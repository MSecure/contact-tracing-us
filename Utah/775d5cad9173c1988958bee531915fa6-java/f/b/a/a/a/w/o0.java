package f.b.a.a.a.w;

import android.content.Intent;
import android.view.View;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.a.a.g0.n;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class o0 implements View.OnClickListener {
    public final /* synthetic */ f1 b;

    public /* synthetic */ o0(f1 f1Var) {
        this.b = f1Var;
    }

    public final void onClick(View view) {
        f1 f1Var = this.b;
        Objects.requireNonNull(f1Var);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", f1Var.j().getString(R.string.settings_share_message, String.format(f1Var.j().getString(R.string.share_this_app_link), "gov.ut.covid19.exposurenotifications")));
        f1Var.D0(Intent.createChooser(intent, null));
        ExposureNotificationViewModel exposureNotificationViewModel = f1Var.W;
        exposureNotificationViewModel.s.a(n.c.SHARE_APP_CLICKED);
    }
}
