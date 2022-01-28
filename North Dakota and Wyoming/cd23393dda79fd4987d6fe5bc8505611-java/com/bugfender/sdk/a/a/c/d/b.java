package com.bugfender.sdk.a.a.c.d;

import android.text.TextUtils;
import com.bugfender.sdk.a.a.c.a;
import com.bugfender.sdk.a.a.h.e;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements a<e, String> {
    private JSONObject b(e eVar) {
        if (eVar.a() != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", eVar.a().a());
                return jSONObject;
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public String b(e eVar) {
        JSONObject b = b(eVar);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", eVar.g().toString());
            jSONObject.put("title", eVar.e());
            jSONObject.put("text", eVar.d());
            jSONObject.put("sessionId", eVar.c());
            jSONObject.put("application", b);
            jSONObject.putOpt("type", eVar.f());
            jSONObject.putOpt("raw", eVar.b());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public e a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("uid");
            String string = jSONObject.getString("title");
            String string2 = jSONObject.getString("text");
            long j = jSONObject.getLong("sessionId");
            String optString2 = jSONObject.optString("type");
            if (optString2 == null) {
                optString2 = jSONObject.optString("tag");
            }
            String optString3 = jSONObject.optString("raw");
            JSONObject optJSONObject = jSONObject.optJSONObject("application");
            String string3 = optJSONObject != null ? optJSONObject.getString("key") : null;
            if (string3 != null) {
                e.b a = e.h().c(string).b(string2).a(j).a(new com.bugfender.sdk.a.a.h.a(string3)).d(optString2).a(optString3);
                if (!TextUtils.isEmpty(optString)) {
                    a.a(UUID.fromString(optString));
                }
                return a.a();
            }
            e.b a2 = e.h().c(string).b(string2).a(j).d(optString2).a(optString3);
            if (!TextUtils.isEmpty(optString)) {
                a2.a(UUID.fromString(optString));
            }
            return a2.a();
        } catch (JSONException unused) {
            return null;
        }
    }
}
