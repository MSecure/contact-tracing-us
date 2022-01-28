package com.proudcrowd.exposure.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface SignatureInfoOrBuilder extends MessageOrBuilder {
    String getSignatureAlgorithm();

    ByteString getSignatureAlgorithmBytes();

    String getVerificationKeyId();

    ByteString getVerificationKeyIdBytes();

    String getVerificationKeyVersion();

    ByteString getVerificationKeyVersionBytes();

    boolean hasSignatureAlgorithm();

    boolean hasVerificationKeyId();

    boolean hasVerificationKeyVersion();
}
