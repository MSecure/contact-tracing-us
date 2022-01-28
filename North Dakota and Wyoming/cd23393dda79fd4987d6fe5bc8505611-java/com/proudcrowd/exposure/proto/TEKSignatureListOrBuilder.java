package com.proudcrowd.exposure.proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface TEKSignatureListOrBuilder extends MessageOrBuilder {
    TEKSignature getSignatures(int i);

    int getSignaturesCount();

    List<TEKSignature> getSignaturesList();

    TEKSignatureOrBuilder getSignaturesOrBuilder(int i);

    List<? extends TEKSignatureOrBuilder> getSignaturesOrBuilderList();
}
