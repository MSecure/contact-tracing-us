package e.b.f;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionMenuView;
import e.b.e.i.g;
import e.j.j.v;
import e.j.j.x;
import e.j.j.y;
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {
    public final C0019a b;
    public final Context c;

    /* renamed from: d */
    public ActionMenuView f894d;

    /* renamed from: e */
    public c f895e;

    /* renamed from: f */
    public int f896f;

    /* renamed from: g */
    public x f897g;

    /* renamed from: h */
    public boolean f898h;

    /* renamed from: i */
    public boolean f899i;

    /* renamed from: e.b.f.a$a */
    /* loaded from: classes.dex */
    public class C0019a implements y {
        public boolean a = false;
        public int b;

        public C0019a() {
            a.this = r1;
        }

        @Override // e.j.j.y
        public void a(View view) {
            if (!this.a) {
                a aVar = a.this;
                aVar.f897g = null;
                a.super.setVisibility(this.b);
            }
        }

        @Override // e.j.j.y
        public void b(View view) {
            a.super.setVisibility(0);
            this.a = false;
        }

        @Override // e.j.j.y
        public void c(View view) {
            this.a = true;
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = new C0019a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.c = context;
        } else {
            this.c = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public int c(View view, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    public int d(View view, int i2, int i3, int i4, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = ((i4 - measuredHeight) / 2) + i3;
        if (z) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public x e(int i2, long j2) {
        x xVar = this.f897g;
        if (xVar != null) {
            xVar.b();
        }
        if (i2 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            x b = v.b(this);
            b.a(1.0f);
            b.c(j2);
            C0019a aVar = this.b;
            a.this.f897g = b;
            aVar.b = i2;
            View view = b.a.get();
            if (view != null) {
                b.e(view, aVar);
            }
            return b;
        }
        x b2 = v.b(this);
        b2.a(0.0f);
        b2.c(j2);
        C0019a aVar2 = this.b;
        a.this.f897g = b2;
        aVar2.b = i2;
        View view2 = b2.a.get();
        if (view2 != null) {
            b2.e(view2, aVar2);
        }
        return b2;
    }

    public int getAnimatedVisibility() {
        return this.f897g != null ? this.b.b : getVisibility();
    }

    public int getContentHeight() {
        return this.f896f;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.f895e;
        if (cVar != null) {
            Configuration configuration2 = cVar.c.getResources().getConfiguration();
            int i2 = configuration2.screenWidthDp;
            int i3 = configuration2.screenHeightDp;
            cVar.q = (configuration2.smallestScreenWidthDp > 600 || i2 > 600 || (i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960)) ? 5 : (i2 >= 500 || (i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640)) ? 4 : i2 >= 360 ? 3 : 2;
            g gVar = cVar.f826d;
            if (gVar != null) {
                gVar.q(true);
            }
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f899i = false;
        }
        if (!this.f899i) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f899i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f899i = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f898h = false;
        }
        if (!this.f898h) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f898h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f898h = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i2);

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            x xVar = this.f897g;
            if (xVar != null) {
                xVar.b();
            }
            super.setVisibility(i2);
        }
    }
}
