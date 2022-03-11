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
    public b[] f1588d;

    /* renamed from: e  reason: collision with root package name */
    public int f1589e;

    /* renamed from: f  reason: collision with root package name */
    public String f1590f = null;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f1591g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Bundle> f1592h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<c0.l> f1593i;

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
        this.f1588d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1589e = parcel.readInt();
        this.f1590f = parcel.readString();
        this.f1591g = parcel.createStringArrayList();
        this.f1592h = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f1593i = parcel.createTypedArrayList(c0.l.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.b);
        parcel.writeStringList(this.c);
        parcel.writeTypedArray(this.f1588d, i2);
        parcel.writeInt(this.f1589e);
        parcel.writeString(this.f1590f);
        parcel.writeStringList(this.f1591g);
        parcel.writeTypedList(this.f1592h);
        parcel.writeTypedList(this.f1593i);
    }
}
