package f.a.b.w;

import android.support.annotation.Nullable;
import e.b.a.m;
import f.a.b.k;
import f.a.b.p;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends g<JSONObject> {
    public f(int i2, String str, @Nullable JSONObject jSONObject, p.b<JSONObject> bVar, @Nullable p.a aVar) {
        super(i2, str, jSONObject == null ? null : jSONObject.toString(), bVar, aVar);
    }

    @Override // f.a.b.n
    public p<JSONObject> q(k kVar) {
        try {
            return new p<>(new JSONObject(new String(kVar.b, m.e.h1(kVar.c, "utf-8"))), m.e.g1(kVar));
        } catch (UnsupportedEncodingException e2) {
            return new p<>(new f.a.b.m(e2));
        } catch (JSONException e3) {
            return new p<>(new f.a.b.m(e3));
        }
    }
}
