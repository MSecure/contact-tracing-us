package f.b.a.a.a.w;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import e.n.a.l;
import f.b.a.a.a.t.n0;
import gov.ut.covid19.exposurenotifications.R;

public class h1 extends l {
    public n0 m0;

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_sms_notice_dialog, viewGroup, false);
        int i2 = R.id.btn_close;
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.btn_close);
        if (imageButton != null) {
            i2 = R.id.btn_learn_more;
            Button button = (Button) inflate.findViewById(R.id.btn_learn_more);
            if (button != null) {
                i2 = R.id.btn_ok;
                Button button2 = (Button) inflate.findViewById(R.id.btn_ok);
                if (button2 != null) {
                    i2 = R.id.do_you_have_code_content;
                    TextView textView = (TextView) inflate.findViewById(R.id.do_you_have_code_content);
                    if (textView != null) {
                        this.m0 = new n0((LinearLayout) inflate, imageButton, button, button2, textView);
                        Dialog dialog = this.h0;
                        if (!(dialog == null || dialog.getWindow() == null)) {
                            this.h0.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        }
                        return this.m0.a;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.n.a.l, e.n.a.m
    public void V() {
        super.V();
        this.m0 = null;
    }

    @Override // e.n.a.m
    public void k0(View view, Bundle bundle) {
        this.m0.b.setOnClickListener(new q0(this));
        this.m0.f2406d.setOnClickListener(new p0(this));
        this.m0.c.setOnClickListener(new r0(this));
    }
}
