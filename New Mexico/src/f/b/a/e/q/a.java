package f.b.a.e.q;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.material.internal.CheckableImageButton;
import e.j.j.c;
import e.j.j.c0.b;
/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CheckableImageButton f2988d;

    public a(CheckableImageButton checkableImageButton) {
        this.f2988d = checkableImageButton;
    }

    @Override // e.j.j.c
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.f2988d.isChecked());
    }

    @Override // e.j.j.c
    public void d(View view, b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        bVar.a.setCheckable(this.f2988d.f585f);
        bVar.a.setChecked(this.f2988d.isChecked());
    }
}
