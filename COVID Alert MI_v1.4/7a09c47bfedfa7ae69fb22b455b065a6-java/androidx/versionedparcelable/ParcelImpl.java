package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import b.z.c;
import b.z.d;

@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final d f413b;

    public static class a implements Parcelable.Creator<ParcelImpl> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ParcelImpl[] newArray(int i) {
            return new ParcelImpl[i];
        }
    }

    public ParcelImpl(Parcel parcel) {
        this.f413b = new c(parcel).o();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        new c(parcel).w(this.f413b);
    }
}
