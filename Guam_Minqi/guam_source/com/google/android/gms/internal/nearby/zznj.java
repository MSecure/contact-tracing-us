package com.google.android.gms.internal.nearby;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public class zznj {
    public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri zzb = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzc = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzd = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    public static final AtomicBoolean zze = new AtomicBoolean();
    public static HashMap<String, String> zzf;
    public static final HashMap<String, Boolean> zzg = new HashMap<>();
    public static final HashMap<String, Integer> zzh = new HashMap<>();
    public static final HashMap<String, Long> zzi = new HashMap<>();
    public static final HashMap<String, Float> zzj = new HashMap<>();
    public static Object zzk;
    public static boolean zzl;
    public static String[] zzm = new String[0];

    public static void zza(ContentResolver contentResolver) {
        if (zzf == null) {
            zze.set(false);
            zzf = new HashMap<>();
            zzk = new Object();
            zzl = false;
            contentResolver.registerContentObserver(zza, true, new zznm());
        } else if (zze.getAndSet(false)) {
            zzf.clear();
            zzg.clear();
            zzh.clear();
            zzi.clear();
            zzj.clear();
            zzk = new Object();
            zzl = false;
        }
    }

    public static void zza(Object obj, String str, String str2) {
        synchronized (zznj.class) {
            if (obj == zzk) {
                zzf.put(str, str2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:88:0x0138 A[SYNTHETIC] */
    public static boolean zza(ContentResolver contentResolver, String str) {
        Object obj;
        String str2;
        boolean z;
        Boolean bool;
        synchronized (zznj.class) {
            zza(contentResolver);
            obj = zzk;
        }
        HashMap<String, Boolean> hashMap = zzg;
        Boolean bool2 = Boolean.TRUE;
        synchronized (zznj.class) {
            str2 = null;
            if (hashMap.containsKey(str)) {
                Boolean bool3 = hashMap.get(str);
                if (bool3 != null) {
                    bool2 = bool3;
                }
            } else {
                bool2 = null;
            }
        }
        Boolean bool4 = bool2;
        if (bool4 != null) {
            return bool4.booleanValue();
        }
        synchronized (zznj.class) {
            zza(contentResolver);
            Object obj2 = zzk;
            z = false;
            if (zzf.containsKey(str)) {
                String str3 = zzf.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            } else {
                String[] strArr = zzm;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        Cursor query = contentResolver.query(zza, null, null, new String[]{str}, null);
                        if (query != null) {
                            try {
                                if (!query.moveToFirst()) {
                                    zza(obj2, str, null);
                                } else {
                                    String string = query.getString(1);
                                    if (string != null && string.equals(null)) {
                                        string = null;
                                    }
                                    zza(obj2, str, string);
                                    if (string != null) {
                                        str2 = string;
                                    }
                                    query.close();
                                }
                            } finally {
                                query.close();
                            }
                        } else if (query != null) {
                            query.close();
                        }
                    } else if (!str.startsWith(strArr[i])) {
                        i++;
                    } else if (!zzl || zzf.isEmpty()) {
                        String[] strArr2 = zzm;
                        HashMap<String, String> hashMap2 = zzf;
                        Cursor query2 = contentResolver.query(zzb, null, null, strArr2, null);
                        TreeMap treeMap = new TreeMap();
                        if (query2 != null) {
                            while (query2.moveToNext()) {
                                try {
                                    treeMap.put(query2.getString(0), query2.getString(1));
                                } finally {
                                    query2.close();
                                }
                            }
                        }
                        hashMap2.putAll(treeMap);
                        zzl = true;
                        if (zzf.containsKey(str)) {
                            String str4 = zzf.get(str);
                            if (str4 != null) {
                                str2 = str4;
                            }
                        }
                    }
                }
            }
        }
        if (str2 != null && !str2.equals("")) {
            if (zzc.matcher(str2).matches()) {
                bool4 = Boolean.TRUE;
            } else if (zzd.matcher(str2).matches()) {
                bool = Boolean.FALSE;
                HashMap<String, Boolean> hashMap3 = zzg;
                synchronized (zznj.class) {
                    if (obj == zzk) {
                        hashMap3.put(str, bool);
                        zzf.remove(str);
                    }
                }
                return z;
            } else {
                Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + str2 + "\") as boolean");
            }
        }
        bool = bool4;
        z = true;
        HashMap<String, Boolean> hashMap32 = zzg;
        synchronized (zznj.class) {
        }
    }
}
