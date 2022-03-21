package f.a.b.w;

import android.support.annotation.VisibleForTesting;
import f.a.b.g;
import f.a.b.n;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e extends a {

    public static class a extends FilterInputStream {
        public final HttpURLConnection b;

        /* JADX WARNING: Illegal instructions before constructor call */
        public a(HttpURLConnection httpURLConnection) {
            super(r0);
            InputStream inputStream;
            try {
                inputStream = httpURLConnection.getInputStream();
            } catch (IOException unused) {
                inputStream = httpURLConnection.getErrorStream();
            }
            this.b = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() {
            super.close();
            this.b.disconnect();
        }
    }

    public static void b(HttpURLConnection httpURLConnection, n<?> nVar, byte[] bArr) {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", nVar.f());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    @VisibleForTesting
    public static List<g> c(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String str : entry.getValue()) {
                    arrayList.add(new g(entry.getKey(), str));
                }
            }
        }
        return arrayList;
    }

    public static void d(HttpURLConnection httpURLConnection, n<?> nVar) {
        String str;
        switch (nVar.c) {
            case -1:
                byte[] l2 = nVar.l();
                if (l2 != null) {
                    httpURLConnection.setRequestMethod("POST");
                    b(httpURLConnection, nVar, l2);
                    return;
                }
                return;
            case 0:
                str = "GET";
                break;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                byte[] e2 = nVar.e();
                if (e2 != null) {
                    b(httpURLConnection, nVar, e2);
                    return;
                }
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                byte[] e3 = nVar.e();
                if (e3 != null) {
                    b(httpURLConnection, nVar, e3);
                    return;
                }
                return;
            case 3:
                str = "DELETE";
                break;
            case 4:
                str = "HEAD";
                break;
            case 5:
                str = "OPTIONS";
                break;
            case 6:
                str = "TRACE";
                break;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                byte[] e4 = nVar.e();
                if (e4 != null) {
                    b(httpURLConnection, nVar, e4);
                    return;
                }
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
        httpURLConnection.setRequestMethod(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b8  */
    @Override // f.a.b.w.a
    public d a(n<?> nVar, Map<String, String> map) {
        Throwable th;
        String str = nVar.f2032d;
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(nVar.i());
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int a2 = nVar.f2040l.a();
        httpURLConnection.setConnectTimeout(a2);
        httpURLConnection.setReadTimeout(a2);
        boolean z = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        "https".equals(url.getProtocol());
        try {
            for (String str2 : hashMap.keySet()) {
                httpURLConnection.setRequestProperty(str2, (String) hashMap.get(str2));
            }
            d(httpURLConnection, nVar);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != -1) {
                if (!((nVar.c == 4 || (100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304) ? false : true)) {
                    d dVar = new d(responseCode, c(httpURLConnection.getHeaderFields()));
                    httpURLConnection.disconnect();
                    return dVar;
                }
                try {
                    return new d(responseCode, c(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new a(httpURLConnection));
                } catch (Throwable th2) {
                    th = th2;
                    z = true;
                    if (!z) {
                    }
                    throw th;
                }
            } else {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
        } catch (Throwable th3) {
            th = th3;
            if (!z) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
