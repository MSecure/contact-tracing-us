package b.b.q;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import b.b.k.i;
import b.b.l.a.a;

public class h extends CheckedTextView {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f843c = {16843016};

    /* renamed from: b  reason: collision with root package name */
    public final y f844b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16843720);
        v0.a(context);
        t0.a(this, getContext());
        y yVar = new y(this);
        this.f844b = yVar;
        yVar.e(attributeSet, 16843720);
        this.f844b.b();
        y0 q = y0.q(getContext(), attributeSet, f843c, 16843720, 0);
        setCheckMarkDrawable(q.g(0));
        q.f986b.recycle();
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        y yVar = this.f844b;
        if (yVar != null) {
            yVar.b();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        i.j.U(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(a.b(getContext(), i));
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.j.m0(this, callback));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        y yVar = this.f844b;
        if (yVar != null) {
            yVar.f(context, i);
        }
    }
}
