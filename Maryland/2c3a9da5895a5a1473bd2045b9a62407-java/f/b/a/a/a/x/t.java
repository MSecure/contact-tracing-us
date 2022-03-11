package f.b.a.a.a.x;

import android.content.Intent;
import android.view.View;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.a.a.u.s;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class t implements View.OnClickListener {
    public final /* synthetic */ r0 b;

    public /* synthetic */ t(r0 r0Var) {
        this.b = r0Var;
    }

    public final void onClick(View view) {
        r0 r0Var = this.b;
        Objects.requireNonNull(r0Var);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", r0Var.X.getString(R.string.settings_share_message, String.format("https://play.google.com/store/apps/details?id=%s", "gov.md.covid19.exposurenotifications")));
        r0Var.w0(Intent.createChooser(intent, null));
        ExposureNotificationViewModel exposureNotificationViewModel = r0.b0;
        exposureNotificationViewModel.f348l.a(s.c.SHARE_APP_CLICKED);
    }
}
