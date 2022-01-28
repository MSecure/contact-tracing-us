package com.bugfender.sdk.a.a.c.e;

import com.bugfender.sdk.a.a.c.a;
import com.bugfender.sdk.a.a.h.g;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.text.ParseException;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements a<g, String> {
    /* renamed from: a */
    public String b(g gVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("line", gVar.e());
            jSONObject.put(FirebaseAnalytics.Param.LEVEL, gVar.d());
            jSONObject.put("absoluteTime", gVar.a());
            jSONObject.put("date", com.bugfender.sdk.a.a.i.b.a.b.a().format(gVar.b()));
            String g = gVar.g();
            String str = "";
            if (g == null) {
                g = str;
            }
            jSONObject.put("tag", g);
            String f = gVar.f();
            if (f == null) {
                f = str;
            }
            jSONObject.put(FirebaseAnalytics.Param.METHOD, f);
            String c = gVar.c();
            if (c == null) {
                c = str;
            }
            jSONObject.put("file", c);
            String h = gVar.h();
            if (h == null) {
                h = str;
            }
            jSONObject.put("text", h);
            String j = gVar.j();
            if (j == null) {
                j = str;
            }
            jSONObject.put("thn", j);
            String i = gVar.i();
            if (i != null) {
                str = i;
            }
            jSONObject.put("th", str);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public g a(String str) {
        Date date;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("line");
            int i2 = jSONObject.getInt(FirebaseAnalytics.Param.LEVEL);
            long j = jSONObject.getLong("absoluteTime");
            try {
                date = com.bugfender.sdk.a.a.i.b.a.b.a().parse(jSONObject.optString("date"));
            } catch (ParseException unused) {
                date = null;
            }
            String str2 = "";
            String string = jSONObject.has("tag") ? jSONObject.getString("tag") : str2;
            String string2 = jSONObject.has(FirebaseAnalytics.Param.METHOD) ? jSONObject.getString(FirebaseAnalytics.Param.METHOD) : str2;
            String string3 = jSONObject.has("file") ? jSONObject.getString("file") : str2;
            String string4 = jSONObject.has("text") ? jSONObject.getString("text") : str2;
            String string5 = jSONObject.has("thn") ? jSONObject.getString("thn") : str2;
            if (jSONObject.has("th")) {
                str2 = jSONObject.getString("th");
            }
            return new g.b().b(i).a(i2).a(j).a(date).c(string).b(string2).a(string3).d(string4).f(string5).e(str2).a();
        } catch (JSONException unused2) {
            return null;
        }
    }
}
