package org.pathcheck.covidsafepaths.exposurenotifications.dto;

import java.util.UUID;

public class RNDiagnosisKey {
    public String id = UUID.randomUUID().toString();
    public long rollingStartNumber;

    public RNDiagnosisKey(long j) {
        this.rollingStartNumber = j;
    }
}
