package f.b.a.c.f.b;

import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import f.b.a.c.i.h;
import java.io.File;
import java.util.List;

public interface c {
    h<Void> a(List<File> list);

    h<List<TemporaryExposureKey>> b();

    boolean c();

    h<List<DailySummary>> d(DailySummariesConfig dailySummariesConfig);

    h<List<d>> e();

    h<Long> f();

    h<DiagnosisKeysDataMapping> g();

    h<Void> h(DiagnosisKeysDataMapping diagnosisKeysDataMapping);

    h<e> i();

    h<Boolean> isEnabled();

    h<Void> start();

    h<Void> stop();
}
