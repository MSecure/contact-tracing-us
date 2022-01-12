package org.spongycastle.util.encoders;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayOutputStream;
import org.spongycastle.util.Strings;

public class Hex {
    public static final Encoder encoder = new HexEncoder();

    public static byte[] decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            encoder.decode(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("exception decoding Hex string: ");
            outline17.append(e.getMessage());
            throw new DecoderException(outline17.toString(), e);
        }
    }

    public static byte[] encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public static String toHexString(byte[] bArr) {
        return Strings.fromByteArray(encode(bArr, 0, bArr.length));
    }

    public static byte[] encode(byte[] bArr, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            encoder.encode(bArr, i, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("exception encoding Hex string: ");
            outline17.append(e.getMessage());
            throw new EncoderException(outline17.toString(), e);
        }
    }
}
