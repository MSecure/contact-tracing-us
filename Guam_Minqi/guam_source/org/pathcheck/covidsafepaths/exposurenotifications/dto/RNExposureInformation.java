package org.pathcheck.covidsafepaths.exposurenotifications.dto;

import java.util.UUID;

public class RNExposureInformation {
    public long date;
    public String id = UUID.randomUUID().toString();

    public RNExposureInformation(long j) {
        this.date = j;
    }
}
