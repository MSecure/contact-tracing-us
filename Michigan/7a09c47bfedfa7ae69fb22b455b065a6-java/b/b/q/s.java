package b.b.q;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import b.b.a;

public class s extends RatingBar {

    /* renamed from: b  reason: collision with root package name */
    public final q f930b;

    /* JADX WARNING: Illegal instructions before constructor call */
    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int i = a.ratingBarStyle;
        t0.a(this, getContext());
        q qVar = new q(this);
        this.f930b = qVar;
        qVar.a(attributeSet, i);
    }

    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmap = this.f930b.f913b;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
