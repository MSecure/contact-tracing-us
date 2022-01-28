package e.a.a.e;

import android.net.Uri;
import b.f.a.b;
import b.f.a.d;
import c.b.b.b.c;
import gov.michigan.MiCovidExposure.network.DiagnosisAttestor;

/* compiled from: lambda */
public final /* synthetic */ class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisAttestor f6273a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f6274b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f6275c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Uri f6276d;

    public /* synthetic */ a(DiagnosisAttestor diagnosisAttestor, String str, c cVar, Uri uri) {
        this.f6273a = diagnosisAttestor;
        this.f6274b = str;
        this.f6275c = cVar;
        this.f6276d = uri;
    }

    @Override // b.f.a.d
    public final Object a(b bVar) {
        return this.f6273a.d(this.f6274b, this.f6275c, this.f6276d, bVar);
    }
}
