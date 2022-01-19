package io.realm;

import io.realm.internal.ColumnInfo;

public final class io_realm_sync_permissions_RoleRealmProxy$RoleColumnInfo extends ColumnInfo {
    public long membersColKey;
    public long nameColKey;

    @Override // io.realm.internal.ColumnInfo
    public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
        io_realm_sync_permissions_RoleRealmProxy$RoleColumnInfo io_realm_sync_permissions_rolerealmproxy_rolecolumninfo = (io_realm_sync_permissions_RoleRealmProxy$RoleColumnInfo) columnInfo;
        io_realm_sync_permissions_RoleRealmProxy$RoleColumnInfo io_realm_sync_permissions_rolerealmproxy_rolecolumninfo2 = (io_realm_sync_permissions_RoleRealmProxy$RoleColumnInfo) columnInfo2;
        io_realm_sync_permissions_rolerealmproxy_rolecolumninfo2.nameColKey = io_realm_sync_permissions_rolerealmproxy_rolecolumninfo.nameColKey;
        io_realm_sync_permissions_rolerealmproxy_rolecolumninfo2.membersColKey = io_realm_sync_permissions_rolerealmproxy_rolecolumninfo.membersColKey;
    }
}
