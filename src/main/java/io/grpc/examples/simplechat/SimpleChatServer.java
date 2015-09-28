package io.grpc.examples.simplechat;

import io.grpc.ServerImpl;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.logging.Logger;

public class SimpleChatServer {

  private static final Logger logger = Logger.getLogger(SimpleChatServer.class.getName());

  /* The port on which the server should run */
  private int port = 50051;
  private ServerImpl server;

  private void start() throws Exception {
    server = NettyServerBuilder.forPort(port)
        .addService(SimpleChatGrpc.bindService(new SimpleChatImpl()))
        .build().start();
    logger.info("Server started, listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        SimpleChatServer.this.stop();
        System.err.println("*** server shut down");
      }
    });
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  /**
   * Main launches the server from the command line.
   */
  public static void main(String[] args) throws Exception {
    final SimpleChatServer server = new SimpleChatServer();
    server.start();
  }

  private class SimpleChatImpl implements SimpleChatGrpc.SimpleChat {

    private ArrayList<String> users = new ArrayList<String>();
    private ArrayList<Channel> channels = new ArrayList<Channel>();

    @Override
    public void login(UserRequest req, StreamObserver<StatusResponse> responseObserver) {
      String username = req.getUsername();

      users.add(username);
      System.out.println("User " + username + " logged in");

      StatusResponse reply = StatusResponse.newBuilder().setStatus(0).build();
      responseObserver.onValue(reply);
      responseObserver.onCompleted();
    }

    @Override
    public void setNickname(NickRequest req, StreamObserver<StatusResponse> responseObserver) {
      String currentName = req.getCurrentName();
      String newName = req.getNewName();
      StatusResponse reply;

      if (users.contains(newName)) {
        System.out.println("User " + newName + " already exists");

        reply = StatusResponse.newBuilder().setStatus(1).build();
      } else {
        users.remove(currentName);
        users.add(newName);

        for (Channel current : channels) {
          System.out.println("Checking channel " + current.getChannelName());
          if (current.isMember(currentName)) {
            current.removeMember(currentName);
            current.addMember(newName);
          }
        }
        System.out.println("User " + currentName + " changed his/her name to " + newName);

        reply = StatusResponse.newBuilder().setStatus(0).build();
      }

      responseObserver.onValue(reply);
      responseObserver.onCompleted();
    }

    @Override
    public void joinChannel(ChannelRequest req, StreamObserver<StatusResponse> responseObserver) {
      String username = req.getUsername();
      String channelName = req.getChannelName();
      StatusResponse reply;

      Channel theChannel = null;
      for (Channel current : channels) {
        System.out.println("Checking channel " + current.getChannelName());
        if (current.getChannelName().equals(channelName)) {
          theChannel = current;
        }
      }

      if (theChannel == null) {
        System.out.println("Channel " + channelName + " not found, creating a new one");
        theChannel = new Channel();
        theChannel.setChannelName(channelName);
        channels.add(theChannel);
        System.out.println("Channel " + channelName + " has been created");
      }

      if (theChannel.isMember(username)) {
        System.out.println("User " + username + " already a member of channel " + channelName);

        reply = StatusResponse.newBuilder().setStatus(1).build();
      } else {
        System.out.println("Adding user " + username + " to channel " + channelName);
        theChannel.addMember(username);
        System.out.println("User " + username + " joined channel " + channelName);

        reply = StatusResponse.newBuilder().setStatus(0).build();
      }

      responseObserver.onValue(reply);
      responseObserver.onCompleted();
    }

    @Override
    public void leaveChannel(ChannelRequest req, StreamObserver<StatusResponse> responseObserver) {
      String username = req.getUsername();
      String channelName = req.getChannelName();
      StatusResponse reply;

      Channel theChannel = null;
      for (Channel current : channels) {
        System.out.println("Checking channel " + current.getChannelName());
        if (current.getChannelName().equals(channelName)) {
          theChannel = current;
        }
      }

      if (theChannel == null) {
        System.out.println("Channel " + channelName + " not found");

        reply = StatusResponse.newBuilder().setStatus(2).build();
      } else if (theChannel.isMember(username)) {
        theChannel.removeMember(username);
        System.out.println("User " + username + " left channel " + channelName);

        reply = StatusResponse.newBuilder().setStatus(0).build();
      } else {
        System.out.println("User " + username + " is not a member of channel " + channelName);

        reply = StatusResponse.newBuilder().setStatus(1).build();
      }

      responseObserver.onValue(reply);
      responseObserver.onCompleted();
    }

    @Override
    public void broadcast(BroadcastRequest req, StreamObserver<StatusResponse> responseObserver) {
      String username = req.getUsername();
      String message = req.getMessage();

      for (Channel current : channels) {
        if (current.isMember(username)) {
          System.out.println("User " + username + " broadcasted '" + message + "' to channel " + current.getChannelName());
          current.addMessage("(" + username + ") " + message);
        }
      }

      StatusResponse reply = StatusResponse.newBuilder().setStatus(0).build();
      responseObserver.onValue(reply);
      responseObserver.onCompleted();
    }

    @Override
    public void chat(ChatRequest req, StreamObserver<StatusResponse> responseObserver) {
      String username = req.getUsername();
      String channelName = req.getChannelName();
      String message = req.getMessage();
      StatusResponse reply = StatusResponse.newBuilder().setStatus(2).build();

      for (Channel current : channels) {
        if (current.getChannelName().equals(channelName) && current.isMember(username)) {
          System.out.println("User " + username + " sent '" + message + "' to channel " + channelName);
          current.addMessage("(" + username + ") " + message);

          reply = StatusResponse.newBuilder().setStatus(0).build();
          break;
        } else if (current.getChannelName().equals(channelName)) {
          reply = StatusResponse.newBuilder().setStatus(1).build();
          break;
        }
      }

      responseObserver.onValue(reply);
      responseObserver.onCompleted();
    }

    @Override
    public void exit(UserRequest req, StreamObserver<StatusResponse> responseObserver) {
      String username = req.getUsername();

      users.remove(username);
      for (Channel current : channels) {
        System.out.println("Checking channel " + current.getChannelName());
        if (current.isMember(username)) {
          current.removeMember(username);
        }
      }
      System.out.println("User " + username + " exited chat system");

      StatusResponse reply = StatusResponse.newBuilder().setStatus(0).build();
      responseObserver.onValue(reply);
      responseObserver.onCompleted();
    }

    @Override
    public void refresh(UserRequest req, StreamObserver<MessageResponse> responseObserver) {
      String username = req.getUsername();

      String retval = "";
      for (Channel current : channels) {
        if (current.isMember(username)) {
          retval += current.sendMessagesTo(username);
        }
      }

      MessageResponse reply = MessageResponse.newBuilder().setMessage(retval).build();
      responseObserver.onValue(reply);
      responseObserver.onCompleted();
    }
  }
}