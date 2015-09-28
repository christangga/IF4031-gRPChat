package io.grpc.examples.simplechat;

import io.grpc.ChannelImpl;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleChatClient {

  private static final Logger logger = Logger.getLogger(SimpleChatClient.class.getName());
  private static String username = "guest" + String.valueOf(System.currentTimeMillis() / 1000L);

  private final ChannelImpl channel;
  private final SimpleChatGrpc.SimpleChatBlockingStub blockingStub;

  /**
   * Construct client connecting to SimpleChat server at {@code host:port}.
   */
  public SimpleChatClient(String host, int port) {
    channel =
        NettyChannelBuilder.forAddress(host, port).negotiationType(NegotiationType.PLAINTEXT)
            .build();
    blockingStub = SimpleChatGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  public void login(String username) {
    try {
      UserRequest request = UserRequest.newBuilder().setUsername(username).build();
      StatusResponse response = blockingStub.login(request);
    } catch (RuntimeException e) {
      logger.log(Level.WARNING, "RPC failed", e);
      return;
    }
  }

  public int setNickname(String currentName, String newName) {
    try {
      NickRequest request = NickRequest.newBuilder().setCurrentName(currentName).setNewName(newName).build();
      StatusResponse response = blockingStub.setNickname(request);

      return response.getStatus();
    } catch (RuntimeException e) {
      logger.log(Level.WARNING, "RPC failed", e);
      return -1;
    }
  }

  public int joinChannel(String username, String channelName) {
    try {
      ChannelRequest request = ChannelRequest.newBuilder().setUsername(username).setChannelName(channelName).build();
      StatusResponse response = blockingStub.joinChannel(request);

      return response.getStatus();
    } catch (RuntimeException e) {
      logger.log(Level.WARNING, "RPC failed", e);
      return -1;
    }
  }

  public int leaveChannel(String username, String channelName) {
    try {
      ChannelRequest request = ChannelRequest.newBuilder().setUsername(username).setChannelName(channelName).build();
      StatusResponse response = blockingStub.leaveChannel(request);

      return response.getStatus();
    } catch (RuntimeException e) {
      logger.log(Level.WARNING, "RPC failed", e);
      return -1;
    }
  }

  public void broadcast(String username, String message) {
    try {
      BroadcastRequest request = BroadcastRequest.newBuilder().setUsername(username).setMessage(message).build();
      StatusResponse response = blockingStub.broadcast(request);
    } catch (RuntimeException e) {
      logger.log(Level.WARNING, "RPC failed", e);
      return;
    }
  }

  public int chat(String username, String channelName, String message) {
    try {
      ChatRequest request = ChatRequest.newBuilder().setUsername(username).setChannelName(channelName).setMessage(message).build();
      StatusResponse response = blockingStub.chat(request);

      return response.getStatus();
    } catch (RuntimeException e) {
      logger.log(Level.WARNING, "RPC failed", e);
      return -1;
    }
  }

  public void exit(String username) {
    try {
      UserRequest request = UserRequest.newBuilder().setUsername(username).build();
      StatusResponse response = blockingStub.exit(request);
    } catch (RuntimeException e) {
      logger.log(Level.WARNING, "RPC failed", e);
      return;
    }
  }

  public String refresh(String username) {
    try {
      UserRequest request = UserRequest.newBuilder().setUsername(username).build();
      MessageResponse response = blockingStub.refresh(request);

      return response.getMessage();
    } catch (RuntimeException e) {
      logger.log(Level.WARNING, "RPC failed", e);
      return "";
    }
  }

  public static void main(String[] args) throws Exception {
    final SimpleChatClient client = new SimpleChatClient("localhost", 50051);
    try {
      client.login(username);
      System.out.println("Welcome, " + username + "!");

      Timer timer = new Timer();
      timer.schedule(new TimerTask() {
        @Override
        public void run() {
          System.out.print(client.refresh(username));
        }
      }, 1000, 1000);

      Scanner scn = new Scanner(System.in);
      String s = "";
      while (!s.toLowerCase().startsWith("/exit")) {
        s = scn.nextLine();
        /* Command */
        if (s.startsWith("/")) {
          String[] command = s.split(" ");
          if (command[0].toLowerCase().equals("/nick")) {
            if (command.length < 2) {
              System.out.println("Invalid command!");
              System.out.println("/nick <username>");
              continue;
            }

            if (client.setNickname(username, command[1]) == 0) {
              username = command[1];
              System.out.println("Successfully changed name to " + username);
            } else {
              System.out.println("User " + command[1] + " already exists");
            }
          } else if (command[0].toLowerCase().equals("/join")) {
            if (command.length < 2) {
              System.out.println("Invalid command!");
              System.out.println("/join <channelname>");
              continue;
            }

            if (client.joinChannel(username, command[1]) == 0) {
              System.out.println("Successfully joined channel " + command[1]);
            } else {
              System.out.println("Already a member of channel " + command[1]);
            }
          } else if (command[0].toLowerCase().equals("/leave")) {
            if (command.length < 2) {
              System.out.println("Invalid command!");
              System.out.println("/leave <channel>");
              continue;
            }

            int isLeft = client.leaveChannel(username, command[1]);
            if (isLeft == 0) {
              System.out.println("Successfully left channel " + command[1]);
            } else if (isLeft == 1) {
              System.out.println("Not a member of channel " + command[1]);
            } else {
              System.out.println("Channel " + command[1] + " not found");
            }
          } else if (command[0].toLowerCase().equals("/exit")) {
            timer.cancel();  // Terminates this timer, discarding any currently scheduled tasks.
            timer.purge();   // Removes all cancelled tasks from this timer's task queue.

            client.exit(username);
            System.out.println("Goodbye, " + username + "!");
          } else {
            System.out.println("Invalid command!");
            System.out.println("/nick <username>");
            System.out.println("/join <channelname>");
            System.out.println("/leave <channel>");
            System.out.println("/exit");
            System.out.println("<text>");
            System.out.println("@<channelname> <text>");
          }
        } else if (s.startsWith("@")) {
          String[] command = s.split(" ", 2);

          if (command.length < 2) {
            System.out.println("Invalid command!");
            System.out.println("@<channelname> <text>");
            continue;
          } else {
            int isSent = client.chat(username, command[0].substring(1), command[1]);
            if (isSent == 0) {
              System.out.println("Message to channel " + command[0].substring(1) + " sent!");
            } else if (isSent == 1) {
              System.out.println("Not a member of channel " + command[0].substring(1));
            } else {
              System.out.println("Channel " + command[0].substring(1) + " not found");
            }
          }
        } else {
          client.broadcast(username, s);
          System.out.println("Message sent!");
        }
      }
    } finally {
      client.shutdown();
    }
  }
}