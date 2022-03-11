package f.b.a.a.a.r;

import android.app.Activity;
import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;

public final /* synthetic */ class p implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity b;

    public /* synthetic */ p(Activity activity) {
        this.b = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        Activity activity = this.b;
        int i3 = ShareDiagnosisActivity.v;
        activity.finish();
    }
}
