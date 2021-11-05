package gov.michigan.MiCovidExposure.proto;

import c.b.d.f1;
import c.b.d.i1;
import c.b.d.j;
import c.b.d.k1;
import c.b.d.q2;
import c.b.d.s;
import java.util.List;
import java.util.Map;

public interface TemporaryExposureKeyOrBuilder extends k1 {
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

    j getKeyData();

    /* synthetic */ s.g getOneofFieldDescriptor(s.k kVar);

    /* synthetic */ Object getRepeatedField(s.g gVar, int i);

    /* synthetic */ int getRepeatedFieldCount(s.g gVar);

    int getRollingPeriod();

    int getRollingStartIntervalNumber();

    int getTransmissionRiskLevel();

    @Override // c.b.d.k1
    /* synthetic */ q2 getUnknownFields();

    @Override // c.b.d.k1
    /* synthetic */ boolean hasField(s.g gVar);

    boolean hasKeyData();

    /* synthetic */ boolean hasOneof(s.k kVar);

    boolean hasRollingPeriod();

    boolean hasRollingStartIntervalNumber();

    boolean hasTransmissionRiskLevel();

    @Override // c.b.d.j1
    /* synthetic */ boolean isInitialized();
}
