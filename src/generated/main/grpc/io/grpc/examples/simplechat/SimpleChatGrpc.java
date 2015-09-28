package io.grpc.examples.simplechat;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class SimpleChatGrpc {

  // Static method descriptors that strictly reflect the proto.
  public static final io.grpc.MethodDescriptor<io.grpc.examples.simplechat.UserRequest,
      io.grpc.examples.simplechat.StatusResponse> METHOD_LOGIN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "simplechat.SimpleChat", "Login",
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.UserRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.StatusResponse.parser()));
  public static final io.grpc.MethodDescriptor<io.grpc.examples.simplechat.NickRequest,
      io.grpc.examples.simplechat.StatusResponse> METHOD_SET_NICKNAME =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "simplechat.SimpleChat", "SetNickname",
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.NickRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.StatusResponse.parser()));
  public static final io.grpc.MethodDescriptor<io.grpc.examples.simplechat.ChannelRequest,
      io.grpc.examples.simplechat.StatusResponse> METHOD_JOIN_CHANNEL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "simplechat.SimpleChat", "JoinChannel",
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.ChannelRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.StatusResponse.parser()));
  public static final io.grpc.MethodDescriptor<io.grpc.examples.simplechat.ChannelRequest,
      io.grpc.examples.simplechat.StatusResponse> METHOD_LEAVE_CHANNEL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "simplechat.SimpleChat", "LeaveChannel",
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.ChannelRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.StatusResponse.parser()));
  public static final io.grpc.MethodDescriptor<io.grpc.examples.simplechat.BroadcastRequest,
      io.grpc.examples.simplechat.StatusResponse> METHOD_BROADCAST =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "simplechat.SimpleChat", "Broadcast",
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.BroadcastRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.StatusResponse.parser()));
  public static final io.grpc.MethodDescriptor<io.grpc.examples.simplechat.ChatRequest,
      io.grpc.examples.simplechat.StatusResponse> METHOD_CHAT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "simplechat.SimpleChat", "Chat",
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.ChatRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.StatusResponse.parser()));
  public static final io.grpc.MethodDescriptor<io.grpc.examples.simplechat.UserRequest,
      io.grpc.examples.simplechat.StatusResponse> METHOD_EXIT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "simplechat.SimpleChat", "Exit",
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.UserRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.StatusResponse.parser()));
  public static final io.grpc.MethodDescriptor<io.grpc.examples.simplechat.UserRequest,
      io.grpc.examples.simplechat.MessageResponse> METHOD_REFRESH =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "simplechat.SimpleChat", "Refresh",
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.UserRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.examples.simplechat.MessageResponse.parser()));

  public static SimpleChatStub newStub(io.grpc.Channel channel) {
    return new SimpleChatStub(channel);
  }

  public static SimpleChatBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SimpleChatBlockingStub(channel);
  }

  public static SimpleChatFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SimpleChatFutureStub(channel);
  }

  public static interface SimpleChat {

    public void login(io.grpc.examples.simplechat.UserRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver);

    public void setNickname(io.grpc.examples.simplechat.NickRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver);

    public void joinChannel(io.grpc.examples.simplechat.ChannelRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver);

    public void leaveChannel(io.grpc.examples.simplechat.ChannelRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver);

    public void broadcast(io.grpc.examples.simplechat.BroadcastRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver);

    public void chat(io.grpc.examples.simplechat.ChatRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver);

    public void exit(io.grpc.examples.simplechat.UserRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver);

    public void refresh(io.grpc.examples.simplechat.UserRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.MessageResponse> responseObserver);
  }

  public static interface SimpleChatBlockingClient {

    public io.grpc.examples.simplechat.StatusResponse login(io.grpc.examples.simplechat.UserRequest request);

    public io.grpc.examples.simplechat.StatusResponse setNickname(io.grpc.examples.simplechat.NickRequest request);

    public io.grpc.examples.simplechat.StatusResponse joinChannel(io.grpc.examples.simplechat.ChannelRequest request);

    public io.grpc.examples.simplechat.StatusResponse leaveChannel(io.grpc.examples.simplechat.ChannelRequest request);

    public io.grpc.examples.simplechat.StatusResponse broadcast(io.grpc.examples.simplechat.BroadcastRequest request);

    public io.grpc.examples.simplechat.StatusResponse chat(io.grpc.examples.simplechat.ChatRequest request);

    public io.grpc.examples.simplechat.StatusResponse exit(io.grpc.examples.simplechat.UserRequest request);

    public io.grpc.examples.simplechat.MessageResponse refresh(io.grpc.examples.simplechat.UserRequest request);
  }

  public static interface SimpleChatFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.StatusResponse> login(
        io.grpc.examples.simplechat.UserRequest request);

    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.StatusResponse> setNickname(
        io.grpc.examples.simplechat.NickRequest request);

    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.StatusResponse> joinChannel(
        io.grpc.examples.simplechat.ChannelRequest request);

    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.StatusResponse> leaveChannel(
        io.grpc.examples.simplechat.ChannelRequest request);

    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.StatusResponse> broadcast(
        io.grpc.examples.simplechat.BroadcastRequest request);

    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.StatusResponse> chat(
        io.grpc.examples.simplechat.ChatRequest request);

    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.StatusResponse> exit(
        io.grpc.examples.simplechat.UserRequest request);

    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.MessageResponse> refresh(
        io.grpc.examples.simplechat.UserRequest request);
  }

  public static class SimpleChatStub extends io.grpc.stub.AbstractStub<SimpleChatStub>
      implements SimpleChat {
    private SimpleChatStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SimpleChatStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimpleChatStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SimpleChatStub(channel, callOptions);
    }

    @java.lang.Override
    public void login(io.grpc.examples.simplechat.UserRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_LOGIN, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void setNickname(io.grpc.examples.simplechat.NickRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_SET_NICKNAME, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void joinChannel(io.grpc.examples.simplechat.ChannelRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_JOIN_CHANNEL, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void leaveChannel(io.grpc.examples.simplechat.ChannelRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_LEAVE_CHANNEL, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void broadcast(io.grpc.examples.simplechat.BroadcastRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_BROADCAST, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void chat(io.grpc.examples.simplechat.ChatRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_CHAT, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void exit(io.grpc.examples.simplechat.UserRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_EXIT, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void refresh(io.grpc.examples.simplechat.UserRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.MessageResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_REFRESH, callOptions), request, responseObserver);
    }
  }

  public static class SimpleChatBlockingStub extends io.grpc.stub.AbstractStub<SimpleChatBlockingStub>
      implements SimpleChatBlockingClient {
    private SimpleChatBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SimpleChatBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimpleChatBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SimpleChatBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public io.grpc.examples.simplechat.StatusResponse login(io.grpc.examples.simplechat.UserRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_LOGIN, callOptions), request);
    }

    @java.lang.Override
    public io.grpc.examples.simplechat.StatusResponse setNickname(io.grpc.examples.simplechat.NickRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_SET_NICKNAME, callOptions), request);
    }

    @java.lang.Override
    public io.grpc.examples.simplechat.StatusResponse joinChannel(io.grpc.examples.simplechat.ChannelRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_JOIN_CHANNEL, callOptions), request);
    }

    @java.lang.Override
    public io.grpc.examples.simplechat.StatusResponse leaveChannel(io.grpc.examples.simplechat.ChannelRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_LEAVE_CHANNEL, callOptions), request);
    }

    @java.lang.Override
    public io.grpc.examples.simplechat.StatusResponse broadcast(io.grpc.examples.simplechat.BroadcastRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_BROADCAST, callOptions), request);
    }

    @java.lang.Override
    public io.grpc.examples.simplechat.StatusResponse chat(io.grpc.examples.simplechat.ChatRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_CHAT, callOptions), request);
    }

    @java.lang.Override
    public io.grpc.examples.simplechat.StatusResponse exit(io.grpc.examples.simplechat.UserRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_EXIT, callOptions), request);
    }

    @java.lang.Override
    public io.grpc.examples.simplechat.MessageResponse refresh(io.grpc.examples.simplechat.UserRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_REFRESH, callOptions), request);
    }
  }

  public static class SimpleChatFutureStub extends io.grpc.stub.AbstractStub<SimpleChatFutureStub>
      implements SimpleChatFutureClient {
    private SimpleChatFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SimpleChatFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimpleChatFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SimpleChatFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.StatusResponse> login(
        io.grpc.examples.simplechat.UserRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_LOGIN, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.StatusResponse> setNickname(
        io.grpc.examples.simplechat.NickRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_SET_NICKNAME, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.StatusResponse> joinChannel(
        io.grpc.examples.simplechat.ChannelRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_JOIN_CHANNEL, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.StatusResponse> leaveChannel(
        io.grpc.examples.simplechat.ChannelRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_LEAVE_CHANNEL, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.StatusResponse> broadcast(
        io.grpc.examples.simplechat.BroadcastRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_BROADCAST, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.StatusResponse> chat(
        io.grpc.examples.simplechat.ChatRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_CHAT, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.StatusResponse> exit(
        io.grpc.examples.simplechat.UserRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_EXIT, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.simplechat.MessageResponse> refresh(
        io.grpc.examples.simplechat.UserRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_REFRESH, callOptions), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final SimpleChat serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder("simplechat.SimpleChat")
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_LOGIN,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                io.grpc.examples.simplechat.UserRequest,
                io.grpc.examples.simplechat.StatusResponse>() {
              @java.lang.Override
              public void invoke(
                  io.grpc.examples.simplechat.UserRequest request,
                  io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver) {
                serviceImpl.login(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_SET_NICKNAME,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                io.grpc.examples.simplechat.NickRequest,
                io.grpc.examples.simplechat.StatusResponse>() {
              @java.lang.Override
              public void invoke(
                  io.grpc.examples.simplechat.NickRequest request,
                  io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver) {
                serviceImpl.setNickname(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_JOIN_CHANNEL,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                io.grpc.examples.simplechat.ChannelRequest,
                io.grpc.examples.simplechat.StatusResponse>() {
              @java.lang.Override
              public void invoke(
                  io.grpc.examples.simplechat.ChannelRequest request,
                  io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver) {
                serviceImpl.joinChannel(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_LEAVE_CHANNEL,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                io.grpc.examples.simplechat.ChannelRequest,
                io.grpc.examples.simplechat.StatusResponse>() {
              @java.lang.Override
              public void invoke(
                  io.grpc.examples.simplechat.ChannelRequest request,
                  io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver) {
                serviceImpl.leaveChannel(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_BROADCAST,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                io.grpc.examples.simplechat.BroadcastRequest,
                io.grpc.examples.simplechat.StatusResponse>() {
              @java.lang.Override
              public void invoke(
                  io.grpc.examples.simplechat.BroadcastRequest request,
                  io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver) {
                serviceImpl.broadcast(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_CHAT,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                io.grpc.examples.simplechat.ChatRequest,
                io.grpc.examples.simplechat.StatusResponse>() {
              @java.lang.Override
              public void invoke(
                  io.grpc.examples.simplechat.ChatRequest request,
                  io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver) {
                serviceImpl.chat(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_EXIT,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                io.grpc.examples.simplechat.UserRequest,
                io.grpc.examples.simplechat.StatusResponse>() {
              @java.lang.Override
              public void invoke(
                  io.grpc.examples.simplechat.UserRequest request,
                  io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.StatusResponse> responseObserver) {
                serviceImpl.exit(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_REFRESH,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                io.grpc.examples.simplechat.UserRequest,
                io.grpc.examples.simplechat.MessageResponse>() {
              @java.lang.Override
              public void invoke(
                  io.grpc.examples.simplechat.UserRequest request,
                  io.grpc.stub.StreamObserver<io.grpc.examples.simplechat.MessageResponse> responseObserver) {
                serviceImpl.refresh(request, responseObserver);
              }
            }))).build();
  }
}
