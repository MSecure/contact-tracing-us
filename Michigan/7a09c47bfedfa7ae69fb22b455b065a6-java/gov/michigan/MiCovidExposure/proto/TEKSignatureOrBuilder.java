package gov.michigan.MiCovidExposure.proto;

import c.b.d.f1;
import c.b.d.i1;
import c.b.d.j;
import c.b.d.k1;
import c.b.d.q2;
import c.b.d.s;
import java.util.List;
import java.util.Map;

public interface TEKSignatureOrBuilder extends k1 {
    /* synthetic */ List<String> findInitializationErrors();

    @Override // c.b.d.k1
    /* synthetic */ Map<s.g, Object> getAllFields();

    int getBatchNum();

    int getBatchSize();

    @Override // c.b.d.k1, c.b.d.j1
    /* synthetic */ f1 getDefaultInstanceForType();

    @Override // c.b.d.k1, c.b.d.j1
    /* synthetic */ i1 getDefaultInstanceForType();

    @Override // c.b.d.k1
    /* synthetic */ s.b getDescriptorForType();

    @Override // c.b.d.k1
    /* synthetic */ Object getField(s.g gVar);

    /* synthetic */ String getInitializationErrorString();

    /* synthetic */ s.g getOneofFieldDescriptor(s.k kVar);

    /* synthetic */ Object getRepeatedField(s.g gVar, int i);

    /* synthetic */ int getRepeatedFieldCount(s.g gVar);

    j getSignature();

    SignatureInfo getSignatureInfo();

    SignatureInfoOrBuilder getSignatureInfoOrBuilder();

    @Override // c.b.d.k1
    /* synthetic */ q2 getUnknownFields();

    boolean hasBatchNum();

    boolean hasBatchSize();

    @Override // c.b.d.k1
    /* synthetic */ boolean hasField(s.g gVar);

    /* synthetic */ boolean hasOneof(s.k kVar);

    boolean hasSignature();

    boolean hasSignatureInfo();

    @Override // c.b.d.j1
    /* synthetic */ boolean isInitialized();
}
