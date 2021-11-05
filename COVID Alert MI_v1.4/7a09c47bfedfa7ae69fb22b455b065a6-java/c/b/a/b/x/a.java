package c.b.a.b.x;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0082a();

    /* renamed from: b  reason: collision with root package name */
    public final s f4539b;

    /* renamed from: c  reason: collision with root package name */
    public final s f4540c;

    /* renamed from: d  reason: collision with root package name */
    public final s f4541d;

    /* renamed from: e  reason: collision with root package name */
    public final c f4542e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4543f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4544g;

    /* renamed from: c.b.a.b.x.a$a  reason: collision with other inner class name */
    public static class C0082a implements Parcelable.Creator<a> {
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
        public static final long f4545e = a0.a(s.t(1900, 0).h);

        /* renamed from: f  reason: collision with root package name */
        public static final long f4546f = a0.a(s.t(2100, 11).h);

        /* renamed from: a  reason: collision with root package name */
        public long f4547a = f4545e;

        /* renamed from: b  reason: collision with root package name */
        public long f4548b = f4546f;

        /* renamed from: c  reason: collision with root package name */
        public Long f4549c;

        /* renamed from: d  reason: collision with root package name */
        public c f4550d = new e(Long.MIN_VALUE);

        public b(a aVar) {
            this.f4547a = aVar.f4539b.h;
            this.f4548b = aVar.f4540c.h;
            this.f4549c = Long.valueOf(aVar.f4541d.h);
            this.f4550d = aVar.f4542e;
        }
    }

    public interface c extends Parcelable {
        boolean k(long j);
    }

    public a(s sVar, s sVar2, s sVar3, c cVar, C0082a aVar) {
        this.f4539b = sVar;
        this.f4540c = sVar2;
        this.f4541d = sVar3;
        this.f4542e = cVar;
        if (sVar.f4610b.compareTo(sVar3.f4610b) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (sVar3.f4610b.compareTo(sVar2.f4610b) <= 0) {
            this.f4544g = sVar.D(sVar2) + 1;
            this.f4543f = (sVar2.f4613e - sVar.f4613e) + 1;
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
        return this.f4539b.equals(aVar.f4539b) && this.f4540c.equals(aVar.f4540c) && this.f4541d.equals(aVar.f4541d) && this.f4542e.equals(aVar.f4542e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4539b, this.f4540c, this.f4541d, this.f4542e});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4539b, 0);
        parcel.writeParcelable(this.f4540c, 0);
        parcel.writeParcelable(this.f4541d, 0);
        parcel.writeParcelable(this.f4542e, 0);
    }
}
