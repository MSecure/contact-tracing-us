package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import b.z.b;
import b.z.c;
import java.nio.charset.Charset;

public class IconCompatParcelizer {
    public static IconCompat read(b bVar) {
        Parcelable parcelable;
        IconCompat iconCompat = new IconCompat();
        iconCompat.f201a = bVar.k(iconCompat.f201a, 1);
        byte[] bArr = iconCompat.f203c;
        if (bVar.i(2)) {
            c cVar = (c) bVar;
            int readInt = cVar.f2791e.readInt();
            if (readInt < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[readInt];
                cVar.f2791e.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f203c = bArr;
        iconCompat.f204d = bVar.l(iconCompat.f204d, 3);
        iconCompat.f205e = bVar.k(iconCompat.f205e, 4);
        iconCompat.f206f = bVar.k(iconCompat.f206f, 5);
        iconCompat.f207g = (ColorStateList) bVar.l(iconCompat.f207g, 6);
        String n = bVar.n(iconCompat.i, 7);
        iconCompat.i = n;
        iconCompat.h = PorterDuff.Mode.valueOf(n);
        switch (iconCompat.f201a) {
            case -1:
                parcelable = iconCompat.f204d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f202b = parcelable;
                break;
            case 1:
            case 5:
                parcelable = iconCompat.f204d;
                if (parcelable == null) {
                    byte[] bArr3 = iconCompat.f203c;
                    iconCompat.f202b = bArr3;
                    iconCompat.f201a = 3;
                    iconCompat.f205e = 0;
                    iconCompat.f206f = bArr3.length;
                    break;
                }
                iconCompat.f202b = parcelable;
                break;
            case 2:
            case 4:
            case 6:
                iconCompat.f202b = new String(iconCompat.f203c, Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f202b = iconCompat.f203c;
                break;
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, b bVar) {
        if (bVar != null) {
            iconCompat.i = iconCompat.h.name();
            switch (iconCompat.f201a) {
                case -1:
                case 1:
                case 5:
                    iconCompat.f204d = (Parcelable) iconCompat.f202b;
                    break;
                case 2:
                    iconCompat.f203c = ((String) iconCompat.f202b).getBytes(Charset.forName("UTF-16"));
                    break;
                case 3:
                    iconCompat.f203c = (byte[]) iconCompat.f202b;
                    break;
                case 4:
                case 6:
                    iconCompat.f203c = iconCompat.f202b.toString().getBytes(Charset.forName("UTF-16"));
                    break;
            }
            int i = iconCompat.f201a;
            if (-1 != i) {
                bVar.t(i, 1);
            }
            byte[] bArr = iconCompat.f203c;
            if (bArr != null) {
                bVar.q(2);
                bVar.s(bArr);
            }
            Parcelable parcelable = iconCompat.f204d;
            if (parcelable != null) {
                bVar.q(3);
                ((c) bVar).f2791e.writeParcelable(parcelable, 0);
            }
            int i2 = iconCompat.f205e;
            if (i2 != 0) {
                bVar.t(i2, 4);
            }
            int i3 = iconCompat.f206f;
            if (i3 != 0) {
                bVar.t(i3, 5);
            }
            ColorStateList colorStateList = iconCompat.f207g;
            if (colorStateList != null) {
                bVar.q(6);
                ((c) bVar).f2791e.writeParcelable(colorStateList, 0);
            }
            String str = iconCompat.i;
            if (str != null) {
                bVar.q(7);
                ((c) bVar).f2791e.writeString(str);
                return;
            }
            return;
        }
        throw null;
    }
}
