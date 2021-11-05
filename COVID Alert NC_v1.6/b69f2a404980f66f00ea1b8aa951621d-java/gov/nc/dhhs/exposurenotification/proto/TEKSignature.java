package gov.nc.dhhs.exposurenotification.proto;

import c.a.a.a.a;
import c.b.d.a;
import c.b.d.c;
import c.b.d.e1;
import c.b.d.f2;
import c.b.d.j;
import c.b.d.k;
import c.b.d.k0;
import c.b.d.m;
import c.b.d.m0;
import c.b.d.n0;
import c.b.d.p2;
import c.b.d.s;
import c.b.d.v1;
import c.b.d.z;
import gov.nc.dhhs.exposurenotification.proto.SignatureInfo;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class TEKSignature extends k0 implements TEKSignatureOrBuilder {
    public static final int BATCH_NUM_FIELD_NUMBER = 2;
    public static final int BATCH_SIZE_FIELD_NUMBER = 3;
    public static final TEKSignature DEFAULT_INSTANCE = new TEKSignature();
    @Deprecated
    public static final v1<TEKSignature> PARSER = new c<TEKSignature>() {
        /* class gov.nc.dhhs.exposurenotification.proto.TEKSignature.AnonymousClass1 */

        @Override // c.b.d.v1
        public TEKSignature parsePartialFrom(k kVar, z zVar) {
            return new TEKSignature(kVar, zVar);
        }
    };
    public static final int SIGNATURE_FIELD_NUMBER = 4;
    public static final int SIGNATURE_INFO_FIELD_NUMBER = 1;
    public static final long serialVersionUID = 0;
    public int batchNum_;
    public int batchSize_;
    public int bitField0_;
    public byte memoizedIsInitialized;
    public SignatureInfo signatureInfo_;
    public j signature_;

    public TEKSignature() {
        this.memoizedIsInitialized = -1;
        this.signature_ = j.f3914c;
    }

    public TEKSignature(k0.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = -1;
    }

    public TEKSignature(k kVar, z zVar) {
        this();
        if (zVar != null) {
            p2.b b2 = p2.b();
            boolean z = false;
            while (!z) {
                try {
                    int G = kVar.G();
                    if (G != 0) {
                        if (G == 10) {
                            SignatureInfo.Builder builder = (this.bitField0_ & 1) != 0 ? this.signatureInfo_.toBuilder() : null;
                            SignatureInfo signatureInfo = (SignatureInfo) kVar.w(SignatureInfo.PARSER, zVar);
                            this.signatureInfo_ = signatureInfo;
                            if (builder != null) {
                                builder.mergeFrom(signatureInfo);
                                this.signatureInfo_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 1;
                        } else if (G == 16) {
                            this.bitField0_ |= 2;
                            this.batchNum_ = kVar.u();
                        } else if (G == 24) {
                            this.bitField0_ |= 4;
                            this.batchSize_ = kVar.u();
                        } else if (G == 34) {
                            this.bitField0_ |= 8;
                            this.signature_ = kVar.n();
                        } else if (!parseUnknownField(kVar, b2, zVar, G)) {
                        }
                    }
                    z = true;
                } catch (n0 e2) {
                    e2.f4007b = this;
                    throw e2;
                } catch (IOException e3) {
                    n0 n0Var = new n0(e3);
                    n0Var.f4007b = this;
                    throw n0Var;
                } catch (Throwable th) {
                    this.unknownFields = b2.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.unknownFields = b2.build();
            makeExtensionsImmutable();
            return;
        }
        throw null;
    }

    public static TEKSignature getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final s.b getDescriptor() {
        return KeyFile.internal_static_gov_nc_dhhs_exposurenotification_debug_TEKSignature_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TEKSignature tEKSignature) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(tEKSignature);
    }

    public static TEKSignature parseDelimitedFrom(InputStream inputStream) {
        return (TEKSignature) k0.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static TEKSignature parseDelimitedFrom(InputStream inputStream, z zVar) {
        return (TEKSignature) k0.parseDelimitedWithIOException(PARSER, inputStream, zVar);
    }

    public static TEKSignature parseFrom(j jVar) {
        return PARSER.parseFrom(jVar);
    }

    public static TEKSignature parseFrom(j jVar, z zVar) {
        return PARSER.parseFrom(jVar, zVar);
    }

    public static TEKSignature parseFrom(k kVar) {
        return (TEKSignature) k0.parseWithIOException(PARSER, kVar);
    }

    public static TEKSignature parseFrom(k kVar, z zVar) {
        return (TEKSignature) k0.parseWithIOException(PARSER, kVar, zVar);
    }

    public static TEKSignature parseFrom(InputStream inputStream) {
        return (TEKSignature) k0.parseWithIOException(PARSER, inputStream);
    }

    public static TEKSignature parseFrom(InputStream inputStream, z zVar) {
        return (TEKSignature) k0.parseWithIOException(PARSER, inputStream, zVar);
    }

    public static TEKSignature parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static TEKSignature parseFrom(ByteBuffer byteBuffer, z zVar) {
        return PARSER.parseFrom(byteBuffer, zVar);
    }

    public static TEKSignature parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    public static TEKSignature parseFrom(byte[] bArr, z zVar) {
        return PARSER.parseFrom(bArr, zVar);
    }

    public static v1<TEKSignature> parser() {
        return PARSER;
    }

    @Override // c.b.d.a
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
        if ((!hasBatchSize() || getBatchSize() == tEKSignature.getBatchSize()) && hasSignature() == tEKSignature.hasSignature()) {
            return (!hasSignature() || getSignature().equals(tEKSignature.getSignature())) && this.unknownFields.equals(tEKSignature.unknownFields);
        }
        return false;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
    public int getBatchNum() {
        return this.batchNum_;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
    public int getBatchSize() {
        return this.batchSize_;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder, gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder, c.b.d.j1, c.b.d.i1
    public TEKSignature getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // c.b.d.k0, c.b.d.h1
    public v1<TEKSignature> getParserForType() {
        return PARSER;
    }

    @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.bitField0_ & 1) != 0) {
            i2 = 0 + m.z(1, getSignatureInfo());
        }
        if ((this.bitField0_ & 2) != 0) {
            i2 += m.s(2, this.batchNum_);
        }
        if ((this.bitField0_ & 4) != 0) {
            i2 += m.s(3, this.batchSize_);
        }
        if ((this.bitField0_ & 8) != 0) {
            i2 += m.f(4, this.signature_);
        }
        int serializedSize = this.unknownFields.getSerializedSize() + i2;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
    public j getSignature() {
        return this.signature_;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
    public SignatureInfo getSignatureInfo() {
        SignatureInfo signatureInfo = this.signatureInfo_;
        return signatureInfo == null ? SignatureInfo.getDefaultInstance() : signatureInfo;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
    public SignatureInfoOrBuilder getSignatureInfoOrBuilder() {
        SignatureInfo signatureInfo = this.signatureInfo_;
        return signatureInfo == null ? SignatureInfo.getDefaultInstance() : signatureInfo;
    }

    @Override // c.b.d.k0, gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder, c.b.d.j1
    public final p2 getUnknownFields() {
        return this.unknownFields;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
    public boolean hasBatchNum() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
    public boolean hasBatchSize() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
    public boolean hasSignature() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
    public boolean hasSignatureInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // c.b.d.a
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = getDescriptor().hashCode() + 779;
        if (hasSignatureInfo()) {
            hashCode = a.a(hashCode, 37, 1, 53) + getSignatureInfo().hashCode();
        }
        if (hasBatchNum()) {
            hashCode = a.a(hashCode, 37, 2, 53) + getBatchNum();
        }
        if (hasBatchSize()) {
            hashCode = a.a(hashCode, 37, 3, 53) + getBatchSize();
        }
        if (hasSignature()) {
            hashCode = a.a(hashCode, 37, 4, 53) + getSignature().hashCode();
        }
        int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // c.b.d.k0
    public k0.f internalGetFieldAccessorTable() {
        k0.f fVar = KeyFile.internal_static_gov_nc_dhhs_exposurenotification_debug_TEKSignature_fieldAccessorTable;
        fVar.c(TEKSignature.class, Builder.class);
        return fVar;
    }

    @Override // c.b.d.k0, gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder, c.b.d.a, c.b.d.i1
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // c.b.d.e1, c.b.d.h1
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // c.b.d.k0
    public Builder newBuilderForType(k0.c cVar) {
        return new Builder(cVar);
    }

    @Override // c.b.d.k0
    public Object newInstance(k0.g gVar) {
        return new TEKSignature();
    }

    @Override // c.b.d.e1, c.b.d.h1
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
    public void writeTo(m mVar) {
        if ((this.bitField0_ & 1) != 0) {
            mVar.k0(1, getSignatureInfo());
        }
        if ((this.bitField0_ & 2) != 0) {
            mVar.i0(2, this.batchNum_);
        }
        if ((this.bitField0_ & 4) != 0) {
            mVar.i0(3, this.batchSize_);
        }
        if ((this.bitField0_ & 8) != 0) {
            mVar.a0(4, this.signature_);
        }
        this.unknownFields.writeTo(mVar);
    }

    public static final class Builder extends k0.b<Builder> implements TEKSignatureOrBuilder {
        public int batchNum_;
        public int batchSize_;
        public int bitField0_;
        public f2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> signatureInfoBuilder_;
        public SignatureInfo signatureInfo_;
        public j signature_;

        public Builder() {
            this.signature_ = j.f3914c;
            maybeForceBuilderInitialization();
        }

        public Builder(k0.c cVar) {
            super(cVar);
            this.signature_ = j.f3914c;
            maybeForceBuilderInitialization();
        }

        public static final s.b getDescriptor() {
            return KeyFile.internal_static_gov_nc_dhhs_exposurenotification_debug_TEKSignature_descriptor;
        }

        private f2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> getSignatureInfoFieldBuilder() {
            if (this.signatureInfoBuilder_ == null) {
                this.signatureInfoBuilder_ = new f2<>(getSignatureInfo(), getParentForChildren(), isClean());
                this.signatureInfo_ = null;
            }
            return this.signatureInfoBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (k0.alwaysUseFieldBuilders) {
                getSignatureInfoFieldBuilder();
            }
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
        public Builder addRepeatedField(s.g gVar, Object obj) {
            return (Builder) super.addRepeatedField(gVar, obj);
        }

        @Override // c.b.d.h1.a, c.b.d.e1.a
        public TEKSignature build() {
            TEKSignature buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0097a.newUninitializedMessageException((e1) buildPartial);
        }

        @Override // c.b.d.h1.a, c.b.d.e1.a
        public TEKSignature buildPartial() {
            int i;
            TEKSignature tEKSignature = new TEKSignature(this);
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                f2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> f2Var = this.signatureInfoBuilder_;
                tEKSignature.signatureInfo_ = f2Var == null ? this.signatureInfo_ : f2Var.b();
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

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public Builder clear() {
            super.clear();
            f2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> f2Var = this.signatureInfoBuilder_;
            if (f2Var == null) {
                this.signatureInfo_ = null;
            } else {
                f2Var.c();
            }
            int i = this.bitField0_ & -2;
            this.bitField0_ = i;
            this.batchNum_ = 0;
            int i2 = i & -3;
            this.bitField0_ = i2;
            this.batchSize_ = 0;
            int i3 = i2 & -5;
            this.bitField0_ = i3;
            this.signature_ = j.f3914c;
            this.bitField0_ = i3 & -9;
            return this;
        }

        public Builder clearBatchNum() {
            this.bitField0_ &= -3;
            this.batchNum_ = 0;
            onChanged();
            return this;
        }

        public Builder clearBatchSize() {
            this.bitField0_ &= -5;
            this.batchSize_ = 0;
            onChanged();
            return this;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
        public Builder clearField(s.g gVar) {
            return (Builder) super.clearField(gVar);
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public Builder clearOneof(s.k kVar) {
            return (Builder) super.clearOneof(kVar);
        }

        public Builder clearSignature() {
            this.bitField0_ &= -9;
            this.signature_ = TEKSignature.getDefaultInstance().getSignature();
            onChanged();
            return this;
        }

        public Builder clearSignatureInfo() {
            f2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> f2Var = this.signatureInfoBuilder_;
            if (f2Var == null) {
                this.signatureInfo_ = null;
                onChanged();
            } else {
                f2Var.c();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.b.a, c.b.d.b.a, c.b.d.b.a, java.lang.Object, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
        public int getBatchNum() {
            return this.batchNum_;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
        public int getBatchSize() {
            return this.batchSize_;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder, gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder, c.b.d.j1, c.b.d.i1
        public TEKSignature getDefaultInstanceForType() {
            return TEKSignature.getDefaultInstance();
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder, c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
        public s.b getDescriptorForType() {
            return KeyFile.internal_static_gov_nc_dhhs_exposurenotification_debug_TEKSignature_descriptor;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
        public j getSignature() {
            return this.signature_;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
        public SignatureInfo getSignatureInfo() {
            f2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> f2Var = this.signatureInfoBuilder_;
            if (f2Var != null) {
                return f2Var.e();
            }
            SignatureInfo signatureInfo = this.signatureInfo_;
            return signatureInfo == null ? SignatureInfo.getDefaultInstance() : signatureInfo;
        }

        public SignatureInfo.Builder getSignatureInfoBuilder() {
            this.bitField0_ |= 1;
            onChanged();
            return getSignatureInfoFieldBuilder().d();
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
        public SignatureInfoOrBuilder getSignatureInfoOrBuilder() {
            f2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> f2Var = this.signatureInfoBuilder_;
            if (f2Var != null) {
                MType mtype = f2Var.f3867b;
                if (mtype == null) {
                    mtype = f2Var.f3868c;
                }
                return (SignatureInfoOrBuilder) mtype;
            }
            SignatureInfo signatureInfo = this.signatureInfo_;
            return signatureInfo == null ? SignatureInfo.getDefaultInstance() : signatureInfo;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
        public boolean hasBatchNum() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
        public boolean hasBatchSize() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
        public boolean hasSignature() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder
        public boolean hasSignatureInfo() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // c.b.d.k0.b
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = KeyFile.internal_static_gov_nc_dhhs_exposurenotification_debug_TEKSignature_fieldAccessorTable;
            fVar.c(TEKSignature.class, Builder.class);
            return fVar;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TEKSignatureOrBuilder, c.b.d.k0.b, c.b.d.i1
        public final boolean isInitialized() {
            return true;
        }

        @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public Builder mergeFrom(e1 e1Var) {
            if (e1Var instanceof TEKSignature) {
                return mergeFrom((TEKSignature) e1Var);
            }
            super.mergeFrom(e1Var);
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
        @Override // c.b.d.h1.a, c.b.d.b.a, c.b.d.b.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public Builder mergeFrom(k kVar, z zVar) {
            Throwable th;
            TEKSignature tEKSignature;
            TEKSignature tEKSignature2 = null;
            try {
                TEKSignature parsePartialFrom = TEKSignature.PARSER.parsePartialFrom(kVar, zVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (n0 e2) {
                tEKSignature = (TEKSignature) e2.f4007b;
                throw e2.j();
            } catch (Throwable th2) {
                th = th2;
                tEKSignature2 = tEKSignature;
                if (tEKSignature2 != null) {
                }
                throw th;
            }
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

        public Builder mergeSignatureInfo(SignatureInfo signatureInfo) {
            SignatureInfo signatureInfo2;
            f2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> f2Var = this.signatureInfoBuilder_;
            if (f2Var == null) {
                if (!((this.bitField0_ & 1) == 0 || (signatureInfo2 = this.signatureInfo_) == null || signatureInfo2 == SignatureInfo.getDefaultInstance())) {
                    signatureInfo = SignatureInfo.newBuilder(this.signatureInfo_).mergeFrom(signatureInfo).buildPartial();
                }
                this.signatureInfo_ = signatureInfo;
                onChanged();
            } else {
                f2Var.f(signatureInfo);
            }
            this.bitField0_ |= 1;
            return this;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public final Builder mergeUnknownFields(p2 p2Var) {
            return (Builder) super.mergeUnknownFields(p2Var);
        }

        public Builder setBatchNum(int i) {
            this.bitField0_ |= 2;
            this.batchNum_ = i;
            onChanged();
            return this;
        }

        public Builder setBatchSize(int i) {
            this.bitField0_ |= 4;
            this.batchSize_ = i;
            onChanged();
            return this;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
        public Builder setField(s.g gVar, Object obj) {
            return (Builder) super.setField(gVar, obj);
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b
        public Builder setRepeatedField(s.g gVar, int i, Object obj) {
            return (Builder) super.setRepeatedField(gVar, i, obj);
        }

        public Builder setSignature(j jVar) {
            if (jVar != null) {
                this.bitField0_ |= 8;
                this.signature_ = jVar;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setSignatureInfo(SignatureInfo.Builder builder) {
            f2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> f2Var = this.signatureInfoBuilder_;
            SignatureInfo build = builder.build();
            if (f2Var == null) {
                this.signatureInfo_ = build;
                onChanged();
            } else {
                m0.a(build);
                f2Var.f3868c = build;
                BType btype = f2Var.f3867b;
                if (btype != null) {
                    btype.dispose();
                    f2Var.f3867b = null;
                }
                f2Var.g();
            }
            this.bitField0_ |= 1;
            return this;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
        public final Builder setUnknownFields(p2 p2Var) {
            return (Builder) super.setUnknownFields(p2Var);
        }

        public Builder setSignatureInfo(SignatureInfo signatureInfo) {
            f2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> f2Var = this.signatureInfoBuilder_;
            if (f2Var != null) {
                m0.a(signatureInfo);
                f2Var.f3868c = signatureInfo;
                BType btype = f2Var.f3867b;
                if (btype != null) {
                    btype.dispose();
                    f2Var.f3867b = null;
                }
                f2Var.g();
            } else if (signatureInfo != null) {
                this.signatureInfo_ = signatureInfo;
                onChanged();
            } else {
                throw null;
            }
            this.bitField0_ |= 1;
            return this;
        }
    }
}
