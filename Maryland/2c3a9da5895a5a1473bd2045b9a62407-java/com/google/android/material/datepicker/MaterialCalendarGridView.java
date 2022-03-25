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
import f.b.a.d.l.d0;
import f.b.a.d.l.f;
import f.b.a.d.l.p;
import f.b.a.d.l.q;
import f.b.a.d.l.v;
import java.util.Calendar;
import java.util.Objects;

public final class MaterialCalendarGridView extends GridView {
    public final Calendar b = d0.g();
    public final boolean c;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        if (q.D0(getContext())) {
            setNextFocusLeftId(R$id.cancel_button);
            setNextFocusRightId(R$id.confirm_button);
        }
        this.c = q.E0(getContext(), R$attr.nestedScrollable);
        m.r(this, new p(this));
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
        super.onDraw(canvas);
        v a = getAdapter();
        f<?> fVar = a.c;
        a.getItem(a.b());
        a.getItem(a.d());
        for (a<Long, Long> aVar : fVar.e()) {
            Objects.requireNonNull(aVar);
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
