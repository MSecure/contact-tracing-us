package e.b.f;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.appcompat.R$attr;
import androidx.core.R$id;
import e.b.a.m;
import e.i.i.d0.a;
import e.i.i.d0.b;
import e.i.i.d0.c;
import e.i.i.d0.d;
import e.i.i.e;
import e.i.i.p;
import e.i.i.v;
import e.i.j.g;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class l extends EditText implements p {
    public final e b;
    public final b0 c;

    /* renamed from: d  reason: collision with root package name */
    public final a0 f920d;

    /* renamed from: e  reason: collision with root package name */
    public final g f921e;

    /* renamed from: f  reason: collision with root package name */
    public final m f922f;

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.editTextStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        z0.a(context);
        x0.a(this, getContext());
        e eVar = new e(this);
        this.b = eVar;
        eVar.d(attributeSet, i2);
        b0 b0Var = new b0(this);
        this.c = b0Var;
        b0Var.e(attributeSet, i2);
        b0Var.b();
        this.f920d = new a0(this);
        this.f921e = new g();
        m mVar = new m(this);
        this.f922f = mVar;
        mVar.b(attributeSet, i2);
        mVar.a();
    }

    @Override // e.i.i.p
    public e a(e eVar) {
        return this.f921e.a(this, eVar);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.b;
        if (eVar != null) {
            eVar.a();
        }
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return m.e.M1(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // android.widget.EditText, android.widget.EditText
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    public TextClassifier getTextClassifier() {
        a0 a0Var;
        return (Build.VERSION.SDK_INT >= 28 || (a0Var = this.f920d) == null) ? super.getTextClassifier() : a0Var.a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (r2 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
        if (r2 != null) goto L_0x006c;
     */
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnection;
        String[] strArr;
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.c.g(this, onCreateInputConnection, editorInfo);
        m.e.Y0(onCreateInputConnection, editorInfo, this);
        AtomicInteger atomicInteger = v.a;
        String[] strArr2 = (String[]) getTag(R$id.tag_on_receive_content_mime_types);
        if (!(onCreateInputConnection == null || strArr2 == null)) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 25) {
                editorInfo.contentMimeTypes = strArr2;
            } else {
                if (editorInfo.extras == null) {
                    editorInfo.extras = new Bundle();
                }
                editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr2);
                editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr2);
            }
            d dVar = new d(this);
            Objects.requireNonNull(editorInfo, "editorInfo must be non-null");
            if (i2 >= 25) {
                inputConnection = new b(onCreateInputConnection, false, dVar);
            } else {
                if (i2 >= 25) {
                    strArr = editorInfo.contentMimeTypes;
                } else {
                    Bundle bundle = editorInfo.extras;
                    if (bundle != null) {
                        strArr = bundle.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                        if (strArr == null) {
                            strArr = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                        }
                    }
                }
                strArr = a.a;
                if (strArr.length != 0) {
                    inputConnection = new c(onCreateInputConnection, false, dVar);
                }
            }
            onCreateInputConnection = inputConnection;
        }
        return this.f922f.c(onCreateInputConnection, editorInfo);
    }

    /* JADX INFO: finally extract failed */
    public boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 24 && dragEvent.getLocalState() == null) {
            AtomicInteger atomicInteger = v.a;
            if (((String[]) getTag(R$id.tag_on_receive_content_mime_types)) != null) {
                Context context = getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        activity = null;
                        break;
                    } else if (context instanceof Activity) {
                        activity = (Activity) context;
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
                if (activity == null) {
                    String str = "Can't handle drop: no activity: view=" + this;
                } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                    activity.requestDragAndDropPermissions(dragEvent);
                    int offsetForPosition = getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
                    beginBatchEdit();
                    try {
                        Selection.setSelection((Spannable) getText(), offsetForPosition);
                        v.q(this, new e(new e.a(dragEvent.getClipData(), 3)));
                        endBatchEdit();
                        z = true;
                    } catch (Throwable th) {
                        endBatchEdit();
                        throw th;
                    }
                }
            }
        }
        if (z) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    public boolean onTextContextMenuItem(int i2) {
        int i3 = 0;
        if (i2 == 16908322 || i2 == 16908337) {
            AtomicInteger atomicInteger = v.a;
            if (((String[]) getTag(R$id.tag_on_receive_content_mime_types)) != null) {
                ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
                ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
                if (primaryClip != null && primaryClip.getItemCount() > 0) {
                    e.a aVar = new e.a(primaryClip, 1);
                    if (i2 != 16908322) {
                        i3 = 1;
                    }
                    aVar.c = i3;
                    v.q(this, new e(aVar));
                }
                i3 = 1;
            }
        }
        if (i3 != 0) {
            return true;
        }
        return super.onTextContextMenuItem(i2);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.b;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.b;
        if (eVar != null) {
            eVar.f(i2);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(m.e.Q1(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.f922f.b.a.c(z);
    }

    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f922f.b.a.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.f(context, i2);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        a0 a0Var;
        if (Build.VERSION.SDK_INT >= 28 || (a0Var = this.f920d) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            a0Var.b = textClassifier;
        }
    }
}
