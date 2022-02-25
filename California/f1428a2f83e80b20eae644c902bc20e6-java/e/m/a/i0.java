package e.m.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class i0 implements Parcelable {
    public static final Parcelable.Creator<i0> CREATOR = new a();
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1604d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1605e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1606f;

    /* renamed from: g  reason: collision with root package name */
    public final String f1607g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1608h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f1609i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f1610j;

    /* renamed from: k  reason: collision with root package name */
    public final Bundle f1611k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f1612l;
    public final int m;
    public Bundle n;

    public class a implements Parcelable.Creator<i0> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public i0 createFromParcel(Parcel parcel) {
            return new i0(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public i0[] newArray(int i2) {
            return new i0[i2];
        }
    }

    public i0(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
        boolean z = true;
        this.f1604d = parcel.readInt() != 0;
        this.f1605e = parcel.readInt();
        this.f1606f = parcel.readInt();
        this.f1607g = parcel.readString();
        this.f1608h = parcel.readInt() != 0;
        this.f1609i = parcel.readInt() != 0;
        this.f1610j = parcel.readInt() != 0;
        this.f1611k = parcel.readBundle();
        this.f1612l = parcel.readInt() == 0 ? false : z;
        this.n = parcel.readBundle();
        this.m = parcel.readInt();
    }

    public i0(l lVar) {
        this.b = lVar.getClass().getName();
        this.c = lVar.f1620f;
        this.f1604d = lVar.n;
        this.f1605e = lVar.w;
        this.f1606f = lVar.x;
        this.f1607g = lVar.y;
        this.f1608h = lVar.B;
        this.f1609i = lVar.m;
        this.f1610j = lVar.A;
        this.f1611k = lVar.f1621g;
        this.f1612l = lVar.z;
        this.m = lVar.O.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.b);
        sb.append(" (");
        sb.append(this.c);
        sb.append(")}:");
        if (this.f1604d) {
            sb.append(" fromLayout");
        }
        if (this.f1606f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1606f));
        }
        String str = this.f1607g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1607g);
        }
        if (this.f1608h) {
            sb.append(" retainInstance");
        }
        if (this.f1609i) {
            sb.append(" removing");
        }
        if (this.f1610j) {
            sb.append(" detached");
        }
        if (this.f1612l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.f1604d ? 1 : 0);
        parcel.writeInt(this.f1605e);
        parcel.writeInt(this.f1606f);
        parcel.writeString(this.f1607g);
        parcel.writeInt(this.f1608h ? 1 : 0);
        parcel.writeInt(this.f1609i ? 1 : 0);
        parcel.writeInt(this.f1610j ? 1 : 0);
        parcel.writeBundle(this.f1611k);
        parcel.writeInt(this.f1612l ? 1 : 0);
        parcel.writeBundle(this.n);
        parcel.writeInt(this.m);
    }
}
