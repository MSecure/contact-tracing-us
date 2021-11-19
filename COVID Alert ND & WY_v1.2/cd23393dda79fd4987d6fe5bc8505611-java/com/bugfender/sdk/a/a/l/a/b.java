package com.bugfender.sdk.a.a.l.a;

import com.bugfender.sdk.a.a.e.g.a;
import com.bugfender.sdk.a.a.h.g;
import com.bugfender.sdk.a.a.h.h;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class b implements Callable<Boolean> {
    public static final Pattern e = Pattern.compile("\\{\"bf_start_date\":(\\d+),\"bf_end_date\":(\\d+)\\}");
    private final com.bugfender.sdk.a.a.j.b a;
    private final long b;
    private final com.bugfender.sdk.a.a.c.e.b c = new com.bugfender.sdk.a.a.c.e.b();
    private final AtomicLong d;

    public b(com.bugfender.sdk.a.a.j.b bVar, long j, AtomicLong atomicLong) {
        this.a = bVar;
        this.b = j;
        this.d = atomicLong;
    }

    private boolean a(h hVar, List<h> list) {
        for (h hVar2 : list) {
            long f = hVar2.f();
            List<File> a2 = this.a.a(f, com.bugfender.sdk.a.a.j.b.a);
            if (!a2.isEmpty()) {
                File file = a2.get(0);
                a aVar = new a(file, com.bugfender.sdk.a.a.e.g.b.a);
                String b2 = aVar.b();
                aVar.close();
                if (b2 != null) {
                    String str = "";
                    if (!b2.equals(str)) {
                        g a3 = this.c.a(b2);
                        if (a3 == null) {
                            return file.delete();
                        }
                        if (a3.h() != null) {
                            str = a3.h();
                        }
                        Matcher matcher = e.matcher(str);
                        if (!matcher.matches()) {
                            a(file, b2, null);
                            return true;
                        } else if (a2.size() > 1) {
                            a(a2.get(1), b2, Long.valueOf(new Date(Long.valueOf(matcher.group(1)).longValue()).getTime()));
                            return file.delete();
                        }
                    }
                }
                return file.delete();
            } else if (f != hVar.f()) {
                this.a.a(f);
            }
        }
        return true;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() {
        while (a()) {
            a(this.a.c(), this.a.g());
        }
        return true;
    }

    private void a(File file, String str, Long l) {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String readLine = bufferedReader.readLine();
        bufferedReader.close();
        if (l == null) {
            l = Long.valueOf(this.c.a(readLine).b().getTime());
        }
        long time = this.c.a(str).b().getTime();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bf_start_date", l);
        jSONObject.put("bf_end_date", time);
        String a2 = this.c.b(new g.b().a(this.d.getAndIncrement()).a(new Date()).a(g.c.D.a()).b(0).e("").f("").c("bf_gap_log").a("").d(jSONObject.toString()).a());
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(a2);
        printWriter.close();
    }

    private boolean a() {
        return this.a.d() >= this.b;
    }
}
