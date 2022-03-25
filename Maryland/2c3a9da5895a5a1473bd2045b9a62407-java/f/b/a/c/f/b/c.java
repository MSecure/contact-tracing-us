package f.b.a.c.f.b;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import f.b.a.c.i.h;
import java.io.File;
import java.util.List;
import java.util.Set;

public interface c {
    @RecentlyNonNull
    h<Void> a(@RecentlyNonNull List<File> list);

    @RecentlyNonNull
    h<List<TemporaryExposureKey>> b();

    @RecentlyNonNull
    h<List<DailySummary>> c(@RecentlyNonNull DailySummariesConfig dailySummariesConfig);

    @RecentlyNonNull
    h<List<e>> d();

    @RecentlyNonNull
    h<Long> e();

    @RecentlyNonNull
    h<DiagnosisKeysDataMapping> f();

    @RecentlyNonNull
    h<Void> g(@RecentlyNonNull DiagnosisKeysDataMapping diagnosisKeysDataMapping);

    @RecentlyNonNull
    h<Set<d>> getStatus();

    @RecentlyNonNull
    h<f> h();

    @RecentlyNonNull
    h<Boolean> isEnabled();

    @RecentlyNonNull
    h<Void> start();

    @RecentlyNonNull
    h<Void> stop();
}
