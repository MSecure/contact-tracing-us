package b.b.q;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import b.b.a;

public class t extends SeekBar {

    /* renamed from: b  reason: collision with root package name */
    public final u f718b;

    /* JADX WARNING: Illegal instructions before constructor call */
    public t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int i = a.seekBarStyle;
        t0.a(this, getContext());
        u uVar = new u(this);
        this.f718b = uVar;
        uVar.a(attributeSet, i);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        u uVar = this.f718b;
        Drawable drawable = uVar.f725e;
        if (drawable != null && drawable.isStateful() && drawable.setState(uVar.f724d.getDrawableState())) {
            uVar.f724d.invalidateDrawable(drawable);
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f718b.f725e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f718b.d(canvas);
    }
}
