package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import e.b0.b;
import java.nio.charset.Charset;
import java.util.Objects;
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(b bVar) {
        Parcelable parcelable;
        IconCompat iconCompat = new IconCompat();
        iconCompat.a = bVar.l(iconCompat.a, 1);
        byte[] bArr = iconCompat.c;
        if (bVar.j(2)) {
            bArr = bVar.h();
        }
        iconCompat.c = bArr;
        iconCompat.f157d = bVar.o(iconCompat.f157d, 3);
        iconCompat.f158e = bVar.l(iconCompat.f158e, 4);
        iconCompat.f159f = bVar.l(iconCompat.f159f, 5);
        iconCompat.f160g = (ColorStateList) bVar.o(iconCompat.f160g, 6);
        iconCompat.f162i = bVar.q(iconCompat.f162i, 7);
        iconCompat.f163j = bVar.q(iconCompat.f163j, 8);
        iconCompat.f161h = PorterDuff.Mode.valueOf(iconCompat.f162i);
        switch (iconCompat.a) {
            case -1:
                parcelable = iconCompat.f157d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.b = parcelable;
                break;
            case 1:
            case 5:
                parcelable = iconCompat.f157d;
                if (parcelable == null) {
                    byte[] bArr2 = iconCompat.c;
                    iconCompat.b = bArr2;
                    iconCompat.a = 3;
                    iconCompat.f158e = 0;
                    iconCompat.f159f = bArr2.length;
                    break;
                }
                iconCompat.b = parcelable;
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.c, Charset.forName("UTF-16"));
                iconCompat.b = str;
                if (iconCompat.a == 2 && iconCompat.f163j == null) {
                    iconCompat.f163j = str.split(":", -1)[0];
                    break;
                }
                break;
            case 3:
                iconCompat.b = iconCompat.c;
                break;
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, b bVar) {
        Objects.requireNonNull(bVar);
        iconCompat.f162i = iconCompat.f161h.name();
        switch (iconCompat.a) {
            case -1:
            case 1:
            case 5:
                iconCompat.f157d = (Parcelable) iconCompat.b;
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
            bVar.u(1);
            bVar.z(i2);
        }
        byte[] bArr = iconCompat.c;
        if (bArr != null) {
            bVar.u(2);
            bVar.x(bArr);
        }
        Parcelable parcelable = iconCompat.f157d;
        if (parcelable != null) {
            bVar.u(3);
            bVar.B(parcelable);
        }
        int i3 = iconCompat.f158e;
        if (i3 != 0) {
            bVar.u(4);
            bVar.z(i3);
        }
        int i4 = iconCompat.f159f;
        if (i4 != 0) {
            bVar.u(5);
            bVar.z(i4);
        }
        ColorStateList colorStateList = iconCompat.f160g;
        if (colorStateList != null) {
            bVar.u(6);
            bVar.B(colorStateList);
        }
        String str = iconCompat.f162i;
        if (str != null) {
            bVar.u(7);
            bVar.C(str);
        }
        String str2 = iconCompat.f163j;
        if (str2 != null) {
            bVar.u(8);
            bVar.C(str2);
        }
    }
}
