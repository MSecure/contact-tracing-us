package com.proudcrowd.exposure.datasource;

import android.content.Context;
import android.net.Uri;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.NoCache;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.proudcrowd.exposure.core.DiagnosisKey;
import com.proudcrowd.exposure.core.ExposureApplication;
import com.proudcrowd.exposure.datamodel.DiagnosisKeyFile;
import java.util.Collection;

public class ExposureManagerDataSource {
    private static final String REGION_CODE = "US";
    private static final String TAG = "ExposureManagerDataSource";
    private static RequestQueue httpRequestQueue;
    private final ExposureApplication applicationContext;
    private final ExposureDownloadDataSource diagnosisKeyDownloader;
    private final ExposureUploadDataSource diagnosisKeyUploader;

    public ExposureManagerDataSource(Context context) {
        ExposureApplication exposureApplication = (ExposureApplication) context.getApplicationContext();
        this.applicationContext = exposureApplication;
        this.diagnosisKeyDownloader = new ExposureDownloadDataSource(exposureApplication, getHttpRequestQueue(exposureApplication), REGION_CODE);
        this.diagnosisKeyUploader = new ExposureUploadDataSource(exposureApplication, getHttpRequestQueue(exposureApplication), REGION_CODE);
    }

    public ListenableFuture<String> downloadIndex(Uri uri) {
        return this.diagnosisKeyDownloader.executeIndex(uri);
    }

    public ListenableFuture<ImmutableList<DiagnosisKeyFile>> download(Uri uri, Collection<String> collection) {
        return this.diagnosisKeyDownloader.execute(uri, collection);
    }

    public ListenableFuture<?> upload(Uri uri, ImmutableList<DiagnosisKey> immutableList) {
        return this.diagnosisKeyUploader.execute(uri, immutableList);
    }

    public ListenableFuture<?> uploadFakeKeys(Uri uri, ImmutableList<DiagnosisKey> immutableList) {
        return this.diagnosisKeyUploader.executeFakeTraffic(uri, immutableList);
    }

    private static RequestQueue getHttpRequestQueue(Context context) {
        if (httpRequestQueue == null) {
            RequestQueue requestQueue = new RequestQueue(new NoCache(), new BasicNetwork((BaseHttpStack) new HurlStack()));
            httpRequestQueue = requestQueue;
            requestQueue.start();
        }
        return httpRequestQueue;
    }

    public boolean isUsingTestKeyService(Uri uri) {
        return uri.toString().startsWith("https://storage.googleapis.com/exposure-notification-export-lmuvk");
    }
}
