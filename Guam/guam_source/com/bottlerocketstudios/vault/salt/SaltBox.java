package com.bottlerocketstudios.vault.salt;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.SparseArray;
import java.util.Locale;

public class SaltBox {
    public static SparseArray<byte[]> sStoredBits = new SparseArray<>();

    public static String getSettingName(int i) {
        return String.format(Locale.US, "NaCl-%1$d", Integer.valueOf(i));
    }

    public static boolean isByteArrayInvalid(byte[] bArr, int i) {
        return bArr == null || bArr.length != i;
    }

    public static void writeStoredBits(Context context, int i, byte[] bArr, int i2) {
        String settingName = getSettingName(i);
        SharedPreferences.Editor edit = context.getSharedPreferences("NaCl", 0).edit();
        if (isByteArrayInvalid(bArr, i2)) {
            edit.remove(settingName);
        } else {
            edit.putString(settingName, Base64.encodeToString(bArr, 0));
        }
        edit.apply();
        if (isByteArrayInvalid(bArr, i2)) {
            sStoredBits.put(i, null);
        } else {
            sStoredBits.put(i, bArr);
        }
    }
}
