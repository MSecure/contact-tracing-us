package b.i.l.w;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class a extends ClickableSpan {

    /* renamed from: b  reason: collision with root package name */
    public final int f1902b;

    /* renamed from: c  reason: collision with root package name */
    public final b f1903c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1904d;

    public a(int i, b bVar, int i2) {
        this.f1902b = i;
        this.f1903c = bVar;
        this.f1904d = i2;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f1902b);
        b bVar = this.f1903c;
        bVar.f1906a.performAction(this.f1904d, bundle);
    }
}
