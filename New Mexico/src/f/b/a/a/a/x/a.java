package f.b.a.a.a.x;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.a.e.b;
import e.r.s;
import f.b.a.c.i.c;
import f.b.a.c.i.e;
import f.b.a.c.i.f;
import java.util.Objects;
/* loaded from: classes.dex */
public final /* synthetic */ class a implements b {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ a(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // e.a.e.b
    public final void a(Object obj) {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        Objects.requireNonNull(exposureNotificationViewModel);
        ExposureNotificationViewModel.y.a("onResolutionComplete");
        if (((e.a.e.a) obj).b == -1) {
            exposureNotificationViewModel.f342e.l(Boolean.FALSE);
            exposureNotificationViewModel.q.d().f(new f() { // from class: f.b.a.a.a.x.r
                @Override // f.b.a.c.i.f
                public final void a(Object obj2) {
                    ExposureNotificationViewModel exposureNotificationViewModel2 = ExposureNotificationViewModel.this;
                    Void r3 = (Void) obj2;
                    exposureNotificationViewModel2.d(true);
                    s<Boolean> sVar = exposureNotificationViewModel2.f343f;
                    Boolean bool = Boolean.TRUE;
                    sVar.l(bool);
                    exposureNotificationViewModel2.f344g.l(bool);
                    exposureNotificationViewModel2.f341d.l(Boolean.FALSE);
                    exposureNotificationViewModel2.e();
                }
            }).d(new e() { // from class: f.b.a.a.a.x.f
                @Override // f.b.a.c.i.e
                public final void b(Exception exc) {
                    ExposureNotificationViewModel exposureNotificationViewModel2 = ExposureNotificationViewModel.this;
                    exposureNotificationViewModel2.f349l.l(null);
                    exposureNotificationViewModel2.f341d.l(Boolean.FALSE);
                }
            }).a(new c() { // from class: f.b.a.a.a.x.l
                @Override // f.b.a.c.i.c
                public final void d() {
                    ExposureNotificationViewModel.this.f341d.l(Boolean.FALSE);
                }
            });
            return;
        }
        s<Boolean> sVar = exposureNotificationViewModel.f342e;
        Boolean bool = Boolean.FALSE;
        sVar.l(bool);
        exposureNotificationViewModel.f341d.l(bool);
    }
}
