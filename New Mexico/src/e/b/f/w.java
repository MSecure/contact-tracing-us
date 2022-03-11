package e.b.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$attr;
/* loaded from: classes.dex */
public class w extends SeekBar {
    public final x b;

    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int i2 = R$attr.seekBarStyle;
        x0.a(this, getContext());
        x xVar = new x(this);
        this.b = xVar;
        xVar.a(attributeSet, i2);
    }

    @Override // android.widget.ProgressBar, android.widget.AbsSeekBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        x xVar = this.b;
        Drawable drawable = xVar.f1045e;
        if (drawable != null && drawable.isStateful() && drawable.setState(xVar.f1044d.getDrawableState())) {
            xVar.f1044d.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ProgressBar, android.widget.AbsSeekBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.b.f1045e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.ProgressBar, android.widget.AbsSeekBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.b.d(canvas);
    }
}
