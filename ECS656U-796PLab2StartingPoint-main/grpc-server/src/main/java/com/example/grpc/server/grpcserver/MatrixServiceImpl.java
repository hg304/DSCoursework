package com.example.grpc.server.grpcserver;


import java.util.ArrayList;
import java.util.List;

import javax.swing.RepaintManager;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
@GrpcService
public class MatrixServiceImpl extends MatrixServiceGrpc.MatrixServiceImplBase
{
	@Override
	public void addBlock(MatrixRequest request, StreamObserver<MatrixReply> reply)
	{
		System.out.println("Request received from client:\n" + request);
			List<InnerList> a = request.getA();
			List<InnerList> b = request.getB();
			int index = request.getN();
			int answer = 0;

			MatrixReply.Builder rep = MatrixReply.newBuilder();
			rep.setC(a.getA(index) + b.getA(index));
			MatrixReply response = rep.build();
			reply.onNext(response);
			reply.onCompleted();
	}
	@Override
	public void multiplyBlock(MatrixRequest request, StreamObserver<MatrixReply> reply)
	{
		System.out.println("Request received from client:\n" + request);
		InnerList A = request.getA();
		InnerList B = request.getB();
		int length = request.getN();
		int answer = 0;
		
		MatrixReply.Builder rep = MatrixReply.newBuilder();
		for (int i = 0; i < length; i++) {
			answer += A.getA(i) * B.getA(i);
		}
		rep.setC(answer);
		MatrixReply response = rep.build();
		reply.onNext(response);
		reply.onCompleted();
	}
}
