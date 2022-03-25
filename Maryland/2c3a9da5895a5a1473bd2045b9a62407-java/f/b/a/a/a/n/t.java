package f.b.a.a.a.n;

import android.content.Context;
import android.net.Uri;
import f.a.b.p;
import f.b.a.a.a.o.p;
import f.b.a.a.a.q.g;
import f.b.a.a.a.q.i;
import f.b.a.c.b.o.b;
import f.b.b.b.h;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import l.b.a.c;
import org.json.JSONObject;

public class t {

    /* renamed from: h  reason: collision with root package name */
    public static final f.b.b.c.a f2199h = f.b.b.c.a.a;
    public final Context a;
    public final Uri b;
    public final g c;

    /* renamed from: d  reason: collision with root package name */
    public final ExecutorService f2200d;

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f2201e;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.a.a.a.h.s.a f2202f;

    /* renamed from: g  reason: collision with root package name */
    public final p f2203g;

    public static class a extends i {
        public a(Uri uri, JSONObject jSONObject, p.b<JSONObject> bVar, p.a aVar, f.b.a.a.a.h.s.a aVar2, boolean z) {
            super(1, uri.toString(), jSONObject, bVar, aVar, aVar2, z);
        }

        @Override // f.a.b.n
        public Map<String, String> i() {
            if (!this.t) {
                return h.f2981h;
            }
            b.y("X-Chaff", "1");
            return h.d(1, new Object[]{"X-Chaff", "1"});
        }
    }

    static {
        c.m(30);
    }

    public t(Context context, Uri uri, g gVar, ExecutorService executorService, ExecutorService executorService2, f.b.a.a.a.h.s.a aVar, f.b.a.a.a.o.p pVar) {
        this.a = context;
        this.b = uri;
        this.c = gVar;
        this.f2200d = executorService;
        this.f2201e = executorService2;
        this.f2202f = aVar;
        this.f2203g = pVar;
    }
}
