package b.i.l;

import android.view.View;
import android.view.ViewParent;
import b.b.k.i;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public ViewParent f1148a;

    /* renamed from: b  reason: collision with root package name */
    public ViewParent f1149b;

    /* renamed from: c  reason: collision with root package name */
    public final View f1150c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1151d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f1152e;

    public f(View view) {
        this.f1150c = view;
    }

    public boolean a(float f, float f2, boolean z) {
        ViewParent f3;
        if (!this.f1151d || (f3 = f(0)) == null) {
            return false;
        }
        return i.j.F0(f3, this.f1150c, f, f2, z);
    }

    public boolean b(float f, float f2) {
        ViewParent f3;
        if (!this.f1151d || (f3 = f(0)) == null) {
            return false;
        }
        return i.j.G0(f3, this.f1150c, f, f2);
    }

    public boolean c(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent f;
        int i4;
        int i5;
        if (!this.f1151d || (f = f(i3)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            if (iArr2 != null) {
                this.f1150c.getLocationInWindow(iArr2);
                i5 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i5 = 0;
                i4 = 0;
            }
            if (iArr == null) {
                if (this.f1152e == null) {
                    this.f1152e = new int[2];
                }
                iArr = this.f1152e;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            i.j.H0(f, this.f1150c, i, i2, iArr, i3);
            if (iArr2 != null) {
                this.f1150c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i5;
                iArr2[1] = iArr2[1] - i4;
            }
            if (iArr[0] == 0 && iArr[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean d(int i, int i2, int i3, int i4, int[] iArr) {
        return e(i, i2, i3, i4, iArr, 0, null);
    }

    public final boolean e(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent f;
        int i6;
        int i7;
        int[] iArr3;
        if (!this.f1151d || (f = f(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f1150c.getLocationInWindow(iArr);
            i7 = iArr[0];
            i6 = iArr[1];
        } else {
            i7 = 0;
            i6 = 0;
        }
        if (iArr2 == null) {
            if (this.f1152e == null) {
                this.f1152e = new int[2];
            }
            int[] iArr4 = this.f1152e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        i.j.I0(f, this.f1150c, i, i2, i3, i4, i5, iArr3);
        if (iArr != null) {
            this.f1150c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i7;
            iArr[1] = iArr[1] - i6;
        }
        return true;
    }

    public final ViewParent f(int i) {
        if (i == 0) {
            return this.f1148a;
        }
        if (i != 1) {
            return null;
        }
        return this.f1149b;
    }

    public boolean g(int i) {
        return f(i) != null;
    }

    public boolean h(int i, int i2) {
        boolean z;
        if (f(i2) != null) {
            return true;
        }
        if (this.f1151d) {
            View view = this.f1150c;
            for (ViewParent parent = this.f1150c.getParent(); parent != null; parent = parent.getParent()) {
                View view2 = this.f1150c;
                boolean z2 = parent instanceof g;
                if (z2) {
                    z = ((g) parent).o(view, view2, i, i2);
                } else {
                    if (i2 == 0) {
                        try {
                            z = parent.onStartNestedScroll(view, view2, i);
                        } catch (AbstractMethodError unused) {
                            String str = "ViewParent " + parent + " does not implement interface method onStartNestedScroll";
                        }
                    }
                    z = false;
                }
                if (z) {
                    if (i2 == 0) {
                        this.f1148a = parent;
                    } else if (i2 == 1) {
                        this.f1149b = parent;
                    }
                    View view3 = this.f1150c;
                    if (z2) {
                        ((g) parent).h(view, view3, i, i2);
                    } else if (i2 == 0) {
                        try {
                            parent.onNestedScrollAccepted(view, view3, i);
                        } catch (AbstractMethodError unused2) {
                            String str2 = "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted";
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void i(int i) {
        ViewParent f = f(i);
        if (f != null) {
            View view = this.f1150c;
            if (f instanceof g) {
                ((g) f).i(view, i);
            } else if (i == 0) {
                try {
                    f.onStopNestedScroll(view);
                } catch (AbstractMethodError unused) {
                    String str = "ViewParent " + f + " does not implement interface method onStopNestedScroll";
                }
            }
            if (i == 0) {
                this.f1148a = null;
            } else if (i == 1) {
                this.f1149b = null;
            }
        }
    }
}
