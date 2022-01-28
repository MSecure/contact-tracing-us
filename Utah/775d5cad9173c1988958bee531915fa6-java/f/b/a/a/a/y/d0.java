package f.b.a.a.a.y;

import android.content.Context;
import android.net.Uri;
import f.a.b.p;
import f.b.a.a.a.c0.g;
import f.b.a.a.a.c0.i;
import f.b.a.a.a.z.r;
import f.b.a.c.b.o.b;
import f.b.b.b.h;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import l.b.a.d;
import org.json.JSONObject;

public class d0 {

    /* renamed from: h  reason: collision with root package name */
    public static final f.b.a.a.a.s.d0.a f2496h = f.b.a.a.a.s.d0.a.e("DiagnosisKeyUploader");

    /* renamed from: i  reason: collision with root package name */
    public static final f.b.b.c.a f2497i = f.b.b.c.a.a;
    public final Context a;
    public final Uri b;
    public final g c;

    /* renamed from: d  reason: collision with root package name */
    public final ExecutorService f2498d;

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f2499e;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.a.a.a.s.e0.a f2500f;

    /* renamed from: g  reason: collision with root package name */
    public final r f2501g;

    public static class a extends i {
        public a(Uri uri, JSONObject jSONObject, p.b<JSONObject> bVar, p.a aVar, f.b.a.a.a.s.e0.a aVar2, boolean z) {
            super(1, uri.toString(), jSONObject, bVar, aVar, aVar2, z);
        }

        @Override // f.a.b.n
        public Map<String, String> i() {
            if (!this.t) {
                return h.f3138h;
            }
            b.x("X-Chaff", "1");
            return h.d(1, new Object[]{"X-Chaff", "1"});
        }
    }

    static {
        d.n(30);
    }

    public d0(Context context, Uri uri, g gVar, ExecutorService executorService, ExecutorService executorService2, f.b.a.a.a.s.e0.a aVar, r rVar) {
        this.a = context;
        this.b = uri;
        this.c = gVar;
        this.f2498d = executorService;
        this.f2499e = executorService2;
        this.f2500f = aVar;
        this.f2501g = rVar;
    }
}
