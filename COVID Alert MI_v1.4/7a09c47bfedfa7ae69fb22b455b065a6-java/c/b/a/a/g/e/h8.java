package c.b.a.a.g.e;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class h8 extends a {
    public static final Parcelable.Creator<h8> CREATOR = new g8();

    /* renamed from: b  reason: collision with root package name */
    public String f3589b;

    /* renamed from: c  reason: collision with root package name */
    public String f3590c;

    /* renamed from: d  reason: collision with root package name */
    public String f3591d;

    /* renamed from: e  reason: collision with root package name */
    public BluetoothDevice f3592e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f3593f;

    public h8() {
    }

    public h8(String str, String str2, String str3, BluetoothDevice bluetoothDevice, byte[] bArr) {
        this.f3589b = str;
        this.f3590c = str2;
        this.f3591d = str3;
        this.f3592e = bluetoothDevice;
        this.f3593f = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h8) {
            h8 h8Var = (h8) obj;
            return t.j1(this.f3589b, h8Var.f3589b) && t.j1(this.f3590c, h8Var.f3590c) && t.j1(this.f3591d, h8Var.f3591d) && t.j1(this.f3592e, h8Var.f3592e) && Arrays.equals(this.f3593f, h8Var.f3593f);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3589b, this.f3590c, this.f3591d, this.f3592e, Integer.valueOf(Arrays.hashCode(this.f3593f))});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.w3(parcel, 1, this.f3589b, false);
        t.w3(parcel, 2, this.f3590c, false);
        t.w3(parcel, 3, this.f3591d, false);
        t.v3(parcel, 4, this.f3592e, i, false);
        t.l3(parcel, 5, this.f3593f, false);
        t.w4(parcel, m);
    }
}
