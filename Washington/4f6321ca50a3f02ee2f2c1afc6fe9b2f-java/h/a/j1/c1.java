package h.a.j1;

import h.a.j1.z0;
import h.a.n;
import h.a.v;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c1 implements Runnable {
    public final /* synthetic */ List b;
    public final /* synthetic */ z0 c;

    public c1(z0 z0Var, List list) {
        this.c = z0Var;
        this.b = list;
    }

    public void run() {
        n nVar = n.READY;
        List<v> unmodifiableList = Collections.unmodifiableList(new ArrayList(this.b));
        SocketAddress a = this.c.f3792l.a();
        z0.f fVar = this.c.f3792l;
        fVar.a = unmodifiableList;
        fVar.b();
        this.c.m = unmodifiableList;
        z zVar = null;
        if (this.c.u.a == nVar || this.c.u.a == n.CONNECTING) {
            z0.f fVar2 = this.c.f3792l;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 < fVar2.a.size()) {
                    int indexOf = fVar2.a.get(i2).a.indexOf(a);
                    if (indexOf != -1) {
                        fVar2.b = i2;
                        fVar2.c = indexOf;
                        z = true;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            if (!z) {
                if (this.c.u.a == nVar) {
                    y1 y1Var = this.c.t;
                    this.c.t = null;
                    this.c.f3792l.b();
                    z0.h(this.c, n.IDLE);
                    zVar = y1Var;
                } else {
                    z0 z0Var = this.c;
                    z zVar2 = z0Var.s;
                    z0Var.s = null;
                    z0Var.f3792l.b();
                    z0.i(this.c);
                    zVar = zVar2;
                }
            }
        }
        if (zVar != null) {
            zVar.d(h.a.c1.n.g("InternalSubchannel closed transport due to address change"));
        }
    }
}
