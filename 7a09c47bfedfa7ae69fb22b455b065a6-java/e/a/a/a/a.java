package e.a.a.a;

import android.os.StrictMode;
import gov.michigan.MiCovidExposure.common.AppExecutors;

/* compiled from: lambda */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StrictMode.ThreadPolicy f6210b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f6211c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Runnable f6212d;

    public /* synthetic */ a(StrictMode.ThreadPolicy threadPolicy, int i, Runnable runnable) {
        this.f6210b = threadPolicy;
        this.f6211c = i;
        this.f6212d = runnable;
    }

    public final void run() {
        AppExecutors.b(this.f6210b, this.f6211c, this.f6212d);
    }
}
