package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import e.p.h;
import e.p.j;
import e.p.l;
import e.p.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public abstract class ActivityResultRegistry {
    public Random a = new Random();
    public final Map<Integer, String> b = new HashMap();
    public final Map<String, Integer> c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, d> f14d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final transient Map<String, c<?>> f15e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, Object> f16f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Bundle f17g = new Bundle();

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

    public static class d {
        public final h a;
        public final ArrayList<j> b = new ArrayList<>();

        public d(h hVar) {
            this.a = hVar;
        }
    }

    public final boolean a(int i2, int i3, Intent intent) {
        e.a.e.b<O> bVar;
        String str = this.b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        c<?> cVar = this.f15e.get(str);
        if (cVar == null || (bVar = cVar.a) == null) {
            this.f16f.remove(str);
            this.f17g.putParcelable(str, new e.a.e.a(i3, intent));
            return true;
        }
        bVar.a(cVar.b.c(i3, intent));
        return true;
    }

    public abstract <I, O> void b(int i2, e.a.e.f.a<I, O> aVar, I i3, e.i.a.c cVar);

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: e.a.e.b<O> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> e.a.e.c<I> c(String str, e.a.e.f.a<I, O> aVar, e.a.e.b<O> bVar) {
        int e2 = e(str);
        this.f15e.put(str, new c<>(bVar, aVar));
        if (this.f16f.containsKey(str)) {
            Object obj = this.f16f.get(str);
            this.f16f.remove(str);
            bVar.a(obj);
        }
        e.a.e.a aVar2 = (e.a.e.a) this.f17g.getParcelable(str);
        if (aVar2 != null) {
            this.f17g.remove(str);
            bVar.a(aVar.c(aVar2.b, aVar2.c));
        }
        return new b(e2, aVar, str);
    }

    public final <I, O> e.a.e.c<I> d(final String str, l lVar, final e.a.e.f.a<I, O> aVar, final e.a.e.b<O> bVar) {
        h a2 = lVar.a();
        m mVar = (m) a2;
        if (!(mVar.b.compareTo(h.b.STARTED) >= 0)) {
            int e2 = e(str);
            d dVar = this.f14d.get(str);
            if (dVar == null) {
                dVar = new d(a2);
            }
            AnonymousClass1 r0 = new j() {
                /* class androidx.activity.result.ActivityResultRegistry.AnonymousClass1 */

                @Override // e.p.j
                public void d(l lVar, h.a aVar) {
                    if (h.a.ON_START.equals(aVar)) {
                        ActivityResultRegistry.this.f15e.put(str, new c<>(bVar, aVar));
                        if (ActivityResultRegistry.this.f16f.containsKey(str)) {
                            Object obj = ActivityResultRegistry.this.f16f.get(str);
                            ActivityResultRegistry.this.f16f.remove(str);
                            bVar.a(obj);
                        }
                        e.a.e.a aVar2 = (e.a.e.a) ActivityResultRegistry.this.f17g.getParcelable(str);
                        if (aVar2 != null) {
                            ActivityResultRegistry.this.f17g.remove(str);
                            bVar.a(aVar.c(aVar2.b, aVar2.c));
                        }
                    } else if (h.a.ON_STOP.equals(aVar)) {
                        ActivityResultRegistry.this.f15e.remove(str);
                    } else if (h.a.ON_DESTROY.equals(aVar)) {
                        ActivityResultRegistry.this.f(str);
                    }
                }
            };
            dVar.a.a(r0);
            dVar.b.add(r0);
            this.f14d.put(str, dVar);
            return new a(e2, aVar, str);
        }
        throw new IllegalStateException("LifecycleOwner " + lVar + " is attempting to register while current state is " + mVar.b + ". LifecycleOwners must call register before they are STARTED.");
    }

    public final int e(String str) {
        Integer num = this.c.get(str);
        if (num != null) {
            return num.intValue();
        }
        int nextInt = this.a.nextInt(2147418112);
        while (true) {
            int i2 = nextInt + 65536;
            if (this.b.containsKey(Integer.valueOf(i2))) {
                nextInt = this.a.nextInt(2147418112);
            } else {
                this.b.put(Integer.valueOf(i2), str);
                this.c.put(str, Integer.valueOf(i2));
                return i2;
            }
        }
    }

    public final void f(String str) {
        Integer remove = this.c.remove(str);
        if (remove != null) {
            this.b.remove(remove);
        }
        this.f15e.remove(str);
        if (this.f16f.containsKey(str)) {
            StringBuilder k2 = f.a.a.a.a.k("Dropping pending result for request ", str, ": ");
            k2.append(this.f16f.get(str));
            k2.toString();
            this.f16f.remove(str);
        }
        if (this.f17g.containsKey(str)) {
            StringBuilder k3 = f.a.a.a.a.k("Dropping pending result for request ", str, ": ");
            k3.append(this.f17g.getParcelable(str));
            k3.toString();
            this.f17g.remove(str);
        }
        d dVar = this.f14d.get(str);
        if (dVar != null) {
            Iterator<j> it = dVar.b.iterator();
            while (it.hasNext()) {
                dVar.a.b(it.next());
            }
            dVar.b.clear();
            this.f14d.remove(str);
        }
    }
}
