package e.a.e;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class d {
    public final AtomicInteger a = new AtomicInteger(65536);
    public final Map<Integer, String> b = new HashMap();
    public final Map<String, Integer> c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final transient Map<String, b<?>> f640d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Bundle f641e = new Bundle();

    public class a extends c<I> {
        public final /* synthetic */ String a;

        public a(int i2, e.a.e.f.a aVar, String str) {
            this.a = str;
        }

        @Override // e.a.e.c
        public void a() {
            d.this.c(this.a);
        }
    }

    public static class b<O> {
        public final b<O> a;
        public final e.a.e.f.a<?, O> b;

        public b(b<O> bVar, e.a.e.f.a<?, O> aVar) {
            this.a = bVar;
            this.b = aVar;
        }
    }

    public final boolean a(int i2, int i3, Intent intent) {
        b<O> bVar;
        String str = this.b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        b<?> bVar2 = this.f640d.get(str);
        if (bVar2 == null || (bVar = bVar2.a) == null) {
            this.f641e.putParcelable(str, new a(i3, intent));
            return true;
        }
        bVar.a(bVar2.b.a(i3, intent));
        return true;
    }

    public final <I, O> c<I> b(String str, e.a.e.f.a<I, O> aVar, b<O> bVar) {
        int i2;
        Integer num = this.c.get(str);
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = this.a.getAndIncrement();
            this.b.put(Integer.valueOf(i2), str);
            this.c.put(str, Integer.valueOf(i2));
        }
        this.f640d.put(str, new b<>(bVar, aVar));
        a aVar2 = (a) this.f641e.getParcelable(str);
        if (aVar2 != null) {
            this.f641e.remove(str);
            bVar.a(aVar.a(aVar2.b, aVar2.c));
        }
        return new a(i2, aVar, str);
    }

    public final void c(String str) {
        Integer remove = this.c.remove(str);
        if (remove != null) {
            this.b.remove(remove);
        }
        this.f640d.remove(str);
        if (this.f641e.containsKey(str)) {
            StringBuilder j2 = f.a.a.a.a.j("Dropping pending result for request ", str, ": ");
            j2.append(this.f641e.getParcelable(str));
            Log.w("ActivityResultRegistry", j2.toString());
            this.f641e.remove(str);
        }
    }
}
