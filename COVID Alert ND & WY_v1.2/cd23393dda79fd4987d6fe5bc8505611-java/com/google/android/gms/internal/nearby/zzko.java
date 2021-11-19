package com.google.android.gms.internal.nearby;

import android.os.ParcelUuid;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.util.Hex;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzko {
    private static final ParcelUuid zza = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    private final int zzb;
    private final List<ParcelUuid> zzc;
    private final SparseArray<byte[]> zzd;
    private final Map<ParcelUuid, byte[]> zze;
    private final int zzf;
    private final String zzg;
    private final byte[] zzh;

    private zzko(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.zzc = list;
        this.zzd = sparseArray;
        this.zze = map;
        this.zzg = str;
        this.zzb = i;
        this.zzf = i2;
        this.zzh = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c A[Catch:{ Exception -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008e A[Catch:{ Exception -> 0x0097 }] */
    public static zzko zza(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i = 0;
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        HashMap hashMap = new HashMap();
        String str = null;
        int i2 = -1;
        byte b = -2147483648;
        while (i < bArr.length) {
            try {
                int i3 = i + 1;
                int i4 = bArr[i] & 255;
                if (i4 != 0) {
                    int i5 = i4 - 1;
                    int i6 = i3 + 1;
                    int i7 = bArr[i3] & 255;
                    if (i7 == 22) {
                        hashMap.put(zzb(zza(bArr, i6, 2)), zza(bArr, i6 + 2, i5 - 2));
                    } else if (i7 != 255) {
                        switch (i7) {
                            case 1:
                                i2 = bArr[i6] & 255;
                                continue;
                            case 2:
                            case 3:
                                zza(bArr, i6, i5, 2, arrayList);
                                continue;
                            case 4:
                            case 5:
                                zza(bArr, i6, i5, 4, arrayList);
                                continue;
                            case 6:
                            case 7:
                                zza(bArr, i6, i5, 16, arrayList);
                                continue;
                            case 8:
                            case 9:
                                str = new String(zza(bArr, i6, i5));
                                continue;
                            case 10:
                                b = bArr[i6];
                                continue;
                            default:
                                continue;
                        }
                    } else {
                        sparseArray.put(((bArr[i6 + 1] & 255) << 8) + (255 & bArr[i6]), zza(bArr, i6 + 2, i5 - 2));
                    }
                    i = i5 + i6;
                } else {
                    return new zzko(!arrayList.isEmpty() ? null : arrayList, sparseArray, hashMap, i2, b, str, bArr);
                }
            } catch (Exception e) {
                String valueOf = String.valueOf(Arrays.toString(bArr));
                Log.w("BleRecord", valueOf.length() != 0 ? "Unable to parse scan record: ".concat(valueOf) : new String("Unable to parse scan record: "), e);
                return null;
            }
        }
        return new zzko(!arrayList.isEmpty() ? null : arrayList, sparseArray, hashMap, i2, b, str, bArr);
    }

    private static int zza(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(zzb(zza(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private static byte[] zza(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public final String toString() {
        String str;
        int i = this.zzb;
        String valueOf = String.valueOf(this.zzc);
        SparseArray<byte[]> sparseArray = this.zzd;
        StringBuilder sb = new StringBuilder();
        String str2 = "{}";
        int i2 = 0;
        if (sparseArray.size() <= 0) {
            str = str2;
        } else {
            sb.append('{');
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                if (i3 > 0) {
                    sb.append(", ");
                }
                int keyAt = sparseArray.keyAt(i3);
                byte[] valueAt = sparseArray.valueAt(i3);
                sb.append(keyAt);
                sb.append('=');
                sb.append(valueAt == null ? null : Hex.bytesToStringUppercase(valueAt));
            }
            sb.append('}');
            str = sb.toString();
        }
        Map<ParcelUuid, byte[]> map = this.zze;
        StringBuilder sb2 = new StringBuilder();
        if (map.keySet().size() > 0) {
            sb2.append('{');
            for (Map.Entry<ParcelUuid, byte[]> entry : map.entrySet()) {
                if (i2 > 0) {
                    sb2.append(", ");
                }
                sb2.append(entry.getKey());
                sb2.append('=');
                byte[] value = entry.getValue();
                sb2.append(value == null ? null : Hex.bytesToStringUppercase(value));
                i2++;
            }
            sb2.append('}');
            str2 = sb2.toString();
        }
        int i4 = this.zzf;
        String str3 = this.zzg;
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 139 + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb3.append("BleRecord [mAdvertiseFlags=");
        sb3.append(i);
        sb3.append(", mServiceUuids=");
        sb3.append(valueOf);
        sb3.append(", mManufacturerSpecificData=");
        sb3.append(str);
        sb3.append(", mServiceData=");
        sb3.append(str2);
        sb3.append(", mTxPowerLevel=");
        sb3.append(i4);
        sb3.append(", mDeviceName=");
        sb3.append(str3);
        sb3.append("]");
        return sb3.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzko)) {
            return false;
        }
        return Arrays.equals(this.zzh, ((zzko) obj).zzh);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzh);
    }

    private static ParcelUuid zzb(byte[] bArr) {
        long j;
        if (bArr != null) {
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                StringBuilder sb = new StringBuilder(38);
                sb.append("uuidBytes length invalid - ");
                sb.append(length);
                throw new IllegalArgumentException(sb.toString());
            } else if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            } else {
                if (length == 2) {
                    j = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
                } else {
                    j = ((long) ((bArr[3] & 255) << 24)) + ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8)) + ((long) ((bArr[2] & 255) << 16));
                }
                ParcelUuid parcelUuid = zza;
                return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j << 32), parcelUuid.getUuid().getLeastSignificantBits()));
            }
        } else {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
    }
}
