package f.b.a.a.a.z;

import android.content.Context;
import android.net.Uri;
import f.a.b.p;
import f.b.a.a.a.a0.r;
import f.b.a.a.a.d0.g;
import f.b.a.a.a.n0.j0;
import f.b.b.a.i;
import f.b.b.b.c;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c0 {

    /* renamed from: h */
    public static final f.b.a.a.a.t.p0.a f2536h = f.b.a.a.a.t.p0.a.e("DiagnosisAttestor");

    /* renamed from: i */
    public static final i f2537i = new i(String.valueOf(','));

    /* renamed from: j */
    public static final f.b.b.c.a f2538j = f.b.b.c.a.a;

    /* renamed from: k */
    public static final JSONArray f2539k = new JSONArray((Collection) c.x(j0.d.CONFIRMED.b(), j0.d.LIKELY.b(), j0.d.NEGATIVE.b(), j0.d.USER_REPORT.b()));
    public final Uri a;
    public final Uri b;
    public final Uri c;

    /* renamed from: d */
    public final g f2540d;

    /* renamed from: e */
    public final String f2541e;

    /* renamed from: f */
    public final f.b.a.a.a.t.q0.a f2542f;

    /* renamed from: g */
    public final r f2543g;

    /* loaded from: classes.dex */
    public static class a extends f.b.a.a.a.d0.i {
        public final String v;

        public a(String str, Uri uri, JSONObject jSONObject, p.b<JSONObject> bVar, p.a aVar, f.b.a.a.a.t.q0.a aVar2, boolean z) {
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

    public c0(Context context, Uri uri, Uri uri2, Uri uri3, g gVar, f.b.a.a.a.t.q0.a aVar, r rVar) {
        this.a = uri;
        this.b = uri2;
        this.c = uri3;
        this.f2540d = gVar;
        this.f2542f = aVar;
        this.f2543g = rVar;
        this.f2541e = context.getString(R.string.enx_testVerificationAPIKey);
    }
}
