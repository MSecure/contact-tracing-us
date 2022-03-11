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
import e.h.a.i.c;
import e.h.a.i.d;
import e.h.a.i.e;
import e.h.a.i.f;
import e.h.a.i.i;
import e.h.a.i.j;
import e.h.a.i.l.b;
import e.h.a.i.l.k;
import e.h.a.i.l.m;
import e.h.a.i.l.o;
import e.h.c.c;
import e.h.c.d;
import e.h.c.g;
import e.h.c.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    public static h u;
    public SparseArray<View> b = new SparseArray<>();
    public ArrayList<e.h.c.b> c = new ArrayList<>(4);

    /* renamed from: d */
    public e f111d = new e();

    /* renamed from: e */
    public int f112e = 0;

    /* renamed from: f */
    public int f113f = 0;

    /* renamed from: g */
    public int f114g = Integer.MAX_VALUE;

    /* renamed from: h */
    public int f115h = Integer.MAX_VALUE;

    /* renamed from: i */
    public boolean f116i = true;

    /* renamed from: j */
    public int f117j = 257;

    /* renamed from: k */
    public d f118k = null;

    /* renamed from: l */
    public c f119l = null;
    public int m = -1;
    public HashMap<String, Integer> n = new HashMap<>();
    public int o = -1;
    public int p = -1;
    public SparseArray<e.h.a.i.d> q = new SparseArray<>();
    public b r = new b(this);
    public int s = 0;
    public int t = 0;

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public int C;
        public float D;
        public float E;
        public String F;
        public float G;
        public float H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public float Q;
        public float R;
        public int S;
        public int T;
        public int U;
        public boolean V;
        public boolean W;
        public String X;
        public int Y;
        public boolean Z;
        public int a;
        public boolean a0;
        public int b;
        public boolean b0;
        public float c;
        public boolean c0;

        /* renamed from: d */
        public int f120d;
        public boolean d0;

        /* renamed from: e */
        public int f121e;
        public boolean e0;

        /* renamed from: f */
        public int f122f;
        public int f0;

        /* renamed from: g */
        public int f123g;
        public int g0;

        /* renamed from: h */
        public int f124h;
        public int h0;

        /* renamed from: i */
        public int f125i;
        public int i0;

        /* renamed from: j */
        public int f126j;
        public int j0;

        /* renamed from: k */
        public int f127k;
        public int k0;

        /* renamed from: l */
        public int f128l;
        public float l0;
        public int m;
        public int m0;
        public int n;
        public int n0;
        public int o;
        public float o0;
        public int p;
        public e.h.a.i.d p0;
        public float q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public int z;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a */
        /* loaded from: classes.dex */
        public static class C0001a {
            public static final SparseIntArray a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                a = sparseIntArray;
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
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
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
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
                SparseIntArray sparseIntArray2 = a;
                sparseIntArray2.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray2.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray2.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray2.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray2.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray2.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray2.append(R$styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray2.append(R$styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        public a(int i2, int i3) {
            super(i2, i3);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.f120d = -1;
            this.f121e = -1;
            this.f122f = -1;
            this.f123g = -1;
            this.f124h = -1;
            this.f125i = -1;
            this.f126j = -1;
            this.f127k = -1;
            this.f128l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = 0;
            this.q = 0.0f;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = Integer.MIN_VALUE;
            this.w = Integer.MIN_VALUE;
            this.x = Integer.MIN_VALUE;
            this.y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = 0;
            this.D = 0.5f;
            this.E = 0.5f;
            this.F = null;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 1.0f;
            this.R = 1.0f;
            this.S = -1;
            this.T = -1;
            this.U = -1;
            this.V = false;
            this.W = false;
            this.X = null;
            this.Y = 0;
            this.Z = true;
            this.a0 = true;
            this.b0 = false;
            this.c0 = false;
            this.d0 = false;
            this.e0 = false;
            this.f0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = Integer.MIN_VALUE;
            this.k0 = Integer.MIN_VALUE;
            this.l0 = 0.5f;
            this.p0 = new e.h.a.i.d();
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.f120d = -1;
            this.f121e = -1;
            this.f122f = -1;
            this.f123g = -1;
            this.f124h = -1;
            this.f125i = -1;
            this.f126j = -1;
            this.f127k = -1;
            this.f128l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = 0;
            this.q = 0.0f;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = Integer.MIN_VALUE;
            this.w = Integer.MIN_VALUE;
            this.x = Integer.MIN_VALUE;
            this.y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = 0;
            this.D = 0.5f;
            this.E = 0.5f;
            this.F = null;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 1.0f;
            this.R = 1.0f;
            this.S = -1;
            this.T = -1;
            this.U = -1;
            this.V = false;
            this.W = false;
            this.X = null;
            this.Y = 0;
            this.Z = true;
            this.a0 = true;
            this.b0 = false;
            this.c0 = false;
            this.d0 = false;
            this.e0 = false;
            this.f0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = Integer.MIN_VALUE;
            this.k0 = Integer.MIN_VALUE;
            this.l0 = 0.5f;
            this.p0 = new e.h.a.i.d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = C0001a.a.get(index);
                switch (i3) {
                    case 1:
                        this.U = obtainStyledAttributes.getInt(index, this.U);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.o);
                        this.o = resourceId;
                        if (resourceId == -1) {
                            this.o = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.p = obtainStyledAttributes.getDimensionPixelSize(index, this.p);
                        break;
                    case 4:
                        float f2 = obtainStyledAttributes.getFloat(index, this.q) % 360.0f;
                        this.q = f2;
                        if (f2 < 0.0f) {
                            this.q = (360.0f - f2) % 360.0f;
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
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f120d);
                        this.f120d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f120d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f121e);
                        this.f121e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f121e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f122f);
                        this.f122f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f122f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f123g);
                        this.f123g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f123g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f124h);
                        this.f124h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f124h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f125i);
                        this.f125i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f125i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f126j);
                        this.f126j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f126j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f127k);
                        this.f127k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f127k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f128l);
                        this.f128l = resourceId10;
                        if (resourceId10 == -1) {
                            this.f128l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.r);
                        this.r = resourceId11;
                        if (resourceId11 == -1) {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId12;
                        if (resourceId12 == -1) {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.t);
                        this.t = resourceId13;
                        if (resourceId13 == -1) {
                            this.t = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.u);
                        this.u = resourceId14;
                        if (resourceId14 == -1) {
                            this.u = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 22:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 23:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 24:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 25:
                        this.z = obtainStyledAttributes.getDimensionPixelSize(index, this.z);
                        break;
                    case 26:
                        this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 27:
                        this.V = obtainStyledAttributes.getBoolean(index, this.V);
                        break;
                    case 28:
                        this.W = obtainStyledAttributes.getBoolean(index, this.W);
                        break;
                    case 29:
                        this.D = obtainStyledAttributes.getFloat(index, this.D);
                        break;
                    case 30:
                        this.E = obtainStyledAttributes.getFloat(index, this.E);
                        break;
                    case 31:
                        this.K = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 32:
                        this.L = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 33:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.O) == -2) {
                                this.O = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.Q = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.Q));
                        this.K = 2;
                        break;
                    case 36:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.P) == -2) {
                                this.P = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.R = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.R));
                        this.L = 2;
                        break;
                    default:
                        switch (i3) {
                            case 44:
                                d.h(this, obtainStyledAttributes.getString(index));
                                continue;
                            case 45:
                                this.G = obtainStyledAttributes.getFloat(index, this.G);
                                continue;
                            case 46:
                                this.H = obtainStyledAttributes.getFloat(index, this.H);
                                continue;
                            case 47:
                                this.I = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.J = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.S = obtainStyledAttributes.getDimensionPixelOffset(index, this.S);
                                continue;
                            case 50:
                                this.T = obtainStyledAttributes.getDimensionPixelOffset(index, this.T);
                                continue;
                            case 51:
                                this.X = obtainStyledAttributes.getString(index);
                                continue;
                            case 52:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.m);
                                this.m = resourceId15;
                                if (resourceId15 == -1) {
                                    this.m = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    continue;
                                }
                            case 53:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.n);
                                this.n = resourceId16;
                                if (resourceId16 == -1) {
                                    this.n = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    continue;
                                }
                            case 54:
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                continue;
                            case 55:
                                this.B = obtainStyledAttributes.getDimensionPixelSize(index, this.B);
                                continue;
                            default:
                                switch (i3) {
                                    case 64:
                                        d.g(this, obtainStyledAttributes, index, 0);
                                        continue;
                                        continue;
                                    case 65:
                                        d.g(this, obtainStyledAttributes, index, 1);
                                        continue;
                                    case 66:
                                        this.Y = obtainStyledAttributes.getInt(index, this.Y);
                                        continue;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.f120d = -1;
            this.f121e = -1;
            this.f122f = -1;
            this.f123g = -1;
            this.f124h = -1;
            this.f125i = -1;
            this.f126j = -1;
            this.f127k = -1;
            this.f128l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = 0;
            this.q = 0.0f;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = Integer.MIN_VALUE;
            this.w = Integer.MIN_VALUE;
            this.x = Integer.MIN_VALUE;
            this.y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = 0;
            this.D = 0.5f;
            this.E = 0.5f;
            this.F = null;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 1.0f;
            this.R = 1.0f;
            this.S = -1;
            this.T = -1;
            this.U = -1;
            this.V = false;
            this.W = false;
            this.X = null;
            this.Y = 0;
            this.Z = true;
            this.a0 = true;
            this.b0 = false;
            this.c0 = false;
            this.d0 = false;
            this.e0 = false;
            this.f0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = Integer.MIN_VALUE;
            this.k0 = Integer.MIN_VALUE;
            this.l0 = 0.5f;
            this.p0 = new e.h.a.i.d();
        }

        public void a() {
            this.c0 = false;
            this.Z = true;
            this.a0 = true;
            int i2 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i2 == -2 && this.V) {
                this.Z = false;
                if (this.K == 0) {
                    this.K = 1;
                }
            }
            int i3 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i3 == -2 && this.W) {
                this.a0 = false;
                if (this.L == 0) {
                    this.L = 1;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.Z = false;
                if (i2 == 0 && this.K == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.V = true;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.a0 = false;
                if (i3 == 0 && this.L == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.W = true;
                }
            }
            if (this.c != -1.0f || this.a != -1 || this.b != -1) {
                this.c0 = true;
                this.Z = true;
                this.a0 = true;
                if (!(this.p0 instanceof f)) {
                    this.p0 = new f();
                }
                ((f) this.p0).R(this.U);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:72:0x00d0, code lost:
            if (r1 > 0) goto L_0x00d2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x00d2, code lost:
            ((android.view.ViewGroup.MarginLayoutParams) r10).rightMargin = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x00df, code lost:
            if (r1 > 0) goto L_0x00d2;
         */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x00f1  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void resolveLayoutDirection(int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i9 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i2);
            boolean z = false;
            boolean z2 = 1 == getLayoutDirection();
            this.h0 = -1;
            this.i0 = -1;
            this.f0 = -1;
            this.g0 = -1;
            this.j0 = -1;
            this.k0 = -1;
            this.j0 = this.v;
            this.k0 = this.x;
            float f2 = this.D;
            this.l0 = f2;
            int i10 = this.a;
            this.m0 = i10;
            int i11 = this.b;
            this.n0 = i11;
            float f3 = this.c;
            this.o0 = f3;
            if (z2) {
                int i12 = this.r;
                if (i12 != -1) {
                    this.h0 = i12;
                } else {
                    int i13 = this.s;
                    if (i13 != -1) {
                        this.i0 = i13;
                    }
                    i4 = this.t;
                    if (i4 != -1) {
                        this.g0 = i4;
                        z = true;
                    }
                    i5 = this.u;
                    if (i5 != -1) {
                        this.f0 = i5;
                        z = true;
                    }
                    i6 = this.z;
                    if (i6 != Integer.MIN_VALUE) {
                        this.k0 = i6;
                    }
                    i7 = this.A;
                    if (i7 != Integer.MIN_VALUE) {
                        this.j0 = i7;
                    }
                    if (z) {
                        this.l0 = 1.0f - f2;
                    }
                    if (this.c0 && this.U == 1) {
                        if (f3 == -1.0f) {
                            this.o0 = 1.0f - f3;
                            this.m0 = -1;
                            this.n0 = -1;
                        } else {
                            if (i10 != -1) {
                                this.n0 = i10;
                                this.m0 = -1;
                            } else if (i11 != -1) {
                                this.m0 = i11;
                                this.n0 = -1;
                            }
                            this.o0 = -1.0f;
                        }
                    }
                }
                z = true;
                i4 = this.t;
                if (i4 != -1) {
                }
                i5 = this.u;
                if (i5 != -1) {
                }
                i6 = this.z;
                if (i6 != Integer.MIN_VALUE) {
                }
                i7 = this.A;
                if (i7 != Integer.MIN_VALUE) {
                }
                if (z) {
                }
                if (this.c0) {
                    if (f3 == -1.0f) {
                    }
                }
            } else {
                int i14 = this.r;
                if (i14 != -1) {
                    this.g0 = i14;
                }
                int i15 = this.s;
                if (i15 != -1) {
                    this.f0 = i15;
                }
                int i16 = this.t;
                if (i16 != -1) {
                    this.h0 = i16;
                }
                int i17 = this.u;
                if (i17 != -1) {
                    this.i0 = i17;
                }
                int i18 = this.z;
                if (i18 != Integer.MIN_VALUE) {
                    this.j0 = i18;
                }
                int i19 = this.A;
                if (i19 != Integer.MIN_VALUE) {
                    this.k0 = i19;
                }
            }
            if (this.t == -1 && this.u == -1 && this.s == -1 && this.r == -1) {
                int i20 = this.f122f;
                if (i20 != -1) {
                    this.h0 = i20;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0) {
                    }
                    i3 = this.f120d;
                    if (i3 == -1) {
                        this.f0 = i3;
                        if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                            return;
                        }
                    } else {
                        int i21 = this.f121e;
                        if (i21 != -1) {
                            this.g0 = i21;
                            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
                }
                int i22 = this.f123g;
                if (i22 != -1) {
                    this.i0 = i22;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0) {
                    }
                }
                i3 = this.f120d;
                if (i3 == -1) {
                }
                ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.AbstractC0031b {
        public ConstraintLayout a;
        public int b;
        public int c;

        /* renamed from: d */
        public int f129d;

        /* renamed from: e */
        public int f130e;

        /* renamed from: f */
        public int f131f;

        /* renamed from: g */
        public int f132g;

        public b(ConstraintLayout constraintLayout) {
            ConstraintLayout.this = r1;
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

        /* JADX WARN: Removed duplicated region for block: B:101:0x0147  */
        /* JADX WARN: Removed duplicated region for block: B:122:0x01a6  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x01bb  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x01bd  */
        /* JADX WARN: Removed duplicated region for block: B:129:0x01c0  */
        /* JADX WARN: Removed duplicated region for block: B:130:0x01c2  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x01c7 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:137:0x01cf A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:142:0x01d8  */
        /* JADX WARN: Removed duplicated region for block: B:147:0x01e3  */
        /* JADX WARN: Removed duplicated region for block: B:152:0x01ee A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:153:0x01ef  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x013a  */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public final void b(e.h.a.i.d dVar, b.a aVar) {
            int i2;
            int ordinal;
            int i3;
            e eVar;
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
                if (dVar.h0 == 8 && !dVar.E) {
                    aVar.f1404e = 0;
                    aVar.f1405f = 0;
                    aVar.f1406g = 0;
                } else if (dVar.U != null) {
                    d.a aVar3 = aVar.a;
                    d.a aVar4 = aVar.b;
                    int i13 = aVar.c;
                    int i14 = aVar.f1403d;
                    int i15 = this.b + this.c;
                    int i16 = this.f129d;
                    View view = (View) dVar.g0;
                    int ordinal2 = aVar3.ordinal();
                    if (ordinal2 == 0) {
                        i12 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                    } else if (ordinal2 == 1) {
                        i12 = ViewGroup.getChildMeasureSpec(this.f131f, i16, -2);
                    } else if (ordinal2 != 2) {
                        if (ordinal2 != 3) {
                            i2 = 0;
                        } else {
                            int i17 = this.f131f;
                            e.h.a.i.c cVar = dVar.I;
                            int i18 = cVar != null ? cVar.f1380g + 0 : 0;
                            e.h.a.i.c cVar2 = dVar.K;
                            if (cVar2 != null) {
                                i18 += cVar2.f1380g;
                            }
                            i2 = ViewGroup.getChildMeasureSpec(i17, i16 + i18, -1);
                        }
                        ordinal = aVar4.ordinal();
                        if (ordinal == 0) {
                            if (ordinal == 1) {
                                i10 = -2;
                                i11 = this.f132g;
                            } else if (ordinal == 2) {
                                i9 = ViewGroup.getChildMeasureSpec(this.f132g, i15, -2);
                                boolean z = dVar.r == 1;
                                int i19 = aVar.f1409j;
                                if (i19 == 1 || i19 == 2) {
                                    if (aVar.f1409j == 2 || !z || (z && (view.getMeasuredWidth() == dVar.r())) || (view instanceof g) || dVar.B()) {
                                        i9 = View.MeasureSpec.makeMeasureSpec(dVar.l(), 1073741824);
                                    }
                                }
                            } else if (ordinal != 3) {
                                i3 = 0;
                                eVar = (e) dVar.U;
                                if (eVar != null && i.b(ConstraintLayout.this.f117j, 256) && view.getMeasuredWidth() == dVar.r() && view.getMeasuredWidth() < eVar.r() && view.getMeasuredHeight() == dVar.l() && view.getMeasuredHeight() < eVar.l() && view.getBaseline() == dVar.b0 && !dVar.z()) {
                                    if (!a(dVar.G, i2, dVar.r()) && a(dVar.H, i3, dVar.l())) {
                                        aVar.f1404e = dVar.r();
                                        aVar.f1405f = dVar.l();
                                        aVar.f1406g = dVar.b0;
                                        return;
                                    }
                                }
                                d.a aVar5 = d.a.MATCH_CONSTRAINT;
                                boolean z2 = aVar3 == aVar5;
                                boolean z3 = aVar4 == aVar5;
                                d.a aVar6 = d.a.MATCH_PARENT;
                                boolean z4 = aVar4 != aVar6 || aVar4 == aVar2;
                                boolean z5 = aVar3 != aVar6 || aVar3 == aVar2;
                                boolean z6 = !z2 && dVar.X > 0.0f;
                                boolean z7 = !z3 && dVar.X > 0.0f;
                                if (view != null) {
                                    a aVar7 = (a) view.getLayoutParams();
                                    int i20 = aVar.f1409j;
                                    if (i20 == 1 || i20 == 2 || !z2 || dVar.q != 0 || !z3 || dVar.r != 0) {
                                        if (!(view instanceof e.h.c.i) || !(dVar instanceof j)) {
                                            view.measure(i2, i3);
                                        } else {
                                            j jVar = (j) dVar;
                                            ((e.h.c.i) view).o();
                                        }
                                        dVar.G = i2;
                                        dVar.H = i3;
                                        dVar.f1394g = false;
                                        int measuredWidth = view.getMeasuredWidth();
                                        int measuredHeight = view.getMeasuredHeight();
                                        i6 = view.getBaseline();
                                        int i21 = dVar.t;
                                        i5 = i21 > 0 ? Math.max(i21, measuredWidth) : measuredWidth;
                                        int i22 = dVar.u;
                                        if (i22 > 0) {
                                            i5 = Math.min(i22, i5);
                                        }
                                        int i23 = dVar.w;
                                        if (i23 > 0) {
                                            i4 = Math.max(i23, measuredHeight);
                                            i8 = i2;
                                        } else {
                                            i8 = i2;
                                            i4 = measuredHeight;
                                        }
                                        int i24 = dVar.x;
                                        if (i24 > 0) {
                                            i4 = Math.min(i24, i4);
                                        }
                                        if (!i.b(ConstraintLayout.this.f117j, 1)) {
                                            if (z6 && z4) {
                                                i5 = (int) ((((float) i4) * dVar.X) + 0.5f);
                                            } else if (z7 && z5) {
                                                i4 = (int) ((((float) i5) / dVar.X) + 0.5f);
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
                                            dVar.G = makeMeasureSpec;
                                            dVar.H = i3;
                                            dVar.f1394g = false;
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
                                    aVar.f1408i = (i5 == aVar.c && i4 == aVar.f1403d) ? false : true;
                                    if (aVar7.b0) {
                                        z8 = true;
                                    }
                                    if (!(!z8 || i6 == -1 || dVar.b0 == i6)) {
                                        aVar.f1408i = true;
                                    }
                                    aVar.f1404e = i5;
                                    aVar.f1405f = i4;
                                    aVar.f1407h = z8;
                                    aVar.f1406g = i6;
                                    return;
                                }
                                return;
                            } else {
                                i11 = this.f132g;
                                int i25 = dVar.I != null ? dVar.J.f1380g + 0 : 0;
                                if (dVar.K != null) {
                                    i25 += dVar.L.f1380g;
                                }
                                i15 += i25;
                                i10 = -1;
                            }
                            i9 = ViewGroup.getChildMeasureSpec(i11, i15, i10);
                        } else {
                            i9 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                        }
                        i3 = i9;
                        eVar = (e) dVar.U;
                        if (eVar != null) {
                            if (!a(dVar.G, i2, dVar.r()) && a(dVar.H, i3, dVar.l())) {
                            }
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
                        i12 = ViewGroup.getChildMeasureSpec(this.f131f, i16, -2);
                        boolean z9 = dVar.q == 1;
                        int i26 = aVar.f1409j;
                        if (i26 == 1 || i26 == 2) {
                            if (aVar.f1409j == 2 || !z9 || (z9 && (view.getMeasuredHeight() == dVar.l())) || (view instanceof g) || dVar.A()) {
                                i12 = View.MeasureSpec.makeMeasureSpec(dVar.r(), 1073741824);
                            }
                        }
                    }
                    i2 = i12;
                    ordinal = aVar4.ordinal();
                    if (ordinal == 0) {
                    }
                    i3 = i9;
                    eVar = (e) dVar.U;
                    if (eVar != null) {
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

    public static h getSharedValues() {
        if (u == null) {
            u = new h();
        }
        return u;
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

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public View d(int i2) {
        return this.b.get(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<e.h.c.b> arrayList = this.c;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.c.get(i2).m();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            int childCount = getChildCount();
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

    public final e.h.a.i.d e(View view) {
        if (view == this) {
            return this.f111d;
        }
        if (view == null) {
            return null;
        }
        if (!(view.getLayoutParams() instanceof a)) {
            view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
            if (!(view.getLayoutParams() instanceof a)) {
                return null;
            }
        }
        return ((a) view.getLayoutParams()).p0;
    }

    public final void f(AttributeSet attributeSet, int i2, int i3) {
        e eVar = this.f111d;
        eVar.g0 = this;
        b bVar = this.r;
        eVar.u0 = bVar;
        eVar.s0.f1414f = bVar;
        this.b.put(getId(), this);
        this.f118k = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout, i2, i3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R$styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.f112e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f112e);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.f113f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f113f);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.f114g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f114g);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.f115h = obtainStyledAttributes.getDimensionPixelOffset(index, this.f115h);
                } else if (index == R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f117j = obtainStyledAttributes.getInt(index, this.f117j);
                } else if (index == R$styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            k(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f119l = null;
                        }
                    }
                } else if (index == R$styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        e.h.c.d dVar = new e.h.c.d();
                        this.f118k = dVar;
                        dVar.f(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f118k = null;
                    }
                    this.m = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f111d.b0(this.f117j);
    }

    @Override // android.view.View
    public void forceLayout() {
        this.f116i = true;
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
        return this.f115h;
    }

    public int getMaxWidth() {
        return this.f114g;
    }

    public int getMinHeight() {
        return this.f113f;
    }

    public int getMinWidth() {
        return this.f112e;
    }

    public int getOptimizationLevel() {
        return this.f111d.D0;
    }

    public void k(int i2) {
        this.f119l = new c(getContext(), this, i2);
    }

    public void l(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        b bVar = this.r;
        int i6 = bVar.f130e;
        int resolveSizeAndState = ViewGroup.resolveSizeAndState(i4 + bVar.f129d, i2, 0);
        int min = Math.min(this.f114g, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.f115h, ViewGroup.resolveSizeAndState(i5 + i6, i3, 0) & 16777215);
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

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            a aVar = (a) childAt.getLayoutParams();
            e.h.a.i.d dVar = aVar.p0;
            if ((childAt.getVisibility() != 8 || aVar.c0 || aVar.d0 || isInEditMode) && !aVar.e0) {
                int s = dVar.s();
                int t = dVar.t();
                int r = dVar.r() + s;
                int l2 = dVar.l() + t;
                childAt.layout(s, t, r, l2);
                if ((childAt instanceof g) && (content = ((g) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(s, t, r, l2);
                }
            }
        }
        int size = this.c.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.c.get(i7).k();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0585 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f9 A[ADDED_TO_REGION] */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        d.a aVar;
        d.a aVar2;
        d.a aVar3;
        int i6;
        d.a aVar4;
        int i7;
        int size;
        boolean z;
        boolean z2;
        int i8;
        boolean z3;
        e.h.a.i.l.b bVar;
        int i9;
        int i10;
        b.AbstractC0031b bVar2;
        c.a aVar5;
        c.a aVar6;
        boolean z4;
        int i11;
        boolean z5;
        e.h.a.i.l.b bVar3;
        int size2;
        int i12;
        int i13;
        e eVar;
        int i14;
        b.AbstractC0031b bVar4;
        c.a aVar7;
        c.a aVar8;
        boolean z6;
        int i15;
        e.h.a.i.l.b bVar5;
        k kVar;
        m mVar;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z7;
        boolean z8;
        int i20;
        int i21;
        int i22 = this.s;
        if (!this.f116i) {
            int childCount = getChildCount();
            int i23 = 0;
            while (true) {
                if (i23 >= childCount) {
                    break;
                } else if (getChildAt(i23).isLayoutRequested()) {
                    this.f116i = true;
                    break;
                } else {
                    i23++;
                }
            }
        }
        this.s = i2;
        this.t = i3;
        this.f111d.v0 = g();
        if (this.f116i) {
            this.f116i = false;
            if (r()) {
                e eVar2 = this.f111d;
                eVar2.r0.c(eVar2);
            }
        }
        e eVar3 = this.f111d;
        int i24 = this.f117j;
        d.a aVar9 = d.a.FIXED;
        int mode = View.MeasureSpec.getMode(i2);
        int size3 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size4 = View.MeasureSpec.getSize(i3);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i25 = max + max2;
        int paddingWidth = getPaddingWidth();
        b bVar6 = this.r;
        bVar6.b = max;
        bVar6.c = max2;
        bVar6.f129d = paddingWidth;
        bVar6.f130e = i25;
        bVar6.f131f = i2;
        bVar6.f132g = i3;
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        if (max3 <= 0 && max4 <= 0) {
            max3 = Math.max(0, getPaddingLeft());
        } else if (g()) {
            max3 = max4;
        }
        int i26 = size3 - paddingWidth;
        int i27 = size4 - i25;
        d.a aVar10 = d.a.WRAP_CONTENT;
        b bVar7 = this.r;
        int i28 = bVar7.f130e;
        int i29 = bVar7.f129d;
        int childCount2 = getChildCount();
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode != 1073741824) {
                    aVar = aVar9;
                } else {
                    i4 = Math.min(this.f114g - i29, i26);
                    aVar = aVar9;
                    i5 = Integer.MIN_VALUE;
                    if (mode2 == i5) {
                        if (mode2 != 0) {
                            if (mode2 != 1073741824) {
                                aVar4 = aVar9;
                            } else {
                                i6 = Math.min(this.f115h - i28, i27);
                                aVar3 = aVar9;
                                aVar2 = aVar10;
                                aVar4 = aVar3;
                                if (i4 == eVar3.r() || i6 != eVar3.l()) {
                                    i7 = i27;
                                    eVar3.s0.c = true;
                                } else {
                                    i7 = i27;
                                }
                                eVar3.Z = 0;
                                eVar3.a0 = 0;
                                int[] iArr = eVar3.B;
                                iArr[0] = this.f114g - i29;
                                iArr[1] = this.f115h - i28;
                                eVar3.L(0);
                                eVar3.K(0);
                                eVar3.T[0] = aVar;
                                eVar3.N(i4);
                                eVar3.T[1] = aVar4;
                                eVar3.I(i6);
                                eVar3.L(this.f112e - i29);
                                eVar3.K(this.f113f - i28);
                                eVar3.x0 = max3;
                                eVar3.y0 = max;
                                e.h.a.i.l.b bVar8 = eVar3.r0;
                                Objects.requireNonNull(bVar8);
                                c.a aVar11 = c.a.BOTTOM;
                                c.a aVar12 = c.a.RIGHT;
                                d.a aVar13 = d.a.MATCH_CONSTRAINT;
                                b.AbstractC0031b bVar9 = eVar3.u0;
                                size = eVar3.q0.size();
                                int r = eVar3.r();
                                int l2 = eVar3.l();
                                boolean b2 = i.b(i24, 128);
                                z = !b2 || i.b(i24, 64);
                                if (z) {
                                    int i30 = 0;
                                    while (i30 < size) {
                                        e.h.a.i.d dVar = eVar3.q0.get(i30);
                                        boolean z9 = (dVar.m() == aVar13) && (dVar.q() == aVar13) && dVar.X > 0.0f;
                                        if ((dVar.x() && z9) || ((dVar.y() && z9) || (dVar instanceof j) || dVar.x() || dVar.y())) {
                                            i8 = 1073741824;
                                            z2 = false;
                                            break;
                                        }
                                        i30++;
                                        z = z;
                                    }
                                }
                                z2 = z;
                                i8 = 1073741824;
                                z3 = z2 & ((mode != i8 && mode2 == i8) || b2);
                                if (z3) {
                                    int min = Math.min(eVar3.B[0], i26);
                                    int min2 = Math.min(eVar3.B[1], i7);
                                    if (mode == 1073741824 && eVar3.r() != min) {
                                        eVar3.N(min);
                                        eVar3.Y();
                                    }
                                    if (mode2 == 1073741824 && eVar3.l() != min2) {
                                        eVar3.I(min2);
                                        eVar3.Y();
                                    }
                                    if (mode == 1073741824 && mode2 == 1073741824) {
                                        e.h.a.i.l.e eVar4 = eVar3.s0;
                                        d.a aVar14 = d.a.MATCH_PARENT;
                                        boolean z10 = b2 & true;
                                        if (eVar4.b || eVar4.c) {
                                            for (Iterator<e.h.a.i.d> it = eVar4.a.q0.iterator(); it.hasNext(); it = it) {
                                                e.h.a.i.d next = it.next();
                                                next.h();
                                                next.a = false;
                                                next.f1391d.n();
                                                next.f1392e.m();
                                                z3 = z3;
                                            }
                                            z4 = z3;
                                            eVar4.a.h();
                                            e eVar5 = eVar4.a;
                                            i19 = 0;
                                            eVar5.a = false;
                                            eVar5.f1391d.n();
                                            eVar4.a.f1392e.m();
                                            eVar4.c = false;
                                        } else {
                                            z4 = z3;
                                            i19 = 0;
                                        }
                                        eVar4.b(eVar4.f1412d);
                                        e eVar6 = eVar4.a;
                                        eVar6.Z = i19;
                                        eVar6.a0 = i19;
                                        d.a k2 = eVar6.k(i19);
                                        aVar6 = aVar11;
                                        d.a k3 = eVar4.a.k(1);
                                        if (eVar4.b) {
                                            eVar4.c();
                                        }
                                        int s = eVar4.a.s();
                                        aVar5 = aVar12;
                                        int t = eVar4.a.t();
                                        bVar2 = bVar9;
                                        eVar4.a.f1391d.f1443h.c(s);
                                        eVar4.a.f1392e.f1443h.c(t);
                                        eVar4.g();
                                        if (k2 == aVar2 || k3 == aVar2) {
                                            boolean z11 = z10;
                                            if (z10) {
                                                Iterator<o> it2 = eVar4.f1413e.iterator();
                                                while (true) {
                                                    if (it2.hasNext()) {
                                                        if (!it2.next().k()) {
                                                            z11 = false;
                                                            break;
                                                        }
                                                    } else {
                                                        break;
                                                    }
                                                }
                                            }
                                            if (!z11 || k2 != aVar2) {
                                                i10 = r;
                                                i9 = l2;
                                            } else {
                                                e eVar7 = eVar4.a;
                                                i10 = r;
                                                i9 = l2;
                                                eVar7.T[0] = aVar3;
                                                eVar7.N(eVar4.d(eVar7, 0));
                                                e eVar8 = eVar4.a;
                                                eVar8.f1391d.f1440e.c(eVar8.r());
                                            }
                                            if (z11 && k3 == aVar2) {
                                                e eVar9 = eVar4.a;
                                                eVar9.T[1] = aVar3;
                                                eVar9.I(eVar4.d(eVar9, 1));
                                                e eVar10 = eVar4.a;
                                                eVar10.f1392e.f1440e.c(eVar10.l());
                                            }
                                        } else {
                                            i10 = r;
                                            i9 = l2;
                                        }
                                        e eVar11 = eVar4.a;
                                        d.a[] aVarArr = eVar11.T;
                                        aVar2 = aVar2;
                                        bVar = bVar8;
                                        if (aVarArr[0] == aVar3 || aVarArr[0] == aVar14) {
                                            int r2 = eVar11.r() + s;
                                            eVar4.a.f1391d.f1444i.c(r2);
                                            eVar4.a.f1391d.f1440e.c(r2 - s);
                                            eVar4.g();
                                            e eVar12 = eVar4.a;
                                            d.a[] aVarArr2 = eVar12.T;
                                            if (aVarArr2[1] == aVar3 || aVarArr2[1] == aVar14) {
                                                int l3 = eVar12.l() + t;
                                                eVar4.a.f1392e.f1444i.c(l3);
                                                eVar4.a.f1392e.f1440e.c(l3 - t);
                                            }
                                            eVar4.g();
                                            z7 = true;
                                        } else {
                                            z7 = false;
                                        }
                                        Iterator<o> it3 = eVar4.f1413e.iterator();
                                        while (it3.hasNext()) {
                                            o next2 = it3.next();
                                            if (next2.b != eVar4.a || next2.f1442g) {
                                                next2.e();
                                            }
                                        }
                                        Iterator<o> it4 = eVar4.f1413e.iterator();
                                        while (it4.hasNext()) {
                                            o next3 = it4.next();
                                            if (z7 || next3.b != eVar4.a) {
                                                if (!next3.f1443h.f1423j || ((!next3.f1444i.f1423j && !(next3 instanceof e.h.a.i.l.i)) || (!next3.f1440e.f1423j && !(next3 instanceof e.h.a.i.l.c) && !(next3 instanceof e.h.a.i.l.i)))) {
                                                    z8 = false;
                                                    break;
                                                }
                                            }
                                        }
                                        z8 = true;
                                        eVar4.a.J(k2);
                                        eVar4.a.M(k3);
                                        z5 = z8;
                                        i16 = 1073741824;
                                        i11 = 2;
                                    } else {
                                        bVar = bVar8;
                                        aVar6 = aVar11;
                                        aVar5 = aVar12;
                                        z4 = z3;
                                        bVar2 = bVar9;
                                        i10 = r;
                                        i9 = l2;
                                        e.h.a.i.l.e eVar13 = eVar3.s0;
                                        if (eVar13.b) {
                                            Iterator<e.h.a.i.d> it5 = eVar13.a.q0.iterator();
                                            while (it5.hasNext()) {
                                                e.h.a.i.d next4 = it5.next();
                                                next4.h();
                                                next4.a = false;
                                                k kVar2 = next4.f1391d;
                                                kVar2.f1440e.f1423j = false;
                                                kVar2.f1442g = false;
                                                kVar2.n();
                                                m mVar2 = next4.f1392e;
                                                mVar2.f1440e.f1423j = false;
                                                mVar2.f1442g = false;
                                                mVar2.m();
                                            }
                                            i17 = 0;
                                            eVar13.a.h();
                                            e eVar14 = eVar13.a;
                                            eVar14.a = false;
                                            k kVar3 = eVar14.f1391d;
                                            kVar3.f1440e.f1423j = false;
                                            kVar3.f1442g = false;
                                            kVar3.n();
                                            m mVar3 = eVar13.a.f1392e;
                                            mVar3.f1440e.f1423j = false;
                                            mVar3.f1442g = false;
                                            mVar3.m();
                                            eVar13.c();
                                        } else {
                                            i17 = 0;
                                        }
                                        eVar13.b(eVar13.f1412d);
                                        e eVar15 = eVar13.a;
                                        eVar15.Z = i17;
                                        eVar15.a0 = i17;
                                        eVar15.f1391d.f1443h.c(i17);
                                        eVar13.a.f1392e.f1443h.c(i17);
                                        i16 = 1073741824;
                                        if (mode == 1073741824) {
                                            i18 = 1;
                                            z5 = eVar3.X(b2, i17) & true;
                                            i11 = 1;
                                        } else {
                                            i18 = 1;
                                            z5 = true;
                                            i11 = 0;
                                        }
                                        if (mode2 == 1073741824) {
                                            z5 &= eVar3.X(b2, i18);
                                            i11++;
                                        }
                                    }
                                    if (z5) {
                                        eVar3.O(mode == i16, mode2 == i16);
                                    }
                                } else {
                                    bVar = bVar8;
                                    aVar6 = aVar11;
                                    aVar5 = aVar12;
                                    z4 = z3;
                                    bVar2 = bVar9;
                                    i10 = r;
                                    i9 = l2;
                                    z5 = false;
                                    i11 = 0;
                                }
                                if (z5 || i11 != 2) {
                                    int i31 = eVar3.D0;
                                    if (size > 0) {
                                        int size5 = eVar3.q0.size();
                                        boolean a0 = eVar3.a0(64);
                                        b.AbstractC0031b bVar10 = eVar3.u0;
                                        int i32 = 0;
                                        while (i32 < size5) {
                                            e.h.a.i.d dVar2 = eVar3.q0.get(i32);
                                            if (!(dVar2 instanceof f) && !(dVar2 instanceof e.h.a.i.a) && !dVar2.F && (!a0 || (kVar = dVar2.f1391d) == null || (mVar = dVar2.f1392e) == null || !kVar.f1440e.f1423j || !mVar.f1440e.f1423j)) {
                                                d.a k4 = dVar2.k(0);
                                                d.a k5 = dVar2.k(1);
                                                boolean z12 = k4 == aVar13 && dVar2.q != 1 && k5 == aVar13 && dVar2.r != 1;
                                                if (!z12 && eVar3.a0(1) && !(dVar2 instanceof j)) {
                                                    if (k4 == aVar13 && dVar2.q == 0 && k5 != aVar13 && !dVar2.x()) {
                                                        z12 = true;
                                                    }
                                                    if (k5 == aVar13 && dVar2.r == 0 && k4 != aVar13 && !dVar2.x()) {
                                                        z12 = true;
                                                    }
                                                    if (k4 == aVar13 || k5 == aVar13) {
                                                        if (dVar2.X > 0.0f) {
                                                            z12 = true;
                                                        }
                                                        bVar5 = bVar;
                                                        if (z12) {
                                                            bVar5.a(bVar10, dVar2, 0);
                                                        }
                                                    }
                                                }
                                                bVar5 = bVar;
                                                if (z12) {
                                                }
                                            } else {
                                                bVar5 = bVar;
                                            }
                                            i32++;
                                            bVar = bVar5;
                                        }
                                        bVar3 = bVar;
                                        b bVar11 = (b) bVar10;
                                        int childCount3 = bVar11.a.getChildCount();
                                        for (int i33 = 0; i33 < childCount3; i33++) {
                                            View childAt = bVar11.a.getChildAt(i33);
                                            if (childAt instanceof g) {
                                                ((g) childAt).a();
                                            }
                                        }
                                        int size6 = bVar11.a.c.size();
                                        if (size6 > 0) {
                                            for (int i34 = 0; i34 < size6; i34++) {
                                                bVar11.a.c.get(i34).l();
                                            }
                                        }
                                    } else {
                                        bVar3 = bVar;
                                    }
                                    bVar3.c(eVar3);
                                    size2 = bVar3.a.size();
                                    int i35 = i10;
                                    int i36 = i9;
                                    if (size > 0) {
                                        bVar3.b(eVar3, 0, i35, i36);
                                    }
                                    if (size2 > 0) {
                                        boolean z13 = eVar3.m() == aVar2;
                                        boolean z14 = eVar3.q() == aVar2;
                                        int max5 = Math.max(eVar3.r(), bVar3.c.c0);
                                        int max6 = Math.max(eVar3.l(), bVar3.c.d0);
                                        int i37 = max5;
                                        int i38 = 0;
                                        boolean z15 = false;
                                        while (i38 < size2) {
                                            e.h.a.i.d dVar3 = bVar3.a.get(i38);
                                            if (!(dVar3 instanceof j)) {
                                                i14 = i31;
                                                aVar7 = aVar6;
                                                aVar8 = aVar5;
                                                bVar4 = bVar2;
                                            } else {
                                                int r3 = dVar3.r();
                                                int l4 = dVar3.l();
                                                i14 = i31;
                                                bVar4 = bVar2;
                                                boolean a2 = z15 | bVar3.a(bVar4, dVar3, 1);
                                                int r4 = dVar3.r();
                                                int l5 = dVar3.l();
                                                if (r4 != r3) {
                                                    dVar3.N(r4);
                                                    if (!z13 || dVar3.p() <= i37) {
                                                        aVar8 = aVar5;
                                                    } else {
                                                        aVar8 = aVar5;
                                                        i37 = Math.max(i37, dVar3.i(aVar8).d() + dVar3.p());
                                                    }
                                                    a2 = true;
                                                } else {
                                                    aVar8 = aVar5;
                                                }
                                                if (l5 != l4) {
                                                    dVar3.I(l5);
                                                    if (!z14 || dVar3.j() <= max6) {
                                                        aVar7 = aVar6;
                                                    } else {
                                                        aVar7 = aVar6;
                                                        max6 = Math.max(max6, dVar3.i(aVar7).d() + dVar3.j());
                                                    }
                                                    i15 = max6;
                                                    z6 = true;
                                                } else {
                                                    aVar7 = aVar6;
                                                    i15 = max6;
                                                    z6 = a2;
                                                }
                                                j jVar = (j) dVar3;
                                                z15 = z6 | false;
                                                max6 = i15;
                                            }
                                            i38++;
                                            aVar5 = aVar8;
                                            aVar6 = aVar7;
                                            bVar2 = bVar4;
                                            i31 = i14;
                                        }
                                        int i39 = 0;
                                        int i40 = 2;
                                        while (true) {
                                            if (i39 >= i40) {
                                                break;
                                            }
                                            int i41 = max6;
                                            boolean z16 = z15;
                                            int i42 = 0;
                                            while (i42 < size2) {
                                                e.h.a.i.d dVar4 = bVar3.a.get(i42);
                                                if ((!(dVar4 instanceof e.h.a.i.g) || (dVar4 instanceof j)) && !(dVar4 instanceof f)) {
                                                    eVar = eVar3;
                                                    if (dVar4.h0 != 8 && ((!z4 || !dVar4.f1391d.f1440e.f1423j || !dVar4.f1392e.f1440e.f1423j) && !(dVar4 instanceof j))) {
                                                        int r5 = dVar4.r();
                                                        int l6 = dVar4.l();
                                                        i13 = i35;
                                                        int i43 = dVar4.b0;
                                                        i12 = i36;
                                                        int i44 = 1;
                                                        if (i39 == 1) {
                                                            i44 = 2;
                                                        }
                                                        boolean a3 = z16 | bVar3.a(bVar2, dVar4, i44);
                                                        int r6 = dVar4.r();
                                                        int l7 = dVar4.l();
                                                        if (r6 != r5) {
                                                            dVar4.N(r6);
                                                            if (z13 && dVar4.p() > i37) {
                                                                i37 = Math.max(i37, dVar4.i(aVar5).d() + dVar4.p());
                                                            }
                                                            a3 = true;
                                                        }
                                                        if (l7 != l6) {
                                                            dVar4.I(l7);
                                                            if (z14 && dVar4.j() > i41) {
                                                                i41 = Math.max(i41, dVar4.i(aVar6).d() + dVar4.j());
                                                            }
                                                            z16 = true;
                                                        } else {
                                                            z16 = a3;
                                                        }
                                                        if (dVar4.D && i43 != dVar4.b0) {
                                                            z16 = true;
                                                        }
                                                        i42++;
                                                        size2 = size2;
                                                        eVar3 = eVar;
                                                        i35 = i13;
                                                        i36 = i12;
                                                    }
                                                } else {
                                                    eVar = eVar3;
                                                }
                                                i13 = i35;
                                                i12 = i36;
                                                i42++;
                                                size2 = size2;
                                                eVar3 = eVar;
                                                i35 = i13;
                                                i36 = i12;
                                            }
                                            if (!z16) {
                                                eVar3 = eVar3;
                                                break;
                                            }
                                            i39++;
                                            eVar3 = eVar3;
                                            bVar3.b(eVar3, i39, i35, i36);
                                            i36 = i36;
                                            max6 = i41;
                                            i40 = 2;
                                            z15 = false;
                                            i35 = i35;
                                            size2 = size2;
                                        }
                                        i31 = i31;
                                    }
                                    eVar3.b0(i31);
                                }
                                int r7 = this.f111d.r();
                                int l8 = this.f111d.l();
                                e eVar16 = this.f111d;
                                l(i2, i3, r7, l8, eVar16.E0, eVar16.F0);
                            }
                        } else if (childCount2 != 0) {
                            aVar4 = aVar10;
                        }
                        aVar3 = aVar9;
                        aVar2 = aVar10;
                        i6 = 0;
                        if (i4 == eVar3.r()) {
                        }
                        i7 = i27;
                        eVar3.s0.c = true;
                        eVar3.Z = 0;
                        eVar3.a0 = 0;
                        int[] iArr2 = eVar3.B;
                        iArr2[0] = this.f114g - i29;
                        iArr2[1] = this.f115h - i28;
                        eVar3.L(0);
                        eVar3.K(0);
                        eVar3.T[0] = aVar;
                        eVar3.N(i4);
                        eVar3.T[1] = aVar4;
                        eVar3.I(i6);
                        eVar3.L(this.f112e - i29);
                        eVar3.K(this.f113f - i28);
                        eVar3.x0 = max3;
                        eVar3.y0 = max;
                        e.h.a.i.l.b bVar82 = eVar3.r0;
                        Objects.requireNonNull(bVar82);
                        c.a aVar112 = c.a.BOTTOM;
                        c.a aVar122 = c.a.RIGHT;
                        d.a aVar132 = d.a.MATCH_CONSTRAINT;
                        b.AbstractC0031b bVar92 = eVar3.u0;
                        size = eVar3.q0.size();
                        int r8 = eVar3.r();
                        int l22 = eVar3.l();
                        boolean b22 = i.b(i24, 128);
                        if (!b22) {
                        }
                        if (z) {
                        }
                        z2 = z;
                        i8 = 1073741824;
                        z3 = z2 & ((mode != i8 && mode2 == i8) || b22);
                        if (z3) {
                        }
                        if (z5) {
                        }
                        int i312 = eVar3.D0;
                        if (size > 0) {
                        }
                        bVar3.c(eVar3);
                        size2 = bVar3.a.size();
                        int i352 = i10;
                        int i362 = i9;
                        if (size > 0) {
                        }
                        if (size2 > 0) {
                        }
                        eVar3.b0(i312);
                        int r72 = this.f111d.r();
                        int l82 = this.f111d.l();
                        e eVar162 = this.f111d;
                        l(i2, i3, r72, l82, eVar162.E0, eVar162.F0);
                    } else if (childCount2 != 0) {
                        aVar3 = aVar9;
                        i20 = i27;
                        i6 = i20;
                        aVar4 = aVar10;
                        aVar2 = aVar4;
                        if (i4 == eVar3.r()) {
                        }
                        i7 = i27;
                        eVar3.s0.c = true;
                        eVar3.Z = 0;
                        eVar3.a0 = 0;
                        int[] iArr22 = eVar3.B;
                        iArr22[0] = this.f114g - i29;
                        iArr22[1] = this.f115h - i28;
                        eVar3.L(0);
                        eVar3.K(0);
                        eVar3.T[0] = aVar;
                        eVar3.N(i4);
                        eVar3.T[1] = aVar4;
                        eVar3.I(i6);
                        eVar3.L(this.f112e - i29);
                        eVar3.K(this.f113f - i28);
                        eVar3.x0 = max3;
                        eVar3.y0 = max;
                        e.h.a.i.l.b bVar822 = eVar3.r0;
                        Objects.requireNonNull(bVar822);
                        c.a aVar1122 = c.a.BOTTOM;
                        c.a aVar1222 = c.a.RIGHT;
                        d.a aVar1322 = d.a.MATCH_CONSTRAINT;
                        b.AbstractC0031b bVar922 = eVar3.u0;
                        size = eVar3.q0.size();
                        int r82 = eVar3.r();
                        int l222 = eVar3.l();
                        boolean b222 = i.b(i24, 128);
                        if (!b222) {
                        }
                        if (z) {
                        }
                        z2 = z;
                        i8 = 1073741824;
                        z3 = z2 & ((mode != i8 && mode2 == i8) || b222);
                        if (z3) {
                        }
                        if (z5) {
                        }
                        int i3122 = eVar3.D0;
                        if (size > 0) {
                        }
                        bVar3.c(eVar3);
                        size2 = bVar3.a.size();
                        int i3522 = i10;
                        int i3622 = i9;
                        if (size > 0) {
                        }
                        if (size2 > 0) {
                        }
                        eVar3.b0(i3122);
                        int r722 = this.f111d.r();
                        int l822 = this.f111d.l();
                        e eVar1622 = this.f111d;
                        l(i2, i3, r722, l822, eVar1622.E0, eVar1622.F0);
                    }
                    aVar3 = aVar9;
                    i20 = Math.max(0, this.f113f);
                    i6 = i20;
                    aVar4 = aVar10;
                    aVar2 = aVar4;
                    if (i4 == eVar3.r()) {
                    }
                    i7 = i27;
                    eVar3.s0.c = true;
                    eVar3.Z = 0;
                    eVar3.a0 = 0;
                    int[] iArr222 = eVar3.B;
                    iArr222[0] = this.f114g - i29;
                    iArr222[1] = this.f115h - i28;
                    eVar3.L(0);
                    eVar3.K(0);
                    eVar3.T[0] = aVar;
                    eVar3.N(i4);
                    eVar3.T[1] = aVar4;
                    eVar3.I(i6);
                    eVar3.L(this.f112e - i29);
                    eVar3.K(this.f113f - i28);
                    eVar3.x0 = max3;
                    eVar3.y0 = max;
                    e.h.a.i.l.b bVar8222 = eVar3.r0;
                    Objects.requireNonNull(bVar8222);
                    c.a aVar11222 = c.a.BOTTOM;
                    c.a aVar12222 = c.a.RIGHT;
                    d.a aVar13222 = d.a.MATCH_CONSTRAINT;
                    b.AbstractC0031b bVar9222 = eVar3.u0;
                    size = eVar3.q0.size();
                    int r822 = eVar3.r();
                    int l2222 = eVar3.l();
                    boolean b2222 = i.b(i24, 128);
                    if (!b2222) {
                    }
                    if (z) {
                    }
                    z2 = z;
                    i8 = 1073741824;
                    z3 = z2 & ((mode != i8 && mode2 == i8) || b2222);
                    if (z3) {
                    }
                    if (z5) {
                    }
                    int i31222 = eVar3.D0;
                    if (size > 0) {
                    }
                    bVar3.c(eVar3);
                    size2 = bVar3.a.size();
                    int i35222 = i10;
                    int i36222 = i9;
                    if (size > 0) {
                    }
                    if (size2 > 0) {
                    }
                    eVar3.b0(i31222);
                    int r7222 = this.f111d.r();
                    int l8222 = this.f111d.l();
                    e eVar16222 = this.f111d;
                    l(i2, i3, r7222, l8222, eVar16222.E0, eVar16222.F0);
                }
            } else if (childCount2 != 0) {
                aVar = aVar10;
            }
            i5 = Integer.MIN_VALUE;
            i4 = 0;
            if (mode2 == i5) {
            }
            aVar3 = aVar9;
            i20 = Math.max(0, this.f113f);
            i6 = i20;
            aVar4 = aVar10;
            aVar2 = aVar4;
            if (i4 == eVar3.r()) {
            }
            i7 = i27;
            eVar3.s0.c = true;
            eVar3.Z = 0;
            eVar3.a0 = 0;
            int[] iArr2222 = eVar3.B;
            iArr2222[0] = this.f114g - i29;
            iArr2222[1] = this.f115h - i28;
            eVar3.L(0);
            eVar3.K(0);
            eVar3.T[0] = aVar;
            eVar3.N(i4);
            eVar3.T[1] = aVar4;
            eVar3.I(i6);
            eVar3.L(this.f112e - i29);
            eVar3.K(this.f113f - i28);
            eVar3.x0 = max3;
            eVar3.y0 = max;
            e.h.a.i.l.b bVar82222 = eVar3.r0;
            Objects.requireNonNull(bVar82222);
            c.a aVar112222 = c.a.BOTTOM;
            c.a aVar122222 = c.a.RIGHT;
            d.a aVar132222 = d.a.MATCH_CONSTRAINT;
            b.AbstractC0031b bVar92222 = eVar3.u0;
            size = eVar3.q0.size();
            int r8222 = eVar3.r();
            int l22222 = eVar3.l();
            boolean b22222 = i.b(i24, 128);
            if (!b22222) {
            }
            if (z) {
            }
            z2 = z;
            i8 = 1073741824;
            z3 = z2 & ((mode != i8 && mode2 == i8) || b22222);
            if (z3) {
            }
            if (z5) {
            }
            int i312222 = eVar3.D0;
            if (size > 0) {
            }
            bVar3.c(eVar3);
            size2 = bVar3.a.size();
            int i352222 = i10;
            int i362222 = i9;
            if (size > 0) {
            }
            if (size2 > 0) {
            }
            eVar3.b0(i312222);
            int r72222 = this.f111d.r();
            int l82222 = this.f111d.l();
            e eVar162222 = this.f111d;
            l(i2, i3, r72222, l82222, eVar162222.E0, eVar162222.F0);
        } else if (childCount2 != 0) {
            i21 = i26;
            i4 = i21;
            aVar = aVar10;
            i5 = Integer.MIN_VALUE;
            if (mode2 == i5) {
            }
            aVar3 = aVar9;
            i20 = Math.max(0, this.f113f);
            i6 = i20;
            aVar4 = aVar10;
            aVar2 = aVar4;
            if (i4 == eVar3.r()) {
            }
            i7 = i27;
            eVar3.s0.c = true;
            eVar3.Z = 0;
            eVar3.a0 = 0;
            int[] iArr22222 = eVar3.B;
            iArr22222[0] = this.f114g - i29;
            iArr22222[1] = this.f115h - i28;
            eVar3.L(0);
            eVar3.K(0);
            eVar3.T[0] = aVar;
            eVar3.N(i4);
            eVar3.T[1] = aVar4;
            eVar3.I(i6);
            eVar3.L(this.f112e - i29);
            eVar3.K(this.f113f - i28);
            eVar3.x0 = max3;
            eVar3.y0 = max;
            e.h.a.i.l.b bVar822222 = eVar3.r0;
            Objects.requireNonNull(bVar822222);
            c.a aVar1122222 = c.a.BOTTOM;
            c.a aVar1222222 = c.a.RIGHT;
            d.a aVar1322222 = d.a.MATCH_CONSTRAINT;
            b.AbstractC0031b bVar922222 = eVar3.u0;
            size = eVar3.q0.size();
            int r82222 = eVar3.r();
            int l222222 = eVar3.l();
            boolean b222222 = i.b(i24, 128);
            if (!b222222) {
            }
            if (z) {
            }
            z2 = z;
            i8 = 1073741824;
            z3 = z2 & ((mode != i8 && mode2 == i8) || b222222);
            if (z3) {
            }
            if (z5) {
            }
            int i3122222 = eVar3.D0;
            if (size > 0) {
            }
            bVar3.c(eVar3);
            size2 = bVar3.a.size();
            int i3522222 = i10;
            int i3622222 = i9;
            if (size > 0) {
            }
            if (size2 > 0) {
            }
            eVar3.b0(i3122222);
            int r722222 = this.f111d.r();
            int l822222 = this.f111d.l();
            e eVar1622222 = this.f111d;
            l(i2, i3, r722222, l822222, eVar1622222.E0, eVar1622222.F0);
        }
        i21 = Math.max(0, this.f112e);
        i4 = i21;
        aVar = aVar10;
        i5 = Integer.MIN_VALUE;
        if (mode2 == i5) {
        }
        aVar3 = aVar9;
        i20 = Math.max(0, this.f113f);
        i6 = i20;
        aVar4 = aVar10;
        aVar2 = aVar4;
        if (i4 == eVar3.r()) {
        }
        i7 = i27;
        eVar3.s0.c = true;
        eVar3.Z = 0;
        eVar3.a0 = 0;
        int[] iArr222222 = eVar3.B;
        iArr222222[0] = this.f114g - i29;
        iArr222222[1] = this.f115h - i28;
        eVar3.L(0);
        eVar3.K(0);
        eVar3.T[0] = aVar;
        eVar3.N(i4);
        eVar3.T[1] = aVar4;
        eVar3.I(i6);
        eVar3.L(this.f112e - i29);
        eVar3.K(this.f113f - i28);
        eVar3.x0 = max3;
        eVar3.y0 = max;
        e.h.a.i.l.b bVar8222222 = eVar3.r0;
        Objects.requireNonNull(bVar8222222);
        c.a aVar11222222 = c.a.BOTTOM;
        c.a aVar12222222 = c.a.RIGHT;
        d.a aVar13222222 = d.a.MATCH_CONSTRAINT;
        b.AbstractC0031b bVar9222222 = eVar3.u0;
        size = eVar3.q0.size();
        int r822222 = eVar3.r();
        int l2222222 = eVar3.l();
        boolean b2222222 = i.b(i24, 128);
        if (!b2222222) {
        }
        if (z) {
        }
        z2 = z;
        i8 = 1073741824;
        z3 = z2 & ((mode != i8 && mode2 == i8) || b2222222);
        if (z3) {
        }
        if (z5) {
        }
        int i31222222 = eVar3.D0;
        if (size > 0) {
        }
        bVar3.c(eVar3);
        size2 = bVar3.a.size();
        int i35222222 = i10;
        int i36222222 = i9;
        if (size > 0) {
        }
        if (size2 > 0) {
        }
        eVar3.b0(i31222222);
        int r7222222 = this.f111d.r();
        int l8222222 = this.f111d.l();
        e eVar16222222 = this.f111d;
        l(i2, i3, r7222222, l8222222, eVar16222222.E0, eVar16222222.F0);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        e.h.a.i.d e2 = e(view);
        if ((view instanceof Guideline) && !(e2 instanceof f)) {
            a aVar = (a) view.getLayoutParams();
            f fVar = new f();
            aVar.p0 = fVar;
            aVar.c0 = true;
            fVar.R(aVar.U);
        }
        if (view instanceof e.h.c.b) {
            e.h.c.b bVar = (e.h.c.b) view;
            bVar.n();
            ((a) view.getLayoutParams()).d0 = true;
            if (!this.c.contains(bVar)) {
                this.c.add(bVar);
            }
        }
        this.b.put(view.getId(), view);
        this.f116i = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.b.remove(view.getId());
        e.h.a.i.d e2 = e(view);
        this.f111d.q0.remove(e2);
        e2.C();
        this.c.remove(view);
        this.f116i = true;
    }

    public void p(int i2, Object obj, Object obj2) {
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

    public final void q(e.h.a.i.d dVar, a aVar, SparseArray<e.h.a.i.d> sparseArray, int i2, c.a aVar2) {
        View view = this.b.get(i2);
        e.h.a.i.d dVar2 = sparseArray.get(i2);
        if (dVar2 != null && view != null && (view.getLayoutParams() instanceof a)) {
            aVar.b0 = true;
            c.a aVar3 = c.a.BASELINE;
            if (aVar2 == aVar3) {
                a aVar4 = (a) view.getLayoutParams();
                aVar4.b0 = true;
                aVar4.p0.D = true;
            }
            dVar.i(aVar3).a(dVar2.i(aVar2), aVar.C, aVar.B, true);
            dVar.D = true;
            dVar.i(c.a.TOP).h();
            dVar.i(c.a.BOTTOM).h();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03b8  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final boolean r() {
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        boolean z4;
        int i3;
        c.a aVar;
        c.a aVar2;
        c.a aVar3;
        c.a aVar4;
        int i4;
        int i5;
        float f2;
        int i6;
        int i7;
        int i8;
        int i9;
        float f3;
        c.a aVar5;
        int i10;
        e.h.a.i.d dVar;
        int i11;
        int i12;
        e.h.a.i.c i13;
        e.h.a.i.c i14;
        e.h.a.i.c cVar;
        int i15;
        int i16;
        e.h.a.i.c cVar2;
        e.h.a.i.d dVar2;
        e.h.a.i.c cVar3;
        int i17;
        e.h.a.i.c cVar4;
        e.h.a.i.d dVar3;
        e.h.a.i.c cVar5;
        int i18;
        e.h.a.i.c cVar6;
        e.h.a.i.d dVar4;
        String str;
        int h2;
        String resourceName;
        int id;
        e.h.a.i.d dVar5;
        ConstraintLayout constraintLayout = this;
        int childCount = getChildCount();
        int i19 = 0;
        int i20 = 0;
        while (true) {
            z = true;
            if (i20 >= childCount) {
                z2 = false;
                break;
            } else if (constraintLayout.getChildAt(i20).isLayoutRequested()) {
                z2 = true;
                break;
            } else {
                i20++;
            }
        }
        if (z2) {
            boolean isInEditMode = isInEditMode();
            int childCount2 = getChildCount();
            for (int i21 = 0; i21 < childCount2; i21++) {
                e.h.a.i.d e2 = constraintLayout.e(constraintLayout.getChildAt(i21));
                if (e2 != null) {
                    e2.C();
                }
            }
            Object obj = null;
            int i22 = -1;
            if (isInEditMode) {
                for (int i23 = 0; i23 < childCount2; i23++) {
                    View childAt = constraintLayout.getChildAt(i23);
                    try {
                        resourceName = getResources().getResourceName(childAt.getId());
                        constraintLayout.p(0, resourceName, Integer.valueOf(childAt.getId()));
                        int indexOf = resourceName.indexOf(47);
                        if (indexOf != -1) {
                            resourceName = resourceName.substring(indexOf + 1);
                        }
                        id = childAt.getId();
                    } catch (Resources.NotFoundException unused) {
                    }
                    if (id != 0) {
                        View view = constraintLayout.b.get(id);
                        if (view == null && (view = constraintLayout.findViewById(id)) != null && view != constraintLayout && view.getParent() == constraintLayout) {
                            constraintLayout.onViewAdded(view);
                        }
                        if (view != constraintLayout) {
                            dVar5 = view == null ? null : ((a) view.getLayoutParams()).p0;
                            dVar5.i0 = resourceName;
                        }
                    }
                    dVar5 = constraintLayout.f111d;
                    dVar5.i0 = resourceName;
                }
            }
            if (constraintLayout.m != -1) {
                for (int i24 = 0; i24 < childCount2; i24++) {
                    View childAt2 = constraintLayout.getChildAt(i24);
                    if (childAt2.getId() == constraintLayout.m && (childAt2 instanceof e.h.c.e)) {
                        constraintLayout.f118k = ((e.h.c.e) childAt2).getConstraintSet();
                    }
                }
            }
            e.h.c.d dVar6 = constraintLayout.f118k;
            if (dVar6 != null) {
                dVar6.b(constraintLayout, true);
            }
            constraintLayout.f111d.q0.clear();
            int size = constraintLayout.c.size();
            if (size > 0) {
                int i25 = 0;
                while (i25 < size) {
                    e.h.c.b bVar = constraintLayout.c.get(i25);
                    if (bVar.isInEditMode()) {
                        bVar.setIds(bVar.f1471f);
                    }
                    e.h.a.i.g gVar = bVar.f1470e;
                    if (gVar != null) {
                        e.h.a.i.h hVar = (e.h.a.i.h) gVar;
                        hVar.r0 = i19;
                        Arrays.fill(hVar.q0, obj);
                        for (int i26 = 0; i26 < bVar.c; i26++) {
                            int i27 = bVar.b[i26];
                            View d2 = constraintLayout.d(i27);
                            if (d2 == null && (h2 = bVar.h(constraintLayout, (str = bVar.f1474i.get(Integer.valueOf(i27))))) != 0) {
                                bVar.b[i26] = h2;
                                bVar.f1474i.put(Integer.valueOf(h2), str);
                                d2 = constraintLayout.d(h2);
                            }
                            if (d2 != null) {
                                e.h.a.i.g gVar2 = bVar.f1470e;
                                e.h.a.i.d e3 = constraintLayout.e(d2);
                                e.h.a.i.h hVar2 = (e.h.a.i.h) gVar2;
                                Objects.requireNonNull(hVar2);
                                if (!(e3 == hVar2 || e3 == null)) {
                                    int i28 = hVar2.r0 + 1;
                                    e.h.a.i.d[] dVarArr = hVar2.q0;
                                    if (i28 > dVarArr.length) {
                                        hVar2.q0 = (e.h.a.i.d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
                                    }
                                    e.h.a.i.d[] dVarArr2 = hVar2.q0;
                                    int i29 = hVar2.r0;
                                    dVarArr2[i29] = e3;
                                    hVar2.r0 = i29 + 1;
                                }
                            }
                        }
                        bVar.f1470e.a(constraintLayout.f111d);
                    }
                    i25++;
                    obj = null;
                    i19 = 0;
                }
            }
            for (int i30 = 0; i30 < childCount2; i30++) {
                View childAt3 = constraintLayout.getChildAt(i30);
                if (childAt3 instanceof g) {
                    g gVar3 = (g) childAt3;
                    if (gVar3.b == -1 && !gVar3.isInEditMode()) {
                        gVar3.setVisibility(gVar3.f1526d);
                    }
                    View findViewById = constraintLayout.findViewById(gVar3.b);
                    gVar3.c = findViewById;
                    if (findViewById != null) {
                        ((a) findViewById.getLayoutParams()).e0 = true;
                        gVar3.c.setVisibility(0);
                        gVar3.setVisibility(0);
                    }
                }
            }
            constraintLayout.q.clear();
            constraintLayout.q.put(0, constraintLayout.f111d);
            constraintLayout.q.put(getId(), constraintLayout.f111d);
            for (int i31 = 0; i31 < childCount2; i31++) {
                View childAt4 = constraintLayout.getChildAt(i31);
                constraintLayout.q.put(childAt4.getId(), constraintLayout.e(childAt4));
            }
            int i32 = 0;
            while (i32 < childCount2) {
                View childAt5 = constraintLayout.getChildAt(i32);
                e.h.a.i.d e4 = constraintLayout.e(childAt5);
                if (e4 != null) {
                    a aVar6 = (a) childAt5.getLayoutParams();
                    e eVar = constraintLayout.f111d;
                    eVar.q0.add(e4);
                    e.h.a.i.d dVar7 = e4.U;
                    if (dVar7 != null) {
                        ((e.h.a.i.k) dVar7).q0.remove(e4);
                        e4.C();
                    }
                    e4.U = eVar;
                    SparseArray<e.h.a.i.d> sparseArray = constraintLayout.q;
                    d.a aVar7 = d.a.MATCH_PARENT;
                    d.a aVar8 = d.a.WRAP_CONTENT;
                    d.a aVar9 = d.a.FIXED;
                    d.a aVar10 = d.a.MATCH_CONSTRAINT;
                    c.a aVar11 = c.a.RIGHT;
                    c.a aVar12 = c.a.LEFT;
                    c.a aVar13 = c.a.BOTTOM;
                    c.a aVar14 = c.a.TOP;
                    aVar6.a();
                    e4.h0 = childAt5.getVisibility();
                    if (aVar6.e0) {
                        e4.E = z;
                        e4.h0 = 8;
                    }
                    e4.g0 = childAt5;
                    if (childAt5 instanceof e.h.c.b) {
                        ((e.h.c.b) childAt5).j(e4, constraintLayout.f111d.v0);
                    }
                    if (aVar6.c0) {
                        f fVar = (f) e4;
                        int i33 = aVar6.m0;
                        int i34 = aVar6.n0;
                        float f4 = aVar6.o0;
                        int i35 = (f4 > -1.0f ? 1 : (f4 == -1.0f ? 0 : -1));
                        if (i35 != 0) {
                            if (i35 > 0) {
                                fVar.q0 = f4;
                                fVar.r0 = i22;
                                fVar.s0 = i22;
                            }
                        } else if (i33 != i22) {
                            if (i33 > i22) {
                                fVar.q0 = -1.0f;
                                fVar.r0 = i33;
                                fVar.s0 = i22;
                            }
                        } else if (i34 != i22 && i34 > i22) {
                            fVar.q0 = -1.0f;
                            fVar.r0 = i22;
                            fVar.s0 = i34;
                        }
                    } else {
                        int i36 = aVar6.f0;
                        int i37 = aVar6.g0;
                        int i38 = aVar6.h0;
                        int i39 = aVar6.i0;
                        int i40 = aVar6.j0;
                        i3 = childCount2;
                        int i41 = aVar6.k0;
                        z4 = z2;
                        float f5 = aVar6.l0;
                        i2 = i32;
                        int i42 = aVar6.o;
                        z3 = isInEditMode;
                        if (i42 != -1) {
                            e.h.a.i.d dVar8 = sparseArray.get(i42);
                            if (dVar8 != null) {
                                float f6 = aVar6.q;
                                int i43 = aVar6.p;
                                c.a aVar15 = c.a.CENTER;
                                e4.i(aVar15).a(dVar8.i(aVar15), i43, 0, true);
                                e4.C = f6;
                            }
                            aVar3 = aVar14;
                            aVar2 = aVar13;
                            aVar = aVar12;
                            aVar4 = aVar11;
                        } else if (i36 != -1) {
                            e.h.a.i.d dVar9 = sparseArray.get(i36);
                            if (dVar9 != null) {
                                i18 = ((ViewGroup.MarginLayoutParams) aVar6).leftMargin;
                                cVar5 = e4.i(aVar12);
                                cVar6 = dVar9.i(aVar12);
                                cVar5.a(cVar6, i18, i40, true);
                            }
                            if (i38 == -1) {
                                e.h.a.i.d dVar10 = sparseArray.get(i38);
                                if (dVar10 != null) {
                                    i17 = ((ViewGroup.MarginLayoutParams) aVar6).rightMargin;
                                    cVar3 = e4.i(aVar11);
                                    cVar4 = dVar10.i(aVar12);
                                    cVar3.a(cVar4, i17, i41, true);
                                }
                                i7 = aVar6.f124h;
                                if (i7 == -1) {
                                    e.h.a.i.d dVar11 = sparseArray.get(i7);
                                    if (dVar11 != null) {
                                        i16 = ((ViewGroup.MarginLayoutParams) aVar6).topMargin;
                                        i15 = aVar6.w;
                                        cVar = e4.i(aVar14);
                                        cVar2 = dVar11.i(aVar14);
                                        cVar.a(cVar2, i16, i15, true);
                                    }
                                    i8 = aVar6.f126j;
                                    if (i8 == -1) {
                                        e.h.a.i.d dVar12 = sparseArray.get(i8);
                                        if (dVar12 != null) {
                                            i11 = ((ViewGroup.MarginLayoutParams) aVar6).bottomMargin;
                                            i12 = aVar6.y;
                                            i13 = e4.i(aVar13);
                                            i14 = dVar12.i(aVar14);
                                            i13.a(i14, i11, i12, true);
                                        }
                                        i9 = aVar6.f128l;
                                        if (i9 == -1) {
                                            aVar5 = c.a.BASELINE;
                                            i10 = i9;
                                        } else {
                                            int i44 = aVar6.m;
                                            if (i44 != -1) {
                                                i10 = i44;
                                                aVar5 = aVar14;
                                            } else {
                                                int i45 = aVar6.n;
                                                if (i45 != -1) {
                                                    i10 = i45;
                                                    aVar5 = aVar13;
                                                } else {
                                                    aVar3 = aVar14;
                                                    aVar2 = aVar13;
                                                    aVar = aVar12;
                                                    aVar4 = aVar11;
                                                    if (f5 >= 0.0f) {
                                                        e4.e0 = f5;
                                                    }
                                                    f3 = aVar6.E;
                                                    if (f3 >= 0.0f) {
                                                        e4.f0 = f3;
                                                    }
                                                }
                                            }
                                        }
                                        aVar3 = aVar14;
                                        aVar2 = aVar13;
                                        aVar = aVar12;
                                        aVar4 = aVar11;
                                        q(e4, aVar6, sparseArray, i10, aVar5);
                                        if (f5 >= 0.0f) {
                                        }
                                        f3 = aVar6.E;
                                        if (f3 >= 0.0f) {
                                        }
                                    } else {
                                        int i46 = aVar6.f127k;
                                        if (!(i46 == -1 || (dVar = sparseArray.get(i46)) == null)) {
                                            i11 = ((ViewGroup.MarginLayoutParams) aVar6).bottomMargin;
                                            i12 = aVar6.y;
                                            i13 = e4.i(aVar13);
                                            i14 = dVar.i(aVar13);
                                            i13.a(i14, i11, i12, true);
                                        }
                                        i9 = aVar6.f128l;
                                        if (i9 == -1) {
                                        }
                                        aVar3 = aVar14;
                                        aVar2 = aVar13;
                                        aVar = aVar12;
                                        aVar4 = aVar11;
                                        q(e4, aVar6, sparseArray, i10, aVar5);
                                        if (f5 >= 0.0f) {
                                        }
                                        f3 = aVar6.E;
                                        if (f3 >= 0.0f) {
                                        }
                                    }
                                } else {
                                    int i47 = aVar6.f125i;
                                    if (!(i47 == -1 || (dVar2 = sparseArray.get(i47)) == null)) {
                                        i16 = ((ViewGroup.MarginLayoutParams) aVar6).topMargin;
                                        i15 = aVar6.w;
                                        cVar = e4.i(aVar14);
                                        cVar2 = dVar2.i(aVar13);
                                        cVar.a(cVar2, i16, i15, true);
                                    }
                                    i8 = aVar6.f126j;
                                    if (i8 == -1) {
                                    }
                                }
                            } else {
                                if (!(i39 == -1 || (dVar3 = sparseArray.get(i39)) == null)) {
                                    i17 = ((ViewGroup.MarginLayoutParams) aVar6).rightMargin;
                                    cVar3 = e4.i(aVar11);
                                    cVar4 = dVar3.i(aVar11);
                                    cVar3.a(cVar4, i17, i41, true);
                                }
                                i7 = aVar6.f124h;
                                if (i7 == -1) {
                                }
                            }
                        } else {
                            if (!(i37 == -1 || (dVar4 = sparseArray.get(i37)) == null)) {
                                i18 = ((ViewGroup.MarginLayoutParams) aVar6).leftMargin;
                                cVar5 = e4.i(aVar12);
                                cVar6 = dVar4.i(aVar11);
                                cVar5.a(cVar6, i18, i40, true);
                            }
                            if (i38 == -1) {
                            }
                        }
                        if (z3 && !((i6 = aVar6.S) == -1 && aVar6.T == -1)) {
                            int i48 = aVar6.T;
                            e4.Z = i6;
                            e4.a0 = i48;
                        }
                        if (aVar6.Z) {
                            e4.T[0] = aVar9;
                            e4.N(((ViewGroup.MarginLayoutParams) aVar6).width);
                            if (((ViewGroup.MarginLayoutParams) aVar6).width == -2) {
                                e4.T[0] = aVar8;
                            }
                        } else if (((ViewGroup.MarginLayoutParams) aVar6).width == -1) {
                            if (aVar6.V) {
                                e4.T[0] = aVar10;
                            } else {
                                e4.T[0] = aVar7;
                            }
                            e4.i(aVar).f1380g = ((ViewGroup.MarginLayoutParams) aVar6).leftMargin;
                            e4.i(aVar4).f1380g = ((ViewGroup.MarginLayoutParams) aVar6).rightMargin;
                        } else {
                            e4.T[0] = aVar10;
                            e4.N(0);
                        }
                        if (aVar6.a0) {
                            e4.T[1] = aVar9;
                            e4.I(((ViewGroup.MarginLayoutParams) aVar6).height);
                            if (((ViewGroup.MarginLayoutParams) aVar6).height == -2) {
                                e4.T[1] = aVar8;
                            }
                        } else if (((ViewGroup.MarginLayoutParams) aVar6).height == -1) {
                            if (aVar6.W) {
                                e4.T[1] = aVar10;
                            } else {
                                e4.T[1] = aVar7;
                            }
                            e4.i(aVar3).f1380g = ((ViewGroup.MarginLayoutParams) aVar6).topMargin;
                            e4.i(aVar2).f1380g = ((ViewGroup.MarginLayoutParams) aVar6).bottomMargin;
                        } else {
                            e4.T[1] = aVar10;
                            e4.I(0);
                        }
                        String str2 = aVar6.F;
                        if (str2 == null || str2.length() == 0) {
                            e4.X = 0.0f;
                        } else {
                            int length = str2.length();
                            int indexOf2 = str2.indexOf(44);
                            if (indexOf2 <= 0 || indexOf2 >= length - 1) {
                                i5 = 0;
                                i4 = -1;
                            } else {
                                String substring = str2.substring(0, indexOf2);
                                i5 = indexOf2 + 1;
                                i4 = substring.equalsIgnoreCase("W") ? 0 : substring.equalsIgnoreCase("H") ? 1 : -1;
                            }
                            int indexOf3 = str2.indexOf(58);
                            if (indexOf3 < 0 || indexOf3 >= length - 1) {
                                String substring2 = str2.substring(i5);
                                if (substring2.length() > 0) {
                                    f2 = Float.parseFloat(substring2);
                                }
                                f2 = 0.0f;
                            } else {
                                String substring3 = str2.substring(i5, indexOf3);
                                String substring4 = str2.substring(indexOf3 + 1);
                                if (substring3.length() > 0 && substring4.length() > 0) {
                                    try {
                                        float parseFloat = Float.parseFloat(substring3);
                                        float parseFloat2 = Float.parseFloat(substring4);
                                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                            f2 = i4 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                                        }
                                    } catch (NumberFormatException unused2) {
                                    }
                                }
                                f2 = 0.0f;
                            }
                            if (f2 > 0.0f) {
                                e4.X = f2;
                                e4.Y = i4;
                            }
                        }
                        float f7 = aVar6.G;
                        float[] fArr = e4.l0;
                        fArr[0] = f7;
                        fArr[1] = aVar6.H;
                        e4.j0 = aVar6.I;
                        e4.k0 = aVar6.J;
                        int i49 = aVar6.Y;
                        if (i49 >= 0 && i49 <= 3) {
                            e4.p = i49;
                        }
                        int i50 = aVar6.K;
                        int i51 = aVar6.M;
                        int i52 = aVar6.O;
                        float f8 = aVar6.Q;
                        e4.q = i50;
                        e4.t = i51;
                        if (i52 == Integer.MAX_VALUE) {
                            i52 = 0;
                        }
                        e4.u = i52;
                        e4.v = f8;
                        if (f8 > 0.0f && f8 < 1.0f && i50 == 0) {
                            e4.q = 2;
                        }
                        int i53 = aVar6.L;
                        int i54 = aVar6.N;
                        int i55 = aVar6.P;
                        float f9 = aVar6.R;
                        e4.r = i53;
                        e4.w = i54;
                        if (i55 == Integer.MAX_VALUE) {
                            i55 = 0;
                        }
                        e4.x = i55;
                        e4.y = f9;
                        if (f9 > 0.0f && f9 < 1.0f && i53 == 0) {
                            e4.r = 2;
                        }
                        i32 = i2 + 1;
                        constraintLayout = this;
                        childCount2 = i3;
                        z2 = z4;
                        isInEditMode = z3;
                        z = true;
                        i22 = -1;
                    }
                }
                i2 = i32;
                z4 = z2;
                z3 = isInEditMode;
                i3 = childCount2;
                i32 = i2 + 1;
                constraintLayout = this;
                childCount2 = i3;
                z2 = z4;
                isInEditMode = z3;
                z = true;
                i22 = -1;
            }
        }
        return z2;
    }

    @Override // android.view.ViewParent, android.view.View
    public void requestLayout() {
        this.f116i = true;
        this.o = -1;
        this.p = -1;
        super.requestLayout();
    }

    public void setConstraintSet(e.h.c.d dVar) {
        this.f118k = dVar;
    }

    @Override // android.view.View
    public void setId(int i2) {
        this.b.remove(getId());
        super.setId(i2);
        this.b.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 != this.f115h) {
            this.f115h = i2;
            requestLayout();
        }
    }

    public void setMaxWidth(int i2) {
        if (i2 != this.f114g) {
            this.f114g = i2;
            requestLayout();
        }
    }

    public void setMinHeight(int i2) {
        if (i2 != this.f113f) {
            this.f113f = i2;
            requestLayout();
        }
    }

    public void setMinWidth(int i2) {
        if (i2 != this.f112e) {
            this.f112e = i2;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(e.h.c.f fVar) {
        e.h.c.c cVar = this.f119l;
        if (cVar != null) {
            Objects.requireNonNull(cVar);
        }
    }

    public void setOptimizationLevel(int i2) {
        this.f117j = i2;
        e eVar = this.f111d;
        eVar.D0 = i2;
        e.h.a.d.p = eVar.a0(512);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
