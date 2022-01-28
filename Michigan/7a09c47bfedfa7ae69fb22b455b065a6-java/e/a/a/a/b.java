package e.a.a.a;

import android.os.StrictMode;
import gov.michigan.MiCovidExposure.common.AppExecutors;
import java.util.concurrent.ThreadFactory;

/* compiled from: lambda */
public final /* synthetic */ class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StrictMode.ThreadPolicy f6213a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f6214b;

    public /* synthetic */ b(StrictMode.ThreadPolicy threadPolicy, int i) {
        this.f6213a = threadPolicy;
        this.f6214b = i;
    }

    public final Thread newThread(Runnable runnable) {
        return AppExecutors.a(this.f6213a, this.f6214b, runnable);
    }
}
