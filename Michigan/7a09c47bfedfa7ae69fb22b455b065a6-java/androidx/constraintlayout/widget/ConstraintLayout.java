package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
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
import androidx.recyclerview.widget.RecyclerView;
import b.g.b.h.c;
import b.g.b.h.d;
import b.g.b.h.e;
import b.g.b.h.f;
import b.g.b.h.g;
import b.g.b.h.h;
import b.g.b.h.k;
import b.g.b.h.l.b;
import b.g.b.h.l.l;
import b.g.b.h.l.m;
import b.g.c.c;
import b.g.c.d;
import b.g.c.i;
import b.g.c.j;
import com.google.android.gms.nearby.messages.BleSignal;
import gov.michigan.MiCovidExposure.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class ConstraintLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f163b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b.g.c.b> f164c = new ArrayList<>(4);

    /* renamed from: d  reason: collision with root package name */
    public e f165d = new e();

    /* renamed from: e  reason: collision with root package name */
    public int f166e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f167f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f168g = Integer.MAX_VALUE;
    public int h = Integer.MAX_VALUE;
    public boolean i = true;
    public int j = 7;
    public d k = null;
    public c l = null;
    public int m = -1;
    public HashMap<String, Integer> n = new HashMap<>();
    public int o = -1;
    public int p = -1;
    public SparseArray<b.g.b.h.d> q = new SparseArray<>();
    public b r = new b(this, this);
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

        /* renamed from: a  reason: collision with root package name */
        public int f169a = -1;
        public boolean a0 = false;

        /* renamed from: b  reason: collision with root package name */
        public int f170b = -1;
        public boolean b0 = false;

        /* renamed from: c  reason: collision with root package name */
        public float f171c = -1.0f;
        public int c0 = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f172d = -1;
        public int d0 = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f173e = -1;
        public int e0 = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f174f = -1;
        public int f0 = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f175g = -1;
        public int g0 = -1;
        public int h = -1;
        public int h0 = -1;
        public int i = -1;
        public float i0 = 0.5f;
        public int j = -1;
        public int j0;
        public int k = -1;
        public int k0;
        public int l = -1;
        public float l0;
        public int m = -1;
        public b.g.b.h.d m0 = new b.g.b.h.d();
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
        public static class C0003a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f176a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f176a = sparseIntArray;
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f176a.append(i.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f176a.append(i.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f176a.append(i.ConstraintLayout_Layout_android_orientation, 1);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f176a.append(i.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f176a.append(i.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f176a.append(i.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f176a.append(i.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f176a.append(i.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f176a.append(i.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f176a.append(i.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f176a.append(i.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                f176a.append(i.ConstraintLayout_Layout_layout_constraintTag, 51);
            }
        }

        public a(int i2, int i3) {
            super(i2, i3);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i2;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                int i4 = C0003a.f176a.get(index);
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
                        this.f169a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f169a);
                        break;
                    case 6:
                        this.f170b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f170b);
                        break;
                    case 7:
                        this.f171c = obtainStyledAttributes.getFloat(index, this.f171c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f172d);
                        this.f172d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f172d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f173e);
                        this.f173e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f173e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f174f);
                        this.f174f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f174f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f175g);
                        this.f175g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f175g = obtainStyledAttributes.getInt(index, -1);
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
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.B.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i2 = 0;
                                    } else {
                                        String substring = this.B.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.C = 0;
                                        } else if (substring.equalsIgnoreCase(BuildConfig.DOWNLOAD_SCHEDULE_UNIT)) {
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
            if (((ViewGroup.MarginLayoutParams) this).width == -2 && this.S) {
                this.V = false;
                if (this.H == 0) {
                    this.H = 1;
                }
            }
            if (((ViewGroup.MarginLayoutParams) this).height == -2 && this.T) {
                this.W = false;
                if (this.I == 0) {
                    this.I = 1;
                }
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i2 == 0 || i2 == -1) {
                this.V = false;
                if (((ViewGroup.MarginLayoutParams) this).width == 0 && this.H == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.S = true;
                }
            }
            int i3 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i3 == 0 || i3 == -1) {
                this.W = false;
                if (((ViewGroup.MarginLayoutParams) this).height == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.T = true;
                }
            }
            if (this.f171c != -1.0f || this.f169a != -1 || this.f170b != -1) {
                this.Y = true;
                this.V = true;
                this.W = true;
                if (!(this.m0 instanceof f)) {
                    this.m0 = new f();
                }
                ((f) this.m0).E(this.R);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00d6, code lost:
            if (r1 > 0) goto L_0x00d8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x00e5, code lost:
            if (r1 > 0) goto L_0x00d8;
         */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0084  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x00ec  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x00f7  */
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
            boolean z2 = false;
            boolean z3 = 1 == getLayoutDirection();
            this.e0 = -1;
            this.f0 = -1;
            this.c0 = -1;
            this.d0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.g0 = this.t;
            this.h0 = this.v;
            this.i0 = this.z;
            this.j0 = this.f169a;
            this.k0 = this.f170b;
            this.l0 = this.f171c;
            if (z3) {
                int i10 = this.p;
                if (i10 != -1) {
                    this.e0 = i10;
                } else {
                    int i11 = this.q;
                    if (i11 != -1) {
                        this.f0 = i11;
                    }
                    i4 = this.r;
                    if (i4 != -1) {
                        this.d0 = i4;
                        z2 = true;
                    }
                    i5 = this.s;
                    if (i5 != -1) {
                        this.c0 = i5;
                        z2 = true;
                    }
                    i6 = this.x;
                    if (i6 != -1) {
                        this.h0 = i6;
                    }
                    i7 = this.y;
                    if (i7 != -1) {
                        this.g0 = i7;
                    }
                    if (z2) {
                        this.i0 = 1.0f - this.z;
                    }
                    if (this.Y && this.R == 1) {
                        f2 = this.f171c;
                        if (f2 == -1.0f) {
                            this.l0 = 1.0f - f2;
                            this.j0 = -1;
                            this.k0 = -1;
                        } else {
                            int i12 = this.f169a;
                            if (i12 != -1) {
                                this.k0 = i12;
                                this.j0 = -1;
                            } else {
                                int i13 = this.f170b;
                                if (i13 != -1) {
                                    this.j0 = i13;
                                    this.k0 = -1;
                                }
                            }
                            this.l0 = -1.0f;
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
                f2 = this.f171c;
                if (f2 == -1.0f) {
                }
            } else {
                int i14 = this.p;
                if (i14 != -1) {
                    this.d0 = i14;
                }
                int i15 = this.q;
                if (i15 != -1) {
                    this.c0 = i15;
                }
                int i16 = this.r;
                if (i16 != -1) {
                    this.e0 = i16;
                }
                int i17 = this.s;
                if (i17 != -1) {
                    this.f0 = i17;
                }
                int i18 = this.x;
                if (i18 != -1) {
                    this.g0 = i18;
                }
                int i19 = this.y;
                if (i19 != -1) {
                    this.h0 = i19;
                }
            }
            if (this.r == -1 && this.s == -1 && this.q == -1 && this.p == -1) {
                int i20 = this.f174f;
                if (i20 != -1) {
                    this.e0 = i20;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0) {
                    }
                    i3 = this.f172d;
                    if (i3 != -1) {
                        this.c0 = i3;
                        if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                            return;
                        }
                    } else {
                        int i21 = this.f173e;
                        if (i21 != -1) {
                            this.d0 = i21;
                            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
                }
                int i22 = this.f175g;
                if (i22 != -1) {
                    this.f0 = i22;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0) {
                    }
                }
                i3 = this.f172d;
                if (i3 != -1) {
                }
                ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
                ((ViewGroup.MarginLayoutParams) this).rightMargin = i9;
                i3 = this.f172d;
                if (i3 != -1) {
                }
                ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
            }
        }
    }

    public class b implements b.AbstractC0025b {

        /* renamed from: a  reason: collision with root package name */
        public ConstraintLayout f177a;

        public b(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
            this.f177a = constraintLayout2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:104:0x016d  */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x018c  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x0193  */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x0197  */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x01a0  */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x01a5  */
        /* JADX WARNING: Removed duplicated region for block: B:120:0x01aa  */
        /* JADX WARNING: Removed duplicated region for block: B:123:0x01b2  */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x01b7  */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x01bc  */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x01c4 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:136:0x01db A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:141:0x01e6  */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x01ec  */
        /* JADX WARNING: Removed duplicated region for block: B:146:0x0203  */
        /* JADX WARNING: Removed duplicated region for block: B:147:0x0205  */
        /* JADX WARNING: Removed duplicated region for block: B:150:0x020b  */
        /* JADX WARNING: Removed duplicated region for block: B:156:0x021a  */
        /* JADX WARNING: Removed duplicated region for block: B:157:0x021c  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00ad  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0117  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0119  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x011c  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x011e  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x0121 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0129 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0132  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x013d  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0154 A[ADDED_TO_REGION] */
        @SuppressLint({"WrongCall"})
        public final void a(b.g.b.h.d dVar, b.a aVar) {
            boolean z;
            int i;
            int ordinal;
            boolean z2;
            int i2;
            boolean z3;
            View view;
            boolean z4;
            int i3;
            int i4;
            int i5;
            int i6;
            int measuredWidth;
            int measuredHeight;
            int max;
            int i7;
            int max2;
            int i8;
            d.a aVar2 = d.a.FIXED;
            d.a aVar3 = d.a.MATCH_PARENT;
            d.a aVar4 = d.a.MATCH_CONSTRAINT;
            if (dVar != null) {
                if (dVar.V == 8) {
                    aVar.f1531e = 0;
                    aVar.f1532f = 0;
                    aVar.f1533g = 0;
                    return;
                }
                d.a aVar5 = aVar.f1527a;
                d.a aVar6 = aVar.f1528b;
                int i9 = aVar.f1529c;
                int i10 = aVar.f1530d;
                int paddingBottom = this.f177a.getPaddingBottom() + this.f177a.getPaddingTop();
                int paddingWidth = this.f177a.getPaddingWidth();
                int ordinal2 = aVar5.ordinal();
                if (ordinal2 != 0) {
                    if (ordinal2 == 1) {
                        i = ViewGroup.getChildMeasureSpec(this.f177a.s, paddingWidth, -2);
                    } else if (ordinal2 != 2) {
                        if (ordinal2 != 3) {
                            i = 0;
                        } else {
                            int i11 = this.f177a.s;
                            b.g.b.h.c cVar = dVar.x;
                            int i12 = cVar != null ? cVar.f1502d + 0 : 0;
                            b.g.b.h.c cVar2 = dVar.z;
                            if (cVar2 != null) {
                                i12 += cVar2.f1502d;
                            }
                            i = ViewGroup.getChildMeasureSpec(i11, paddingWidth + i12, -1);
                        }
                        z = false;
                        ordinal = aVar6.ordinal();
                        if (ordinal != 0) {
                            if (ordinal == 1) {
                                i2 = ViewGroup.getChildMeasureSpec(this.f177a.t, paddingBottom, -2);
                            } else if (ordinal != 2) {
                                if (ordinal != 3) {
                                    i2 = 0;
                                } else {
                                    int i13 = this.f177a.t;
                                    int i14 = dVar.x != null ? dVar.y.f1502d + 0 : 0;
                                    if (dVar.z != null) {
                                        i14 += dVar.A.f1502d;
                                    }
                                    i2 = ViewGroup.getChildMeasureSpec(i13, paddingBottom + i14, -1);
                                }
                                z2 = false;
                                boolean z5 = aVar5 == aVar4;
                                boolean z6 = aVar6 == aVar4;
                                boolean z7 = aVar6 != aVar3 || aVar6 == aVar2;
                                boolean z8 = aVar5 != aVar3 || aVar5 == aVar2;
                                z3 = !z5 && dVar.L > 0.0f;
                                boolean z9 = !z6 && dVar.L > 0.0f;
                                view = (View) dVar.U;
                                a aVar7 = (a) view.getLayoutParams();
                                if (!aVar.j || !z5 || dVar.j != 0 || !z6 || dVar.k != 0) {
                                    if ((view instanceof j) || !(dVar instanceof b.g.b.h.j)) {
                                        view.measure(i, i2);
                                    } else {
                                        b.g.b.h.j jVar = (b.g.b.h.j) dVar;
                                        ((j) view).j();
                                    }
                                    measuredWidth = view.getMeasuredWidth();
                                    measuredHeight = view.getMeasuredHeight();
                                    i3 = view.getBaseline();
                                    if (z) {
                                        z4 = false;
                                        dVar.f1517g[0] = measuredWidth;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z2) {
                                        dVar.f1517g[1] = measuredHeight;
                                    }
                                    int i15 = dVar.m;
                                    max = i15 > 0 ? Math.max(i15, measuredWidth) : measuredWidth;
                                    i7 = dVar.n;
                                    if (i7 > 0) {
                                        max = Math.min(i7, max);
                                    }
                                    int i16 = dVar.p;
                                    max2 = i16 > 0 ? Math.max(i16, measuredHeight) : measuredHeight;
                                    i8 = dVar.q;
                                    if (i8 > 0) {
                                        max2 = Math.min(i8, max2);
                                    }
                                    if (!z3 && z7) {
                                        max = (int) ((((float) max2) * dVar.L) + 0.5f);
                                    } else if (z9 && z8) {
                                        max2 = (int) ((((float) max) / dVar.L) + 0.5f);
                                    }
                                    if (measuredWidth == max || measuredHeight != max2) {
                                        if (measuredWidth != max) {
                                            i = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
                                        }
                                        if (measuredHeight != max2) {
                                            i2 = View.MeasureSpec.makeMeasureSpec(max2, 1073741824);
                                        }
                                        view.measure(i, i2);
                                        i6 = view.getMeasuredWidth();
                                        i5 = view.getMeasuredHeight();
                                        i3 = view.getBaseline();
                                    } else {
                                        i6 = max;
                                        i5 = max2;
                                    }
                                    i4 = -1;
                                } else {
                                    i6 = 0;
                                    i5 = 0;
                                    i4 = -1;
                                    i3 = 0;
                                    z4 = false;
                                }
                                boolean z10 = i3 != i4 ? true : z4;
                                aVar.i = (i6 == aVar.f1529c || i5 != aVar.f1530d) ? true : z4;
                                boolean z11 = aVar7.X ? true : z10;
                                if (!(!z11 || i3 == -1 || dVar.P == i3)) {
                                    aVar.i = true;
                                }
                                aVar.f1531e = i6;
                                aVar.f1532f = i5;
                                aVar.h = z11;
                                aVar.f1533g = i3;
                            } else {
                                i2 = ViewGroup.getChildMeasureSpec(this.f177a.t, paddingBottom, -2);
                                boolean z12 = dVar.k == 1;
                                if (aVar.j && (!z12 || (z12 && dVar.f1517g[1] != dVar.i()))) {
                                    i10 = dVar.i();
                                }
                            }
                            z2 = true;
                            if (aVar5 == aVar4) {
                            }
                            if (aVar6 == aVar4) {
                            }
                            if (aVar6 != aVar3) {
                            }
                            if (aVar5 != aVar3) {
                            }
                            if (!z5) {
                            }
                            if (!z6) {
                            }
                            view = (View) dVar.U;
                            a aVar72 = (a) view.getLayoutParams();
                            if (!aVar.j) {
                            }
                            if (view instanceof j) {
                            }
                            view.measure(i, i2);
                            measuredWidth = view.getMeasuredWidth();
                            measuredHeight = view.getMeasuredHeight();
                            i3 = view.getBaseline();
                            if (z) {
                            }
                            if (z2) {
                            }
                            int i152 = dVar.m;
                            if (i152 > 0) {
                            }
                            i7 = dVar.n;
                            if (i7 > 0) {
                            }
                            int i162 = dVar.p;
                            if (i162 > 0) {
                            }
                            i8 = dVar.q;
                            if (i8 > 0) {
                            }
                            if (!z3) {
                            }
                            max2 = (int) ((((float) max) / dVar.L) + 0.5f);
                            if (measuredWidth == max) {
                            }
                            if (measuredWidth != max) {
                            }
                            if (measuredHeight != max2) {
                            }
                            view.measure(i, i2);
                            i6 = view.getMeasuredWidth();
                            i5 = view.getMeasuredHeight();
                            i3 = view.getBaseline();
                            i4 = -1;
                            if (i3 != i4) {
                            }
                            aVar.i = (i6 == aVar.f1529c || i5 != aVar.f1530d) ? true : z4;
                            if (aVar72.X) {
                            }
                            aVar.i = true;
                            aVar.f1531e = i6;
                            aVar.f1532f = i5;
                            aVar.h = z11;
                            aVar.f1533g = i3;
                        }
                        i2 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                        z2 = false;
                        if (aVar5 == aVar4) {
                        }
                        if (aVar6 == aVar4) {
                        }
                        if (aVar6 != aVar3) {
                        }
                        if (aVar5 != aVar3) {
                        }
                        if (!z5) {
                        }
                        if (!z6) {
                        }
                        view = (View) dVar.U;
                        a aVar722 = (a) view.getLayoutParams();
                        if (!aVar.j) {
                        }
                        if (view instanceof j) {
                        }
                        view.measure(i, i2);
                        measuredWidth = view.getMeasuredWidth();
                        measuredHeight = view.getMeasuredHeight();
                        i3 = view.getBaseline();
                        if (z) {
                        }
                        if (z2) {
                        }
                        int i1522 = dVar.m;
                        if (i1522 > 0) {
                        }
                        i7 = dVar.n;
                        if (i7 > 0) {
                        }
                        int i1622 = dVar.p;
                        if (i1622 > 0) {
                        }
                        i8 = dVar.q;
                        if (i8 > 0) {
                        }
                        if (!z3) {
                        }
                        max2 = (int) ((((float) max) / dVar.L) + 0.5f);
                        if (measuredWidth == max) {
                        }
                        if (measuredWidth != max) {
                        }
                        if (measuredHeight != max2) {
                        }
                        view.measure(i, i2);
                        i6 = view.getMeasuredWidth();
                        i5 = view.getMeasuredHeight();
                        i3 = view.getBaseline();
                        i4 = -1;
                        if (i3 != i4) {
                        }
                        aVar.i = (i6 == aVar.f1529c || i5 != aVar.f1530d) ? true : z4;
                        if (aVar722.X) {
                        }
                        aVar.i = true;
                        aVar.f1531e = i6;
                        aVar.f1532f = i5;
                        aVar.h = z11;
                        aVar.f1533g = i3;
                    } else {
                        i = ViewGroup.getChildMeasureSpec(this.f177a.s, paddingWidth, -2);
                        boolean z13 = dVar.j == 1;
                        if (aVar.j && (!z13 || (z13 && dVar.f1517g[0] != dVar.o()))) {
                            i9 = dVar.o();
                        }
                    }
                    z = true;
                    ordinal = aVar6.ordinal();
                    if (ordinal != 0) {
                    }
                    i2 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                    z2 = false;
                    if (aVar5 == aVar4) {
                    }
                    if (aVar6 == aVar4) {
                    }
                    if (aVar6 != aVar3) {
                    }
                    if (aVar5 != aVar3) {
                    }
                    if (!z5) {
                    }
                    if (!z6) {
                    }
                    view = (View) dVar.U;
                    a aVar7222 = (a) view.getLayoutParams();
                    if (!aVar.j) {
                    }
                    if (view instanceof j) {
                    }
                    view.measure(i, i2);
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    i3 = view.getBaseline();
                    if (z) {
                    }
                    if (z2) {
                    }
                    int i15222 = dVar.m;
                    if (i15222 > 0) {
                    }
                    i7 = dVar.n;
                    if (i7 > 0) {
                    }
                    int i16222 = dVar.p;
                    if (i16222 > 0) {
                    }
                    i8 = dVar.q;
                    if (i8 > 0) {
                    }
                    if (!z3) {
                    }
                    max2 = (int) ((((float) max) / dVar.L) + 0.5f);
                    if (measuredWidth == max) {
                    }
                    if (measuredWidth != max) {
                    }
                    if (measuredHeight != max2) {
                    }
                    view.measure(i, i2);
                    i6 = view.getMeasuredWidth();
                    i5 = view.getMeasuredHeight();
                    i3 = view.getBaseline();
                    i4 = -1;
                    if (i3 != i4) {
                    }
                    aVar.i = (i6 == aVar.f1529c || i5 != aVar.f1530d) ? true : z4;
                    if (aVar7222.X) {
                    }
                    aVar.i = true;
                    aVar.f1531e = i6;
                    aVar.f1532f = i5;
                    aVar.h = z11;
                    aVar.f1533g = i3;
                }
                i = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
                z = false;
                ordinal = aVar6.ordinal();
                if (ordinal != 0) {
                }
                i2 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                z2 = false;
                if (aVar5 == aVar4) {
                }
                if (aVar6 == aVar4) {
                }
                if (aVar6 != aVar3) {
                }
                if (aVar5 != aVar3) {
                }
                if (!z5) {
                }
                if (!z6) {
                }
                view = (View) dVar.U;
                a aVar72222 = (a) view.getLayoutParams();
                if (!aVar.j) {
                }
                if (view instanceof j) {
                }
                view.measure(i, i2);
                measuredWidth = view.getMeasuredWidth();
                measuredHeight = view.getMeasuredHeight();
                i3 = view.getBaseline();
                if (z) {
                }
                if (z2) {
                }
                int i152222 = dVar.m;
                if (i152222 > 0) {
                }
                i7 = dVar.n;
                if (i7 > 0) {
                }
                int i162222 = dVar.p;
                if (i162222 > 0) {
                }
                i8 = dVar.q;
                if (i8 > 0) {
                }
                if (!z3) {
                }
                max2 = (int) ((((float) max) / dVar.L) + 0.5f);
                if (measuredWidth == max) {
                }
                if (measuredWidth != max) {
                }
                if (measuredHeight != max2) {
                }
                view.measure(i, i2);
                i6 = view.getMeasuredWidth();
                i5 = view.getMeasuredHeight();
                i3 = view.getBaseline();
                i4 = -1;
                if (i3 != i4) {
                }
                aVar.i = (i6 == aVar.f1529c || i5 != aVar.f1530d) ? true : z4;
                if (aVar72222.X) {
                }
                aVar.i = true;
                aVar.f1531e = i6;
                aVar.f1532f = i5;
                aVar.h = z11;
                aVar.f1533g = i3;
            }
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        g(attributeSet, i2, 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getPaddingWidth() {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingEnd = getPaddingEnd() + getPaddingStart();
        return paddingEnd > 0 ? paddingEnd : paddingRight;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
    }

    /* renamed from: c */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public Object d(int i2, Object obj) {
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

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<b.g.c.b> arrayList = this.f164c;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.f164c.get(i2).h();
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

    public View e(int i2) {
        return this.f163b.get(i2);
    }

    public final b.g.b.h.d f(View view) {
        if (view == this) {
            return this.f165d;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).m0;
    }

    public void forceLayout() {
        this.i = true;
        this.o = -1;
        this.p = -1;
        super.forceLayout();
    }

    public final void g(AttributeSet attributeSet, int i2, int i3) {
        e eVar = this.f165d;
        eVar.U = this;
        b bVar = this.r;
        eVar.g0 = bVar;
        eVar.f0.f1539f = bVar;
        this.f163b.put(getId(), this);
        this.k = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.ConstraintLayout_Layout, i2, i3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == i.ConstraintLayout_Layout_android_minWidth) {
                    this.f166e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f166e);
                } else if (index == i.ConstraintLayout_Layout_android_minHeight) {
                    this.f167f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f167f);
                } else if (index == i.ConstraintLayout_Layout_android_maxWidth) {
                    this.f168g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f168g);
                } else if (index == i.ConstraintLayout_Layout_android_maxHeight) {
                    this.h = obtainStyledAttributes.getDimensionPixelOffset(index, this.h);
                } else if (index == i.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.j = obtainStyledAttributes.getInt(index, this.j);
                } else if (index == i.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            this.l = new c(getContext(), this, resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.l = null;
                        }
                    }
                } else if (index == i.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        b.g.c.d dVar = new b.g.c.d();
                        this.k = dVar;
                        dVar.f(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.k = null;
                    }
                    this.m = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f165d.p0 = this.j;
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
        return this.h;
    }

    public int getMaxWidth() {
        return this.f168g;
    }

    public int getMinHeight() {
        return this.f167f;
    }

    public int getMinWidth() {
        return this.f166e;
    }

    public int getOptimizationLevel() {
        return this.f165d.p0;
    }

    public boolean h() {
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
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

    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0258, code lost:
        if (r1 == 6) goto L_0x025d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x025f, code lost:
        if (r1 == 6) goto L_0x0261;
     */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x032f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x034c  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0361  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0382  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0397  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x03b8  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0407  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x054b  */
    public final boolean j() {
        boolean z;
        boolean z2;
        int i2;
        boolean z3;
        int i3;
        int i4;
        char c2;
        d.a aVar;
        int i5;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        int i10;
        float f3;
        b.g.b.h.c cVar;
        int i11;
        int i12;
        b.g.b.h.c cVar2;
        b.g.b.h.d dVar;
        b.g.b.h.c cVar3;
        int i13;
        int i14;
        b.g.b.h.c cVar4;
        b.g.b.h.d dVar2;
        b.g.b.h.c cVar5;
        int i15;
        b.g.b.h.c cVar6;
        b.g.b.h.d dVar3;
        b.g.b.h.c cVar7;
        int i16;
        b.g.b.h.c cVar8;
        int i17;
        String str;
        int d2;
        b.g.b.h.d dVar4;
        int childCount = getChildCount();
        int i18 = 0;
        int i19 = 0;
        while (true) {
            if (i19 >= childCount) {
                z = false;
                break;
            } else if (getChildAt(i19).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i19++;
            }
        }
        if (z) {
            boolean isInEditMode = isInEditMode();
            int childCount2 = getChildCount();
            for (int i20 = 0; i20 < childCount2; i20++) {
                b.g.b.h.d f4 = f(getChildAt(i20));
                if (f4 != null) {
                    f4.u();
                }
            }
            Object obj = null;
            int i21 = -1;
            if (isInEditMode) {
                for (int i22 = 0; i22 < childCount2; i22++) {
                    View childAt = getChildAt(i22);
                    try {
                        String resourceName = getResources().getResourceName(childAt.getId());
                        i(0, resourceName, Integer.valueOf(childAt.getId()));
                        int indexOf = resourceName.indexOf(47);
                        if (indexOf != -1) {
                            resourceName = resourceName.substring(indexOf + 1);
                        }
                        int id = childAt.getId();
                        if (id != 0) {
                            View view = this.f163b.get(id);
                            if (view == null && (view = findViewById(id)) != null && view != this && view.getParent() == this) {
                                onViewAdded(view);
                            }
                            if (view != this) {
                                dVar4 = view == null ? null : ((a) view.getLayoutParams()).m0;
                                dVar4.W = resourceName;
                            }
                        }
                        dVar4 = this.f165d;
                        dVar4.W = resourceName;
                    } catch (Resources.NotFoundException unused) {
                    }
                }
            }
            if (this.m != -1) {
                for (int i23 = 0; i23 < childCount2; i23++) {
                    View childAt2 = getChildAt(i23);
                    if (childAt2.getId() == this.m && (childAt2 instanceof b.g.c.e)) {
                        this.k = ((b.g.c.e) childAt2).getConstraintSet();
                    }
                }
            }
            b.g.c.d dVar5 = this.k;
            if (dVar5 != null) {
                dVar5.b(this, true);
            }
            this.f165d.d0.clear();
            int size = this.f164c.size();
            char c3 = 2;
            if (size > 0) {
                int i24 = 0;
                while (i24 < size) {
                    b.g.c.b bVar = this.f164c.get(i24);
                    if (bVar.isInEditMode()) {
                        bVar.setIds(bVar.f1587g);
                    }
                    String str2 = bVar.f1587g;
                    if (str2 != null) {
                        bVar.setIds(str2);
                    }
                    g gVar = bVar.f1585e;
                    if (gVar != null) {
                        h hVar = (h) gVar;
                        hVar.e0 = i18;
                        Arrays.fill(hVar.d0, obj);
                        for (int i25 = i18; i25 < bVar.f1583c; i25++) {
                            int i26 = bVar.f1582b[i25];
                            View e2 = e(i26);
                            if (e2 == null && (d2 = bVar.d(this, (str = bVar.h.get(Integer.valueOf(i26))))) != 0) {
                                bVar.f1582b[i25] = d2;
                                bVar.h.put(Integer.valueOf(d2), str);
                                e2 = e(d2);
                            }
                            if (e2 != null) {
                                g gVar2 = bVar.f1585e;
                                b.g.b.h.d f5 = f(e2);
                                h hVar2 = (h) gVar2;
                                int i27 = hVar2.e0 + 1;
                                b.g.b.h.d[] dVarArr = hVar2.d0;
                                if (i27 > dVarArr.length) {
                                    hVar2.d0 = (b.g.b.h.d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
                                }
                                b.g.b.h.d[] dVarArr2 = hVar2.d0;
                                int i28 = hVar2.e0;
                                dVarArr2[i28] = f5;
                                hVar2.e0 = i28 + 1;
                            }
                        }
                        bVar.f1585e.a(this.f165d);
                    }
                    i24++;
                    i18 = 0;
                    obj = null;
                }
            }
            for (int i29 = 0; i29 < childCount2; i29++) {
                View childAt3 = getChildAt(i29);
                if (childAt3 instanceof b.g.c.g) {
                    b.g.c.g gVar3 = (b.g.c.g) childAt3;
                    if (gVar3.f1638b == -1 && !gVar3.isInEditMode()) {
                        gVar3.setVisibility(gVar3.f1640d);
                    }
                    View findViewById = findViewById(gVar3.f1638b);
                    gVar3.f1639c = findViewById;
                    if (findViewById != null) {
                        ((a) findViewById.getLayoutParams()).a0 = true;
                        gVar3.f1639c.setVisibility(0);
                        gVar3.setVisibility(0);
                    }
                }
            }
            this.q.clear();
            this.q.put(0, this.f165d);
            this.q.put(getId(), this.f165d);
            for (int i30 = 0; i30 < childCount2; i30++) {
                View childAt4 = getChildAt(i30);
                this.q.put(childAt4.getId(), f(childAt4));
            }
            int i31 = 0;
            while (i31 < childCount2) {
                View childAt5 = getChildAt(i31);
                b.g.b.h.d f6 = f(childAt5);
                if (f6 == null) {
                    z3 = z;
                    z2 = isInEditMode;
                    i3 = childCount2;
                    i4 = i21;
                    c2 = c3;
                    i2 = i31;
                } else {
                    a aVar2 = (a) childAt5.getLayoutParams();
                    e eVar = this.f165d;
                    eVar.d0.add(f6);
                    b.g.b.h.d dVar6 = f6.I;
                    if (dVar6 != null) {
                        ((k) dVar6).d0.remove(f6);
                        f6.I = null;
                    }
                    f6.I = eVar;
                    SparseArray<b.g.b.h.d> sparseArray = this.q;
                    c.a aVar3 = c.a.BASELINE;
                    d.a aVar4 = d.a.MATCH_PARENT;
                    d.a aVar5 = d.a.WRAP_CONTENT;
                    d.a aVar6 = d.a.FIXED;
                    d.a aVar7 = d.a.MATCH_CONSTRAINT;
                    c.a aVar8 = c.a.RIGHT;
                    c.a aVar9 = c.a.LEFT;
                    c.a aVar10 = c.a.BOTTOM;
                    c.a aVar11 = c.a.TOP;
                    aVar2.a();
                    i3 = childCount2;
                    f6.V = childAt5.getVisibility();
                    if (aVar2.a0) {
                        f6.V = 8;
                    }
                    f6.U = childAt5;
                    if (childAt5 instanceof b.g.c.b) {
                        boolean z4 = this.f165d.h0;
                        Barrier barrier = (Barrier) ((b.g.c.b) childAt5);
                        z3 = z;
                        int i32 = barrier.i;
                        barrier.j = i32;
                        i2 = i31;
                        aVar = aVar5;
                        if (z4) {
                            if (i32 != 5) {
                            }
                            i17 = 1;
                            barrier.j = i17;
                            if (f6 instanceof b.g.b.h.a) {
                                ((b.g.b.h.a) f6).f0 = barrier.j;
                            }
                        } else if (i32 != 5) {
                        }
                        i17 = 0;
                        barrier.j = i17;
                        if (f6 instanceof b.g.b.h.a) {
                        }
                    } else {
                        z3 = z;
                        i2 = i31;
                        aVar = aVar5;
                    }
                    if (aVar2.Y) {
                        f fVar = (f) f6;
                        int i33 = aVar2.j0;
                        int i34 = aVar2.k0;
                        float f7 = aVar2.l0;
                        int i35 = (f7 > -1.0f ? 1 : (f7 == -1.0f ? 0 : -1));
                        if (i35 != 0) {
                            if (i35 > 0) {
                                fVar.d0 = f7;
                                fVar.e0 = -1;
                                fVar.f0 = -1;
                            }
                        } else if (i33 != -1) {
                            if (i33 > -1) {
                                fVar.d0 = -1.0f;
                                fVar.e0 = i33;
                                fVar.f0 = -1;
                            }
                        } else if (i34 != -1 && i34 > -1) {
                            fVar.d0 = -1.0f;
                            fVar.e0 = -1;
                            fVar.f0 = i34;
                        }
                        z2 = isInEditMode;
                        c2 = 2;
                        i4 = -1;
                    } else {
                        int i36 = aVar2.c0;
                        int i37 = aVar2.d0;
                        int i38 = aVar2.e0;
                        int i39 = aVar2.f0;
                        int i40 = aVar2.g0;
                        int i41 = aVar2.h0;
                        z2 = isInEditMode;
                        float f8 = aVar2.i0;
                        int i42 = aVar2.m;
                        if (i42 != -1) {
                            b.g.b.h.d dVar7 = sparseArray.get(i42);
                            if (dVar7 != null) {
                                float f9 = aVar2.o;
                                int i43 = aVar2.n;
                                c.a aVar12 = c.a.CENTER;
                                f6.f(aVar12).a(dVar7.f(aVar12), i43, 0, true);
                                f6.v = f9;
                            }
                        } else {
                            if (i36 != -1) {
                                b.g.b.h.d dVar8 = sparseArray.get(i36);
                                if (dVar8 != null) {
                                    i16 = ((ViewGroup.MarginLayoutParams) aVar2).leftMargin;
                                    cVar7 = f6.f(aVar9);
                                    cVar8 = dVar8.f(aVar9);
                                }
                                i7 = -1;
                                if (i38 == i7) {
                                    b.g.b.h.d dVar9 = sparseArray.get(i38);
                                    if (dVar9 != null) {
                                        i15 = ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                                        cVar5 = f6.f(aVar8);
                                        cVar6 = dVar9.f(aVar9);
                                    }
                                    i8 = aVar2.h;
                                    if (i8 == -1) {
                                        b.g.b.h.d dVar10 = sparseArray.get(i8);
                                        if (dVar10 != null) {
                                            i14 = ((ViewGroup.MarginLayoutParams) aVar2).topMargin;
                                            i13 = aVar2.u;
                                            cVar3 = f6.f(aVar11);
                                            cVar4 = dVar10.f(aVar11);
                                        }
                                        i9 = aVar2.j;
                                        if (i9 == -1) {
                                            b.g.b.h.d dVar11 = sparseArray.get(i9);
                                            if (dVar11 != null) {
                                                i12 = ((ViewGroup.MarginLayoutParams) aVar2).bottomMargin;
                                                i11 = aVar2.w;
                                                cVar = f6.f(aVar10);
                                                cVar2 = dVar11.f(aVar11);
                                            }
                                            i10 = aVar2.l;
                                            if (i10 != -1) {
                                                View view2 = this.f163b.get(i10);
                                                b.g.b.h.d dVar12 = sparseArray.get(aVar2.l);
                                                if (!(dVar12 == null || view2 == null || !(view2.getLayoutParams() instanceof a))) {
                                                    a aVar13 = (a) view2.getLayoutParams();
                                                    aVar2.X = true;
                                                    aVar13.X = true;
                                                    f6.f(aVar3).a(dVar12.f(aVar3), 0, -1, true);
                                                    f6.w = true;
                                                    aVar13.m0.w = true;
                                                    f6.f(aVar11).d();
                                                    f6.f(aVar10).d();
                                                }
                                            }
                                            if (f8 >= 0.0f) {
                                                f6.S = f8;
                                            }
                                            f3 = aVar2.A;
                                            if (f3 >= 0.0f) {
                                                f6.T = f3;
                                            }
                                        } else {
                                            int i44 = aVar2.k;
                                            if (!(i44 == -1 || (dVar = sparseArray.get(i44)) == null)) {
                                                i12 = ((ViewGroup.MarginLayoutParams) aVar2).bottomMargin;
                                                i11 = aVar2.w;
                                                cVar = f6.f(aVar10);
                                                cVar2 = dVar.f(aVar10);
                                            }
                                            i10 = aVar2.l;
                                            if (i10 != -1) {
                                            }
                                            if (f8 >= 0.0f) {
                                            }
                                            f3 = aVar2.A;
                                            if (f3 >= 0.0f) {
                                            }
                                        }
                                        cVar.a(cVar2, i12, i11, true);
                                        i10 = aVar2.l;
                                        if (i10 != -1) {
                                        }
                                        if (f8 >= 0.0f) {
                                        }
                                        f3 = aVar2.A;
                                        if (f3 >= 0.0f) {
                                        }
                                    } else {
                                        int i45 = aVar2.i;
                                        if (!(i45 == -1 || (dVar2 = sparseArray.get(i45)) == null)) {
                                            i14 = ((ViewGroup.MarginLayoutParams) aVar2).topMargin;
                                            i13 = aVar2.u;
                                            cVar3 = f6.f(aVar11);
                                            cVar4 = dVar2.f(aVar10);
                                        }
                                        i9 = aVar2.j;
                                        if (i9 == -1) {
                                        }
                                        cVar.a(cVar2, i12, i11, true);
                                        i10 = aVar2.l;
                                        if (i10 != -1) {
                                        }
                                        if (f8 >= 0.0f) {
                                        }
                                        f3 = aVar2.A;
                                        if (f3 >= 0.0f) {
                                        }
                                    }
                                    cVar3.a(cVar4, i14, i13, true);
                                    i9 = aVar2.j;
                                    if (i9 == -1) {
                                    }
                                    cVar.a(cVar2, i12, i11, true);
                                    i10 = aVar2.l;
                                    if (i10 != -1) {
                                    }
                                    if (f8 >= 0.0f) {
                                    }
                                    f3 = aVar2.A;
                                    if (f3 >= 0.0f) {
                                    }
                                } else {
                                    if (!(i39 == i7 || (dVar3 = sparseArray.get(i39)) == null)) {
                                        i15 = ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                                        cVar5 = f6.f(aVar8);
                                        cVar6 = dVar3.f(aVar8);
                                    }
                                    i8 = aVar2.h;
                                    if (i8 == -1) {
                                    }
                                    cVar3.a(cVar4, i14, i13, true);
                                    i9 = aVar2.j;
                                    if (i9 == -1) {
                                    }
                                    cVar.a(cVar2, i12, i11, true);
                                    i10 = aVar2.l;
                                    if (i10 != -1) {
                                    }
                                    if (f8 >= 0.0f) {
                                    }
                                    f3 = aVar2.A;
                                    if (f3 >= 0.0f) {
                                    }
                                }
                                cVar5.a(cVar6, i15, i41, true);
                                i8 = aVar2.h;
                                if (i8 == -1) {
                                }
                                cVar3.a(cVar4, i14, i13, true);
                                i9 = aVar2.j;
                                if (i9 == -1) {
                                }
                                cVar.a(cVar2, i12, i11, true);
                                i10 = aVar2.l;
                                if (i10 != -1) {
                                }
                                if (f8 >= 0.0f) {
                                }
                                f3 = aVar2.A;
                                if (f3 >= 0.0f) {
                                }
                            } else if (i37 != -1) {
                                b.g.b.h.d dVar13 = sparseArray.get(i37);
                                if (dVar13 != null) {
                                    i16 = ((ViewGroup.MarginLayoutParams) aVar2).leftMargin;
                                    cVar7 = f6.f(aVar9);
                                    cVar8 = dVar13.f(aVar8);
                                }
                                i7 = -1;
                                if (i38 == i7) {
                                }
                                cVar5.a(cVar6, i15, i41, true);
                                i8 = aVar2.h;
                                if (i8 == -1) {
                                }
                                cVar3.a(cVar4, i14, i13, true);
                                i9 = aVar2.j;
                                if (i9 == -1) {
                                }
                                cVar.a(cVar2, i12, i11, true);
                                i10 = aVar2.l;
                                if (i10 != -1) {
                                }
                                if (f8 >= 0.0f) {
                                }
                                f3 = aVar2.A;
                                if (f3 >= 0.0f) {
                                }
                            } else {
                                i7 = -1;
                                if (i38 == i7) {
                                }
                                cVar5.a(cVar6, i15, i41, true);
                                i8 = aVar2.h;
                                if (i8 == -1) {
                                }
                                cVar3.a(cVar4, i14, i13, true);
                                i9 = aVar2.j;
                                if (i9 == -1) {
                                }
                                cVar.a(cVar2, i12, i11, true);
                                i10 = aVar2.l;
                                if (i10 != -1) {
                                }
                                if (f8 >= 0.0f) {
                                }
                                f3 = aVar2.A;
                                if (f3 >= 0.0f) {
                                }
                            }
                            cVar7.a(cVar8, i16, i40, true);
                            i7 = -1;
                            if (i38 == i7) {
                            }
                            cVar5.a(cVar6, i15, i41, true);
                            i8 = aVar2.h;
                            if (i8 == -1) {
                            }
                            cVar3.a(cVar4, i14, i13, true);
                            i9 = aVar2.j;
                            if (i9 == -1) {
                            }
                            cVar.a(cVar2, i12, i11, true);
                            i10 = aVar2.l;
                            if (i10 != -1) {
                            }
                            if (f8 >= 0.0f) {
                            }
                            f3 = aVar2.A;
                            if (f3 >= 0.0f) {
                            }
                        }
                        if (z2 && !(aVar2.P == -1 && aVar2.Q == -1)) {
                            int i46 = aVar2.P;
                            int i47 = aVar2.Q;
                            f6.N = i46;
                            f6.O = i47;
                        }
                        if (aVar2.V) {
                            f6.H[0] = aVar6;
                            f6.B(((ViewGroup.MarginLayoutParams) aVar2).width);
                            if (((ViewGroup.MarginLayoutParams) aVar2).width == -2) {
                                f6.H[0] = aVar;
                            }
                        } else if (((ViewGroup.MarginLayoutParams) aVar2).width == -1) {
                            if (aVar2.S) {
                                f6.H[0] = aVar7;
                            } else {
                                f6.H[0] = aVar4;
                            }
                            f6.f(aVar9).f1502d = ((ViewGroup.MarginLayoutParams) aVar2).leftMargin;
                            f6.f(aVar8).f1502d = ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                        } else {
                            f6.H[0] = aVar7;
                            f6.B(0);
                        }
                        if (!aVar2.W) {
                            i4 = -1;
                            if (((ViewGroup.MarginLayoutParams) aVar2).height == -1) {
                                if (aVar2.T) {
                                    f6.H[1] = aVar7;
                                } else {
                                    f6.H[1] = aVar4;
                                }
                                f6.f(aVar11).f1502d = ((ViewGroup.MarginLayoutParams) aVar2).topMargin;
                                f6.f(aVar10).f1502d = ((ViewGroup.MarginLayoutParams) aVar2).bottomMargin;
                            } else {
                                f6.H[1] = aVar7;
                                f6.w(0);
                            }
                        } else {
                            i4 = -1;
                            f6.H[1] = aVar6;
                            f6.w(((ViewGroup.MarginLayoutParams) aVar2).height);
                            if (((ViewGroup.MarginLayoutParams) aVar2).height == -2) {
                                f6.H[1] = aVar;
                            }
                        }
                        String str3 = aVar2.B;
                        if (str3 != null) {
                            if (str3.length() == 0) {
                                f6.L = 0.0f;
                            } else {
                                int length = str3.length();
                                int indexOf2 = str3.indexOf(44);
                                if (indexOf2 <= 0 || indexOf2 >= length - 1) {
                                    i6 = i4;
                                    i5 = 0;
                                } else {
                                    String substring = str3.substring(0, indexOf2);
                                    i5 = indexOf2 + 1;
                                    i6 = substring.equalsIgnoreCase("W") ? 0 : substring.equalsIgnoreCase(BuildConfig.DOWNLOAD_SCHEDULE_UNIT) ? 1 : i4;
                                }
                                int indexOf3 = str3.indexOf(58);
                                if (indexOf3 < 0 || indexOf3 >= length - 1) {
                                    String substring2 = str3.substring(i5);
                                    if (substring2.length() > 0) {
                                        f2 = Float.parseFloat(substring2);
                                        if (f2 > 0.0f) {
                                            f6.L = f2;
                                            f6.M = i6;
                                        }
                                    }
                                } else {
                                    String substring3 = str3.substring(i5, indexOf3);
                                    String substring4 = str3.substring(indexOf3 + 1);
                                    if (substring3.length() > 0 && substring4.length() > 0) {
                                        try {
                                            float parseFloat = Float.parseFloat(substring3);
                                            float parseFloat2 = Float.parseFloat(substring4);
                                            if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                f2 = i6 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
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
                        }
                        float f10 = aVar2.D;
                        float[] fArr = f6.a0;
                        fArr[0] = f10;
                        fArr[1] = aVar2.E;
                        f6.Y = aVar2.F;
                        f6.Z = aVar2.G;
                        int i48 = aVar2.H;
                        int i49 = aVar2.J;
                        int i50 = aVar2.L;
                        float f11 = aVar2.N;
                        f6.j = i48;
                        f6.m = i49;
                        if (i50 == Integer.MAX_VALUE) {
                            i50 = 0;
                        }
                        f6.n = i50;
                        f6.o = f11;
                        if (f11 > 0.0f && f11 < 1.0f && f6.j == 0) {
                            f6.j = 2;
                        }
                        int i51 = aVar2.I;
                        int i52 = aVar2.K;
                        int i53 = aVar2.M;
                        float f12 = aVar2.O;
                        f6.k = i51;
                        f6.p = i52;
                        if (i53 == Integer.MAX_VALUE) {
                            i53 = 0;
                        }
                        f6.q = i53;
                        f6.r = f12;
                        if (f12 <= 0.0f || f12 >= 1.0f || f6.k != 0) {
                            c2 = 2;
                            c3 = c2;
                            i31 = i2 + 1;
                            i21 = i4;
                            childCount2 = i3;
                            z = z3;
                            isInEditMode = z2;
                        } else {
                            c2 = 2;
                            f6.k = 2;
                            c3 = c2;
                            i31 = i2 + 1;
                            i21 = i4;
                            childCount2 = i3;
                            z = z3;
                            isInEditMode = z2;
                        }
                    }
                }
                c3 = c2;
                i31 = i2 + 1;
                i21 = i4;
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
            b.g.b.h.d dVar = aVar.m0;
            if ((childAt.getVisibility() != 8 || aVar.Y || aVar.Z || aVar.b0 || isInEditMode) && !aVar.a0) {
                int p2 = dVar.p();
                int q2 = dVar.q();
                int o2 = dVar.o() + p2;
                int i7 = dVar.i() + q2;
                childAt.layout(p2, q2, o2, i7);
                if ((childAt instanceof b.g.c.g) && (content = ((b.g.c.g) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(p2, q2, o2, i7);
                }
            }
        }
        int size = this.f164c.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                this.f164c.get(i8).f();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x020a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03ad  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04b4  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x04ea  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x057c  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0581  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x0759  */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x07a5  */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x07a8  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x07b1  */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x03ff A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01a1  */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        d.a aVar;
        int i6;
        d.a aVar2;
        d.a aVar3;
        int i7;
        d.a aVar4;
        b.g.b.h.l.b bVar;
        boolean z;
        c.a aVar5;
        boolean z2;
        int i8;
        int i9;
        b.AbstractC0025b bVar2;
        c.a aVar6;
        boolean z3;
        int i10;
        boolean z4;
        boolean z5;
        int size;
        int i11;
        e eVar;
        boolean z6;
        boolean z7;
        int i12;
        e eVar2;
        int i13;
        e eVar3;
        int i14;
        int i15;
        b.AbstractC0025b bVar3;
        c.a aVar7;
        c.a aVar8;
        int i16;
        int i17;
        boolean z8;
        int i18;
        int i19;
        boolean z9;
        Iterator<m> it;
        Iterator<m> it2;
        d.a aVar9;
        int i20;
        d.a aVar10 = d.a.MATCH_PARENT;
        d.a aVar11 = d.a.MATCH_CONSTRAINT;
        this.s = i2;
        this.t = i3;
        this.f165d.h0 = h();
        if (this.i) {
            this.i = false;
            if (j()) {
                e eVar4 = this.f165d;
                b.g.b.h.l.b bVar4 = eVar4.e0;
                bVar4.f1524a.clear();
                int size2 = eVar4.d0.size();
                for (int i21 = 0; i21 < size2; i21++) {
                    b.g.b.h.d dVar = eVar4.d0.get(i21);
                    if (dVar.j() == aVar11 || dVar.j() == aVar10 || dVar.n() == aVar11 || dVar.n() == aVar10) {
                        bVar4.f1524a.add(dVar);
                    }
                }
                eVar4.I();
            }
        }
        e eVar5 = this.f165d;
        int i22 = this.j;
        d.a aVar12 = d.a.FIXED;
        d.a aVar13 = d.a.WRAP_CONTENT;
        int mode = View.MeasureSpec.getMode(i2);
        int size3 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size4 = View.MeasureSpec.getSize(i3);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom() + paddingTop;
        int paddingWidth = getPaddingWidth();
        int paddingStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();
        if (paddingStart <= 0 && paddingEnd <= 0) {
            paddingStart = getPaddingLeft();
        } else if (h()) {
            i4 = paddingEnd;
            int i23 = size3 - paddingWidth;
            int i24 = size4 - paddingBottom;
            int paddingBottom2 = getPaddingBottom() + getPaddingTop();
            int paddingWidth2 = getPaddingWidth();
            int childCount = getChildCount();
            if (mode == Integer.MIN_VALUE) {
                if (mode != 0) {
                    if (mode != 1073741824) {
                        aVar = aVar12;
                    } else {
                        i6 = Integer.MIN_VALUE;
                        i5 = Math.min(this.f168g - paddingWidth2, i23);
                        aVar = aVar12;
                        if (mode2 != i6) {
                            if (mode2 != 0) {
                                if (mode2 != 1073741824) {
                                    aVar4 = aVar12;
                                } else {
                                    aVar3 = aVar10;
                                    aVar2 = aVar12;
                                    i7 = Math.min(this.h - paddingBottom2, i24);
                                    aVar4 = aVar2;
                                    d.a aVar14 = aVar13;
                                    if (!(i5 == eVar5.o() && i7 == eVar5.i())) {
                                        eVar5.f0.f1536c = true;
                                    }
                                    eVar5.N = 0;
                                    eVar5.O = 0;
                                    int[] iArr = eVar5.u;
                                    iArr[0] = this.f168g - paddingWidth2;
                                    iArr[1] = this.h - paddingBottom2;
                                    eVar5.z(0);
                                    eVar5.y(0);
                                    eVar5.H[0] = aVar;
                                    eVar5.B(i5);
                                    eVar5.H[1] = aVar4;
                                    eVar5.w(i7);
                                    eVar5.z(this.f166e - paddingWidth2);
                                    eVar5.y(this.f167f - paddingBottom2);
                                    eVar5.j0 = i4;
                                    eVar5.k0 = paddingTop;
                                    bVar = eVar5.e0;
                                    if (bVar == null) {
                                        c.a aVar15 = c.a.BOTTOM;
                                        c.a aVar16 = c.a.RIGHT;
                                        b.AbstractC0025b bVar5 = eVar5.g0;
                                        int size5 = eVar5.d0.size();
                                        int o2 = eVar5.o();
                                        int i25 = eVar5.i();
                                        boolean z10 = (i22 & RecyclerView.a0.FLAG_IGNORE) == 128;
                                        if (!z10) {
                                            if (!((i22 & 64) == 64)) {
                                                z = false;
                                                if (z) {
                                                    int i26 = 0;
                                                    while (true) {
                                                        if (i26 >= size5) {
                                                            break;
                                                        }
                                                        b.g.b.h.d dVar2 = eVar5.d0.get(i26);
                                                        aVar5 = aVar15;
                                                        boolean z11 = (dVar2.j() == aVar11) && (dVar2.n() == aVar11) && dVar2.L > 0.0f;
                                                        if ((!dVar2.s() || !z11) && ((!dVar2.t() || !z11) && !(dVar2 instanceof b.g.b.h.j) && !dVar2.s() && !dVar2.t())) {
                                                            i26++;
                                                            z = z;
                                                            aVar15 = aVar5;
                                                        }
                                                    }
                                                    i8 = 1073741824;
                                                    z2 = false;
                                                    if (z2 && ((mode != i8 && mode2 == i8) || z10)) {
                                                        int min = Math.min(eVar5.u[0], i23);
                                                        int min2 = Math.min(eVar5.u[1], i24);
                                                        if (mode == 1073741824 && eVar5.o() != min) {
                                                            eVar5.B(min);
                                                            eVar5.I();
                                                        }
                                                        if (mode2 == 1073741824 && eVar5.i() != min2) {
                                                            eVar5.w(min2);
                                                            eVar5.I();
                                                        }
                                                        if (mode == 1073741824 && mode2 == 1073741824) {
                                                            b.g.b.h.l.e eVar6 = eVar5.f0;
                                                            boolean z12 = z10 & true;
                                                            if (eVar6.f1535b || eVar6.f1536c) {
                                                                Iterator<b.g.b.h.d> it3 = eVar6.f1534a.d0.iterator();
                                                                while (it3.hasNext()) {
                                                                    b.g.b.h.d next = it3.next();
                                                                    next.f1511a = false;
                                                                    next.f1514d.n();
                                                                    next.f1515e.m();
                                                                }
                                                                i19 = 0;
                                                                e eVar7 = eVar6.f1534a;
                                                                eVar7.f1511a = false;
                                                                eVar7.f1514d.n();
                                                                eVar6.f1534a.f1515e.m();
                                                                eVar6.f1536c = false;
                                                            } else {
                                                                i19 = 0;
                                                            }
                                                            eVar6.b(eVar6.f1537d);
                                                            e eVar8 = eVar6.f1534a;
                                                            eVar8.N = i19;
                                                            eVar8.O = i19;
                                                            d.a h2 = eVar8.h(i19);
                                                            d.a h3 = eVar6.f1534a.h(1);
                                                            if (eVar6.f1535b) {
                                                                eVar6.c();
                                                            }
                                                            int p2 = eVar6.f1534a.p();
                                                            int q2 = eVar6.f1534a.q();
                                                            aVar6 = aVar16;
                                                            eVar6.f1534a.f1514d.h.c(p2);
                                                            eVar6.f1534a.f1515e.h.c(q2);
                                                            eVar6.g();
                                                            if (h2 == aVar14 || h3 == aVar14) {
                                                                boolean z13 = z12;
                                                                if (z12) {
                                                                    Iterator<m> it4 = eVar6.f1538e.iterator();
                                                                    while (true) {
                                                                        if (it4.hasNext()) {
                                                                            if (!it4.next().k()) {
                                                                                z13 = false;
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                                if (!z13 || h2 != aVar14) {
                                                                    bVar2 = bVar5;
                                                                    i9 = o2;
                                                                } else {
                                                                    e eVar9 = eVar6.f1534a;
                                                                    bVar2 = bVar5;
                                                                    i9 = o2;
                                                                    eVar9.H[0] = aVar2;
                                                                    eVar9.B(eVar6.d(eVar9, 0));
                                                                    e eVar10 = eVar6.f1534a;
                                                                    eVar10.f1514d.f1561e.c(eVar10.o());
                                                                }
                                                                if (z13 && h3 == aVar14) {
                                                                    e eVar11 = eVar6.f1534a;
                                                                    eVar11.H[1] = aVar2;
                                                                    eVar11.w(eVar6.d(eVar11, 1));
                                                                    e eVar12 = eVar6.f1534a;
                                                                    eVar12.f1515e.f1561e.c(eVar12.i());
                                                                }
                                                            } else {
                                                                bVar2 = bVar5;
                                                                i9 = o2;
                                                            }
                                                            d.a[] aVarArr = eVar6.f1534a.H;
                                                            aVar14 = aVar14;
                                                            if (aVarArr[0] != aVar2) {
                                                                aVar9 = aVar3;
                                                                if (aVarArr[0] != aVar9) {
                                                                    z9 = false;
                                                                    it = eVar6.f1538e.iterator();
                                                                    while (it.hasNext()) {
                                                                        m next2 = it.next();
                                                                        if (next2.f1558b != eVar6.f1534a || next2.f1563g) {
                                                                            next2.e();
                                                                        }
                                                                    }
                                                                    it2 = eVar6.f1538e.iterator();
                                                                    while (true) {
                                                                        if (it2.hasNext()) {
                                                                            z3 = true;
                                                                            break;
                                                                        }
                                                                        m next3 = it2.next();
                                                                        if ((z9 || next3.f1558b != eVar6.f1534a) && (!next3.h.j || ((!next3.i.j && !(next3 instanceof b.g.b.h.l.h)) || (!next3.f1561e.j && !(next3 instanceof b.g.b.h.l.c) && !(next3 instanceof b.g.b.h.l.h))))) {
                                                                            z3 = false;
                                                                        }
                                                                    }
                                                                    z3 = false;
                                                                    eVar6.f1534a.x(h2);
                                                                    eVar6.f1534a.A(h3);
                                                                    i16 = 1073741824;
                                                                    i10 = 2;
                                                                }
                                                            } else {
                                                                aVar9 = aVar3;
                                                            }
                                                            int o3 = eVar6.f1534a.o() + p2;
                                                            eVar6.f1534a.f1514d.i.c(o3);
                                                            eVar6.f1534a.f1514d.f1561e.c(o3 - p2);
                                                            eVar6.g();
                                                            d.a[] aVarArr2 = eVar6.f1534a.H;
                                                            if (aVarArr2[1] == aVar2 || aVarArr2[1] == aVar9) {
                                                                int i27 = eVar6.f1534a.i() + q2;
                                                                eVar6.f1534a.f1515e.i.c(i27);
                                                                eVar6.f1534a.f1515e.f1561e.c(i27 - q2);
                                                            }
                                                            eVar6.g();
                                                            z9 = true;
                                                            it = eVar6.f1538e.iterator();
                                                            while (it.hasNext()) {
                                                            }
                                                            it2 = eVar6.f1538e.iterator();
                                                            while (true) {
                                                                if (it2.hasNext()) {
                                                                }
                                                            }
                                                            z3 = false;
                                                            eVar6.f1534a.x(h2);
                                                            eVar6.f1534a.A(h3);
                                                            i16 = 1073741824;
                                                            i10 = 2;
                                                        } else {
                                                            aVar6 = aVar16;
                                                            bVar2 = bVar5;
                                                            i9 = o2;
                                                            b.g.b.h.l.e eVar13 = eVar5.f0;
                                                            if (eVar13.f1535b) {
                                                                Iterator<b.g.b.h.d> it5 = eVar13.f1534a.d0.iterator();
                                                                while (it5.hasNext()) {
                                                                    b.g.b.h.d next4 = it5.next();
                                                                    next4.f1511a = false;
                                                                    b.g.b.h.l.j jVar = next4.f1514d;
                                                                    jVar.f1561e.j = false;
                                                                    jVar.f1563g = false;
                                                                    jVar.n();
                                                                    l lVar = next4.f1515e;
                                                                    lVar.f1561e.j = false;
                                                                    lVar.f1563g = false;
                                                                    lVar.m();
                                                                }
                                                                i17 = 0;
                                                                e eVar14 = eVar13.f1534a;
                                                                eVar14.f1511a = false;
                                                                b.g.b.h.l.j jVar2 = eVar14.f1514d;
                                                                jVar2.f1561e.j = false;
                                                                jVar2.f1563g = false;
                                                                jVar2.n();
                                                                l lVar2 = eVar13.f1534a.f1515e;
                                                                lVar2.f1561e.j = false;
                                                                lVar2.f1563g = false;
                                                                lVar2.m();
                                                                eVar13.c();
                                                            } else {
                                                                i17 = 0;
                                                            }
                                                            eVar13.b(eVar13.f1537d);
                                                            e eVar15 = eVar13.f1534a;
                                                            eVar15.N = i17;
                                                            eVar15.O = i17;
                                                            eVar15.f1514d.h.c(i17);
                                                            eVar13.f1534a.f1515e.h.c(i17);
                                                            i16 = 1073741824;
                                                            if (mode == 1073741824) {
                                                                i18 = 1;
                                                                i10 = 1;
                                                                z8 = eVar5.H(z10, i17) & true;
                                                            } else {
                                                                i18 = 1;
                                                                z8 = true;
                                                                i10 = 0;
                                                            }
                                                            if (mode2 == 1073741824) {
                                                                z3 = z8 & eVar5.H(z10, i18);
                                                                i10++;
                                                            } else {
                                                                z3 = z8;
                                                            }
                                                        }
                                                        if (z3) {
                                                            eVar5.C(mode == i16, mode2 == i16);
                                                        }
                                                    } else {
                                                        aVar6 = aVar16;
                                                        bVar2 = bVar5;
                                                        i9 = o2;
                                                        eVar5.f1514d.f();
                                                        eVar5.f1515e.f();
                                                        Iterator<b.g.b.h.d> it6 = eVar5.d0.iterator();
                                                        while (it6.hasNext()) {
                                                            b.g.b.h.d next5 = it6.next();
                                                            next5.f1514d.f();
                                                            next5.f1515e.f();
                                                        }
                                                        i10 = 0;
                                                        z3 = false;
                                                    }
                                                    if (!z3 || i10 != 2) {
                                                        if (size5 > 0) {
                                                            int size6 = eVar5.d0.size();
                                                            b.AbstractC0025b bVar6 = eVar5.g0;
                                                            for (int i28 = 0; i28 < size6; i28++) {
                                                                b.g.b.h.d dVar3 = eVar5.d0.get(i28);
                                                                if (!(dVar3 instanceof f) && (!dVar3.f1514d.f1561e.j || !dVar3.f1515e.f1561e.j)) {
                                                                    if (!(dVar3.h(0) == aVar11 && dVar3.j != 1 && dVar3.h(1) == aVar11 && dVar3.k != 1)) {
                                                                        bVar.a(bVar6, dVar3, false);
                                                                    }
                                                                }
                                                            }
                                                            b bVar7 = (b) bVar6;
                                                            int childCount2 = bVar7.f177a.getChildCount();
                                                            for (int i29 = 0; i29 < childCount2; i29++) {
                                                                View childAt = bVar7.f177a.getChildAt(i29);
                                                                if (childAt instanceof b.g.c.g) {
                                                                    ((b.g.c.g) childAt).a();
                                                                }
                                                            }
                                                            int size7 = bVar7.f177a.f164c.size();
                                                            if (size7 > 0) {
                                                                for (int i30 = 0; i30 < size7; i30++) {
                                                                    bVar7.f177a.f164c.get(i30).g();
                                                                }
                                                            }
                                                        }
                                                        int i31 = eVar5.p0;
                                                        size = bVar.f1524a.size();
                                                        int i32 = i9;
                                                        if (size5 > 0) {
                                                            bVar.b(eVar5, i32, i25);
                                                        }
                                                        if (size > 0) {
                                                            boolean z14 = eVar5.j() == aVar14;
                                                            boolean z15 = eVar5.n() == aVar14;
                                                            int max = Math.max(eVar5.o(), bVar.f1526c.Q);
                                                            int max2 = Math.max(eVar5.i(), bVar.f1526c.R);
                                                            int i33 = 0;
                                                            boolean z16 = false;
                                                            while (i33 < size) {
                                                                b.g.b.h.d dVar4 = bVar.f1524a.get(i33);
                                                                if (!(dVar4 instanceof b.g.b.h.j)) {
                                                                    i15 = i31;
                                                                    aVar7 = aVar5;
                                                                    aVar8 = aVar6;
                                                                    bVar3 = bVar2;
                                                                } else {
                                                                    int o4 = dVar4.o();
                                                                    int i34 = dVar4.i();
                                                                    i15 = i31;
                                                                    bVar3 = bVar2;
                                                                    boolean a2 = z16 | bVar.a(bVar3, dVar4, true);
                                                                    int o5 = dVar4.o();
                                                                    boolean z17 = a2;
                                                                    int i35 = dVar4.i();
                                                                    if (o5 != o4) {
                                                                        dVar4.B(o5);
                                                                        if (!z14 || dVar4.m() <= max) {
                                                                            aVar8 = aVar6;
                                                                        } else {
                                                                            aVar8 = aVar6;
                                                                            max = Math.max(max, dVar4.f(aVar8).b() + dVar4.m());
                                                                        }
                                                                        z17 = true;
                                                                    } else {
                                                                        aVar8 = aVar6;
                                                                    }
                                                                    if (i35 != i34) {
                                                                        dVar4.w(i35);
                                                                        if (!z15 || dVar4.g() <= max2) {
                                                                            aVar7 = aVar5;
                                                                        } else {
                                                                            aVar7 = aVar5;
                                                                            max2 = Math.max(max2, dVar4.f(aVar7).b() + dVar4.g());
                                                                        }
                                                                        z17 = true;
                                                                    } else {
                                                                        aVar7 = aVar5;
                                                                    }
                                                                    z16 = ((b.g.b.h.j) dVar4).f0 | z17;
                                                                }
                                                                i33++;
                                                                aVar6 = aVar8;
                                                                aVar5 = aVar7;
                                                                bVar2 = bVar3;
                                                                i31 = i15;
                                                            }
                                                            i11 = i31;
                                                            int i36 = 0;
                                                            int i37 = 2;
                                                            while (i36 < i37) {
                                                                int i38 = max2;
                                                                int i39 = max;
                                                                boolean z18 = z16;
                                                                int i40 = 0;
                                                                while (i40 < size) {
                                                                    b.g.b.h.d dVar5 = bVar.f1524a.get(i40);
                                                                    if ((!(dVar5 instanceof g) || (dVar5 instanceof b.g.b.h.j)) && !(dVar5 instanceof f)) {
                                                                        i14 = i36;
                                                                        if (dVar5.V != 8 && ((!dVar5.f1514d.f1561e.j || !dVar5.f1515e.f1561e.j) && !(dVar5 instanceof b.g.b.h.j))) {
                                                                            int o6 = dVar5.o();
                                                                            int i41 = dVar5.i();
                                                                            i13 = i32;
                                                                            int i42 = dVar5.P;
                                                                            eVar3 = eVar5;
                                                                            boolean a3 = z18 | bVar.a(bVar2, dVar5, true);
                                                                            int o7 = dVar5.o();
                                                                            int i43 = dVar5.i();
                                                                            if (o7 != o6) {
                                                                                dVar5.B(o7);
                                                                                if (z14 && dVar5.m() > i39) {
                                                                                    i39 = Math.max(i39, dVar5.f(aVar6).b() + dVar5.m());
                                                                                }
                                                                                a3 = true;
                                                                            }
                                                                            if (i43 != i41) {
                                                                                dVar5.w(i43);
                                                                                if (z15 && dVar5.g() > i38) {
                                                                                    i38 = Math.max(i38, dVar5.f(aVar5).b() + dVar5.g());
                                                                                }
                                                                                a3 = true;
                                                                            }
                                                                            if (!dVar5.w || i42 == dVar5.P) {
                                                                                z18 = a3;
                                                                                i40++;
                                                                                size = size;
                                                                                i36 = i14;
                                                                                eVar5 = eVar3;
                                                                                i32 = i13;
                                                                            } else {
                                                                                z18 = true;
                                                                                i40++;
                                                                                size = size;
                                                                                i36 = i14;
                                                                                eVar5 = eVar3;
                                                                                i32 = i13;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        i14 = i36;
                                                                    }
                                                                    i13 = i32;
                                                                    eVar3 = eVar5;
                                                                    i40++;
                                                                    size = size;
                                                                    i36 = i14;
                                                                    eVar5 = eVar3;
                                                                    i32 = i13;
                                                                }
                                                                if (z18) {
                                                                    eVar2 = eVar5;
                                                                    i12 = i32;
                                                                    bVar.b(eVar2, i12, i25);
                                                                    z16 = false;
                                                                } else {
                                                                    eVar2 = eVar5;
                                                                    i12 = i32;
                                                                    z16 = z18;
                                                                }
                                                                eVar5 = eVar2;
                                                                i36++;
                                                                max = i39;
                                                                max2 = i38;
                                                                i37 = 2;
                                                                i32 = i12;
                                                                size = size;
                                                            }
                                                            eVar = eVar5;
                                                            if (z16) {
                                                                bVar.b(eVar, i32, i25);
                                                                if (eVar.o() < max) {
                                                                    eVar.B(max);
                                                                    z6 = true;
                                                                } else {
                                                                    z6 = false;
                                                                }
                                                                if (eVar.i() < max2) {
                                                                    eVar.w(max2);
                                                                    z7 = true;
                                                                } else {
                                                                    z7 = z6;
                                                                }
                                                                if (z7) {
                                                                    bVar.b(eVar, i32, i25);
                                                                }
                                                            }
                                                        } else {
                                                            i11 = i31;
                                                            eVar = eVar5;
                                                        }
                                                        eVar.p0 = i11;
                                                    }
                                                    int o8 = this.f165d.o();
                                                    int i44 = this.f165d.i();
                                                    e eVar16 = this.f165d;
                                                    z4 = eVar16.q0;
                                                    z5 = eVar16.r0;
                                                    int paddingBottom3 = getPaddingBottom() + getPaddingTop();
                                                    int min3 = Math.min(this.f168g, ViewGroup.resolveSizeAndState(o8 + getPaddingWidth(), i2, 0) & 16777215);
                                                    int min4 = Math.min(this.h, ViewGroup.resolveSizeAndState(i44 + paddingBottom3, i3, 0) & 16777215);
                                                    if (z4) {
                                                        min3 |= 16777216;
                                                    }
                                                    if (z5) {
                                                        min4 |= 16777216;
                                                    }
                                                    setMeasuredDimension(min3, min4);
                                                    this.o = min3;
                                                    this.p = min4;
                                                    return;
                                                }
                                                aVar5 = aVar15;
                                                z2 = z;
                                                i8 = 1073741824;
                                                if (z2 && ((mode != i8 && mode2 == i8) || z10)) {
                                                }
                                                if (size5 > 0) {
                                                }
                                                int i312 = eVar5.p0;
                                                size = bVar.f1524a.size();
                                                int i322 = i9;
                                                if (size5 > 0) {
                                                }
                                                if (size > 0) {
                                                }
                                                eVar.p0 = i11;
                                                int o82 = this.f165d.o();
                                                int i442 = this.f165d.i();
                                                e eVar162 = this.f165d;
                                                z4 = eVar162.q0;
                                                z5 = eVar162.r0;
                                                int paddingBottom32 = getPaddingBottom() + getPaddingTop();
                                                int min32 = Math.min(this.f168g, ViewGroup.resolveSizeAndState(o82 + getPaddingWidth(), i2, 0) & 16777215);
                                                int min42 = Math.min(this.h, ViewGroup.resolveSizeAndState(i442 + paddingBottom32, i3, 0) & 16777215);
                                                if (z4) {
                                                }
                                                if (z5) {
                                                }
                                                setMeasuredDimension(min32, min42);
                                                this.o = min32;
                                                this.p = min42;
                                                return;
                                            }
                                        }
                                        z = true;
                                        if (z) {
                                        }
                                        aVar5 = aVar15;
                                        z2 = z;
                                        i8 = 1073741824;
                                        if (z2 && ((mode != i8 && mode2 == i8) || z10)) {
                                        }
                                        if (size5 > 0) {
                                        }
                                        int i3122 = eVar5.p0;
                                        size = bVar.f1524a.size();
                                        int i3222 = i9;
                                        if (size5 > 0) {
                                        }
                                        if (size > 0) {
                                        }
                                        eVar.p0 = i11;
                                        int o822 = this.f165d.o();
                                        int i4422 = this.f165d.i();
                                        e eVar1622 = this.f165d;
                                        z4 = eVar1622.q0;
                                        z5 = eVar1622.r0;
                                        int paddingBottom322 = getPaddingBottom() + getPaddingTop();
                                        int min322 = Math.min(this.f168g, ViewGroup.resolveSizeAndState(o822 + getPaddingWidth(), i2, 0) & 16777215);
                                        int min422 = Math.min(this.h, ViewGroup.resolveSizeAndState(i4422 + paddingBottom322, i3, 0) & 16777215);
                                        if (z4) {
                                        }
                                        if (z5) {
                                        }
                                        setMeasuredDimension(min322, min422);
                                        this.o = min322;
                                        this.p = min422;
                                        return;
                                    }
                                    throw null;
                                }
                            } else if (childCount != 0) {
                                aVar4 = aVar13;
                            }
                            aVar3 = aVar10;
                            aVar2 = aVar12;
                            i7 = 0;
                            d.a aVar142 = aVar13;
                            eVar5.f0.f1536c = true;
                            eVar5.N = 0;
                            eVar5.O = 0;
                            int[] iArr2 = eVar5.u;
                            iArr2[0] = this.f168g - paddingWidth2;
                            iArr2[1] = this.h - paddingBottom2;
                            eVar5.z(0);
                            eVar5.y(0);
                            eVar5.H[0] = aVar;
                            eVar5.B(i5);
                            eVar5.H[1] = aVar4;
                            eVar5.w(i7);
                            eVar5.z(this.f166e - paddingWidth2);
                            eVar5.y(this.f167f - paddingBottom2);
                            eVar5.j0 = i4;
                            eVar5.k0 = paddingTop;
                            bVar = eVar5.e0;
                            if (bVar == null) {
                            }
                        } else if (childCount != 0) {
                            aVar3 = aVar10;
                            aVar2 = aVar12;
                            aVar4 = aVar13;
                            i7 = i24;
                            d.a aVar1422 = aVar13;
                            eVar5.f0.f1536c = true;
                            eVar5.N = 0;
                            eVar5.O = 0;
                            int[] iArr22 = eVar5.u;
                            iArr22[0] = this.f168g - paddingWidth2;
                            iArr22[1] = this.h - paddingBottom2;
                            eVar5.z(0);
                            eVar5.y(0);
                            eVar5.H[0] = aVar;
                            eVar5.B(i5);
                            eVar5.H[1] = aVar4;
                            eVar5.w(i7);
                            eVar5.z(this.f166e - paddingWidth2);
                            eVar5.y(this.f167f - paddingBottom2);
                            eVar5.j0 = i4;
                            eVar5.k0 = paddingTop;
                            bVar = eVar5.e0;
                            if (bVar == null) {
                            }
                        }
                        aVar3 = aVar10;
                        i7 = Math.max(0, this.f167f);
                        aVar2 = aVar12;
                        aVar4 = aVar13;
                        d.a aVar14222 = aVar13;
                        eVar5.f0.f1536c = true;
                        eVar5.N = 0;
                        eVar5.O = 0;
                        int[] iArr222 = eVar5.u;
                        iArr222[0] = this.f168g - paddingWidth2;
                        iArr222[1] = this.h - paddingBottom2;
                        eVar5.z(0);
                        eVar5.y(0);
                        eVar5.H[0] = aVar;
                        eVar5.B(i5);
                        eVar5.H[1] = aVar4;
                        eVar5.w(i7);
                        eVar5.z(this.f166e - paddingWidth2);
                        eVar5.y(this.f167f - paddingBottom2);
                        eVar5.j0 = i4;
                        eVar5.k0 = paddingTop;
                        bVar = eVar5.e0;
                        if (bVar == null) {
                        }
                    }
                } else if (childCount != 0) {
                    aVar = aVar13;
                }
                i6 = Integer.MIN_VALUE;
                i5 = 0;
                if (mode2 != i6) {
                }
                aVar3 = aVar10;
                i7 = Math.max(0, this.f167f);
                aVar2 = aVar12;
                aVar4 = aVar13;
                d.a aVar142222 = aVar13;
                eVar5.f0.f1536c = true;
                eVar5.N = 0;
                eVar5.O = 0;
                int[] iArr2222 = eVar5.u;
                iArr2222[0] = this.f168g - paddingWidth2;
                iArr2222[1] = this.h - paddingBottom2;
                eVar5.z(0);
                eVar5.y(0);
                eVar5.H[0] = aVar;
                eVar5.B(i5);
                eVar5.H[1] = aVar4;
                eVar5.w(i7);
                eVar5.z(this.f166e - paddingWidth2);
                eVar5.y(this.f167f - paddingBottom2);
                eVar5.j0 = i4;
                eVar5.k0 = paddingTop;
                bVar = eVar5.e0;
                if (bVar == null) {
                }
            } else if (childCount != 0) {
                i20 = i23;
                i5 = i20;
                aVar = aVar13;
                i6 = BleSignal.UNKNOWN_TX_POWER;
                if (mode2 != i6) {
                }
                aVar3 = aVar10;
                i7 = Math.max(0, this.f167f);
                aVar2 = aVar12;
                aVar4 = aVar13;
                d.a aVar1422222 = aVar13;
                eVar5.f0.f1536c = true;
                eVar5.N = 0;
                eVar5.O = 0;
                int[] iArr22222 = eVar5.u;
                iArr22222[0] = this.f168g - paddingWidth2;
                iArr22222[1] = this.h - paddingBottom2;
                eVar5.z(0);
                eVar5.y(0);
                eVar5.H[0] = aVar;
                eVar5.B(i5);
                eVar5.H[1] = aVar4;
                eVar5.w(i7);
                eVar5.z(this.f166e - paddingWidth2);
                eVar5.y(this.f167f - paddingBottom2);
                eVar5.j0 = i4;
                eVar5.k0 = paddingTop;
                bVar = eVar5.e0;
                if (bVar == null) {
                }
            }
            i20 = Math.max(0, this.f166e);
            i5 = i20;
            aVar = aVar13;
            i6 = BleSignal.UNKNOWN_TX_POWER;
            if (mode2 != i6) {
            }
            aVar3 = aVar10;
            i7 = Math.max(0, this.f167f);
            aVar2 = aVar12;
            aVar4 = aVar13;
            d.a aVar14222222 = aVar13;
            eVar5.f0.f1536c = true;
            eVar5.N = 0;
            eVar5.O = 0;
            int[] iArr222222 = eVar5.u;
            iArr222222[0] = this.f168g - paddingWidth2;
            iArr222222[1] = this.h - paddingBottom2;
            eVar5.z(0);
            eVar5.y(0);
            eVar5.H[0] = aVar;
            eVar5.B(i5);
            eVar5.H[1] = aVar4;
            eVar5.w(i7);
            eVar5.z(this.f166e - paddingWidth2);
            eVar5.y(this.f167f - paddingBottom2);
            eVar5.j0 = i4;
            eVar5.k0 = paddingTop;
            bVar = eVar5.e0;
            if (bVar == null) {
            }
        }
        i4 = paddingStart;
        int i232 = size3 - paddingWidth;
        int i242 = size4 - paddingBottom;
        int paddingBottom22 = getPaddingBottom() + getPaddingTop();
        int paddingWidth22 = getPaddingWidth();
        int childCount3 = getChildCount();
        if (mode == Integer.MIN_VALUE) {
        }
        i20 = Math.max(0, this.f166e);
        i5 = i20;
        aVar = aVar13;
        i6 = BleSignal.UNKNOWN_TX_POWER;
        if (mode2 != i6) {
        }
        aVar3 = aVar10;
        i7 = Math.max(0, this.f167f);
        aVar2 = aVar12;
        aVar4 = aVar13;
        d.a aVar142222222 = aVar13;
        eVar5.f0.f1536c = true;
        eVar5.N = 0;
        eVar5.O = 0;
        int[] iArr2222222 = eVar5.u;
        iArr2222222[0] = this.f168g - paddingWidth22;
        iArr2222222[1] = this.h - paddingBottom22;
        eVar5.z(0);
        eVar5.y(0);
        eVar5.H[0] = aVar;
        eVar5.B(i5);
        eVar5.H[1] = aVar4;
        eVar5.w(i7);
        eVar5.z(this.f166e - paddingWidth22);
        eVar5.y(this.f167f - paddingBottom22);
        eVar5.j0 = i4;
        eVar5.k0 = paddingTop;
        bVar = eVar5.e0;
        if (bVar == null) {
        }
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        b.g.b.h.d f2 = f(view);
        if ((view instanceof Guideline) && !(f2 instanceof f)) {
            a aVar = (a) view.getLayoutParams();
            f fVar = new f();
            aVar.m0 = fVar;
            aVar.Y = true;
            fVar.E(aVar.R);
        }
        if (view instanceof b.g.c.b) {
            b.g.c.b bVar = (b.g.c.b) view;
            bVar.i();
            ((a) view.getLayoutParams()).Z = true;
            if (!this.f164c.contains(bVar)) {
                this.f164c.add(bVar);
            }
        }
        this.f163b.put(view.getId(), view);
        this.i = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f163b.remove(view.getId());
        b.g.b.h.d f2 = f(view);
        this.f165d.d0.remove(f2);
        f2.I = null;
        this.f164c.remove(view);
        this.i = true;
    }

    public void removeView(View view) {
        super.removeView(view);
    }

    public void requestLayout() {
        this.i = true;
        this.o = -1;
        this.p = -1;
        super.requestLayout();
    }

    public void setConstraintSet(b.g.c.d dVar) {
        this.k = dVar;
    }

    public void setId(int i2) {
        this.f163b.remove(getId());
        super.setId(i2);
        this.f163b.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 != this.h) {
            this.h = i2;
            requestLayout();
        }
    }

    public void setMaxWidth(int i2) {
        if (i2 != this.f168g) {
            this.f168g = i2;
            requestLayout();
        }
    }

    public void setMinHeight(int i2) {
        if (i2 != this.f167f) {
            this.f167f = i2;
            requestLayout();
        }
    }

    public void setMinWidth(int i2) {
        if (i2 != this.f166e) {
            this.f166e = i2;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(b.g.c.f fVar) {
        b.g.c.c cVar = this.l;
        if (cVar != null && cVar == null) {
            throw null;
        }
    }

    public void setOptimizationLevel(int i2) {
        this.j = i2;
        this.f165d.p0 = i2;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
