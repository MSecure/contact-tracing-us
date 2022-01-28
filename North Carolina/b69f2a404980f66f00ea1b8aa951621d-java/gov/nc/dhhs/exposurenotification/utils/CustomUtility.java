package gov.nc.dhhs.exposurenotification.utils;

import c.a.a.a.a;
import c.a.b.x.h;
import gov.nc.dhhs.exposurenotification.BuildConfig;
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
        StringBuilder g = a.g("{\"type\" : \"Android\",\"timestamp\": \"");
        g.append(date.getTime());
        g.append("\",\"message\" :\"");
        g.append(date.toString() + " : " + str2);
        g.append("\"}");
        String sb = g.toString();
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
        String[] strArr = {"A_CW_91000", "A_CW_91001", "A_CW_91009", "A_CW_91002", "A_CW_91011", "A_CW_ERROR", "ERROR", "error", "Error"};
        for (int i = 0; i < 9; i++) {
            if (str.contains(strArr[i])) {
                return true;
            }
        }
        return false;
    }

    public static void customLogger(final String str) {
        if (LOG_TO_SERVER.booleanValue() && containsWords(str)) {
            new Thread(BuildConfig.LOGGING_URL) {
                /* class gov.nc.dhhs.exposurenotification.utils.CustomUtility.AnonymousClass1 */

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
