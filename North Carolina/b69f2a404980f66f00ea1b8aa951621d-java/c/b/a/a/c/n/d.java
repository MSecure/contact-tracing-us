package c.b.a.a.c.n;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f2497a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f2498b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length << 1);
        for (int i = 0; i < length; i++) {
            sb.append(f2497a[(bArr[i] & 240) >>> 4]);
            sb.append(f2497a[bArr[i] & 15]);
        }
        return sb.toString();
    }
}
