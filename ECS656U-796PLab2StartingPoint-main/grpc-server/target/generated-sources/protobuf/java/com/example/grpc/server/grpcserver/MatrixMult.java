// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: matrix.proto

package com.example.grpc.server.grpcserver;

public final class MatrixMult {
  private MatrixMult() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_matrixmult_MatrixRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_matrixmult_MatrixRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_matrixmult_MatrixReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_matrixmult_MatrixReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_matrixmult_InnerList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_matrixmult_InnerList_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014matrix.proto\022\nmatrixmult\"S\n\rMatrixRequ" +
      "est\022 \n\001a\030\001 \003(\0132\025.matrixmult.InnerList\022 \n" +
      "\001b\030\002 \003(\0132\025.matrixmult.InnerList\"/\n\013Matri" +
      "xReply\022 \n\001c\030\001 \003(\0132\025.matrixmult.InnerList" +
      "\"\026\n\tInnerList\022\t\n\001a\030\001 \003(\0052\230\001\n\rMatrixServi" +
      "ce\022E\n\rMultiplyBlock\022\031.matrixmult.MatrixR" +
      "equest\032\027.matrixmult.MatrixReply\"\000\022@\n\010Add" +
      "Block\022\031.matrixmult.MatrixRequest\032\027.matri" +
      "xmult.MatrixReply\"\000B7\n\"com.example.grpc." +
      "server.grpcserverB\nMatrixMultP\001\242\002\002MMb\006pr",
      "oto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_matrixmult_MatrixRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_matrixmult_MatrixRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_matrixmult_MatrixRequest_descriptor,
        new java.lang.String[] { "A", "B", });
    internal_static_matrixmult_MatrixReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_matrixmult_MatrixReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_matrixmult_MatrixReply_descriptor,
        new java.lang.String[] { "C", });
    internal_static_matrixmult_InnerList_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_matrixmult_InnerList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_matrixmult_InnerList_descriptor,
        new java.lang.String[] { "A", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}