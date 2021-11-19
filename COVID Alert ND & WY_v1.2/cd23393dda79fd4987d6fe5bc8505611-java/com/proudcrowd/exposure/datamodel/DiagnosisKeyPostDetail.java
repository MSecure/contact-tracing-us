package com.proudcrowd.exposure.datamodel;

import com.google.common.collect.ImmutableList;
import com.proudcrowd.exposure.core.DiagnosisKey;

public class DiagnosisKeyPostDetail {
    public String healthAuthorityID;
    public String hmacKey;
    public String padding;
    public String revisionToken;
    public int symptomOnsetInterval;
    public ImmutableList<DiagnosisKey> temporaryExposureKeys;
    public boolean traveler;
    public String verificationPayload;
}
