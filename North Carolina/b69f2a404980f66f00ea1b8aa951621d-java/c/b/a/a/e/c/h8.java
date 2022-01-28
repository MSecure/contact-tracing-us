package c.b.a.a.e.c;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class h8 extends a {
    public static final Parcelable.Creator<h8> CREATOR = new g8();

    /* renamed from: b  reason: collision with root package name */
    public String f2604b;

    /* renamed from: c  reason: collision with root package name */
    public String f2605c;

    /* renamed from: d  reason: collision with root package name */
    public String f2606d;

    /* renamed from: e  reason: collision with root package name */
    public BluetoothDevice f2607e;
    public byte[] f;

    public h8() {
    }

    public h8(String str, String str2, String str3, BluetoothDevice bluetoothDevice, byte[] bArr) {
        this.f2604b = str;
        this.f2605c = str2;
        this.f2606d = str3;
        this.f2607e = bluetoothDevice;
        this.f = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h8) {
            h8 h8Var = (h8) obj;
            return i.j.X(this.f2604b, h8Var.f2604b) && i.j.X(this.f2605c, h8Var.f2605c) && i.j.X(this.f2606d, h8Var.f2606d) && i.j.X(this.f2607e, h8Var.f2607e) && Arrays.equals(this.f, h8Var.f);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2604b, this.f2605c, this.f2606d, this.f2607e, Integer.valueOf(Arrays.hashCode(this.f))});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.z1(parcel, 1, this.f2604b, false);
        i.j.z1(parcel, 2, this.f2605c, false);
        i.j.z1(parcel, 3, this.f2606d, false);
        i.j.y1(parcel, 4, this.f2607e, i, false);
        i.j.q1(parcel, 5, this.f, false);
        i.j.F1(parcel, e2);
    }
}
