package d.a.a.a.g;

import gov.nc.dhhs.exposurenotification.network.DiagnosisAttestor;
import gov.nc.dhhs.exposurenotification.network.DiagnosisKey;
import java.util.Comparator;

/* compiled from: lambda */
public final /* synthetic */ class c implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ c f4666b = new c();

    private /* synthetic */ c() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return DiagnosisAttestor.BASE64.c(((DiagnosisKey) obj).getKeyBytes()).compareTo(DiagnosisAttestor.BASE64.c(((DiagnosisKey) obj2).getKeyBytes()));
    }
}
