package b.o;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import b.t.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class t {

    /* renamed from: e  reason: collision with root package name */
    public static final Class[] f2237e = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f2238a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, b.AbstractC0050b> f2239b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Object<?>> f2240c;

    /* renamed from: d  reason: collision with root package name */
    public final b.AbstractC0050b f2241d;

    public class a implements b.AbstractC0050b {
        public a() {
        }

        @Override // b.t.b.AbstractC0050b
        public Bundle a() {
            for (Map.Entry entry : new HashMap(t.this.f2239b).entrySet()) {
                Bundle a2 = ((b.AbstractC0050b) entry.getValue()).a();
                t tVar = t.this;
                String str = (String) entry.getKey();
                if (tVar != null) {
                    if (a2 != null) {
                        for (Class cls : t.f2237e) {
                            if (!cls.isInstance(a2)) {
                            }
                        }
                        StringBuilder h = c.a.a.a.a.h("Can't put value with type ");
                        h.append(a2.getClass());
                        h.append(" into saved state");
                        throw new IllegalArgumentException(h.toString());
                    }
                    p pVar = (p) tVar.f2240c.get(str);
                    if (pVar != null) {
                        pVar.setValue(a2);
                    } else {
                        tVar.f2238a.put(str, a2);
                    }
                } else {
                    throw null;
                }
            }
            Set<String> keySet = t.this.f2238a.keySet();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
            for (String str2 : keySet) {
                arrayList.add(str2);
                arrayList2.add(t.this.f2238a.get(str2));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("keys", arrayList);
            bundle.putParcelableArrayList("values", arrayList2);
            return bundle;
        }
    }

    public t() {
        this.f2239b = new HashMap();
        this.f2240c = new HashMap();
        this.f2241d = new a();
        this.f2238a = new HashMap();
    }

    public t(Map<String, Object> map) {
        this.f2239b = new HashMap();
        this.f2240c = new HashMap();
        this.f2241d = new a();
        this.f2238a = new HashMap(map);
    }

    public static t a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new t();
        }
        HashMap hashMap = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new t(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        for (int i = 0; i < parcelableArrayList.size(); i++) {
            hashMap.put((String) parcelableArrayList.get(i), parcelableArrayList2.get(i));
        }
        return new t(hashMap);
    }
}
