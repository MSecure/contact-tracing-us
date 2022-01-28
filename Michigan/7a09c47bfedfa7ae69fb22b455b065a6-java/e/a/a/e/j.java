package e.a.a.e;

import c.b.b.e.a.i;
import c.b.b.e.a.u;
import gov.michigan.MiCovidExposure.network.DiagnosisKeyDownloader;
import gov.michigan.MiCovidExposure.network.KeyFileBatch;

/* compiled from: lambda */
public final /* synthetic */ class j implements i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyDownloader f6289a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KeyFileBatch f6290b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f6291c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f6292d;

    public /* synthetic */ j(DiagnosisKeyDownloader diagnosisKeyDownloader, KeyFileBatch keyFileBatch, String str, int i) {
        this.f6289a = diagnosisKeyDownloader;
        this.f6290b = keyFileBatch;
        this.f6291c = str;
        this.f6292d = i;
    }

    @Override // c.b.b.e.a.i
    public final u a(Object obj) {
        return this.f6289a.c(this.f6290b, this.f6291c, this.f6292d, (byte[]) obj);
    }
}
