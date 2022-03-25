package e.m.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class l0 implements Parcelable {
    public static final Parcelable.Creator<l0> CREATOR = new a();
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1647d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1648e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1649f;

    /* renamed from: g  reason: collision with root package name */
    public final String f1650g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1651h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f1652i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f1653j;

    /* renamed from: k  reason: collision with root package name */
    public final Bundle f1654k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f1655l;
    public final int m;
    public Bundle n;

    public class a implements Parcelable.Creator<l0> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public l0 createFromParcel(Parcel parcel) {
            return new l0(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public l0[] newArray(int i2) {
            return new l0[i2];
        }
    }

    public l0(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
        boolean z = true;
        this.f1647d = parcel.readInt() != 0;
        this.f1648e = parcel.readInt();
        this.f1649f = parcel.readInt();
        this.f1650g = parcel.readString();
        this.f1651h = parcel.readInt() != 0;
        this.f1652i = parcel.readInt() != 0;
        this.f1653j = parcel.readInt() != 0;
        this.f1654k = parcel.readBundle();
        this.f1655l = parcel.readInt() == 0 ? false : z;
        this.n = parcel.readBundle();
        this.m = parcel.readInt();
    }

    public l0(l lVar) {
        this.b = lVar.getClass().getName();
        this.c = lVar.f1631f;
        this.f1647d = lVar.n;
        this.f1648e = lVar.w;
        this.f1649f = lVar.x;
        this.f1650g = lVar.y;
        this.f1651h = lVar.B;
        this.f1652i = lVar.m;
        this.f1653j = lVar.A;
        this.f1654k = lVar.f1632g;
        this.f1655l = lVar.z;
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
        if (this.f1647d) {
            sb.append(" fromLayout");
        }
        if (this.f1649f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1649f));
        }
        String str = this.f1650g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1650g);
        }
        if (this.f1651h) {
            sb.append(" retainInstance");
        }
        if (this.f1652i) {
            sb.append(" removing");
        }
        if (this.f1653j) {
            sb.append(" detached");
        }
        if (this.f1655l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.f1647d ? 1 : 0);
        parcel.writeInt(this.f1648e);
        parcel.writeInt(this.f1649f);
        parcel.writeString(this.f1650g);
        parcel.writeInt(this.f1651h ? 1 : 0);
        parcel.writeInt(this.f1652i ? 1 : 0);
        parcel.writeInt(this.f1653j ? 1 : 0);
        parcel.writeBundle(this.f1654k);
        parcel.writeInt(this.f1655l ? 1 : 0);
        parcel.writeBundle(this.n);
        parcel.writeInt(this.m);
    }
}
