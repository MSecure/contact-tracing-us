package f.b.a.a.a.f0;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import f.b.a.d.a.g0;
import f.b.b.a.g;

public final /* synthetic */ class j implements g {
    public final /* synthetic */ SubmitPrivateAnalyticsWorker a;

    public /* synthetic */ j(SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker) {
        this.a = submitPrivateAnalyticsWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        g0.a aVar = (g0.a) obj;
        this.a.g();
        return new ListenableWorker.a.c();
    }
}
