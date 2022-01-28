package e.a.a.e;

import b.f.a.b;
import b.f.a.d;
import gov.michigan.MiCovidExposure.network.DiagnosisKeyUploader;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: lambda */
public final /* synthetic */ class m implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyUploader f6298a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f6299b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyUploader.KeySubmission f6300c;

    public /* synthetic */ m(DiagnosisKeyUploader diagnosisKeyUploader, AtomicReference atomicReference, DiagnosisKeyUploader.KeySubmission keySubmission) {
        this.f6298a = diagnosisKeyUploader;
        this.f6299b = atomicReference;
        this.f6300c = keySubmission;
    }

    @Override // b.f.a.d
    public final Object a(b bVar) {
        return this.f6298a.j(this.f6299b, this.f6300c, bVar);
    }
}
