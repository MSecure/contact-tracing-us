package org.pathcheck.covidsafepaths.exposurenotifications.dto;

public class RNExposureKey {
    public String key;
    public int rollingPeriod;
    public int rollingStartNumber;
    public int transmissionRisk;

    public RNExposureKey(String str, int i, int i2, int i3) {
        this.key = str;
        this.rollingPeriod = i;
        this.rollingStartNumber = i2;
        this.transmissionRisk = i3;
    }
}
