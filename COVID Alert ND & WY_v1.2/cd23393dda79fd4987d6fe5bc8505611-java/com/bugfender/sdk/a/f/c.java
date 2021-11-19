package com.bugfender.sdk.a.f;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;
import okhttp3.HttpUrl;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    private final UUID a;
    private final Thread b;
    private final Throwable c;
    private final Date d;

    public static class b {
        private Throwable a;
        private Thread b;
        private Date c;

        public b a(Throwable th) {
            this.a = (Throwable) com.bugfender.sdk.a.a.e.c.a(th, "throwable == null");
            return this;
        }

        public b a(Thread thread) {
            this.b = thread;
            return this;
        }

        public b a(Date date) {
            this.c = (Date) com.bugfender.sdk.a.a.e.c.a(date, "date == null");
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.bugfender.sdk.a.f.c$c  reason: collision with other inner class name */
    public static class C0023c {
        final Throwable a;

        C0023c(Throwable th) {
            this.a = th;
        }

        public String a() {
            String[] split = toString().split(IOUtils.LINE_SEPARATOR_UNIX);
            return split.length >= 1 ? split[1] : "Crash Report";
        }

        public String b() {
            JSONArray jSONArray = new JSONArray();
            StackTraceElement[] stackTrace = this.a.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(FirebaseAnalytics.Param.METHOD, stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName());
                    jSONObject.put("file", stackTraceElement.getFileName() == null ? "Unknown" : stackTraceElement.getFileName());
                    jSONObject.put("lineNumber", stackTraceElement.getLineNumber());
                    jSONArray.put(jSONObject);
                } catch (JSONException unused) {
                    return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                }
            }
            return jSONArray.toString();
        }

        public String toString() {
            StringWriter stringWriter = new StringWriter();
            this.a.printStackTrace(new PrintWriter(stringWriter));
            return "``` \n " + stringWriter.toString() + " \n ```";
        }
    }

    public UUID a() {
        return this.a;
    }

    public Thread b() {
        return this.b;
    }

    public Throwable c() {
        return this.c;
    }

    public Date d() {
        return this.d;
    }

    public String e() {
        try {
            C0023c cVar = new C0023c(this.c);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.a.toString());
            jSONObject.put("title", cVar.a());
            jSONObject.put("raw", cVar.b());
            jSONObject.put("message", cVar.toString());
            jSONObject.put("date", new Date().getTime());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    private c(b bVar) {
        this.a = UUID.randomUUID();
        this.b = bVar.b;
        this.c = bVar.a;
        this.d = bVar.c;
    }

    public static c a(Thread thread, Throwable th) {
        return new b().a(th).a(thread).a(new Date()).a();
    }
}
