package e.m.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.m.a.f0;
import java.util.ArrayList;

public final class i0 implements Parcelable {
    public static final Parcelable.Creator<i0> CREATOR = new a();
    public ArrayList<l0> b;
    public ArrayList<String> c;

    /* renamed from: d  reason: collision with root package name */
    public b[] f1617d;

    /* renamed from: e  reason: collision with root package name */
    public int f1618e;

    /* renamed from: f  reason: collision with root package name */
    public String f1619f = null;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f1620g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Bundle> f1621h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<f0.l> f1622i;

    public class a implements Parcelable.Creator<i0> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public i0 createFromParcel(Parcel parcel) {
            return new i0(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public i0[] newArray(int i2) {
            return new i0[i2];
        }
    }

    public i0() {
    }

    public i0(Parcel parcel) {
        this.b = parcel.createTypedArrayList(l0.CREATOR);
        this.c = parcel.createStringArrayList();
        this.f1617d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1618e = parcel.readInt();
        this.f1619f = parcel.readString();
        this.f1620g = parcel.createStringArrayList();
        this.f1621h = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f1622i = parcel.createTypedArrayList(f0.l.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.b);
        parcel.writeStringList(this.c);
        parcel.writeTypedArray(this.f1617d, i2);
        parcel.writeInt(this.f1618e);
        parcel.writeString(this.f1619f);
        parcel.writeStringList(this.f1620g);
        parcel.writeTypedList(this.f1621h);
        parcel.writeTypedList(this.f1622i);
    }
}
