package com.bugfender.sdk.a.b.d;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import java.util.Timer;
import java.util.TimerTask;

public class c extends a implements TextWatcher {
    private final com.bugfender.sdk.a.a.b e;
    private final boolean f;
    private final boolean g;
    private EditText h;
    private Timer i;

    private static class b extends TimerTask {
        private final int a;
        private final String b;
        private final com.bugfender.sdk.a.a.b c;
        private final boolean d;
        private final boolean e;

        private void a(String str) {
            if (this.d) {
                Log.d(a.d, str);
            }
            if (this.e) {
                this.c.a(a.d, str);
            }
        }

        public void run() {
            StringBuilder sb = new StringBuilder("OnTextChanged in EditText with { id: " + this.a);
            if (this.b != null) {
                sb.append(", text: ");
                sb.append(this.b);
            }
            sb.append(" }");
            a(sb.toString());
        }

        private b(int i, String str, com.bugfender.sdk.a.a.b bVar, boolean z, boolean z2) {
            this.a = i;
            this.b = str;
            this.c = bVar;
            this.d = z;
            this.e = z2;
        }
    }

    public c(com.bugfender.sdk.a.a.b bVar, boolean z, boolean z2) {
        super(bVar, z, z2);
        this.e = bVar;
        this.f = z;
        this.g = z2;
    }

    @Override // com.bugfender.sdk.a.b.d.g
    public <T extends View> void a(T t) {
        EditText editText = (EditText) t;
        this.h = editText;
        editText.addTextChangedListener(this);
    }

    public void afterTextChanged(Editable editable) {
        Timer timer = new Timer();
        this.i = timer;
        timer.schedule(new b(this.h.getId(), a(this.h) ? null : editable.toString(), this.e, this.f, this.g), 600);
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Timer timer = this.i;
        if (timer != null) {
            timer.cancel();
        }
    }

    @Override // com.bugfender.sdk.a.b.d.a, com.bugfender.sdk.a.b.d.g
    public void a() {
        this.h.addTextChangedListener(null);
        this.h = null;
        Timer timer = this.i;
        if (timer != null) {
            timer.purge();
            this.i = null;
        }
        super.a();
    }

    private static boolean a(EditText editText) {
        int inputType = editText.getInputType();
        return inputType == 129 || inputType == 145 || (com.bugfender.sdk.a.c.h.a.a() && inputType == 225) || (com.bugfender.sdk.a.c.h.a.a() && inputType == 18);
    }
}
