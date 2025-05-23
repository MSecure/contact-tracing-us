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

public class q0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    public boolean b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f931d;

    /* renamed from: e  reason: collision with root package name */
    public int f932e;

    public class a extends LinearLayout {
        public a.c b;
        public final /* synthetic */ q0 c;

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            Objects.requireNonNull(this.c);
        }

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

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

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

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((a) view).b.a();
    }

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
        this.f931d = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.f932e = i2;
        throw null;
    }
}
