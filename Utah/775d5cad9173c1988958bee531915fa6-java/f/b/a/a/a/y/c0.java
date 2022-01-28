package f.b.a.a.a.y;

import android.content.Context;
import android.net.Uri;
import f.a.b.p;
import f.b.a.a.a.c0.g;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.z.r;
import f.b.b.a.i;
import f.b.b.b.c;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class c0 {

    /* renamed from: h  reason: collision with root package name */
    public static final f.b.a.a.a.s.d0.a f2488h = f.b.a.a.a.s.d0.a.e("DiagnosisAttestor");

    /* renamed from: i  reason: collision with root package name */
    public static final i f2489i = new i(String.valueOf(','));

    /* renamed from: j  reason: collision with root package name */
    public static final f.b.b.c.a f2490j = f.b.b.c.a.a;

    /* renamed from: k  reason: collision with root package name */
    public static final JSONArray f2491k = new JSONArray((Collection) c.x(h0.d.CONFIRMED.b(), h0.d.LIKELY.b(), h0.d.NEGATIVE.b(), h0.d.USER_REPORT.b()));
    public final Uri a;
    public final Uri b;
    public final Uri c;

    /* renamed from: d  reason: collision with root package name */
    public final g f2492d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2493e;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.a.a.a.s.e0.a f2494f;

    /* renamed from: g  reason: collision with root package name */
    public final r f2495g;

    public static class a extends f.b.a.a.a.c0.i {
        public final String v;

        public a(String str, Uri uri, JSONObject jSONObject, p.b<JSONObject> bVar, p.a aVar, f.b.a.a.a.s.e0.a aVar2, boolean z) {
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

    public c0(Context context, Uri uri, Uri uri2, Uri uri3, g gVar, f.b.a.a.a.s.e0.a aVar, r rVar) {
        this.a = uri;
        this.b = uri2;
        this.c = uri3;
        this.f2492d = gVar;
        this.f2494f = aVar;
        this.f2495g = rVar;
        this.f2493e = context.getString(R.string.enx_testVerificationAPIKey);
    }
}
