package f.b.a.a.a.d0;

import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.s.b0;
import f.b.a.a.a.s.x;
import f.b.a.a.a.y.f0;
import f.b.a.a.a.y.i0;
import f.b.b.c.a;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import f.b.f.a.b;
import f.b.f.a.c;
import f.b.f.a.d;
import f.b.f.a.e;
import gov.ut.covid19.exposurenotifications.R;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;
import l.b.a.f;

public final /* synthetic */ class b1 implements View.OnClickListener {
    public final /* synthetic */ z5 b;
    public final /* synthetic */ View c;

    public /* synthetic */ b1(z5 z5Var, View view) {
        this.b = z5Var;
        this.c = view;
    }

    public final void onClick(View view) {
        boolean z;
        e eVar;
        String stripSeparators;
        z5 z5Var = this.b;
        View view2 = this.c;
        z5Var.T0();
        m.e.S0(z5Var.t0(), view2);
        String obj = z5Var.h0.f2369g.getText().toString();
        f T = f.T(z5Var.h0.m.getText().toString(), z5Var.L0());
        ShareDiagnosisViewModel shareDiagnosisViewModel = z5Var.b0;
        if (!shareDiagnosisViewModel.o.d().booleanValue()) {
            shareDiagnosisViewModel.o.j(Boolean.TRUE);
            b0 b0Var = shareDiagnosisViewModel.f406k;
            Objects.requireNonNull(b0Var);
            String str = null;
            if (!(obj == null || (stripSeparators = PhoneNumberUtils.stripSeparators(obj)) == null)) {
                str = PhoneNumberUtils.formatNumberToE164(stripSeparators, b0Var.a());
                if (TextUtils.isEmpty(str)) {
                    str = stripSeparators;
                }
            }
            b0 b0Var2 = shareDiagnosisViewModel.f406k;
            Objects.requireNonNull(b0Var2);
            if (!TextUtils.isEmpty(obj)) {
                String a = b0Var2.a();
                Logger logger = e.f3538h;
                synchronized (e.class) {
                    if (e.v == null) {
                        e eVar2 = new e(new c(b.a), f.b.a.c.b.o.b.A0());
                        synchronized (e.class) {
                            e.v = eVar2;
                        }
                    }
                    eVar = e.v;
                }
                try {
                    z = eVar.j(eVar.p(obj, a));
                } catch (d unused) {
                }
                if (z || TextUtils.isEmpty(str)) {
                    String string = shareDiagnosisViewModel.f402g.getString(R.string.self_report_bad_phone_number, shareDiagnosisViewModel.f402g.getString(R.string.learn_more));
                    shareDiagnosisViewModel.o.j(Boolean.FALSE);
                    shareDiagnosisViewModel.F.j(string);
                } else {
                    shareDiagnosisViewModel.F.j("");
                    long j2 = (long) (shareDiagnosisViewModel.f405j.b().c.c / 60);
                    SecureRandom secureRandom = shareDiagnosisViewModel.f407l;
                    a aVar = x.a;
                    byte[] bArr = new byte[256];
                    secureRandom.nextBytes(bArr);
                    i0 a2 = i0.d(str, x.a.c(bArr), T, j2).a();
                    l y = l.x(shareDiagnosisViewModel.d(ShareDiagnosisViewModel.P)).z(new l4(shareDiagnosisViewModel), shareDiagnosisViewModel.y).z(new x2(shareDiagnosisViewModel, a2), shareDiagnosisViewModel.y).z(new g3(shareDiagnosisViewModel, a2), shareDiagnosisViewModel.y).y(new x3(shareDiagnosisViewModel), shareDiagnosisViewModel.y);
                    w2 w2Var = new w2(shareDiagnosisViewModel);
                    ExecutorService executorService = shareDiagnosisViewModel.y;
                    a.b bVar = new a.b(y, ShareDiagnosisViewModel.c.class, w2Var);
                    y.a(bVar, f.b.a.c.b.o.b.j1(executorService, bVar));
                    r3 r3Var = new r3(shareDiagnosisViewModel);
                    ExecutorService executorService2 = shareDiagnosisViewModel.y;
                    a.b bVar2 = new a.b(bVar, f0.c.class, r3Var);
                    bVar.a(bVar2, f.b.a.c.b.o.b.j1(executorService2, bVar2));
                    b4 b4Var = new b4(shareDiagnosisViewModel, a2);
                    ExecutorService executorService3 = shareDiagnosisViewModel.y;
                    a.C0108a aVar2 = new a.C0108a(bVar2, f0.d.class, b4Var);
                    bVar2.a(aVar2, f.b.a.c.b.o.b.j1(executorService3, aVar2));
                    s3 s3Var = new s3(shareDiagnosisViewModel);
                    ExecutorService executorService4 = shareDiagnosisViewModel.y;
                    a.b bVar3 = new a.b(aVar2, Exception.class, s3Var);
                    aVar2.a(bVar3, f.b.a.c.b.o.b.j1(executorService4, bVar3));
                    return;
                }
            }
            z = false;
            if (z) {
            }
            String string2 = shareDiagnosisViewModel.f402g.getString(R.string.self_report_bad_phone_number, shareDiagnosisViewModel.f402g.getString(R.string.learn_more));
            shareDiagnosisViewModel.o.j(Boolean.FALSE);
            shareDiagnosisViewModel.F.j(string2);
        }
        u<?> uVar = s.c;
    }
}
