package com.facebook.imagepipeline.memory;

import okhttp3.internal.ws.RealWebSocket;

public class BitmapCounterProvider {
    public static final int MAX_BITMAP_TOTAL_SIZE;
    public static volatile BitmapCounter sBitmapCounter;
    public static int sMaxBitmapCount = 384;

    static {
        int i;
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (((long) min) > RealWebSocket.MAX_QUEUE_SIZE) {
            i = (min / 4) * 3;
        } else {
            i = min / 2;
        }
        MAX_BITMAP_TOTAL_SIZE = i;
    }
}
