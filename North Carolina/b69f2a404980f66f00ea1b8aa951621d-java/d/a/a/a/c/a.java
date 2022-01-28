package d.a.a.a.c;

import android.os.StrictMode;
import gov.nc.dhhs.exposurenotification.common.AppExecutors;

/* compiled from: lambda */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StrictMode.ThreadPolicy f4596b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4597c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Runnable f4598d;

    public /* synthetic */ a(StrictMode.ThreadPolicy threadPolicy, int i, Runnable runnable) {
        this.f4596b = threadPolicy;
        this.f4597c = i;
        this.f4598d = runnable;
    }

    public final void run() {
        AppExecutors.b(this.f4596b, this.f4597c, this.f4598d);
    }
}
