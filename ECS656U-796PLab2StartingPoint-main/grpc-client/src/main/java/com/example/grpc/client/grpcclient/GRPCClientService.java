package com.example.grpc.client.grpcclient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.example.grpc.server.grpcserver.PingRequest;
import com.example.grpc.server.grpcserver.PongResponse;
import com.example.grpc.server.grpcserver.InnerList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
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

      public int[][] addMatrices(int[][] matrixA, int[][] matrixB, long deadline) {
        ManagedChannel channel1 = ManagedChannelBuilder.forAddress("10.128.0.2",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub1 = MatrixServiceGrpc.newBlockingStub(channel1);
        ManagedChannel channel2 = ManagedChannelBuilder.forAddress("10.128.0.3",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub2 = MatrixServiceGrpc.newBlockingStub(channel2);
        ManagedChannel channel3 = ManagedChannelBuilder.forAddress("10.128.0.4",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub3 = MatrixServiceGrpc.newBlockingStub(channel3);
        ManagedChannel channel4 = ManagedChannelBuilder.forAddress("10.128.0.5",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub4 = MatrixServiceGrpc.newBlockingStub(channel4);
        ManagedChannel channel5 = ManagedChannelBuilder.forAddress("10.128.0.6",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub5 = MatrixServiceGrpc.newBlockingStub(channel5);
        ManagedChannel channel6 = ManagedChannelBuilder.forAddress("10.128.0.7",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub6 = MatrixServiceGrpc.newBlockingStub(channel6);
        ManagedChannel channel7 = ManagedChannelBuilder.forAddress("10.128.0.8",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub7 = MatrixServiceGrpc.newBlockingStub(channel7);
        ManagedChannel channel8 = ManagedChannelBuilder.forAddress("10.128.0.9",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub8 = MatrixServiceGrpc.newBlockingStub(channel8);

        MatrixServiceGrpc.MatrixServiceBlockingStub[] stubs = {stub1, stub2, stub3, stub4, stub5, stub6, stub7, stub8};
        List<MatrixServiceGrpc.MatrixServiceBlockingStub> selectedstubs = new ArrayList<MatrixServiceGrpc.MatrixServiceBlockingStub>();



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
        for (int i = 0; i < matrixA.length; i++) {
                MatrixRequest.Builder temp = MatrixRequest.newBuilder();
                temp.setA(A.get(i));
                temp.setB(B.get(i));
                for (int j = 0; j < matrixA.length; j++) {
                        temp.setN(j);
                        MatrixReply rep = selectedstubs.get(stubcounter).addBlock(temp.build());
                        if (stubcounter == selectedstubs.size() - 1) {
                                stubcounter = 0;
                        } else {
                                stubcounter += 1;
                        }
                        finalm[i][j] = rep.getC();
                }
               
        }

        return finalm;

      }

     public int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB, long deadline) {
        ManagedChannel channel1 = ManagedChannelBuilder.forAddress("10.128.0.2",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub1 = MatrixServiceGrpc.newBlockingStub(channel1);
        ManagedChannel channel2 = ManagedChannelBuilder.forAddress("10.128.0.3",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub2 = MatrixServiceGrpc.newBlockingStub(channel2);
        ManagedChannel channel3 = ManagedChannelBuilder.forAddress("10.128.0.4",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub3 = MatrixServiceGrpc.newBlockingStub(channel3);
        ManagedChannel channel4 = ManagedChannelBuilder.forAddress("10.128.0.5",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub4 = MatrixServiceGrpc.newBlockingStub(channel4);
        ManagedChannel channel5 = ManagedChannelBuilder.forAddress("10.128.0.6",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub5 = MatrixServiceGrpc.newBlockingStub(channel5);
        ManagedChannel channel6 = ManagedChannelBuilder.forAddress("10.128.0.7",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub6 = MatrixServiceGrpc.newBlockingStub(channel6);
        ManagedChannel channel7 = ManagedChannelBuilder.forAddress("10.128.0.8",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub7 = MatrixServiceGrpc.newBlockingStub(channel7);
        ManagedChannel channel8 = ManagedChannelBuilder.forAddress("10.128.0.9",9090).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub8 = MatrixServiceGrpc.newBlockingStub(channel8);

        MatrixServiceGrpc.MatrixServiceBlockingStub[] stubs = {stub1, stub2, stub3, stub4, stub5, stub6, stub7, stub8};
        List<MatrixServiceGrpc.MatrixServiceBlockingStub> selectedstubs = new ArrayList<MatrixServiceGrpc.MatrixServiceBlockingStub>();

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
        for (int i = 0; i < matrixA.length; i++) {
                MatrixRequest.Builder temp = MatrixRequest.newBuilder();
                temp.setA(A.get(i));
                temp.setN(matrixA.length);
                for (int j = 0; j < matrixA.length; j++) {
                        temp.setB(B.get(i));
                        MatrixReply rep = selectedstubs.get(stubcounter).multiplyBlock(temp.build());
                        finalm[i][j] = rep.getC();
                        if (stubcounter == selectedstubs.size() - 1) {
                                stubcounter = 0;
                        } else {
                                stubcounter += 1;
                        }
                        
                }
               
        }

        return finalm;
        }

        public int getNumberServers(String op, InnerList.Builder a, InnerList.Builder b, int value, ManagedChannel channel, int amountOfCalls, long deadline) {
                MatrixRequest.Builder temp = MatrixRequest.newBuilder();
                MatrixServiceGrpc.MatrixServiceBlockingStub tempstub = MatrixServiceGrpc.newBlockingStub(channel);
                temp.setA(a);
                temp.setB(b);
                temp.setN(value);
                long start = System.nanoTime();
                System.out.println("Asynchronous operation being done");
                System.out.println("CALCULATING NUMBER OF SERVERS NEEDED.....");
                MatrixReply rep = tempstub.multiplyBlock(temp.build());
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
