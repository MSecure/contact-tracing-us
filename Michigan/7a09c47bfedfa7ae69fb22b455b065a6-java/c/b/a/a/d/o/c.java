package c.b.a.a.d.o;

import androidx.annotation.RecentlyNonNull;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f3173a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f3174b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @RecentlyNonNull
    public static String a(@RecentlyNonNull byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length << 1);
        for (int i = 0; i < length; i++) {
            sb.append(f3173a[(bArr[i] & 240) >>> 4]);
            sb.append(f3173a[bArr[i] & 15]);
        }
        return sb.toString();
    }
}
