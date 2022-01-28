package com.proudcrowd.exposure.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface TEKSignatureOrBuilder extends MessageOrBuilder {
    int getBatchNum();

    int getBatchSize();

    ByteString getSignature();

    SignatureInfo getSignatureInfo();

    SignatureInfoOrBuilder getSignatureInfoOrBuilder();

    boolean hasBatchNum();

    boolean hasBatchSize();

    boolean hasSignature();

    boolean hasSignatureInfo();
}
