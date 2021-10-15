package e.a.a.e;

import android.net.Uri;
import b.f.a.b;
import c.a.b.q;
import gov.michigan.MiCovidExposure.network.DiagnosisKeyDownloader;

/* compiled from: lambda */
public final /* synthetic */ class g implements q.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uri f6284a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f6285b;

    public /* synthetic */ g(Uri uri, b bVar) {
        this.f6284a = uri;
        this.f6285b = bVar;
    }

    @Override // c.a.b.q.b
    public final void a(Object obj) {
        DiagnosisKeyDownloader.e(this.f6284a, this.f6285b, (byte[]) obj);
    }
}
