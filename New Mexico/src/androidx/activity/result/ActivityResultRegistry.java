package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import e.r.h;
import e.r.j;
import e.r.l;
import e.r.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {
    public Random a = new Random();
    public final Map<Integer, String> b = new HashMap();
    public final Map<String, Integer> c = new HashMap();

    /* renamed from: d */
    public final Map<String, d> f14d = new HashMap();

    /* renamed from: e */
    public ArrayList<String> f15e = new ArrayList<>();

    /* renamed from: f */
    public final transient Map<String, c<?>> f16f = new HashMap();

    /* renamed from: g */
    public final Map<String, Object> f17g = new HashMap();

    /* renamed from: h */
    public final Bundle f18h = new Bundle();

    /* loaded from: classes.dex */
    public class a extends e.a.e.c<I> {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ e.a.e.f.a c;

        public a(String str, int i2, e.a.e.f.a aVar) {
            ActivityResultRegistry.this = r1;
            this.a = str;
            this.b = i2;
            this.c = aVar;
        }

        @Override // e.a.e.c
        public void a(I i2, e.j.a.d dVar) {
            ActivityResultRegistry.this.f15e.add(this.a);
            Integer num = ActivityResultRegistry.this.c.get(this.a);
            ActivityResultRegistry.this.b(num != null ? num.intValue() : this.b, this.c, i2, dVar);
        }

        @Override // e.a.e.c
        public void b() {
            ActivityResultRegistry.this.f(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class b extends e.a.e.c<I> {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ e.a.e.f.a c;

        public b(String str, int i2, e.a.e.f.a aVar) {
            ActivityResultRegistry.this = r1;
            this.a = str;
            this.b = i2;
            this.c = aVar;
        }

        @Override // e.a.e.c
        public void a(I i2, e.j.a.d dVar) {
            ActivityResultRegistry.this.f15e.add(this.a);
            Integer num = ActivityResultRegistry.this.c.get(this.a);
            ActivityResultRegistry.this.b(num != null ? num.intValue() : this.b, this.c, i2, dVar);
        }

        @Override // e.a.e.c
        public void b() {
            ActivityResultRegistry.this.f(this.a);
        }
    }

    /* loaded from: classes.dex */
    public static class c<O> {
        public final e.a.e.b<O> a;
        public final e.a.e.f.a<?, O> b;

        public c(e.a.e.b<O> bVar, e.a.e.f.a<?, O> aVar) {
            this.a = bVar;
            this.b = aVar;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public final h a;
        public final ArrayList<j> b = new ArrayList<>();

        public d(h hVar) {
            this.a = hVar;
        }
    }

    public final boolean a(int i2, int i3, Intent intent) {
        e.a.e.b<?> bVar;
        String str = this.b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        this.f15e.remove(str);
        c<?> cVar = this.f16f.get(str);
        if (cVar == null || (bVar = cVar.a) == null) {
            this.f17g.remove(str);
            this.f18h.putParcelable(str, new e.a.e.a(i3, intent));
            return true;
        }
        bVar.a(cVar.b.c(i3, intent));
        return true;
    }

    public abstract <I, O> void b(int i2, e.a.e.f.a<I, O> aVar, I i3, e.j.a.d dVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> e.a.e.c<I> c(String str, e.a.e.f.a<I, O> aVar, e.a.e.b<O> bVar) {
        int e2 = e(str);
        this.f16f.put(str, new c<>(bVar, aVar));
        if (this.f17g.containsKey(str)) {
            Object obj = this.f17g.get(str);
            this.f17g.remove(str);
            bVar.a(obj);
        }
        e.a.e.a aVar2 = (e.a.e.a) this.f18h.getParcelable(str);
        if (aVar2 != null) {
            this.f18h.remove(str);
            bVar.a(aVar.c(aVar2.b, aVar2.c));
        }
        return new b(str, e2, aVar);
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
            AnonymousClass1 r0 = new j() { // from class: androidx.activity.result.ActivityResultRegistry.1
                @Override // e.r.j
                public void d(l lVar2, h.a aVar2) {
                    if (h.a.ON_START.equals(aVar2)) {
                        ActivityResultRegistry.this.f16f.put(str, new c<>(bVar, aVar));
                        if (ActivityResultRegistry.this.f17g.containsKey(str)) {
                            Object obj = ActivityResultRegistry.this.f17g.get(str);
                            ActivityResultRegistry.this.f17g.remove(str);
                            bVar.a(obj);
                        }
                        e.a.e.a aVar3 = (e.a.e.a) ActivityResultRegistry.this.f18h.getParcelable(str);
                        if (aVar3 != null) {
                            ActivityResultRegistry.this.f18h.remove(str);
                            bVar.a(aVar.c(aVar3.b, aVar3.c));
                        }
                    } else if (h.a.ON_STOP.equals(aVar2)) {
                        ActivityResultRegistry.this.f16f.remove(str);
                    } else if (h.a.ON_DESTROY.equals(aVar2)) {
                        ActivityResultRegistry.this.f(str);
                    }
                }
            };
            dVar.a.a(r0);
            dVar.b.add(r0);
            this.f14d.put(str, dVar);
            return new a(str, e2, aVar);
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
        Integer remove;
        if (!this.f15e.contains(str) && (remove = this.c.remove(str)) != null) {
            this.b.remove(remove);
        }
        this.f16f.remove(str);
        if (this.f17g.containsKey(str)) {
            StringBuilder j2 = f.a.a.a.a.j("Dropping pending result for request ", str, ": ");
            j2.append(this.f17g.get(str));
            j2.toString();
            this.f17g.remove(str);
        }
        if (this.f18h.containsKey(str)) {
            StringBuilder j3 = f.a.a.a.a.j("Dropping pending result for request ", str, ": ");
            j3.append(this.f18h.getParcelable(str));
            j3.toString();
            this.f18h.remove(str);
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
