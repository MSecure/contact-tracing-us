package e.m.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.m.a.c0;
import java.util.ArrayList;

public final class f0 implements Parcelable {
    public static final Parcelable.Creator<f0> CREATOR = new a();
    public ArrayList<i0> b;
    public ArrayList<String> c;

    /* renamed from: d  reason: collision with root package name */
    public b[] f1589d;

    /* renamed from: e  reason: collision with root package name */
    public int f1590e;

    /* renamed from: f  reason: collision with root package name */
    public String f1591f = null;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f1592g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Bundle> f1593h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<c0.l> f1594i;

    public class a implements Parcelable.Creator<f0> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public f0 createFromParcel(Parcel parcel) {
            return new f0(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public f0[] newArray(int i2) {
            return new f0[i2];
        }
    }

    public f0() {
    }

    public f0(Parcel parcel) {
        this.b = parcel.createTypedArrayList(i0.CREATOR);
        this.c = parcel.createStringArrayList();
        this.f1589d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1590e = parcel.readInt();
        this.f1591f = parcel.readString();
        this.f1592g = parcel.createStringArrayList();
        this.f1593h = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f1594i = parcel.createTypedArrayList(c0.l.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.b);
        parcel.writeStringList(this.c);
        parcel.writeTypedArray(this.f1589d, i2);
        parcel.writeInt(this.f1590e);
        parcel.writeString(this.f1591f);
        parcel.writeStringList(this.f1592g);
        parcel.writeTypedList(this.f1593h);
        parcel.writeTypedList(this.f1594i);
    }
}
