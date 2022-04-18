package com.example.grpc.client.grpcclient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import io.grpc.stub.StreamObserver;
import com.example.grpc.server.grpcserver.PingRequest;
import com.example.grpc.server.grpcserver.PongResponse;
import com.example.grpc.server.grpcserver.InnerList.Builder;
import com.example.grpc.server.grpcserver.PingPongServiceGrpc;
import com.example.grpc.server.grpcserver.MatrixRequest;
import com.example.grpc.server.grpcserver.MatrixReply;
import com.example.grpc.server.grpcserver.InnerList;
import com.example.grpc.server.grpcserver.MatrixServiceGrpc;
import org.springframework.web.bind.annotation.RequestMapping;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
@Service
public class GRPCClientService {
    public String ping() {
        	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();        
		PingPongServiceGrpc.PingPongServiceBlockingStub stub
                = PingPongServiceGrpc.newBlockingStub(channel);        
		PongResponse helloResponse = stub.ping(PingRequest.newBuilder()
                .setPing("")
                .build());        
		channel.shutdown();        
		return helloResponse.getPong();
    }

    public int[][][] GrpcService(Model model, String f) {
        try {
                File file = new File(f);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                String matrixLine1 = new String();
                String matrixLine2 = new String();
                int row = 0;
                int col = 0;
                int maxRowA = 0;
                int maxRowB = 0;
                int maxColA = 0;
                int maxColB = 0;
                String temp = new String();
                while (!line.isEmpty()) {
                row += 1;
                for (int i = 0; i < line.length(); i++) {
                        char c = line.charAt(i);
                        if (c == ' ') {
                        col += 1;
                        matrixLine1 = matrixLine1 + temp + " ";
                        temp = "";
                        
                        } else {
                        temp += c;
                        }
                        
                        if (i == line.length() - 1) {
                        col += 1;
                        maxColA = col;
                        col = 0;
                        matrixLine1 += temp + " ";
                        temp = "";
                        }

                }
                line = br.readLine();
                }
                maxRowA = row;
                row = 0;
                line = br.readLine();
                while (!line.isEmpty()) {
                row += 1;
                for (int i = 0; i < line.length(); i++) {
                        char c = line.charAt(i);
                        if (c == ' ') {
                        col += 1;
                        matrixLine2 = matrixLine2 + temp + " ";
                        temp = "";
                        
                        } else {
                        temp += c;
                        }
                        
                        if (i == line.length() - 1) {
                        col += 1;
                        maxColB = col;
                        col = 0;
                        matrixLine2 += temp + " ";
                        temp = "";
                        }

                }
                line = br.readLine();
                }
                maxRowB = row;
                br.close();

                if (maxColA != maxRowB) {
                        String message = "The matrices cannot be used to perform operations";
                        printError(model, message);
                } else {
                        int[][] matrixA = stringToMatrix(matrixLine1, maxColA, maxRowA);
                        int[][] matrixB = stringToMatrix(matrixLine2, maxColB, maxRowB);
                        int[][][] matrices = new int[2][][];
                        matrices[0] = matrixA;
                        matrices[1] = matrixB;
                        return matrices;
                }
        } catch (Exception e) {
                String message = e.getMessage();
                printError(model, message);
        }
        return null;

      }
      @RequestMapping("/error")
      public String printError(Model model, String message) {
              model.addAttribute("msg", message);
              return "errorform";

      }

