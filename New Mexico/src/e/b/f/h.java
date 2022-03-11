package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import e.b.a.m;
import e.j.j.v;
/* loaded from: classes.dex */
public class h extends CheckedTextView {
    public final i b;
    public final e c;

    /* renamed from: d  reason: collision with root package name */
    public final b0 f961d;

    /* renamed from: e  reason: collision with root package name */
    public n f962e;

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0066 A[Catch: all -> 0x00b6, TRY_ENTER, TryCatch #0 {all -> 0x00b6, blocks: (B:3:0x0046, B:5:0x004e, B:7:0x0054, B:11:0x0066, B:13:0x006e, B:15:0x0074, B:16:0x0081, B:18:0x0089, B:19:0x0092, B:21:0x009a), top: B:28:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0089 A[Catch: all -> 0x00b6, TryCatch #0 {all -> 0x00b6, blocks: (B:3:0x0046, B:5:0x004e, B:7:0x0054, B:11:0x0066, B:13:0x006e, B:15:0x0074, B:16:0x0081, B:18:0x0089, B:19:0x0092, B:21:0x009a), top: B:28:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009a A[Catch: all -> 0x00b6, TRY_LEAVE, TryCatch #0 {all -> 0x00b6, blocks: (B:3:0x0046, B:5:0x004e, B:7:0x0054, B:11:0x0066, B:13:0x006e, B:15:0x0074, B:16:0x0081, B:18:0x0089, B:19:0x0092, B:21:0x009a), top: B:28:0x0046 }] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r7);
        boolean z;
        int i2;
        int i3;
        int l2;
        int l3;
        int i4 = R$attr.checkedTextViewStyle;
        z0.a(context);
        x0.a(this, getContext());
        b0 b0Var = new b0(this);
        this.f961d = b0Var;
        b0Var.e(attributeSet, i4);
        b0Var.b();
        e eVar = new e(this);
        this.c = eVar;
        eVar.d(attributeSet, i4);
        i iVar = new i(this);
        this.b = iVar;
        Context context2 = getContext();
        int[] iArr = R$styleable.CheckedTextView;
        c1 q = c1.q(context2, attributeSet, iArr, i4, 0);
        CheckedTextView checkedTextView = iVar.a;
        v.t(checkedTextView, checkedTextView.getContext(), iArr, attributeSet, q.b, i4, 0);
        try {
            int i5 = R$styleable.CheckedTextView_checkMarkCompat;
            if (q.o(i5) && (l3 = q.l(i5, 0)) != 0) {
                try {
                    CheckedTextView checkedTextView2 = iVar.a;
                    checkedTextView2.setCheckMarkDrawable(m.e.i0(checkedTextView2.getContext(), l3));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                }
                if (!z) {
                    int i6 = R$styleable.CheckedTextView_android_checkMark;
                    if (q.o(i6) && (l2 = q.l(i6, 0)) != 0) {
                        CheckedTextView checkedTextView3 = iVar.a;
                        checkedTextView3.setCheckMarkDrawable(m.e.i0(checkedTextView3.getContext(), l2));
                    }
                }
                i2 = R$styleable.CheckedTextView_checkMarkTint;
                if (q.o(i2)) {
                    iVar.a.setCheckMarkTintList(q.c(i2));
                }
                i3 = R$styleable.CheckedTextView_checkMarkTintMode;
                if (q.o(i3)) {
                    iVar.a.setCheckMarkTintMode(i0.e(q.j(i3, -1), null));
                }
                q.b.recycle();
                getEmojiTextViewHelper().a(attributeSet, i4);
            }
            z = false;
            if (!z) {
            }
            i2 = R$styleable.CheckedTextView_checkMarkTint;
            if (q.o(i2)) {
            }
            i3 = R$styleable.CheckedTextView_checkMarkTintMode;
            if (q.o(i3)) {
            }
            q.b.recycle();
            getEmojiTextViewHelper().a(attributeSet, i4);
        } catch (Throwable th) {
            q.b.recycle();
            throw th;
        }
    }

    private n getEmojiTextViewHelper() {
        if (this.f962e == null) {
            this.f962e = new n(this);
        }
        return this.f962e;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        b0 b0Var = this.f961d;
        if (b0Var != null) {
            b0Var.b();
        }
        e eVar = this.c;
        if (eVar != null) {
            eVar.a();
        }
        i iVar = this.b;
        if (iVar != null) {
            iVar.a();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return m.e.U1(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.c;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.c;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.c;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        m.e.e1(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().b.a.c(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.c;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.c;
        if (eVar != null) {
            eVar.f(i2);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(m.e.i0(getContext(), i2));
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        i iVar = this.b;
        if (iVar == null) {
            return;
        }
        if (iVar.f965f) {
            iVar.f965f = false;
            return;
        }
        iVar.f965f = true;
        iVar.a();
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(m.e.Y1(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().b.a.d(z);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.c;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.c;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        i iVar = this.b;
        if (iVar != null) {
            iVar.b = colorStateList;
            iVar.f963d = true;
            iVar.a();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        i iVar = this.b;
        if (iVar != null) {
            iVar.c = mode;
            iVar.f964e = true;
            iVar.a();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        b0 b0Var = this.f961d;
        if (b0Var != null) {
            b0Var.f(context, i2);
        }
    }
}
