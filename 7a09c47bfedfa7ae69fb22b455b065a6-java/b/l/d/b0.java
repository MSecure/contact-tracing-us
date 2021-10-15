package b.l.d;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.l.d.z;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
public final class b0 implements Parcelable {
    public static final Parcelable.Creator<b0> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<f0> f1976b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f1977c;

    /* renamed from: d  reason: collision with root package name */
    public b[] f1978d;

    /* renamed from: e  reason: collision with root package name */
    public int f1979e;

    /* renamed from: f  reason: collision with root package name */
    public String f1980f = null;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f1981g = new ArrayList<>();
    public ArrayList<Bundle> h = new ArrayList<>();
    public ArrayList<z.k> i;

    public class a implements Parcelable.Creator<b0> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public b0 createFromParcel(Parcel parcel) {
            return new b0(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public b0[] newArray(int i) {
            return new b0[i];
        }
    }

    public b0() {
    }

    public b0(Parcel parcel) {
        this.f1976b = parcel.createTypedArrayList(f0.CREATOR);
        this.f1977c = parcel.createStringArrayList();
        this.f1978d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1979e = parcel.readInt();
        this.f1980f = parcel.readString();
        this.f1981g = parcel.createStringArrayList();
        this.h = parcel.createTypedArrayList(Bundle.CREATOR);
        this.i = parcel.createTypedArrayList(z.k.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f1976b);
        parcel.writeStringList(this.f1977c);
        parcel.writeTypedArray(this.f1978d, i2);
        parcel.writeInt(this.f1979e);
        parcel.writeString(this.f1980f);
        parcel.writeStringList(this.f1981g);
        parcel.writeTypedList(this.h);
        parcel.writeTypedList(this.i);
    }
}
