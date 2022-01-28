package com.bugfender.sdk.a.a.l.a.m;

import com.bugfender.sdk.a.a.e.e;
import com.bugfender.sdk.a.a.h.d;
import com.bugfender.sdk.a.a.h.g;
import com.bugfender.sdk.a.a.h.h;
import com.bugfender.sdk.a.a.j.b;
import com.bugfender.sdk.a.a.l.a.l;
import com.bugfender.sdk.a.a.l.a.p.c;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements Callable<l<Integer>> {
    private final b a;
    private final com.bugfender.sdk.a.a.i.a b;
    private final String c;
    private final d d;
    private final com.bugfender.sdk.a.a.e.f.a e;

    public a(b bVar, com.bugfender.sdk.a.a.i.a aVar, String str, com.bugfender.sdk.a.a.e.f.a aVar2, d dVar) {
        this.a = bVar;
        this.b = aVar;
        this.c = str;
        this.d = dVar;
        this.e = aVar2;
    }

    public l<Integer> a(h hVar, List<String> list) {
        int i = 0;
        if (list.size() > 0) {
            if (hVar.k() <= 0) {
                try {
                    long a2 = this.b.a(hVar);
                    hVar.a(a2);
                    this.a.a(hVar.f(), a2);
                } catch (com.bugfender.sdk.a.a.d.b.b unused) {
                    return new l<>(0);
                }
            }
            for (String str : list) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("title", "Crash Report");
                    String optString2 = jSONObject.optString("raw", "{}");
                    String optString3 = jSONObject.optString("message", "");
                    long optLong = jSONObject.optLong("date", new Date().getTime());
                    UUID a3 = e.a(this.e.a());
                    long k = hVar.k();
                    this.b.a(k, Collections.singletonList(new g.b().a(g.c.D.a()).c("bf_issue").d(a3.toString()).a(new Date(optLong)).a()));
                    this.b.a(com.bugfender.sdk.a.a.h.e.h().a(a3).c(optString).a(optString2).b(optString3).a(k).a(new com.bugfender.sdk.a.a.h.a(this.c)).d(AppMeasurement.CRASH_ORIGIN).a());
                    i++;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                } finally {
                    this.a.c(hVar.f());
                }
            }
        }
        return new l<>(Integer.valueOf(i));
    }

    @Override // java.util.concurrent.Callable
    public l<Integer> call() {
        int i = 0;
        if (this.d.b()) {
            for (h hVar : this.a.a()) {
                try {
                    l<Integer> a2 = a(hVar, this.a.b(hVar).d().a());
                    if (a2.a().intValue() > 0) {
                        new c(this.b, this.a, this.c, Collections.singletonList(hVar)).call();
                    }
                    i += a2.a().intValue();
                } catch (com.bugfender.sdk.a.a.j.d unused) {
                }
            }
        }
        return new l<>(Integer.valueOf(i));
    }
}
