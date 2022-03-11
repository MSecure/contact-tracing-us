package e.r;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import e.w.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: e */
    public static final Class[] f1907e = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    public final Map<String, Object> a;
    public final Map<String, a.b> b;
    public final Map<String, b<?>> c;

    /* renamed from: d */
    public final a.b f1908d;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public a() {
            y.this = r1;
        }

        @Override // e.w.a.b
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

    /* loaded from: classes.dex */
    public static class b<T> extends s<T> {

        /* renamed from: l */
        public String f1909l;
        public y m;

        public b(y yVar, String str, T t) {
            super(t);
            this.f1909l = str;
            this.m = yVar;
        }

        @Override // e.r.s, androidx.lifecycle.LiveData
        public void l(T t) {
            y yVar = this.m;
            if (yVar != null) {
                yVar.a.put(this.f1909l, t);
            }
            super.l(t);
        }
    }

    public y() {
        this.b = new HashMap();
        this.c = new HashMap();
        this.f1908d = new a();
        this.a = new HashMap();
    }

    public y(Map<String, Object> map) {
        this.b = new HashMap();
        this.c = new HashMap();
        this.f1908d = new a();
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
            for (Class cls : f1907e) {
                if (!cls.isInstance(t)) {
                }
            }
            StringBuilder h2 = f.a.a.a.a.h("Can't put value with type ");
            h2.append(t.getClass());
            h2.append(" into saved state");
            throw new IllegalArgumentException(h2.toString());
        }
        b<?> bVar = this.c.get(str);
        if (bVar != null) {
            bVar.l(t);
        } else {
            this.a.put(str, t);
        }
    }
}
