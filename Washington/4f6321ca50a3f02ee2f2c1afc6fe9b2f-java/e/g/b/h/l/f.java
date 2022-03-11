package e.g.b.h.l;

import java.util.ArrayList;
import java.util.List;

public class f implements d {
    public d a = null;
    public boolean b = false;
    public boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    public o f1299d;

    /* renamed from: e  reason: collision with root package name */
    public a f1300e = a.UNKNOWN;

    /* renamed from: f  reason: collision with root package name */
    public int f1301f;

    /* renamed from: g  reason: collision with root package name */
    public int f1302g;

    /* renamed from: h  reason: collision with root package name */
    public int f1303h = 1;

    /* renamed from: i  reason: collision with root package name */
    public g f1304i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1305j = false;

    /* renamed from: k  reason: collision with root package name */
    public List<d> f1306k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public List<f> f1307l = new ArrayList();

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
        this.f1299d = oVar;
    }

    @Override // e.g.b.h.l.d
    public void a(d dVar) {
        for (f fVar : this.f1307l) {
            if (!fVar.f1305j) {
                return;
            }
        }
        this.c = true;
        d dVar2 = this.a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.b) {
            this.f1299d.a(this);
            return;
        }
        f fVar2 = null;
        int i2 = 0;
        for (f fVar3 : this.f1307l) {
            if (!(fVar3 instanceof g)) {
                i2++;
                fVar2 = fVar3;
            }
        }
        if (fVar2 != null && i2 == 1 && fVar2.f1305j) {
            g gVar = this.f1304i;
            if (gVar != null) {
                if (gVar.f1305j) {
                    this.f1301f = this.f1303h * gVar.f1302g;
                } else {
                    return;
                }
            }
            c(fVar2.f1302g + this.f1301f);
        }
        d dVar3 = this.a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b() {
        this.f1307l.clear();
        this.f1306k.clear();
        this.f1305j = false;
        this.f1302g = 0;
        this.c = false;
        this.b = false;
    }

    public void c(int i2) {
        if (!this.f1305j) {
            this.f1305j = true;
            this.f1302g = i2;
            for (d dVar : this.f1306k) {
                dVar.a(dVar);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1299d.b.d0);
        sb.append(":");
        sb.append(this.f1300e);
        sb.append("(");
        sb.append(this.f1305j ? Integer.valueOf(this.f1302g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f1307l.size());
        sb.append(":d=");
        sb.append(this.f1306k.size());
        sb.append(">");
        return sb.toString();
    }
}
