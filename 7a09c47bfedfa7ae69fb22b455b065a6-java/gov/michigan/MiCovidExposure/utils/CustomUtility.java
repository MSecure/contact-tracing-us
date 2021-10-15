package gov.michigan.MiCovidExposure.utils;

import c.a.a.a.a;
import c.a.b.x.h;
import gov.michigan.MiCovidExposure.BuildConfig;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;
import javax.net.ssl.HttpsURLConnection;

public class CustomUtility {
    public static Boolean LOG_TO_SERVER = Boolean.TRUE;
    public static final String TAG = "CustomUtility";

    public static void Logger(String str, String str2) {
        Boolean bool;
        URL url = new URL(str);
        Date date = new Date();
        StringBuilder h = a.h("{\"type\" : \"Android\",\"timestamp\": \"");
        h.append(date.getTime());
        h.append("\",\"message\" :\"");
        h.append(date.toString() + " : " + str2);
        h.append("\"}");
        String sb = h.toString();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setConnectTimeout(300000);
        httpsURLConnection.setReadTimeout(15000);
        httpsURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
        httpsURLConnection.setRequestProperty("Accept", "application/json");
        OutputStream outputStream = httpsURLConnection.getOutputStream();
        byte[] bytes = sb.getBytes(h.PROTOCOL_CHARSET);
        outputStream.write(bytes, 0, bytes.length);
        if (httpsURLConnection.getResponseCode() != 200) {
            httpsURLConnection.getResponseCode();
            bool = Boolean.FALSE;
        } else {
            bool = Boolean.TRUE;
        }
        LOG_TO_SERVER = bool;
    }

    public static boolean containsWords(String str) {
        String[] strArr = {"A_CW_91001", "A_CW_91009", "A_CW_91002", "A_CW_ERROR", "A_CW_91201", "A_CW_91202", "ERROR", "error", "Error"};
        for (int i = 0; i < 9; i++) {
            if (str.contains(strArr[i])) {
                return true;
            }
        }
        return false;
    }

    public static void customLogger(final String str) {
        if (containsWords(str)) {
            new Thread(BuildConfig.LOGGING_URL) {
                /* class gov.michigan.MiCovidExposure.utils.CustomUtility.AnonymousClass1 */

                public void run() {
                    try {
                        CustomUtility.Logger(BuildConfig.LOGGING_URL, str);
                    } catch (Exception unused) {
                    }
                }
            }.start();
        }
    }
}
