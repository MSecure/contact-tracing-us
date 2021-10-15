package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import java.util.Arrays;

public final class o8 extends a {
    public static final Parcelable.Creator<o8> CREATOR = new n8();

    /* renamed from: b  reason: collision with root package name */
    public String f3673b;

    /* renamed from: c  reason: collision with root package name */
    public PayloadTransferUpdate f3674c;

    public o8() {
    }

    public o8(String str, PayloadTransferUpdate payloadTransferUpdate) {
        this.f3673b = str;
        this.f3674c = payloadTransferUpdate;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o8) {
            o8 o8Var = (o8) obj;
            return t.j1(this.f3673b, o8Var.f3673b) && t.j1(this.f3674c, o8Var.f3674c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3673b, this.f3674c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.w3(parcel, 1, this.f3673b, false);
        t.v3(parcel, 2, this.f3674c, i, false);
        t.w4(parcel, m);
    }
}
