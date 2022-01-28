package c.b.c.a.m0;

public final class m {
    public static void a(long[] jArr, long[] jArr2, int i) {
        int i2 = -i;
        for (int i3 = 0; i3 < 10; i3++) {
            jArr[i3] = (long) (((((int) jArr[i3]) ^ ((int) jArr2[i3])) & i2) ^ ((int) jArr[i3]));
        }
    }
}
