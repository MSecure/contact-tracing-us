package e.g.b.h.l;

import java.util.ArrayList;
import java.util.List;

public class f implements d {
    public d a = null;
    public boolean b = false;
    public boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    public o f1312d;

    /* renamed from: e  reason: collision with root package name */
    public a f1313e = a.UNKNOWN;

    /* renamed from: f  reason: collision with root package name */
    public int f1314f;

    /* renamed from: g  reason: collision with root package name */
    public int f1315g;

    /* renamed from: h  reason: collision with root package name */
    public int f1316h = 1;

    /* renamed from: i  reason: collision with root package name */
    public g f1317i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1318j = false;

    /* renamed from: k  reason: collision with root package name */
    public List<d> f1319k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public List<f> f1320l = new ArrayList();

    public enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(o oVar) {
        this.f1312d = oVar;
    }

    @Override // e.g.b.h.l.d
    public void a(d dVar) {
        for (f fVar : this.f1320l) {
            if (!fVar.f1318j) {
                return;
            }
        }
        this.c = true;
        d dVar2 = this.a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.b) {
            this.f1312d.a(this);
            return;
        }
        f fVar2 = null;
        int i2 = 0;
        for (f fVar3 : this.f1320l) {
            if (!(fVar3 instanceof g)) {
                i2++;
                fVar2 = fVar3;
            }
        }
        if (fVar2 != null && i2 == 1 && fVar2.f1318j) {
            g gVar = this.f1317i;
            if (gVar != null) {
                if (gVar.f1318j) {
                    this.f1314f = this.f1316h * gVar.f1315g;
                } else {
                    return;
                }
            }
            c(fVar2.f1315g + this.f1314f);
        }
        d dVar3 = this.a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b() {
        this.f1320l.clear();
        this.f1319k.clear();
        this.f1318j = false;
        this.f1315g = 0;
        this.c = false;
        this.b = false;
    }

    public void c(int i2) {
        if (!this.f1318j) {
            this.f1318j = true;
            this.f1315g = i2;
            for (d dVar : this.f1319k) {
                dVar.a(dVar);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1312d.b.d0);
        sb.append(":");
        sb.append(this.f1313e);
        sb.append("(");
        sb.append(this.f1318j ? Integer.valueOf(this.f1315g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f1320l.size());
        sb.append(":d=");
        sb.append(this.f1319k.size());
        sb.append(">");
        return sb.toString();
    }
}
