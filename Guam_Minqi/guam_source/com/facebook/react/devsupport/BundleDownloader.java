package com.facebook.react.devsupport;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.devsupport.MultipartStreamReader;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.modules.network.NetworkingModule;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleDownloader {
    public static final int FILES_CHANGED_COUNT_NOT_BUILT_BY_BUNDLER = -2;
    public static final String TAG = "BundleDownloader";
    public final OkHttpClient mClient;
    public Call mDownloadBundleFromURLCall;

    public static class BundleInfo {
        public int mFilesChangedCount;
        public String mUrl;

        public static BundleInfo fromJSONString(String str) {
            if (str == null) {
                return null;
            }
            BundleInfo bundleInfo = new BundleInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                bundleInfo.mUrl = jSONObject.getString("url");
                bundleInfo.mFilesChangedCount = jSONObject.getInt("filesChangedCount");
                return bundleInfo;
            } catch (JSONException e) {
                FLog.e(BundleDownloader.TAG, "Invalid bundle info: ", e);
                return null;
            }
        }

        public int getFilesChangedCount() {
            return this.mFilesChangedCount;
        }

        public String getUrl() {
            String str = this.mUrl;
            return str != null ? str : "unknown";
        }

        public String toJSONString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", this.mUrl);
                jSONObject.put("filesChangedCount", this.mFilesChangedCount);
                return jSONObject.toString();
            } catch (JSONException e) {
                FLog.e(BundleDownloader.TAG, "Can't serialize bundle info: ", e);
                return null;
            }
        }
    }

    public BundleDownloader(OkHttpClient okHttpClient) {
        this.mClient = okHttpClient;
    }

    private String formatBundleUrl(String str) {
        return str;
    }

    public static void populateBundleInfo(String str, Headers headers, BundleInfo bundleInfo) {
        bundleInfo.mUrl = str;
        String str2 = headers.get("X-Metro-Files-Changed-Count");
        if (str2 != null) {
            try {
                bundleInfo.mFilesChangedCount = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                bundleInfo.mFilesChangedCount = -2;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void processBundleResult(String str, int i, Headers headers, BufferedSource bufferedSource, File file, BundleInfo bundleInfo, DevBundleDownloadListener devBundleDownloadListener) throws IOException {
        if (i != 200) {
            String readUtf8 = bufferedSource.readUtf8();
            DebugServerException parse = DebugServerException.parse(str, readUtf8);
            if (parse != null) {
                devBundleDownloadListener.onFailure(parse);
                return;
            }
            devBundleDownloadListener.onFailure(new DebugServerException("The development server returned response error code: " + i + "\n\n" + "URL: " + str + "\n\n" + "Body:\n" + readUtf8));
            return;
        }
        if (bundleInfo != null) {
            populateBundleInfo(str, headers, bundleInfo);
        }
        File file2 = new File(file.getPath() + ".tmp");
        if (!storePlainJSInFile(bufferedSource, file2) || file2.renameTo(file)) {
            devBundleDownloadListener.onSuccess();
            return;
        }
        throw new IOException("Couldn't rename " + file2 + " to " + file);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void processMultipartResponse(final String str, final Response response, String str2, final File file, final BundleInfo bundleInfo, final DevBundleDownloadListener devBundleDownloadListener) throws IOException {
        if (!new MultipartStreamReader(response.body().source(), str2).readAllParts(new MultipartStreamReader.ChunkListener() {
            /* class com.facebook.react.devsupport.BundleDownloader.AnonymousClass2 */

            @Override // com.facebook.react.devsupport.MultipartStreamReader.ChunkListener
            public void onChunkComplete(Map<String, String> map, Buffer buffer, boolean z) throws IOException {
                if (z) {
                    int code = response.code();
                    if (map.containsKey("X-Http-Status")) {
                        code = Integer.parseInt(map.get("X-Http-Status"));
                    }
                    BundleDownloader.this.processBundleResult(str, code, Headers.of(map), buffer, file, bundleInfo, devBundleDownloadListener);
                } else if (map.containsKey("Content-Type") && map.get("Content-Type").equals("application/json")) {
                    try {
                        JSONObject jSONObject = new JSONObject(buffer.readUtf8());
                        Integer num = null;
                        String string = jSONObject.has("status") ? jSONObject.getString("status") : null;
                        Integer valueOf = jSONObject.has("done") ? Integer.valueOf(jSONObject.getInt("done")) : null;
                        if (jSONObject.has("total")) {
                            num = Integer.valueOf(jSONObject.getInt("total"));
                        }
                        devBundleDownloadListener.onProgress(string, valueOf, num);
                    } catch (JSONException e) {
                        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Error parsing progress JSON. ");
                        outline15.append(e.toString());
                        FLog.e("ReactNative", outline15.toString());
                    }
                }
            }

            @Override // com.facebook.react.devsupport.MultipartStreamReader.ChunkListener
            public void onChunkProgress(Map<String, String> map, long j, long j2) throws IOException {
                if ("application/javascript".equals(map.get("Content-Type"))) {
                    devBundleDownloadListener.onProgress("Downloading JavaScript bundle", Integer.valueOf((int) (j / 1024)), Integer.valueOf((int) (j2 / 1024)));
                }
            }
        })) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Error while reading multipart response.\n\nResponse code: ");
            outline15.append(response.code());
            outline15.append("\n\nURL: ");
            outline15.append(str.toString());
            outline15.append("\n\n");
            devBundleDownloadListener.onFailure(new DebugServerException(outline15.toString()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016  */
    public static boolean storePlainJSInFile(BufferedSource bufferedSource, File file) throws IOException {
        Sink sink;
        Throwable th;
        try {
            sink = Okio.sink(file);
            try {
                bufferedSource.readAll(sink);
                r1.close();
                return true;
            } catch (Throwable th2) {
                th = th2;
                if (sink != null) {
                    r1.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            sink = null;
            if (sink != null) {
            }
            throw th;
        }
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleInfo bundleInfo) {
        downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo, new Request.Builder());
    }

    public void downloadBundleFromURL(final DevBundleDownloadListener devBundleDownloadListener, final File file, String str, final BundleInfo bundleInfo, Request.Builder builder) {
        Call newCall = this.mClient.newCall(builder.url(formatBundleUrl(str)).addHeader("Accept", "multipart/mixed").build());
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(newCall);
        Call call = newCall;
        this.mDownloadBundleFromURLCall = call;
        call.enqueue(new Callback() {
            /* class com.facebook.react.devsupport.BundleDownloader.AnonymousClass1 */

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (BundleDownloader.this.mDownloadBundleFromURLCall == null || BundleDownloader.this.mDownloadBundleFromURLCall.isCanceled()) {
                    BundleDownloader.this.mDownloadBundleFromURLCall = null;
                    return;
                }
                BundleDownloader.this.mDownloadBundleFromURLCall = null;
                String httpUrl = call.request().url().toString();
                DevBundleDownloadListener devBundleDownloadListener = devBundleDownloadListener;
                devBundleDownloadListener.onFailure(DebugServerException.makeGeneric(httpUrl, "Could not connect to development server.", "URL: " + httpUrl, iOException));
            }

            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0074, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
                r10.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
                r10 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
                r9.addSuppressed(r10);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x007d, code lost:
                throw r0;
             */
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                if (BundleDownloader.this.mDownloadBundleFromURLCall == null || BundleDownloader.this.mDownloadBundleFromURLCall.isCanceled()) {
                    BundleDownloader.this.mDownloadBundleFromURLCall = null;
                    return;
                }
                BundleDownloader.this.mDownloadBundleFromURLCall = null;
                String httpUrl = response.request().url().toString();
                Matcher matcher = Pattern.compile("multipart/mixed;.*boundary=\"([^\"]+)\"").matcher(response.header(NetworkingModule.CONTENT_TYPE_HEADER_NAME));
                if (matcher.find()) {
                    BundleDownloader.this.processMultipartResponse(httpUrl, response, matcher.group(1), file, bundleInfo, devBundleDownloadListener);
                } else {
                    BundleDownloader.this.processBundleResult(httpUrl, response.code(), response.headers(), Okio.buffer(response.body().source()), file, bundleInfo, devBundleDownloadListener);
                }
                response.close();
            }
        });
    }
}
