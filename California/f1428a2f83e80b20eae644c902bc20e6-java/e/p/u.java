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
import java.util.Objects;
import java.util.Set;

public final class u {

    /* renamed from: e  reason: collision with root package name */
    public static final Class[] f1717e = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    public final Map<String, Object> a;
    public final Map<String, a.b> b;
    public final Map<String, Object<?>> c;

    /* renamed from: d  reason: collision with root package name */
    public final a.b f1718d;

    public class a implements a.b {
        public a() {
        }

        @Override // e.u.a.b
        public Bundle a() {
            for (Map.Entry entry : new HashMap(u.this.b).entrySet()) {
                Bundle a2 = ((a.b) entry.getValue()).a();
                u uVar = u.this;
                String str = (String) entry.getKey();
                Objects.requireNonNull(uVar);
                if (a2 != null) {
                    for (Class cls : u.f1717e) {
                        if (!cls.isInstance(a2)) {
                        }
                    }
                    StringBuilder h2 = f.a.a.a.a.h("Can't put value with type ");
                    h2.append(a2.getClass());
                    h2.append(" into saved state");
                    throw new IllegalArgumentException(h2.toString());
                }
                q qVar = (q) uVar.c.get(str);
                if (qVar != null) {
                    qVar.l(a2);
                } else {
                    uVar.a.put(str, a2);
                }
            }
            Set<String> keySet = u.this.a.keySet();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
            for (String str2 : keySet) {
                arrayList.add(str2);
                arrayList2.add(u.this.a.get(str2));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("keys", arrayList);
            bundle.putParcelableArrayList("values", arrayList2);
            return bundle;
        }
    }

    public u() {
        this.b = new HashMap();
        this.c = new HashMap();
        this.f1718d = new a();
        this.a = new HashMap();
    }

    public u(Map<String, Object> map) {
        this.b = new HashMap();
        this.c = new HashMap();
        this.f1718d = new a();
        this.a = new HashMap(map);
    }
}
