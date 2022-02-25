package f.b.a.a.a.l;

import android.content.Context;
import android.net.Uri;
import f.a.b.p;
import f.b.a.a.a.m.p;
import f.b.a.a.a.o.g;
import f.b.a.a.a.w.b0;
import f.b.b.a.i;
import f.b.b.b.c;
import gov.ca.covid19.exposurenotifications.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class r {

    /* renamed from: g  reason: collision with root package name */
    public static final i f2114g = new i(String.valueOf(','));

    /* renamed from: h  reason: collision with root package name */
    public static final f.b.b.c.a f2115h = f.b.b.c.a.a;

    /* renamed from: i  reason: collision with root package name */
    public static final JSONArray f2116i;
    public final Uri a;
    public final Uri b;
    public final g c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2117d;

    /* renamed from: e  reason: collision with root package name */
    public final f.b.a.a.a.h.s.a f2118e;

    /* renamed from: f  reason: collision with root package name */
    public final p f2119f;

    public static class a extends f.b.a.a.a.o.i {
        public final String u;

        public a(String str, Uri uri, JSONObject jSONObject, p.b<JSONObject> bVar, p.a aVar, f.b.a.a.a.h.s.a aVar2, boolean z) {
            super(1, uri.toString(), jSONObject, bVar, aVar, aVar2, z);
            this.u = str;
        }

        @Override // f.a.b.n
        public Map<String, String> i() {
            HashMap hashMap = new HashMap();
            hashMap.put("X-API-Key", this.u);
            if (this.s) {
                hashMap.put("X-Chaff", "1");
            }
            return hashMap;
        }
    }

    static {
        String a2 = b0.d.CONFIRMED.a();
        String a3 = b0.d.LIKELY.a();
        String a4 = b0.d.NEGATIVE.a();
        f.b.b.b.a<Object> aVar = c.c;
        f2116i = new JSONArray((Collection) c.q(a2, a3, a4));
    }

    public r(Context context, Uri uri, Uri uri2, g gVar, f.b.a.a.a.h.s.a aVar, f.b.a.a.a.m.p pVar) {
        this.a = uri;
        this.b = uri2;
        this.c = gVar;
        this.f2118e = aVar;
        this.f2119f = pVar;
        this.f2117d = context.getString(R.string.enx_testVerificationAPIKey);
    }
}
