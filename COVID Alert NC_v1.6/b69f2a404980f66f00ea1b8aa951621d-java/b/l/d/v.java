package b.l.d;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

@SuppressLint({"BanParcelableUsage"})
public final class v implements Parcelable {
    public static final Parcelable.Creator<v> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final String f1356b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1357c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1358d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1359e;
    public final int f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final Bundle k;
    public final boolean l;
    public final int m;
    public Bundle n;

    public static class a implements Parcelable.Creator<v> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public v createFromParcel(Parcel parcel) {
            return new v(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public v[] newArray(int i) {
            return new v[i];
        }
    }

    public v(Parcel parcel) {
        this.f1356b = parcel.readString();
        this.f1357c = parcel.readString();
        boolean z = true;
        this.f1358d = parcel.readInt() != 0;
        this.f1359e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt() != 0;
        this.i = parcel.readInt() != 0;
        this.j = parcel.readInt() != 0;
        this.k = parcel.readBundle();
        this.l = parcel.readInt() == 0 ? false : z;
        this.n = parcel.readBundle();
        this.m = parcel.readInt();
    }

    public v(Fragment fragment) {
        this.f1356b = fragment.getClass().getName();
        this.f1357c = fragment.mWho;
        this.f1358d = fragment.mFromLayout;
        this.f1359e = fragment.mFragmentId;
        this.f = fragment.mContainerId;
        this.g = fragment.mTag;
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
        StringBuilder sb = new StringBuilder((int) RecyclerView.d0.FLAG_IGNORE);
        sb.append("FragmentState{");
        sb.append(this.f1356b);
        sb.append(" (");
        sb.append(this.f1357c);
        sb.append(")}:");
        if (this.f1358d) {
            sb.append(" fromLayout");
        }
        if (this.f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f));
        }
        String str = this.g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.g);
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
        parcel.writeString(this.f1356b);
        parcel.writeString(this.f1357c);
        parcel.writeInt(this.f1358d ? 1 : 0);
        parcel.writeInt(this.f1359e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeBundle(this.n);
        parcel.writeInt(this.m);
    }
}
