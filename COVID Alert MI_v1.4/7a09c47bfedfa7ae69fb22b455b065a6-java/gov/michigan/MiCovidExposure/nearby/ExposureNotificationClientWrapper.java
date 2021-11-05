package gov.michigan.MiCovidExposure.nearby;

import android.content.Context;
import b.x.t;
import c.b.a.a.j.b0;
import c.b.a.a.j.c0;
import c.b.a.a.j.i;
import c.b.a.a.j.k;
import c.b.a.a.j.m;
import c.b.a.a.j.x;
import c.b.a.a.j.y;
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
import e.a.a.d.b;
import e.a.a.d.c;
import e.a.a.d.d;
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

    public static /* synthetic */ Boolean a(i iVar) {
        if (iVar.g()) {
            try {
                boolean z = false;
                if (Long.parseLong(Long.toString(((Long) iVar.f()).longValue()).substring(0, 2)) >= 17) {
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

    private i<Long> getVersion() {
        return this.exposureNotificationClient.getVersion();
    }

    private i<Boolean> isAtLeastEnModuleVersion1Pt7() {
        i<Long> version = getVersion();
        d dVar = d.f6258a;
        b0 b0Var = (b0) version;
        if (b0Var != null) {
            Executor executor = k.f4110a;
            b0 b0Var2 = new b0();
            y<TResult> yVar = b0Var.f4102b;
            c0.a(executor);
            yVar.b(new m(executor, dVar, b0Var2));
            b0Var.k();
            return b0Var2;
        }
        throw null;
    }

    public /* synthetic */ i b(List list, Boolean bool) {
        return bool.booleanValue() ? this.exposureNotificationClient.provideDiagnosisKeys(new DiagnosisKeyFileProvider(list)) : this.exposureNotificationClient.provideDiagnosisKeys(list);
    }

    public boolean deviceSupportsLocationlessScanning() {
        return this.exposureNotificationClient.deviceSupportsLocationlessScanning();
    }

    public i<List<DailySummary>> getDailySummary(DailySummariesConfig dailySummariesConfig) {
        return this.exposureNotificationClient.getDailySummaries(dailySummariesConfig);
    }

    public i<DiagnosisKeysDataMapping> getDiagnosisKeysDataMapping() {
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

    public i<List<ExposureInformation>> getExposureInformation(String str) {
        return this.exposureNotificationClient.getExposureInformation(str);
    }

    public i<ExposureSummary> getExposureSummary(String str) {
        return FAKE_TOKEN_1.equals(str) ? t.x1(new ExposureSummary.ExposureSummaryBuilder().setMatchedKeyCount(2).setDaysSinceLastExposure(1).build()) : FAKE_TOKEN_2.equals(str) ? t.x1(new ExposureSummary.ExposureSummaryBuilder().setMatchedKeyCount(1).setDaysSinceLastExposure(2).build()) : FAKE_TOKEN_3.equals(str) ? t.x1(new ExposureSummary.ExposureSummaryBuilder().setMatchedKeyCount(1).setDaysSinceLastExposure(3).setAttenuationDurations(new int[]{6, 4, 2}).build()) : this.exposureNotificationClient.getExposureSummary(str);
    }

    public i<List<ExposureWindow>> getExposureWindows() {
        return this.exposureNotificationClient.getExposureWindows(ExposureNotificationClient.TOKEN_A);
    }

    public i<List<TemporaryExposureKey>> getTemporaryExposureKeyHistory() {
        return this.exposureNotificationClient.getTemporaryExposureKeyHistory();
    }

    public i<Boolean> isEnabled() {
        return this.exposureNotificationClient.isEnabled();
    }

    public i<Void> provideDiagnosisKeys(List<File> list, String str) {
        return this.exposureNotificationClient.provideDiagnosisKeys(list, this.config.get(), str);
    }

    public i<Void> provideDiagnosisKeys2(List<File> list) {
        i<Boolean> isAtLeastEnModuleVersion1Pt7 = isAtLeastEnModuleVersion1Pt7();
        b bVar = new b(this, list);
        b0 b0Var = (b0) isAtLeastEnModuleVersion1Pt7;
        if (b0Var != null) {
            Executor executor = k.f4110a;
            b0 b0Var2 = new b0();
            y<TResult> yVar = b0Var.f4102b;
            c0.a(executor);
            yVar.b(new x(executor, bVar, b0Var2));
            b0Var.k();
            b0Var2.c(k.f4110a, c.f6257a);
            return b0Var2;
        }
        throw null;
    }

    public i<Void> setDiagnosisKeysDataMapping(DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        return this.exposureNotificationClient.setDiagnosisKeysDataMapping(diagnosisKeysDataMapping);
    }

    public i<Void> start() {
        return this.exposureNotificationClient.start();
    }

    public i<Void> stop() {
        return this.exposureNotificationClient.stop();
    }
}
