package b.i.l.w;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class a extends ClickableSpan {

    /* renamed from: b  reason: collision with root package name */
    public final int f1191b;

    /* renamed from: c  reason: collision with root package name */
    public final b f1192c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1193d;

    public a(int i, b bVar, int i2) {
        this.f1191b = i;
        this.f1192c = bVar;
        this.f1193d = i2;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f1191b);
        b bVar = this.f1192c;
        bVar.f1195a.performAction(this.f1193d, bundle);
    }
}
