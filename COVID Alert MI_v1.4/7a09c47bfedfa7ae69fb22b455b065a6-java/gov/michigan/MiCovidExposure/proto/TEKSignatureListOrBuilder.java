package gov.michigan.MiCovidExposure.proto;

import c.b.d.f1;
import c.b.d.i1;
import c.b.d.k1;
import c.b.d.q2;
import c.b.d.s;
import java.util.List;
import java.util.Map;

public interface TEKSignatureListOrBuilder extends k1 {
    /* synthetic */ List<String> findInitializationErrors();

    @Override // c.b.d.k1
    /* synthetic */ Map<s.g, Object> getAllFields();

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

    TEKSignature getSignatures(int i);

    int getSignaturesCount();

    List<TEKSignature> getSignaturesList();

    TEKSignatureOrBuilder getSignaturesOrBuilder(int i);

    List<? extends TEKSignatureOrBuilder> getSignaturesOrBuilderList();

    @Override // c.b.d.k1
    /* synthetic */ q2 getUnknownFields();

    @Override // c.b.d.k1
    /* synthetic */ boolean hasField(s.g gVar);

    /* synthetic */ boolean hasOneof(s.k kVar);

    @Override // c.b.d.j1
    /* synthetic */ boolean isInitialized();
}
