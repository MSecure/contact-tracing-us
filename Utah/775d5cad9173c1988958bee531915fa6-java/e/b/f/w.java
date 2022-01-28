package e.b.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$attr;

public class w extends SeekBar {
    public final x b;

    /* JADX WARNING: Illegal instructions before constructor call */
    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int i2 = R$attr.seekBarStyle;
        x0.a(this, getContext());
        x xVar = new x(this);
        this.b = xVar;
        xVar.a(attributeSet, i2);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        x xVar = this.b;
        Drawable drawable = xVar.f981e;
        if (drawable != null && drawable.isStateful() && drawable.setState(xVar.f980d.getDrawableState())) {
            xVar.f980d.invalidateDrawable(drawable);
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.b.f981e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.b.d(canvas);
    }
}
