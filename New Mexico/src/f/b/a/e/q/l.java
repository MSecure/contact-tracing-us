package f.b.a.e.q;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
public final class l implements Runnable {
    public final /* synthetic */ View b;

    public l(View view) {
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InputMethodManager) this.b.getContext().getSystemService("input_method")).showSoftInput(this.b, 1);
    }
}
