package com.proudcrowd.exposure.datasource;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.app.NotificationCompat;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.io.BaseEncoding;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.proudcrowd.exposure.core.ExposureApplication;
import com.proudcrowd.exposure.datamodel.DiagnosisKeyFile;
import com.proudcrowd.exposure.datasource.ExposureDownloadDataSource;
import com.proudcrowd.exposure.misc.AppExecutors;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.threeten.bp.Duration;

public class ExposureDownloadDataSource {
    private static final BaseEncoding BASE32 = BaseEncoding.base32().lowerCase().omitPadding();
    private static final Pattern BATCH_NUM_PATTERN = Pattern.compile("(.*)/([0-9]+)-([0-9]+-)?[0-9]+.zip");
    private static final Duration DOWNLOAD_ALL_FILES_TIMEOUT = Duration.ofMinutes(30);
    private static final String FILE_PATTERN;
    private static final SecureRandom RAND = new SecureRandom();
    private static final String TAG;
    private final ExposureApplication applicationContext;
    private final DownloadManager downloadManager;
    private final ConcurrentMap<Long, Download> downloadMap = new ConcurrentHashMap();
    private final BroadcastReceiver downloadStatusReceiver = new BroadcastReceiver() {
        /* class com.proudcrowd.exposure.datasource.ExposureDownloadDataSource.AnonymousClass1 */

        public void onReceive(Context context, Intent intent) {
            AppExecutors.getBackgroundExecutor().submit((Runnable) new Runnable(intent, context) {
                /* class com.proudcrowd.exposure.datasource.$$Lambda$ExposureDownloadDataSource$1$GG14J3Niq8tjeTwSXmPX3PtCv4 */
                public final /* synthetic */ Intent f$1;
                public final /* synthetic */ Context f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    ExposureDownloadDataSource.AnonymousClass1.this.lambda$onReceive$0$ExposureDownloadDataSource$1(this.f$1, this.f$2);
                }
            });
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d4, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d5, code lost:
            if (r2 != null) goto L_0x00d7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r2.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00db, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00dc, code lost:
            r11.addSuppressed(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00df, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0108, code lost:
            r11 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0109, code lost:
            if (r0 != null) goto L_0x010b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            r0.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x010f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0110, code lost:
            r10.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0113, code lost:
            throw r11;
         */
        public /* synthetic */ void lambda$onReceive$0$ExposureDownloadDataSource$1(Intent intent, Context context) {
            if ("android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
                long longExtra = intent.getLongExtra("extra_download_id", -1);
                if (longExtra != -1 && ExposureDownloadDataSource.this.downloadMap.containsKey(Long.valueOf(longExtra))) {
                    Download download = (Download) ExposureDownloadDataSource.this.downloadMap.get(Long.valueOf(longExtra));
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(longExtra);
                    Cursor query2 = ExposureDownloadDataSource.this.downloadManager.query(query);
                    if (query2.moveToFirst()) {
                        if (8 == query2.getInt(query2.getColumnIndex(NotificationCompat.CATEGORY_STATUS))) {
                            try {
                                InputStream openInputStream = context.getContentResolver().openInputStream(ExposureDownloadDataSource.this.downloadManager.getUriForDownloadedFile(download.downloadId));
                                String format = String.format(ExposureDownloadDataSource.FILE_PATTERN, download.dir, Long.valueOf(longExtra));
                                File file = new File(context.getFilesDir(), format);
                                FileUtils.copyInputStreamToFile(openInputStream, file);
                                download.succeed(file);
                                ExposureDownloadDataSource.this.downloadManager.remove(longExtra);
                                String str = ExposureDownloadDataSource.TAG;
                                Log.d(str, "Downloaded file: " + format);
                                if (openInputStream != null) {
                                    openInputStream.close();
                                }
                            } catch (IOException | NullPointerException e) {
                                download.fail(e);
                            }
                        } else {
                            download.fileFuture.setException(new FileNotFoundException());
                        }
                        if (query2 != null) {
                            query2.close();
                        }
                        ExposureDownloadDataSource.this.downloadMap.remove(Long.valueOf(longExtra));
                    } else if (query2 != null) {
                        query2.close();
                    }
                }
            }
        }
    };
    private final RequestQueue httpRequestQueue;
    private FutureCallback<ImmutableList<DiagnosisKeyFile>> logBatchesDownloadOutcome = new FutureCallback<ImmutableList<DiagnosisKeyFile>>() {
        /* class com.proudcrowd.exposure.datasource.ExposureDownloadDataSource.AnonymousClass2 */

        public void onSuccess(ImmutableList<DiagnosisKeyFile> immutableList) {
            String str = ExposureDownloadDataSource.TAG;
            Log.i(str, "All key files successfully downloaded. Batch count: " + immutableList.size());
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
            Log.e(ExposureDownloadDataSource.TAG, "Download of key files failed.");
        }
    };
    private final String regionCode;

    ExposureDownloadDataSource(ExposureApplication exposureApplication, RequestQueue requestQueue, String str) {
        this.applicationContext = exposureApplication;
        this.httpRequestQueue = requestQueue;
        this.regionCode = str;
        this.downloadManager = (DownloadManager) exposureApplication.getSystemService("download");
    }

    public ListenableFuture<String> executeIndex(Uri uri) {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(uri) {
            /* class com.proudcrowd.exposure.datasource.$$Lambda$ExposureDownloadDataSource$LMJMCPw1t7THpF9mKivpdg9mz3o */
            public final /* synthetic */ Uri f$1;

            {
                this.f$1 = r2;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return ExposureDownloadDataSource.this.lambda$executeIndex$1$ExposureDownloadDataSource(this.f$1, completer);
            }
        });
    }

