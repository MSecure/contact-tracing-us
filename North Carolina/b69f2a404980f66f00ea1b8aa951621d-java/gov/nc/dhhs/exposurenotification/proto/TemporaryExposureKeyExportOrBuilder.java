package gov.nc.dhhs.exposurenotification.proto;

import c.b.d.e1;
import c.b.d.h1;
import c.b.d.j;
import c.b.d.j1;
import c.b.d.p2;
import c.b.d.s;
import java.util.List;
import java.util.Map;

public interface TemporaryExposureKeyExportOrBuilder extends j1 {
    /* synthetic */ List<String> findInitializationErrors();

    @Override // c.b.d.j1
    /* synthetic */ Map<s.g, Object> getAllFields();

    int getBatchNum();

    int getBatchSize();

    @Override // c.b.d.j1, c.b.d.i1
    /* synthetic */ e1 getDefaultInstanceForType();

    @Override // c.b.d.j1, c.b.d.i1
    /* synthetic */ h1 getDefaultInstanceForType();

    @Override // c.b.d.j1
    /* synthetic */ s.b getDescriptorForType();

    long getEndTimestamp();

    @Override // c.b.d.j1
    /* synthetic */ Object getField(s.g gVar);

    /* synthetic */ String getInitializationErrorString();

    TemporaryExposureKey getKeys(int i);

    int getKeysCount();

    List<TemporaryExposureKey> getKeysList();

    TemporaryExposureKeyOrBuilder getKeysOrBuilder(int i);

    List<? extends TemporaryExposureKeyOrBuilder> getKeysOrBuilderList();

    /* synthetic */ s.g getOneofFieldDescriptor(s.k kVar);

    String getRegion();

    j getRegionBytes();

    /* synthetic */ Object getRepeatedField(s.g gVar, int i);

    /* synthetic */ int getRepeatedFieldCount(s.g gVar);

    SignatureInfo getSignatureInfos(int i);

    int getSignatureInfosCount();

    List<SignatureInfo> getSignatureInfosList();

    SignatureInfoOrBuilder getSignatureInfosOrBuilder(int i);

    List<? extends SignatureInfoOrBuilder> getSignatureInfosOrBuilderList();

    long getStartTimestamp();

    @Override // c.b.d.j1
    /* synthetic */ p2 getUnknownFields();

    boolean hasBatchNum();

    boolean hasBatchSize();

    boolean hasEndTimestamp();

    @Override // c.b.d.j1
    /* synthetic */ boolean hasField(s.g gVar);

    /* synthetic */ boolean hasOneof(s.k kVar);

    boolean hasRegion();

    boolean hasStartTimestamp();

    @Override // c.b.d.i1
    /* synthetic */ boolean isInitialized();
}
