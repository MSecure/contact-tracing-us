package e.o.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class j0 implements Parcelable {
    public static final Parcelable.Creator<j0> CREATOR = new a();
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1798d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1799e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1800f;

    /* renamed from: g  reason: collision with root package name */
    public final String f1801g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1802h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f1803i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f1804j;

    /* renamed from: k  reason: collision with root package name */
    public final Bundle f1805k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f1806l;
    public final int m;
    public Bundle n;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<j0> {
        @Override // android.os.Parcelable.Creator
        public j0 createFromParcel(Parcel parcel) {
            return new j0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public j0[] newArray(int i2) {
            return new j0[i2];
        }
    }

    public j0(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
        boolean z = true;
        this.f1798d = parcel.readInt() != 0;
        this.f1799e = parcel.readInt();
        this.f1800f = parcel.readInt();
        this.f1801g = parcel.readString();
        this.f1802h = parcel.readInt() != 0;
        this.f1803i = parcel.readInt() != 0;
        this.f1804j = parcel.readInt() != 0;
        this.f1805k = parcel.readBundle();
        this.f1806l = parcel.readInt() == 0 ? false : z;
        this.n = parcel.readBundle();
        this.m = parcel.readInt();
    }

    public j0(m mVar) {
        this.b = mVar.getClass().getName();
        this.c = mVar.f1811f;
        this.f1798d = mVar.n;
        this.f1799e = mVar.w;
        this.f1800f = mVar.x;
        this.f1801g = mVar.y;
        this.f1802h = mVar.B;
        this.f1803i = mVar.m;
        this.f1804j = mVar.A;
        this.f1805k = mVar.f1812g;
        this.f1806l = mVar.z;
        this.m = mVar.N.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.b);
        sb.append(" (");
        sb.append(this.c);
        sb.append(")}:");
        if (this.f1798d) {
            sb.append(" fromLayout");
        }
        if (this.f1800f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1800f));
        }
        String str = this.f1801g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1801g);
        }
        if (this.f1802h) {
            sb.append(" retainInstance");
        }
        if (this.f1803i) {
            sb.append(" removing");
        }
        if (this.f1804j) {
            sb.append(" detached");
        }
        if (this.f1806l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.f1798d ? 1 : 0);
        parcel.writeInt(this.f1799e);
        parcel.writeInt(this.f1800f);
        parcel.writeString(this.f1801g);
        parcel.writeInt(this.f1802h ? 1 : 0);
        parcel.writeInt(this.f1803i ? 1 : 0);
        parcel.writeInt(this.f1804j ? 1 : 0);
        parcel.writeBundle(this.f1805k);
        parcel.writeInt(this.f1806l ? 1 : 0);
        parcel.writeBundle(this.n);
        parcel.writeInt(this.m);
    }
}
