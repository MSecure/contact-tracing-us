package com.proudcrowd.exposure.datasource;

import android.os.Build;
import com.proudcrowd.exposure.core.ExposureApplication;
import com.proudcrowd.exposure.datamodel.ScanPostDetail;
import retrofit2.Call;

public class ScanPostDataSource extends BaseFuturesDataSource<Boolean> {
    public static final int AUTHORIZATION_SCAN_PHASE = 0;
    public static final int DOWNLOAD_SCAN_PHASE = 1;
    public static final int KEY_MATCH_SCAN_PHASE = 3;
    private static final String TAG = "ScanPostDataSource";
    public static final int UNZIP_SCAN_PHASE = 2;
    private final ExposureApplication mAppContext;
    private final ScanPostDetail mPostModel;

    public ScanPostDataSource(ExposureApplication exposureApplication, boolean z, int i, String str) {
        this.mAppContext = exposureApplication;
        ScanPostDetail scanPostDetail = new ScanPostDetail();
        this.mPostModel = scanPostDetail;
        scanPostDetail.isSuccess = z;
        scanPostDetail.scanPhase = i;
        scanPostDetail.errorMessage = str;
        scanPostDetail.osVersion = String.valueOf(Build.VERSION.SDK_INT);
        scanPostDetail.appVersion = exposureApplication.mAppVersion;
    }

    /* access modifiers changed from: protected */
    @Override // com.proudcrowd.exposure.datasource.BaseFuturesDataSource
    public Call<Boolean> CallApi() {
        return ((BaseFuturesDataSource) this).GetDataApi.ScanPost(2, this.mAppContext.mDeviceGuid, this.mPostModel);
    }

    public static void Execute(ExposureApplication exposureApplication, boolean z, int i, String str) {
        new ScanPostDataSource(exposureApplication, z, i, str).ExecuteRequest();
    }
}
