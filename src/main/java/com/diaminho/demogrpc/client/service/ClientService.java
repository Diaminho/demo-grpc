package com.diaminho.demogrpc.client.service;

import com.diaminho.demogrpc.DemoServiceGrpc;
import com.diaminho.demogrpc.Request;
import com.diaminho.demogrpc.Response;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ClientService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ClientService.class);

    private DemoServiceGrpc.DemoServiceStub demoServiceStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 6565).usePlaintext().build();

        demoServiceStub =
                DemoServiceGrpc.newStub(managedChannel);
    }

    public String processPayload(String payload) {
       /* Request request = Request
                .newBuilder()
                .setPayload(payload)
                .build();
        LOGGER.info("client sending {}", request);

        Response response =
                demoServiceStub.process(request, StreamObserver<Response> responseObserver);
        LOGGER.info("client received {}", response);*/

        return" response.getMessage()";
    }
}
