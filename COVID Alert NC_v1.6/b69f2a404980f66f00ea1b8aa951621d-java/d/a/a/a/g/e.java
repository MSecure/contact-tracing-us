package d.a.a.a.g;

import c.b.b.e.a.i;
import c.b.b.e.a.u;
import gov.nc.dhhs.exposurenotification.network.DiagnosisKeyDownloader;
import gov.nc.dhhs.exposurenotification.network.KeyFileBatch;

/* compiled from: lambda */
public final /* synthetic */ class e implements i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyDownloader f4668a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KeyFileBatch f4669b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f4670c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4671d;

    public /* synthetic */ e(DiagnosisKeyDownloader diagnosisKeyDownloader, KeyFileBatch keyFileBatch, String str, int i) {
        this.f4668a = diagnosisKeyDownloader;
        this.f4669b = keyFileBatch;
        this.f4670c = str;
        this.f4671d = i;
    }

    @Override // c.b.b.e.a.i
    public final u a(Object obj) {
        return this.f4668a.c(this.f4669b, this.f4670c, this.f4671d, (byte[]) obj);
    }
}
