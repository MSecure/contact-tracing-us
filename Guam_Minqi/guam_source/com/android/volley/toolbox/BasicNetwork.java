package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Header;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;

public class BasicNetwork implements Network {
    public static final boolean DEBUG = VolleyLog.DEBUG;
    public final BaseHttpStack mBaseHttpStack;
    public final ByteArrayPool mPool;

    public BasicNetwork(BaseHttpStack baseHttpStack) {
        ByteArrayPool byteArrayPool = new ByteArrayPool(4096);
        this.mBaseHttpStack = baseHttpStack;
        this.mPool = byteArrayPool;
    }

    public static void attemptRetryOnException(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        DefaultRetryPolicy defaultRetryPolicy = request.mRetryPolicy;
        int i = defaultRetryPolicy.mCurrentTimeoutMs;
        try {
            int i2 = defaultRetryPolicy.mCurrentRetryCount + 1;
            defaultRetryPolicy.mCurrentRetryCount = i2;
            defaultRetryPolicy.mCurrentTimeoutMs = ((int) (((float) i) * defaultRetryPolicy.mBackoffMultiplier)) + i;
            if (i2 <= defaultRetryPolicy.mMaxNumRetries) {
                request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(i)));
                return;
            }
            throw volleyError;
        } catch (VolleyError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(i)));
            throw e;
        }
    }

    public static List<Header> combineHeaders(List<Header> list, Cache.Entry entry) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (Header header : list) {
                treeSet.add(header.mName);
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<Header> list2 = entry.allResponseHeaders;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (Header header2 : entry.allResponseHeaders) {
                    if (!treeSet.contains(header2.mName)) {
                        arrayList.add(header2);
                    }
                }
            }
        } else if (!entry.responseHeaders.isEmpty()) {
            for (Map.Entry<String, String> entry2 : entry.responseHeaders.entrySet()) {
                if (!treeSet.contains(entry2.getKey())) {
                    arrayList.add(new Header(entry2.getKey(), entry2.getValue()));
                }
            }
        }
        return arrayList;
    }

    public final Map<String, String> getCacheHeaders(Cache.Entry entry) {
        if (entry == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = entry.etag;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j = entry.lastModified;
        if (j > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            hashMap.put("If-Modified-Since", simpleDateFormat.format(new Date(j)));
        }
        return hashMap;
    }

    public final byte[] inputStreamToBytes(InputStream inputStream, int i) throws IOException, ServerError {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, i);
        try {
            byte[] buf = this.mPool.getBuf(1024);
            while (true) {
                int read = inputStream.read(buf);
                if (read == -1) {
                    break;
                }
                poolingByteArrayOutputStream.write(buf, 0, read);
            }
            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused) {
                VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
            }
            this.mPool.returnBuf(buf);
            poolingByteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
            }
            this.mPool.returnBuf(null);
            poolingByteArrayOutputStream.close();
            throw th;
        }
    }

    public final void logSlowRequests(long j, Request<?> request, byte[] bArr, int i) {
        if (DEBUG || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(request.mRetryPolicy.mCurrentRetryCount);
            VolleyLog.buildMessage("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        r14 = null;
        r2 = r12;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a1, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a5, code lost:
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ac, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ad, code lost:
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00af, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b0, code lost:
        r18 = r1;
        r14 = null;
        r2 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b6, code lost:
        r18 = r1;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bb, code lost:
        r0 = r2.mStatusCode;
        com.android.volley.VolleyLog.e("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r29.mUrl);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d0, code lost:
        if (r14 != null) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d2, code lost:
        r1 = new com.android.volley.NetworkResponse(r0, r14, false, android.os.SystemClock.elapsedRealtime() - r9, r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e2, code lost:
        if (r0 == 401) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00eb, code lost:
        if (r0 < 400) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f7, code lost:
        throw new com.android.volley.ClientError(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fa, code lost:
        if (r0 < 500) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0102, code lost:
        if (r29.mShouldRetryServerErrors != false) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0104, code lost:
        attemptRetryOnException("server", r29, new com.android.volley.ServerError(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0115, code lost:
        throw new com.android.volley.ServerError(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x011c, code lost:
        attemptRetryOnException("auth", r29, new com.android.volley.AuthFailureError(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0128, code lost:
        attemptRetryOnException("network", r29, new com.android.volley.NetworkError());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0139, code lost:
        throw new com.android.volley.NoConnectionError(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x013a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x013b, code lost:
        r2 = com.android.tools.r8.GeneratedOutlineSupport.outline15("Bad URL ");
        r2.append(r29.mUrl);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x014f, code lost:
        throw new java.lang.RuntimeException(r2.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0150, code lost:
        attemptRetryOnException("socket", r29, new com.android.volley.TimeoutError());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x013a A[ExcHandler: MalformedURLException (r0v1 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0134 A[SYNTHETIC] */
    public NetworkResponse performRequest(Request<?> request) throws VolleyError {
        NetworkResponse networkResponse;
        HttpResponse executeRequest;
        byte[] inputStreamToBytes;
        List list;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            List emptyList = Collections.emptyList();
            HttpResponse httpResponse = null;
            try {
                executeRequest = this.mBaseHttpStack.executeRequest(request, getCacheHeaders(request.mCacheEntry));
                int i = executeRequest.mStatusCode;
                List unmodifiableList = Collections.unmodifiableList(executeRequest.mHeaders);
                if (i == 304) {
                    Cache.Entry entry = request.mCacheEntry;
                    if (entry == null) {
                        return new NetworkResponse(304, null, true, SystemClock.elapsedRealtime() - elapsedRealtime, unmodifiableList);
                    }
                    return new NetworkResponse(304, entry.data, true, SystemClock.elapsedRealtime() - elapsedRealtime, combineHeaders(unmodifiableList, entry));
                }
                InputStream inputStream = executeRequest.mContent;
                inputStreamToBytes = inputStream != null ? inputStreamToBytes(inputStream, executeRequest.mContentLength) : new byte[0];
                logSlowRequests(SystemClock.elapsedRealtime() - elapsedRealtime, request, inputStreamToBytes, i);
                if (i >= 200 && i <= 299) {
                    list = unmodifiableList;
                    return new NetworkResponse(i, inputStreamToBytes, false, SystemClock.elapsedRealtime() - elapsedRealtime, list);
                }
            } catch (SocketTimeoutException unused) {
            } catch (MalformedURLException e) {
            } catch (IOException e2) {
                IOException e3 = e2;
                List list2 = list;
                httpResponse = executeRequest;
                byte[] bArr = inputStreamToBytes;
                if (httpResponse == null) {
                }
            }
        }
        throw new ServerError(networkResponse);
    }
}
