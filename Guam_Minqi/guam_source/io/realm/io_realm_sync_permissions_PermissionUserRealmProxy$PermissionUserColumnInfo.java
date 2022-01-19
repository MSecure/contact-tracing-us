package io.realm;

import io.realm.internal.ColumnInfo;

public final class io_realm_sync_permissions_PermissionUserRealmProxy$PermissionUserColumnInfo extends ColumnInfo {
    public long idColKey;
    public long roleColKey;

    @Override // io.realm.internal.ColumnInfo
    public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
        io_realm_sync_permissions_PermissionUserRealmProxy$PermissionUserColumnInfo io_realm_sync_permissions_permissionuserrealmproxy_permissionusercolumninfo = (io_realm_sync_permissions_PermissionUserRealmProxy$PermissionUserColumnInfo) columnInfo;
        io_realm_sync_permissions_PermissionUserRealmProxy$PermissionUserColumnInfo io_realm_sync_permissions_permissionuserrealmproxy_permissionusercolumninfo2 = (io_realm_sync_permissions_PermissionUserRealmProxy$PermissionUserColumnInfo) columnInfo2;
        io_realm_sync_permissions_permissionuserrealmproxy_permissionusercolumninfo2.idColKey = io_realm_sync_permissions_permissionuserrealmproxy_permissionusercolumninfo.idColKey;
        io_realm_sync_permissions_permissionuserrealmproxy_permissionusercolumninfo2.roleColKey = io_realm_sync_permissions_permissionuserrealmproxy_permissionusercolumninfo.roleColKey;
    }
}
