package gov.michigan.MiCovidExposure.proto;

import c.a.a.a.a;
import c.b.d.a;
import c.b.d.b;
import c.b.d.c;
import c.b.d.c2;
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
import gov.michigan.MiCovidExposure.proto.TEKSignature;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TEKSignatureList extends l0 implements TEKSignatureListOrBuilder {
    public static final TEKSignatureList DEFAULT_INSTANCE = new TEKSignatureList();
    @Deprecated
    public static final w1<TEKSignatureList> PARSER = new c<TEKSignatureList>() {
        /* class gov.michigan.MiCovidExposure.proto.TEKSignatureList.AnonymousClass1 */

        @Override // c.b.d.w1
        public TEKSignatureList parsePartialFrom(k kVar, z zVar) {
            return new TEKSignatureList(kVar, zVar);
        }
    };
    public static final int SIGNATURES_FIELD_NUMBER = 1;
    public static final long serialVersionUID = 0;
    public byte memoizedIsInitialized;
    public List<TEKSignature> signatures_;

    public TEKSignatureList() {
        this.memoizedIsInitialized = -1;
        this.signatures_ = Collections.emptyList();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: java.util.List<gov.michigan.MiCovidExposure.proto.TEKSignature> */
    /* JADX WARN: Multi-variable type inference failed */
    public TEKSignatureList(k kVar, z zVar) {
        this();
        if (zVar != null) {
            q2.b b2 = q2.b();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int G = kVar.G();
                    if (G != 0) {
                        if (G == 10) {
                            if (!z2 || !true) {
                                this.signatures_ = new ArrayList();
                                z2 |= true;
                            }
                            this.signatures_.add(kVar.w(TEKSignature.PARSER, zVar));
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
                    if (z2 && true) {
                        this.signatures_ = Collections.unmodifiableList(this.signatures_);
                    }
                    this.unknownFields = b2.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.signatures_ = Collections.unmodifiableList(this.signatures_);
            }
            this.unknownFields = b2.build();
            makeExtensionsImmutable();
            return;
        }
        throw null;
    }

    public TEKSignatureList(l0.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = -1;
    }

    public static TEKSignatureList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final s.b getDescriptor() {
        return KeyFile.internal_static_gov_michigan_MiCovidExposure_TEKSignatureList_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TEKSignatureList tEKSignatureList) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(tEKSignatureList);
    }

    public static TEKSignatureList parseDelimitedFrom(InputStream inputStream) {
        return (TEKSignatureList) l0.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static TEKSignatureList parseDelimitedFrom(InputStream inputStream, z zVar) {
        return (TEKSignatureList) l0.parseDelimitedWithIOException(PARSER, inputStream, zVar);
    }

    public static TEKSignatureList parseFrom(j jVar) {
        return PARSER.parseFrom(jVar);
    }

    public static TEKSignatureList parseFrom(j jVar, z zVar) {
        return PARSER.parseFrom(jVar, zVar);
    }

    public static TEKSignatureList parseFrom(k kVar) {
        return (TEKSignatureList) l0.parseWithIOException(PARSER, kVar);
    }

    public static TEKSignatureList parseFrom(k kVar, z zVar) {
        return (TEKSignatureList) l0.parseWithIOException(PARSER, kVar, zVar);
    }

    public static TEKSignatureList parseFrom(InputStream inputStream) {
        return (TEKSignatureList) l0.parseWithIOException(PARSER, inputStream);
    }

    public static TEKSignatureList parseFrom(InputStream inputStream, z zVar) {
        return (TEKSignatureList) l0.parseWithIOException(PARSER, inputStream, zVar);
    }

    public static TEKSignatureList parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static TEKSignatureList parseFrom(ByteBuffer byteBuffer, z zVar) {
        return PARSER.parseFrom(byteBuffer, zVar);
    }

    public static TEKSignatureList parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    public static TEKSignatureList parseFrom(byte[] bArr, z zVar) {
        return PARSER.parseFrom(bArr, zVar);
    }

    public static w1<TEKSignatureList> parser() {
        return PARSER;
    }

    @Override // c.b.d.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TEKSignatureList)) {
            return super.equals(obj);
        }
        TEKSignatureList tEKSignatureList = (TEKSignatureList) obj;
        return getSignaturesList().equals(tEKSignatureList.getSignaturesList()) && this.unknownFields.equals(tEKSignatureList.unknownFields);
    }

    @Override // gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder, gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder, c.b.d.k1, c.b.d.j1
    public TEKSignatureList getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // c.b.d.l0, c.b.d.i1
    public w1<TEKSignatureList> getParserForType() {
        return PARSER;
    }

    @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.signatures_.size(); i3++) {
            i2 += m.z(1, this.signatures_.get(i3));
        }
        int serializedSize = this.unknownFields.getSerializedSize() + i2;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder
    public TEKSignature getSignatures(int i) {
        return this.signatures_.get(i);
    }

    @Override // gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder
    public int getSignaturesCount() {
        return this.signatures_.size();
    }

    @Override // gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder
    public List<TEKSignature> getSignaturesList() {
        return this.signatures_;
    }

    @Override // gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder
    public TEKSignatureOrBuilder getSignaturesOrBuilder(int i) {
        return this.signatures_.get(i);
    }

    @Override // gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder
    public List<? extends TEKSignatureOrBuilder> getSignaturesOrBuilderList() {
        return this.signatures_;
    }

    @Override // c.b.d.l0, gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder, c.b.d.k1
    public final q2 getUnknownFields() {
        return this.unknownFields;
    }

    @Override // c.b.d.a
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = getDescriptor().hashCode() + 779;
        if (getSignaturesCount() > 0) {
            hashCode = a.a(hashCode, 37, 1, 53) + getSignaturesList().hashCode();
        }
        int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // c.b.d.l0
    public l0.f internalGetFieldAccessorTable() {
        l0.f fVar = KeyFile.internal_static_gov_michigan_MiCovidExposure_TEKSignatureList_fieldAccessorTable;
        fVar.c(TEKSignatureList.class, Builder.class);
        return fVar;
    }

    @Override // c.b.d.l0, gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder, c.b.d.a, c.b.d.j1
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
        return new TEKSignatureList();
    }

    @Override // c.b.d.f1, c.b.d.i1
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
    public void writeTo(m mVar) {
        for (int i = 0; i < this.signatures_.size(); i++) {
            mVar.k0(1, this.signatures_.get(i));
        }
        this.unknownFields.writeTo(mVar);
    }

    public static final class Builder extends l0.b<Builder> implements TEKSignatureListOrBuilder {
        public int bitField0_;
        public c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> signaturesBuilder_;
        public List<TEKSignature> signatures_;

        public Builder() {
            this.signatures_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder(l0.c cVar) {
            super(cVar);
            this.signatures_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureSignaturesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.signatures_ = new ArrayList(this.signatures_);
                this.bitField0_ |= 1;
            }
        }

        public static final s.b getDescriptor() {
            return KeyFile.internal_static_gov_michigan_MiCovidExposure_TEKSignatureList_descriptor;
        }

        private c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> getSignaturesFieldBuilder() {
            if (this.signaturesBuilder_ == null) {
                List<TEKSignature> list = this.signatures_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.signaturesBuilder_ = new c2<>(list, z, getParentForChildren(), isClean());
                this.signatures_ = null;
            }
            return this.signaturesBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (l0.alwaysUseFieldBuilders) {
                getSignaturesFieldBuilder();
            }
        }

        public Builder addAllSignatures(Iterable<? extends TEKSignature> iterable) {
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            if (c2Var == null) {
                ensureSignaturesIsMutable();
                b.a.addAll((Iterable) iterable, (List) this.signatures_);
                onChanged();
            } else {
                c2Var.b(iterable);
            }
            return this;
        }

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
        public Builder addRepeatedField(s.g gVar, Object obj) {
            return (Builder) super.addRepeatedField(gVar, obj);
        }

        public Builder addSignatures(int i, TEKSignature.Builder builder) {
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            if (c2Var == null) {
                ensureSignaturesIsMutable();
                this.signatures_.add(i, builder.build());
                onChanged();
            } else {
                c2Var.e(i, builder.build());
            }
            return this;
        }

        public Builder addSignatures(int i, TEKSignature tEKSignature) {
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            if (c2Var != null) {
                c2Var.e(i, tEKSignature);
            } else if (tEKSignature != null) {
                ensureSignaturesIsMutable();
                this.signatures_.add(i, tEKSignature);
                onChanged();
            } else {
                throw null;
            }
            return this;
        }

        public Builder addSignatures(TEKSignature.Builder builder) {
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            if (c2Var == null) {
                ensureSignaturesIsMutable();
                this.signatures_.add(builder.build());
                onChanged();
            } else {
                c2Var.f(builder.build());
            }
            return this;
        }

        public Builder addSignatures(TEKSignature tEKSignature) {
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            if (c2Var != null) {
                c2Var.f(tEKSignature);
            } else if (tEKSignature != null) {
                ensureSignaturesIsMutable();
                this.signatures_.add(tEKSignature);
                onChanged();
            } else {
                throw null;
            }
            return this;
        }

        public TEKSignature.Builder addSignaturesBuilder() {
            return getSignaturesFieldBuilder().d(TEKSignature.getDefaultInstance());
        }

        public TEKSignature.Builder addSignaturesBuilder(int i) {
            return getSignaturesFieldBuilder().c(i, TEKSignature.getDefaultInstance());
        }

        @Override // c.b.d.i1.a, c.b.d.f1.a
        public TEKSignatureList build() {
            TEKSignatureList buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0106a.newUninitializedMessageException((f1) buildPartial);
        }

        @Override // c.b.d.i1.a, c.b.d.f1.a
        public TEKSignatureList buildPartial() {
            List<TEKSignature> list;
            TEKSignatureList tEKSignatureList = new TEKSignatureList(this);
            int i = this.bitField0_;
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            if (c2Var == null) {
                if ((i & 1) != 0) {
                    this.signatures_ = Collections.unmodifiableList(this.signatures_);
                    this.bitField0_ &= -2;
                }
                list = this.signatures_;
            } else {
                list = c2Var.g();
            }
            tEKSignatureList.signatures_ = list;
            onBuilt();
            return tEKSignatureList;
        }

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public Builder clear() {
            super.clear();
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            if (c2Var == null) {
                this.signatures_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                c2Var.h();
            }
            return this;
        }

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
        public Builder clearField(s.g gVar) {
            return (Builder) super.clearField(gVar);
        }

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public Builder clearOneof(s.k kVar) {
            return (Builder) super.clearOneof(kVar);
        }

        public Builder clearSignatures() {
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            if (c2Var == null) {
                this.signatures_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                c2Var.h();
            }
            return this;
        }

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.b.a, c.b.d.b.a, c.b.d.b.a, java.lang.Object, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder, gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder, c.b.d.k1, c.b.d.j1
        public TEKSignatureList getDefaultInstanceForType() {
            return TEKSignatureList.getDefaultInstance();
        }

        @Override // c.b.d.l0.b, gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder, c.b.d.k1, c.b.d.f1.a
        public s.b getDescriptorForType() {
            return KeyFile.internal_static_gov_michigan_MiCovidExposure_TEKSignatureList_descriptor;
        }

        @Override // gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder
        public TEKSignature getSignatures(int i) {
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            return c2Var == null ? this.signatures_.get(i) : c2Var.n(i, false);
        }

        public TEKSignature.Builder getSignaturesBuilder(int i) {
            return getSignaturesFieldBuilder().k(i);
        }

        public List<TEKSignature.Builder> getSignaturesBuilderList() {
            return getSignaturesFieldBuilder().l();
        }

        @Override // gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder
        public int getSignaturesCount() {
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            return c2Var == null ? this.signatures_.size() : c2Var.m();
        }

        @Override // gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder
        public List<TEKSignature> getSignaturesList() {
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            return c2Var == null ? Collections.unmodifiableList(this.signatures_) : c2Var.o();
        }

        @Override // gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder
        public TEKSignatureOrBuilder getSignaturesOrBuilder(int i) {
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            return (TEKSignatureOrBuilder) (c2Var == null ? this.signatures_.get(i) : c2Var.p(i));
        }

        @Override // gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder
        public List<? extends TEKSignatureOrBuilder> getSignaturesOrBuilderList() {
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            return c2Var != null ? c2Var.q() : Collections.unmodifiableList(this.signatures_);
        }

        @Override // c.b.d.l0.b
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = KeyFile.internal_static_gov_michigan_MiCovidExposure_TEKSignatureList_fieldAccessorTable;
            fVar.c(TEKSignatureList.class, Builder.class);
            return fVar;
        }

        @Override // c.b.d.l0.b, gov.michigan.MiCovidExposure.proto.TEKSignatureListOrBuilder, c.b.d.j1
        public final boolean isInitialized() {
            return true;
        }

        @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public Builder mergeFrom(f1 f1Var) {
            if (f1Var instanceof TEKSignatureList) {
                return mergeFrom((TEKSignatureList) f1Var);
            }
            super.mergeFrom(f1Var);
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
        @Override // c.b.d.i1.a, c.b.d.b.a, c.b.d.b.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public Builder mergeFrom(k kVar, z zVar) {
            Throwable th;
            TEKSignatureList tEKSignatureList;
            TEKSignatureList tEKSignatureList2 = null;
            try {
                TEKSignatureList parsePartialFrom = TEKSignatureList.PARSER.parsePartialFrom(kVar, zVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (o0 e2) {
                tEKSignatureList = (TEKSignatureList) e2.f5447b;
                throw e2.j();
            } catch (Throwable th2) {
                th = th2;
                tEKSignatureList2 = tEKSignatureList;
                if (tEKSignatureList2 != null) {
                }
                throw th;
            }
        }

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public final Builder mergeUnknownFields(q2 q2Var) {
            return (Builder) super.mergeUnknownFields(q2Var);
        }

        public Builder removeSignatures(int i) {
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            if (c2Var == null) {
                ensureSignaturesIsMutable();
                this.signatures_.remove(i);
                onChanged();
            } else {
                c2Var.u(i);
            }
            return this;
        }

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
        public Builder setField(s.g gVar, Object obj) {
            return (Builder) super.setField(gVar, obj);
        }

        @Override // c.b.d.l0.b, c.b.d.l0.b
        public Builder setRepeatedField(s.g gVar, int i, Object obj) {
            return (Builder) super.setRepeatedField(gVar, i, obj);
        }

        public Builder setSignatures(int i, TEKSignature.Builder builder) {
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            if (c2Var == null) {
                ensureSignaturesIsMutable();
                this.signatures_.set(i, builder.build());
                onChanged();
            } else {
                c2Var.v(i, builder.build());
            }
            return this;
        }

        public Builder setSignatures(int i, TEKSignature tEKSignature) {
            c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = this.signaturesBuilder_;
            if (c2Var != null) {
                c2Var.v(i, tEKSignature);
            } else if (tEKSignature != null) {
                ensureSignaturesIsMutable();
                this.signatures_.set(i, tEKSignature);
                onChanged();
            } else {
                throw null;
            }
            return this;
        }

        @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
        public final Builder setUnknownFields(q2 q2Var) {
            return (Builder) super.setUnknownFields(q2Var);
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
                if (this.signaturesBuilder_.s()) {
                    c2<TEKSignature, TEKSignature.Builder, TEKSignatureOrBuilder> c2Var = null;
                    this.signaturesBuilder_.f5234a = null;
                    this.signaturesBuilder_ = null;
                    this.signatures_ = tEKSignatureList.signatures_;
                    this.bitField0_ &= -2;
                    if (l0.alwaysUseFieldBuilders) {
                        c2Var = getSignaturesFieldBuilder();
                    }
                    this.signaturesBuilder_ = c2Var;
                } else {
                    this.signaturesBuilder_.b(tEKSignatureList.signatures_);
                }
            }
            mergeUnknownFields(tEKSignatureList.unknownFields);
            onChanged();
            return this;
        }
    }
}
