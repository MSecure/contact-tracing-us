package c.b.a.b.v;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;

public class a extends ViewOutlineProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Chip f4530a;

    public a(Chip chip) {
        this.f4530a = chip;
    }

    @TargetApi(21)
    public void getOutline(View view, Outline outline) {
        b bVar = this.f4530a.f6071e;
        if (bVar != null) {
            bVar.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
