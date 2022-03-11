package e.j.j;

import android.view.View;
import android.view.ViewParent;
/* loaded from: classes.dex */
public class j {
    public ViewParent a;
    public ViewParent b;
    public final View c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1638d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f1639e;

    public j(View view) {
        this.c = view;
    }

    public boolean a(float f2, float f3, boolean z) {
        ViewParent g2;
        if (!this.f1638d || (g2 = g(0)) == null) {
            return false;
        }
        try {
            return g2.onNestedFling(this.c, f2, f3, z);
        } catch (AbstractMethodError unused) {
            String str = "ViewParent " + g2 + " does not implement interface method onNestedFling";
            return false;
        }
    }

    public boolean b(float f2, float f3) {
        ViewParent g2;
        if (!this.f1638d || (g2 = g(0)) == null) {
            return false;
        }
        try {
            return g2.onNestedPreFling(this.c, f2, f3);
        } catch (AbstractMethodError unused) {
            String str = "ViewParent " + g2 + " does not implement interface method onNestedPreFling";
            return false;
        }
    }

    public boolean c(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        ViewParent g2;
        int i5;
        int i6;
        int[] iArr3;
        if (!this.f1638d || (g2 = g(i4)) == null) {
            return false;
        }
        if (i2 != 0 || i3 != 0) {
            if (iArr2 != null) {
                this.c.getLocationInWindow(iArr2);
                i6 = iArr2[0];
                i5 = iArr2[1];
            } else {
                i6 = 0;
                i5 = 0;
            }
            if (iArr == null) {
                if (this.f1639e == null) {
                    this.f1639e = new int[2];
                }
                iArr3 = this.f1639e;
            } else {
                iArr3 = iArr;
            }
            iArr3[0] = 0;
            iArr3[1] = 0;
            View view = this.c;
            if (g2 instanceof k) {
                ((k) g2).j(view, i2, i3, iArr3, i4);
            } else if (i4 == 0) {
                try {
                    g2.onNestedPreScroll(view, i2, i3, iArr3);
                } catch (AbstractMethodError unused) {
                    String str = "ViewParent " + g2 + " does not implement interface method onNestedPreScroll";
                }
            }
            if (iArr2 != null) {
                this.c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i6;
                iArr2[1] = iArr2[1] - i5;
            }
            if (!(iArr3[0] == 0 && iArr3[1] == 0)) {
                return true;
            }
        } else if (iArr2 != null) {
            iArr2[0] = 0;
            iArr2[1] = 0;
        }
        return false;
    }

    public void d(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        f(i2, i3, i4, i5, null, i6, iArr2);
    }

    public boolean e(int i2, int i3, int i4, int i5, int[] iArr) {
        return f(i2, i3, i4, i5, iArr, 0, null);
    }

    public final boolean f(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        ViewParent g2;
        int i7;
        int i8;
        int[] iArr3;
        if (!this.f1638d || (g2 = g(i6)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            i8 = iArr[0];
            i7 = iArr[1];
        } else {
            i8 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            if (this.f1639e == null) {
                this.f1639e = new int[2];
            }
            int[] iArr4 = this.f1639e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        View view = this.c;
        if (g2 instanceof l) {
            ((l) g2).m(view, i2, i3, i4, i5, i6, iArr3);
        } else {
            iArr3[0] = iArr3[0] + i4;
            iArr3[1] = iArr3[1] + i5;
            if (g2 instanceof k) {
                ((k) g2).n(view, i2, i3, i4, i5, i6);
            } else if (i6 == 0) {
                try {
                    g2.onNestedScroll(view, i2, i3, i4, i5);
                } catch (AbstractMethodError unused) {
                    String str = "ViewParent " + g2 + " does not implement interface method onNestedScroll";
                }
            }
        }
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i8;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public final ViewParent g(int i2) {
        if (i2 == 0) {
            return this.a;
        }
        if (i2 != 1) {
            return null;
        }
        return this.b;
    }

    public boolean h(int i2) {
        return g(i2) != null;
    }

    public boolean i(int i2, int i3) {
        boolean z;
        if (g(i3) != null) {
            return true;
        }
        if (this.f1638d) {
            View view = this.c;
            for (ViewParent parent = this.c.getParent(); parent != null; parent = parent.getParent()) {
                View view2 = this.c;
                boolean z2 = parent instanceof k;
                if (z2) {
                    z = ((k) parent).o(view, view2, i2, i3);
                } else {
                    if (i3 == 0) {
                        try {
                            z = parent.onStartNestedScroll(view, view2, i2);
                        } catch (AbstractMethodError unused) {
                            String str = "ViewParent " + parent + " does not implement interface method onStartNestedScroll";
                        }
                    }
                    z = false;
                }
                if (z) {
                    if (i3 == 0) {
                        this.a = parent;
                    } else if (i3 == 1) {
                        this.b = parent;
                    }
                    View view3 = this.c;
                    if (z2) {
                        ((k) parent).h(view, view3, i2, i3);
                    } else if (i3 == 0) {
                        try {
                            parent.onNestedScrollAccepted(view, view3, i2);
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

    public void j(int i2) {
        ViewParent g2 = g(i2);
        if (g2 != null) {
            View view = this.c;
            if (g2 instanceof k) {
                ((k) g2).i(view, i2);
            } else if (i2 == 0) {
                try {
                    g2.onStopNestedScroll(view);
                } catch (AbstractMethodError unused) {
                    String str = "ViewParent " + g2 + " does not implement interface method onStopNestedScroll";
                }
            }
            if (i2 == 0) {
                this.a = null;
            } else if (i2 == 1) {
                this.b = null;
            }
        }
    }
}
