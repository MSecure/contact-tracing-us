package e.i.i.d0;

import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import e.i.i.d0.f;

public class b extends InputConnectionWrapper {
    public final /* synthetic */ e a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(InputConnection inputConnection, boolean z, e eVar) {
        super(inputConnection, z);
        this.a = eVar;
    }

    public boolean commitContent(InputContentInfo inputContentInfo, int i2, Bundle bundle) {
        e eVar = this.a;
        f fVar = null;
        if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
            fVar = new f(new f.a(inputContentInfo));
        }
        if (((d) eVar).a(fVar, i2, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i2, bundle);
    }
}
