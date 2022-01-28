package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import b.i.k.a;
import b.i.l.m;
import c.b.a.b.f;
import c.b.a.b.x.a0;
import c.b.a.b.x.c;
import c.b.a.b.x.d;
import c.b.a.b.x.n;
import c.b.a.b.x.o;
import c.b.a.b.x.t;
import java.util.Calendar;

public final class MaterialCalendarGridView extends GridView {

    /* renamed from: b  reason: collision with root package name */
    public final Calendar f6080b = a0.g();

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        if (o.f(getContext())) {
            setNextFocusLeftId(f.cancel_button);
            setNextFocusRightId(f.confirm_button);
        }
        m.U(this, new n(this));
    }

    /* renamed from: a */
    public t getAdapter() {
        return (t) super.getAdapter();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    public final void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        t a2 = getAdapter();
        d<?> dVar = a2.f4618c;
        c cVar = a2.f4619d;
        Long b2 = a2.getItem(a2.a());
        Long b3 = a2.getItem(a2.c());
        for (a<Long, Long> aVar : dVar.i()) {
            F f2 = aVar.f1841a;
            if (f2 != null) {
                if (aVar.f1842b == null) {
                    continue;
                } else {
                    long longValue = f2.longValue();
                    long longValue2 = aVar.f1842b.longValue();
                    Long valueOf = Long.valueOf(longValue);
                    Long valueOf2 = Long.valueOf(longValue2);
                    int i5 = 1;
                    if (!(b2 == null || b3 == null || valueOf == null || valueOf2 == null || valueOf.longValue() > b3.longValue() || valueOf2.longValue() < b2.longValue())) {
                        if (longValue < b2.longValue()) {
                            i2 = a2.a();
                            if (i2 % a2.f4617b.f4614f == 0) {
                                i = 0;
                            } else {
                                i = materialCalendarGridView.getChildAt(i2 - 1).getRight();
                            }
                        } else {
                            materialCalendarGridView.f6080b.setTimeInMillis(longValue);
                            i2 = (materialCalendarGridView.f6080b.get(5) - 1) + a2.a();
                            View childAt = materialCalendarGridView.getChildAt(i2);
                            i = (childAt.getWidth() / 2) + childAt.getLeft();
                        }
                        if (longValue2 > b3.longValue()) {
                            i4 = Math.min(a2.c(), getChildCount() - 1);
                            i3 = (i4 + 1) % a2.f4617b.f4614f == 0 ? getWidth() : materialCalendarGridView.getChildAt(i4).getRight();
                        } else {
                            materialCalendarGridView.f6080b.setTimeInMillis(longValue2);
                            i4 = (materialCalendarGridView.f6080b.get(5) - 1) + a2.a();
                            View childAt2 = materialCalendarGridView.getChildAt(i4);
                            i3 = (childAt2.getWidth() / 2) + childAt2.getLeft();
                        }
                        int itemId = (int) a2.getItemId(i2);
                        int itemId2 = (int) a2.getItemId(i4);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - i5;
                            View childAt3 = materialCalendarGridView.getChildAt(numColumns);
                            canvas.drawRect((float) (numColumns > i2 ? 0 : i), (float) (childAt3.getTop() + cVar.f4560a.f4552a.top), (float) (i4 > numColumns2 ? getWidth() : i3), (float) (childAt3.getBottom() - cVar.f4560a.f4552a.bottom), cVar.h);
                            itemId++;
                            i5 = 1;
                            materialCalendarGridView = this;
                        }
                    } else {
                        return;
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        int i2;
        if (z) {
            if (i == 33) {
                i2 = getAdapter().c();
            } else if (i == 130) {
                i2 = getAdapter().a();
            } else {
                super.onFocusChanged(true, i, rect);
                return;
            }
            setSelection(i2);
            return;
        }
        super.onFocusChanged(false, i, rect);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().a()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter().a());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof t) {
            super.setAdapter(listAdapter);
        } else {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), t.class.getCanonicalName()));
        }
    }

    public void setSelection(int i) {
        if (i < getAdapter().a()) {
            i = getAdapter().a();
        }
        super.setSelection(i);
    }
}
