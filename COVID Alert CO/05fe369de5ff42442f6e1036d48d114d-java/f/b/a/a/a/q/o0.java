package f.b.a.a.a.q;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker;
import f.b.a.a.a.i.v;
import f.b.a.a.a.i.w;
import f.b.b.a.g;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class o0 implements g {
    public final /* synthetic */ SmsVerificationWorker a;
    public final /* synthetic */ Uri b;

    public /* synthetic */ o0(SmsVerificationWorker smsVerificationWorker, Uri uri) {
        this.a = smsVerificationWorker;
        this.b = uri;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        SmsVerificationWorker smsVerificationWorker = this.a;
        Uri uri = this.b;
        SmsVerificationWorker.b bVar = (SmsVerificationWorker.b) obj;
        w wVar = smsVerificationWorker.f385h;
        Context context = smsVerificationWorker.b;
        String str = v.a;
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        launchIntentForPackage.setFlags(268468224);
        launchIntentForPackage.putExtra("IntentUtil.ACTION_SMS_VERIFICATION", true);
        launchIntentForPackage.putExtra("IntentUtil.EXTRA_DEEP_LINK", uri);
        Intent b2 = v.b(smsVerificationWorker.b);
        b2.putExtra("IntentUtil.ACTION_SMS_VERIFICATION", true);
        wVar.c(context, R.string.notify_others_notification_title, R.string.enx_testVerificationNotificationBody, launchIntentForPackage, b2);
        return new ListenableWorker.a.c();
    }
}
