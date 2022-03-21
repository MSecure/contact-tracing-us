package f.b.a.d.x;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.e.h;

public class a extends e.k.a.a {
    public static final Parcelable.Creator<a> CREATOR = new C0095a();

    /* renamed from: d  reason: collision with root package name */
    public final h<String, Bundle> f2827d;

    /* renamed from: f.b.a.d.x.a$a  reason: collision with other inner class name */
    public static class C0095a implements Parcelable.ClassLoaderCreator<a> {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new a(parcel, null, null);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i2) {
            return new a[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }
    }

    public a(Parcel parcel, ClassLoader classLoader, C0095a aVar) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f2827d = new h<>(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f2827d.put(strArr[i2], bundleArr[i2]);
        }
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("ExtendableSavedState{");
        h2.append(Integer.toHexString(System.identityHashCode(this)));
        h2.append(" states=");
        h2.append(this.f2827d);
        h2.append("}");
        return h2.toString();
    }

    @Override // e.k.a.a
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.b, i2);
        int i3 = this.f2827d.f1198d;
        parcel.writeInt(i3);
        String[] strArr = new String[i3];
        Bundle[] bundleArr = new Bundle[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            strArr[i4] = this.f2827d.h(i4);
            bundleArr[i4] = this.f2827d.k(i4);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
