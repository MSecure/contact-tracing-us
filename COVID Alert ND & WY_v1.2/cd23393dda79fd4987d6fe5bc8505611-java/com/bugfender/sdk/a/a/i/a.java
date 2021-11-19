package com.bugfender.sdk.a.a.i;

import android.util.Log;
import com.bugfender.sdk.Bugfender;
import com.bugfender.sdk.a.a.d.a.b;
import com.bugfender.sdk.a.a.e.c;
import com.bugfender.sdk.a.a.h.d;
import com.bugfender.sdk.a.a.h.f;
import com.bugfender.sdk.a.a.h.g;
import com.bugfender.sdk.a.a.h.h;
import com.bugfender.sdk.a.a.i.b.b.a;
import com.bugfender.sdk.a.a.i.c.b.a;
import com.bugfender.sdk.a.a.i.c.b.e;
import java.util.List;
import java.util.Map;

public class a {
    private static final String c = Bugfender.class.getSimpleName();
    private final com.bugfender.sdk.a.a.i.d.a a;
    private final com.bugfender.sdk.a.a.d.a.a<com.bugfender.sdk.a.a.i.c.a.a> b = new b();

    public a(com.bugfender.sdk.a.a.i.d.a aVar) {
        c.a(aVar, "BugfenderApiManager must be not null");
        this.a = aVar;
    }

    public d a(String str, com.bugfender.sdk.a.a.h.c cVar, Map<String, ?> map) {
        try {
            String a2 = this.a.a("app/device-status", a.C0006a.C0007a.a(str, cVar, map));
            com.bugfender.sdk.a.a.i.c.b.a a3 = a.C0006a.b.a(a2);
            if (a3 != null) {
                a.C0012a a4 = a3.a();
                if (a4 != null) {
                    int a5 = a4.a();
                    if (a5 == -1017) {
                        throw new com.bugfender.sdk.a.a.i.c.a.a(com.bugfender.sdk.a.a.i.c.a.a.f, "Deleted app");
                    } else if (a5 == -1004) {
                        throw new com.bugfender.sdk.a.a.i.c.a.a(com.bugfender.sdk.a.a.i.c.a.a.e, "Invalid app token");
                    }
                }
                return new d.b().b(a3.c()).a(a3.d()).a(a3.b().a()).a();
            }
            throw new com.bugfender.sdk.a.a.i.c.a.a(2, "Unexpected response body from server: " + a2);
        } catch (com.bugfender.sdk.a.a.i.c.a.a e) {
            com.bugfender.sdk.a.a.d.b.b a6 = this.b.a(e);
            a(a6);
            throw a6;
        }
    }

    public long a(h hVar) {
        try {
            String a2 = this.a.a("session", a.c.C0009a.a(hVar));
            e a3 = a.c.b.a(a2);
            if (a3 != null) {
                return (long) a3.a();
            }
            throw new com.bugfender.sdk.a.a.i.c.a.a(2, "Unexpected response body from server: " + a2);
        } catch (com.bugfender.sdk.a.a.i.c.a.a e) {
            com.bugfender.sdk.a.a.d.b.b a4 = this.b.a(e);
            a(a4);
            throw a4;
        }
    }

    public void a(long j, List<g> list) {
        try {
            this.a.a("log/batch", a.e.C0011a.a(j, list), j);
        } catch (com.bugfender.sdk.a.a.i.c.a.a e) {
            com.bugfender.sdk.a.a.d.b.b a2 = this.b.a(e);
            a(a2);
            throw a2;
        }
    }

    public void a(com.bugfender.sdk.a.a.h.e eVar) {
        try {
            this.a.a("issue", a.b.C0008a.a(eVar));
        } catch (com.bugfender.sdk.a.a.i.c.a.a e) {
            com.bugfender.sdk.a.a.d.b.b a2 = this.b.a(e);
            a(a2);
            throw a2;
        }
    }

    public void a(String str, String str2, f<?> fVar) {
        try {
            this.a.a("device/keyvalue", a.d.C0010a.a(str, str2, fVar));
        } catch (com.bugfender.sdk.a.a.i.c.a.a e) {
            com.bugfender.sdk.a.a.d.b.b a2 = this.b.a(e);
            a(a2);
            throw a2;
        }
    }

    private void a(Throwable th) {
        if (th instanceof com.bugfender.sdk.a.a.d.b.a) {
            Log.e(c, "Unrecognized application key.");
        } else if (th instanceof com.bugfender.sdk.a.a.d.b.c) {
            Log.d(com.bugfender.sdk.a.a.b.E, "Log limit reached");
        } else if (th instanceof com.bugfender.sdk.a.a.d.b.d) {
            Log.e(com.bugfender.sdk.a.a.b.E, "Network error, will retry later");
        }
    }
}
