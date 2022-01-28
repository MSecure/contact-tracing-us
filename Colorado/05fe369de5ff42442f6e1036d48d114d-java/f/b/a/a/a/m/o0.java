package f.b.a.a.a.m;

import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.a.a.v.n;
import gov.co.cdphe.exposurenotifications.R;
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
        ContextWrapper contextWrapper = f1Var.X;
        intent.putExtra("android.intent.extra.TEXT", contextWrapper.getString(R.string.settings_share_message, String.format(contextWrapper.getString(R.string.share_this_app_link), "gov.co.cdphe.exposurenotifications")));
        f1Var.y0(Intent.createChooser(intent, null));
        ExposureNotificationViewModel exposureNotificationViewModel = f1Var.W;
        exposureNotificationViewModel.s.a(n.c.SHARE_APP_CLICKED);
    }
}
