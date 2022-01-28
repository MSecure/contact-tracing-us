package e.g.a;

import e.g.a.b;
import java.util.Arrays;

public class a implements b.a {
    public int a = 0;
    public final b b;
    public final c c;

    /* renamed from: d  reason: collision with root package name */
    public int f1247d = 8;

    /* renamed from: e  reason: collision with root package name */
    public int[] f1248e = new int[8];

    /* renamed from: f  reason: collision with root package name */
    public int[] f1249f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    public float[] f1250g = new float[8];

    /* renamed from: h  reason: collision with root package name */
    public int f1251h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f1252i = -1;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1253j = false;

    public a(b bVar, c cVar) {
        this.b = bVar;
        this.c = cVar;
    }

    @Override // e.g.a.b.a
    public float a(int i2) {
        int i3 = this.f1251h;
        int i4 = 0;
        while (i3 != -1 && i4 < this.a) {
            if (i4 == i2) {
                return this.f1250g[i3];
            }
            i3 = this.f1249f[i3];
            i4++;
        }
        return 0.0f;
    }

    @Override // e.g.a.b.a
    public final float b(g gVar) {
        int i2 = this.f1251h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            if (this.f1248e[i2] == gVar.c) {
                return this.f1250g[i2];
            }
            i2 = this.f1249f[i2];
            i3++;
        }
        return 0.0f;
    }

    @Override // e.g.a.b.a
    public final float c(g gVar, boolean z) {
        int i2 = this.f1251h;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.a) {
            if (this.f1248e[i2] == gVar.c) {
                if (i2 == this.f1251h) {
                    this.f1251h = this.f1249f[i2];
                } else {
                    int[] iArr = this.f1249f;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    gVar.b(this.b);
                }
                gVar.m--;
                this.a--;
                this.f1248e[i2] = -1;
                if (this.f1253j) {
                    this.f1252i = i2;
                }
                return this.f1250g[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f1249f[i2];
        }
        return 0.0f;
    }

    @Override // e.g.a.b.a
    public final void clear() {
        int i2 = this.f1251h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            g gVar = this.c.f1256d[this.f1248e[i2]];
            if (gVar != null) {
                gVar.b(this.b);
            }
            i2 = this.f1249f[i2];
            i3++;
        }
        this.f1251h = -1;
        this.f1252i = -1;
        this.f1253j = false;
        this.a = 0;
    }

    @Override // e.g.a.b.a
    public boolean d(g gVar) {
        int i2 = this.f1251h;
        if (i2 == -1) {
            return false;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            if (this.f1248e[i2] == gVar.c) {
                return true;
            }
            i2 = this.f1249f[i2];
            i3++;
        }
        return false;
    }

    @Override // e.g.a.b.a
    public float e(b bVar, boolean z) {
        float b2 = b(bVar.a);
        c(bVar.a, z);
        b.a aVar = bVar.f1254d;
        int k2 = aVar.k();
        for (int i2 = 0; i2 < k2; i2++) {
            g g2 = aVar.g(i2);
            h(g2, aVar.b(g2) * b2, z);
        }
        return b2;
    }

    @Override // e.g.a.b.a
    public final void f(g gVar, float f2) {
        if (f2 == 0.0f) {
            c(gVar, true);
            return;
        }
        int i2 = this.f1251h;
        if (i2 == -1) {
            this.f1251h = 0;
            this.f1250g[0] = f2;
            this.f1248e[0] = gVar.c;
            this.f1249f[0] = -1;
            gVar.m++;
            gVar.a(this.b);
            this.a++;
            if (!this.f1253j) {
                int i3 = this.f1252i + 1;
                this.f1252i = i3;
                int[] iArr = this.f1248e;
                if (i3 >= iArr.length) {
                    this.f1253j = true;
                    this.f1252i = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i4 = 0;
        int i5 = -1;
        while (i2 != -1 && i4 < this.a) {
            int[] iArr2 = this.f1248e;
            int i6 = iArr2[i2];
            int i7 = gVar.c;
            if (i6 == i7) {
                this.f1250g[i2] = f2;
                return;
            }
            if (iArr2[i2] < i7) {
                i5 = i2;
            }
            i2 = this.f1249f[i2];
            i4++;
        }
        int i8 = this.f1252i;
        int i9 = i8 + 1;
        if (this.f1253j) {
            int[] iArr3 = this.f1248e;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr4 = this.f1248e;
        if (i8 >= iArr4.length && this.a < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.f1248e;
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
        int[] iArr6 = this.f1248e;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            int i11 = this.f1247d * 2;
            this.f1247d = i11;
            this.f1253j = false;
            this.f1252i = i8 - 1;
            this.f1250g = Arrays.copyOf(this.f1250g, i11);
            this.f1248e = Arrays.copyOf(this.f1248e, this.f1247d);
            this.f1249f = Arrays.copyOf(this.f1249f, this.f1247d);
        }
        this.f1248e[i8] = gVar.c;
        this.f1250g[i8] = f2;
        int[] iArr7 = this.f1249f;
        if (i5 != -1) {
            iArr7[i8] = iArr7[i5];
            iArr7[i5] = i8;
        } else {
            iArr7[i8] = this.f1251h;
            this.f1251h = i8;
        }
        gVar.m++;
        gVar.a(this.b);
        int i12 = this.a + 1;
        this.a = i12;
        if (!this.f1253j) {
            this.f1252i++;
        }
        int[] iArr8 = this.f1248e;
        if (i12 >= iArr8.length) {
            this.f1253j = true;
        }
        if (this.f1252i >= iArr8.length) {
            this.f1253j = true;
            this.f1252i = iArr8.length - 1;
        }
    }

    @Override // e.g.a.b.a
    public g g(int i2) {
        int i3 = this.f1251h;
        int i4 = 0;
        while (i3 != -1 && i4 < this.a) {
            if (i4 == i2) {
                return this.c.f1256d[this.f1248e[i3]];
            }
            i3 = this.f1249f[i3];
            i4++;
        }
        return null;
    }

    @Override // e.g.a.b.a
    public void h(g gVar, float f2, boolean z) {
        if (f2 <= -0.001f || f2 >= 0.001f) {
            int i2 = this.f1251h;
            if (i2 == -1) {
                this.f1251h = 0;
                this.f1250g[0] = f2;
                this.f1248e[0] = gVar.c;
                this.f1249f[0] = -1;
                gVar.m++;
                gVar.a(this.b);
                this.a++;
                if (!this.f1253j) {
                    int i3 = this.f1252i + 1;
                    this.f1252i = i3;
                    int[] iArr = this.f1248e;
                    if (i3 >= iArr.length) {
                        this.f1253j = true;
                        this.f1252i = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = 0;
            int i5 = -1;
            while (i2 != -1 && i4 < this.a) {
                int[] iArr2 = this.f1248e;
                int i6 = iArr2[i2];
                int i7 = gVar.c;
                if (i6 == i7) {
                    float[] fArr = this.f1250g;
                    float f3 = fArr[i2] + f2;
                    if (f3 > -0.001f && f3 < 0.001f) {
                        f3 = 0.0f;
                    }
                    fArr[i2] = f3;
                    if (f3 == 0.0f) {
                        if (i2 == this.f1251h) {
                            this.f1251h = this.f1249f[i2];
                        } else {
                            int[] iArr3 = this.f1249f;
                            iArr3[i5] = iArr3[i2];
                        }
                        if (z) {
                            gVar.b(this.b);
                        }
                        if (this.f1253j) {
                            this.f1252i = i2;
                        }
                        gVar.m--;
                        this.a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i2] < i7) {
                    i5 = i2;
                }
                i2 = this.f1249f[i2];
                i4++;
            }
            int i8 = this.f1252i;
            int i9 = i8 + 1;
            if (this.f1253j) {
                int[] iArr4 = this.f1248e;
                if (iArr4[i8] != -1) {
                    i8 = iArr4.length;
                }
            } else {
                i8 = i9;
            }
            int[] iArr5 = this.f1248e;
            if (i8 >= iArr5.length && this.a < iArr5.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr6 = this.f1248e;
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
            int[] iArr7 = this.f1248e;
            if (i8 >= iArr7.length) {
                i8 = iArr7.length;
                int i11 = this.f1247d * 2;
                this.f1247d = i11;
                this.f1253j = false;
                this.f1252i = i8 - 1;
                this.f1250g = Arrays.copyOf(this.f1250g, i11);
                this.f1248e = Arrays.copyOf(this.f1248e, this.f1247d);
                this.f1249f = Arrays.copyOf(this.f1249f, this.f1247d);
            }
            this.f1248e[i8] = gVar.c;
            this.f1250g[i8] = f2;
            int[] iArr8 = this.f1249f;
            if (i5 != -1) {
                iArr8[i8] = iArr8[i5];
                iArr8[i5] = i8;
            } else {
                iArr8[i8] = this.f1251h;
                this.f1251h = i8;
            }
            gVar.m++;
            gVar.a(this.b);
            this.a++;
            if (!this.f1253j) {
                this.f1252i++;
            }
            int i12 = this.f1252i;
            int[] iArr9 = this.f1248e;
            if (i12 >= iArr9.length) {
                this.f1253j = true;
                this.f1252i = iArr9.length - 1;
            }
        }
    }

    @Override // e.g.a.b.a
    public void i(float f2) {
        int i2 = this.f1251h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            float[] fArr = this.f1250g;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f1249f[i2];
            i3++;
        }
    }

    @Override // e.g.a.b.a
    public void j() {
        int i2 = this.f1251h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            float[] fArr = this.f1250g;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.f1249f[i2];
            i3++;
        }
    }

    @Override // e.g.a.b.a
    public int k() {
        return this.a;
    }

    public String toString() {
        int i2 = this.f1251h;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            StringBuilder h2 = f.a.a.a.a.h(f.a.a.a.a.w(str, " -> "));
            h2.append(this.f1250g[i2]);
            h2.append(" : ");
            StringBuilder h3 = f.a.a.a.a.h(h2.toString());
            h3.append(this.c.f1256d[this.f1248e[i2]]);
            str = h3.toString();
            i2 = this.f1249f[i2];
            i3++;
        }
        return str;
    }
}
