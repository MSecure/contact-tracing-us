package e.l.a;

import e.l.a.b;

public final class e {
    public double a = Math.sqrt(1500.0d);
    public double b = 0.5d;
    public boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    public double f1554d;

    /* renamed from: e  reason: collision with root package name */
    public double f1555e;

    /* renamed from: f  reason: collision with root package name */
    public double f1556f;

    /* renamed from: g  reason: collision with root package name */
    public double f1557g;

    /* renamed from: h  reason: collision with root package name */
    public double f1558h;

    /* renamed from: i  reason: collision with root package name */
    public double f1559i = Double.MAX_VALUE;

    /* renamed from: j  reason: collision with root package name */
    public final b.h f1560j = new b.h();

    public e() {
    }

    public e(float f2) {
        this.f1559i = (double) f2;
    }

    public e a(float f2) {
        if (f2 > 0.0f) {
            this.a = Math.sqrt((double) f2);
            this.c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public b.h b(double d2, double d3, long j2) {
        double d4;
        double d5;
        if (!this.c) {
            if (this.f1559i != Double.MAX_VALUE) {
                double d6 = this.b;
                if (d6 > 1.0d) {
                    double d7 = this.a;
                    this.f1556f = (Math.sqrt((d6 * d6) - 1.0d) * d7) + ((-d6) * d7);
                    double d8 = this.b;
                    double d9 = this.a;
                    this.f1557g = ((-d8) * d9) - (Math.sqrt((d8 * d8) - 1.0d) * d9);
                } else if (d6 >= 0.0d && d6 < 1.0d) {
                    this.f1558h = Math.sqrt(1.0d - (d6 * d6)) * this.a;
                }
                this.c = true;
            } else {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
        }
        double d10 = ((double) j2) / 1000.0d;
        double d11 = d2 - this.f1559i;
        double d12 = this.b;
        if (d12 > 1.0d) {
            double d13 = this.f1557g;
            double d14 = this.f1556f;
            double d15 = d11 - (((d13 * d11) - d3) / (d13 - d14));
            double d16 = ((d11 * d13) - d3) / (d13 - d14);
            d4 = (Math.pow(2.718281828459045d, this.f1556f * d10) * d16) + (Math.pow(2.718281828459045d, d13 * d10) * d15);
            double d17 = this.f1557g;
            double pow = Math.pow(2.718281828459045d, d17 * d10) * d15 * d17;
            double d18 = this.f1556f;
            d5 = (Math.pow(2.718281828459045d, d18 * d10) * d16 * d18) + pow;
        } else if (d12 == 1.0d) {
            double d19 = this.a;
            double d20 = (d19 * d11) + d3;
            double d21 = (d20 * d10) + d11;
            double pow2 = Math.pow(2.718281828459045d, (-d19) * d10) * d21;
            double pow3 = Math.pow(2.718281828459045d, (-this.a) * d10) * d21;
            double d22 = this.a;
            d5 = (Math.pow(2.718281828459045d, (-d22) * d10) * d20) + (pow3 * (-d22));
            d4 = pow2;
        } else {
            double d23 = 1.0d / this.f1558h;
            double d24 = this.a;
            double d25 = ((d12 * d24 * d11) + d3) * d23;
            double sin = ((Math.sin(this.f1558h * d10) * d25) + (Math.cos(this.f1558h * d10) * d11)) * Math.pow(2.718281828459045d, (-d12) * d24 * d10);
            double d26 = this.a;
            double d27 = this.b;
            double d28 = (-d26) * sin * d27;
            double pow4 = Math.pow(2.718281828459045d, (-d27) * d26 * d10);
            double d29 = this.f1558h;
            double d30 = (-d29) * d11;
            double d31 = this.f1558h;
            d5 = (((Math.cos(d31 * d10) * d25 * d31) + (Math.sin(d29 * d10) * d30)) * pow4) + d28;
            d4 = sin;
        }
        b.h hVar = this.f1560j;
        hVar.a = (float) (d4 + this.f1559i);
        hVar.b = (float) d5;
        return hVar;
    }
}
