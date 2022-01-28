package b.n;

import android.os.Bundle;
import android.os.Parcelable;
import b.s.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f1406a;

    /* renamed from: b  reason: collision with root package name */
    public final a.b f1407b;

    public class a implements a.b {
        public a() {
        }

        @Override // b.s.a.b
        public Bundle a() {
            Set<String> keySet = t.this.f1406a.keySet();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
            for (String str : keySet) {
                arrayList.add(str);
                arrayList2.add(t.this.f1406a.get(str));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("keys", arrayList);
            bundle.putParcelableArrayList("values", arrayList2);
            return bundle;
        }
    }

    static {
        Class cls = Double.TYPE;
        Class cls2 = Integer.TYPE;
        Class cls3 = Long.TYPE;
        Class cls4 = Byte.TYPE;
        Class cls5 = Character.TYPE;
        Class cls6 = Float.TYPE;
        Class cls7 = Short.TYPE;
    }

    public t() {
        new HashMap();
        this.f1407b = new a();
        this.f1406a = new HashMap();
    }

    public t(Map<String, Object> map) {
        new HashMap();
        this.f1407b = new a();
        this.f1406a = new HashMap(map);
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
