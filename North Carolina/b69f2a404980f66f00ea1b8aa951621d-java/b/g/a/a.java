package b.g.a;

import b.g.a.g;
import java.util.Arrays;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f863a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final b f864b;

    /* renamed from: c  reason: collision with root package name */
    public final c f865c;

    /* renamed from: d  reason: collision with root package name */
    public int f866d = 8;

    /* renamed from: e  reason: collision with root package name */
    public g f867e = null;
    public int[] f = new int[8];
    public int[] g = new int[8];
    public float[] h = new float[8];
    public int i = -1;
    public int j = -1;
    public boolean k = false;

    public a(b bVar, c cVar) {
        this.f864b = bVar;
        this.f865c = cVar;
    }

    public final void a(g gVar, float f2, boolean z) {
        if (f2 != 0.0f) {
            int i2 = this.i;
            if (i2 == -1) {
                this.i = 0;
                this.h[0] = f2;
                this.f[0] = gVar.f884b;
                this.g[0] = -1;
                gVar.j++;
                gVar.a(this.f864b);
                this.f863a++;
                if (!this.k) {
                    int i3 = this.j + 1;
                    this.j = i3;
                    int[] iArr = this.f;
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
            while (i2 != -1 && i4 < this.f863a) {
                int[] iArr2 = this.f;
                int i6 = iArr2[i2];
                int i7 = gVar.f884b;
                if (i6 == i7) {
                    float[] fArr = this.h;
                    fArr[i2] = fArr[i2] + f2;
                    if (fArr[i2] == 0.0f) {
                        if (i2 == this.i) {
                            this.i = this.g[i2];
                        } else {
                            int[] iArr3 = this.g;
                            iArr3[i5] = iArr3[i2];
                        }
                        if (z) {
                            gVar.b(this.f864b);
                        }
                        if (this.k) {
                            this.j = i2;
                        }
                        gVar.j--;
                        this.f863a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i2] < i7) {
                    i5 = i2;
                }
                i2 = this.g[i2];
                i4++;
            }
            int i8 = this.j;
            int i9 = i8 + 1;
            if (this.k) {
                int[] iArr4 = this.f;
                if (iArr4[i8] != -1) {
                    i8 = iArr4.length;
                }
            } else {
                i8 = i9;
            }
            int[] iArr5 = this.f;
            if (i8 >= iArr5.length && this.f863a < iArr5.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr6 = this.f;
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
            int[] iArr7 = this.f;
            if (i8 >= iArr7.length) {
                i8 = iArr7.length;
                int i11 = this.f866d * 2;
                this.f866d = i11;
                this.k = false;
                this.j = i8 - 1;
                this.h = Arrays.copyOf(this.h, i11);
                this.f = Arrays.copyOf(this.f, this.f866d);
                this.g = Arrays.copyOf(this.g, this.f866d);
            }
            this.f[i8] = gVar.f884b;
            this.h[i8] = f2;
            int[] iArr8 = this.g;
            if (i5 != -1) {
                iArr8[i8] = iArr8[i5];
                iArr8[i5] = i8;
            } else {
                iArr8[i8] = this.i;
                this.i = i8;
            }
            gVar.j++;
            gVar.a(this.f864b);
            this.f863a++;
            if (!this.k) {
                this.j++;
            }
            int i12 = this.j;
            int[] iArr9 = this.f;
            if (i12 >= iArr9.length) {
                this.k = true;
                this.j = iArr9.length - 1;
            }
        }
    }

    public final void b() {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f863a) {
            g gVar = this.f865c.f875c[this.f[i2]];
            if (gVar != null) {
                gVar.b(this.f864b);
            }
            i2 = this.g[i2];
            i3++;
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f863a = 0;
    }

    public final float c(g gVar) {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f863a) {
            if (this.f[i2] == gVar.f884b) {
                return this.h[i2];
            }
            i2 = this.g[i2];
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
        while (i2 != -1 && i3 < this.f863a) {
            if (this.h[i2] < 0.0f) {
                g gVar3 = this.f865c.f875c[this.f[i2]];
                if ((zArr == null || !zArr[gVar3.f884b]) && gVar3 != gVar && ((aVar = gVar3.g) == g.a.SLACK || aVar == g.a.ERROR)) {
                    float f3 = this.h[i2];
                    if (f3 < f2) {
                        gVar2 = gVar3;
                        f2 = f3;
                    }
                }
            }
            i2 = this.g[i2];
            i3++;
        }
        return gVar2;
    }

    public final g e(int i2) {
        int i3 = this.i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f863a) {
            if (i4 == i2) {
                return this.f865c.f875c[this.f[i3]];
            }
            i3 = this.g[i3];
            i4++;
        }
        return null;
    }

    public final float f(int i2) {
        int i3 = this.i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f863a) {
            if (i4 == i2) {
                return this.h[i3];
            }
            i3 = this.g[i3];
            i4++;
        }
        return 0.0f;
    }

    public final boolean g(g gVar) {
        return gVar.j <= 1;
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
            this.f[0] = gVar.f884b;
            this.g[0] = -1;
            gVar.j++;
            gVar.a(this.f864b);
            this.f863a++;
            if (!this.k) {
                int i3 = this.j + 1;
                this.j = i3;
                int[] iArr = this.f;
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
        while (i2 != -1 && i4 < this.f863a) {
            int[] iArr2 = this.f;
            int i6 = iArr2[i2];
            int i7 = gVar.f884b;
            if (i6 == i7) {
                this.h[i2] = f2;
                return;
            }
            if (iArr2[i2] < i7) {
                i5 = i2;
            }
            i2 = this.g[i2];
            i4++;
        }
        int i8 = this.j;
        int i9 = i8 + 1;
        if (this.k) {
            int[] iArr3 = this.f;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr4 = this.f;
        if (i8 >= iArr4.length && this.f863a < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.f;
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
        int[] iArr6 = this.f;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            int i11 = this.f866d * 2;
            this.f866d = i11;
            this.k = false;
            this.j = i8 - 1;
            this.h = Arrays.copyOf(this.h, i11);
            this.f = Arrays.copyOf(this.f, this.f866d);
            this.g = Arrays.copyOf(this.g, this.f866d);
        }
        this.f[i8] = gVar.f884b;
        this.h[i8] = f2;
        int[] iArr7 = this.g;
        if (i5 != -1) {
            iArr7[i8] = iArr7[i5];
            iArr7[i5] = i8;
        } else {
            iArr7[i8] = this.i;
            this.i = i8;
        }
        gVar.j++;
        gVar.a(this.f864b);
        this.f863a++;
        if (!this.k) {
            this.j++;
        }
        if (this.f863a >= this.f.length) {
            this.k = true;
        }
        int i12 = this.j;
        int[] iArr8 = this.f;
        if (i12 >= iArr8.length) {
            this.k = true;
            this.j = iArr8.length - 1;
        }
    }

    public final float i(g gVar, boolean z) {
        if (this.f867e == gVar) {
            this.f867e = null;
        }
        int i2 = this.i;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f863a) {
            if (this.f[i2] == gVar.f884b) {
                if (i2 == this.i) {
                    this.i = this.g[i2];
                } else {
                    int[] iArr = this.g;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    gVar.b(this.f864b);
                }
                gVar.j--;
                this.f863a--;
                this.f[i2] = -1;
                if (this.k) {
                    this.j = i2;
                }
                return this.h[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.g[i2];
        }
        return 0.0f;
    }

    public String toString() {
        int i2 = this.i;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.f863a) {
            StringBuilder g2 = c.a.a.a.a.g(c.a.a.a.a.o(str, " -> "));
            g2.append(this.h[i2]);
            g2.append(" : ");
            StringBuilder g3 = c.a.a.a.a.g(g2.toString());
            g3.append(this.f865c.f875c[this.f[i2]]);
            str = g3.toString();
            i2 = this.g[i2];
            i3++;
        }
        return str;
    }
}
