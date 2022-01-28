package f.b.a.a.a.o;

import android.content.Context;
import android.net.Uri;
import f.a.b.p;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.p.r;
import f.b.a.a.a.r.g;
import f.b.b.a.i;
import f.b.b.b.c;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class c0 {

    /* renamed from: h  reason: collision with root package name */
    public static final f.b.a.a.a.i.e0.a f2296h = f.b.a.a.a.i.e0.a.e("DiagnosisAttestor");

    /* renamed from: i  reason: collision with root package name */
    public static final i f2297i = new i(String.valueOf(','));

    /* renamed from: j  reason: collision with root package name */
    public static final f.b.b.c.a f2298j = f.b.b.c.a.a;

    /* renamed from: k  reason: collision with root package name */
    public static final JSONArray f2299k = new JSONArray((Collection) c.x(h0.d.CONFIRMED.b(), h0.d.LIKELY.b(), h0.d.NEGATIVE.b(), h0.d.USER_REPORT.b()));
    public final Uri a;
    public final Uri b;
    public final Uri c;

    /* renamed from: d  reason: collision with root package name */
    public final g f2300d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2301e;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.a.a.a.i.f0.a f2302f;

    /* renamed from: g  reason: collision with root package name */
    public final r f2303g;

    public static class a extends f.b.a.a.a.r.i {
        public final String v;

        public a(String str, Uri uri, JSONObject jSONObject, p.b<JSONObject> bVar, p.a aVar, f.b.a.a.a.i.f0.a aVar2, boolean z) {
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

    public c0(Context context, Uri uri, Uri uri2, Uri uri3, g gVar, f.b.a.a.a.i.f0.a aVar, r rVar) {
        this.a = uri;
        this.b = uri2;
        this.c = uri3;
        this.f2300d = gVar;
        this.f2302f = aVar;
        this.f2303g = rVar;
        this.f2301e = context.getString(R.string.enx_testVerificationAPIKey);
    }
}
