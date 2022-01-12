package com.bugsnag.android;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.bugsnag.android.JsonStream;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;

/* compiled from: DefaultDelivery.kt */
public final class DefaultDelivery implements Delivery {
    public final Connectivity connectivity;
    public final Logger logger;

    public DefaultDelivery(Connectivity connectivity2, Logger logger2) {
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        this.connectivity = connectivity2;
        this.logger = logger2;
    }

    @Override // com.bugsnag.android.Delivery
    public DeliveryStatus deliver(EventPayload eventPayload, DeliveryParams deliveryParams) {
        Intrinsics.checkParameterIsNotNull(eventPayload, "payload");
        Intrinsics.checkParameterIsNotNull(deliveryParams, "deliveryParams");
        DeliveryStatus deliver = deliver(deliveryParams.endpoint, eventPayload, deliveryParams.headers);
        Logger logger2 = this.logger;
        logger2.i("Error API request finished with status " + deliver);
        return deliver;
    }

    public final DeliveryStatus getDeliveryStatus$bugsnag_android_core_release(int i) {
        IntRange intRange = new IntRange(400, 499);
        ArrayList arrayList = new ArrayList();
        for (Object obj : intRange) {
            int intValue = ((Number) obj).intValue();
            if ((intValue == 408 || intValue == 429) ? false : true) {
                arrayList.add(obj);
            }
        }
        if (200 <= i && 299 >= i) {
            return DeliveryStatus.DELIVERED;
        }
        if (arrayList.contains(Integer.valueOf(i))) {
            return DeliveryStatus.FAILURE;
        }
        return DeliveryStatus.UNDELIVERED;
    }

    public final void logRequestInfo(int i, HttpURLConnection httpURLConnection, DeliveryStatus deliveryStatus) {
        Logger logger2 = this.logger;
        logger2.i("Request completed with code " + i + ", " + "message: " + httpURLConnection.getResponseMessage() + ", " + "headers: " + httpURLConnection.getHeaderFields());
        if (deliveryStatus != DeliveryStatus.DELIVERED) {
            InputStream errorStream = httpURLConnection.getErrorStream();
            Intrinsics.checkExpressionValueIsNotNull(errorStream, "conn.errorStream");
            InputStreamReader inputStreamReader = new InputStreamReader(errorStream, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            Intrinsics.checkNotNullParameter(bufferedReader, "$this$readText");
            StringWriter stringWriter = new StringWriter();
            Intrinsics.checkNotNullParameter(bufferedReader, "$this$copyTo");
            Intrinsics.checkNotNullParameter(stringWriter, "out");
            char[] cArr = new char[8192];
            for (int read = bufferedReader.read(cArr); read >= 0; read = bufferedReader.read(cArr)) {
                stringWriter.write(cArr, 0, read);
            }
            String stringWriter2 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter2, "buffer.toString()");
            Logger logger3 = this.logger;
            logger3.w("Request error details: " + stringWriter2);
        }
    }

    @Override // com.bugsnag.android.Delivery
    public DeliveryStatus deliver(Session session, DeliveryParams deliveryParams) {
        Intrinsics.checkParameterIsNotNull(session, "payload");
        Intrinsics.checkParameterIsNotNull(deliveryParams, "deliveryParams");
        DeliveryStatus deliver = deliver(deliveryParams.endpoint, session, deliveryParams.headers);
        Logger logger2 = this.logger;
        logger2.i("Session API request finished with status " + deliver);
        return deliver;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0095, code lost:
        r7 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0091 A[SYNTHETIC, Splitter:B:29:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0095 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:11:0x002b] */
    public final DeliveryStatus deliver(String str, JsonStream.Streamable streamable, Map<String, String> map) {
        IOException e;
        Exception e2;
        Throwable th;
        DeliveryStatus deliveryStatus = DeliveryStatus.UNDELIVERED;
        Intrinsics.checkParameterIsNotNull(str, "urlString");
        Intrinsics.checkParameterIsNotNull(streamable, "streamable");
        Intrinsics.checkParameterIsNotNull(map, "headers");
        Connectivity connectivity2 = this.connectivity;
        if (!(connectivity2 == null || connectivity2.hasNetworkConnection())) {
            return deliveryStatus;
        }
        HttpURLConnection httpURLConnection = null;
        JsonStream jsonStream = null;
        HttpURLConnection httpURLConnection2 = null;
        try {
            URLConnection openConnection = new URL(str).openConnection();
            if (openConnection != null) {
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) openConnection;
                try {
                    httpURLConnection3.setDoOutput(true);
                    httpURLConnection3.setChunkedStreamingMode(0);
                    httpURLConnection3.addRequestProperty("Content-Type", "application/json");
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection3.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                    try {
                        JsonStream jsonStream2 = new JsonStream(new BufferedWriter(new OutputStreamWriter(httpURLConnection3.getOutputStream(), Charset.forName(RNCWebViewManager.HTML_ENCODING))));
                        try {
                            streamable.toStream(jsonStream2);
                            jsonStream2.close();
                            int responseCode = httpURLConnection3.getResponseCode();
                            DeliveryStatus deliveryStatus$bugsnag_android_core_release = getDeliveryStatus$bugsnag_android_core_release(responseCode);
                            logRequestInfo(responseCode, httpURLConnection3, deliveryStatus$bugsnag_android_core_release);
                            AppCompatDelegateImpl.ConfigurationImplApi17.close(httpURLConnection3);
                            return deliveryStatus$bugsnag_android_core_release;
                        } catch (Throwable th2) {
                            th = th2;
                            jsonStream = jsonStream2;
                            if (jsonStream != null) {
                                jsonStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (jsonStream != null) {
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    httpURLConnection = httpURLConnection3;
                    this.logger.w("IOException encountered in request", e);
                    AppCompatDelegateImpl.ConfigurationImplApi17.close(httpURLConnection);
                    return deliveryStatus;
                } catch (Exception e4) {
                    e2 = e4;
                    httpURLConnection2 = httpURLConnection3;
                    try {
                        this.logger.w("Unexpected error delivering payload", e2);
                        DeliveryStatus deliveryStatus2 = DeliveryStatus.FAILURE;
                        AppCompatDelegateImpl.ConfigurationImplApi17.close(httpURLConnection2);
                        return deliveryStatus2;
                    } catch (Throwable th4) {
                        Throwable th5 = th4;
                        httpURLConnection3 = httpURLConnection2;
                        AppCompatDelegateImpl.ConfigurationImplApi17.close(httpURLConnection3);
                        throw th5;
                    }
                } catch (Throwable th6) {
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
        } catch (IOException e5) {
            e = e5;
            this.logger.w("IOException encountered in request", e);
            AppCompatDelegateImpl.ConfigurationImplApi17.close(httpURLConnection);
            return deliveryStatus;
        } catch (Exception e6) {
            e2 = e6;
            this.logger.w("Unexpected error delivering payload", e2);
            DeliveryStatus deliveryStatus22 = DeliveryStatus.FAILURE;
            AppCompatDelegateImpl.ConfigurationImplApi17.close(httpURLConnection2);
            return deliveryStatus22;
        }
    }
}
