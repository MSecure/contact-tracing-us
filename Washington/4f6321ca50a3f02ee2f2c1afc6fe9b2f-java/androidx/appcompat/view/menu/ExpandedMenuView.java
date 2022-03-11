package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import e.b.b.a.a;
import e.b.e.i.g;
import e.b.e.i.i;
import e.b.e.i.n;

public final class ExpandedMenuView extends ListView implements g.b, n, AdapterView.OnItemClickListener {
    public static final int[] c = {16842964, 16843049};
    public g b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        int resourceId2;
        setOnItemClickListener(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c, 16842868, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            setBackgroundDrawable((!obtainStyledAttributes.hasValue(0) || (resourceId2 = obtainStyledAttributes.getResourceId(0, 0)) == 0) ? obtainStyledAttributes.getDrawable(0) : a.b(context, resourceId2));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            setDivider((!obtainStyledAttributes.hasValue(1) || (resourceId = obtainStyledAttributes.getResourceId(1, 0)) == 0) ? obtainStyledAttributes.getDrawable(1) : a.b(context, resourceId));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // e.b.e.i.g.b
    public boolean a(i iVar) {
        return this.b.s(iVar, null, 0);
    }

    @Override // e.b.e.i.n
    public void b(g gVar) {
        this.b = gVar;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        a((i) getAdapter().getItem(i2));
    }
}
