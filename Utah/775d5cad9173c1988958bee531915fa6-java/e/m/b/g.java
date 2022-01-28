package e.m.b;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import e.m.a.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class g implements TextWatcher {
    public final EditText b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public e.AbstractC0047e f1656d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1657e = true;

    public static class a extends e.AbstractC0047e {
        public final Reference<EditText> a;

        public a(EditText editText) {
            this.a = new WeakReference(editText);
        }

        @Override // e.m.a.e.AbstractC0047e
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

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (!this.b.isInEditMode()) {
            if (!(!this.f1657e || (!this.c && !e.c())) && i3 <= i4 && (charSequence instanceof Spannable)) {
                int b2 = e.a().b();
                if (b2 != 0) {
                    if (b2 == 1) {
                        e.a().i((Spannable) charSequence, i2, i2 + i4, Integer.MAX_VALUE, 0);
                        return;
                    } else if (b2 != 3) {
                        return;
                    }
                }
                e a2 = e.a();
                if (this.f1656d == null) {
                    this.f1656d = new a(this.b);
                }
                a2.j(this.f1656d);
            }
        }
    }
}
