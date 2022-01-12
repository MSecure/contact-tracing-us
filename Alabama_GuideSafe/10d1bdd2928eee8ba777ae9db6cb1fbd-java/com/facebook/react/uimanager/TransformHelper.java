package com.facebook.react.uimanager;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

public class TransformHelper {
    public static ThreadLocal<double[]> sHelperMatrix = new ThreadLocal<double[]>() {
        /* class com.facebook.react.uimanager.TransformHelper.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public double[] initialValue() {
            return new double[16];
        }
    };

    public static double convertToRadians(ReadableMap readableMap, String str) {
        double d;
        boolean z = true;
        if (readableMap.getType(str) == ReadableType.String) {
            String string = readableMap.getString(str);
            if (string.endsWith("rad")) {
                string = string.substring(0, string.length() - 3);
            } else if (string.endsWith("deg")) {
                string = string.substring(0, string.length() - 3);
                z = false;
            }
            d = (double) Float.parseFloat(string);
        } else {
            d = readableMap.getDouble(str);
        }
        return z ? d : (d * 3.141592653589793d) / 180.0d;
    }

    public static void processTransform(ReadableArray readableArray, double[] dArr) {
        char c;
        double[] dArr2 = sHelperMatrix.get();
        AppCompatDelegateImpl.ConfigurationImplApi17.resetIdentityMatrix(dArr);
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            ReadableMap map = readableArray.getMap(i);
            String nextKey = map.keySetIterator().nextKey();
            AppCompatDelegateImpl.ConfigurationImplApi17.resetIdentityMatrix(dArr2);
            if ("matrix".equals(nextKey)) {
                ReadableArray array = map.getArray(nextKey);
                for (int i2 = 0; i2 < 16; i2++) {
                    dArr2[i2] = array.getDouble(i2);
                }
            } else if ("perspective".equals(nextKey)) {
                dArr2[11] = -1.0d / map.getDouble(nextKey);
            } else if ("rotateX".equals(nextKey)) {
                double convertToRadians = convertToRadians(map, nextKey);
                dArr2[5] = Math.cos(convertToRadians);
                dArr2[6] = Math.sin(convertToRadians);
                dArr2[9] = -Math.sin(convertToRadians);
                dArr2[10] = Math.cos(convertToRadians);
            } else if ("rotateY".equals(nextKey)) {
                double convertToRadians2 = convertToRadians(map, nextKey);
                dArr2[0] = Math.cos(convertToRadians2);
                dArr2[2] = -Math.sin(convertToRadians2);
                dArr2[8] = Math.sin(convertToRadians2);
                dArr2[10] = Math.cos(convertToRadians2);
            } else if ("rotate".equals(nextKey) || "rotateZ".equals(nextKey)) {
                double convertToRadians3 = convertToRadians(map, nextKey);
                dArr2[0] = Math.cos(convertToRadians3);
                dArr2[1] = Math.sin(convertToRadians3);
                c = 4;
                dArr2[4] = -Math.sin(convertToRadians3);
                dArr2[5] = Math.cos(convertToRadians3);
                double d = dArr[0];
                double d2 = dArr[1];
                double d3 = dArr[2];
                double d4 = dArr[3];
                double d5 = dArr[c];
                double d6 = dArr[5];
                double d7 = dArr[6];
                double d8 = dArr[7];
                double d9 = dArr[8];
                double d10 = dArr[9];
                double d11 = dArr[10];
                double d12 = dArr[11];
                double d13 = dArr[12];
                double d14 = dArr[13];
                double d15 = dArr[14];
                double d16 = dArr[15];
                double d17 = dArr2[0];
                double d18 = dArr2[1];
                double d19 = dArr2[2];
                double d20 = dArr2[3];
                dArr[0] = (d20 * d13) + (d19 * d9) + (d18 * d5) + (d17 * d);
                dArr[1] = (d20 * d14) + (d19 * d10) + (d18 * d6) + (d17 * d2);
                dArr[2] = (d20 * d15) + (d19 * d11) + (d18 * d7) + (d17 * d3);
                double d21 = d20 * d16;
                dArr[3] = d21 + (d19 * d12) + (d18 * d8) + (d17 * d4);
                double d22 = dArr2[4];
                double d23 = dArr2[5];
                double d24 = dArr2[6];
                double d25 = dArr2[7];
                dArr[4] = (d25 * d13) + (d24 * d9) + (d23 * d5) + (d22 * d);
                dArr[5] = (d25 * d14) + (d24 * d10) + (d23 * d6) + (d22 * d2);
                dArr[6] = (d25 * d15) + (d24 * d11) + (d23 * d7) + (d22 * d3);
                double d26 = d25 * d16;
                dArr[7] = d26 + (d24 * d12) + (d23 * d8) + (d22 * d4);
                double d27 = dArr2[8];
                double d28 = dArr2[9];
                double d29 = dArr2[10];
                double d30 = dArr2[11];
                dArr[8] = (d30 * d13) + (d29 * d9) + (d28 * d5) + (d27 * d);
                dArr[9] = (d30 * d14) + (d29 * d10) + (d28 * d6) + (d27 * d2);
                dArr[10] = (d30 * d15) + (d29 * d11) + (d28 * d7) + (d27 * d3);
                double d31 = d30 * d16;
                dArr[11] = d31 + (d29 * d12) + (d28 * d8) + (d27 * d4);
                double d32 = dArr2[12];
                double d33 = dArr2[13];
                double d34 = dArr2[14];
                double d35 = dArr2[15];
                double d36 = d13 * d35;
                dArr[12] = d36 + (d9 * d34) + (d5 * d33) + (d * d32);
                double d37 = d14 * d35;
                dArr[13] = d37 + (d10 * d34) + (d6 * d33) + (d2 * d32);
                double d38 = d15 * d35;
                dArr[14] = d38 + (d11 * d34) + (d7 * d33) + (d3 * d32);
                double d39 = d35 * d16;
                dArr[15] = d39 + (d34 * d12) + (d33 * d8) + (d32 * d4);
            } else if ("scale".equals(nextKey)) {
                double d40 = map.getDouble(nextKey);
                dArr2[0] = d40;
                dArr2[5] = d40;
            } else if ("scaleX".equals(nextKey)) {
                dArr2[0] = map.getDouble(nextKey);
            } else if ("scaleY".equals(nextKey)) {
                dArr2[5] = map.getDouble(nextKey);
            } else {
                double d41 = 0.0d;
                if ("translate".equals(nextKey)) {
                    ReadableArray array2 = map.getArray(nextKey);
                    double d42 = array2.getDouble(0);
                    double d43 = array2.getDouble(1);
                    if (array2.size() > 2) {
                        d41 = array2.getDouble(2);
                    }
                    dArr2[12] = d42;
                    dArr2[13] = d43;
                    dArr2[14] = d41;
                } else if ("translateX".equals(nextKey)) {
                    dArr2[12] = map.getDouble(nextKey);
                    dArr2[13] = 0.0d;
                } else if ("translateY".equals(nextKey)) {
                    double d44 = map.getDouble(nextKey);
                    dArr2[12] = 0.0d;
                    dArr2[13] = d44;
                } else if ("skewX".equals(nextKey)) {
                    c = 4;
                    dArr2[4] = Math.tan(convertToRadians(map, nextKey));
                    double d45 = dArr[0];
                    double d210 = dArr[1];
                    double d310 = dArr[2];
                    double d46 = dArr[3];
                    double d52 = dArr[c];
                    double d62 = dArr[5];
                    double d72 = dArr[6];
                    double d82 = dArr[7];
                    double d92 = dArr[8];
                    double d102 = dArr[9];
                    double d112 = dArr[10];
                    double d122 = dArr[11];
                    double d132 = dArr[12];
                    double d142 = dArr[13];
                    double d152 = dArr[14];
                    double d162 = dArr[15];
                    double d172 = dArr2[0];
                    double d182 = dArr2[1];
                    double d192 = dArr2[2];
                    double d202 = dArr2[3];
                    dArr[0] = (d202 * d132) + (d192 * d92) + (d182 * d52) + (d172 * d45);
                    dArr[1] = (d202 * d142) + (d192 * d102) + (d182 * d62) + (d172 * d210);
                    dArr[2] = (d202 * d152) + (d192 * d112) + (d182 * d72) + (d172 * d310);
                    double d212 = d202 * d162;
                    dArr[3] = d212 + (d192 * d122) + (d182 * d82) + (d172 * d46);
                    double d222 = dArr2[4];
                    double d232 = dArr2[5];
                    double d242 = dArr2[6];
                    double d252 = dArr2[7];
                    dArr[4] = (d252 * d132) + (d242 * d92) + (d232 * d52) + (d222 * d45);
                    dArr[5] = (d252 * d142) + (d242 * d102) + (d232 * d62) + (d222 * d210);
                    dArr[6] = (d252 * d152) + (d242 * d112) + (d232 * d72) + (d222 * d310);
                    double d262 = d252 * d162;
                    dArr[7] = d262 + (d242 * d122) + (d232 * d82) + (d222 * d46);
                    double d272 = dArr2[8];
                    double d282 = dArr2[9];
                    double d292 = dArr2[10];
                    double d302 = dArr2[11];
                    dArr[8] = (d302 * d132) + (d292 * d92) + (d282 * d52) + (d272 * d45);
                    dArr[9] = (d302 * d142) + (d292 * d102) + (d282 * d62) + (d272 * d210);
                    dArr[10] = (d302 * d152) + (d292 * d112) + (d282 * d72) + (d272 * d310);
                    double d312 = d302 * d162;
                    dArr[11] = d312 + (d292 * d122) + (d282 * d82) + (d272 * d46);
                    double d322 = dArr2[12];
                    double d332 = dArr2[13];
                    double d342 = dArr2[14];
                    double d352 = dArr2[15];
                    double d362 = d132 * d352;
                    dArr[12] = d362 + (d92 * d342) + (d52 * d332) + (d45 * d322);
                    double d372 = d142 * d352;
                    dArr[13] = d372 + (d102 * d342) + (d62 * d332) + (d210 * d322);
                    double d382 = d152 * d352;
                    dArr[14] = d382 + (d112 * d342) + (d72 * d332) + (d310 * d322);
                    double d392 = d352 * d162;
                    dArr[15] = d392 + (d342 * d122) + (d332 * d82) + (d322 * d46);
                } else if ("skewY".equals(nextKey)) {
                    dArr2[1] = Math.tan(convertToRadians(map, nextKey));
                } else {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline10("Unsupported transform type: ", nextKey));
                }
            }
            c = 4;
            double d452 = dArr[0];
            double d2102 = dArr[1];
            double d3102 = dArr[2];
            double d462 = dArr[3];
            double d522 = dArr[c];
            double d622 = dArr[5];
            double d722 = dArr[6];
            double d822 = dArr[7];
            double d922 = dArr[8];
            double d1022 = dArr[9];
            double d1122 = dArr[10];
            double d1222 = dArr[11];
            double d1322 = dArr[12];
            double d1422 = dArr[13];
            double d1522 = dArr[14];
            double d1622 = dArr[15];
            double d1722 = dArr2[0];
            double d1822 = dArr2[1];
            double d1922 = dArr2[2];
            double d2022 = dArr2[3];
            dArr[0] = (d2022 * d1322) + (d1922 * d922) + (d1822 * d522) + (d1722 * d452);
            dArr[1] = (d2022 * d1422) + (d1922 * d1022) + (d1822 * d622) + (d1722 * d2102);
            dArr[2] = (d2022 * d1522) + (d1922 * d1122) + (d1822 * d722) + (d1722 * d3102);
            double d2122 = d2022 * d1622;
            dArr[3] = d2122 + (d1922 * d1222) + (d1822 * d822) + (d1722 * d462);
            double d2222 = dArr2[4];
            double d2322 = dArr2[5];
            double d2422 = dArr2[6];
            double d2522 = dArr2[7];
            dArr[4] = (d2522 * d1322) + (d2422 * d922) + (d2322 * d522) + (d2222 * d452);
            dArr[5] = (d2522 * d1422) + (d2422 * d1022) + (d2322 * d622) + (d2222 * d2102);
            dArr[6] = (d2522 * d1522) + (d2422 * d1122) + (d2322 * d722) + (d2222 * d3102);
            double d2622 = d2522 * d1622;
            dArr[7] = d2622 + (d2422 * d1222) + (d2322 * d822) + (d2222 * d462);
            double d2722 = dArr2[8];
            double d2822 = dArr2[9];
            double d2922 = dArr2[10];
            double d3022 = dArr2[11];
            dArr[8] = (d3022 * d1322) + (d2922 * d922) + (d2822 * d522) + (d2722 * d452);
            dArr[9] = (d3022 * d1422) + (d2922 * d1022) + (d2822 * d622) + (d2722 * d2102);
            dArr[10] = (d3022 * d1522) + (d2922 * d1122) + (d2822 * d722) + (d2722 * d3102);
            double d3122 = d3022 * d1622;
            dArr[11] = d3122 + (d2922 * d1222) + (d2822 * d822) + (d2722 * d462);
            double d3222 = dArr2[12];
            double d3322 = dArr2[13];
            double d3422 = dArr2[14];
            double d3522 = dArr2[15];
            double d3622 = d1322 * d3522;
            dArr[12] = d3622 + (d922 * d3422) + (d522 * d3322) + (d452 * d3222);
            double d3722 = d1422 * d3522;
            dArr[13] = d3722 + (d1022 * d3422) + (d622 * d3322) + (d2102 * d3222);
            double d3822 = d1522 * d3522;
            dArr[14] = d3822 + (d1122 * d3422) + (d722 * d3322) + (d3102 * d3222);
            double d3922 = d3522 * d1622;
            dArr[15] = d3922 + (d3422 * d1222) + (d3322 * d822) + (d3222 * d462);
        }
    }
}
