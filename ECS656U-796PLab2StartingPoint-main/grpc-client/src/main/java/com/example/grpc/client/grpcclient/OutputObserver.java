package com.example.grpc.client.grpcclient;

import io.grpc.stub.StreamObserver;
import com.example.grpc.server.grpcserver.MatrixReply;

public class OutputObserver implements StreamObserver<MatrixReply> {
    
    @Override
    public void onNext(MatrixReply rep) {
        System.out.println("Received: " + rep.getResult());
    }

    @Override
    public void onError(Throwable throwable) {

    }
    
    @Override
    public void onCompleted() {
        System.out.println("Block multiplied");
    }
}
