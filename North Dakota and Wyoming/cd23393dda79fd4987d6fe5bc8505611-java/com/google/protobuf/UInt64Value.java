package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class UInt64Value extends GeneratedMessageV3 implements UInt64ValueOrBuilder {
    private static final UInt64Value DEFAULT_INSTANCE = new UInt64Value();
    private static final Parser<UInt64Value> PARSER = new AbstractParser<UInt64Value>() {
        /* class com.google.protobuf.UInt64Value.AnonymousClass1 */

        @Override // com.google.protobuf.Parser
        public UInt64Value parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new UInt64Value(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private long value_;

    private UInt64Value(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private UInt64Value() {
        this.memoizedIsInitialized = -1;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new UInt64Value();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private UInt64Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag == 8) {
                        this.value_ = codedInputStream.readUInt64();
                    } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                    }
                }
                z = true;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
            } catch (Throwable th) {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_UInt64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(UInt64Value.class, Builder.class);
    }

    @Override // com.google.protobuf.UInt64ValueOrBuilder
    public long getValue() {
        return this.value_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.AbstractMessage, com.google.protobuf.GeneratedMessageV3
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.value_;
        if (j != 0) {
            codedOutputStream.writeUInt64(1, j);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.AbstractMessage, com.google.protobuf.GeneratedMessageV3
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        long j = this.value_;
        if (j != 0) {
            i2 = 0 + CodedOutputStream.computeUInt64Size(1, j);
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UInt64Value)) {
            return super.equals(obj);
        }
        UInt64Value uInt64Value = (UInt64Value) obj;
        if (getValue() == uInt64Value.getValue() && this.unknownFields.equals(uInt64Value.unknownFields)) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getValue())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public static UInt64Value parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static UInt64Value parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static UInt64Value parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static UInt64Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static UInt64Value parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static UInt64Value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static UInt64Value parseFrom(InputStream inputStream) throws IOException {
        return (UInt64Value) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static UInt64Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UInt64Value) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static UInt64Value parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (UInt64Value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static UInt64Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UInt64Value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static UInt64Value parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (UInt64Value) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static UInt64Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UInt64Value) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(UInt64Value uInt64Value) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(uInt64Value);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        if (this == DEFAULT_INSTANCE) {
            return new Builder();
        }
        return new Builder().mergeFrom(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UInt64ValueOrBuilder {
        private long value_;

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.GeneratedMessageV3.Builder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WrappersProto.internal_static_google_protobuf_UInt64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(UInt64Value.class, Builder.class);
        }

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean z = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder
        public Builder clear() {
            super.clear();
            this.value_ = 0;
            return this;
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessageV3.Builder
        public Descriptors.Descriptor getDescriptorForType() {
            return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UInt64Value getDefaultInstanceForType() {
            return UInt64Value.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UInt64Value build() {
            UInt64Value buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UInt64Value buildPartial() {
            UInt64Value uInt64Value = new UInt64Value(this);
            uInt64Value.value_ = this.value_;
            onBuilt();
            return uInt64Value;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder, java.lang.Object, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof UInt64Value) {
                return mergeFrom((UInt64Value) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(UInt64Value uInt64Value) {
            if (uInt64Value == UInt64Value.getDefaultInstance()) {
                return this;
            }
            if (uInt64Value.getValue() != 0) {
                setValue(uInt64Value.getValue());
            }
            mergeUnknownFields(uInt64Value.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Throwable th;
            UInt64Value uInt64Value;
            UInt64Value uInt64Value2 = null;
            try {
                UInt64Value uInt64Value3 = (UInt64Value) UInt64Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (uInt64Value3 != null) {
                    mergeFrom(uInt64Value3);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                uInt64Value = (UInt64Value) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } catch (Throwable th2) {
                th = th2;
                uInt64Value2 = uInt64Value;
                if (uInt64Value2 != null) {
                }
                throw th;
            }
        }

        @Override // com.google.protobuf.UInt64ValueOrBuilder
        public long getValue() {
            return this.value_;
        }

        public Builder setValue(long j) {
            this.value_ = j;
            onChanged();
            return this;
        }

        public Builder clearValue() {
            this.value_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static UInt64Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static UInt64Value of(long j) {
        return newBuilder().setValue(j).build();
    }

    public static Parser<UInt64Value> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message, com.google.protobuf.GeneratedMessageV3
    public Parser<UInt64Value> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public UInt64Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
