package f.b.a.e.x;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.f.h;
/* loaded from: classes.dex */
public class a extends e.l.a.a {
    public static final Parcelable.Creator<a> CREATOR = new C0100a();

    /* renamed from: d  reason: collision with root package name */
    public final h<String, Bundle> f3126d;

    /* renamed from: f.b.a.e.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0100a implements Parcelable.ClassLoaderCreator<a> {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new a(parcel, null, null);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i2) {
            return new a[i2];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }
    }

    public a(Parcel parcel, ClassLoader classLoader, C0100a aVar) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f3126d = new h<>(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f3126d.put(strArr[i2], bundleArr[i2]);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("ExtendableSavedState{");
        h2.append(Integer.toHexString(System.identityHashCode(this)));
        h2.append(" states=");
        h2.append(this.f3126d);
        h2.append("}");
        return h2.toString();
    }

    @Override // e.l.a.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.b, i2);
        int i3 = this.f3126d.f1316d;
        parcel.writeInt(i3);
        String[] strArr = new String[i3];
        Bundle[] bundleArr = new Bundle[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            strArr[i4] = this.f3126d.h(i4);
            bundleArr[i4] = this.f3126d.k(i4);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
