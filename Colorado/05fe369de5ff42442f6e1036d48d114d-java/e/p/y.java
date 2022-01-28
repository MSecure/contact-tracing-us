package e.p;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import e.u.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class y {

    /* renamed from: e  reason: collision with root package name */
    public static final Class[] f1547e = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    public final Map<String, Object> a;
    public final Map<String, a.b> b;
    public final Map<String, b<?>> c;

    /* renamed from: d  reason: collision with root package name */
    public final a.b f1548d;

    public class a implements a.b {
        public a() {
        }

        @Override // e.u.a.b
        public Bundle a() {
            for (Map.Entry entry : new HashMap(y.this.b).entrySet()) {
                y.this.b((String) entry.getKey(), ((a.b) entry.getValue()).a());
            }
            Set<String> keySet = y.this.a.keySet();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
            for (String str : keySet) {
                arrayList.add(str);
                arrayList2.add(y.this.a.get(str));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("keys", arrayList);
            bundle.putParcelableArrayList("values", arrayList2);
            return bundle;
        }
    }

    public static class b<T> extends s<T> {

        /* renamed from: l  reason: collision with root package name */
        public String f1549l;
        public y m;

        public b(y yVar, String str, T t) {
            super(t);
            this.f1549l = str;
            this.m = yVar;
        }

        @Override // androidx.lifecycle.LiveData, e.p.s
        public void l(T t) {
            y yVar = this.m;
            if (yVar != null) {
                yVar.a.put(this.f1549l, t);
            }
            super.l(t);
        }
    }

    public y() {
        this.b = new HashMap();
        this.c = new HashMap();
        this.f1548d = new a();
        this.a = new HashMap();
    }

    public y(Map<String, Object> map) {
        this.b = new HashMap();
        this.c = new HashMap();
        this.f1548d = new a();
        this.a = new HashMap(map);
    }

    public <T> s<T> a(String str, T t) {
        b<?> bVar = this.c.get(str);
        if (bVar == null) {
            bVar = this.a.containsKey(str) ? new b<>(this, str, this.a.get(str)) : new b<>(this, str, t);
            this.c.put(str, bVar);
        }
        return bVar;
    }

    public <T> void b(String str, T t) {
        if (t != null) {
            for (Class cls : f1547e) {
                if (!cls.isInstance(t)) {
                }
            }
            StringBuilder i2 = f.a.a.a.a.i("Can't put value with type ");
            i2.append(t.getClass());
            i2.append(" into saved state");
            throw new IllegalArgumentException(i2.toString());
        }
        b<?> bVar = this.c.get(str);
        if (bVar != null) {
            bVar.l(t);
        } else {
            this.a.put(str, t);
        }
    }
}
