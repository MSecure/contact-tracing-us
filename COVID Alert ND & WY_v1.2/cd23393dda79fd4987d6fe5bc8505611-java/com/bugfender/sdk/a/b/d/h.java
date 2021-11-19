package com.bugfender.sdk.a.b.d;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import com.bugfender.sdk.a.a.b;
import com.bugfender.sdk.a.c.k.a;
import java.util.Arrays;

public class h {
    public static g a(View view, b bVar, boolean z, boolean z2) {
        if ((view instanceof Button) && !(view instanceof CompoundButton)) {
            if (com.bugfender.sdk.a.c.k.b.a(view, Arrays.asList(a.c, a.d))) {
                return new b(bVar, z, z2);
            }
            return null;
        } else if (view instanceof SeekBar) {
            return new d(bVar, z, z2);
        } else {
            if (view instanceof EditText) {
                return new c(bVar, z, z2);
            }
            if (view instanceof Spinner) {
                return new e(bVar, z, z2);
            }
            if (view instanceof CompoundButton) {
                return new f(bVar, z, z2);
            }
            return null;
        }
    }
}
