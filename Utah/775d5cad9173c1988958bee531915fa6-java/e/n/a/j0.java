package e.n.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class j0 implements Parcelable {
    public static final Parcelable.Creator<j0> CREATOR = new a();
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1713d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1714e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1715f;

    /* renamed from: g  reason: collision with root package name */
    public final String f1716g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1717h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f1718i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f1719j;

    /* renamed from: k  reason: collision with root package name */
    public final Bundle f1720k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f1721l;
    public final int m;
    public Bundle n;

    public class a implements Parcelable.Creator<j0> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public j0 createFromParcel(Parcel parcel) {
            return new j0(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public j0[] newArray(int i2) {
            return new j0[i2];
        }
    }

    public j0(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
        boolean z = true;
        this.f1713d = parcel.readInt() != 0;
        this.f1714e = parcel.readInt();
        this.f1715f = parcel.readInt();
        this.f1716g = parcel.readString();
        this.f1717h = parcel.readInt() != 0;
        this.f1718i = parcel.readInt() != 0;
        this.f1719j = parcel.readInt() != 0;
        this.f1720k = parcel.readBundle();
        this.f1721l = parcel.readInt() == 0 ? false : z;
        this.n = parcel.readBundle();
        this.m = parcel.readInt();
    }

    public j0(m mVar) {
        this.b = mVar.getClass().getName();
        this.c = mVar.f1726f;
        this.f1713d = mVar.n;
        this.f1714e = mVar.w;
        this.f1715f = mVar.x;
        this.f1716g = mVar.y;
        this.f1717h = mVar.B;
        this.f1718i = mVar.m;
        this.f1719j = mVar.A;
        this.f1720k = mVar.f1727g;
        this.f1721l = mVar.z;
        this.m = mVar.N.ordinal();
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
        if (this.f1713d) {
            sb.append(" fromLayout");
        }
        if (this.f1715f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1715f));
        }
        String str = this.f1716g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1716g);
        }
        if (this.f1717h) {
            sb.append(" retainInstance");
        }
        if (this.f1718i) {
            sb.append(" removing");
        }
        if (this.f1719j) {
            sb.append(" detached");
        }
        if (this.f1721l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.f1713d ? 1 : 0);
        parcel.writeInt(this.f1714e);
        parcel.writeInt(this.f1715f);
        parcel.writeString(this.f1716g);
        parcel.writeInt(this.f1717h ? 1 : 0);
        parcel.writeInt(this.f1718i ? 1 : 0);
        parcel.writeInt(this.f1719j ? 1 : 0);
        parcel.writeBundle(this.f1720k);
        parcel.writeInt(this.f1721l ? 1 : 0);
        parcel.writeBundle(this.n);
        parcel.writeInt(this.m);
    }
}
