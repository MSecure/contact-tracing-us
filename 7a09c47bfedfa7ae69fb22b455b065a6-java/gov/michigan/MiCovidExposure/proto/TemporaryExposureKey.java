package gov.michigan.MiCovidExposure.proto;

import c.b.d.a;
import c.b.d.c;
import c.b.d.f1;
import c.b.d.j;
import c.b.d.k;
import c.b.d.l0;
import c.b.d.m;
import c.b.d.o0;
import c.b.d.q2;
import c.b.d.s;
import c.b.d.w1;
import c.b.d.z;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class TemporaryExposureKey extends l0 implements TemporaryExposureKeyOrBuilder {
    public static final TemporaryExposureKey DEFAULT_INSTANCE = new TemporaryExposureKey();
    public static final int KEY_DATA_FIELD_NUMBER = 1;
    @Deprecated
    public static final w1<TemporaryExposureKey> PARSER = new c<TemporaryExposureKey>() {
        /* class gov.michigan.MiCovidExposure.proto.TemporaryExposureKey.AnonymousClass1 */

        @Override // c.b.d.w1
        public TemporaryExposureKey parsePartialFrom(k kVar, z zVar) {
            return new TemporaryExposureKey(kVar, zVar);
        }
    };
    public static final int ROLLING_PERIOD_FIELD_NUMBER = 4;
    public static final int ROLLING_START_INTERVAL_NUMBER_FIELD_NUMBER = 3;
    public static final int TRANSMISSION_RISK_LEVEL_FIELD_NUMBER = 2;
    public static final long serialVersionUID = 0;
    public int bitField0_;
    public j keyData_;
    public byte memoizedIsInitialized;
    public int rollingPeriod_;
    public int rollingStartIntervalNumber_;
    public int transmissionRiskLevel_;

    public static final class Builder extends l0.b<Builder> implements TemporaryExposureKeyOrBuilder {
        public int bitField0_;
        public j keyData_;
        public int rollingPeriod_;
        public int rollingStartIntervalNumber_;
        public int transmissionRiskLevel_;

        public Builder() {
            this.keyData_ = j.f5320c;
            this.rollingPeriod_ = 144;
            maybeForceBuilderInitialization();
        }

        public Builder(l0.c cVar) {
            super(cVar);
            this.keyData_ = j.f5320c;
            this.rollingPeriod_ = 144;
            maybeForceBuilderInitialization();
        }

        public static final s.b getDescriptor() {
            return KeyFile.internal_static_gov_michigan_MiCovidExposure_TemporaryExposureKey_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = l0.alwaysUseFieldBuilders;
        }

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
        public Builder addRepeatedField(s.g gVar, Object obj) {
            return (Builder) super.addRepeatedField(gVar, obj);
        }

        @Override // c.b.d.i1.a, c.b.d.f1.a
        public TemporaryExposureKey build() {
            TemporaryExposureKey buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0106a.newUninitializedMessageException((f1) buildPartial);
        }

        @Override // c.b.d.i1.a, c.b.d.f1.a
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

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public Builder clear() {
            super.clear();
            this.keyData_ = j.f5320c;
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

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
        public Builder clearField(s.g gVar) {
            return (Builder) super.clearField(gVar);
        }

        public Builder clearKeyData() {
            this.bitField0_ &= -2;
            this.keyData_ = TemporaryExposureKey.getDefaultInstance().getKeyData();
            onChanged();
            return this;
        }

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public Builder clearOneof(s.k kVar) {
            return (Builder) super.clearOneof(kVar);
        }

        public Builder clearRollingPeriod() {
            this.bitField0_ &= -9;
            this.rollingPeriod_ = 144;
            onChanged();
            return this;
        }

        public Builder clearRollingStartIntervalNumber() {
            this.bitField0_ &= -5;
            this.rollingStartIntervalNumber_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTransmissionRiskLevel() {
            this.bitField0_ &= -3;
            this.transmissionRiskLevel_ = 0;
            onChanged();
            return this;
        }

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.b.a, c.b.d.b.a, c.b.d.b.a, java.lang.Object, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // c.b.d.k1, gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder, gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder, c.b.d.j1
        public TemporaryExposureKey getDefaultInstanceForType() {
            return TemporaryExposureKey.getDefaultInstance();
        }

        @Override // c.b.d.l0.b, c.b.d.k1, gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder, c.b.d.f1.a
        public s.b getDescriptorForType() {
            return KeyFile.internal_static_gov_michigan_MiCovidExposure_TemporaryExposureKey_descriptor;
        }

        @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
        public j getKeyData() {
            return this.keyData_;
        }

        @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
        public int getRollingPeriod() {
            return this.rollingPeriod_;
        }

        @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
        public int getRollingStartIntervalNumber() {
            return this.rollingStartIntervalNumber_;
        }

        @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
        public int getTransmissionRiskLevel() {
            return this.transmissionRiskLevel_;
        }

        @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
        public boolean hasKeyData() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
        public boolean hasRollingPeriod() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
        public boolean hasRollingStartIntervalNumber() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
        public boolean hasTransmissionRiskLevel() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // c.b.d.l0.b
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = KeyFile.internal_static_gov_michigan_MiCovidExposure_TemporaryExposureKey_fieldAccessorTable;
            fVar.c(TemporaryExposureKey.class, Builder.class);
            return fVar;
        }

        @Override // c.b.d.l0.b, gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder, c.b.d.j1
        public final boolean isInitialized() {
            return true;
        }

        @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public Builder mergeFrom(f1 f1Var) {
            if (f1Var instanceof TemporaryExposureKey) {
                return mergeFrom((TemporaryExposureKey) f1Var);
            }
            super.mergeFrom(f1Var);
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
        @Override // c.b.d.i1.a, c.b.d.b.a, c.b.d.b.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public Builder mergeFrom(k kVar, z zVar) {
            Throwable th;
            TemporaryExposureKey temporaryExposureKey;
            TemporaryExposureKey temporaryExposureKey2 = null;
            try {
                TemporaryExposureKey parsePartialFrom = TemporaryExposureKey.PARSER.parsePartialFrom(kVar, zVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (o0 e2) {
                temporaryExposureKey = (TemporaryExposureKey) e2.f5447b;
                throw e2.j();
            } catch (Throwable th2) {
                th = th2;
                temporaryExposureKey2 = temporaryExposureKey;
                if (temporaryExposureKey2 != null) {
                }
                throw th;
            }
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

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public final Builder mergeUnknownFields(q2 q2Var) {
            return (Builder) super.mergeUnknownFields(q2Var);
        }

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
        public Builder setField(s.g gVar, Object obj) {
            return (Builder) super.setField(gVar, obj);
        }

        public Builder setKeyData(j jVar) {
            if (jVar != null) {
                this.bitField0_ |= 1;
                this.keyData_ = jVar;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // c.b.d.l0.b, c.b.d.l0.b
        public Builder setRepeatedField(s.g gVar, int i, Object obj) {
            return (Builder) super.setRepeatedField(gVar, i, obj);
        }

        public Builder setRollingPeriod(int i) {
            this.bitField0_ |= 8;
            this.rollingPeriod_ = i;
            onChanged();
            return this;
        }

        public Builder setRollingStartIntervalNumber(int i) {
            this.bitField0_ |= 4;
            this.rollingStartIntervalNumber_ = i;
            onChanged();
            return this;
        }

        public Builder setTransmissionRiskLevel(int i) {
            this.bitField0_ |= 2;
            this.transmissionRiskLevel_ = i;
            onChanged();
            return this;
        }

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
        public final Builder setUnknownFields(q2 q2Var) {
            return (Builder) super.setUnknownFields(q2Var);
        }
    }

    public TemporaryExposureKey() {
        this.memoizedIsInitialized = -1;
        this.keyData_ = j.f5320c;
        this.rollingPeriod_ = 144;
    }

    public TemporaryExposureKey(k kVar, z zVar) {
        this();
        if (zVar != null) {
            q2.b b2 = q2.b();
            boolean z = false;
            while (!z) {
                try {
                    int G = kVar.G();
                    if (G != 0) {
                        if (G == 10) {
                            this.bitField0_ |= 1;
                            this.keyData_ = kVar.n();
                        } else if (G == 16) {
                            this.bitField0_ |= 2;
                            this.transmissionRiskLevel_ = kVar.u();
                        } else if (G == 24) {
                            this.bitField0_ |= 4;
                            this.rollingStartIntervalNumber_ = kVar.u();
                        } else if (G == 32) {
                            this.bitField0_ |= 8;
                            this.rollingPeriod_ = kVar.u();
                        } else if (!parseUnknownField(kVar, b2, zVar, G)) {
                        }
                    }
                    z = true;
                } catch (o0 e2) {
                    e2.f5447b = this;
                    throw e2;
                } catch (IOException e3) {
                    o0 o0Var = new o0(e3);
                    o0Var.f5447b = this;
                    throw o0Var;
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

    public TemporaryExposureKey(l0.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = -1;
    }

    public static TemporaryExposureKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final s.b getDescriptor() {
        return KeyFile.internal_static_gov_michigan_MiCovidExposure_TemporaryExposureKey_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TemporaryExposureKey temporaryExposureKey) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(temporaryExposureKey);
    }

    public static TemporaryExposureKey parseDelimitedFrom(InputStream inputStream) {
        return (TemporaryExposureKey) l0.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static TemporaryExposureKey parseDelimitedFrom(InputStream inputStream, z zVar) {
        return (TemporaryExposureKey) l0.parseDelimitedWithIOException(PARSER, inputStream, zVar);
    }

    public static TemporaryExposureKey parseFrom(j jVar) {
        return PARSER.parseFrom(jVar);
    }

    public static TemporaryExposureKey parseFrom(j jVar, z zVar) {
        return PARSER.parseFrom(jVar, zVar);
    }

    public static TemporaryExposureKey parseFrom(k kVar) {
        return (TemporaryExposureKey) l0.parseWithIOException(PARSER, kVar);
    }

    public static TemporaryExposureKey parseFrom(k kVar, z zVar) {
        return (TemporaryExposureKey) l0.parseWithIOException(PARSER, kVar, zVar);
    }

    public static TemporaryExposureKey parseFrom(InputStream inputStream) {
        return (TemporaryExposureKey) l0.parseWithIOException(PARSER, inputStream);
    }

    public static TemporaryExposureKey parseFrom(InputStream inputStream, z zVar) {
        return (TemporaryExposureKey) l0.parseWithIOException(PARSER, inputStream, zVar);
    }

    public static TemporaryExposureKey parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static TemporaryExposureKey parseFrom(ByteBuffer byteBuffer, z zVar) {
        return PARSER.parseFrom(byteBuffer, zVar);
    }

    public static TemporaryExposureKey parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    public static TemporaryExposureKey parseFrom(byte[] bArr, z zVar) {
        return PARSER.parseFrom(bArr, zVar);
    }

    public static w1<TemporaryExposureKey> parser() {
        return PARSER;
    }

    @Override // c.b.d.a
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
        if ((!hasRollingStartIntervalNumber() || getRollingStartIntervalNumber() == temporaryExposureKey.getRollingStartIntervalNumber()) && hasRollingPeriod() == temporaryExposureKey.hasRollingPeriod()) {
            return (!hasRollingPeriod() || getRollingPeriod() == temporaryExposureKey.getRollingPeriod()) && this.unknownFields.equals(temporaryExposureKey.unknownFields);
        }
        return false;
    }

    @Override // c.b.d.k1, gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder, gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder, c.b.d.j1
    public TemporaryExposureKey getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
    public j getKeyData() {
        return this.keyData_;
    }

    @Override // c.b.d.l0, c.b.d.i1
    public w1<TemporaryExposureKey> getParserForType() {
        return PARSER;
    }

    @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
    public int getRollingPeriod() {
        return this.rollingPeriod_;
    }

    @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
    public int getRollingStartIntervalNumber() {
        return this.rollingStartIntervalNumber_;
    }

    @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.bitField0_ & 1) != 0) {
            i2 = 0 + m.f(1, this.keyData_);
        }
        if ((this.bitField0_ & 2) != 0) {
            i2 += m.s(2, this.transmissionRiskLevel_);
        }
        if ((this.bitField0_ & 4) != 0) {
            i2 += m.s(3, this.rollingStartIntervalNumber_);
        }
        if ((this.bitField0_ & 8) != 0) {
            i2 += m.s(4, this.rollingPeriod_);
        }
        int serializedSize = this.unknownFields.getSerializedSize() + i2;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
    public int getTransmissionRiskLevel() {
        return this.transmissionRiskLevel_;
    }

    @Override // c.b.d.l0, c.b.d.k1, gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
    public final q2 getUnknownFields() {
        return this.unknownFields;
    }

    @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
    public boolean hasKeyData() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
    public boolean hasRollingPeriod() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
    public boolean hasRollingStartIntervalNumber() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder
    public boolean hasTransmissionRiskLevel() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // c.b.d.a
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = getDescriptor().hashCode() + 779;
        if (hasKeyData()) {
            hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + getKeyData().hashCode();
        }
        if (hasTransmissionRiskLevel()) {
            hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + getTransmissionRiskLevel();
        }
        if (hasRollingStartIntervalNumber()) {
            hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + getRollingStartIntervalNumber();
        }
        if (hasRollingPeriod()) {
            hashCode = c.a.a.a.a.a(hashCode, 37, 4, 53) + getRollingPeriod();
        }
        int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // c.b.d.l0
    public l0.f internalGetFieldAccessorTable() {
        l0.f fVar = KeyFile.internal_static_gov_michigan_MiCovidExposure_TemporaryExposureKey_fieldAccessorTable;
        fVar.c(TemporaryExposureKey.class, Builder.class);
        return fVar;
    }

    @Override // c.b.d.l0, c.b.d.a, gov.michigan.MiCovidExposure.proto.TemporaryExposureKeyOrBuilder, c.b.d.j1
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

    @Override // c.b.d.f1, c.b.d.i1
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // c.b.d.l0
    public Builder newBuilderForType(l0.c cVar) {
        return new Builder(cVar);
    }

    @Override // c.b.d.l0
    public Object newInstance(l0.g gVar) {
        return new TemporaryExposureKey();
    }

    @Override // c.b.d.f1, c.b.d.i1
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
    public void writeTo(m mVar) {
        if ((this.bitField0_ & 1) != 0) {
            mVar.a0(1, this.keyData_);
        }
        if ((this.bitField0_ & 2) != 0) {
            mVar.i0(2, this.transmissionRiskLevel_);
        }
        if ((this.bitField0_ & 4) != 0) {
            mVar.i0(3, this.rollingStartIntervalNumber_);
        }
        if ((this.bitField0_ & 8) != 0) {
            mVar.i0(4, this.rollingPeriod_);
        }
        this.unknownFields.writeTo(mVar);
    }
}
