package e.a.a.d;

import gov.michigan.MiCovidExposure.nearby.DiagnosisKeyFileSubmitter;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f6254b;

    public /* synthetic */ a(List list) {
        this.f6254b = list;
    }

    public final void run() {
        DiagnosisKeyFileSubmitter.a(this.f6254b);
    }
}
