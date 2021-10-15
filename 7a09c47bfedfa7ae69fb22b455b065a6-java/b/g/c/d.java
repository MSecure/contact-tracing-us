package b.g.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import b.g.c.e;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f1600d = {0, 4, 8};

    /* renamed from: e  reason: collision with root package name */
    public static SparseIntArray f1601e;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, a> f1602a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f1603b = true;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Integer, a> f1604c = new HashMap<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1605a;

        /* renamed from: b  reason: collision with root package name */
        public final C0027d f1606b = new C0027d();

        /* renamed from: c  reason: collision with root package name */
        public final c f1607c = new c();

        /* renamed from: d  reason: collision with root package name */
        public final b f1608d = new b();

        /* renamed from: e  reason: collision with root package name */
        public final e f1609e = new e();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, a> f1610f = new HashMap<>();

        public void a(ConstraintLayout.a aVar) {
            b bVar = this.f1608d;
            aVar.f172d = bVar.h;
            aVar.f173e = bVar.i;
            aVar.f174f = bVar.j;
            aVar.f175g = bVar.k;
            aVar.h = bVar.l;
            aVar.i = bVar.m;
            aVar.j = bVar.n;
            aVar.k = bVar.o;
            aVar.l = bVar.p;
            aVar.p = bVar.q;
            aVar.q = bVar.r;
            aVar.r = bVar.s;
            aVar.s = bVar.t;
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = bVar.D;
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = bVar.E;
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = bVar.F;
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = bVar.G;
            aVar.x = bVar.O;
            aVar.y = bVar.N;
            aVar.u = bVar.K;
            aVar.w = bVar.M;
            aVar.z = bVar.u;
            aVar.A = bVar.v;
            aVar.m = bVar.x;
            aVar.n = bVar.y;
            aVar.o = bVar.z;
            aVar.B = bVar.w;
            aVar.P = bVar.A;
            aVar.Q = bVar.B;
            aVar.E = bVar.P;
            aVar.D = bVar.Q;
            aVar.G = bVar.S;
            aVar.F = bVar.R;
            aVar.S = bVar.h0;
            aVar.T = bVar.i0;
            aVar.H = bVar.T;
            aVar.I = bVar.U;
            aVar.L = bVar.V;
            aVar.M = bVar.W;
            aVar.J = bVar.X;
            aVar.K = bVar.Y;
            aVar.N = bVar.Z;
            aVar.O = bVar.a0;
            aVar.R = bVar.C;
            aVar.f171c = bVar.f1617g;
            aVar.f169a = bVar.f1615e;
            aVar.f170b = bVar.f1616f;
            ((ViewGroup.MarginLayoutParams) aVar).width = bVar.f1613c;
            ((ViewGroup.MarginLayoutParams) aVar).height = bVar.f1614d;
            String str = bVar.g0;
            if (str != null) {
                aVar.U = str;
            }
            aVar.setMarginStart(this.f1608d.I);
            aVar.setMarginEnd(this.f1608d.H);
            aVar.a();
        }

        public final void b(int i, ConstraintLayout.a aVar) {
            this.f1605a = i;
            b bVar = this.f1608d;
            bVar.h = aVar.f172d;
            bVar.i = aVar.f173e;
            bVar.j = aVar.f174f;
            bVar.k = aVar.f175g;
            bVar.l = aVar.h;
            bVar.m = aVar.i;
            bVar.n = aVar.j;
            bVar.o = aVar.k;
            bVar.p = aVar.l;
            bVar.q = aVar.p;
            bVar.r = aVar.q;
            bVar.s = aVar.r;
            bVar.t = aVar.s;
            bVar.u = aVar.z;
            bVar.v = aVar.A;
            bVar.w = aVar.B;
            bVar.x = aVar.m;
            bVar.y = aVar.n;
            bVar.z = aVar.o;
            bVar.A = aVar.P;
            bVar.B = aVar.Q;
            bVar.C = aVar.R;
            bVar.f1617g = aVar.f171c;
            bVar.f1615e = aVar.f169a;
            bVar.f1616f = aVar.f170b;
            bVar.f1613c = ((ViewGroup.MarginLayoutParams) aVar).width;
            bVar.f1614d = ((ViewGroup.MarginLayoutParams) aVar).height;
            bVar.D = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
            bVar.E = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
            bVar.F = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
            bVar.G = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            bVar.P = aVar.E;
            bVar.Q = aVar.D;
            bVar.S = aVar.G;
            bVar.R = aVar.F;
            bVar.h0 = aVar.S;
            bVar.i0 = aVar.T;
            bVar.T = aVar.H;
            bVar.U = aVar.I;
            bVar.V = aVar.L;
            bVar.W = aVar.M;
            bVar.X = aVar.J;
            bVar.Y = aVar.K;
            bVar.Z = aVar.N;
            bVar.a0 = aVar.O;
            bVar.g0 = aVar.U;
            bVar.K = aVar.u;
            bVar.M = aVar.w;
            bVar.J = aVar.t;
            bVar.L = aVar.v;
            bVar.O = aVar.x;
            bVar.N = aVar.y;
            bVar.H = aVar.getMarginEnd();
            this.f1608d.I = aVar.getMarginStart();
        }

        public final void c(int i, e.a aVar) {
            b(i, aVar);
            this.f1606b.f1628d = aVar.n0;
            e eVar = this.f1609e;
            eVar.f1631b = aVar.q0;
            eVar.f1632c = aVar.r0;
            eVar.f1633d = aVar.s0;
            eVar.f1634e = aVar.t0;
            eVar.f1635f = aVar.u0;
            eVar.f1636g = aVar.v0;
            eVar.h = aVar.w0;
            eVar.i = aVar.x0;
            eVar.j = aVar.y0;
            eVar.k = aVar.z0;
            eVar.m = aVar.p0;
            eVar.l = aVar.o0;
        }

        public Object clone() {
            a aVar = new a();
            b bVar = aVar.f1608d;
            b bVar2 = this.f1608d;
            if (bVar != null) {
                bVar.f1611a = bVar2.f1611a;
                bVar.f1613c = bVar2.f1613c;
                bVar.f1612b = bVar2.f1612b;
                bVar.f1614d = bVar2.f1614d;
                bVar.f1615e = bVar2.f1615e;
                bVar.f1616f = bVar2.f1616f;
                bVar.f1617g = bVar2.f1617g;
                bVar.h = bVar2.h;
                bVar.i = bVar2.i;
                bVar.j = bVar2.j;
                bVar.k = bVar2.k;
                bVar.l = bVar2.l;
                bVar.m = bVar2.m;
                bVar.n = bVar2.n;
                bVar.o = bVar2.o;
                bVar.p = bVar2.p;
                bVar.q = bVar2.q;
                bVar.r = bVar2.r;
                bVar.s = bVar2.s;
                bVar.t = bVar2.t;
                bVar.u = bVar2.u;
                bVar.v = bVar2.v;
                bVar.w = bVar2.w;
                bVar.x = bVar2.x;
                bVar.y = bVar2.y;
                bVar.z = bVar2.z;
                bVar.A = bVar2.A;
                bVar.B = bVar2.B;
                bVar.C = bVar2.C;
                bVar.D = bVar2.D;
                bVar.E = bVar2.E;
                bVar.F = bVar2.F;
                bVar.G = bVar2.G;
                bVar.H = bVar2.H;
                bVar.I = bVar2.I;
                bVar.J = bVar2.J;
                bVar.K = bVar2.K;
                bVar.L = bVar2.L;
                bVar.M = bVar2.M;
                bVar.N = bVar2.N;
                bVar.O = bVar2.O;
                bVar.P = bVar2.P;
                bVar.Q = bVar2.Q;
                bVar.R = bVar2.R;
                bVar.S = bVar2.S;
                bVar.T = bVar2.T;
                bVar.U = bVar2.U;
                bVar.V = bVar2.V;
                bVar.W = bVar2.W;
                bVar.X = bVar2.X;
                bVar.Y = bVar2.Y;
                bVar.Z = bVar2.Z;
                bVar.a0 = bVar2.a0;
                bVar.b0 = bVar2.b0;
                bVar.c0 = bVar2.c0;
                bVar.d0 = bVar2.d0;
                bVar.g0 = bVar2.g0;
                int[] iArr = bVar2.e0;
                if (iArr != null) {
                    bVar.e0 = Arrays.copyOf(iArr, iArr.length);
                } else {
                    bVar.e0 = null;
                }
                bVar.f0 = bVar2.f0;
                bVar.h0 = bVar2.h0;
                bVar.i0 = bVar2.i0;
                bVar.j0 = bVar2.j0;
                c cVar = aVar.f1607c;
                c cVar2 = this.f1607c;
                if (cVar != null) {
                    cVar.f1618a = cVar2.f1618a;
                    cVar.f1619b = cVar2.f1619b;
                    cVar.f1620c = cVar2.f1620c;
                    cVar.f1621d = cVar2.f1621d;
                    cVar.f1622e = cVar2.f1622e;
                    cVar.f1624g = cVar2.f1624g;
                    cVar.f1623f = cVar2.f1623f;
                    C0027d dVar = aVar.f1606b;
                    C0027d dVar2 = this.f1606b;
                    if (dVar != null) {
                        dVar.f1625a = dVar2.f1625a;
                        dVar.f1626b = dVar2.f1626b;
                        dVar.f1628d = dVar2.f1628d;
                        dVar.f1629e = dVar2.f1629e;
                        dVar.f1627c = dVar2.f1627c;
                        e eVar = aVar.f1609e;
                        e eVar2 = this.f1609e;
                        if (eVar != null) {
                            eVar.f1630a = eVar2.f1630a;
                            eVar.f1631b = eVar2.f1631b;
                            eVar.f1632c = eVar2.f1632c;
                            eVar.f1633d = eVar2.f1633d;
                            eVar.f1634e = eVar2.f1634e;
                            eVar.f1635f = eVar2.f1635f;
                            eVar.f1636g = eVar2.f1636g;
                            eVar.h = eVar2.h;
                            eVar.i = eVar2.i;
                            eVar.j = eVar2.j;
                            eVar.k = eVar2.k;
                            eVar.l = eVar2.l;
                            eVar.m = eVar2.m;
                            aVar.f1605a = this.f1605a;
                            return aVar;
                        }
                        throw null;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        }
    }

    public static class b {
        public static SparseIntArray k0;
        public int A = -1;
        public int B = -1;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = -1;
        public int I = -1;
        public int J = -1;
        public int K = -1;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        public int O = -1;
        public float P = -1.0f;
        public float Q = -1.0f;
        public int R = 0;
        public int S = 0;
        public int T = 0;
        public int U = 0;
        public int V = -1;
        public int W = -1;
        public int X = -1;
        public int Y = -1;
        public float Z = 1.0f;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1611a = false;
        public float a0 = 1.0f;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1612b = false;
        public int b0 = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f1613c;
        public int c0 = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f1614d;
        public int d0 = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f1615e = -1;
        public int[] e0;

        /* renamed from: f  reason: collision with root package name */
        public int f1616f = -1;
        public String f0;

        /* renamed from: g  reason: collision with root package name */
        public float f1617g = -1.0f;
        public String g0;
        public int h = -1;
        public boolean h0 = false;
        public int i = -1;
        public boolean i0 = false;
        public int j = -1;
        public boolean j0 = true;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public float u = 0.5f;
        public float v = 0.5f;
        public String w = null;
        public int x = -1;
        public int y = 0;
        public float z = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            k0 = sparseIntArray;
            sparseIntArray.append(i.Layout_layout_constraintLeft_toLeftOf, 24);
            k0.append(i.Layout_layout_constraintLeft_toRightOf, 25);
            k0.append(i.Layout_layout_constraintRight_toLeftOf, 28);
            k0.append(i.Layout_layout_constraintRight_toRightOf, 29);
            k0.append(i.Layout_layout_constraintTop_toTopOf, 35);
            k0.append(i.Layout_layout_constraintTop_toBottomOf, 34);
            k0.append(i.Layout_layout_constraintBottom_toTopOf, 4);
            k0.append(i.Layout_layout_constraintBottom_toBottomOf, 3);
            k0.append(i.Layout_layout_constraintBaseline_toBaselineOf, 1);
            k0.append(i.Layout_layout_editor_absoluteX, 6);
            k0.append(i.Layout_layout_editor_absoluteY, 7);
            k0.append(i.Layout_layout_constraintGuide_begin, 17);
            k0.append(i.Layout_layout_constraintGuide_end, 18);
            k0.append(i.Layout_layout_constraintGuide_percent, 19);
            k0.append(i.Layout_android_orientation, 26);
            k0.append(i.Layout_layout_constraintStart_toEndOf, 31);
            k0.append(i.Layout_layout_constraintStart_toStartOf, 32);
            k0.append(i.Layout_layout_constraintEnd_toStartOf, 10);
            k0.append(i.Layout_layout_constraintEnd_toEndOf, 9);
            k0.append(i.Layout_layout_goneMarginLeft, 13);
            k0.append(i.Layout_layout_goneMarginTop, 16);
            k0.append(i.Layout_layout_goneMarginRight, 14);
            k0.append(i.Layout_layout_goneMarginBottom, 11);
            k0.append(i.Layout_layout_goneMarginStart, 15);
            k0.append(i.Layout_layout_goneMarginEnd, 12);
            k0.append(i.Layout_layout_constraintVertical_weight, 38);
            k0.append(i.Layout_layout_constraintHorizontal_weight, 37);
            k0.append(i.Layout_layout_constraintHorizontal_chainStyle, 39);
            k0.append(i.Layout_layout_constraintVertical_chainStyle, 40);
            k0.append(i.Layout_layout_constraintHorizontal_bias, 20);
            k0.append(i.Layout_layout_constraintVertical_bias, 36);
            k0.append(i.Layout_layout_constraintDimensionRatio, 5);
            k0.append(i.Layout_layout_constraintLeft_creator, 76);
            k0.append(i.Layout_layout_constraintTop_creator, 76);
            k0.append(i.Layout_layout_constraintRight_creator, 76);
            k0.append(i.Layout_layout_constraintBottom_creator, 76);
            k0.append(i.Layout_layout_constraintBaseline_creator, 76);
            k0.append(i.Layout_android_layout_marginLeft, 23);
            k0.append(i.Layout_android_layout_marginRight, 27);
            k0.append(i.Layout_android_layout_marginStart, 30);
            k0.append(i.Layout_android_layout_marginEnd, 8);
            k0.append(i.Layout_android_layout_marginTop, 33);
            k0.append(i.Layout_android_layout_marginBottom, 2);
            k0.append(i.Layout_android_layout_width, 22);
            k0.append(i.Layout_android_layout_height, 21);
            k0.append(i.Layout_layout_constraintCircle, 61);
            k0.append(i.Layout_layout_constraintCircleRadius, 62);
            k0.append(i.Layout_layout_constraintCircleAngle, 63);
            k0.append(i.Layout_layout_constraintWidth_percent, 69);
            k0.append(i.Layout_layout_constraintHeight_percent, 70);
            k0.append(i.Layout_chainUseRtl, 71);
            k0.append(i.Layout_barrierDirection, 72);
            k0.append(i.Layout_barrierMargin, 73);
            k0.append(i.Layout_constraint_referenced_ids, 74);
            k0.append(i.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.Layout);
            this.f1612b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = k0.get(index);
                if (i3 == 80) {
                    this.h0 = obtainStyledAttributes.getBoolean(index, this.h0);
                } else if (i3 != 81) {
                    switch (i3) {
                        case 1:
                            this.p = d.a(obtainStyledAttributes, index, this.p);
                            continue;
                        case 2:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            continue;
                        case 3:
                            this.o = d.a(obtainStyledAttributes, index, this.o);
                            continue;
                        case 4:
                            this.n = d.a(obtainStyledAttributes, index, this.n);
                            continue;
                        case 5:
                            this.w = obtainStyledAttributes.getString(index);
                            continue;
                        case 6:
                            this.A = obtainStyledAttributes.getDimensionPixelOffset(index, this.A);
                            continue;
                        case 7:
                            this.B = obtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                            continue;
                        case 8:
                            this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                            continue;
                        case 9:
                            this.t = d.a(obtainStyledAttributes, index, this.t);
                            continue;
                        case 10:
                            this.s = d.a(obtainStyledAttributes, index, this.s);
                            continue;
                        case 11:
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            continue;
                        case 12:
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            continue;
                        case 13:
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            continue;
                        case 14:
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            continue;
                        case 15:
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            continue;
                        case 16:
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            continue;
                        case 17:
                            this.f1615e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1615e);
                            continue;
                        case 18:
                            this.f1616f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1616f);
                            continue;
                        case 19:
                            this.f1617g = obtainStyledAttributes.getFloat(index, this.f1617g);
                            continue;
                        case 20:
                            this.u = obtainStyledAttributes.getFloat(index, this.u);
                            continue;
                        case 21:
                            this.f1614d = obtainStyledAttributes.getLayoutDimension(index, this.f1614d);
                            continue;
                        case 22:
                            this.f1613c = obtainStyledAttributes.getLayoutDimension(index, this.f1613c);
                            continue;
                        case 23:
                            this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                            continue;
                        case 24:
                            this.h = d.a(obtainStyledAttributes, index, this.h);
                            continue;
                        case 25:
                            this.i = d.a(obtainStyledAttributes, index, this.i);
                            continue;
                        case 26:
                            this.C = obtainStyledAttributes.getInt(index, this.C);
                            continue;
                        case 27:
                            this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                            continue;
                        case 28:
                            this.j = d.a(obtainStyledAttributes, index, this.j);
                            continue;
                        case 29:
                            this.k = d.a(obtainStyledAttributes, index, this.k);
                            continue;
                        case 30:
                            this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                            continue;
                        case 31:
                            this.q = d.a(obtainStyledAttributes, index, this.q);
                            continue;
                        case 32:
                            this.r = d.a(obtainStyledAttributes, index, this.r);
                            continue;
                        case 33:
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            continue;
                        case 34:
                            this.m = d.a(obtainStyledAttributes, index, this.m);
                            continue;
                        case 35:
                            this.l = d.a(obtainStyledAttributes, index, this.l);
                            continue;
                        case 36:
                            this.v = obtainStyledAttributes.getFloat(index, this.v);
                            continue;
                        case 37:
                            this.Q = obtainStyledAttributes.getFloat(index, this.Q);
                            continue;
                        case 38:
                            this.P = obtainStyledAttributes.getFloat(index, this.P);
                            continue;
                        case 39:
                            this.R = obtainStyledAttributes.getInt(index, this.R);
                            continue;
                        case 40:
                            this.S = obtainStyledAttributes.getInt(index, this.S);
                            continue;
                        default:
                            switch (i3) {
                                case 54:
                                    this.T = obtainStyledAttributes.getInt(index, this.T);
                                    continue;
                                case 55:
                                    this.U = obtainStyledAttributes.getInt(index, this.U);
                                    continue;
                                case 56:
                                    this.V = obtainStyledAttributes.getDimensionPixelSize(index, this.V);
                                    continue;
                                case 57:
                                    this.W = obtainStyledAttributes.getDimensionPixelSize(index, this.W);
                                    continue;
                                case 58:
                                    this.X = obtainStyledAttributes.getDimensionPixelSize(index, this.X);
                                    continue;
                                case 59:
                                    this.Y = obtainStyledAttributes.getDimensionPixelSize(index, this.Y);
                                    continue;
                                default:
                                    switch (i3) {
                                        case 61:
                                            this.x = d.a(obtainStyledAttributes, index, this.x);
                                            continue;
                                        case 62:
                                            this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                                            continue;
                                        case 63:
                                            this.z = obtainStyledAttributes.getFloat(index, this.z);
                                            continue;
                                        default:
                                            switch (i3) {
                                                case 69:
                                                    this.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 70:
                                                    this.a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 71:
                                                    continue;
                                                    continue;
                                                    continue;
                                                case 72:
                                                    this.b0 = obtainStyledAttributes.getInt(index, this.b0);
                                                    continue;
                                                case 73:
                                                    this.c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                                    continue;
                                                case 74:
                                                    this.f0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                case 75:
                                                    this.j0 = obtainStyledAttributes.getBoolean(index, this.j0);
                                                    continue;
                                                case 76:
                                                default:
                                                    Integer.toHexString(index);
                                                    k0.get(index);
                                                    continue;
                                                case 77:
                                                    this.g0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                            }
                                    }
                            }
                    }
                } else {
                    this.i0 = obtainStyledAttributes.getBoolean(index, this.i0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class c {
        public static SparseIntArray h;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1618a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f1619b = -1;

        /* renamed from: c  reason: collision with root package name */
        public String f1620c = null;

        /* renamed from: d  reason: collision with root package name */
        public int f1621d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f1622e = 0;

        /* renamed from: f  reason: collision with root package name */
        public float f1623f = Float.NaN;

        /* renamed from: g  reason: collision with root package name */
        public float f1624g = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            h = sparseIntArray;
            sparseIntArray.append(i.Motion_motionPathRotate, 1);
            h.append(i.Motion_pathMotionArc, 2);
            h.append(i.Motion_transitionEasing, 3);
            h.append(i.Motion_drawPath, 4);
            h.append(i.Motion_animate_relativeTo, 5);
            h.append(i.Motion_motionStagger, 6);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.Motion);
            this.f1618a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (h.get(index)) {
                    case 1:
                        this.f1624g = obtainStyledAttributes.getFloat(index, this.f1624g);
                        break;
                    case 2:
                        this.f1621d = obtainStyledAttributes.getInt(index, this.f1621d);
                        break;
                    case 3:
                        this.f1620c = obtainStyledAttributes.peekValue(index).type == 3 ? obtainStyledAttributes.getString(index) : b.g.a.a.a.f1450a[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    case 4:
                        this.f1622e = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f1619b = d.a(obtainStyledAttributes, index, this.f1619b);
                        break;
                    case 6:
                        this.f1623f = obtainStyledAttributes.getFloat(index, this.f1623f);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b.g.c.d$d  reason: collision with other inner class name */
    public static class C0027d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1625a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f1626b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f1627c = 0;

        /* renamed from: d  reason: collision with root package name */
        public float f1628d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f1629e = Float.NaN;

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.PropertySet);
            this.f1625a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == i.PropertySet_android_alpha) {
                    this.f1628d = obtainStyledAttributes.getFloat(index, this.f1628d);
                } else if (index == i.PropertySet_android_visibility) {
                    int i2 = obtainStyledAttributes.getInt(index, this.f1626b);
                    this.f1626b = i2;
                    this.f1626b = d.f1600d[i2];
                } else if (index == i.PropertySet_visibilityMode) {
                    this.f1627c = obtainStyledAttributes.getInt(index, this.f1627c);
                } else if (index == i.PropertySet_motionProgress) {
                    this.f1629e = obtainStyledAttributes.getFloat(index, this.f1629e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class e {
        public static SparseIntArray n;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1630a = false;

        /* renamed from: b  reason: collision with root package name */
        public float f1631b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f1632c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f1633d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f1634e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f1635f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f1636g = Float.NaN;
        public float h = Float.NaN;
        public float i = 0.0f;
        public float j = 0.0f;
        public float k = 0.0f;
        public boolean l = false;
        public float m = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            n = sparseIntArray;
            sparseIntArray.append(i.Transform_android_rotation, 1);
            n.append(i.Transform_android_rotationX, 2);
            n.append(i.Transform_android_rotationY, 3);
            n.append(i.Transform_android_scaleX, 4);
            n.append(i.Transform_android_scaleY, 5);
            n.append(i.Transform_android_transformPivotX, 6);
            n.append(i.Transform_android_transformPivotY, 7);
            n.append(i.Transform_android_translationX, 8);
            n.append(i.Transform_android_translationY, 9);
            n.append(i.Transform_android_translationZ, 10);
            n.append(i.Transform_android_elevation, 11);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.Transform);
            this.f1630a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (n.get(index)) {
                    case 1:
                        this.f1631b = obtainStyledAttributes.getFloat(index, this.f1631b);
                        break;
                    case 2:
                        this.f1632c = obtainStyledAttributes.getFloat(index, this.f1632c);
                        break;
                    case 3:
                        this.f1633d = obtainStyledAttributes.getFloat(index, this.f1633d);
                        break;
                    case 4:
                        this.f1634e = obtainStyledAttributes.getFloat(index, this.f1634e);
                        break;
                    case 5:
                        this.f1635f = obtainStyledAttributes.getFloat(index, this.f1635f);
                        break;
                    case 6:
                        this.f1636g = obtainStyledAttributes.getFloat(index, this.f1636g);
                        break;
                    case 7:
                        this.h = obtainStyledAttributes.getFloat(index, this.h);
                        break;
                    case 8:
                        this.i = obtainStyledAttributes.getDimension(index, this.i);
                        break;
                    case 9:
                        this.j = obtainStyledAttributes.getDimension(index, this.j);
                        break;
                    case 10:
                        this.k = obtainStyledAttributes.getDimension(index, this.k);
                        break;
                    case 11:
                        this.l = true;
                        this.m = obtainStyledAttributes.getDimension(index, this.m);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1601e = sparseIntArray;
        sparseIntArray.append(i.Constraint_layout_constraintLeft_toLeftOf, 25);
        f1601e.append(i.Constraint_layout_constraintLeft_toRightOf, 26);
        f1601e.append(i.Constraint_layout_constraintRight_toLeftOf, 29);
        f1601e.append(i.Constraint_layout_constraintRight_toRightOf, 30);
        f1601e.append(i.Constraint_layout_constraintTop_toTopOf, 36);
        f1601e.append(i.Constraint_layout_constraintTop_toBottomOf, 35);
        f1601e.append(i.Constraint_layout_constraintBottom_toTopOf, 4);
        f1601e.append(i.Constraint_layout_constraintBottom_toBottomOf, 3);
        f1601e.append(i.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f1601e.append(i.Constraint_layout_editor_absoluteX, 6);
        f1601e.append(i.Constraint_layout_editor_absoluteY, 7);
        f1601e.append(i.Constraint_layout_constraintGuide_begin, 17);
        f1601e.append(i.Constraint_layout_constraintGuide_end, 18);
        f1601e.append(i.Constraint_layout_constraintGuide_percent, 19);
        f1601e.append(i.Constraint_android_orientation, 27);
        f1601e.append(i.Constraint_layout_constraintStart_toEndOf, 32);
        f1601e.append(i.Constraint_layout_constraintStart_toStartOf, 33);
        f1601e.append(i.Constraint_layout_constraintEnd_toStartOf, 10);
        f1601e.append(i.Constraint_layout_constraintEnd_toEndOf, 9);
        f1601e.append(i.Constraint_layout_goneMarginLeft, 13);
        f1601e.append(i.Constraint_layout_goneMarginTop, 16);
        f1601e.append(i.Constraint_layout_goneMarginRight, 14);
        f1601e.append(i.Constraint_layout_goneMarginBottom, 11);
        f1601e.append(i.Constraint_layout_goneMarginStart, 15);
        f1601e.append(i.Constraint_layout_goneMarginEnd, 12);
        f1601e.append(i.Constraint_layout_constraintVertical_weight, 40);
        f1601e.append(i.Constraint_layout_constraintHorizontal_weight, 39);
        f1601e.append(i.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f1601e.append(i.Constraint_layout_constraintVertical_chainStyle, 42);
        f1601e.append(i.Constraint_layout_constraintHorizontal_bias, 20);
        f1601e.append(i.Constraint_layout_constraintVertical_bias, 37);
        f1601e.append(i.Constraint_layout_constraintDimensionRatio, 5);
        f1601e.append(i.Constraint_layout_constraintLeft_creator, 82);
        f1601e.append(i.Constraint_layout_constraintTop_creator, 82);
        f1601e.append(i.Constraint_layout_constraintRight_creator, 82);
        f1601e.append(i.Constraint_layout_constraintBottom_creator, 82);
        f1601e.append(i.Constraint_layout_constraintBaseline_creator, 82);
        f1601e.append(i.Constraint_android_layout_marginLeft, 24);
        f1601e.append(i.Constraint_android_layout_marginRight, 28);
        f1601e.append(i.Constraint_android_layout_marginStart, 31);
        f1601e.append(i.Constraint_android_layout_marginEnd, 8);
        f1601e.append(i.Constraint_android_layout_marginTop, 34);
        f1601e.append(i.Constraint_android_layout_marginBottom, 2);
        f1601e.append(i.Constraint_android_layout_width, 23);
        f1601e.append(i.Constraint_android_layout_height, 21);
        f1601e.append(i.Constraint_android_visibility, 22);
        f1601e.append(i.Constraint_android_alpha, 43);
        f1601e.append(i.Constraint_android_elevation, 44);
        f1601e.append(i.Constraint_android_rotationX, 45);
        f1601e.append(i.Constraint_android_rotationY, 46);
        f1601e.append(i.Constraint_android_rotation, 60);
        f1601e.append(i.Constraint_android_scaleX, 47);
        f1601e.append(i.Constraint_android_scaleY, 48);
        f1601e.append(i.Constraint_android_transformPivotX, 49);
        f1601e.append(i.Constraint_android_transformPivotY, 50);
        f1601e.append(i.Constraint_android_translationX, 51);
        f1601e.append(i.Constraint_android_translationY, 52);
        f1601e.append(i.Constraint_android_translationZ, 53);
        f1601e.append(i.Constraint_layout_constraintWidth_default, 54);
        f1601e.append(i.Constraint_layout_constraintHeight_default, 55);
        f1601e.append(i.Constraint_layout_constraintWidth_max, 56);
        f1601e.append(i.Constraint_layout_constraintHeight_max, 57);
        f1601e.append(i.Constraint_layout_constraintWidth_min, 58);
        f1601e.append(i.Constraint_layout_constraintHeight_min, 59);
        f1601e.append(i.Constraint_layout_constraintCircle, 61);
        f1601e.append(i.Constraint_layout_constraintCircleRadius, 62);
        f1601e.append(i.Constraint_layout_constraintCircleAngle, 63);
        f1601e.append(i.Constraint_animate_relativeTo, 64);
        f1601e.append(i.Constraint_transitionEasing, 65);
        f1601e.append(i.Constraint_drawPath, 66);
        f1601e.append(i.Constraint_transitionPathRotate, 67);
        f1601e.append(i.Constraint_motionStagger, 79);
        f1601e.append(i.Constraint_android_id, 38);
        f1601e.append(i.Constraint_progress, 68);
        f1601e.append(i.Constraint_layout_constraintWidth_percent, 69);
        f1601e.append(i.Constraint_layout_constraintHeight_percent, 70);
        f1601e.append(i.Constraint_chainUseRtl, 71);
        f1601e.append(i.Constraint_barrierDirection, 72);
        f1601e.append(i.Constraint_barrierMargin, 73);
        f1601e.append(i.Constraint_constraint_referenced_ids, 74);
        f1601e.append(i.Constraint_barrierAllowsGoneWidgets, 75);
        f1601e.append(i.Constraint_pathMotionArc, 76);
        f1601e.append(i.Constraint_layout_constraintTag, 77);
        f1601e.append(i.Constraint_visibilityMode, 78);
        f1601e.append(i.Constraint_layout_constrainedWidth, 80);
        f1601e.append(i.Constraint_layout_constrainedHeight, 81);
    }

    public static int a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    public void b(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f1604c.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.f1604c.containsKey(Integer.valueOf(id))) {
                try {
                    childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                }
            } else if (this.f1603b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1 && this.f1604c.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                a aVar = this.f1604c.get(Integer.valueOf(id));
                if (childAt instanceof Barrier) {
                    aVar.f1608d.d0 = 1;
                }
                int i2 = aVar.f1608d.d0;
                if (i2 != -1 && i2 == 1) {
                    Barrier barrier = (Barrier) childAt;
                    barrier.setId(id);
                    barrier.setType(aVar.f1608d.b0);
                    barrier.setMargin(aVar.f1608d.c0);
                    barrier.setAllowsGoneWidget(aVar.f1608d.j0);
                    b bVar = aVar.f1608d;
                    int[] iArr = bVar.e0;
                    if (iArr != null) {
                        barrier.setReferencedIds(iArr);
                    } else {
                        String str = bVar.f0;
                        if (str != null) {
                            bVar.e0 = d(barrier, str);
                            barrier.setReferencedIds(aVar.f1608d.e0);
                        }
                    }
                }
                ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
                aVar2.a();
                aVar.a(aVar2);
                if (z) {
                    HashMap<String, a> hashMap = aVar.f1610f;
                    Class<?> cls = childAt.getClass();
                    for (String str2 : hashMap.keySet()) {
                        a aVar3 = hashMap.get(str2);
                        String q = c.a.a.a.a.q("set", str2);
                        try {
                            switch (aVar3.f1570b.ordinal()) {
                                case 0:
                                    cls.getMethod(q, Integer.TYPE).invoke(childAt, Integer.valueOf(aVar3.f1571c));
                                    break;
                                case 1:
                                    cls.getMethod(q, Float.TYPE).invoke(childAt, Float.valueOf(aVar3.f1572d));
                                    break;
                                case 2:
                                    cls.getMethod(q, Integer.TYPE).invoke(childAt, Integer.valueOf(aVar3.f1575g));
                                    break;
                                case 3:
                                    Method method = cls.getMethod(q, Drawable.class);
                                    ColorDrawable colorDrawable = new ColorDrawable();
                                    colorDrawable.setColor(aVar3.f1575g);
                                    method.invoke(childAt, colorDrawable);
                                    break;
                                case 4:
                                    cls.getMethod(q, CharSequence.class).invoke(childAt, aVar3.f1573e);
                                    break;
                                case 5:
                                    cls.getMethod(q, Boolean.TYPE).invoke(childAt, Boolean.valueOf(aVar3.f1574f));
                                    break;
                                case 6:
                                    cls.getMethod(q, Float.TYPE).invoke(childAt, Float.valueOf(aVar3.f1572d));
                                    break;
                            }
                        } catch (NoSuchMethodException e2) {
                            e2.getMessage();
                            cls.getName();
                        } catch (IllegalAccessException e3) {
                            cls.getName();
                            e3.printStackTrace();
                        } catch (InvocationTargetException e4) {
                            cls.getName();
                            e4.printStackTrace();
                        }
                    }
                }
                childAt.setLayoutParams(aVar2);
                C0027d dVar = aVar.f1606b;
                if (dVar.f1627c == 0) {
                    childAt.setVisibility(dVar.f1626b);
                }
                childAt.setAlpha(aVar.f1606b.f1628d);
                childAt.setRotation(aVar.f1609e.f1631b);
                childAt.setRotationX(aVar.f1609e.f1632c);
                childAt.setRotationY(aVar.f1609e.f1633d);
                childAt.setScaleX(aVar.f1609e.f1634e);
                childAt.setScaleY(aVar.f1609e.f1635f);
                if (!Float.isNaN(aVar.f1609e.f1636g)) {
                    childAt.setPivotX(aVar.f1609e.f1636g);
                }
                if (!Float.isNaN(aVar.f1609e.h)) {
                    childAt.setPivotY(aVar.f1609e.h);
                }
                childAt.setTranslationX(aVar.f1609e.i);
                childAt.setTranslationY(aVar.f1609e.j);
                childAt.setTranslationZ(aVar.f1609e.k);
                e eVar = aVar.f1609e;
                if (eVar.l) {
                    childAt.setElevation(eVar.m);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar4 = this.f1604c.get(num);
            int i3 = aVar4.f1608d.d0;
            if (i3 != -1 && i3 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                b bVar2 = aVar4.f1608d;
                int[] iArr2 = bVar2.e0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str3 = bVar2.f0;
                    if (str3 != null) {
                        bVar2.e0 = d(barrier2, str3);
                        barrier2.setReferencedIds(aVar4.f1608d.e0);
                    }
                }
                barrier2.setType(aVar4.f1608d.b0);
                barrier2.setMargin(aVar4.f1608d.c0);
                ConstraintLayout.a c2 = constraintLayout.generateDefaultLayoutParams();
                barrier2.i();
                aVar4.a(c2);
                constraintLayout.addView(barrier2, c2);
            }
            if (aVar4.f1608d.f1611a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.a c3 = constraintLayout.generateDefaultLayoutParams();
                aVar4.a(c3);
                constraintLayout.addView(guideline, c3);
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        NoSuchMethodException e2;
        IllegalAccessException e3;
        InvocationTargetException e4;
        a aVar;
        d dVar = this;
        int childCount = constraintLayout.getChildCount();
        dVar.f1604c.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!dVar.f1603b || id != -1) {
                if (!dVar.f1604c.containsKey(Integer.valueOf(id))) {
                    dVar.f1604c.put(Integer.valueOf(id), new a());
                }
                a aVar3 = dVar.f1604c.get(Integer.valueOf(id));
                HashMap<String, a> hashMap = dVar.f1602a;
                HashMap<String, a> hashMap2 = new HashMap<>();
                Class<?> cls = childAt.getClass();
                for (String str : hashMap.keySet()) {
                    a aVar4 = hashMap.get(str);
                    try {
                        if (str.equals("BackgroundColor")) {
                            aVar = new a(aVar4, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor()));
                        } else {
                            try {
                                aVar = new a(aVar4, cls.getMethod("getMap" + str, new Class[0]).invoke(childAt, new Object[0]));
                            } catch (NoSuchMethodException e5) {
                                e2 = e5;
                                e2.printStackTrace();
                            } catch (IllegalAccessException e6) {
                                e3 = e6;
                                e3.printStackTrace();
                            } catch (InvocationTargetException e7) {
                                e4 = e7;
                                e4.printStackTrace();
                            }
                        }
                        hashMap2.put(str, aVar);
                    } catch (NoSuchMethodException e8) {
                        e2 = e8;
                        e2.printStackTrace();
                    } catch (IllegalAccessException e9) {
                        e3 = e9;
                        e3.printStackTrace();
                    } catch (InvocationTargetException e10) {
                        e4 = e10;
                        e4.printStackTrace();
                    }
                }
                aVar3.f1610f = hashMap2;
                aVar3.b(id, aVar2);
                aVar3.f1606b.f1626b = childAt.getVisibility();
                aVar3.f1606b.f1628d = childAt.getAlpha();
                aVar3.f1609e.f1631b = childAt.getRotation();
                aVar3.f1609e.f1632c = childAt.getRotationX();
                aVar3.f1609e.f1633d = childAt.getRotationY();
                aVar3.f1609e.f1634e = childAt.getScaleX();
                aVar3.f1609e.f1635f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                    e eVar = aVar3.f1609e;
                    eVar.f1636g = pivotX;
                    eVar.h = pivotY;
                }
                aVar3.f1609e.i = childAt.getTranslationX();
                aVar3.f1609e.j = childAt.getTranslationY();
                aVar3.f1609e.k = childAt.getTranslationZ();
                e eVar2 = aVar3.f1609e;
                if (eVar2.l) {
                    eVar2.m = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    b bVar = aVar3.f1608d;
                    bVar.j0 = barrier.k.g0;
                    bVar.e0 = barrier.getReferencedIds();
                    aVar3.f1608d.b0 = barrier.getType();
                    aVar3.f1608d.c0 = barrier.getMargin();
                }
                i++;
                dVar = this;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public final int[] d(View view, String str) {
        int i;
        Object d2;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = h.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (d2 = ((ConstraintLayout) view.getParent()).d(0, trim)) != null && (d2 instanceof Integer)) {
                i = ((Integer) d2).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    public final a e(Context context, AttributeSet attributeSet) {
        c cVar;
        String str;
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.Constraint);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index != i.Constraint_android_id) {
                aVar.f1607c.f1618a = true;
                aVar.f1608d.f1612b = true;
                aVar.f1606b.f1625a = true;
                aVar.f1609e.f1630a = true;
            }
            switch (f1601e.get(index)) {
                case 1:
                    b bVar = aVar.f1608d;
                    int resourceId = obtainStyledAttributes.getResourceId(index, bVar.p);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar.p = resourceId;
                    break;
                case 2:
                    b bVar2 = aVar.f1608d;
                    bVar2.G = obtainStyledAttributes.getDimensionPixelSize(index, bVar2.G);
                    break;
                case 3:
                    b bVar3 = aVar.f1608d;
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, bVar3.o);
                    if (resourceId2 == -1) {
                        resourceId2 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar3.o = resourceId2;
                    break;
                case 4:
                    b bVar4 = aVar.f1608d;
                    int resourceId3 = obtainStyledAttributes.getResourceId(index, bVar4.n);
                    if (resourceId3 == -1) {
                        resourceId3 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar4.n = resourceId3;
                    break;
                case 5:
                    aVar.f1608d.w = obtainStyledAttributes.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f1608d;
                    bVar5.A = obtainStyledAttributes.getDimensionPixelOffset(index, bVar5.A);
                    break;
                case 7:
                    b bVar6 = aVar.f1608d;
                    bVar6.B = obtainStyledAttributes.getDimensionPixelOffset(index, bVar6.B);
                    break;
                case 8:
                    b bVar7 = aVar.f1608d;
                    bVar7.H = obtainStyledAttributes.getDimensionPixelSize(index, bVar7.H);
                    break;
                case 9:
                    b bVar8 = aVar.f1608d;
                    int resourceId4 = obtainStyledAttributes.getResourceId(index, bVar8.t);
                    if (resourceId4 == -1) {
                        resourceId4 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar8.t = resourceId4;
                    break;
                case 10:
                    b bVar9 = aVar.f1608d;
                    int resourceId5 = obtainStyledAttributes.getResourceId(index, bVar9.s);
                    if (resourceId5 == -1) {
                        resourceId5 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar9.s = resourceId5;
                    break;
                case 11:
                    b bVar10 = aVar.f1608d;
                    bVar10.M = obtainStyledAttributes.getDimensionPixelSize(index, bVar10.M);
                    break;
                case 12:
                    b bVar11 = aVar.f1608d;
                    bVar11.N = obtainStyledAttributes.getDimensionPixelSize(index, bVar11.N);
                    break;
                case 13:
                    b bVar12 = aVar.f1608d;
                    bVar12.J = obtainStyledAttributes.getDimensionPixelSize(index, bVar12.J);
                    break;
                case 14:
                    b bVar13 = aVar.f1608d;
                    bVar13.L = obtainStyledAttributes.getDimensionPixelSize(index, bVar13.L);
                    break;
                case 15:
                    b bVar14 = aVar.f1608d;
                    bVar14.O = obtainStyledAttributes.getDimensionPixelSize(index, bVar14.O);
                    break;
                case 16:
                    b bVar15 = aVar.f1608d;
                    bVar15.K = obtainStyledAttributes.getDimensionPixelSize(index, bVar15.K);
                    break;
                case 17:
                    b bVar16 = aVar.f1608d;
                    bVar16.f1615e = obtainStyledAttributes.getDimensionPixelOffset(index, bVar16.f1615e);
                    break;
                case 18:
                    b bVar17 = aVar.f1608d;
                    bVar17.f1616f = obtainStyledAttributes.getDimensionPixelOffset(index, bVar17.f1616f);
                    break;
                case 19:
                    b bVar18 = aVar.f1608d;
                    bVar18.f1617g = obtainStyledAttributes.getFloat(index, bVar18.f1617g);
                    break;
                case 20:
                    b bVar19 = aVar.f1608d;
                    bVar19.u = obtainStyledAttributes.getFloat(index, bVar19.u);
                    break;
                case 21:
                    b bVar20 = aVar.f1608d;
                    bVar20.f1614d = obtainStyledAttributes.getLayoutDimension(index, bVar20.f1614d);
                    break;
                case 22:
                    C0027d dVar = aVar.f1606b;
                    dVar.f1626b = obtainStyledAttributes.getInt(index, dVar.f1626b);
                    C0027d dVar2 = aVar.f1606b;
                    dVar2.f1626b = f1600d[dVar2.f1626b];
                    break;
                case 23:
                    b bVar21 = aVar.f1608d;
                    bVar21.f1613c = obtainStyledAttributes.getLayoutDimension(index, bVar21.f1613c);
                    break;
                case 24:
                    b bVar22 = aVar.f1608d;
                    bVar22.D = obtainStyledAttributes.getDimensionPixelSize(index, bVar22.D);
                    break;
                case 25:
                    b bVar23 = aVar.f1608d;
                    int resourceId6 = obtainStyledAttributes.getResourceId(index, bVar23.h);
                    if (resourceId6 == -1) {
                        resourceId6 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar23.h = resourceId6;
                    break;
                case 26:
                    b bVar24 = aVar.f1608d;
                    int resourceId7 = obtainStyledAttributes.getResourceId(index, bVar24.i);
                    if (resourceId7 == -1) {
                        resourceId7 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar24.i = resourceId7;
                    break;
                case 27:
                    b bVar25 = aVar.f1608d;
                    bVar25.C = obtainStyledAttributes.getInt(index, bVar25.C);
                    break;
                case 28:
                    b bVar26 = aVar.f1608d;
                    bVar26.E = obtainStyledAttributes.getDimensionPixelSize(index, bVar26.E);
                    break;
                case 29:
                    b bVar27 = aVar.f1608d;
                    int resourceId8 = obtainStyledAttributes.getResourceId(index, bVar27.j);
                    if (resourceId8 == -1) {
                        resourceId8 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar27.j = resourceId8;
                    break;
                case 30:
                    b bVar28 = aVar.f1608d;
                    int resourceId9 = obtainStyledAttributes.getResourceId(index, bVar28.k);
                    if (resourceId9 == -1) {
                        resourceId9 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar28.k = resourceId9;
                    break;
                case 31:
                    b bVar29 = aVar.f1608d;
                    bVar29.I = obtainStyledAttributes.getDimensionPixelSize(index, bVar29.I);
                    break;
                case 32:
                    b bVar30 = aVar.f1608d;
                    int resourceId10 = obtainStyledAttributes.getResourceId(index, bVar30.q);
                    if (resourceId10 == -1) {
                        resourceId10 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar30.q = resourceId10;
                    break;
                case 33:
                    b bVar31 = aVar.f1608d;
                    int resourceId11 = obtainStyledAttributes.getResourceId(index, bVar31.r);
                    if (resourceId11 == -1) {
                        resourceId11 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar31.r = resourceId11;
                    break;
                case 34:
                    b bVar32 = aVar.f1608d;
                    bVar32.F = obtainStyledAttributes.getDimensionPixelSize(index, bVar32.F);
                    break;
                case 35:
                    b bVar33 = aVar.f1608d;
                    int resourceId12 = obtainStyledAttributes.getResourceId(index, bVar33.m);
                    if (resourceId12 == -1) {
                        resourceId12 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar33.m = resourceId12;
                    break;
                case 36:
                    b bVar34 = aVar.f1608d;
                    int resourceId13 = obtainStyledAttributes.getResourceId(index, bVar34.l);
                    if (resourceId13 == -1) {
                        resourceId13 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar34.l = resourceId13;
                    break;
                case 37:
                    b bVar35 = aVar.f1608d;
                    bVar35.v = obtainStyledAttributes.getFloat(index, bVar35.v);
                    break;
                case 38:
                    aVar.f1605a = obtainStyledAttributes.getResourceId(index, aVar.f1605a);
                    break;
                case 39:
                    b bVar36 = aVar.f1608d;
                    bVar36.Q = obtainStyledAttributes.getFloat(index, bVar36.Q);
                    break;
                case 40:
                    b bVar37 = aVar.f1608d;
                    bVar37.P = obtainStyledAttributes.getFloat(index, bVar37.P);
                    break;
                case 41:
                    b bVar38 = aVar.f1608d;
                    bVar38.R = obtainStyledAttributes.getInt(index, bVar38.R);
                    break;
                case 42:
                    b bVar39 = aVar.f1608d;
                    bVar39.S = obtainStyledAttributes.getInt(index, bVar39.S);
                    break;
                case 43:
                    C0027d dVar3 = aVar.f1606b;
                    dVar3.f1628d = obtainStyledAttributes.getFloat(index, dVar3.f1628d);
                    break;
                case 44:
                    e eVar = aVar.f1609e;
                    eVar.l = true;
                    eVar.m = obtainStyledAttributes.getDimension(index, eVar.m);
                    break;
                case 45:
                    e eVar2 = aVar.f1609e;
                    eVar2.f1632c = obtainStyledAttributes.getFloat(index, eVar2.f1632c);
                    break;
                case 46:
                    e eVar3 = aVar.f1609e;
                    eVar3.f1633d = obtainStyledAttributes.getFloat(index, eVar3.f1633d);
                    break;
                case 47:
                    e eVar4 = aVar.f1609e;
                    eVar4.f1634e = obtainStyledAttributes.getFloat(index, eVar4.f1634e);
                    break;
                case 48:
                    e eVar5 = aVar.f1609e;
                    eVar5.f1635f = obtainStyledAttributes.getFloat(index, eVar5.f1635f);
                    break;
                case 49:
                    e eVar6 = aVar.f1609e;
                    eVar6.f1636g = obtainStyledAttributes.getFloat(index, eVar6.f1636g);
                    break;
                case 50:
                    e eVar7 = aVar.f1609e;
                    eVar7.h = obtainStyledAttributes.getFloat(index, eVar7.h);
                    break;
                case 51:
                    e eVar8 = aVar.f1609e;
                    eVar8.i = obtainStyledAttributes.getDimension(index, eVar8.i);
                    break;
                case 52:
                    e eVar9 = aVar.f1609e;
                    eVar9.j = obtainStyledAttributes.getDimension(index, eVar9.j);
                    break;
                case 53:
                    e eVar10 = aVar.f1609e;
                    eVar10.k = obtainStyledAttributes.getDimension(index, eVar10.k);
                    break;
                case 54:
                    b bVar40 = aVar.f1608d;
                    bVar40.T = obtainStyledAttributes.getInt(index, bVar40.T);
                    break;
                case 55:
                    b bVar41 = aVar.f1608d;
                    bVar41.U = obtainStyledAttributes.getInt(index, bVar41.U);
                    break;
                case 56:
                    b bVar42 = aVar.f1608d;
                    bVar42.V = obtainStyledAttributes.getDimensionPixelSize(index, bVar42.V);
                    break;
                case 57:
                    b bVar43 = aVar.f1608d;
                    bVar43.W = obtainStyledAttributes.getDimensionPixelSize(index, bVar43.W);
                    break;
                case 58:
                    b bVar44 = aVar.f1608d;
                    bVar44.X = obtainStyledAttributes.getDimensionPixelSize(index, bVar44.X);
                    break;
                case 59:
                    b bVar45 = aVar.f1608d;
                    bVar45.Y = obtainStyledAttributes.getDimensionPixelSize(index, bVar45.Y);
                    break;
                case 60:
                    e eVar11 = aVar.f1609e;
                    eVar11.f1631b = obtainStyledAttributes.getFloat(index, eVar11.f1631b);
                    break;
                case 61:
                    b bVar46 = aVar.f1608d;
                    int resourceId14 = obtainStyledAttributes.getResourceId(index, bVar46.x);
                    if (resourceId14 == -1) {
                        resourceId14 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar46.x = resourceId14;
                    break;
                case 62:
                    b bVar47 = aVar.f1608d;
                    bVar47.y = obtainStyledAttributes.getDimensionPixelSize(index, bVar47.y);
                    break;
                case 63:
                    b bVar48 = aVar.f1608d;
                    bVar48.z = obtainStyledAttributes.getFloat(index, bVar48.z);
                    break;
                case 64:
                    c cVar2 = aVar.f1607c;
                    int resourceId15 = obtainStyledAttributes.getResourceId(index, cVar2.f1619b);
                    if (resourceId15 == -1) {
                        resourceId15 = obtainStyledAttributes.getInt(index, -1);
                    }
                    cVar2.f1619b = resourceId15;
                    break;
                case 65:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        cVar = aVar.f1607c;
                        str = obtainStyledAttributes.getString(index);
                    } else {
                        cVar = aVar.f1607c;
                        str = b.g.a.a.a.f1450a[obtainStyledAttributes.getInteger(index, 0)];
                    }
                    cVar.f1620c = str;
                    break;
                case 66:
                    aVar.f1607c.f1622e = obtainStyledAttributes.getInt(index, 0);
                    break;
                case 67:
                    c cVar3 = aVar.f1607c;
                    cVar3.f1624g = obtainStyledAttributes.getFloat(index, cVar3.f1624g);
                    break;
                case 68:
                    C0027d dVar4 = aVar.f1606b;
                    dVar4.f1629e = obtainStyledAttributes.getFloat(index, dVar4.f1629e);
                    break;
                case 69:
                    aVar.f1608d.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f1608d.a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 71:
                    break;
                case 72:
                    b bVar49 = aVar.f1608d;
                    bVar49.b0 = obtainStyledAttributes.getInt(index, bVar49.b0);
                    break;
                case 73:
                    b bVar50 = aVar.f1608d;
                    bVar50.c0 = obtainStyledAttributes.getDimensionPixelSize(index, bVar50.c0);
                    break;
                case 74:
                    aVar.f1608d.f0 = obtainStyledAttributes.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f1608d;
                    bVar51.j0 = obtainStyledAttributes.getBoolean(index, bVar51.j0);
                    break;
                case 76:
                    c cVar4 = aVar.f1607c;
                    cVar4.f1621d = obtainStyledAttributes.getInt(index, cVar4.f1621d);
                    break;
                case 77:
                    aVar.f1608d.g0 = obtainStyledAttributes.getString(index);
                    break;
                case 78:
                    C0027d dVar5 = aVar.f1606b;
                    dVar5.f1627c = obtainStyledAttributes.getInt(index, dVar5.f1627c);
                    break;
                case 79:
                    c cVar5 = aVar.f1607c;
                    cVar5.f1623f = obtainStyledAttributes.getFloat(index, cVar5.f1623f);
                    break;
                case 80:
                    b bVar52 = aVar.f1608d;
                    bVar52.h0 = obtainStyledAttributes.getBoolean(index, bVar52.h0);
                    break;
                case 81:
                    b bVar53 = aVar.f1608d;
                    bVar53.i0 = obtainStyledAttributes.getBoolean(index, bVar53.i0);
                    break;
                default:
                    Integer.toHexString(index);
                    f1601e.get(index);
                    break;
            }
        }
        obtainStyledAttributes.recycle();
        return aVar;
    }

    public void f(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a e2 = e(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        e2.f1608d.f1611a = true;
                    }
                    this.f1604c.put(Integer.valueOf(e2.f1605a), e2);
                }
            }
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }
}
