package org.spongycastle.util.encoders;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayOutputStream;

public class Base64 {
    public static final Encoder encoder = new Base64Encoder();

    public static byte[] decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((str.length() / 4) * 3);
        try {
            encoder.decode(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("unable to decode base64 string: ");
            outline15.append(e.getMessage());
            throw new DecoderException(outline15.toString(), e);
        }
    }

    public static byte[] encode(byte[] bArr) {
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((length + 2) / 3) * 4);
        try {
            encoder.encode(bArr, 0, length, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("exception encoding base64 string: ");
            outline15.append(e.getMessage());
            throw new EncoderException(outline15.toString(), e);
        }
    }
}
