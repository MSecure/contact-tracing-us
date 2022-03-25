package f.b.a.a.a.k;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel;
import e.m.a.k;
import e.p.b0;
import f.b.a.a.a.i.h;
import gov.md.covid19.exposurenotifications.R;

public class m extends k {
    public h n0;

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.exposure_checks_dialog, viewGroup, false);
        int i2 = R.id.checks_dialog_close;
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.checks_dialog_close);
        if (imageButton != null) {
            i2 = R.id.checks_recycler_view;
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.checks_recycler_view);
            if (recyclerView != null) {
                this.n0 = new h((LinearLayout) inflate, imageButton, recyclerView);
                Dialog dialog = this.i0;
                if (dialog != null) {
                    dialog.setTitle(z(R.string.recent_check_dialog_title));
                }
                Dialog dialog2 = this.i0;
                if (!(dialog2 == null || dialog2.getWindow() == null)) {
                    this.i0.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                }
                return this.n0.a;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.k, e.m.a.l
    public void R() {
        super.R();
        this.n0 = null;
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        l lVar = new l(n0());
        n0();
        this.n0.c.setLayoutManager(new LinearLayoutManager(1, false));
        this.n0.c.setAdapter(lVar);
        this.n0.b.setOnClickListener(new a(this));
        ((ExposureHomeViewModel) new b0(m0()).a(ExposureHomeViewModel.class)).f339d.f(B(), new k(lVar));
    }
}
