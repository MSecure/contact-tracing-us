package f.b.a.b.h;

import e.b.a.m;
import f.b.a.b.h.b.o;
import f.b.a.b.h.b.s;
import f.b.a.b.h.e;
import f.b.c.i.a;
import f.b.c.i.h.d;
import f.b.c.i.h.f;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public final /* synthetic */ class c {
    public final e a;

    public c(e eVar) {
        this.a = eVar;
    }

    public Object a(Object obj) {
        e eVar = this.a;
        e.a aVar = (e.a) obj;
        Objects.requireNonNull(eVar);
        m.e.S("CctTransportBackend", "Making request to: %s", aVar.a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(eVar.f2608f);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "2.3.1"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                a aVar2 = eVar.a;
                o oVar = aVar.b;
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                f.b.c.i.h.e eVar2 = ((d) aVar2).a;
                f fVar = new f(bufferedWriter, eVar2.a, eVar2.b, eVar2.c, eVar2.f3492d);
                fVar.e(oVar, false);
                fVar.g();
                fVar.b.flush();
                gZIPOutputStream.close();
                if (outputStream != null) {
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                m.e.C0("CctTransportBackend");
                httpURLConnection.getHeaderField("Content-Type");
                m.e.C0("CctTransportBackend");
                httpURLConnection.getHeaderField("Content-Encoding");
                m.e.C0("CctTransportBackend");
                if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                    return new e.b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0);
                }
                if (responseCode != 200) {
                    return new e.b(responseCode, null, 0);
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                    e.b bVar = new e.b(responseCode, null, ((f.b.a.b.h.b.m) s.b(new BufferedReader(new InputStreamReader(gZIPInputStream)))).a);
                    if (gZIPInputStream != null) {
                        gZIPInputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return bVar;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        } catch (f.b.c.i.c | IOException unused3) {
            m.e.C0("CctTransportBackend");
            return new e.b(400, null, 0);
        } catch (ConnectException | UnknownHostException unused4) {
            m.e.C0("CctTransportBackend");
            return new e.b(500, null, 0);
        }
    }
}
