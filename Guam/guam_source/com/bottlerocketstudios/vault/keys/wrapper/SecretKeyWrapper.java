package com.bottlerocketstudios.vault.keys.wrapper;

import android.content.Context;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.crypto.SecretKey;

public interface SecretKeyWrapper {
    void clearKey(Context context) throws GeneralSecurityException, IOException;

    SecretKey unwrap(byte[] bArr, String str) throws GeneralSecurityException, IOException;

    byte[] wrap(SecretKey secretKey) throws GeneralSecurityException, IOException;
}
