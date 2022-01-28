package gov.nc.dhhs.exposurenotification.network;

import android.content.Context;
import c.b.b.b.c;
import c.b.b.e.a.u;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;
import gov.nc.dhhs.exposurenotification.utils.CustomUtility;

public class DiagnosisKeys {
    public static final String TAG = "DiagnosisKeys";
    public final DiagnosisKeyDownloader diagnosisKeyDownloader;
    public final DiagnosisKeyUploader diagnosisKeyUploader;
    public final FakeDiagnosisKeyDownloader fakeDiagnosisKeyDownloader;
    public final FakeDiagnosisKeyUploader fakeDiagnosisKeyUploader;
    public final ExposureNotificationSharedPreferences preferences;

    /* renamed from: gov.nc.dhhs.exposurenotification.network.DiagnosisKeys$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$gov$nc$dhhs$exposurenotification$storage$ExposureNotificationSharedPreferences$NetworkMode;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            int[] iArr = new int[ExposureNotificationSharedPreferences.NetworkMode.values().length];
            $SwitchMap$gov$nc$dhhs$exposurenotification$storage$ExposureNotificationSharedPreferences$NetworkMode = iArr;
            ExposureNotificationSharedPreferences.NetworkMode networkMode = ExposureNotificationSharedPreferences.NetworkMode.FAKE;
            iArr[1] = 1;
            try {
                int[] iArr2 = $SwitchMap$gov$nc$dhhs$exposurenotification$storage$ExposureNotificationSharedPreferences$NetworkMode;
                ExposureNotificationSharedPreferences.NetworkMode networkMode2 = ExposureNotificationSharedPreferences.NetworkMode.TEST;
                iArr2[0] = 2;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public DiagnosisKeys(Context context) {
        this.diagnosisKeyDownloader = new DiagnosisKeyDownloader(context.getApplicationContext());
        this.diagnosisKeyUploader = new DiagnosisKeyUploader(context.getApplicationContext());
        this.fakeDiagnosisKeyDownloader = new FakeDiagnosisKeyDownloader(context.getApplicationContext());
        this.fakeDiagnosisKeyUploader = new FakeDiagnosisKeyUploader(context.getApplicationContext());
        this.preferences = new ExposureNotificationSharedPreferences(context.getApplicationContext());
    }

    public u<c<KeyFileBatch>> download() {
        ExposureNotificationSharedPreferences.NetworkMode networkMode = this.preferences.getNetworkMode(ExposureNotificationSharedPreferences.NetworkMode.TEST);
        int ordinal = networkMode.ordinal();
        if (ordinal == 0) {
            CustomUtility.customLogger("Using real: DiagnosisKeyDownloader");
        } else if (ordinal != 1) {
            throw new IllegalArgumentException("Unsupported network mode: " + networkMode);
        }
        return this.diagnosisKeyDownloader.download();
    }

    public u<?> upload(c<DiagnosisKey> cVar) {
        ExposureNotificationSharedPreferences.NetworkMode networkMode = this.preferences.getNetworkMode(ExposureNotificationSharedPreferences.NetworkMode.TEST);
        int ordinal = networkMode.ordinal();
        if (ordinal == 0) {
            CustomUtility.customLogger("Using real: DiagnosisKeyUploader");
            return this.diagnosisKeyUploader.upload(cVar);
        } else if (ordinal == 1) {
            return this.fakeDiagnosisKeyUploader.upload(cVar);
        } else {
            throw new IllegalArgumentException("Unsupported network mode: " + networkMode);
        }
    }
}
