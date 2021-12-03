package e.i.i.d0;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import e.i.i.e;
import e.i.i.v;

public class d implements e {
    public final /* synthetic */ View a;

    public d(View view) {
        this.a = view;
    }

    public boolean a(f fVar, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i2 & 1) != 0) {
            try {
                fVar.a.a();
                InputContentInfo inputContentInfo = (InputContentInfo) fVar.a.d();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
            } catch (Exception unused) {
                return false;
            }
        }
        e.a aVar = new e.a(new ClipData(fVar.a.c(), new ClipData.Item(fVar.a.e())), 2);
        aVar.f1550d = fVar.a.b();
        aVar.f1551e = bundle;
        if (v.q(this.a, new e(aVar)) == null) {
            return true;
        }
        return false;
    }
}
