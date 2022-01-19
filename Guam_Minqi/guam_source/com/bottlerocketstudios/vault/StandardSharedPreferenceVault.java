package com.bottlerocketstudios.vault;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.bottlerocketstudios.vault.StringEncryptionUtils;
import com.bottlerocketstudios.vault.keys.storage.KeyStorage;
import com.bottlerocketstudios.vault.keys.storage.SharedPrefKeyStorage;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class StandardSharedPreferenceVault implements SharedPreferences {
    public static final Pattern BOOLEAN_REGEX = Pattern.compile("^(true|false)$");
    public static final Pattern FLOAT_REGEX = Pattern.compile("^-?\\d+\\.\\d+$");
    public static final Pattern INTEGER_REGEX = Pattern.compile("^-?\\d+$");
    public static final String TAG = StandardSharedPreferenceVault.class.getSimpleName();
    public final Context mContext;
    public final boolean mEnableExceptions;
    public final KeyStorage mKeyStorage;
    public final List<SharedPreferences.OnSharedPreferenceChangeListener> mSharedPreferenceChangeListenerList = Collections.synchronizedList(new LinkedList());
    public final String mSharedPreferenceName;
    public SharedPreferences mSharedPreferences;
    public final String mTransform;

    public StandardSharedPreferenceVault(Context context, KeyStorage keyStorage, String str, String str2, boolean z) {
        this.mContext = context.getApplicationContext();
        this.mKeyStorage = keyStorage;
        this.mSharedPreferenceName = str;
        this.mTransform = str2;
        this.mEnableExceptions = z;
    }

    public boolean contains(String str) {
        return getSharedPreferences().contains(str);
    }

    public SharedPreferences.Editor edit() {
        return new StandardSharedPreferenceVaultEditor(this);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap hashMap = new HashMap();
        SecretKey loadKey = ((SharedPrefKeyStorage) this.mKeyStorage).loadKey(this.mContext);
        if (loadKey != null) {
            try {
                for (String str : getSharedPreferences().getAll().keySet()) {
                    String string = getString(str, null, loadKey);
                    if (string != null) {
                        if (FLOAT_REGEX.matcher(string).matches()) {
                            hashMap.put(str, Float.valueOf(string));
                        } else if (INTEGER_REGEX.matcher(string).matches()) {
                            Long valueOf = Long.valueOf(string);
                            if (valueOf.longValue() > 2147483647L || valueOf.longValue() < -2147483648L) {
                                hashMap.put(str, valueOf);
                            } else {
                                hashMap.put(str, Integer.valueOf(valueOf.intValue()));
                            }
                        } else if (BOOLEAN_REGEX.matcher(string).matches()) {
                            hashMap.put(str, Boolean.valueOf(string));
                        } else if (string.contains("1eRHtJaybutdAsFp2DkfrT1FqMJlLfT7DdgCpQtTaoQWheoeFBZRqt5pgFDH7Cf")) {
                            hashMap.put(str, splitStringSet(string));
                        } else {
                            hashMap.put(str, string);
                        }
                    }
                }
            } catch (StringEncryptionUtils.UnencryptedException | UnsupportedEncodingException | GeneralSecurityException e) {
                if (this.mEnableExceptions) {
                    throw new RuntimeException(e);
                }
            }
        }
        return hashMap;
    }

    public boolean getBoolean(String str, boolean z) {
        String string = getString(str, null);
        return string != null ? Boolean.valueOf(string).booleanValue() : z;
    }

    public float getFloat(String str, float f) {
        String string = getString(str, null);
        return string != null ? Float.valueOf(string).floatValue() : f;
    }

    public int getInt(String str, int i) {
        String string = getString(str, null);
        return string != null ? Integer.valueOf(string).intValue() : i;
    }

    public long getLong(String str, long j) {
        String string = getString(str, null);
        return string != null ? Long.valueOf(string).longValue() : j;
    }

    public final SharedPreferences getSharedPreferences() {
        if (this.mSharedPreferences == null) {
            if (!TextUtils.isEmpty(this.mSharedPreferenceName)) {
                this.mSharedPreferences = this.mContext.getSharedPreferences(this.mSharedPreferenceName, 0);
            } else {
                throw new IllegalStateException("Cannot open preferences before calling setSharedPreferenceFileName");
            }
        }
        return this.mSharedPreferences;
    }

    public String getString(String str, String str2) {
        try {
            return getString(str, str2, ((SharedPrefKeyStorage) this.mKeyStorage).loadKey(this.mContext));
        } catch (StringEncryptionUtils.UnencryptedException | UnsupportedEncodingException | GeneralSecurityException e) {
            if (!this.mEnableExceptions) {
                return str2;
            }
            throw new RuntimeException(e);
        }
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        String string = getString(str, null);
        if (string == null) {
            return set;
        }
        String[] split = string.split("1eRHtJaybutdAsFp2DkfrT1FqMJlLfT7DdgCpQtTaoQWheoeFBZRqt5pgFDH7Cf");
        HashSet hashSet = new HashSet(split.length);
        hashSet.addAll(Arrays.asList(split));
        return hashSet;
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mSharedPreferenceChangeListenerList.add(onSharedPreferenceChangeListener);
    }

    public final Set<String> splitStringSet(String str) {
        String[] split = str.split("1eRHtJaybutdAsFp2DkfrT1FqMJlLfT7DdgCpQtTaoQWheoeFBZRqt5pgFDH7Cf");
        HashSet hashSet = new HashSet(split.length);
        hashSet.addAll(Arrays.asList(split));
        return hashSet;
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mSharedPreferenceChangeListenerList.remove(onSharedPreferenceChangeListener);
    }

    public final void writeString(SharedPreferences.Editor editor, String str, SecretKey secretKey, String str2) throws GeneralSecurityException, UnsupportedEncodingException {
        String str3;
        String str4 = this.mTransform;
        if (str2 == null) {
            str3 = null;
        } else {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher instance = Cipher.getInstance(str4);
            instance.init(1, secretKey);
            byte[] doFinal = instance.doFinal(bytes);
            byte[] iv = instance.getIV();
            ByteBuffer allocate = ByteBuffer.allocate(iv.length + 6);
            allocate.put((byte) 121);
            allocate.put((byte) 1);
            allocate.putInt(iv.length);
            allocate.put(iv);
            byte[] array = allocate.array();
            byte[] bArr = new byte[(array.length + doFinal.length)];
            System.arraycopy(array, 0, bArr, 0, array.length);
            System.arraycopy(doFinal, 0, bArr, array.length, doFinal.length);
            str3 = Base64.encodeToString(bArr, 0);
        }
        editor.putString(str, str3);
    }

    public final void writeStringSet(SharedPreferences.Editor editor, String str, SecretKey secretKey, Set<String> set) throws GeneralSecurityException, UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append("1eRHtJaybutdAsFp2DkfrT1FqMJlLfT7DdgCpQtTaoQWheoeFBZRqt5pgFDH7Cf");
            }
        }
        writeString(editor, str, secretKey, sb.toString());
    }

    public boolean writeValues(boolean z, boolean z2, Set<String> set, StronglyTypedBundle stronglyTypedBundle) {
        SecretKey loadKey;
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        HashSet hashSet = new HashSet();
        if (z2) {
            edit.clear();
        }
        if (set != null) {
            for (String str : set) {
                edit.remove(str);
            }
            hashSet.addAll(set);
        }
        if (stronglyTypedBundle == null || (loadKey = ((SharedPrefKeyStorage) this.mKeyStorage).loadKey(this.mContext)) == null) {
            return false;
        }
        try {
            for (String str2 : stronglyTypedBundle.mValueMap.keySet()) {
                Class cls = stronglyTypedBundle.mClassMap.get(str2);
                if (cls == String.class) {
                    writeString(edit, str2, loadKey, (String) String.class.cast(stronglyTypedBundle.mValueMap.get(str2)));
                } else if (cls == Long.class) {
                    writeString(edit, str2, loadKey, String.valueOf((Long) Long.class.cast(stronglyTypedBundle.mValueMap.get(str2))));
                } else if (cls == Integer.class) {
                    writeString(edit, str2, loadKey, String.valueOf((Integer) Integer.class.cast(stronglyTypedBundle.mValueMap.get(str2))));
                } else if (cls == Float.class) {
                    writeString(edit, str2, loadKey, String.valueOf((Float) Float.class.cast(stronglyTypedBundle.mValueMap.get(str2))));
                } else if (cls == Boolean.class) {
                    writeString(edit, str2, loadKey, String.valueOf((Boolean) Boolean.class.cast(stronglyTypedBundle.mValueMap.get(str2))));
                } else if (Set.class.isAssignableFrom(cls)) {
                    try {
                        writeStringSet(edit, str2, loadKey, (Set) Set.class.cast(stronglyTypedBundle.mValueMap.get(str2)));
                    } catch (ClassCastException unused) {
                        return false;
                    }
                } else {
                    cls.toString();
                    return false;
                }
            }
            hashSet.addAll(stronglyTypedBundle.mValueMap.keySet());
            boolean z3 = true;
            if (z) {
                z3 = edit.commit();
            } else {
                edit.apply();
            }
            if (z3) {
                synchronized (this.mSharedPreferenceChangeListenerList) {
                    for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.mSharedPreferenceChangeListenerList) {
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, (String) it.next());
                        }
                    }
                }
            }
            return z3;
        } catch (UnsupportedEncodingException | GeneralSecurityException e) {
            if (!this.mEnableExceptions) {
                return false;
            }
            throw new RuntimeException(e);
        }
    }

    public final String getString(String str, String str2, SecretKey secretKey) throws GeneralSecurityException, UnsupportedEncodingException, StringEncryptionUtils.UnencryptedException {
        String string = getSharedPreferences().getString(str, null);
        if (string == null || secretKey == null) {
            return str2;
        }
        try {
            byte[] decrypt = StringEncryptionUtils.decrypt(secretKey, Base64.decode(string, 0), this.mTransform);
            if (decrypt != null) {
                return new String(decrypt, "UTF-8");
            }
            return null;
        } catch (IllegalArgumentException e) {
            throw new StringEncryptionUtils.UnencryptedException("Encrypted String was not base64 encoded.", e);
        }
    }
}
