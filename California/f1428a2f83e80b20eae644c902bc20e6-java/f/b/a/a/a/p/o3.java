package f.b.a.a.a.p;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import gov.ca.covid19.exposurenotifications.R;

public class o3 extends z2 {
    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_not_shared, viewGroup, false);
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        g().setTitle(R.string.not_shared_confirm_title);
        view.findViewById(R.id.share_done_button).setOnClickListener(new i0(this));
    }
}
