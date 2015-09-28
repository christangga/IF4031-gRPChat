package io.grpc.examples.simplechat;

import java.util.ArrayList;

public class Message {

  private String text;
  private ArrayList<String> sendTo;

  public void setMessage(String message, ArrayList<String> receivers) {
    text = message;
    sendTo = new ArrayList<>(receivers);
  }

  public String getText() {
    return text;
  }

  public String sendMessage(String receiver) {
    if (sendTo.contains(receiver)) {
      sendTo.remove(receiver);
      return text;
    } else {
      return null;
    }
  }

  public boolean isSentToAll() {
    return sendTo.isEmpty();
  }
}