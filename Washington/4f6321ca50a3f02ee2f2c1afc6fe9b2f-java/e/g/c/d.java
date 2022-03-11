package e.g.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import e.g.c.e;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f1350d = {0, 4, 8};

    /* renamed from: e  reason: collision with root package name */
    public static SparseIntArray f1351e;
    public HashMap<String, a> a = new HashMap<>();
    public boolean b = true;
    public HashMap<Integer, a> c = new HashMap<>();

    public static class a {
        public int a;
        public final C0030d b = new C0030d();
        public final c c = new c();

        /* renamed from: d  reason: collision with root package name */
        public final b f1352d = new b();

        /* renamed from: e  reason: collision with root package name */
        public final e f1353e = new e();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, a> f1354f = new HashMap<>();

        public void a(ConstraintLayout.a aVar) {
            b bVar = this.f1352d;
            aVar.f108d = bVar.f1359h;
            aVar.f109e = bVar.f1360i;
            aVar.f110f = bVar.f1361j;
            aVar.f111g = bVar.f1362k;
            aVar.f112h = bVar.f1363l;
            aVar.f113i = bVar.m;
            aVar.f114j = bVar.n;
            aVar.f115k = bVar.o;
            aVar.f116l = bVar.p;
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
            b bVar2 = this.f1352d;
            aVar.o = bVar2.z;
            aVar.B = bVar2.w;
            aVar.P = bVar2.A;
            aVar.Q = bVar2.B;
            aVar.E = bVar2.P;
            aVar.D = bVar2.Q;
            aVar.G = bVar2.S;
            aVar.F = bVar2.R;
            aVar.S = bVar2.h0;
            aVar.T = bVar2.i0;
            aVar.H = bVar2.T;
            aVar.I = bVar2.U;
            aVar.L = bVar2.V;
            aVar.M = bVar2.W;
            aVar.J = bVar2.X;
            aVar.K = bVar2.Y;
            aVar.N = bVar2.Z;
            aVar.O = bVar2.a0;
            aVar.R = bVar2.C;
            aVar.c = bVar2.f1358g;
            aVar.a = bVar2.f1356e;
            aVar.b = bVar2.f1357f;
            ((ViewGroup.MarginLayoutParams) aVar).width = bVar2.c;
            ((ViewGroup.MarginLayoutParams) aVar).height = bVar2.f1355d;
            String str = bVar2.g0;
            if (str != null) {
                aVar.U = str;
            }
            aVar.setMarginStart(this.f1352d.I);
            aVar.setMarginEnd(this.f1352d.H);
            aVar.a();
        }

        public final void b(int i2, ConstraintLayout.a aVar) {
            this.a = i2;
            b bVar = this.f1352d;
            bVar.f1359h = aVar.f108d;
            bVar.f1360i = aVar.f109e;
            bVar.f1361j = aVar.f110f;
            bVar.f1362k = aVar.f111g;
            bVar.f1363l = aVar.f112h;
            bVar.m = aVar.f113i;
            bVar.n = aVar.f114j;
            bVar.o = aVar.f115k;
            bVar.p = aVar.f116l;
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
            bVar.f1358g = aVar.c;
            bVar.f1356e = aVar.a;
            bVar.f1357f = aVar.b;
            b bVar2 = this.f1352d;
            bVar2.c = ((ViewGroup.MarginLayoutParams) aVar).width;
            bVar2.f1355d = ((ViewGroup.MarginLayoutParams) aVar).height;
            bVar2.D = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
            bVar2.E = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
            bVar2.F = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
            bVar2.G = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            bVar2.P = aVar.E;
            bVar2.Q = aVar.D;
            bVar2.S = aVar.G;
            bVar2.R = aVar.F;
            bVar2.h0 = aVar.S;
            bVar2.i0 = aVar.T;
            bVar2.T = aVar.H;
            bVar2.U = aVar.I;
            bVar2.V = aVar.L;
            bVar2.W = aVar.M;
            bVar2.X = aVar.J;
            bVar2.Y = aVar.K;
            bVar2.Z = aVar.N;
            bVar2.a0 = aVar.O;
            bVar2.g0 = aVar.U;
            bVar2.K = aVar.u;
            bVar2.M = aVar.w;
            bVar2.J = aVar.t;
            bVar2.L = aVar.v;
            b bVar3 = this.f1352d;
            bVar3.O = aVar.x;
            bVar3.N = aVar.y;
            bVar3.H = aVar.getMarginEnd();
            this.f1352d.I = aVar.getMarginStart();
        }

        public final void c(int i2, e.a aVar) {
            b(i2, aVar);
            this.b.f1369d = aVar.m0;
            e eVar = this.f1353e;
            eVar.b = aVar.p0;
            eVar.c = aVar.q0;
            eVar.f1371d = aVar.r0;
            eVar.f1372e = aVar.s0;
            eVar.f1373f = aVar.t0;
            eVar.f1374g = aVar.u0;
            eVar.f1375h = aVar.v0;
            eVar.f1376i = aVar.w0;
            eVar.f1377j = aVar.x0;
            eVar.f1378k = aVar.y0;
            eVar.m = aVar.o0;
            eVar.f1379l = aVar.n0;
        }

        public Object clone() {
            a aVar = new a();
            b bVar = aVar.f1352d;
            b bVar2 = this.f1352d;
            Objects.requireNonNull(bVar);
            bVar.a = bVar2.a;
            bVar.c = bVar2.c;
            bVar.b = bVar2.b;
            bVar.f1355d = bVar2.f1355d;
            bVar.f1356e = bVar2.f1356e;
            bVar.f1357f = bVar2.f1357f;
            bVar.f1358g = bVar2.f1358g;
            bVar.f1359h = bVar2.f1359h;
            bVar.f1360i = bVar2.f1360i;
            bVar.f1361j = bVar2.f1361j;
            bVar.f1362k = bVar2.f1362k;
            bVar.f1363l = bVar2.f1363l;
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
            c cVar = aVar.c;
            c cVar2 = this.c;
            Objects.requireNonNull(cVar);
            cVar.a = cVar2.a;
            cVar.b = cVar2.b;
            cVar.c = cVar2.c;
            cVar.f1365d = cVar2.f1365d;
            cVar.f1366e = cVar2.f1366e;
            cVar.f1368g = cVar2.f1368g;
            cVar.f1367f = cVar2.f1367f;
            C0030d dVar = aVar.b;
            C0030d dVar2 = this.b;
            Objects.requireNonNull(dVar);
            dVar.a = dVar2.a;
            dVar.b = dVar2.b;
            dVar.f1369d = dVar2.f1369d;
            dVar.f1370e = dVar2.f1370e;
            dVar.c = dVar2.c;
            e eVar = aVar.f1353e;
            e eVar2 = this.f1353e;
            Objects.requireNonNull(eVar);
            eVar.a = eVar2.a;
            eVar.b = eVar2.b;
            eVar.c = eVar2.c;
            eVar.f1371d = eVar2.f1371d;
            eVar.f1372e = eVar2.f1372e;
            eVar.f1373f = eVar2.f1373f;
            eVar.f1374g = eVar2.f1374g;
            eVar.f1375h = eVar2.f1375h;
            eVar.f1376i = eVar2.f1376i;
            eVar.f1377j = eVar2.f1377j;
            eVar.f1378k = eVar2.f1378k;
            eVar.f1379l = eVar2.f1379l;
            eVar.m = eVar2.m;
            aVar.a = this.a;
            return aVar;
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
        public boolean a = false;
        public float a0 = 1.0f;
        public boolean b = false;
        public int b0 = -1;
        public int c;
        public int c0 = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f1355d;
        public int d0 = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f1356e = -1;
        public int[] e0;

        /* renamed from: f  reason: collision with root package name */
        public int f1357f = -1;
        public String f0;

        /* renamed from: g  reason: collision with root package name */
        public float f1358g = -1.0f;
        public String g0;

        /* renamed from: h  reason: collision with root package name */
        public int f1359h = -1;
        public boolean h0 = false;

        /* renamed from: i  reason: collision with root package name */
        public int f1360i = -1;
        public boolean i0 = false;

        /* renamed from: j  reason: collision with root package name */
        public int f1361j = -1;
        public boolean j0 = true;

        /* renamed from: k  reason: collision with root package name */
        public int f1362k = -1;

        /* renamed from: l  reason: collision with root package name */
        public int f1363l = -1;
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
            sparseIntArray.append(R$styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            k0.append(R$styleable.Layout_layout_constraintLeft_toRightOf, 25);
            k0.append(R$styleable.Layout_layout_constraintRight_toLeftOf, 28);
            k0.append(R$styleable.Layout_layout_constraintRight_toRightOf, 29);
            k0.append(R$styleable.Layout_layout_constraintTop_toTopOf, 35);
            k0.append(R$styleable.Layout_layout_constraintTop_toBottomOf, 34);
            k0.append(R$styleable.Layout_layout_constraintBottom_toTopOf, 4);
            k0.append(R$styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            k0.append(R$styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            k0.append(R$styleable.Layout_layout_editor_absoluteX, 6);
            k0.append(R$styleable.Layout_layout_editor_absoluteY, 7);
            k0.append(R$styleable.Layout_layout_constraintGuide_begin, 17);
            k0.append(R$styleable.Layout_layout_constraintGuide_end, 18);
            k0.append(R$styleable.Layout_layout_constraintGuide_percent, 19);
            k0.append(R$styleable.Layout_android_orientation, 26);
            k0.append(R$styleable.Layout_layout_constraintStart_toEndOf, 31);
            k0.append(R$styleable.Layout_layout_constraintStart_toStartOf, 32);
            k0.append(R$styleable.Layout_layout_constraintEnd_toStartOf, 10);
            k0.append(R$styleable.Layout_layout_constraintEnd_toEndOf, 9);
            k0.append(R$styleable.Layout_layout_goneMarginLeft, 13);
            k0.append(R$styleable.Layout_layout_goneMarginTop, 16);
            k0.append(R$styleable.Layout_layout_goneMarginRight, 14);
            k0.append(R$styleable.Layout_layout_goneMarginBottom, 11);
            k0.append(R$styleable.Layout_layout_goneMarginStart, 15);
            k0.append(R$styleable.Layout_layout_goneMarginEnd, 12);
            k0.append(R$styleable.Layout_layout_constraintVertical_weight, 38);
            k0.append(R$styleable.Layout_layout_constraintHorizontal_weight, 37);
            k0.append(R$styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            k0.append(R$styleable.Layout_layout_constraintVertical_chainStyle, 40);
            k0.append(R$styleable.Layout_layout_constraintHorizontal_bias, 20);
            k0.append(R$styleable.Layout_layout_constraintVertical_bias, 36);
            k0.append(R$styleable.Layout_layout_constraintDimensionRatio, 5);
            k0.append(R$styleable.Layout_layout_constraintLeft_creator, 76);
            k0.append(R$styleable.Layout_layout_constraintTop_creator, 76);
            k0.append(R$styleable.Layout_layout_constraintRight_creator, 76);
            k0.append(R$styleable.Layout_layout_constraintBottom_creator, 76);
            k0.append(R$styleable.Layout_layout_constraintBaseline_creator, 76);
            k0.append(R$styleable.Layout_android_layout_marginLeft, 23);
            k0.append(R$styleable.Layout_android_layout_marginRight, 27);
            k0.append(R$styleable.Layout_android_layout_marginStart, 30);
            k0.append(R$styleable.Layout_android_layout_marginEnd, 8);
            k0.append(R$styleable.Layout_android_layout_marginTop, 33);
            k0.append(R$styleable.Layout_android_layout_marginBottom, 2);
            k0.append(R$styleable.Layout_android_layout_width, 22);
            k0.append(R$styleable.Layout_android_layout_height, 21);
            k0.append(R$styleable.Layout_layout_constraintCircle, 61);
            k0.append(R$styleable.Layout_layout_constraintCircleRadius, 62);
            k0.append(R$styleable.Layout_layout_constraintCircleAngle, 63);
            k0.append(R$styleable.Layout_layout_constraintWidth_percent, 69);
            k0.append(R$styleable.Layout_layout_constraintHeight_percent, 70);
            k0.append(R$styleable.Layout_chainUseRtl, 71);
            k0.append(R$styleable.Layout_barrierDirection, 72);
            k0.append(R$styleable.Layout_barrierMargin, 73);
            k0.append(R$styleable.Layout_constraint_referenced_ids, 74);
            k0.append(R$styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(Context context, AttributeSet attributeSet) {
            String str;
            StringBuilder sb;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Layout);
            this.b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = k0.get(index);
                if (i3 == 80) {
                    this.h0 = obtainStyledAttributes.getBoolean(index, this.h0);
                } else if (i3 != 81) {
                    switch (i3) {
                        case 1:
                            int i4 = this.p;
                            int[] iArr = d.f1350d;
                            int resourceId = obtainStyledAttributes.getResourceId(index, i4);
                            if (resourceId == -1) {
                                resourceId = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.p = resourceId;
                            continue;
                        case 2:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            continue;
                        case 3:
                            int i5 = this.o;
                            int[] iArr2 = d.f1350d;
                            int resourceId2 = obtainStyledAttributes.getResourceId(index, i5);
                            if (resourceId2 == -1) {
                                resourceId2 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.o = resourceId2;
                            continue;
                        case 4:
                            int i6 = this.n;
                            int[] iArr3 = d.f1350d;
                            int resourceId3 = obtainStyledAttributes.getResourceId(index, i6);
                            if (resourceId3 == -1) {
                                resourceId3 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.n = resourceId3;
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
                            int i7 = this.t;
                            int[] iArr4 = d.f1350d;
                            int resourceId4 = obtainStyledAttributes.getResourceId(index, i7);
                            if (resourceId4 == -1) {
                                resourceId4 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.t = resourceId4;
                            continue;
                        case 10:
                            int i8 = this.s;
                            int[] iArr5 = d.f1350d;
                            int resourceId5 = obtainStyledAttributes.getResourceId(index, i8);
                            if (resourceId5 == -1) {
                                resourceId5 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.s = resourceId5;
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
                            this.f1356e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1356e);
                            continue;
                        case 18:
                            this.f1357f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1357f);
                            continue;
                        case 19:
                            this.f1358g = obtainStyledAttributes.getFloat(index, this.f1358g);
                            continue;
                        case 20:
                            this.u = obtainStyledAttributes.getFloat(index, this.u);
                            continue;
                        case 21:
                            this.f1355d = obtainStyledAttributes.getLayoutDimension(index, this.f1355d);
                            continue;
                        case 22:
                            this.c = obtainStyledAttributes.getLayoutDimension(index, this.c);
                            continue;
                        case 23:
                            this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                            continue;
                        case 24:
                            int i9 = this.f1359h;
                            int[] iArr6 = d.f1350d;
                            int resourceId6 = obtainStyledAttributes.getResourceId(index, i9);
                            if (resourceId6 == -1) {
                                resourceId6 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1359h = resourceId6;
                            continue;
                        case 25:
                            int i10 = this.f1360i;
                            int[] iArr7 = d.f1350d;
                            int resourceId7 = obtainStyledAttributes.getResourceId(index, i10);
                            if (resourceId7 == -1) {
                                resourceId7 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1360i = resourceId7;
                            continue;
                        case 26:
                            this.C = obtainStyledAttributes.getInt(index, this.C);
                            continue;
                        case 27:
                            this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                            continue;
                        case 28:
                            int i11 = this.f1361j;
                            int[] iArr8 = d.f1350d;
                            int resourceId8 = obtainStyledAttributes.getResourceId(index, i11);
                            if (resourceId8 == -1) {
                                resourceId8 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1361j = resourceId8;
                            continue;
                        case 29:
                            int i12 = this.f1362k;
                            int[] iArr9 = d.f1350d;
                            int resourceId9 = obtainStyledAttributes.getResourceId(index, i12);
                            if (resourceId9 == -1) {
                                resourceId9 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1362k = resourceId9;
                            continue;
                        case 30:
                            this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                            continue;
                        case 31:
                            int i13 = this.q;
                            int[] iArr10 = d.f1350d;
                            int resourceId10 = obtainStyledAttributes.getResourceId(index, i13);
                            if (resourceId10 == -1) {
                                resourceId10 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.q = resourceId10;
                            continue;
                        case 32:
                            int i14 = this.r;
                            int[] iArr11 = d.f1350d;
                            int resourceId11 = obtainStyledAttributes.getResourceId(index, i14);
                            if (resourceId11 == -1) {
                                resourceId11 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.r = resourceId11;
                            continue;
                        case 33:
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            continue;
                        case 34:
                            int i15 = this.m;
                            int[] iArr12 = d.f1350d;
                            int resourceId12 = obtainStyledAttributes.getResourceId(index, i15);
                            if (resourceId12 == -1) {
                                resourceId12 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.m = resourceId12;
                            continue;
                        case 35:
                            int i16 = this.f1363l;
                            int[] iArr13 = d.f1350d;
                            int resourceId13 = obtainStyledAttributes.getResourceId(index, i16);
                            if (resourceId13 == -1) {
                                resourceId13 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1363l = resourceId13;
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
                                    continue;
                                default:
                                    switch (i3) {
                                        case 61:
                                            int i17 = this.x;
                                            int[] iArr14 = d.f1350d;
                                            int resourceId14 = obtainStyledAttributes.getResourceId(index, i17);
                                            if (resourceId14 == -1) {
                                                resourceId14 = obtainStyledAttributes.getInt(index, -1);
                                            }
                                            this.x = resourceId14;
                                            continue;
                                        case 62:
                                            this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                                            continue;
                                        case 63:
                                            this.z = obtainStyledAttributes.getFloat(index, this.z);
                                            continue;
                                            continue;
                                        default:
                                            switch (i3) {
                                                case 69:
                                                    this.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    break;
                                                case 72:
                                                    this.b0 = obtainStyledAttributes.getInt(index, this.b0);
                                                    break;
                                                case 73:
                                                    this.c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                                    break;
                                                case 74:
                                                    this.f0 = obtainStyledAttributes.getString(index);
                                                    break;
                                                case 75:
                                                    this.j0 = obtainStyledAttributes.getBoolean(index, this.j0);
                                                    break;
                                                case 76:
                                                    sb = new StringBuilder();
                                                    str = "unused attribute 0x";
                                                    sb.append(str);
                                                    sb.append(Integer.toHexString(index));
                                                    sb.append("   ");
                                                    sb.append(k0.get(index));
                                                    Log.w("ConstraintSet", sb.toString());
                                                    break;
                                                case 77:
                                                    this.g0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                default:
                                                    sb = new StringBuilder();
                                                    str = "Unknown attribute 0x";
                                                    sb.append(str);
                                                    sb.append(Integer.toHexString(index));
                                                    sb.append("   ");
                                                    sb.append(k0.get(index));
                                                    Log.w("ConstraintSet", sb.toString());
                                                    break;
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

        /* renamed from: h  reason: collision with root package name */
        public static SparseIntArray f1364h;
        public boolean a = false;
        public int b = -1;
        public String c = null;

        /* renamed from: d  reason: collision with root package name */
        public int f1365d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f1366e = 0;

        /* renamed from: f  reason: collision with root package name */
        public float f1367f = Float.NaN;

        /* renamed from: g  reason: collision with root package name */
        public float f1368g = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1364h = sparseIntArray;
            sparseIntArray.append(R$styleable.Motion_motionPathRotate, 1);
            f1364h.append(R$styleable.Motion_pathMotionArc, 2);
            f1364h.append(R$styleable.Motion_transitionEasing, 3);
            f1364h.append(R$styleable.Motion_drawPath, 4);
            f1364h.append(R$styleable.Motion_animate_relativeTo, 5);
            f1364h.append(R$styleable.Motion_motionStagger, 6);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Motion);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (f1364h.get(index)) {
                    case 1:
                        this.f1368g = obtainStyledAttributes.getFloat(index, this.f1368g);
                        break;
                    case 2:
                        this.f1365d = obtainStyledAttributes.getInt(index, this.f1365d);
                        break;
                    case 3:
                        this.c = obtainStyledAttributes.peekValue(index).type == 3 ? obtainStyledAttributes.getString(index) : e.g.a.a.a.a[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    case 4:
                        this.f1366e = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        int i3 = this.b;
                        int[] iArr = d.f1350d;
                        int resourceId = obtainStyledAttributes.getResourceId(index, i3);
                        if (resourceId == -1) {
                            resourceId = obtainStyledAttributes.getInt(index, -1);
                        }
                        this.b = resourceId;
                        break;
                    case 6:
                        this.f1367f = obtainStyledAttributes.getFloat(index, this.f1367f);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: e.g.c.d$d  reason: collision with other inner class name */
    public static class C0030d {
        public boolean a = false;
        public int b = 0;
        public int c = 0;

        /* renamed from: d  reason: collision with root package name */
        public float f1369d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f1370e = Float.NaN;

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PropertySet);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.PropertySet_android_alpha) {
                    this.f1369d = obtainStyledAttributes.getFloat(index, this.f1369d);
                } else if (index == R$styleable.PropertySet_android_visibility) {
                    int i3 = obtainStyledAttributes.getInt(index, this.b);
                    this.b = i3;
                    int[] iArr = d.f1350d;
                    this.b = d.f1350d[i3];
                } else if (index == R$styleable.PropertySet_visibilityMode) {
                    this.c = obtainStyledAttributes.getInt(index, this.c);
                } else if (index == R$styleable.PropertySet_motionProgress) {
                    this.f1370e = obtainStyledAttributes.getFloat(index, this.f1370e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class e {
        public static SparseIntArray n;
        public boolean a = false;
        public float b = 0.0f;
        public float c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f1371d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f1372e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f1373f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f1374g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public float f1375h = Float.NaN;

        /* renamed from: i  reason: collision with root package name */
        public float f1376i = 0.0f;

        /* renamed from: j  reason: collision with root package name */
        public float f1377j = 0.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f1378k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public boolean f1379l = false;
        public float m = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            n = sparseIntArray;
            sparseIntArray.append(R$styleable.Transform_android_rotation, 1);
            n.append(R$styleable.Transform_android_rotationX, 2);
            n.append(R$styleable.Transform_android_rotationY, 3);
            n.append(R$styleable.Transform_android_scaleX, 4);
            n.append(R$styleable.Transform_android_scaleY, 5);
            n.append(R$styleable.Transform_android_transformPivotX, 6);
            n.append(R$styleable.Transform_android_transformPivotY, 7);
            n.append(R$styleable.Transform_android_translationX, 8);
            n.append(R$styleable.Transform_android_translationY, 9);
            n.append(R$styleable.Transform_android_translationZ, 10);
            n.append(R$styleable.Transform_android_elevation, 11);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transform);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (n.get(index)) {
                    case 1:
                        this.b = obtainStyledAttributes.getFloat(index, this.b);
                        break;
                    case 2:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 3:
                        this.f1371d = obtainStyledAttributes.getFloat(index, this.f1371d);
                        break;
                    case 4:
                        this.f1372e = obtainStyledAttributes.getFloat(index, this.f1372e);
                        break;
                    case 5:
                        this.f1373f = obtainStyledAttributes.getFloat(index, this.f1373f);
                        break;
                    case 6:
                        this.f1374g = obtainStyledAttributes.getDimension(index, this.f1374g);
                        break;
                    case 7:
                        this.f1375h = obtainStyledAttributes.getDimension(index, this.f1375h);
                        break;
                    case 8:
                        this.f1376i = obtainStyledAttributes.getDimension(index, this.f1376i);
                        break;
                    case 9:
                        this.f1377j = obtainStyledAttributes.getDimension(index, this.f1377j);
                        break;
                    case 10:
                        this.f1378k = obtainStyledAttributes.getDimension(index, this.f1378k);
                        break;
                    case 11:
                        this.f1379l = true;
                        this.m = obtainStyledAttributes.getDimension(index, this.m);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1351e = sparseIntArray;
        sparseIntArray.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        f1351e.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        f1351e.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        f1351e.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        f1351e.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        f1351e.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        f1351e.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        f1351e.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        f1351e.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f1351e.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        f1351e.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        f1351e.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        f1351e.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        f1351e.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        f1351e.append(R$styleable.Constraint_android_orientation, 27);
        f1351e.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        f1351e.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        f1351e.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        f1351e.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        f1351e.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        f1351e.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        f1351e.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        f1351e.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        f1351e.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        f1351e.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        f1351e.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        f1351e.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        f1351e.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f1351e.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        f1351e.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        f1351e.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        f1351e.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        f1351e.append(R$styleable.Constraint_layout_constraintLeft_creator, 82);
        f1351e.append(R$styleable.Constraint_layout_constraintTop_creator, 82);
        f1351e.append(R$styleable.Constraint_layout_constraintRight_creator, 82);
        f1351e.append(R$styleable.Constraint_layout_constraintBottom_creator, 82);
        f1351e.append(R$styleable.Constraint_layout_constraintBaseline_creator, 82);
        f1351e.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        f1351e.append(R$styleable.Constraint_android_layout_marginRight, 28);
        f1351e.append(R$styleable.Constraint_android_layout_marginStart, 31);
        f1351e.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        f1351e.append(R$styleable.Constraint_android_layout_marginTop, 34);
        f1351e.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        f1351e.append(R$styleable.Constraint_android_layout_width, 23);
        f1351e.append(R$styleable.Constraint_android_layout_height, 21);
        f1351e.append(R$styleable.Constraint_android_visibility, 22);
        f1351e.append(R$styleable.Constraint_android_alpha, 43);
        f1351e.append(R$styleable.Constraint_android_elevation, 44);
        f1351e.append(R$styleable.Constraint_android_rotationX, 45);
        f1351e.append(R$styleable.Constraint_android_rotationY, 46);
        f1351e.append(R$styleable.Constraint_android_rotation, 60);
        f1351e.append(R$styleable.Constraint_android_scaleX, 47);
        f1351e.append(R$styleable.Constraint_android_scaleY, 48);
        f1351e.append(R$styleable.Constraint_android_transformPivotX, 49);
        f1351e.append(R$styleable.Constraint_android_transformPivotY, 50);
        f1351e.append(R$styleable.Constraint_android_translationX, 51);
        f1351e.append(R$styleable.Constraint_android_translationY, 52);
        f1351e.append(R$styleable.Constraint_android_translationZ, 53);
        f1351e.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        f1351e.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        f1351e.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        f1351e.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        f1351e.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        f1351e.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        f1351e.append(R$styleable.Constraint_layout_constraintCircle, 61);
        f1351e.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        f1351e.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        f1351e.append(R$styleable.Constraint_animate_relativeTo, 64);
        f1351e.append(R$styleable.Constraint_transitionEasing, 65);
        f1351e.append(R$styleable.Constraint_drawPath, 66);
        f1351e.append(R$styleable.Constraint_transitionPathRotate, 67);
        f1351e.append(R$styleable.Constraint_motionStagger, 79);
        f1351e.append(R$styleable.Constraint_android_id, 38);
        f1351e.append(R$styleable.Constraint_motionProgress, 68);
        f1351e.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        f1351e.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        f1351e.append(R$styleable.Constraint_chainUseRtl, 71);
        f1351e.append(R$styleable.Constraint_barrierDirection, 72);
        f1351e.append(R$styleable.Constraint_barrierMargin, 73);
        f1351e.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        f1351e.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        f1351e.append(R$styleable.Constraint_pathMotionArc, 76);
        f1351e.append(R$styleable.Constraint_layout_constraintTag, 77);
        f1351e.append(R$styleable.Constraint_visibilityMode, 78);
        f1351e.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        f1351e.append(R$styleable.Constraint_layout_constrainedHeight, 81);
    }

    public void a(ConstraintLayout constraintLayout, boolean z) {
        int i2;
        Iterator<String> it;
        NoSuchMethodException e2;
        IllegalAccessException e3;
        InvocationTargetException e4;
        String str;
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.c.keySet());
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = constraintLayout.getChildAt(i3);
            int id = childAt.getId();
            if (!this.c.containsKey(Integer.valueOf(id))) {
                StringBuilder h2 = f.a.a.a.a.h("id unknown ");
                try {
                    str = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    str = "UNKNOWN";
                }
                h2.append(str);
                Log.w("ConstraintSet", h2.toString());
            } else if (this.b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1 && this.c.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                a aVar = this.c.get(Integer.valueOf(id));
                if (childAt instanceof Barrier) {
                    aVar.f1352d.d0 = 1;
                }
                int i4 = aVar.f1352d.d0;
                if (i4 != -1 && i4 == 1) {
                    Barrier barrier = (Barrier) childAt;
                    barrier.setId(id);
                    barrier.setType(aVar.f1352d.b0);
                    barrier.setMargin(aVar.f1352d.c0);
                    barrier.setAllowsGoneWidget(aVar.f1352d.j0);
                    b bVar = aVar.f1352d;
                    int[] iArr = bVar.e0;
                    if (iArr != null) {
                        barrier.setReferencedIds(iArr);
                    } else {
                        String str2 = bVar.f0;
                        if (str2 != null) {
                            bVar.e0 = c(barrier, str2);
                            barrier.setReferencedIds(aVar.f1352d.e0);
                        }
                    }
                }
                ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
                aVar2.a();
                aVar.a(aVar2);
                if (z) {
                    HashMap<String, a> hashMap = aVar.f1354f;
                    Class<?> cls = childAt.getClass();
                    Iterator<String> it2 = hashMap.keySet().iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        a aVar3 = hashMap.get(next);
                        String t = f.a.a.a.a.t("set", next);
                        try {
                            switch (aVar3.b.ordinal()) {
                                case 0:
                                    it = it2;
                                    cls.getMethod(t, Integer.TYPE).invoke(childAt, Integer.valueOf(aVar3.c));
                                    break;
                                case 1:
                                    it = it2;
                                    cls.getMethod(t, Float.TYPE).invoke(childAt, Float.valueOf(aVar3.f1331d));
                                    break;
                                case 2:
                                    it = it2;
                                    cls.getMethod(t, Integer.TYPE).invoke(childAt, Integer.valueOf(aVar3.f1334g));
                                    break;
                                case 3:
                                    it = it2;
                                    Method method = cls.getMethod(t, Drawable.class);
                                    ColorDrawable colorDrawable = new ColorDrawable();
                                    colorDrawable.setColor(aVar3.f1334g);
                                    method.invoke(childAt, colorDrawable);
                                    break;
                                case 4:
                                    it = it2;
                                    cls.getMethod(t, CharSequence.class).invoke(childAt, aVar3.f1332e);
                                    break;
                                case 5:
                                    it = it2;
                                    cls.getMethod(t, Boolean.TYPE).invoke(childAt, Boolean.valueOf(aVar3.f1333f));
                                    break;
                                case 6:
                                    it = it2;
                                    try {
                                        cls.getMethod(t, Float.TYPE).invoke(childAt, Float.valueOf(aVar3.f1331d));
                                    } catch (NoSuchMethodException e5) {
                                        e2 = e5;
                                        Log.e("TransitionLayout", e2.getMessage());
                                        Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(cls.getName());
                                        sb.append(" must have a method ");
                                        sb.append(t);
                                        Log.e("TransitionLayout", sb.toString());
                                        childCount = childCount;
                                        hashMap = hashMap;
                                        it2 = it;
                                    } catch (IllegalAccessException e6) {
                                        e3 = e6;
                                        StringBuilder j2 = f.a.a.a.a.j(" Custom Attribute \"", next, "\" not found on ");
                                        j2.append(cls.getName());
                                        Log.e("TransitionLayout", j2.toString());
                                        e3.printStackTrace();
                                        childCount = childCount;
                                        hashMap = hashMap;
                                        it2 = it;
                                    } catch (InvocationTargetException e7) {
                                        e4 = e7;
                                        StringBuilder j3 = f.a.a.a.a.j(" Custom Attribute \"", next, "\" not found on ");
                                        j3.append(cls.getName());
                                        Log.e("TransitionLayout", j3.toString());
                                        e4.printStackTrace();
                                        childCount = childCount;
                                        hashMap = hashMap;
                                        it2 = it;
                                    }
                                default:
                                    it = it2;
                                    break;
                            }
                        } catch (NoSuchMethodException e8) {
                            e2 = e8;
                            it = it2;
                            Log.e("TransitionLayout", e2.getMessage());
                            Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(cls.getName());
                            sb2.append(" must have a method ");
                            sb2.append(t);
                            Log.e("TransitionLayout", sb2.toString());
                            childCount = childCount;
                            hashMap = hashMap;
                            it2 = it;
                        } catch (IllegalAccessException e9) {
                            e3 = e9;
                            it = it2;
                            StringBuilder j22 = f.a.a.a.a.j(" Custom Attribute \"", next, "\" not found on ");
                            j22.append(cls.getName());
                            Log.e("TransitionLayout", j22.toString());
                            e3.printStackTrace();
                            childCount = childCount;
                            hashMap = hashMap;
                            it2 = it;
                        } catch (InvocationTargetException e10) {
                            e4 = e10;
                            it = it2;
                            StringBuilder j32 = f.a.a.a.a.j(" Custom Attribute \"", next, "\" not found on ");
                            j32.append(cls.getName());
                            Log.e("TransitionLayout", j32.toString());
                            e4.printStackTrace();
                            childCount = childCount;
                            hashMap = hashMap;
                            it2 = it;
                        }
                        childCount = childCount;
                        hashMap = hashMap;
                        it2 = it;
                    }
                }
                i2 = childCount;
                childAt.setLayoutParams(aVar2);
                C0030d dVar = aVar.b;
                if (dVar.c == 0) {
                    childAt.setVisibility(dVar.b);
                }
                childAt.setAlpha(aVar.b.f1369d);
                childAt.setRotation(aVar.f1353e.b);
                childAt.setRotationX(aVar.f1353e.c);
                childAt.setRotationY(aVar.f1353e.f1371d);
                childAt.setScaleX(aVar.f1353e.f1372e);
                childAt.setScaleY(aVar.f1353e.f1373f);
                if (!Float.isNaN(aVar.f1353e.f1374g)) {
                    childAt.setPivotX(aVar.f1353e.f1374g);
                }
                if (!Float.isNaN(aVar.f1353e.f1375h)) {
                    childAt.setPivotY(aVar.f1353e.f1375h);
                }
                childAt.setTranslationX(aVar.f1353e.f1376i);
                childAt.setTranslationY(aVar.f1353e.f1377j);
                childAt.setTranslationZ(aVar.f1353e.f1378k);
                e eVar = aVar.f1353e;
                if (eVar.f1379l) {
                    childAt.setElevation(eVar.m);
                }
                i3++;
                childCount = i2;
            }
            i2 = childCount;
            i3++;
            childCount = i2;
        }
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            Integer num = (Integer) it3.next();
            a aVar4 = this.c.get(num);
            int i5 = aVar4.f1352d.d0;
            if (i5 != -1 && i5 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                b bVar2 = aVar4.f1352d;
                int[] iArr2 = bVar2.e0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str3 = bVar2.f0;
                    if (str3 != null) {
                        bVar2.e0 = c(barrier2, str3);
                        barrier2.setReferencedIds(aVar4.f1352d.e0);
                    }
                }
                barrier2.setType(aVar4.f1352d.b0);
                barrier2.setMargin(aVar4.f1352d.c0);
                ConstraintLayout.a b2 = constraintLayout.generateDefaultLayoutParams();
                barrier2.k();
                aVar4.a(b2);
                constraintLayout.addView(barrier2, b2);
            }
            if (aVar4.f1352d.a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.a b3 = constraintLayout.generateDefaultLayoutParams();
                aVar4.a(b3);
                constraintLayout.addView(guideline, b3);
            }
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        NoSuchMethodException e2;
        IllegalAccessException e3;
        InvocationTargetException e4;
        a aVar;
        d dVar = this;
        int childCount = constraintLayout.getChildCount();
        dVar.c.clear();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!dVar.b || id != -1) {
                if (!dVar.c.containsKey(Integer.valueOf(id))) {
                    dVar.c.put(Integer.valueOf(id), new a());
                }
                a aVar3 = dVar.c.get(Integer.valueOf(id));
                HashMap<String, a> hashMap = dVar.a;
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
                aVar3.f1354f = hashMap2;
                aVar3.b(id, aVar2);
                aVar3.b.b = childAt.getVisibility();
                aVar3.b.f1369d = childAt.getAlpha();
                aVar3.f1353e.b = childAt.getRotation();
                aVar3.f1353e.c = childAt.getRotationX();
                aVar3.f1353e.f1371d = childAt.getRotationY();
                aVar3.f1353e.f1372e = childAt.getScaleX();
                aVar3.f1353e.f1373f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                    e eVar = aVar3.f1353e;
                    eVar.f1374g = pivotX;
                    eVar.f1375h = pivotY;
                }
                aVar3.f1353e.f1376i = childAt.getTranslationX();
                aVar3.f1353e.f1377j = childAt.getTranslationY();
                aVar3.f1353e.f1378k = childAt.getTranslationZ();
                e eVar2 = aVar3.f1353e;
                if (eVar2.f1379l) {
                    eVar2.m = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    b bVar = aVar3.f1352d;
                    bVar.j0 = barrier.f98k.o0;
                    bVar.e0 = barrier.getReferencedIds();
                    aVar3.f1352d.b0 = barrier.getType();
                    aVar3.f1352d.c0 = barrier.getMargin();
                }
                i2++;
                dVar = this;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public final int[] c(View view, String str) {
        int i2;
        Object c2;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < split.length) {
            String trim = split[i3].trim();
            try {
                i2 = R$id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i2 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (c2 = ((ConstraintLayout) view.getParent()).c(0, trim)) != null && (c2 instanceof Integer)) {
                i2 = ((Integer) c2).intValue();
            }
            iArr[i4] = i2;
            i3++;
            i4++;
        }
        return i4 != split.length ? Arrays.copyOf(iArr, i4) : iArr;
    }

    public final a d(Context context, AttributeSet attributeSet) {
        String str;
        StringBuilder sb;
        c cVar;
        String str2;
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Constraint);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (!(index == R$styleable.Constraint_android_id || R$styleable.Constraint_android_layout_marginStart == index || R$styleable.Constraint_android_layout_marginEnd == index)) {
                aVar.c.a = true;
                aVar.f1352d.b = true;
                aVar.b.a = true;
                aVar.f1353e.a = true;
            }
            switch (f1351e.get(index)) {
                case 1:
                    b bVar = aVar.f1352d;
                    int resourceId = obtainStyledAttributes.getResourceId(index, bVar.p);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar.p = resourceId;
                    continue;
                case 2:
                    b bVar2 = aVar.f1352d;
                    bVar2.G = obtainStyledAttributes.getDimensionPixelSize(index, bVar2.G);
                    continue;
                case 3:
                    b bVar3 = aVar.f1352d;
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, bVar3.o);
                    if (resourceId2 == -1) {
                        resourceId2 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar3.o = resourceId2;
                    continue;
                case 4:
                    b bVar4 = aVar.f1352d;
                    int resourceId3 = obtainStyledAttributes.getResourceId(index, bVar4.n);
                    if (resourceId3 == -1) {
                        resourceId3 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar4.n = resourceId3;
                    continue;
                case 5:
                    aVar.f1352d.w = obtainStyledAttributes.getString(index);
                    continue;
                case 6:
                    b bVar5 = aVar.f1352d;
                    bVar5.A = obtainStyledAttributes.getDimensionPixelOffset(index, bVar5.A);
                    continue;
                case 7:
                    b bVar6 = aVar.f1352d;
                    bVar6.B = obtainStyledAttributes.getDimensionPixelOffset(index, bVar6.B);
                    continue;
                case 8:
                    b bVar7 = aVar.f1352d;
                    bVar7.H = obtainStyledAttributes.getDimensionPixelSize(index, bVar7.H);
                    continue;
                case 9:
                    b bVar8 = aVar.f1352d;
                    int resourceId4 = obtainStyledAttributes.getResourceId(index, bVar8.t);
                    if (resourceId4 == -1) {
                        resourceId4 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar8.t = resourceId4;
                    continue;
                case 10:
                    b bVar9 = aVar.f1352d;
                    int resourceId5 = obtainStyledAttributes.getResourceId(index, bVar9.s);
                    if (resourceId5 == -1) {
                        resourceId5 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar9.s = resourceId5;
                    continue;
                case 11:
                    b bVar10 = aVar.f1352d;
                    bVar10.M = obtainStyledAttributes.getDimensionPixelSize(index, bVar10.M);
                    continue;
                case 12:
                    b bVar11 = aVar.f1352d;
                    bVar11.N = obtainStyledAttributes.getDimensionPixelSize(index, bVar11.N);
                    continue;
                case 13:
                    b bVar12 = aVar.f1352d;
                    bVar12.J = obtainStyledAttributes.getDimensionPixelSize(index, bVar12.J);
                    continue;
                case 14:
                    b bVar13 = aVar.f1352d;
                    bVar13.L = obtainStyledAttributes.getDimensionPixelSize(index, bVar13.L);
                    continue;
                case 15:
                    b bVar14 = aVar.f1352d;
                    bVar14.O = obtainStyledAttributes.getDimensionPixelSize(index, bVar14.O);
                    continue;
                case 16:
                    b bVar15 = aVar.f1352d;
                    bVar15.K = obtainStyledAttributes.getDimensionPixelSize(index, bVar15.K);
                    continue;
                case 17:
                    b bVar16 = aVar.f1352d;
                    bVar16.f1356e = obtainStyledAttributes.getDimensionPixelOffset(index, bVar16.f1356e);
                    continue;
                case 18:
                    b bVar17 = aVar.f1352d;
                    bVar17.f1357f = obtainStyledAttributes.getDimensionPixelOffset(index, bVar17.f1357f);
                    continue;
                case 19:
                    b bVar18 = aVar.f1352d;
                    bVar18.f1358g = obtainStyledAttributes.getFloat(index, bVar18.f1358g);
                    continue;
                case 20:
                    b bVar19 = aVar.f1352d;
                    bVar19.u = obtainStyledAttributes.getFloat(index, bVar19.u);
                    continue;
                case 21:
                    b bVar20 = aVar.f1352d;
                    bVar20.f1355d = obtainStyledAttributes.getLayoutDimension(index, bVar20.f1355d);
                    continue;
                case 22:
                    C0030d dVar = aVar.b;
                    dVar.b = obtainStyledAttributes.getInt(index, dVar.b);
                    C0030d dVar2 = aVar.b;
                    dVar2.b = f1350d[dVar2.b];
                    continue;
                case 23:
                    b bVar21 = aVar.f1352d;
                    bVar21.c = obtainStyledAttributes.getLayoutDimension(index, bVar21.c);
                    continue;
                case 24:
                    b bVar22 = aVar.f1352d;
                    bVar22.D = obtainStyledAttributes.getDimensionPixelSize(index, bVar22.D);
                    continue;
                case 25:
                    b bVar23 = aVar.f1352d;
                    int resourceId6 = obtainStyledAttributes.getResourceId(index, bVar23.f1359h);
                    if (resourceId6 == -1) {
                        resourceId6 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar23.f1359h = resourceId6;
                    continue;
                case 26:
                    b bVar24 = aVar.f1352d;
                    int resourceId7 = obtainStyledAttributes.getResourceId(index, bVar24.f1360i);
                    if (resourceId7 == -1) {
                        resourceId7 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar24.f1360i = resourceId7;
                    continue;
                case 27:
                    b bVar25 = aVar.f1352d;
                    bVar25.C = obtainStyledAttributes.getInt(index, bVar25.C);
                    continue;
                case 28:
                    b bVar26 = aVar.f1352d;
                    bVar26.E = obtainStyledAttributes.getDimensionPixelSize(index, bVar26.E);
                    continue;
                case 29:
                    b bVar27 = aVar.f1352d;
                    int resourceId8 = obtainStyledAttributes.getResourceId(index, bVar27.f1361j);
                    if (resourceId8 == -1) {
                        resourceId8 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar27.f1361j = resourceId8;
                    continue;
                case 30:
                    b bVar28 = aVar.f1352d;
                    int resourceId9 = obtainStyledAttributes.getResourceId(index, bVar28.f1362k);
                    if (resourceId9 == -1) {
                        resourceId9 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar28.f1362k = resourceId9;
                    continue;
                case 31:
                    b bVar29 = aVar.f1352d;
                    bVar29.I = obtainStyledAttributes.getDimensionPixelSize(index, bVar29.I);
                    continue;
                case 32:
                    b bVar30 = aVar.f1352d;
                    int resourceId10 = obtainStyledAttributes.getResourceId(index, bVar30.q);
                    if (resourceId10 == -1) {
                        resourceId10 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar30.q = resourceId10;
                    continue;
                case 33:
                    b bVar31 = aVar.f1352d;
                    int resourceId11 = obtainStyledAttributes.getResourceId(index, bVar31.r);
                    if (resourceId11 == -1) {
                        resourceId11 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar31.r = resourceId11;
                    continue;
                case 34:
                    b bVar32 = aVar.f1352d;
                    bVar32.F = obtainStyledAttributes.getDimensionPixelSize(index, bVar32.F);
                    continue;
                case 35:
                    b bVar33 = aVar.f1352d;
                    int resourceId12 = obtainStyledAttributes.getResourceId(index, bVar33.m);
                    if (resourceId12 == -1) {
                        resourceId12 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar33.m = resourceId12;
                    continue;
                case 36:
                    b bVar34 = aVar.f1352d;
                    int resourceId13 = obtainStyledAttributes.getResourceId(index, bVar34.f1363l);
                    if (resourceId13 == -1) {
                        resourceId13 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar34.f1363l = resourceId13;
                    continue;
                case 37:
                    b bVar35 = aVar.f1352d;
                    bVar35.v = obtainStyledAttributes.getFloat(index, bVar35.v);
                    continue;
                case 38:
                    aVar.a = obtainStyledAttributes.getResourceId(index, aVar.a);
                    continue;
                case 39:
                    b bVar36 = aVar.f1352d;
                    bVar36.Q = obtainStyledAttributes.getFloat(index, bVar36.Q);
                    continue;
                case 40:
                    b bVar37 = aVar.f1352d;
                    bVar37.P = obtainStyledAttributes.getFloat(index, bVar37.P);
                    continue;
                case 41:
                    b bVar38 = aVar.f1352d;
                    bVar38.R = obtainStyledAttributes.getInt(index, bVar38.R);
                    continue;
                case 42:
                    b bVar39 = aVar.f1352d;
                    bVar39.S = obtainStyledAttributes.getInt(index, bVar39.S);
                    continue;
                case 43:
                    C0030d dVar3 = aVar.b;
                    dVar3.f1369d = obtainStyledAttributes.getFloat(index, dVar3.f1369d);
                    continue;
                case 44:
                    e eVar = aVar.f1353e;
                    eVar.f1379l = true;
                    eVar.m = obtainStyledAttributes.getDimension(index, eVar.m);
                    continue;
                case 45:
                    e eVar2 = aVar.f1353e;
                    eVar2.c = obtainStyledAttributes.getFloat(index, eVar2.c);
                    continue;
                case 46:
                    e eVar3 = aVar.f1353e;
                    eVar3.f1371d = obtainStyledAttributes.getFloat(index, eVar3.f1371d);
                    continue;
                case 47:
                    e eVar4 = aVar.f1353e;
                    eVar4.f1372e = obtainStyledAttributes.getFloat(index, eVar4.f1372e);
                    continue;
                case 48:
                    e eVar5 = aVar.f1353e;
                    eVar5.f1373f = obtainStyledAttributes.getFloat(index, eVar5.f1373f);
                    continue;
                case 49:
                    e eVar6 = aVar.f1353e;
                    eVar6.f1374g = obtainStyledAttributes.getDimension(index, eVar6.f1374g);
                    continue;
                case 50:
                    e eVar7 = aVar.f1353e;
                    eVar7.f1375h = obtainStyledAttributes.getDimension(index, eVar7.f1375h);
                    continue;
                case 51:
                    e eVar8 = aVar.f1353e;
                    eVar8.f1376i = obtainStyledAttributes.getDimension(index, eVar8.f1376i);
                    continue;
                case 52:
                    e eVar9 = aVar.f1353e;
                    eVar9.f1377j = obtainStyledAttributes.getDimension(index, eVar9.f1377j);
                    continue;
                case 53:
                    e eVar10 = aVar.f1353e;
                    eVar10.f1378k = obtainStyledAttributes.getDimension(index, eVar10.f1378k);
                    continue;
                case 54:
                    b bVar40 = aVar.f1352d;
                    bVar40.T = obtainStyledAttributes.getInt(index, bVar40.T);
                    continue;
                case 55:
                    b bVar41 = aVar.f1352d;
                    bVar41.U = obtainStyledAttributes.getInt(index, bVar41.U);
                    continue;
                case 56:
                    b bVar42 = aVar.f1352d;
                    bVar42.V = obtainStyledAttributes.getDimensionPixelSize(index, bVar42.V);
                    continue;
                case 57:
                    b bVar43 = aVar.f1352d;
                    bVar43.W = obtainStyledAttributes.getDimensionPixelSize(index, bVar43.W);
                    continue;
                case 58:
                    b bVar44 = aVar.f1352d;
                    bVar44.X = obtainStyledAttributes.getDimensionPixelSize(index, bVar44.X);
                    continue;
                case 59:
                    b bVar45 = aVar.f1352d;
                    bVar45.Y = obtainStyledAttributes.getDimensionPixelSize(index, bVar45.Y);
                    continue;
                case 60:
                    e eVar11 = aVar.f1353e;
                    eVar11.b = obtainStyledAttributes.getFloat(index, eVar11.b);
                    continue;
                case 61:
                    b bVar46 = aVar.f1352d;
                    int resourceId14 = obtainStyledAttributes.getResourceId(index, bVar46.x);
                    if (resourceId14 == -1) {
                        resourceId14 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar46.x = resourceId14;
                    continue;
                case 62:
                    b bVar47 = aVar.f1352d;
                    bVar47.y = obtainStyledAttributes.getDimensionPixelSize(index, bVar47.y);
                    continue;
                case 63:
                    b bVar48 = aVar.f1352d;
                    bVar48.z = obtainStyledAttributes.getFloat(index, bVar48.z);
                    continue;
                case 64:
                    c cVar2 = aVar.c;
                    int resourceId15 = obtainStyledAttributes.getResourceId(index, cVar2.b);
                    if (resourceId15 == -1) {
                        resourceId15 = obtainStyledAttributes.getInt(index, -1);
                    }
                    cVar2.b = resourceId15;
                    continue;
                case 65:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        cVar = aVar.c;
                        str2 = obtainStyledAttributes.getString(index);
                    } else {
                        cVar = aVar.c;
                        str2 = e.g.a.a.a.a[obtainStyledAttributes.getInteger(index, 0)];
                    }
                    cVar.c = str2;
                    continue;
                case 66:
                    aVar.c.f1366e = obtainStyledAttributes.getInt(index, 0);
                    continue;
                case 67:
                    c cVar3 = aVar.c;
                    cVar3.f1368g = obtainStyledAttributes.getFloat(index, cVar3.f1368g);
                    continue;
                case 68:
                    C0030d dVar4 = aVar.b;
                    dVar4.f1370e = obtainStyledAttributes.getFloat(index, dVar4.f1370e);
                    continue;
                case 69:
                    aVar.f1352d.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                    continue;
                case 70:
                    aVar.f1352d.a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                    continue;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    continue;
                case 72:
                    b bVar49 = aVar.f1352d;
                    bVar49.b0 = obtainStyledAttributes.getInt(index, bVar49.b0);
                    continue;
                case 73:
                    b bVar50 = aVar.f1352d;
                    bVar50.c0 = obtainStyledAttributes.getDimensionPixelSize(index, bVar50.c0);
                    continue;
                case 74:
                    aVar.f1352d.f0 = obtainStyledAttributes.getString(index);
                    continue;
                case 75:
                    b bVar51 = aVar.f1352d;
                    bVar51.j0 = obtainStyledAttributes.getBoolean(index, bVar51.j0);
                    continue;
                case 76:
                    c cVar4 = aVar.c;
                    cVar4.f1365d = obtainStyledAttributes.getInt(index, cVar4.f1365d);
                    continue;
                case 77:
                    aVar.f1352d.g0 = obtainStyledAttributes.getString(index);
                    continue;
                case 78:
                    C0030d dVar5 = aVar.b;
                    dVar5.c = obtainStyledAttributes.getInt(index, dVar5.c);
                    continue;
                case 79:
                    c cVar5 = aVar.c;
                    cVar5.f1367f = obtainStyledAttributes.getFloat(index, cVar5.f1367f);
                    continue;
                case 80:
                    b bVar52 = aVar.f1352d;
                    bVar52.h0 = obtainStyledAttributes.getBoolean(index, bVar52.h0);
                    continue;
                case 81:
                    b bVar53 = aVar.f1352d;
                    bVar53.i0 = obtainStyledAttributes.getBoolean(index, bVar53.i0);
                    continue;
                case 82:
                    sb = new StringBuilder();
                    str = "unused attribute 0x";
                    break;
                default:
                    sb = new StringBuilder();
                    str = "Unknown attribute 0x";
                    break;
            }
            sb.append(str);
            sb.append(Integer.toHexString(index));
            sb.append("   ");
            sb.append(f1351e.get(index));
            Log.w("ConstraintSet", sb.toString());
        }
        obtainStyledAttributes.recycle();
        return aVar;
    }

    public void e(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a d2 = d(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        d2.f1352d.a = true;
                    }
                    this.c.put(Integer.valueOf(d2.a), d2);
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}