      public int[][] addMatrices(int[][] matrixA, int[][] matrixB, long deadline) throws InterruptedException, ExecutionException{
        ManagedChannel channel1 = ManagedChannelBuilder.forAddress("10.128.0.2",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub1 = MatrixServiceGrpc.newStub(channel1);
        ManagedChannel channel2 = ManagedChannelBuilder.forAddress("10.128.0.3",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub2 = MatrixServiceGrpc.newStub(channel2);
        ManagedChannel channel3 = ManagedChannelBuilder.forAddress("10.128.0.4",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub3 = MatrixServiceGrpc.newStub(channel3);
        ManagedChannel channel4 = ManagedChannelBuilder.forAddress("10.128.0.5",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub4 = MatrixServiceGrpc.newStub(channel4);
        ManagedChannel channel5 = ManagedChannelBuilder.forAddress("10.128.0.6",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub5 = MatrixServiceGrpc.newStub(channel5);
        ManagedChannel channel6 = ManagedChannelBuilder.forAddress("10.128.0.7",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub6 = MatrixServiceGrpc.newStub(channel6);
        ManagedChannel channel7 = ManagedChannelBuilder.forAddress("10.128.0.8",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub7 = MatrixServiceGrpc.newStub(channel7);
        ManagedChannel channel8 = ManagedChannelBuilder.forAddress("10.128.0.9",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub8 = MatrixServiceGrpc.newStub(channel8);

        MatrixServiceGrpc.MatrixServiceStub[] stubs = {stub1, stub2, stub3, stub4, stub5, stub6, stub7, stub8};
        List<MatrixServiceGrpc.MatrixServiceStub> selectedstubs = new ArrayList<MatrixServiceGrpc.MatrixServiceStub>();



        List<InnerList.Builder> A = new ArrayList<InnerList.Builder>();
        List<InnerList.Builder> B = new ArrayList<InnerList.Builder>();

        for (int i = 0; i < matrixA.length; i++) {
                InnerList.Builder temp = InnerList.newBuilder();
                for (int j = 0; j < matrixA.length; j++) {
                        temp.addA(matrixA[i][j]);
                }
                A.add(temp);
        }

        for (int i = 0; i < matrixB.length; i++) {
                InnerList.Builder temp = InnerList.newBuilder();
                for (int j = 0; j < matrixB.length; j++) {
                        temp.addA(matrixB[i][j]);
                }
                B.add(temp);
        }

        int numberServers = getNumberServers("add", A.get(0), B.get(0), 0, channel1, (matrixA.length*matrixA.length), deadline);

        System.out.println("Number of servers to be used for operation: " + numberServers + "/8 servers");

        for (int i = 0; i < numberServers; i++) {
                selectedstubs.add(stubs[i]);
        }

        int[][] finalm = new int[matrixA.length][matrixA.length];
        int stubcounter = 0;
        StreamObserver<MatrixReply> responseObserver = new StreamObserver<MatrixReply>() {
                @Override
                public void onNext(MatrixReply rep) {
                        System.out.println("Result obtained for Matrix Position " + rep.getIndex1() + ", " + rep.getIndex2() + ": " + rep.getC());
                        finalm[rep.getIndex1()][rep.getIndex2()] = rep.getC();
                }
                @Override
                public void onError(Throwable t) {
                }
                @Override
                public void onCompleted() {
                        System.out.println("Server finished processing addition");
                }

        };

        for (int i = 0; i < matrixA.length; i++) {
                MatrixRequest.Builder temp = MatrixRequest.newBuilder();
                temp.setA(A.get(i));
                temp.setB(B.get(i));
                temp.setLength(matrixA.length);
                temp.setIndex1(i);
                temp.setIndex2(i);
                for (int j = 0; j < matrixA.length; j++) {
                        selectedstubs.get(stubcounter).addBlock(temp.build(), responseObserver;
                        if (stubcounter == selectedstubs.size() - 1) {
                                stubcounter = 0;
                        } else {
                                stubcounter += 1;
                        }
                        Thread.sleep(250);
                }
               
        }

        return finalm;

      }

     public int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB, long deadline) throws InterruptedException, ExecutionException {
        ManagedChannel channel1 = ManagedChannelBuilder.forAddress("10.128.0.2",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub1 = MatrixServiceGrpc.newStub(channel1);
        ManagedChannel channel2 = ManagedChannelBuilder.forAddress("10.128.0.3",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub2 = MatrixServiceGrpc.newStub(channel2);
        ManagedChannel channel3 = ManagedChannelBuilder.forAddress("10.128.0.4",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub3 = MatrixServiceGrpc.newStub(channel3);
        ManagedChannel channel4 = ManagedChannelBuilder.forAddress("10.128.0.5",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub4 = MatrixServiceGrpc.newStub(channel4);
        ManagedChannel channel5 = ManagedChannelBuilder.forAddress("10.128.0.6",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub5 = MatrixServiceGrpc.newStub(channel5);
        ManagedChannel channel6 = ManagedChannelBuilder.forAddress("10.128.0.7",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub6 = MatrixServiceGrpc.newStub(channel6);
        ManagedChannel channel7 = ManagedChannelBuilder.forAddress("10.128.0.8",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub7 = MatrixServiceGrpc.newStub(channel7);
        ManagedChannel channel8 = ManagedChannelBuilder.forAddress("10.128.0.9",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceStub stub8 = MatrixServiceGrpc.newStub(channel8);

        MatrixServiceGrpc.MatrixServiceStub[] stubs = {stub1, stub2, stub3, stub4, stub5, stub6, stub7, stub8};
        List<MatrixServiceGrpc.MatrixServiceStub> selectedstubs = new ArrayList<MatrixServiceGrpc.MatrixServiceStub>();

        List<InnerList.Builder> A = new ArrayList<InnerList.Builder>();
        List<InnerList.Builder> B = new ArrayList<InnerList.Builder>();

        for (int i = 0; i < matrixA.length; i++) {
                InnerList.Builder temp = InnerList.newBuilder();
                for (int j = 0; j < matrixA.length; j++) {
                        temp.addA(matrixA[i][j]);
                }
                A.add(temp);
        }

        for (int i = 0; i < matrixB.length; i++) {
                InnerList.Builder temp = InnerList.newBuilder();
                for (int j = 0; j < matrixB.length; j++) {
                        temp.addA(matrixB[j][i]);
                }
                B.add(temp);
        }

        int numberServers = getNumberServers("multiply", A.get(0), B.get(0), matrixA.length, channel1, (matrixA.length*matrixA.length), deadline);

        System.out.println("Number of servers to be used for operation: " + numberServers + "/8 servers");

        for (int i = 0; i < numberServers; i++) {
                selectedstubs.add(stubs[i]);
        }

        int[][] finalm = new int[matrixA.length][matrixA.length];
        int stubcounter = 0;
        StreamObserver<MatrixReply> responseObserver = new StreamObserver<MatrixReply>() {
                @Override
                public void onNext(MatrixReply rep) {
                        System.out.println("Result obtained for Matrix Position " + rep.getIndex1() + ", " + rep.getIndex2() + ": " + rep.getC());
                        finalm[rep.getIndex1()][rep.getIndex2()] = rep.getC();
                }
                @Override
                public void onError(Throwable t) {
                }
                @Override
                public void onCompleted() {
                        System.out.println("Server finished processing multiplication");
                }

        };

        for (int i = 0; i < matrixA.length; i++) {
                MatrixRequest.Builder temp = MatrixRequest.newBuilder();
                temp.setA(A.get(i));
                temp.setLength(matrixA.length);
                temp.setIndex1(i);
                for (int j = 0; j < matrixA.length; j++) {
                        temp.setB(B.get(j));
                        temp.setIndex2(j);
                        selectedstubs.get(stubcounter).multiplyBlock(temp.build(), responseObserver);
                        if (stubcounter == selectedstubs.size() - 1) {
                                stubcounter = 0;
                        } else {
                                stubcounter += 1;
                        }
                        Thread.sleep(250);
                }
               
        }

        System.out.println(finalm);

        return finalm;
        }

        public int getNumberServers(String op, InnerList.Builder a, InnerList.Builder b, int value, ManagedChannel channel, int amountOfCalls, long deadline) throws InterruptedException, ExecutionException {
                MatrixRequest.Builder temp = MatrixRequest.newBuilder();
                MatrixServiceGrpc.MatrixServiceBlockingStub tempstub = MatrixServiceGrpc.newBlockingStub(channel);
                temp.setA(a);
                temp.setB(b);
                temp.setLength(value);
                temp.setIndex1(0);
                temp.setIndex2(0);
                MatrixReply rep = null;
                System.out.println("Asynchronous operation being done");
                System.out.println("CALCULATING NUMBER OF SERVERS NEEDED.....");
                long start = System.nanoTime();
                if (op.equals("multiply")) {
                        rep = tempstub.multiplyBlock(temp.build());
                } else {
                        rep.tempstub.addBlock(temp.build());
                }
                long end = System.nanoTime();
                System.out.println("Number of block calls: " + amountOfCalls);
                long footprint = end - start;
                System.out.println("Start time: " + start + " End time: " + end + " Elapsed time: " + footprint);
                long numberOfServersLong = (footprint*amountOfCalls) / deadline;
                int numberOfServers = Math.toIntExact(numberOfServersLong);
                if (numberOfServers > 8) {
                        numberOfServers = 8;
                }
                if (numberOfServers < 1) {
                        numberOfServers = 1;
                }
                return numberOfServers;
        }

        public int[][] stringToMatrix(String line, int col, int row) {
        String[] lineArr = line.split(" ");
        int[][] matrix = new int[row][col];
        int pointerrow = 0;
        int pointercol = 0;

        for (int i = 0; i < lineArr.length; i++) {
                matrix[pointerrow][pointercol] = Integer.parseInt(lineArr[i]);
                pointercol += 1;
                if (pointercol == col) {
                pointerrow += 1;
                pointercol = 0;
                }
        }

        return matrix;
        }
}
