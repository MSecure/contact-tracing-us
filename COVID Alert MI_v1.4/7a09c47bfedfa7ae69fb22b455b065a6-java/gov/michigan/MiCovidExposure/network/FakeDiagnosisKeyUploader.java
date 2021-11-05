package gov.michigan.MiCovidExposure.network;

import android.content.Context;
import b.x.t;
import c.b.b.e.a.u;
import java.util.List;

public class FakeDiagnosisKeyUploader {
    public final Context context;

    public FakeDiagnosisKeyUploader(Context context2) {
        this.context = context2;
    }

    public u<Void> upload(List<DiagnosisKey> list) {
        return t.N1(null);
    }
}
