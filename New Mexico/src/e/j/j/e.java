package e.j.j;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import java.util.Locale;
import java.util.Objects;
/* loaded from: classes.dex */
public final class e {
    public final ClipData a;
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final Uri f1633d;

    /* renamed from: e  reason: collision with root package name */
    public final Bundle f1634e;

    /* loaded from: classes.dex */
    public static final class a {
        public ClipData a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public Uri f1635d;

        /* renamed from: e  reason: collision with root package name */
        public Bundle f1636e;

        public a(ClipData clipData, int i2) {
            this.a = clipData;
            this.b = i2;
        }
    }

    public e(a aVar) {
        ClipData clipData = aVar.a;
        Objects.requireNonNull(clipData);
        this.a = clipData;
        int i2 = aVar.b;
        if (i2 < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", "source", 0, 3));
        } else if (i2 <= 3) {
            this.b = i2;
            int i3 = aVar.c;
            if ((i3 & 1) == i3) {
                this.c = i3;
                this.f1633d = aVar.f1635d;
                this.f1634e = aVar.f1636e;
                return;
            }
            StringBuilder h2 = f.a.a.a.a.h("Requested flags 0x");
            h2.append(Integer.toHexString(i3));
            h2.append(", but only 0x");
            h2.append(Integer.toHexString(1));
            h2.append(" are allowed");
            throw new IllegalArgumentException(h2.toString());
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", "source", 0, 3));
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder h2 = f.a.a.a.a.h("ContentInfoCompat{clip=");
        h2.append(this.a.getDescription());
        h2.append(", source=");
        int i2 = this.b;
        h2.append(i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? String.valueOf(i2) : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
        h2.append(", flags=");
        int i3 = this.c;
        if ((i3 & 1) != 0) {
            str = "FLAG_CONVERT_TO_PLAIN_TEXT";
        } else {
            str = String.valueOf(i3);
        }
        h2.append(str);
        String str3 = "";
        if (this.f1633d == null) {
            str2 = str3;
        } else {
            StringBuilder h3 = f.a.a.a.a.h(", hasLinkUri(");
            h3.append(this.f1633d.toString().length());
            h3.append(")");
            str2 = h3.toString();
        }
        h2.append(str2);
        if (this.f1634e != null) {
            str3 = ", hasExtras";
        }
        return f.a.a.a.a.e(h2, str3, "}");
    }
}
