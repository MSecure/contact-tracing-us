package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.react.uimanager.BaseViewManager;

public class TransitionUtils {
    public static final boolean HAS_PICTURE_BITMAP = (Build.VERSION.SDK_INT >= 28);

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00f4  */
    public static View copyViewImage(ViewGroup viewGroup, View view, View view2) {
        boolean z;
        int i;
        ViewGroup viewGroup2;
        Bitmap bitmap;
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        ViewUtils.IMPL.transformMatrixToGlobal(view, matrix);
        ViewUtils.IMPL.transformMatrixToLocal(viewGroup, matrix);
        RectF rectF = new RectF(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, (float) view.getWidth(), (float) view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        boolean z2 = !view.isAttachedToWindow();
        if (viewGroup == null) {
            z = false;
        } else {
            z = viewGroup.isAttachedToWindow();
        }
        Bitmap bitmap2 = null;
        if (z2) {
            if (z) {
                viewGroup2 = (ViewGroup) view.getParent();
                i = viewGroup2.indexOfChild(view);
                viewGroup.getOverlay().add(view);
            }
            if (bitmap2 != null) {
                imageView.setImageBitmap(bitmap2);
            }
            imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
            imageView.layout(round, round2, round3, round4);
            return imageView;
        }
        i = 0;
        viewGroup2 = null;
        int round5 = Math.round(rectF.width());
        int round6 = Math.round(rectF.height());
        if (round5 > 0 && round6 > 0) {
            float min = Math.min(1.0f, 1048576.0f / ((float) (round5 * round6)));
            int round7 = Math.round(((float) round5) * min);
            int round8 = Math.round(((float) round6) * min);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(min, min);
            if (HAS_PICTURE_BITMAP) {
                Picture picture = new Picture();
                Canvas beginRecording = picture.beginRecording(round7, round8);
                beginRecording.concat(matrix);
                view.draw(beginRecording);
                picture.endRecording();
                bitmap = Bitmap.createBitmap(picture);
            } else {
                bitmap = Bitmap.createBitmap(round7, round8, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.concat(matrix);
                view.draw(canvas);
            }
            bitmap2 = bitmap;
        }
        if (z2) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, i);
        }
        if (bitmap2 != null) {
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    public static Animator mergeAnimators(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
