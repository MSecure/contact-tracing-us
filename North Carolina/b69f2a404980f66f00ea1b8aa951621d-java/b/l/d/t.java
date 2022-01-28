package b.l.d;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
public final class t implements Parcelable {
    public static final Parcelable.Creator<t> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<v> f1347b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f1348c;

    /* renamed from: d  reason: collision with root package name */
    public b[] f1349d;

    /* renamed from: e  reason: collision with root package name */
    public int f1350e;
    public String f = null;

    public static class a implements Parcelable.Creator<t> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public t createFromParcel(Parcel parcel) {
            return new t(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public t[] newArray(int i) {
            return new t[i];
        }
    }

    public t() {
    }

    public t(Parcel parcel) {
        this.f1347b = parcel.createTypedArrayList(v.CREATOR);
        this.f1348c = parcel.createStringArrayList();
        this.f1349d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1350e = parcel.readInt();
        this.f = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f1347b);
        parcel.writeStringList(this.f1348c);
        parcel.writeTypedArray(this.f1349d, i);
        parcel.writeInt(this.f1350e);
        parcel.writeString(this.f);
    }
}
