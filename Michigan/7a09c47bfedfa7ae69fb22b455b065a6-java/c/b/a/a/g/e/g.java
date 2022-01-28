package c.b.a.a.g.e;

import c.b.a.a.d.k.o.o;
import c.b.a.a.j.j;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeyFileProvider;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;

public final /* synthetic */ class g implements o {

    /* renamed from: a  reason: collision with root package name */
    public final bb f3572a;

    /* renamed from: b  reason: collision with root package name */
    public final DiagnosisKeyFileProvider f3573b;

    public g(bb bbVar, DiagnosisKeyFileProvider diagnosisKeyFileProvider) {
        this.f3572a = bbVar;
        this.f3573b = diagnosisKeyFileProvider;
    }

    @Override // c.b.a.a.d.k.o.o
    public final void a(Object obj, Object obj2) {
        bb bbVar = this.f3572a;
        DiagnosisKeyFileProvider diagnosisKeyFileProvider = this.f3573b;
        cb cbVar = (cb) obj;
        j jVar = (j) obj2;
        if (bbVar != null) {
            a3 a3Var = new a3(null);
            a3Var.f3497e = new ExposureConfiguration.ExposureConfigurationBuilder().build();
            a3Var.f3499g = new u(diagnosisKeyFileProvider);
            a3Var.f3495c = new q(jVar);
            a3Var.f3498f = ExposureNotificationClient.TOKEN_A;
            ((n2) cbVar.getService()).k(a3Var);
            return;
        }
        throw null;
    }
}
