package e.b.f;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import e.b.a.m;
import e.b.b.a.a;

public class h extends CheckedTextView {
    public static final int[] c = {16843016};
    public final y b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16843720);
        v0.a(context);
        t0.a(this, getContext());
        y yVar = new y(this);
        this.b = yVar;
        yVar.e(attributeSet, 16843720);
        yVar.b();
        y0 q = y0.q(getContext(), attributeSet, c, 16843720, 0);
        setCheckMarkDrawable(q.g(0));
        q.b.recycle();
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        y yVar = this.b;
        if (yVar != null) {
            yVar.b();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        m.h.G0(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(a.b(getContext(), i2));
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(m.h.x1(this, callback));
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        y yVar = this.b;
        if (yVar != null) {
            yVar.f(context, i2);
        }
    }
}
