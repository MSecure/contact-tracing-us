package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import b.x.a;
import b.x.b;
import java.nio.charset.Charset;

public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        Parcelable parcelable;
        IconCompat iconCompat = new IconCompat();
        iconCompat.f137a = aVar.i(iconCompat.f137a, 1);
        byte[] bArr = iconCompat.f139c;
        if (aVar.h(2)) {
            b bVar = (b) aVar;
            int readInt = bVar.f1883e.readInt();
            if (readInt < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[readInt];
                bVar.f1883e.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f139c = bArr;
        iconCompat.f140d = aVar.j(iconCompat.f140d, 3);
        iconCompat.f141e = aVar.i(iconCompat.f141e, 4);
        iconCompat.f = aVar.i(iconCompat.f, 5);
        iconCompat.g = (ColorStateList) aVar.j(iconCompat.g, 6);
        String str = iconCompat.i;
        if (aVar.h(7)) {
            str = ((b) aVar).f1883e.readString();
        }
        iconCompat.i = str;
        iconCompat.h = PorterDuff.Mode.valueOf(str);
        switch (iconCompat.f137a) {
            case -1:
                parcelable = iconCompat.f140d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f138b = parcelable;
                break;
            case 1:
            case 5:
                parcelable = iconCompat.f140d;
                if (parcelable == null) {
                    byte[] bArr3 = iconCompat.f139c;
                    iconCompat.f138b = bArr3;
                    iconCompat.f137a = 3;
                    iconCompat.f141e = 0;
                    iconCompat.f = bArr3.length;
                    break;
                }
                iconCompat.f138b = parcelable;
                break;
            case 2:
            case 4:
            case 6:
                iconCompat.f138b = new String(iconCompat.f139c, Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f138b = iconCompat.f139c;
                break;
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        if (aVar != null) {
            iconCompat.i = iconCompat.h.name();
            switch (iconCompat.f137a) {
                case -1:
                case 1:
                case 5:
                    iconCompat.f140d = (Parcelable) iconCompat.f138b;
                    break;
                case 2:
                    iconCompat.f139c = ((String) iconCompat.f138b).getBytes(Charset.forName("UTF-16"));
                    break;
                case 3:
                    iconCompat.f139c = (byte[]) iconCompat.f138b;
                    break;
                case 4:
                case 6:
                    iconCompat.f139c = iconCompat.f138b.toString().getBytes(Charset.forName("UTF-16"));
                    break;
            }
            int i = iconCompat.f137a;
            if (-1 != i) {
                aVar.m(i, 1);
            }
            byte[] bArr = iconCompat.f139c;
            if (bArr != null) {
                aVar.l(2);
                b bVar = (b) aVar;
                bVar.f1883e.writeInt(bArr.length);
                bVar.f1883e.writeByteArray(bArr);
            }
            Parcelable parcelable = iconCompat.f140d;
            if (parcelable != null) {
                aVar.l(3);
                ((b) aVar).f1883e.writeParcelable(parcelable, 0);
            }
            int i2 = iconCompat.f141e;
            if (i2 != 0) {
                aVar.m(i2, 4);
            }
            int i3 = iconCompat.f;
            if (i3 != 0) {
                aVar.m(i3, 5);
            }
            ColorStateList colorStateList = iconCompat.g;
            if (colorStateList != null) {
                aVar.l(6);
                ((b) aVar).f1883e.writeParcelable(colorStateList, 0);
            }
            String str = iconCompat.i;
            if (str != null) {
                aVar.l(7);
                ((b) aVar).f1883e.writeString(str);
                return;
            }
            return;
        }
        throw null;
    }
}
