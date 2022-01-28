package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import b.i.l.m;
import b.i.l.w.b;
import b.x.t;
import c.b.a.b.h0.j;
import c.b.a.b.k;
import c.b.a.b.l;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

public class MaterialButtonToggleGroup extends LinearLayout {
    public static final String l = MaterialButtonToggleGroup.class.getSimpleName();
    public static final int m = k.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: b  reason: collision with root package name */
    public final List<d> f6056b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final c f6057c = new c(null);

    /* renamed from: d  reason: collision with root package name */
    public final f f6058d = new f(null);

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashSet<e> f6059e = new LinkedHashSet<>();

    /* renamed from: f  reason: collision with root package name */
    public final Comparator<MaterialButton> f6060f = new a();

    /* renamed from: g  reason: collision with root package name */
    public Integer[] f6061g;
    public boolean h = false;
    public boolean i;
    public boolean j;
    public int k;

    public class a implements Comparator<MaterialButton> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            MaterialButton materialButton3 = materialButton;
            MaterialButton materialButton4 = materialButton2;
            int compareTo = Boolean.valueOf(materialButton3.isChecked()).compareTo(Boolean.valueOf(materialButton4.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton3.isPressed()).compareTo(Boolean.valueOf(materialButton4.isPressed()));
            return compareTo2 != 0 ? compareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton3)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton4)));
        }
    }

    public class b extends b.i.l.a {
        public b() {
        }

        @Override // b.i.l.a
        public void d(View view, b.i.l.w.b bVar) {
            this.f1847a.onInitializeAccessibilityNodeInfo(view, bVar.f1906a);
            bVar.j(b.c.a(0, 1, MaterialButtonToggleGroup.a(MaterialButtonToggleGroup.this, view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    public class c implements MaterialButton.a {
        public c(a aVar) {
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            if (!materialButtonToggleGroup.h) {
                if (materialButtonToggleGroup.i) {
                    materialButtonToggleGroup.k = z ? materialButton.getId() : -1;
                }
                if (MaterialButtonToggleGroup.this.g(materialButton.getId(), z)) {
                    MaterialButtonToggleGroup.this.c(materialButton.getId(), materialButton.isChecked());
                }
                MaterialButtonToggleGroup.this.invalidate();
            }
        }
    }

    public static class d {

        /* renamed from: e  reason: collision with root package name */
        public static final c.b.a.b.h0.c f6065e = new c.b.a.b.h0.a(0.0f);

        /* renamed from: a  reason: collision with root package name */
        public c.b.a.b.h0.c f6066a;

        /* renamed from: b  reason: collision with root package name */
        public c.b.a.b.h0.c f6067b;

        /* renamed from: c  reason: collision with root package name */
        public c.b.a.b.h0.c f6068c;

        /* renamed from: d  reason: collision with root package name */
        public c.b.a.b.h0.c f6069d;

        public d(c.b.a.b.h0.c cVar, c.b.a.b.h0.c cVar2, c.b.a.b.h0.c cVar3, c.b.a.b.h0.c cVar4) {
            this.f6066a = cVar;
            this.f6067b = cVar3;
            this.f6068c = cVar4;
            this.f6069d = cVar2;
        }
    }

    public interface e {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z);
    }

    public class f implements MaterialButton.b {
        public f(a aVar) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(c.b.a.b.m0.a.a.a(context, attributeSet, r3, m), attributeSet, r3);
        int i2 = c.b.a.b.b.materialButtonToggleGroupStyle;
        TypedArray d2 = c.b.a.b.c0.k.d(getContext(), attributeSet, l.MaterialButtonToggleGroup, i2, m, new int[0]);
        setSingleSelection(d2.getBoolean(l.MaterialButtonToggleGroup_singleSelection, false));
        this.k = d2.getResourceId(l.MaterialButtonToggleGroup_checkedButton, -1);
        this.j = d2.getBoolean(l.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        d2.recycle();
        m.b0(this, 1);
    }

    public static int a(MaterialButtonToggleGroup materialButtonToggleGroup, View view) {
        if (materialButtonToggleGroup == null) {
            throw null;
        } else if (!(view instanceof MaterialButton)) {
            return -1;
        } else {
            int i2 = 0;
            for (int i3 = 0; i3 < materialButtonToggleGroup.getChildCount(); i3++) {
                if (materialButtonToggleGroup.getChildAt(i3) == view) {
                    return i2;
                }
                if ((materialButtonToggleGroup.getChildAt(i3) instanceof MaterialButton) && materialButtonToggleGroup.e(i3)) {
                    i2++;
                }
            }
            return -1;
        }
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (e(i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (e(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof MaterialButton) && e(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private void setCheckedId(int i2) {
        this.k = i2;
        c(i2, true);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(m.f());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.f6052e.add(this.f6057c);
        materialButton.setOnPressedChangeListenerInternal(this.f6058d);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MaterialButton) {
            super.addView(view, i2, layoutParams);
            MaterialButton materialButton = (MaterialButton) view;
            setGeneratedIdIfNeeded(materialButton);
            setupButtonChild(materialButton);
            if (materialButton.isChecked()) {
                g(materialButton.getId(), true);
                setCheckedId(materialButton.getId());
            }
            j shapeAppearanceModel = materialButton.getShapeAppearanceModel();
            this.f6056b.add(new d(shapeAppearanceModel.f4281e, shapeAppearanceModel.h, shapeAppearanceModel.f4282f, shapeAppearanceModel.f4283g));
            m.U(materialButton, new b());
        }
    }

    public final void b() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
                MaterialButton d2 = d(i2);
                int min = Math.min(d2.getStrokeWidth(), d(i2 - 1).getStrokeWidth());
                ViewGroup.LayoutParams layoutParams = d2.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
                if (getOrientation() == 0) {
                    layoutParams2.setMarginEnd(0);
                    layoutParams2.setMarginStart(-min);
                } else {
                    layoutParams2.bottomMargin = 0;
                    layoutParams2.topMargin = -min;
                }
                d2.setLayoutParams(layoutParams2);
            }
            if (!(getChildCount() == 0 || firstVisibleChildIndex == -1)) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
                if (getOrientation() == 1) {
                    layoutParams3.topMargin = 0;
                    layoutParams3.bottomMargin = 0;
                    return;
                }
                layoutParams3.setMarginEnd(0);
                layoutParams3.setMarginStart(0);
                layoutParams3.leftMargin = 0;
                layoutParams3.rightMargin = 0;
            }
        }
    }

    public final void c(int i2, boolean z) {
        Iterator<e> it = this.f6059e.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2, z);
        }
    }

    public final MaterialButton d(int i2) {
        return (MaterialButton) getChildAt(i2);
    }

    public void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f6060f);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put(d(i2), Integer.valueOf(i2));
        }
        this.f6061g = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final boolean e(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    public final void f(int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof MaterialButton) {
            this.h = true;
            ((MaterialButton) findViewById).setChecked(z);
            this.h = false;
        }
    }

    public final boolean g(int i2, boolean z) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (!this.j || !checkedButtonIds.isEmpty()) {
            if (z && this.i) {
                checkedButtonIds.remove(Integer.valueOf(i2));
                for (Integer num : checkedButtonIds) {
                    int intValue = num.intValue();
                    f(intValue, false);
                    c(intValue, false);
                }
            }
            return true;
        }
        f(i2, true);
        this.k = i2;
        return false;
    }

    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    public int getCheckedButtonId() {
        if (this.i) {
            return this.k;
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton d2 = d(i2);
            if (d2.isChecked()) {
                arrayList.add(Integer.valueOf(d2.getId()));
            }
        }
        return arrayList;
    }

    public int getChildDrawingOrder(int i2, int i3) {
        Integer[] numArr = this.f6061g;
        return (numArr == null || i3 >= numArr.length) ? i3 : numArr[i3].intValue();
    }

    public void h() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i2 = 0; i2 < childCount; i2++) {
            MaterialButton d2 = d(i2);
            if (d2.getVisibility() != 8) {
                j shapeAppearanceModel = d2.getShapeAppearanceModel();
                d dVar = null;
                if (shapeAppearanceModel != null) {
                    j.b bVar = new j.b(shapeAppearanceModel);
                    d dVar2 = this.f6056b.get(i2);
                    if (firstVisibleChildIndex == lastVisibleChildIndex) {
                        dVar = dVar2;
                    } else {
                        boolean z = getOrientation() == 0;
                        if (i2 == firstVisibleChildIndex) {
                            if (!z) {
                                c.b.a.b.h0.c cVar = dVar2.f6066a;
                                c.b.a.b.h0.c cVar2 = d.f6065e;
                                dVar = new d(cVar, cVar2, dVar2.f6067b, cVar2);
                            } else if (t.V1(this)) {
                                c.b.a.b.h0.c cVar3 = d.f6065e;
                                dVar = new d(cVar3, cVar3, dVar2.f6067b, dVar2.f6068c);
                            } else {
                                c.b.a.b.h0.c cVar4 = dVar2.f6066a;
                                c.b.a.b.h0.c cVar5 = dVar2.f6069d;
                                c.b.a.b.h0.c cVar6 = d.f6065e;
                                dVar = new d(cVar4, cVar5, cVar6, cVar6);
                            }
                        } else if (i2 == lastVisibleChildIndex) {
                            if (!z) {
                                c.b.a.b.h0.c cVar7 = d.f6065e;
                                dVar = new d(cVar7, dVar2.f6069d, cVar7, dVar2.f6068c);
                            } else if (t.V1(this)) {
                                c.b.a.b.h0.c cVar8 = dVar2.f6066a;
                                c.b.a.b.h0.c cVar9 = dVar2.f6069d;
                                c.b.a.b.h0.c cVar10 = d.f6065e;
                                dVar = new d(cVar8, cVar9, cVar10, cVar10);
                            } else {
                                c.b.a.b.h0.c cVar11 = d.f6065e;
                                dVar = new d(cVar11, cVar11, dVar2.f6067b, dVar2.f6068c);
                            }
                        }
                    }
                    if (dVar == null) {
                        bVar.c(0.0f);
                    } else {
                        bVar.f4288e = dVar.f6066a;
                        bVar.h = dVar.f6069d;
                        bVar.f4289f = dVar.f6067b;
                        bVar.f4290g = dVar.f6068c;
                    }
                    d2.setShapeAppearanceModel(bVar.a());
                } else {
                    throw null;
                }
            }
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.k;
        if (i2 != -1) {
            f(i2, true);
            g(i2, true);
            setCheckedId(i2);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) b.C0036b.a(1, getVisibleButtonCount(), false, this.i ? 1 : 2).f1916a);
    }

    public void onMeasure(int i2, int i3) {
        h();
        b();
        super.onMeasure(i2, i3);
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.f6052e.remove(this.f6057c);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f6056b.remove(indexOfChild);
        }
        h();
        b();
    }

    public void setSelectionRequired(boolean z) {
        this.j = z;
    }

    public void setSingleSelection(int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }

    public void setSingleSelection(boolean z) {
        if (this.i != z) {
            this.i = z;
            this.h = true;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                MaterialButton d2 = d(i2);
                d2.setChecked(false);
                c(d2.getId(), false);
            }
            this.h = false;
            setCheckedId(-1);
        }
    }
}
