package e.g.b.h.l;

import java.util.ArrayList;
import java.util.List;

public class f implements d {
    public d a = null;
    public boolean b = false;
    public boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    public o f1123d;

    /* renamed from: e  reason: collision with root package name */
    public a f1124e = a.UNKNOWN;

    /* renamed from: f  reason: collision with root package name */
    public int f1125f;

    /* renamed from: g  reason: collision with root package name */
    public int f1126g;

    /* renamed from: h  reason: collision with root package name */
    public int f1127h = 1;

    /* renamed from: i  reason: collision with root package name */
    public g f1128i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1129j = false;

    /* renamed from: k  reason: collision with root package name */
    public List<d> f1130k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public List<f> f1131l = new ArrayList();

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
        this.f1123d = oVar;
    }

    @Override // e.g.b.h.l.d
    public void a(d dVar) {
        for (f fVar : this.f1131l) {
            if (!fVar.f1129j) {
                return;
            }
        }
        this.c = true;
        d dVar2 = this.a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.b) {
            this.f1123d.a(this);
            return;
        }
        f fVar2 = null;
        int i2 = 0;
        for (f fVar3 : this.f1131l) {
            if (!(fVar3 instanceof g)) {
                i2++;
                fVar2 = fVar3;
            }
        }
        if (fVar2 != null && i2 == 1 && fVar2.f1129j) {
            g gVar = this.f1128i;
            if (gVar != null) {
                if (gVar.f1129j) {
                    this.f1125f = this.f1127h * gVar.f1126g;
                } else {
                    return;
                }
            }
            c(fVar2.f1126g + this.f1125f);
        }
        d dVar3 = this.a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b() {
        this.f1131l.clear();
        this.f1130k.clear();
        this.f1129j = false;
        this.f1126g = 0;
        this.c = false;
        this.b = false;
    }

    public void c(int i2) {
        if (!this.f1129j) {
            this.f1129j = true;
            this.f1126g = i2;
            for (d dVar : this.f1130k) {
                dVar.a(dVar);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1123d.b.d0);
        sb.append(":");
        sb.append(this.f1124e);
        sb.append("(");
        sb.append(this.f1129j ? Integer.valueOf(this.f1126g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f1131l.size());
        sb.append(":d=");
        sb.append(this.f1130k.size());
        sb.append(">");
        return sb.toString();
    }
}
