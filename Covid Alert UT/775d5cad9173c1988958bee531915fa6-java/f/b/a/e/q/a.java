package f.b.a.e.q;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.material.internal.CheckableImageButton;
import e.i.i.c;
import e.i.i.c0.b;

public class a extends c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CheckableImageButton f2946d;

    public a(CheckableImageButton checkableImageButton) {
        this.f2946d = checkableImageButton;
    }

    @Override // e.i.i.c
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.f2946d.isChecked());
    }

    @Override // e.i.i.c
    public void d(View view, b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        bVar.a.setCheckable(this.f2946d.f573f);
        bVar.a.setChecked(this.f2946d.isChecked());
    }
}
