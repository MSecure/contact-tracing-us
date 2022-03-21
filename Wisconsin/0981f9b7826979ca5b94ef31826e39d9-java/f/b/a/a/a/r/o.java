package f.b.a.a.a.r;

import android.util.Log;
import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import f.b.b.a.g;
import l.b.a.c;

public final /* synthetic */ class o implements g {
    public static final /* synthetic */ o a = new o();

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        c cVar = SubmitPrivateAnalyticsWorker.f388i;
        Log.e("PrioSubmitWorker", "Failure to submit private analytics", (Exception) obj);
        return new ListenableWorker.a.C0002a();
    }
}
