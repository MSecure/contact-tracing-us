package d.a.a.a.c;

import android.os.StrictMode;
import gov.nc.dhhs.exposurenotification.common.AppExecutors;
import java.util.concurrent.ThreadFactory;

/* compiled from: lambda */
public final /* synthetic */ class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StrictMode.ThreadPolicy f4599a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4600b;

    public /* synthetic */ b(StrictMode.ThreadPolicy threadPolicy, int i) {
        this.f4599a = threadPolicy;
        this.f4600b = i;
    }

    public final Thread newThread(Runnable runnable) {
        return AppExecutors.a(this.f4599a, this.f4600b, runnable);
    }
}
