package e.g.b.h.l;

import java.util.ArrayList;
import java.util.List;

public class f implements d {
    public d a = null;
    public boolean b = false;
    public boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    public o f1300d;

    /* renamed from: e  reason: collision with root package name */
    public a f1301e = a.UNKNOWN;

    /* renamed from: f  reason: collision with root package name */
    public int f1302f;

    /* renamed from: g  reason: collision with root package name */
    public int f1303g;

    /* renamed from: h  reason: collision with root package name */
    public int f1304h = 1;

    /* renamed from: i  reason: collision with root package name */
    public g f1305i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1306j = false;

    /* renamed from: k  reason: collision with root package name */
    public List<d> f1307k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public List<f> f1308l = new ArrayList();

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
        this.f1300d = oVar;
    }

    @Override // e.g.b.h.l.d
    public void a(d dVar) {
        for (f fVar : this.f1308l) {
            if (!fVar.f1306j) {
                return;
            }
        }
        this.c = true;
        d dVar2 = this.a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.b) {
            this.f1300d.a(this);
            return;
        }
        f fVar2 = null;
        int i2 = 0;
        for (f fVar3 : this.f1308l) {
            if (!(fVar3 instanceof g)) {
                i2++;
                fVar2 = fVar3;
            }
        }
        if (fVar2 != null && i2 == 1 && fVar2.f1306j) {
            g gVar = this.f1305i;
            if (gVar != null) {
                if (gVar.f1306j) {
                    this.f1302f = this.f1304h * gVar.f1303g;
                } else {
                    return;
                }
            }
            c(fVar2.f1303g + this.f1302f);
        }
        d dVar3 = this.a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b() {
        this.f1308l.clear();
        this.f1307k.clear();
        this.f1306j = false;
        this.f1303g = 0;
        this.c = false;
        this.b = false;
    }

    public void c(int i2) {
        if (!this.f1306j) {
            this.f1306j = true;
            this.f1303g = i2;
            for (d dVar : this.f1307k) {
                dVar.a(dVar);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1300d.b.d0);
        sb.append(":");
        sb.append(this.f1301e);
        sb.append("(");
        sb.append(this.f1306j ? Integer.valueOf(this.f1303g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f1308l.size());
        sb.append(":d=");
        sb.append(this.f1307k.size());
        sb.append(">");
        return sb.toString();
    }
}
