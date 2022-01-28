package com.bugfender.sdk.a.a.c.f;

import com.bugfender.sdk.a.a.c.a;
import com.bugfender.sdk.a.a.h.c;
import com.bugfender.sdk.a.a.h.h;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements a<h, String> {
    /* renamed from: a */
    public String b(h hVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("device", a(hVar.c()));
            jSONObject.put("applicationVersion", a(hVar.a()));
            jSONObject.put("batteryLevel", (double) hVar.b());
            jSONObject.put("freeRam", hVar.d());
            jSONObject.put("time", com.bugfender.sdk.a.a.i.b.a.b.a().format(hVar.m()));
            jSONObject.put("osVersion", hVar.h());
            jSONObject.put("language", hVar.e());
            jSONObject.put("timezone", hVar.n());
            jSONObject.put("totalRam", hVar.o());
            jSONObject.put("ramUsed", hVar.i());
            jSONObject.put("orientation", hVar.g());
            jSONObject.put("sdkType", hVar.j());
            jSONObject.put("localSessionId", hVar.f());
            jSONObject.put("sessionId", hVar.k());
            jSONObject.put("sessionIdentifier", hVar.l());
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public h a(String str) {
        String str2;
        String str3;
        try {
            JSONObject jSONObject = new JSONObject(str);
            h.a aVar = new h.a();
            JSONObject optJSONObject = jSONObject.optJSONObject("device");
            if (optJSONObject != null) {
                String string = optJSONObject.getString("udid");
                String string2 = optJSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
                String string3 = optJSONObject.getString("deviceType");
                String optString = optJSONObject.optString("osVersion");
                String optString2 = optJSONObject.optString("version");
                String optString3 = optJSONObject.optString("build");
                String optString4 = optJSONObject.optString("language");
                String optString5 = optJSONObject.optString("timezone");
                str2 = "language";
                str3 = "osVersion";
                aVar.a(new c.b().j(string).e(string2).c(string3).f(optString).k(optString2).b(optString3).d(optString4).i(optString5).g(optJSONObject.optString("sdkType")).a(optJSONObject.getString("applicationToken")).h(optJSONObject.optString("sdkVersion")).a());
            } else {
                str2 = "language";
                str3 = "osVersion";
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("applicationVersion");
            if (optJSONObject2 != null) {
                String string4 = optJSONObject2.getString("versionName");
                String string5 = optJSONObject2.getString("versionCode");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("application");
                aVar.a(com.bugfender.sdk.a.a.h.b.b(new com.bugfender.sdk.a.a.h.a(optJSONObject3 != null ? optJSONObject3.getString("key") : null), string4, string5));
            }
            Double valueOf = Double.valueOf(jSONObject.optDouble("batteryLevel"));
            aVar.a(valueOf.isNaN() ? 0.0f : BigDecimal.valueOf(valueOf.doubleValue()).floatValue());
            aVar.a(jSONObject.optLong("freeRam"));
            String optString6 = jSONObject.optString("time", null);
            if (optString6 != null) {
                try {
                    aVar.a(com.bugfender.sdk.a.a.i.b.a.b.a().parse(optString6));
                } catch (ParseException unused) {
                    aVar.a(new Date());
                }
            } else {
                aVar.a(new Date());
            }
            aVar.e(jSONObject.getString("timezone"));
            aVar.e(jSONObject.getLong("totalRam"));
            aVar.c(jSONObject.getLong("ramUsed"));
            aVar.a(jSONObject.getInt("orientation"));
            aVar.c(jSONObject.getString("sdkType"));
            aVar.b(jSONObject.getLong("localSessionId"));
            aVar.d(jSONObject.getLong("sessionId"));
            aVar.b(jSONObject.optString(str3));
            aVar.a(jSONObject.optString(str2));
            String optString7 = jSONObject.optString("sessionIdentifier");
            if (optString7 != null) {
                aVar.d(optString7);
            }
            return aVar.a();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private JSONObject a(c cVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("udid", cVar.l());
        jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.NAME, cVar.e());
        jSONObject.put("deviceType", cVar.c());
        jSONObject.put("osVersion", cVar.f());
        jSONObject.put("version", cVar.m());
        jSONObject.put("build", cVar.b());
        jSONObject.put("language", cVar.d());
        jSONObject.put("timezone", cVar.i());
        jSONObject.put("sdkType", cVar.g());
        jSONObject.put("applicationToken", cVar.a());
        jSONObject.put("sdkVersion", cVar.h());
        return jSONObject;
    }

    private JSONObject a(com.bugfender.sdk.a.a.h.b bVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("application", a(bVar.a()));
        jSONObject.put("versionName", bVar.c());
        jSONObject.put("versionCode", bVar.b());
        return jSONObject;
    }

    private JSONObject a(com.bugfender.sdk.a.a.h.a aVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", aVar.a());
        return jSONObject;
    }
}
