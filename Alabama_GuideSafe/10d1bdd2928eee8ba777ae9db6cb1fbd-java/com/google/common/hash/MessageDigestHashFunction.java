package com.google.common.hash;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MessageDigestHashFunction extends AbstractHashFunction implements Serializable {
    public final int bytes;
    public final MessageDigest prototype;
    public final boolean supportsClone;
    public final String toString;

    public static final class MessageDigestHasher extends AbstractByteHasher {
        public final int bytes;
        public final MessageDigest digest;
        public boolean done;

        public MessageDigestHasher(MessageDigest messageDigest, int i, AnonymousClass1 r3) {
            this.digest = messageDigest;
            this.bytes = i;
        }
    }

    public MessageDigestHashFunction(String str, String str2) {
        boolean z;
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            this.prototype = instance;
            this.bytes = instance.getDigestLength();
            this.toString = str2;
            try {
                this.prototype.clone();
                z = true;
            } catch (CloneNotSupportedException unused) {
                z = false;
            }
            this.supportsClone = z;
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public String toString() {
        return this.toString;
    }
}
