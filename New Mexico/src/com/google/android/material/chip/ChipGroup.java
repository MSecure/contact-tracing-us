package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.j.j.c0.b;
import e.j.j.v;
import f.b.a.e.q.k;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ChipGroup extends f.b.a.e.q.e {
    public static final int o = R$style.Widget_MaterialComponents_ChipGroup;

    /* renamed from: f */
    public int f567f;

    /* renamed from: g */
    public int f568g;

    /* renamed from: h */
    public boolean f569h;

    /* renamed from: i */
    public boolean f570i;

    /* renamed from: j */
    public d f571j;
    public int m;

    /* renamed from: k */
    public final b f572k = new b(null);

    /* renamed from: l */
    public e f573l = new e(null);
    public boolean n = false;

    /* loaded from: classes.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public b(a aVar) {
            ChipGroup.this = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ChipGroup chipGroup = ChipGroup.this;
            if (!chipGroup.n) {
                if (chipGroup.getCheckedChipIds().isEmpty()) {
                    ChipGroup chipGroup2 = ChipGroup.this;
                    if (chipGroup2.f570i) {
                        chipGroup2.d(compoundButton.getId(), true);
                        ChipGroup chipGroup3 = ChipGroup.this;
                        chipGroup3.m = compoundButton.getId();
                        d dVar = chipGroup3.f571j;
                        return;
                    }
                }
                int id = compoundButton.getId();
                if (z) {
                    ChipGroup chipGroup4 = ChipGroup.this;
                    int i2 = chipGroup4.m;
                    if (!(i2 == -1 || i2 == id || !chipGroup4.f569h)) {
                        chipGroup4.d(i2, false);
                    }
                    ChipGroup.this.setCheckedId(id);
                    return;
                }
                ChipGroup chipGroup5 = ChipGroup.this;
                if (chipGroup5.m == id) {
                    chipGroup5.setCheckedId(-1);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ViewGroup.MarginLayoutParams {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(ChipGroup chipGroup, int i2);
    }

    /* loaded from: classes.dex */
    public class e implements ViewGroup.OnHierarchyChangeListener {
        public ViewGroup.OnHierarchyChangeListener a;

        public e(a aVar) {
            ChipGroup.this = r1;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    AtomicInteger atomicInteger = v.a;
                    view2.setId(v.e.a());
                }
                Chip chip = (Chip) view2;
                if (chip.isChecked()) {
                    ((ChipGroup) view).c(chip.getId());
                }
                chip.setOnCheckedChangeListenerInternal(ChipGroup.this.f572k);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public ChipGroup(Context context, AttributeSet attributeSet) {
        super(f.b.a.e.z.a.a.a(context, attributeSet, r3, r4), attributeSet, r3);
        int i2 = R$attr.chipGroupStyle;
        int i3 = o;
        this.m = -1;
        TypedArray d2 = k.d(getContext(), attributeSet, R$styleable.ChipGroup, i2, i3, new int[0]);
        int dimensionPixelOffset = d2.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(d2.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(d2.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(d2.getBoolean(R$styleable.ChipGroup_singleLine, false));
        setSingleSelection(d2.getBoolean(R$styleable.ChipGroup_singleSelection, false));
        setSelectionRequired(d2.getBoolean(R$styleable.ChipGroup_selectionRequired, false));
        int resourceId = d2.getResourceId(R$styleable.ChipGroup_checkedChip, -1);
        if (resourceId != -1) {
            this.m = resourceId;
        }
        d2.recycle();
        super.setOnHierarchyChangeListener(this.f573l);
        AtomicInteger atomicInteger = v.a;
        v.d.s(this, 1);
    }

    private int getChipCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) instanceof Chip) {
                i2++;
            }
        }
        return i2;
    }

    public void setCheckedId(int i2) {
        this.m = i2;
        d dVar = this.f571j;
        if (dVar != null && this.f569h) {
            dVar.a(this, i2);
        }
    }

    @Override // f.b.a.e.q.e
    public boolean a() {
        return this.f2998d;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i3 = this.m;
                if (i3 != -1 && this.f569h) {
                    d(i3, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i2, layoutParams);
    }

    public void c(int i2) {
        int i3 = this.m;
        if (i2 != i3) {
            if (i3 != -1 && this.f569h) {
                d(i3, false);
            }
            if (i2 != -1) {
                d(i2, true);
            }
            setCheckedId(i2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof c);
    }

    public final void d(int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof Chip) {
            this.n = true;
            ((Chip) findViewById).setChecked(z);
            this.n = false;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public int getCheckedChipId() {
        if (this.f569h) {
            return this.m;
        }
        return -1;
    }

    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.f569h) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public int getChipSpacingHorizontal() {
        return this.f567f;
    }

    public int getChipSpacingVertical() {
        return this.f568g;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.m;
        if (i2 != -1) {
            d(i2, true);
            setCheckedId(this.m);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) b.C0041b.a(getRowCount(), this.f2998d ? getChipCount() : -1, false, this.f569h ? 1 : 2).a);
    }

    public void setChipSpacing(int i2) {
        setChipSpacingHorizontal(i2);
        setChipSpacingVertical(i2);
    }

    public void setChipSpacingHorizontal(int i2) {
        if (this.f567f != i2) {
            this.f567f = i2;
            setItemSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i2) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingResource(int i2) {
        setChipSpacing(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingVertical(int i2) {
        if (this.f568g != i2) {
            this.f568g = i2;
            setLineSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i2) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i2));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i2) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(d dVar) {
        this.f571j = dVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f573l.a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.f570i = z;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int i2) {
        setSingleLine(getResources().getBoolean(i2));
    }

    @Override // f.b.a.e.q.e
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }

    public void setSingleSelection(boolean z) {
        if (this.f569h != z) {
            this.f569h = z;
            this.n = true;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof Chip) {
                    ((Chip) childAt).setChecked(false);
                }
            }
            this.n = false;
            setCheckedId(-1);
        }
    }
}
