package e.b.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R$attr;

public class v extends RatingBar {
    public final t b;

    /* JADX WARNING: Illegal instructions before constructor call */
    public v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int i2 = R$attr.ratingBarStyle;
        x0.a(this, getContext());
        t tVar = new t(this);
        this.b = tVar;
        tVar.a(attributeSet, i2);
    }

    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Bitmap bitmap = this.b.b;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i2, 0), getMeasuredHeight());
        }
    }
}
