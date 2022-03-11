package e.b.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import e.j.k.c;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class j0 extends ListView {
    public final Rect b = new Rect();
    public int c = 0;

    /* renamed from: d */
    public int f972d = 0;

    /* renamed from: e */
    public int f973e = 0;

    /* renamed from: f */
    public int f974f = 0;

    /* renamed from: g */
    public int f975g;

    /* renamed from: h */
    public Field f976h;

    /* renamed from: i */
    public a f977i;

    /* renamed from: j */
    public boolean f978j;

    /* renamed from: k */
    public boolean f979k;

    /* renamed from: l */
    public boolean f980l;
    public c m;
    public b n;

    /* loaded from: classes.dex */
    public static class a extends e.b.b.a.c {
        public boolean c = true;

        public a(Drawable drawable) {
            super(drawable);
        }

        @Override // e.b.b.a.c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.c) {
                this.b.draw(canvas);
            }
        }

        @Override // e.b.b.a.c, android.graphics.drawable.Drawable
        public void setHotspot(float f2, float f3) {
            if (this.c) {
                this.b.setHotspot(f2, f3);
            }
        }

        @Override // e.b.b.a.c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i2, int i3, int i4, int i5) {
            if (this.c) {
                this.b.setHotspotBounds(i2, i3, i4, i5);
            }
        }

        @Override // e.b.b.a.c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.c) {
                return this.b.setState(iArr);
            }
            return false;
        }

        @Override // e.b.b.a.c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.c) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
            j0.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0 j0Var = j0.this;
            j0Var.n = null;
            j0Var.drawableStateChanged();
        }
    }

    public j0(Context context, boolean z) {
        super(context, null, R$attr.dropDownListViewStyle);
        this.f979k = z;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f976h = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private void setSelectorEnabled(boolean z) {
        a aVar = this.f977i;
        if (aVar != null) {
            aVar.c = z;
        }
    }

    public int a(int i2, int i3, int i4) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int i5 = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return i5;
        }
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < count) {
            int itemViewType = adapter.getItemViewType(i6);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i6, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i9 = layoutParams.height;
            view.measure(i2, i9 > 0 ? View.MeasureSpec.makeMeasureSpec(i9, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i6 > 0) {
                i5 += dividerHeight;
            }
            i5 += view.getMeasuredHeight();
            if (i5 >= i3) {
                return (i4 < 0 || i6 <= i4 || i8 <= 0 || i5 == i3) ? i3 : i8;
            }
            if (i4 >= 0 && i6 >= i4) {
                i8 = i5;
            }
            i6++;
        }
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r3 != 3) goto L_0x0121;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0157  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean b(MotionEvent motionEvent, int i2) {
        boolean z;
        View childAt;
        View childAt2;
        int actionMasked = motionEvent.getActionMasked();
        boolean z2 = true;
        if (actionMasked == 1) {
            z = false;
        } else if (actionMasked == 2) {
            z = true;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        if (findPointerIndex >= 0) {
            int x = (int) motionEvent.getX(findPointerIndex);
            int y = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, y);
            if (pointToPosition != -1) {
                View childAt3 = getChildAt(pointToPosition - getFirstVisiblePosition());
                float f2 = (float) x;
                float f3 = (float) y;
                this.f980l = true;
                drawableHotspotChanged(f2, f3);
                if (!isPressed()) {
                    setPressed(true);
                }
                layoutChildren();
                int i3 = this.f975g;
                if (!(i3 == -1 || (childAt2 = getChildAt(i3 - getFirstVisiblePosition())) == null || childAt2 == childAt3 || !childAt2.isPressed())) {
                    childAt2.setPressed(false);
                }
                this.f975g = pointToPosition;
                childAt3.drawableHotspotChanged(f2 - ((float) childAt3.getLeft()), f3 - ((float) childAt3.getTop()));
                if (!childAt3.isPressed()) {
                    childAt3.setPressed(true);
                }
                Drawable selector = getSelector();
                boolean z3 = (selector == null || pointToPosition == -1) ? false : true;
                if (z3) {
                    selector.setVisible(false, false);
                }
                Rect rect = this.b;
                rect.set(childAt3.getLeft(), childAt3.getTop(), childAt3.getRight(), childAt3.getBottom());
                rect.left -= this.c;
                rect.top -= this.f972d;
                rect.right += this.f973e;
                rect.bottom += this.f974f;
                try {
                    boolean z4 = this.f976h.getBoolean(this);
                    if (childAt3.isEnabled() != z4) {
                        this.f976h.set(this, Boolean.valueOf(!z4));
                        if (pointToPosition != -1) {
                            refreshDrawableState();
                        }
                    }
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
                if (z3) {
                    Rect rect2 = this.b;
                    float exactCenterX = rect2.exactCenterX();
                    float exactCenterY = rect2.exactCenterY();
                    selector.setVisible(getVisibility() == 0, false);
                    selector.setHotspot(exactCenterX, exactCenterY);
                }
                Drawable selector2 = getSelector();
                if (!(selector2 == null || pointToPosition == -1)) {
                    selector2.setHotspot(f2, f3);
                }
                setSelectorEnabled(false);
                refreshDrawableState();
                if (actionMasked == 1) {
                    performItemClick(childAt3, pointToPosition, getItemIdAtPosition(pointToPosition));
                }
                z = true;
                z2 = false;
            }
            if (z || z2) {
                this.f980l = false;
                setPressed(false);
                drawableStateChanged();
                childAt = getChildAt(this.f975g - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setPressed(false);
                }
            }
            if (!z) {
                if (this.m == null) {
                    this.m = new c(this);
                }
                c cVar = this.m;
                boolean z5 = cVar.q;
                cVar.q = true;
                cVar.onTouch(this, motionEvent);
            } else {
                c cVar2 = this.m;
                if (cVar2 != null) {
                    if (cVar2.q) {
                        cVar2.d();
                    }
                    cVar2.q = false;
                }
            }
            return z;
        }
        z = false;
        z2 = false;
        if (z) {
        }
        this.f980l = false;
        setPressed(false);
        drawableStateChanged();
        childAt = getChildAt(this.f975g - getFirstVisiblePosition());
        if (childAt != null) {
        }
        if (!z) {
        }
        return z;
    }

    public final void c() {
        Drawable selector = getSelector();
        if (selector != null && this.f980l && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Drawable selector;
        if (!this.b.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.b);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.n == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f979k || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f979k || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f979k || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f979k && this.f978j) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View, android.widget.AdapterView
    public void onDetachedFromWindow() {
        this.n = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.n == null) {
            b bVar = new b();
            this.n = bVar;
            post(bVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                c();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f975g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.n;
        if (bVar != null) {
            j0 j0Var = j0.this;
            j0Var.n = null;
            j0Var.removeCallbacks(bVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z) {
        this.f978j = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        a aVar = drawable != null ? new a(drawable) : null;
        this.f977i = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.c = rect.left;
        this.f972d = rect.top;
        this.f973e = rect.right;
        this.f974f = rect.bottom;
    }
}
