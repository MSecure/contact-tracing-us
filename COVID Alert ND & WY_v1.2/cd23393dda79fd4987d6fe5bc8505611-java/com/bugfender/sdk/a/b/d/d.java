package com.bugfender.sdk.a.b.d;

import android.view.View;
import android.widget.SeekBar;
import com.bugfender.sdk.a.a.b;

public class d extends a {
    private View e;

    private class a implements SeekBar.OnSeekBarChangeListener {
        private final SeekBar.OnSeekBarChangeListener a;

        public a(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
            this.a = onSeekBarChangeListener;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            d.this.a("OnProgressChanged in SeekBar with { id: " + seekBar.getId() + ", progress: " + seekBar.getProgress() + " }");
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.a;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onProgressChanged(seekBar, i, z);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.a;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onStartTrackingTouch(seekBar);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.a;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onStopTrackingTouch(seekBar);
            }
        }
    }

    public d(b bVar, boolean z, boolean z2) {
        super(bVar, z, z2);
    }

    @Override // com.bugfender.sdk.a.b.d.g
    public <T extends View> void a(T t) {
        this.e = t;
        ((SeekBar) t).setOnSeekBarChangeListener(new a(com.bugfender.sdk.a.b.c.a.d(t)));
    }

    @Override // com.bugfender.sdk.a.b.d.a, com.bugfender.sdk.a.b.d.g
    public void a() {
        ((SeekBar) this.e).setOnSeekBarChangeListener(null);
        this.e = null;
        super.a();
    }
}
