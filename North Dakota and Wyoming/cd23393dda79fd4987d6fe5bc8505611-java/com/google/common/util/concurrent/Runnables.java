package com.google.common.util.concurrent;

public final class Runnables {
    private static final Runnable EMPTY_RUNNABLE = new Runnable() {
        /* class com.google.common.util.concurrent.Runnables.AnonymousClass1 */

        public void run() {
        }
    };

    public static Runnable doNothing() {
        return EMPTY_RUNNABLE;
    }

    private Runnables() {
    }
}
