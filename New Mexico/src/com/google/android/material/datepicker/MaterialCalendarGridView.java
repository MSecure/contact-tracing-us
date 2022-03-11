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
import e.j.i.b;
import e.j.j.v;
import f.b.a.e.l.c;
import f.b.a.e.l.d0;
import f.b.a.e.l.f;
import f.b.a.e.l.p;
import f.b.a.e.l.q;
import java.util.Calendar;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class MaterialCalendarGridView extends GridView {
    public final Calendar b = d0.g();
    public final boolean c;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        if (q.N0(getContext())) {
            setNextFocusLeftId(R$id.cancel_button);
            setNextFocusRightId(R$id.confirm_button);
        }
        this.c = q.O0(getContext(), R$attr.nestedScrollable);
        v.u(this, new p(this));
    }

    /* renamed from: a */
    public f.b.a.e.l.v getAdapter() {
        return (f.b.a.e.l.v) super.getAdapter();
    }

    public final View b(int i2) {
        return getChildAt(i2 - getFirstVisiblePosition());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
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
        c cVar = a.f2953e;
        int max = Math.max(a.b(), getFirstVisiblePosition());
        int min = Math.min(a.d(), getLastVisiblePosition());
        Long c = a.getItem(max);
        Long c2 = a.getItem(min);
        Iterator<b<Long, Long>> it = fVar.e().iterator();
        while (it.hasNext()) {
            b<Long, Long> next = it.next();
            Long l2 = next.a;
            if (l2 == null) {
                materialCalendarGridView = this;
            } else if (next.b != null) {
                long longValue = l2.longValue();
                long longValue2 = next.b.longValue();
                Long valueOf = Long.valueOf(longValue);
                Long valueOf2 = Long.valueOf(longValue2);
                if (!(c == null || c2 == null || valueOf == null || valueOf2 == null || valueOf.longValue() > c2.longValue() || valueOf2.longValue() < c.longValue())) {
                    boolean W0 = f.b.a.c.b.o.b.W0(this);
                    if (longValue < c.longValue()) {
                        if (max % a.b.f2947e == 0) {
                            i9 = 0;
                        } else {
                            View b = materialCalendarGridView.b(max - 1);
                            i9 = !W0 ? b.getRight() : b.getLeft();
                        }
                        i2 = i9;
                        i3 = max;
                    } else {
                        materialCalendarGridView.b.setTimeInMillis(longValue);
                        i3 = a.a(materialCalendarGridView.b.get(5));
                        View b2 = materialCalendarGridView.b(i3);
                        i2 = (b2.getWidth() / 2) + b2.getLeft();
                    }
                    if (longValue2 > c2.longValue()) {
                        if ((min + 1) % a.b.f2947e == 0) {
                            i8 = getWidth();
                        } else {
                            View b3 = materialCalendarGridView.b(min);
                            i8 = !W0 ? b3.getRight() : b3.getLeft();
                        }
                        i4 = i8;
                        i5 = min;
                    } else {
                        materialCalendarGridView.b.setTimeInMillis(longValue2);
                        i5 = a.a(materialCalendarGridView.b.get(5));
                        View b4 = materialCalendarGridView.b(i5);
                        i4 = (b4.getWidth() / 2) + b4.getLeft();
                    }
                    int itemId = (int) a.getItemId(i3);
                    int itemId2 = (int) a.getItemId(i5);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (getNumColumns() + numColumns) - 1;
                        View b5 = materialCalendarGridView.b(numColumns);
                        int top = b5.getTop() + cVar.a.a.top;
                        int bottom = b5.getBottom() - cVar.a.a.bottom;
                        if (!W0) {
                            i7 = numColumns > i3 ? 0 : i2;
                            i6 = i5 > numColumns2 ? getWidth() : i4;
                        } else {
                            int i10 = i5 > numColumns2 ? 0 : i4;
                            i6 = numColumns > i3 ? getWidth() : i2;
                            i7 = i10;
                        }
                        canvas.drawRect((float) i7, (float) top, (float) i6, (float) bottom, cVar.f2937h);
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

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
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

    @Override // android.widget.GridView, android.view.KeyEvent.Callback, android.widget.AbsListView, android.view.View
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

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
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
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), f.b.a.e.l.v.class.getCanonicalName()));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i2) {
        if (i2 < getAdapter().b()) {
            i2 = getAdapter().b();
        }
        super.setSelection(i2);
    }
}
