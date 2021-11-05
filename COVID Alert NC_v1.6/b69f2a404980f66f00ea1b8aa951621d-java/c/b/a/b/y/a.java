package c.b.a.b.y;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class a implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final Dialog f3299b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3300c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3301d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3302e;

    public a(Dialog dialog, Rect rect) {
        this.f3299b = dialog;
        this.f3300c = rect.left;
        this.f3301d = rect.top;
        this.f3302e = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = findViewById.getLeft() + this.f3300c;
        int width = findViewById.getWidth() + left;
        int top = findViewById.getTop() + this.f3301d;
        if (new RectF((float) left, (float) top, (float) width, (float) (findViewById.getHeight() + top)).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i = this.f3302e;
            obtain.setLocation((float) ((-i) - 1), (float) ((-i) - 1));
        }
        view.performClick();
        return this.f3299b.onTouchEvent(obtain);
    }
}
