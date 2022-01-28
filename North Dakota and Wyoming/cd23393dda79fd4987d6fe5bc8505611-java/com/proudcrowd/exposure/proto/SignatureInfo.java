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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class SignatureInfo extends GeneratedMessageV3 implements SignatureInfoOrBuilder {
    private static final SignatureInfo DEFAULT_INSTANCE = new SignatureInfo();
    @Deprecated
    public static final Parser<SignatureInfo> PARSER = new AbstractParser<SignatureInfo>() {
        /* class com.proudcrowd.exposure.proto.SignatureInfo.AnonymousClass1 */

        @Override // com.google.protobuf.Parser
        public SignatureInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new SignatureInfo(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int SIGNATURE_ALGORITHM_FIELD_NUMBER = 5;
    public static final int VERIFICATION_KEY_ID_FIELD_NUMBER = 4;
    public static final int VERIFICATION_KEY_VERSION_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private volatile Object signatureAlgorithm_;
    private volatile Object verificationKeyId_;
    private volatile Object verificationKeyVersion_;

    private SignatureInfo(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private SignatureInfo() {
        this.memoizedIsInitialized = -1;
        this.verificationKeyVersion_ = "";
        this.verificationKeyId_ = "";
        this.signatureAlgorithm_ = "";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new SignatureInfo();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private SignatureInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag == 26) {
                        ByteString readBytes = codedInputStream.readBytes();
                        this.bitField0_ = 1 | this.bitField0_;
                        this.verificationKeyVersion_ = readBytes;
                    } else if (readTag == 34) {
                        ByteString readBytes2 = codedInputStream.readBytes();
                        this.bitField0_ |= 2;
                        this.verificationKeyId_ = readBytes2;
                    } else if (readTag == 42) {
                        ByteString readBytes3 = codedInputStream.readBytes();
                        this.bitField0_ |= 4;
                        this.signatureAlgorithm_ = readBytes3;
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
        return KeyFile.internal_static_com_proudcrowd_exposure_debug_SignatureInfo_descriptor;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return KeyFile.internal_static_com_proudcrowd_exposure_debug_SignatureInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SignatureInfo.class, Builder.class);
    }

    @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
    public boolean hasVerificationKeyVersion() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
    public String getVerificationKeyVersion() {
        Object obj = this.verificationKeyVersion_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.verificationKeyVersion_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
    public ByteString getVerificationKeyVersionBytes() {
        Object obj = this.verificationKeyVersion_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.verificationKeyVersion_ = copyFromUtf8;
        return copyFromUtf8;
    }

    @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
    public boolean hasVerificationKeyId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
    public String getVerificationKeyId() {
        Object obj = this.verificationKeyId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.verificationKeyId_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
    public ByteString getVerificationKeyIdBytes() {
        Object obj = this.verificationKeyId_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.verificationKeyId_ = copyFromUtf8;
        return copyFromUtf8;
    }

    @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
    public boolean hasSignatureAlgorithm() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
    public String getSignatureAlgorithm() {
        Object obj = this.signatureAlgorithm_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.signatureAlgorithm_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
    public ByteString getSignatureAlgorithmBytes() {
        Object obj = this.signatureAlgorithm_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.signatureAlgorithm_ = copyFromUtf8;
        return copyFromUtf8;
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
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.verificationKeyVersion_);
        }
        if ((this.bitField0_ & 2) != 0) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.verificationKeyId_);
        }
        if ((this.bitField0_ & 4) != 0) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.signatureAlgorithm_);
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
            i2 = 0 + GeneratedMessageV3.computeStringSize(3, this.verificationKeyVersion_);
        }
        if ((this.bitField0_ & 2) != 0) {
            i2 += GeneratedMessageV3.computeStringSize(4, this.verificationKeyId_);
        }
        if ((this.bitField0_ & 4) != 0) {
            i2 += GeneratedMessageV3.computeStringSize(5, this.signatureAlgorithm_);
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
        if (!(obj instanceof SignatureInfo)) {
            return super.equals(obj);
        }
        SignatureInfo signatureInfo = (SignatureInfo) obj;
        if (hasVerificationKeyVersion() != signatureInfo.hasVerificationKeyVersion()) {
            return false;
        }
        if ((hasVerificationKeyVersion() && !getVerificationKeyVersion().equals(signatureInfo.getVerificationKeyVersion())) || hasVerificationKeyId() != signatureInfo.hasVerificationKeyId()) {
            return false;
        }
        if ((hasVerificationKeyId() && !getVerificationKeyId().equals(signatureInfo.getVerificationKeyId())) || hasSignatureAlgorithm() != signatureInfo.hasSignatureAlgorithm()) {
            return false;
        }
        if ((!hasSignatureAlgorithm() || getSignatureAlgorithm().equals(signatureInfo.getSignatureAlgorithm())) && this.unknownFields.equals(signatureInfo.unknownFields)) {
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
        if (hasVerificationKeyVersion()) {
            hashCode = (((hashCode * 37) + 3) * 53) + getVerificationKeyVersion().hashCode();
        }
        if (hasVerificationKeyId()) {
            hashCode = (((hashCode * 37) + 4) * 53) + getVerificationKeyId().hashCode();
        }
        if (hasSignatureAlgorithm()) {
            hashCode = (((hashCode * 37) + 5) * 53) + getSignatureAlgorithm().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public static SignatureInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static SignatureInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static SignatureInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static SignatureInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static SignatureInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static SignatureInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static SignatureInfo parseFrom(InputStream inputStream) throws IOException {
        return (SignatureInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static SignatureInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SignatureInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static SignatureInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SignatureInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static SignatureInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SignatureInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static SignatureInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SignatureInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static SignatureInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SignatureInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(SignatureInfo signatureInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(signatureInfo);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SignatureInfoOrBuilder {
        private int bitField0_;
        private Object signatureAlgorithm_;
        private Object verificationKeyId_;
        private Object verificationKeyVersion_;

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.GeneratedMessageV3.Builder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return KeyFile.internal_static_com_proudcrowd_exposure_debug_SignatureInfo_descriptor;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return KeyFile.internal_static_com_proudcrowd_exposure_debug_SignatureInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SignatureInfo.class, Builder.class);
        }

        private Builder() {
            this.verificationKeyVersion_ = "";
            this.verificationKeyId_ = "";
            this.signatureAlgorithm_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.verificationKeyVersion_ = "";
            this.verificationKeyId_ = "";
            this.signatureAlgorithm_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = SignatureInfo.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder
        public Builder clear() {
            super.clear();
            this.verificationKeyVersion_ = "";
            int i = this.bitField0_ & -2;
            this.bitField0_ = i;
            this.verificationKeyId_ = "";
            int i2 = i & -3;
            this.bitField0_ = i2;
            this.signatureAlgorithm_ = "";
            this.bitField0_ = i2 & -5;
            return this;
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessageV3.Builder
        public Descriptors.Descriptor getDescriptorForType() {
            return KeyFile.internal_static_com_proudcrowd_exposure_debug_SignatureInfo_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SignatureInfo getDefaultInstanceForType() {
            return SignatureInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SignatureInfo build() {
            SignatureInfo buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SignatureInfo buildPartial() {
            SignatureInfo signatureInfo = new SignatureInfo(this);
            int i = this.bitField0_;
            int i2 = (i & 1) != 0 ? 1 : 0;
            signatureInfo.verificationKeyVersion_ = this.verificationKeyVersion_;
            if ((i & 2) != 0) {
                i2 |= 2;
            }
            signatureInfo.verificationKeyId_ = this.verificationKeyId_;
            if ((i & 4) != 0) {
                i2 |= 4;
            }
            signatureInfo.signatureAlgorithm_ = this.signatureAlgorithm_;
            signatureInfo.bitField0_ = i2;
            onBuilt();
            return signatureInfo;
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
            if (message instanceof SignatureInfo) {
                return mergeFrom((SignatureInfo) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(SignatureInfo signatureInfo) {
            if (signatureInfo == SignatureInfo.getDefaultInstance()) {
                return this;
            }
            if (signatureInfo.hasVerificationKeyVersion()) {
                this.bitField0_ |= 1;
                this.verificationKeyVersion_ = signatureInfo.verificationKeyVersion_;
                onChanged();
            }
            if (signatureInfo.hasVerificationKeyId()) {
                this.bitField0_ |= 2;
                this.verificationKeyId_ = signatureInfo.verificationKeyId_;
                onChanged();
            }
            if (signatureInfo.hasSignatureAlgorithm()) {
                this.bitField0_ |= 4;
                this.signatureAlgorithm_ = signatureInfo.signatureAlgorithm_;
                onChanged();
            }
            mergeUnknownFields(signatureInfo.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Throwable th;
            SignatureInfo signatureInfo;
            SignatureInfo signatureInfo2 = null;
            try {
                SignatureInfo parsePartialFrom = SignatureInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                signatureInfo = (SignatureInfo) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } catch (Throwable th2) {
                th = th2;
                signatureInfo2 = signatureInfo;
                if (signatureInfo2 != null) {
                }
                throw th;
            }
        }

        @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
        public boolean hasVerificationKeyVersion() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
        public String getVerificationKeyVersion() {
            Object obj = this.verificationKeyVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.verificationKeyVersion_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
        public ByteString getVerificationKeyVersionBytes() {
            Object obj = this.verificationKeyVersion_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.verificationKeyVersion_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Builder setVerificationKeyVersion(String str) {
            Objects.requireNonNull(str);
            this.bitField0_ |= 1;
            this.verificationKeyVersion_ = str;
            onChanged();
            return this;
        }

        public Builder clearVerificationKeyVersion() {
            this.bitField0_ &= -2;
            this.verificationKeyVersion_ = SignatureInfo.getDefaultInstance().getVerificationKeyVersion();
            onChanged();
            return this;
        }

        public Builder setVerificationKeyVersionBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            this.bitField0_ |= 1;
            this.verificationKeyVersion_ = byteString;
            onChanged();
            return this;
        }

        @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
        public boolean hasVerificationKeyId() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
        public String getVerificationKeyId() {
            Object obj = this.verificationKeyId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.verificationKeyId_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
        public ByteString getVerificationKeyIdBytes() {
            Object obj = this.verificationKeyId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.verificationKeyId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Builder setVerificationKeyId(String str) {
            Objects.requireNonNull(str);
            this.bitField0_ |= 2;
            this.verificationKeyId_ = str;
            onChanged();
            return this;
        }

        public Builder clearVerificationKeyId() {
            this.bitField0_ &= -3;
            this.verificationKeyId_ = SignatureInfo.getDefaultInstance().getVerificationKeyId();
            onChanged();
            return this;
        }

        public Builder setVerificationKeyIdBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            this.bitField0_ |= 2;
            this.verificationKeyId_ = byteString;
            onChanged();
            return this;
        }

        @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
        public boolean hasSignatureAlgorithm() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
        public String getSignatureAlgorithm() {
            Object obj = this.signatureAlgorithm_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.signatureAlgorithm_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.proudcrowd.exposure.proto.SignatureInfoOrBuilder
        public ByteString getSignatureAlgorithmBytes() {
            Object obj = this.signatureAlgorithm_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.signatureAlgorithm_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Builder setSignatureAlgorithm(String str) {
            Objects.requireNonNull(str);
            this.bitField0_ |= 4;
            this.signatureAlgorithm_ = str;
            onChanged();
            return this;
        }

        public Builder clearSignatureAlgorithm() {
            this.bitField0_ &= -5;
            this.signatureAlgorithm_ = SignatureInfo.getDefaultInstance().getSignatureAlgorithm();
            onChanged();
            return this;
        }

        public Builder setSignatureAlgorithmBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            this.bitField0_ |= 4;
            this.signatureAlgorithm_ = byteString;
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

    public static SignatureInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<SignatureInfo> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message, com.google.protobuf.GeneratedMessageV3
    public Parser<SignatureInfo> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public SignatureInfo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
