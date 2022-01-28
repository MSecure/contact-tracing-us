package f.b.a.a.a.c0;

import android.text.style.URLSpan;
import android.view.View;

public class a extends URLSpan {
    public a(String str) {
        super(str);
    }

    public void onClick(View view) {
        b.a(view, getURL());
    }
}
