package com.bugfender.sdk.a.d;

import android.content.Context;
import android.util.Log;
import com.bugfender.sdk.a.a.e.b;
import com.bugfender.sdk.a.a.h.e;
import com.bugfender.sdk.a.a.h.g;
import com.bugfender.sdk.a.a.h.h;
import com.bugfender.sdk.a.a.j.d;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class a implements com.bugfender.sdk.a.a.j.b {
    private static final String q = "session.json";
    private static final String r = "bugfender";
    private static final String s = "logs";
    private static final String t = "issues";
    private static final String u = "crashes";
    private final Context c;
    private final com.bugfender.sdk.a.a.c.f.b d;
    private final com.bugfender.sdk.a.a.c.f.a e;
    private final com.bugfender.sdk.a.a.c.a<g, String> f;
    private final com.bugfender.sdk.a.a.c.a<File, List<g>> g;
    private final com.bugfender.sdk.a.a.c.a<e, String> h;
    private final com.bugfender.sdk.a.a.c.a<File, List<e>> i;
    private final com.bugfender.sdk.a.a.c.a<String, String> j = new com.bugfender.sdk.a.a.c.c();
    private final com.bugfender.sdk.a.a.c.a<File, List<String>> k = new com.bugfender.sdk.a.a.c.b();
    private com.bugfender.sdk.a.a.j.c<g> l;
    private com.bugfender.sdk.a.a.j.c<e> m;
    private com.bugfender.sdk.a.a.j.c<String> n;
    private File o;
    private File p;

    /* access modifiers changed from: package-private */
    /* renamed from: com.bugfender.sdk.a.d.a$a  reason: collision with other inner class name */
    public class C0021a implements FileFilter {
        C0021a() {
        }

        public boolean accept(File file) {
            return file.isDirectory() && file.getName().equalsIgnoreCase(a.s);
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends b.a {
        b(File[] fileArr) {
            super(fileArr);
        }

        @Override // com.bugfender.sdk.a.a.e.b.a
        public int a(File file, Long l, File file2, Long l2) {
            return l.compareTo(l2);
        }
    }

    /* access modifiers changed from: package-private */
    public class c extends b.a {
        c(File[] fileArr) {
            super(fileArr);
        }

        @Override // com.bugfender.sdk.a.a.e.b.a
        public int a(File file, Long l, File file2, Long l2) {
            return l.compareTo(l2);
        }
    }

    public a(Context context, com.bugfender.sdk.a.a.c.f.b bVar, com.bugfender.sdk.a.a.c.f.a aVar, com.bugfender.sdk.a.a.c.e.b bVar2, com.bugfender.sdk.a.a.c.e.a aVar2, com.bugfender.sdk.a.a.c.d.b bVar3, com.bugfender.sdk.a.a.c.d.a aVar3) {
        this.c = context;
        this.d = bVar;
        this.e = aVar;
        this.f = bVar2;
        this.g = aVar2;
        this.h = bVar3;
        this.i = aVar3;
    }

    private static int b(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }

    private <T> List<T> f(h hVar) {
        return Collections.emptyList();
    }

    private File h() {
        return this.c.getDir(r, 0);
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public void a(h hVar) {
        File h2 = h();
        if (h2.exists()) {
            String str = "session-" + hVar.f();
            File file = new File(h2, str);
            this.o = file;
            if (file.mkdir()) {
                this.p = new File(this.o, q);
                com.bugfender.sdk.a.a.e.b.a(this.p, this.d.b(hVar));
                File file2 = new File(this.o, s);
                if (file2.mkdir()) {
                    this.l = new com.bugfender.sdk.a.a.j.c<>(this.f, this.g, file2, s);
                    File file3 = new File(this.o, t);
                    if (file3.mkdir()) {
                        this.m = new com.bugfender.sdk.a.a.j.c<>(this.h, this.i, file3, t);
                        File file4 = new File(this.o, u);
                        if (file4.mkdir()) {
                            this.n = new com.bugfender.sdk.a.a.j.c<>(this.j, this.k, file4, u);
                            return;
                        }
                        throw new com.bugfender.sdk.a.a.d.b.f.a("Crashes folder: " + file4.getName() + " couldn't create the crashes folder.");
                    }
                    throw new com.bugfender.sdk.a.a.d.b.f.a("Session folder: " + this.o.getName() + " couldn't create the issue folder.");
                }
                throw new com.bugfender.sdk.a.a.d.b.f.a("Session folder: " + this.o.getName() + " couldn't create the log folder.");
            }
            throw new com.bugfender.sdk.a.a.d.b.f.a("Session with name: " + str + " couldn't create the session folder.");
        }
        throw new com.bugfender.sdk.a.a.d.b.f.a("Bugfender folder doesn't exist and it couldn't be created");
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public List<File> b(long j2) {
        return a(j2, (Comparator<File>) null);
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public boolean c(long j2) {
        return com.bugfender.sdk.a.a.e.b.b(new File(e(j2), u));
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public void d(long j2) {
        h c2 = c();
        c2.a(j2);
        com.bugfender.sdk.a.a.e.b.b(this.p, this.d.b(c2));
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public com.bugfender.sdk.a.a.j.c<String> e() {
        return this.n;
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public List<h> g() {
        h c2 = c();
        List<h> a = a();
        if (a.isEmpty()) {
            return Collections.singletonList(c2);
        }
        a.add(a.size(), c2);
        return a;
    }

    private File e(h hVar) {
        File e2 = e(hVar.f());
        if (e2 != null && e2.exists()) {
            return e2;
        }
        String str = "The old session with local-sessionId: " + hVar.f() + " couldn't be opened.";
        Log.e(com.bugfender.sdk.a.a.b.E, str);
        throw new FileNotFoundException(str);
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public com.bugfender.sdk.a.a.j.c<String> b(h hVar) {
        try {
            return new com.bugfender.sdk.a.a.j.c<>(this.j, this.k, a(e(hVar), u), u);
        } catch (FileNotFoundException e2) {
            throw new d(e2);
        }
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public com.bugfender.sdk.a.a.j.c<g> f() {
        return this.l;
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public h c() {
        if (this.p != null) {
            this.p = new File(this.o, q);
        }
        return this.e.b(this.p);
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public long d() {
        return a(h());
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public com.bugfender.sdk.a.a.j.c<e> d(h hVar) {
        try {
            return new com.bugfender.sdk.a.a.j.c<>(this.h, this.i, a(e(hVar), t), t);
        } catch (FileNotFoundException e2) {
            throw new d(e2);
        }
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public com.bugfender.sdk.a.a.j.c<e> b() {
        return this.m;
    }

    private File e(long j2) {
        File h2 = h();
        File file = new File(h2, "session-" + j2);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public com.bugfender.sdk.a.a.j.c<g> c(h hVar) {
        try {
            return new com.bugfender.sdk.a.a.j.c<>(this.f, this.g, a(e(hVar), s), s);
        } catch (FileNotFoundException e2) {
            throw new d(e2);
        }
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public void a(long j2, long j3) {
        File file = new File(e(j2), q);
        h a = this.e.b(file);
        a.a(j3);
        com.bugfender.sdk.a.a.e.b.b(file, this.d.b(a));
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public List<File> a(long j2, Comparator<File> comparator) {
        File[] listFiles = e(j2).listFiles(new C0021a());
        if (listFiles.length <= 0) {
            return Collections.emptyList();
        }
        File[] listFiles2 = listFiles[0].listFiles();
        a(listFiles2, comparator);
        return Arrays.asList(listFiles2);
    }

    private void a(File[] fileArr, Comparator<File> comparator) {
        if (comparator == null) {
            com.bugfender.sdk.a.a.e.b.a(fileArr, new b(fileArr));
        } else {
            Arrays.sort(fileArr, comparator);
        }
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public boolean a(long j2) {
        return com.bugfender.sdk.a.a.e.b.a(e(j2));
    }

    @Override // com.bugfender.sdk.a.a.j.b
    public List<h> a() {
        File h2 = h();
        h c2 = c();
        ArrayList arrayList = new ArrayList();
        File[] listFiles = h2.listFiles();
        com.bugfender.sdk.a.a.e.b.a(listFiles, new c(listFiles));
        for (File file : listFiles) {
            if (file.isDirectory() && !file.getName().contains(String.valueOf(c2.f()))) {
                File[] listFiles2 = file.listFiles();
                for (File file2 : listFiles2) {
                    if (file2.getName().equalsIgnoreCase(q)) {
                        h a = this.e.b(file2);
                        if (a != null) {
                            arrayList.add(a);
                        } else {
                            com.bugfender.sdk.a.a.e.b.a(file);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private long a(File file) {
        long j2;
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j3 = 0;
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                j2 = file2.length();
            } else {
                j2 = a(file2);
            }
            j3 += j2;
        }
        return j3;
    }

    private File a(File file, String str) {
        File[] listFiles = file.listFiles();
        for (File file2 : listFiles) {
            if (file2.isDirectory() && file2.getName().contains(str)) {
                return file2;
            }
        }
        String str2 = "The " + str + " folder inside the session folder: " + file.getName() + " couldn't be opened.";
        Log.e(com.bugfender.sdk.a.a.b.E, str2);
        throw new FileNotFoundException(str2);
    }
}
