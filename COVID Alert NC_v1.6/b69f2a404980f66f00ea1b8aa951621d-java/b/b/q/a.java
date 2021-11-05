package b.b.q;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import b.b.j;
import b.b.p.i.g;
import b.i.l.m;
import b.i.l.r;
import b.i.l.s;

public abstract class a extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public final C0011a f578b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f579c;

    /* renamed from: d  reason: collision with root package name */
    public ActionMenuView f580d;

    /* renamed from: e  reason: collision with root package name */
    public c f581e;
    public int f;
    public r g;
    public boolean h;
    public boolean i;

    /* renamed from: b.b.q.a$a  reason: collision with other inner class name */
    public class C0011a implements s {

        /* renamed from: a  reason: collision with root package name */
        public boolean f582a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f583b;

        public C0011a() {
        }

        @Override // b.i.l.s
        public void a(View view) {
            if (!this.f582a) {
                a aVar = a.this;
                aVar.g = null;
                a.super.setVisibility(this.f583b);
            }
        }

        @Override // b.i.l.s
        public void b(View view) {
            a.super.setVisibility(0);
            this.f582a = false;
        }

        @Override // b.i.l.s
        public void c(View view) {
            this.f582a = true;
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f578b = new C0011a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(b.b.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f579c = context;
        } else {
            this.f579c = new ContextThemeWrapper(context, typedValue.resourceId);
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

    public r e(int i2, long j) {
        r rVar = this.g;
        if (rVar != null) {
            rVar.b();
        }
        if (i2 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            r a2 = m.a(this);
            a2.a(1.0f);
            a2.c(j);
            C0011a aVar = this.f578b;
            a.this.g = a2;
            aVar.f583b = i2;
            View view = a2.f1171a.get();
            if (view != null) {
                a2.e(view, aVar);
            }
            return a2;
        }
        r a3 = m.a(this);
        a3.a(0.0f);
        a3.c(j);
        C0011a aVar2 = this.f578b;
        a.this.g = a3;
        aVar2.f583b = i2;
        View view2 = a3.f1171a.get();
        if (view2 != null) {
            a3.e(view2, aVar2);
        }
        return a3;
    }

    public int getAnimatedVisibility() {
        return this.g != null ? this.f578b.f583b : getVisibility();
    }

    public int getContentHeight() {
        return this.f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, j.ActionBar, b.b.a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.f581e;
        if (cVar != null) {
            Configuration configuration2 = cVar.f511c.getResources().getConfiguration();
            int i2 = configuration2.screenWidthDp;
            int i3 = configuration2.screenHeightDp;
            cVar.q = (configuration2.smallestScreenWidthDp > 600 || i2 > 600 || (i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960)) ? 5 : (i2 >= 500 || (i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640)) ? 4 : i2 >= 360 ? 3 : 2;
            g gVar = cVar.f512d;
            if (gVar != null) {
                gVar.q(true);
            }
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.i = false;
        }
        if (!this.i) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.i = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.h = false;
        }
        if (!this.h) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i2);

    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            r rVar = this.g;
            if (rVar != null) {
                rVar.b();
            }
            super.setVisibility(i2);
        }
    }
}
