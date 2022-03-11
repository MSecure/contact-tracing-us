package f.b.a.a.a.t;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import f.b.b.a.g;

public final /* synthetic */ class o implements g {
    public final /* synthetic */ SubmitPrivateAnalyticsWorker a;

    public /* synthetic */ o(SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker) {
        this.a = submitPrivateAnalyticsWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker = this.a;
        submitPrivateAnalyticsWorker.f407i.n(submitPrivateAnalyticsWorker.f408j.b());
        return new ListenableWorker.a.c();
    }
}
