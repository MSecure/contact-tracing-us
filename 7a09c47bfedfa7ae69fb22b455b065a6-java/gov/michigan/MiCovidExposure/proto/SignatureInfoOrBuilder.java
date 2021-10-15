package gov.michigan.MiCovidExposure.proto;

import c.b.d.f1;
import c.b.d.i1;
import c.b.d.j;
import c.b.d.k1;
import c.b.d.q2;
import c.b.d.s;
import java.util.List;
import java.util.Map;

public interface SignatureInfoOrBuilder extends k1 {
    /* synthetic */ List<String> findInitializationErrors();

    @Override // c.b.d.k1
    /* synthetic */ Map<s.g, Object> getAllFields();

    String getAndroidPackage();

    j getAndroidPackageBytes();

    String getAppBundleId();

    j getAppBundleIdBytes();

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

    String getSignatureAlgorithm();

    j getSignatureAlgorithmBytes();

    @Override // c.b.d.k1
    /* synthetic */ q2 getUnknownFields();

    String getVerificationKeyId();

    j getVerificationKeyIdBytes();

    String getVerificationKeyVersion();

    j getVerificationKeyVersionBytes();

    boolean hasAndroidPackage();

    boolean hasAppBundleId();

    @Override // c.b.d.k1
    /* synthetic */ boolean hasField(s.g gVar);

    /* synthetic */ boolean hasOneof(s.k kVar);

    boolean hasSignatureAlgorithm();

    boolean hasVerificationKeyId();

    boolean hasVerificationKeyVersion();

    @Override // c.b.d.j1
    /* synthetic */ boolean isInitialized();
}
