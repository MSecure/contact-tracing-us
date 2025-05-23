package b.b.q;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import b.i.f.k.a;

public class q {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f696c = {16843067, 16843068};

    /* renamed from: a  reason: collision with root package name */
    public final ProgressBar f697a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f698b;

    public q(ProgressBar progressBar) {
        this.f697a = progressBar;
    }

    public void a(AttributeSet attributeSet, int i) {
        y0 q = y0.q(this.f697a.getContext(), attributeSet, f696c, i, 0);
        Drawable h = q.h(0);
        if (h != null) {
            ProgressBar progressBar = this.f697a;
            if (h instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) h;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i2 = 0; i2 < numberOfFrames; i2++) {
                    Drawable b2 = b(animationDrawable.getFrame(i2), true);
                    b2.setLevel(10000);
                    animationDrawable2.addFrame(b2, animationDrawable.getDuration(i2));
                }
                animationDrawable2.setLevel(10000);
                h = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(h);
        }
        Drawable h2 = q.h(1);
        if (h2 != null) {
            this.f697a.setProgressDrawable(b(h2, false));
        }
        q.f759b.recycle();
    }

    public final Drawable b(Drawable drawable, boolean z) {
        if (drawable instanceof a) {
            a aVar = (a) drawable;
            Drawable a2 = aVar.a();
            if (a2 != null) {
                aVar.b(b(a2, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id = layerDrawable.getId(i);
                drawableArr[i] = b(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.setId(i2, layerDrawable.getId(i2));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f698b == null) {
                this.f698b = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }
}
