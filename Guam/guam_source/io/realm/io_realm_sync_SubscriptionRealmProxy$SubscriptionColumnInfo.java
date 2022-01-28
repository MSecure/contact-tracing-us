package io.realm;

import io.realm.internal.ColumnInfo;

public final class io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo extends ColumnInfo {
    public long createdAtColKey;
    public long errorMessageColKey;
    public long expiresAtColKey;
    public long matchesPropertyColKey;
    public long nameColKey;
    public long queryColKey;
    public long queryParseCounterColKey;
    public long statusColKey;
    public long timeToLiveColKey;
    public long updatedAtColKey;

    @Override // io.realm.internal.ColumnInfo
    public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
        io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo = (io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo) columnInfo;
        io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2 = (io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo) columnInfo2;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.nameColKey = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.nameColKey;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.statusColKey = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.statusColKey;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.errorMessageColKey = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.errorMessageColKey;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.matchesPropertyColKey = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.matchesPropertyColKey;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.queryColKey = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.queryColKey;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.queryParseCounterColKey = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.queryParseCounterColKey;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.createdAtColKey = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.createdAtColKey;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.updatedAtColKey = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.updatedAtColKey;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.expiresAtColKey = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.expiresAtColKey;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.timeToLiveColKey = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.timeToLiveColKey;
    }
}
