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
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import e.i.i.c0.b;
import e.i.i.v;
import f.b.a.e.q.k;
import f.b.a.e.v.j;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: l  reason: collision with root package name */
    public static final String f534l = MaterialButtonToggleGroup.class.getSimpleName();
    public static final int m = R$style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    public final List<d> b = new ArrayList();
    public final c c = new c(null);

    /* renamed from: d  reason: collision with root package name */
    public final f f535d = new f(null);

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashSet<e> f536e = new LinkedHashSet<>();

    /* renamed from: f  reason: collision with root package name */
    public final Comparator<MaterialButton> f537f = new a();

    /* renamed from: g  reason: collision with root package name */
    public Integer[] f538g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f539h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f540i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f541j;

    /* renamed from: k  reason: collision with root package name */
    public int f542k;

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

    public class b extends e.i.i.c {
        public b() {
        }

        @Override // e.i.i.c
        public void d(View view, e.i.i.c0.b bVar) {
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            String str = MaterialButtonToggleGroup.f534l;
            Objects.requireNonNull(materialButtonToggleGroup);
            int i2 = -1;
            if (view instanceof MaterialButton) {
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i3 >= materialButtonToggleGroup.getChildCount()) {
                        break;
                    } else if (materialButtonToggleGroup.getChildAt(i3) == view) {
                        i2 = i4;
                        break;
                    } else {
                        if ((materialButtonToggleGroup.getChildAt(i3) instanceof MaterialButton) && materialButtonToggleGroup.d(i3)) {
                            i4++;
                        }
                        i3++;
                    }
                }
            }
            bVar.j(b.c.a(0, 1, i2, 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    public class c implements MaterialButton.a {
        public c(a aVar) {
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            if (!materialButtonToggleGroup.f539h) {
                if (materialButtonToggleGroup.f540i) {
                    materialButtonToggleGroup.f542k = z ? materialButton.getId() : -1;
                }
                if (MaterialButtonToggleGroup.this.f(materialButton.getId(), z)) {
                    MaterialButtonToggleGroup.this.b(materialButton.getId(), materialButton.isChecked());
                }
                MaterialButtonToggleGroup.this.invalidate();
            }
        }
    }

    public static class d {

        /* renamed from: e  reason: collision with root package name */
        public static final f.b.a.e.v.c f544e = new f.b.a.e.v.a(0.0f);
        public f.b.a.e.v.c a;
        public f.b.a.e.v.c b;
        public f.b.a.e.v.c c;

        /* renamed from: d  reason: collision with root package name */
        public f.b.a.e.v.c f545d;

        public d(f.b.a.e.v.c cVar, f.b.a.e.v.c cVar2, f.b.a.e.v.c cVar3, f.b.a.e.v.c cVar4) {
            this.a = cVar;
            this.b = cVar3;
            this.c = cVar4;
            this.f545d = cVar2;
        }
    }

    public interface e {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z);
    }

    public class f implements MaterialButton.b {
        public f(a aVar) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(f.b.a.e.z.a.a.a(context, attributeSet, r3, r4), attributeSet, r3);
        int i2 = R$attr.materialButtonToggleGroupStyle;
        int i3 = m;
        TypedArray d2 = k.d(getContext(), attributeSet, R$styleable.MaterialButtonToggleGroup, i2, i3, new int[0]);
        setSingleSelection(d2.getBoolean(R$styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.f542k = d2.getResourceId(R$styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.f541j = d2.getBoolean(R$styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        d2.recycle();
        AtomicInteger atomicInteger = v.a;
        v.d.s(this, 1);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (d(i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (d(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof MaterialButton) && d(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private void setCheckedId(int i2) {
        this.f542k = i2;
        b(i2, true);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            AtomicInteger atomicInteger = v.a;
            materialButton.setId(v.e.a());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.f526f.add(this.c);
        materialButton.setOnPressedChangeListenerInternal(this.f535d);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
                MaterialButton c2 = c(i2);
                int min = Math.min(c2.getStrokeWidth(), c(i2 - 1).getStrokeWidth());
                ViewGroup.LayoutParams layoutParams = c2.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
                if (getOrientation() == 0) {
                    layoutParams2.setMarginEnd(0);
                    layoutParams2.setMarginStart(-min);
                    layoutParams2.topMargin = 0;
                } else {
                    layoutParams2.bottomMargin = 0;
                    layoutParams2.topMargin = -min;
                    layoutParams2.setMarginStart(0);
                }
                c2.setLayoutParams(layoutParams2);
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

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MaterialButton) {
            super.addView(view, i2, layoutParams);
            MaterialButton materialButton = (MaterialButton) view;
            setGeneratedIdIfNeeded(materialButton);
            setupButtonChild(materialButton);
            if (materialButton.isChecked()) {
                f(materialButton.getId(), true);
                setCheckedId(materialButton.getId());
            }
            j shapeAppearanceModel = materialButton.getShapeAppearanceModel();
            this.b.add(new d(shapeAppearanceModel.f3045e, shapeAppearanceModel.f3048h, shapeAppearanceModel.f3046f, shapeAppearanceModel.f3047g));
            v.u(materialButton, new b());
        }
    }

    public final void b(int i2, boolean z) {
        Iterator<e> it = this.f536e.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2, z);
        }
    }

    public final MaterialButton c(int i2) {
        return (MaterialButton) getChildAt(i2);
    }

    public final boolean d(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    public void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f537f);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put(c(i2), Integer.valueOf(i2));
        }
        this.f538g = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e(int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof MaterialButton) {
            this.f539h = true;
            ((MaterialButton) findViewById).setChecked(z);
            this.f539h = false;
        }
    }

    public final boolean f(int i2, boolean z) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (!this.f541j || !checkedButtonIds.isEmpty()) {
            if (z && this.f540i) {
                checkedButtonIds.remove(Integer.valueOf(i2));
                for (Integer num : checkedButtonIds) {
                    int intValue = num.intValue();
                    e(intValue, false);
                    b(intValue, false);
                }
            }
            return true;
        }
        e(i2, true);
        this.f542k = i2;
        return false;
    }

    public void g() {
        d dVar;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i2 = 0; i2 < childCount; i2++) {
            MaterialButton c2 = c(i2);
            if (c2.getVisibility() != 8) {
                j shapeAppearanceModel = c2.getShapeAppearanceModel();
                Objects.requireNonNull(shapeAppearanceModel);
                j.b bVar = new j.b(shapeAppearanceModel);
                d dVar2 = this.b.get(i2);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z = getOrientation() == 0;
                    if (i2 == firstVisibleChildIndex) {
                        if (!z) {
                            f.b.a.e.v.c cVar = dVar2.a;
                            f.b.a.e.v.c cVar2 = d.f544e;
                            dVar = new d(cVar, cVar2, dVar2.b, cVar2);
                        } else if (f.b.a.c.b.o.b.V0(this)) {
                            f.b.a.e.v.c cVar3 = d.f544e;
                            dVar = new d(cVar3, cVar3, dVar2.b, dVar2.c);
                        } else {
                            f.b.a.e.v.c cVar4 = dVar2.a;
                            f.b.a.e.v.c cVar5 = dVar2.f545d;
                            f.b.a.e.v.c cVar6 = d.f544e;
                            dVar = new d(cVar4, cVar5, cVar6, cVar6);
                        }
                    } else if (i2 != lastVisibleChildIndex) {
                        dVar2 = null;
                    } else if (!z) {
                        f.b.a.e.v.c cVar7 = d.f544e;
                        dVar = new d(cVar7, dVar2.f545d, cVar7, dVar2.c);
                    } else if (f.b.a.c.b.o.b.V0(this)) {
                        f.b.a.e.v.c cVar8 = dVar2.a;
                        f.b.a.e.v.c cVar9 = dVar2.f545d;
                        f.b.a.e.v.c cVar10 = d.f544e;
                        dVar = new d(cVar8, cVar9, cVar10, cVar10);
                    } else {
                        f.b.a.e.v.c cVar11 = d.f544e;
                        dVar = new d(cVar11, cVar11, dVar2.b, dVar2.c);
                    }
                    dVar2 = dVar;
                }
                if (dVar2 == null) {
                    bVar.c(0.0f);
                } else {
                    bVar.f3054e = dVar2.a;
                    bVar.f3057h = dVar2.f545d;
                    bVar.f3055f = dVar2.b;
                    bVar.f3056g = dVar2.c;
                }
                c2.setShapeAppearanceModel(bVar.a());
            }
        }
    }

    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    public int getCheckedButtonId() {
        if (this.f540i) {
            return this.f542k;
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton c2 = c(i2);
            if (c2.isChecked()) {
                arrayList.add(Integer.valueOf(c2.getId()));
            }
        }
        return arrayList;
    }

    public int getChildDrawingOrder(int i2, int i3) {
        Integer[] numArr = this.f538g;
        return (numArr == null || i3 >= numArr.length) ? i3 : numArr[i3].intValue();
    }

    public void onFinishInflate() {
        MaterialButton materialButton;
        super.onFinishInflate();
        int i2 = this.f542k;
        if (i2 != -1 && (materialButton = (MaterialButton) findViewById(i2)) != null) {
            materialButton.setChecked(true);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) b.C0037b.a(1, getVisibleButtonCount(), false, this.f540i ? 1 : 2).a);
    }

    public void onMeasure(int i2, int i3) {
        g();
        a();
        super.onMeasure(i2, i3);
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.f526f.remove(this.c);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.b.remove(indexOfChild);
        }
        g();
        a();
    }

    public void setSelectionRequired(boolean z) {
        this.f541j = z;
    }

    public void setSingleSelection(int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }

    public void setSingleSelection(boolean z) {
        if (this.f540i != z) {
            this.f540i = z;
            this.f539h = true;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                MaterialButton c2 = c(i2);
                c2.setChecked(false);
                b(c2.getId(), false);
            }
            this.f539h = false;
            setCheckedId(-1);
        }
    }
}
