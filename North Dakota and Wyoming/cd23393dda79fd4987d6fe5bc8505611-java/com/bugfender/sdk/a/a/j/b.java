package com.bugfender.sdk.a.a.j;

import com.bugfender.sdk.a.a.h.e;
import com.bugfender.sdk.a.a.h.g;
import com.bugfender.sdk.a.a.h.h;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface b {
    public static final Comparator<File> a = new a();
    public static final Pattern b = Pattern.compile("logs-([\\d]+)\\.json");

    static class a implements Comparator<File> {
        a() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            String name = file.getName();
            String name2 = file2.getName();
            Matcher matcher = b.b.matcher(name);
            Matcher matcher2 = b.b.matcher(name2);
            boolean matches = matcher.matches();
            boolean matches2 = matcher2.matches();
            if (matches && matches2) {
                return Long.valueOf(matcher.group(1)).compareTo(Long.valueOf(matcher2.group(1)));
            } else if (!matches && !matches2) {
                throw new IllegalStateException("Log file doesn't comply to log-TIMESTAMP.json");
            } else if (name.equals("logs")) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    List<h> a();

    List<File> a(long j, Comparator<File> comparator);

    void a(long j, long j2);

    void a(h hVar);

    boolean a(long j);

    c<e> b();

    c<String> b(h hVar);

    List<File> b(long j);

    h c();

    c<g> c(h hVar);

    boolean c(long j);

    long d();

    c<e> d(h hVar);

    void d(long j);

    c<String> e();

    c<g> f();

    List<h> g();
}
