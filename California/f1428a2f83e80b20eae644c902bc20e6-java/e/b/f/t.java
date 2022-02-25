package e.b.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$attr;

public class t extends SeekBar {
    public final u b;

    /* JADX WARNING: Illegal instructions before constructor call */
    public t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int i2 = R$attr.seekBarStyle;
        t0.a(this, getContext());
        u uVar = new u(this);
        this.b = uVar;
        uVar.a(attributeSet, i2);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        u uVar = this.b;
        Drawable drawable = uVar.f950e;
        if (drawable != null && drawable.isStateful() && drawable.setState(uVar.f949d.getDrawableState())) {
            uVar.f949d.invalidateDrawable(drawable);
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.b.f950e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.b.d(canvas);
    }
}
