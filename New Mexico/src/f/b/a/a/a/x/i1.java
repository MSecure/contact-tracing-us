package f.b.a.a.a.x;

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
import e.o.a.l;
import f.b.a.a.a.o0.b;
import f.b.a.a.a.u.q0;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public class i1 extends l {
    public q0 m0;

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                        this.m0 = new q0((LinearLayout) inflate, imageButton, button, button2, textView);
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

    @Override // e.o.a.l, e.o.a.m
    public void X() {
        super.X();
        this.m0 = null;
    }

    @Override // e.o.a.m
    public void m0(View view, Bundle bundle) {
        this.m0.b.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i1.this.H0(false, false);
            }
        });
        this.m0.f2474d.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i1.this.H0(false, false);
            }
        });
        this.m0.c.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.a(view2, i1.this.F(R.string.sms_notice_link));
            }
        });
    }
}
