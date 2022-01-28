package e.g.a.i.l;

import java.util.ArrayList;
import java.util.List;

public class f implements d {
    public d a = null;
    public boolean b = false;
    public boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    public o f1333d;

    /* renamed from: e  reason: collision with root package name */
    public a f1334e = a.UNKNOWN;

    /* renamed from: f  reason: collision with root package name */
    public int f1335f;

    /* renamed from: g  reason: collision with root package name */
    public int f1336g;

    /* renamed from: h  reason: collision with root package name */
    public int f1337h = 1;

    /* renamed from: i  reason: collision with root package name */
    public g f1338i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1339j = false;

    /* renamed from: k  reason: collision with root package name */
    public List<d> f1340k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public List<f> f1341l = new ArrayList();

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
        this.f1333d = oVar;
    }

    @Override // e.g.a.i.l.d
    public void a(d dVar) {
        for (f fVar : this.f1341l) {
            if (!fVar.f1339j) {
                return;
            }
        }
        this.c = true;
        d dVar2 = this.a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.b) {
            this.f1333d.a(this);
            return;
        }
        f fVar2 = null;
        int i2 = 0;
        for (f fVar3 : this.f1341l) {
            if (!(fVar3 instanceof g)) {
                i2++;
                fVar2 = fVar3;
            }
        }
        if (fVar2 != null && i2 == 1 && fVar2.f1339j) {
            g gVar = this.f1338i;
            if (gVar != null) {
                if (gVar.f1339j) {
                    this.f1335f = this.f1337h * gVar.f1336g;
                } else {
                    return;
                }
            }
            c(fVar2.f1336g + this.f1335f);
        }
        d dVar3 = this.a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b() {
        this.f1341l.clear();
        this.f1340k.clear();
        this.f1339j = false;
        this.f1336g = 0;
        this.c = false;
        this.b = false;
    }

    public void c(int i2) {
        if (!this.f1339j) {
            this.f1339j = true;
            this.f1336g = i2;
            for (d dVar : this.f1340k) {
                dVar.a(dVar);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1333d.b.i0);
        sb.append(":");
        sb.append(this.f1334e);
        sb.append("(");
        sb.append(this.f1339j ? Integer.valueOf(this.f1336g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f1341l.size());
        sb.append(":d=");
        sb.append(this.f1340k.size());
        sb.append(">");
        return sb.toString();
    }
}
