package com.proudcrowd.exposure.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.proudcrowd.exposure.proto.SignatureInfo;
import com.proudcrowd.exposure.proto.TemporaryExposureKey;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class TemporaryExposureKeyExport extends GeneratedMessageV3 implements TemporaryExposureKeyExportOrBuilder {
    public static final int BATCH_NUM_FIELD_NUMBER = 4;
    public static final int BATCH_SIZE_FIELD_NUMBER = 5;
    private static final TemporaryExposureKeyExport DEFAULT_INSTANCE = new TemporaryExposureKeyExport();
    public static final int END_TIMESTAMP_FIELD_NUMBER = 2;
    public static final int KEYS_FIELD_NUMBER = 7;
    @Deprecated
    public static final Parser<TemporaryExposureKeyExport> PARSER = new AbstractParser<TemporaryExposureKeyExport>() {
        /* class com.proudcrowd.exposure.proto.TemporaryExposureKeyExport.AnonymousClass1 */

        @Override // com.google.protobuf.Parser
        public TemporaryExposureKeyExport parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new TemporaryExposureKeyExport(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int REGION_FIELD_NUMBER = 3;
    public static final int SIGNATURE_INFOS_FIELD_NUMBER = 6;
    public static final int START_TIMESTAMP_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int batchNum_;
    private int batchSize_;
    private int bitField0_;
    private long endTimestamp_;
    private List<TemporaryExposureKey> keys_;
    private byte memoizedIsInitialized;
    private volatile Object region_;
    private List<SignatureInfo> signatureInfos_;
    private long startTimestamp_;

    private TemporaryExposureKeyExport(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private TemporaryExposureKeyExport() {
        this.memoizedIsInitialized = -1;
        this.region_ = "";
        this.signatureInfos_ = Collections.emptyList();
        this.keys_ = Collections.emptyList();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new TemporaryExposureKeyExport();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v15, resolved type: java.util.List<com.proudcrowd.exposure.proto.SignatureInfo> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v18, resolved type: java.util.List<com.proudcrowd.exposure.proto.TemporaryExposureKey> */
    /* JADX WARN: Multi-variable type inference failed */
    private TemporaryExposureKeyExport(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag == 9) {
                        this.bitField0_ |= 1;
                        this.startTimestamp_ = codedInputStream.readFixed64();
                    } else if (readTag == 17) {
                        this.bitField0_ |= 2;
                        this.endTimestamp_ = codedInputStream.readFixed64();
                    } else if (readTag == 26) {
                        ByteString readBytes = codedInputStream.readBytes();
                        this.bitField0_ |= 4;
                        this.region_ = readBytes;
                    } else if (readTag == 32) {
                        this.bitField0_ |= 8;
                        this.batchNum_ = codedInputStream.readInt32();
                    } else if (readTag == 40) {
                        this.bitField0_ |= 16;
                        this.batchSize_ = codedInputStream.readInt32();
                    } else if (readTag == 50) {
                        if (!z2 || !true) {
                            this.signatureInfos_ = new ArrayList();
                            z2 |= true;
                        }
                        this.signatureInfos_.add(codedInputStream.readMessage(SignatureInfo.PARSER, extensionRegistryLite));
                    } else if (readTag == 58) {
                        if (!z2 || !true) {
                            this.keys_ = new ArrayList();
                            z2 |= true;
                        }
                        this.keys_.add(codedInputStream.readMessage(TemporaryExposureKey.PARSER, extensionRegistryLite));
                    } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                    }
                }
                z = true;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
            } catch (Throwable th) {
                if (z2 && true) {
                    this.signatureInfos_ = Collections.unmodifiableList(this.signatureInfos_);
                }
                if (z2 && true) {
                    this.keys_ = Collections.unmodifiableList(this.keys_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 && true) {
            this.signatureInfos_ = Collections.unmodifiableList(this.signatureInfos_);
        }
        if (z2 && true) {
            this.keys_ = Collections.unmodifiableList(this.keys_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return KeyFile.internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKeyExport_descriptor;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return KeyFile.internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKeyExport_fieldAccessorTable.ensureFieldAccessorsInitialized(TemporaryExposureKeyExport.class, Builder.class);
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public boolean hasStartTimestamp() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public long getStartTimestamp() {
        return this.startTimestamp_;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public boolean hasEndTimestamp() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public long getEndTimestamp() {
        return this.endTimestamp_;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public boolean hasRegion() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public String getRegion() {
        Object obj = this.region_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.region_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public ByteString getRegionBytes() {
        Object obj = this.region_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.region_ = copyFromUtf8;
        return copyFromUtf8;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public boolean hasBatchNum() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public int getBatchNum() {
        return this.batchNum_;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public boolean hasBatchSize() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public int getBatchSize() {
        return this.batchSize_;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public List<SignatureInfo> getSignatureInfosList() {
        return this.signatureInfos_;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public List<? extends SignatureInfoOrBuilder> getSignatureInfosOrBuilderList() {
        return this.signatureInfos_;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public int getSignatureInfosCount() {
        return this.signatureInfos_.size();
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public SignatureInfo getSignatureInfos(int i) {
        return this.signatureInfos_.get(i);
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public SignatureInfoOrBuilder getSignatureInfosOrBuilder(int i) {
        return this.signatureInfos_.get(i);
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public List<TemporaryExposureKey> getKeysList() {
        return this.keys_;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public List<? extends TemporaryExposureKeyOrBuilder> getKeysOrBuilderList() {
        return this.keys_;
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public int getKeysCount() {
        return this.keys_.size();
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public TemporaryExposureKey getKeys(int i) {
        return this.keys_.get(i);
    }

    @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
    public TemporaryExposureKeyOrBuilder getKeysOrBuilder(int i) {
        return this.keys_.get(i);
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
            codedOutputStream.writeFixed64(1, this.startTimestamp_);
        }
        if ((this.bitField0_ & 2) != 0) {
            codedOutputStream.writeFixed64(2, this.endTimestamp_);
        }
        if ((this.bitField0_ & 4) != 0) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.region_);
        }
        if ((this.bitField0_ & 8) != 0) {
            codedOutputStream.writeInt32(4, this.batchNum_);
        }
        if ((this.bitField0_ & 16) != 0) {
            codedOutputStream.writeInt32(5, this.batchSize_);
        }
        for (int i = 0; i < this.signatureInfos_.size(); i++) {
            codedOutputStream.writeMessage(6, this.signatureInfos_.get(i));
        }
        for (int i2 = 0; i2 < this.keys_.size(); i2++) {
            codedOutputStream.writeMessage(7, this.keys_.get(i2));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.AbstractMessage, com.google.protobuf.GeneratedMessageV3
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeFixed64Size = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeFixed64Size(1, this.startTimestamp_) + 0 : 0;
        if ((this.bitField0_ & 2) != 0) {
            computeFixed64Size += CodedOutputStream.computeFixed64Size(2, this.endTimestamp_);
        }
        if ((this.bitField0_ & 4) != 0) {
            computeFixed64Size += GeneratedMessageV3.computeStringSize(3, this.region_);
        }
        if ((this.bitField0_ & 8) != 0) {
            computeFixed64Size += CodedOutputStream.computeInt32Size(4, this.batchNum_);
        }
        if ((this.bitField0_ & 16) != 0) {
            computeFixed64Size += CodedOutputStream.computeInt32Size(5, this.batchSize_);
        }
        for (int i2 = 0; i2 < this.signatureInfos_.size(); i2++) {
            computeFixed64Size += CodedOutputStream.computeMessageSize(6, this.signatureInfos_.get(i2));
        }
        for (int i3 = 0; i3 < this.keys_.size(); i3++) {
            computeFixed64Size += CodedOutputStream.computeMessageSize(7, this.keys_.get(i3));
        }
        int serializedSize = computeFixed64Size + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TemporaryExposureKeyExport)) {
            return super.equals(obj);
        }
        TemporaryExposureKeyExport temporaryExposureKeyExport = (TemporaryExposureKeyExport) obj;
        if (hasStartTimestamp() != temporaryExposureKeyExport.hasStartTimestamp()) {
            return false;
        }
        if ((hasStartTimestamp() && getStartTimestamp() != temporaryExposureKeyExport.getStartTimestamp()) || hasEndTimestamp() != temporaryExposureKeyExport.hasEndTimestamp()) {
            return false;
        }
        if ((hasEndTimestamp() && getEndTimestamp() != temporaryExposureKeyExport.getEndTimestamp()) || hasRegion() != temporaryExposureKeyExport.hasRegion()) {
            return false;
        }
        if ((hasRegion() && !getRegion().equals(temporaryExposureKeyExport.getRegion())) || hasBatchNum() != temporaryExposureKeyExport.hasBatchNum()) {
            return false;
        }
        if ((hasBatchNum() && getBatchNum() != temporaryExposureKeyExport.getBatchNum()) || hasBatchSize() != temporaryExposureKeyExport.hasBatchSize()) {
            return false;
        }
        if ((!hasBatchSize() || getBatchSize() == temporaryExposureKeyExport.getBatchSize()) && getSignatureInfosList().equals(temporaryExposureKeyExport.getSignatureInfosList()) && getKeysList().equals(temporaryExposureKeyExport.getKeysList()) && this.unknownFields.equals(temporaryExposureKeyExport.unknownFields)) {
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
        if (hasStartTimestamp()) {
            hashCode = (((hashCode * 37) + 1) * 53) + Internal.hashLong(getStartTimestamp());
        }
        if (hasEndTimestamp()) {
            hashCode = (((hashCode * 37) + 2) * 53) + Internal.hashLong(getEndTimestamp());
        }
        if (hasRegion()) {
            hashCode = (((hashCode * 37) + 3) * 53) + getRegion().hashCode();
        }
        if (hasBatchNum()) {
            hashCode = (((hashCode * 37) + 4) * 53) + getBatchNum();
        }
        if (hasBatchSize()) {
            hashCode = (((hashCode * 37) + 5) * 53) + getBatchSize();
        }
        if (getSignatureInfosCount() > 0) {
            hashCode = (((hashCode * 37) + 6) * 53) + getSignatureInfosList().hashCode();
        }
        if (getKeysCount() > 0) {
            hashCode = (((hashCode * 37) + 7) * 53) + getKeysList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public static TemporaryExposureKeyExport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static TemporaryExposureKeyExport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static TemporaryExposureKeyExport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static TemporaryExposureKeyExport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static TemporaryExposureKeyExport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static TemporaryExposureKeyExport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static TemporaryExposureKeyExport parseFrom(InputStream inputStream) throws IOException {
        return (TemporaryExposureKeyExport) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static TemporaryExposureKeyExport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TemporaryExposureKeyExport) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TemporaryExposureKeyExport parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TemporaryExposureKeyExport) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static TemporaryExposureKeyExport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TemporaryExposureKeyExport) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TemporaryExposureKeyExport parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TemporaryExposureKeyExport) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static TemporaryExposureKeyExport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TemporaryExposureKeyExport) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TemporaryExposureKeyExport temporaryExposureKeyExport) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(temporaryExposureKeyExport);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TemporaryExposureKeyExportOrBuilder {
        private int batchNum_;
        private int batchSize_;
        private int bitField0_;
        private long endTimestamp_;
        private RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> keysBuilder_;
        private List<TemporaryExposureKey> keys_;
        private Object region_;
        private RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> signatureInfosBuilder_;
        private List<SignatureInfo> signatureInfos_;
        private long startTimestamp_;

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.GeneratedMessageV3.Builder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return KeyFile.internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKeyExport_descriptor;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return KeyFile.internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKeyExport_fieldAccessorTable.ensureFieldAccessorsInitialized(TemporaryExposureKeyExport.class, Builder.class);
        }

        private Builder() {
            this.region_ = "";
            this.signatureInfos_ = Collections.emptyList();
            this.keys_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.region_ = "";
            this.signatureInfos_ = Collections.emptyList();
            this.keys_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (TemporaryExposureKeyExport.alwaysUseFieldBuilders) {
                getSignatureInfosFieldBuilder();
                getKeysFieldBuilder();
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder
        public Builder clear() {
            super.clear();
            this.startTimestamp_ = 0;
            int i = this.bitField0_ & -2;
            this.bitField0_ = i;
            this.endTimestamp_ = 0;
            int i2 = i & -3;
            this.bitField0_ = i2;
            this.region_ = "";
            int i3 = i2 & -5;
            this.bitField0_ = i3;
            this.batchNum_ = 0;
            int i4 = i3 & -9;
            this.bitField0_ = i4;
            this.batchSize_ = 0;
            this.bitField0_ = i4 & -17;
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.signatureInfos_ = Collections.emptyList();
                this.bitField0_ &= -33;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV32 = this.keysBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                this.keys_ = Collections.emptyList();
                this.bitField0_ &= -65;
            } else {
                repeatedFieldBuilderV32.clear();
            }
            return this;
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessageV3.Builder
        public Descriptors.Descriptor getDescriptorForType() {
            return KeyFile.internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKeyExport_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TemporaryExposureKeyExport getDefaultInstanceForType() {
            return TemporaryExposureKeyExport.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TemporaryExposureKeyExport build() {
            TemporaryExposureKeyExport buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TemporaryExposureKeyExport buildPartial() {
            int i;
            TemporaryExposureKeyExport temporaryExposureKeyExport = new TemporaryExposureKeyExport(this);
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                temporaryExposureKeyExport.startTimestamp_ = this.startTimestamp_;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 2) != 0) {
                temporaryExposureKeyExport.endTimestamp_ = this.endTimestamp_;
                i |= 2;
            }
            if ((i2 & 4) != 0) {
                i |= 4;
            }
            temporaryExposureKeyExport.region_ = this.region_;
            if ((i2 & 8) != 0) {
                temporaryExposureKeyExport.batchNum_ = this.batchNum_;
                i |= 8;
            }
            if ((i2 & 16) != 0) {
                temporaryExposureKeyExport.batchSize_ = this.batchSize_;
                i |= 16;
            }
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 32) != 0) {
                    this.signatureInfos_ = Collections.unmodifiableList(this.signatureInfos_);
                    this.bitField0_ &= -33;
                }
                temporaryExposureKeyExport.signatureInfos_ = this.signatureInfos_;
            } else {
                temporaryExposureKeyExport.signatureInfos_ = repeatedFieldBuilderV3.build();
            }
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV32 = this.keysBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                if ((this.bitField0_ & 64) != 0) {
                    this.keys_ = Collections.unmodifiableList(this.keys_);
                    this.bitField0_ &= -65;
                }
                temporaryExposureKeyExport.keys_ = this.keys_;
            } else {
                temporaryExposureKeyExport.keys_ = repeatedFieldBuilderV32.build();
            }
            temporaryExposureKeyExport.bitField0_ = i;
            onBuilt();
            return temporaryExposureKeyExport;
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
            if (message instanceof TemporaryExposureKeyExport) {
                return mergeFrom((TemporaryExposureKeyExport) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(TemporaryExposureKeyExport temporaryExposureKeyExport) {
            if (temporaryExposureKeyExport == TemporaryExposureKeyExport.getDefaultInstance()) {
                return this;
            }
            if (temporaryExposureKeyExport.hasStartTimestamp()) {
                setStartTimestamp(temporaryExposureKeyExport.getStartTimestamp());
            }
            if (temporaryExposureKeyExport.hasEndTimestamp()) {
                setEndTimestamp(temporaryExposureKeyExport.getEndTimestamp());
            }
            if (temporaryExposureKeyExport.hasRegion()) {
                this.bitField0_ |= 4;
                this.region_ = temporaryExposureKeyExport.region_;
                onChanged();
            }
            if (temporaryExposureKeyExport.hasBatchNum()) {
                setBatchNum(temporaryExposureKeyExport.getBatchNum());
            }
            if (temporaryExposureKeyExport.hasBatchSize()) {
                setBatchSize(temporaryExposureKeyExport.getBatchSize());
            }
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV3 = null;
            if (this.signatureInfosBuilder_ == null) {
                if (!temporaryExposureKeyExport.signatureInfos_.isEmpty()) {
                    if (this.signatureInfos_.isEmpty()) {
                        this.signatureInfos_ = temporaryExposureKeyExport.signatureInfos_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureSignatureInfosIsMutable();
                        this.signatureInfos_.addAll(temporaryExposureKeyExport.signatureInfos_);
                    }
                    onChanged();
                }
            } else if (!temporaryExposureKeyExport.signatureInfos_.isEmpty()) {
                if (this.signatureInfosBuilder_.isEmpty()) {
                    this.signatureInfosBuilder_.dispose();
                    this.signatureInfosBuilder_ = null;
                    this.signatureInfos_ = temporaryExposureKeyExport.signatureInfos_;
                    this.bitField0_ &= -33;
                    this.signatureInfosBuilder_ = TemporaryExposureKeyExport.alwaysUseFieldBuilders ? getSignatureInfosFieldBuilder() : null;
                } else {
                    this.signatureInfosBuilder_.addAllMessages(temporaryExposureKeyExport.signatureInfos_);
                }
            }
            if (this.keysBuilder_ == null) {
                if (!temporaryExposureKeyExport.keys_.isEmpty()) {
                    if (this.keys_.isEmpty()) {
                        this.keys_ = temporaryExposureKeyExport.keys_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureKeysIsMutable();
                        this.keys_.addAll(temporaryExposureKeyExport.keys_);
                    }
                    onChanged();
                }
            } else if (!temporaryExposureKeyExport.keys_.isEmpty()) {
                if (this.keysBuilder_.isEmpty()) {
                    this.keysBuilder_.dispose();
                    this.keysBuilder_ = null;
                    this.keys_ = temporaryExposureKeyExport.keys_;
                    this.bitField0_ &= -65;
                    if (TemporaryExposureKeyExport.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getKeysFieldBuilder();
                    }
                    this.keysBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.keysBuilder_.addAllMessages(temporaryExposureKeyExport.keys_);
                }
            }
            mergeUnknownFields(temporaryExposureKeyExport.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Throwable th;
            TemporaryExposureKeyExport temporaryExposureKeyExport;
            TemporaryExposureKeyExport temporaryExposureKeyExport2 = null;
            try {
                TemporaryExposureKeyExport parsePartialFrom = TemporaryExposureKeyExport.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                temporaryExposureKeyExport = (TemporaryExposureKeyExport) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } catch (Throwable th2) {
                th = th2;
                temporaryExposureKeyExport2 = temporaryExposureKeyExport;
                if (temporaryExposureKeyExport2 != null) {
                }
                throw th;
            }
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public boolean hasStartTimestamp() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public long getStartTimestamp() {
            return this.startTimestamp_;
        }

        public Builder setStartTimestamp(long j) {
            this.bitField0_ |= 1;
            this.startTimestamp_ = j;
            onChanged();
            return this;
        }

        public Builder clearStartTimestamp() {
            this.bitField0_ &= -2;
            this.startTimestamp_ = 0;
            onChanged();
            return this;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public boolean hasEndTimestamp() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public long getEndTimestamp() {
            return this.endTimestamp_;
        }

        public Builder setEndTimestamp(long j) {
            this.bitField0_ |= 2;
            this.endTimestamp_ = j;
            onChanged();
            return this;
        }

        public Builder clearEndTimestamp() {
            this.bitField0_ &= -3;
            this.endTimestamp_ = 0;
            onChanged();
            return this;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public boolean hasRegion() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public String getRegion() {
            Object obj = this.region_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.region_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public ByteString getRegionBytes() {
            Object obj = this.region_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.region_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Builder setRegion(String str) {
            Objects.requireNonNull(str);
            this.bitField0_ |= 4;
            this.region_ = str;
            onChanged();
            return this;
        }

        public Builder clearRegion() {
            this.bitField0_ &= -5;
            this.region_ = TemporaryExposureKeyExport.getDefaultInstance().getRegion();
            onChanged();
            return this;
        }

        public Builder setRegionBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            this.bitField0_ |= 4;
            this.region_ = byteString;
            onChanged();
            return this;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public boolean hasBatchNum() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public int getBatchNum() {
            return this.batchNum_;
        }

        public Builder setBatchNum(int i) {
            this.bitField0_ |= 8;
            this.batchNum_ = i;
            onChanged();
            return this;
        }

        public Builder clearBatchNum() {
            this.bitField0_ &= -9;
            this.batchNum_ = 0;
            onChanged();
            return this;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public boolean hasBatchSize() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public int getBatchSize() {
            return this.batchSize_;
        }

        public Builder setBatchSize(int i) {
            this.bitField0_ |= 16;
            this.batchSize_ = i;
            onChanged();
            return this;
        }

        public Builder clearBatchSize() {
            this.bitField0_ &= -17;
            this.batchSize_ = 0;
            onChanged();
            return this;
        }

        private void ensureSignatureInfosIsMutable() {
            if ((this.bitField0_ & 32) == 0) {
                this.signatureInfos_ = new ArrayList(this.signatureInfos_);
                this.bitField0_ |= 32;
            }
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public List<SignatureInfo> getSignatureInfosList() {
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.signatureInfos_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public int getSignatureInfosCount() {
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.signatureInfos_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public SignatureInfo getSignatureInfos(int i) {
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.signatureInfos_.get(i);
            }
            return repeatedFieldBuilderV3.getMessage(i);
        }

        public Builder setSignatureInfos(int i, SignatureInfo signatureInfo) {
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(signatureInfo);
                ensureSignatureInfosIsMutable();
                this.signatureInfos_.set(i, signatureInfo);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i, signatureInfo);
            }
            return this;
        }

        public Builder setSignatureInfos(int i, SignatureInfo.Builder builder) {
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureSignatureInfosIsMutable();
                this.signatureInfos_.set(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
            }
            return this;
        }

        public Builder addSignatureInfos(SignatureInfo signatureInfo) {
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(signatureInfo);
                ensureSignatureInfosIsMutable();
                this.signatureInfos_.add(signatureInfo);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(signatureInfo);
            }
            return this;
        }

        public Builder addSignatureInfos(int i, SignatureInfo signatureInfo) {
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(signatureInfo);
                ensureSignatureInfosIsMutable();
                this.signatureInfos_.add(i, signatureInfo);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i, signatureInfo);
            }
            return this;
        }

        public Builder addSignatureInfos(SignatureInfo.Builder builder) {
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureSignatureInfosIsMutable();
                this.signatureInfos_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addSignatureInfos(int i, SignatureInfo.Builder builder) {
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureSignatureInfosIsMutable();
                this.signatureInfos_.add(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
            }
            return this;
        }

        public Builder addAllSignatureInfos(Iterable<? extends SignatureInfo> iterable) {
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureSignatureInfosIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.signatureInfos_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder clearSignatureInfos() {
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.signatureInfos_ = Collections.emptyList();
                this.bitField0_ &= -33;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder removeSignatureInfos(int i) {
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureSignatureInfosIsMutable();
                this.signatureInfos_.remove(i);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i);
            }
            return this;
        }

        public SignatureInfo.Builder getSignatureInfosBuilder(int i) {
            return getSignatureInfosFieldBuilder().getBuilder(i);
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public SignatureInfoOrBuilder getSignatureInfosOrBuilder(int i) {
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.signatureInfos_.get(i);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public List<? extends SignatureInfoOrBuilder> getSignatureInfosOrBuilderList() {
            RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> repeatedFieldBuilderV3 = this.signatureInfosBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.signatureInfos_);
        }

        public SignatureInfo.Builder addSignatureInfosBuilder() {
            return getSignatureInfosFieldBuilder().addBuilder(SignatureInfo.getDefaultInstance());
        }

        public SignatureInfo.Builder addSignatureInfosBuilder(int i) {
            return getSignatureInfosFieldBuilder().addBuilder(i, SignatureInfo.getDefaultInstance());
        }

        public List<SignatureInfo.Builder> getSignatureInfosBuilderList() {
            return getSignatureInfosFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> getSignatureInfosFieldBuilder() {
            if (this.signatureInfosBuilder_ == null) {
                this.signatureInfosBuilder_ = new RepeatedFieldBuilderV3<>(this.signatureInfos_, (this.bitField0_ & 32) != 0, getParentForChildren(), isClean());
                this.signatureInfos_ = null;
            }
            return this.signatureInfosBuilder_;
        }

        private void ensureKeysIsMutable() {
            if ((this.bitField0_ & 64) == 0) {
                this.keys_ = new ArrayList(this.keys_);
                this.bitField0_ |= 64;
            }
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public List<TemporaryExposureKey> getKeysList() {
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV3 = this.keysBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.keys_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public int getKeysCount() {
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV3 = this.keysBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.keys_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public TemporaryExposureKey getKeys(int i) {
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV3 = this.keysBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.keys_.get(i);
            }
            return repeatedFieldBuilderV3.getMessage(i);
        }

        public Builder setKeys(int i, TemporaryExposureKey temporaryExposureKey) {
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV3 = this.keysBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(temporaryExposureKey);
                ensureKeysIsMutable();
                this.keys_.set(i, temporaryExposureKey);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i, temporaryExposureKey);
            }
            return this;
        }

        public Builder setKeys(int i, TemporaryExposureKey.Builder builder) {
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV3 = this.keysBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureKeysIsMutable();
                this.keys_.set(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
            }
            return this;
        }

        public Builder addKeys(TemporaryExposureKey temporaryExposureKey) {
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV3 = this.keysBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(temporaryExposureKey);
                ensureKeysIsMutable();
                this.keys_.add(temporaryExposureKey);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(temporaryExposureKey);
            }
            return this;
        }

        public Builder addKeys(int i, TemporaryExposureKey temporaryExposureKey) {
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV3 = this.keysBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(temporaryExposureKey);
                ensureKeysIsMutable();
                this.keys_.add(i, temporaryExposureKey);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i, temporaryExposureKey);
            }
            return this;
        }

        public Builder addKeys(TemporaryExposureKey.Builder builder) {
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV3 = this.keysBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureKeysIsMutable();
                this.keys_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addKeys(int i, TemporaryExposureKey.Builder builder) {
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV3 = this.keysBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureKeysIsMutable();
                this.keys_.add(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
            }
            return this;
        }

        public Builder addAllKeys(Iterable<? extends TemporaryExposureKey> iterable) {
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV3 = this.keysBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureKeysIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.keys_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder clearKeys() {
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV3 = this.keysBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.keys_ = Collections.emptyList();
                this.bitField0_ &= -65;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder removeKeys(int i) {
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV3 = this.keysBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureKeysIsMutable();
                this.keys_.remove(i);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i);
            }
            return this;
        }

        public TemporaryExposureKey.Builder getKeysBuilder(int i) {
            return getKeysFieldBuilder().getBuilder(i);
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public TemporaryExposureKeyOrBuilder getKeysOrBuilder(int i) {
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV3 = this.keysBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.keys_.get(i);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.proudcrowd.exposure.proto.TemporaryExposureKeyExportOrBuilder
        public List<? extends TemporaryExposureKeyOrBuilder> getKeysOrBuilderList() {
            RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> repeatedFieldBuilderV3 = this.keysBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.keys_);
        }

        public TemporaryExposureKey.Builder addKeysBuilder() {
            return getKeysFieldBuilder().addBuilder(TemporaryExposureKey.getDefaultInstance());
        }

        public TemporaryExposureKey.Builder addKeysBuilder(int i) {
            return getKeysFieldBuilder().addBuilder(i, TemporaryExposureKey.getDefaultInstance());
        }

        public List<TemporaryExposureKey.Builder> getKeysBuilderList() {
            return getKeysFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> getKeysFieldBuilder() {
            if (this.keysBuilder_ == null) {
                this.keysBuilder_ = new RepeatedFieldBuilderV3<>(this.keys_, (this.bitField0_ & 64) != 0, getParentForChildren(), isClean());
                this.keys_ = null;
            }
            return this.keysBuilder_;
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

    public static TemporaryExposureKeyExport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<TemporaryExposureKeyExport> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message, com.google.protobuf.GeneratedMessageV3
    public Parser<TemporaryExposureKeyExport> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public TemporaryExposureKeyExport getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
