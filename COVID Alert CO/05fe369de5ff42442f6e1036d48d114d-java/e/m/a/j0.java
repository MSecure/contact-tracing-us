package e.m.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class j0 implements Parcelable {
    public static final Parcelable.Creator<j0> CREATOR = new a();
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1440d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1441e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1442f;

    /* renamed from: g  reason: collision with root package name */
    public final String f1443g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1444h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f1445i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f1446j;

    /* renamed from: k  reason: collision with root package name */
    public final Bundle f1447k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f1448l;
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
        this.f1440d = parcel.readInt() != 0;
        this.f1441e = parcel.readInt();
        this.f1442f = parcel.readInt();
        this.f1443g = parcel.readString();
        this.f1444h = parcel.readInt() != 0;
        this.f1445i = parcel.readInt() != 0;
        this.f1446j = parcel.readInt() != 0;
        this.f1447k = parcel.readBundle();
        this.f1448l = parcel.readInt() == 0 ? false : z;
        this.n = parcel.readBundle();
        this.m = parcel.readInt();
    }

    public j0(m mVar) {
        this.b = mVar.getClass().getName();
        this.c = mVar.f1453f;
        this.f1440d = mVar.n;
        this.f1441e = mVar.w;
        this.f1442f = mVar.x;
        this.f1443g = mVar.y;
        this.f1444h = mVar.B;
        this.f1445i = mVar.m;
        this.f1446j = mVar.A;
        this.f1447k = mVar.f1454g;
        this.f1448l = mVar.z;
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
        if (this.f1440d) {
            sb.append(" fromLayout");
        }
        if (this.f1442f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1442f));
        }
        String str = this.f1443g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1443g);
        }
        if (this.f1444h) {
            sb.append(" retainInstance");
        }
        if (this.f1445i) {
            sb.append(" removing");
        }
        if (this.f1446j) {
            sb.append(" detached");
        }
        if (this.f1448l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.f1440d ? 1 : 0);
        parcel.writeInt(this.f1441e);
        parcel.writeInt(this.f1442f);
        parcel.writeString(this.f1443g);
        parcel.writeInt(this.f1444h ? 1 : 0);
        parcel.writeInt(this.f1445i ? 1 : 0);
        parcel.writeInt(this.f1446j ? 1 : 0);
        parcel.writeBundle(this.f1447k);
        parcel.writeInt(this.f1448l ? 1 : 0);
        parcel.writeBundle(this.n);
        parcel.writeInt(this.m);
    }
}
