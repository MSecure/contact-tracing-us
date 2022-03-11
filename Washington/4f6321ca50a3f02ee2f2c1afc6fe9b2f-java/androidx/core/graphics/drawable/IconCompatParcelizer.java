package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import e.y.a;
import java.nio.charset.Charset;
import java.util.Objects;

public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        Parcelable parcelable;
        IconCompat iconCompat = new IconCompat();
        iconCompat.a = aVar.k(iconCompat.a, 1);
        byte[] bArr = iconCompat.c;
        if (aVar.i(2)) {
            bArr = aVar.g();
        }
        iconCompat.c = bArr;
        iconCompat.f145d = aVar.m(iconCompat.f145d, 3);
        iconCompat.f146e = aVar.k(iconCompat.f146e, 4);
        iconCompat.f147f = aVar.k(iconCompat.f147f, 5);
        iconCompat.f148g = (ColorStateList) aVar.m(iconCompat.f148g, 6);
        String str = iconCompat.f150i;
        if (aVar.i(7)) {
            str = aVar.n();
        }
        iconCompat.f150i = str;
        String str2 = iconCompat.f151j;
        if (aVar.i(8)) {
            str2 = aVar.n();
        }
        iconCompat.f151j = str2;
        iconCompat.f149h = PorterDuff.Mode.valueOf(iconCompat.f150i);
        switch (iconCompat.a) {
            case -1:
                parcelable = iconCompat.f145d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.b = parcelable;
                break;
            case 1:
            case 5:
                parcelable = iconCompat.f145d;
                if (parcelable == null) {
                    byte[] bArr2 = iconCompat.c;
                    iconCompat.b = bArr2;
                    iconCompat.a = 3;
                    iconCompat.f146e = 0;
                    iconCompat.f147f = bArr2.length;
                    break;
                }
                iconCompat.b = parcelable;
                break;
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.c, Charset.forName("UTF-16"));
                iconCompat.b = str3;
                if (iconCompat.a == 2 && iconCompat.f151j == null) {
                    iconCompat.f151j = str3.split(":", -1)[0];
                    break;
                }
            case 3:
                iconCompat.b = iconCompat.c;
                break;
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        Objects.requireNonNull(aVar);
        iconCompat.f150i = iconCompat.f149h.name();
        switch (iconCompat.a) {
            case -1:
            case 1:
            case 5:
                iconCompat.f145d = (Parcelable) iconCompat.b;
                break;
            case 2:
                iconCompat.c = ((String) iconCompat.b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.c = (byte[]) iconCompat.b;
                break;
            case 4:
            case 6:
                iconCompat.c = iconCompat.b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i2 = iconCompat.a;
        if (-1 != i2) {
            aVar.p(1);
            aVar.t(i2);
        }
        byte[] bArr = iconCompat.c;
        if (bArr != null) {
            aVar.p(2);
            aVar.r(bArr);
        }
        Parcelable parcelable = iconCompat.f145d;
        if (parcelable != null) {
            aVar.p(3);
            aVar.u(parcelable);
        }
        int i3 = iconCompat.f146e;
        if (i3 != 0) {
            aVar.p(4);
            aVar.t(i3);
        }
        int i4 = iconCompat.f147f;
        if (i4 != 0) {
            aVar.p(5);
            aVar.t(i4);
        }
        ColorStateList colorStateList = iconCompat.f148g;
        if (colorStateList != null) {
            aVar.p(6);
            aVar.u(colorStateList);
        }
        String str = iconCompat.f150i;
        if (str != null) {
            aVar.p(7);
            aVar.v(str);
        }
        String str2 = iconCompat.f151j;
        if (str2 != null) {
            aVar.p(8);
            aVar.v(str2);
        }
    }
}
