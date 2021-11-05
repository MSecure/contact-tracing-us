package gov.nc.dhhs.exposurenotification.nearby;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import b.z.c;
import b.z.f;
import b.z.n;
import b.z.q;
import b.z.y.g;
import b.z.y.k;
import c.b.a.a.c.k.b;
import c.b.b.c.a;
import c.b.b.e.a.l;
import c.b.b.e.a.s;
import c.b.b.e.a.u;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import d.a.a.a.f.e;
import d.a.a.a.f.h;
import d.a.a.a.f.j;
import d.a.a.a.f.m;
import e.b.f.c;
import e.b.h.i;
import e.c.a.c;
import gov.nc.dhhs.exposurenotification.common.AppExecutors;
import gov.nc.dhhs.exposurenotification.common.NotificationHelper;
import gov.nc.dhhs.exposurenotification.common.TaskToFutureAdapter;
import gov.nc.dhhs.exposurenotification.network.DiagnosisKeys;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;
import gov.nc.dhhs.exposurenotification.storage.TokenEntity;
import gov.nc.dhhs.exposurenotification.storage.TokenRepository;
import gov.nc.dhhs.exposurenotification.utils.CustomUtility;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ProvideDiagnosisKeysWorker extends ListenableWorker {
    public static final a BASE64_LOWER = a.f3351a;
    public static final c DEFAULT_API_TIMEOUT = c.k(15);
    public static final c GET_DIAGNOSIS_KEY_DATA_MAPPING_TIMEOUT = c.k(10);
    public static final int RANDOM_TOKEN_BYTE_LENGTH = 32;
    public static final c SET_DIAGNOSIS_KEY_DATA_MAPPING_TIMEOUT = c.k(10);
    public static final String TAG = "ProvideDiagnosisKeysWkr";
    public static final String WORKER_NAME = "ProvideDiagnosisKeysWorker";
    public final Context context;
    public final DiagnosisKeys diagnosisKeys;
    public double localAppVersion;
    public double playStoreVersion;
    public final SecureRandom secureRandom = new SecureRandom();
    public final DiagnosisKeyFileSubmitter submitter;
    public final TokenRepository tokenRepository;
    public String versionName;

    public static class NotEnabledException extends Exception {
        public NotEnabledException() {
        }
    }

    public static class VersionChecker extends AsyncTask<String, String, String> {
        public String doInBackground(String... strArr) {
            try {
                e.b.f.c cVar = (e.b.f.c) c.b.a.a.c.n.c.D("https://play.google.com/store/apps/details?id=gov.nc.dhhs.exposurenotification");
                c.C0114c cVar2 = (c.C0114c) cVar.f4810a;
                i iVar = null;
                if (cVar2 != null) {
                    c.b.a.a.c.n.c.u1(true, "Timeout milliseconds must be 0 (infinite) or greater");
                    cVar2.f4816e = 30000;
                    c.b.a.a.c.n.c.K1("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6", "User agent must not be null");
                    ((c.b) cVar.f4810a).f("User-Agent", "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6");
                    c.b.a.a.c.n.c.K1("http://www.google.com", "Referrer must not be null");
                    ((c.b) cVar.f4810a).f("Referer", "http://www.google.com");
                    e.b.j.c N = cVar.b().N("div.hAyfc:nth-child(4) > span:nth-child(2) > div:nth-child(1) > span:nth-child(1)");
                    if (!N.isEmpty()) {
                        iVar = (i) N.get(0);
                    }
                    return iVar.K();
                }
                throw null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    public ProvideDiagnosisKeysWorker(Context context2, WorkerParameters workerParameters) {
        super(context2, workerParameters);
        this.diagnosisKeys = new DiagnosisKeys(context2);
        this.submitter = new DiagnosisKeyFileSubmitter(context2);
        this.context = context2;
        this.tokenRepository = new TokenRepository(context2);
    }

    public static u b(Exception exc) {
        if (exc instanceof NotEnabledException) {
            return new s.a(new NotEnabledException());
        }
        return s.f3411c;
    }

    /* JADX DEBUG: Type inference failed for r5v4. Raw type applied. Possible types: c.b.b.e.a.u<?>, c.b.b.e.a.u<java.lang.Void> */
    /* access modifiers changed from: private */
    public u<Void> checkDiagnosisKeyDataMappingForUpdate(DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        ExposureNotificationClientWrapper exposureNotificationClientWrapper = ExposureNotificationClientWrapper.get(getApplicationContext());
        DiagnosisKeysDataMapping diagnosisKeysDataMapping2 = exposureNotificationClientWrapper.getDiagnosisKeysDataMapping2();
        if (diagnosisKeysDataMapping.equals(diagnosisKeysDataMapping2)) {
            return s.f3411c;
        }
        return TaskToFutureAdapter.getFutureWithTimeout(exposureNotificationClientWrapper.setDiagnosisKeysDataMapping(diagnosisKeysDataMapping2), SET_DIAGNOSIS_KEY_DATA_MAPPING_TIMEOUT.f4964b, TimeUnit.SECONDS, AppExecutors.getScheduledExecutor());
    }

    private String generateRandomToken() {
        byte[] bArr = new byte[32];
        this.secureRandom.nextBytes(bArr);
        return BASE64_LOWER.c(bArr);
    }

    public static ListenableWorker.a i(NotEnabledException notEnabledException) {
        return new ListenableWorker.a.c();
    }

    public static ListenableWorker.a j(Exception exc) {
        if (!(exc instanceof b)) {
            CustomUtility.customLogger("A_CW_ERROR while downloading");
        }
        return new ListenableWorker.a.C0004a();
    }

    public static void scheduleDailyProvideDiagnosisKeys(Context context2) {
        k b2 = k.b(context2);
        q.a aVar = new q.a(ProvideDiagnosisKeysWorker.class, (long) 6, TimeUnit.HOURS);
        c.a aVar2 = new c.a();
        aVar2.f1906d = true;
        aVar2.f1904b = false;
        aVar2.f1905c = n.CONNECTED;
        aVar.f1941c.j = new b.z.c(aVar2);
        q qVar = (q) aVar.a();
        if (b2 != null) {
            new g(b2, WORKER_NAME, f.REPLACE, Collections.singletonList(qVar), null).a();
            return;
        }
        throw null;
    }

    public u a(Boolean bool) {
        return bool.booleanValue() ? TaskToFutureAdapter.getFutureWithTimeout(ExposureNotificationClientWrapper.get(getApplicationContext()).getDiagnosisKeysDataMapping(), GET_DIAGNOSIS_KEY_DATA_MAPPING_TIMEOUT.f4964b, TimeUnit.SECONDS, AppExecutors.getScheduledExecutor()) : c.b.a.a.c.n.c.j1(new NotEnabledException());
    }

    public /* synthetic */ u d(Void r1) {
        return this.diagnosisKeys.download();
    }

    public /* synthetic */ u f(String str, c.b.b.b.c cVar) {
        return this.submitter.submitFiles(cVar, str);
    }

    public /* synthetic */ u g(String str, Object obj) {
        return this.tokenRepository.upsertAsync(TokenEntity.create(str, false));
    }

    public ListenableWorker.a h(Void r3) {
        new ExposureNotificationSharedPreferences(getApplicationContext()).setLastExposure(Long.valueOf(System.currentTimeMillis()));
        return new ListenableWorker.a.c();
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> startWork() {
        ExposureNotificationSharedPreferences exposureNotificationSharedPreferences = new ExposureNotificationSharedPreferences(this.context);
        try {
            String substring = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName.substring(0, 3);
            this.versionName = substring;
            this.localAppVersion = Double.parseDouble(substring);
            if (!((String) new VersionChecker().execute(new String[0]).get()).equals("")) {
                this.playStoreVersion = Double.parseDouble((String) new VersionChecker().execute(new String[0]).get());
            }
        } catch (PackageManager.NameNotFoundException | InterruptedException | ExecutionException e2) {
            e2.printStackTrace();
        }
        if (this.playStoreVersion - this.localAppVersion > 0.0d && !exposureNotificationSharedPreferences.getUpdateNotificationShown(false)) {
            NotificationHelper.showUpdateNotification(this.context);
            exposureNotificationSharedPreferences.setUpdateNotificationShown(true);
            exposureNotificationSharedPreferences.setVersionNumber(this.playStoreVersion + "");
        }
        if (!exposureNotificationSharedPreferences.getVersionNumber("").isEmpty() && Double.parseDouble(exposureNotificationSharedPreferences.getVersionNumber("1.0")) < this.playStoreVersion) {
            NotificationHelper.showUpdateNotification(this.context);
            exposureNotificationSharedPreferences.setVersionNumber(this.playStoreVersion + "");
        }
        String generateRandomToken = generateRandomToken();
        return ((l) c.b.b.e.a.a.x(l.s(TaskToFutureAdapter.getFutureWithTimeout(ExposureNotificationClientWrapper.get(getApplicationContext()).isEnabled(), DEFAULT_API_TIMEOUT.p(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor())).u(new d.a.a.a.f.i(this), AppExecutors.getBackgroundExecutor()).u(new d.a.a.a.f.l(this), AppExecutors.getBackgroundExecutor()), Exception.class, d.a.a.a.f.g.f4650a, AppExecutors.getBackgroundExecutor())).u(new h(this), AppExecutors.getBackgroundExecutor()).u(new d.a.a.a.f.f(this, generateRandomToken), AppExecutors.getBackgroundExecutor()).u(new j(this, generateRandomToken), AppExecutors.getBackgroundExecutor()).t(new m(this), AppExecutors.getLightweightExecutor()).q(NotEnabledException.class, e.f4647a, AppExecutors.getBackgroundExecutor()).q(Exception.class, d.a.a.a.f.k.f4655a, AppExecutors.getBackgroundExecutor());
    }
}
