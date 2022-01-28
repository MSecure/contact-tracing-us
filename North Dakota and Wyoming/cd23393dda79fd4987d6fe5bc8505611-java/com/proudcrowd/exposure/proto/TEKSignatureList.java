package com.proudcrowd.exposure.proto;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.proudcrowd.exposure.proto.TEKSignature;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class TEKSignatureList extends GeneratedMessageV3 implements TEKSignatureListOrBuilder {
    private static final TEKSignatureList DEFAULT_INSTANCE = new TEKSignatureList();
    @Deprecated
    public static final Parser<TEKSignatureList> PARSER = new AbstractParser<TEKSignatureList>() {
        /* class com.proudcrowd.exposure.proto.TEKSignatureList.AnonymousClass1 */

        @Override // com.google.protobuf.Parser
        public TEKSignatureList parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new TEKSignatureList(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int SIGNATURES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private List<TEKSignature> signatures_;

    private TEKSignatureList(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private TEKSignatureList() {
        this.memoizedIsInitialized = -1;
        this.signatures_ = Collections.emptyList();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new TEKSignatureList();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: java.util.List<com.proudcrowd.exposure.proto.TEKSignature> */
    /* JADX WARN: Multi-variable type inference failed */
    private TEKSignatureList(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag == 10) {
                        if (!z2 || !true) {
                            this.signatures_ = new ArrayList();
                            z2 |= true;
                        }
                        this.signatures_.add(codedInputStream.readMessage(TEKSignature.PARSER, extensionRegistryLite));
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
                    this.signatures_ = Collections.unmodifiableList(this.signatures_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 && true) {
            this.signatures_ = Collections.unmodifiableList(this.signatures_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return KeyFile.internal_static_com_proudcrowd_exposure_debug_TEKSignatureList_descriptor;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return KeyFile.internal_static_com_proudcrowd_exposure_debug_TEKSignatureList_fieldAccessorTable.ensureFieldAccessorsInitialized(TEKSignatureList.class, Builder.class);
    }

    @Override // com.proudcrowd.exposure.proto.TEKSignatureListOrBuilder
    public List<TEKSignature> getSignaturesList() {
        return this.signatures_;
    }

    @Override // com.proudcrowd.exposure.proto.TEKSignatureListOrBuilder
    public List<? extends TEKSignatureOrBuilder> getSignaturesOrBuilderList() {
        return this.signatures_;
    }

    @Override // com.proudcrowd.exposure.proto.TEKSignatureListOrBuilder
    public int getSignaturesCount() {
        return this.signatures_.size();
    }

    @Override // com.proudcrowd.exposure.proto.TEKSignatureListOrBuilder
    public TEKSignature getSignatures(int i) {
        return this.signatures_.get(i);
    }

    @Override // com.proudcrowd.exposure.proto.TEKSignatureListOrBuilder
    public TEKSignatureOrBuilder getSignaturesOrBuilder(int i) {
        return this.signatures_.get(i);
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
        for (int i = 0; i < this.signatures_.size(); i++) {
            codedOutputStream.writeMessage(1, this.signatures_.get(i));
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
        for (int i3 = 0; i3 < this.signatures_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.signatures_.get(i3));
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
        if (!(obj instanceof TEKSignatureList)) {
            return super.equals(obj);
        }
        TEKSignatureList tEKSignatureList = (TEKSignatureList) obj;
        if (getSignaturesList().equals(tEKSignatureList.getSignaturesList()) && this.unknownFields.equals(tEKSignatureList.unknownFields)) {
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
        if (getSignaturesCount() > 0) {
            hashCode = (((hashCode * 37) + 1) * 53) + getSignaturesList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public static TEKSignatureList parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static TEKSignatureList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static TEKSignatureList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static TEKSignatureList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static TEKSignatureList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static TEKSignatureList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static TEKSignatureList parseFrom(InputStream inputStream) throws IOException {
        return (TEKSignatureList) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static TEKSignatureList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TEKSignatureList) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TEKSignatureList parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TEKSignatureList) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static TEKSignatureList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TEKSignatureList) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TEKSignatureList parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TEKSignatureList) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static TEKSignatureList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TEKSignatureList) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TEKSignatureList tEKSignatureList) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(tEKSignatureList);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TEKSignatureListOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> signaturesBuilder_;
        private List<TEKSignature> signatures_;

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.GeneratedMessageV3.Builder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return KeyFile.internal_static_com_proudcrowd_exposure_debug_TEKSignatureList_descriptor;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return KeyFile.internal_static_com_proudcrowd_exposure_debug_TEKSignatureList_fieldAccessorTable.ensureFieldAccessorsInitialized(TEKSignatureList.class, Builder.class);
        }

        private Builder() {
            this.signatures_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.signatures_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (TEKSignatureList.alwaysUseFieldBuilders) {
                getSignaturesFieldBuilder();
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessageV3.Builder
        public Builder clear() {
            super.clear();
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.signatures_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessageV3.Builder
        public Descriptors.Descriptor getDescriptorForType() {
            return KeyFile.internal_static_com_proudcrowd_exposure_debug_TEKSignatureList_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TEKSignatureList getDefaultInstanceForType() {
            return TEKSignatureList.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TEKSignatureList build() {
            TEKSignatureList buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TEKSignatureList buildPartial() {
            TEKSignatureList tEKSignatureList = new TEKSignatureList(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.signatures_ = Collections.unmodifiableList(this.signatures_);
                    this.bitField0_ &= -2;
                }
                tEKSignatureList.signatures_ = this.signatures_;
            } else {
                tEKSignatureList.signatures_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return tEKSignatureList;
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
            if (message instanceof TEKSignatureList) {
                return mergeFrom((TEKSignatureList) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(TEKSignatureList tEKSignatureList) {
            if (tEKSignatureList == TEKSignatureList.getDefaultInstance()) {
                return this;
            }
            if (this.signaturesBuilder_ == null) {
                if (!tEKSignatureList.signatures_.isEmpty()) {
                    if (this.signatures_.isEmpty()) {
                        this.signatures_ = tEKSignatureList.signatures_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureSignaturesIsMutable();
                        this.signatures_.addAll(tEKSignatureList.signatures_);
                    }
                    onChanged();
                }
            } else if (!tEKSignatureList.signatures_.isEmpty()) {
                if (this.signaturesBuilder_.isEmpty()) {
                    this.signaturesBuilder_.dispose();
                    RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = null;
                    this.signaturesBuilder_ = null;
                    this.signatures_ = tEKSignatureList.signatures_;
                    this.bitField0_ &= -2;
                    if (TEKSignatureList.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getSignaturesFieldBuilder();
                    }
                    this.signaturesBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.signaturesBuilder_.addAllMessages(tEKSignatureList.signatures_);
                }
            }
            mergeUnknownFields(tEKSignatureList.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Throwable th;
            TEKSignatureList tEKSignatureList;
            TEKSignatureList tEKSignatureList2 = null;
            try {
                TEKSignatureList parsePartialFrom = TEKSignatureList.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                tEKSignatureList = (TEKSignatureList) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } catch (Throwable th2) {
                th = th2;
                tEKSignatureList2 = tEKSignatureList;
                if (tEKSignatureList2 != null) {
                }
                throw th;
            }
        }

        private void ensureSignaturesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.signatures_ = new ArrayList(this.signatures_);
                this.bitField0_ |= 1;
            }
        }

        @Override // com.proudcrowd.exposure.proto.TEKSignatureListOrBuilder
        public List<TEKSignature> getSignaturesList() {
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.signatures_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.proudcrowd.exposure.proto.TEKSignatureListOrBuilder
        public int getSignaturesCount() {
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.signatures_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.proudcrowd.exposure.proto.TEKSignatureListOrBuilder
        public TEKSignature getSignatures(int i) {
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.signatures_.get(i);
            }
            return repeatedFieldBuilderV3.getMessage(i);
        }

        public Builder setSignatures(int i, TEKSignature tEKSignature) {
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(tEKSignature);
                ensureSignaturesIsMutable();
                this.signatures_.set(i, tEKSignature);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i, tEKSignature);
            }
            return this;
        }

        public Builder setSignatures(int i, TEKSignature.Builder builder) {
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureSignaturesIsMutable();
                this.signatures_.set(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
            }
            return this;
        }

        public Builder addSignatures(TEKSignature tEKSignature) {
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(tEKSignature);
                ensureSignaturesIsMutable();
                this.signatures_.add(tEKSignature);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(tEKSignature);
            }
            return this;
        }

        public Builder addSignatures(int i, TEKSignature tEKSignature) {
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(tEKSignature);
                ensureSignaturesIsMutable();
                this.signatures_.add(i, tEKSignature);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i, tEKSignature);
            }
            return this;
        }

        public Builder addSignatures(TEKSignature.Builder builder) {
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureSignaturesIsMutable();
                this.signatures_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addSignatures(int i, TEKSignature.Builder builder) {
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureSignaturesIsMutable();
                this.signatures_.add(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
            }
            return this;
        }

        public Builder addAllSignatures(Iterable<? extends TEKSignature> iterable) {
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureSignaturesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.signatures_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder clearSignatures() {
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.signatures_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder removeSignatures(int i) {
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureSignaturesIsMutable();
                this.signatures_.remove(i);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i);
            }
            return this;
        }

        public TEKSignature.Builder getSignaturesBuilder(int i) {
            return getSignaturesFieldBuilder().getBuilder(i);
        }

        @Override // com.proudcrowd.exposure.proto.TEKSignatureListOrBuilder
        public TEKSignatureOrBuilder getSignaturesOrBuilder(int i) {
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.signatures_.get(i);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.proudcrowd.exposure.proto.TEKSignatureListOrBuilder
        public List<? extends TEKSignatureOrBuilder> getSignaturesOrBuilderList() {
            RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> repeatedFieldBuilderV3 = this.signaturesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.signatures_);
        }

        public TEKSignature.Builder addSignaturesBuilder() {
            return getSignaturesFieldBuilder().addBuilder(TEKSignature.getDefaultInstance());
        }

        public TEKSignature.Builder addSignaturesBuilder(int i) {
            return getSignaturesFieldBuilder().addBuilder(i, TEKSignature.getDefaultInstance());
        }

        public List<TEKSignature.Builder> getSignaturesBuilderList() {
            return getSignaturesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> getSignaturesFieldBuilder() {
            if (this.signaturesBuilder_ == null) {
                List<TEKSignature> list = this.signatures_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.signaturesBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.signatures_ = null;
            }
            return this.signaturesBuilder_;
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

    public static TEKSignatureList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<TEKSignatureList> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message, com.google.protobuf.GeneratedMessageV3
    public Parser<TEKSignatureList> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public TEKSignatureList getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
