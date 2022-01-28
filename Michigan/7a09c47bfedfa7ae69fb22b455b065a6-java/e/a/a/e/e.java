package e.a.a.e;

import android.net.Uri;
import b.f.a.b;
import b.f.a.d;
import gov.michigan.MiCovidExposure.network.DiagnosisKeyDownloader;

/* compiled from: lambda */
public final /* synthetic */ class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyDownloader f6280a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Uri f6281b;

    public /* synthetic */ e(DiagnosisKeyDownloader diagnosisKeyDownloader, Uri uri) {
        this.f6280a = diagnosisKeyDownloader;
        this.f6281b = uri;
    }

    @Override // b.f.a.d
    public final Object a(b bVar) {
        return this.f6280a.d(this.f6281b, bVar);
    }
}
