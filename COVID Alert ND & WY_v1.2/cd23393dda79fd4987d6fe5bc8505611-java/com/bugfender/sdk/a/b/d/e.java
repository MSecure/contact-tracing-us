package com.bugfender.sdk.a.b.d;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class e extends a {
    private View e;

    private class b implements AdapterView.OnItemSelectedListener {
        private final AdapterView.OnItemSelectedListener a;

        private int a(View view) {
            if (view != null) {
                return view.getId();
            }
            return -1;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            e.this.a("OnItemSelected in Spinner with { id: " + a(view) + ", position: " + i + " }");
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.a;
            if (onItemSelectedListener != null) {
                onItemSelectedListener.onItemSelected(adapterView, view, i, j);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.a;
            if (onItemSelectedListener != null) {
                onItemSelectedListener.onNothingSelected(adapterView);
            }
        }

        private b(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.a = onItemSelectedListener;
        }
    }

    public e(com.bugfender.sdk.a.a.b bVar, boolean z, boolean z2) {
        super(bVar, z, z2);
    }

    @Override // com.bugfender.sdk.a.b.d.g
    public <T extends View> void a(T t) {
        this.e = t;
        ((Spinner) t).setOnItemSelectedListener(new b(com.bugfender.sdk.a.b.c.a.c(t)));
    }

    @Override // com.bugfender.sdk.a.b.d.a, com.bugfender.sdk.a.b.d.g
    public void a() {
        ((Spinner) this.e).setOnItemSelectedListener(null);
        this.e = null;
        super.a();
    }
}
