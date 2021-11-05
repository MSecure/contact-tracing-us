package d.a.a.a.g;

import android.net.Uri;
import b.f.a.b;
import c.a.b.q;
import gov.nc.dhhs.exposurenotification.network.DiagnosisKeyDownloader;

/* compiled from: lambda */
public final /* synthetic */ class j implements q.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uri f4679a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f4680b;

    public /* synthetic */ j(Uri uri, b bVar) {
        this.f4679a = uri;
        this.f4680b = bVar;
    }

    @Override // c.a.b.q.b
    public final void a(Object obj) {
        DiagnosisKeyDownloader.e(this.f4679a, this.f4680b, (byte[]) obj);
    }
}
