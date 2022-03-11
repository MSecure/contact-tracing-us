package f.b.a.a.a.z;

import android.content.Context;
import android.net.Uri;
import f.a.b.p;
import f.b.a.a.a.a0.r;
import f.b.a.a.a.d0.g;
import f.b.a.a.a.d0.i;
import f.b.a.c.b.o.b;
import f.b.b.b.h;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import l.b.a.d;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d0 {

    /* renamed from: h */
    public static final f.b.a.a.a.t.p0.a f2544h = f.b.a.a.a.t.p0.a.e("DiagnosisKeyUploader");

    /* renamed from: i */
    public static final f.b.b.c.a f2545i = f.b.b.c.a.a;
    public final Context a;
    public final Uri b;
    public final g c;

    /* renamed from: d */
    public final ExecutorService f2546d;

    /* renamed from: e */
    public final ExecutorService f2547e;

    /* renamed from: f */
    public final f.b.a.a.a.t.q0.a f2548f;

    /* renamed from: g */
    public final r f2549g;

    /* loaded from: classes.dex */
    public static class a extends i {
        public a(Uri uri, JSONObject jSONObject, p.b<JSONObject> bVar, p.a aVar, f.b.a.a.a.t.q0.a aVar2, boolean z) {
            super(1, uri.toString(), jSONObject, bVar, aVar, aVar2, z);
        }

        @Override // f.a.b.n
        public Map<String, String> i() {
            if (!this.t) {
                return h.f3393h;
            }
            b.y("X-Chaff", "1");
            return h.d(1, new Object[]{"X-Chaff", "1"});
        }
    }

    static {
        d.n(30);
    }

    public d0(Context context, Uri uri, g gVar, ExecutorService executorService, ExecutorService executorService2, f.b.a.a.a.t.q0.a aVar, r rVar) {
        this.a = context;
        this.b = uri;
        this.c = gVar;
        this.f2546d = executorService;
        this.f2547e = executorService2;
        this.f2548f = aVar;
        this.f2549g = rVar;
    }
}
