package f.b.a.a.a.v;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel;
import e.q.t;
import f.b.a.a.a.s.a0;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.t.w;
import gov.ut.covid19.exposurenotifications.R;
import l.b.a.e;
import l.b.a.f;
import l.b.a.g;
import l.b.a.h;
import l.b.a.r;

public final /* synthetic */ class d implements t {
    public final /* synthetic */ n a;

    public /* synthetic */ d(n nVar) {
        this.a = nVar;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        int i2;
        int i3;
        n nVar = this.a;
        f.b.a.a.a.h0.d dVar = (f.b.a.a.a.h0.d) obj;
        boolean booleanValue = Boolean.valueOf(nVar.c0.c.f()).booleanValue();
        w wVar = nVar.b0;
        TextView textView = wVar.f2429d;
        TextView textView2 = wVar.f2431f;
        Button button = wVar.f2432g;
        ExposureHomeViewModel exposureHomeViewModel = nVar.c0;
        Context t0 = nVar.t0();
        e c = exposureHomeViewModel.f337f.c();
        a aVar = a0.a;
        long j2 = l.b.a.d.c(g.F(f.R(dVar.a()), h.f4365h).w(r.f4386g), c).b;
        long j3 = 1;
        if (j2 < 0) {
            a0.a.c("Negative time since exposure!");
        } else {
            j3 = Math.max(1L, j2 / 86400);
        }
        textView.setText(t0.getResources().getQuantityString(R.plurals.days_from_start_of_exposure, (int) j3, Long.valueOf(j3)));
        if (booleanValue) {
            i2 = R.string.exposure_details_url_revoked;
            button.setText(R.string.exposure_details_url_revoked);
            i3 = R.string.exposure_details_text_revoked;
        } else {
            int b = dVar.b();
            if (b == 1) {
                i2 = R.string.exposure_details_url_1;
                button.setText(R.string.exposure_details_url_1);
                i3 = R.string.exposure_details_text_1;
            } else if (b == 2) {
                i2 = R.string.exposure_details_url_2;
                button.setText(R.string.exposure_details_url_2);
                i3 = R.string.exposure_details_text_2;
            } else if (b == 3) {
                i2 = R.string.exposure_details_url_3;
                button.setText(R.string.exposure_details_url_3);
                i3 = R.string.exposure_details_text_3;
            } else if (b == 4) {
                i2 = R.string.exposure_details_url_4;
                button.setText(R.string.exposure_details_url_4);
                i3 = R.string.exposure_details_text_4;
            } else {
                return;
            }
        }
        textView2.setText(i3);
        nVar.I0(nVar.E(i2));
    }
}
