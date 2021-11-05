package gov.nc.dhhs.exposurenotification.proto;

import c.b.d.e1;
import c.b.d.h1;
import c.b.d.j;
import c.b.d.j1;
import c.b.d.p2;
import c.b.d.s;
import java.util.List;
import java.util.Map;

public interface TemporaryExposureKeyOrBuilder extends j1 {
    /* synthetic */ List<String> findInitializationErrors();

    @Override // c.b.d.j1
    /* synthetic */ Map<s.g, Object> getAllFields();

    @Override // c.b.d.j1, c.b.d.i1
    /* synthetic */ e1 getDefaultInstanceForType();

    @Override // c.b.d.j1, c.b.d.i1
    /* synthetic */ h1 getDefaultInstanceForType();

    @Override // c.b.d.j1
    /* synthetic */ s.b getDescriptorForType();

    @Override // c.b.d.j1
    /* synthetic */ Object getField(s.g gVar);

    /* synthetic */ String getInitializationErrorString();

    j getKeyData();

    /* synthetic */ s.g getOneofFieldDescriptor(s.k kVar);

    /* synthetic */ Object getRepeatedField(s.g gVar, int i);

    /* synthetic */ int getRepeatedFieldCount(s.g gVar);

    int getRollingPeriod();

    int getRollingStartIntervalNumber();

    int getTransmissionRiskLevel();

    @Override // c.b.d.j1
    /* synthetic */ p2 getUnknownFields();

    @Override // c.b.d.j1
    /* synthetic */ boolean hasField(s.g gVar);

    boolean hasKeyData();

    /* synthetic */ boolean hasOneof(s.k kVar);

    boolean hasRollingPeriod();

    boolean hasRollingStartIntervalNumber();

    boolean hasTransmissionRiskLevel();

    @Override // c.b.d.i1
    /* synthetic */ boolean isInitialized();
}
