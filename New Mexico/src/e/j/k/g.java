package e.j.k;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import e.j.j.e;
import e.j.j.o;
/* loaded from: classes.dex */
public final class g implements o {
    @Override // e.j.j.o
    public e a(View view, e eVar) {
        CharSequence charSequence;
        if (Log.isLoggable("ReceiveContent", 3)) {
            String str = "onReceive: " + eVar;
        }
        if (eVar.b == 2) {
            return eVar;
        }
        ClipData clipData = eVar.a;
        int i2 = eVar.c;
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z = false;
        for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
            ClipData.Item itemAt = clipData.getItemAt(i3);
            if ((i2 & 1) != 0) {
                charSequence = itemAt.coerceToText(context);
                if (charSequence instanceof Spanned) {
                    charSequence = charSequence.toString();
                }
            } else {
                charSequence = itemAt.coerceToStyledText(context);
            }
            if (charSequence != null) {
                if (!z) {
                    int selectionStart = Selection.getSelectionStart(editable);
                    int selectionEnd = Selection.getSelectionEnd(editable);
                    int max = Math.max(0, Math.min(selectionStart, selectionEnd));
                    int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
                    Selection.setSelection(editable, max2);
                    editable.replace(max, max2, charSequence);
                    z = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), charSequence);
                }
            }
        }
        return null;
    }
}
