package d.a.a.a.g;

import android.net.Uri;
import b.f.a.b;
import b.f.a.d;
import gov.nc.dhhs.exposurenotification.network.DiagnosisKeyDownloader;

/* compiled from: lambda */
public final /* synthetic */ class h implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyDownloader f4675a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Uri f4676b;

    public /* synthetic */ h(DiagnosisKeyDownloader diagnosisKeyDownloader, Uri uri) {
        this.f4675a = diagnosisKeyDownloader;
        this.f4676b = uri;
    }

    @Override // b.f.a.d
    public final Object a(b bVar) {
        return this.f4675a.d(this.f4676b, bVar);
    }
}
