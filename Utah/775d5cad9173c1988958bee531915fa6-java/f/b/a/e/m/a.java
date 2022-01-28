package f.b.a.e.m;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class a implements View.OnTouchListener {
    public final Dialog b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2917d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2918e;

    public a(Dialog dialog, Rect rect) {
        this.b = dialog;
        this.c = rect.left;
        this.f2917d = rect.top;
        this.f2918e = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = findViewById.getLeft() + this.c;
        int width = findViewById.getWidth() + left;
        int top = findViewById.getTop() + this.f2917d;
        if (new RectF((float) left, (float) top, (float) width, (float) (findViewById.getHeight() + top)).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i2 = this.f2918e;
            obtain.setLocation((float) ((-i2) - 1), (float) ((-i2) - 1));
        }
        view.performClick();
        return this.b.onTouchEvent(obtain);
    }
}
