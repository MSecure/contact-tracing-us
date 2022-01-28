package com.proudcrowd.exposure.datasource;

import com.proudcrowd.exposure.core.ExposureApplication;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import retrofit2.Call;

public class DeviceExposureDataSource extends BaseFuturesDataSource<Boolean> {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    private static final String TAG = "DeviceExposureDataSource";
    private final String mDeviceGuid;
    private final String mExposureDate;

    public DeviceExposureDataSource(String str, Date date) {
        this.mDeviceGuid = str;
        this.mExposureDate = DATE_FORMAT.format(date);
    }

    /* access modifiers changed from: protected */
    @Override // com.proudcrowd.exposure.datasource.BaseFuturesDataSource
    public Call<Boolean> CallApi() {
        return ((BaseFuturesDataSource) this).GetDataApi.DeviceExposurePost(2, this.mDeviceGuid, this.mExposureDate, ExposureApplication.TEK_SERVER_VERSION);
    }
}
