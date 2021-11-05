package c.b.a.a.g.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.provider.Settings;
import c.b.a.a.d.c;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.d;
import c.b.a.a.d.k.o.r;
import c.b.a.a.j.i;
import c.b.a.a.j.j;
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
    public static final a<a.d.c> f3520a = new a<>("Nearby.EXPOSURE_NOTIFICATION_API", new l(), new a.g());

    public bb(Context context) {
        super(context, f3520a, (a.d) null, d.a.f2942c);
    }

    public static final void a(cb cbVar, j jVar) {
        j3 j3Var = new j3((i3) null);
        j3Var.f3614b = new q(jVar);
        ((n2) cbVar.getService()).z(j3Var);
    }

    public static final void b(cb cbVar, j jVar) {
        g3 g3Var = new g3(null);
        g3Var.f3574b = new q(jVar);
        ((n2) cbVar.getService()).s(g3Var);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    @TargetApi(21)
    public final boolean deviceSupportsLocationlessScanning() {
        return Settings.Global.getInt(getApplicationContext().getContentResolver(), "bluetooth_sanitized_exposure_notification_supported", 0) == 1;
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<Integer> getCalibrationConfidence() {
        r.a builder = r.builder();
        builder.f3043a = new ib(this);
        builder.f3045c = new c[]{zza.zze};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<List<DailySummary>> getDailySummaries(DailySummariesConfig dailySummariesConfig) {
        r.a builder = r.builder();
        builder.f3043a = new fb(this, dailySummariesConfig);
        builder.f3045c = new c[]{zza.zzf};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<DiagnosisKeysDataMapping> getDiagnosisKeysDataMapping() {
        r.a builder = r.builder();
        builder.f3043a = new b(this);
        builder.f3045c = new c[]{zza.zzh};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<List<ExposureInformation>> getExposureInformation(String str) {
        r.a builder = r.builder();
        builder.f3043a = new db(this, str);
        builder.f3045c = new c[]{zza.zzb};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<ExposureSummary> getExposureSummary(String str) {
        r.a builder = r.builder();
        builder.f3043a = new i(this, str);
        builder.f3045c = new c[]{zza.zzb};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<List<ExposureWindow>> getExposureWindows() {
        return getExposureWindows(ExposureNotificationClient.TOKEN_A);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<List<ExposureWindow>> getExposureWindows(String str) {
        r.a builder = r.builder();
        builder.f3043a = new j(this, str);
        builder.f3045c = new c[]{zza.zzb};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<PackageConfiguration> getPackageConfiguration() {
        r.a builder = r.builder();
        builder.f3043a = new d(this);
        builder.f3045c = new c[]{zza.zzj};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<Set<ExposureNotificationStatus>> getStatus() {
        r.a builder = r.builder();
        builder.f3043a = new jb(this);
        builder.f3045c = new c[]{zza.zzg};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<List<TemporaryExposureKey>> getTemporaryExposureKeyHistory() {
        r.a builder = r.builder();
        builder.f3043a = new e(this);
        builder.f3045c = new c[]{zza.zzb};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<Long> getVersion() {
        r.a builder = r.builder();
        builder.f3043a = new gb(this);
        builder.f3045c = new c[]{zza.zzd};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<Boolean> isEnabled() {
        r.a builder = r.builder();
        builder.f3043a = new f(this);
        builder.f3045c = new c[]{zza.zzb};
        return doRead(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<Void> provideDiagnosisKeys(DiagnosisKeyFileProvider diagnosisKeyFileProvider) {
        r.a builder = r.builder();
        builder.f3043a = new g(this, diagnosisKeyFileProvider);
        builder.f3045c = new c[]{zza.zzi};
        return doWrite(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<Void> provideDiagnosisKeys(List<File> list) {
        return provideDiagnosisKeys(list, new ExposureConfiguration.ExposureConfigurationBuilder().build(), ExposureNotificationClient.TOKEN_A);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<Void> setDiagnosisKeysDataMapping(DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        r.a builder = r.builder();
        builder.f3043a = new hb(diagnosisKeysDataMapping);
        builder.f3045c = new c[]{zza.zzh};
        return doWrite(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<Void> start() {
        r.a builder = r.builder();
        builder.f3043a = eb.f3553a;
        builder.f3045c = new c[]{zza.zzb};
        return doWrite(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<Void> stop() {
        r.a builder = r.builder();
        builder.f3043a = c.f3521a;
        builder.f3045c = new c[]{zza.zzb};
        return doWrite(builder.a());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final i<Void> provideDiagnosisKeys(List<File> list, ExposureConfiguration exposureConfiguration, String str) {
        r.a builder = r.builder();
        builder.f3043a = new h(this, list, exposureConfiguration, str);
        builder.f3045c = new c[]{zza.zzb};
        return doWrite(builder.a());
    }
}
