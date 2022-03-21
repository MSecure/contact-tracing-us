package e.g.b;

import e.g.b.b;
import java.util.Arrays;

public class a implements b.a {
    public int a = 0;
    public final b b;
    public final c c;

    /* renamed from: d  reason: collision with root package name */
    public int f1213d = 8;

    /* renamed from: e  reason: collision with root package name */
    public int[] f1214e = new int[8];

    /* renamed from: f  reason: collision with root package name */
    public int[] f1215f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    public float[] f1216g = new float[8];

    /* renamed from: h  reason: collision with root package name */
    public int f1217h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f1218i = -1;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1219j = false;

    public a(b bVar, c cVar) {
        this.b = bVar;
        this.c = cVar;
    }

    @Override // e.g.b.b.a
    public float a(int i2) {
        int i3 = this.f1217h;
        int i4 = 0;
        while (i3 != -1 && i4 < this.a) {
            if (i4 == i2) {
                return this.f1216g[i3];
            }
            i3 = this.f1215f[i3];
            i4++;
        }
        return 0.0f;
    }

    @Override // e.g.b.b.a
    public float b(b bVar, boolean z) {
        float g2 = g(bVar.a);
        d(bVar.a, z);
        b.a aVar = bVar.f1220d;
        int k2 = aVar.k();
        for (int i2 = 0; i2 < k2; i2++) {
            g f2 = aVar.f(i2);
            e(f2, aVar.g(f2) * g2, z);
        }
        return g2;
    }

