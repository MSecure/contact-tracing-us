package e.h.a;

import e.h.a.b;
import java.util.Arrays;
/* loaded from: classes.dex */
public class a implements b.a {
    public final b b;
    public final c c;
    public int a = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f1331d = 8;

    /* renamed from: e  reason: collision with root package name */
    public int[] f1332e = new int[8];

    /* renamed from: f  reason: collision with root package name */
    public int[] f1333f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    public float[] f1334g = new float[8];

    /* renamed from: h  reason: collision with root package name */
    public int f1335h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f1336i = -1;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1337j = false;

    public a(b bVar, c cVar) {
        this.b = bVar;
        this.c = cVar;
    }

    @Override // e.h.a.b.a
    public float a(int i2) {
        int i3 = this.f1335h;
        int i4 = 0;
        while (i3 != -1 && i4 < this.a) {
            if (i4 == i2) {
                return this.f1334g[i3];
            }
            i3 = this.f1333f[i3];
            i4++;
        }
        return 0.0f;
    }

    @Override // e.h.a.b.a
    public final float b(g gVar) {
        int i2 = this.f1335h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            if (this.f1332e[i2] == gVar.c) {
                return this.f1334g[i2];
            }
            i2 = this.f1333f[i2];
            i3++;
        }
        return 0.0f;
    }

    @Override // e.h.a.b.a
    public final float c(g gVar, boolean z) {
        int i2 = this.f1335h;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.a) {
            if (this.f1332e[i2] == gVar.c) {
                if (i2 == this.f1335h) {
                    this.f1335h = this.f1333f[i2];
                } else {
                    int[] iArr = this.f1333f;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    gVar.b(this.b);
                }
                gVar.m--;
                this.a--;
                this.f1332e[i2] = -1;
                if (this.f1337j) {
                    this.f1336i = i2;
                }
                return this.f1334g[i2];
            }
            i2 = this.f1333f[i2];
            i3++;
            i4 = i2;
        }
        return 0.0f;
    }

    @Override // e.h.a.b.a
    public final void clear() {
        int i2 = this.f1335h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            g gVar = this.c.f1340d[this.f1332e[i2]];
            if (gVar != null) {
                gVar.b(this.b);
            }
            i2 = this.f1333f[i2];
            i3++;
        }
        this.f1335h = -1;
        this.f1336i = -1;
        this.f1337j = false;
        this.a = 0;
    }

    @Override // e.h.a.b.a
    public boolean d(g gVar) {
        int i2 = this.f1335h;
        if (i2 == -1) {
            return false;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            if (this.f1332e[i2] == gVar.c) {
                return true;
            }
            i2 = this.f1333f[i2];
            i3++;
        }
        return false;
    }

    @Override // e.h.a.b.a
    public float e(b bVar, boolean z) {
        float b = b(bVar.a);
        c(bVar.a, z);
        b.a aVar = bVar.f1338d;
        int k2 = aVar.k();
        for (int i2 = 0; i2 < k2; i2++) {
            g g2 = aVar.g(i2);
            h(g2, aVar.b(g2) * b, z);
        }
        return b;
    }

    @Override // e.h.a.b.a
    public final void f(g gVar, float f2) {
        if (f2 == 0.0f) {
            c(gVar, true);
            return;
        }
        int i2 = this.f1335h;
        if (i2 == -1) {
            this.f1335h = 0;
            this.f1334g[0] = f2;
            this.f1332e[0] = gVar.c;
            this.f1333f[0] = -1;
            gVar.m++;
            gVar.a(this.b);
            this.a++;
            if (!this.f1337j) {
                int i3 = this.f1336i + 1;
                this.f1336i = i3;
                int[] iArr = this.f1332e;
                if (i3 >= iArr.length) {
                    this.f1337j = true;
                    this.f1336i = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i4 = 0;
        int i5 = -1;
        while (i2 != -1 && i4 < this.a) {
            int[] iArr2 = this.f1332e;
            int i6 = iArr2[i2];
            int i7 = gVar.c;
            if (i6 == i7) {
                this.f1334g[i2] = f2;
                return;
            }
            if (iArr2[i2] < i7) {
                i5 = i2;
            }
            i2 = this.f1333f[i2];
            i4++;
        }
        int i8 = this.f1336i;
        i8++;
        if (this.f1337j) {
            int[] iArr3 = this.f1332e;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        }
        int[] iArr4 = this.f1332e;
        if (i8 >= iArr4.length && this.a < iArr4.length) {
            int i9 = 0;
            while (true) {
                int[] iArr5 = this.f1332e;
                if (i9 >= iArr5.length) {
                    break;
                } else if (iArr5[i9] == -1) {
                    i8 = i9;
                    break;
                } else {
                    i9++;
                }
            }
        }
        int[] iArr6 = this.f1332e;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            int i10 = this.f1331d * 2;
            this.f1331d = i10;
            this.f1337j = false;
            this.f1336i = i8 - 1;
            this.f1334g = Arrays.copyOf(this.f1334g, i10);
            this.f1332e = Arrays.copyOf(this.f1332e, this.f1331d);
            this.f1333f = Arrays.copyOf(this.f1333f, this.f1331d);
        }
        this.f1332e[i8] = gVar.c;
        this.f1334g[i8] = f2;
        int[] iArr7 = this.f1333f;
        if (i5 != -1) {
            iArr7[i8] = iArr7[i5];
            iArr7[i5] = i8;
        } else {
            iArr7[i8] = this.f1335h;
            this.f1335h = i8;
        }
        gVar.m++;
        gVar.a(this.b);
        int i11 = this.a + 1;
        this.a = i11;
        if (!this.f1337j) {
            this.f1336i++;
        }
        int[] iArr8 = this.f1332e;
        if (i11 >= iArr8.length) {
            this.f1337j = true;
        }
        if (this.f1336i >= iArr8.length) {
            this.f1337j = true;
            this.f1336i = iArr8.length - 1;
        }
    }

    @Override // e.h.a.b.a
    public g g(int i2) {
        int i3 = this.f1335h;
        int i4 = 0;
        while (i3 != -1 && i4 < this.a) {
            if (i4 == i2) {
                return this.c.f1340d[this.f1332e[i3]];
            }
            i3 = this.f1333f[i3];
            i4++;
        }
        return null;
    }

    @Override // e.h.a.b.a
    public void h(g gVar, float f2, boolean z) {
        if (f2 <= -0.001f || f2 >= 0.001f) {
            int i2 = this.f1335h;
            if (i2 == -1) {
                this.f1335h = 0;
                this.f1334g[0] = f2;
                this.f1332e[0] = gVar.c;
                this.f1333f[0] = -1;
                gVar.m++;
                gVar.a(this.b);
                this.a++;
                if (!this.f1337j) {
                    int i3 = this.f1336i + 1;
                    this.f1336i = i3;
                    int[] iArr = this.f1332e;
                    if (i3 >= iArr.length) {
                        this.f1337j = true;
                        this.f1336i = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = 0;
            int i5 = -1;
            while (i2 != -1 && i4 < this.a) {
                int[] iArr2 = this.f1332e;
                int i6 = iArr2[i2];
                int i7 = gVar.c;
                if (i6 == i7) {
                    float[] fArr = this.f1334g;
                    float f3 = fArr[i2] + f2;
                    if (f3 > -0.001f && f3 < 0.001f) {
                        f3 = 0.0f;
                    }
                    fArr[i2] = f3;
                    if (f3 == 0.0f) {
                        if (i2 == this.f1335h) {
                            this.f1335h = this.f1333f[i2];
                        } else {
                            int[] iArr3 = this.f1333f;
                            iArr3[i5] = iArr3[i2];
                        }
                        if (z) {
                            gVar.b(this.b);
                        }
                        if (this.f1337j) {
                            this.f1336i = i2;
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
                i2 = this.f1333f[i2];
                i4++;
            }
            int i8 = this.f1336i;
            i8++;
            if (this.f1337j) {
                int[] iArr4 = this.f1332e;
                if (iArr4[i8] != -1) {
                    i8 = iArr4.length;
                }
            }
            int[] iArr5 = this.f1332e;
            if (i8 >= iArr5.length && this.a < iArr5.length) {
                int i9 = 0;
                while (true) {
                    int[] iArr6 = this.f1332e;
                    if (i9 >= iArr6.length) {
                        break;
                    } else if (iArr6[i9] == -1) {
                        i8 = i9;
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            int[] iArr7 = this.f1332e;
            if (i8 >= iArr7.length) {
                i8 = iArr7.length;
                int i10 = this.f1331d * 2;
                this.f1331d = i10;
                this.f1337j = false;
                this.f1336i = i8 - 1;
                this.f1334g = Arrays.copyOf(this.f1334g, i10);
                this.f1332e = Arrays.copyOf(this.f1332e, this.f1331d);
                this.f1333f = Arrays.copyOf(this.f1333f, this.f1331d);
            }
            this.f1332e[i8] = gVar.c;
            this.f1334g[i8] = f2;
            int[] iArr8 = this.f1333f;
            if (i5 != -1) {
                iArr8[i8] = iArr8[i5];
                iArr8[i5] = i8;
            } else {
                iArr8[i8] = this.f1335h;
                this.f1335h = i8;
            }
            gVar.m++;
            gVar.a(this.b);
            this.a++;
            if (!this.f1337j) {
                this.f1336i++;
            }
            int i11 = this.f1336i;
            int[] iArr9 = this.f1332e;
            if (i11 >= iArr9.length) {
                this.f1337j = true;
                this.f1336i = iArr9.length - 1;
            }
        }
    }

    @Override // e.h.a.b.a
    public void i(float f2) {
        int i2 = this.f1335h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            float[] fArr = this.f1334g;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f1333f[i2];
            i3++;
        }
    }

    @Override // e.h.a.b.a
    public void j() {
        int i2 = this.f1335h;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            float[] fArr = this.f1334g;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.f1333f[i2];
            i3++;
        }
    }

    @Override // e.h.a.b.a
    public int k() {
        return this.a;
    }

    public String toString() {
        int i2 = this.f1335h;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            StringBuilder h2 = f.a.a.a.a.h(f.a.a.a.a.x(str, " -> "));
            h2.append(this.f1334g[i2]);
            h2.append(" : ");
            StringBuilder h3 = f.a.a.a.a.h(h2.toString());
            h3.append(this.c.f1340d[this.f1332e[i2]]);
            str = h3.toString();
            i2 = this.f1333f[i2];
            i3++;
        }
        return str;
    }
}
