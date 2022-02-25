package f.b.a.a.a.v;

import android.content.Intent;
import android.view.View;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.a.a.s.s;
import gov.ca.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class t implements View.OnClickListener {
    public final /* synthetic */ t0 b;

    public /* synthetic */ t(t0 t0Var) {
        this.b = t0Var;
    }

    public final void onClick(View view) {
        t0 t0Var = this.b;
        Objects.requireNonNull(t0Var);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", t0Var.W.getString(R.string.settings_share_message, String.format("https://play.google.com/store/apps/details?id=%s", "gov.ca.covid19.exposurenotifications")));
        t0Var.w0(Intent.createChooser(intent, null));
        ExposureNotificationViewModel exposureNotificationViewModel = t0.Z;
        exposureNotificationViewModel.m.a(s.c.SHARE_APP_CLICKED);
    }
}
