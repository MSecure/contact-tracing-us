package f.b.a.d.l;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0092a();
    public final u b;
    public final u c;

    /* renamed from: d  reason: collision with root package name */
    public final c f2610d;

    /* renamed from: e  reason: collision with root package name */
    public u f2611e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2612f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2613g;

    /* renamed from: f.b.a.d.l.a$a  reason: collision with other inner class name */
    public static class C0092a implements Parcelable.Creator<a> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a((u) parcel.readParcelable(u.class.getClassLoader()), (u) parcel.readParcelable(u.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (u) parcel.readParcelable(u.class.getClassLoader()), null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    public interface c extends Parcelable {
        boolean f(long j2);
    }

    public a(u uVar, u uVar2, c cVar, u uVar3, C0092a aVar) {
        this.b = uVar;
        this.c = uVar2;
        this.f2611e = uVar3;
        this.f2610d = cVar;
        if (uVar3 != null && uVar.b.compareTo(uVar3.b) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (uVar3 == null || uVar3.b.compareTo(uVar2.b) <= 0) {
            this.f2613g = uVar.w(uVar2) + 1;
            this.f2612f = (uVar2.f2635d - uVar.f2635d) + 1;
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
        if (!this.b.equals(aVar.b) || !this.c.equals(aVar.c) || !Objects.equals(this.f2611e, aVar.f2611e) || !this.f2610d.equals(aVar.f2610d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f2611e, this.f2610d});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.c, 0);
        parcel.writeParcelable(this.f2611e, 0);
        parcel.writeParcelable(this.f2610d, 0);
    }

    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        public static final long f2614e = d0.a(u.o(1900, 0).f2638g);

        /* renamed from: f  reason: collision with root package name */
        public static final long f2615f = d0.a(u.o(2100, 11).f2638g);
        public long a = f2614e;
        public long b = f2615f;
        public Long c;

        /* renamed from: d  reason: collision with root package name */
        public c f2616d = new g(Long.MIN_VALUE);

        public b() {
        }

        public a a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f2616d);
            u q = u.q(this.a);
            u q2 = u.q(this.b);
            c cVar = (c) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l2 = this.c;
            return new a(q, q2, cVar, l2 == null ? null : u.q(l2.longValue()), null);
        }

        public b(a aVar) {
            this.a = aVar.b.f2638g;
            this.b = aVar.c.f2638g;
            this.c = Long.valueOf(aVar.f2611e.f2638g);
            this.f2616d = aVar.f2610d;
        }
    }
}
