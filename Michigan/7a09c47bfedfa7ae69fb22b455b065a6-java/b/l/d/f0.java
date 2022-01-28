package b.l.d;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

@SuppressLint({"BanParcelableUsage"})
public final class f0 implements Parcelable {
    public static final Parcelable.Creator<f0> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final String f2010b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2011c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2012d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2013e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2014f;

    /* renamed from: g  reason: collision with root package name */
    public final String f2015g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final Bundle k;
    public final boolean l;
    public final int m;
    public Bundle n;

    public class a implements Parcelable.Creator<f0> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public f0 createFromParcel(Parcel parcel) {
            return new f0(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public f0[] newArray(int i) {
            return new f0[i];
        }
    }

    public f0(Parcel parcel) {
        this.f2010b = parcel.readString();
        this.f2011c = parcel.readString();
        boolean z = true;
        this.f2012d = parcel.readInt() != 0;
        this.f2013e = parcel.readInt();
        this.f2014f = parcel.readInt();
        this.f2015g = parcel.readString();
        this.h = parcel.readInt() != 0;
        this.i = parcel.readInt() != 0;
        this.j = parcel.readInt() != 0;
        this.k = parcel.readBundle();
        this.l = parcel.readInt() == 0 ? false : z;
        this.n = parcel.readBundle();
        this.m = parcel.readInt();
    }

    public f0(Fragment fragment) {
        this.f2010b = fragment.getClass().getName();
        this.f2011c = fragment.mWho;
        this.f2012d = fragment.mFromLayout;
        this.f2013e = fragment.mFragmentId;
        this.f2014f = fragment.mContainerId;
        this.f2015g = fragment.mTag;
        this.h = fragment.mRetainInstance;
        this.i = fragment.mRemoving;
        this.j = fragment.mDetached;
        this.k = fragment.mArguments;
        this.l = fragment.mHidden;
        this.m = fragment.mMaxState.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) RecyclerView.a0.FLAG_IGNORE);
        sb.append("FragmentState{");
        sb.append(this.f2010b);
        sb.append(" (");
        sb.append(this.f2011c);
        sb.append(")}:");
        if (this.f2012d) {
            sb.append(" fromLayout");
        }
        if (this.f2014f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f2014f));
        }
        String str = this.f2015g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f2015g);
        }
        if (this.h) {
            sb.append(" retainInstance");
        }
        if (this.i) {
            sb.append(" removing");
        }
        if (this.j) {
            sb.append(" detached");
        }
        if (this.l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f2010b);
        parcel.writeString(this.f2011c);
        parcel.writeInt(this.f2012d ? 1 : 0);
        parcel.writeInt(this.f2013e);
        parcel.writeInt(this.f2014f);
        parcel.writeString(this.f2015g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeBundle(this.n);
        parcel.writeInt(this.m);
    }
}
