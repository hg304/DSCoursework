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
		List<InnerList> a = request.getAList();
		List<InnerList> b = request.getBList();
		MatrixReply.Builder rep = MatrixReply.newBuilder();
		for (int i = 0; i < a.size(); i++) {
			InnerList.Builder temp = InnerList.newBuilder();
			for (int j = 0; j < a.get(i).getAList().size(); j++) {
				temp.addA(a.get(i).getA(j) + b.get(i).getA(j));
			}
			rep.addC(temp);
		}
		MatrixReply response = rep.build();
		reply.onNext(response);
		reply.onCompleted();
	}
	@Override
	public void multiplyBlock(MatrixRequest request, StreamObserver<MatrixReply> reply)
	{
		System.out.println("Request received from client:\n" + request);
		List<InnerList> a = request.getAList();
		List<InnerList> b = request.getBList();
		MatrixReply.Builder rep = MatrixReply.newBuilder();
		for (int i = 0; i < a.size(); i++) {
			InnerList.Builder temp = InnerList.newBuilder();
			int sum = 0;
			for (int j = 0; j< a.get(i).getAList().size(); j++) {
				for (int k = 0; k < a.get(i).getAList().size(); k++) {
					sum += (a.get(i).getA(k) * b.get(k).getA(j));
				}
				temp.addA(sum);
				sum = 0;
			}
			rep.addC(temp);
    	}
		MatrixReply response = rep.build();
		reply.onNext(response);
		reply.onCompleted();
	}
}
