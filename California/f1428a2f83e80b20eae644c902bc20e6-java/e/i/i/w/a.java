package e.i.i.w;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class a extends ClickableSpan {
    public final int b;
    public final b c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1483d;

    public a(int i2, b bVar, int i3) {
        this.b = i2;
        this.c = bVar;
        this.f1483d = i3;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.b);
        b bVar = this.c;
        bVar.a.performAction(this.f1483d, bundle);
    }
}
