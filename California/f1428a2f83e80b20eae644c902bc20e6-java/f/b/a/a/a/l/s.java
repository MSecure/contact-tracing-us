package f.b.a.a.a.l;

import android.content.Context;
import android.net.Uri;
import f.a.b.p;
import f.b.a.a.a.m.p;
import f.b.a.a.a.o.g;
import f.b.a.a.a.o.i;
import f.b.a.c.b.o.b;
import f.b.b.b.h;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import l.b.a.c;
import org.json.JSONObject;

public class s {

    /* renamed from: h  reason: collision with root package name */
    public static final f.b.b.c.a f2120h = f.b.b.c.a.a;
    public final Context a;
    public final Uri b;
    public final g c;

    /* renamed from: d  reason: collision with root package name */
    public final ExecutorService f2121d;

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f2122e;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.a.a.a.h.s.a f2123f;

    /* renamed from: g  reason: collision with root package name */
    public final p f2124g;

    public static class a extends i {
        public a(Uri uri, JSONObject jSONObject, p.b<JSONObject> bVar, p.a aVar, f.b.a.a.a.h.s.a aVar2, boolean z) {
            super(1, uri.toString(), jSONObject, bVar, aVar, aVar2, z);
        }

        @Override // f.a.b.n
        public Map<String, String> i() {
            if (!this.s) {
                return h.f2877h;
            }
            b.y("X-Chaff", "1");
            return h.d(1, new Object[]{"X-Chaff", "1"});
        }
    }

    static {
        c.l(30);
    }

    public s(Context context, Uri uri, g gVar, ExecutorService executorService, ExecutorService executorService2, f.b.a.a.a.h.s.a aVar, f.b.a.a.a.m.p pVar) {
        this.a = context;
        this.b = uri;
        this.c = gVar;
        this.f2121d = executorService;
        this.f2122e = executorService2;
        this.f2123f = aVar;
        this.f2124g = pVar;
    }
}
