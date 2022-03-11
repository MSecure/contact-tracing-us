package f.b.a.a.a.o0;

import android.text.style.URLSpan;
import android.view.View;
/* loaded from: classes.dex */
public class a extends URLSpan {
    public a(String str) {
        super(str);
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        b.a(view, getURL());
    }
}
