package f.b.a.a.a.o;

import android.content.Context;
import android.net.Uri;
import f.a.b.p;
import f.b.a.a.a.p.r;
import f.b.a.a.a.r.g;
import f.b.a.a.a.r.i;
import f.b.a.c.b.o.b;
import f.b.b.b.h;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import l.b.a.d;
import org.json.JSONObject;

public class d0 {

    /* renamed from: h  reason: collision with root package name */
    public static final f.b.a.a.a.i.e0.a f2304h = f.b.a.a.a.i.e0.a.e("DiagnosisKeyUploader");

    /* renamed from: i  reason: collision with root package name */
    public static final f.b.b.c.a f2305i = f.b.b.c.a.a;
    public final Context a;
    public final Uri b;
    public final g c;

    /* renamed from: d  reason: collision with root package name */
    public final ExecutorService f2306d;

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f2307e;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.a.a.a.i.f0.a f2308f;

    /* renamed from: g  reason: collision with root package name */
    public final r f2309g;

    public static class a extends i {
        public a(Uri uri, JSONObject jSONObject, p.b<JSONObject> bVar, p.a aVar, f.b.a.a.a.i.f0.a aVar2, boolean z) {
            super(1, uri.toString(), jSONObject, bVar, aVar, aVar2, z);
        }

        @Override // f.a.b.n
        public Map<String, String> i() {
            if (!this.t) {
                return h.f3075h;
            }
            b.x("X-Chaff", "1");
            return h.d(1, new Object[]{"X-Chaff", "1"});
        }
    }

    static {
        d.n(30);
    }

    public d0(Context context, Uri uri, g gVar, ExecutorService executorService, ExecutorService executorService2, f.b.a.a.a.i.f0.a aVar, r rVar) {
        this.a = context;
        this.b = uri;
        this.c = gVar;
        this.f2306d = executorService;
        this.f2307e = executorService2;
        this.f2308f = aVar;
        this.f2309g = rVar;
    }
}
