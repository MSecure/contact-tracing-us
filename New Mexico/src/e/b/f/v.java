package e.b.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R$attr;
/* loaded from: classes.dex */
public class v extends RatingBar {
    public final t b;

    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int i2 = R$attr.ratingBarStyle;
        x0.a(this, getContext());
        t tVar = new t(this);
        this.b = tVar;
        tVar.a(attributeSet, i2);
    }

    @Override // android.widget.RatingBar, android.widget.ProgressBar, android.widget.AbsSeekBar, android.view.View
    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Bitmap bitmap = this.b.b;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i2, 0), getMeasuredHeight());
        }
    }
}
