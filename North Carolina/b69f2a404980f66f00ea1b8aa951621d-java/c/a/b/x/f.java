package c.a.b.x;

import android.support.annotation.VisibleForTesting;
import c.a.b.h;
import c.a.b.o;
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
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    public final b f2270a = null;

    /* renamed from: b  reason: collision with root package name */
    public final SSLSocketFactory f2271b = null;

    public static class a extends FilterInputStream {

        /* renamed from: b  reason: collision with root package name */
        public final HttpURLConnection f2272b;

        /* JADX WARNING: Illegal instructions before constructor call */
        public a(HttpURLConnection httpURLConnection) {
            super(r0);
            InputStream inputStream;
            try {
                inputStream = httpURLConnection.getInputStream();
            } catch (IOException unused) {
                inputStream = httpURLConnection.getErrorStream();
            }
            this.f2272b = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() {
            super.close();
            this.f2272b.disconnect();
        }
    }

    public interface b {
        String a(String str);
    }

    public static void b(HttpURLConnection httpURLConnection, o<?> oVar, byte[] bArr) {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", oVar.getBodyContentType());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    @VisibleForTesting
    public static List<h> c(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String str : entry.getValue()) {
                    arrayList.add(new h(entry.getKey(), str));
                }
            }
        }
        return arrayList;
    }

    public static void d(HttpURLConnection httpURLConnection, o<?> oVar) {
        String str;
        switch (oVar.getMethod()) {
            case -1:
                byte[] postBody = oVar.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setRequestMethod("POST");
                    b(httpURLConnection, oVar, postBody);
                    return;
                }
                return;
            case 0:
                str = "GET";
                break;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                byte[] body = oVar.getBody();
                if (body != null) {
                    b(httpURLConnection, oVar, body);
                    return;
                }
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                byte[] body2 = oVar.getBody();
                if (body2 != null) {
                    b(httpURLConnection, oVar, body2);
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
                byte[] body3 = oVar.getBody();
                if (body3 != null) {
                    b(httpURLConnection, oVar, body3);
                    return;
                }
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
        httpURLConnection.setRequestMethod(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00df  */
    @Override // c.a.b.x.a
    public e a(o<?> oVar, Map<String, String> map) {
        Throwable th;
        SSLSocketFactory sSLSocketFactory;
        String url = oVar.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(oVar.getHeaders());
        b bVar = this.f2270a;
        if (bVar != null) {
            String a2 = bVar.a(url);
            if (a2 != null) {
                url = a2;
            } else {
                throw new IOException(c.a.a.a.a.o("URL blocked by rewriter: ", url));
            }
        }
        URL url2 = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url2.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int timeoutMs = oVar.getTimeoutMs();
        httpURLConnection.setConnectTimeout(timeoutMs);
        httpURLConnection.setReadTimeout(timeoutMs);
        boolean z = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if ("https".equals(url2.getProtocol()) && (sSLSocketFactory = this.f2271b) != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        try {
            for (String str : hashMap.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) hashMap.get(str));
            }
            d(httpURLConnection, oVar);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != -1) {
                if (!((oVar.getMethod() == 4 || (100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304) ? false : true)) {
                    e eVar = new e(responseCode, c(httpURLConnection.getHeaderFields()));
                    httpURLConnection.disconnect();
                    return eVar;
                }
                try {
                    return new e(responseCode, c(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new a(httpURLConnection));
                } catch (Throwable th2) {
                    th = th2;
                    z = true;
                    if (!z) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } else {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
        } catch (Throwable th3) {
            th = th3;
            if (!z) {
            }
            throw th;
        }
    }
}