    @Override // e.g.b.b.a
    public final void c(g gVar, float f2) {
        if (f2 == 0.0f) {
            d(gVar, true);
            return;
        }
        int i2 = this.f1217h;
        if (i2 == -1) {
            this.f1217h = 0;
            this.f1216g[0] = f2;
            this.f1214e[0] = gVar.b;
            this.f1215f[0] = -1;
            gVar.f1245l++;
            gVar.a(this.b);
            this.a++;
            if (!this.f1219j) {
                int i3 = this.f1218i + 1;
                this.f1218i = i3;
                int[] iArr = this.f1214e;
                if (i3 >= iArr.length) {
                    this.f1219j = true;
                    this.f1218i = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i4 = 0;
        int i5 = -1;
        while (i2 != -1 && i4 < this.a) {
            int[] iArr2 = this.f1214e;
            int i6 = iArr2[i2];
            int i7 = gVar.b;
            if (i6 == i7) {
                this.f1216g[i2] = f2;
                return;
            }
            if (iArr2[i2] < i7) {
                i5 = i2;
            }
            i2 = this.f1215f[i2];
            i4++;
        }
        int i8 = this.f1218i;
        int i9 = i8 + 1;
        if (this.f1219j) {
            int[] iArr3 = this.f1214e;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr4 = this.f1214e;
        if (i8 >= iArr4.length && this.a < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.f1214e;
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
        int[] iArr6 = this.f1214e;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            int i11 = this.f1213d * 2;
            this.f1213d = i11;
            this.f1219j = false;
            this.f1218i = i8 - 1;
            this.f1216g = Arrays.copyOf(this.f1216g, i11);
            this.f1214e = Arrays.copyOf(this.f1214e, this.f1213d);
            this.f1215f = Arrays.copyOf(this.f1215f, this.f1213d);
        }
        this.f1214e[i8] = gVar.b;
        this.f1216g[i8] = f2;
        int[] iArr7 = this.f1215f;
        if (i5 != -1) {
            iArr7[i8] = iArr7[i5];
            iArr7[i5] = i8;
        } else {
            iArr7[i8] = this.f1217h;
            this.f1217h = i8;
        }
        gVar.f1245l++;
        gVar.a(this.b);
        int i12 = this.a + 1;
        this.a = i12;
        if (!this.f1219j) {
            this.f1218i++;
        }
        int[] iArr8 = this.f1214e;
        if (i12 >= iArr8.length) {
            this.f1219j = true;
        }
        if (this.f1218i >= iArr8.length) {
            this.f1219j = true;
            this.f1218i = iArr8.length - 1;
        }
    }

    @Override // e.g.b.b.a
    public final void clear() {
        int i2 = this.f1217h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            g gVar = this.c.f1222d[this.f1214e[i2]];
            if (gVar != null) {
                gVar.b(this.b);
            }
            i2 = this.f1215f[i2];
            i3++;
        }
        this.f1217h = -1;
        this.f1218i = -1;
        this.f1219j = false;
        this.a = 0;
    }

    @Override // e.g.b.b.a
    public final float d(g gVar, boolean z) {
        int i2 = this.f1217h;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.a) {
            if (this.f1214e[i2] == gVar.b) {
                if (i2 == this.f1217h) {
                    this.f1217h = this.f1215f[i2];
                } else {
                    int[] iArr = this.f1215f;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    gVar.b(this.b);
                }
                gVar.f1245l--;
                this.a--;
                this.f1214e[i2] = -1;
                if (this.f1219j) {
                    this.f1218i = i2;
                }
                return this.f1216g[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f1215f[i2];
        }
        return 0.0f;
    }

    @Override // e.g.b.b.a
    public void e(g gVar, float f2, boolean z) {
        if (f2 <= -0.001f || f2 >= 0.001f) {
            int i2 = this.f1217h;
            if (i2 == -1) {
                this.f1217h = 0;
                this.f1216g[0] = f2;
                this.f1214e[0] = gVar.b;
                this.f1215f[0] = -1;
                gVar.f1245l++;
                gVar.a(this.b);
                this.a++;
                if (!this.f1219j) {
                    int i3 = this.f1218i + 1;
                    this.f1218i = i3;
                    int[] iArr = this.f1214e;
                    if (i3 >= iArr.length) {
                        this.f1219j = true;
                        this.f1218i = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = 0;
            int i5 = -1;
            while (i2 != -1 && i4 < this.a) {
                int[] iArr2 = this.f1214e;
                int i6 = iArr2[i2];
                int i7 = gVar.b;
                if (i6 == i7) {
                    float[] fArr = this.f1216g;
                    float f3 = fArr[i2] + f2;
                    if (f3 > -0.001f && f3 < 0.001f) {
                        f3 = 0.0f;
                    }
                    fArr[i2] = f3;
                    if (f3 == 0.0f) {
                        if (i2 == this.f1217h) {
                            this.f1217h = this.f1215f[i2];
                        } else {
                            int[] iArr3 = this.f1215f;
                            iArr3[i5] = iArr3[i2];
                        }
                        if (z) {
                            gVar.b(this.b);
                        }
                        if (this.f1219j) {
                            this.f1218i = i2;
                        }
                        gVar.f1245l--;
                        this.a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i2] < i7) {
                    i5 = i2;
                }
                i2 = this.f1215f[i2];
                i4++;
            }
            int i8 = this.f1218i;
            int i9 = i8 + 1;
            if (this.f1219j) {
                int[] iArr4 = this.f1214e;
                if (iArr4[i8] != -1) {
                    i8 = iArr4.length;
                }
            } else {
                i8 = i9;
            }
            int[] iArr5 = this.f1214e;
            if (i8 >= iArr5.length && this.a < iArr5.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr6 = this.f1214e;
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
            int[] iArr7 = this.f1214e;
            if (i8 >= iArr7.length) {
                i8 = iArr7.length;
                int i11 = this.f1213d * 2;
                this.f1213d = i11;
                this.f1219j = false;
                this.f1218i = i8 - 1;
                this.f1216g = Arrays.copyOf(this.f1216g, i11);
                this.f1214e = Arrays.copyOf(this.f1214e, this.f1213d);
                this.f1215f = Arrays.copyOf(this.f1215f, this.f1213d);
            }
            this.f1214e[i8] = gVar.b;
            this.f1216g[i8] = f2;
            int[] iArr8 = this.f1215f;
            if (i5 != -1) {
                iArr8[i8] = iArr8[i5];
                iArr8[i5] = i8;
            } else {
                iArr8[i8] = this.f1217h;
                this.f1217h = i8;
            }
            gVar.f1245l++;
            gVar.a(this.b);
            this.a++;
            if (!this.f1219j) {
                this.f1218i++;
            }
            int i12 = this.f1218i;
            int[] iArr9 = this.f1214e;
            if (i12 >= iArr9.length) {
                this.f1219j = true;
                this.f1218i = iArr9.length - 1;
            }
        }
    }

    @Override // e.g.b.b.a
    public g f(int i2) {
        int i3 = this.f1217h;
        int i4 = 0;
        while (i3 != -1 && i4 < this.a) {
            if (i4 == i2) {
                return this.c.f1222d[this.f1214e[i3]];
            }
            i3 = this.f1215f[i3];
            i4++;
        }
        return null;
    }

    @Override // e.g.b.b.a
    public final float g(g gVar) {
        int i2 = this.f1217h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            if (this.f1214e[i2] == gVar.b) {
                return this.f1216g[i2];
            }
            i2 = this.f1215f[i2];
            i3++;
        }
        return 0.0f;
    }

    @Override // e.g.b.b.a
    public boolean h(g gVar) {
        int i2 = this.f1217h;
        if (i2 == -1) {
            return false;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            if (this.f1214e[i2] == gVar.b) {
                return true;
            }
            i2 = this.f1215f[i2];
            i3++;
        }
        return false;
    }

    @Override // e.g.b.b.a
    public void i(float f2) {
        int i2 = this.f1217h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            float[] fArr = this.f1216g;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f1215f[i2];
            i3++;
        }
    }

    @Override // e.g.b.b.a
    public void j() {
        int i2 = this.f1217h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            float[] fArr = this.f1216g;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.f1215f[i2];
            i3++;
        }
    }

    @Override // e.g.b.b.a
    public int k() {
        return this.a;
    }

    public String toString() {
        int i2 = this.f1217h;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            StringBuilder h2 = f.a.a.a.a.h(f.a.a.a.a.t(str, " -> "));
            h2.append(this.f1216g[i2]);
            h2.append(" : ");
            StringBuilder h3 = f.a.a.a.a.h(h2.toString());
            h3.append(this.c.f1222d[this.f1214e[i2]]);
            str = h3.toString();
            i2 = this.f1215f[i2];
            i3++;
        }
        return str;
    }
}
