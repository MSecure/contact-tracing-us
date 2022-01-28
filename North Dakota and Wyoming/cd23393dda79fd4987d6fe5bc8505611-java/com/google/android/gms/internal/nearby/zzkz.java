package com.google.android.gms.internal.nearby;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public class zzkz {
    private static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzb = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static final Pattern zzc = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static final Pattern zzd = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zze = new AtomicBoolean();
    private static HashMap<String, String> zzf;
    private static final HashMap<String, Boolean> zzg = new HashMap<>();
    private static final HashMap<String, Integer> zzh = new HashMap<>();
    private static final HashMap<String, Long> zzi = new HashMap<>();
    private static final HashMap<String, Float> zzj = new HashMap<>();
    private static Object zzk;
    private static boolean zzl;
    private static String[] zzm = new String[0];

    private static void zza(ContentResolver contentResolver) {
        if (zzf == null) {
            zze.set(false);
            zzf = new HashMap<>();
            zzk = new Object();
            zzl = false;
            contentResolver.registerContentObserver(zza, true, new zzlc(null));
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

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0062, code lost:
        r13 = r13.query(com.google.android.gms.internal.nearby.zzkz.zza, null, null, new java.lang.String[]{r14}, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0070, code lost:
        if (r13 != null) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0072, code lost:
        if (r13 == null) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0074, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0077, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007c, code lost:
        if (r13.moveToFirst() != false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007e, code lost:
        zza(r0, r14, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0086, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0087, code lost:
        r15 = r13.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008b, code lost:
        if (r15 == null) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0091, code lost:
        if (r15.equals(null) == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0093, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0094, code lost:
        zza(r0, r14, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0097, code lost:
        if (r15 == null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0099, code lost:
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009a, code lost:
        if (r13 == null) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x009c, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009f, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a0, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a1, code lost:
        if (r13 != null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a3, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a6, code lost:
        throw r14;
     */
    private static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzkz.class) {
            zza(contentResolver);
            Object obj = zzk;
            String str3 = null;
            if (zzf.containsKey(str)) {
                String str4 = zzf.get(str);
                if (str4 != null) {
                    str3 = str4;
                }
                return str3;
            }
            for (String str5 : zzm) {
                if (str.startsWith(str5)) {
                    if (!zzl || zzf.isEmpty()) {
                        zzf.putAll(zza(contentResolver, zzm));
                        zzl = true;
                        if (zzf.containsKey(str)) {
                            String str6 = zzf.get(str);
                            if (str6 != null) {
                                str3 = str6;
                            }
                            return str3;
                        }
                    }
                    return null;
                }
            }
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzkz.class) {
            if (obj == zzk) {
                zzf.put(str, str2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006c A[SYNTHETIC] */
    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        Object zzb2 = zzb(contentResolver);
        HashMap<String, Boolean> hashMap = zzg;
        boolean z2 = true;
        boolean z3 = true;
        Boolean bool = (Boolean) zza((HashMap) hashMap, str, (Object) true);
        if (bool != null) {
            return bool.booleanValue();
        }
        String zza2 = zza(contentResolver, str, (String) null);
        if (zza2 != null && !zza2.equals("")) {
            if (!zzc.matcher(zza2).matches()) {
                if (zzd.matcher(zza2).matches()) {
                    z3 = false;
                    z2 = false;
                } else {
                    Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + zza2 + "\") as boolean");
                }
            }
            synchronized (zzkz.class) {
                if (zzb2 == zzk && zzf.remove(str) != null) {
                    hashMap.put(str, z3);
                }
            }
            return z2;
        }
        z3 = bool;
        synchronized (zzkz.class) {
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzb, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzkz.class) {
            zza(contentResolver);
            obj = zzk;
        }
        return obj;
    }

    private static <T> T zza(HashMap<String, T> hashMap, String str, T t) {
        synchronized (zzkz.class) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            T t2 = hashMap.get(str);
            if (t2 != null) {
                t = t2;
            }
            return t;
        }
    }
}
