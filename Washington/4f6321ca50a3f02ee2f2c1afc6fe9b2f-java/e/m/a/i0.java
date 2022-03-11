package e.m.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class i0 implements Parcelable {
    public static final Parcelable.Creator<i0> CREATOR = new a();
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1603d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1604e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1605f;

    /* renamed from: g  reason: collision with root package name */
    public final String f1606g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1607h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f1608i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f1609j;

    /* renamed from: k  reason: collision with root package name */
    public final Bundle f1610k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f1611l;
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
        this.f1603d = parcel.readInt() != 0;
        this.f1604e = parcel.readInt();
        this.f1605f = parcel.readInt();
        this.f1606g = parcel.readString();
        this.f1607h = parcel.readInt() != 0;
        this.f1608i = parcel.readInt() != 0;
        this.f1609j = parcel.readInt() != 0;
        this.f1610k = parcel.readBundle();
        this.f1611l = parcel.readInt() == 0 ? false : z;
        this.n = parcel.readBundle();
        this.m = parcel.readInt();
    }

    public i0(l lVar) {
        this.b = lVar.getClass().getName();
        this.c = lVar.f1619f;
        this.f1603d = lVar.n;
        this.f1604e = lVar.w;
        this.f1605f = lVar.x;
        this.f1606g = lVar.y;
        this.f1607h = lVar.B;
        this.f1608i = lVar.m;
        this.f1609j = lVar.A;
        this.f1610k = lVar.f1620g;
        this.f1611l = lVar.z;
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
        if (this.f1603d) {
            sb.append(" fromLayout");
        }
        if (this.f1605f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1605f));
        }
        String str = this.f1606g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1606g);
        }
        if (this.f1607h) {
            sb.append(" retainInstance");
        }
        if (this.f1608i) {
            sb.append(" removing");
        }
        if (this.f1609j) {
            sb.append(" detached");
        }
        if (this.f1611l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.f1603d ? 1 : 0);
        parcel.writeInt(this.f1604e);
        parcel.writeInt(this.f1605f);
        parcel.writeString(this.f1606g);
        parcel.writeInt(this.f1607h ? 1 : 0);
        parcel.writeInt(this.f1608i ? 1 : 0);
        parcel.writeInt(this.f1609j ? 1 : 0);
        parcel.writeBundle(this.f1610k);
        parcel.writeInt(this.f1611l ? 1 : 0);
        parcel.writeBundle(this.n);
        parcel.writeInt(this.m);
    }
}
