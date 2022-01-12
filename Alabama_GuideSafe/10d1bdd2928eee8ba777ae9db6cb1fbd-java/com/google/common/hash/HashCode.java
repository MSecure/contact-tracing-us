package com.google.common.hash;

import com.facebook.react.uimanager.ReactYogaConfigProvider;
import java.io.Serializable;

public abstract class HashCode {
    public static final char[] hexDigits = "0123456789abcdef".toCharArray();

    public static final class BytesHashCode extends HashCode implements Serializable {
        public final byte[] bytes;

        public BytesHashCode(byte[] bArr) {
            if (bArr != null) {
                this.bytes = bArr;
                return;
            }
            throw null;
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return this.bytes.length * 8;
        }
    }

    public static HashCode fromBytesNoCopy(byte[] bArr) {
        return new BytesHashCode(bArr);
    }

    public abstract int bits();

    public final boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof HashCode)) {
            return false;
        }
        HashCode hashCode = (HashCode) obj;
        if (bits() != hashCode.bits()) {
            return false;
        }
        BytesHashCode bytesHashCode = (BytesHashCode) this;
        BytesHashCode bytesHashCode2 = (BytesHashCode) hashCode;
        if (bytesHashCode.bytes.length == bytesHashCode2.bytes.length) {
            int i = 0;
            z = true;
            while (true) {
                byte[] bArr = bytesHashCode.bytes;
                if (i >= bArr.length) {
                    break;
                }
                z &= bArr[i] == bytesHashCode2.bytes[i];
                i++;
            }
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (bits() >= 32) {
            BytesHashCode bytesHashCode = (BytesHashCode) this;
            boolean z = bytesHashCode.bytes.length >= 4;
            byte[] bArr = bytesHashCode.bytes;
            int length = bArr.length;
            if (z) {
                return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
            }
            throw new IllegalStateException(ReactYogaConfigProvider.lenientFormat("HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", Integer.valueOf(length)));
        }
        byte[] bArr2 = ((BytesHashCode) this).bytes;
        int i = bArr2[0] & 255;
        for (int i2 = 1; i2 < bArr2.length; i2++) {
            i |= (bArr2[i2] & 255) << (i2 * 8);
        }
        return i;
    }

    public final String toString() {
        byte[] bArr = ((BytesHashCode) this).bytes;
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(hexDigits[(b >> 4) & 15]);
            sb.append(hexDigits[b & 15]);
        }
        return sb.toString();
    }
}
