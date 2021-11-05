package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b.b.j;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {

    /* renamed from: b  reason: collision with root package name */
    public int f150b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f151c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<View> f152d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f153e;

    /* renamed from: f  reason: collision with root package name */
    public a f154f;

    public interface a {
        void a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ViewStubCompat, 0, 0);
        this.f151c = obtainStyledAttributes.getResourceId(j.ViewStubCompat_android_inflatedId, -1);
        this.f150b = obtainStyledAttributes.getResourceId(j.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(j.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f150b != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            LayoutInflater layoutInflater = this.f153e;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f150b, viewGroup, false);
            int i = this.f151c;
            if (i != -1) {
                inflate.setId(i);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f152d = new WeakReference<>(inflate);
            a aVar = this.f154f;
            if (aVar != null) {
                aVar.a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public void dispatchDraw(Canvas canvas) {
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f151c;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f153e;
    }

    public int getLayoutResource() {
        return this.f150b;
    }

    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f151c = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f153e = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f150b = i;
    }

    public void setOnInflateListener(a aVar) {
        this.f154f = aVar;
    }

    public void setVisibility(int i) {
        WeakReference<View> weakReference = this.f152d;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            a();
        }
    }
}
