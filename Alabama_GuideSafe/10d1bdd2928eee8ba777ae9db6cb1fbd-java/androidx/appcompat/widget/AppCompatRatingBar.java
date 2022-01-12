package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R$attr;

public class AppCompatRatingBar extends RatingBar {
    public final AppCompatProgressBarHelper mAppCompatProgressBarHelper;

    /* JADX WARNING: Illegal instructions before constructor call */
    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int i = R$attr.ratingBarStyle;
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatProgressBarHelper appCompatProgressBarHelper = new AppCompatProgressBarHelper(this);
        this.mAppCompatProgressBarHelper = appCompatProgressBarHelper;
        appCompatProgressBarHelper.loadFromAttributes(attributeSet, i);
    }

    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmap = this.mAppCompatProgressBarHelper.mSampleTile;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
