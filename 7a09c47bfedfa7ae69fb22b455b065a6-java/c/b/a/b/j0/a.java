package c.b.a.b.j0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.e.h;

public class a extends b.k.a.a {
    public static final Parcelable.Creator<a> CREATOR = new C0074a();

    /* renamed from: d  reason: collision with root package name */
    public final h<String, Bundle> f4348d;

    /* renamed from: c.b.a.b.j0.a$a  reason: collision with other inner class name */
    public static class C0074a implements Parcelable.ClassLoaderCreator<a> {
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

    public a(Parcel parcel, ClassLoader classLoader, C0074a aVar) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f4348d = new h<>(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f4348d.put(strArr[i], bundleArr[i]);
        }
    }

    public String toString() {
        StringBuilder h = c.a.a.a.a.h("ExtendableSavedState{");
        h.append(Integer.toHexString(System.identityHashCode(this)));
        h.append(" states=");
        h.append(this.f4348d);
        h.append("}");
        return h.toString();
    }

    @Override // b.k.a.a
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1952b, i);
        int i2 = this.f4348d.f1413d;
        parcel.writeInt(i2);
        String[] strArr = new String[i2];
        Bundle[] bundleArr = new Bundle[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            strArr[i3] = this.f4348d.h(i3);
            bundleArr[i3] = this.f4348d.k(i3);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
