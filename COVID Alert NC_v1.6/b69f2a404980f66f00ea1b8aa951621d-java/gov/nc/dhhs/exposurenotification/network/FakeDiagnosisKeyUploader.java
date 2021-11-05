package gov.nc.dhhs.exposurenotification.network;

import android.content.Context;
import c.b.a.a.c.n.c;
import c.b.b.e.a.u;
import java.util.List;

public class FakeDiagnosisKeyUploader {
    public final Context context;

    public FakeDiagnosisKeyUploader(Context context2) {
        this.context = context2;
    }

    public u<Void> upload(List<DiagnosisKey> list) {
        return c.k1(null);
    }
}
