package c.b.a.a.e.c;

import c.b.a.a.c.k.o.o;
import c.b.a.a.g.i;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeyFileProvider;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;

public final /* synthetic */ class g implements o {

    /* renamed from: a  reason: collision with root package name */
    public final bb f2587a;

    /* renamed from: b  reason: collision with root package name */
    public final DiagnosisKeyFileProvider f2588b;

    public g(bb bbVar, DiagnosisKeyFileProvider diagnosisKeyFileProvider) {
        this.f2587a = bbVar;
        this.f2588b = diagnosisKeyFileProvider;
    }

    @Override // c.b.a.a.c.k.o.o
    public final void a(Object obj, Object obj2) {
        bb bbVar = this.f2587a;
        DiagnosisKeyFileProvider diagnosisKeyFileProvider = this.f2588b;
        cb cbVar = (cb) obj;
        i iVar = (i) obj2;
        if (bbVar != null) {
            a3 a3Var = new a3(null);
            a3Var.f2516e = new ExposureConfiguration.ExposureConfigurationBuilder().build();
            a3Var.g = new u(diagnosisKeyFileProvider);
            a3Var.f2514c = new q(iVar);
            a3Var.f = ExposureNotificationClient.TOKEN_A;
            ((n2) cbVar.getService()).n(a3Var);
            return;
        }
        throw null;
    }
}
