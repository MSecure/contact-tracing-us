package okhttp3;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.ByteString;

public final class Credentials {
    public static String basic(String str, String str2) {
        return basic(str, str2, Util.ISO_8859_1);
    }

    public static String basic(String str, String str2, Charset charset) {
        return GeneratedOutlineSupport.outline8("Basic ", ByteString.encodeString(str + ColorPropConverter.PACKAGE_DELIMITER + str2, charset).base64());
    }
}
