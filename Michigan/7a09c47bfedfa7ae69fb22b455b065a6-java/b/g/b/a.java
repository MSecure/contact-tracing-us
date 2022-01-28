package b.g.b;

import b.g.b.g;
import java.util.Arrays;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f1451a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final b f1452b;

    /* renamed from: c  reason: collision with root package name */
    public final c f1453c;

    /* renamed from: d  reason: collision with root package name */
    public int f1454d = 8;

    /* renamed from: e  reason: collision with root package name */
    public g f1455e = null;

    /* renamed from: f  reason: collision with root package name */
    public int[] f1456f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    public int[] f1457g = new int[8];
    public float[] h = new float[8];
    public int i = -1;
    public int j = -1;
    public boolean k = false;

    public a(b bVar, c cVar) {
        this.f1452b = bVar;
        this.f1453c = cVar;
    }

    public final void a(g gVar, float f2, boolean z) {
        if (Math.abs(f2) >= 0.001f) {
            int i2 = this.i;
            if (i2 == -1) {
                this.i = 0;
                this.h[0] = f2;
                this.f1456f[0] = gVar.f1481c;
                this.f1457g[0] = -1;
                gVar.l++;
                gVar.a(this.f1452b);
                this.f1451a++;
                if (!this.k) {
                    int i3 = this.j + 1;
                    this.j = i3;
                    int[] iArr = this.f1456f;
                    if (i3 >= iArr.length) {
                        this.k = true;
                        this.j = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = 0;
            int i5 = -1;
            while (i2 != -1 && i4 < this.f1451a) {
                int[] iArr2 = this.f1456f;
                int i6 = iArr2[i2];
                int i7 = gVar.f1481c;
                if (i6 == i7) {
                    float[] fArr = this.h;
                    fArr[i2] = fArr[i2] + f2;
                    if (Math.abs(fArr[i2]) < 0.001f) {
                        this.h[i2] = 0.0f;
                    }
                    if (this.h[i2] == 0.0f) {
                        if (i2 == this.i) {
                            this.i = this.f1457g[i2];
                        } else {
                            int[] iArr3 = this.f1457g;
                            iArr3[i5] = iArr3[i2];
                        }
                        if (z) {
                            gVar.b(this.f1452b);
                        }
                        if (this.k) {
                            this.j = i2;
                        }
                        gVar.l--;
                        this.f1451a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i2] < i7) {
                    i5 = i2;
                }
                i2 = this.f1457g[i2];
                i4++;
            }
            int i8 = this.j;
            int i9 = i8 + 1;
            if (this.k) {
                int[] iArr4 = this.f1456f;
                if (iArr4[i8] != -1) {
                    i8 = iArr4.length;
                }
            } else {
                i8 = i9;
            }
            int[] iArr5 = this.f1456f;
            if (i8 >= iArr5.length && this.f1451a < iArr5.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr6 = this.f1456f;
                    if (i10 >= iArr6.length) {
                        break;
                    } else if (iArr6[i10] == -1) {
                        i8 = i10;
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            int[] iArr7 = this.f1456f;
            if (i8 >= iArr7.length) {
                i8 = iArr7.length;
                int i11 = this.f1454d * 2;
                this.f1454d = i11;
                this.k = false;
                this.j = i8 - 1;
                this.h = Arrays.copyOf(this.h, i11);
                this.f1456f = Arrays.copyOf(this.f1456f, this.f1454d);
                this.f1457g = Arrays.copyOf(this.f1457g, this.f1454d);
            }
            this.f1456f[i8] = gVar.f1481c;
            this.h[i8] = f2;
            int[] iArr8 = this.f1457g;
            if (i5 != -1) {
                iArr8[i8] = iArr8[i5];
                iArr8[i5] = i8;
            } else {
                iArr8[i8] = this.i;
                this.i = i8;
            }
            gVar.l++;
            gVar.a(this.f1452b);
            this.f1451a++;
            if (!this.k) {
                this.j++;
            }
            int i12 = this.j;
            int[] iArr9 = this.f1456f;
            if (i12 >= iArr9.length) {
                this.k = true;
                this.j = iArr9.length - 1;
            }
        }
    }

    public final void b() {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1451a) {
            g gVar = this.f1453c.f1465c[this.f1456f[i2]];
            if (gVar != null) {
                gVar.b(this.f1452b);
            }
            i2 = this.f1457g[i2];
            i3++;
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f1451a = 0;
    }

    public final float c(g gVar) {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1451a) {
            if (this.f1456f[i2] == gVar.f1481c) {
                return this.h[i2];
            }
            i2 = this.f1457g[i2];
            i3++;
        }
        return 0.0f;
    }

    public g d(boolean[] zArr, g gVar) {
        g.a aVar;
        int i2 = this.i;
        int i3 = 0;
        g gVar2 = null;
        float f2 = 0.0f;
        while (i2 != -1 && i3 < this.f1451a) {
            float f3 = this.h[i2];
            if (f3 < 0.0f) {
                g gVar3 = this.f1453c.f1465c[this.f1456f[i2]];
                if ((zArr == null || !zArr[gVar3.f1481c]) && gVar3 != gVar && (((aVar = gVar3.i) == g.a.SLACK || aVar == g.a.ERROR) && f3 < f2)) {
                    f2 = f3;
                    gVar2 = gVar3;
                }
            }
            i2 = this.f1457g[i2];
            i3++;
        }
        return gVar2;
    }

    public final g e(int i2) {
        int i3 = this.i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f1451a) {
            if (i4 == i2) {
                return this.f1453c.f1465c[this.f1456f[i3]];
            }
            i3 = this.f1457g[i3];
            i4++;
        }
        return null;
    }

    public final float f(int i2) {
        int i3 = this.i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f1451a) {
            if (i4 == i2) {
                return this.h[i3];
            }
            i3 = this.f1457g[i3];
            i4++;
        }
        return 0.0f;
    }

    public final boolean g(g gVar) {
        return gVar.l <= 1;
    }

    public final void h(g gVar, float f2) {
        if (f2 == 0.0f) {
            i(gVar, true);
            return;
        }
        int i2 = this.i;
        if (i2 == -1) {
            this.i = 0;
            this.h[0] = f2;
            this.f1456f[0] = gVar.f1481c;
            this.f1457g[0] = -1;
            gVar.l++;
            gVar.a(this.f1452b);
            this.f1451a++;
            if (!this.k) {
                int i3 = this.j + 1;
                this.j = i3;
                int[] iArr = this.f1456f;
                if (i3 >= iArr.length) {
                    this.k = true;
                    this.j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i4 = 0;
        int i5 = -1;
        while (i2 != -1 && i4 < this.f1451a) {
            int[] iArr2 = this.f1456f;
            int i6 = iArr2[i2];
            int i7 = gVar.f1481c;
            if (i6 == i7) {
                this.h[i2] = f2;
                return;
            }
            if (iArr2[i2] < i7) {
                i5 = i2;
            }
            i2 = this.f1457g[i2];
            i4++;
        }
        int i8 = this.j;
        int i9 = i8 + 1;
        if (this.k) {
            int[] iArr3 = this.f1456f;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr4 = this.f1456f;
        if (i8 >= iArr4.length && this.f1451a < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.f1456f;
                if (i10 >= iArr5.length) {
                    break;
                } else if (iArr5[i10] == -1) {
                    i8 = i10;
                    break;
                } else {
                    i10++;
                }
            }
        }
        int[] iArr6 = this.f1456f;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            int i11 = this.f1454d * 2;
            this.f1454d = i11;
            this.k = false;
            this.j = i8 - 1;
            this.h = Arrays.copyOf(this.h, i11);
            this.f1456f = Arrays.copyOf(this.f1456f, this.f1454d);
            this.f1457g = Arrays.copyOf(this.f1457g, this.f1454d);
        }
        this.f1456f[i8] = gVar.f1481c;
        this.h[i8] = f2;
        int[] iArr7 = this.f1457g;
        if (i5 != -1) {
            iArr7[i8] = iArr7[i5];
            iArr7[i5] = i8;
        } else {
            iArr7[i8] = this.i;
            this.i = i8;
        }
        gVar.l++;
        gVar.a(this.f1452b);
        this.f1451a++;
        if (!this.k) {
            this.j++;
        }
        if (this.f1451a >= this.f1456f.length) {
            this.k = true;
        }
        int i12 = this.j;
        int[] iArr8 = this.f1456f;
        if (i12 >= iArr8.length) {
            this.k = true;
            this.j = iArr8.length - 1;
        }
    }

    public final float i(g gVar, boolean z) {
        if (this.f1455e == gVar) {
            this.f1455e = null;
        }
        int i2 = this.i;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f1451a) {
            if (this.f1456f[i2] == gVar.f1481c) {
                if (i2 == this.i) {
                    this.i = this.f1457g[i2];
                } else {
                    int[] iArr = this.f1457g;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    gVar.b(this.f1452b);
                }
                gVar.l--;
                this.f1451a--;
                this.f1456f[i2] = -1;
                if (this.k) {
                    this.j = i2;
                }
                return this.h[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f1457g[i2];
        }
        return 0.0f;
    }

    public String toString() {
        int i2 = this.i;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1451a) {
            StringBuilder h2 = c.a.a.a.a.h(c.a.a.a.a.q(str, " -> "));
            h2.append(this.h[i2]);
            h2.append(" : ");
            StringBuilder h3 = c.a.a.a.a.h(h2.toString());
            h3.append(this.f1453c.f1465c[this.f1456f[i2]]);
            str = h3.toString();
            i2 = this.f1457g[i2];
            i3++;
        }
        return str;
    }
}
