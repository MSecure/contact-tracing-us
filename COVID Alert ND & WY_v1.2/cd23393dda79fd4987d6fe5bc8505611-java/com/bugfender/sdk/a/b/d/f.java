package com.bugfender.sdk.a.b.d;

import android.view.View;
import android.widget.CompoundButton;

public class f extends a {
    private View e;

    private class b implements CompoundButton.OnCheckedChangeListener {
        private final CompoundButton.OnCheckedChangeListener a;

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            f.this.a("OnCheckedChanged in CompoundButton (Switch / SwitchCompat) with { id: " + compoundButton.getId() + ", checked: " + z + " }");
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.a;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(compoundButton, z);
            }
        }

        private b(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            this.a = onCheckedChangeListener;
        }
    }

    public f(com.bugfender.sdk.a.a.b bVar, boolean z, boolean z2) {
        super(bVar, z, z2);
    }

    @Override // com.bugfender.sdk.a.b.d.g
    public <T extends View> void a(T t) {
        this.e = t;
        ((CompoundButton) t).setOnCheckedChangeListener(new b(com.bugfender.sdk.a.b.c.a.a(t)));
    }

    @Override // com.bugfender.sdk.a.b.d.a, com.bugfender.sdk.a.b.d.g
    public void a() {
        ((CompoundButton) this.e).setOnCheckedChangeListener(null);
        this.e = null;
        super.a();
    }
}
