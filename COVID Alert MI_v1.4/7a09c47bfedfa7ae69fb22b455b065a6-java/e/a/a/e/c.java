package e.a.a.e;

import gov.michigan.MiCovidExposure.network.DiagnosisAttestor;
import gov.michigan.MiCovidExposure.network.DiagnosisKey;
import java.util.Comparator;

/* compiled from: lambda */
public final /* synthetic */ class c implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ c f6278b = new c();

    private /* synthetic */ c() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return DiagnosisAttestor.BASE64.c(((DiagnosisKey) obj).getKeyBytes()).compareTo(DiagnosisAttestor.BASE64.c(((DiagnosisKey) obj2).getKeyBytes()));
    }
}
