package f.b.a.a.a.l;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import f.b.b.a.g;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class o implements g {
    public static final /* synthetic */ o a = new o();

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        Throwable th = (Throwable) obj;
        TimeUnit timeUnit = UploadCoverTrafficWorker.f345j;
        return new ListenableWorker.a.C0002a();
    }
}
