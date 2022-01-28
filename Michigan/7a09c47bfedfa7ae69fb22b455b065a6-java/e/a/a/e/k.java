package e.a.a.e;

import b.f.a.b;
import c.a.b.q;
import gov.michigan.MiCovidExposure.network.DiagnosisKeyUploader;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: lambda */
public final /* synthetic */ class k implements q.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyUploader f6293a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f6294b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f6295c;

    public /* synthetic */ k(DiagnosisKeyUploader diagnosisKeyUploader, AtomicReference atomicReference, b bVar) {
        this.f6293a = diagnosisKeyUploader;
        this.f6294b = atomicReference;
        this.f6295c = bVar;
    }

    @Override // c.a.b.q.b
    public final void a(Object obj) {
        this.f6293a.h(this.f6294b, this.f6295c, (String) obj);
    }
}
