package f.b.a.b.i.p;

import android.content.Context;
import f.b.a.b.i.u.a;
import java.util.Objects;

public final class c extends h {
    public final Context a;
    public final a b;
    public final a c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2535d;

    public c(Context context, a aVar, a aVar2, String str) {
        Objects.requireNonNull(context, "Null applicationContext");
        this.a = context;
        Objects.requireNonNull(aVar, "Null wallClock");
        this.b = aVar;
        Objects.requireNonNull(aVar2, "Null monotonicClock");
        this.c = aVar2;
        Objects.requireNonNull(str, "Null backendName");
        this.f2535d = str;
    }

    @Override // f.b.a.b.i.p.h
    public Context a() {
        return this.a;
    }

    @Override // f.b.a.b.i.p.h
    public String b() {
        return this.f2535d;
    }

    @Override // f.b.a.b.i.p.h
    public a c() {
        return this.c;
    }

    @Override // f.b.a.b.i.p.h
    public a d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.a.equals(hVar.a()) && this.b.equals(hVar.d()) && this.c.equals(hVar.c()) && this.f2535d.equals(hVar.b());
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.f2535d.hashCode();
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("CreationContext{applicationContext=");
        i2.append(this.a);
        i2.append(", wallClock=");
        i2.append(this.b);
        i2.append(", monotonicClock=");
        i2.append(this.c);
        i2.append(", backendName=");
        return f.a.a.a.a.f(i2, this.f2535d, "}");
    }
}
