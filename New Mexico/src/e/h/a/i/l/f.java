package e.h.a.i.l;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f implements d {

    /* renamed from: d */
    public o f1417d;

    /* renamed from: f */
    public int f1419f;

    /* renamed from: g */
    public int f1420g;
    public d a = null;
    public boolean b = false;
    public boolean c = false;

    /* renamed from: e */
    public a f1418e = a.UNKNOWN;

    /* renamed from: h */
    public int f1421h = 1;

    /* renamed from: i */
    public g f1422i = null;

    /* renamed from: j */
    public boolean f1423j = false;

    /* renamed from: k */
    public List<d> f1424k = new ArrayList();

    /* renamed from: l */
    public List<f> f1425l = new ArrayList();

    /* loaded from: classes.dex */
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
        this.f1417d = oVar;
    }

    @Override // e.h.a.i.l.d
    public void a(d dVar) {
        for (f fVar : this.f1425l) {
            if (!fVar.f1423j) {
                return;
            }
        }
        this.c = true;
        d dVar2 = this.a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.b) {
            this.f1417d.a(this);
            return;
        }
        f fVar2 = null;
        int i2 = 0;
        for (f fVar3 : this.f1425l) {
            if (!(fVar3 instanceof g)) {
                i2++;
                fVar2 = fVar3;
            }
        }
        if (fVar2 != null && i2 == 1 && fVar2.f1423j) {
            g gVar = this.f1422i;
            if (gVar != null) {
                if (gVar.f1423j) {
                    this.f1419f = this.f1421h * gVar.f1420g;
                } else {
                    return;
                }
            }
            c(fVar2.f1420g + this.f1419f);
        }
        d dVar3 = this.a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b() {
        this.f1425l.clear();
        this.f1424k.clear();
        this.f1423j = false;
        this.f1420g = 0;
        this.c = false;
        this.b = false;
    }

    public void c(int i2) {
        if (!this.f1423j) {
            this.f1423j = true;
            this.f1420g = i2;
            for (d dVar : this.f1424k) {
                dVar.a(dVar);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1417d.b.i0);
        sb.append(":");
        sb.append(this.f1418e);
        sb.append("(");
        sb.append(this.f1423j ? Integer.valueOf(this.f1420g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f1425l.size());
        sb.append(":d=");
        sb.append(this.f1424k.size());
        sb.append(">");
        return sb.toString();
    }
}
