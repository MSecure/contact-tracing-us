package e.b.f;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import e.m.b.f;

public class n {
    public final TextView a;
    public final f b;

    public n(TextView textView) {
        this.a = textView;
        this.b = new f(textView, false);
    }

    /* JADX INFO: finally extract failed */
    public void a(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i2, 0);
        try {
            int i3 = R$styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z = true;
            if (obtainStyledAttributes.hasValue(i3)) {
                z = obtainStyledAttributes.getBoolean(i3, true);
            }
            obtainStyledAttributes.recycle();
            b(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void b(boolean z) {
        this.b.a.d(z);
    }
}
