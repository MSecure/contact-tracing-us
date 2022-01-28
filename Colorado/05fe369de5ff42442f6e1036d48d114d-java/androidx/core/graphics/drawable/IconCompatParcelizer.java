package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import e.y.b;
import java.nio.charset.Charset;
import java.util.Objects;

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
        iconCompat.f156d = bVar.o(iconCompat.f156d, 3);
        iconCompat.f157e = bVar.l(iconCompat.f157e, 4);
        iconCompat.f158f = bVar.l(iconCompat.f158f, 5);
        iconCompat.f159g = (ColorStateList) bVar.o(iconCompat.f159g, 6);
        iconCompat.f161i = bVar.q(iconCompat.f161i, 7);
        iconCompat.f162j = bVar.q(iconCompat.f162j, 8);
        iconCompat.f160h = PorterDuff.Mode.valueOf(iconCompat.f161i);
        switch (iconCompat.a) {
            case -1:
                parcelable = iconCompat.f156d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.b = parcelable;
                break;
            case 1:
            case 5:
                parcelable = iconCompat.f156d;
                if (parcelable == null) {
                    byte[] bArr2 = iconCompat.c;
                    iconCompat.b = bArr2;
                    iconCompat.a = 3;
                    iconCompat.f157e = 0;
                    iconCompat.f158f = bArr2.length;
                    break;
                }
                iconCompat.b = parcelable;
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.c, Charset.forName("UTF-16"));
                iconCompat.b = str;
                if (iconCompat.a == 2 && iconCompat.f162j == null) {
                    iconCompat.f162j = str.split(":", -1)[0];
                    break;
                }
            case 3:
                iconCompat.b = iconCompat.c;
                break;
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, b bVar) {
        Objects.requireNonNull(bVar);
        iconCompat.f161i = iconCompat.f160h.name();
        switch (iconCompat.a) {
            case -1:
            case 1:
            case 5:
                iconCompat.f156d = (Parcelable) iconCompat.b;
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
        Parcelable parcelable = iconCompat.f156d;
        if (parcelable != null) {
            bVar.u(3);
            bVar.B(parcelable);
        }
        int i3 = iconCompat.f157e;
        if (i3 != 0) {
            bVar.u(4);
            bVar.z(i3);
        }
        int i4 = iconCompat.f158f;
        if (i4 != 0) {
            bVar.u(5);
            bVar.z(i4);
        }
        ColorStateList colorStateList = iconCompat.f159g;
        if (colorStateList != null) {
            bVar.u(6);
            bVar.B(colorStateList);
        }
        String str = iconCompat.f161i;
        if (str != null) {
            bVar.u(7);
            bVar.C(str);
        }
        String str2 = iconCompat.f162j;
        if (str2 != null) {
            bVar.u(8);
            bVar.C(str2);
        }
    }
}
