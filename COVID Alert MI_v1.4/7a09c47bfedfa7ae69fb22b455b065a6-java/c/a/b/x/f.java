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
    public static final int HTTP_CONTINUE = 100;
    public final SSLSocketFactory mSslSocketFactory;
    public final b mUrlRewriter;

    public static class a extends FilterInputStream {

        /* renamed from: b  reason: collision with root package name */
        public final HttpURLConnection f2885b;

        public a(HttpURLConnection httpURLConnection) {
            super(f.inputStreamFromConnection(httpURLConnection));
            this.f2885b = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() {
            super.close();
            this.f2885b.disconnect();
        }
    }

    public interface b {
        String a(String str);
    }

    public f() {
        this(null);
    }

    public f(b bVar) {
        this(bVar, null);
    }

    public f(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.mUrlRewriter = bVar;
        this.mSslSocketFactory = sSLSocketFactory;
    }

    public static void addBody(HttpURLConnection httpURLConnection, o<?> oVar, byte[] bArr) {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", oVar.getBodyContentType());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    public static void addBodyIfExists(HttpURLConnection httpURLConnection, o<?> oVar) {
        byte[] body = oVar.getBody();
        if (body != null) {
            addBody(httpURLConnection, oVar, body);
        }
    }

    @VisibleForTesting
    public static List<h> convertHeaders(Map<String, List<String>> map) {
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

    public static boolean hasResponseBody(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    public static InputStream inputStreamFromConnection(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private HttpURLConnection openConnection(URL url, o<?> oVar) {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection createConnection = createConnection(url);
        int timeoutMs = oVar.getTimeoutMs();
        createConnection.setConnectTimeout(timeoutMs);
        createConnection.setReadTimeout(timeoutMs);
        createConnection.setUseCaches(false);
        createConnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.mSslSocketFactory) != null) {
            ((HttpsURLConnection) createConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        return createConnection;
    }

    public static void setConnectionParametersForRequest(HttpURLConnection httpURLConnection, o<?> oVar) {
        String str;
        String str2;
        switch (oVar.getMethod()) {
            case -1:
                byte[] postBody = oVar.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setRequestMethod("POST");
                    addBody(httpURLConnection, oVar, postBody);
                    return;
                }
                return;
            case 0:
                str = "GET";
                httpURLConnection.setRequestMethod(str);
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                addBodyIfExists(httpURLConnection, oVar);
                return;
            case 2:
                str2 = "PUT";
                httpURLConnection.setRequestMethod(str2);
                addBodyIfExists(httpURLConnection, oVar);
                return;
            case 3:
                str = "DELETE";
                httpURLConnection.setRequestMethod(str);
                return;
            case 4:
                str = "HEAD";
                httpURLConnection.setRequestMethod(str);
                return;
            case 5:
                str = "OPTIONS";
                httpURLConnection.setRequestMethod(str);
                return;
            case 6:
                str = "TRACE";
                httpURLConnection.setRequestMethod(str);
                return;
            case 7:
                str2 = "PATCH";
                httpURLConnection.setRequestMethod(str2);
                addBodyIfExists(httpURLConnection, oVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    public HttpURLConnection createConnection(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    @Override // c.a.b.x.a
    public e executeRequest(o<?> oVar, Map<String, String> map) {
        String url = oVar.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(oVar.getHeaders());
        b bVar = this.mUrlRewriter;
        if (bVar != null) {
            String a2 = bVar.a(url);
            if (a2 != null) {
                url = a2;
            } else {
                throw new IOException(c.a.a.a.a.q("URL blocked by rewriter: ", url));
            }
        }
        HttpURLConnection openConnection = openConnection(new URL(url), oVar);
        try {
            for (String str : hashMap.keySet()) {
                openConnection.setRequestProperty(str, (String) hashMap.get(str));
            }
            setConnectionParametersForRequest(openConnection, oVar);
            int responseCode = openConnection.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            } else if (hasResponseBody(oVar.getMethod(), responseCode)) {
                return new e(responseCode, convertHeaders(openConnection.getHeaderFields()), openConnection.getContentLength(), new a(openConnection));
            } else {
                e eVar = new e(responseCode, convertHeaders(openConnection.getHeaderFields()));
                openConnection.disconnect();
                return eVar;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                openConnection.disconnect();
            }
            throw th;
        }
    }
}
