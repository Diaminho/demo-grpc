package com.diaminho.demogrpc.controller;

import com.diaminho.demogrpc.DemoServiceGrpc;
import com.diaminho.demogrpc.Request;
import com.diaminho.demogrpc.Response;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

@Slf4j
@GRpcService
public class ServerController extends DemoServiceGrpc.DemoServiceImplBase {

    @Override
    public void process(Request request, StreamObserver<Response> responseObserver) {
        log.info("Payload Received : " + request.getPayload());
        Response response = Response
                .newBuilder()
                .setMessage(request.getPayload())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
