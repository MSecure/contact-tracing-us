package c.b.a.b.j0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.e.h;

public class a extends b.k.a.a {
    public static final Parcelable.Creator<a> CREATOR = new C0065a();

    /* renamed from: d  reason: collision with root package name */
    public final h<String, Bundle> f3055d;

    /* renamed from: c.b.a.b.j0.a$a  reason: collision with other inner class name */
    public static class C0065a implements Parcelable.ClassLoaderCreator<a> {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new a(parcel, null, null);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new a[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }
    }

    public a(Parcel parcel, ClassLoader classLoader, C0065a aVar) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f3055d = new h<>(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f3055d.put(strArr[i], bundleArr[i]);
        }
    }

    public String toString() {
        StringBuilder g = c.a.a.a.a.g("ExtendableSavedState{");
        g.append(Integer.toHexString(System.identityHashCode(this)));
        g.append(" states=");
        g.append(this.f3055d);
        g.append("}");
        return g.toString();
    }

    @Override // b.k.a.a
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1231b, i);
        int i2 = this.f3055d.f829d;
        parcel.writeInt(i2);
        String[] strArr = new String[i2];
        Bundle[] bundleArr = new Bundle[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            strArr[i3] = this.f3055d.h(i3);
            bundleArr[i3] = this.f3055d.k(i3);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
