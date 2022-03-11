package f.b.a.c.f.b;

import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import f.b.a.c.i.h;
import java.io.File;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public interface c {
    h<Void> a();

    h<Void> b(List<File> list);

    h<List<TemporaryExposureKey>> c();

    h<List<DailySummary>> d(DailySummariesConfig dailySummariesConfig);

    h<List<e>> e();

    h<Long> f();

    h<DiagnosisKeysDataMapping> g();

    h<Set<d>> getStatus();

    h<Void> h();

    h<Void> i(DiagnosisKeysDataMapping diagnosisKeysDataMapping);

    h<Boolean> isEnabled();

    h<f> j();

    h<Void> start();

    h<Void> stop();
}
