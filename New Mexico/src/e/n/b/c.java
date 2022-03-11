package e.n.b;

import android.text.Editable;
import android.text.Selection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import e.n.a.e;
import e.n.a.i;
/* loaded from: classes.dex */
public final class c extends InputConnectionWrapper {
    public final TextView a;
    public final a b;

    /* loaded from: classes.dex */
    public static class a {
        /* JADX WARN: Code restructure failed: missing block: B:27:0x004c, code lost:
            if (java.lang.Character.isHighSurrogate(r5) != false) goto L_0x004f;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x007c, code lost:
            if (r12 != false) goto L_0x00a7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0089, code lost:
            if (java.lang.Character.isLowSurrogate(r5) != false) goto L_0x008c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public boolean a(InputConnection inputConnection, Editable editable, int i2, int i3, boolean z) {
            int i4;
            Object obj = e.f1717j;
            if (editable == null || i2 < 0 || i3 < 0) {
                return false;
            }
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart == -1 || selectionEnd == -1 || selectionStart != selectionEnd) {
                return false;
            }
            if (z) {
                int max = Math.max(i2, 0);
                int length = editable.length();
                if (selectionStart >= 0 && length >= selectionStart && max >= 0) {
                    loop0: while (true) {
                        boolean z2 = false;
                        while (true) {
                            if (max == 0) {
                                break loop0;
                            }
                            selectionStart--;
                            if (selectionStart >= 0) {
                                char charAt = editable.charAt(selectionStart);
                                if (z2) {
                                    break;
                                } else if (!Character.isSurrogate(charAt)) {
                                    max--;
                                } else if (Character.isHighSurrogate(charAt)) {
                                    break loop0;
                                } else {
                                    z2 = true;
                                }
                            } else if (!z2) {
                                selectionStart = 0;
                            }
                        }
                        max--;
                    }
                }
                selectionStart = -1;
                int max2 = Math.max(i3, 0);
                i4 = editable.length();
                if (selectionEnd >= 0 && i4 >= selectionEnd && max2 >= 0) {
                    loop2: while (true) {
                        boolean z3 = false;
                        while (true) {
                            if (max2 == 0) {
                                i4 = selectionEnd;
                                break loop2;
                            } else if (selectionEnd < i4) {
                                char charAt2 = editable.charAt(selectionEnd);
                                if (z3) {
                                    break;
                                } else if (!Character.isSurrogate(charAt2)) {
                                    max2--;
                                    selectionEnd++;
                                } else if (Character.isLowSurrogate(charAt2)) {
                                    break loop2;
                                } else {
                                    selectionEnd++;
                                    z3 = true;
                                }
                            }
                        }
                        max2--;
                        selectionEnd++;
                    }
                    if (selectionStart != -1 || i4 == -1) {
                    }
                }
                i4 = -1;
                return selectionStart != -1 ? false : false;
            }
            selectionStart = Math.max(selectionStart - i2, 0);
            i4 = Math.min(selectionEnd + i3, editable.length());
            i[] iVarArr = (i[]) editable.getSpans(selectionStart, i4, i.class);
            if (iVarArr == null || iVarArr.length <= 0) {
                return false;
            }
            for (i iVar : iVarArr) {
                int spanStart = editable.getSpanStart(iVar);
                int spanEnd = editable.getSpanEnd(iVar);
                selectionStart = Math.min(spanStart, selectionStart);
                i4 = Math.max(spanEnd, i4);
            }
            int max3 = Math.max(selectionStart, 0);
            int min = Math.min(i4, editable.length());
            inputConnection.beginBatchEdit();
            editable.delete(max3, min);
            inputConnection.endBatchEdit();
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        a aVar = new a();
        this.a = textView;
        this.b = aVar;
        if (e.c()) {
            e a2 = e.a();
            if (a2.d() && editorInfo != null && editorInfo.extras != null) {
                a2.f1720e.c(editorInfo);
            }
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i2, int i3) {
        return this.b.a(this, this.a.getEditableText(), i2, i3, false) || super.deleteSurroundingText(i2, i3);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i2, int i3) {
        return this.b.a(this, this.a.getEditableText(), i2, i3, true) || super.deleteSurroundingTextInCodePoints(i2, i3);
    }
}
