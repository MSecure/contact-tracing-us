package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import b.o.f;
import b.o.g;
import b.o.i;
import b.o.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public abstract class ActivityResultRegistry {

    /* renamed from: a  reason: collision with root package name */
    public Random f26a = new Random();

    /* renamed from: b  reason: collision with root package name */
    public final Map<Integer, String> f27b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Integer> f28c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, d> f29d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f30e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public final transient Map<String, c<?>> f31f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, Object> f32g = new HashMap();
    public final Bundle h = new Bundle();

    public class a extends b.a.e.c<I> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f37a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f38b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.e.f.a f39c;

        public a(String str, int i, b.a.e.f.a aVar) {
            this.f37a = str;
            this.f38b = i;
            this.f39c = aVar;
        }

        @Override // b.a.e.c
        public void a(I i, b.i.d.b bVar) {
            ActivityResultRegistry.this.f30e.add(this.f37a);
            ActivityResultRegistry.this.b(this.f38b, this.f39c, i, bVar);
        }

        @Override // b.a.e.c
        public void b() {
            ActivityResultRegistry.this.f(this.f37a);
        }
    }

    public class b extends b.a.e.c<I> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f42b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.e.f.a f43c;

        public b(String str, int i, b.a.e.f.a aVar) {
            this.f41a = str;
            this.f42b = i;
            this.f43c = aVar;
        }

        @Override // b.a.e.c
        public void a(I i, b.i.d.b bVar) {
            ActivityResultRegistry.this.f30e.add(this.f41a);
            ActivityResultRegistry.this.b(this.f42b, this.f43c, i, bVar);
        }

        @Override // b.a.e.c
        public void b() {
            ActivityResultRegistry.this.f(this.f41a);
        }
    }

    public static class c<O> {

        /* renamed from: a  reason: collision with root package name */
        public final b.a.e.b<O> f45a;

        /* renamed from: b  reason: collision with root package name */
        public final b.a.e.f.a<?, O> f46b;

        public c(b.a.e.b<O> bVar, b.a.e.f.a<?, O> aVar) {
            this.f45a = bVar;
            this.f46b = aVar;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final f f47a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<g> f48b = new ArrayList<>();

        public d(f fVar) {
            this.f47a = fVar;
        }
    }

    public final boolean a(int i, int i2, Intent intent) {
        b.a.e.b<O> bVar;
        String str = this.f27b.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.f30e.remove(str);
        c<?> cVar = this.f31f.get(str);
        if (cVar == null || (bVar = cVar.f45a) == null) {
            this.f32g.remove(str);
            this.h.putParcelable(str, new b.a.e.a(i2, intent));
            return true;
        }
        bVar.a(cVar.f46b.c(i2, intent));
        return true;
    }

    public abstract <I, O> void b(int i, b.a.e.f.a<I, O> aVar, @SuppressLint({"UnknownNullness"}) I i2, b.i.d.b bVar);

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: b.a.e.b<O> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> b.a.e.c<I> c(String str, b.a.e.f.a<I, O> aVar, b.a.e.b<O> bVar) {
        int e2 = e(str);
        this.f31f.put(str, new c<>(bVar, aVar));
        if (this.f32g.containsKey(str)) {
            Object obj = this.f32g.get(str);
            this.f32g.remove(str);
            bVar.a(obj);
        }
        b.a.e.a aVar2 = (b.a.e.a) this.h.getParcelable(str);
        if (aVar2 != null) {
            this.h.remove(str);
            bVar.a(aVar.c(aVar2.f500b, aVar2.f501c));
        }
        return new b(str, e2, aVar);
    }

    public final <I, O> b.a.e.c<I> d(final String str, i iVar, final b.a.e.f.a<I, O> aVar, final b.a.e.b<O> bVar) {
        f lifecycle = iVar.getLifecycle();
        j jVar = (j) lifecycle;
        if (!(jVar.f2221b.compareTo(f.b.STARTED) >= 0)) {
            int e2 = e(str);
            d dVar = this.f29d.get(str);
            if (dVar == null) {
                dVar = new d(lifecycle);
            }
            AnonymousClass1 r0 = new g() {
                /* class androidx.activity.result.ActivityResultRegistry.AnonymousClass1 */

                @Override // b.o.g
                public void d(i iVar, f.a aVar) {
                    if (f.a.ON_START.equals(aVar)) {
                        ActivityResultRegistry.this.f31f.put(str, new c<>(bVar, aVar));
                        if (ActivityResultRegistry.this.f32g.containsKey(str)) {
                            Object obj = ActivityResultRegistry.this.f32g.get(str);
                            ActivityResultRegistry.this.f32g.remove(str);
                            bVar.a(obj);
                        }
                        b.a.e.a aVar2 = (b.a.e.a) ActivityResultRegistry.this.h.getParcelable(str);
                        if (aVar2 != null) {
                            ActivityResultRegistry.this.h.remove(str);
                            bVar.a(aVar.c(aVar2.f500b, aVar2.f501c));
                        }
                    } else if (f.a.ON_STOP.equals(aVar)) {
                        ActivityResultRegistry.this.f31f.remove(str);
                    } else if (f.a.ON_DESTROY.equals(aVar)) {
                        ActivityResultRegistry.this.f(str);
                    }
                }
            };
            dVar.f47a.a(r0);
            dVar.f48b.add(r0);
            this.f29d.put(str, dVar);
            return new a(str, e2, aVar);
        }
        throw new IllegalStateException("LifecycleOwner " + iVar + " is attempting to register while current state is " + jVar.f2221b + ". LifecycleOwners must call register before they are STARTED.");
    }

    public final int e(String str) {
        Integer num = this.f28c.get(str);
        if (num != null) {
            return num.intValue();
        }
        int nextInt = this.f26a.nextInt(2147418112);
        while (true) {
            int i = nextInt + 65536;
            if (this.f27b.containsKey(Integer.valueOf(i))) {
                nextInt = this.f26a.nextInt(2147418112);
            } else {
                this.f27b.put(Integer.valueOf(i), str);
                this.f28c.put(str, Integer.valueOf(i));
                return i;
            }
        }
    }

    public final void f(String str) {
        Integer remove;
        if (!this.f30e.contains(str) && (remove = this.f28c.remove(str)) != null) {
            this.f27b.remove(remove);
        }
        this.f31f.remove(str);
        if (this.f32g.containsKey(str)) {
            String str2 = "Dropping pending result for request " + str + ": " + this.f32g.get(str);
            this.f32g.remove(str);
        }
        if (this.h.containsKey(str)) {
            String str3 = "Dropping pending result for request " + str + ": " + this.h.getParcelable(str);
            this.h.remove(str);
        }
        d dVar = this.f29d.get(str);
        if (dVar != null) {
            Iterator<g> it = dVar.f48b.iterator();
            while (it.hasNext()) {
                dVar.f47a.b(it.next());
            }
            dVar.f48b.clear();
            this.f29d.remove(str);
        }
    }
}
