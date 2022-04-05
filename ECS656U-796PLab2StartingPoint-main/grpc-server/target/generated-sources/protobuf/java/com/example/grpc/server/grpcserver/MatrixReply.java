// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: matrix.proto

package com.example.grpc.server.grpcserver;

/**
 * <pre>
 * The response message containing the result marix
 * </pre>
 *
 * Protobuf type {@code matrixmult.MatrixReply}
 */
public  final class MatrixReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:matrixmult.MatrixReply)
    MatrixReplyOrBuilder {
  // Use MatrixReply.newBuilder() to construct.
  private MatrixReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MatrixReply() {
    c_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private MatrixReply(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              c_ = new java.util.ArrayList<com.example.grpc.server.grpcserver.InnerList>();
              mutable_bitField0_ |= 0x00000001;
            }
            c_.add(
                input.readMessage(com.example.grpc.server.grpcserver.InnerList.parser(), extensionRegistry));
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        c_ = java.util.Collections.unmodifiableList(c_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.grpc.server.grpcserver.MatrixMult.internal_static_matrixmult_MatrixReply_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.grpc.server.grpcserver.MatrixMult.internal_static_matrixmult_MatrixReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.grpc.server.grpcserver.MatrixReply.class, com.example.grpc.server.grpcserver.MatrixReply.Builder.class);
  }

  public static final int C_FIELD_NUMBER = 1;
  private java.util.List<com.example.grpc.server.grpcserver.InnerList> c_;
  /**
   * <code>repeated .matrixmult.InnerList c = 1;</code>
   */
  public java.util.List<com.example.grpc.server.grpcserver.InnerList> getCList() {
    return c_;
  }
  /**
   * <code>repeated .matrixmult.InnerList c = 1;</code>
   */
  public java.util.List<? extends com.example.grpc.server.grpcserver.InnerListOrBuilder> 
      getCOrBuilderList() {
    return c_;
  }
  /**
   * <code>repeated .matrixmult.InnerList c = 1;</code>
   */
  public int getCCount() {
    return c_.size();
  }
  /**
   * <code>repeated .matrixmult.InnerList c = 1;</code>
   */
  public com.example.grpc.server.grpcserver.InnerList getC(int index) {
    return c_.get(index);
  }
  /**
   * <code>repeated .matrixmult.InnerList c = 1;</code>
   */
  public com.example.grpc.server.grpcserver.InnerListOrBuilder getCOrBuilder(
      int index) {
    return c_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < c_.size(); i++) {
      output.writeMessage(1, c_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < c_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, c_.get(i));
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.grpc.server.grpcserver.MatrixReply)) {
      return super.equals(obj);
    }
    com.example.grpc.server.grpcserver.MatrixReply other = (com.example.grpc.server.grpcserver.MatrixReply) obj;

    boolean result = true;
    result = result && getCList()
        .equals(other.getCList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getCCount() > 0) {
      hash = (37 * hash) + C_FIELD_NUMBER;
      hash = (53 * hash) + getCList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.grpc.server.grpcserver.MatrixReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.grpc.server.grpcserver.MatrixReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.grpc.server.grpcserver.MatrixReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.grpc.server.grpcserver.MatrixReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.grpc.server.grpcserver.MatrixReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.grpc.server.grpcserver.MatrixReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.grpc.server.grpcserver.MatrixReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.grpc.server.grpcserver.MatrixReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.grpc.server.grpcserver.MatrixReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.grpc.server.grpcserver.MatrixReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.grpc.server.grpcserver.MatrixReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.grpc.server.grpcserver.MatrixReply parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.grpc.server.grpcserver.MatrixReply prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * The response message containing the result marix
   * </pre>
   *
   * Protobuf type {@code matrixmult.MatrixReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:matrixmult.MatrixReply)
      com.example.grpc.server.grpcserver.MatrixReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.grpc.server.grpcserver.MatrixMult.internal_static_matrixmult_MatrixReply_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.grpc.server.grpcserver.MatrixMult.internal_static_matrixmult_MatrixReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.grpc.server.grpcserver.MatrixReply.class, com.example.grpc.server.grpcserver.MatrixReply.Builder.class);
    }

    // Construct using com.example.grpc.server.grpcserver.MatrixReply.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getCFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (cBuilder_ == null) {
        c_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        cBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.grpc.server.grpcserver.MatrixMult.internal_static_matrixmult_MatrixReply_descriptor;
    }

    public com.example.grpc.server.grpcserver.MatrixReply getDefaultInstanceForType() {
      return com.example.grpc.server.grpcserver.MatrixReply.getDefaultInstance();
    }

    public com.example.grpc.server.grpcserver.MatrixReply build() {
      com.example.grpc.server.grpcserver.MatrixReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.example.grpc.server.grpcserver.MatrixReply buildPartial() {
      com.example.grpc.server.grpcserver.MatrixReply result = new com.example.grpc.server.grpcserver.MatrixReply(this);
      int from_bitField0_ = bitField0_;
      if (cBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          c_ = java.util.Collections.unmodifiableList(c_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.c_ = c_;
      } else {
        result.c_ = cBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.grpc.server.grpcserver.MatrixReply) {
        return mergeFrom((com.example.grpc.server.grpcserver.MatrixReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.grpc.server.grpcserver.MatrixReply other) {
      if (other == com.example.grpc.server.grpcserver.MatrixReply.getDefaultInstance()) return this;
      if (cBuilder_ == null) {
        if (!other.c_.isEmpty()) {
          if (c_.isEmpty()) {
            c_ = other.c_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureCIsMutable();
            c_.addAll(other.c_);
          }
          onChanged();
        }
      } else {
        if (!other.c_.isEmpty()) {
          if (cBuilder_.isEmpty()) {
            cBuilder_.dispose();
            cBuilder_ = null;
            c_ = other.c_;
            bitField0_ = (bitField0_ & ~0x00000001);
            cBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getCFieldBuilder() : null;
          } else {
            cBuilder_.addAllMessages(other.c_);
          }
        }
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.example.grpc.server.grpcserver.MatrixReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.grpc.server.grpcserver.MatrixReply) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.example.grpc.server.grpcserver.InnerList> c_ =
      java.util.Collections.emptyList();
    private void ensureCIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        c_ = new java.util.ArrayList<com.example.grpc.server.grpcserver.InnerList>(c_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.example.grpc.server.grpcserver.InnerList, com.example.grpc.server.grpcserver.InnerList.Builder, com.example.grpc.server.grpcserver.InnerListOrBuilder> cBuilder_;

    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public java.util.List<com.example.grpc.server.grpcserver.InnerList> getCList() {
      if (cBuilder_ == null) {
        return java.util.Collections.unmodifiableList(c_);
      } else {
        return cBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public int getCCount() {
      if (cBuilder_ == null) {
        return c_.size();
      } else {
        return cBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public com.example.grpc.server.grpcserver.InnerList getC(int index) {
      if (cBuilder_ == null) {
        return c_.get(index);
      } else {
        return cBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public Builder setC(
        int index, com.example.grpc.server.grpcserver.InnerList value) {
      if (cBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCIsMutable();
        c_.set(index, value);
        onChanged();
      } else {
        cBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public Builder setC(
        int index, com.example.grpc.server.grpcserver.InnerList.Builder builderForValue) {
      if (cBuilder_ == null) {
        ensureCIsMutable();
        c_.set(index, builderForValue.build());
        onChanged();
      } else {
        cBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public Builder addC(com.example.grpc.server.grpcserver.InnerList value) {
      if (cBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCIsMutable();
        c_.add(value);
        onChanged();
      } else {
        cBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public Builder addC(
        int index, com.example.grpc.server.grpcserver.InnerList value) {
      if (cBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCIsMutable();
        c_.add(index, value);
        onChanged();
      } else {
        cBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public Builder addC(
        com.example.grpc.server.grpcserver.InnerList.Builder builderForValue) {
      if (cBuilder_ == null) {
        ensureCIsMutable();
        c_.add(builderForValue.build());
        onChanged();
      } else {
        cBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public Builder addC(
        int index, com.example.grpc.server.grpcserver.InnerList.Builder builderForValue) {
      if (cBuilder_ == null) {
        ensureCIsMutable();
        c_.add(index, builderForValue.build());
        onChanged();
      } else {
        cBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public Builder addAllC(
        java.lang.Iterable<? extends com.example.grpc.server.grpcserver.InnerList> values) {
      if (cBuilder_ == null) {
        ensureCIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, c_);
        onChanged();
      } else {
        cBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public Builder clearC() {
      if (cBuilder_ == null) {
        c_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        cBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public Builder removeC(int index) {
      if (cBuilder_ == null) {
        ensureCIsMutable();
        c_.remove(index);
        onChanged();
      } else {
        cBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public com.example.grpc.server.grpcserver.InnerList.Builder getCBuilder(
        int index) {
      return getCFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public com.example.grpc.server.grpcserver.InnerListOrBuilder getCOrBuilder(
        int index) {
      if (cBuilder_ == null) {
        return c_.get(index);  } else {
        return cBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public java.util.List<? extends com.example.grpc.server.grpcserver.InnerListOrBuilder> 
         getCOrBuilderList() {
      if (cBuilder_ != null) {
        return cBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(c_);
      }
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public com.example.grpc.server.grpcserver.InnerList.Builder addCBuilder() {
      return getCFieldBuilder().addBuilder(
          com.example.grpc.server.grpcserver.InnerList.getDefaultInstance());
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public com.example.grpc.server.grpcserver.InnerList.Builder addCBuilder(
        int index) {
      return getCFieldBuilder().addBuilder(
          index, com.example.grpc.server.grpcserver.InnerList.getDefaultInstance());
    }
    /**
     * <code>repeated .matrixmult.InnerList c = 1;</code>
     */
    public java.util.List<com.example.grpc.server.grpcserver.InnerList.Builder> 
         getCBuilderList() {
      return getCFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.example.grpc.server.grpcserver.InnerList, com.example.grpc.server.grpcserver.InnerList.Builder, com.example.grpc.server.grpcserver.InnerListOrBuilder> 
        getCFieldBuilder() {
      if (cBuilder_ == null) {
        cBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.example.grpc.server.grpcserver.InnerList, com.example.grpc.server.grpcserver.InnerList.Builder, com.example.grpc.server.grpcserver.InnerListOrBuilder>(
                c_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        c_ = null;
      }
      return cBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:matrixmult.MatrixReply)
  }

  // @@protoc_insertion_point(class_scope:matrixmult.MatrixReply)
  private static final com.example.grpc.server.grpcserver.MatrixReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.grpc.server.grpcserver.MatrixReply();
  }

  public static com.example.grpc.server.grpcserver.MatrixReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MatrixReply>
      PARSER = new com.google.protobuf.AbstractParser<MatrixReply>() {
    public MatrixReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new MatrixReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MatrixReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MatrixReply> getParserForType() {
    return PARSER;
  }

  public com.example.grpc.server.grpcserver.MatrixReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
