package e.s;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h {

    /* renamed from: i  reason: collision with root package name */
    public static final Pattern f1844i = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    public final ArrayList<String> a = new ArrayList<>();
    public final Map<String, b> b = new HashMap();
    public Pattern c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1845d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1846e = false;

    /* renamed from: f  reason: collision with root package name */
    public final String f1847f;

    /* renamed from: g  reason: collision with root package name */
    public Pattern f1848g = null;

    /* renamed from: h  reason: collision with root package name */
    public final String f1849h;

    public static class a implements Comparable<a> {
        public String b;
        public String c;

        public a(String str) {
            String[] split = str.split("/", -1);
            this.b = split[0];
            this.c = split[1];
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            int i2 = this.b.equals(aVar.b) ? 2 : 0;
            return this.c.equals(aVar.c) ? i2 + 1 : i2;
        }
    }

    public static class b {
        public String a;
        public ArrayList<String> b = new ArrayList<>();
    }

    public h(String str, String str2, String str3) {
        this.f1847f = str2;
        this.f1849h = str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            int i2 = 1;
            this.f1846e = parse.getQuery() != null;
            StringBuilder sb = new StringBuilder("^");
            if (!f1844i.matcher(str).find()) {
                sb.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.f1846e) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    a(str.substring(0, matcher.start()), sb, compile);
                }
                this.f1845d = false;
                for (String str4 : parse.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(str4);
                    Matcher matcher2 = compile.matcher(queryParameter);
                    b bVar = new b();
                    int i3 = 0;
                    while (matcher2.find()) {
                        bVar.b.add(matcher2.group(i2));
                        sb2.append(Pattern.quote(queryParameter.substring(i3, matcher2.start())));
                        sb2.append("(.+?)?");
                        i3 = matcher2.end();
                        i2 = 1;
                    }
                    if (i3 < queryParameter.length()) {
                        sb2.append(Pattern.quote(queryParameter.substring(i3)));
                    }
                    bVar.a = sb2.toString().replace(".*", "\\E.*\\Q");
                    this.b.put(str4, bVar);
                    i2 = 1;
                }
            } else {
                this.f1845d = a(str, sb, compile);
            }
            this.c = Pattern.compile(sb.toString().replace(".*", "\\E.*\\Q"));
        }
        if (str3 == null) {
            return;
        }
        if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
            a aVar = new a(str3);
            StringBuilder h2 = f.a.a.a.a.h("^(");
            h2.append(aVar.b);
            h2.append("|[*]+)/(");
            h2.append(aVar.c);
            h2.append("|[*]+)$");
            this.f1848g = Pattern.compile(h2.toString().replace("*|[*]", "[\\s\\S]"));
            return;
        }
        throw new IllegalArgumentException(f.a.a.a.a.c("The given mimeType ", str3, " does not match to required \"type/subtype\" format"));
    }

    public final boolean a(String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z = !str.contains(".*");
        int i2 = 0;
        while (matcher.find()) {
            this.a.add(matcher.group(1));
            sb.append(Pattern.quote(str.substring(i2, matcher.start())));
            sb.append("(.+?)");
            i2 = matcher.end();
            z = false;
        }
        if (i2 < str.length()) {
            sb.append(Pattern.quote(str.substring(i2)));
        }
        sb.append("($|(\\?(.)*))");
        return z;
    }

    public final boolean b(Bundle bundle, String str, String str2, d dVar) {
        if (dVar != null) {
            p pVar = dVar.a;
            try {
                pVar.d(bundle, str, pVar.c(str2));
                return false;
            } catch (IllegalArgumentException unused) {
                return true;
            }
        } else {
            bundle.putString(str, str2);
            return false;
        }
    }
}
