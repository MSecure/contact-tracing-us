package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import e.i.h.a;
import e.i.i.m;
import f.b.a.c.b.o.b;
import f.b.a.e.k.c;
import f.b.a.e.k.d0;
import f.b.a.e.k.f;
import f.b.a.e.k.p;
import f.b.a.e.k.q;
import f.b.a.e.k.v;
import java.util.Calendar;

public final class MaterialCalendarGridView extends GridView {
    public final Calendar b = d0.g();
    public final boolean c;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        if (q.F0(getContext())) {
            setNextFocusLeftId(R$id.cancel_button);
            setNextFocusRightId(R$id.confirm_button);
        }
        this.c = q.G0(getContext(), R$attr.nestedScrollable);
        m.q(this, new p(this));
    }

    /* renamed from: a */
    public v getAdapter() {
        return (v) super.getAdapter();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    public final void onDraw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        v a = getAdapter();
        f<?> fVar = a.c;
        c cVar = a.f2855e;
        Long c2 = a.getItem(a.b());
        Long c3 = a.getItem(a.d());
        for (a<Long, Long> aVar : fVar.e()) {
            F f2 = aVar.a;
            if (f2 != null) {
                if (aVar.b != null) {
                    long longValue = f2.longValue();
                    long longValue2 = aVar.b.longValue();
                    Long valueOf = Long.valueOf(longValue);
                    Long valueOf2 = Long.valueOf(longValue2);
                    boolean z = true;
                    if (!(c2 == null || c3 == null || valueOf == null || valueOf2 == null || valueOf.longValue() > c3.longValue() || valueOf2.longValue() < c2.longValue())) {
                        boolean S0 = b.S0(this);
                        if (longValue < c2.longValue()) {
                            i3 = a.b();
                            if (i3 % a.b.f2849e == 0) {
                                i2 = 0;
                            } else {
                                View childAt = materialCalendarGridView.getChildAt(i3 - 1);
                                i2 = !S0 ? childAt.getRight() : childAt.getLeft();
                            }
                        } else {
                            materialCalendarGridView.b.setTimeInMillis(longValue);
                            i3 = a.a(materialCalendarGridView.b.get(5));
                            View childAt2 = materialCalendarGridView.getChildAt(i3);
                            i2 = (childAt2.getWidth() / 2) + childAt2.getLeft();
                        }
                        if (longValue2 > c3.longValue()) {
                            i5 = Math.min(a.d(), getChildCount() - 1);
                            if ((i5 + 1) % a.b.f2849e != 0) {
                                z = false;
                            }
                            if (z) {
                                i4 = getWidth();
                            } else {
                                View childAt3 = materialCalendarGridView.getChildAt(i5);
                                i4 = !S0 ? childAt3.getRight() : childAt3.getLeft();
                            }
                        } else {
                            materialCalendarGridView.b.setTimeInMillis(longValue2);
                            i5 = a.a(materialCalendarGridView.b.get(5));
                            View childAt4 = materialCalendarGridView.getChildAt(i5);
                            i4 = (childAt4.getWidth() / 2) + childAt4.getLeft();
                        }
                        int itemId = (int) a.getItemId(i3);
                        int itemId2 = (int) a.getItemId(i5);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt5 = materialCalendarGridView.getChildAt(numColumns);
                            int top = childAt5.getTop() + cVar.a.a.top;
                            int bottom = childAt5.getBottom() - cVar.a.a.bottom;
                            if (!S0) {
                                i7 = numColumns > i3 ? 0 : i2;
                                i6 = i5 > numColumns2 ? getWidth() : i4;
                            } else {
                                int i8 = i5 > numColumns2 ? 0 : i4;
                                i6 = numColumns > i3 ? getWidth() : i2;
                                i7 = i8;
                            }
                            canvas.drawRect((float) i7, (float) top, (float) i6, (float) bottom, cVar.f2839h);
                            itemId++;
                            materialCalendarGridView = this;
                            a = a;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
            a = a;
        }
    }

    public void onFocusChanged(boolean z, int i2, Rect rect) {
        int i3;
        if (z) {
            if (i2 == 33) {
                i3 = getAdapter().d();
            } else if (i2 == 130) {
                i3 = getAdapter().b();
            } else {
                super.onFocusChanged(true, i2, rect);
                return;
            }
            setSelection(i3);
            return;
        }
        super.onFocusChanged(false, i2, rect);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!super.onKeyDown(i2, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i2) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    public void onMeasure(int i2, int i3) {
        if (this.c) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof v) {
            super.setAdapter(listAdapter);
        } else {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), v.class.getCanonicalName()));
        }
    }

    public void setSelection(int i2) {
        if (i2 < getAdapter().b()) {
            i2 = getAdapter().b();
        }
        super.setSelection(i2);
    }
}
