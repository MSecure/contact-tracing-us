package c.a.b.x;

import android.support.annotation.Nullable;
import b.b.k.i;
import c.a.b.l;
import c.a.b.n;
import c.a.b.q;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends h<JSONObject> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(int i, String str, @Nullable JSONObject jSONObject, q.b<JSONObject> bVar, @Nullable q.a aVar) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), bVar, aVar);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public g(String str, @Nullable JSONObject jSONObject, q.b<JSONObject> bVar, @Nullable q.a aVar) {
        this(jSONObject == null ? 0 : 1, str, jSONObject, bVar, aVar);
    }

    @Override // c.a.b.x.h, c.a.b.o
    public q<JSONObject> parseNetworkResponse(l lVar) {
        try {
            return new q<>(new JSONObject(new String(lVar.f2218b, i.j.L0(lVar.f2219c, h.PROTOCOL_CHARSET))), i.j.K0(lVar));
        } catch (UnsupportedEncodingException e2) {
            return new q<>(new n(e2));
        } catch (JSONException e3) {
            return new q<>(new n(e3));
        }
    }
}
