package f.b.a.a.a.n;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import f.b.b.a.g;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class m implements g {
    public static final /* synthetic */ m a = new m();

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        Throwable th = (Throwable) obj;
        TimeUnit timeUnit = UploadCoverTrafficWorker.f354k;
        return new ListenableWorker.a.C0003a();
    }
}
