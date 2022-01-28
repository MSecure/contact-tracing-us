package c.b.a.b.c0;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import b.i.l.w.b;
import com.google.android.material.internal.CheckableImageButton;

public class a extends b.i.l.a {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CheckableImageButton f4187d;

    public a(CheckableImageButton checkableImageButton) {
        this.f4187d = checkableImageButton;
    }

    @Override // b.i.l.a
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f1847a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.f4187d.isChecked());
    }

    @Override // b.i.l.a
    public void d(View view, b bVar) {
        this.f1847a.onInitializeAccessibilityNodeInfo(view, bVar.f1906a);
        bVar.f1906a.setCheckable(this.f4187d.f6097e);
        bVar.f1906a.setChecked(this.f4187d.isChecked());
    }
}
