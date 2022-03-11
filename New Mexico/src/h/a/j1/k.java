package h.a.j1;

import f.b.a.c.b.o.b;
import f.b.b.a.s;
import h.a.j1.t2;
import h.a.q0;
import h.a.s0;
import java.net.URI;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class k extends s0 {
    @Override // h.a.q0.c
    public String a() {
        return "dns";
    }

    @Override // h.a.q0.c
    public q0 b(URI uri, q0.a aVar) {
        boolean z;
        if (!"dns".equals(uri.getScheme())) {
            return null;
        }
        String path = uri.getPath();
        b.A(path, "targetPath");
        b.u(path.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", path, uri);
        String substring = path.substring(1);
        uri.getAuthority();
        t2.c<Executor> cVar = q0.m;
        s sVar = new s();
        try {
            Class.forName("android.app.Application", false, getClass().getClassLoader());
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        return new f0(substring, aVar, cVar, sVar, z, g0.f4194e);
    }

    @Override // h.a.s0
    public boolean c() {
        return true;
    }
}
