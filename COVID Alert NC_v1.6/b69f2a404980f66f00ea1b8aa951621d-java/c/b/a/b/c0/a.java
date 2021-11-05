package c.b.a.b.c0;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import b.i.l.w.b;
import com.google.android.material.internal.CheckableImageButton;

public class a extends b.i.l.a {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CheckableImageButton f2924d;

    public a(CheckableImageButton checkableImageButton) {
        this.f2924d = checkableImageButton;
    }

    @Override // b.i.l.a
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f1139a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.f2924d.isChecked());
    }

    @Override // b.i.l.a
    public void d(View view, b bVar) {
        this.f1139a.onInitializeAccessibilityNodeInfo(view, bVar.f1195a);
        bVar.f1195a.setCheckable(this.f2924d.f4511e);
        bVar.f1195a.setChecked(this.f2924d.isChecked());
    }
}
