package b.b.o;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public class a implements TransformationMethod {

    /* renamed from: b  reason: collision with root package name */
    public Locale f633b;

    public a(Context context) {
        this.f633b = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f633b);
        }
        return null;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
