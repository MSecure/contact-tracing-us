package e.r;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.navigation.common.R$styleable;
import e.e.i;
import e.r.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class j {
    public final String b;
    public k c;

    /* renamed from: d  reason: collision with root package name */
    public int f1575d;

    /* renamed from: e  reason: collision with root package name */
    public String f1576e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f1577f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<h> f1578g;

    /* renamed from: h  reason: collision with root package name */
    public i<c> f1579h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, d> f1580i;

    public static class a implements Comparable<a> {
        public final j b;
        public final Bundle c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f1581d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f1582e;

        /* renamed from: f  reason: collision with root package name */
        public final int f1583f;

        public a(j jVar, Bundle bundle, boolean z, boolean z2, int i2) {
            this.b = jVar;
            this.c = bundle;
            this.f1581d = z;
            this.f1582e = z2;
            this.f1583f = i2;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            boolean z = this.f1581d;
            if (z && !aVar.f1581d) {
                return 1;
            }
            if (!z && aVar.f1581d) {
                return -1;
            }
            Bundle bundle = this.c;
            if (bundle != null && aVar.c == null) {
                return 1;
            }
            if (bundle == null && aVar.c != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size() - aVar.c.size();
                if (size > 0) {
                    return 1;
                }
                if (size < 0) {
                    return -1;
                }
            }
            boolean z2 = this.f1582e;
            if (z2 && !aVar.f1582e) {
                return 1;
            }
            if (z2 || !aVar.f1582e) {
                return this.f1583f - aVar.f1583f;
            }
            return -1;
        }
    }

    static {
        new HashMap();
    }

    public j(q<? extends j> qVar) {
        this.b = r.b(qVar.getClass());
    }

    public static String i(Context context, int i2) {
        if (i2 <= 16777215) {
            return Integer.toString(i2);
        }
        try {
            return context.getResources().getResourceName(i2);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(i2);
        }
    }

    public Bundle h(Bundle bundle) {
        HashMap<String, d> hashMap;
        if (bundle == null && ((hashMap = this.f1580i) == null || hashMap.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        HashMap<String, d> hashMap2 = this.f1580i;
        if (hashMap2 != null) {
            for (Map.Entry<String, d> entry : hashMap2.entrySet()) {
                d value = entry.getValue();
                String key = entry.getKey();
                if (value.c) {
                    value.a.d(bundle2, key, value.f1557d);
                }
            }
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap<String, d> hashMap3 = this.f1580i;
            if (hashMap3 != null) {
                for (Map.Entry<String, d> entry2 : hashMap3.entrySet()) {
                    d value2 = entry2.getValue();
                    String key2 = entry2.getKey();
                    boolean z = false;
                    if (value2.b || !bundle.containsKey(key2) || bundle.get(key2) != null) {
                        try {
                            value2.a.a(bundle, key2);
                            z = true;
                            continue;
                        } catch (ClassCastException unused) {
                            continue;
                        }
                    }
                    if (!z) {
                        StringBuilder i2 = f.a.a.a.a.i("Wrong argument type for '");
                        i2.append(entry2.getKey());
                        i2.append("' in argument bundle. ");
                        i2.append(entry2.getValue().a.b());
                        i2.append(" expected.");
                        throw new IllegalArgumentException(i2.toString());
                    }
                }
            }
        }
        return bundle2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00df, code lost:
        if (r14.replaceAll("[{}]", "").equals(r15) != false) goto L_0x00e4;
     */
    public a j(i iVar) {
        Bundle bundle;
        int i2;
        Bundle bundle2;
        Matcher matcher;
        Uri uri;
        ArrayList<h> arrayList = this.f1578g;
        Matcher matcher2 = null;
        if (arrayList == null) {
            return null;
        }
        Iterator<h> it = arrayList.iterator();
        a aVar = null;
        while (it.hasNext()) {
            h next = it.next();
            Uri uri2 = iVar.a;
            if (uri2 != null) {
                HashMap<String, d> hashMap = this.f1580i;
                Map emptyMap = hashMap == null ? Collections.emptyMap() : Collections.unmodifiableMap(hashMap);
                Matcher matcher3 = next.c.matcher(uri2.toString());
                if (matcher3.matches()) {
                    bundle2 = new Bundle();
                    int size = next.a.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 < size) {
                            String str = next.a.get(i3);
                            i3++;
                            if (next.b(bundle2, str, Uri.decode(matcher3.group(i3)), (d) emptyMap.get(str))) {
                                break;
                            }
                        } else if (next.f1571e) {
                            Iterator<String> it2 = next.b.keySet().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                String next2 = it2.next();
                                h.b bVar = next.b.get(next2);
                                String queryParameter = uri2.getQueryParameter(next2);
                                if (queryParameter != null) {
                                    matcher = Pattern.compile(bVar.a).matcher(queryParameter);
                                    if (!matcher.matches()) {
                                        break;
                                    }
                                } else {
                                    matcher = matcher2;
                                }
                                int i4 = 0;
                                while (true) {
                                    if (i4 < bVar.b.size()) {
                                        String decode = matcher != null ? Uri.decode(matcher.group(i4 + 1)) : matcher2;
                                        String str2 = bVar.b.get(i4);
                                        d dVar = (d) emptyMap.get(str2);
                                        if (dVar != null) {
                                            if (decode != null) {
                                                uri = uri2;
                                            } else {
                                                uri = uri2;
                                            }
                                            Object obj = dVar.f1557d;
                                            if (obj != null) {
                                                decode = obj.toString();
                                            } else if (dVar.b) {
                                                decode = null;
                                            }
                                        } else {
                                            uri = uri2;
                                        }
                                        if (next.b(bundle2, str2, decode, dVar)) {
                                            bundle2 = null;
                                            break;
                                        }
                                        i4++;
                                        uri2 = uri;
                                        matcher2 = null;
                                    }
                                }
                            }
                        }
                    }
                    bundle = bundle2;
                }
                bundle2 = matcher2;
                bundle = bundle2;
            } else {
                bundle = null;
            }
            String str3 = iVar.b;
            boolean z = str3 != null && str3.equals(next.f1572f);
            String str4 = iVar.c;
            if (str4 != null) {
                i2 = (next.f1574h == null || !next.f1573g.matcher(str4).matches()) ? -1 : new h.a(next.f1574h).compareTo(new h.a(str4));
            } else {
                i2 = -1;
            }
            if (bundle != null || z || i2 > -1) {
                a aVar2 = new a(this, bundle, next.f1570d, z, i2);
                if (aVar == null || aVar2.compareTo(aVar) > 0) {
                    aVar = aVar2;
                }
            }
            matcher2 = null;
        }
        return aVar;
    }

    public void k(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.Navigator);
        int resourceId = obtainAttributes.getResourceId(R$styleable.Navigator_android_id, 0);
        this.f1575d = resourceId;
        this.f1576e = null;
        this.f1576e = i(context, resourceId);
        this.f1577f = obtainAttributes.getText(R$styleable.Navigator_android_label);
        obtainAttributes.recycle();
    }

    public boolean l() {
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.f1576e;
        if (str == null) {
            sb.append("0x");
            str = Integer.toHexString(this.f1575d);
        }
        sb.append(str);
        sb.append(")");
        if (this.f1577f != null) {
            sb.append(" label=");
            sb.append(this.f1577f);
        }
        return sb.toString();
    }
}
