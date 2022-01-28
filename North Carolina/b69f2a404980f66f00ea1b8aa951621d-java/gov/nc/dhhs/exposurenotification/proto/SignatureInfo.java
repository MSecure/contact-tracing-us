package gov.nc.dhhs.exposurenotification.proto;

import c.b.d.a;
import c.b.d.c;
import c.b.d.e1;
import c.b.d.j;
import c.b.d.k;
import c.b.d.k0;
import c.b.d.m;
import c.b.d.n0;
import c.b.d.p2;
import c.b.d.s;
import c.b.d.v1;
import c.b.d.z;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class SignatureInfo extends k0 implements SignatureInfoOrBuilder {
    public static final int ANDROID_PACKAGE_FIELD_NUMBER = 2;
    public static final int APP_BUNDLE_ID_FIELD_NUMBER = 1;
    public static final SignatureInfo DEFAULT_INSTANCE = new SignatureInfo();
    @Deprecated
    public static final v1<SignatureInfo> PARSER = new c<SignatureInfo>() {
        /* class gov.nc.dhhs.exposurenotification.proto.SignatureInfo.AnonymousClass1 */

        @Override // c.b.d.v1
        public SignatureInfo parsePartialFrom(k kVar, z zVar) {
            return new SignatureInfo(kVar, zVar);
        }
    };
    public static final int SIGNATURE_ALGORITHM_FIELD_NUMBER = 5;
    public static final int VERIFICATION_KEY_ID_FIELD_NUMBER = 4;
    public static final int VERIFICATION_KEY_VERSION_FIELD_NUMBER = 3;
    public static final long serialVersionUID = 0;
    public volatile Object androidPackage_;
    public volatile Object appBundleId_;
    public int bitField0_;
    public byte memoizedIsInitialized;
    public volatile Object signatureAlgorithm_;
    public volatile Object verificationKeyId_;
    public volatile Object verificationKeyVersion_;

    public static final class Builder extends k0.b<Builder> implements SignatureInfoOrBuilder {
        public Object androidPackage_;
        public Object appBundleId_;
        public int bitField0_;
        public Object signatureAlgorithm_;
        public Object verificationKeyId_;
        public Object verificationKeyVersion_;

        public Builder() {
            this.appBundleId_ = "";
            this.androidPackage_ = "";
            this.verificationKeyVersion_ = "";
            this.verificationKeyId_ = "";
            this.signatureAlgorithm_ = "";
            maybeForceBuilderInitialization();
        }

        public Builder(k0.c cVar) {
            super(cVar);
            this.appBundleId_ = "";
            this.androidPackage_ = "";
            this.verificationKeyVersion_ = "";
            this.verificationKeyId_ = "";
            this.signatureAlgorithm_ = "";
            maybeForceBuilderInitialization();
        }

        public static final s.b getDescriptor() {
            return KeyFile.internal_static_gov_nc_dhhs_exposurenotification_debug_SignatureInfo_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = k0.alwaysUseFieldBuilders;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
        public Builder addRepeatedField(s.g gVar, Object obj) {
            return (Builder) super.addRepeatedField(gVar, obj);
        }

        @Override // c.b.d.h1.a, c.b.d.e1.a
        public SignatureInfo build() {
            SignatureInfo buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0097a.newUninitializedMessageException((e1) buildPartial);
        }

        @Override // c.b.d.h1.a, c.b.d.e1.a
        public SignatureInfo buildPartial() {
            SignatureInfo signatureInfo = new SignatureInfo(this);
            int i = this.bitField0_;
            int i2 = (i & 1) != 0 ? 1 : 0;
            signatureInfo.appBundleId_ = this.appBundleId_;
            if ((i & 2) != 0) {
                i2 |= 2;
            }
            signatureInfo.androidPackage_ = this.androidPackage_;
            if ((i & 4) != 0) {
                i2 |= 4;
            }
            signatureInfo.verificationKeyVersion_ = this.verificationKeyVersion_;
            if ((i & 8) != 0) {
                i2 |= 8;
            }
            signatureInfo.verificationKeyId_ = this.verificationKeyId_;
            if ((i & 16) != 0) {
                i2 |= 16;
            }
            signatureInfo.signatureAlgorithm_ = this.signatureAlgorithm_;
            signatureInfo.bitField0_ = i2;
            onBuilt();
            return signatureInfo;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public Builder clear() {
            super.clear();
            this.appBundleId_ = "";
            int i = this.bitField0_ & -2;
            this.bitField0_ = i;
            this.androidPackage_ = "";
            int i2 = i & -3;
            this.bitField0_ = i2;
            this.verificationKeyVersion_ = "";
            int i3 = i2 & -5;
            this.bitField0_ = i3;
            this.verificationKeyId_ = "";
            int i4 = i3 & -9;
            this.bitField0_ = i4;
            this.signatureAlgorithm_ = "";
            this.bitField0_ = i4 & -17;
            return this;
        }

        public Builder clearAndroidPackage() {
            this.bitField0_ &= -3;
            this.androidPackage_ = SignatureInfo.getDefaultInstance().getAndroidPackage();
            onChanged();
            return this;
        }

        public Builder clearAppBundleId() {
            this.bitField0_ &= -2;
            this.appBundleId_ = SignatureInfo.getDefaultInstance().getAppBundleId();
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

        public Builder clearSignatureAlgorithm() {
            this.bitField0_ &= -17;
            this.signatureAlgorithm_ = SignatureInfo.getDefaultInstance().getSignatureAlgorithm();
            onChanged();
            return this;
        }

        public Builder clearVerificationKeyId() {
            this.bitField0_ &= -9;
            this.verificationKeyId_ = SignatureInfo.getDefaultInstance().getVerificationKeyId();
            onChanged();
            return this;
        }

        public Builder clearVerificationKeyVersion() {
            this.bitField0_ &= -5;
            this.verificationKeyVersion_ = SignatureInfo.getDefaultInstance().getVerificationKeyVersion();
            onChanged();
            return this;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.b.a, c.b.d.b.a, c.b.d.b.a, java.lang.Object, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
        public String getAndroidPackage() {
            Object obj = this.androidPackage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.androidPackage_ = u;
            }
            return u;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
        public j getAndroidPackageBytes() {
            Object obj = this.androidPackage_;
            if (!(obj instanceof String)) {
                return (j) obj;
            }
            j j = j.j((String) obj);
            this.androidPackage_ = j;
            return j;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
        public String getAppBundleId() {
            Object obj = this.appBundleId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.appBundleId_ = u;
            }
            return u;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
        public j getAppBundleIdBytes() {
            Object obj = this.appBundleId_;
            if (!(obj instanceof String)) {
                return (j) obj;
            }
            j j = j.j((String) obj);
            this.appBundleId_ = j;
            return j;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder, gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder, c.b.d.j1, c.b.d.i1
        public SignatureInfo getDefaultInstanceForType() {
            return SignatureInfo.getDefaultInstance();
        }

        @Override // c.b.d.k0.b, gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder, c.b.d.e1.a, c.b.d.j1
        public s.b getDescriptorForType() {
            return KeyFile.internal_static_gov_nc_dhhs_exposurenotification_debug_SignatureInfo_descriptor;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
        public String getSignatureAlgorithm() {
            Object obj = this.signatureAlgorithm_;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.signatureAlgorithm_ = u;
            }
            return u;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
        public j getSignatureAlgorithmBytes() {
            Object obj = this.signatureAlgorithm_;
            if (!(obj instanceof String)) {
                return (j) obj;
            }
            j j = j.j((String) obj);
            this.signatureAlgorithm_ = j;
            return j;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
        public String getVerificationKeyId() {
            Object obj = this.verificationKeyId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.verificationKeyId_ = u;
            }
            return u;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
        public j getVerificationKeyIdBytes() {
            Object obj = this.verificationKeyId_;
            if (!(obj instanceof String)) {
                return (j) obj;
            }
            j j = j.j((String) obj);
            this.verificationKeyId_ = j;
            return j;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
        public String getVerificationKeyVersion() {
            Object obj = this.verificationKeyVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.verificationKeyVersion_ = u;
            }
            return u;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
        public j getVerificationKeyVersionBytes() {
            Object obj = this.verificationKeyVersion_;
            if (!(obj instanceof String)) {
                return (j) obj;
            }
            j j = j.j((String) obj);
            this.verificationKeyVersion_ = j;
            return j;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
        public boolean hasAndroidPackage() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
        public boolean hasAppBundleId() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
        public boolean hasSignatureAlgorithm() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
        public boolean hasVerificationKeyId() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
        public boolean hasVerificationKeyVersion() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // c.b.d.k0.b
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = KeyFile.internal_static_gov_nc_dhhs_exposurenotification_debug_SignatureInfo_fieldAccessorTable;
            fVar.c(SignatureInfo.class, Builder.class);
            return fVar;
        }

        @Override // c.b.d.k0.b, gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder, c.b.d.i1
        public final boolean isInitialized() {
            return true;
        }

        @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public Builder mergeFrom(e1 e1Var) {
            if (e1Var instanceof SignatureInfo) {
                return mergeFrom((SignatureInfo) e1Var);
            }
            super.mergeFrom(e1Var);
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
        @Override // c.b.d.h1.a, c.b.d.b.a, c.b.d.b.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public Builder mergeFrom(k kVar, z zVar) {
            Throwable th;
            SignatureInfo signatureInfo;
            SignatureInfo signatureInfo2 = null;
            try {
                SignatureInfo parsePartialFrom = SignatureInfo.PARSER.parsePartialFrom(kVar, zVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (n0 e2) {
                signatureInfo = (SignatureInfo) e2.f4007b;
                throw e2.j();
            } catch (Throwable th2) {
                th = th2;
                signatureInfo2 = signatureInfo;
                if (signatureInfo2 != null) {
                }
                throw th;
            }
        }

        public Builder mergeFrom(SignatureInfo signatureInfo) {
            if (signatureInfo == SignatureInfo.getDefaultInstance()) {
                return this;
            }
            if (signatureInfo.hasAppBundleId()) {
                this.bitField0_ |= 1;
                this.appBundleId_ = signatureInfo.appBundleId_;
                onChanged();
            }
            if (signatureInfo.hasAndroidPackage()) {
                this.bitField0_ |= 2;
                this.androidPackage_ = signatureInfo.androidPackage_;
                onChanged();
            }
            if (signatureInfo.hasVerificationKeyVersion()) {
                this.bitField0_ |= 4;
                this.verificationKeyVersion_ = signatureInfo.verificationKeyVersion_;
                onChanged();
            }
            if (signatureInfo.hasVerificationKeyId()) {
                this.bitField0_ |= 8;
                this.verificationKeyId_ = signatureInfo.verificationKeyId_;
                onChanged();
            }
            if (signatureInfo.hasSignatureAlgorithm()) {
                this.bitField0_ |= 16;
                this.signatureAlgorithm_ = signatureInfo.signatureAlgorithm_;
                onChanged();
            }
            mergeUnknownFields(signatureInfo.unknownFields);
            onChanged();
            return this;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public final Builder mergeUnknownFields(p2 p2Var) {
            return (Builder) super.mergeUnknownFields(p2Var);
        }

        public Builder setAndroidPackage(String str) {
            if (str != null) {
                this.bitField0_ |= 2;
                this.androidPackage_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAndroidPackageBytes(j jVar) {
            if (jVar != null) {
                this.bitField0_ |= 2;
                this.androidPackage_ = jVar;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAppBundleId(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.appBundleId_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAppBundleIdBytes(j jVar) {
            if (jVar != null) {
                this.bitField0_ |= 1;
                this.appBundleId_ = jVar;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
        public Builder setField(s.g gVar, Object obj) {
            return (Builder) super.setField(gVar, obj);
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b
        public Builder setRepeatedField(s.g gVar, int i, Object obj) {
            return (Builder) super.setRepeatedField(gVar, i, obj);
        }

        public Builder setSignatureAlgorithm(String str) {
            if (str != null) {
                this.bitField0_ |= 16;
                this.signatureAlgorithm_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setSignatureAlgorithmBytes(j jVar) {
            if (jVar != null) {
                this.bitField0_ |= 16;
                this.signatureAlgorithm_ = jVar;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
        public final Builder setUnknownFields(p2 p2Var) {
            return (Builder) super.setUnknownFields(p2Var);
        }

        public Builder setVerificationKeyId(String str) {
            if (str != null) {
                this.bitField0_ |= 8;
                this.verificationKeyId_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setVerificationKeyIdBytes(j jVar) {
            if (jVar != null) {
                this.bitField0_ |= 8;
                this.verificationKeyId_ = jVar;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setVerificationKeyVersion(String str) {
            if (str != null) {
                this.bitField0_ |= 4;
                this.verificationKeyVersion_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setVerificationKeyVersionBytes(j jVar) {
            if (jVar != null) {
                this.bitField0_ |= 4;
                this.verificationKeyVersion_ = jVar;
                onChanged();
                return this;
            }
            throw null;
        }
    }

    public SignatureInfo() {
        this.memoizedIsInitialized = -1;
        this.appBundleId_ = "";
        this.androidPackage_ = "";
        this.verificationKeyVersion_ = "";
        this.verificationKeyId_ = "";
        this.signatureAlgorithm_ = "";
    }

    public SignatureInfo(k0.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = -1;
    }

    public SignatureInfo(k kVar, z zVar) {
        this();
        if (zVar != null) {
            p2.b b2 = p2.b();
            boolean z = false;
            while (!z) {
                try {
                    int G = kVar.G();
                    if (G != 0) {
                        if (G == 10) {
                            j n = kVar.n();
                            this.bitField0_ = 1 | this.bitField0_;
                            this.appBundleId_ = n;
                        } else if (G == 18) {
                            j n2 = kVar.n();
                            this.bitField0_ |= 2;
                            this.androidPackage_ = n2;
                        } else if (G == 26) {
                            j n3 = kVar.n();
                            this.bitField0_ |= 4;
                            this.verificationKeyVersion_ = n3;
                        } else if (G == 34) {
                            j n4 = kVar.n();
                            this.bitField0_ |= 8;
                            this.verificationKeyId_ = n4;
                        } else if (G == 42) {
                            j n5 = kVar.n();
                            this.bitField0_ |= 16;
                            this.signatureAlgorithm_ = n5;
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

    public static SignatureInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final s.b getDescriptor() {
        return KeyFile.internal_static_gov_nc_dhhs_exposurenotification_debug_SignatureInfo_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(SignatureInfo signatureInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(signatureInfo);
    }

    public static SignatureInfo parseDelimitedFrom(InputStream inputStream) {
        return (SignatureInfo) k0.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static SignatureInfo parseDelimitedFrom(InputStream inputStream, z zVar) {
        return (SignatureInfo) k0.parseDelimitedWithIOException(PARSER, inputStream, zVar);
    }

    public static SignatureInfo parseFrom(j jVar) {
        return PARSER.parseFrom(jVar);
    }

    public static SignatureInfo parseFrom(j jVar, z zVar) {
        return PARSER.parseFrom(jVar, zVar);
    }

    public static SignatureInfo parseFrom(k kVar) {
        return (SignatureInfo) k0.parseWithIOException(PARSER, kVar);
    }

    public static SignatureInfo parseFrom(k kVar, z zVar) {
        return (SignatureInfo) k0.parseWithIOException(PARSER, kVar, zVar);
    }

    public static SignatureInfo parseFrom(InputStream inputStream) {
        return (SignatureInfo) k0.parseWithIOException(PARSER, inputStream);
    }

    public static SignatureInfo parseFrom(InputStream inputStream, z zVar) {
        return (SignatureInfo) k0.parseWithIOException(PARSER, inputStream, zVar);
    }

    public static SignatureInfo parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static SignatureInfo parseFrom(ByteBuffer byteBuffer, z zVar) {
        return PARSER.parseFrom(byteBuffer, zVar);
    }

    public static SignatureInfo parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    public static SignatureInfo parseFrom(byte[] bArr, z zVar) {
        return PARSER.parseFrom(bArr, zVar);
    }

    public static v1<SignatureInfo> parser() {
        return PARSER;
    }

    @Override // c.b.d.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignatureInfo)) {
            return super.equals(obj);
        }
        SignatureInfo signatureInfo = (SignatureInfo) obj;
        if (hasAppBundleId() != signatureInfo.hasAppBundleId()) {
            return false;
        }
        if ((hasAppBundleId() && !getAppBundleId().equals(signatureInfo.getAppBundleId())) || hasAndroidPackage() != signatureInfo.hasAndroidPackage()) {
            return false;
        }
        if ((hasAndroidPackage() && !getAndroidPackage().equals(signatureInfo.getAndroidPackage())) || hasVerificationKeyVersion() != signatureInfo.hasVerificationKeyVersion()) {
            return false;
        }
        if ((hasVerificationKeyVersion() && !getVerificationKeyVersion().equals(signatureInfo.getVerificationKeyVersion())) || hasVerificationKeyId() != signatureInfo.hasVerificationKeyId()) {
            return false;
        }
        if ((!hasVerificationKeyId() || getVerificationKeyId().equals(signatureInfo.getVerificationKeyId())) && hasSignatureAlgorithm() == signatureInfo.hasSignatureAlgorithm()) {
            return (!hasSignatureAlgorithm() || getSignatureAlgorithm().equals(signatureInfo.getSignatureAlgorithm())) && this.unknownFields.equals(signatureInfo.unknownFields);
        }
        return false;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
    public String getAndroidPackage() {
        Object obj = this.androidPackage_;
        if (obj instanceof String) {
            return (String) obj;
        }
        j jVar = (j) obj;
        String u = jVar.u();
        if (jVar.o()) {
            this.androidPackage_ = u;
        }
        return u;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
    public j getAndroidPackageBytes() {
        Object obj = this.androidPackage_;
        if (!(obj instanceof String)) {
            return (j) obj;
        }
        j j = j.j((String) obj);
        this.androidPackage_ = j;
        return j;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
    public String getAppBundleId() {
        Object obj = this.appBundleId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        j jVar = (j) obj;
        String u = jVar.u();
        if (jVar.o()) {
            this.appBundleId_ = u;
        }
        return u;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
    public j getAppBundleIdBytes() {
        Object obj = this.appBundleId_;
        if (!(obj instanceof String)) {
            return (j) obj;
        }
        j j = j.j((String) obj);
        this.appBundleId_ = j;
        return j;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder, gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder, c.b.d.j1, c.b.d.i1
    public SignatureInfo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // c.b.d.k0, c.b.d.h1
    public v1<SignatureInfo> getParserForType() {
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
            i2 = 0 + k0.computeStringSize(1, this.appBundleId_);
        }
        if ((this.bitField0_ & 2) != 0) {
            i2 += k0.computeStringSize(2, this.androidPackage_);
        }
        if ((this.bitField0_ & 4) != 0) {
            i2 += k0.computeStringSize(3, this.verificationKeyVersion_);
        }
        if ((this.bitField0_ & 8) != 0) {
            i2 += k0.computeStringSize(4, this.verificationKeyId_);
        }
        if ((this.bitField0_ & 16) != 0) {
            i2 += k0.computeStringSize(5, this.signatureAlgorithm_);
        }
        int serializedSize = this.unknownFields.getSerializedSize() + i2;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
    public String getSignatureAlgorithm() {
        Object obj = this.signatureAlgorithm_;
        if (obj instanceof String) {
            return (String) obj;
        }
        j jVar = (j) obj;
        String u = jVar.u();
        if (jVar.o()) {
            this.signatureAlgorithm_ = u;
        }
        return u;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
    public j getSignatureAlgorithmBytes() {
        Object obj = this.signatureAlgorithm_;
        if (!(obj instanceof String)) {
            return (j) obj;
        }
        j j = j.j((String) obj);
        this.signatureAlgorithm_ = j;
        return j;
    }

    @Override // c.b.d.k0, gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder, c.b.d.j1
    public final p2 getUnknownFields() {
        return this.unknownFields;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
    public String getVerificationKeyId() {
        Object obj = this.verificationKeyId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        j jVar = (j) obj;
        String u = jVar.u();
        if (jVar.o()) {
            this.verificationKeyId_ = u;
        }
        return u;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
    public j getVerificationKeyIdBytes() {
        Object obj = this.verificationKeyId_;
        if (!(obj instanceof String)) {
            return (j) obj;
        }
        j j = j.j((String) obj);
        this.verificationKeyId_ = j;
        return j;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
    public String getVerificationKeyVersion() {
        Object obj = this.verificationKeyVersion_;
        if (obj instanceof String) {
            return (String) obj;
        }
        j jVar = (j) obj;
        String u = jVar.u();
        if (jVar.o()) {
            this.verificationKeyVersion_ = u;
        }
        return u;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
    public j getVerificationKeyVersionBytes() {
        Object obj = this.verificationKeyVersion_;
        if (!(obj instanceof String)) {
            return (j) obj;
        }
        j j = j.j((String) obj);
        this.verificationKeyVersion_ = j;
        return j;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
    public boolean hasAndroidPackage() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
    public boolean hasAppBundleId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
    public boolean hasSignatureAlgorithm() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
    public boolean hasVerificationKeyId() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder
    public boolean hasVerificationKeyVersion() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // c.b.d.a
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = getDescriptor().hashCode() + 779;
        if (hasAppBundleId()) {
            hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + getAppBundleId().hashCode();
        }
        if (hasAndroidPackage()) {
            hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + getAndroidPackage().hashCode();
        }
        if (hasVerificationKeyVersion()) {
            hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + getVerificationKeyVersion().hashCode();
        }
        if (hasVerificationKeyId()) {
            hashCode = c.a.a.a.a.a(hashCode, 37, 4, 53) + getVerificationKeyId().hashCode();
        }
        if (hasSignatureAlgorithm()) {
            hashCode = c.a.a.a.a.a(hashCode, 37, 5, 53) + getSignatureAlgorithm().hashCode();
        }
        int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // c.b.d.k0
    public k0.f internalGetFieldAccessorTable() {
        k0.f fVar = KeyFile.internal_static_gov_nc_dhhs_exposurenotification_debug_SignatureInfo_fieldAccessorTable;
        fVar.c(SignatureInfo.class, Builder.class);
        return fVar;
    }

    @Override // c.b.d.k0, c.b.d.a, gov.nc.dhhs.exposurenotification.proto.SignatureInfoOrBuilder, c.b.d.i1
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
        return new SignatureInfo();
    }

    @Override // c.b.d.e1, c.b.d.h1
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
    public void writeTo(m mVar) {
        if ((this.bitField0_ & 1) != 0) {
            k0.writeString(mVar, 1, this.appBundleId_);
        }
        if ((this.bitField0_ & 2) != 0) {
            k0.writeString(mVar, 2, this.androidPackage_);
        }
        if ((this.bitField0_ & 4) != 0) {
            k0.writeString(mVar, 3, this.verificationKeyVersion_);
        }
        if ((this.bitField0_ & 8) != 0) {
            k0.writeString(mVar, 4, this.verificationKeyId_);
        }
        if ((this.bitField0_ & 16) != 0) {
            k0.writeString(mVar, 5, this.signatureAlgorithm_);
        }
        this.unknownFields.writeTo(mVar);
    }
}
