package androidx.constraintlayout.widget;

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
import e.g.b.h.c;
import e.g.b.h.d;
import e.g.b.h.e;
import e.g.b.h.f;
import e.g.b.h.i;
import e.g.b.h.j;
import e.g.b.h.k;
import e.g.b.h.l.b;
import e.g.b.h.l.m;
import e.g.b.h.l.o;
import e.g.c.c;
import e.g.c.d;
import e.g.c.g;
import e.g.c.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class ConstraintLayout extends ViewGroup {
    public SparseArray<View> b = new SparseArray<>();
    public ArrayList<e.g.c.b> c = new ArrayList<>(4);

    /* renamed from: d  reason: collision with root package name */
    public e f110d = new e();

    /* renamed from: e  reason: collision with root package name */
    public int f111e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f112f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f113g = Integer.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    public int f114h = Integer.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public boolean f115i = true;

    /* renamed from: j  reason: collision with root package name */
    public int f116j = 257;

    /* renamed from: k  reason: collision with root package name */
    public d f117k = null;

    /* renamed from: l  reason: collision with root package name */
    public c f118l = null;
    public int m = -1;
    public HashMap<String, Integer> n = new HashMap<>();
    public int o = -1;
    public int p = -1;
    public SparseArray<e.g.b.h.d> q = new SparseArray<>();
    public b r = new b(this);
    public int s = 0;
    public int t = 0;

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
        public String U = null;
        public boolean V = true;
        public boolean W = true;
        public boolean X = false;
        public boolean Y = false;
        public boolean Z = false;
        public int a = -1;
        public boolean a0 = false;
        public int b = -1;
        public int b0 = -1;
        public float c = -1.0f;
        public int c0 = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f119d = -1;
        public int d0 = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f120e = -1;
        public int e0 = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f121f = -1;
        public int f0 = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f122g = -1;
        public int g0 = -1;

        /* renamed from: h  reason: collision with root package name */
        public int f123h = -1;
        public float h0 = 0.5f;

        /* renamed from: i  reason: collision with root package name */
        public int f124i = -1;
        public int i0;

        /* renamed from: j  reason: collision with root package name */
        public int f125j = -1;
        public int j0;

        /* renamed from: k  reason: collision with root package name */
        public int f126k = -1;
        public float k0;

        /* renamed from: l  reason: collision with root package name */
        public int f127l = -1;
        public e.g.b.h.d l0 = new e.g.b.h.d();
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
        public static class C0001a {
            public static final SparseIntArray a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                a = sparseIntArray;
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                a.append(R$styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
            }
        }

        public a(int i2, int i3) {
            super(i2, i3);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i2;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                int i4 = C0001a.a.get(index);
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
                        this.a = obtainStyledAttributes.getDimensionPixelOffset(index, this.a);
                        break;
                    case 6:
                        this.b = obtainStyledAttributes.getDimensionPixelOffset(index, this.b);
                        break;
                    case 7:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f119d);
                        this.f119d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f119d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f120e);
                        this.f120e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f120e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f121f);
                        this.f121f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f121f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f122g);
                        this.f122g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f122g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f123h);
                        this.f123h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f123h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f124i);
                        this.f124i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f124i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f125j);
                        this.f125j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f125j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f126k);
                        this.f126k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f126k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f127l);
                        this.f127l = resourceId10;
                        if (resourceId10 == -1) {
                            this.f127l = obtainStyledAttributes.getInt(index, -1);
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
                        this.H = 2;
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
                        this.I = 2;
                        break;
                    default:
                        switch (i4) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = -1;
                                if (string == null) {
                                    break;
                                } else {
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
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.B.substring(i2, indexOf2);
                                        String substring3 = this.B.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring2);
                                                float parseFloat2 = Float.parseFloat(substring3);
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
                                    } else {
                                        String substring4 = this.B.substring(i2);
                                        if (substring4.length() <= 0) {
                                            break;
                                        } else {
                                            Float.parseFloat(substring4);
                                            continue;
                                        }
                                    }
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
                            case 51:
                                this.U = obtainStyledAttributes.getString(index);
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
            this.Y = false;
            this.V = true;
            this.W = true;
            int i2 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i2 == -2 && this.S) {
                this.V = false;
                if (this.H == 0) {
                    this.H = 1;
                }
            }
            int i3 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i3 == -2 && this.T) {
                this.W = false;
                if (this.I == 0) {
                    this.I = 1;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.V = false;
                if (i2 == 0 && this.H == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.S = true;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.W = false;
                if (i3 == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.T = true;
                }
            }
            if (this.c != -1.0f || this.a != -1 || this.b != -1) {
                this.Y = true;
                this.V = true;
                this.W = true;
                if (!(this.l0 instanceof f)) {
                    this.l0 = new f();
                }
                ((f) this.l0).Q(this.R);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ce, code lost:
            if (r1 > 0) goto L_0x00d0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x00dd, code lost:
            if (r1 > 0) goto L_0x00d0;
         */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0078  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0080  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x00e4  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x00ef  */
        public void resolveLayoutDirection(int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i9 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i2);
            boolean z2 = false;
            boolean z3 = 1 == getLayoutDirection();
            this.d0 = -1;
            this.e0 = -1;
            this.b0 = -1;
            this.c0 = -1;
            this.f0 = -1;
            this.g0 = -1;
            this.f0 = this.t;
            this.g0 = this.v;
            float f2 = this.z;
            this.h0 = f2;
            int i10 = this.a;
            this.i0 = i10;
            int i11 = this.b;
            this.j0 = i11;
            float f3 = this.c;
            this.k0 = f3;
            if (z3) {
                int i12 = this.p;
                if (i12 != -1) {
                    this.d0 = i12;
                } else {
                    int i13 = this.q;
                    if (i13 != -1) {
                        this.e0 = i13;
                    }
                    i4 = this.r;
                    if (i4 != -1) {
                        this.c0 = i4;
                        z2 = true;
                    }
                    i5 = this.s;
                    if (i5 != -1) {
                        this.b0 = i5;
                        z2 = true;
                    }
                    i6 = this.x;
                    if (i6 != -1) {
                        this.g0 = i6;
                    }
                    i7 = this.y;
                    if (i7 != -1) {
                        this.f0 = i7;
                    }
                    if (z2) {
                        this.h0 = 1.0f - f2;
                    }
                    if (this.Y && this.R == 1) {
                        if (f3 == -1.0f) {
                            this.k0 = 1.0f - f3;
                            this.i0 = -1;
                            this.j0 = -1;
                        } else {
                            if (i10 != -1) {
                                this.j0 = i10;
                                this.i0 = -1;
                            } else if (i11 != -1) {
                                this.i0 = i11;
                                this.j0 = -1;
                            }
                            this.k0 = -1.0f;
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
                if (f3 == -1.0f) {
                }
            } else {
                int i14 = this.p;
                if (i14 != -1) {
                    this.c0 = i14;
                }
                int i15 = this.q;
                if (i15 != -1) {
                    this.b0 = i15;
                }
                int i16 = this.r;
                if (i16 != -1) {
                    this.d0 = i16;
                }
                int i17 = this.s;
                if (i17 != -1) {
                    this.e0 = i17;
                }
                int i18 = this.x;
                if (i18 != -1) {
                    this.f0 = i18;
                }
                int i19 = this.y;
                if (i19 != -1) {
                    this.g0 = i19;
                }
            }
            if (this.r == -1 && this.s == -1 && this.q == -1 && this.p == -1) {
                int i20 = this.f121f;
                if (i20 != -1) {
                    this.d0 = i20;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0) {
                    }
                    i3 = this.f119d;
                    if (i3 != -1) {
                        this.b0 = i3;
                        if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                            return;
                        }
                    } else {
                        int i21 = this.f120e;
                        if (i21 != -1) {
                            this.c0 = i21;
                            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
                }
                int i22 = this.f122g;
                if (i22 != -1) {
                    this.e0 = i22;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0) {
                    }
                }
                i3 = this.f119d;
                if (i3 != -1) {
                }
                ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
                ((ViewGroup.MarginLayoutParams) this).rightMargin = i9;
                i3 = this.f119d;
                if (i3 != -1) {
                }
                ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
            }
        }
    }

    public class b implements b.AbstractC0026b {
        public ConstraintLayout a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f128d;

        /* renamed from: e  reason: collision with root package name */
        public int f129e;

        /* renamed from: f  reason: collision with root package name */
        public int f130f;

        /* renamed from: g  reason: collision with root package name */
        public int f131g;

        public b(ConstraintLayout constraintLayout) {
            this.a = constraintLayout;
        }

        public final boolean a(int i2, int i3, int i4) {
            if (i2 == i3) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i2);
            View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i4 == size;
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:115:0x0195  */
        /* JADX WARNING: Removed duplicated region for block: B:120:0x01a6  */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x01bb  */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x01bd  */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x01c0  */
        /* JADX WARNING: Removed duplicated region for block: B:128:0x01c2  */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x01c7 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:135:0x01cf A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x01d8  */
        /* JADX WARNING: Removed duplicated region for block: B:145:0x01e3  */
        /* JADX WARNING: Removed duplicated region for block: B:150:0x01ee A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:151:0x01ef  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x00c1  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x013a  */
        public final void b(e.g.b.h.d dVar, b.a aVar) {
            int i2;
            int ordinal;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            d.a aVar2 = d.a.FIXED;
            if (dVar != null) {
                if (dVar.c0 == 8 && !dVar.z) {
                    aVar.f1110e = 0;
                    aVar.f1111f = 0;
                    aVar.f1112g = 0;
                } else if (dVar.P != null) {
                    d.a aVar3 = aVar.a;
                    d.a aVar4 = aVar.b;
                    int i13 = aVar.c;
                    int i14 = aVar.f1109d;
                    int i15 = this.b + this.c;
                    int i16 = this.f128d;
                    View view = (View) dVar.b0;
                    int ordinal2 = aVar3.ordinal();
                    if (ordinal2 == 0) {
                        i12 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                    } else if (ordinal2 == 1) {
                        i12 = ViewGroup.getChildMeasureSpec(this.f130f, i16, -2);
                    } else if (ordinal2 != 2) {
                        if (ordinal2 != 3) {
                            i2 = 0;
                        } else {
                            int i17 = this.f130f;
                            e.g.b.h.c cVar = dVar.D;
                            int i18 = cVar != null ? cVar.f1086g + 0 : 0;
                            e.g.b.h.c cVar2 = dVar.F;
                            if (cVar2 != null) {
                                i18 += cVar2.f1086g;
                            }
                            i2 = ViewGroup.getChildMeasureSpec(i17, i16 + i18, -1);
                        }
                        ordinal = aVar4.ordinal();
                        if (ordinal == 0) {
                            if (ordinal == 1) {
                                i10 = -2;
                                i11 = this.f131g;
                            } else if (ordinal == 2) {
                                i9 = ViewGroup.getChildMeasureSpec(this.f131g, i15, -2);
                                boolean z = dVar.m == 1;
                                int i19 = aVar.f1115j;
                                if (i19 == 1 || i19 == 2) {
                                    if (aVar.f1115j == 2 || !z || (z && (view.getMeasuredWidth() == dVar.r())) || (view instanceof g) || dVar.A()) {
                                        i9 = View.MeasureSpec.makeMeasureSpec(dVar.l(), 1073741824);
                                    }
                                }
                            } else if (ordinal != 3) {
                                i3 = 0;
                                e eVar = (e) dVar.P;
                                if (eVar != null && i.b(ConstraintLayout.this.f116j, 256) && view.getMeasuredWidth() == dVar.r() && view.getMeasuredWidth() < eVar.r() && view.getMeasuredHeight() == dVar.l() && view.getMeasuredHeight() < eVar.l() && view.getBaseline() == dVar.W && !dVar.y()) {
                                    if (!a(dVar.B, i2, dVar.r()) && a(dVar.C, i3, dVar.l())) {
                                        aVar.f1110e = dVar.r();
                                        aVar.f1111f = dVar.l();
                                        aVar.f1112g = dVar.W;
                                        return;
                                    }
                                }
                                d.a aVar5 = d.a.MATCH_CONSTRAINT;
                                boolean z2 = aVar3 == aVar5;
                                boolean z3 = aVar4 == aVar5;
                                d.a aVar6 = d.a.MATCH_PARENT;
                                boolean z4 = aVar4 != aVar6 || aVar4 == aVar2;
                                boolean z5 = aVar3 != aVar6 || aVar3 == aVar2;
                                boolean z6 = !z2 && dVar.S > 0.0f;
                                boolean z7 = !z3 && dVar.S > 0.0f;
                                if (view != null) {
                                    a aVar7 = (a) view.getLayoutParams();
                                    int i20 = aVar.f1115j;
                                    if (i20 == 1 || i20 == 2 || !z2 || dVar.f1105l != 0 || !z3 || dVar.m != 0) {
                                        if (!(view instanceof h) || !(dVar instanceof j)) {
                                            view.measure(i2, i3);
                                        } else {
                                            j jVar = (j) dVar;
                                            ((h) view).l();
                                        }
                                        dVar.B = i2;
                                        dVar.C = i3;
                                        dVar.f1100g = false;
                                        int measuredWidth = view.getMeasuredWidth();
                                        int measuredHeight = view.getMeasuredHeight();
                                        i6 = view.getBaseline();
                                        int i21 = dVar.o;
                                        i5 = i21 > 0 ? Math.max(i21, measuredWidth) : measuredWidth;
                                        int i22 = dVar.p;
                                        if (i22 > 0) {
                                            i5 = Math.min(i22, i5);
                                        }
                                        int i23 = dVar.r;
                                        if (i23 > 0) {
                                            i4 = Math.max(i23, measuredHeight);
                                            i8 = i2;
                                        } else {
                                            i8 = i2;
                                            i4 = measuredHeight;
                                        }
                                        int i24 = dVar.s;
                                        if (i24 > 0) {
                                            i4 = Math.min(i24, i4);
                                        }
                                        if (!i.b(ConstraintLayout.this.f116j, 1)) {
                                            if (z6 && z4) {
                                                i5 = (int) ((((float) i4) * dVar.S) + 0.5f);
                                            } else if (z7 && z5) {
                                                i4 = (int) ((((float) i5) / dVar.S) + 0.5f);
                                            }
                                        }
                                        if (measuredWidth == i5 && measuredHeight == i4) {
                                            i7 = -1;
                                        } else {
                                            int makeMeasureSpec = measuredWidth != i5 ? View.MeasureSpec.makeMeasureSpec(i5, 1073741824) : i8;
                                            if (measuredHeight != i4) {
                                                i3 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                                            }
                                            view.measure(makeMeasureSpec, i3);
                                            dVar.B = makeMeasureSpec;
                                            dVar.C = i3;
                                            dVar.f1100g = false;
                                            i5 = view.getMeasuredWidth();
                                            i4 = view.getMeasuredHeight();
                                            i6 = view.getBaseline();
                                            i7 = -1;
                                        }
                                    } else {
                                        i7 = -1;
                                        i6 = 0;
                                        i5 = 0;
                                        i4 = 0;
                                    }
                                    boolean z8 = i6 != i7;
                                    aVar.f1114i = (i5 == aVar.c && i4 == aVar.f1109d) ? false : true;
                                    if (aVar7.X) {
                                        z8 = true;
                                    }
                                    if (!(!z8 || i6 == -1 || dVar.W == i6)) {
                                        aVar.f1114i = true;
                                    }
                                    aVar.f1110e = i5;
                                    aVar.f1111f = i4;
                                    aVar.f1113h = z8;
                                    aVar.f1112g = i6;
                                    return;
                                }
                                return;
                            } else {
                                i11 = this.f131g;
                                int i25 = dVar.D != null ? dVar.E.f1086g + 0 : 0;
                                if (dVar.F != null) {
                                    i25 += dVar.G.f1086g;
                                }
                                i15 += i25;
                                i10 = -1;
                            }
                            i9 = ViewGroup.getChildMeasureSpec(i11, i15, i10);
                        } else {
                            i9 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                        }
                        i3 = i9;
                        e eVar2 = (e) dVar.P;
                        if (!a(dVar.B, i2, dVar.r()) && a(dVar.C, i3, dVar.l())) {
                        }
                        d.a aVar52 = d.a.MATCH_CONSTRAINT;
                        if (aVar3 == aVar52) {
                        }
                        if (aVar4 == aVar52) {
                        }
                        d.a aVar62 = d.a.MATCH_PARENT;
                        if (aVar4 != aVar62) {
                        }
                        if (aVar3 != aVar62) {
                        }
                        if (!z2) {
                        }
                        if (!z3) {
                        }
                        if (view != null) {
                        }
                    } else {
                        i12 = ViewGroup.getChildMeasureSpec(this.f130f, i16, -2);
                        boolean z9 = dVar.f1105l == 1;
                        int i26 = aVar.f1115j;
                        if (i26 == 1 || i26 == 2) {
                            if (aVar.f1115j == 2 || !z9 || (z9 && (view.getMeasuredHeight() == dVar.l())) || (view instanceof g) || dVar.z()) {
                                i12 = View.MeasureSpec.makeMeasureSpec(dVar.r(), 1073741824);
                            }
                        }
                    }
                    i2 = i12;
                    ordinal = aVar4.ordinal();
                    if (ordinal == 0) {
                    }
                    i3 = i9;
                    e eVar22 = (e) dVar.P;
                    if (!a(dVar.B, i2, dVar.r()) && a(dVar.C, i3, dVar.l())) {
                    }
                    d.a aVar522 = d.a.MATCH_CONSTRAINT;
                    if (aVar3 == aVar522) {
                    }
                    if (aVar4 == aVar522) {
                    }
                    d.a aVar622 = d.a.MATCH_PARENT;
                    if (aVar4 != aVar622) {
                    }
                    if (aVar3 != aVar622) {
                    }
                    if (!z2) {
                    }
                    if (!z3) {
                    }
                    if (view != null) {
                    }
                }
            }
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        f(attributeSet, i2, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return max2 > 0 ? max2 : max;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
    }

    /* renamed from: b */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    public Object c(int i2, Object obj) {
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

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public View d(int i2) {
        return this.b.get(i2);
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<e.g.c.b> arrayList = this.c;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.c.get(i2).j();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i4 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i5 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = (float) i4;
                        float f3 = (float) i5;
                        float f4 = (float) (i4 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        canvas.drawLine(f2, f3, f4, f3, paint);
                        float parseInt4 = (float) (i5 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
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

    public final e.g.b.h.d e(View view) {
        if (view == this) {
            return this.f110d;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).l0;
    }

    public final void f(AttributeSet attributeSet, int i2, int i3) {
        e eVar = this.f110d;
        eVar.b0 = this;
        b bVar = this.r;
        eVar.o0 = bVar;
        eVar.n0.f1120f = bVar;
        this.b.put(getId(), this);
        this.f117k = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout, i2, i3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R$styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.f111e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f111e);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.f112f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f112f);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.f113g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f113g);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.f114h = obtainStyledAttributes.getDimensionPixelOffset(index, this.f114h);
                } else if (index == R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f116j = obtainStyledAttributes.getInt(index, this.f116j);
                } else if (index == R$styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            this.f118l = new c(getContext(), this, resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f118l = null;
                        }
                    }
                } else if (index == R$styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        e.g.c.d dVar = new e.g.c.d();
                        this.f117k = dVar;
                        dVar.e(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f117k = null;
                    }
                    this.m = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f110d.Z(this.f116j);
    }

    public void forceLayout() {
        this.f115i = true;
        this.o = -1;
        this.p = -1;
        super.forceLayout();
    }

    public boolean g() {
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
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
        return this.f114h;
    }

    public int getMaxWidth() {
        return this.f113g;
    }

    public int getMinHeight() {
        return this.f112f;
    }

    public int getMinWidth() {
        return this.f111e;
    }

    public int getOptimizationLevel() {
        return this.f110d.x0;
    }

    public void h(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        b bVar = this.r;
        int i6 = bVar.f129e;
        int resolveSizeAndState = ViewGroup.resolveSizeAndState(i4 + bVar.f128d, i2, 0);
        int min = Math.min(this.f113g, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.f114h, ViewGroup.resolveSizeAndState(i5 + i6, i3, 0) & 16777215);
        if (z) {
            min |= 16777216;
        }
        if (z2) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.o = min;
        this.p = min2;
    }

    public void i(int i2, Object obj, Object obj2) {
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

    /* JADX WARNING: Removed duplicated region for block: B:146:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0305 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0337  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x036d  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x038e  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x03dd  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x03e7  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x051c  */
    public final boolean j() {
        boolean z;
        boolean z2;
        int i2;
        boolean z3;
        int i3;
        int i4;
        int i5;
        float f2;
        int i6;
        int i7;
        int i8;
        int i9;
        float f3;
        e.g.b.h.c cVar;
        int i10;
        int i11;
        e.g.b.h.c cVar2;
        e.g.b.h.d dVar;
        e.g.b.h.c cVar3;
        int i12;
        int i13;
        e.g.b.h.c cVar4;
        e.g.b.h.d dVar2;
        e.g.b.h.c cVar5;
        int i14;
        e.g.b.h.c cVar6;
        e.g.b.h.d dVar3;
        e.g.b.h.c cVar7;
        int i15;
        e.g.b.h.c cVar8;
        e.g.b.h.d dVar4;
        String str;
        int e2;
        e.g.b.h.d dVar5;
        int childCount = getChildCount();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i17 >= childCount) {
                z = false;
                break;
            } else if (getChildAt(i17).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i17++;
            }
        }
        if (z) {
            boolean isInEditMode = isInEditMode();
            int childCount2 = getChildCount();
            for (int i18 = 0; i18 < childCount2; i18++) {
                e.g.b.h.d e3 = e(getChildAt(i18));
                if (e3 != null) {
                    e3.B();
                }
            }
            Object obj = null;
            if (isInEditMode) {
                for (int i19 = 0; i19 < childCount2; i19++) {
                    View childAt = getChildAt(i19);
                    try {
                        String resourceName = getResources().getResourceName(childAt.getId());
                        i(0, resourceName, Integer.valueOf(childAt.getId()));
                        int indexOf = resourceName.indexOf(47);
                        if (indexOf != -1) {
                            resourceName = resourceName.substring(indexOf + 1);
                        }
                        int id = childAt.getId();
                        if (id != 0) {
                            View view = this.b.get(id);
                            if (view == null && (view = findViewById(id)) != null && view != this && view.getParent() == this) {
                                onViewAdded(view);
                            }
                            if (view != this) {
                                dVar5 = view == null ? null : ((a) view.getLayoutParams()).l0;
                                dVar5.d0 = resourceName;
                            }
                        }
                        dVar5 = this.f110d;
                        dVar5.d0 = resourceName;
                    } catch (Resources.NotFoundException unused) {
                    }
                }
            }
            if (this.m != -1) {
                for (int i20 = 0; i20 < childCount2; i20++) {
                    View childAt2 = getChildAt(i20);
                    if (childAt2.getId() == this.m && (childAt2 instanceof e.g.c.e)) {
                        this.f117k = ((e.g.c.e) childAt2).getConstraintSet();
                    }
                }
            }
            e.g.c.d dVar6 = this.f117k;
            if (dVar6 != null) {
                dVar6.a(this, true);
            }
            this.f110d.l0.clear();
            int size = this.c.size();
            if (size > 0) {
                int i21 = 0;
                while (i21 < size) {
                    e.g.c.b bVar = this.c.get(i21);
                    if (bVar.isInEditMode()) {
                        bVar.setIds(bVar.f1167f);
                    }
                    e.g.b.h.g gVar = bVar.f1166e;
                    if (gVar != null) {
                        e.g.b.h.h hVar = (e.g.b.h.h) gVar;
                        hVar.m0 = i16;
                        Arrays.fill(hVar.l0, obj);
                        for (int i22 = 0; i22 < bVar.c; i22++) {
                            int i23 = bVar.b[i22];
                            View d2 = d(i23);
                            if (d2 == null && (e2 = bVar.e(this, (str = bVar.f1169h.get(Integer.valueOf(i23))))) != 0) {
                                bVar.b[i22] = e2;
                                bVar.f1169h.put(Integer.valueOf(e2), str);
                                d2 = d(e2);
                            }
                            if (d2 != null) {
                                e.g.b.h.g gVar2 = bVar.f1166e;
                                e.g.b.h.d e4 = e(d2);
                                e.g.b.h.h hVar2 = (e.g.b.h.h) gVar2;
                                Objects.requireNonNull(hVar2);
                                if (!(e4 == hVar2 || e4 == null)) {
                                    int i24 = hVar2.m0 + 1;
                                    e.g.b.h.d[] dVarArr = hVar2.l0;
                                    if (i24 > dVarArr.length) {
                                        hVar2.l0 = (e.g.b.h.d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
                                    }
                                    e.g.b.h.d[] dVarArr2 = hVar2.l0;
                                    int i25 = hVar2.m0;
                                    dVarArr2[i25] = e4;
                                    hVar2.m0 = i25 + 1;
                                }
                            }
                        }
                        bVar.f1166e.a(this.f110d);
                    }
                    i21++;
                    i16 = 0;
                    obj = null;
                }
            }
            for (int i26 = 0; i26 < childCount2; i26++) {
                View childAt3 = getChildAt(i26);
                if (childAt3 instanceof g) {
                    g gVar3 = (g) childAt3;
                    if (gVar3.b == -1 && !gVar3.isInEditMode()) {
                        gVar3.setVisibility(gVar3.f1204d);
                    }
                    View findViewById = findViewById(gVar3.b);
                    gVar3.c = findViewById;
                    if (findViewById != null) {
                        ((a) findViewById.getLayoutParams()).a0 = true;
                        gVar3.c.setVisibility(0);
                        gVar3.setVisibility(0);
                    }
                }
            }
            this.q.clear();
            this.q.put(0, this.f110d);
            this.q.put(getId(), this.f110d);
            for (int i27 = 0; i27 < childCount2; i27++) {
                View childAt4 = getChildAt(i27);
                this.q.put(childAt4.getId(), e(childAt4));
            }
            int i28 = 0;
            while (i28 < childCount2) {
                View childAt5 = getChildAt(i28);
                e.g.b.h.d e5 = e(childAt5);
                if (e5 == null) {
                    z3 = z;
                    i3 = childCount2;
                } else {
                    a aVar = (a) childAt5.getLayoutParams();
                    e eVar = this.f110d;
                    eVar.l0.add(e5);
                    e.g.b.h.d dVar7 = e5.P;
                    if (dVar7 != null) {
                        ((k) dVar7).l0.remove(e5);
                        e5.B();
                    }
                    e5.P = eVar;
                    SparseArray<e.g.b.h.d> sparseArray = this.q;
                    d.a aVar2 = d.a.MATCH_PARENT;
                    d.a aVar3 = d.a.WRAP_CONTENT;
                    d.a aVar4 = d.a.FIXED;
                    d.a aVar5 = d.a.MATCH_CONSTRAINT;
                    c.a aVar6 = c.a.RIGHT;
                    c.a aVar7 = c.a.LEFT;
                    c.a aVar8 = c.a.BOTTOM;
                    i3 = childCount2;
                    c.a aVar9 = c.a.TOP;
                    aVar.a();
                    z3 = z;
                    e5.c0 = childAt5.getVisibility();
                    if (aVar.a0) {
                        e5.z = true;
                        e5.c0 = 8;
                    }
                    e5.b0 = childAt5;
                    if (childAt5 instanceof e.g.c.b) {
                        ((e.g.c.b) childAt5).g(e5, this.f110d.p0);
                    }
                    if (aVar.Y) {
                        f fVar = (f) e5;
                        int i29 = aVar.i0;
                        int i30 = aVar.j0;
                        float f4 = aVar.k0;
                        int i31 = (f4 > -1.0f ? 1 : (f4 == -1.0f ? 0 : -1));
                        if (i31 != 0) {
                            if (i31 > 0) {
                                fVar.l0 = f4;
                                fVar.m0 = -1;
                                fVar.n0 = -1;
                            }
                        } else if (i29 != -1) {
                            if (i29 > -1) {
                                fVar.l0 = -1.0f;
                                fVar.m0 = i29;
                                fVar.n0 = -1;
                            }
                        } else if (i30 != -1 && i30 > -1) {
                            fVar.l0 = -1.0f;
                            fVar.m0 = -1;
                            fVar.n0 = i30;
                        }
                    } else {
                        int i32 = aVar.b0;
                        int i33 = aVar.c0;
                        i2 = i28;
                        int i34 = aVar.d0;
                        int i35 = aVar.e0;
                        int i36 = aVar.f0;
                        int i37 = aVar.g0;
                        float f5 = aVar.h0;
                        z2 = isInEditMode;
                        int i38 = aVar.m;
                        if (i38 != -1) {
                            e.g.b.h.d dVar8 = sparseArray.get(i38);
                            if (dVar8 != null) {
                                float f6 = aVar.o;
                                int i39 = aVar.n;
                                c.a aVar10 = c.a.CENTER;
                                e5.i(aVar10).a(dVar8.i(aVar10), i39, 0, true);
                                e5.x = f6;
                            }
                        } else {
                            if (i32 != -1) {
                                e.g.b.h.d dVar9 = sparseArray.get(i32);
                                if (dVar9 != null) {
                                    i15 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                                    cVar7 = e5.i(aVar7);
                                    cVar8 = dVar9.i(aVar7);
                                }
                                if (i34 != -1) {
                                    e.g.b.h.d dVar10 = sparseArray.get(i34);
                                    if (dVar10 != null) {
                                        i14 = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                                        cVar5 = e5.i(aVar6);
                                        cVar6 = dVar10.i(aVar7);
                                    }
                                    i7 = aVar.f123h;
                                    if (i7 != -1) {
                                        e.g.b.h.d dVar11 = sparseArray.get(i7);
                                        if (dVar11 != null) {
                                            i13 = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                                            i12 = aVar.u;
                                            cVar3 = e5.i(aVar9);
                                            cVar4 = dVar11.i(aVar9);
                                        }
                                        i8 = aVar.f125j;
                                        if (i8 != -1) {
                                            e.g.b.h.d dVar12 = sparseArray.get(i8);
                                            if (dVar12 != null) {
                                                i11 = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                                                i10 = aVar.w;
                                                cVar = e5.i(aVar8);
                                                cVar2 = dVar12.i(aVar9);
                                            }
                                            i9 = aVar.f127l;
                                            if (i9 != -1) {
                                                View view2 = this.b.get(i9);
                                                e.g.b.h.d dVar13 = sparseArray.get(aVar.f127l);
                                                if (!(dVar13 == null || view2 == null || !(view2.getLayoutParams() instanceof a))) {
                                                    a aVar11 = (a) view2.getLayoutParams();
                                                    aVar.X = true;
                                                    aVar11.X = true;
                                                    c.a aVar12 = c.a.BASELINE;
                                                    e5.i(aVar12).a(dVar13.i(aVar12), 0, -1, true);
                                                    e5.y = true;
                                                    aVar11.l0.y = true;
                                                    e5.i(aVar9).h();
                                                    e5.i(aVar8).h();
                                                }
                                            }
                                            if (f5 >= 0.0f) {
                                                e5.Z = f5;
                                            }
                                            f3 = aVar.A;
                                            if (f3 >= 0.0f) {
                                                e5.a0 = f3;
                                            }
                                        } else {
                                            int i40 = aVar.f126k;
                                            if (!(i40 == -1 || (dVar = sparseArray.get(i40)) == null)) {
                                                i11 = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                                                i10 = aVar.w;
                                                cVar = e5.i(aVar8);
                                                cVar2 = dVar.i(aVar8);
                                            }
                                            i9 = aVar.f127l;
                                            if (i9 != -1) {
                                            }
                                            if (f5 >= 0.0f) {
                                            }
                                            f3 = aVar.A;
                                            if (f3 >= 0.0f) {
                                            }
                                        }
                                        cVar.a(cVar2, i11, i10, true);
                                        i9 = aVar.f127l;
                                        if (i9 != -1) {
                                        }
                                        if (f5 >= 0.0f) {
                                        }
                                        f3 = aVar.A;
                                        if (f3 >= 0.0f) {
                                        }
                                    } else {
                                        int i41 = aVar.f124i;
                                        if (!(i41 == -1 || (dVar2 = sparseArray.get(i41)) == null)) {
                                            i13 = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                                            i12 = aVar.u;
                                            cVar3 = e5.i(aVar9);
                                            cVar4 = dVar2.i(aVar8);
                                        }
                                        i8 = aVar.f125j;
                                        if (i8 != -1) {
                                        }
                                        cVar.a(cVar2, i11, i10, true);
                                        i9 = aVar.f127l;
                                        if (i9 != -1) {
                                        }
                                        if (f5 >= 0.0f) {
                                        }
                                        f3 = aVar.A;
                                        if (f3 >= 0.0f) {
                                        }
                                    }
                                    cVar3.a(cVar4, i13, i12, true);
                                    i8 = aVar.f125j;
                                    if (i8 != -1) {
                                    }
                                    cVar.a(cVar2, i11, i10, true);
                                    i9 = aVar.f127l;
                                    if (i9 != -1) {
                                    }
                                    if (f5 >= 0.0f) {
                                    }
                                    f3 = aVar.A;
                                    if (f3 >= 0.0f) {
                                    }
                                } else {
                                    if (!(i35 == -1 || (dVar3 = sparseArray.get(i35)) == null)) {
                                        i14 = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                                        cVar5 = e5.i(aVar6);
                                        cVar6 = dVar3.i(aVar6);
                                    }
                                    i7 = aVar.f123h;
                                    if (i7 != -1) {
                                    }
                                    cVar3.a(cVar4, i13, i12, true);
                                    i8 = aVar.f125j;
                                    if (i8 != -1) {
                                    }
                                    cVar.a(cVar2, i11, i10, true);
                                    i9 = aVar.f127l;
                                    if (i9 != -1) {
                                    }
                                    if (f5 >= 0.0f) {
                                    }
                                    f3 = aVar.A;
                                    if (f3 >= 0.0f) {
                                    }
                                }
                                cVar5.a(cVar6, i14, i37, true);
                                i7 = aVar.f123h;
                                if (i7 != -1) {
                                }
                                cVar3.a(cVar4, i13, i12, true);
                                i8 = aVar.f125j;
                                if (i8 != -1) {
                                }
                                cVar.a(cVar2, i11, i10, true);
                                i9 = aVar.f127l;
                                if (i9 != -1) {
                                }
                                if (f5 >= 0.0f) {
                                }
                                f3 = aVar.A;
                                if (f3 >= 0.0f) {
                                }
                            } else {
                                if (!(i33 == -1 || (dVar4 = sparseArray.get(i33)) == null)) {
                                    i15 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                                    cVar7 = e5.i(aVar7);
                                    cVar8 = dVar4.i(aVar6);
                                }
                                if (i34 != -1) {
                                }
                                cVar5.a(cVar6, i14, i37, true);
                                i7 = aVar.f123h;
                                if (i7 != -1) {
                                }
                                cVar3.a(cVar4, i13, i12, true);
                                i8 = aVar.f125j;
                                if (i8 != -1) {
                                }
                                cVar.a(cVar2, i11, i10, true);
                                i9 = aVar.f127l;
                                if (i9 != -1) {
                                }
                                if (f5 >= 0.0f) {
                                }
                                f3 = aVar.A;
                                if (f3 >= 0.0f) {
                                }
                            }
                            cVar7.a(cVar8, i15, i36, true);
                            if (i34 != -1) {
                            }
                            cVar5.a(cVar6, i14, i37, true);
                            i7 = aVar.f123h;
                            if (i7 != -1) {
                            }
                            cVar3.a(cVar4, i13, i12, true);
                            i8 = aVar.f125j;
                            if (i8 != -1) {
                            }
                            cVar.a(cVar2, i11, i10, true);
                            i9 = aVar.f127l;
                            if (i9 != -1) {
                            }
                            if (f5 >= 0.0f) {
                            }
                            f3 = aVar.A;
                            if (f3 >= 0.0f) {
                            }
                        }
                        if (z2 && !((i6 = aVar.P) == -1 && aVar.Q == -1)) {
                            int i42 = aVar.Q;
                            e5.U = i6;
                            e5.V = i42;
                        }
                        if (aVar.V) {
                            e5.O[0] = aVar4;
                            e5.M(((ViewGroup.MarginLayoutParams) aVar).width);
                            if (((ViewGroup.MarginLayoutParams) aVar).width == -2) {
                                e5.O[0] = aVar3;
                            }
                        } else if (((ViewGroup.MarginLayoutParams) aVar).width == -1) {
                            if (aVar.S) {
                                e5.O[0] = aVar5;
                            } else {
                                e5.O[0] = aVar2;
                            }
                            e5.i(aVar7).f1086g = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                            e5.i(aVar6).f1086g = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                        } else {
                            e5.O[0] = aVar5;
                            e5.M(0);
                        }
                        if (aVar.W) {
                            e5.O[1] = aVar4;
                            e5.H(((ViewGroup.MarginLayoutParams) aVar).height);
                            if (((ViewGroup.MarginLayoutParams) aVar).height == -2) {
                                e5.O[1] = aVar3;
                            }
                        } else if (((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                            if (aVar.T) {
                                e5.O[1] = aVar5;
                            } else {
                                e5.O[1] = aVar2;
                            }
                            e5.i(aVar9).f1086g = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                            e5.i(aVar8).f1086g = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                        } else {
                            e5.O[1] = aVar5;
                            e5.H(0);
                        }
                        String str2 = aVar.B;
                        if (str2 == null || str2.length() == 0) {
                            e5.S = 0.0f;
                        } else {
                            int length = str2.length();
                            int indexOf2 = str2.indexOf(44);
                            if (indexOf2 <= 0 || indexOf2 >= length - 1) {
                                i5 = -1;
                                i4 = 0;
                            } else {
                                String substring = str2.substring(0, indexOf2);
                                i4 = indexOf2 + 1;
                                i5 = substring.equalsIgnoreCase("W") ? 0 : substring.equalsIgnoreCase("H") ? 1 : -1;
                            }
                            int indexOf3 = str2.indexOf(58);
                            if (indexOf3 < 0 || indexOf3 >= length - 1) {
                                String substring2 = str2.substring(i4);
                                if (substring2.length() > 0) {
                                    f2 = Float.parseFloat(substring2);
                                    if (f2 > 0.0f) {
                                        e5.S = f2;
                                        e5.T = i5;
                                    }
                                }
                            } else {
                                String substring3 = str2.substring(i4, indexOf3);
                                String substring4 = str2.substring(indexOf3 + 1);
                                if (substring3.length() > 0 && substring4.length() > 0) {
                                    try {
                                        float parseFloat = Float.parseFloat(substring3);
                                        float parseFloat2 = Float.parseFloat(substring4);
                                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                            f2 = i5 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                                            if (f2 > 0.0f) {
                                            }
                                        }
                                    } catch (NumberFormatException unused2) {
                                    }
                                }
                            }
                            f2 = 0.0f;
                            if (f2 > 0.0f) {
                            }
                        }
                        float f7 = aVar.D;
                        float[] fArr = e5.g0;
                        fArr[0] = f7;
                        fArr[1] = aVar.E;
                        e5.e0 = aVar.F;
                        e5.f0 = aVar.G;
                        int i43 = aVar.H;
                        int i44 = aVar.J;
                        int i45 = aVar.L;
                        float f8 = aVar.N;
                        e5.f1105l = i43;
                        e5.o = i44;
                        if (i45 == Integer.MAX_VALUE) {
                            i45 = 0;
                        }
                        e5.p = i45;
                        e5.q = f8;
                        if (f8 > 0.0f && f8 < 1.0f && i43 == 0) {
                            e5.f1105l = 2;
                        }
                        int i46 = aVar.I;
                        int i47 = aVar.K;
                        int i48 = aVar.M;
                        float f9 = aVar.O;
                        e5.m = i46;
                        e5.r = i47;
                        if (i48 == Integer.MAX_VALUE) {
                            i48 = 0;
                        }
                        e5.s = i48;
                        e5.t = f9;
                        if (f9 <= 0.0f || f9 >= 1.0f || i46 != 0) {
                            i28 = i2 + 1;
                            childCount2 = i3;
                            z = z3;
                            isInEditMode = z2;
                        } else {
                            e5.m = 2;
                            i28 = i2 + 1;
                            childCount2 = i3;
                            z = z3;
                            isInEditMode = z2;
                        }
                    }
                }
                z2 = isInEditMode;
                i2 = i28;
                i28 = i2 + 1;
                childCount2 = i3;
                z = z3;
                isInEditMode = z2;
            }
        }
        return z;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            a aVar = (a) childAt.getLayoutParams();
            e.g.b.h.d dVar = aVar.l0;
            if ((childAt.getVisibility() != 8 || aVar.Y || aVar.Z || isInEditMode) && !aVar.a0) {
                int s2 = dVar.s();
                int t2 = dVar.t();
                int r2 = dVar.r() + s2;
                int l2 = dVar.l() + t2;
                childAt.layout(s2, t2, r2, l2);
                if ((childAt instanceof g) && (content = ((g) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(s2, t2, r2, l2);
                }
            }
        }
        int size = this.c.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.c.get(i7).h();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x0259 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x052b  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0544  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x05dc  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0622  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0633  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0638  */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x05e0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01f6  */
    public void onMeasure(int i2, int i3) {
        d.a aVar;
        int i4;
        d.a aVar2;
        d.a aVar3;
        int i5;
        d.a aVar4;
        int i6;
        int i7;
        int size;
        boolean z;
        boolean z2;
        int i8;
        boolean z3;
        e.g.b.h.l.b bVar;
        int i9;
        int i10;
        b.AbstractC0026b bVar2;
        c.a aVar5;
        c.a aVar6;
        boolean z4;
        int i11;
        boolean z5;
        int r2;
        int l2;
        boolean z6;
        boolean z7;
        ConstraintLayout constraintLayout;
        int i12;
        int i13;
        e.g.b.h.l.b bVar3;
        int size2;
        int i14;
        boolean z8;
        boolean z9;
        int i15;
        b.AbstractC0026b bVar4;
        e eVar;
        int i16;
        int i17;
        b.AbstractC0026b bVar5;
        c.a aVar7;
        c.a aVar8;
        e.g.b.h.l.b bVar6;
        e.g.b.h.l.k kVar;
        m mVar;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z10;
        boolean z11;
        int i22;
        int i23;
        e eVar2;
        if (!this.f115i) {
            int childCount = getChildCount();
            int i24 = 0;
            while (true) {
                if (i24 >= childCount) {
                    break;
                } else if (getChildAt(i24).isLayoutRequested()) {
                    this.f115i = true;
                    break;
                } else {
                    i24++;
                }
            }
        }
        if (!this.f115i) {
            int i25 = this.s;
            if (i25 == i2 && this.t == i3) {
                r2 = this.f110d.r();
                l2 = this.f110d.l();
                eVar2 = this.f110d;
                z6 = eVar2.y0;
            } else if (i25 == i2 && View.MeasureSpec.getMode(i2) == 1073741824 && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && View.MeasureSpec.getMode(this.t) == Integer.MIN_VALUE && View.MeasureSpec.getSize(i3) >= this.f110d.l()) {
                this.s = i2;
                this.t = i3;
                r2 = this.f110d.r();
                l2 = this.f110d.l();
                eVar2 = this.f110d;
                z6 = eVar2.y0;
            }
            z7 = eVar2.z0;
            constraintLayout = this;
            i12 = i2;
            i13 = i3;
            constraintLayout.h(i12, i13, r2, l2, z6, z7);
        }
        this.s = i2;
        this.t = i3;
        this.f110d.p0 = g();
        if (this.f115i) {
            this.f115i = false;
            if (j()) {
                e eVar3 = this.f110d;
                eVar3.m0.c(eVar3);
            }
        }
        e eVar4 = this.f110d;
        int i26 = this.f116j;
        d.a aVar9 = d.a.FIXED;
        int mode = View.MeasureSpec.getMode(i2);
        int size3 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size4 = View.MeasureSpec.getSize(i3);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i27 = max + max2;
        int paddingWidth = getPaddingWidth();
        b bVar7 = this.r;
        bVar7.b = max;
        bVar7.c = max2;
        bVar7.f128d = paddingWidth;
        bVar7.f129e = i27;
        bVar7.f130f = i2;
        bVar7.f131g = i3;
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        if (max3 <= 0 && max4 <= 0) {
            max3 = Math.max(0, getPaddingLeft());
        } else if (g()) {
            max3 = max4;
        }
        int i28 = size3 - paddingWidth;
        int i29 = size4 - i27;
        d.a aVar10 = d.a.WRAP_CONTENT;
        b bVar8 = this.r;
        int i30 = bVar8.f129e;
        int i31 = bVar8.f128d;
        int childCount2 = getChildCount();
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode != 1073741824) {
                    aVar = aVar9;
                } else {
                    i4 = Math.min(this.f113g - i31, i28);
                    aVar = aVar9;
                    if (mode2 == Integer.MIN_VALUE) {
                        if (mode2 != 0) {
                            if (mode2 != 1073741824) {
                                aVar4 = aVar9;
                            } else {
                                aVar2 = aVar10;
                                aVar3 = aVar9;
                                i5 = Math.min(this.f114h - i30, i29);
                                aVar4 = aVar3;
                                if (i4 == eVar4.r() || i5 != eVar4.l()) {
                                    i6 = i29;
                                    eVar4.n0.c = true;
                                    i7 = 0;
                                } else {
                                    i6 = i29;
                                    i7 = 0;
                                }
                                eVar4.U = i7;
                                eVar4.V = i7;
                                int[] iArr = eVar4.w;
                                iArr[i7] = this.f113g - i31;
                                iArr[1] = this.f114h - i30;
                                eVar4.K(i7);
                                eVar4.J(i7);
                                eVar4.O[i7] = aVar;
                                eVar4.M(i4);
                                eVar4.O[1] = aVar4;
                                eVar4.H(i5);
                                eVar4.K(this.f111e - i31);
                                eVar4.J(this.f112f - i30);
                                eVar4.r0 = max3;
                                eVar4.s0 = max;
                                e.g.b.h.l.b bVar9 = eVar4.m0;
                                Objects.requireNonNull(bVar9);
                                c.a aVar11 = c.a.BOTTOM;
                                c.a aVar12 = c.a.RIGHT;
                                d.a aVar13 = d.a.MATCH_CONSTRAINT;
                                b.AbstractC0026b bVar10 = eVar4.o0;
                                size = eVar4.l0.size();
                                int r3 = eVar4.r();
                                int l3 = eVar4.l();
                                boolean b2 = i.b(i26, 128);
                                z = !b2 || i.b(i26, 64);
                                if (z) {
                                    int i32 = 0;
                                    while (true) {
                                        if (i32 >= size) {
                                            break;
                                        }
                                        e.g.b.h.d dVar = eVar4.l0.get(i32);
                                        boolean z12 = (dVar.m() == aVar13) && (dVar.q() == aVar13) && dVar.S > 0.0f;
                                        if ((!dVar.w() || !z12) && ((!dVar.x() || !z12) && !(dVar instanceof j) && !dVar.w() && !dVar.x())) {
                                            i32++;
                                            z = z;
                                        }
                                    }
                                    i8 = 1073741824;
                                    z2 = false;
                                    z3 = z2 & ((mode != i8 && mode2 == i8) || b2);
                                    if (!z3) {
                                        int min = Math.min(eVar4.w[0], i28);
                                        int min2 = Math.min(eVar4.w[1], i6);
                                        if (mode == 1073741824 && eVar4.r() != min) {
                                            eVar4.M(min);
                                            eVar4.W();
                                        }
                                        if (mode2 == 1073741824 && eVar4.l() != min2) {
                                            eVar4.H(min2);
                                            eVar4.W();
                                        }
                                        if (mode == 1073741824 && mode2 == 1073741824) {
                                            e.g.b.h.l.e eVar5 = eVar4.n0;
                                            d.a aVar14 = d.a.MATCH_PARENT;
                                            boolean z13 = b2 & true;
                                            if (eVar5.b || eVar5.c) {
                                                for (Iterator<e.g.b.h.d> it = eVar5.a.l0.iterator(); it.hasNext(); it = it) {
                                                    e.g.b.h.d next = it.next();
                                                    next.h();
                                                    next.a = false;
                                                    next.f1097d.n();
                                                    next.f1098e.m();
                                                    z3 = z3;
                                                }
                                                z4 = z3;
                                                eVar5.a.h();
                                                e eVar6 = eVar5.a;
                                                i21 = 0;
                                                eVar6.a = false;
                                                eVar6.f1097d.n();
                                                eVar5.a.f1098e.m();
                                                eVar5.c = false;
                                            } else {
                                                z4 = z3;
                                                i21 = 0;
                                            }
                                            eVar5.b(eVar5.f1118d);
                                            e eVar7 = eVar5.a;
                                            eVar7.U = i21;
                                            eVar7.V = i21;
                                            d.a k2 = eVar7.k(i21);
                                            aVar6 = aVar11;
                                            d.a k3 = eVar5.a.k(1);
                                            if (eVar5.b) {
                                                eVar5.c();
                                            }
                                            int s2 = eVar5.a.s();
                                            aVar5 = aVar12;
                                            int t2 = eVar5.a.t();
                                            bVar2 = bVar10;
                                            eVar5.a.f1097d.f1149h.c(s2);
                                            eVar5.a.f1098e.f1149h.c(t2);
                                            eVar5.g();
                                            if (k2 == aVar2 || k3 == aVar2) {
                                                boolean z14 = z13;
                                                if (z13) {
                                                    Iterator<o> it2 = eVar5.f1119e.iterator();
                                                    while (true) {
                                                        if (it2.hasNext()) {
                                                            if (!it2.next().k()) {
                                                                z14 = false;
                                                                break;
                                                            }
                                                        } else {
                                                            break;
                                                        }
                                                    }
                                                }
                                                if (!z14 || k2 != aVar2) {
                                                    i10 = r3;
                                                    i9 = l3;
                                                } else {
                                                    e eVar8 = eVar5.a;
                                                    i10 = r3;
                                                    i9 = l3;
                                                    eVar8.O[0] = aVar3;
                                                    eVar8.M(eVar5.d(eVar8, 0));
                                                    e eVar9 = eVar5.a;
                                                    eVar9.f1097d.f1146e.c(eVar9.r());
                                                }
                                                if (z14 && k3 == aVar2) {
                                                    e eVar10 = eVar5.a;
                                                    eVar10.O[1] = aVar3;
                                                    eVar10.H(eVar5.d(eVar10, 1));
                                                    e eVar11 = eVar5.a;
                                                    eVar11.f1098e.f1146e.c(eVar11.l());
                                                }
                                            } else {
                                                i10 = r3;
                                                i9 = l3;
                                            }
                                            e eVar12 = eVar5.a;
                                            d.a[] aVarArr = eVar12.O;
                                            aVar2 = aVar2;
                                            bVar = bVar9;
                                            if (aVarArr[0] == aVar3 || aVarArr[0] == aVar14) {
                                                int r4 = eVar12.r() + s2;
                                                eVar5.a.f1097d.f1150i.c(r4);
                                                eVar5.a.f1097d.f1146e.c(r4 - s2);
                                                eVar5.g();
                                                e eVar13 = eVar5.a;
                                                d.a[] aVarArr2 = eVar13.O;
                                                if (aVarArr2[1] == aVar3 || aVarArr2[1] == aVar14) {
                                                    int l4 = eVar13.l() + t2;
                                                    eVar5.a.f1098e.f1150i.c(l4);
                                                    eVar5.a.f1098e.f1146e.c(l4 - t2);
                                                }
                                                eVar5.g();
                                                z10 = true;
                                            } else {
                                                z10 = false;
                                            }
                                            Iterator<o> it3 = eVar5.f1119e.iterator();
                                            while (it3.hasNext()) {
                                                o next2 = it3.next();
                                                if (next2.b != eVar5.a || next2.f1148g) {
                                                    next2.e();
                                                }
                                            }
                                            Iterator<o> it4 = eVar5.f1119e.iterator();
                                            while (true) {
                                                if (!it4.hasNext()) {
                                                    z11 = true;
                                                    break;
                                                }
                                                o next3 = it4.next();
                                                if ((z10 || next3.b != eVar5.a) && (!next3.f1149h.f1129j || ((!next3.f1150i.f1129j && !(next3 instanceof e.g.b.h.l.i)) || (!next3.f1146e.f1129j && !(next3 instanceof e.g.b.h.l.c) && !(next3 instanceof e.g.b.h.l.i))))) {
                                                    z11 = false;
                                                }
                                            }
                                            z11 = false;
                                            eVar5.a.I(k2);
                                            eVar5.a.L(k3);
                                            z5 = z11;
                                            i18 = 1073741824;
                                            i11 = 2;
                                        } else {
                                            bVar = bVar9;
                                            aVar6 = aVar11;
                                            aVar5 = aVar12;
                                            bVar2 = bVar10;
                                            z4 = z3;
                                            i10 = r3;
                                            i9 = l3;
                                            e.g.b.h.l.e eVar14 = eVar4.n0;
                                            if (eVar14.b) {
                                                Iterator<e.g.b.h.d> it5 = eVar14.a.l0.iterator();
                                                while (it5.hasNext()) {
                                                    e.g.b.h.d next4 = it5.next();
                                                    next4.h();
                                                    next4.a = false;
                                                    e.g.b.h.l.k kVar2 = next4.f1097d;
                                                    kVar2.f1146e.f1129j = false;
                                                    kVar2.f1148g = false;
                                                    kVar2.n();
                                                    m mVar2 = next4.f1098e;
                                                    mVar2.f1146e.f1129j = false;
                                                    mVar2.f1148g = false;
                                                    mVar2.m();
                                                }
                                                i19 = 0;
                                                eVar14.a.h();
                                                e eVar15 = eVar14.a;
                                                eVar15.a = false;
                                                e.g.b.h.l.k kVar3 = eVar15.f1097d;
                                                kVar3.f1146e.f1129j = false;
                                                kVar3.f1148g = false;
                                                kVar3.n();
                                                m mVar3 = eVar14.a.f1098e;
                                                mVar3.f1146e.f1129j = false;
                                                mVar3.f1148g = false;
                                                mVar3.m();
                                                eVar14.c();
                                            } else {
                                                i19 = 0;
                                            }
                                            eVar14.b(eVar14.f1118d);
                                            e eVar16 = eVar14.a;
                                            eVar16.U = i19;
                                            eVar16.V = i19;
                                            eVar16.f1097d.f1149h.c(i19);
                                            eVar14.a.f1098e.f1149h.c(i19);
                                            i18 = 1073741824;
                                            if (mode == 1073741824) {
                                                i20 = 1;
                                                z5 = eVar4.V(b2, i19) & true;
                                                i11 = 1;
                                            } else {
                                                i20 = 1;
                                                z5 = true;
                                                i11 = 0;
                                            }
                                            if (mode2 == 1073741824) {
                                                z5 &= eVar4.V(b2, i20);
                                                i11++;
                                            }
                                        }
                                        if (z5) {
                                            eVar4.N(mode == i18, mode2 == i18);
                                        }
                                    } else {
                                        bVar = bVar9;
                                        aVar6 = aVar11;
                                        aVar5 = aVar12;
                                        bVar2 = bVar10;
                                        z4 = z3;
                                        i10 = r3;
                                        i9 = l3;
                                        z5 = false;
                                        i11 = 0;
                                    }
                                    if (!z5 || i11 != 2) {
                                        int i33 = eVar4.x0;
                                        if (size <= 0) {
                                            int size5 = eVar4.l0.size();
                                            boolean Y = eVar4.Y(64);
                                            b.AbstractC0026b bVar11 = eVar4.o0;
                                            int i34 = 0;
                                            while (i34 < size5) {
                                                e.g.b.h.d dVar2 = eVar4.l0.get(i34);
                                                if (!(dVar2 instanceof f) && !(dVar2 instanceof e.g.b.h.a) && !dVar2.A && (!Y || (kVar = dVar2.f1097d) == null || (mVar = dVar2.f1098e) == null || !kVar.f1146e.f1129j || !mVar.f1146e.f1129j)) {
                                                    d.a k4 = dVar2.k(0);
                                                    d.a k5 = dVar2.k(1);
                                                    boolean z15 = k4 == aVar13 && dVar2.f1105l != 1 && k5 == aVar13 && dVar2.m != 1;
                                                    if (!z15 && eVar4.Y(1) && !(dVar2 instanceof j)) {
                                                        if (k4 == aVar13 && dVar2.f1105l == 0 && k5 != aVar13 && !dVar2.w()) {
                                                            z15 = true;
                                                        }
                                                        if (k5 == aVar13 && dVar2.m == 0 && k4 != aVar13 && !dVar2.w()) {
                                                            z15 = true;
                                                        }
                                                        if (k4 == aVar13 || k5 == aVar13) {
                                                            if (dVar2.S > 0.0f) {
                                                                z15 = true;
                                                            }
                                                            bVar6 = bVar;
                                                            if (z15) {
                                                                bVar6.a(bVar11, dVar2, 0);
                                                            }
                                                        }
                                                    }
                                                    bVar6 = bVar;
                                                    if (z15) {
                                                    }
                                                } else {
                                                    bVar6 = bVar;
                                                }
                                                i34++;
                                                bVar = bVar6;
                                            }
                                            bVar3 = bVar;
                                            b bVar12 = (b) bVar11;
                                            int childCount3 = bVar12.a.getChildCount();
                                            for (int i35 = 0; i35 < childCount3; i35++) {
                                                View childAt = bVar12.a.getChildAt(i35);
                                                if (childAt instanceof g) {
                                                    ((g) childAt).a();
                                                }
                                            }
                                            int size6 = bVar12.a.c.size();
                                            if (size6 > 0) {
                                                for (int i36 = 0; i36 < size6; i36++) {
                                                    bVar12.a.c.get(i36).i();
                                                }
                                            }
                                        } else {
                                            bVar3 = bVar;
                                        }
                                        bVar3.c(eVar4);
                                        size2 = bVar3.a.size();
                                        int i37 = i10;
                                        if (size > 0) {
                                            bVar3.b(eVar4, i37, i9);
                                        }
                                        if (size2 > 0) {
                                            boolean z16 = eVar4.m() == aVar2;
                                            boolean z17 = eVar4.q() == aVar2;
                                            int max5 = Math.max(eVar4.r(), bVar3.c.X);
                                            int max6 = Math.max(eVar4.l(), bVar3.c.Y);
                                            int i38 = 0;
                                            boolean z18 = false;
                                            while (i38 < size2) {
                                                e.g.b.h.d dVar3 = bVar3.a.get(i38);
                                                if (!(dVar3 instanceof j)) {
                                                    i17 = i33;
                                                    aVar7 = aVar6;
                                                    aVar8 = aVar5;
                                                    bVar5 = bVar2;
                                                } else {
                                                    int r5 = dVar3.r();
                                                    int l5 = dVar3.l();
                                                    i17 = i33;
                                                    bVar5 = bVar2;
                                                    boolean a2 = z18 | bVar3.a(bVar5, dVar3, 1);
                                                    int r6 = dVar3.r();
                                                    boolean z19 = a2;
                                                    int l6 = dVar3.l();
                                                    if (r6 != r5) {
                                                        dVar3.M(r6);
                                                        if (!z16 || dVar3.p() <= max5) {
                                                            aVar8 = aVar5;
                                                        } else {
                                                            aVar8 = aVar5;
                                                            max5 = Math.max(max5, dVar3.i(aVar8).d() + dVar3.p());
                                                        }
                                                        z19 = true;
                                                    } else {
                                                        aVar8 = aVar5;
                                                    }
                                                    if (l6 != l5) {
                                                        dVar3.H(l6);
                                                        if (!z17 || dVar3.j() <= max6) {
                                                            aVar7 = aVar6;
                                                        } else {
                                                            aVar7 = aVar6;
                                                            max6 = Math.max(max6, dVar3.i(aVar7).d() + dVar3.j());
                                                        }
                                                        z19 = true;
                                                    } else {
                                                        aVar7 = aVar6;
                                                    }
                                                    j jVar = (j) dVar3;
                                                    z18 = z19 | false;
                                                }
                                                i38++;
                                                aVar5 = aVar8;
                                                aVar6 = aVar7;
                                                bVar2 = bVar5;
                                                i33 = i17;
                                            }
                                            b.AbstractC0026b bVar13 = bVar2;
                                            int i39 = 0;
                                            while (true) {
                                                if (i39 >= 2) {
                                                    i14 = i37;
                                                    break;
                                                }
                                                boolean z20 = z18;
                                                int i40 = 0;
                                                while (i40 < size2) {
                                                    e.g.b.h.d dVar4 = bVar3.a.get(i40);
                                                    if ((!(dVar4 instanceof e.g.b.h.g) || (dVar4 instanceof j)) && !(dVar4 instanceof f)) {
                                                        i16 = size2;
                                                        if (dVar4.c0 != 8 && ((!z4 || !dVar4.f1097d.f1146e.f1129j || !dVar4.f1098e.f1146e.f1129j) && !(dVar4 instanceof j))) {
                                                            int r7 = dVar4.r();
                                                            int l7 = dVar4.l();
                                                            eVar = eVar4;
                                                            int i41 = dVar4.W;
                                                            i15 = i37;
                                                            int i42 = 1;
                                                            if (i39 == 1) {
                                                                i42 = 2;
                                                            }
                                                            z20 = bVar3.a(bVar13, dVar4, i42) | z20;
                                                            int r8 = dVar4.r();
                                                            bVar4 = bVar13;
                                                            int l8 = dVar4.l();
                                                            if (r8 != r7) {
                                                                dVar4.M(r8);
                                                                if (z16 && dVar4.p() > max5) {
                                                                    max5 = Math.max(max5, dVar4.i(aVar5).d() + dVar4.p());
                                                                }
                                                                z20 = true;
                                                            }
                                                            if (l8 != l7) {
                                                                dVar4.H(l8);
                                                                if (z17 && dVar4.j() > max6) {
                                                                    max6 = Math.max(max6, dVar4.i(aVar6).d() + dVar4.j());
                                                                }
                                                                z20 = true;
                                                            }
                                                            if (dVar4.y && i41 != dVar4.W) {
                                                                z20 = true;
                                                            }
                                                            i40++;
                                                            size2 = i16;
                                                            eVar4 = eVar;
                                                            bVar13 = bVar4;
                                                            i37 = i15;
                                                        }
                                                    } else {
                                                        i16 = size2;
                                                    }
                                                    eVar = eVar4;
                                                    i15 = i37;
                                                    bVar4 = bVar13;
                                                    i40++;
                                                    size2 = i16;
                                                    eVar4 = eVar;
                                                    bVar13 = bVar4;
                                                    i37 = i15;
                                                }
                                                if (!z20) {
                                                    eVar4 = eVar4;
                                                    i14 = i37;
                                                    z18 = z20;
                                                    break;
                                                }
                                                eVar4 = eVar4;
                                                bVar3.b(eVar4, i37, i9);
                                                i39++;
                                                i37 = i37;
                                                size2 = size2;
                                                bVar13 = bVar13;
                                                z18 = false;
                                            }
                                            if (z18) {
                                                bVar3.b(eVar4, i14, i9);
                                                if (eVar4.r() < max5) {
                                                    eVar4.M(max5);
                                                    z8 = true;
                                                } else {
                                                    z8 = false;
                                                }
                                                if (eVar4.l() < max6) {
                                                    eVar4.H(max6);
                                                    z9 = true;
                                                } else {
                                                    z9 = z8;
                                                }
                                                if (z9) {
                                                    bVar3.b(eVar4, i14, i9);
                                                }
                                            }
                                            i33 = i33;
                                        }
                                        eVar4.Z(i33);
                                    }
                                    r2 = this.f110d.r();
                                    l2 = this.f110d.l();
                                    e eVar17 = this.f110d;
                                    z6 = eVar17.y0;
                                    z7 = eVar17.z0;
                                    constraintLayout = this;
                                    i12 = i2;
                                    i13 = i3;
                                    constraintLayout.h(i12, i13, r2, l2, z6, z7);
                                }
                                z2 = z;
                                i8 = 1073741824;
                                z3 = z2 & ((mode != i8 && mode2 == i8) || b2);
                                if (!z3) {
                                }
                                int i332 = eVar4.x0;
                                if (size <= 0) {
                                }
                                bVar3.c(eVar4);
                                size2 = bVar3.a.size();
                                int i372 = i10;
                                if (size > 0) {
                                }
                                if (size2 > 0) {
                                }
                                eVar4.Z(i332);
                                r2 = this.f110d.r();
                                l2 = this.f110d.l();
                                e eVar172 = this.f110d;
                                z6 = eVar172.y0;
                                z7 = eVar172.z0;
                                constraintLayout = this;
                                i12 = i2;
                                i13 = i3;
                                constraintLayout.h(i12, i13, r2, l2, z6, z7);
                            }
                        } else if (childCount2 != 0) {
                            aVar4 = aVar10;
                        }
                        aVar2 = aVar10;
                        aVar3 = aVar9;
                        i5 = 0;
                        if (i4 == eVar4.r()) {
                        }
                        i6 = i29;
                        eVar4.n0.c = true;
                        i7 = 0;
                        eVar4.U = i7;
                        eVar4.V = i7;
                        int[] iArr2 = eVar4.w;
                        iArr2[i7] = this.f113g - i31;
                        iArr2[1] = this.f114h - i30;
                        eVar4.K(i7);
                        eVar4.J(i7);
                        eVar4.O[i7] = aVar;
                        eVar4.M(i4);
                        eVar4.O[1] = aVar4;
                        eVar4.H(i5);
                        eVar4.K(this.f111e - i31);
                        eVar4.J(this.f112f - i30);
                        eVar4.r0 = max3;
                        eVar4.s0 = max;
                        e.g.b.h.l.b bVar92 = eVar4.m0;
                        Objects.requireNonNull(bVar92);
                        c.a aVar112 = c.a.BOTTOM;
                        c.a aVar122 = c.a.RIGHT;
                        d.a aVar132 = d.a.MATCH_CONSTRAINT;
                        b.AbstractC0026b bVar102 = eVar4.o0;
                        size = eVar4.l0.size();
                        int r32 = eVar4.r();
                        int l32 = eVar4.l();
                        boolean b22 = i.b(i26, 128);
                        if (!b22) {
                        }
                        if (z) {
                        }
                        z2 = z;
                        i8 = 1073741824;
                        z3 = z2 & ((mode != i8 && mode2 == i8) || b22);
                        if (!z3) {
                        }
                        int i3322 = eVar4.x0;
                        if (size <= 0) {
                        }
                        bVar3.c(eVar4);
                        size2 = bVar3.a.size();
                        int i3722 = i10;
                        if (size > 0) {
                        }
                        if (size2 > 0) {
                        }
                        eVar4.Z(i3322);
                        r2 = this.f110d.r();
                        l2 = this.f110d.l();
                        e eVar1722 = this.f110d;
                        z6 = eVar1722.y0;
                        z7 = eVar1722.z0;
                        constraintLayout = this;
                        i12 = i2;
                        i13 = i3;
                        constraintLayout.h(i12, i13, r2, l2, z6, z7);
                    } else if (childCount2 != 0) {
                        aVar3 = aVar9;
                        i22 = i29;
                        i5 = i22;
                        aVar4 = aVar10;
                        aVar2 = aVar4;
                        if (i4 == eVar4.r()) {
                        }
                        i6 = i29;
                        eVar4.n0.c = true;
                        i7 = 0;
                        eVar4.U = i7;
                        eVar4.V = i7;
                        int[] iArr22 = eVar4.w;
                        iArr22[i7] = this.f113g - i31;
                        iArr22[1] = this.f114h - i30;
                        eVar4.K(i7);
                        eVar4.J(i7);
                        eVar4.O[i7] = aVar;
                        eVar4.M(i4);
                        eVar4.O[1] = aVar4;
                        eVar4.H(i5);
                        eVar4.K(this.f111e - i31);
                        eVar4.J(this.f112f - i30);
                        eVar4.r0 = max3;
                        eVar4.s0 = max;
                        e.g.b.h.l.b bVar922 = eVar4.m0;
                        Objects.requireNonNull(bVar922);
                        c.a aVar1122 = c.a.BOTTOM;
                        c.a aVar1222 = c.a.RIGHT;
                        d.a aVar1322 = d.a.MATCH_CONSTRAINT;
                        b.AbstractC0026b bVar1022 = eVar4.o0;
                        size = eVar4.l0.size();
                        int r322 = eVar4.r();
                        int l322 = eVar4.l();
                        boolean b222 = i.b(i26, 128);
                        if (!b222) {
                        }
                        if (z) {
                        }
                        z2 = z;
                        i8 = 1073741824;
                        z3 = z2 & ((mode != i8 && mode2 == i8) || b222);
                        if (!z3) {
                        }
                        int i33222 = eVar4.x0;
                        if (size <= 0) {
                        }
                        bVar3.c(eVar4);
                        size2 = bVar3.a.size();
                        int i37222 = i10;
                        if (size > 0) {
                        }
                        if (size2 > 0) {
                        }
                        eVar4.Z(i33222);
                        r2 = this.f110d.r();
                        l2 = this.f110d.l();
                        e eVar17222 = this.f110d;
                        z6 = eVar17222.y0;
                        z7 = eVar17222.z0;
                        constraintLayout = this;
                        i12 = i2;
                        i13 = i3;
                        constraintLayout.h(i12, i13, r2, l2, z6, z7);
                    }
                    aVar3 = aVar9;
                    i22 = Math.max(0, this.f112f);
                    i5 = i22;
                    aVar4 = aVar10;
                    aVar2 = aVar4;
                    if (i4 == eVar4.r()) {
                    }
                    i6 = i29;
                    eVar4.n0.c = true;
                    i7 = 0;
                    eVar4.U = i7;
                    eVar4.V = i7;
                    int[] iArr222 = eVar4.w;
                    iArr222[i7] = this.f113g - i31;
                    iArr222[1] = this.f114h - i30;
                    eVar4.K(i7);
                    eVar4.J(i7);
                    eVar4.O[i7] = aVar;
                    eVar4.M(i4);
                    eVar4.O[1] = aVar4;
                    eVar4.H(i5);
                    eVar4.K(this.f111e - i31);
                    eVar4.J(this.f112f - i30);
                    eVar4.r0 = max3;
                    eVar4.s0 = max;
                    e.g.b.h.l.b bVar9222 = eVar4.m0;
                    Objects.requireNonNull(bVar9222);
                    c.a aVar11222 = c.a.BOTTOM;
                    c.a aVar12222 = c.a.RIGHT;
                    d.a aVar13222 = d.a.MATCH_CONSTRAINT;
                    b.AbstractC0026b bVar10222 = eVar4.o0;
                    size = eVar4.l0.size();
                    int r3222 = eVar4.r();
                    int l3222 = eVar4.l();
                    boolean b2222 = i.b(i26, 128);
                    if (!b2222) {
                    }
                    if (z) {
                    }
                    z2 = z;
                    i8 = 1073741824;
                    z3 = z2 & ((mode != i8 && mode2 == i8) || b2222);
                    if (!z3) {
                    }
                    int i332222 = eVar4.x0;
                    if (size <= 0) {
                    }
                    bVar3.c(eVar4);
                    size2 = bVar3.a.size();
                    int i372222 = i10;
                    if (size > 0) {
                    }
                    if (size2 > 0) {
                    }
                    eVar4.Z(i332222);
                    r2 = this.f110d.r();
                    l2 = this.f110d.l();
                    e eVar172222 = this.f110d;
                    z6 = eVar172222.y0;
                    z7 = eVar172222.z0;
                    constraintLayout = this;
                    i12 = i2;
                    i13 = i3;
                    constraintLayout.h(i12, i13, r2, l2, z6, z7);
                }
            } else if (childCount2 != 0) {
                aVar = aVar10;
            }
            i4 = 0;
            if (mode2 == Integer.MIN_VALUE) {
            }
            aVar3 = aVar9;
            i22 = Math.max(0, this.f112f);
            i5 = i22;
            aVar4 = aVar10;
            aVar2 = aVar4;
            if (i4 == eVar4.r()) {
            }
            i6 = i29;
            eVar4.n0.c = true;
            i7 = 0;
            eVar4.U = i7;
            eVar4.V = i7;
            int[] iArr2222 = eVar4.w;
            iArr2222[i7] = this.f113g - i31;
            iArr2222[1] = this.f114h - i30;
            eVar4.K(i7);
            eVar4.J(i7);
            eVar4.O[i7] = aVar;
            eVar4.M(i4);
            eVar4.O[1] = aVar4;
            eVar4.H(i5);
            eVar4.K(this.f111e - i31);
            eVar4.J(this.f112f - i30);
            eVar4.r0 = max3;
            eVar4.s0 = max;
            e.g.b.h.l.b bVar92222 = eVar4.m0;
            Objects.requireNonNull(bVar92222);
            c.a aVar112222 = c.a.BOTTOM;
            c.a aVar122222 = c.a.RIGHT;
            d.a aVar132222 = d.a.MATCH_CONSTRAINT;
            b.AbstractC0026b bVar102222 = eVar4.o0;
            size = eVar4.l0.size();
            int r32222 = eVar4.r();
            int l32222 = eVar4.l();
            boolean b22222 = i.b(i26, 128);
            if (!b22222) {
            }
            if (z) {
            }
            z2 = z;
            i8 = 1073741824;
            z3 = z2 & ((mode != i8 && mode2 == i8) || b22222);
            if (!z3) {
            }
            int i3322222 = eVar4.x0;
            if (size <= 0) {
            }
            bVar3.c(eVar4);
            size2 = bVar3.a.size();
            int i3722222 = i10;
            if (size > 0) {
            }
            if (size2 > 0) {
            }
            eVar4.Z(i3322222);
            r2 = this.f110d.r();
            l2 = this.f110d.l();
            e eVar1722222 = this.f110d;
            z6 = eVar1722222.y0;
            z7 = eVar1722222.z0;
            constraintLayout = this;
            i12 = i2;
            i13 = i3;
            constraintLayout.h(i12, i13, r2, l2, z6, z7);
        } else if (childCount2 != 0) {
            i23 = i28;
            i4 = i23;
            aVar = aVar10;
            if (mode2 == Integer.MIN_VALUE) {
            }
            aVar3 = aVar9;
            i22 = Math.max(0, this.f112f);
            i5 = i22;
            aVar4 = aVar10;
            aVar2 = aVar4;
            if (i4 == eVar4.r()) {
            }
            i6 = i29;
            eVar4.n0.c = true;
            i7 = 0;
            eVar4.U = i7;
            eVar4.V = i7;
            int[] iArr22222 = eVar4.w;
            iArr22222[i7] = this.f113g - i31;
            iArr22222[1] = this.f114h - i30;
            eVar4.K(i7);
            eVar4.J(i7);
            eVar4.O[i7] = aVar;
            eVar4.M(i4);
            eVar4.O[1] = aVar4;
            eVar4.H(i5);
            eVar4.K(this.f111e - i31);
            eVar4.J(this.f112f - i30);
            eVar4.r0 = max3;
            eVar4.s0 = max;
            e.g.b.h.l.b bVar922222 = eVar4.m0;
            Objects.requireNonNull(bVar922222);
            c.a aVar1122222 = c.a.BOTTOM;
            c.a aVar1222222 = c.a.RIGHT;
            d.a aVar1322222 = d.a.MATCH_CONSTRAINT;
            b.AbstractC0026b bVar1022222 = eVar4.o0;
            size = eVar4.l0.size();
            int r322222 = eVar4.r();
            int l322222 = eVar4.l();
            boolean b222222 = i.b(i26, 128);
            if (!b222222) {
            }
            if (z) {
            }
            z2 = z;
            i8 = 1073741824;
            z3 = z2 & ((mode != i8 && mode2 == i8) || b222222);
            if (!z3) {
            }
            int i33222222 = eVar4.x0;
            if (size <= 0) {
            }
            bVar3.c(eVar4);
            size2 = bVar3.a.size();
            int i37222222 = i10;
            if (size > 0) {
            }
            if (size2 > 0) {
            }
            eVar4.Z(i33222222);
            r2 = this.f110d.r();
            l2 = this.f110d.l();
            e eVar17222222 = this.f110d;
            z6 = eVar17222222.y0;
            z7 = eVar17222222.z0;
            constraintLayout = this;
            i12 = i2;
            i13 = i3;
            constraintLayout.h(i12, i13, r2, l2, z6, z7);
        }
        i23 = Math.max(0, this.f111e);
        i4 = i23;
        aVar = aVar10;
        if (mode2 == Integer.MIN_VALUE) {
        }
        aVar3 = aVar9;
        i22 = Math.max(0, this.f112f);
        i5 = i22;
        aVar4 = aVar10;
        aVar2 = aVar4;
        if (i4 == eVar4.r()) {
        }
        i6 = i29;
        eVar4.n0.c = true;
        i7 = 0;
        eVar4.U = i7;
        eVar4.V = i7;
        int[] iArr222222 = eVar4.w;
        iArr222222[i7] = this.f113g - i31;
        iArr222222[1] = this.f114h - i30;
        eVar4.K(i7);
        eVar4.J(i7);
        eVar4.O[i7] = aVar;
        eVar4.M(i4);
        eVar4.O[1] = aVar4;
        eVar4.H(i5);
        eVar4.K(this.f111e - i31);
        eVar4.J(this.f112f - i30);
        eVar4.r0 = max3;
        eVar4.s0 = max;
        e.g.b.h.l.b bVar9222222 = eVar4.m0;
        Objects.requireNonNull(bVar9222222);
        c.a aVar11222222 = c.a.BOTTOM;
        c.a aVar12222222 = c.a.RIGHT;
        d.a aVar13222222 = d.a.MATCH_CONSTRAINT;
        b.AbstractC0026b bVar10222222 = eVar4.o0;
        size = eVar4.l0.size();
        int r3222222 = eVar4.r();
        int l3222222 = eVar4.l();
        boolean b2222222 = i.b(i26, 128);
        if (!b2222222) {
        }
        if (z) {
        }
        z2 = z;
        i8 = 1073741824;
        z3 = z2 & ((mode != i8 && mode2 == i8) || b2222222);
        if (!z3) {
        }
        int i332222222 = eVar4.x0;
        if (size <= 0) {
        }
        bVar3.c(eVar4);
        size2 = bVar3.a.size();
        int i372222222 = i10;
        if (size > 0) {
        }
        if (size2 > 0) {
        }
        eVar4.Z(i332222222);
        r2 = this.f110d.r();
        l2 = this.f110d.l();
        e eVar172222222 = this.f110d;
        z6 = eVar172222222.y0;
        z7 = eVar172222222.z0;
        constraintLayout = this;
        i12 = i2;
        i13 = i3;
        constraintLayout.h(i12, i13, r2, l2, z6, z7);
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        e.g.b.h.d e2 = e(view);
        if ((view instanceof Guideline) && !(e2 instanceof f)) {
            a aVar = (a) view.getLayoutParams();
            f fVar = new f();
            aVar.l0 = fVar;
            aVar.Y = true;
            fVar.Q(aVar.R);
        }
        if (view instanceof e.g.c.b) {
            e.g.c.b bVar = (e.g.c.b) view;
            bVar.k();
            ((a) view.getLayoutParams()).Z = true;
            if (!this.c.contains(bVar)) {
                this.c.add(bVar);
            }
        }
        this.b.put(view.getId(), view);
        this.f115i = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.b.remove(view.getId());
        e.g.b.h.d e2 = e(view);
        this.f110d.l0.remove(e2);
        e2.B();
        this.c.remove(view);
        this.f115i = true;
    }

    public void removeView(View view) {
        super.removeView(view);
    }

    public void requestLayout() {
        this.f115i = true;
        this.o = -1;
        this.p = -1;
        super.requestLayout();
    }

    public void setConstraintSet(e.g.c.d dVar) {
        this.f117k = dVar;
    }

    public void setId(int i2) {
        this.b.remove(getId());
        super.setId(i2);
        this.b.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 != this.f114h) {
            this.f114h = i2;
            requestLayout();
        }
    }

    public void setMaxWidth(int i2) {
        if (i2 != this.f113g) {
            this.f113g = i2;
            requestLayout();
        }
    }

    public void setMinHeight(int i2) {
        if (i2 != this.f112f) {
            this.f112f = i2;
            requestLayout();
        }
    }

    public void setMinWidth(int i2) {
        if (i2 != this.f111e) {
            this.f111e = i2;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(e.g.c.f fVar) {
        e.g.c.c cVar = this.f118l;
        if (cVar != null) {
            Objects.requireNonNull(cVar);
        }
    }

    public void setOptimizationLevel(int i2) {
        this.f116j = i2;
        e eVar = this.f110d;
        eVar.x0 = i2;
        e.g.b.d.p = eVar.Y(512);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
