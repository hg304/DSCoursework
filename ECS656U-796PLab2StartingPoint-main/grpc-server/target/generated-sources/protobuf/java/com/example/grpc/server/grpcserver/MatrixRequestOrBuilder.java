// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: matrix.proto

package com.example.grpc.server.grpcserver;

public interface MatrixRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:matrixmult.MatrixRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .matrixmult.InnerList a = 1;</code>
   */
  java.util.List<com.example.grpc.server.grpcserver.InnerList> 
      getAList();
  /**
   * <code>repeated .matrixmult.InnerList a = 1;</code>
   */
  com.example.grpc.server.grpcserver.InnerList getA(int index);
  /**
   * <code>repeated .matrixmult.InnerList a = 1;</code>
   */
  int getACount();
  /**
   * <code>repeated .matrixmult.InnerList a = 1;</code>
   */
  java.util.List<? extends com.example.grpc.server.grpcserver.InnerListOrBuilder> 
      getAOrBuilderList();
  /**
   * <code>repeated .matrixmult.InnerList a = 1;</code>
   */
  com.example.grpc.server.grpcserver.InnerListOrBuilder getAOrBuilder(
      int index);

  /**
   * <code>repeated .matrixmult.InnerList b = 2;</code>
   */
  java.util.List<com.example.grpc.server.grpcserver.InnerList> 
      getBList();
  /**
   * <code>repeated .matrixmult.InnerList b = 2;</code>
   */
  com.example.grpc.server.grpcserver.InnerList getB(int index);
  /**
   * <code>repeated .matrixmult.InnerList b = 2;</code>
   */
  int getBCount();
  /**
   * <code>repeated .matrixmult.InnerList b = 2;</code>
   */
  java.util.List<? extends com.example.grpc.server.grpcserver.InnerListOrBuilder> 
      getBOrBuilderList();
  /**
   * <code>repeated .matrixmult.InnerList b = 2;</code>
   */
  com.example.grpc.server.grpcserver.InnerListOrBuilder getBOrBuilder(
      int index);
}
