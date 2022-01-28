package com.bugfender.sdk.a.a.i.d;

import com.google.common.net.HttpHeaders;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class a {
    private static final int d = -1;
    private final URL a;
    private final String b;
    private final String c;

    public a(URL url, String str, String str2) {
        this.a = url;
        this.b = str;
        this.c = str2;
    }

    public String a(String str, String str2) {
        return a(str, str2, -1);
    }

    public String a(String str, String str2, long j) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a, str).openConnection();
                try {
                    httpURLConnection.setRequestProperty("User-Agent", "bugfender-android/" + this.b);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setDefaultUseCaches(false);
                    httpURLConnection.setChunkedStreamingMode(0);
                    httpURLConnection.setConnectTimeout((int) TimeUnit.SECONDS.toMillis(20));
                    httpURLConnection.setReadTimeout((int) TimeUnit.SECONDS.toMillis(60));
                    httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf-8");
                    httpURLConnection.setRequestProperty("X-App-Token", this.c);
                    if (j != -1) {
                        httpURLConnection.setRequestProperty("X-App-Session", String.valueOf(j));
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    bufferedOutputStream.write(str2.getBytes());
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (200 > responseCode || responseCode > 299) {
                        String responseMessage = httpURLConnection.getResponseMessage();
                        String a2 = a(httpURLConnection.getErrorStream());
                        throw new com.bugfender.sdk.a.a.i.c.a.a(1, "Error status: " + responseCode + " / Response Message: " + responseMessage + " / Error Body: " + a2);
                    }
                    String a3 = a(httpURLConnection.getInputStream());
                    httpURLConnection.disconnect();
                    return a3;
                } catch (IOException e) {
                    throw new com.bugfender.sdk.a.a.i.c.a.a(1, "IO Exception: " + e.getMessage());
                } catch (Throwable th) {
                    httpURLConnection.disconnect();
                    throw th;
                }
            } catch (IOException e2) {
                throw new com.bugfender.sdk.a.a.i.c.a.a(1, "IO Exception: " + e2.getMessage());
            }
        } catch (MalformedURLException e3) {
            throw new RuntimeException(e3);
        }
    }

    private String a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[4096];
        while (true) {
            int read = bufferedReader.read(cArr);
            if (-1 != read) {
                stringWriter.write(cArr, 0, read);
            } else {
                bufferedReader.close();
                return stringWriter.toString();
            }
        }
    }
}
