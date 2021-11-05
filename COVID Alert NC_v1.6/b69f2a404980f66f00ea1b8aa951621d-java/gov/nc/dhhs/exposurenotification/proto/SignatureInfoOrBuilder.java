package gov.nc.dhhs.exposurenotification.proto;

import c.b.d.e1;
import c.b.d.h1;
import c.b.d.j;
import c.b.d.j1;
import c.b.d.p2;
import c.b.d.s;
import java.util.List;
import java.util.Map;

public interface SignatureInfoOrBuilder extends j1 {
    /* synthetic */ List<String> findInitializationErrors();

    @Override // c.b.d.j1
    /* synthetic */ Map<s.g, Object> getAllFields();

    String getAndroidPackage();

    j getAndroidPackageBytes();

    String getAppBundleId();

    j getAppBundleIdBytes();

    @Override // c.b.d.j1, c.b.d.i1
    /* synthetic */ e1 getDefaultInstanceForType();

    @Override // c.b.d.j1, c.b.d.i1
    /* synthetic */ h1 getDefaultInstanceForType();

    @Override // c.b.d.j1
    /* synthetic */ s.b getDescriptorForType();

    @Override // c.b.d.j1
    /* synthetic */ Object getField(s.g gVar);

    /* synthetic */ String getInitializationErrorString();

    /* synthetic */ s.g getOneofFieldDescriptor(s.k kVar);

    /* synthetic */ Object getRepeatedField(s.g gVar, int i);

    /* synthetic */ int getRepeatedFieldCount(s.g gVar);

    String getSignatureAlgorithm();

    j getSignatureAlgorithmBytes();

    @Override // c.b.d.j1
    /* synthetic */ p2 getUnknownFields();

    String getVerificationKeyId();

    j getVerificationKeyIdBytes();

    String getVerificationKeyVersion();

    j getVerificationKeyVersionBytes();

    boolean hasAndroidPackage();

    boolean hasAppBundleId();

    @Override // c.b.d.j1
    /* synthetic */ boolean hasField(s.g gVar);

    /* synthetic */ boolean hasOneof(s.k kVar);

    boolean hasSignatureAlgorithm();

    boolean hasVerificationKeyId();

    boolean hasVerificationKeyVersion();

    @Override // c.b.d.i1
    /* synthetic */ boolean isInitialized();
}
