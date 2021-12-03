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
import e.i.h.b;
import e.i.i.v;
import f.b.a.e.l.c;
import f.b.a.e.l.d0;
import f.b.a.e.l.f;
import f.b.a.e.l.p;
import f.b.a.e.l.q;
import java.util.Calendar;
import java.util.Iterator;

public final class MaterialCalendarGridView extends GridView {
    public final Calendar b = d0.g();
    public final boolean c;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        if (q.L0(getContext())) {
            setNextFocusLeftId(R$id.cancel_button);
            setNextFocusRightId(R$id.confirm_button);
        }
        this.c = q.M0(getContext(), R$attr.nestedScrollable);
        v.u(this, new p(this));
    }

    /* renamed from: a */
    public f.b.a.e.l.v getAdapter() {
        return (f.b.a.e.l.v) super.getAdapter();
    }

    public final View b(int i2) {
        return getChildAt(i2 - getFirstVisiblePosition());
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
        int i8;
        int i9;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        f.b.a.e.l.v a = getAdapter();
        f<?> fVar = a.c;
        c cVar = a.f2911e;
        int max = Math.max(a.b(), getFirstVisiblePosition());
        int min = Math.min(a.d(), getLastVisiblePosition());
        Long c2 = a.getItem(max);
        Long c3 = a.getItem(min);
        Iterator<b<Long, Long>> it = fVar.e().iterator();
        while (it.hasNext()) {
            b<Long, Long> next = it.next();
            F f2 = next.a;
            if (f2 == null) {
                materialCalendarGridView = this;
            } else if (next.b != null) {
                long longValue = f2.longValue();
                long longValue2 = next.b.longValue();
                Long valueOf = Long.valueOf(longValue);
                Long valueOf2 = Long.valueOf(longValue2);
                if (!(c2 == null || c3 == null || valueOf == null || valueOf2 == null || valueOf.longValue() > c3.longValue() || valueOf2.longValue() < c2.longValue())) {
                    boolean V0 = f.b.a.c.b.o.b.V0(this);
                    if (longValue < c2.longValue()) {
                        if (max % a.b.f2905e == 0) {
                            i9 = 0;
                        } else {
                            View b2 = materialCalendarGridView.b(max - 1);
                            i9 = !V0 ? b2.getRight() : b2.getLeft();
                        }
                        i2 = i9;
                        i3 = max;
                    } else {
                        materialCalendarGridView.b.setTimeInMillis(longValue);
                        i3 = a.a(materialCalendarGridView.b.get(5));
                        View b3 = materialCalendarGridView.b(i3);
                        i2 = (b3.getWidth() / 2) + b3.getLeft();
                    }
                    if (longValue2 > c3.longValue()) {
                        if ((min + 1) % a.b.f2905e == 0) {
                            i8 = getWidth();
                        } else {
                            View b4 = materialCalendarGridView.b(min);
                            i8 = !V0 ? b4.getRight() : b4.getLeft();
                        }
                        i4 = i8;
                        i5 = min;
                    } else {
                        materialCalendarGridView.b.setTimeInMillis(longValue2);
                        i5 = a.a(materialCalendarGridView.b.get(5));
                        View b5 = materialCalendarGridView.b(i5);
                        i4 = (b5.getWidth() / 2) + b5.getLeft();
                    }
                    int itemId = (int) a.getItemId(i3);
                    int itemId2 = (int) a.getItemId(i5);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (getNumColumns() + numColumns) - 1;
                        View b6 = materialCalendarGridView.b(numColumns);
                        int top = b6.getTop() + cVar.a.a.top;
                        int bottom = b6.getBottom() - cVar.a.a.bottom;
                        if (!V0) {
                            i7 = numColumns > i3 ? 0 : i2;
                            i6 = i5 > numColumns2 ? getWidth() : i4;
                        } else {
                            int i10 = i5 > numColumns2 ? 0 : i4;
                            i6 = numColumns > i3 ? getWidth() : i2;
                            i7 = i10;
                        }
                        canvas.drawRect((float) i7, (float) top, (float) i6, (float) bottom, cVar.f2895h);
                        itemId++;
                        materialCalendarGridView = this;
                        it = it;
                        a = a;
                    }
                    materialCalendarGridView = this;
                    max = max;
                    min = min;
                }
            }
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
        if (listAdapter instanceof f.b.a.e.l.v) {
            super.setAdapter(listAdapter);
        } else {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), f.b.a.e.l.v.class.getCanonicalName()));
        }
    }

    public void setSelection(int i2) {
        if (i2 < getAdapter().b()) {
            i2 = getAdapter().b();
        }
        super.setSelection(i2);
    }
}
