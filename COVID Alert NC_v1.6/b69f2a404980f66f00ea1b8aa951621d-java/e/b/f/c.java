package e.b.f;

import c.a.b.o;
import e.b.a;
import e.b.e;
import e.b.h.f;
import e.b.i.g;
import e.b.i.j;
import e.b.i.n;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class c implements e.b.a {

    /* renamed from: a  reason: collision with root package name */
    public a.d f4810a = new C0114c();

    /* renamed from: b  reason: collision with root package name */
    public a.e f4811b = new d();

    public static abstract class b<T extends a.AbstractC0113a> implements a.AbstractC0113a<T> {

        /* renamed from: a  reason: collision with root package name */
        public URL f4812a;

        /* renamed from: b  reason: collision with root package name */
        public a.c f4813b;

        /* renamed from: c  reason: collision with root package name */
        public Map<String, List<String>> f4814c = new LinkedHashMap();

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String> f4815d = new LinkedHashMap();

        public b() {
        }

        public b(a aVar) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0051 A[Catch:{ UnsupportedEncodingException -> 0x0090 }] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0087 A[Catch:{ UnsupportedEncodingException -> 0x0090 }] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0088 A[Catch:{ UnsupportedEncodingException -> 0x0090 }] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0084 A[SYNTHETIC] */
        public T a(String str, String str2) {
            int length;
            int i;
            c.b.a.a.c.n.c.H1(str);
            if (str2 == null) {
                str2 = "";
            }
            c.b.a.a.c.n.c.H1(str);
            List<String> c2 = c(str);
            if (c2.isEmpty()) {
                c2 = new ArrayList<>();
                this.f4814c.put(str, c2);
            }
            try {
                byte[] bytes = str2.getBytes("ISO-8859-1");
                boolean z = false;
                int i2 = 3;
                if (bytes.length >= 3 && (bytes[0] & 255) == 239) {
                    if (((bytes[1] & 255) == 187) && ((bytes[2] & 255) == 191)) {
                        length = bytes.length;
                        loop0:
                        while (true) {
                            if (i2 < length) {
                                z = true;
                                break;
                            }
                            byte b2 = bytes[i2];
                            if ((b2 & 128) != 0) {
                                if ((b2 & 224) != 192) {
                                    if ((b2 & 240) != 224) {
                                        if ((b2 & 248) != 240) {
                                            break;
                                        }
                                        i = i2 + 3;
                                    } else {
                                        i = i2 + 2;
                                    }
                                } else {
                                    i = i2 + 1;
                                }
                                if (i >= bytes.length) {
                                    break;
                                }
                                while (i2 < i) {
                                    i2++;
                                    if ((bytes[i2] & 192) != 128) {
                                        break loop0;
                                    }
                                }
                                continue;
                            }
                            i2++;
                        }
                        if (!z) {
                            str2 = new String(bytes, o.DEFAULT_PARAMS_ENCODING);
                        }
                        c2.add(str2);
                        return this;
                    }
                }
                i2 = 0;
                length = bytes.length;
                loop0:
                while (true) {
                    if (i2 < length) {
                    }
                    i2++;
                }
                if (!z) {
                }
            } catch (UnsupportedEncodingException unused) {
            }
            c2.add(str2);
            return this;
        }

        public T b(String str, String str2) {
            c.b.a.a.c.n.c.I1(str, "Cookie name must not be empty");
            c.b.a.a.c.n.c.K1(str2, "Cookie value must not be null");
            this.f4815d.put(str, str2);
            return this;
        }

        public final List<String> c(String str) {
            c.b.a.a.c.n.c.J1(str);
            for (Map.Entry<String, List<String>> entry : this.f4814c.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
            return Collections.emptyList();
        }

        public boolean d(String str, String str2) {
            c.b.a.a.c.n.c.H1(str);
            c.b.a.a.c.n.c.H1(str2);
            c.b.a.a.c.n.c.H1(str);
            for (String str3 : c(str)) {
                if (str2.equalsIgnoreCase(str3)) {
                    return true;
                }
            }
            return false;
        }

        public String e(String str) {
            c.b.a.a.c.n.c.K1(str, "Header name must not be null");
            List<String> c2 = c(str);
            if (c2.size() > 0) {
                return e.b.g.b.h(c2, ", ");
            }
            return null;
        }

        public T f(String str, String str2) {
            c.b.a.a.c.n.c.I1(str, "Header name must not be empty");
            g(str);
            a(str, str2);
            return this;
        }

        public T g(String str) {
            Map.Entry<String, List<String>> entry;
            c.b.a.a.c.n.c.I1(str, "Header name must not be empty");
            String C1 = c.b.a.a.c.n.c.C1(str);
            Iterator<Map.Entry<String, List<String>>> it = this.f4814c.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    entry = null;
                    break;
                }
                entry = it.next();
                if (c.b.a.a.c.n.c.C1(entry.getKey()).equals(C1)) {
                    break;
                }
            }
            if (entry != null) {
                this.f4814c.remove(entry.getKey());
            }
            return this;
        }

        public T h(URL url) {
            c.b.a.a.c.n.c.K1(url, "URL must not be null");
            this.f4812a = url;
            return this;
        }
    }

    /* renamed from: e.b.f.c$c  reason: collision with other inner class name */
    public static class C0114c extends b<a.d> implements a.d {

        /* renamed from: e  reason: collision with root package name */
        public int f4816e = 30000;
        public int f = 2097152;
        public boolean g = true;
        public Collection<a.b> h = new ArrayList();
        public String i = null;
        public boolean j = false;
        public boolean k = false;
        public g l;
        public boolean m = false;
        public String n = o.DEFAULT_PARAMS_ENCODING;

        public C0114c() {
            super(null);
            this.f4813b = a.c.GET;
            a("Accept-Encoding", "gzip");
            a("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
            this.l = new g(new e.b.i.b());
        }
    }

    public static class d extends b<a.e> implements a.e {
        public static final Pattern n = Pattern.compile("(application|text)/\\w*\\+?xml.*");

        /* renamed from: e  reason: collision with root package name */
        public ByteBuffer f4817e;
        public InputStream f;
        public HttpURLConnection g;
        public String h;
        public String i;
        public boolean j = false;
        public boolean k = false;
        public int l = 0;
        public a.d m;

        public d() {
            super(null);
        }

        public d(d dVar) {
            super(null);
            if (dVar != null) {
                int i2 = dVar.l + 1;
                this.l = i2;
                if (i2 >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", dVar.f4812a));
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:146:0x03c2  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0198  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x01a3  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x01f7  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0226 A[Catch:{ IOException -> 0x03be }] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x024a A[Catch:{ IOException -> 0x03bb }] */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x02ca A[Catch:{ IOException -> 0x03bb }] */
        public static d i(a.d dVar, d dVar2) {
            String str;
            HttpURLConnection httpURLConnection;
            d dVar3;
            IOException e2;
            int responseCode;
            d dVar4;
            InputStream inputStream;
            String str2;
            StringBuilder sb;
            boolean z;
            boolean z2;
            c.b.a.a.c.n.c.K1(dVar, "Request must not be null");
            b bVar = (b) dVar;
            c.b.a.a.c.n.c.K1(bVar.f4812a, "URL must be specified to connect");
            String protocol = bVar.f4812a.getProtocol();
            if (protocol.equals("http") || protocol.equals("https")) {
                boolean z3 = bVar.f4813b.f4801b;
                C0114c cVar = (C0114c) dVar;
                boolean z4 = true;
                boolean z5 = cVar.i != null;
                if (!z3) {
                    StringBuilder g2 = c.a.a.a.a.g("Cannot set a request body for HTTP method ");
                    g2.append(bVar.f4813b);
                    c.b.a.a.c.n.c.p1(z5, g2.toString());
                }
                if (cVar.h.size() > 0 && (!z3 || z5)) {
                    URL url = bVar.f4812a;
                    StringBuilder b2 = e.b.g.b.b();
                    b2.append(url.getProtocol());
                    b2.append("://");
                    b2.append(url.getAuthority());
                    b2.append(url.getPath());
                    b2.append("?");
                    if (url.getQuery() != null) {
                        b2.append(url.getQuery());
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    for (a.b bVar2 : cVar.h) {
                        c.b.a.a.c.n.c.p1(bVar2.b(), "InputStream data not supported in URL query string.");
                        if (!z2) {
                            b2.append('&');
                        } else {
                            z2 = false;
                        }
                        b2.append(URLEncoder.encode(bVar2.a(), o.DEFAULT_PARAMS_ENCODING));
                        b2.append('=');
                        b2.append(URLEncoder.encode(bVar2.value(), o.DEFAULT_PARAMS_ENCODING));
                    }
                    bVar.h(new URL(e.b.g.b.j(b2)));
                    cVar.h.clear();
                } else if (z3) {
                    c.b.a.a.c.n.c.I1("Content-Type", "Header name must not be empty");
                    if (!(!bVar.c("Content-Type").isEmpty())) {
                        Iterator<a.b> it = cVar.h.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().b()) {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            str = b.c();
                            sb = new StringBuilder();
                        } else {
                            StringBuilder g3 = c.a.a.a.a.g("application/x-www-form-urlencoded; charset=");
                            g3.append(cVar.n);
                            str2 = g3.toString();
                            str = null;
                            bVar.f("Content-Type", str2);
                            long nanoTime = System.nanoTime();
                            httpURLConnection = (HttpURLConnection) bVar.f4812a.openConnection();
                            httpURLConnection.setRequestMethod(bVar.f4813b.name());
                            httpURLConnection.setInstanceFollowRedirects(false);
                            httpURLConnection.setConnectTimeout(cVar.f4816e);
                            httpURLConnection.setReadTimeout(cVar.f4816e / 2);
                            if (bVar.f4813b.f4801b) {
                                httpURLConnection.setDoOutput(true);
                            }
                            if (bVar.f4815d.size() > 0) {
                                StringBuilder b3 = e.b.g.b.b();
                                for (Map.Entry<String, String> entry : bVar.f4815d.entrySet()) {
                                    if (!z4) {
                                        b3.append("; ");
                                    } else {
                                        z4 = false;
                                    }
                                    b3.append(entry.getKey());
                                    b3.append('=');
                                    b3.append(entry.getValue());
                                }
                                httpURLConnection.addRequestProperty("Cookie", e.b.g.b.j(b3));
                            }
                            for (Map.Entry<String, List<String>> entry2 : bVar.f4814c.entrySet()) {
                                for (String str3 : entry2.getValue()) {
                                    httpURLConnection.addRequestProperty(entry2.getKey(), str3);
                                }
                            }
                            httpURLConnection.connect();
                            if (httpURLConnection.getDoOutput()) {
                                l(dVar, httpURLConnection.getOutputStream(), str);
                            }
                            responseCode = httpURLConnection.getResponseCode();
                            dVar4 = new d(dVar2);
                            dVar4.k(httpURLConnection, dVar2);
                            dVar4.m = dVar;
                            c.b.a.a.c.n.c.I1("Location", "Header name must not be empty");
                            if (!(!dVar4.c("Location").isEmpty()) && ((C0114c) dVar).g) {
                                if (responseCode != 307) {
                                    a.c cVar2 = a.c.GET;
                                    c.b.a.a.c.n.c.K1(cVar2, "Method must not be null");
                                    ((b) dVar).f4813b = cVar2;
                                    ((C0114c) dVar).h.clear();
                                    ((C0114c) dVar).i = null;
                                    bVar.g("Content-Type");
                                }
                                String e3 = dVar4.e("Location");
                                if (e3.startsWith("http:/") && e3.charAt(6) != '/') {
                                    e3 = e3.substring(6);
                                }
                                bVar.h(c.a(e.b.g.b.l(((b) dVar).f4812a, e3)));
                                for (Map.Entry<String, String> entry3 : dVar4.f4815d.entrySet()) {
                                    bVar.b(entry3.getKey(), entry3.getValue());
                                }
                                return i(dVar, dVar4);
                            } else if ((responseCode >= 200 || responseCode >= 400) && !((C0114c) dVar).j) {
                                throw new e.b.b("HTTP error fetching URL", responseCode, ((b) dVar).f4812a.toString());
                            } else {
                                String str4 = dVar4.i;
                                if (str4 != null && !((C0114c) dVar).k && !str4.startsWith("text/")) {
                                    if (!n.matcher(str4).matches()) {
                                        throw new e("Unhandled content type. Must be text/*, application/xml, or application/*+xml", str4, ((b) dVar).f4812a.toString());
                                    }
                                }
                                if (str4 != null && n.matcher(str4).matches() && (dVar instanceof C0114c) && !((C0114c) dVar).m) {
                                    C0114c cVar3 = (C0114c) dVar;
                                    cVar3.l = new g(new n());
                                    cVar3.m = true;
                                }
                                dVar4.h = b.b(dVar4.i);
                                if (httpURLConnection.getContentLength() == 0 || ((b) dVar).f4813b == a.c.HEAD) {
                                    dVar4.f4817e = ByteBuffer.allocate(0);
                                } else {
                                    dVar4.f = null;
                                    dVar4.f = httpURLConnection.getErrorStream() != null ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
                                    if (dVar4.d("Content-Encoding", "gzip")) {
                                        inputStream = new GZIPInputStream(dVar4.f);
                                    } else {
                                        if (dVar4.d("Content-Encoding", "deflate")) {
                                            inputStream = new InflaterInputStream(dVar4.f, new Inflater(true));
                                        }
                                        e.b.g.a a2 = e.b.g.a.a(dVar4.f, 32768, ((C0114c) dVar).f);
                                        a2.f4820d = nanoTime;
                                        a2.f4821e = ((long) ((C0114c) dVar).f4816e) * 1000000;
                                        dVar4.f = a2;
                                    }
                                    dVar4.f = inputStream;
                                    e.b.g.a a22 = e.b.g.a.a(dVar4.f, 32768, ((C0114c) dVar).f);
                                    a22.f4820d = nanoTime;
                                    a22.f4821e = ((long) ((C0114c) dVar).f4816e) * 1000000;
                                    dVar4.f = a22;
                                }
                                dVar4.j = true;
                                return dVar4;
                            }
                        }
                    } else if (bVar.e("Content-Type").contains("multipart/form-data") && !bVar.e("Content-Type").contains("boundary")) {
                        str = b.c();
                        sb = new StringBuilder();
                    }
                    sb.append("multipart/form-data; boundary=");
                    sb.append(str);
                    str2 = sb.toString();
                    bVar.f("Content-Type", str2);
                    long nanoTime2 = System.nanoTime();
                    httpURLConnection = (HttpURLConnection) bVar.f4812a.openConnection();
                    httpURLConnection.setRequestMethod(bVar.f4813b.name());
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setConnectTimeout(cVar.f4816e);
                    httpURLConnection.setReadTimeout(cVar.f4816e / 2);
                    if (bVar.f4813b.f4801b) {
                    }
                    if (bVar.f4815d.size() > 0) {
                    }
                    while (r6.hasNext()) {
                    }
                    httpURLConnection.connect();
                    if (httpURLConnection.getDoOutput()) {
                    }
                    responseCode = httpURLConnection.getResponseCode();
                    dVar4 = new d(dVar2);
                    try {
                        dVar4.k(httpURLConnection, dVar2);
                        dVar4.m = dVar;
                        c.b.a.a.c.n.c.I1("Location", "Header name must not be empty");
                        if (!(!dVar4.c("Location").isEmpty())) {
                        }
                        if (responseCode >= 200) {
                        }
                        throw new e.b.b("HTTP error fetching URL", responseCode, ((b) dVar).f4812a.toString());
                    } catch (IOException e4) {
                        e2 = e4;
                        dVar3 = dVar4;
                        if (dVar3 != null) {
                            dVar3.j();
                        }
                        throw e2;
                    }
                }
                str = null;
                long nanoTime22 = System.nanoTime();
                httpURLConnection = (HttpURLConnection) bVar.f4812a.openConnection();
                httpURLConnection.setRequestMethod(bVar.f4813b.name());
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setConnectTimeout(cVar.f4816e);
                httpURLConnection.setReadTimeout(cVar.f4816e / 2);
                if (bVar.f4813b.f4801b) {
                }
                if (bVar.f4815d.size() > 0) {
                }
                while (r6.hasNext()) {
                }
                try {
                    httpURLConnection.connect();
                    if (httpURLConnection.getDoOutput()) {
                    }
                    responseCode = httpURLConnection.getResponseCode();
                    dVar4 = new d(dVar2);
                    dVar4.k(httpURLConnection, dVar2);
                    dVar4.m = dVar;
                    c.b.a.a.c.n.c.I1("Location", "Header name must not be empty");
                    if (!(!dVar4.c("Location").isEmpty())) {
                    }
                    if (responseCode >= 200) {
                    }
                    throw new e.b.b("HTTP error fetching URL", responseCode, ((b) dVar).f4812a.toString());
                } catch (IOException e5) {
                    e2 = e5;
                    dVar3 = null;
                    if (dVar3 != null) {
                    }
                    throw e2;
                }
            } else {
                throw new MalformedURLException("Only http & https protocols supported");
            }
        }

        public static void l(a.d dVar, OutputStream outputStream, String str) {
            C0114c cVar = (C0114c) dVar;
            Collection<a.b> collection = cVar.h;
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, cVar.n));
            if (str != null) {
                for (a.b bVar : collection) {
                    bufferedWriter.write("--");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    String a2 = bVar.a();
                    String str2 = null;
                    bufferedWriter.write(a2 == null ? null : a2.replace("\"", "%22"));
                    bufferedWriter.write("\"");
                    if (bVar.b()) {
                        bufferedWriter.write("; filename=\"");
                        String value = bVar.value();
                        if (value != null) {
                            str2 = value.replace("\"", "%22");
                        }
                        bufferedWriter.write(str2);
                        bufferedWriter.write("\"\r\nContent-Type: ");
                        bufferedWriter.write(bVar.c() != null ? bVar.c() : "application/octet-stream");
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.flush();
                        b.a(bVar.d(), outputStream);
                        outputStream.flush();
                    } else {
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.write(bVar.value());
                    }
                    bufferedWriter.write("\r\n");
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("--");
            } else {
                String str3 = cVar.i;
                if (str3 != null) {
                    bufferedWriter.write(str3);
                } else {
                    boolean z = true;
                    for (a.b bVar2 : collection) {
                        if (!z) {
                            bufferedWriter.append('&');
                        } else {
                            z = false;
                        }
                        bufferedWriter.write(URLEncoder.encode(bVar2.a(), cVar.n));
                        bufferedWriter.write(61);
                        bufferedWriter.write(URLEncoder.encode(bVar2.value(), cVar.n));
                    }
                }
            }
            bufferedWriter.close();
        }

        public final void j() {
            InputStream inputStream = this.f;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.f = null;
                    throw th;
                }
                this.f = null;
            }
            HttpURLConnection httpURLConnection = this.g;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                this.g = null;
            }
        }

        public final void k(HttpURLConnection httpURLConnection, d dVar) {
            this.g = httpURLConnection;
            this.f4813b = a.c.valueOf(httpURLConnection.getRequestMethod());
            this.f4812a = httpURLConnection.getURL();
            httpURLConnection.getResponseCode();
            httpURLConnection.getResponseMessage();
            this.i = httpURLConnection.getContentType();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i2 = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i2);
                String headerField = httpURLConnection.getHeaderField(i2);
                if (headerFieldKey == null && headerField == null) {
                    break;
                }
                i2++;
                if (!(headerFieldKey == null || headerField == null)) {
                    if (linkedHashMap.containsKey(headerFieldKey)) {
                        ((List) linkedHashMap.get(headerFieldKey)).add(headerField);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(headerField);
                        linkedHashMap.put(headerFieldKey, arrayList);
                    }
                }
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                if (str != null) {
                    List<String> list = (List) entry.getValue();
                    if (str.equalsIgnoreCase("Set-Cookie")) {
                        for (String str2 : list) {
                            if (str2 != null) {
                                j jVar = new j(str2);
                                String e2 = jVar.e("=");
                                jVar.h("=");
                                String trim = e2.trim();
                                String trim2 = jVar.e(";").trim();
                                if (trim.length() > 0) {
                                    b(trim, trim2);
                                }
                            }
                        }
                    }
                    for (String str3 : list) {
                        a(str, str3);
                    }
                }
            }
            if (dVar != null) {
                for (Map.Entry<String, String> entry2 : dVar.f4815d.entrySet()) {
                    String key = entry2.getKey();
                    c.b.a.a.c.n.c.I1(key, "Cookie name must not be empty");
                    if (!this.f4815d.containsKey(key)) {
                        b(entry2.getKey(), entry2.getValue());
                    }
                }
                dVar.j();
            }
        }
    }

    public static URL a(URL url) {
        try {
            return new URL(new URI(url.toExternalForm().replace(" ", "%20")).toASCIIString());
        } catch (MalformedURLException | URISyntaxException unused) {
            return url;
        }
    }

    public f b() {
        a.d dVar = this.f4810a;
        a.c cVar = a.c.GET;
        b bVar = (b) dVar;
        if (bVar != null) {
            c.b.a.a.c.n.c.K1(cVar, "Method must not be null");
            bVar.f4813b = cVar;
            d i = d.i(this.f4810a, null);
            this.f4811b = i;
            c.b.a.a.c.n.c.u1(i.j, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            if (i.f4817e != null) {
                i.f = new ByteArrayInputStream(i.f4817e.array());
                i.k = false;
            }
            c.b.a.a.c.n.c.p1(i.k, "Input stream already read and parsed, cannot re-read.");
            f d2 = b.d(i.f, i.h, i.f4812a.toExternalForm(), ((C0114c) i.m).l);
            i.h = d2.j.f4835c.name();
            i.k = true;
            i.j();
            return d2;
        }
        throw null;
    }
}
