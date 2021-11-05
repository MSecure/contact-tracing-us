package d.a.a.a.g;

import b.f.a.b;
import b.f.a.d;
import gov.nc.dhhs.exposurenotification.network.DiagnosisKeyUploader;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: lambda */
public final /* synthetic */ class r implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyUploader f4692a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4693b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyUploader.KeySubmission f4694c;

    public /* synthetic */ r(DiagnosisKeyUploader diagnosisKeyUploader, AtomicReference atomicReference, DiagnosisKeyUploader.KeySubmission keySubmission) {
        this.f4692a = diagnosisKeyUploader;
        this.f4693b = atomicReference;
        this.f4694c = keySubmission;
    }

    @Override // b.f.a.d
    public final Object a(b bVar) {
        return this.f4692a.j(this.f4693b, this.f4694c, bVar);
    }
}
