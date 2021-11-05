package c.b.a.a.e.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.provider.Settings;
import c.b.a.a.c.c;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.d;
import c.b.a.a.c.k.o.q;
import c.b.a.a.g.h;
import c.b.a.a.g.i;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeyFileProvider;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.ExposureInformation;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationStatus;
import com.google.android.gms.nearby.exposurenotification.ExposureSummary;
import com.google.android.gms.nearby.exposurenotification.ExposureWindow;
import com.google.android.gms.nearby.exposurenotification.PackageConfiguration;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.android.gms.nearby.zza;
import java.io.File;
import java.util.List;
import java.util.Set;

public final class bb extends d<a.d.c> implements ExposureNotificationClient {

    /* renamed from: a  reason: collision with root package name */
    public static final a<a.d.c> f2535a = new a<>("Nearby.EXPOSURE_NOTIFICATION_API", new l(), new a.g());

    public bb(Context context) {
        super(context, f2535a, (a.d) null, d.a.f2305c);
    }

    public static final void a(cb cbVar, i iVar) {
        j3 j3Var = new j3((i3) null);
        j3Var.f2626b = new q(iVar);
        ((n2) cbVar.getService()).C(j3Var);
    }

    public static final void b(cb cbVar, i iVar) {
        g3 g3Var = new g3(null);
        g3Var.f2589b = new q(iVar);
        ((n2) cbVar.getService()).v(g3Var);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    @TargetApi(21)
    public final boolean deviceSupportsLocationlessScanning() {
        return Settings.Global.getInt(getApplicationContext().getContentResolver(), "bluetooth_sanitized_exposure_notification_supported", 0) == 1;
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<Integer> getCalibrationConfidence() {
        q.a builder = q.builder();
        builder.f2389a = new ib(this);
        builder.f2391c = new c[]{zza.zze};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<List<DailySummary>> getDailySummaries(DailySummariesConfig dailySummariesConfig) {
        q.a builder = q.builder();
        builder.f2389a = new fb(this, dailySummariesConfig);
        builder.f2391c = new c[]{zza.zzf};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<DiagnosisKeysDataMapping> getDiagnosisKeysDataMapping() {
        q.a builder = q.builder();
        builder.f2389a = new b(this);
        builder.f2391c = new c[]{zza.zzh};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<List<ExposureInformation>> getExposureInformation(String str) {
        q.a builder = q.builder();
        builder.f2389a = new db(this, str);
        builder.f2391c = new c[]{zza.zzb};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<ExposureSummary> getExposureSummary(String str) {
        q.a builder = q.builder();
        builder.f2389a = new i(this, str);
        builder.f2391c = new c[]{zza.zzb};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<List<ExposureWindow>> getExposureWindows() {
        return getExposureWindows(ExposureNotificationClient.TOKEN_A);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<List<ExposureWindow>> getExposureWindows(String str) {
        q.a builder = q.builder();
        builder.f2389a = new j(this, str);
        builder.f2391c = new c[]{zza.zzb};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<PackageConfiguration> getPackageConfiguration() {
        q.a builder = q.builder();
        builder.f2389a = new d(this);
        builder.f2391c = new c[]{zza.zzj};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<Set<ExposureNotificationStatus>> getStatus() {
        q.a builder = q.builder();
        builder.f2389a = new jb(this);
        builder.f2391c = new c[]{zza.zzg};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<List<TemporaryExposureKey>> getTemporaryExposureKeyHistory() {
        q.a builder = q.builder();
        builder.f2389a = new e(this);
        builder.f2391c = new c[]{zza.zzb};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<Long> getVersion() {
        q.a builder = q.builder();
        builder.f2389a = new gb(this);
        builder.f2391c = new c[]{zza.zzd};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<Boolean> isEnabled() {
        q.a builder = q.builder();
        builder.f2389a = new f(this);
        builder.f2391c = new c[]{zza.zzb};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<Void> provideDiagnosisKeys(DiagnosisKeyFileProvider diagnosisKeyFileProvider) {
        q.a builder = q.builder();
        builder.f2389a = new g(this, diagnosisKeyFileProvider);
        builder.f2391c = new c[]{zza.zzi};
        return doWrite(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<Void> provideDiagnosisKeys(List<File> list) {
        return provideDiagnosisKeys(list, new ExposureConfiguration.ExposureConfigurationBuilder().build(), ExposureNotificationClient.TOKEN_A);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<Void> setDiagnosisKeysDataMapping(DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        q.a builder = q.builder();
        builder.f2389a = new hb(diagnosisKeysDataMapping);
        builder.f2391c = new c[]{zza.zzh};
        return doWrite(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<Void> start() {
        q.a builder = q.builder();
        builder.f2389a = eb.f2568a;
        builder.f2391c = new c[]{zza.zzb};
        return doWrite(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<Void> stop() {
        q.a builder = q.builder();
        builder.f2389a = c.f2536a;
        builder.f2391c = new c[]{zza.zzb};
        return doWrite(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final h<Void> provideDiagnosisKeys(List<File> list, ExposureConfiguration exposureConfiguration, String str) {
        q.a builder = q.builder();
        builder.f2389a = new h(this, list, exposureConfiguration, str);
        builder.f2391c = new c[]{zza.zzb};
        return doWrite(builder.a());
    }
}
