package gov.nc.dhhs.exposurenotification.nearby;

import android.content.Context;
import c.b.a.a.g.a0;
import c.b.a.a.g.c0;
import c.b.a.a.g.h;
import c.b.a.a.g.j;
import c.b.a.a.g.l;
import c.b.a.a.g.v;
import c.b.a.a.g.y;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeyFileProvider;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.nearby.exposurenotification.ExposureInformation;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import com.google.android.gms.nearby.exposurenotification.ExposureSummary;
import com.google.android.gms.nearby.exposurenotification.ExposureWindow;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import d.a.a.a.f.b;
import d.a.a.a.f.c;
import d.a.a.a.f.d;
import java.io.File;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.Executor;

public class ExposureNotificationClientWrapper {
    public static final String FAKE_TOKEN_1 = "FAKE_TOKEN_1";
    public static final String FAKE_TOKEN_2 = "FAKE_TOKEN_2";
    public static final String FAKE_TOKEN_3 = "FAKE_TOKEN_3";
    public static ExposureNotificationClientWrapper INSTANCE;
    public final ExposureConfigurations config;
    public final ExposureNotificationClient exposureNotificationClient;

    public ExposureNotificationClientWrapper(Context context) {
        this.exposureNotificationClient = Nearby.getExposureNotificationClient(context);
        this.config = new ExposureConfigurations(context);
    }

    public static /* synthetic */ Boolean a(h hVar) {
        if (hVar.g()) {
            try {
                boolean z = false;
                if (Long.parseLong(Long.toString(((Long) hVar.f()).longValue()).substring(0, 2)) >= 17) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } catch (NumberFormatException unused) {
            }
        }
        return Boolean.FALSE;
    }

    public static ExposureNotificationClientWrapper get(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ExposureNotificationClientWrapper(context);
        }
        return INSTANCE;
    }

    private h<Long> getVersion() {
        return this.exposureNotificationClient.getVersion();
    }

    private h<Boolean> isAtLeastEnModuleVersion1Pt7() {
        h<Long> version = getVersion();
        c cVar = c.f4644a;
        a0 a0Var = (a0) version;
        if (a0Var != null) {
            Executor executor = j.f2857a;
            a0 a0Var2 = new a0();
            y<TResult> yVar = a0Var.f2850b;
            c0.a(executor);
            yVar.b(new l(executor, cVar, a0Var2));
            a0Var.k();
            return a0Var2;
        }
        throw null;
    }

    public /* synthetic */ h b(List list, Boolean bool) {
        return bool.booleanValue() ? this.exposureNotificationClient.provideDiagnosisKeys(new DiagnosisKeyFileProvider(list)) : this.exposureNotificationClient.provideDiagnosisKeys(list);
    }

    public boolean deviceSupportsLocationlessScanning() {
        return this.exposureNotificationClient.deviceSupportsLocationlessScanning();
    }

    public h<List<DailySummary>> getDailySummary(DailySummariesConfig dailySummariesConfig) {
        return this.exposureNotificationClient.getDailySummaries(dailySummariesConfig);
    }

    public h<DiagnosisKeysDataMapping> getDiagnosisKeysDataMapping() {
        return this.exposureNotificationClient.getDiagnosisKeysDataMapping();
    }

    public DiagnosisKeysDataMapping getDiagnosisKeysDataMapping2() {
        Integer num;
        TreeMap treeMap = new TreeMap();
        int i = -14;
        while (true) {
            int i2 = 2;
            if (i > 14) {
                return new DiagnosisKeysDataMapping.DiagnosisKeysDataMappingBuilder().setDaysSinceOnsetToInfectiousness(treeMap).setReportTypeWhenMissing(1).setInfectiousnessWhenDaysSinceOnsetMissing(2).build();
            }
            if (i < -14 || i >= -2) {
                num = Integer.valueOf(i);
            } else {
                num = Integer.valueOf(i);
                i2 = 0;
            }
            treeMap.put(num, Integer.valueOf(i2));
            i++;
        }
    }

    public h<List<ExposureInformation>> getExposureInformation(String str) {
        return this.exposureNotificationClient.getExposureInformation(str);
    }

    public h<ExposureSummary> getExposureSummary(String str) {
        return FAKE_TOKEN_1.equals(str) ? c.b.a.a.c.n.c.V0(new ExposureSummary.ExposureSummaryBuilder().setMatchedKeyCount(2).setDaysSinceLastExposure(1).build()) : FAKE_TOKEN_2.equals(str) ? c.b.a.a.c.n.c.V0(new ExposureSummary.ExposureSummaryBuilder().setMatchedKeyCount(1).setDaysSinceLastExposure(2).build()) : FAKE_TOKEN_3.equals(str) ? c.b.a.a.c.n.c.V0(new ExposureSummary.ExposureSummaryBuilder().setMatchedKeyCount(1).setDaysSinceLastExposure(3).setAttenuationDurations(new int[]{6, 4, 2}).build()) : this.exposureNotificationClient.getExposureSummary(str);
    }

    public h<List<ExposureWindow>> getExposureWindows() {
        return this.exposureNotificationClient.getExposureWindows(ExposureNotificationClient.TOKEN_A);
    }

    public h<List<TemporaryExposureKey>> getTemporaryExposureKeyHistory() {
        return this.exposureNotificationClient.getTemporaryExposureKeyHistory();
    }

    public h<Boolean> isEnabled() {
        return this.exposureNotificationClient.isEnabled();
    }

    public h<Void> provideDiagnosisKeys(List<File> list, String str) {
        return this.exposureNotificationClient.provideDiagnosisKeys(list, this.config.get(), str);
    }

    public h<Void> provideDiagnosisKeys2(List<File> list) {
        h<Boolean> isAtLeastEnModuleVersion1Pt7 = isAtLeastEnModuleVersion1Pt7();
        d dVar = new d(this, list);
        a0 a0Var = (a0) isAtLeastEnModuleVersion1Pt7;
        if (a0Var != null) {
            Executor executor = j.f2857a;
            a0 a0Var2 = new a0();
            y<TResult> yVar = a0Var.f2850b;
            c0.a(executor);
            yVar.b(new v(executor, dVar, a0Var2));
            a0Var.k();
            a0Var2.c(j.f2857a, b.f4643a);
            return a0Var2;
        }
        throw null;
    }

    public h<Void> setDiagnosisKeysDataMapping(DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        return this.exposureNotificationClient.setDiagnosisKeysDataMapping(diagnosisKeysDataMapping);
    }

    public h<Void> start() {
        return this.exposureNotificationClient.start();
    }

    public h<Void> stop() {
        return this.exposureNotificationClient.stop();
    }
}
