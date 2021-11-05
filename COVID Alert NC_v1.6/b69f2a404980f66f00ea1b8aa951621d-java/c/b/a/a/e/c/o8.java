package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import java.util.Arrays;

public final class o8 extends a {
    public static final Parcelable.Creator<o8> CREATOR = new n8();

    /* renamed from: b  reason: collision with root package name */
    public String f2681b;

    /* renamed from: c  reason: collision with root package name */
    public PayloadTransferUpdate f2682c;

    public o8() {
    }

    public o8(String str, PayloadTransferUpdate payloadTransferUpdate) {
        this.f2681b = str;
        this.f2682c = payloadTransferUpdate;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o8) {
            o8 o8Var = (o8) obj;
            return i.j.X(this.f2681b, o8Var.f2681b) && i.j.X(this.f2682c, o8Var.f2682c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2681b, this.f2682c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.z1(parcel, 1, this.f2681b, false);
        i.j.y1(parcel, 2, this.f2682c, i, false);
        i.j.F1(parcel, e2);
    }
}
