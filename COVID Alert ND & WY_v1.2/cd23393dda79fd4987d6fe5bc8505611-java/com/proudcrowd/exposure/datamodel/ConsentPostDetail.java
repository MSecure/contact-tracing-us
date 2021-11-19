package com.proudcrowd.exposure.datamodel;

import com.proudcrowd.exposure.core.ExposureApplication;

public class ConsentPostDetail {
    public String citizenCode;
    public String exposureKeysHash;
    public String tekVersion = ExposureApplication.TEK_SERVER_VERSION;

    public ConsentPostDetail(String str, String str2) {
        this.citizenCode = str;
        this.exposureKeysHash = str2;
    }
}
