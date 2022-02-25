package f.b.a.d.f;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import e.i.i.w.d;

public class c implements d {
    public final /* synthetic */ int a;
    public final /* synthetic */ BottomSheetBehavior b;

    public c(BottomSheetBehavior bottomSheetBehavior, int i2) {
        this.b = bottomSheetBehavior;
        this.a = i2;
    }

    @Override // e.i.i.w.d
    public boolean a(View view, d.a aVar) {
        this.b.J(this.a);
        return true;
    }
}
