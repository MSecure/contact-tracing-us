package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import b.b.k.i;
import b.g.a.h.c;
import b.g.a.h.d;
import b.g.a.h.e;
import b.g.a.h.g;
import b.g.a.h.j;
import b.g.a.h.k;
import b.g.a.h.n;
import b.g.b.b;
import b.g.b.c;
import b.g.b.f;
import b.g.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f109b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b> f110c = new ArrayList<>(4);

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<d> f111d = new ArrayList<>(100);

    /* renamed from: e  reason: collision with root package name */
    public e f112e = new e();
    public int f = 0;
    public int g = 0;
    public int h = Integer.MAX_VALUE;
    public int i = Integer.MAX_VALUE;
    public boolean j = true;
    public int k = 7;
    public c l = null;
    public int m = -1;
    public HashMap<String, Integer> n = new HashMap<>();
    public int o = -1;
    public int p = -1;

    public static class a extends ViewGroup.MarginLayoutParams {
        public float A = 0.5f;
        public String B = null;
        public int C = 1;
        public float D = -1.0f;
        public float E = -1.0f;
        public int F = 0;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public float N = 1.0f;
        public float O = 1.0f;
        public int P = -1;
        public int Q = -1;
        public int R = -1;
        public boolean S = false;
        public boolean T = false;
        public boolean U = true;
        public boolean V = true;
        public boolean W = false;
        public boolean X = false;
        public boolean Y = false;
        public boolean Z = false;

        /* renamed from: a  reason: collision with root package name */
        public int f113a = -1;
        public int a0 = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f114b = -1;
        public int b0 = -1;

        /* renamed from: c  reason: collision with root package name */
        public float f115c = -1.0f;
        public int c0 = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f116d = -1;
        public int d0 = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f117e = -1;
        public int e0 = -1;
        public int f = -1;
        public int f0 = -1;
        public int g = -1;
        public float g0 = 0.5f;
        public int h = -1;
        public int h0;
        public int i = -1;
        public int i0;
        public int j = -1;
        public float j0;
        public int k = -1;
        public d k0 = new d();
        public int l = -1;
        public boolean l0 = false;
        public int m = -1;
        public int n = 0;
        public float o = 0.0f;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public int w = -1;
        public int x = -1;
        public int y = -1;
        public float z = 0.5f;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a  reason: collision with other inner class name */
        public static class C0002a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f118a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f118a = sparseIntArray;
                sparseIntArray.append(h.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f118a.append(h.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f118a.append(h.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f118a.append(h.ConstraintLayout_Layout_android_orientation, 1);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f118a.append(h.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f118a.append(h.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f118a.append(h.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f118a.append(h.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f118a.append(h.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f118a.append(h.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f118a.append(h.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f118a.append(h.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f118a.append(h.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public a(int i2, int i3) {
            super(i2, i3);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i2;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                int i4 = C0002a.f118a.get(index);
                switch (i4) {
                    case 1:
                        this.R = obtainStyledAttributes.getInt(index, this.R);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.m);
                        this.m = resourceId;
                        if (resourceId == -1) {
                            this.m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        break;
                    case 4:
                        float f2 = obtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        this.o = f2;
                        if (f2 < 0.0f) {
                            this.o = (360.0f - f2) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f113a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f113a);
                        break;
                    case 6:
                        this.f114b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f114b);
                        break;
                    case 7:
                        this.f115c = obtainStyledAttributes.getFloat(index, this.f115c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f116d);
                        this.f116d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f116d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f117e);
                        this.f117e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f117e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f);
                        this.f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.g);
                        this.g = resourceId5;
                        if (resourceId5 == -1) {
                            this.g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.h);
                        this.h = resourceId6;
                        if (resourceId6 == -1) {
                            this.h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.i);
                        this.i = resourceId7;
                        if (resourceId7 == -1) {
                            this.i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.j);
                        this.j = resourceId8;
                        if (resourceId8 == -1) {
                            this.j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.k);
                        this.k = resourceId9;
                        if (resourceId9 == -1) {
                            this.k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.l);
                        this.l = resourceId10;
                        if (resourceId10 == -1) {
                            this.l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.p);
                        this.p = resourceId11;
                        if (resourceId11 == -1) {
                            this.p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.q);
                        this.q = resourceId12;
                        if (resourceId12 == -1) {
                            this.q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.r);
                        this.r = resourceId13;
                        if (resourceId13 == -1) {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId14;
                        if (resourceId14 == -1) {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 24:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 25:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 26:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 27:
                        this.S = obtainStyledAttributes.getBoolean(index, this.S);
                        break;
                    case 28:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 29:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        this.H = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 32:
                        this.I = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 33:
                        try {
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.J) == -2) {
                                this.J = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.N = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.N));
                        break;
                    case 36:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        break;
                    default:
                        switch (i4) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.B.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i2 = 0;
                                    } else {
                                        String substring = this.B.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.C = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.C = 1;
                                        }
                                        i2 = indexOf + 1;
                                    }
                                    int indexOf2 = this.B.indexOf(58);
                                    if (indexOf2 < 0 || indexOf2 >= length - 1) {
                                        String substring2 = this.B.substring(i2);
                                        if (substring2.length() > 0) {
                                            Float.parseFloat(substring2);
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        String substring3 = this.B.substring(i2, indexOf2);
                                        String substring4 = this.B.substring(indexOf2 + 1);
                                        if (substring3.length() > 0 && substring4.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring3);
                                                float parseFloat2 = Float.parseFloat(substring4);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.C == 1) {
                                                        Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    } else {
                                                        Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    continue;
                                }
                                break;
                            case 45:
                                this.D = obtainStyledAttributes.getFloat(index, this.D);
                                continue;
                            case 46:
                                this.E = obtainStyledAttributes.getFloat(index, this.E);
                                continue;
                            case 47:
                                this.F = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.G = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.P = obtainStyledAttributes.getDimensionPixelOffset(index, this.P);
                                continue;
                            case 50:
                                this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                continue;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void a() {
            this.X = false;
            this.U = true;
            this.V = true;
            if (((ViewGroup.MarginLayoutParams) this).width == -2 && this.S) {
                this.U = false;
                this.H = 1;
            }
            if (((ViewGroup.MarginLayoutParams) this).height == -2 && this.T) {
                this.V = false;
                this.I = 1;
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i2 == 0 || i2 == -1) {
                this.U = false;
                if (((ViewGroup.MarginLayoutParams) this).width == 0 && this.H == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.S = true;
                }
            }
            int i3 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i3 == 0 || i3 == -1) {
                this.V = false;
                if (((ViewGroup.MarginLayoutParams) this).height == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.T = true;
                }
            }
            if (this.f115c != -1.0f || this.f113a != -1 || this.f114b != -1) {
                this.X = true;
                this.U = true;
                this.V = true;
                if (!(this.k0 instanceof g)) {
                    this.k0 = new g();
                }
                ((g) this.k0).F(this.R);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:71:0x00d6, code lost:
            if (r1 > 0) goto L_0x00d8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x00e5, code lost:
            if (r1 > 0) goto L_0x00d8;
         */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0084  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x00ec  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x00f7  */
        @TargetApi(17)
        public void resolveLayoutDirection(int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            float f2;
            int i8 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i9 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i2);
            this.c0 = -1;
            this.d0 = -1;
            this.a0 = -1;
            this.b0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.e0 = this.t;
            this.f0 = this.v;
            this.g0 = this.z;
            this.h0 = this.f113a;
            this.i0 = this.f114b;
            this.j0 = this.f115c;
            boolean z2 = false;
            if (1 == getLayoutDirection()) {
                int i10 = this.p;
                if (i10 != -1) {
                    this.c0 = i10;
                } else {
                    int i11 = this.q;
                    if (i11 != -1) {
                        this.d0 = i11;
                    }
                    i4 = this.r;
                    if (i4 != -1) {
                        this.b0 = i4;
                        z2 = true;
                    }
                    i5 = this.s;
                    if (i5 != -1) {
                        this.a0 = i5;
                        z2 = true;
                    }
                    i6 = this.x;
                    if (i6 != -1) {
                        this.f0 = i6;
                    }
                    i7 = this.y;
                    if (i7 != -1) {
                        this.e0 = i7;
                    }
                    if (z2) {
                        this.g0 = 1.0f - this.z;
                    }
                    if (this.X && this.R == 1) {
                        f2 = this.f115c;
                        if (f2 == -1.0f) {
                            this.j0 = 1.0f - f2;
                            this.h0 = -1;
                            this.i0 = -1;
                        } else {
                            int i12 = this.f113a;
                            if (i12 != -1) {
                                this.i0 = i12;
                                this.h0 = -1;
                            } else {
                                int i13 = this.f114b;
                                if (i13 != -1) {
                                    this.h0 = i13;
                                    this.i0 = -1;
                                }
                            }
                            this.j0 = -1.0f;
                        }
                    }
                }
                z2 = true;
                i4 = this.r;
                if (i4 != -1) {
                }
                i5 = this.s;
                if (i5 != -1) {
                }
                i6 = this.x;
                if (i6 != -1) {
                }
                i7 = this.y;
                if (i7 != -1) {
                }
                if (z2) {
                }
                f2 = this.f115c;
                if (f2 == -1.0f) {
                }
            } else {
                int i14 = this.p;
                if (i14 != -1) {
                    this.b0 = i14;
                }
                int i15 = this.q;
                if (i15 != -1) {
                    this.a0 = i15;
                }
                int i16 = this.r;
                if (i16 != -1) {
                    this.c0 = i16;
                }
                int i17 = this.s;
                if (i17 != -1) {
                    this.d0 = i17;
                }
                int i18 = this.x;
                if (i18 != -1) {
                    this.e0 = i18;
                }
                int i19 = this.y;
                if (i19 != -1) {
                    this.f0 = i19;
                }
            }
            if (this.r == -1 && this.s == -1 && this.q == -1 && this.p == -1) {
                int i20 = this.f;
                if (i20 != -1) {
                    this.c0 = i20;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0) {
                    }
                    i3 = this.f116d;
                    if (i3 != -1) {
                        this.a0 = i3;
                        if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                            return;
                        }
                    } else {
                        int i21 = this.f117e;
                        if (i21 != -1) {
                            this.b0 = i21;
                            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
                }
                int i22 = this.g;
                if (i22 != -1) {
                    this.d0 = i22;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0) {
                    }
                }
                i3 = this.f116d;
                if (i3 != -1) {
                }
                ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
                ((ViewGroup.MarginLayoutParams) this).rightMargin = i9;
                i3 = this.f116d;
                if (i3 != -1) {
                }
                ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
            }
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f112e.X = this;
        this.f109b.put(getId(), this);
        this.l = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == h.ConstraintLayout_Layout_android_minWidth) {
                    this.f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                } else if (index == h.ConstraintLayout_Layout_android_minHeight) {
                    this.g = obtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                } else if (index == h.ConstraintLayout_Layout_android_maxWidth) {
                    this.h = obtainStyledAttributes.getDimensionPixelOffset(index, this.h);
                } else if (index == h.ConstraintLayout_Layout_android_maxHeight) {
                    this.i = obtainStyledAttributes.getDimensionPixelOffset(index, this.i);
                } else if (index == h.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.k = obtainStyledAttributes.getInt(index, this.k);
                } else if (index == h.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        c cVar = new c();
                        this.l = cVar;
                        cVar.c(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.l = null;
                    }
                    this.m = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f112e.B0 = this.k;
    }

    /* renamed from: a */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
    }

    public Object b(int i2, Object obj) {
        if (i2 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.n;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.n.get(str);
    }

    public final d c(int i2) {
        if (i2 == 0) {
            return this.f112e;
        }
        View view = this.f109b.get(i2);
        if (view == null && (view = findViewById(i2)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f112e;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).k0;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public final d d(View view) {
        if (view == this) {
            return this.f112e;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).k0;
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i4 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = (float) i3;
                        float f3 = (float) i4;
                        float f4 = (float) (i3 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        canvas.drawLine(f2, f3, f4, f3, paint);
                        float parseInt4 = (float) (i4 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        canvas.drawLine(f4, f3, f4, parseInt4, paint);
                        canvas.drawLine(f4, parseInt4, f2, parseInt4, paint);
                        canvas.drawLine(f2, parseInt4, f2, f3, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f2, f3, f4, parseInt4, paint);
                        canvas.drawLine(f2, parseInt4, f4, f3, paint);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02d7  */
    public final void e(int i2, int i3) {
        int i4;
        c.b bVar;
        c.b bVar2;
        c.b bVar3;
        c.b bVar4;
        int i5;
        int i6;
        d.a aVar;
        int i7;
        d.a aVar2;
        boolean z;
        boolean z2;
        boolean z3;
        int i8;
        boolean z4;
        View view;
        int i9;
        boolean z5;
        boolean z6;
        boolean z7;
        int i10;
        boolean z8;
        c.b bVar5;
        d.a aVar3;
        d.a aVar4;
        int baseline;
        ConstraintLayout constraintLayout = this;
        int i11 = i3;
        d.a aVar5 = d.a.MATCH_CONSTRAINT;
        d.a aVar6 = d.a.WRAP_CONTENT;
        c.b bVar6 = c.b.BOTTOM;
        c.b bVar7 = c.b.TOP;
        c.b bVar8 = c.b.RIGHT;
        c.b bVar9 = c.b.LEFT;
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int childCount = getChildCount();
        int i12 = 0;
        while (true) {
            i4 = 8;
            if (i12 >= childCount) {
                break;
            }
            View childAt = constraintLayout.getChildAt(i12);
            if (childAt.getVisibility() == 8) {
                aVar4 = aVar5;
            } else {
                a aVar7 = (a) childAt.getLayoutParams();
                d dVar = aVar7.k0;
                aVar4 = aVar5;
                if (!aVar7.X && !aVar7.Y) {
                    dVar.Y = childAt.getVisibility();
                    int i13 = ((ViewGroup.MarginLayoutParams) aVar7).width;
                    aVar3 = aVar6;
                    int i14 = ((ViewGroup.MarginLayoutParams) aVar7).height;
                    if (i13 == 0 || i14 == 0) {
                        bVar5 = bVar6;
                        dVar.l().b();
                        dVar.k().b();
                        i12++;
                        aVar5 = aVar4;
                        aVar6 = aVar3;
                        bVar6 = bVar5;
                    } else {
                        bVar5 = bVar6;
                        boolean z9 = i13 == -2;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingRight, i13);
                        boolean z10 = i14 == -2;
                        childAt.measure(childMeasureSpec, ViewGroup.getChildMeasureSpec(i11, paddingBottom, i14));
                        int measuredWidth = childAt.getMeasuredWidth();
                        int measuredHeight = childAt.getMeasuredHeight();
                        dVar.C(measuredWidth);
                        dVar.w(measuredHeight);
                        if (z9) {
                            dVar.T = measuredWidth;
                        }
                        if (z10) {
                            dVar.U = measuredHeight;
                        }
                        if (aVar7.W && (baseline = childAt.getBaseline()) != -1) {
                            dVar.Q = baseline;
                        }
                        if (aVar7.U && aVar7.V) {
                            dVar.l().e(measuredWidth);
                            dVar.k().e(measuredHeight);
                        }
                        i12++;
                        aVar5 = aVar4;
                        aVar6 = aVar3;
                        bVar6 = bVar5;
                    }
                }
            }
            aVar3 = aVar6;
            bVar5 = bVar6;
            i12++;
            aVar5 = aVar4;
            aVar6 = aVar3;
            bVar6 = bVar5;
        }
        d.a aVar8 = aVar5;
        d.a aVar9 = aVar6;
        c.b bVar10 = bVar6;
        constraintLayout.f112e.N();
        int i15 = 0;
        while (i15 < childCount) {
            View childAt2 = constraintLayout.getChildAt(i15);
            if (childAt2.getVisibility() != i4) {
                a aVar10 = (a) childAt2.getLayoutParams();
                d dVar2 = aVar10.k0;
                if (!aVar10.X && !aVar10.Y) {
                    dVar2.Y = childAt2.getVisibility();
                    int i16 = ((ViewGroup.MarginLayoutParams) aVar10).width;
                    int i17 = ((ViewGroup.MarginLayoutParams) aVar10).height;
                    if (i16 == 0 || i17 == 0) {
                        j jVar = dVar2.f(bVar9).f897a;
                        i6 = childCount;
                        j jVar2 = dVar2.f(bVar8).f897a;
                        i5 = i15;
                        if (dVar2.f(bVar9).f900d == null || dVar2.f(bVar8).f900d == null) {
                            bVar4 = bVar8;
                            z = false;
                        } else {
                            bVar4 = bVar8;
                            z = true;
                        }
                        j jVar3 = dVar2.f(bVar7).f897a;
                        bVar3 = bVar9;
                        j jVar4 = dVar2.f(bVar10).f897a;
                        boolean z11 = (dVar2.f(bVar7).f900d == null || dVar2.f(bVar10).f900d == null) ? false : true;
                        if (i16 != 0 || i17 != 0 || !z || !z11) {
                            bVar2 = bVar7;
                            bVar = bVar10;
                            aVar = aVar9;
                            boolean z12 = constraintLayout.f112e.i() != aVar;
                            boolean z13 = constraintLayout.f112e.m() != aVar;
                            if (!z12) {
                                dVar2.l().b();
                            }
                            if (!z13) {
                                dVar2.k().b();
                            }
                            if (i16 == 0) {
                                if (z12) {
                                    if (dVar2.f914e == 0 && dVar2.G == 0.0f && dVar2.h == 0 && dVar2.i == 0) {
                                        z2 = false;
                                        aVar2 = aVar8;
                                        if (dVar2.C[0] == aVar2) {
                                            z8 = true;
                                            if (z8 && z && jVar.c() && jVar2.c()) {
                                                int i18 = (int) (jVar2.g - jVar.g);
                                                dVar2.l().e(i18);
                                                i10 = ViewGroup.getChildMeasureSpec(i2, paddingRight, i18);
                                            }
                                        }
                                    } else {
                                        aVar2 = aVar8;
                                        z2 = false;
                                    }
                                    z8 = z2;
                                    int i182 = (int) (jVar2.g - jVar.g);
                                    dVar2.l().e(i182);
                                    i10 = ViewGroup.getChildMeasureSpec(i2, paddingRight, i182);
                                } else {
                                    aVar2 = aVar8;
                                    z2 = false;
                                }
                                i8 = ViewGroup.getChildMeasureSpec(i2, paddingRight, -2);
                                z3 = z2;
                                z4 = true;
                                if (i17 == 0) {
                                    if (z13) {
                                        if (dVar2.f == 0 && dVar2.G == 0.0f && dVar2.k == 0 && dVar2.l == 0) {
                                            z6 = true;
                                            if (dVar2.C[1] == aVar2) {
                                                z7 = true;
                                                if (z7 || !z11 || !jVar3.c() || !jVar4.c()) {
                                                    i7 = i3;
                                                } else {
                                                    int i19 = (int) (jVar4.g - jVar3.g);
                                                    dVar2.k().e(i19);
                                                    i7 = i3;
                                                    i9 = ViewGroup.getChildMeasureSpec(i7, paddingBottom, i19);
                                                    z5 = z2;
                                                    view = childAt2;
                                                    view.measure(i8, i9);
                                                    int measuredWidth2 = view.getMeasuredWidth();
                                                    int measuredHeight2 = view.getMeasuredHeight();
                                                    dVar2.C(measuredWidth2);
                                                    dVar2.w(measuredHeight2);
                                                    if (z4) {
                                                        dVar2.T = measuredWidth2;
                                                    }
                                                    if (z5) {
                                                        dVar2.U = measuredHeight2;
                                                    }
                                                    if (!z3) {
                                                        dVar2.l().e(measuredWidth2);
                                                    } else {
                                                        dVar2.l().f930b = 2;
                                                    }
                                                    k k2 = dVar2.k();
                                                    if (!z13) {
                                                        k2.e(measuredHeight2);
                                                    } else {
                                                        k2.f930b = 2;
                                                    }
                                                    if (!aVar10.W) {
                                                        int baseline2 = view.getBaseline();
                                                        if (baseline2 != -1) {
                                                            dVar2.Q = baseline2;
                                                        }
                                                    }
                                                    aVar8 = aVar2;
                                                    i15 = i5 + 1;
                                                    i11 = i7;
                                                    aVar9 = aVar;
                                                    childCount = i6;
                                                    bVar8 = bVar4;
                                                    bVar9 = bVar3;
                                                    bVar7 = bVar2;
                                                    bVar10 = bVar;
                                                    i4 = 8;
                                                    constraintLayout = this;
                                                }
                                            }
                                        } else {
                                            z6 = true;
                                        }
                                        z7 = z2;
                                        if (z7) {
                                        }
                                        i7 = i3;
                                    } else {
                                        i7 = i3;
                                        z6 = true;
                                    }
                                    i9 = ViewGroup.getChildMeasureSpec(i7, paddingBottom, -2);
                                    z5 = z6;
                                    z13 = z2;
                                } else {
                                    i7 = i3;
                                    if (i17 == -1) {
                                        i9 = ViewGroup.getChildMeasureSpec(i7, paddingBottom, -1);
                                        z5 = z2;
                                    } else {
                                        z5 = i17 == -2 ? true : z2;
                                        i9 = ViewGroup.getChildMeasureSpec(i7, paddingBottom, i17);
                                    }
                                }
                                view = childAt2;
                                view.measure(i8, i9);
                                int measuredWidth22 = view.getMeasuredWidth();
                                int measuredHeight22 = view.getMeasuredHeight();
                                dVar2.C(measuredWidth22);
                                dVar2.w(measuredHeight22);
                                if (z4) {
                                }
                                if (z5) {
                                }
                                if (!z3) {
                                }
                                k k22 = dVar2.k();
                                if (!z13) {
                                }
                                if (!aVar10.W) {
                                }
                                aVar8 = aVar2;
                                i15 = i5 + 1;
                                i11 = i7;
                                aVar9 = aVar;
                                childCount = i6;
                                bVar8 = bVar4;
                                bVar9 = bVar3;
                                bVar7 = bVar2;
                                bVar10 = bVar;
                                i4 = 8;
                                constraintLayout = this;
                            } else {
                                aVar2 = aVar8;
                                z2 = false;
                                if (i16 == -1) {
                                    i10 = ViewGroup.getChildMeasureSpec(i2, paddingRight, -1);
                                } else {
                                    z4 = i16 == -2;
                                    z3 = z12;
                                    i8 = ViewGroup.getChildMeasureSpec(i2, paddingRight, i16);
                                    if (i17 == 0) {
                                    }
                                    view = childAt2;
                                    view.measure(i8, i9);
                                    int measuredWidth222 = view.getMeasuredWidth();
                                    int measuredHeight222 = view.getMeasuredHeight();
                                    dVar2.C(measuredWidth222);
                                    dVar2.w(measuredHeight222);
                                    if (z4) {
                                    }
                                    if (z5) {
                                    }
                                    if (!z3) {
                                    }
                                    k k222 = dVar2.k();
                                    if (!z13) {
                                    }
                                    if (!aVar10.W) {
                                    }
                                    aVar8 = aVar2;
                                    i15 = i5 + 1;
                                    i11 = i7;
                                    aVar9 = aVar;
                                    childCount = i6;
                                    bVar8 = bVar4;
                                    bVar9 = bVar3;
                                    bVar7 = bVar2;
                                    bVar10 = bVar;
                                    i4 = 8;
                                    constraintLayout = this;
                                }
                            }
                            z3 = z12;
                            i8 = i10;
                            z4 = z2;
                            if (i17 == 0) {
                            }
                            view = childAt2;
                            view.measure(i8, i9);
                            int measuredWidth2222 = view.getMeasuredWidth();
                            int measuredHeight2222 = view.getMeasuredHeight();
                            dVar2.C(measuredWidth2222);
                            dVar2.w(measuredHeight2222);
                            if (z4) {
                            }
                            if (z5) {
                            }
                            if (!z3) {
                            }
                            k k2222 = dVar2.k();
                            if (!z13) {
                            }
                            if (!aVar10.W) {
                            }
                            aVar8 = aVar2;
                            i15 = i5 + 1;
                            i11 = i7;
                            aVar9 = aVar;
                            childCount = i6;
                            bVar8 = bVar4;
                            bVar9 = bVar3;
                            bVar7 = bVar2;
                            bVar10 = bVar;
                            i4 = 8;
                            constraintLayout = this;
                        } else {
                            i7 = i11;
                            bVar2 = bVar7;
                            bVar = bVar10;
                            aVar2 = aVar8;
                            aVar = aVar9;
                            aVar8 = aVar2;
                            i15 = i5 + 1;
                            i11 = i7;
                            aVar9 = aVar;
                            childCount = i6;
                            bVar8 = bVar4;
                            bVar9 = bVar3;
                            bVar7 = bVar2;
                            bVar10 = bVar;
                            i4 = 8;
                            constraintLayout = this;
                        }
                    }
                }
            }
            i7 = i11;
            i5 = i15;
            bVar2 = bVar7;
            bVar4 = bVar8;
            bVar3 = bVar9;
            i6 = childCount;
            aVar2 = aVar8;
            aVar = aVar9;
            bVar = bVar10;
            aVar8 = aVar2;
            i15 = i5 + 1;
            i11 = i7;
            aVar9 = aVar;
            childCount = i6;
            bVar8 = bVar4;
            bVar9 = bVar3;
            bVar7 = bVar2;
            bVar10 = bVar;
            i4 = 8;
            constraintLayout = this;
        }
    }

    public void f(int i2, Object obj, Object obj2) {
        if (i2 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.n == null) {
                this.n = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.n.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public void g() {
        this.f112e.F();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public int getMaxHeight() {
        return this.i;
    }

    public int getMaxWidth() {
        return this.h;
    }

    public int getMinHeight() {
        return this.g;
    }

    public int getMinWidth() {
        return this.f;
    }

    public int getOptimizationLevel() {
        return this.f112e.B0;
    }

    public final void h() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof f) {
                ((f) childAt).a();
            }
        }
        int size = this.f110c.size();
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                this.f110c.get(i3).d();
            }
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            a aVar = (a) childAt.getLayoutParams();
            d dVar = aVar.k0;
            if ((childAt.getVisibility() != 8 || aVar.X || aVar.Y || isInEditMode) && !aVar.Z) {
                int i7 = dVar.M + dVar.O;
                int i8 = dVar.N + dVar.P;
                int n2 = dVar.n() + i7;
                int h2 = dVar.h() + i8;
                childAt.layout(i7, i8, n2, h2);
                if ((childAt instanceof f) && (content = ((f) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(i7, i8, n2, h2);
                }
            }
        }
        int size = this.f110c.size();
        if (size > 0) {
            for (int i9 = 0; i9 < size; i9++) {
                this.f110c.get(i9).c();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:383:0x0843, code lost:
        if (r13.H != 1) goto L_0x0847;
     */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0524  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0530 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0569  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x057c  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x059d  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x05ac  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x05c7  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x06ab  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x073c  */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x0860  */
    /* JADX WARNING: Removed duplicated region for block: B:419:0x08b2  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x08c3  */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x08c7  */
    /* JADX WARNING: Removed duplicated region for block: B:462:0x095a  */
    /* JADX WARNING: Removed duplicated region for block: B:484:0x09ac  */
    /* JADX WARNING: Removed duplicated region for block: B:487:0x09b4  */
    /* JADX WARNING: Removed duplicated region for block: B:490:0x09cb  */
    /* JADX WARNING: Removed duplicated region for block: B:592:0x0bb4  */
    /* JADX WARNING: Removed duplicated region for block: B:595:0x0be8  */
    /* JADX WARNING: Removed duplicated region for block: B:598:0x0bef  */
    public void onMeasure(int i2, int i3) {
        d.a aVar;
        d.a aVar2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        d.a aVar3;
        c.b bVar;
        boolean z;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z2;
        boolean z3;
        boolean z4;
        int baseline;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int size;
        int i24;
        boolean z5;
        boolean z6;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        boolean z7;
        d.a aVar4;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        d.a aVar5;
        d.a aVar6;
        d.a aVar7;
        c.b bVar2;
        c.b bVar3;
        c.b bVar4;
        c.b bVar5;
        c.b bVar6;
        int i36;
        String str;
        int i37;
        int i38;
        float f2;
        int i39;
        int i40;
        int i41;
        int i42;
        float f3;
        d c2;
        int i43;
        int i44;
        c.b bVar7;
        int i45;
        int i46;
        c.b bVar8;
        d dVar;
        d c3;
        int i47;
        c.b bVar9;
        d dVar2;
        d c4;
        int i48;
        c.b bVar10;
        d dVar3;
        d c5;
        d.a aVar8;
        int i49;
        int i50;
        int i51;
        int i52;
        ConstraintLayout constraintLayout = this;
        c.b bVar11 = c.b.BOTTOM;
        c.b bVar12 = c.b.RIGHT;
        d.a aVar9 = d.a.WRAP_CONTENT;
        d.a aVar10 = d.a.FIXED;
        System.currentTimeMillis();
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size3 = View.MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        e eVar = constraintLayout.f112e;
        eVar.I = paddingLeft;
        eVar.J = paddingTop;
        int i53 = constraintLayout.h;
        int[] iArr = eVar.q;
        iArr[0] = i53;
        iArr[1] = constraintLayout.i;
        eVar.k0 = getLayoutDirection() == 1;
        int mode3 = View.MeasureSpec.getMode(i2);
        int size4 = View.MeasureSpec.getSize(i2);
        int mode4 = View.MeasureSpec.getMode(i3);
        int size5 = View.MeasureSpec.getSize(i3);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingRight = getPaddingRight() + getPaddingLeft();
        getLayoutParams();
        if (mode3 != Integer.MIN_VALUE) {
            if (mode3 == 0) {
                aVar = aVar9;
            } else if (mode3 != 1073741824) {
                aVar = aVar10;
            } else {
                size4 = Math.min(constraintLayout.h, size4) - paddingRight;
                aVar = aVar10;
            }
            size4 = 0;
        } else {
            aVar = aVar9;
        }
        if (mode4 != Integer.MIN_VALUE) {
            if (mode4 == 0) {
                aVar2 = aVar9;
            } else if (mode4 != 1073741824) {
                aVar2 = aVar10;
            } else {
                size5 = Math.min(constraintLayout.i, size5) - paddingBottom;
                aVar2 = aVar10;
            }
            size5 = 0;
        } else {
            aVar2 = aVar9;
        }
        e eVar2 = constraintLayout.f112e;
        eVar2.R = 0;
        eVar2.S = 0;
        eVar2.y(aVar);
        constraintLayout.f112e.C(size4);
        constraintLayout.f112e.B(aVar2);
        constraintLayout.f112e.w(size5);
        e eVar3 = constraintLayout.f112e;
        int paddingLeft2 = (constraintLayout.f - getPaddingLeft()) - getPaddingRight();
        if (paddingLeft2 < 0) {
            paddingLeft2 = 0;
        }
        eVar3.R = paddingLeft2;
        e eVar4 = constraintLayout.f112e;
        int paddingTop2 = (constraintLayout.g - getPaddingTop()) - getPaddingBottom();
        if (paddingTop2 < 0) {
            paddingTop2 = 0;
        }
        eVar4.S = paddingTop2;
        int n2 = constraintLayout.f112e.n();
        int h2 = constraintLayout.f112e.h();
        if (constraintLayout.j) {
            constraintLayout.j = false;
            int childCount = getChildCount();
            int i54 = 0;
            while (true) {
                if (i54 >= childCount) {
                    z7 = false;
                    break;
                } else if (constraintLayout.getChildAt(i54).isLayoutRequested()) {
                    z7 = true;
                    break;
                } else {
                    i54++;
                }
            }
            if (z7) {
                constraintLayout.f111d.clear();
                c.b bVar13 = c.b.BASELINE;
                d.a aVar11 = d.a.MATCH_PARENT;
                d.a aVar12 = d.a.MATCH_CONSTRAINT;
                c.b bVar14 = c.b.LEFT;
                i8 = mode;
                c.b bVar15 = c.b.TOP;
                boolean isInEditMode = isInEditMode();
                int childCount2 = getChildCount();
                d.a aVar13 = aVar11;
                if (isInEditMode) {
                    int i55 = 0;
                    while (i55 < childCount2) {
                        View childAt = constraintLayout.getChildAt(i55);
                        try {
                            i52 = paddingTop;
                            try {
                                String resourceName = getResources().getResourceName(childAt.getId());
                                i51 = paddingLeft;
                                try {
                                    constraintLayout.f(0, resourceName, Integer.valueOf(childAt.getId()));
                                    int indexOf = resourceName.indexOf(47);
                                    if (indexOf != -1) {
                                        resourceName = resourceName.substring(indexOf + 1);
                                    }
                                    constraintLayout.c(childAt.getId()).Z = resourceName;
                                } catch (Resources.NotFoundException unused) {
                                }
                            } catch (Resources.NotFoundException unused2) {
                                i51 = paddingLeft;
                                i55++;
                                bVar13 = bVar13;
                                paddingTop = i52;
                                paddingLeft = i51;
                            }
                        } catch (Resources.NotFoundException unused3) {
                            i52 = paddingTop;
                            i51 = paddingLeft;
                            i55++;
                            bVar13 = bVar13;
                            paddingTop = i52;
                            paddingLeft = i51;
                        }
                        i55++;
                        bVar13 = bVar13;
                        paddingTop = i52;
                        paddingLeft = i51;
                    }
                }
                c.b bVar16 = bVar13;
                int i56 = paddingTop;
                int i57 = paddingLeft;
                for (int i58 = 0; i58 < childCount2; i58++) {
                    d d2 = constraintLayout.d(constraintLayout.getChildAt(i58));
                    if (d2 != null) {
                        d2.r();
                    }
                }
                if (constraintLayout.m != -1) {
                    for (int i59 = 0; i59 < childCount2; i59++) {
                        View childAt2 = constraintLayout.getChildAt(i59);
                        if (childAt2.getId() == constraintLayout.m && (childAt2 instanceof b.g.b.d)) {
                            constraintLayout.l = ((b.g.b.d) childAt2).getConstraintSet();
                        }
                    }
                }
                b.g.b.c cVar = constraintLayout.l;
                if (cVar != null) {
                    int childCount3 = getChildCount();
                    HashSet hashSet = new HashSet(cVar.f947a.keySet());
                    int i60 = 0;
                    while (i60 < childCount3) {
                        View childAt3 = constraintLayout.getChildAt(i60);
                        int id = childAt3.getId();
                        if (id != -1) {
                            if (cVar.f947a.containsKey(Integer.valueOf(id))) {
                                hashSet.remove(Integer.valueOf(id));
                                c.a aVar14 = cVar.f947a.get(Integer.valueOf(id));
                                if (childAt3 instanceof b.g.b.a) {
                                    i50 = 1;
                                    aVar14.t0 = 1;
                                } else {
                                    i50 = 1;
                                }
                                i49 = h2;
                                int i61 = aVar14.t0;
                                aVar8 = aVar10;
                                if (i61 != -1 && i61 == i50) {
                                    b.g.b.a aVar15 = (b.g.b.a) childAt3;
                                    aVar15.setId(id);
                                    aVar15.setType(aVar14.s0);
                                    aVar15.setAllowsGoneWidget(aVar14.r0);
                                    int[] iArr2 = aVar14.u0;
                                    if (iArr2 != null) {
                                        aVar15.setReferencedIds(iArr2);
                                    } else {
                                        String str2 = aVar14.v0;
                                        if (str2 != null) {
                                            int[] a2 = cVar.a(aVar15, str2);
                                            aVar14.u0 = a2;
                                            aVar15.setReferencedIds(a2);
                                        }
                                    }
                                }
                                a aVar16 = (a) childAt3.getLayoutParams();
                                aVar14.a(aVar16);
                                childAt3.setLayoutParams(aVar16);
                                childAt3.setVisibility(aVar14.J);
                                childAt3.setAlpha(aVar14.U);
                                childAt3.setRotation(aVar14.X);
                                childAt3.setRotationX(aVar14.Y);
                                childAt3.setRotationY(aVar14.Z);
                                childAt3.setScaleX(aVar14.a0);
                                childAt3.setScaleY(aVar14.b0);
                                if (!Float.isNaN(aVar14.c0)) {
                                    childAt3.setPivotX(aVar14.c0);
                                }
                                if (!Float.isNaN(aVar14.d0)) {
                                    childAt3.setPivotY(aVar14.d0);
                                }
                                childAt3.setTranslationX(aVar14.e0);
                                childAt3.setTranslationY(aVar14.f0);
                                childAt3.setTranslationZ(aVar14.g0);
                                if (aVar14.V) {
                                    childAt3.setElevation(aVar14.W);
                                }
                            } else {
                                aVar8 = aVar10;
                                i49 = h2;
                            }
                            i60++;
                            childCount3 = childCount3;
                            size3 = size3;
                            n2 = n2;
                            h2 = i49;
                            aVar10 = aVar8;
                        } else {
                            throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                        }
                    }
                    i30 = size3;
                    i6 = n2;
                    aVar4 = aVar10;
                    i5 = h2;
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        c.a aVar17 = cVar.f947a.get(num);
                        int i62 = aVar17.t0;
                        if (i62 != -1 && i62 == 1) {
                            b.g.b.a aVar18 = new b.g.b.a(getContext());
                            aVar18.setId(num.intValue());
                            int[] iArr3 = aVar17.u0;
                            if (iArr3 != null) {
                                aVar18.setReferencedIds(iArr3);
                            } else {
                                String str3 = aVar17.v0;
                                if (str3 != null) {
                                    int[] a3 = cVar.a(aVar18, str3);
                                    aVar17.u0 = a3;
                                    aVar18.setReferencedIds(a3);
                                }
                            }
                            aVar18.setType(aVar17.s0);
                            a a4 = generateDefaultLayoutParams();
                            aVar18.f();
                            aVar17.a(a4);
                            constraintLayout.addView(aVar18, a4);
                        }
                        if (aVar17.f948a) {
                            b.g.b.e eVar5 = new b.g.b.e(getContext());
                            eVar5.setId(num.intValue());
                            a a5 = generateDefaultLayoutParams();
                            aVar17.a(a5);
                            constraintLayout.addView(eVar5, a5);
                        }
                    }
                } else {
                    i30 = size3;
                    i6 = n2;
                    aVar4 = aVar10;
                    i5 = h2;
                }
                constraintLayout.f112e.j0.clear();
                int size6 = constraintLayout.f110c.size();
                if (size6 > 0) {
                    for (int i63 = 0; i63 < size6; i63++) {
                        constraintLayout.f110c.get(i63).e(constraintLayout);
                    }
                }
                for (int i64 = 0; i64 < childCount2; i64++) {
                    View childAt4 = constraintLayout.getChildAt(i64);
                    if (childAt4 instanceof f) {
                        f fVar = (f) childAt4;
                        if (fVar.f954b == -1 && !fVar.isInEditMode()) {
                            fVar.setVisibility(fVar.f956d);
                        }
                        View findViewById = constraintLayout.findViewById(fVar.f954b);
                        fVar.f955c = findViewById;
                        if (findViewById != null) {
                            ((a) findViewById.getLayoutParams()).Z = true;
                            fVar.f955c.setVisibility(0);
                            fVar.setVisibility(0);
                        }
                    }
                }
                int i65 = 0;
                while (i65 < childCount2) {
                    View childAt5 = constraintLayout.getChildAt(i65);
                    d d3 = constraintLayout.d(childAt5);
                    if (d3 != null) {
                        a aVar19 = (a) childAt5.getLayoutParams();
                        aVar19.a();
                        if (aVar19.l0) {
                            aVar19.l0 = false;
                        } else if (isInEditMode) {
                            try {
                                String resourceName2 = getResources().getResourceName(childAt5.getId());
                                constraintLayout.f(0, resourceName2, Integer.valueOf(childAt5.getId()));
                                constraintLayout.c(childAt5.getId()).Z = resourceName2.substring(resourceName2.indexOf("id/") + 3);
                            } catch (Resources.NotFoundException unused4) {
                            }
                        }
                        d3.Y = childAt5.getVisibility();
                        if (aVar19.Z) {
                            d3.Y = 8;
                        }
                        d3.X = childAt5;
                        e eVar6 = constraintLayout.f112e;
                        eVar6.j0.add(d3);
                        d dVar4 = d3.D;
                        if (dVar4 != null) {
                            ((n) dVar4).j0.remove(d3);
                            d3.D = null;
                        }
                        d3.D = eVar6;
                        if (!aVar19.V || !aVar19.U) {
                            constraintLayout.f111d.add(d3);
                        }
                        if (aVar19.X) {
                            g gVar = (g) d3;
                            int i66 = aVar19.h0;
                            int i67 = aVar19.i0;
                            float f4 = aVar19.j0;
                            int i68 = (f4 > -1.0f ? 1 : (f4 == -1.0f ? 0 : -1));
                            if (i68 != 0) {
                                if (i68 > 0) {
                                    gVar.j0 = f4;
                                    gVar.k0 = -1;
                                    gVar.l0 = -1;
                                }
                            } else if (i66 != -1) {
                                if (i66 > -1) {
                                    gVar.j0 = -1.0f;
                                    gVar.k0 = i66;
                                    gVar.l0 = -1;
                                }
                            } else if (i67 != -1 && i67 > -1) {
                                gVar.j0 = -1.0f;
                                gVar.k0 = -1;
                                gVar.l0 = i67;
                            }
                        } else if (!(aVar19.f116d == -1 && aVar19.f117e == -1 && aVar19.f == -1 && aVar19.g == -1 && aVar19.q == -1 && aVar19.p == -1 && aVar19.r == -1 && aVar19.s == -1 && aVar19.h == -1 && aVar19.i == -1 && aVar19.j == -1 && aVar19.k == -1 && aVar19.l == -1 && aVar19.P == -1 && aVar19.Q == -1 && aVar19.m == -1 && ((ViewGroup.MarginLayoutParams) aVar19).width != -1 && ((ViewGroup.MarginLayoutParams) aVar19).height != -1)) {
                            int i69 = aVar19.a0;
                            int i70 = aVar19.b0;
                            int i71 = aVar19.c0;
                            int i72 = aVar19.d0;
                            int i73 = aVar19.e0;
                            int i74 = aVar19.f0;
                            i33 = childCount2;
                            float f5 = aVar19.g0;
                            i32 = i65;
                            int i75 = aVar19.m;
                            if (i75 != -1) {
                                d c6 = constraintLayout.c(i75);
                                if (c6 != null) {
                                    float f6 = aVar19.o;
                                    int i76 = aVar19.n;
                                    c.b bVar17 = c.b.CENTER;
                                    d3.o(bVar17, c6, bVar17, i76, 0);
                                    d3.r = f6;
                                }
                                bVar5 = bVar14;
                                aVar5 = aVar13;
                                bVar4 = bVar16;
                                i35 = i56;
                                i34 = i57;
                                i31 = i30;
                                bVar6 = bVar12;
                                i36 = -1;
                            } else {
                                if (i69 != -1) {
                                    d c7 = constraintLayout.c(i69);
                                    if (c7 != null) {
                                        dVar3 = c7;
                                        i48 = ((ViewGroup.MarginLayoutParams) aVar19).leftMargin;
                                        bVar10 = bVar14;
                                    }
                                    if (i71 != -1) {
                                        d c8 = constraintLayout.c(i71);
                                        if (c8 != null) {
                                            dVar2 = c8;
                                            i47 = ((ViewGroup.MarginLayoutParams) aVar19).rightMargin;
                                            bVar9 = bVar14;
                                        }
                                        bVar5 = bVar14;
                                        aVar5 = aVar13;
                                        i35 = i56;
                                        i31 = i30;
                                        bVar6 = bVar12;
                                        i36 = -1;
                                        bVar4 = bVar16;
                                        i34 = i57;
                                        i40 = aVar19.h;
                                        if (i40 != i36) {
                                            d c9 = constraintLayout.c(i40);
                                            if (c9 != null) {
                                                dVar = c9;
                                                i46 = ((ViewGroup.MarginLayoutParams) aVar19).topMargin;
                                                i45 = aVar19.u;
                                                bVar8 = bVar15;
                                            }
                                            i41 = aVar19.j;
                                            if (i41 != i36) {
                                                c2 = constraintLayout.c(i41);
                                                if (c2 != null) {
                                                    i43 = ((ViewGroup.MarginLayoutParams) aVar19).bottomMargin;
                                                    i44 = aVar19.w;
                                                    bVar7 = bVar15;
                                                }
                                                i42 = aVar19.l;
                                                if (i42 != i36) {
                                                    View view = constraintLayout.f109b.get(i42);
                                                    d c10 = constraintLayout.c(aVar19.l);
                                                    if (!(c10 == null || view == null || !(view.getLayoutParams() instanceof a))) {
                                                        aVar19.W = true;
                                                        ((a) view.getLayoutParams()).W = true;
                                                        d3.f(bVar4).a(c10.f(bVar4), 0, -1, c.a.STRONG, 0, true);
                                                        d3.f(bVar15).d();
                                                        d3.f(bVar11).d();
                                                    }
                                                }
                                                if (f5 >= 0.0f && f5 != 0.5f) {
                                                    d3.V = f5;
                                                }
                                                f3 = aVar19.A;
                                                if (f3 >= 0.0f && f3 != 0.5f) {
                                                    d3.W = f3;
                                                }
                                            } else {
                                                int i77 = aVar19.k;
                                                if (!(i77 == i36 || (c2 = constraintLayout.c(i77)) == null)) {
                                                    i43 = ((ViewGroup.MarginLayoutParams) aVar19).bottomMargin;
                                                    i44 = aVar19.w;
                                                    bVar7 = bVar11;
                                                }
                                                i42 = aVar19.l;
                                                if (i42 != i36) {
                                                }
                                                d3.V = f5;
                                                f3 = aVar19.A;
                                                d3.W = f3;
                                            }
                                            d3.o(bVar11, c2, bVar7, i43, i44);
                                            i42 = aVar19.l;
                                            if (i42 != i36) {
                                            }
                                            d3.V = f5;
                                            f3 = aVar19.A;
                                            d3.W = f3;
                                        } else {
                                            int i78 = aVar19.i;
                                            if (!(i78 == i36 || (c3 = constraintLayout.c(i78)) == null)) {
                                                dVar = c3;
                                                i46 = ((ViewGroup.MarginLayoutParams) aVar19).topMargin;
                                                i45 = aVar19.u;
                                                bVar8 = bVar11;
                                            }
                                            i41 = aVar19.j;
                                            if (i41 != i36) {
                                            }
                                            d3.o(bVar11, c2, bVar7, i43, i44);
                                            i42 = aVar19.l;
                                            if (i42 != i36) {
                                            }
                                            d3.V = f5;
                                            f3 = aVar19.A;
                                            d3.W = f3;
                                        }
                                        d3.o(bVar15, dVar, bVar8, i46, i45);
                                        i41 = aVar19.j;
                                        if (i41 != i36) {
                                        }
                                        d3.o(bVar11, c2, bVar7, i43, i44);
                                        i42 = aVar19.l;
                                        if (i42 != i36) {
                                        }
                                        d3.V = f5;
                                        f3 = aVar19.A;
                                        d3.W = f3;
                                    } else {
                                        if (!(i72 == -1 || (c4 = constraintLayout.c(i72)) == null)) {
                                            dVar2 = c4;
                                            i47 = ((ViewGroup.MarginLayoutParams) aVar19).rightMargin;
                                            bVar9 = bVar12;
                                        }
                                        bVar5 = bVar14;
                                        aVar5 = aVar13;
                                        i35 = i56;
                                        i31 = i30;
                                        bVar6 = bVar12;
                                        i36 = -1;
                                        bVar4 = bVar16;
                                        i34 = i57;
                                        i40 = aVar19.h;
                                        if (i40 != i36) {
                                        }
                                        d3.o(bVar15, dVar, bVar8, i46, i45);
                                        i41 = aVar19.j;
                                        if (i41 != i36) {
                                        }
                                        d3.o(bVar11, c2, bVar7, i43, i44);
                                        i42 = aVar19.l;
                                        if (i42 != i36) {
                                        }
                                        d3.V = f5;
                                        f3 = aVar19.A;
                                        d3.W = f3;
                                    }
                                    aVar5 = aVar13;
                                    bVar4 = bVar16;
                                    bVar5 = bVar14;
                                    bVar6 = bVar12;
                                    i36 = -1;
                                    i35 = i56;
                                    i34 = i57;
                                    i31 = i30;
                                    d3.o(bVar12, dVar2, bVar9, i47, i74);
                                    i40 = aVar19.h;
                                    if (i40 != i36) {
                                    }
                                    d3.o(bVar15, dVar, bVar8, i46, i45);
                                    i41 = aVar19.j;
                                    if (i41 != i36) {
                                    }
                                    d3.o(bVar11, c2, bVar7, i43, i44);
                                    i42 = aVar19.l;
                                    if (i42 != i36) {
                                    }
                                    d3.V = f5;
                                    f3 = aVar19.A;
                                    d3.W = f3;
                                } else {
                                    if (!(i70 == -1 || (c5 = constraintLayout.c(i70)) == null)) {
                                        dVar3 = c5;
                                        i48 = ((ViewGroup.MarginLayoutParams) aVar19).leftMargin;
                                        bVar10 = bVar12;
                                    }
                                    if (i71 != -1) {
                                    }
                                    aVar5 = aVar13;
                                    bVar4 = bVar16;
                                    bVar5 = bVar14;
                                    bVar6 = bVar12;
                                    i36 = -1;
                                    i35 = i56;
                                    i34 = i57;
                                    i31 = i30;
                                    d3.o(bVar12, dVar2, bVar9, i47, i74);
                                    i40 = aVar19.h;
                                    if (i40 != i36) {
                                    }
                                    d3.o(bVar15, dVar, bVar8, i46, i45);
                                    i41 = aVar19.j;
                                    if (i41 != i36) {
                                    }
                                    d3.o(bVar11, c2, bVar7, i43, i44);
                                    i42 = aVar19.l;
                                    if (i42 != i36) {
                                    }
                                    d3.V = f5;
                                    f3 = aVar19.A;
                                    d3.W = f3;
                                }
                                d3.o(bVar14, dVar3, bVar10, i48, i73);
                                if (i71 != -1) {
                                }
                                aVar5 = aVar13;
                                bVar4 = bVar16;
                                bVar5 = bVar14;
                                bVar6 = bVar12;
                                i36 = -1;
                                i35 = i56;
                                i34 = i57;
                                i31 = i30;
                                d3.o(bVar12, dVar2, bVar9, i47, i74);
                                i40 = aVar19.h;
                                if (i40 != i36) {
                                }
                                d3.o(bVar15, dVar, bVar8, i46, i45);
                                i41 = aVar19.j;
                                if (i41 != i36) {
                                }
                                d3.o(bVar11, c2, bVar7, i43, i44);
                                i42 = aVar19.l;
                                if (i42 != i36) {
                                }
                                d3.V = f5;
                                f3 = aVar19.A;
                                d3.W = f3;
                            }
                            if (isInEditMode && !(aVar19.P == i36 && aVar19.Q == i36)) {
                                int i79 = aVar19.P;
                                int i80 = aVar19.Q;
                                d3.I = i79;
                                d3.J = i80;
                            }
                            if (aVar19.U) {
                                bVar2 = bVar6;
                                aVar6 = aVar4;
                                aVar7 = aVar12;
                                bVar3 = bVar5;
                                d3.y(aVar6);
                                d3.C(((ViewGroup.MarginLayoutParams) aVar19).width);
                            } else if (((ViewGroup.MarginLayoutParams) aVar19).width == i36) {
                                d3.y(aVar5);
                                bVar3 = bVar5;
                                d3.f(bVar3).f901e = ((ViewGroup.MarginLayoutParams) aVar19).leftMargin;
                                bVar2 = bVar6;
                                d3.f(bVar2).f901e = ((ViewGroup.MarginLayoutParams) aVar19).rightMargin;
                                aVar6 = aVar4;
                                aVar7 = aVar12;
                            } else {
                                bVar2 = bVar6;
                                aVar7 = aVar12;
                                bVar3 = bVar5;
                                d3.y(aVar7);
                                d3.C(0);
                                aVar6 = aVar4;
                            }
                            if (aVar19.V) {
                                d3.B(aVar6);
                                i39 = ((ViewGroup.MarginLayoutParams) aVar19).height;
                            } else if (((ViewGroup.MarginLayoutParams) aVar19).height == i36) {
                                d3.B(aVar5);
                                d3.f(bVar15).f901e = ((ViewGroup.MarginLayoutParams) aVar19).topMargin;
                                d3.f(bVar11).f901e = ((ViewGroup.MarginLayoutParams) aVar19).bottomMargin;
                                str = aVar19.B;
                                if (str != null) {
                                    if (str.length() == 0) {
                                        d3.G = 0.0f;
                                    } else {
                                        int length = str.length();
                                        int indexOf2 = str.indexOf(44);
                                        if (indexOf2 <= 0 || indexOf2 >= length - 1) {
                                            i38 = 0;
                                            i37 = -1;
                                        } else {
                                            String substring = str.substring(0, indexOf2);
                                            i37 = substring.equalsIgnoreCase("W") ? 0 : substring.equalsIgnoreCase("H") ? 1 : -1;
                                            i38 = indexOf2 + 1;
                                        }
                                        int indexOf3 = str.indexOf(58);
                                        if (indexOf3 < 0 || indexOf3 >= length - 1) {
                                            String substring2 = str.substring(i38);
                                            if (substring2.length() > 0) {
                                                f2 = Float.parseFloat(substring2);
                                                if (f2 > 0.0f) {
                                                    d3.G = f2;
                                                    d3.H = i37;
                                                }
                                            }
                                        } else {
                                            String substring3 = str.substring(i38, indexOf3);
                                            String substring4 = str.substring(indexOf3 + 1);
                                            if (substring3.length() > 0 && substring4.length() > 0) {
                                                try {
                                                    float parseFloat = Float.parseFloat(substring3);
                                                    float parseFloat2 = Float.parseFloat(substring4);
                                                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                        f2 = i37 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                                                        if (f2 > 0.0f) {
                                                        }
                                                    }
                                                } catch (NumberFormatException unused5) {
                                                }
                                            }
                                        }
                                        f2 = 0.0f;
                                        if (f2 > 0.0f) {
                                        }
                                    }
                                }
                                float f7 = aVar19.D;
                                float[] fArr = d3.g0;
                                fArr[0] = f7;
                                fArr[1] = aVar19.E;
                                d3.e0 = aVar19.F;
                                d3.f0 = aVar19.G;
                                int i81 = aVar19.H;
                                int i82 = aVar19.J;
                                int i83 = aVar19.L;
                                float f8 = aVar19.N;
                                d3.f914e = i81;
                                d3.h = i82;
                                d3.i = i83;
                                d3.j = f8;
                                if (f8 < 1.0f && i81 == 0) {
                                    d3.f914e = 2;
                                }
                                int i84 = aVar19.I;
                                int i85 = aVar19.K;
                                int i86 = aVar19.M;
                                float f9 = aVar19.O;
                                d3.f = i84;
                                d3.k = i85;
                                d3.l = i86;
                                d3.m = f9;
                                if (f9 < 1.0f && i84 == 0) {
                                    d3.f = 2;
                                }
                                bVar12 = bVar2;
                                aVar4 = aVar6;
                                aVar13 = aVar5;
                                i56 = i35;
                                i57 = i34;
                                i30 = i31;
                                bVar16 = bVar4;
                                bVar14 = bVar3;
                                aVar12 = aVar7;
                                i65 = i32 + 1;
                                childCount2 = i33;
                            } else {
                                d3.B(aVar7);
                                i39 = 0;
                            }
                            d3.w(i39);
                            str = aVar19.B;
                            if (str != null) {
                            }
                            float f72 = aVar19.D;
                            float[] fArr2 = d3.g0;
                            fArr2[0] = f72;
                            fArr2[1] = aVar19.E;
                            d3.e0 = aVar19.F;
                            d3.f0 = aVar19.G;
                            int i812 = aVar19.H;
                            int i822 = aVar19.J;
                            int i832 = aVar19.L;
                            float f82 = aVar19.N;
                            d3.f914e = i812;
                            d3.h = i822;
                            d3.i = i832;
                            d3.j = f82;
                            d3.f914e = 2;
                            int i842 = aVar19.I;
                            int i852 = aVar19.K;
                            int i862 = aVar19.M;
                            float f92 = aVar19.O;
                            d3.f = i842;
                            d3.k = i852;
                            d3.l = i862;
                            d3.m = f92;
                            d3.f = 2;
                            bVar12 = bVar2;
                            aVar4 = aVar6;
                            aVar13 = aVar5;
                            i56 = i35;
                            i57 = i34;
                            i30 = i31;
                            bVar16 = bVar4;
                            bVar14 = bVar3;
                            aVar12 = aVar7;
                            i65 = i32 + 1;
                            childCount2 = i33;
                        }
                    }
                    i32 = i65;
                    i33 = childCount2;
                    bVar3 = bVar14;
                    bVar2 = bVar12;
                    aVar7 = aVar12;
                    aVar5 = aVar13;
                    bVar4 = bVar16;
                    i35 = i56;
                    i34 = i57;
                    i31 = i30;
                    aVar6 = aVar4;
                    bVar12 = bVar2;
                    aVar4 = aVar6;
                    aVar13 = aVar5;
                    i56 = i35;
                    i57 = i34;
                    i30 = i31;
                    bVar16 = bVar4;
                    bVar14 = bVar3;
                    aVar12 = aVar7;
                    i65 = i32 + 1;
                    childCount2 = i33;
                }
                bVar = bVar12;
                i9 = i56;
                i7 = i57;
                i4 = i30;
                aVar3 = aVar4;
            } else {
                i9 = paddingTop;
                i7 = paddingLeft;
                i4 = size3;
                bVar = bVar12;
                i6 = n2;
                aVar3 = aVar10;
                i8 = mode;
                i5 = h2;
            }
            z = true;
        } else {
            i9 = paddingTop;
            i7 = paddingLeft;
            i4 = size3;
            bVar = bVar12;
            i6 = n2;
            aVar3 = aVar10;
            i8 = mode;
            i5 = h2;
            z = false;
        }
        boolean z8 = (constraintLayout.k & 8) == 8;
        if (z8) {
            constraintLayout.f112e.L();
            constraintLayout.f112e.J(i6, i5);
            e(i2, i3);
            i10 = i3;
        } else {
            int i87 = i6;
            int i88 = i5;
            int paddingBottom2 = getPaddingBottom() + getPaddingTop();
            int paddingRight2 = getPaddingRight() + getPaddingLeft();
            int childCount4 = getChildCount();
            int i89 = 0;
            while (i89 < childCount4) {
                View childAt6 = constraintLayout.getChildAt(i89);
                if (childAt6.getVisibility() != 8) {
                    a aVar20 = (a) childAt6.getLayoutParams();
                    d dVar5 = aVar20.k0;
                    if (!aVar20.X && !aVar20.Y) {
                        dVar5.Y = childAt6.getVisibility();
                        int i90 = ((ViewGroup.MarginLayoutParams) aVar20).width;
                        i14 = childCount4;
                        int i91 = ((ViewGroup.MarginLayoutParams) aVar20).height;
                        i11 = i88;
                        boolean z9 = aVar20.U;
                        i12 = i87;
                        if (!z9 && !aVar20.V) {
                            if (!z9) {
                            }
                            if (((ViewGroup.MarginLayoutParams) aVar20).width != -1 && (aVar20.V || !(aVar20.I == 1 || ((ViewGroup.MarginLayoutParams) aVar20).height == -1))) {
                                z2 = false;
                                if (!z2) {
                                    if (i90 == 0) {
                                        i15 = -2;
                                        i16 = ViewGroup.getChildMeasureSpec(i2, paddingRight2, -2);
                                        z3 = true;
                                    } else if (i90 == -1) {
                                        i16 = ViewGroup.getChildMeasureSpec(i2, paddingRight2, -1);
                                        i15 = -2;
                                        z3 = false;
                                    } else {
                                        i15 = -2;
                                        boolean z10 = i90 == -2;
                                        i16 = ViewGroup.getChildMeasureSpec(i2, paddingRight2, i90);
                                        z3 = z10;
                                    }
                                    i13 = paddingRight2;
                                    if (i91 == 0) {
                                        i17 = ViewGroup.getChildMeasureSpec(i3, paddingBottom2, i15);
                                        z4 = true;
                                    } else if (i91 == -1) {
                                        i17 = ViewGroup.getChildMeasureSpec(i3, paddingBottom2, -1);
                                        z4 = false;
                                    } else {
                                        z4 = i91 == -2;
                                        i17 = ViewGroup.getChildMeasureSpec(i3, paddingBottom2, i91);
                                    }
                                    childAt6.measure(i16, i17);
                                    i90 = childAt6.getMeasuredWidth();
                                    i91 = childAt6.getMeasuredHeight();
                                } else {
                                    i13 = paddingRight2;
                                    z4 = false;
                                    z3 = false;
                                }
                                dVar5.C(i90);
                                dVar5.w(i91);
                                if (z3) {
                                    dVar5.T = i90;
                                }
                                if (z4) {
                                    dVar5.U = i91;
                                }
                                if (aVar20.W && (baseline = childAt6.getBaseline()) != -1) {
                                    dVar5.Q = baseline;
                                }
                                i89++;
                                childCount4 = i14;
                                paddingRight2 = i13;
                                i87 = i12;
                                i88 = i11;
                            }
                        }
                        z2 = true;
                        if (!z2) {
                        }
                        dVar5.C(i90);
                        dVar5.w(i91);
                        if (z3) {
                        }
                        if (z4) {
                        }
                        dVar5.Q = baseline;
                        i89++;
                        childCount4 = i14;
                        paddingRight2 = i13;
                        i87 = i12;
                        i88 = i11;
                    }
                }
                i14 = childCount4;
                i12 = i87;
                i11 = i88;
                i13 = paddingRight2;
                i89++;
                childCount4 = i14;
                paddingRight2 = i13;
                i87 = i12;
                i88 = i11;
            }
            i10 = i3;
            i6 = i87;
            i5 = i88;
        }
        int i92 = i2;
        h();
        if (getChildCount() > 0 && z) {
            i.j.V(constraintLayout.f112e);
        }
        e eVar7 = constraintLayout.f112e;
        if (eVar7.w0) {
            if (eVar7.x0) {
                i21 = i8;
                if (i21 == Integer.MIN_VALUE) {
                    int i93 = eVar7.z0;
                    i19 = size2;
                    if (i93 < i19) {
                        eVar7.C(i93);
                    }
                    constraintLayout.f112e.y(aVar3);
                } else {
                    i19 = size2;
                }
            } else {
                i19 = size2;
                i21 = i8;
            }
            e eVar8 = constraintLayout.f112e;
            if (eVar8.y0) {
                i20 = mode2;
                if (i20 == Integer.MIN_VALUE) {
                    int i94 = eVar8.A0;
                    i18 = i4;
                    if (i94 < i18) {
                        eVar8.w(i94);
                    }
                    constraintLayout.f112e.B(aVar3);
                    if ((constraintLayout.k & 32) != 32) {
                        int n3 = constraintLayout.f112e.n();
                        int h3 = constraintLayout.f112e.h();
                        if (constraintLayout.o != n3) {
                            i29 = 1073741824;
                            if (i21 == 1073741824) {
                                i.j.Y0(constraintLayout.f112e.v0, 0, n3);
                            }
                        } else {
                            i29 = 1073741824;
                        }
                        if (constraintLayout.p != h3 && i20 == i29) {
                            i.j.Y0(constraintLayout.f112e.v0, 1, h3);
                        }
                        e eVar9 = constraintLayout.f112e;
                        if (!eVar9.x0 || eVar9.z0 <= i19) {
                            i23 = 0;
                        } else {
                            i23 = 0;
                            i.j.Y0(eVar9.v0, 0, i19);
                        }
                        e eVar10 = constraintLayout.f112e;
                        if (eVar10.y0 && eVar10.A0 > i18) {
                            i22 = 1;
                            i.j.Y0(eVar10.v0, 1, i18);
                            if (getChildCount() > 0) {
                                g();
                            }
                            size = constraintLayout.f111d.size();
                            int paddingBottom3 = getPaddingBottom() + i9;
                            int paddingRight3 = getPaddingRight() + i7;
                            if (size > 0) {
                                int i95 = constraintLayout.f112e.i() == aVar9 ? i22 : i23;
                                int i96 = constraintLayout.f112e.m() == aVar9 ? i22 : i23;
                                int max = Math.max(constraintLayout.f112e.n(), constraintLayout.f);
                                int max2 = Math.max(constraintLayout.f112e.h(), constraintLayout.g);
                                int i97 = i23;
                                int i98 = i97;
                                while (i97 < size) {
                                    d dVar6 = constraintLayout.f111d.get(i97);
                                    View view2 = (View) dVar6.X;
                                    if (view2 == null) {
                                        i28 = i23;
                                        i25 = i95;
                                        i26 = i97;
                                    } else {
                                        a aVar21 = (a) view2.getLayoutParams();
                                        i26 = i97;
                                        if (aVar21.Y || aVar21.X) {
                                            i28 = i23;
                                            i25 = i95;
                                        } else if (view2.getVisibility() != 8 && (!z8 || !dVar6.l().c() || !dVar6.k().c())) {
                                            int i99 = ((ViewGroup.MarginLayoutParams) aVar21).width;
                                            int makeMeasureSpec = (i99 != -2 || !aVar21.U) ? View.MeasureSpec.makeMeasureSpec(dVar6.n(), 1073741824) : ViewGroup.getChildMeasureSpec(i92, paddingRight3, i99);
                                            int i100 = ((ViewGroup.MarginLayoutParams) aVar21).height;
                                            view2.measure(makeMeasureSpec, (i100 != -2 || !aVar21.V) ? View.MeasureSpec.makeMeasureSpec(dVar6.h(), 1073741824) : ViewGroup.getChildMeasureSpec(i10, paddingBottom3, i100));
                                            int measuredWidth = view2.getMeasuredWidth();
                                            int measuredHeight = view2.getMeasuredHeight();
                                            if (measuredWidth != dVar6.n()) {
                                                dVar6.C(measuredWidth);
                                                if (z8) {
                                                    dVar6.l().e(measuredWidth);
                                                }
                                                if (i95 != 0) {
                                                    int i101 = dVar6.I;
                                                    int i102 = dVar6.E;
                                                    i25 = i95;
                                                    if (i101 + i102 > max) {
                                                        max = Math.max(max, dVar6.f(bVar).b() + i101 + i102);
                                                    }
                                                } else {
                                                    i25 = i95;
                                                }
                                                i98 = 1;
                                            } else {
                                                i25 = i95;
                                            }
                                            if (measuredHeight != dVar6.h()) {
                                                dVar6.w(measuredHeight);
                                                if (z8) {
                                                    dVar6.k().e(measuredHeight);
                                                }
                                                if (i96 != 0) {
                                                    int i103 = dVar6.J;
                                                    int i104 = dVar6.F;
                                                    if (i103 + i104 > max2) {
                                                        max2 = Math.max(max2, dVar6.f(bVar11).b() + i103 + i104);
                                                    }
                                                }
                                                i98 = 1;
                                            }
                                            if (aVar21.W) {
                                                int baseline2 = view2.getBaseline();
                                                if (!(baseline2 == -1 || baseline2 == dVar6.Q)) {
                                                    dVar6.Q = baseline2;
                                                    i98 = 1;
                                                }
                                            }
                                            i27 = ViewGroup.combineMeasuredStates(i23, view2.getMeasuredState());
                                            i97 = i26 + 1;
                                            i92 = i2;
                                            i23 = i27;
                                            size = size;
                                            i95 = i25;
                                            constraintLayout = this;
                                        } else {
                                            i25 = i95;
                                            i28 = i23;
                                        }
                                    }
                                    i27 = i28;
                                    i97 = i26 + 1;
                                    i92 = i2;
                                    i23 = i27;
                                    size = size;
                                    i95 = i25;
                                    constraintLayout = this;
                                }
                                constraintLayout = this;
                                if (i98 != 0) {
                                    constraintLayout.f112e.C(i6);
                                    constraintLayout.f112e.w(i5);
                                    if (z8) {
                                        constraintLayout.f112e.N();
                                    }
                                    g();
                                    if (constraintLayout.f112e.n() < max) {
                                        constraintLayout.f112e.C(max);
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    if (constraintLayout.f112e.h() < max2) {
                                        constraintLayout.f112e.w(max2);
                                        z6 = true;
                                    } else {
                                        z6 = z5;
                                    }
                                    if (z6) {
                                        g();
                                    }
                                }
                                for (int i105 = 0; i105 < size; i105++) {
                                    d dVar7 = constraintLayout.f111d.get(i105);
                                    View view3 = (View) dVar7.X;
                                    if (view3 != null && (view3.getMeasuredWidth() != dVar7.n() || view3.getMeasuredHeight() != dVar7.h())) {
                                        if (dVar7.Y != 8) {
                                            view3.measure(View.MeasureSpec.makeMeasureSpec(dVar7.n(), 1073741824), View.MeasureSpec.makeMeasureSpec(dVar7.h(), 1073741824));
                                        }
                                    }
                                }
                                i24 = i23;
                            } else {
                                i24 = 0;
                            }
                            int min = Math.min(constraintLayout.h, ViewGroup.resolveSizeAndState(constraintLayout.f112e.n() + paddingRight3, i2, i24) & 16777215);
                            int min2 = Math.min(constraintLayout.i, ViewGroup.resolveSizeAndState(constraintLayout.f112e.h() + paddingBottom3, i10, i24 << 16) & 16777215);
                            if (constraintLayout.f112e.D0) {
                                min |= 16777216;
                            }
                            if (constraintLayout.f112e.E0) {
                                min2 |= 16777216;
                            }
                            constraintLayout.setMeasuredDimension(min, min2);
                            constraintLayout.o = min;
                            constraintLayout.p = min2;
                        }
                    } else {
                        i23 = 0;
                    }
                    i22 = 1;
                    if (getChildCount() > 0) {
                    }
                    size = constraintLayout.f111d.size();
                    int paddingBottom32 = getPaddingBottom() + i9;
                    int paddingRight32 = getPaddingRight() + i7;
                    if (size > 0) {
                    }
                    int min3 = Math.min(constraintLayout.h, ViewGroup.resolveSizeAndState(constraintLayout.f112e.n() + paddingRight32, i2, i24) & 16777215);
                    int min22 = Math.min(constraintLayout.i, ViewGroup.resolveSizeAndState(constraintLayout.f112e.h() + paddingBottom32, i10, i24 << 16) & 16777215);
                    if (constraintLayout.f112e.D0) {
                    }
                    if (constraintLayout.f112e.E0) {
                    }
                    constraintLayout.setMeasuredDimension(min3, min22);
                    constraintLayout.o = min3;
                    constraintLayout.p = min22;
                }
            } else {
                i20 = mode2;
            }
        } else {
            i20 = mode2;
            i19 = size2;
            i21 = i8;
        }
        i18 = i4;
        if ((constraintLayout.k & 32) != 32) {
        }
        i22 = 1;
        if (getChildCount() > 0) {
        }
        size = constraintLayout.f111d.size();
        int paddingBottom322 = getPaddingBottom() + i9;
        int paddingRight322 = getPaddingRight() + i7;
        if (size > 0) {
        }
        int min32 = Math.min(constraintLayout.h, ViewGroup.resolveSizeAndState(constraintLayout.f112e.n() + paddingRight322, i2, i24) & 16777215);
        int min222 = Math.min(constraintLayout.i, ViewGroup.resolveSizeAndState(constraintLayout.f112e.h() + paddingBottom322, i10, i24 << 16) & 16777215);
        if (constraintLayout.f112e.D0) {
        }
        if (constraintLayout.f112e.E0) {
        }
        constraintLayout.setMeasuredDimension(min32, min222);
        constraintLayout.o = min32;
        constraintLayout.p = min222;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        d d2 = d(view);
        if ((view instanceof b.g.b.e) && !(d2 instanceof g)) {
            a aVar = (a) view.getLayoutParams();
            g gVar = new g();
            aVar.k0 = gVar;
            aVar.X = true;
            gVar.F(aVar.R);
        }
        if (view instanceof b) {
            b bVar = (b) view;
            bVar.f();
            ((a) view.getLayoutParams()).Y = true;
            if (!this.f110c.contains(bVar)) {
                this.f110c.add(bVar);
            }
        }
        this.f109b.put(view.getId(), view);
        this.j = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f109b.remove(view.getId());
        d d2 = d(view);
        this.f112e.j0.remove(d2);
        d2.D = null;
        this.f110c.remove(view);
        this.f111d.remove(d2);
        this.j = true;
    }

    public void removeView(View view) {
        super.removeView(view);
    }

    public void requestLayout() {
        super.requestLayout();
        this.j = true;
        this.o = -1;
        this.p = -1;
    }

    public void setConstraintSet(b.g.b.c cVar) {
        this.l = cVar;
    }

    public void setId(int i2) {
        this.f109b.remove(getId());
        super.setId(i2);
        this.f109b.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 != this.i) {
            this.i = i2;
            requestLayout();
        }
    }

    public void setMaxWidth(int i2) {
        if (i2 != this.h) {
            this.h = i2;
            requestLayout();
        }
    }

    public void setMinHeight(int i2) {
        if (i2 != this.g) {
            this.g = i2;
            requestLayout();
        }
    }

    public void setMinWidth(int i2) {
        if (i2 != this.f) {
            this.f = i2;
            requestLayout();
        }
    }

    public void setOptimizationLevel(int i2) {
        this.f112e.B0 = i2;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
