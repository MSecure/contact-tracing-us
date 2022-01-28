package d.a.a.a.g;

import b.f.a.b;
import c.a.b.q;
import gov.nc.dhhs.exposurenotification.network.DiagnosisKeyUploader;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: lambda */
public final /* synthetic */ class t implements q.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyUploader f4697a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4698b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f4699c;

    public /* synthetic */ t(DiagnosisKeyUploader diagnosisKeyUploader, AtomicReference atomicReference, b bVar) {
        this.f4697a = diagnosisKeyUploader;
        this.f4698b = atomicReference;
        this.f4699c = bVar;
    }

    @Override // c.a.b.q.b
    public final void a(Object obj) {
        this.f4697a.h(this.f4698b, this.f4699c, (String) obj);
    }
}
