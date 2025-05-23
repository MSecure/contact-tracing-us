package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import e.y.b;
import e.y.c;

public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();
    public final c b;

    public static class a implements Parcelable.Creator<ParcelImpl> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ParcelImpl[] newArray(int i2) {
            return new ParcelImpl[i2];
        }
    }

    public ParcelImpl(Parcel parcel) {
        this.b = new b(parcel).o();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        new b(parcel).w(this.b);
    }
}
