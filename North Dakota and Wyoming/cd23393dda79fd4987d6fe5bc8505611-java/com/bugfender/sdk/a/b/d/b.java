package com.bugfender.sdk.a.b.d;

import android.view.View;
import android.widget.Button;

public class b extends a {
    private View e;
    private View$OnClickListenerC0017b f;

    /* renamed from: com.bugfender.sdk.a.b.d.b$b  reason: collision with other inner class name */
    private class View$OnClickListenerC0017b implements View.OnClickListener {
        private View.OnClickListener a;

        public void a() {
            this.a = null;
        }

        public void onClick(View view) {
            b.this.a("OnClick in Button with { id: " + view.getId() + ", text: " + ((Object) ((Button) view).getText()) + " }");
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        private View$OnClickListenerC0017b(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }
    }

    public b(com.bugfender.sdk.a.a.b bVar, boolean z, boolean z2) {
        super(bVar, z, z2);
    }

    @Override // com.bugfender.sdk.a.b.d.g
    public <T extends View> void a(T t) {
        this.e = t;
        if (t.isClickable()) {
            View$OnClickListenerC0017b bVar = new View$OnClickListenerC0017b(com.bugfender.sdk.a.b.c.a.b(t));
            this.f = bVar;
            t.setOnClickListener(bVar);
        }
    }

    @Override // com.bugfender.sdk.a.b.d.a, com.bugfender.sdk.a.b.d.g
    public void a() {
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.a();
        this.f = null;
        super.a();
    }
}
