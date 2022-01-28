package f.b.a.e.e;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import e.i.i.c0.d;

public class c implements d {
    public final /* synthetic */ int a;
    public final /* synthetic */ BottomSheetBehavior b;

    public c(BottomSheetBehavior bottomSheetBehavior, int i2) {
        this.b = bottomSheetBehavior;
        this.a = i2;
    }

    @Override // e.i.i.c0.d
    public boolean a(View view, d.a aVar) {
        this.b.K(this.a);
        return true;
    }
}
