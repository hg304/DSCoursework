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
		/*System.out.println("Request received from client:\n" + request);
			List<InnerList> a = request.getA();
			List<InnerList> b = request.getB();
			MatrixReply.Builder rep = MatrixReply.newBuilder();
			for (int i = 0; i < a.size(); i++) {
					InnerList.Builder temp = InnerList.newBuilder();
						temp.addA(a.getA(j) + b.getA(j));
					}
					rep.addC(temp);
			}
			MatrixReply response = rep.build();
			reply.onNext(response);
			reply.onCompleted();*/
	}
	@Override
	public void multiplyBlock(MatrixRequest request, StreamObserver<MatrixReply> reply)
	{
		System.out.println("Request received from client:\n" + request);
		InnerList A = request.getA();
		InnerList B = request.getB();
		int answer = 0;
		MatrixReply.Builder rep = MatrixReply.newBuilder();
		for (int i = 0; i < A.length; i++) {
			answer += A.getA(i) * B.getA(i);
		}
		rep.setC(answer);
		MatrixReply response = rep.build();
		reply.onNext(response);
		reply.onCompleted();
	}
}
