package io.realm.internal.sync;

public class SubscriptionAction {
    public static final SubscriptionAction NO_SUBSCRIPTION = new SubscriptionAction(null, 0, false);
    public final String subscriptionName = null;
    public final long timeToLiveMs;
    public final boolean update;

    public SubscriptionAction(String str, long j, boolean z) {
        this.timeToLiveMs = j;
        this.update = z;
    }
}
