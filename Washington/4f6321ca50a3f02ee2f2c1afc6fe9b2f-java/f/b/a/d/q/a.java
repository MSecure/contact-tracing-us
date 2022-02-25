package f.b.a.d.q;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.material.internal.CheckableImageButton;
import e.i.i.w.b;

public class a extends e.i.i.a {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CheckableImageButton f2677d;

    public a(CheckableImageButton checkableImageButton) {
        this.f2677d = checkableImageButton;
    }

    @Override // e.i.i.a
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.f2677d.isChecked());
    }

    @Override // e.i.i.a
    public void d(View view, b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        bVar.a.setCheckable(this.f2677d.f534e);
        bVar.a.setChecked(this.f2677d.isChecked());
    }
}
