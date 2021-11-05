package gov.michigan.MiCovidExposure.nearby;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import b.b0.c;
import b.b0.f;
import b.b0.m;
import b.b0.n;
import b.b0.p;
import b.b0.q;
import b.b0.v;
import b.b0.y.g;
import b.b0.y.k;
import b.x.t;
import c.b.a.a.d.k.b;
import c.b.b.c.a;
import c.b.b.e.a.l;
import c.b.b.e.a.s;
import c.b.b.e.a.u;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.a.a.d.e;
import e.a.a.d.h;
import e.a.a.d.i;
import e.a.a.d.j;
import g.b.a.c;
import gov.michigan.MiCovidExposure.common.AppExecutors;
import gov.michigan.MiCovidExposure.common.TaskToFutureAdapter;
import gov.michigan.MiCovidExposure.network.DiagnosisKeys;
import gov.michigan.MiCovidExposure.storage.ExposureNotificationSharedPreferences;
import gov.michigan.MiCovidExposure.storage.TokenEntity;
import gov.michigan.MiCovidExposure.storage.TokenRepository;
import gov.michigan.MiCovidExposure.utils.CustomUtility;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class ProvideDiagnosisKeysWorker extends ListenableWorker {
    public static final a BASE64_LOWER = a.f4692a;
    public static final c DEFAULT_API_TIMEOUT = c.m(15);
    public static final c GET_DIAGNOSIS_KEY_DATA_MAPPING_TIMEOUT = c.m(10);
    public static final int RANDOM_TOKEN_BYTE_LENGTH = 32;
    public static final c SET_DIAGNOSIS_KEY_DATA_MAPPING_TIMEOUT = c.m(10);
    public static final String TAG = "ProvideDiagnosisKeysWkr";
    public static final String WORKER_NAME = "ProvideDiagnosisKeysWorker";
    public final DiagnosisKeys diagnosisKeys;
    public final SecureRandom secureRandom = new SecureRandom();
    public final DiagnosisKeyFileSubmitter submitter;
    public final TokenRepository tokenRepository;

    public static class NotEnabledException extends Exception {
        public NotEnabledException() {
        }
    }

    public ProvideDiagnosisKeysWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.diagnosisKeys = new DiagnosisKeys(context);
        this.submitter = new DiagnosisKeyFileSubmitter(context);
        this.tokenRepository = new TokenRepository(context);
    }

    /* JADX DEBUG: Type inference failed for r5v4. Raw type applied. Possible types: c.b.b.e.a.u<?>, c.b.b.e.a.u<java.lang.Void> */
    /* access modifiers changed from: private */
    public u<Void> checkDiagnosisKeyDataMappingForUpdate(DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        ExposureNotificationClientWrapper exposureNotificationClientWrapper = ExposureNotificationClientWrapper.get(getApplicationContext());
        DiagnosisKeysDataMapping diagnosisKeysDataMapping2 = exposureNotificationClientWrapper.getDiagnosisKeysDataMapping2();
        if (diagnosisKeysDataMapping.equals(diagnosisKeysDataMapping2)) {
            return s.f4761c;
        }
        return TaskToFutureAdapter.getFutureWithTimeout(exposureNotificationClientWrapper.setDiagnosisKeysDataMapping(diagnosisKeysDataMapping2), SET_DIAGNOSIS_KEY_DATA_MAPPING_TIMEOUT.f6401b, TimeUnit.SECONDS, AppExecutors.getScheduledExecutor());
    }

    public static u d(Exception exc) {
        if (exc instanceof NotEnabledException) {
            return new s.a(new NotEnabledException());
        }
        return s.f4761c;
    }

    private String generateRandomToken() {
        byte[] bArr = new byte[32];
        this.secureRandom.nextBytes(bArr);
        return BASE64_LOWER.c(bArr);
    }

    public static ListenableWorker.a j(NotEnabledException notEnabledException) {
        CustomUtility.customLogger("A_CW_ERROR Got NotEnabledException, but continuing " + notEnabledException);
        return new ListenableWorker.a.c();
    }

    public static ListenableWorker.a k(Exception exc) {
        if (!(exc instanceof b)) {
            CustomUtility.customLogger("A_CW_ERROR while downloading");
        }
        return new ListenableWorker.a.C0005a();
    }

    public static p scheduleDailyProvideDiagnosisKeys(v vVar) {
        q.a aVar = new q.a(ProvideDiagnosisKeysWorker.class, (long) 6, TimeUnit.HOURS);
        c.a aVar2 = new c.a();
        aVar2.f1019d = false;
        aVar2.f1017b = false;
        aVar2.f1017b = false;
        aVar2.f1018c = n.CONNECTED;
        b.b0.c cVar = new b.b0.c(aVar2);
        b.b0.y.r.p pVar = aVar.f1061c;
        pVar.j = cVar;
        b.b0.a aVar3 = b.b0.a.EXPONENTIAL;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        aVar.f1059a = true;
        pVar.l = aVar3;
        long millis = timeUnit.toMillis(30000);
        if (millis > 18000000) {
            m.c().f(b.b0.y.r.p.r, "Backoff delay duration exceeds maximum value", new Throwable[0]);
            millis = 18000000;
        }
        if (millis < 10000) {
            m.c().f(b.b0.y.r.p.r, "Backoff delay duration less than minimum value", new Throwable[0]);
            millis = 10000;
        }
        pVar.m = millis;
        q qVar = (q) aVar.a();
        k kVar = (k) vVar;
        if (kVar != null) {
            return new g(kVar, WORKER_NAME, f.KEEP, Collections.singletonList(qVar), null).a();
        }
        throw null;
    }

    public u b(Boolean bool) {
        return bool.booleanValue() ? TaskToFutureAdapter.getFutureWithTimeout(ExposureNotificationClientWrapper.get(getApplicationContext()).getDiagnosisKeysDataMapping(), GET_DIAGNOSIS_KEY_DATA_MAPPING_TIMEOUT.f6401b, TimeUnit.SECONDS, AppExecutors.getScheduledExecutor()) : t.M1(new NotEnabledException());
    }

    public /* synthetic */ u f(Void r1) {
        return this.diagnosisKeys.download();
    }

    public /* synthetic */ u g(String str, c.b.b.b.c cVar) {
        return this.submitter.submitFiles(cVar, str);
    }

    public /* synthetic */ u h(String str, Object obj) {
        return this.tokenRepository.upsertAsync(TokenEntity.create(str, false));
    }

    public ListenableWorker.a i(Void r3) {
        new ExposureNotificationSharedPreferences(getApplicationContext()).setLastExposure(Long.valueOf(System.currentTimeMillis()));
        return new ListenableWorker.a.c();
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> startWork() {
        CustomUtility.customLogger("A91006 - Starting worker downloading diagnosis key files and submitting them to the API for exposure detection, then storing the token used.");
        String generateRandomToken = generateRandomToken();
        return ((l) c.b.b.e.a.a.x(l.s(TaskToFutureAdapter.getFutureWithTimeout(ExposureNotificationClientWrapper.get(getApplicationContext()).isEnabled(), DEFAULT_API_TIMEOUT.s(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor())).u(new j(this), AppExecutors.getBackgroundExecutor()).u(new e.a.a.d.m(this), AppExecutors.getBackgroundExecutor()), Exception.class, e.f6259a, AppExecutors.getBackgroundExecutor())).u(new h(this), AppExecutors.getBackgroundExecutor()).u(new e.a.a.d.k(this, generateRandomToken), AppExecutors.getBackgroundExecutor()).u(new i(this, generateRandomToken), AppExecutors.getBackgroundExecutor()).t(new e.a.a.d.l(this), AppExecutors.getLightweightExecutor()).q(NotEnabledException.class, e.a.a.d.f.f6260a, AppExecutors.getBackgroundExecutor()).q(Exception.class, e.a.a.d.g.f6261a, AppExecutors.getBackgroundExecutor());
    }
}
