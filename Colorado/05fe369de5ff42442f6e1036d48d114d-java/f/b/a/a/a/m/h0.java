package f.b.a.a.a.m;

import e.p.t;
import java.util.Objects;

public final /* synthetic */ class h0 implements t {
    public final /* synthetic */ f1 a;

    public /* synthetic */ h0(f1 f1Var) {
        this.a = f1Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        f1 f1Var = this.a;
        Objects.requireNonNull(f1Var);
        if (((Boolean) obj).booleanValue()) {
            f1Var.W.f340j.a.edit().putBoolean("ExposureNotificationSharedPreferences.IS_IN_APP_SMS_NOTICE_SEEN", true).apply();
            new h1().D0(f1Var.h(), "SmsInterceptNoticeDialogFragment");
        }
    }
}
