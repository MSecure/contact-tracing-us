package f.b.a.f.a.b;

import f.b.a.c.b.o.b;
import f.b.a.f.a.c.d;
import f.b.a.f.a.e.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
/* loaded from: classes.dex */
public final class v1 {

    /* renamed from: e */
    public static final a f3324e = new a("ExtractorTaskFinder");
    public final s1 a;
    public final d0 b;
    public final l0 c;

    /* renamed from: d */
    public final d f3325d;

    public v1(s1 s1Var, d0 d0Var, l0 l0Var, d dVar) {
        this.a = s1Var;
        this.b = d0Var;
        this.c = l0Var;
        this.f3325d = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b6, code lost:
        if (r0 == null) goto L_0x00c1;
     */
    /* JADX WARN: Removed duplicated region for block: B:165:0x028a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0270 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final u1 a() {
        u1 u1Var;
        boolean z;
        boolean z2;
        int i2;
        try {
            this.a.f3304f.lock();
            ArrayList arrayList = new ArrayList();
            for (p1 p1Var : this.a.f3303e.values()) {
                if (b.O1(p1Var.c.f3270d)) {
                    arrayList.add(p1Var);
                }
            }
            t0 t0Var = null;
            if (!arrayList.isEmpty()) {
                char c = 0;
                int i3 = 2;
                if (this.f3325d.a()) {
                    Map<String, Long> v = this.b.v();
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            u1Var = null;
                            break;
                        }
                        p1 p1Var2 = (p1) it.next();
                        Long l2 = (Long) ((HashMap) v).get(p1Var2.c.a);
                        if (l2 != null && p1Var2.c.b == l2.longValue()) {
                            f3324e.a("Found promote pack task for session %s with pack %s.", Integer.valueOf(p1Var2.a), p1Var2.c.a);
                            int i4 = p1Var2.a;
                            String str = p1Var2.c.a;
                            u1Var = new t2(i4, str, (int) d0.d(this.b.e(str), true), p1Var2.b, p1Var2.c.b);
                            break;
                        }
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        u1Var = null;
                        break;
                    }
                    p1 p1Var3 = (p1) it2.next();
                    try {
                        d0 d0Var = this.b;
                        o1 o1Var = p1Var3.c;
                        if (d0Var.k(o1Var.a, p1Var3.b, o1Var.b) == p1Var3.c.f3272f.size()) {
                            f3324e.a("Found final move task for session %s with pack %s.", Integer.valueOf(p1Var3.a), p1Var3.c.a);
                            int i5 = p1Var3.a;
                            o1 o1Var2 = p1Var3.c;
                            u1Var = new h2(i5, o1Var2.a, p1Var3.b, o1Var2.b, o1Var2.c);
                            break;
                        }
                    } catch (IOException e2) {
                        throw new z0(String.format("Failed to check number of completed merges for session %s, pack %s", Integer.valueOf(p1Var3.a), p1Var3.c.a), e2, p1Var3.a);
                    }
                }
                if (u1Var == null) {
                    Iterator it3 = arrayList.iterator();
                    loop3: while (true) {
                        if (!it3.hasNext()) {
                            u1Var = null;
                            break;
                        }
                        p1 p1Var4 = (p1) it3.next();
                        if (b.O1(p1Var4.c.f3270d)) {
                            for (q1 q1Var : p1Var4.c.f3272f) {
                                d0 d0Var2 = this.b;
                                o1 o1Var3 = p1Var4.c;
                                if (d0Var2.t(o1Var3.a, p1Var4.b, o1Var3.b, q1Var.a).exists()) {
                                    f3324e.a("Found merge task for session %s with pack %s and slice %s.", Integer.valueOf(p1Var4.a), p1Var4.c.a, q1Var.a);
                                    int i6 = p1Var4.a;
                                    o1 o1Var4 = p1Var4.c;
                                    u1Var = new e2(i6, o1Var4.a, p1Var4.b, o1Var4.b, q1Var.a);
                                    break loop3;
                                }
                            }
                            continue;
                        }
                    }
                    if (u1Var == null) {
                        Iterator it4 = arrayList.iterator();
                        loop5: while (true) {
                            if (!it4.hasNext()) {
                                u1Var = null;
                                break;
                            }
                            p1 p1Var5 = (p1) it4.next();
                            if (b.O1(p1Var5.c.f3270d)) {
                                for (q1 q1Var2 : p1Var5.c.f3272f) {
                                    if (b(p1Var5, q1Var2)) {
                                        d0 d0Var3 = this.b;
                                        o1 o1Var5 = p1Var5.c;
                                        if (d0Var3.s(o1Var5.a, p1Var5.b, o1Var5.b, q1Var2.a).exists()) {
                                            f3324e.a("Found verify task for session %s with pack %s and slice %s.", Integer.valueOf(p1Var5.a), p1Var5.c.a, q1Var2.a);
                                            int i7 = p1Var5.a;
                                            o1 o1Var6 = p1Var5.c;
                                            u1Var = new b3(i7, o1Var6.a, p1Var5.b, o1Var6.b, q1Var2.a, q1Var2.b);
                                            break loop5;
                                        }
                                    }
                                }
                                continue;
                            }
                        }
                        if (u1Var == null) {
                            Iterator it5 = arrayList.iterator();
                            loop7: while (true) {
                                char c2 = 4;
                                if (!it5.hasNext()) {
                                    t0Var = null;
                                    break;
                                }
                                p1 p1Var6 = (p1) it5.next();
                                if (b.O1(p1Var6.c.f3270d)) {
                                    Iterator<q1> it6 = p1Var6.c.f3272f.iterator();
                                    while (it6.hasNext()) {
                                        q1 next = it6.next();
                                        int i8 = next.f3278f;
                                        if (!(i8 == 1 || i8 == i3)) {
                                            z2 = false;
                                            if (z2) {
                                                d0 d0Var4 = this.b;
                                                o1 o1Var7 = p1Var6.c;
                                                try {
                                                    i2 = new y2(d0Var4, o1Var7.a, p1Var6.b, o1Var7.b, next.a).a();
                                                } catch (IOException e3) {
                                                    a aVar = f3324e;
                                                    Object[] objArr = new Object[1];
                                                    objArr[c] = e3;
                                                    aVar.b("Slice checkpoint corrupt, restarting extraction. %s", objArr);
                                                    i2 = 0;
                                                }
                                                if (i2 != -1 && next.f3276d.get(i2).a) {
                                                    a aVar2 = f3324e;
                                                    Object[] objArr2 = new Object[5];
                                                    objArr2[c] = Integer.valueOf(next.f3277e);
                                                    objArr2[1] = Integer.valueOf(p1Var6.a);
                                                    objArr2[i3] = p1Var6.c.a;
                                                    objArr2[3] = next.a;
                                                    objArr2[c2] = Integer.valueOf(i2);
                                                    aVar2.a("Found extraction task using compression format %s for session %s, pack %s, slice %s, chunk %s.", objArr2);
                                                    InputStream a = this.c.a(p1Var6.a, p1Var6.c.a, next.a, i2);
                                                    int i9 = p1Var6.a;
                                                    o1 o1Var8 = p1Var6.c;
                                                    String str2 = o1Var8.a;
                                                    int i10 = p1Var6.b;
                                                    long j2 = o1Var8.b;
                                                    String str3 = o1Var8.c;
                                                    String str4 = next.a;
                                                    int i11 = next.f3277e;
                                                    int size = next.f3276d.size();
                                                    o1 o1Var9 = p1Var6.c;
                                                    t0Var = new t0(i9, str2, i10, j2, str3, str4, i11, i2, size, o1Var9.f3271e, o1Var9.f3270d, a);
                                                    break loop7;
                                                }
                                                it6 = it6;
                                                c2 = 4;
                                                c = 0;
                                                i3 = 2;
                                            }
                                        }
                                        z2 = true;
                                        if (z2) {
                                        }
                                    }
                                    continue;
                                }
                            }
                            if (t0Var == null) {
                                Iterator it7 = arrayList.iterator();
                                loop9: while (true) {
                                    if (!it7.hasNext()) {
                                        u1Var = null;
                                        break;
                                    }
                                    p1 p1Var7 = (p1) it7.next();
                                    if (b.O1(p1Var7.c.f3270d)) {
                                        for (q1 q1Var3 : p1Var7.c.f3272f) {
                                            int i12 = q1Var3.f3278f;
                                            if (!(i12 == 1 || i12 == 2)) {
                                                z = false;
                                                if (!(z || !q1Var3.f3276d.get(0).a || b(p1Var7, q1Var3))) {
                                                    f3324e.a("Found patch slice task using patch format %s for session %s, pack %s, slice %s.", Integer.valueOf(q1Var3.f3278f), Integer.valueOf(p1Var7.a), p1Var7.c.a, q1Var3.a);
                                                    InputStream a2 = this.c.a(p1Var7.a, p1Var7.c.a, q1Var3.a, 0);
                                                    int i13 = p1Var7.a;
                                                    String str5 = p1Var7.c.a;
                                                    u1Var = new q2(i13, str5, (int) d0.d(this.b.e(str5), true), this.b.l(p1Var7.c.a), p1Var7.b, p1Var7.c.b, q1Var3.f3278f, q1Var3.a, q1Var3.c, a2);
                                                    break loop9;
                                                }
                                            }
                                            z = true;
                                            if (z) {
                                            }
                                        }
                                        continue;
                                    }
                                }
                                if (u1Var == null) {
                                    this.a.f3304f.unlock();
                                    return null;
                                }
                            }
                        }
                    }
                }
                return u1Var;
            }
            return t0Var;
        } finally {
            this.a.f3304f.unlock();
        }
    }

    public final boolean b(p1 p1Var, q1 q1Var) {
        d0 d0Var = this.b;
        o1 o1Var = p1Var.c;
        File q = d0Var.q(o1Var.a, p1Var.b, o1Var.b, q1Var.a);
        if (q.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(q);
                Properties properties = new Properties();
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") == null) {
                    y2.f3343h.b("Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
                } else if (Integer.parseInt(properties.getProperty("fileStatus")) == 4) {
                    return true;
                }
            } catch (IOException e2) {
                y2.f3343h.b("Could not read checkpoint while checking if extraction finished. %s", e2);
            }
        }
        return false;
    }
}
