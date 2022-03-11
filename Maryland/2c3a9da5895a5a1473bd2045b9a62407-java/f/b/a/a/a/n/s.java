package f.b.a.a.a.n;

import android.content.Context;
import android.net.Uri;
import f.a.b.p;
import f.b.a.a.a.o.p;
import f.b.a.a.a.q.g;
import f.b.a.a.a.y.c0;
import f.b.b.a.i;
import f.b.b.b.c;
import gov.md.covid19.exposurenotifications.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class s {

    /* renamed from: g  reason: collision with root package name */
    public static final i f2193g = new i(String.valueOf(','));

    /* renamed from: h  reason: collision with root package name */
    public static final f.b.b.c.a f2194h = f.b.b.c.a.a;

    /* renamed from: i  reason: collision with root package name */
    public static final JSONArray f2195i;
    public final Uri a;
    public final Uri b;
    public final g c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2196d;

    /* renamed from: e  reason: collision with root package name */
    public final f.b.a.a.a.h.s.a f2197e;

    /* renamed from: f  reason: collision with root package name */
    public final p f2198f;

    public static class a extends f.b.a.a.a.q.i {
        public final String v;

        public a(String str, Uri uri, JSONObject jSONObject, p.b<JSONObject> bVar, p.a aVar, f.b.a.a.a.h.s.a aVar2, boolean z) {
            super(1, uri.toString(), jSONObject, bVar, aVar, aVar2, z);
            this.v = str;
        }

        @Override // f.a.b.n
        public Map<String, String> i() {
            HashMap hashMap = new HashMap();
            hashMap.put("X-API-Key", this.v);
            if (this.t) {
                hashMap.put("X-Chaff", "1");
            }
            return hashMap;
        }
    }

    static {
        String a2 = c0.d.CONFIRMED.a();
        String a3 = c0.d.LIKELY.a();
        String a4 = c0.d.NEGATIVE.a();
        f.b.b.b.a<Object> aVar = c.c;
        f2195i = new JSONArray((Collection) c.q(a2, a3, a4));
    }

    public s(Context context, Uri uri, Uri uri2, g gVar, f.b.a.a.a.h.s.a aVar, f.b.a.a.a.o.p pVar) {
        this.a = uri;
        this.b = uri2;
        this.c = gVar;
        this.f2197e = aVar;
        this.f2198f = pVar;
        this.f2196d = context.getString(R.string.enx_testVerificationAPIKey);
    }
}