    public /* synthetic */ Object lambda$executeIndex$1$ExposureDownloadDataSource(Uri uri, CallbackToFutureAdapter.Completer completer) {
        completer.getClass();
        $$Lambda$OXUTY5dquqgq_dIKlkLgzxDZnY r0 = new Response.Listener() {
            /* class com.proudcrowd.exposure.datasource.$$Lambda$OXUTY5dquqgq_dIKlkLgzxDZnY */

            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                CallbackToFutureAdapter.Completer.this.set((String) obj);
            }
        };
        $$Lambda$ExposureDownloadDataSource$O2HCw81RcTEZAV7VzSTazdaHKa0 r1 = new Response.ErrorListener() {
            /* class com.proudcrowd.exposure.datasource.$$Lambda$ExposureDownloadDataSource$O2HCw81RcTEZAV7VzSTazdaHKa0 */

            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                ExposureDownloadDataSource.lambda$null$0(CallbackToFutureAdapter.Completer.this, volleyError);
            }
        };
        String str = TAG;
        Log.d(str, "Getting index file. Uri: " + uri);
        StringRequest stringRequest = new StringRequest(uri.toString(), r0, r1);
        stringRequest.setShouldCache(false);
        this.httpRequestQueue.add(stringRequest);
        return stringRequest;
    }

    static /* synthetic */ void lambda$null$0(CallbackToFutureAdapter.Completer completer, VolleyError volleyError) {
        String str = TAG;
        Log.e(str, "Error getting key file index. " + volleyError.getMessage());
        completer.setCancelled();
    }

    public ListenableFuture<ImmutableList<DiagnosisKeyFile>> execute(Uri uri, Collection<String> collection) {
        this.applicationContext.registerReceiver(this.downloadStatusReceiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        FluentFuture withTimeout = FluentFuture.from(initiateDownloads(getDiagnosisKeyFileUrls(uri, collection), randDirname())).transform(new Function() {
            /* class com.proudcrowd.exposure.datasource.$$Lambda$ExposureDownloadDataSource$0pMCbJl0MI_Q1o0t0EB8e4WpU4Q */

            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ExposureDownloadDataSource.lambda$0pMCbJl0MI_Q1o0t0EB8e4WpU4Q(ExposureDownloadDataSource.this, (List) obj);
            }
        }, AppExecutors.getBackgroundExecutor()).withTimeout(DOWNLOAD_ALL_FILES_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor());
        Futures.addCallback(withTimeout, this.logBatchesDownloadOutcome, AppExecutors.getLightweightExecutor());
        withTimeout.addListener(new Runnable() {
            /* class com.proudcrowd.exposure.datasource.$$Lambda$ExposureDownloadDataSource$YPDEQQovrNTEi5qrLzMFhOlQ0s */

            public final void run() {
                ExposureDownloadDataSource.this.lambda$execute$2$ExposureDownloadDataSource();
            }
        }, AppExecutors.getLightweightExecutor());
        return withTimeout;
    }

    public /* synthetic */ void lambda$execute$2$ExposureDownloadDataSource() {
        this.applicationContext.unregisterReceiver(this.downloadStatusReceiver);
    }

    private ImmutableList<DiagnosisKeyFile> getDiagnosisKeyFileUrls(Uri uri, Collection<String> collection) {
        HashMap hashMap = new HashMap();
        for (String str : collection) {
            Matcher matcher = BATCH_NUM_PATTERN.matcher(str);
            if (!matcher.matches() || matcher.group(2) == null) {
                throw new RuntimeException("Failed to parse batch num from File [" + str + "].");
            }
            long parseLong = Long.parseLong(matcher.group(2));
            if (!hashMap.containsKey(Long.valueOf(parseLong))) {
                hashMap.put(Long.valueOf(parseLong), new ArrayList());
            }
            ((List) hashMap.get(Long.valueOf(parseLong))).add(uri.buildUpon().appendEncodedPath(str).build());
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Map.Entry entry : hashMap.entrySet()) {
            new ArrayList();
            builder.add((Object) DiagnosisKeyFile.ofUris(this.regionCode, ((Long) entry.getKey()).longValue(), (Collection) entry.getValue()));
        }
        return builder.build();
    }

    private ListenableFuture<List<BatchFile>> initiateDownloads(List<DiagnosisKeyFile> list, String str) {
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (DiagnosisKeyFile diagnosisKeyFile : list) {
            i++;
            Log.i(TAG, "Requesting download of key file batch. File count: " + diagnosisKeyFile.uris().size() + ". Batch: " + i + "/" + size);
            ArrayList arrayList2 = new ArrayList();
            UnmodifiableIterator<Uri> it = diagnosisKeyFile.uris().iterator();
            while (it.hasNext()) {
                long enqueue = this.downloadManager.enqueue(new DownloadManager.Request(it.next()).setDestinationUri(Uri.fromFile(this.applicationContext.getExternalFilesDir(null))).setNotificationVisibility(0).setMimeType("application/octet-stream").setTitle("Exposure Notifications Check").setDescription("Exposure Notifications Check"));
                Download download = new Download(diagnosisKeyFile, enqueue, str);
                arrayList2.add(download.fileFuture);
                this.downloadMap.put(Long.valueOf(enqueue), download);
            }
            arrayList.addAll(arrayList2);
        }
        return Futures.allAsList(arrayList);
    }

    /* access modifiers changed from: public */
    private ImmutableList<DiagnosisKeyFile> groupAsBatches(List<BatchFile> list) {
        HashMap hashMap = new HashMap();
        for (BatchFile batchFile : list) {
            if (!hashMap.containsKey(batchFile.batch)) {
                hashMap.put(batchFile.batch, new ArrayList());
            }
            ((List) hashMap.get(batchFile.batch)).add(batchFile.file);
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Map.Entry entry : hashMap.entrySet()) {
            builder.add((Object) ((DiagnosisKeyFile) entry.getKey()).copyWith((List) entry.getValue()));
        }
        return builder.build();
    }

    private static String randDirname() {
        byte[] bArr = new byte[8];
        RAND.nextBytes(bArr);
        return BASE32.encode(bArr);
    }

    public static class BatchFile {
        private final DiagnosisKeyFile batch;
        private final File file;

        private BatchFile(DiagnosisKeyFile diagnosisKeyFile, File file2) {
            this.batch = diagnosisKeyFile;
            this.file = file2;
        }
    }

    public static class Download {
        private final DiagnosisKeyFile batch;
        private final String dir;
        private final long downloadId;
        private final SettableFuture<BatchFile> fileFuture;

        private Download(DiagnosisKeyFile diagnosisKeyFile, long j, String str) {
            this.fileFuture = SettableFuture.create();
            this.batch = diagnosisKeyFile;
            this.downloadId = j;
            this.dir = str;
        }

        private void succeed(File file) {
            this.fileFuture.set(new BatchFile(this.batch, file));
        }

        private void fail(Throwable th) {
            this.fileFuture.setException(th);
        }
    }
}
