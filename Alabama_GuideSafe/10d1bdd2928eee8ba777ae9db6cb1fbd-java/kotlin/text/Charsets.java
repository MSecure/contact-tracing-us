package kotlin.text;

import com.reactnativecommunity.webview.RNCWebViewManager;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Charsets.kt */
public final class Charsets {
    public static final Charset UTF_8;

    static {
        Charset forName = Charset.forName(RNCWebViewManager.HTML_ENCODING);
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(\"UTF-8\")");
        UTF_8 = forName;
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("US-ASCII"), "Charset.forName(\"US-ASCII\")");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }
}
