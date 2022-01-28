package e.g.c;

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
    public static final int[] f1174d = {0, 4, 8};

    /* renamed from: e  reason: collision with root package name */
    public static SparseIntArray f1175e;
    public HashMap<String, a> a = new HashMap<>();
    public boolean b = true;
    public HashMap<Integer, a> c = new HashMap<>();

    public static class a {
        public int a;
        public final C0028d b = new C0028d();
        public final c c = new c();

        /* renamed from: d  reason: collision with root package name */
        public final b f1176d = new b();

        /* renamed from: e  reason: collision with root package name */
        public final e f1177e = new e();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, a> f1178f = new HashMap<>();

        public void a(ConstraintLayout.a aVar) {
            b bVar = this.f1176d;
            aVar.f119d = bVar.f1183h;
            aVar.f120e = bVar.f1184i;
            aVar.f121f = bVar.f1185j;
            aVar.f122g = bVar.f1186k;
            aVar.f123h = bVar.f1187l;
            aVar.f124i = bVar.m;
            aVar.f125j = bVar.n;
            aVar.f126k = bVar.o;
            aVar.f127l = bVar.p;
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
            b bVar2 = this.f1176d;
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
            aVar.c = bVar2.f1182g;
            aVar.a = bVar2.f1180e;
            aVar.b = bVar2.f1181f;
            ((ViewGroup.MarginLayoutParams) aVar).width = bVar2.c;
            ((ViewGroup.MarginLayoutParams) aVar).height = bVar2.f1179d;
            String str = bVar2.g0;
            if (str != null) {
                aVar.U = str;
            }
            aVar.setMarginStart(this.f1176d.I);
            aVar.setMarginEnd(this.f1176d.H);
            aVar.a();
        }

        public final void b(int i2, ConstraintLayout.a aVar) {
            this.a = i2;
            b bVar = this.f1176d;
            bVar.f1183h = aVar.f119d;
            bVar.f1184i = aVar.f120e;
            bVar.f1185j = aVar.f121f;
            bVar.f1186k = aVar.f122g;
            bVar.f1187l = aVar.f123h;
            bVar.m = aVar.f124i;
            bVar.n = aVar.f125j;
            bVar.o = aVar.f126k;
            bVar.p = aVar.f127l;
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
            bVar.f1182g = aVar.c;
            bVar.f1180e = aVar.a;
            bVar.f1181f = aVar.b;
            b bVar2 = this.f1176d;
            bVar2.c = ((ViewGroup.MarginLayoutParams) aVar).width;
            bVar2.f1179d = ((ViewGroup.MarginLayoutParams) aVar).height;
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
            b bVar3 = this.f1176d;
            bVar3.O = aVar.x;
            bVar3.N = aVar.y;
            bVar3.H = aVar.getMarginEnd();
            this.f1176d.I = aVar.getMarginStart();
        }

        public final void c(int i2, e.a aVar) {
            b(i2, aVar);
            this.b.f1193d = aVar.m0;
            e eVar = this.f1177e;
            eVar.b = aVar.p0;
            eVar.c = aVar.q0;
            eVar.f1195d = aVar.r0;
            eVar.f1196e = aVar.s0;
            eVar.f1197f = aVar.t0;
            eVar.f1198g = aVar.u0;
            eVar.f1199h = aVar.v0;
            eVar.f1200i = aVar.w0;
            eVar.f1201j = aVar.x0;
            eVar.f1202k = aVar.y0;
            eVar.m = aVar.o0;
            eVar.f1203l = aVar.n0;
        }

        public Object clone() {
            a aVar = new a();
            b bVar = aVar.f1176d;
            b bVar2 = this.f1176d;
            Objects.requireNonNull(bVar);
            bVar.a = bVar2.a;
            bVar.c = bVar2.c;
            bVar.b = bVar2.b;
            bVar.f1179d = bVar2.f1179d;
            bVar.f1180e = bVar2.f1180e;
            bVar.f1181f = bVar2.f1181f;
            bVar.f1182g = bVar2.f1182g;
            bVar.f1183h = bVar2.f1183h;
            bVar.f1184i = bVar2.f1184i;
            bVar.f1185j = bVar2.f1185j;
            bVar.f1186k = bVar2.f1186k;
            bVar.f1187l = bVar2.f1187l;
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
            cVar.f1189d = cVar2.f1189d;
            cVar.f1190e = cVar2.f1190e;
            cVar.f1192g = cVar2.f1192g;
            cVar.f1191f = cVar2.f1191f;
            C0028d dVar = aVar.b;
            C0028d dVar2 = this.b;
            Objects.requireNonNull(dVar);
            dVar.a = dVar2.a;
            dVar.b = dVar2.b;
            dVar.f1193d = dVar2.f1193d;
            dVar.f1194e = dVar2.f1194e;
            dVar.c = dVar2.c;
            e eVar = aVar.f1177e;
            e eVar2 = this.f1177e;
            Objects.requireNonNull(eVar);
            eVar.a = eVar2.a;
            eVar.b = eVar2.b;
            eVar.c = eVar2.c;
            eVar.f1195d = eVar2.f1195d;
            eVar.f1196e = eVar2.f1196e;
            eVar.f1197f = eVar2.f1197f;
            eVar.f1198g = eVar2.f1198g;
            eVar.f1199h = eVar2.f1199h;
            eVar.f1200i = eVar2.f1200i;
            eVar.f1201j = eVar2.f1201j;
            eVar.f1202k = eVar2.f1202k;
            eVar.f1203l = eVar2.f1203l;
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
        public int f1179d;
        public int d0 = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f1180e = -1;
        public int[] e0;

        /* renamed from: f  reason: collision with root package name */
        public int f1181f = -1;
        public String f0;

        /* renamed from: g  reason: collision with root package name */
        public float f1182g = -1.0f;
        public String g0;

        /* renamed from: h  reason: collision with root package name */
        public int f1183h = -1;
        public boolean h0 = false;

        /* renamed from: i  reason: collision with root package name */
        public int f1184i = -1;
        public boolean i0 = false;

        /* renamed from: j  reason: collision with root package name */
        public int f1185j = -1;
        public boolean j0 = true;

        /* renamed from: k  reason: collision with root package name */
        public int f1186k = -1;

        /* renamed from: l  reason: collision with root package name */
        public int f1187l = -1;
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
                            int[] iArr = d.f1174d;
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
                            int[] iArr2 = d.f1174d;
                            int resourceId2 = obtainStyledAttributes.getResourceId(index, i5);
                            if (resourceId2 == -1) {
                                resourceId2 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.o = resourceId2;
                            continue;
                        case 4:
                            int i6 = this.n;
                            int[] iArr3 = d.f1174d;
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
                            int[] iArr4 = d.f1174d;
                            int resourceId4 = obtainStyledAttributes.getResourceId(index, i7);
                            if (resourceId4 == -1) {
                                resourceId4 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.t = resourceId4;
                            continue;
                        case 10:
                            int i8 = this.s;
                            int[] iArr5 = d.f1174d;
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
                            this.f1180e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1180e);
                            continue;
                        case 18:
                            this.f1181f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1181f);
                            continue;
                        case 19:
                            this.f1182g = obtainStyledAttributes.getFloat(index, this.f1182g);
                            continue;
                        case 20:
                            this.u = obtainStyledAttributes.getFloat(index, this.u);
                            continue;
                        case 21:
                            this.f1179d = obtainStyledAttributes.getLayoutDimension(index, this.f1179d);
                            continue;
                        case 22:
                            this.c = obtainStyledAttributes.getLayoutDimension(index, this.c);
                            continue;
                        case 23:
                            this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                            continue;
                        case 24:
                            int i9 = this.f1183h;
                            int[] iArr6 = d.f1174d;
                            int resourceId6 = obtainStyledAttributes.getResourceId(index, i9);
                            if (resourceId6 == -1) {
                                resourceId6 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1183h = resourceId6;
                            continue;
                        case 25:
                            int i10 = this.f1184i;
                            int[] iArr7 = d.f1174d;
                            int resourceId7 = obtainStyledAttributes.getResourceId(index, i10);
                            if (resourceId7 == -1) {
                                resourceId7 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1184i = resourceId7;
                            continue;
                        case 26:
                            this.C = obtainStyledAttributes.getInt(index, this.C);
                            continue;
                        case 27:
                            this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                            continue;
                        case 28:
                            int i11 = this.f1185j;
                            int[] iArr8 = d.f1174d;
                            int resourceId8 = obtainStyledAttributes.getResourceId(index, i11);
                            if (resourceId8 == -1) {
                                resourceId8 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1185j = resourceId8;
                            continue;
                        case 29:
                            int i12 = this.f1186k;
                            int[] iArr9 = d.f1174d;
                            int resourceId9 = obtainStyledAttributes.getResourceId(index, i12);
                            if (resourceId9 == -1) {
                                resourceId9 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1186k = resourceId9;
                            continue;
                        case 30:
                            this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                            continue;
                        case 31:
                            int i13 = this.q;
                            int[] iArr10 = d.f1174d;
                            int resourceId10 = obtainStyledAttributes.getResourceId(index, i13);
                            if (resourceId10 == -1) {
                                resourceId10 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.q = resourceId10;
                            continue;
                        case 32:
                            int i14 = this.r;
                            int[] iArr11 = d.f1174d;
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
                            int[] iArr12 = d.f1174d;
                            int resourceId12 = obtainStyledAttributes.getResourceId(index, i15);
                            if (resourceId12 == -1) {
                                resourceId12 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.m = resourceId12;
                            continue;
                        case 35:
                            int i16 = this.f1187l;
                            int[] iArr13 = d.f1174d;
                            int resourceId13 = obtainStyledAttributes.getResourceId(index, i16);
                            if (resourceId13 == -1) {
                                resourceId13 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1187l = resourceId13;
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
                                            int i17 = this.x;
                                            int[] iArr14 = d.f1174d;
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

        /* renamed from: h  reason: collision with root package name */
        public static SparseIntArray f1188h;
        public boolean a = false;
        public int b = -1;
        public String c = null;

        /* renamed from: d  reason: collision with root package name */
        public int f1189d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f1190e = 0;

        /* renamed from: f  reason: collision with root package name */
        public float f1191f = Float.NaN;

        /* renamed from: g  reason: collision with root package name */
        public float f1192g = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1188h = sparseIntArray;
            sparseIntArray.append(R$styleable.Motion_motionPathRotate, 1);
            f1188h.append(R$styleable.Motion_pathMotionArc, 2);
            f1188h.append(R$styleable.Motion_transitionEasing, 3);
            f1188h.append(R$styleable.Motion_drawPath, 4);
            f1188h.append(R$styleable.Motion_animate_relativeTo, 5);
            f1188h.append(R$styleable.Motion_motionStagger, 6);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Motion);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (f1188h.get(index)) {
                    case 1:
                        this.f1192g = obtainStyledAttributes.getFloat(index, this.f1192g);
                        break;
                    case 2:
                        this.f1189d = obtainStyledAttributes.getInt(index, this.f1189d);
                        break;
                    case 3:
                        this.c = obtainStyledAttributes.peekValue(index).type == 3 ? obtainStyledAttributes.getString(index) : e.g.a.a.a.a[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    case 4:
                        this.f1190e = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        int i3 = this.b;
                        int[] iArr = d.f1174d;
                        int resourceId = obtainStyledAttributes.getResourceId(index, i3);
                        if (resourceId == -1) {
                            resourceId = obtainStyledAttributes.getInt(index, -1);
                        }
                        this.b = resourceId;
                        break;
                    case 6:
                        this.f1191f = obtainStyledAttributes.getFloat(index, this.f1191f);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: e.g.c.d$d  reason: collision with other inner class name */
    public static class C0028d {
        public boolean a = false;
        public int b = 0;
        public int c = 0;

        /* renamed from: d  reason: collision with root package name */
        public float f1193d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f1194e = Float.NaN;

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PropertySet);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.PropertySet_android_alpha) {
                    this.f1193d = obtainStyledAttributes.getFloat(index, this.f1193d);
                } else if (index == R$styleable.PropertySet_android_visibility) {
                    int i3 = obtainStyledAttributes.getInt(index, this.b);
                    this.b = i3;
                    int[] iArr = d.f1174d;
                    this.b = d.f1174d[i3];
                } else if (index == R$styleable.PropertySet_visibilityMode) {
                    this.c = obtainStyledAttributes.getInt(index, this.c);
                } else if (index == R$styleable.PropertySet_motionProgress) {
                    this.f1194e = obtainStyledAttributes.getFloat(index, this.f1194e);
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
        public float f1195d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f1196e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f1197f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f1198g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public float f1199h = Float.NaN;

        /* renamed from: i  reason: collision with root package name */
        public float f1200i = 0.0f;

        /* renamed from: j  reason: collision with root package name */
        public float f1201j = 0.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f1202k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public boolean f1203l = false;
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
                        this.f1195d = obtainStyledAttributes.getFloat(index, this.f1195d);
                        break;
                    case 4:
                        this.f1196e = obtainStyledAttributes.getFloat(index, this.f1196e);
                        break;
                    case 5:
                        this.f1197f = obtainStyledAttributes.getFloat(index, this.f1197f);
                        break;
                    case 6:
                        this.f1198g = obtainStyledAttributes.getDimension(index, this.f1198g);
                        break;
                    case 7:
                        this.f1199h = obtainStyledAttributes.getDimension(index, this.f1199h);
                        break;
                    case 8:
                        this.f1200i = obtainStyledAttributes.getDimension(index, this.f1200i);
                        break;
                    case 9:
                        this.f1201j = obtainStyledAttributes.getDimension(index, this.f1201j);
                        break;
                    case 10:
                        this.f1202k = obtainStyledAttributes.getDimension(index, this.f1202k);
                        break;
                    case 11:
                        this.f1203l = true;
                        this.m = obtainStyledAttributes.getDimension(index, this.m);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1175e = sparseIntArray;
        sparseIntArray.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        f1175e.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        f1175e.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        f1175e.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        f1175e.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        f1175e.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        f1175e.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        f1175e.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        f1175e.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f1175e.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        f1175e.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        f1175e.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        f1175e.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        f1175e.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        f1175e.append(R$styleable.Constraint_android_orientation, 27);
        f1175e.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        f1175e.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        f1175e.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        f1175e.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        f1175e.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        f1175e.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        f1175e.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        f1175e.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        f1175e.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        f1175e.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        f1175e.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        f1175e.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        f1175e.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f1175e.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        f1175e.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        f1175e.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        f1175e.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        f1175e.append(R$styleable.Constraint_layout_constraintLeft_creator, 82);
        f1175e.append(R$styleable.Constraint_layout_constraintTop_creator, 82);
        f1175e.append(R$styleable.Constraint_layout_constraintRight_creator, 82);
        f1175e.append(R$styleable.Constraint_layout_constraintBottom_creator, 82);
        f1175e.append(R$styleable.Constraint_layout_constraintBaseline_creator, 82);
        f1175e.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        f1175e.append(R$styleable.Constraint_android_layout_marginRight, 28);
        f1175e.append(R$styleable.Constraint_android_layout_marginStart, 31);
        f1175e.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        f1175e.append(R$styleable.Constraint_android_layout_marginTop, 34);
        f1175e.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        f1175e.append(R$styleable.Constraint_android_layout_width, 23);
        f1175e.append(R$styleable.Constraint_android_layout_height, 21);
        f1175e.append(R$styleable.Constraint_android_visibility, 22);
        f1175e.append(R$styleable.Constraint_android_alpha, 43);
        f1175e.append(R$styleable.Constraint_android_elevation, 44);
        f1175e.append(R$styleable.Constraint_android_rotationX, 45);
        f1175e.append(R$styleable.Constraint_android_rotationY, 46);
        f1175e.append(R$styleable.Constraint_android_rotation, 60);
        f1175e.append(R$styleable.Constraint_android_scaleX, 47);
        f1175e.append(R$styleable.Constraint_android_scaleY, 48);
        f1175e.append(R$styleable.Constraint_android_transformPivotX, 49);
        f1175e.append(R$styleable.Constraint_android_transformPivotY, 50);
        f1175e.append(R$styleable.Constraint_android_translationX, 51);
        f1175e.append(R$styleable.Constraint_android_translationY, 52);
        f1175e.append(R$styleable.Constraint_android_translationZ, 53);
        f1175e.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        f1175e.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        f1175e.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        f1175e.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        f1175e.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        f1175e.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        f1175e.append(R$styleable.Constraint_layout_constraintCircle, 61);
        f1175e.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        f1175e.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        f1175e.append(R$styleable.Constraint_animate_relativeTo, 64);
        f1175e.append(R$styleable.Constraint_transitionEasing, 65);
        f1175e.append(R$styleable.Constraint_drawPath, 66);
        f1175e.append(R$styleable.Constraint_transitionPathRotate, 67);
        f1175e.append(R$styleable.Constraint_motionStagger, 79);
        f1175e.append(R$styleable.Constraint_android_id, 38);
        f1175e.append(R$styleable.Constraint_motionProgress, 68);
        f1175e.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        f1175e.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        f1175e.append(R$styleable.Constraint_chainUseRtl, 71);
        f1175e.append(R$styleable.Constraint_barrierDirection, 72);
        f1175e.append(R$styleable.Constraint_barrierMargin, 73);
        f1175e.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        f1175e.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        f1175e.append(R$styleable.Constraint_pathMotionArc, 76);
        f1175e.append(R$styleable.Constraint_layout_constraintTag, 77);
        f1175e.append(R$styleable.Constraint_visibilityMode, 78);
        f1175e.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        f1175e.append(R$styleable.Constraint_layout_constrainedHeight, 81);
    }

    public void a(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.c.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.c.containsKey(Integer.valueOf(id))) {
                try {
                    childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                }
            } else if (this.b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1 && this.c.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                a aVar = this.c.get(Integer.valueOf(id));
                if (childAt instanceof Barrier) {
                    aVar.f1176d.d0 = 1;
                }
                int i3 = aVar.f1176d.d0;
                if (i3 != -1 && i3 == 1) {
                    Barrier barrier = (Barrier) childAt;
                    barrier.setId(id);
                    barrier.setType(aVar.f1176d.b0);
                    barrier.setMargin(aVar.f1176d.c0);
                    barrier.setAllowsGoneWidget(aVar.f1176d.j0);
                    b bVar = aVar.f1176d;
                    int[] iArr = bVar.e0;
                    if (iArr != null) {
                        barrier.setReferencedIds(iArr);
                    } else {
                        String str = bVar.f0;
                        if (str != null) {
                            bVar.e0 = c(barrier, str);
                            barrier.setReferencedIds(aVar.f1176d.e0);
                        }
                    }
                }
                ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
                aVar2.a();
                aVar.a(aVar2);
                if (z) {
                    HashMap<String, a> hashMap = aVar.f1178f;
                    Class<?> cls = childAt.getClass();
                    for (String str2 : hashMap.keySet()) {
                        a aVar3 = hashMap.get(str2);
                        String c2 = f.a.a.a.a.c("set", str2);
                        try {
                            switch (aVar3.b.ordinal()) {
                                case 0:
                                    cls.getMethod(c2, Integer.TYPE).invoke(childAt, Integer.valueOf(aVar3.c));
                                    break;
                                case 1:
                                    cls.getMethod(c2, Float.TYPE).invoke(childAt, Float.valueOf(aVar3.f1155d));
                                    break;
                                case 2:
                                    cls.getMethod(c2, Integer.TYPE).invoke(childAt, Integer.valueOf(aVar3.f1158g));
                                    break;
                                case 3:
                                    Method method = cls.getMethod(c2, Drawable.class);
                                    ColorDrawable colorDrawable = new ColorDrawable();
                                    colorDrawable.setColor(aVar3.f1158g);
                                    method.invoke(childAt, colorDrawable);
                                    break;
                                case 4:
                                    cls.getMethod(c2, CharSequence.class).invoke(childAt, aVar3.f1156e);
                                    break;
                                case 5:
                                    cls.getMethod(c2, Boolean.TYPE).invoke(childAt, Boolean.valueOf(aVar3.f1157f));
                                    break;
                                case 6:
                                    cls.getMethod(c2, Float.TYPE).invoke(childAt, Float.valueOf(aVar3.f1155d));
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
                C0028d dVar = aVar.b;
                if (dVar.c == 0) {
                    childAt.setVisibility(dVar.b);
                }
                childAt.setAlpha(aVar.b.f1193d);
                childAt.setRotation(aVar.f1177e.b);
                childAt.setRotationX(aVar.f1177e.c);
                childAt.setRotationY(aVar.f1177e.f1195d);
                childAt.setScaleX(aVar.f1177e.f1196e);
                childAt.setScaleY(aVar.f1177e.f1197f);
                if (!Float.isNaN(aVar.f1177e.f1198g)) {
                    childAt.setPivotX(aVar.f1177e.f1198g);
                }
                if (!Float.isNaN(aVar.f1177e.f1199h)) {
                    childAt.setPivotY(aVar.f1177e.f1199h);
                }
                childAt.setTranslationX(aVar.f1177e.f1200i);
                childAt.setTranslationY(aVar.f1177e.f1201j);
                childAt.setTranslationZ(aVar.f1177e.f1202k);
                e eVar = aVar.f1177e;
                if (eVar.f1203l) {
                    childAt.setElevation(eVar.m);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar4 = this.c.get(num);
            int i4 = aVar4.f1176d.d0;
            if (i4 != -1 && i4 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                b bVar2 = aVar4.f1176d;
                int[] iArr2 = bVar2.e0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str3 = bVar2.f0;
                    if (str3 != null) {
                        bVar2.e0 = c(barrier2, str3);
                        barrier2.setReferencedIds(aVar4.f1176d.e0);
                    }
                }
                barrier2.setType(aVar4.f1176d.b0);
                barrier2.setMargin(aVar4.f1176d.c0);
                ConstraintLayout.a b2 = constraintLayout.generateDefaultLayoutParams();
                barrier2.k();
                aVar4.a(b2);
                constraintLayout.addView(barrier2, b2);
            }
            if (aVar4.f1176d.a) {
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
                aVar3.f1178f = hashMap2;
                aVar3.b(id, aVar2);
                aVar3.b.b = childAt.getVisibility();
                aVar3.b.f1193d = childAt.getAlpha();
                aVar3.f1177e.b = childAt.getRotation();
                aVar3.f1177e.c = childAt.getRotationX();
                aVar3.f1177e.f1195d = childAt.getRotationY();
                aVar3.f1177e.f1196e = childAt.getScaleX();
                aVar3.f1177e.f1197f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                    e eVar = aVar3.f1177e;
                    eVar.f1198g = pivotX;
                    eVar.f1199h = pivotY;
                }
                aVar3.f1177e.f1200i = childAt.getTranslationX();
                aVar3.f1177e.f1201j = childAt.getTranslationY();
                aVar3.f1177e.f1202k = childAt.getTranslationZ();
                e eVar2 = aVar3.f1177e;
                if (eVar2.f1203l) {
                    eVar2.m = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    b bVar = aVar3.f1176d;
                    bVar.j0 = barrier.f109k.o0;
                    bVar.e0 = barrier.getReferencedIds();
                    aVar3.f1176d.b0 = barrier.getType();
                    aVar3.f1176d.c0 = barrier.getMargin();
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
        c cVar;
        String str;
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Constraint);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (!(index == R$styleable.Constraint_android_id || R$styleable.Constraint_android_layout_marginStart == index || R$styleable.Constraint_android_layout_marginEnd == index)) {
                aVar.c.a = true;
                aVar.f1176d.b = true;
                aVar.b.a = true;
                aVar.f1177e.a = true;
            }
            switch (f1175e.get(index)) {
                case 1:
                    b bVar = aVar.f1176d;
                    int resourceId = obtainStyledAttributes.getResourceId(index, bVar.p);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar.p = resourceId;
                    break;
                case 2:
                    b bVar2 = aVar.f1176d;
                    bVar2.G = obtainStyledAttributes.getDimensionPixelSize(index, bVar2.G);
                    break;
                case 3:
                    b bVar3 = aVar.f1176d;
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, bVar3.o);
                    if (resourceId2 == -1) {
                        resourceId2 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar3.o = resourceId2;
                    break;
                case 4:
                    b bVar4 = aVar.f1176d;
                    int resourceId3 = obtainStyledAttributes.getResourceId(index, bVar4.n);
                    if (resourceId3 == -1) {
                        resourceId3 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar4.n = resourceId3;
                    break;
                case 5:
                    aVar.f1176d.w = obtainStyledAttributes.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f1176d;
                    bVar5.A = obtainStyledAttributes.getDimensionPixelOffset(index, bVar5.A);
                    break;
                case 7:
                    b bVar6 = aVar.f1176d;
                    bVar6.B = obtainStyledAttributes.getDimensionPixelOffset(index, bVar6.B);
                    break;
                case 8:
                    b bVar7 = aVar.f1176d;
                    bVar7.H = obtainStyledAttributes.getDimensionPixelSize(index, bVar7.H);
                    break;
                case 9:
                    b bVar8 = aVar.f1176d;
                    int resourceId4 = obtainStyledAttributes.getResourceId(index, bVar8.t);
                    if (resourceId4 == -1) {
                        resourceId4 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar8.t = resourceId4;
                    break;
                case 10:
                    b bVar9 = aVar.f1176d;
                    int resourceId5 = obtainStyledAttributes.getResourceId(index, bVar9.s);
                    if (resourceId5 == -1) {
                        resourceId5 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar9.s = resourceId5;
                    break;
                case 11:
                    b bVar10 = aVar.f1176d;
                    bVar10.M = obtainStyledAttributes.getDimensionPixelSize(index, bVar10.M);
                    break;
                case 12:
                    b bVar11 = aVar.f1176d;
                    bVar11.N = obtainStyledAttributes.getDimensionPixelSize(index, bVar11.N);
                    break;
                case 13:
                    b bVar12 = aVar.f1176d;
                    bVar12.J = obtainStyledAttributes.getDimensionPixelSize(index, bVar12.J);
                    break;
                case 14:
                    b bVar13 = aVar.f1176d;
                    bVar13.L = obtainStyledAttributes.getDimensionPixelSize(index, bVar13.L);
                    break;
                case 15:
                    b bVar14 = aVar.f1176d;
                    bVar14.O = obtainStyledAttributes.getDimensionPixelSize(index, bVar14.O);
                    break;
                case 16:
                    b bVar15 = aVar.f1176d;
                    bVar15.K = obtainStyledAttributes.getDimensionPixelSize(index, bVar15.K);
                    break;
                case 17:
                    b bVar16 = aVar.f1176d;
                    bVar16.f1180e = obtainStyledAttributes.getDimensionPixelOffset(index, bVar16.f1180e);
                    break;
                case 18:
                    b bVar17 = aVar.f1176d;
                    bVar17.f1181f = obtainStyledAttributes.getDimensionPixelOffset(index, bVar17.f1181f);
                    break;
                case 19:
                    b bVar18 = aVar.f1176d;
                    bVar18.f1182g = obtainStyledAttributes.getFloat(index, bVar18.f1182g);
                    break;
                case 20:
                    b bVar19 = aVar.f1176d;
                    bVar19.u = obtainStyledAttributes.getFloat(index, bVar19.u);
                    break;
                case 21:
                    b bVar20 = aVar.f1176d;
                    bVar20.f1179d = obtainStyledAttributes.getLayoutDimension(index, bVar20.f1179d);
                    break;
                case 22:
                    C0028d dVar = aVar.b;
                    dVar.b = obtainStyledAttributes.getInt(index, dVar.b);
                    C0028d dVar2 = aVar.b;
                    dVar2.b = f1174d[dVar2.b];
                    break;
                case 23:
                    b bVar21 = aVar.f1176d;
                    bVar21.c = obtainStyledAttributes.getLayoutDimension(index, bVar21.c);
                    break;
                case 24:
                    b bVar22 = aVar.f1176d;
                    bVar22.D = obtainStyledAttributes.getDimensionPixelSize(index, bVar22.D);
                    break;
                case 25:
                    b bVar23 = aVar.f1176d;
                    int resourceId6 = obtainStyledAttributes.getResourceId(index, bVar23.f1183h);
                    if (resourceId6 == -1) {
                        resourceId6 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar23.f1183h = resourceId6;
                    break;
                case 26:
                    b bVar24 = aVar.f1176d;
                    int resourceId7 = obtainStyledAttributes.getResourceId(index, bVar24.f1184i);
                    if (resourceId7 == -1) {
                        resourceId7 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar24.f1184i = resourceId7;
                    break;
                case 27:
                    b bVar25 = aVar.f1176d;
                    bVar25.C = obtainStyledAttributes.getInt(index, bVar25.C);
                    break;
                case 28:
                    b bVar26 = aVar.f1176d;
                    bVar26.E = obtainStyledAttributes.getDimensionPixelSize(index, bVar26.E);
                    break;
                case 29:
                    b bVar27 = aVar.f1176d;
                    int resourceId8 = obtainStyledAttributes.getResourceId(index, bVar27.f1185j);
                    if (resourceId8 == -1) {
                        resourceId8 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar27.f1185j = resourceId8;
                    break;
                case 30:
                    b bVar28 = aVar.f1176d;
                    int resourceId9 = obtainStyledAttributes.getResourceId(index, bVar28.f1186k);
                    if (resourceId9 == -1) {
                        resourceId9 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar28.f1186k = resourceId9;
                    break;
                case 31:
                    b bVar29 = aVar.f1176d;
                    bVar29.I = obtainStyledAttributes.getDimensionPixelSize(index, bVar29.I);
                    break;
                case 32:
                    b bVar30 = aVar.f1176d;
                    int resourceId10 = obtainStyledAttributes.getResourceId(index, bVar30.q);
                    if (resourceId10 == -1) {
                        resourceId10 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar30.q = resourceId10;
                    break;
                case 33:
                    b bVar31 = aVar.f1176d;
                    int resourceId11 = obtainStyledAttributes.getResourceId(index, bVar31.r);
                    if (resourceId11 == -1) {
                        resourceId11 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar31.r = resourceId11;
                    break;
                case 34:
                    b bVar32 = aVar.f1176d;
                    bVar32.F = obtainStyledAttributes.getDimensionPixelSize(index, bVar32.F);
                    break;
                case 35:
                    b bVar33 = aVar.f1176d;
                    int resourceId12 = obtainStyledAttributes.getResourceId(index, bVar33.m);
                    if (resourceId12 == -1) {
                        resourceId12 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar33.m = resourceId12;
                    break;
                case 36:
                    b bVar34 = aVar.f1176d;
                    int resourceId13 = obtainStyledAttributes.getResourceId(index, bVar34.f1187l);
                    if (resourceId13 == -1) {
                        resourceId13 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar34.f1187l = resourceId13;
                    break;
                case 37:
                    b bVar35 = aVar.f1176d;
                    bVar35.v = obtainStyledAttributes.getFloat(index, bVar35.v);
                    break;
                case 38:
                    aVar.a = obtainStyledAttributes.getResourceId(index, aVar.a);
                    break;
                case 39:
                    b bVar36 = aVar.f1176d;
                    bVar36.Q = obtainStyledAttributes.getFloat(index, bVar36.Q);
                    break;
                case 40:
                    b bVar37 = aVar.f1176d;
                    bVar37.P = obtainStyledAttributes.getFloat(index, bVar37.P);
                    break;
                case 41:
                    b bVar38 = aVar.f1176d;
                    bVar38.R = obtainStyledAttributes.getInt(index, bVar38.R);
                    break;
                case 42:
                    b bVar39 = aVar.f1176d;
                    bVar39.S = obtainStyledAttributes.getInt(index, bVar39.S);
                    break;
                case 43:
                    C0028d dVar3 = aVar.b;
                    dVar3.f1193d = obtainStyledAttributes.getFloat(index, dVar3.f1193d);
                    break;
                case 44:
                    e eVar = aVar.f1177e;
                    eVar.f1203l = true;
                    eVar.m = obtainStyledAttributes.getDimension(index, eVar.m);
                    break;
                case 45:
                    e eVar2 = aVar.f1177e;
                    eVar2.c = obtainStyledAttributes.getFloat(index, eVar2.c);
                    break;
                case 46:
                    e eVar3 = aVar.f1177e;
                    eVar3.f1195d = obtainStyledAttributes.getFloat(index, eVar3.f1195d);
                    break;
                case 47:
                    e eVar4 = aVar.f1177e;
                    eVar4.f1196e = obtainStyledAttributes.getFloat(index, eVar4.f1196e);
                    break;
                case 48:
                    e eVar5 = aVar.f1177e;
                    eVar5.f1197f = obtainStyledAttributes.getFloat(index, eVar5.f1197f);
                    break;
                case 49:
                    e eVar6 = aVar.f1177e;
                    eVar6.f1198g = obtainStyledAttributes.getDimension(index, eVar6.f1198g);
                    break;
                case 50:
                    e eVar7 = aVar.f1177e;
                    eVar7.f1199h = obtainStyledAttributes.getDimension(index, eVar7.f1199h);
                    break;
                case 51:
                    e eVar8 = aVar.f1177e;
                    eVar8.f1200i = obtainStyledAttributes.getDimension(index, eVar8.f1200i);
                    break;
                case 52:
                    e eVar9 = aVar.f1177e;
                    eVar9.f1201j = obtainStyledAttributes.getDimension(index, eVar9.f1201j);
                    break;
                case 53:
                    e eVar10 = aVar.f1177e;
                    eVar10.f1202k = obtainStyledAttributes.getDimension(index, eVar10.f1202k);
                    break;
                case 54:
                    b bVar40 = aVar.f1176d;
                    bVar40.T = obtainStyledAttributes.getInt(index, bVar40.T);
                    break;
                case 55:
                    b bVar41 = aVar.f1176d;
                    bVar41.U = obtainStyledAttributes.getInt(index, bVar41.U);
                    break;
                case 56:
                    b bVar42 = aVar.f1176d;
                    bVar42.V = obtainStyledAttributes.getDimensionPixelSize(index, bVar42.V);
                    break;
                case 57:
                    b bVar43 = aVar.f1176d;
                    bVar43.W = obtainStyledAttributes.getDimensionPixelSize(index, bVar43.W);
                    break;
                case 58:
                    b bVar44 = aVar.f1176d;
                    bVar44.X = obtainStyledAttributes.getDimensionPixelSize(index, bVar44.X);
                    break;
                case 59:
                    b bVar45 = aVar.f1176d;
                    bVar45.Y = obtainStyledAttributes.getDimensionPixelSize(index, bVar45.Y);
                    break;
                case 60:
                    e eVar11 = aVar.f1177e;
                    eVar11.b = obtainStyledAttributes.getFloat(index, eVar11.b);
                    break;
                case 61:
                    b bVar46 = aVar.f1176d;
                    int resourceId14 = obtainStyledAttributes.getResourceId(index, bVar46.x);
                    if (resourceId14 == -1) {
                        resourceId14 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar46.x = resourceId14;
                    break;
                case 62:
                    b bVar47 = aVar.f1176d;
                    bVar47.y = obtainStyledAttributes.getDimensionPixelSize(index, bVar47.y);
                    break;
                case 63:
                    b bVar48 = aVar.f1176d;
                    bVar48.z = obtainStyledAttributes.getFloat(index, bVar48.z);
                    break;
                case 64:
                    c cVar2 = aVar.c;
                    int resourceId15 = obtainStyledAttributes.getResourceId(index, cVar2.b);
                    if (resourceId15 == -1) {
                        resourceId15 = obtainStyledAttributes.getInt(index, -1);
                    }
                    cVar2.b = resourceId15;
                    break;
                case 65:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        cVar = aVar.c;
                        str = obtainStyledAttributes.getString(index);
                    } else {
                        cVar = aVar.c;
                        str = e.g.a.a.a.a[obtainStyledAttributes.getInteger(index, 0)];
                    }
                    cVar.c = str;
                    break;
                case 66:
                    aVar.c.f1190e = obtainStyledAttributes.getInt(index, 0);
                    break;
                case 67:
                    c cVar3 = aVar.c;
                    cVar3.f1192g = obtainStyledAttributes.getFloat(index, cVar3.f1192g);
                    break;
                case 68:
                    C0028d dVar4 = aVar.b;
                    dVar4.f1194e = obtainStyledAttributes.getFloat(index, dVar4.f1194e);
                    break;
                case 69:
                    aVar.f1176d.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f1176d.a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 71:
                    break;
                case 72:
                    b bVar49 = aVar.f1176d;
                    bVar49.b0 = obtainStyledAttributes.getInt(index, bVar49.b0);
                    break;
                case 73:
                    b bVar50 = aVar.f1176d;
                    bVar50.c0 = obtainStyledAttributes.getDimensionPixelSize(index, bVar50.c0);
                    break;
                case 74:
                    aVar.f1176d.f0 = obtainStyledAttributes.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f1176d;
                    bVar51.j0 = obtainStyledAttributes.getBoolean(index, bVar51.j0);
                    break;
                case 76:
                    c cVar4 = aVar.c;
                    cVar4.f1189d = obtainStyledAttributes.getInt(index, cVar4.f1189d);
                    break;
                case 77:
                    aVar.f1176d.g0 = obtainStyledAttributes.getString(index);
                    break;
                case 78:
                    C0028d dVar5 = aVar.b;
                    dVar5.c = obtainStyledAttributes.getInt(index, dVar5.c);
                    break;
                case 79:
                    c cVar5 = aVar.c;
                    cVar5.f1191f = obtainStyledAttributes.getFloat(index, cVar5.f1191f);
                    break;
                case 80:
                    b bVar52 = aVar.f1176d;
                    bVar52.h0 = obtainStyledAttributes.getBoolean(index, bVar52.h0);
                    break;
                case 81:
                    b bVar53 = aVar.f1176d;
                    bVar53.i0 = obtainStyledAttributes.getBoolean(index, bVar53.i0);
                    break;
                default:
                    Integer.toHexString(index);
                    f1175e.get(index);
                    break;
            }
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
                        d2.f1176d.a = true;
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
