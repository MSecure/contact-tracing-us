package com.proudcrowd.exposure.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface TemporaryExposureKeyOrBuilder extends MessageOrBuilder {
    ByteString getKeyData();

    int getRollingPeriod();

    int getRollingStartIntervalNumber();

    int getTransmissionRiskLevel();

    boolean hasKeyData();

    boolean hasRollingPeriod();

    boolean hasRollingStartIntervalNumber();

    boolean hasTransmissionRiskLevel();
}
