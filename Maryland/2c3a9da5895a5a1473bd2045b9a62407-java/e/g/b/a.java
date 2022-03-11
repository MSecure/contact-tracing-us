package e.g.b;

import e.g.b.b;
import java.util.Arrays;

public class a implements b.a {
    public int a = 0;
    public final b b;
    public final c c;

    /* renamed from: d  reason: collision with root package name */
    public int f1226d = 8;

    /* renamed from: e  reason: collision with root package name */
    public int[] f1227e = new int[8];

    /* renamed from: f  reason: collision with root package name */
    public int[] f1228f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    public float[] f1229g = new float[8];

    /* renamed from: h  reason: collision with root package name */
    public int f1230h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f1231i = -1;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1232j = false;

    public a(b bVar, c cVar) {
        this.b = bVar;
        this.c = cVar;
    }

    @Override // e.g.b.b.a
    public float a(int i2) {
        int i3 = this.f1230h;
        int i4 = 0;
        while (i3 != -1 && i4 < this.a) {
            if (i4 == i2) {
                return this.f1229g[i3];
            }
            i3 = this.f1228f[i3];
            i4++;
        }
        return 0.0f;
    }

    @Override // e.g.b.b.a
    public float b(b bVar, boolean z) {
        float g2 = g(bVar.a);
        d(bVar.a, z);
        b.a aVar = bVar.f1233d;
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
        int i2 = this.f1230h;
        if (i2 == -1) {
            this.f1230h = 0;
            this.f1229g[0] = f2;
            this.f1227e[0] = gVar.b;
            this.f1228f[0] = -1;
            gVar.f1258l++;
            gVar.a(this.b);
            this.a++;
            if (!this.f1232j) {
                int i3 = this.f1231i + 1;
                this.f1231i = i3;
                int[] iArr = this.f1227e;
                if (i3 >= iArr.length) {
                    this.f1232j = true;
                    this.f1231i = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i4 = 0;
        int i5 = -1;
        while (i2 != -1 && i4 < this.a) {
            int[] iArr2 = this.f1227e;
            int i6 = iArr2[i2];
            int i7 = gVar.b;
            if (i6 == i7) {
                this.f1229g[i2] = f2;
                return;
            }
            if (iArr2[i2] < i7) {
                i5 = i2;
            }
            i2 = this.f1228f[i2];
            i4++;
        }
        int i8 = this.f1231i;
        int i9 = i8 + 1;
        if (this.f1232j) {
            int[] iArr3 = this.f1227e;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr4 = this.f1227e;
        if (i8 >= iArr4.length && this.a < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.f1227e;
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
        int[] iArr6 = this.f1227e;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            int i11 = this.f1226d * 2;
            this.f1226d = i11;
            this.f1232j = false;
            this.f1231i = i8 - 1;
            this.f1229g = Arrays.copyOf(this.f1229g, i11);
            this.f1227e = Arrays.copyOf(this.f1227e, this.f1226d);
            this.f1228f = Arrays.copyOf(this.f1228f, this.f1226d);
        }
        this.f1227e[i8] = gVar.b;
        this.f1229g[i8] = f2;
        int[] iArr7 = this.f1228f;
        if (i5 != -1) {
            iArr7[i8] = iArr7[i5];
            iArr7[i5] = i8;
        } else {
            iArr7[i8] = this.f1230h;
            this.f1230h = i8;
        }
        gVar.f1258l++;
        gVar.a(this.b);
        int i12 = this.a + 1;
        this.a = i12;
        if (!this.f1232j) {
            this.f1231i++;
        }
        int[] iArr8 = this.f1227e;
        if (i12 >= iArr8.length) {
            this.f1232j = true;
        }
        if (this.f1231i >= iArr8.length) {
            this.f1232j = true;
            this.f1231i = iArr8.length - 1;
        }
    }

    @Override // e.g.b.b.a
    public final void clear() {
        int i2 = this.f1230h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            g gVar = this.c.f1235d[this.f1227e[i2]];
            if (gVar != null) {
                gVar.b(this.b);
            }
            i2 = this.f1228f[i2];
            i3++;
        }
        this.f1230h = -1;
        this.f1231i = -1;
        this.f1232j = false;
        this.a = 0;
    }

    @Override // e.g.b.b.a
    public final float d(g gVar, boolean z) {
        int i2 = this.f1230h;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.a) {
            if (this.f1227e[i2] == gVar.b) {
                if (i2 == this.f1230h) {
                    this.f1230h = this.f1228f[i2];
                } else {
                    int[] iArr = this.f1228f;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    gVar.b(this.b);
                }
                gVar.f1258l--;
                this.a--;
                this.f1227e[i2] = -1;
                if (this.f1232j) {
                    this.f1231i = i2;
                }
                return this.f1229g[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f1228f[i2];
        }
        return 0.0f;
    }

    @Override // e.g.b.b.a
    public void e(g gVar, float f2, boolean z) {
        if (f2 <= -0.001f || f2 >= 0.001f) {
            int i2 = this.f1230h;
            if (i2 == -1) {
                this.f1230h = 0;
                this.f1229g[0] = f2;
                this.f1227e[0] = gVar.b;
                this.f1228f[0] = -1;
                gVar.f1258l++;
                gVar.a(this.b);
                this.a++;
                if (!this.f1232j) {
                    int i3 = this.f1231i + 1;
                    this.f1231i = i3;
                    int[] iArr = this.f1227e;
                    if (i3 >= iArr.length) {
                        this.f1232j = true;
                        this.f1231i = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = 0;
            int i5 = -1;
            while (i2 != -1 && i4 < this.a) {
                int[] iArr2 = this.f1227e;
                int i6 = iArr2[i2];
                int i7 = gVar.b;
                if (i6 == i7) {
                    float[] fArr = this.f1229g;
                    float f3 = fArr[i2] + f2;
                    if (f3 > -0.001f && f3 < 0.001f) {
                        f3 = 0.0f;
                    }
                    fArr[i2] = f3;
                    if (f3 == 0.0f) {
                        if (i2 == this.f1230h) {
                            this.f1230h = this.f1228f[i2];
                        } else {
                            int[] iArr3 = this.f1228f;
                            iArr3[i5] = iArr3[i2];
                        }
                        if (z) {
                            gVar.b(this.b);
                        }
                        if (this.f1232j) {
                            this.f1231i = i2;
                        }
                        gVar.f1258l--;
                        this.a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i2] < i7) {
                    i5 = i2;
                }
                i2 = this.f1228f[i2];
                i4++;
            }
            int i8 = this.f1231i;
            int i9 = i8 + 1;
            if (this.f1232j) {
                int[] iArr4 = this.f1227e;
                if (iArr4[i8] != -1) {
                    i8 = iArr4.length;
                }
            } else {
                i8 = i9;
            }
            int[] iArr5 = this.f1227e;
            if (i8 >= iArr5.length && this.a < iArr5.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr6 = this.f1227e;
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
            int[] iArr7 = this.f1227e;
            if (i8 >= iArr7.length) {
                i8 = iArr7.length;
                int i11 = this.f1226d * 2;
                this.f1226d = i11;
                this.f1232j = false;
                this.f1231i = i8 - 1;
                this.f1229g = Arrays.copyOf(this.f1229g, i11);
                this.f1227e = Arrays.copyOf(this.f1227e, this.f1226d);
                this.f1228f = Arrays.copyOf(this.f1228f, this.f1226d);
            }
            this.f1227e[i8] = gVar.b;
            this.f1229g[i8] = f2;
            int[] iArr8 = this.f1228f;
            if (i5 != -1) {
                iArr8[i8] = iArr8[i5];
                iArr8[i5] = i8;
            } else {
                iArr8[i8] = this.f1230h;
                this.f1230h = i8;
            }
            gVar.f1258l++;
            gVar.a(this.b);
            this.a++;
            if (!this.f1232j) {
                this.f1231i++;
            }
            int i12 = this.f1231i;
            int[] iArr9 = this.f1227e;
            if (i12 >= iArr9.length) {
                this.f1232j = true;
                this.f1231i = iArr9.length - 1;
            }
        }
    }

    @Override // e.g.b.b.a
    public g f(int i2) {
        int i3 = this.f1230h;
        int i4 = 0;
        while (i3 != -1 && i4 < this.a) {
            if (i4 == i2) {
                return this.c.f1235d[this.f1227e[i3]];
            }
            i3 = this.f1228f[i3];
            i4++;
        }
        return null;
    }

    @Override // e.g.b.b.a
    public final float g(g gVar) {
        int i2 = this.f1230h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            if (this.f1227e[i2] == gVar.b) {
                return this.f1229g[i2];
            }
            i2 = this.f1228f[i2];
            i3++;
        }
        return 0.0f;
    }

    @Override // e.g.b.b.a
    public boolean h(g gVar) {
        int i2 = this.f1230h;
        if (i2 == -1) {
            return false;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            if (this.f1227e[i2] == gVar.b) {
                return true;
            }
            i2 = this.f1228f[i2];
            i3++;
        }
        return false;
    }

    @Override // e.g.b.b.a
    public void i(float f2) {
        int i2 = this.f1230h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            float[] fArr = this.f1229g;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f1228f[i2];
            i3++;
        }
    }

    @Override // e.g.b.b.a
    public void j() {
        int i2 = this.f1230h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            float[] fArr = this.f1229g;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.f1228f[i2];
            i3++;
        }
    }

    @Override // e.g.b.b.a
    public int k() {
        return this.a;
    }

    public String toString() {
        int i2 = this.f1230h;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            StringBuilder h2 = f.a.a.a.a.h(f.a.a.a.a.t(str, " -> "));
            h2.append(this.f1229g[i2]);
            h2.append(" : ");
            StringBuilder h3 = f.a.a.a.a.h(h2.toString());
            h3.append(this.c.f1235d[this.f1227e[i2]]);
            str = h3.toString();
            i2 = this.f1228f[i2];
            i3++;
        }
        return str;
    }
}
