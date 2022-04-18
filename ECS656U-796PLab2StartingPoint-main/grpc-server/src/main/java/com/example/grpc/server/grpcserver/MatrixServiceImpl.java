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
			InnerList A = request.getA();
			InnerList B = request.getB();
			int index = request.getLength();
			int answer = 0;

			MatrixReply.Builder rep = MatrixReply.newBuilder();
			rep.setC(A.getA(index) + B.getA(index));
			rep.setIndex1(0);
			rep.setIndex2(0);
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

		return response;
	}
}
