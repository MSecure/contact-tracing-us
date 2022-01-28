package c.b.a.b.m;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public class e extends Property<ImageView, Matrix> {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f4419a = new Matrix();

    public e() {
        super(Matrix.class, "imageMatrixProperty");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.util.Property
    public Matrix get(ImageView imageView) {
        this.f4419a.set(imageView.getImageMatrix());
        return this.f4419a;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // android.util.Property
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
