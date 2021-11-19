package com.proudcrowd.exposure.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface TemporaryExposureKeyExportOrBuilder extends MessageOrBuilder {
    int getBatchNum();

    int getBatchSize();

    long getEndTimestamp();

    TemporaryExposureKey getKeys(int i);

    int getKeysCount();

    List<TemporaryExposureKey> getKeysList();

    TemporaryExposureKeyOrBuilder getKeysOrBuilder(int i);

    List<? extends TemporaryExposureKeyOrBuilder> getKeysOrBuilderList();

    String getRegion();

    ByteString getRegionBytes();

    SignatureInfo getSignatureInfos(int i);

    int getSignatureInfosCount();

    List<SignatureInfo> getSignatureInfosList();

    SignatureInfoOrBuilder getSignatureInfosOrBuilder(int i);

    List<? extends SignatureInfoOrBuilder> getSignatureInfosOrBuilderList();

    long getStartTimestamp();

    boolean hasBatchNum();

    boolean hasBatchSize();

    boolean hasEndTimestamp();

    boolean hasRegion();

    boolean hasStartTimestamp();
}
