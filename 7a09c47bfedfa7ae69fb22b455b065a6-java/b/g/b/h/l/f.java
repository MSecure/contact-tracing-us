package b.g.b.h.l;

import java.util.ArrayList;
import java.util.List;

public class f implements d {

    /* renamed from: a  reason: collision with root package name */
    public d f1541a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1542b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1543c = false;

    /* renamed from: d  reason: collision with root package name */
    public m f1544d;

    /* renamed from: e  reason: collision with root package name */
    public a f1545e = a.UNKNOWN;

    /* renamed from: f  reason: collision with root package name */
    public int f1546f;

    /* renamed from: g  reason: collision with root package name */
    public int f1547g;
    public int h = 1;
    public g i = null;
    public boolean j = false;
    public List<d> k = new ArrayList();
    public List<f> l = new ArrayList();

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

    public f(m mVar) {
        this.f1544d = mVar;
    }

    @Override // b.g.b.h.l.d
    public void a(d dVar) {
        for (f fVar : this.l) {
            if (!fVar.j) {
                return;
            }
        }
        this.f1543c = true;
        d dVar2 = this.f1541a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f1542b) {
            this.f1544d.a(this);
            return;
        }
        f fVar2 = null;
        int i2 = 0;
        for (f fVar3 : this.l) {
            if (!(fVar3 instanceof g)) {
                i2++;
                fVar2 = fVar3;
            }
        }
        if (fVar2 != null && i2 == 1 && fVar2.j) {
            g gVar = this.i;
            if (gVar != null) {
                if (gVar.j) {
                    this.f1546f = this.h * gVar.f1547g;
                } else {
                    return;
                }
            }
            c(fVar2.f1547g + this.f1546f);
        }
        d dVar3 = this.f1541a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.f1547g = 0;
        this.f1543c = false;
        this.f1542b = false;
    }

    public void c(int i2) {
        if (!this.j) {
            this.j = true;
            this.f1547g = i2;
            for (d dVar : this.k) {
                dVar.a(dVar);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1544d.f1558b.W);
        sb.append(":");
        sb.append(this.f1545e);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.f1547g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }
}
