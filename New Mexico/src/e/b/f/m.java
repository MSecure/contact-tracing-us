package e.b.f;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R$styleable;
import e.n.b.a;
import java.util.Objects;
/* loaded from: classes.dex */
public class m {
    public final EditText a;
    public final a b;

    public m(EditText editText) {
        this.a = editText;
        this.b = new a(editText, false);
    }

    public void a() {
        boolean isFocusable = this.a.isFocusable();
        int inputType = this.a.getInputType();
        EditText editText = this.a;
        editText.setKeyListener(editText.getKeyListener());
        this.a.setInputType(inputType);
        this.a.setFocusable(isFocusable);
    }

    /* JADX WARN: Finally extract failed */
    public void b(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i2, 0);
        try {
            int i3 = R$styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z = true;
            if (obtainStyledAttributes.hasValue(i3)) {
                z = obtainStyledAttributes.getBoolean(i3, true);
            }
            obtainStyledAttributes.recycle();
            d(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
        a aVar = this.b;
        Objects.requireNonNull(aVar);
        if (inputConnection == null) {
            return null;
        }
        return aVar.a.b(inputConnection, editorInfo);
    }

    public void d(boolean z) {
        this.b.a.c(z);
    }
}
