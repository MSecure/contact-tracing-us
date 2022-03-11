package e.o.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.o.a.e0;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class g0 implements Parcelable {
    public static final Parcelable.Creator<g0> CREATOR = new a();
    public ArrayList<j0> b;
    public ArrayList<String> c;

    /* renamed from: d  reason: collision with root package name */
    public b[] f1783d;

    /* renamed from: e  reason: collision with root package name */
    public int f1784e;

    /* renamed from: f  reason: collision with root package name */
    public String f1785f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f1786g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Bundle> f1787h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<e0.k> f1788i;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<g0> {
        @Override // android.os.Parcelable.Creator
        public g0 createFromParcel(Parcel parcel) {
            return new g0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public g0[] newArray(int i2) {
            return new g0[i2];
        }
    }

    public g0() {
        this.f1785f = null;
        this.f1786g = new ArrayList<>();
        this.f1787h = new ArrayList<>();
    }

    public g0(Parcel parcel) {
        this.f1785f = null;
        this.f1786g = new ArrayList<>();
        this.f1787h = new ArrayList<>();
        this.b = parcel.createTypedArrayList(j0.CREATOR);
        this.c = parcel.createStringArrayList();
        this.f1783d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1784e = parcel.readInt();
        this.f1785f = parcel.readString();
        this.f1786g = parcel.createStringArrayList();
        this.f1787h = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f1788i = parcel.createTypedArrayList(e0.k.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.b);
        parcel.writeStringList(this.c);
        parcel.writeTypedArray(this.f1783d, i2);
        parcel.writeInt(this.f1784e);
        parcel.writeString(this.f1785f);
        parcel.writeStringList(this.f1786g);
        parcel.writeTypedList(this.f1787h);
        parcel.writeTypedList(this.f1788i);
    }
}
