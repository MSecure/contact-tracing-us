package e.n.b;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import e.n.a.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class g implements TextWatcher {
    public final EditText b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public e.AbstractC0051e f1741d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1742e = true;

    /* loaded from: classes.dex */
    public static class a extends e.AbstractC0051e {
        public final Reference<EditText> a;

        public a(EditText editText) {
            this.a = new WeakReference(editText);
        }

        @Override // e.n.a.e.AbstractC0051e
        public void b() {
            g.a(this.a.get(), 1);
        }
    }

    public g(EditText editText, boolean z) {
        this.b = editText;
        this.c = z;
    }

    public static void a(EditText editText, int i2) {
        if (i2 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            e.a().h(editableText);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (!this.b.isInEditMode()) {
            if (!(!this.f1742e || (!this.c && !e.c())) && i3 <= i4 && (charSequence instanceof Spannable)) {
                int b = e.a().b();
                if (b != 0) {
                    if (b == 1) {
                        e.a().i((Spannable) charSequence, i2, i2 + i4, Integer.MAX_VALUE, 0);
                        return;
                    } else if (b != 3) {
                        return;
                    }
                }
                e a2 = e.a();
                if (this.f1741d == null) {
                    this.f1741d = new a(this.b);
                }
                a2.j(this.f1741d);
            }
        }
    }
}
