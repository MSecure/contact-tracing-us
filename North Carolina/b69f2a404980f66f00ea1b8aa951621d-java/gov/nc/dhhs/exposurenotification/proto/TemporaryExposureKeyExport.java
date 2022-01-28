package gov.nc.dhhs.exposurenotification.proto;

import c.a.a.a.a;
import c.b.d.a;
import c.b.d.b;
import c.b.d.b2;
import c.b.d.c;
import c.b.d.e1;
import c.b.d.h1;
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
import gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKey;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TemporaryExposureKeyExport extends k0 implements TemporaryExposureKeyExportOrBuilder {
    public static final int BATCH_NUM_FIELD_NUMBER = 4;
    public static final int BATCH_SIZE_FIELD_NUMBER = 5;
    public static final TemporaryExposureKeyExport DEFAULT_INSTANCE = new TemporaryExposureKeyExport();
    public static final int END_TIMESTAMP_FIELD_NUMBER = 2;
    public static final int KEYS_FIELD_NUMBER = 7;
    @Deprecated
    public static final v1<TemporaryExposureKeyExport> PARSER = new c<TemporaryExposureKeyExport>() {
        /* class gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExport.AnonymousClass1 */

        @Override // c.b.d.v1
        public TemporaryExposureKeyExport parsePartialFrom(k kVar, z zVar) {
            return new TemporaryExposureKeyExport(kVar, zVar);
        }
    };
    public static final int REGION_FIELD_NUMBER = 3;
    public static final int SIGNATURE_INFOS_FIELD_NUMBER = 6;
    public static final int START_TIMESTAMP_FIELD_NUMBER = 1;
    public static final long serialVersionUID = 0;
    public int batchNum_;
    public int batchSize_;
    public int bitField0_;
    public long endTimestamp_;
    public List<TemporaryExposureKey> keys_;
    public byte memoizedIsInitialized;
    public volatile Object region_;
    public List<SignatureInfo> signatureInfos_;
    public long startTimestamp_;

    public TemporaryExposureKeyExport() {
        this.memoizedIsInitialized = -1;
        this.region_ = "";
        this.signatureInfos_ = Collections.emptyList();
        this.keys_ = Collections.emptyList();
    }

    public TemporaryExposureKeyExport(k0.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = -1;
    }

    public TemporaryExposureKeyExport(k kVar, z zVar) {
        this();
        List list;
        h1 w;
        if (zVar != null) {
            p2.b b2 = p2.b();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int G = kVar.G();
                    if (G != 0) {
                        if (G == 9) {
                            this.bitField0_ |= 1;
                            this.startTimestamp_ = kVar.r();
                        } else if (G == 17) {
                            this.bitField0_ |= 2;
                            this.endTimestamp_ = kVar.r();
                        } else if (G == 26) {
                            j n = kVar.n();
                            this.bitField0_ |= 4;
                            this.region_ = n;
                        } else if (G == 32) {
                            this.bitField0_ |= 8;
                            this.batchNum_ = kVar.u();
                        } else if (G != 40) {
                            if (G == 50) {
                                if (!z2 || !true) {
                                    this.signatureInfos_ = new ArrayList();
                                    z2 |= true;
                                }
                                list = this.signatureInfos_;
                                w = kVar.w(SignatureInfo.PARSER, zVar);
                            } else if (G == 58) {
                                if (!z2 || !true) {
                                    this.keys_ = new ArrayList();
                                    z2 |= true;
                                }
                                list = this.keys_;
                                w = kVar.w(TemporaryExposureKey.PARSER, zVar);
                            } else if (!parseUnknownField(kVar, b2, zVar, G)) {
                            }
                            list.add(w);
                        } else {
                            this.bitField0_ |= 16;
                            this.batchSize_ = kVar.u();
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
                    if (z2 && true) {
                        this.signatureInfos_ = Collections.unmodifiableList(this.signatureInfos_);
                    }
                    if (z2 && true) {
                        this.keys_ = Collections.unmodifiableList(this.keys_);
                    }
                    this.unknownFields = b2.build();
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
            this.unknownFields = b2.build();
            makeExtensionsImmutable();
            return;
        }
        throw null;
    }

    public static TemporaryExposureKeyExport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final s.b getDescriptor() {
        return KeyFile.internal_static_gov_nc_dhhs_exposurenotification_debug_TemporaryExposureKeyExport_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TemporaryExposureKeyExport temporaryExposureKeyExport) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(temporaryExposureKeyExport);
    }

    public static TemporaryExposureKeyExport parseDelimitedFrom(InputStream inputStream) {
        return (TemporaryExposureKeyExport) k0.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static TemporaryExposureKeyExport parseDelimitedFrom(InputStream inputStream, z zVar) {
        return (TemporaryExposureKeyExport) k0.parseDelimitedWithIOException(PARSER, inputStream, zVar);
    }

    public static TemporaryExposureKeyExport parseFrom(j jVar) {
        return PARSER.parseFrom(jVar);
    }

    public static TemporaryExposureKeyExport parseFrom(j jVar, z zVar) {
        return PARSER.parseFrom(jVar, zVar);
    }

    public static TemporaryExposureKeyExport parseFrom(k kVar) {
        return (TemporaryExposureKeyExport) k0.parseWithIOException(PARSER, kVar);
    }

    public static TemporaryExposureKeyExport parseFrom(k kVar, z zVar) {
        return (TemporaryExposureKeyExport) k0.parseWithIOException(PARSER, kVar, zVar);
    }

    public static TemporaryExposureKeyExport parseFrom(InputStream inputStream) {
        return (TemporaryExposureKeyExport) k0.parseWithIOException(PARSER, inputStream);
    }

    public static TemporaryExposureKeyExport parseFrom(InputStream inputStream, z zVar) {
        return (TemporaryExposureKeyExport) k0.parseWithIOException(PARSER, inputStream, zVar);
    }

    public static TemporaryExposureKeyExport parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static TemporaryExposureKeyExport parseFrom(ByteBuffer byteBuffer, z zVar) {
        return PARSER.parseFrom(byteBuffer, zVar);
    }

    public static TemporaryExposureKeyExport parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    public static TemporaryExposureKeyExport parseFrom(byte[] bArr, z zVar) {
        return PARSER.parseFrom(bArr, zVar);
    }

    public static v1<TemporaryExposureKeyExport> parser() {
        return PARSER;
    }

    @Override // c.b.d.a
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
        if ((!hasBatchNum() || getBatchNum() == temporaryExposureKeyExport.getBatchNum()) && hasBatchSize() == temporaryExposureKeyExport.hasBatchSize()) {
            return (!hasBatchSize() || getBatchSize() == temporaryExposureKeyExport.getBatchSize()) && getSignatureInfosList().equals(temporaryExposureKeyExport.getSignatureInfosList()) && getKeysList().equals(temporaryExposureKeyExport.getKeysList()) && this.unknownFields.equals(temporaryExposureKeyExport.unknownFields);
        }
        return false;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public int getBatchNum() {
        return this.batchNum_;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public int getBatchSize() {
        return this.batchSize_;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder, gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder, c.b.d.j1, c.b.d.i1
    public TemporaryExposureKeyExport getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public long getEndTimestamp() {
        return this.endTimestamp_;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public TemporaryExposureKey getKeys(int i) {
        return this.keys_.get(i);
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public int getKeysCount() {
        return this.keys_.size();
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public List<TemporaryExposureKey> getKeysList() {
        return this.keys_;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public TemporaryExposureKeyOrBuilder getKeysOrBuilder(int i) {
        return this.keys_.get(i);
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public List<? extends TemporaryExposureKeyOrBuilder> getKeysOrBuilderList() {
        return this.keys_;
    }

    @Override // c.b.d.k0, c.b.d.h1
    public v1<TemporaryExposureKeyExport> getParserForType() {
        return PARSER;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public String getRegion() {
        Object obj = this.region_;
        if (obj instanceof String) {
            return (String) obj;
        }
        j jVar = (j) obj;
        String u = jVar.u();
        if (jVar.o()) {
            this.region_ = u;
        }
        return u;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public j getRegionBytes() {
        Object obj = this.region_;
        if (!(obj instanceof String)) {
            return (j) obj;
        }
        j j = j.j((String) obj);
        this.region_ = j;
        return j;
    }

    @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int m = (this.bitField0_ & 1) != 0 ? m.m(1, this.startTimestamp_) + 0 : 0;
        if ((this.bitField0_ & 2) != 0) {
            m += m.m(2, this.endTimestamp_);
        }
        if ((this.bitField0_ & 4) != 0) {
            m += k0.computeStringSize(3, this.region_);
        }
        if ((this.bitField0_ & 8) != 0) {
            m += m.s(4, this.batchNum_);
        }
        if ((this.bitField0_ & 16) != 0) {
            m += m.s(5, this.batchSize_);
        }
        for (int i2 = 0; i2 < this.signatureInfos_.size(); i2++) {
            m += m.z(6, this.signatureInfos_.get(i2));
        }
        for (int i3 = 0; i3 < this.keys_.size(); i3++) {
            m += m.z(7, this.keys_.get(i3));
        }
        int serializedSize = this.unknownFields.getSerializedSize() + m;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public SignatureInfo getSignatureInfos(int i) {
        return this.signatureInfos_.get(i);
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public int getSignatureInfosCount() {
        return this.signatureInfos_.size();
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public List<SignatureInfo> getSignatureInfosList() {
        return this.signatureInfos_;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public SignatureInfoOrBuilder getSignatureInfosOrBuilder(int i) {
        return this.signatureInfos_.get(i);
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public List<? extends SignatureInfoOrBuilder> getSignatureInfosOrBuilderList() {
        return this.signatureInfos_;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public long getStartTimestamp() {
        return this.startTimestamp_;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder, c.b.d.k0, c.b.d.j1
    public final p2 getUnknownFields() {
        return this.unknownFields;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public boolean hasBatchNum() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public boolean hasBatchSize() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public boolean hasEndTimestamp() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public boolean hasRegion() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
    public boolean hasStartTimestamp() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // c.b.d.a
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = getDescriptor().hashCode() + 779;
        if (hasStartTimestamp()) {
            hashCode = a.a(hashCode, 37, 1, 53) + m0.e(getStartTimestamp());
        }
        if (hasEndTimestamp()) {
            hashCode = a.a(hashCode, 37, 2, 53) + m0.e(getEndTimestamp());
        }
        if (hasRegion()) {
            hashCode = a.a(hashCode, 37, 3, 53) + getRegion().hashCode();
        }
        if (hasBatchNum()) {
            hashCode = a.a(hashCode, 37, 4, 53) + getBatchNum();
        }
        if (hasBatchSize()) {
            hashCode = a.a(hashCode, 37, 5, 53) + getBatchSize();
        }
        if (getSignatureInfosCount() > 0) {
            hashCode = a.a(hashCode, 37, 6, 53) + getSignatureInfosList().hashCode();
        }
        if (getKeysCount() > 0) {
            hashCode = a.a(hashCode, 37, 7, 53) + getKeysList().hashCode();
        }
        int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // c.b.d.k0
    public k0.f internalGetFieldAccessorTable() {
        k0.f fVar = KeyFile.internal_static_gov_nc_dhhs_exposurenotification_debug_TemporaryExposureKeyExport_fieldAccessorTable;
        fVar.c(TemporaryExposureKeyExport.class, Builder.class);
        return fVar;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder, c.b.d.k0, c.b.d.a, c.b.d.i1
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
        return new TemporaryExposureKeyExport();
    }

    @Override // c.b.d.e1, c.b.d.h1
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
    public void writeTo(m mVar) {
        if ((this.bitField0_ & 1) != 0) {
            mVar.f0(1, this.startTimestamp_);
        }
        if ((this.bitField0_ & 2) != 0) {
            mVar.f0(2, this.endTimestamp_);
        }
        if ((this.bitField0_ & 4) != 0) {
            k0.writeString(mVar, 3, this.region_);
        }
        if ((this.bitField0_ & 8) != 0) {
            mVar.i0(4, this.batchNum_);
        }
        if ((this.bitField0_ & 16) != 0) {
            mVar.i0(5, this.batchSize_);
        }
        for (int i = 0; i < this.signatureInfos_.size(); i++) {
            mVar.k0(6, this.signatureInfos_.get(i));
        }
        for (int i2 = 0; i2 < this.keys_.size(); i2++) {
            mVar.k0(7, this.keys_.get(i2));
        }
        this.unknownFields.writeTo(mVar);
    }

    public static final class Builder extends k0.b<Builder> implements TemporaryExposureKeyExportOrBuilder {
        public int batchNum_;
        public int batchSize_;
        public int bitField0_;
        public long endTimestamp_;
        public b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> keysBuilder_;
        public List<TemporaryExposureKey> keys_;
        public Object region_;
        public b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> signatureInfosBuilder_;
        public List<SignatureInfo> signatureInfos_;
        public long startTimestamp_;

        public Builder() {
            this.region_ = "";
            this.signatureInfos_ = Collections.emptyList();
            this.keys_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder(k0.c cVar) {
            super(cVar);
            this.region_ = "";
            this.signatureInfos_ = Collections.emptyList();
            this.keys_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureKeysIsMutable() {
            if ((this.bitField0_ & 64) == 0) {
                this.keys_ = new ArrayList(this.keys_);
                this.bitField0_ |= 64;
            }
        }

        private void ensureSignatureInfosIsMutable() {
            if ((this.bitField0_ & 32) == 0) {
                this.signatureInfos_ = new ArrayList(this.signatureInfos_);
                this.bitField0_ |= 32;
            }
        }

        public static final s.b getDescriptor() {
            return KeyFile.internal_static_gov_nc_dhhs_exposurenotification_debug_TemporaryExposureKeyExport_descriptor;
        }

        private b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> getKeysFieldBuilder() {
            if (this.keysBuilder_ == null) {
                this.keysBuilder_ = new b2<>(this.keys_, (this.bitField0_ & 64) != 0, getParentForChildren(), isClean());
                this.keys_ = null;
            }
            return this.keysBuilder_;
        }

        private b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> getSignatureInfosFieldBuilder() {
            if (this.signatureInfosBuilder_ == null) {
                this.signatureInfosBuilder_ = new b2<>(this.signatureInfos_, (this.bitField0_ & 32) != 0, getParentForChildren(), isClean());
                this.signatureInfos_ = null;
            }
            return this.signatureInfosBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (k0.alwaysUseFieldBuilders) {
                getSignatureInfosFieldBuilder();
                getKeysFieldBuilder();
            }
        }

        public Builder addAllKeys(Iterable<? extends TemporaryExposureKey> iterable) {
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var = this.keysBuilder_;
            if (b2Var == null) {
                ensureKeysIsMutable();
                b.a.addAll((Iterable) iterable, (List) this.keys_);
                onChanged();
            } else {
                b2Var.b(iterable);
            }
            return this;
        }

        public Builder addAllSignatureInfos(Iterable<? extends SignatureInfo> iterable) {
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            if (b2Var == null) {
                ensureSignatureInfosIsMutable();
                b.a.addAll((Iterable) iterable, (List) this.signatureInfos_);
                onChanged();
            } else {
                b2Var.b(iterable);
            }
            return this;
        }

        public Builder addKeys(int i, TemporaryExposureKey.Builder builder) {
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var = this.keysBuilder_;
            if (b2Var == null) {
                ensureKeysIsMutable();
                this.keys_.add(i, builder.build());
                onChanged();
            } else {
                b2Var.e(i, builder.build());
            }
            return this;
        }

        public Builder addKeys(int i, TemporaryExposureKey temporaryExposureKey) {
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var = this.keysBuilder_;
            if (b2Var != null) {
                b2Var.e(i, temporaryExposureKey);
            } else if (temporaryExposureKey != null) {
                ensureKeysIsMutable();
                this.keys_.add(i, temporaryExposureKey);
                onChanged();
            } else {
                throw null;
            }
            return this;
        }

        public Builder addKeys(TemporaryExposureKey.Builder builder) {
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var = this.keysBuilder_;
            if (b2Var == null) {
                ensureKeysIsMutable();
                this.keys_.add(builder.build());
                onChanged();
            } else {
                b2Var.f(builder.build());
            }
            return this;
        }

        public Builder addKeys(TemporaryExposureKey temporaryExposureKey) {
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var = this.keysBuilder_;
            if (b2Var != null) {
                b2Var.f(temporaryExposureKey);
            } else if (temporaryExposureKey != null) {
                ensureKeysIsMutable();
                this.keys_.add(temporaryExposureKey);
                onChanged();
            } else {
                throw null;
            }
            return this;
        }

        public TemporaryExposureKey.Builder addKeysBuilder() {
            return getKeysFieldBuilder().d(TemporaryExposureKey.getDefaultInstance());
        }

        public TemporaryExposureKey.Builder addKeysBuilder(int i) {
            return getKeysFieldBuilder().c(i, TemporaryExposureKey.getDefaultInstance());
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
        public Builder addRepeatedField(s.g gVar, Object obj) {
            return (Builder) super.addRepeatedField(gVar, obj);
        }

        public Builder addSignatureInfos(int i, SignatureInfo.Builder builder) {
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            if (b2Var == null) {
                ensureSignatureInfosIsMutable();
                this.signatureInfos_.add(i, builder.build());
                onChanged();
            } else {
                b2Var.e(i, builder.build());
            }
            return this;
        }

        public Builder addSignatureInfos(int i, SignatureInfo signatureInfo) {
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            if (b2Var != null) {
                b2Var.e(i, signatureInfo);
            } else if (signatureInfo != null) {
                ensureSignatureInfosIsMutable();
                this.signatureInfos_.add(i, signatureInfo);
                onChanged();
            } else {
                throw null;
            }
            return this;
        }

        public Builder addSignatureInfos(SignatureInfo.Builder builder) {
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            if (b2Var == null) {
                ensureSignatureInfosIsMutable();
                this.signatureInfos_.add(builder.build());
                onChanged();
            } else {
                b2Var.f(builder.build());
            }
            return this;
        }

        public Builder addSignatureInfos(SignatureInfo signatureInfo) {
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            if (b2Var != null) {
                b2Var.f(signatureInfo);
            } else if (signatureInfo != null) {
                ensureSignatureInfosIsMutable();
                this.signatureInfos_.add(signatureInfo);
                onChanged();
            } else {
                throw null;
            }
            return this;
        }

        public SignatureInfo.Builder addSignatureInfosBuilder() {
            return getSignatureInfosFieldBuilder().d(SignatureInfo.getDefaultInstance());
        }

        public SignatureInfo.Builder addSignatureInfosBuilder(int i) {
            return getSignatureInfosFieldBuilder().c(i, SignatureInfo.getDefaultInstance());
        }

        @Override // c.b.d.h1.a, c.b.d.e1.a
        public TemporaryExposureKeyExport build() {
            TemporaryExposureKeyExport buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0097a.newUninitializedMessageException((e1) buildPartial);
        }

        @Override // c.b.d.h1.a, c.b.d.e1.a
        public TemporaryExposureKeyExport buildPartial() {
            int i;
            List<SignatureInfo> list;
            List<TemporaryExposureKey> list2;
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
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            if (b2Var == null) {
                if ((this.bitField0_ & 32) != 0) {
                    this.signatureInfos_ = Collections.unmodifiableList(this.signatureInfos_);
                    this.bitField0_ &= -33;
                }
                list = this.signatureInfos_;
            } else {
                list = b2Var.g();
            }
            temporaryExposureKeyExport.signatureInfos_ = list;
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var2 = this.keysBuilder_;
            if (b2Var2 == null) {
                if ((this.bitField0_ & 64) != 0) {
                    this.keys_ = Collections.unmodifiableList(this.keys_);
                    this.bitField0_ &= -65;
                }
                list2 = this.keys_;
            } else {
                list2 = b2Var2.g();
            }
            temporaryExposureKeyExport.keys_ = list2;
            temporaryExposureKeyExport.bitField0_ = i;
            onBuilt();
            return temporaryExposureKeyExport;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
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
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            if (b2Var == null) {
                this.signatureInfos_ = Collections.emptyList();
                this.bitField0_ &= -33;
            } else {
                b2Var.h();
            }
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var2 = this.keysBuilder_;
            if (b2Var2 == null) {
                this.keys_ = Collections.emptyList();
                this.bitField0_ &= -65;
            } else {
                b2Var2.h();
            }
            return this;
        }

        public Builder clearBatchNum() {
            this.bitField0_ &= -9;
            this.batchNum_ = 0;
            onChanged();
            return this;
        }

        public Builder clearBatchSize() {
            this.bitField0_ &= -17;
            this.batchSize_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEndTimestamp() {
            this.bitField0_ &= -3;
            this.endTimestamp_ = 0;
            onChanged();
            return this;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
        public Builder clearField(s.g gVar) {
            return (Builder) super.clearField(gVar);
        }

        public Builder clearKeys() {
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var = this.keysBuilder_;
            if (b2Var == null) {
                this.keys_ = Collections.emptyList();
                this.bitField0_ &= -65;
                onChanged();
            } else {
                b2Var.h();
            }
            return this;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public Builder clearOneof(s.k kVar) {
            return (Builder) super.clearOneof(kVar);
        }

        public Builder clearRegion() {
            this.bitField0_ &= -5;
            this.region_ = TemporaryExposureKeyExport.getDefaultInstance().getRegion();
            onChanged();
            return this;
        }

        public Builder clearSignatureInfos() {
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            if (b2Var == null) {
                this.signatureInfos_ = Collections.emptyList();
                this.bitField0_ &= -33;
                onChanged();
            } else {
                b2Var.h();
            }
            return this;
        }

        public Builder clearStartTimestamp() {
            this.bitField0_ &= -2;
            this.startTimestamp_ = 0;
            onChanged();
            return this;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.b.a, c.b.d.b.a, c.b.d.b.a, java.lang.Object, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public int getBatchNum() {
            return this.batchNum_;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public int getBatchSize() {
            return this.batchSize_;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder, gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder, c.b.d.j1, c.b.d.i1
        public TemporaryExposureKeyExport getDefaultInstanceForType() {
            return TemporaryExposureKeyExport.getDefaultInstance();
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder, c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
        public s.b getDescriptorForType() {
            return KeyFile.internal_static_gov_nc_dhhs_exposurenotification_debug_TemporaryExposureKeyExport_descriptor;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public long getEndTimestamp() {
            return this.endTimestamp_;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public TemporaryExposureKey getKeys(int i) {
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var = this.keysBuilder_;
            return b2Var == null ? this.keys_.get(i) : b2Var.n(i, false);
        }

        public TemporaryExposureKey.Builder getKeysBuilder(int i) {
            return getKeysFieldBuilder().k(i);
        }

        public List<TemporaryExposureKey.Builder> getKeysBuilderList() {
            return getKeysFieldBuilder().l();
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public int getKeysCount() {
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var = this.keysBuilder_;
            return b2Var == null ? this.keys_.size() : b2Var.m();
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public List<TemporaryExposureKey> getKeysList() {
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var = this.keysBuilder_;
            return b2Var == null ? Collections.unmodifiableList(this.keys_) : b2Var.o();
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public TemporaryExposureKeyOrBuilder getKeysOrBuilder(int i) {
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var = this.keysBuilder_;
            return (TemporaryExposureKeyOrBuilder) (b2Var == null ? this.keys_.get(i) : b2Var.p(i));
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public List<? extends TemporaryExposureKeyOrBuilder> getKeysOrBuilderList() {
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var = this.keysBuilder_;
            return b2Var != null ? b2Var.q() : Collections.unmodifiableList(this.keys_);
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public String getRegion() {
            Object obj = this.region_;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.region_ = u;
            }
            return u;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public j getRegionBytes() {
            Object obj = this.region_;
            if (!(obj instanceof String)) {
                return (j) obj;
            }
            j j = j.j((String) obj);
            this.region_ = j;
            return j;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public SignatureInfo getSignatureInfos(int i) {
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            return b2Var == null ? this.signatureInfos_.get(i) : b2Var.n(i, false);
        }

        public SignatureInfo.Builder getSignatureInfosBuilder(int i) {
            return getSignatureInfosFieldBuilder().k(i);
        }

        public List<SignatureInfo.Builder> getSignatureInfosBuilderList() {
            return getSignatureInfosFieldBuilder().l();
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public int getSignatureInfosCount() {
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            return b2Var == null ? this.signatureInfos_.size() : b2Var.m();
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public List<SignatureInfo> getSignatureInfosList() {
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            return b2Var == null ? Collections.unmodifiableList(this.signatureInfos_) : b2Var.o();
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public SignatureInfoOrBuilder getSignatureInfosOrBuilder(int i) {
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            return (SignatureInfoOrBuilder) (b2Var == null ? this.signatureInfos_.get(i) : b2Var.p(i));
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public List<? extends SignatureInfoOrBuilder> getSignatureInfosOrBuilderList() {
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            return b2Var != null ? b2Var.q() : Collections.unmodifiableList(this.signatureInfos_);
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public long getStartTimestamp() {
            return this.startTimestamp_;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public boolean hasBatchNum() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public boolean hasBatchSize() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public boolean hasEndTimestamp() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public boolean hasRegion() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder
        public boolean hasStartTimestamp() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // c.b.d.k0.b
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = KeyFile.internal_static_gov_nc_dhhs_exposurenotification_debug_TemporaryExposureKeyExport_fieldAccessorTable;
            fVar.c(TemporaryExposureKeyExport.class, Builder.class);
            return fVar;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.TemporaryExposureKeyExportOrBuilder, c.b.d.k0.b, c.b.d.i1
        public final boolean isInitialized() {
            return true;
        }

        @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public Builder mergeFrom(e1 e1Var) {
            if (e1Var instanceof TemporaryExposureKeyExport) {
                return mergeFrom((TemporaryExposureKeyExport) e1Var);
            }
            super.mergeFrom(e1Var);
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
        @Override // c.b.d.h1.a, c.b.d.b.a, c.b.d.b.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public Builder mergeFrom(k kVar, z zVar) {
            Throwable th;
            TemporaryExposureKeyExport temporaryExposureKeyExport;
            TemporaryExposureKeyExport temporaryExposureKeyExport2 = null;
            try {
                TemporaryExposureKeyExport parsePartialFrom = TemporaryExposureKeyExport.PARSER.parsePartialFrom(kVar, zVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (n0 e2) {
                temporaryExposureKeyExport = (TemporaryExposureKeyExport) e2.f4007b;
                throw e2.j();
            } catch (Throwable th2) {
                th = th2;
                temporaryExposureKeyExport2 = temporaryExposureKeyExport;
                if (temporaryExposureKeyExport2 != null) {
                }
                throw th;
            }
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public final Builder mergeUnknownFields(p2 p2Var) {
            return (Builder) super.mergeUnknownFields(p2Var);
        }

        public Builder removeKeys(int i) {
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var = this.keysBuilder_;
            if (b2Var == null) {
                ensureKeysIsMutable();
                this.keys_.remove(i);
                onChanged();
            } else {
                b2Var.u(i);
            }
            return this;
        }

        public Builder removeSignatureInfos(int i) {
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            if (b2Var == null) {
                ensureSignatureInfosIsMutable();
                this.signatureInfos_.remove(i);
                onChanged();
            } else {
                b2Var.u(i);
            }
            return this;
        }

        public Builder setBatchNum(int i) {
            this.bitField0_ |= 8;
            this.batchNum_ = i;
            onChanged();
            return this;
        }

        public Builder setBatchSize(int i) {
            this.bitField0_ |= 16;
            this.batchSize_ = i;
            onChanged();
            return this;
        }

        public Builder setEndTimestamp(long j) {
            this.bitField0_ |= 2;
            this.endTimestamp_ = j;
            onChanged();
            return this;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
        public Builder setField(s.g gVar, Object obj) {
            return (Builder) super.setField(gVar, obj);
        }

        public Builder setKeys(int i, TemporaryExposureKey.Builder builder) {
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var = this.keysBuilder_;
            if (b2Var == null) {
                ensureKeysIsMutable();
                this.keys_.set(i, builder.build());
                onChanged();
            } else {
                b2Var.v(i, builder.build());
            }
            return this;
        }

        public Builder setKeys(int i, TemporaryExposureKey temporaryExposureKey) {
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var = this.keysBuilder_;
            if (b2Var != null) {
                b2Var.v(i, temporaryExposureKey);
            } else if (temporaryExposureKey != null) {
                ensureKeysIsMutable();
                this.keys_.set(i, temporaryExposureKey);
                onChanged();
            } else {
                throw null;
            }
            return this;
        }

        public Builder setRegion(String str) {
            if (str != null) {
                this.bitField0_ |= 4;
                this.region_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRegionBytes(j jVar) {
            if (jVar != null) {
                this.bitField0_ |= 4;
                this.region_ = jVar;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b
        public Builder setRepeatedField(s.g gVar, int i, Object obj) {
            return (Builder) super.setRepeatedField(gVar, i, obj);
        }

        public Builder setSignatureInfos(int i, SignatureInfo.Builder builder) {
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            if (b2Var == null) {
                ensureSignatureInfosIsMutable();
                this.signatureInfos_.set(i, builder.build());
                onChanged();
            } else {
                b2Var.v(i, builder.build());
            }
            return this;
        }

        public Builder setSignatureInfos(int i, SignatureInfo signatureInfo) {
            b2<SignatureInfo, SignatureInfo.Builder, SignatureInfoOrBuilder> b2Var = this.signatureInfosBuilder_;
            if (b2Var != null) {
                b2Var.v(i, signatureInfo);
            } else if (signatureInfo != null) {
                ensureSignatureInfosIsMutable();
                this.signatureInfos_.set(i, signatureInfo);
                onChanged();
            } else {
                throw null;
            }
            return this;
        }

        public Builder setStartTimestamp(long j) {
            this.bitField0_ |= 1;
            this.startTimestamp_ = j;
            onChanged();
            return this;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
        public final Builder setUnknownFields(p2 p2Var) {
            return (Builder) super.setUnknownFields(p2Var);
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
            b2<TemporaryExposureKey, TemporaryExposureKey.Builder, TemporaryExposureKeyOrBuilder> b2Var = null;
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
                if (this.signatureInfosBuilder_.s()) {
                    this.signatureInfosBuilder_.f3831a = null;
                    this.signatureInfosBuilder_ = null;
                    this.signatureInfos_ = temporaryExposureKeyExport.signatureInfos_;
                    this.bitField0_ &= -33;
                    this.signatureInfosBuilder_ = k0.alwaysUseFieldBuilders ? getSignatureInfosFieldBuilder() : null;
                } else {
                    this.signatureInfosBuilder_.b(temporaryExposureKeyExport.signatureInfos_);
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
                if (this.keysBuilder_.s()) {
                    this.keysBuilder_.f3831a = null;
                    this.keysBuilder_ = null;
                    this.keys_ = temporaryExposureKeyExport.keys_;
                    this.bitField0_ &= -65;
                    if (k0.alwaysUseFieldBuilders) {
                        b2Var = getKeysFieldBuilder();
                    }
                    this.keysBuilder_ = b2Var;
                } else {
                    this.keysBuilder_.b(temporaryExposureKeyExport.keys_);
                }
            }
            mergeUnknownFields(temporaryExposureKeyExport.unknownFields);
            onChanged();
            return this;
        }
    }
}
