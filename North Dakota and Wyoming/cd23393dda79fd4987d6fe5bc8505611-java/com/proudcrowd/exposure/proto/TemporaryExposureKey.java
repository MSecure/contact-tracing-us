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

public final class TemporaryExposureKey extends GeneratedMessageV3 implements TemporaryExposureKeyOrBuilder {
    private static final TemporaryExposureKey DEFAULT_INSTANCE = new TemporaryExposureKey();
    public static final int KEY_DATA_FIELD_NUMBER = 1;
    @Deprecated
    public static final Parser<TemporaryExposureKey> PARSER = new AbstractParser<TemporaryExposureKey>() {
        /* class com.proudcrowd.exposure.proto.TemporaryExposureKey.AnonymousClass1 */

        @Override // com.google.protobuf.Parser
        public TemporaryExposureKey parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new TemporaryExposureKey(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int ROLLING_PERIOD_FIELD_NUMBER = 4;
    public static final int ROLLING_START_INTERVAL_NUMBER_FIELD_NUMBER = 3;
    public static final int TRANSMISSION_RISK_LEVEL_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private ByteString keyData_;
    private byte memoizedIsInitialized;
    private int rollingPeriod_;
    private int rollingStartIntervalNumber_;
    private int transmissionRiskLevel_;

    private TemporaryExposureKey(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private TemporaryExposureKey() {
        this.memoizedIsInitialized = -1;
        this.keyData_ = ByteString.EMPTY;
        this.rollingPeriod_ = 144;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new TemporaryExposureKey();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private TemporaryExposureKey(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag == 10) {
                        this.bitField0_ |= 1;
                        this.keyData_ = codedInputStream.readBytes();
                    } else if (readTag == 16) {
                        this.bitField0_ |= 2;
                        this.transmissionRiskLevel_ = codedInputStream.readInt32();
                    } else if (readTag == 24) {
                        this.bitField0_ |= 4;
                        this.rollingStartIntervalNumber_ = codedInputStream.readInt32();
                    } else if (readTag == 32) {
                        this.bitField0_ |= 8;
                        this.rollingPeriod_ = codedInputStream.readInt32();
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
        return KeyFile.internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKey_descriptor;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return KeyFile.internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKey_fieldAccessorTable.ensureFieldAccessorsInitialized(TemporaryExposureKey.class, Builder.class);
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
    public boolean hasKeyData() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
    public ByteString getKeyData() {
        return this.keyData_;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
    public boolean hasTransmissionRiskLevel() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
    public int getTransmissionRiskLevel() {
        return this.transmissionRiskLevel_;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
    public boolean hasRollingStartIntervalNumber() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
    public int getRollingStartIntervalNumber() {
        return this.rollingStartIntervalNumber_;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
    public boolean hasRollingPeriod() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
    public int getRollingPeriod() {
        return this.rollingPeriod_;
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
            codedOutputStream.writeBytes(1, this.keyData_);
        }
        if ((this.bitField0_ & 2) != 0) {
            codedOutputStream.writeInt32(2, this.transmissionRiskLevel_);
        }
        if ((this.bitField0_ & 4) != 0) {
            codedOutputStream.writeInt32(3, this.rollingStartIntervalNumber_);
        }
        if ((this.bitField0_ & 8) != 0) {
            codedOutputStream.writeInt32(4, this.rollingPeriod_);
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
            i2 = 0 + CodedOutputStream.computeBytesSize(1, this.keyData_);
        }
        if ((this.bitField0_ & 2) != 0) {
            i2 += CodedOutputStream.computeInt32Size(2, this.transmissionRiskLevel_);
        }
        if ((this.bitField0_ & 4) != 0) {
            i2 += CodedOutputStream.computeInt32Size(3, this.rollingStartIntervalNumber_);
        }
        if ((this.bitField0_ & 8) != 0) {
            i2 += CodedOutputStream.computeInt32Size(4, this.rollingPeriod_);
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
        if (!(obj instanceof TemporaryExposureKey)) {
            return super.equals(obj);
        }
        TemporaryExposureKey temporaryExposureKey = (TemporaryExposureKey) obj;
        if (hasKeyData() != temporaryExposureKey.hasKeyData()) {
            return false;
        }
        if ((hasKeyData() && !getKeyData().equals(temporaryExposureKey.getKeyData())) || hasTransmissionRiskLevel() != temporaryExposureKey.hasTransmissionRiskLevel()) {
            return false;
        }
        if ((hasTransmissionRiskLevel() && getTransmissionRiskLevel() != temporaryExposureKey.getTransmissionRiskLevel()) || hasRollingStartIntervalNumber() != temporaryExposureKey.hasRollingStartIntervalNumber()) {
            return false;
        }
        if ((hasRollingStartIntervalNumber() && getRollingStartIntervalNumber() != temporaryExposureKey.getRollingStartIntervalNumber()) || hasRollingPeriod() != temporaryExposureKey.hasRollingPeriod()) {
            return false;
        }
        if ((!hasRollingPeriod() || getRollingPeriod() == temporaryExposureKey.getRollingPeriod()) && this.unknownFields.equals(temporaryExposureKey.unknownFields)) {
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
        if (hasKeyData()) {
            hashCode = (((hashCode * 37) + 1) * 53) + getKeyData().hashCode();
        }
        if (hasTransmissionRiskLevel()) {
            hashCode = (((hashCode * 37) + 2) * 53) + getTransmissionRiskLevel();
        }
        if (hasRollingStartIntervalNumber()) {
            hashCode = (((hashCode * 37) + 3) * 53) + getRollingStartIntervalNumber();
        }
        if (hasRollingPeriod()) {
            hashCode = (((hashCode * 37) + 4) * 53) + getRollingPeriod();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public static TemporaryExposureKey parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static TemporaryExposureKey parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static TemporaryExposureKey parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static TemporaryExposureKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static TemporaryExposureKey parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static TemporaryExposureKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static TemporaryExposureKey parseFrom(InputStream inputStream) throws IOException {
        return (TemporaryExposureKey) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static TemporaryExposureKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TemporaryExposureKey) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TemporaryExposureKey parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TemporaryExposureKey) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static TemporaryExposureKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TemporaryExposureKey) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TemporaryExposureKey parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TemporaryExposureKey) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static TemporaryExposureKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TemporaryExposureKey) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TemporaryExposureKey temporaryExposureKey) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(temporaryExposureKey);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TemporaryExposureKeyOrBuilder {
        private int bitField0_;
        private ByteString keyData_;
        private int rollingPeriod_;
        private int rollingStartIntervalNumber_;
        private int transmissionRiskLevel_;

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.GeneratedMessageV3.Builder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return KeyFile.internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKey_descriptor;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return KeyFile.internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKey_fieldAccessorTable.ensureFieldAccessorsInitialized(TemporaryExposureKey.class, Builder.class);
        }

        private Builder() {
            this.keyData_ = ByteString.EMPTY;
            this.rollingPeriod_ = 144;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.keyData_ = ByteString.EMPTY;
            this.rollingPeriod_ = 144;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = TemporaryExposureKey.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder
        public Builder clear() {
            super.clear();
            this.keyData_ = ByteString.EMPTY;
            int i = this.bitField0_ & -2;
            this.bitField0_ = i;
            this.transmissionRiskLevel_ = 0;
            int i2 = i & -3;
            this.bitField0_ = i2;
            this.rollingStartIntervalNumber_ = 0;
            int i3 = i2 & -5;
            this.bitField0_ = i3;
            this.rollingPeriod_ = 144;
            this.bitField0_ = i3 & -9;
            return this;
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessageV3.Builder
        public Descriptors.Descriptor getDescriptorForType() {
            return KeyFile.internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKey_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TemporaryExposureKey getDefaultInstanceForType() {
            return TemporaryExposureKey.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TemporaryExposureKey build() {
            TemporaryExposureKey buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TemporaryExposureKey buildPartial() {
            TemporaryExposureKey temporaryExposureKey = new TemporaryExposureKey(this);
            int i = this.bitField0_;
            int i2 = (i & 1) != 0 ? 1 : 0;
            temporaryExposureKey.keyData_ = this.keyData_;
            if ((i & 2) != 0) {
                temporaryExposureKey.transmissionRiskLevel_ = this.transmissionRiskLevel_;
                i2 |= 2;
            }
            if ((i & 4) != 0) {
                temporaryExposureKey.rollingStartIntervalNumber_ = this.rollingStartIntervalNumber_;
                i2 |= 4;
            }
            if ((i & 8) != 0) {
                i2 |= 8;
            }
            temporaryExposureKey.rollingPeriod_ = this.rollingPeriod_;
            temporaryExposureKey.bitField0_ = i2;
            onBuilt();
            return temporaryExposureKey;
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
            if (message instanceof TemporaryExposureKey) {
                return mergeFrom((TemporaryExposureKey) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(TemporaryExposureKey temporaryExposureKey) {
            if (temporaryExposureKey == TemporaryExposureKey.getDefaultInstance()) {
                return this;
            }
            if (temporaryExposureKey.hasKeyData()) {
                setKeyData(temporaryExposureKey.getKeyData());
            }
            if (temporaryExposureKey.hasTransmissionRiskLevel()) {
                setTransmissionRiskLevel(temporaryExposureKey.getTransmissionRiskLevel());
            }
            if (temporaryExposureKey.hasRollingStartIntervalNumber()) {
                setRollingStartIntervalNumber(temporaryExposureKey.getRollingStartIntervalNumber());
            }
            if (temporaryExposureKey.hasRollingPeriod()) {
                setRollingPeriod(temporaryExposureKey.getRollingPeriod());
            }
            mergeUnknownFields(temporaryExposureKey.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Throwable th;
            TemporaryExposureKey temporaryExposureKey;
            TemporaryExposureKey temporaryExposureKey2 = null;
            try {
                TemporaryExposureKey parsePartialFrom = TemporaryExposureKey.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                temporaryExposureKey = (TemporaryExposureKey) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } catch (Throwable th2) {
                th = th2;
                temporaryExposureKey2 = temporaryExposureKey;
                if (temporaryExposureKey2 != null) {
                }
                throw th;
            }
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
        public boolean hasKeyData() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
        public ByteString getKeyData() {
            return this.keyData_;
        }

        public Builder setKeyData(ByteString byteString) {
            Objects.requireNonNull(byteString);
            this.bitField0_ |= 1;
            this.keyData_ = byteString;
            onChanged();
            return this;
        }

        public Builder clearKeyData() {
            this.bitField0_ &= -2;
            this.keyData_ = TemporaryExposureKey.getDefaultInstance().getKeyData();
            onChanged();
            return this;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
        public boolean hasTransmissionRiskLevel() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
        public int getTransmissionRiskLevel() {
            return this.transmissionRiskLevel_;
        }

        public Builder setTransmissionRiskLevel(int i) {
            this.bitField0_ |= 2;
            this.transmissionRiskLevel_ = i;
            onChanged();
            return this;
        }

        public Builder clearTransmissionRiskLevel() {
            this.bitField0_ &= -3;
            this.transmissionRiskLevel_ = 0;
            onChanged();
            return this;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
        public boolean hasRollingStartIntervalNumber() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
        public int getRollingStartIntervalNumber() {
            return this.rollingStartIntervalNumber_;
        }

        public Builder setRollingStartIntervalNumber(int i) {
            this.bitField0_ |= 4;
            this.rollingStartIntervalNumber_ = i;
            onChanged();
            return this;
        }

        public Builder clearRollingStartIntervalNumber() {
            this.bitField0_ &= -5;
            this.rollingStartIntervalNumber_ = 0;
            onChanged();
            return this;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
        public boolean hasRollingPeriod() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyOrBuilder
        public int getRollingPeriod() {
            return this.rollingPeriod_;
        }

        public Builder setRollingPeriod(int i) {
            this.bitField0_ |= 8;
            this.rollingPeriod_ = i;
            onChanged();
            return this;
        }

        public Builder clearRollingPeriod() {
            this.bitField0_ &= -9;
            this.rollingPeriod_ = 144;
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

    public static TemporaryExposureKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<TemporaryExposureKey> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message, com.google.protobuf.GeneratedMessageV3
    public Parser<TemporaryExposureKey> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public TemporaryExposureKey getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
