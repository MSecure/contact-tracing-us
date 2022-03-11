package e.b.f;

import android.graphics.Typeface;
import android.widget.TextView;
/* loaded from: classes.dex */
public class c0 implements Runnable {
    public final /* synthetic */ TextView b;
    public final /* synthetic */ Typeface c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f916d;

    public c0(b0 b0Var, TextView textView, Typeface typeface, int i2) {
        this.b = textView;
        this.c = typeface;
        this.f916d = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.setTypeface(this.c, this.f916d);
    }
}
