package b.k.a;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final a f1951c = new C0039a();

    /* renamed from: b  reason: collision with root package name */
    public final Parcelable f1952b;

    /* renamed from: b.k.a.a$a  reason: collision with other inner class name */
    public static class C0039a extends a {
        public C0039a() {
            super((C0039a) null);
        }
    }

    public static class b implements Parcelable.ClassLoaderCreator<a> {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            if (parcel.readParcelable(null) == null) {
                return a.f1951c;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new a[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.f1951c;
            }
            throw new IllegalStateException("superState must be null");
        }
    }

    public a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f1952b = readParcelable == null ? f1951c : readParcelable;
    }

    public a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f1952b = parcelable == f1951c ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public a(C0039a aVar) {
        this.f1952b = null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1952b, i);
    }
}
