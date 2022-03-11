package e.n.b;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import e.n.a.e;
/* loaded from: classes.dex */
public class h implements TransformationMethod {
    public final TransformationMethod b;

    public h(TransformationMethod transformationMethod) {
        this.b = transformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.b;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        return (charSequence == null || e.a().b() != 1) ? charSequence : e.a().h(charSequence);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i2, Rect rect) {
        TransformationMethod transformationMethod = this.b;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z, i2, rect);
        }
    }
}
