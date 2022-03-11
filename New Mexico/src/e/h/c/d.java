package e.h.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import e.b.a.m;
import e.h.c.e;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class d {

    /* renamed from: d */
    public static final int[] f1481d = {0, 4, 8};

    /* renamed from: e */
    public static SparseIntArray f1482e = new SparseIntArray();

    /* renamed from: f */
    public static SparseIntArray f1483f = new SparseIntArray();
    public HashMap<String, a> a = new HashMap<>();
    public boolean b = true;
    public HashMap<Integer, a> c = new HashMap<>();

    /* loaded from: classes.dex */
    public static class a {
        public int a;
        public final C0035d b = new C0035d();
        public final c c = new c();

        /* renamed from: d */
        public final b f1484d = new b();

        /* renamed from: e */
        public final e f1485e = new e();

        /* renamed from: f */
        public HashMap<String, a> f1486f = new HashMap<>();

        /* renamed from: g */
        public C0034a f1487g;

        /* renamed from: e.h.c.d$a$a */
        /* loaded from: classes.dex */
        public static class C0034a {
            public int[] a = new int[10];
            public int[] b = new int[10];
            public int c = 0;

            /* renamed from: d */
            public int[] f1488d = new int[10];

            /* renamed from: e */
            public float[] f1489e = new float[10];

            /* renamed from: f */
            public int f1490f = 0;

            /* renamed from: g */
            public int[] f1491g = new int[5];

            /* renamed from: h */
            public String[] f1492h = new String[5];

            /* renamed from: i */
            public int f1493i = 0;

            /* renamed from: j */
            public int[] f1494j = new int[4];

            /* renamed from: k */
            public boolean[] f1495k = new boolean[4];

            /* renamed from: l */
            public int f1496l = 0;

            public void a(int i2, float f2) {
                int i3 = this.f1490f;
                int[] iArr = this.f1488d;
                if (i3 >= iArr.length) {
                    this.f1488d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f1489e;
                    this.f1489e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f1488d;
                int i4 = this.f1490f;
                iArr2[i4] = i2;
                float[] fArr2 = this.f1489e;
                this.f1490f = i4 + 1;
                fArr2[i4] = f2;
            }

            public void b(int i2, int i3) {
                int i4 = this.c;
                int[] iArr = this.a;
                if (i4 >= iArr.length) {
                    this.a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.b;
                    this.b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.a;
                int i5 = this.c;
                iArr3[i5] = i2;
                int[] iArr4 = this.b;
                this.c = i5 + 1;
                iArr4[i5] = i3;
            }

            public void c(int i2, String str) {
                int i3 = this.f1493i;
                int[] iArr = this.f1491g;
                if (i3 >= iArr.length) {
                    this.f1491g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f1492h;
                    this.f1492h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f1491g;
                int i4 = this.f1493i;
                iArr2[i4] = i2;
                String[] strArr2 = this.f1492h;
                this.f1493i = i4 + 1;
                strArr2[i4] = str;
            }

            public void d(int i2, boolean z) {
                int i3 = this.f1496l;
                int[] iArr = this.f1494j;
                if (i3 >= iArr.length) {
                    this.f1494j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f1495k;
                    this.f1495k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f1494j;
                int i4 = this.f1496l;
                iArr2[i4] = i2;
                boolean[] zArr2 = this.f1495k;
                this.f1496l = i4 + 1;
                zArr2[i4] = z;
            }
        }

        public void a(ConstraintLayout.a aVar) {
            b bVar = this.f1484d;
            aVar.f120d = bVar.f1501h;
            aVar.f121e = bVar.f1502i;
            aVar.f122f = bVar.f1503j;
            aVar.f123g = bVar.f1504k;
            aVar.f124h = bVar.f1505l;
            aVar.f125i = bVar.m;
            aVar.f126j = bVar.n;
            aVar.f127k = bVar.o;
            aVar.f128l = bVar.p;
            aVar.m = bVar.q;
            aVar.n = bVar.r;
            aVar.r = bVar.s;
            aVar.s = bVar.t;
            aVar.t = bVar.u;
            aVar.u = bVar.v;
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = bVar.F;
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = bVar.G;
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = bVar.H;
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = bVar.I;
            aVar.z = bVar.R;
            aVar.A = bVar.Q;
            aVar.w = bVar.N;
            aVar.y = bVar.P;
            aVar.D = bVar.w;
            aVar.E = bVar.x;
            b bVar2 = this.f1484d;
            aVar.o = bVar2.z;
            aVar.p = bVar2.A;
            aVar.q = bVar2.B;
            aVar.F = bVar2.y;
            aVar.S = bVar2.C;
            aVar.T = bVar2.D;
            aVar.H = bVar2.T;
            aVar.G = bVar2.U;
            aVar.J = bVar2.W;
            aVar.I = bVar2.V;
            aVar.V = bVar2.l0;
            aVar.W = bVar2.m0;
            aVar.K = bVar2.X;
            aVar.L = bVar2.Y;
            aVar.O = bVar2.Z;
            aVar.P = bVar2.a0;
            aVar.M = bVar2.b0;
            aVar.N = bVar2.c0;
            aVar.Q = bVar2.d0;
            aVar.R = bVar2.e0;
            aVar.U = bVar2.E;
            aVar.c = bVar2.f1500g;
            aVar.a = bVar2.f1498e;
            aVar.b = bVar2.f1499f;
            ((ViewGroup.MarginLayoutParams) aVar).width = bVar2.c;
            b bVar3 = this.f1484d;
            ((ViewGroup.MarginLayoutParams) aVar).height = bVar3.f1497d;
            String str = bVar3.k0;
            if (str != null) {
                aVar.X = str;
            }
            aVar.Y = bVar3.o0;
            aVar.setMarginStart(bVar3.K);
            aVar.setMarginEnd(this.f1484d.J);
            aVar.a();
        }

        public final void b(int i2, ConstraintLayout.a aVar) {
            this.a = i2;
            b bVar = this.f1484d;
            bVar.f1501h = aVar.f120d;
            bVar.f1502i = aVar.f121e;
            bVar.f1503j = aVar.f122f;
            bVar.f1504k = aVar.f123g;
            bVar.f1505l = aVar.f124h;
            bVar.m = aVar.f125i;
            bVar.n = aVar.f126j;
            bVar.o = aVar.f127k;
            bVar.p = aVar.f128l;
            bVar.q = aVar.m;
            bVar.r = aVar.n;
            bVar.s = aVar.r;
            bVar.t = aVar.s;
            bVar.u = aVar.t;
            bVar.v = aVar.u;
            bVar.w = aVar.D;
            bVar.x = aVar.E;
            bVar.y = aVar.F;
            bVar.z = aVar.o;
            bVar.A = aVar.p;
            bVar.B = aVar.q;
            bVar.C = aVar.S;
            bVar.D = aVar.T;
            bVar.E = aVar.U;
            bVar.f1500g = aVar.c;
            b bVar2 = this.f1484d;
            bVar2.f1498e = aVar.a;
            bVar2.f1499f = aVar.b;
            bVar2.c = ((ViewGroup.MarginLayoutParams) aVar).width;
            bVar2.f1497d = ((ViewGroup.MarginLayoutParams) aVar).height;
            bVar2.F = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
            bVar2.G = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
            bVar2.H = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
            bVar2.I = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            bVar2.L = aVar.C;
            bVar2.T = aVar.H;
            bVar2.U = aVar.G;
            bVar2.W = aVar.J;
            bVar2.V = aVar.I;
            bVar2.l0 = aVar.V;
            bVar2.m0 = aVar.W;
            bVar2.X = aVar.K;
            bVar2.Y = aVar.L;
            bVar2.Z = aVar.O;
            bVar2.a0 = aVar.P;
            bVar2.b0 = aVar.M;
            bVar2.c0 = aVar.N;
            bVar2.d0 = aVar.Q;
            bVar2.e0 = aVar.R;
            bVar2.k0 = aVar.X;
            bVar2.N = aVar.w;
            b bVar3 = this.f1484d;
            bVar3.P = aVar.y;
            bVar3.M = aVar.v;
            bVar3.O = aVar.x;
            bVar3.R = aVar.z;
            bVar3.Q = aVar.A;
            bVar3.S = aVar.B;
            bVar3.o0 = aVar.Y;
            bVar3.J = aVar.getMarginEnd();
            this.f1484d.K = aVar.getMarginStart();
        }

        public final void c(int i2, e.a aVar) {
            b(i2, aVar);
            this.b.f1515d = aVar.q0;
            e eVar = this.f1485e;
            eVar.b = aVar.t0;
            eVar.c = aVar.u0;
            eVar.f1517d = aVar.v0;
            eVar.f1518e = aVar.w0;
            eVar.f1519f = aVar.x0;
            eVar.f1520g = aVar.y0;
            eVar.f1521h = aVar.z0;
            eVar.f1523j = aVar.A0;
            eVar.f1524k = aVar.B0;
            eVar.f1525l = aVar.C0;
            eVar.n = aVar.s0;
            eVar.m = aVar.r0;
        }

        public Object clone() {
            a aVar = new a();
            b bVar = aVar.f1484d;
            b bVar2 = this.f1484d;
            Objects.requireNonNull(bVar);
            bVar.a = bVar2.a;
            bVar.c = bVar2.c;
            bVar.b = bVar2.b;
            bVar.f1497d = bVar2.f1497d;
            bVar.f1498e = bVar2.f1498e;
            bVar.f1499f = bVar2.f1499f;
            bVar.f1500g = bVar2.f1500g;
            bVar.f1501h = bVar2.f1501h;
            bVar.f1502i = bVar2.f1502i;
            bVar.f1503j = bVar2.f1503j;
            bVar.f1504k = bVar2.f1504k;
            bVar.f1505l = bVar2.f1505l;
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
            bVar.e0 = bVar2.e0;
            bVar.f0 = bVar2.f0;
            bVar.g0 = bVar2.g0;
            bVar.h0 = bVar2.h0;
            bVar.k0 = bVar2.k0;
            int[] iArr = bVar2.i0;
            if (iArr != null) {
                bVar.i0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                bVar.i0 = null;
            }
            bVar.j0 = bVar2.j0;
            bVar.l0 = bVar2.l0;
            bVar.m0 = bVar2.m0;
            bVar.n0 = bVar2.n0;
            bVar.o0 = bVar2.o0;
            c cVar = aVar.c;
            c cVar2 = this.c;
            Objects.requireNonNull(cVar);
            cVar.a = cVar2.a;
            cVar.b = cVar2.b;
            cVar.f1506d = cVar2.f1506d;
            cVar.f1507e = cVar2.f1507e;
            cVar.f1508f = cVar2.f1508f;
            cVar.f1511i = cVar2.f1511i;
            cVar.f1509g = cVar2.f1509g;
            cVar.f1510h = cVar2.f1510h;
            C0035d dVar = aVar.b;
            C0035d dVar2 = this.b;
            Objects.requireNonNull(dVar);
            dVar.a = dVar2.a;
            dVar.b = dVar2.b;
            dVar.f1515d = dVar2.f1515d;
            dVar.f1516e = dVar2.f1516e;
            dVar.c = dVar2.c;
            e eVar = aVar.f1485e;
            e eVar2 = this.f1485e;
            Objects.requireNonNull(eVar);
            eVar.a = eVar2.a;
            eVar.b = eVar2.b;
            eVar.c = eVar2.c;
            eVar.f1517d = eVar2.f1517d;
            eVar.f1518e = eVar2.f1518e;
            eVar.f1519f = eVar2.f1519f;
            eVar.f1520g = eVar2.f1520g;
            eVar.f1521h = eVar2.f1521h;
            eVar.f1522i = eVar2.f1522i;
            eVar.f1523j = eVar2.f1523j;
            eVar.f1524k = eVar2.f1524k;
            eVar.f1525l = eVar2.f1525l;
            eVar.m = eVar2.m;
            eVar.n = eVar2.n;
            aVar.a = this.a;
            aVar.f1487g = this.f1487g;
            return aVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static SparseIntArray p0;
        public int c;

        /* renamed from: d */
        public int f1497d;
        public int[] i0;
        public String j0;
        public String k0;
        public boolean a = false;
        public boolean b = false;

        /* renamed from: e */
        public int f1498e = -1;

        /* renamed from: f */
        public int f1499f = -1;

        /* renamed from: g */
        public float f1500g = -1.0f;

        /* renamed from: h */
        public int f1501h = -1;

        /* renamed from: i */
        public int f1502i = -1;

        /* renamed from: j */
        public int f1503j = -1;

        /* renamed from: k */
        public int f1504k = -1;

        /* renamed from: l */
        public int f1505l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public float w = 0.5f;
        public float x = 0.5f;
        public String y = null;
        public int z = -1;
        public int A = 0;
        public float B = 0.0f;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = 0;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = Integer.MIN_VALUE;
        public int N = Integer.MIN_VALUE;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public float T = -1.0f;
        public float U = -1.0f;
        public int V = 0;
        public int W = 0;
        public int X = 0;
        public int Y = 0;
        public int Z = -1;
        public int a0 = -1;
        public int b0 = -1;
        public int c0 = -1;
        public float d0 = 1.0f;
        public float e0 = 1.0f;
        public int f0 = -1;
        public int g0 = 0;
        public int h0 = -1;
        public boolean l0 = false;
        public boolean m0 = false;
        public boolean n0 = true;
        public int o0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            p0 = sparseIntArray;
            sparseIntArray.append(R$styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            p0.append(R$styleable.Layout_layout_constraintLeft_toRightOf, 25);
            p0.append(R$styleable.Layout_layout_constraintRight_toLeftOf, 28);
            p0.append(R$styleable.Layout_layout_constraintRight_toRightOf, 29);
            p0.append(R$styleable.Layout_layout_constraintTop_toTopOf, 35);
            p0.append(R$styleable.Layout_layout_constraintTop_toBottomOf, 34);
            p0.append(R$styleable.Layout_layout_constraintBottom_toTopOf, 4);
            p0.append(R$styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            p0.append(R$styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            p0.append(R$styleable.Layout_layout_editor_absoluteX, 6);
            p0.append(R$styleable.Layout_layout_editor_absoluteY, 7);
            p0.append(R$styleable.Layout_layout_constraintGuide_begin, 17);
            p0.append(R$styleable.Layout_layout_constraintGuide_end, 18);
            p0.append(R$styleable.Layout_layout_constraintGuide_percent, 19);
            p0.append(R$styleable.Layout_android_orientation, 26);
            p0.append(R$styleable.Layout_layout_constraintStart_toEndOf, 31);
            p0.append(R$styleable.Layout_layout_constraintStart_toStartOf, 32);
            p0.append(R$styleable.Layout_layout_constraintEnd_toStartOf, 10);
            p0.append(R$styleable.Layout_layout_constraintEnd_toEndOf, 9);
            p0.append(R$styleable.Layout_layout_goneMarginLeft, 13);
            p0.append(R$styleable.Layout_layout_goneMarginTop, 16);
            p0.append(R$styleable.Layout_layout_goneMarginRight, 14);
            p0.append(R$styleable.Layout_layout_goneMarginBottom, 11);
            p0.append(R$styleable.Layout_layout_goneMarginStart, 15);
            p0.append(R$styleable.Layout_layout_goneMarginEnd, 12);
            p0.append(R$styleable.Layout_layout_constraintVertical_weight, 38);
            p0.append(R$styleable.Layout_layout_constraintHorizontal_weight, 37);
            p0.append(R$styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            p0.append(R$styleable.Layout_layout_constraintVertical_chainStyle, 40);
            p0.append(R$styleable.Layout_layout_constraintHorizontal_bias, 20);
            p0.append(R$styleable.Layout_layout_constraintVertical_bias, 36);
            p0.append(R$styleable.Layout_layout_constraintDimensionRatio, 5);
            p0.append(R$styleable.Layout_layout_constraintLeft_creator, 76);
            p0.append(R$styleable.Layout_layout_constraintTop_creator, 76);
            p0.append(R$styleable.Layout_layout_constraintRight_creator, 76);
            p0.append(R$styleable.Layout_layout_constraintBottom_creator, 76);
            p0.append(R$styleable.Layout_layout_constraintBaseline_creator, 76);
            p0.append(R$styleable.Layout_android_layout_marginLeft, 23);
            p0.append(R$styleable.Layout_android_layout_marginRight, 27);
            p0.append(R$styleable.Layout_android_layout_marginStart, 30);
            p0.append(R$styleable.Layout_android_layout_marginEnd, 8);
            p0.append(R$styleable.Layout_android_layout_marginTop, 33);
            p0.append(R$styleable.Layout_android_layout_marginBottom, 2);
            p0.append(R$styleable.Layout_android_layout_width, 22);
            p0.append(R$styleable.Layout_android_layout_height, 21);
            p0.append(R$styleable.Layout_layout_constraintWidth, 41);
            p0.append(R$styleable.Layout_layout_constraintHeight, 42);
            p0.append(R$styleable.Layout_layout_constrainedWidth, 41);
            p0.append(R$styleable.Layout_layout_constrainedHeight, 42);
            p0.append(R$styleable.Layout_layout_wrapBehaviorInParent, 97);
            p0.append(R$styleable.Layout_layout_constraintCircle, 61);
            p0.append(R$styleable.Layout_layout_constraintCircleRadius, 62);
            p0.append(R$styleable.Layout_layout_constraintCircleAngle, 63);
            p0.append(R$styleable.Layout_layout_constraintWidth_percent, 69);
            p0.append(R$styleable.Layout_layout_constraintHeight_percent, 70);
            p0.append(R$styleable.Layout_chainUseRtl, 71);
            p0.append(R$styleable.Layout_barrierDirection, 72);
            p0.append(R$styleable.Layout_barrierMargin, 73);
            p0.append(R$styleable.Layout_constraint_referenced_ids, 74);
            p0.append(R$styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Layout);
            this.b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = p0.get(index);
                if (i3 == 80) {
                    this.l0 = obtainStyledAttributes.getBoolean(index, this.l0);
                } else if (i3 == 81) {
                    this.m0 = obtainStyledAttributes.getBoolean(index, this.m0);
                } else if (i3 != 97) {
                    switch (i3) {
                        case 1:
                            int i4 = this.p;
                            int[] iArr = d.f1481d;
                            int resourceId = obtainStyledAttributes.getResourceId(index, i4);
                            if (resourceId == -1) {
                                resourceId = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.p = resourceId;
                            continue;
                        case 2:
                            this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                            continue;
                        case 3:
                            int i5 = this.o;
                            int[] iArr2 = d.f1481d;
                            int resourceId2 = obtainStyledAttributes.getResourceId(index, i5);
                            if (resourceId2 == -1) {
                                resourceId2 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.o = resourceId2;
                            continue;
                        case 4:
                            int i6 = this.n;
                            int[] iArr3 = d.f1481d;
                            int resourceId3 = obtainStyledAttributes.getResourceId(index, i6);
                            if (resourceId3 == -1) {
                                resourceId3 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.n = resourceId3;
                            continue;
                        case 5:
                            this.y = obtainStyledAttributes.getString(index);
                            continue;
                        case 6:
                            this.C = obtainStyledAttributes.getDimensionPixelOffset(index, this.C);
                            continue;
                        case 7:
                            this.D = obtainStyledAttributes.getDimensionPixelOffset(index, this.D);
                            continue;
                        case 8:
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            continue;
                        case 9:
                            int i7 = this.v;
                            int[] iArr4 = d.f1481d;
                            int resourceId4 = obtainStyledAttributes.getResourceId(index, i7);
                            if (resourceId4 == -1) {
                                resourceId4 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.v = resourceId4;
                            continue;
                        case 10:
                            int i8 = this.u;
                            int[] iArr5 = d.f1481d;
                            int resourceId5 = obtainStyledAttributes.getResourceId(index, i8);
                            if (resourceId5 == -1) {
                                resourceId5 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.u = resourceId5;
                            continue;
                        case 11:
                            this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                            continue;
                        case 12:
                            this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                            continue;
                        case 13:
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            continue;
                        case 14:
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            continue;
                        case 15:
                            this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                            continue;
                        case 16:
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            continue;
                        case 17:
                            this.f1498e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1498e);
                            continue;
                        case 18:
                            this.f1499f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1499f);
                            continue;
                        case 19:
                            this.f1500g = obtainStyledAttributes.getFloat(index, this.f1500g);
                            continue;
                        case 20:
                            this.w = obtainStyledAttributes.getFloat(index, this.w);
                            continue;
                        case 21:
                            this.f1497d = obtainStyledAttributes.getLayoutDimension(index, this.f1497d);
                            continue;
                        case 22:
                            this.c = obtainStyledAttributes.getLayoutDimension(index, this.c);
                            continue;
                        case 23:
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            continue;
                        case 24:
                            int i9 = this.f1501h;
                            int[] iArr6 = d.f1481d;
                            int resourceId6 = obtainStyledAttributes.getResourceId(index, i9);
                            if (resourceId6 == -1) {
                                resourceId6 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1501h = resourceId6;
                            continue;
                        case 25:
                            int i10 = this.f1502i;
                            int[] iArr7 = d.f1481d;
                            int resourceId7 = obtainStyledAttributes.getResourceId(index, i10);
                            if (resourceId7 == -1) {
                                resourceId7 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1502i = resourceId7;
                            continue;
                        case 26:
                            this.E = obtainStyledAttributes.getInt(index, this.E);
                            continue;
                        case 27:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            continue;
                        case 28:
                            int i11 = this.f1503j;
                            int[] iArr8 = d.f1481d;
                            int resourceId8 = obtainStyledAttributes.getResourceId(index, i11);
                            if (resourceId8 == -1) {
                                resourceId8 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1503j = resourceId8;
                            continue;
                        case 29:
                            int i12 = this.f1504k;
                            int[] iArr9 = d.f1481d;
                            int resourceId9 = obtainStyledAttributes.getResourceId(index, i12);
                            if (resourceId9 == -1) {
                                resourceId9 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1504k = resourceId9;
                            continue;
                        case 30:
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            continue;
                        case 31:
                            int i13 = this.s;
                            int[] iArr10 = d.f1481d;
                            int resourceId10 = obtainStyledAttributes.getResourceId(index, i13);
                            if (resourceId10 == -1) {
                                resourceId10 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.s = resourceId10;
                            continue;
                        case 32:
                            int i14 = this.t;
                            int[] iArr11 = d.f1481d;
                            int resourceId11 = obtainStyledAttributes.getResourceId(index, i14);
                            if (resourceId11 == -1) {
                                resourceId11 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.t = resourceId11;
                            continue;
                        case 33:
                            this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                            continue;
                        case 34:
                            int i15 = this.m;
                            int[] iArr12 = d.f1481d;
                            int resourceId12 = obtainStyledAttributes.getResourceId(index, i15);
                            if (resourceId12 == -1) {
                                resourceId12 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.m = resourceId12;
                            continue;
                        case 35:
                            int i16 = this.f1505l;
                            int[] iArr13 = d.f1481d;
                            int resourceId13 = obtainStyledAttributes.getResourceId(index, i16);
                            if (resourceId13 == -1) {
                                resourceId13 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1505l = resourceId13;
                            continue;
                        case 36:
                            this.x = obtainStyledAttributes.getFloat(index, this.x);
                            continue;
                        case 37:
                            this.U = obtainStyledAttributes.getFloat(index, this.U);
                            continue;
                        case 38:
                            this.T = obtainStyledAttributes.getFloat(index, this.T);
                            continue;
                        case 39:
                            this.V = obtainStyledAttributes.getInt(index, this.V);
                            continue;
                        case 40:
                            this.W = obtainStyledAttributes.getInt(index, this.W);
                            continue;
                        case 41:
                            d.g(this, obtainStyledAttributes, index, 0);
                            continue;
                        case 42:
                            d.g(this, obtainStyledAttributes, index, 1);
                            continue;
                        default:
                            switch (i3) {
                                case 54:
                                    this.X = obtainStyledAttributes.getInt(index, this.X);
                                    continue;
                                case 55:
                                    this.Y = obtainStyledAttributes.getInt(index, this.Y);
                                    continue;
                                case 56:
                                    this.Z = obtainStyledAttributes.getDimensionPixelSize(index, this.Z);
                                    continue;
                                case 57:
                                    this.a0 = obtainStyledAttributes.getDimensionPixelSize(index, this.a0);
                                    continue;
                                case 58:
                                    this.b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.b0);
                                    continue;
                                case 59:
                                    this.c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                    continue;
                                default:
                                    switch (i3) {
                                        case 61:
                                            int i17 = this.z;
                                            int[] iArr14 = d.f1481d;
                                            int resourceId14 = obtainStyledAttributes.getResourceId(index, i17);
                                            if (resourceId14 == -1) {
                                                resourceId14 = obtainStyledAttributes.getInt(index, -1);
                                            }
                                            this.z = resourceId14;
                                            continue;
                                        case 62:
                                            this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                                            continue;
                                        case 63:
                                            this.B = obtainStyledAttributes.getFloat(index, this.B);
                                            continue;
                                        default:
                                            switch (i3) {
                                                case 69:
                                                    this.d0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.e0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 71:
                                                    continue;
                                                    continue;
                                                    continue;
                                                case 72:
                                                    this.f0 = obtainStyledAttributes.getInt(index, this.f0);
                                                    break;
                                                case 73:
                                                    this.g0 = obtainStyledAttributes.getDimensionPixelSize(index, this.g0);
                                                    break;
                                                case 74:
                                                    this.j0 = obtainStyledAttributes.getString(index);
                                                    break;
                                                case 75:
                                                    this.n0 = obtainStyledAttributes.getBoolean(index, this.n0);
                                                    break;
                                                case 76:
                                                    Integer.toHexString(index);
                                                    p0.get(index);
                                                    break;
                                                case 77:
                                                    this.k0 = obtainStyledAttributes.getString(index);
                                                    break;
                                                default:
                                                    switch (i3) {
                                                        case 91:
                                                            int i18 = this.q;
                                                            int[] iArr15 = d.f1481d;
                                                            int resourceId15 = obtainStyledAttributes.getResourceId(index, i18);
                                                            if (resourceId15 == -1) {
                                                                resourceId15 = obtainStyledAttributes.getInt(index, -1);
                                                            }
                                                            this.q = resourceId15;
                                                            break;
                                                        case 92:
                                                            int i19 = this.r;
                                                            int[] iArr16 = d.f1481d;
                                                            int resourceId16 = obtainStyledAttributes.getResourceId(index, i19);
                                                            if (resourceId16 == -1) {
                                                                resourceId16 = obtainStyledAttributes.getInt(index, -1);
                                                            }
                                                            this.r = resourceId16;
                                                            break;
                                                        case 93:
                                                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                                                            break;
                                                        case 94:
                                                            this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                                                            break;
                                                    }
                                            }
                                    }
                            }
                    }
                } else {
                    this.o0 = obtainStyledAttributes.getInt(index, this.o0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static SparseIntArray o;
        public boolean a = false;
        public int b = -1;
        public int c = 0;

        /* renamed from: d */
        public String f1506d = null;

        /* renamed from: e */
        public int f1507e = -1;

        /* renamed from: f */
        public int f1508f = 0;

        /* renamed from: g */
        public float f1509g = Float.NaN;

        /* renamed from: h */
        public int f1510h = -1;

        /* renamed from: i */
        public float f1511i = Float.NaN;

        /* renamed from: j */
        public float f1512j = Float.NaN;

        /* renamed from: k */
        public int f1513k = -1;

        /* renamed from: l */
        public String f1514l = null;
        public int m = -3;
        public int n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            o = sparseIntArray;
            sparseIntArray.append(R$styleable.Motion_motionPathRotate, 1);
            o.append(R$styleable.Motion_pathMotionArc, 2);
            o.append(R$styleable.Motion_transitionEasing, 3);
            o.append(R$styleable.Motion_drawPath, 4);
            o.append(R$styleable.Motion_animateRelativeTo, 5);
            o.append(R$styleable.Motion_animateCircleAngleTo, 6);
            o.append(R$styleable.Motion_motionStagger, 7);
            o.append(R$styleable.Motion_quantizeMotionSteps, 8);
            o.append(R$styleable.Motion_quantizeMotionPhase, 9);
            o.append(R$styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Motion);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (o.get(index)) {
                    case 1:
                        this.f1511i = obtainStyledAttributes.getFloat(index, this.f1511i);
                        break;
                    case 2:
                        this.f1507e = obtainStyledAttributes.getInt(index, this.f1507e);
                        break;
                    case 3:
                        this.f1506d = obtainStyledAttributes.peekValue(index).type == 3 ? obtainStyledAttributes.getString(index) : e.h.a.h.a.a.c[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    case 4:
                        this.f1508f = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        int i3 = this.b;
                        int[] iArr = d.f1481d;
                        int resourceId = obtainStyledAttributes.getResourceId(index, i3);
                        if (resourceId == -1) {
                            resourceId = obtainStyledAttributes.getInt(index, -1);
                        }
                        this.b = resourceId;
                        break;
                    case 6:
                        this.c = obtainStyledAttributes.getInteger(index, this.c);
                        break;
                    case 7:
                        this.f1509g = obtainStyledAttributes.getFloat(index, this.f1509g);
                        break;
                    case 8:
                        this.f1513k = obtainStyledAttributes.getInteger(index, this.f1513k);
                        break;
                    case 9:
                        this.f1512j = obtainStyledAttributes.getFloat(index, this.f1512j);
                        break;
                    case 10:
                        int i4 = obtainStyledAttributes.peekValue(index).type;
                        if (i4 == 1) {
                            int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                            this.n = resourceId2;
                            if (resourceId2 == -1) {
                                break;
                            }
                            this.m = -2;
                            break;
                        } else if (i4 != 3) {
                            this.m = obtainStyledAttributes.getInteger(index, this.n);
                            break;
                        } else {
                            String string = obtainStyledAttributes.getString(index);
                            this.f1514l = string;
                            if (string.indexOf("/") <= 0) {
                                this.m = -1;
                                break;
                            } else {
                                this.n = obtainStyledAttributes.getResourceId(index, -1);
                                this.m = -2;
                            }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: e.h.c.d$d */
    /* loaded from: classes.dex */
    public static class C0035d {
        public boolean a = false;
        public int b = 0;
        public int c = 0;

        /* renamed from: d */
        public float f1515d = 1.0f;

        /* renamed from: e */
        public float f1516e = Float.NaN;

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PropertySet);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.PropertySet_android_alpha) {
                    this.f1515d = obtainStyledAttributes.getFloat(index, this.f1515d);
                } else if (index == R$styleable.PropertySet_android_visibility) {
                    int i3 = obtainStyledAttributes.getInt(index, this.b);
                    this.b = i3;
                    int[] iArr = d.f1481d;
                    this.b = d.f1481d[i3];
                } else if (index == R$styleable.PropertySet_visibilityMode) {
                    this.c = obtainStyledAttributes.getInt(index, this.c);
                } else if (index == R$styleable.PropertySet_motionProgress) {
                    this.f1516e = obtainStyledAttributes.getFloat(index, this.f1516e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static SparseIntArray o;
        public boolean a = false;
        public float b = 0.0f;
        public float c = 0.0f;

        /* renamed from: d */
        public float f1517d = 0.0f;

        /* renamed from: e */
        public float f1518e = 1.0f;

        /* renamed from: f */
        public float f1519f = 1.0f;

        /* renamed from: g */
        public float f1520g = Float.NaN;

        /* renamed from: h */
        public float f1521h = Float.NaN;

        /* renamed from: i */
        public int f1522i = -1;

        /* renamed from: j */
        public float f1523j = 0.0f;

        /* renamed from: k */
        public float f1524k = 0.0f;

        /* renamed from: l */
        public float f1525l = 0.0f;
        public boolean m = false;
        public float n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            o = sparseIntArray;
            sparseIntArray.append(R$styleable.Transform_android_rotation, 1);
            o.append(R$styleable.Transform_android_rotationX, 2);
            o.append(R$styleable.Transform_android_rotationY, 3);
            o.append(R$styleable.Transform_android_scaleX, 4);
            o.append(R$styleable.Transform_android_scaleY, 5);
            o.append(R$styleable.Transform_android_transformPivotX, 6);
            o.append(R$styleable.Transform_android_transformPivotY, 7);
            o.append(R$styleable.Transform_android_translationX, 8);
            o.append(R$styleable.Transform_android_translationY, 9);
            o.append(R$styleable.Transform_android_translationZ, 10);
            o.append(R$styleable.Transform_android_elevation, 11);
            o.append(R$styleable.Transform_transformPivotTarget, 12);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transform);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (o.get(index)) {
                    case 1:
                        this.b = obtainStyledAttributes.getFloat(index, this.b);
                        break;
                    case 2:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 3:
                        this.f1517d = obtainStyledAttributes.getFloat(index, this.f1517d);
                        break;
                    case 4:
                        this.f1518e = obtainStyledAttributes.getFloat(index, this.f1518e);
                        break;
                    case 5:
                        this.f1519f = obtainStyledAttributes.getFloat(index, this.f1519f);
                        break;
                    case 6:
                        this.f1520g = obtainStyledAttributes.getDimension(index, this.f1520g);
                        break;
                    case 7:
                        this.f1521h = obtainStyledAttributes.getDimension(index, this.f1521h);
                        break;
                    case 8:
                        this.f1523j = obtainStyledAttributes.getDimension(index, this.f1523j);
                        break;
                    case 9:
                        this.f1524k = obtainStyledAttributes.getDimension(index, this.f1524k);
                        break;
                    case 10:
                        this.f1525l = obtainStyledAttributes.getDimension(index, this.f1525l);
                        break;
                    case 11:
                        this.m = true;
                        this.n = obtainStyledAttributes.getDimension(index, this.n);
                        break;
                    case 12:
                        int i3 = this.f1522i;
                        int[] iArr = d.f1481d;
                        int resourceId = obtainStyledAttributes.getResourceId(index, i3);
                        if (resourceId == -1) {
                            resourceId = obtainStyledAttributes.getInt(index, -1);
                        }
                        this.f1522i = resourceId;
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        f1482e.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        f1482e.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        f1482e.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        f1482e.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        f1482e.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        f1482e.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        f1482e.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        f1482e.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        f1482e.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f1482e.append(R$styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        f1482e.append(R$styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        f1482e.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        f1482e.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        f1482e.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        f1482e.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        f1482e.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        f1482e.append(R$styleable.Constraint_android_orientation, 27);
        f1482e.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        f1482e.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        f1482e.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        f1482e.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        f1482e.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        f1482e.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        f1482e.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        f1482e.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        f1482e.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        f1482e.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        f1482e.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        f1482e.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        f1482e.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f1482e.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        f1482e.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        f1482e.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        f1482e.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        f1482e.append(R$styleable.Constraint_layout_constraintLeft_creator, 87);
        f1482e.append(R$styleable.Constraint_layout_constraintTop_creator, 87);
        f1482e.append(R$styleable.Constraint_layout_constraintRight_creator, 87);
        f1482e.append(R$styleable.Constraint_layout_constraintBottom_creator, 87);
        f1482e.append(R$styleable.Constraint_layout_constraintBaseline_creator, 87);
        f1482e.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        f1482e.append(R$styleable.Constraint_android_layout_marginRight, 28);
        f1482e.append(R$styleable.Constraint_android_layout_marginStart, 31);
        f1482e.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        f1482e.append(R$styleable.Constraint_android_layout_marginTop, 34);
        f1482e.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        f1482e.append(R$styleable.Constraint_android_layout_width, 23);
        f1482e.append(R$styleable.Constraint_android_layout_height, 21);
        f1482e.append(R$styleable.Constraint_layout_constraintWidth, 95);
        f1482e.append(R$styleable.Constraint_layout_constraintHeight, 96);
        f1482e.append(R$styleable.Constraint_android_visibility, 22);
        f1482e.append(R$styleable.Constraint_android_alpha, 43);
        f1482e.append(R$styleable.Constraint_android_elevation, 44);
        f1482e.append(R$styleable.Constraint_android_rotationX, 45);
        f1482e.append(R$styleable.Constraint_android_rotationY, 46);
        f1482e.append(R$styleable.Constraint_android_rotation, 60);
        f1482e.append(R$styleable.Constraint_android_scaleX, 47);
        f1482e.append(R$styleable.Constraint_android_scaleY, 48);
        f1482e.append(R$styleable.Constraint_android_transformPivotX, 49);
        f1482e.append(R$styleable.Constraint_android_transformPivotY, 50);
        f1482e.append(R$styleable.Constraint_android_translationX, 51);
        f1482e.append(R$styleable.Constraint_android_translationY, 52);
        f1482e.append(R$styleable.Constraint_android_translationZ, 53);
        f1482e.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        f1482e.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        f1482e.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        f1482e.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        f1482e.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        f1482e.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        f1482e.append(R$styleable.Constraint_layout_constraintCircle, 61);
        f1482e.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        f1482e.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        f1482e.append(R$styleable.Constraint_animateRelativeTo, 64);
        f1482e.append(R$styleable.Constraint_transitionEasing, 65);
        f1482e.append(R$styleable.Constraint_drawPath, 66);
        f1482e.append(R$styleable.Constraint_transitionPathRotate, 67);
        f1482e.append(R$styleable.Constraint_motionStagger, 79);
        f1482e.append(R$styleable.Constraint_android_id, 38);
        f1482e.append(R$styleable.Constraint_motionProgress, 68);
        f1482e.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        f1482e.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        f1482e.append(R$styleable.Constraint_layout_wrapBehaviorInParent, 97);
        f1482e.append(R$styleable.Constraint_chainUseRtl, 71);
        f1482e.append(R$styleable.Constraint_barrierDirection, 72);
        f1482e.append(R$styleable.Constraint_barrierMargin, 73);
        f1482e.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        f1482e.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        f1482e.append(R$styleable.Constraint_pathMotionArc, 76);
        f1482e.append(R$styleable.Constraint_layout_constraintTag, 77);
        f1482e.append(R$styleable.Constraint_visibilityMode, 78);
        f1482e.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        f1482e.append(R$styleable.Constraint_layout_constrainedHeight, 81);
        f1482e.append(R$styleable.Constraint_polarRelativeTo, 82);
        f1482e.append(R$styleable.Constraint_transformPivotTarget, 83);
        f1482e.append(R$styleable.Constraint_quantizeMotionSteps, 84);
        f1482e.append(R$styleable.Constraint_quantizeMotionPhase, 85);
        f1482e.append(R$styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray sparseIntArray = f1483f;
        int i2 = R$styleable.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray.append(i2, 6);
        f1483f.append(i2, 7);
        f1483f.append(R$styleable.ConstraintOverride_android_orientation, 27);
        f1483f.append(R$styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        f1483f.append(R$styleable.ConstraintOverride_layout_goneMarginTop, 16);
        f1483f.append(R$styleable.ConstraintOverride_layout_goneMarginRight, 14);
        f1483f.append(R$styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        f1483f.append(R$styleable.ConstraintOverride_layout_goneMarginStart, 15);
        f1483f.append(R$styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        f1483f.append(R$styleable.ConstraintOverride_android_layout_marginLeft, 24);
        f1483f.append(R$styleable.ConstraintOverride_android_layout_marginRight, 28);
        f1483f.append(R$styleable.ConstraintOverride_android_layout_marginStart, 31);
        f1483f.append(R$styleable.ConstraintOverride_android_layout_marginEnd, 8);
        f1483f.append(R$styleable.ConstraintOverride_android_layout_marginTop, 34);
        f1483f.append(R$styleable.ConstraintOverride_android_layout_marginBottom, 2);
        f1483f.append(R$styleable.ConstraintOverride_android_layout_width, 23);
        f1483f.append(R$styleable.ConstraintOverride_android_layout_height, 21);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintWidth, 95);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintHeight, 96);
        f1483f.append(R$styleable.ConstraintOverride_android_visibility, 22);
        f1483f.append(R$styleable.ConstraintOverride_android_alpha, 43);
        f1483f.append(R$styleable.ConstraintOverride_android_elevation, 44);
        f1483f.append(R$styleable.ConstraintOverride_android_rotationX, 45);
        f1483f.append(R$styleable.ConstraintOverride_android_rotationY, 46);
        f1483f.append(R$styleable.ConstraintOverride_android_rotation, 60);
        f1483f.append(R$styleable.ConstraintOverride_android_scaleX, 47);
        f1483f.append(R$styleable.ConstraintOverride_android_scaleY, 48);
        f1483f.append(R$styleable.ConstraintOverride_android_transformPivotX, 49);
        f1483f.append(R$styleable.ConstraintOverride_android_transformPivotY, 50);
        f1483f.append(R$styleable.ConstraintOverride_android_translationX, 51);
        f1483f.append(R$styleable.ConstraintOverride_android_translationY, 52);
        f1483f.append(R$styleable.ConstraintOverride_android_translationZ, 53);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        f1483f.append(R$styleable.ConstraintOverride_animateRelativeTo, 64);
        f1483f.append(R$styleable.ConstraintOverride_transitionEasing, 65);
        f1483f.append(R$styleable.ConstraintOverride_drawPath, 66);
        f1483f.append(R$styleable.ConstraintOverride_transitionPathRotate, 67);
        f1483f.append(R$styleable.ConstraintOverride_motionStagger, 79);
        f1483f.append(R$styleable.ConstraintOverride_android_id, 38);
        f1483f.append(R$styleable.ConstraintOverride_motionTarget, 98);
        f1483f.append(R$styleable.ConstraintOverride_motionProgress, 68);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        f1483f.append(R$styleable.ConstraintOverride_chainUseRtl, 71);
        f1483f.append(R$styleable.ConstraintOverride_barrierDirection, 72);
        f1483f.append(R$styleable.ConstraintOverride_barrierMargin, 73);
        f1483f.append(R$styleable.ConstraintOverride_constraint_referenced_ids, 74);
        f1483f.append(R$styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        f1483f.append(R$styleable.ConstraintOverride_pathMotionArc, 76);
        f1483f.append(R$styleable.ConstraintOverride_layout_constraintTag, 77);
        f1483f.append(R$styleable.ConstraintOverride_visibilityMode, 78);
        f1483f.append(R$styleable.ConstraintOverride_layout_constrainedWidth, 80);
        f1483f.append(R$styleable.ConstraintOverride_layout_constrainedHeight, 81);
        f1483f.append(R$styleable.ConstraintOverride_polarRelativeTo, 82);
        f1483f.append(R$styleable.ConstraintOverride_transformPivotTarget, 83);
        f1483f.append(R$styleable.ConstraintOverride_quantizeMotionSteps, 84);
        f1483f.append(R$styleable.ConstraintOverride_quantizeMotionPhase, 85);
        f1483f.append(R$styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        f1483f.append(R$styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static void g(Object obj, TypedArray typedArray, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        if (obj != null) {
            int i8 = typedArray.peekValue(i2).type;
            boolean z = true;
            if (i8 != 3) {
                int i9 = -2;
                if (i8 != 5) {
                    i7 = typedArray.getInt(i2, 0);
                    if (i7 != -4) {
                        if (i7 == -3 || !(i7 == -2 || i7 == -1)) {
                            i9 = 0;
                            z = false;
                        }
                    }
                    if (!(obj instanceof ConstraintLayout.a)) {
                        ConstraintLayout.a aVar = (ConstraintLayout.a) obj;
                        if (i3 == 0) {
                            ((ViewGroup.MarginLayoutParams) aVar).width = i9;
                            aVar.V = z;
                            return;
                        }
                        ((ViewGroup.MarginLayoutParams) aVar).height = i9;
                        aVar.W = z;
                        return;
                    } else if (obj instanceof b) {
                        b bVar = (b) obj;
                        if (i3 == 0) {
                            bVar.c = i9;
                            bVar.l0 = z;
                            return;
                        }
                        bVar.f1497d = i9;
                        bVar.m0 = z;
                        return;
                    } else if (obj instanceof a.C0034a) {
                        a.C0034a aVar2 = (a.C0034a) obj;
                        if (i3 == 0) {
                            aVar2.b(23, i9);
                            i6 = 80;
                        } else {
                            aVar2.b(21, i9);
                            i6 = 81;
                        }
                        aVar2.d(i6, z);
                        return;
                    } else {
                        return;
                    }
                } else {
                    i7 = typedArray.getDimensionPixelSize(i2, 0);
                }
                i9 = i7;
                z = false;
                if (!(obj instanceof ConstraintLayout.a)) {
                }
            } else {
                String string = typedArray.getString(i2);
                if (string != null) {
                    int indexOf = string.indexOf(61);
                    int length = string.length();
                    if (indexOf > 0 && indexOf < length - 1) {
                        String substring = string.substring(0, indexOf);
                        String substring2 = string.substring(indexOf + 1);
                        if (substring2.length() > 0) {
                            String trim = substring.trim();
                            String trim2 = substring2.trim();
                            if (!"ratio".equalsIgnoreCase(trim)) {
                                try {
                                    if ("weight".equalsIgnoreCase(trim)) {
                                        float parseFloat = Float.parseFloat(trim2);
                                        if (obj instanceof ConstraintLayout.a) {
                                            ConstraintLayout.a aVar3 = (ConstraintLayout.a) obj;
                                            if (i3 == 0) {
                                                ((ViewGroup.MarginLayoutParams) aVar3).width = 0;
                                                aVar3.G = parseFloat;
                                                return;
                                            }
                                            ((ViewGroup.MarginLayoutParams) aVar3).height = 0;
                                            aVar3.H = parseFloat;
                                        } else if (obj instanceof b) {
                                            b bVar2 = (b) obj;
                                            if (i3 == 0) {
                                                bVar2.c = 0;
                                                bVar2.U = parseFloat;
                                                return;
                                            }
                                            bVar2.f1497d = 0;
                                            bVar2.T = parseFloat;
                                        } else if (obj instanceof a.C0034a) {
                                            a.C0034a aVar4 = (a.C0034a) obj;
                                            if (i3 == 0) {
                                                aVar4.b(23, 0);
                                                i5 = 39;
                                            } else {
                                                aVar4.b(21, 0);
                                                i5 = 40;
                                            }
                                            aVar4.a(i5, parseFloat);
                                        }
                                    } else if ("parent".equalsIgnoreCase(trim)) {
                                        float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                                        if (obj instanceof ConstraintLayout.a) {
                                            ConstraintLayout.a aVar5 = (ConstraintLayout.a) obj;
                                            if (i3 == 0) {
                                                ((ViewGroup.MarginLayoutParams) aVar5).width = 0;
                                                aVar5.Q = max;
                                                aVar5.K = 2;
                                                return;
                                            }
                                            ((ViewGroup.MarginLayoutParams) aVar5).height = 0;
                                            aVar5.R = max;
                                            aVar5.L = 2;
                                        } else if (obj instanceof b) {
                                            b bVar3 = (b) obj;
                                            if (i3 == 0) {
                                                bVar3.c = 0;
                                                bVar3.d0 = max;
                                                bVar3.X = 2;
                                                return;
                                            }
                                            bVar3.f1497d = 0;
                                            bVar3.e0 = max;
                                            bVar3.Y = 2;
                                        } else if (obj instanceof a.C0034a) {
                                            a.C0034a aVar6 = (a.C0034a) obj;
                                            if (i3 == 0) {
                                                aVar6.b(23, 0);
                                                i4 = 54;
                                            } else {
                                                aVar6.b(21, 0);
                                                i4 = 55;
                                            }
                                            aVar6.b(i4, 2);
                                        }
                                    }
                                } catch (NumberFormatException unused) {
                                }
                            } else if (obj instanceof ConstraintLayout.a) {
                                ConstraintLayout.a aVar7 = (ConstraintLayout.a) obj;
                                if (i3 == 0) {
                                    ((ViewGroup.MarginLayoutParams) aVar7).width = 0;
                                } else {
                                    ((ViewGroup.MarginLayoutParams) aVar7).height = 0;
                                }
                                h(aVar7, trim2);
                            } else if (obj instanceof b) {
                                ((b) obj).y = trim2;
                            } else if (obj instanceof a.C0034a) {
                                ((a.C0034a) obj).c(5, trim2);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void h(ConstraintLayout.a aVar, String str) {
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i2 = 0;
            i2 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("W")) {
                    i2 = substring.equalsIgnoreCase("H") ? 1 : -1;
                }
                i2 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 < 0 || indexOf2 >= length - 1) {
                    String substring2 = str.substring(i2);
                    if (substring2.length() > 0) {
                        Float.parseFloat(substring2);
                    }
                } else {
                    String substring3 = str.substring(i2, indexOf2);
                    String substring4 = str.substring(indexOf2 + 1);
                    if (substring3.length() > 0 && substring4.length() > 0) {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i2 == 1) {
                                Math.abs(parseFloat2 / parseFloat);
                            } else {
                                Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        aVar.F = str;
    }

    public void a(ConstraintLayout constraintLayout) {
        b(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void b(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.c.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.c.containsKey(Integer.valueOf(id))) {
                m.e.t0(childAt);
            } else if (this.b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1 && this.c.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                a aVar = this.c.get(Integer.valueOf(id));
                if (aVar != null) {
                    if (childAt instanceof Barrier) {
                        aVar.f1484d.h0 = 1;
                        Barrier barrier = (Barrier) childAt;
                        barrier.setId(id);
                        barrier.setType(aVar.f1484d.f0);
                        barrier.setMargin(aVar.f1484d.g0);
                        barrier.setAllowsGoneWidget(aVar.f1484d.n0);
                        b bVar = aVar.f1484d;
                        int[] iArr = bVar.i0;
                        if (iArr != null) {
                            barrier.setReferencedIds(iArr);
                        } else {
                            String str = bVar.j0;
                            if (str != null) {
                                bVar.i0 = d(barrier, str);
                                barrier.setReferencedIds(aVar.f1484d.i0);
                            }
                        }
                    }
                    ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
                    aVar2.a();
                    aVar.a(aVar2);
                    if (z) {
                        a.b(childAt, aVar.f1486f);
                    }
                    childAt.setLayoutParams(aVar2);
                    C0035d dVar = aVar.b;
                    if (dVar.c == 0) {
                        childAt.setVisibility(dVar.b);
                    }
                    childAt.setAlpha(aVar.b.f1515d);
                    childAt.setRotation(aVar.f1485e.b);
                    childAt.setRotationX(aVar.f1485e.c);
                    childAt.setRotationY(aVar.f1485e.f1517d);
                    childAt.setScaleX(aVar.f1485e.f1518e);
                    childAt.setScaleY(aVar.f1485e.f1519f);
                    e eVar = aVar.f1485e;
                    if (eVar.f1522i != -1) {
                        View findViewById = ((View) childAt.getParent()).findViewById(aVar.f1485e.f1522i);
                        if (findViewById != null) {
                            float bottom = ((float) (findViewById.getBottom() + findViewById.getTop())) / 2.0f;
                            float right = ((float) (findViewById.getRight() + findViewById.getLeft())) / 2.0f;
                            if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                childAt.setPivotX(right - ((float) childAt.getLeft()));
                                childAt.setPivotY(bottom - ((float) childAt.getTop()));
                            }
                        }
                    } else {
                        if (!Float.isNaN(eVar.f1520g)) {
                            childAt.setPivotX(aVar.f1485e.f1520g);
                        }
                        if (!Float.isNaN(aVar.f1485e.f1521h)) {
                            childAt.setPivotY(aVar.f1485e.f1521h);
                        }
                    }
                    childAt.setTranslationX(aVar.f1485e.f1523j);
                    childAt.setTranslationY(aVar.f1485e.f1524k);
                    childAt.setTranslationZ(aVar.f1485e.f1525l);
                    e eVar2 = aVar.f1485e;
                    if (eVar2.m) {
                        childAt.setElevation(eVar2.n);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar3 = this.c.get(num);
            if (aVar3 != null) {
                if (aVar3.f1484d.h0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    b bVar2 = aVar3.f1484d;
                    int[] iArr2 = bVar2.i0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar2.j0;
                        if (str2 != null) {
                            bVar2.i0 = d(barrier2, str2);
                            barrier2.setReferencedIds(aVar3.f1484d.i0);
                        }
                    }
                    barrier2.setType(aVar3.f1484d.f0);
                    barrier2.setMargin(aVar3.f1484d.g0);
                    ConstraintLayout.a b2 = constraintLayout.generateDefaultLayoutParams();
                    barrier2.n();
                    aVar3.a(b2);
                    constraintLayout.addView(barrier2, b2);
                }
                if (aVar3.f1484d.a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.a b3 = constraintLayout.generateDefaultLayoutParams();
                    aVar3.a(b3);
                    constraintLayout.addView(guideline, b3);
                }
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = constraintLayout.getChildAt(i3);
            if (childAt2 instanceof b) {
                ((b) childAt2).g(constraintLayout);
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
                if (aVar3 != null) {
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
                                } catch (IllegalAccessException e5) {
                                    e3 = e5;
                                    e3.printStackTrace();
                                } catch (NoSuchMethodException e6) {
                                    e2 = e6;
                                    e2.printStackTrace();
                                } catch (InvocationTargetException e7) {
                                    e4 = e7;
                                    e4.printStackTrace();
                                }
                            }
                            hashMap2.put(str, aVar);
                        } catch (IllegalAccessException e8) {
                            e3 = e8;
                        } catch (NoSuchMethodException e9) {
                            e2 = e9;
                        } catch (InvocationTargetException e10) {
                            e4 = e10;
                        }
                    }
                    aVar3.f1486f = hashMap2;
                    aVar3.b(id, aVar2);
                    aVar3.b.b = childAt.getVisibility();
                    aVar3.b.f1515d = childAt.getAlpha();
                    aVar3.f1485e.b = childAt.getRotation();
                    aVar3.f1485e.c = childAt.getRotationX();
                    aVar3.f1485e.f1517d = childAt.getRotationY();
                    aVar3.f1485e.f1518e = childAt.getScaleX();
                    aVar3.f1485e.f1519f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        e eVar = aVar3.f1485e;
                        eVar.f1520g = pivotX;
                        eVar.f1521h = pivotY;
                    }
                    aVar3.f1485e.f1523j = childAt.getTranslationX();
                    aVar3.f1485e.f1524k = childAt.getTranslationY();
                    aVar3.f1485e.f1525l = childAt.getTranslationZ();
                    e eVar2 = aVar3.f1485e;
                    if (eVar2.m) {
                        eVar2.n = childAt.getElevation();
                    }
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        aVar3.f1484d.n0 = barrier.getAllowsGoneWidget();
                        aVar3.f1484d.i0 = barrier.getReferencedIds();
                        aVar3.f1484d.f0 = barrier.getType();
                        aVar3.f1484d.g0 = barrier.getMargin();
                    }
                }
                i2++;
                dVar = this;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public final int[] d(View view, String str) {
        int i2;
        Object c2;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i3 = 0;
        for (String str2 : split) {
            String trim = str2.trim();
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
            i3++;
            iArr[i3] = i2;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02ec, code lost:
        if (r5 == -1) goto L_0x02ee;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02ee, code lost:
        r5 = r1.getInt(r12, -1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0448, code lost:
        if (r7.n != -1) goto L_0x044a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0248, code lost:
        if (r5 == -1) goto L_0x02ee;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final a e(Context context, AttributeSet attributeSet, boolean z) {
        c cVar;
        String str;
        c cVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float f2;
        int i7;
        float f3;
        int i8;
        float f4;
        boolean z2;
        int i9;
        int i10;
        c cVar3;
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z ? R$styleable.ConstraintOverride : R$styleable.Constraint);
        if (z) {
            int indexCount = obtainStyledAttributes.getIndexCount();
            a.C0034a aVar2 = new a.C0034a();
            aVar.f1487g = aVar2;
            aVar.c.a = false;
            aVar.f1484d.b = false;
            aVar.b.a = false;
            aVar.f1485e.a = false;
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                int i12 = f1483f.get(index);
                int i13 = 28;
                if (i12 == 2) {
                    i4 = aVar.f1484d.I;
                    i13 = 2;
                } else if (i12 == 31) {
                    i4 = aVar.f1484d.K;
                    i13 = 31;
                } else if (i12 != 34) {
                    int i14 = 5;
                    if (i12 != 5) {
                        int i15 = 7;
                        if (i12 == 6) {
                            i5 = aVar.f1484d.C;
                            i15 = 6;
                        } else if (i12 == 7) {
                            i5 = aVar.f1484d.D;
                        } else if (i12 != 8) {
                            i3 = 27;
                            if (i12 == 27) {
                                i6 = aVar.f1484d.E;
                            } else if (i12 != 28) {
                                switch (i12) {
                                    case 11:
                                        i13 = 11;
                                        i4 = aVar.f1484d.P;
                                        break;
                                    case 12:
                                        i13 = 12;
                                        i4 = aVar.f1484d.Q;
                                        break;
                                    case 13:
                                        i13 = 13;
                                        i4 = aVar.f1484d.M;
                                        break;
                                    case 14:
                                        i13 = 14;
                                        i4 = aVar.f1484d.O;
                                        break;
                                    case 15:
                                        i13 = 15;
                                        i4 = aVar.f1484d.R;
                                        break;
                                    case 16:
                                        i13 = 16;
                                        i4 = aVar.f1484d.N;
                                        break;
                                    case 17:
                                        i15 = 17;
                                        i5 = aVar.f1484d.f1498e;
                                        break;
                                    case 18:
                                        i15 = 18;
                                        i5 = aVar.f1484d.f1499f;
                                        break;
                                    case 19:
                                        i7 = 19;
                                        f3 = aVar.f1484d.f1500g;
                                        f2 = obtainStyledAttributes.getFloat(index, f3);
                                        aVar2.a(i7, f2);
                                        break;
                                    case 20:
                                        i7 = 20;
                                        f3 = aVar.f1484d.w;
                                        f2 = obtainStyledAttributes.getFloat(index, f3);
                                        aVar2.a(i7, f2);
                                        break;
                                    case 21:
                                        i3 = 21;
                                        i8 = aVar.f1484d.f1497d;
                                        i2 = obtainStyledAttributes.getLayoutDimension(index, i8);
                                        aVar2.b(i3, i2);
                                        break;
                                    case 22:
                                        i3 = 22;
                                        i2 = f1481d[obtainStyledAttributes.getInt(index, aVar.b.b)];
                                        aVar2.b(i3, i2);
                                        break;
                                    case 23:
                                        i3 = 23;
                                        i8 = aVar.f1484d.c;
                                        i2 = obtainStyledAttributes.getLayoutDimension(index, i8);
                                        aVar2.b(i3, i2);
                                        break;
                                    case 24:
                                        i13 = 24;
                                        i4 = aVar.f1484d.F;
                                        break;
                                    default:
                                        switch (i12) {
                                            case 37:
                                                i7 = 37;
                                                f3 = aVar.f1484d.x;
                                                f2 = obtainStyledAttributes.getFloat(index, f3);
                                                aVar2.a(i7, f2);
                                                break;
                                            case 38:
                                                i2 = obtainStyledAttributes.getResourceId(index, aVar.a);
                                                aVar.a = i2;
                                                i3 = 38;
                                                aVar2.b(i3, i2);
                                                break;
                                            case 39:
                                                i7 = 39;
                                                f3 = aVar.f1484d.U;
                                                f2 = obtainStyledAttributes.getFloat(index, f3);
                                                aVar2.a(i7, f2);
                                                break;
                                            case 40:
                                                i7 = 40;
                                                f3 = aVar.f1484d.T;
                                                f2 = obtainStyledAttributes.getFloat(index, f3);
                                                aVar2.a(i7, f2);
                                                break;
                                            case 41:
                                                i3 = 41;
                                                i6 = aVar.f1484d.V;
                                                break;
                                            case 42:
                                                i3 = 42;
                                                i6 = aVar.f1484d.W;
                                                break;
                                            case 43:
                                                i7 = 43;
                                                f3 = aVar.b.f1515d;
                                                f2 = obtainStyledAttributes.getFloat(index, f3);
                                                aVar2.a(i7, f2);
                                                break;
                                            case 44:
                                                i7 = 44;
                                                aVar2.d(44, true);
                                                f4 = aVar.f1485e.n;
                                                f2 = obtainStyledAttributes.getDimension(index, f4);
                                                aVar2.a(i7, f2);
                                                break;
                                            case 45:
                                                i7 = 45;
                                                f3 = aVar.f1485e.c;
                                                f2 = obtainStyledAttributes.getFloat(index, f3);
                                                aVar2.a(i7, f2);
                                                break;
                                            case 46:
                                                i7 = 46;
                                                f3 = aVar.f1485e.f1517d;
                                                f2 = obtainStyledAttributes.getFloat(index, f3);
                                                aVar2.a(i7, f2);
                                                break;
                                            case 47:
                                                i7 = 47;
                                                f3 = aVar.f1485e.f1518e;
                                                f2 = obtainStyledAttributes.getFloat(index, f3);
                                                aVar2.a(i7, f2);
                                                break;
                                            case 48:
                                                i7 = 48;
                                                f3 = aVar.f1485e.f1519f;
                                                f2 = obtainStyledAttributes.getFloat(index, f3);
                                                aVar2.a(i7, f2);
                                                break;
                                            case 49:
                                                i7 = 49;
                                                f4 = aVar.f1485e.f1520g;
                                                f2 = obtainStyledAttributes.getDimension(index, f4);
                                                aVar2.a(i7, f2);
                                                break;
                                            case 50:
                                                i7 = 50;
                                                f4 = aVar.f1485e.f1521h;
                                                f2 = obtainStyledAttributes.getDimension(index, f4);
                                                aVar2.a(i7, f2);
                                                break;
                                            case 51:
                                                i7 = 51;
                                                f4 = aVar.f1485e.f1523j;
                                                f2 = obtainStyledAttributes.getDimension(index, f4);
                                                aVar2.a(i7, f2);
                                                break;
                                            case 52:
                                                i7 = 52;
                                                f4 = aVar.f1485e.f1524k;
                                                f2 = obtainStyledAttributes.getDimension(index, f4);
                                                aVar2.a(i7, f2);
                                                break;
                                            case 53:
                                                i7 = 53;
                                                f4 = aVar.f1485e.f1525l;
                                                f2 = obtainStyledAttributes.getDimension(index, f4);
                                                aVar2.a(i7, f2);
                                                break;
                                            case 54:
                                                i3 = 54;
                                                i6 = aVar.f1484d.X;
                                                break;
                                            case 55:
                                                i3 = 55;
                                                i6 = aVar.f1484d.Y;
                                                break;
                                            case 56:
                                                i13 = 56;
                                                i4 = aVar.f1484d.Z;
                                                break;
                                            case 57:
                                                i13 = 57;
                                                i4 = aVar.f1484d.a0;
                                                break;
                                            case 58:
                                                i13 = 58;
                                                i4 = aVar.f1484d.b0;
                                                break;
                                            case 59:
                                                i13 = 59;
                                                i4 = aVar.f1484d.c0;
                                                break;
                                            case 60:
                                                i7 = 60;
                                                f3 = aVar.f1485e.b;
                                                f2 = obtainStyledAttributes.getFloat(index, f3);
                                                aVar2.a(i7, f2);
                                                break;
                                            default:
                                                switch (i12) {
                                                    case 62:
                                                        i13 = 62;
                                                        i4 = aVar.f1484d.A;
                                                        break;
                                                    case 63:
                                                        i7 = 63;
                                                        f3 = aVar.f1484d.B;
                                                        f2 = obtainStyledAttributes.getFloat(index, f3);
                                                        aVar2.a(i7, f2);
                                                        break;
                                                    case 64:
                                                        i3 = 64;
                                                        i2 = obtainStyledAttributes.getResourceId(index, aVar.c.b);
                                                        break;
                                                    case 65:
                                                        aVar2.c(65, obtainStyledAttributes.peekValue(index).type == 3 ? obtainStyledAttributes.getString(index) : e.h.a.h.a.a.c[obtainStyledAttributes.getInteger(index, 0)]);
                                                        break;
                                                    case 66:
                                                        i3 = 66;
                                                        i2 = obtainStyledAttributes.getInt(index, 0);
                                                        aVar2.b(i3, i2);
                                                        break;
                                                    case 67:
                                                        i7 = 67;
                                                        f3 = aVar.c.f1511i;
                                                        f2 = obtainStyledAttributes.getFloat(index, f3);
                                                        aVar2.a(i7, f2);
                                                        break;
                                                    case 68:
                                                        i7 = 68;
                                                        f3 = aVar.b.f1516e;
                                                        f2 = obtainStyledAttributes.getFloat(index, f3);
                                                        aVar2.a(i7, f2);
                                                        break;
                                                    case 69:
                                                        i7 = 69;
                                                        f3 = 1.0f;
                                                        f2 = obtainStyledAttributes.getFloat(index, f3);
                                                        aVar2.a(i7, f2);
                                                        break;
                                                    case 70:
                                                        i7 = 70;
                                                        f3 = 1.0f;
                                                        f2 = obtainStyledAttributes.getFloat(index, f3);
                                                        aVar2.a(i7, f2);
                                                        break;
                                                    case 71:
                                                        break;
                                                    case 72:
                                                        i3 = 72;
                                                        i6 = aVar.f1484d.f0;
                                                        break;
                                                    case 73:
                                                        i13 = 73;
                                                        i4 = aVar.f1484d.g0;
                                                        break;
                                                    case 74:
                                                        i14 = 74;
                                                        break;
                                                    case 75:
                                                        i9 = 75;
                                                        z2 = aVar.f1484d.n0;
                                                        aVar2.d(i9, obtainStyledAttributes.getBoolean(index, z2));
                                                        break;
                                                    case 76:
                                                        i3 = 76;
                                                        i6 = aVar.c.f1507e;
                                                        break;
                                                    case 77:
                                                        i14 = 77;
                                                        break;
                                                    case 78:
                                                        i3 = 78;
                                                        i6 = aVar.b.c;
                                                        break;
                                                    case 79:
                                                        i7 = 79;
                                                        f3 = aVar.c.f1509g;
                                                        f2 = obtainStyledAttributes.getFloat(index, f3);
                                                        aVar2.a(i7, f2);
                                                        break;
                                                    case 80:
                                                        i9 = 80;
                                                        z2 = aVar.f1484d.l0;
                                                        aVar2.d(i9, obtainStyledAttributes.getBoolean(index, z2));
                                                        break;
                                                    case 81:
                                                        i9 = 81;
                                                        z2 = aVar.f1484d.m0;
                                                        aVar2.d(i9, obtainStyledAttributes.getBoolean(index, z2));
                                                        break;
                                                    case 82:
                                                        i3 = 82;
                                                        i10 = aVar.c.c;
                                                        i2 = obtainStyledAttributes.getInteger(index, i10);
                                                        aVar2.b(i3, i2);
                                                        break;
                                                    case 83:
                                                        i3 = 83;
                                                        i2 = obtainStyledAttributes.getResourceId(index, aVar.f1485e.f1522i);
                                                        break;
                                                    case 84:
                                                        i3 = 84;
                                                        i10 = aVar.c.f1513k;
                                                        i2 = obtainStyledAttributes.getInteger(index, i10);
                                                        aVar2.b(i3, i2);
                                                        break;
                                                    case 85:
                                                        i7 = 85;
                                                        f3 = aVar.c.f1512j;
                                                        f2 = obtainStyledAttributes.getFloat(index, f3);
                                                        aVar2.a(i7, f2);
                                                        break;
                                                    case 86:
                                                        int i16 = obtainStyledAttributes.peekValue(index).type;
                                                        if (i16 == 1) {
                                                            aVar.c.n = obtainStyledAttributes.getResourceId(index, -1);
                                                            aVar2.b(89, aVar.c.n);
                                                            cVar3 = aVar.c;
                                                            if (cVar3.n == -1) {
                                                                break;
                                                            }
                                                            cVar3.m = -2;
                                                            aVar2.b(88, -2);
                                                            break;
                                                        } else if (i16 != 3) {
                                                            c cVar4 = aVar.c;
                                                            cVar4.m = obtainStyledAttributes.getInteger(index, cVar4.n);
                                                            aVar2.b(88, aVar.c.m);
                                                            break;
                                                        } else {
                                                            aVar.c.f1514l = obtainStyledAttributes.getString(index);
                                                            aVar2.c(90, aVar.c.f1514l);
                                                            if (aVar.c.f1514l.indexOf("/") <= 0) {
                                                                aVar.c.m = -1;
                                                                aVar2.b(88, -1);
                                                                break;
                                                            } else {
                                                                aVar.c.n = obtainStyledAttributes.getResourceId(index, -1);
                                                                aVar2.b(89, aVar.c.n);
                                                                cVar3 = aVar.c;
                                                                cVar3.m = -2;
                                                                aVar2.b(88, -2);
                                                            }
                                                        }
                                                    default:
                                                        switch (i12) {
                                                            case 93:
                                                                i13 = 93;
                                                                i4 = aVar.f1484d.L;
                                                                break;
                                                            case 94:
                                                                i13 = 94;
                                                                i4 = aVar.f1484d.S;
                                                                break;
                                                            case 95:
                                                                g(aVar2, obtainStyledAttributes, index, 0);
                                                                continue;
                                                            case 96:
                                                                g(aVar2, obtainStyledAttributes, index, 1);
                                                                continue;
                                                            case 97:
                                                                i3 = 97;
                                                                i6 = aVar.f1484d.o0;
                                                                break;
                                                            case 98:
                                                                int i17 = e.h.b.a.c.W;
                                                                if (obtainStyledAttributes.peekValue(index).type != 3) {
                                                                    aVar.a = obtainStyledAttributes.getResourceId(index, aVar.a);
                                                                    break;
                                                                } else {
                                                                    obtainStyledAttributes.getString(index);
                                                                    continue;
                                                                }
                                                            default:
                                                                Integer.toHexString(index);
                                                                f1482e.get(index);
                                                                continue;
                                                        }
                                                }
                                        }
                                }
                            } else {
                                i4 = aVar.f1484d.G;
                            }
                            i2 = obtainStyledAttributes.getInt(index, i6);
                            aVar2.b(i3, i2);
                        } else {
                            i4 = aVar.f1484d.J;
                            i13 = 8;
                        }
                        i2 = obtainStyledAttributes.getDimensionPixelOffset(index, i5);
                        i3 = i15;
                        aVar2.b(i3, i2);
                    }
                    aVar2.c(i14, obtainStyledAttributes.getString(index));
                } else {
                    i4 = aVar.f1484d.H;
                    i13 = 34;
                }
                i2 = obtainStyledAttributes.getDimensionPixelSize(index, i4);
                i3 = i13;
                aVar2.b(i3, i2);
            }
        } else {
            int indexCount2 = obtainStyledAttributes.getIndexCount();
            for (int i18 = 0; i18 < indexCount2; i18++) {
                int index2 = obtainStyledAttributes.getIndex(i18);
                if (!(index2 == R$styleable.Constraint_android_id || R$styleable.Constraint_android_layout_marginStart == index2 || R$styleable.Constraint_android_layout_marginEnd == index2)) {
                    aVar.c.a = true;
                    aVar.f1484d.b = true;
                    aVar.b.a = true;
                    aVar.f1485e.a = true;
                }
                switch (f1482e.get(index2)) {
                    case 1:
                        b bVar = aVar.f1484d;
                        int resourceId = obtainStyledAttributes.getResourceId(index2, bVar.p);
                        if (resourceId == -1) {
                            resourceId = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar.p = resourceId;
                        continue;
                    case 2:
                        b bVar2 = aVar.f1484d;
                        bVar2.I = obtainStyledAttributes.getDimensionPixelSize(index2, bVar2.I);
                        continue;
                    case 3:
                        b bVar3 = aVar.f1484d;
                        int resourceId2 = obtainStyledAttributes.getResourceId(index2, bVar3.o);
                        if (resourceId2 == -1) {
                            resourceId2 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar3.o = resourceId2;
                        continue;
                    case 4:
                        b bVar4 = aVar.f1484d;
                        int resourceId3 = obtainStyledAttributes.getResourceId(index2, bVar4.n);
                        if (resourceId3 == -1) {
                            resourceId3 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar4.n = resourceId3;
                        continue;
                    case 5:
                        aVar.f1484d.y = obtainStyledAttributes.getString(index2);
                        continue;
                    case 6:
                        b bVar5 = aVar.f1484d;
                        bVar5.C = obtainStyledAttributes.getDimensionPixelOffset(index2, bVar5.C);
                        continue;
                    case 7:
                        b bVar6 = aVar.f1484d;
                        bVar6.D = obtainStyledAttributes.getDimensionPixelOffset(index2, bVar6.D);
                        continue;
                    case 8:
                        b bVar7 = aVar.f1484d;
                        bVar7.J = obtainStyledAttributes.getDimensionPixelSize(index2, bVar7.J);
                        continue;
                    case 9:
                        b bVar8 = aVar.f1484d;
                        int resourceId4 = obtainStyledAttributes.getResourceId(index2, bVar8.v);
                        if (resourceId4 == -1) {
                            resourceId4 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar8.v = resourceId4;
                        continue;
                    case 10:
                        b bVar9 = aVar.f1484d;
                        int resourceId5 = obtainStyledAttributes.getResourceId(index2, bVar9.u);
                        if (resourceId5 == -1) {
                            resourceId5 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar9.u = resourceId5;
                        continue;
                    case 11:
                        b bVar10 = aVar.f1484d;
                        bVar10.P = obtainStyledAttributes.getDimensionPixelSize(index2, bVar10.P);
                        continue;
                    case 12:
                        b bVar11 = aVar.f1484d;
                        bVar11.Q = obtainStyledAttributes.getDimensionPixelSize(index2, bVar11.Q);
                        continue;
                    case 13:
                        b bVar12 = aVar.f1484d;
                        bVar12.M = obtainStyledAttributes.getDimensionPixelSize(index2, bVar12.M);
                        continue;
                    case 14:
                        b bVar13 = aVar.f1484d;
                        bVar13.O = obtainStyledAttributes.getDimensionPixelSize(index2, bVar13.O);
                        continue;
                    case 15:
                        b bVar14 = aVar.f1484d;
                        bVar14.R = obtainStyledAttributes.getDimensionPixelSize(index2, bVar14.R);
                        continue;
                    case 16:
                        b bVar15 = aVar.f1484d;
                        bVar15.N = obtainStyledAttributes.getDimensionPixelSize(index2, bVar15.N);
                        continue;
                    case 17:
                        b bVar16 = aVar.f1484d;
                        bVar16.f1498e = obtainStyledAttributes.getDimensionPixelOffset(index2, bVar16.f1498e);
                        continue;
                    case 18:
                        b bVar17 = aVar.f1484d;
                        bVar17.f1499f = obtainStyledAttributes.getDimensionPixelOffset(index2, bVar17.f1499f);
                        continue;
                    case 19:
                        b bVar18 = aVar.f1484d;
                        bVar18.f1500g = obtainStyledAttributes.getFloat(index2, bVar18.f1500g);
                        continue;
                    case 20:
                        b bVar19 = aVar.f1484d;
                        bVar19.w = obtainStyledAttributes.getFloat(index2, bVar19.w);
                        continue;
                    case 21:
                        b bVar20 = aVar.f1484d;
                        bVar20.f1497d = obtainStyledAttributes.getLayoutDimension(index2, bVar20.f1497d);
                        continue;
                    case 22:
                        C0035d dVar = aVar.b;
                        dVar.b = obtainStyledAttributes.getInt(index2, dVar.b);
                        C0035d dVar2 = aVar.b;
                        dVar2.b = f1481d[dVar2.b];
                        continue;
                    case 23:
                        b bVar21 = aVar.f1484d;
                        bVar21.c = obtainStyledAttributes.getLayoutDimension(index2, bVar21.c);
                        continue;
                    case 24:
                        b bVar22 = aVar.f1484d;
                        bVar22.F = obtainStyledAttributes.getDimensionPixelSize(index2, bVar22.F);
                        continue;
                    case 25:
                        b bVar23 = aVar.f1484d;
                        int resourceId6 = obtainStyledAttributes.getResourceId(index2, bVar23.f1501h);
                        if (resourceId6 == -1) {
                            resourceId6 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar23.f1501h = resourceId6;
                        continue;
                    case 26:
                        b bVar24 = aVar.f1484d;
                        int resourceId7 = obtainStyledAttributes.getResourceId(index2, bVar24.f1502i);
                        if (resourceId7 == -1) {
                            resourceId7 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar24.f1502i = resourceId7;
                        continue;
                    case 27:
                        b bVar25 = aVar.f1484d;
                        bVar25.E = obtainStyledAttributes.getInt(index2, bVar25.E);
                        continue;
                    case 28:
                        b bVar26 = aVar.f1484d;
                        bVar26.G = obtainStyledAttributes.getDimensionPixelSize(index2, bVar26.G);
                        continue;
                    case 29:
                        b bVar27 = aVar.f1484d;
                        int resourceId8 = obtainStyledAttributes.getResourceId(index2, bVar27.f1503j);
                        if (resourceId8 == -1) {
                            resourceId8 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar27.f1503j = resourceId8;
                        continue;
                    case 30:
                        b bVar28 = aVar.f1484d;
                        int resourceId9 = obtainStyledAttributes.getResourceId(index2, bVar28.f1504k);
                        if (resourceId9 == -1) {
                            resourceId9 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar28.f1504k = resourceId9;
                        continue;
                    case 31:
                        b bVar29 = aVar.f1484d;
                        bVar29.K = obtainStyledAttributes.getDimensionPixelSize(index2, bVar29.K);
                        continue;
                    case 32:
                        b bVar30 = aVar.f1484d;
                        int resourceId10 = obtainStyledAttributes.getResourceId(index2, bVar30.s);
                        if (resourceId10 == -1) {
                            resourceId10 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar30.s = resourceId10;
                        continue;
                    case 33:
                        b bVar31 = aVar.f1484d;
                        int resourceId11 = obtainStyledAttributes.getResourceId(index2, bVar31.t);
                        if (resourceId11 == -1) {
                            resourceId11 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar31.t = resourceId11;
                        continue;
                    case 34:
                        b bVar32 = aVar.f1484d;
                        bVar32.H = obtainStyledAttributes.getDimensionPixelSize(index2, bVar32.H);
                        continue;
                    case 35:
                        b bVar33 = aVar.f1484d;
                        int resourceId12 = obtainStyledAttributes.getResourceId(index2, bVar33.m);
                        if (resourceId12 == -1) {
                            resourceId12 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar33.m = resourceId12;
                        continue;
                    case 36:
                        b bVar34 = aVar.f1484d;
                        int resourceId13 = obtainStyledAttributes.getResourceId(index2, bVar34.f1505l);
                        if (resourceId13 == -1) {
                            resourceId13 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar34.f1505l = resourceId13;
                        continue;
                    case 37:
                        b bVar35 = aVar.f1484d;
                        bVar35.x = obtainStyledAttributes.getFloat(index2, bVar35.x);
                        continue;
                    case 38:
                        aVar.a = obtainStyledAttributes.getResourceId(index2, aVar.a);
                        continue;
                    case 39:
                        b bVar36 = aVar.f1484d;
                        bVar36.U = obtainStyledAttributes.getFloat(index2, bVar36.U);
                        continue;
                    case 40:
                        b bVar37 = aVar.f1484d;
                        bVar37.T = obtainStyledAttributes.getFloat(index2, bVar37.T);
                        continue;
                    case 41:
                        b bVar38 = aVar.f1484d;
                        bVar38.V = obtainStyledAttributes.getInt(index2, bVar38.V);
                        continue;
                    case 42:
                        b bVar39 = aVar.f1484d;
                        bVar39.W = obtainStyledAttributes.getInt(index2, bVar39.W);
                        continue;
                    case 43:
                        C0035d dVar3 = aVar.b;
                        dVar3.f1515d = obtainStyledAttributes.getFloat(index2, dVar3.f1515d);
                        continue;
                    case 44:
                        e eVar = aVar.f1485e;
                        eVar.m = true;
                        eVar.n = obtainStyledAttributes.getDimension(index2, eVar.n);
                        continue;
                    case 45:
                        e eVar2 = aVar.f1485e;
                        eVar2.c = obtainStyledAttributes.getFloat(index2, eVar2.c);
                        continue;
                    case 46:
                        e eVar3 = aVar.f1485e;
                        eVar3.f1517d = obtainStyledAttributes.getFloat(index2, eVar3.f1517d);
                        continue;
                    case 47:
                        e eVar4 = aVar.f1485e;
                        eVar4.f1518e = obtainStyledAttributes.getFloat(index2, eVar4.f1518e);
                        continue;
                    case 48:
                        e eVar5 = aVar.f1485e;
                        eVar5.f1519f = obtainStyledAttributes.getFloat(index2, eVar5.f1519f);
                        continue;
                    case 49:
                        e eVar6 = aVar.f1485e;
                        eVar6.f1520g = obtainStyledAttributes.getDimension(index2, eVar6.f1520g);
                        continue;
                    case 50:
                        e eVar7 = aVar.f1485e;
                        eVar7.f1521h = obtainStyledAttributes.getDimension(index2, eVar7.f1521h);
                        continue;
                    case 51:
                        e eVar8 = aVar.f1485e;
                        eVar8.f1523j = obtainStyledAttributes.getDimension(index2, eVar8.f1523j);
                        continue;
                    case 52:
                        e eVar9 = aVar.f1485e;
                        eVar9.f1524k = obtainStyledAttributes.getDimension(index2, eVar9.f1524k);
                        continue;
                    case 53:
                        e eVar10 = aVar.f1485e;
                        eVar10.f1525l = obtainStyledAttributes.getDimension(index2, eVar10.f1525l);
                        continue;
                    case 54:
                        b bVar40 = aVar.f1484d;
                        bVar40.X = obtainStyledAttributes.getInt(index2, bVar40.X);
                        continue;
                    case 55:
                        b bVar41 = aVar.f1484d;
                        bVar41.Y = obtainStyledAttributes.getInt(index2, bVar41.Y);
                        continue;
                    case 56:
                        b bVar42 = aVar.f1484d;
                        bVar42.Z = obtainStyledAttributes.getDimensionPixelSize(index2, bVar42.Z);
                        continue;
                    case 57:
                        b bVar43 = aVar.f1484d;
                        bVar43.a0 = obtainStyledAttributes.getDimensionPixelSize(index2, bVar43.a0);
                        continue;
                    case 58:
                        b bVar44 = aVar.f1484d;
                        bVar44.b0 = obtainStyledAttributes.getDimensionPixelSize(index2, bVar44.b0);
                        continue;
                    case 59:
                        b bVar45 = aVar.f1484d;
                        bVar45.c0 = obtainStyledAttributes.getDimensionPixelSize(index2, bVar45.c0);
                        continue;
                    case 60:
                        e eVar11 = aVar.f1485e;
                        eVar11.b = obtainStyledAttributes.getFloat(index2, eVar11.b);
                        continue;
                    case 61:
                        b bVar46 = aVar.f1484d;
                        int resourceId14 = obtainStyledAttributes.getResourceId(index2, bVar46.z);
                        if (resourceId14 == -1) {
                            resourceId14 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar46.z = resourceId14;
                        continue;
                    case 62:
                        b bVar47 = aVar.f1484d;
                        bVar47.A = obtainStyledAttributes.getDimensionPixelSize(index2, bVar47.A);
                        continue;
                    case 63:
                        b bVar48 = aVar.f1484d;
                        bVar48.B = obtainStyledAttributes.getFloat(index2, bVar48.B);
                        continue;
                    case 64:
                        c cVar5 = aVar.c;
                        int resourceId15 = obtainStyledAttributes.getResourceId(index2, cVar5.b);
                        if (resourceId15 == -1) {
                            resourceId15 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        cVar5.b = resourceId15;
                        continue;
                    case 65:
                        if (obtainStyledAttributes.peekValue(index2).type == 3) {
                            cVar = aVar.c;
                            str = obtainStyledAttributes.getString(index2);
                        } else {
                            cVar = aVar.c;
                            str = e.h.a.h.a.a.c[obtainStyledAttributes.getInteger(index2, 0)];
                        }
                        cVar.f1506d = str;
                        continue;
                    case 66:
                        aVar.c.f1508f = obtainStyledAttributes.getInt(index2, 0);
                        continue;
                    case 67:
                        c cVar6 = aVar.c;
                        cVar6.f1511i = obtainStyledAttributes.getFloat(index2, cVar6.f1511i);
                        break;
                    case 68:
                        C0035d dVar4 = aVar.b;
                        dVar4.f1516e = obtainStyledAttributes.getFloat(index2, dVar4.f1516e);
                        break;
                    case 69:
                        aVar.f1484d.d0 = obtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        aVar.f1484d.e0 = obtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        break;
                    case 72:
                        b bVar49 = aVar.f1484d;
                        bVar49.f0 = obtainStyledAttributes.getInt(index2, bVar49.f0);
                        break;
                    case 73:
                        b bVar50 = aVar.f1484d;
                        bVar50.g0 = obtainStyledAttributes.getDimensionPixelSize(index2, bVar50.g0);
                        break;
                    case 74:
                        aVar.f1484d.j0 = obtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        b bVar51 = aVar.f1484d;
                        bVar51.n0 = obtainStyledAttributes.getBoolean(index2, bVar51.n0);
                        break;
                    case 76:
                        c cVar7 = aVar.c;
                        cVar7.f1507e = obtainStyledAttributes.getInt(index2, cVar7.f1507e);
                        break;
                    case 77:
                        aVar.f1484d.k0 = obtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        C0035d dVar5 = aVar.b;
                        dVar5.c = obtainStyledAttributes.getInt(index2, dVar5.c);
                        break;
                    case 79:
                        c cVar8 = aVar.c;
                        cVar8.f1509g = obtainStyledAttributes.getFloat(index2, cVar8.f1509g);
                        break;
                    case 80:
                        b bVar52 = aVar.f1484d;
                        bVar52.l0 = obtainStyledAttributes.getBoolean(index2, bVar52.l0);
                        break;
                    case 81:
                        b bVar53 = aVar.f1484d;
                        bVar53.m0 = obtainStyledAttributes.getBoolean(index2, bVar53.m0);
                        break;
                    case 82:
                        c cVar9 = aVar.c;
                        cVar9.c = obtainStyledAttributes.getInteger(index2, cVar9.c);
                        break;
                    case 83:
                        e eVar12 = aVar.f1485e;
                        int resourceId16 = obtainStyledAttributes.getResourceId(index2, eVar12.f1522i);
                        if (resourceId16 == -1) {
                            resourceId16 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        eVar12.f1522i = resourceId16;
                        break;
                    case 84:
                        c cVar10 = aVar.c;
                        cVar10.f1513k = obtainStyledAttributes.getInteger(index2, cVar10.f1513k);
                        break;
                    case 85:
                        c cVar11 = aVar.c;
                        cVar11.f1512j = obtainStyledAttributes.getFloat(index2, cVar11.f1512j);
                        break;
                    case 86:
                        int i19 = obtainStyledAttributes.peekValue(index2).type;
                        if (i19 == 1) {
                            aVar.c.n = obtainStyledAttributes.getResourceId(index2, -1);
                            cVar2 = aVar.c;
                            break;
                        } else {
                            if (i19 == 3) {
                                aVar.c.f1514l = obtainStyledAttributes.getString(index2);
                                if (aVar.c.f1514l.indexOf("/") > 0) {
                                    aVar.c.n = obtainStyledAttributes.getResourceId(index2, -1);
                                    cVar2 = aVar.c;
                                } else {
                                    aVar.c.m = -1;
                                }
                            } else {
                                c cVar12 = aVar.c;
                                cVar12.m = obtainStyledAttributes.getInteger(index2, cVar12.n);
                            }
                            break;
                        }
                        cVar2.m = -2;
                    case 87:
                        Integer.toHexString(index2);
                        f1482e.get(index2);
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        Integer.toHexString(index2);
                        f1482e.get(index2);
                        continue;
                    case 91:
                        b bVar54 = aVar.f1484d;
                        int resourceId17 = obtainStyledAttributes.getResourceId(index2, bVar54.q);
                        if (resourceId17 == -1) {
                            resourceId17 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar54.q = resourceId17;
                        break;
                    case 92:
                        b bVar55 = aVar.f1484d;
                        int resourceId18 = obtainStyledAttributes.getResourceId(index2, bVar55.r);
                        if (resourceId18 == -1) {
                            resourceId18 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar55.r = resourceId18;
                        break;
                    case 93:
                        b bVar56 = aVar.f1484d;
                        bVar56.L = obtainStyledAttributes.getDimensionPixelSize(index2, bVar56.L);
                        break;
                    case 94:
                        b bVar57 = aVar.f1484d;
                        bVar57.S = obtainStyledAttributes.getDimensionPixelSize(index2, bVar57.S);
                        break;
                    case 95:
                        g(aVar.f1484d, obtainStyledAttributes, index2, 0);
                        break;
                    case 96:
                        g(aVar.f1484d, obtainStyledAttributes, index2, 1);
                        break;
                    case 97:
                        b bVar58 = aVar.f1484d;
                        bVar58.o0 = obtainStyledAttributes.getInt(index2, bVar58.o0);
                        break;
                }
            }
        }
        obtainStyledAttributes.recycle();
        return aVar;
    }

    public void f(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a e2 = e(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        e2.f1484d.a = true;
                    }
                    this.c.put(Integer.valueOf(e2.a), e2);
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }
}
