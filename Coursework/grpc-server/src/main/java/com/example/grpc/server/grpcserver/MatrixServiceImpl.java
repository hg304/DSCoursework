package com.example.grpc.server.grpcserver;


import java.util.ArrayList;
import java.util.List;

import javax.swing.RepaintManager;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
@GrpcService
public class MatrixServiceImpl extends MatrixServiceGrpc.MatrixServiceImplBase
{
	//method in the servers that will add the blocks received and return the results back
	@Override
	public void addBlock(MatrixRequest request, StreamObserver<MatrixReply> reply)
	{
		System.out.println("Request received from client:\n" + request);
			InnerList A = request.getA();
			InnerList B = request.getB();
			int index1 = request.getIndex1();
			int index2 = request.getIndex2();

			MatrixReply.Builder rep = MatrixReply.newBuilder();
			rep.setC(A.getA(index2) + B.getA(index2));
			rep.setIndex1(index1);
			rep.setIndex2(index2);
			MatrixReply response = rep.build();
			reply.onNext(response);
			reply.onCompleted();
	}

	//method in the servers that will multiply the blocks received and return the results back
	@Override
	public void multiplyBlock(MatrixRequest request, StreamObserver<MatrixReply> reply)
	{
		System.out.println("Request received from client:\n" + request);
		InnerList A = request.getA();
		InnerList B = request.getB();
		int length = request.getLength();
		int answer = 0;
		
		MatrixReply.Builder rep = MatrixReply.newBuilder();
		for (int i = 0; i < length; i++) {
			answer += A.getA(i) * B.getA(i);
		}
		rep.setIndex1(request.getIndex1());
		rep.setIndex2(request.getIndex2());
		rep.setC(answer);
		MatrixReply response = rep.build();
		reply.onNext(response);
		reply.onCompleted();

	}
}
