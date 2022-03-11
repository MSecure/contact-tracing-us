package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import e.p.g;
import e.p.h;
import e.p.j;
import e.p.k;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ActivityResultRegistry {
    public final AtomicInteger a = new AtomicInteger(65536);
    public final Map<Integer, String> b = new HashMap();
    public final Map<String, Integer> c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final transient Map<String, c<?>> f14d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Bundle f15e = new Bundle();

    public class a extends e.a.e.c<I> {
        public final /* synthetic */ int a;
        public final /* synthetic */ e.a.e.f.a b;
        public final /* synthetic */ String c;

        public a(int i2, e.a.e.f.a aVar, String str) {
            this.a = i2;
            this.b = aVar;
            this.c = str;
        }

        @Override // e.a.e.c
        public void a(I i2, e.i.a.c cVar) {
            ActivityResultRegistry.this.b(this.a, this.b, i2, cVar);
        }

        @Override // e.a.e.c
        public void b() {
            ActivityResultRegistry.this.f(this.c);
        }
    }

    public class b extends e.a.e.c<I> {
        public final /* synthetic */ int a;
        public final /* synthetic */ e.a.e.f.a b;
        public final /* synthetic */ String c;

        public b(int i2, e.a.e.f.a aVar, String str) {
            this.a = i2;
            this.b = aVar;
            this.c = str;
        }

        @Override // e.a.e.c
        public void a(I i2, e.i.a.c cVar) {
            ActivityResultRegistry.this.b(this.a, this.b, i2, cVar);
        }

        @Override // e.a.e.c
        public void b() {
            ActivityResultRegistry.this.f(this.c);
        }
    }

    public static class c<O> {
        public final e.a.e.b<O> a;
        public final e.a.e.f.a<?, O> b;

        public c(e.a.e.b<O> bVar, e.a.e.f.a<?, O> aVar) {
            this.a = bVar;
            this.b = aVar;
        }
    }

    public final boolean a(int i2, int i3, Intent intent) {
        e.a.e.b<O> bVar;
        String str = this.b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        c<?> cVar = this.f14d.get(str);
        if (cVar == null || (bVar = cVar.a) == null) {
            this.f15e.putParcelable(str, new e.a.e.a(i3, intent));
            return true;
        }
        bVar.a(cVar.b.c(i3, intent));
        return true;
    }

    public abstract <I, O> void b(int i2, e.a.e.f.a<I, O> aVar, I i3, e.i.a.c cVar);

    public final <I, O> e.a.e.c<I> c(String str, e.a.e.f.a<I, O> aVar, e.a.e.b<O> bVar) {
        int e2 = e(str);
        this.f14d.put(str, new c<>(bVar, aVar));
        e.a.e.a aVar2 = (e.a.e.a) this.f15e.getParcelable(str);
        if (aVar2 != null) {
            this.f15e.remove(str);
            bVar.a(aVar.c(aVar2.b, aVar2.c));
        }
        return new b(e2, aVar, str);
    }

    public final <I, O> e.a.e.c<I> d(final String str, j jVar, final e.a.e.f.a<I, O> aVar, final e.a.e.b<O> bVar) {
        int e2 = e(str);
        this.f14d.put(str, new c<>(bVar, aVar));
        g a2 = jVar.a();
        final e.a.e.a aVar2 = (e.a.e.a) this.f15e.getParcelable(str);
        if (aVar2 != null) {
            this.f15e.remove(str);
            if (((k) a2).b.compareTo(g.b.STARTED) >= 0) {
                bVar.a(aVar.c(aVar2.b, aVar2.c));
            } else {
                a2.a(new h(this) {
                    /* class androidx.activity.result.ActivityResultRegistry.AnonymousClass1 */

                    @Override // e.p.h
                    public void d(j jVar, g.a aVar) {
                        if (g.a.ON_START.equals(aVar)) {
                            e.a.e.b bVar = bVar;
                            e.a.e.f.a aVar2 = aVar;
                            e.a.e.a aVar3 = aVar2;
                            bVar.a(aVar2.c(aVar3.b, aVar3.c));
                        }
                    }
                });
            }
        }
        a2.a(new h() {
            /* class androidx.activity.result.ActivityResultRegistry.AnonymousClass2 */

            @Override // e.p.h
            public void d(j jVar, g.a aVar) {
                if (g.a.ON_DESTROY.equals(aVar)) {
                    ActivityResultRegistry.this.f(str);
                }
            }
        });
        return new a(e2, aVar, str);
    }

    public final int e(String str) {
        Integer num = this.c.get(str);
        if (num != null) {
            return num.intValue();
        }
        int andIncrement = this.a.getAndIncrement();
        this.b.put(Integer.valueOf(andIncrement), str);
        this.c.put(str, Integer.valueOf(andIncrement));
        return andIncrement;
    }

    public final void f(String str) {
        Integer remove = this.c.remove(str);
        if (remove != null) {
            this.b.remove(remove);
        }
        this.f14d.remove(str);
        if (this.f15e.containsKey(str)) {
            StringBuilder j2 = f.a.a.a.a.j("Dropping pending result for request ", str, ": ");
            j2.append(this.f15e.getParcelable(str));
            Log.w("ActivityResultRegistry", j2.toString());
            this.f15e.remove(str);
        }
    }
}
