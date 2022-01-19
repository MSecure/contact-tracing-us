package org.spongycastle.openssl;

import java.io.IOException;

public interface PEMKeyPairParser {
    PEMKeyPair parse(byte[] bArr) throws IOException;
}
