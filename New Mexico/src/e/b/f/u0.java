package e.b.f;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$styleable;
import e.b.a.a;
import java.util.Objects;
/* loaded from: classes.dex */
public class u0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    public boolean b;
    public int c;

    /* renamed from: d */
    public int f1031d;

    /* renamed from: e */
    public int f1032e;

    /* loaded from: classes.dex */
    public class a extends LinearLayout {
        public a.c b;
        public final /* synthetic */ u0 c;

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            Objects.requireNonNull(this.c);
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    static {
        new DecelerateInterpolator();
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Context context = getContext();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0);
        Resources resources = context.getResources();
        if (!context.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs)) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R$dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        setContentHeight(layoutDimension);
        this.c = context.getResources().getDimensionPixelSize(R$dimen.abc_action_bar_stacked_tab_max_width);
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((a) view).b.a();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        setFillViewport(View.MeasureSpec.getMode(i2) == 1073741824);
        throw null;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.b = z;
    }

    public void setContentHeight(int i2) {
        this.f1031d = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.f1032e = i2;
        throw null;
    }
}
