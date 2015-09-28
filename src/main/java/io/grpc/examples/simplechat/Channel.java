package io.grpc.examples.simplechat;

import java.util.ArrayList;
import java.util.Iterator;

public class Channel {

  private String channelName;
  private final ArrayList<String> members = new ArrayList<>();
  private final ArrayList<Message> messages = new ArrayList<>();

  public void setChannelName(String name) {
    channelName = name;
  }

  public String getChannelName() {
    return channelName;
  }

  public ArrayList<String> getAllMembers() {
    return members;
  }

  public void addMember(String member) {
    members.add(member);
  }

  public boolean isMember(String member) {
    return members.contains(member);
  }

  public boolean removeMember(String member) {
    if (!isMember(member)) {
      return false;
    }
    members.remove(member);
    return true;
  }

  public String sendMessagesTo(String member) {
    String retval = "";
    Iterator<Message> i = messages.iterator();
    while (i.hasNext()) {
      Message msg = i.next();
      String message = msg.sendMessage(member);
      if (message != null) {
        retval += "[" + channelName + "] " + message + "\n";
        System.out.println("Sent " + message + " to user " + member);
      }
      if (msg.isSentToAll()) {
        System.out.println("Message " + msg.getText() + " destroyed");
        i.remove();
      }
    }
    return retval;
  }

  public void addMessage(String message) {
    Message current = new Message();
    current.setMessage(message, members);
    messages.add(current);
  }
}