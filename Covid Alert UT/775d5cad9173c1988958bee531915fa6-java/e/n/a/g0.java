package e.n.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.n.a.e0;
import java.util.ArrayList;

public final class g0 implements Parcelable {
    public static final Parcelable.Creator<g0> CREATOR = new a();
    public ArrayList<j0> b;
    public ArrayList<String> c;

    /* renamed from: d  reason: collision with root package name */
    public b[] f1698d;

    /* renamed from: e  reason: collision with root package name */
    public int f1699e;

    /* renamed from: f  reason: collision with root package name */
    public String f1700f = null;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f1701g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Bundle> f1702h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<e0.k> f1703i;

    public class a implements Parcelable.Creator<g0> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public g0 createFromParcel(Parcel parcel) {
            return new g0(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public g0[] newArray(int i2) {
            return new g0[i2];
        }
    }

    public g0() {
    }

    public g0(Parcel parcel) {
        this.b = parcel.createTypedArrayList(j0.CREATOR);
        this.c = parcel.createStringArrayList();
        this.f1698d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1699e = parcel.readInt();
        this.f1700f = parcel.readString();
        this.f1701g = parcel.createStringArrayList();
        this.f1702h = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f1703i = parcel.createTypedArrayList(e0.k.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.b);
        parcel.writeStringList(this.c);
        parcel.writeTypedArray(this.f1698d, i2);
        parcel.writeInt(this.f1699e);
        parcel.writeString(this.f1700f);
        parcel.writeStringList(this.f1701g);
        parcel.writeTypedList(this.f1702h);
        parcel.writeTypedList(this.f1703i);
    }
}
