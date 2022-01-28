package c.b.a.b.x;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0073a();

    /* renamed from: b  reason: collision with root package name */
    public final s f3218b;

    /* renamed from: c  reason: collision with root package name */
    public final s f3219c;

    /* renamed from: d  reason: collision with root package name */
    public final s f3220d;

    /* renamed from: e  reason: collision with root package name */
    public final c f3221e;
    public final int f;
    public final int g;

    /* renamed from: c.b.a.b.x.a$a  reason: collision with other inner class name */
    public static class C0073a implements Parcelable.Creator<a> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a((s) parcel.readParcelable(s.class.getClassLoader()), (s) parcel.readParcelable(s.class.getClassLoader()), (s) parcel.readParcelable(s.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        public static final long f3222e = a0.a(s.q(1900, 0).h);
        public static final long f = a0.a(s.q(2100, 11).h);

        /* renamed from: a  reason: collision with root package name */
        public long f3223a = f3222e;

        /* renamed from: b  reason: collision with root package name */
        public long f3224b = f;

        /* renamed from: c  reason: collision with root package name */
        public Long f3225c;

        /* renamed from: d  reason: collision with root package name */
        public c f3226d = new e(Long.MIN_VALUE);

        public b(a aVar) {
            this.f3223a = aVar.f3218b.h;
            this.f3224b = aVar.f3219c.h;
            this.f3225c = Long.valueOf(aVar.f3220d.h);
            this.f3226d = aVar.f3221e;
        }
    }

    public interface c extends Parcelable {
        boolean i(long j);
    }

    public a(s sVar, s sVar2, s sVar3, c cVar, C0073a aVar) {
        this.f3218b = sVar;
        this.f3219c = sVar2;
        this.f3220d = sVar3;
        this.f3221e = cVar;
        if (sVar.f3279b.compareTo(sVar3.f3279b) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (sVar3.f3279b.compareTo(sVar2.f3279b) <= 0) {
            this.g = sVar.w(sVar2) + 1;
            this.f = (sVar2.f3282e - sVar.f3282e) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f3218b.equals(aVar.f3218b) && this.f3219c.equals(aVar.f3219c) && this.f3220d.equals(aVar.f3220d) && this.f3221e.equals(aVar.f3221e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3218b, this.f3219c, this.f3220d, this.f3221e});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3218b, 0);
        parcel.writeParcelable(this.f3219c, 0);
        parcel.writeParcelable(this.f3220d, 0);
        parcel.writeParcelable(this.f3221e, 0);
    }
}
