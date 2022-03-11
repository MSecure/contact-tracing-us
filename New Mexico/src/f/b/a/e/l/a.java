package f.b.a.e.l;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0095a();
    public final u b;
    public final u c;

    /* renamed from: d */
    public final c f2921d;

    /* renamed from: e */
    public u f2922e;

    /* renamed from: f */
    public final int f2923f;

    /* renamed from: g */
    public final int f2924g;

    /* renamed from: f.b.a.e.l.a$a */
    /* loaded from: classes.dex */
    public static class C0095a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a((u) parcel.readParcelable(u.class.getClassLoader()), (u) parcel.readParcelable(u.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (u) parcel.readParcelable(u.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    /* loaded from: classes.dex */
    public interface c extends Parcelable {
        boolean f(long j2);
    }

    public a(u uVar, u uVar2, c cVar, u uVar3, C0095a aVar) {
        this.b = uVar;
        this.c = uVar2;
        this.f2922e = uVar3;
        this.f2921d = cVar;
        if (uVar3 != null && uVar.b.compareTo(uVar3.b) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (uVar3 == null || uVar3.b.compareTo(uVar2.b) <= 0) {
            this.f2924g = uVar.w(uVar2) + 1;
            this.f2923f = (uVar2.f2946d - uVar.f2946d) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.b.equals(aVar.b) || !this.c.equals(aVar.c) || !Objects.equals(this.f2922e, aVar.f2922e) || !this.f2921d.equals(aVar.f2921d)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f2922e, this.f2921d});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.c, 0);
        parcel.writeParcelable(this.f2922e, 0);
        parcel.writeParcelable(this.f2921d, 0);
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: e */
        public static final long f2925e = d0.a(u.o(1900, 0).f2949g);

        /* renamed from: f */
        public static final long f2926f = d0.a(u.o(2100, 11).f2949g);
        public long a;
        public long b;
        public Long c;

        /* renamed from: d */
        public c f2927d;

        public b() {
            this.a = f2925e;
            this.b = f2926f;
            this.f2927d = new g(Long.MIN_VALUE);
        }

        public a a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f2927d);
            u q = u.q(this.a);
            u q2 = u.q(this.b);
            c cVar = (c) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l2 = this.c;
            return new a(q, q2, cVar, l2 == null ? null : u.q(l2.longValue()), null);
        }

        public b(a aVar) {
            this.a = f2925e;
            this.b = f2926f;
            this.f2927d = new g(Long.MIN_VALUE);
            this.a = aVar.b.f2949g;
            this.b = aVar.c.f2949g;
            this.c = Long.valueOf(aVar.f2922e.f2949g);
            this.f2927d = aVar.f2921d;
        }
    }
}
