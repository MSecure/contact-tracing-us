package com.proudcrowd.exposure.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.proudcrowd.exposure.proto.SignatureInfo;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class TEKSignature extends GeneratedMessageV3 implements TEKSignatureOrBuilder {
    public static final int BATCH_NUM_FIELD_NUMBER = 2;
    public static final int BATCH_SIZE_FIELD_NUMBER = 3;
    private static final TEKSignature DEFAULT_INSTANCE = new TEKSignature();
    @Deprecated
    public static final Parser<TEKSignature> PARSER = new AbstractParser<TEKSignature>() {
        /* class com.proudcrowd.exposure.proto.TEKSignature.AnonymousClass1 */

        @Override // com.google.protobuf.Parser
        public TEKSignature parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new TEKSignature(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int SIGNATURE_FIELD_NUMBER = 4;
    public static final int SIGNATURE_INFO_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int batchNum_;
    private int batchSize_;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private SignatureInfo signatureInfo_;
    private ByteString signature_;

    private TEKSignature(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private TEKSignature() {
        this.memoizedIsInitialized = -1;
        this.signature_ = ByteString.EMPTY;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new TEKSignature();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private TEKSignature(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag == 10) {
                        SignatureInfo.Builder builder = (this.bitField0_ & 1) != 0 ? this.signatureInfo_.toBuilder() : null;
                        SignatureInfo signatureInfo = (SignatureInfo) codedInputStream.readMessage(SignatureInfo.PARSER, extensionRegistryLite);
                        this.signatureInfo_ = signatureInfo;
                        if (builder != null) {
                            builder.mergeFrom(signatureInfo);
                            this.signatureInfo_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 1;
                    } else if (readTag == 16) {
                        this.bitField0_ |= 2;
                        this.batchNum_ = codedInputStream.readInt32();
                    } else if (readTag == 24) {
                        this.bitField0_ |= 4;
                        this.batchSize_ = codedInputStream.readInt32();
                    } else if (readTag == 34) {
                        this.bitField0_ |= 8;
                        this.signature_ = codedInputStream.readBytes();
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
        return KeyFile.internal_static_com_proudcrowd_exposure_debug_TEKSignature_descriptor;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return KeyFile.internal_static_com_proudcrowd_exposure_debug_TEKSignature_fieldAccessorTable.ensureFieldAccessorsInitialized(TEKSignature.class, Builder.class);
    }

    @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
    public boolean hasSignatureInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
    public SignatureInfo getSignatureInfo() {
        SignatureInfo signatureInfo = this.signatureInfo_;
        return signatureInfo == null ? SignatureInfo.getDefaultInstance() : signatureInfo;
    }

    @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
    public SignatureInfoOrBuilder getSignatureInfoOrBuilder() {
        SignatureInfo signatureInfo = this.signatureInfo_;
        return signatureInfo == null ? SignatureInfo.getDefaultInstance() : signatureInfo;
    }

    @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
    public boolean hasBatchNum() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
    public int getBatchNum() {
        return this.batchNum_;
    }

    @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
    public boolean hasBatchSize() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
    public int getBatchSize() {
        return this.batchSize_;
    }

    @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
    public boolean hasSignature() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
    public ByteString getSignature() {
        return this.signature_;
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
        if ((this.bitField0_ & 1) != 0) {
            codedOutputStream.writeMessage(1, getSignatureInfo());
        }
        if ((this.bitField0_ & 2) != 0) {
            codedOutputStream.writeInt32(2, this.batchNum_);
        }
        if ((this.bitField0_ & 4) != 0) {
            codedOutputStream.writeInt32(3, this.batchSize_);
        }
        if ((this.bitField0_ & 8) != 0) {
            codedOutputStream.writeBytes(4, this.signature_);
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
        if ((this.bitField0_ & 1) != 0) {
            i2 = 0 + CodedOutputStream.computeMessageSize(1, getSignatureInfo());
        }
        if ((this.bitField0_ & 2) != 0) {
            i2 += CodedOutputStream.computeInt32Size(2, this.batchNum_);
        }
        if ((this.bitField0_ & 4) != 0) {
            i2 += CodedOutputStream.computeInt32Size(3, this.batchSize_);
        }
        if ((this.bitField0_ & 8) != 0) {
            i2 += CodedOutputStream.computeBytesSize(4, this.signature_);
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
        if (!(obj instanceof TEKSignature)) {
            return super.equals(obj);
        }
        TEKSignature tEKSignature = (TEKSignature) obj;
        if (hasSignatureInfo() != tEKSignature.hasSignatureInfo()) {
            return false;
        }
        if ((hasSignatureInfo() && !getSignatureInfo().equals(tEKSignature.getSignatureInfo())) || hasBatchNum() != tEKSignature.hasBatchNum()) {
            return false;
        }
        if ((hasBatchNum() && getBatchNum() != tEKSignature.getBatchNum()) || hasBatchSize() != tEKSignature.hasBatchSize()) {
            return false;
        }
        if ((hasBatchSize() && getBatchSize() != tEKSignature.getBatchSize()) || hasSignature() != tEKSignature.hasSignature()) {
            return false;
        }
        if ((!hasSignature() || getSignature().equals(tEKSignature.getSignature())) && this.unknownFields.equals(tEKSignature.unknownFields)) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        if (hasSignatureInfo()) {
            hashCode = (((hashCode * 37) + 1) * 53) + getSignatureInfo().hashCode();
        }
        if (hasBatchNum()) {
            hashCode = (((hashCode * 37) + 2) * 53) + getBatchNum();
        }
        if (hasBatchSize()) {
            hashCode = (((hashCode * 37) + 3) * 53) + getBatchSize();
        }
        if (hasSignature()) {
            hashCode = (((hashCode * 37) + 4) * 53) + getSignature().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public static TEKSignature parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static TEKSignature parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static TEKSignature parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static TEKSignature parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static TEKSignature parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static TEKSignature parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static TEKSignature parseFrom(InputStream inputStream) throws IOException {
        return (TEKSignature) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static TEKSignature parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TEKSignature) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TEKSignature parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TEKSignature) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static TEKSignature parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TEKSignature) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TEKSignature parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TEKSignature) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static TEKSignature parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TEKSignature) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TEKSignature tEKSignature) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(tEKSignature);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TEKSignatureOrBuilder {
        private int batchNum_;
        private int batchSize_;
        private int bitField0_;
        private SingleFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> signatureInfoBuilder_;
        private SignatureInfo signatureInfo_;
        private ByteString signature_;

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.GeneratedMessageV3.Builder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return KeyFile.internal_static_com_proudcrowd_exposure_debug_TEKSignature_descriptor;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return KeyFile.internal_static_com_proudcrowd_exposure_debug_TEKSignature_fieldAccessorTable.ensureFieldAccessorsInitialized(TEKSignature.class, Builder.class);
        }

        private Builder() {
            this.signature_ = ByteString.EMPTY;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.signature_ = ByteString.EMPTY;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (TEKSignature.alwaysUseFieldBuilders) {
                getSignatureInfoFieldBuilder();
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder
        public Builder clear() {
            super.clear();
            SingleFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> singleFieldBuilderV3 = this.signatureInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.signatureInfo_ = null;
            } else {
                singleFieldBuilderV3.clear();
            }
            int i = this.bitField0_ & -2;
            this.bitField0_ = i;
            this.batchNum_ = 0;
            int i2 = i & -3;
            this.bitField0_ = i2;
            this.batchSize_ = 0;
            this.bitField0_ = i2 & -5;
            this.signature_ = ByteString.EMPTY;
            this.bitField0_ &= -9;
            return this;
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessageV3.Builder
        public Descriptors.Descriptor getDescriptorForType() {
            return KeyFile.internal_static_com_proudcrowd_exposure_debug_TEKSignature_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TEKSignature getDefaultInstanceForType() {
            return TEKSignature.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TEKSignature build() {
            TEKSignature buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TEKSignature buildPartial() {
            int i;
            TEKSignature tEKSignature = new TEKSignature(this);
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                SingleFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> singleFieldBuilderV3 = this.signatureInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    tEKSignature.signatureInfo_ = this.signatureInfo_;
                } else {
                    tEKSignature.signatureInfo_ = singleFieldBuilderV3.build();
                }
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 2) != 0) {
                tEKSignature.batchNum_ = this.batchNum_;
                i |= 2;
            }
            if ((i2 & 4) != 0) {
                tEKSignature.batchSize_ = this.batchSize_;
                i |= 4;
            }
            if ((i2 & 8) != 0) {
                i |= 8;
            }
            tEKSignature.signature_ = this.signature_;
            tEKSignature.bitField0_ = i;
            onBuilt();
            return tEKSignature;
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
            if (message instanceof TEKSignature) {
                return mergeFrom((TEKSignature) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(TEKSignature tEKSignature) {
            if (tEKSignature == TEKSignature.getDefaultInstance()) {
                return this;
            }
            if (tEKSignature.hasSignatureInfo()) {
                mergeSignatureInfo(tEKSignature.getSignatureInfo());
            }
            if (tEKSignature.hasBatchNum()) {
                setBatchNum(tEKSignature.getBatchNum());
            }
            if (tEKSignature.hasBatchSize()) {
                setBatchSize(tEKSignature.getBatchSize());
            }
            if (tEKSignature.hasSignature()) {
                setSignature(tEKSignature.getSignature());
            }
            mergeUnknownFields(tEKSignature.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Throwable th;
            TEKSignature tEKSignature;
            TEKSignature tEKSignature2 = null;
            try {
                TEKSignature parsePartialFrom = TEKSignature.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                tEKSignature = (TEKSignature) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } catch (Throwable th2) {
                th = th2;
                tEKSignature2 = tEKSignature;
                if (tEKSignature2 != null) {
                }
                throw th;
            }
        }

        @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
        public boolean hasSignatureInfo() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
        public SignatureInfo getSignatureInfo() {
            SingleFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> singleFieldBuilderV3 = this.signatureInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessage();
            }
            SignatureInfo signatureInfo = this.signatureInfo_;
            return signatureInfo == null ? SignatureInfo.getDefaultInstance() : signatureInfo;
        }

        public Builder setSignatureInfo(SignatureInfo signatureInfo) {
            SingleFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> singleFieldBuilderV3 = this.signatureInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(signatureInfo);
                this.signatureInfo_ = signatureInfo;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(signatureInfo);
            }
            this.bitField0_ |= 1;
            return this;
        }

        public Builder setSignatureInfo(SignatureInfo.Builder builder) {
            SingleFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> singleFieldBuilderV3 = this.signatureInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.signatureInfo_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.bitField0_ |= 1;
            return this;
        }

        public Builder mergeSignatureInfo(SignatureInfo signatureInfo) {
            SignatureInfo signatureInfo2;
            SingleFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> singleFieldBuilderV3 = this.signatureInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) == 0 || (signatureInfo2 = this.signatureInfo_) == null || signatureInfo2 == SignatureInfo.getDefaultInstance()) {
                    this.signatureInfo_ = signatureInfo;
                } else {
                    this.signatureInfo_ = SignatureInfo.newBuilder(this.signatureInfo_).mergeFrom(signatureInfo).buildPartial();
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(signatureInfo);
            }
            this.bitField0_ |= 1;
            return this;
        }

        public Builder clearSignatureInfo() {
            SingleFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> singleFieldBuilderV3 = this.signatureInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.signatureInfo_ = null;
                onChanged();
            } else {
                singleFieldBuilderV3.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        public SignatureInfo.Builder getSignatureInfoBuilder() {
            this.bitField0_ |= 1;
            onChanged();
            return getSignatureInfoFieldBuilder().getBuilder();
        }

        @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
        public SignatureInfoOrBuilder getSignatureInfoOrBuilder() {
            SingleFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> singleFieldBuilderV3 = this.signatureInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            SignatureInfo signatureInfo = this.signatureInfo_;
            return signatureInfo == null ? SignatureInfo.getDefaultInstance() : signatureInfo;
        }

        private SingleFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> getSignatureInfoFieldBuilder() {
            if (this.signatureInfoBuilder_ == null) {
                this.signatureInfoBuilder_ = new SingleFieldBuilderV3<>(getSignatureInfo(), getParentForChildren(), isClean());
                this.signatureInfo_ = null;
            }
            return this.signatureInfoBuilder_;
        }

        @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
        public boolean hasBatchNum() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
        public int getBatchNum() {
            return this.batchNum_;
        }

        public Builder setBatchNum(int i) {
            this.bitField0_ |= 2;
            this.batchNum_ = i;
            onChanged();
            return this;
        }

        public Builder clearBatchNum() {
            this.bitField0_ &= -3;
            this.batchNum_ = 0;
            onChanged();
            return this;
        }

        @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
        public boolean hasBatchSize() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
        public int getBatchSize() {
            return this.batchSize_;
        }

        public Builder setBatchSize(int i) {
            this.bitField0_ |= 4;
            this.batchSize_ = i;
            onChanged();
            return this;
        }

        public Builder clearBatchSize() {
            this.bitField0_ &= -5;
            this.batchSize_ = 0;
            onChanged();
            return this;
        }

        @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
        public boolean hasSignature() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.TEKSignatureOrBuilder
        public ByteString getSignature() {
            return this.signature_;
        }

        public Builder setSignature(ByteString byteString) {
            Objects.requireNonNull(byteString);
            this.bitField0_ |= 8;
            this.signature_ = byteString;
            onChanged();
            return this;
        }

        public Builder clearSignature() {
            this.bitField0_ &= -9;
            this.signature_ = TEKSignature.getDefaultInstance().getSignature();
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

    public static TEKSignature getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<TEKSignature> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message, com.google.protobuf.GeneratedMessageV3
    public Parser<TEKSignature> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public TEKSignature getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
