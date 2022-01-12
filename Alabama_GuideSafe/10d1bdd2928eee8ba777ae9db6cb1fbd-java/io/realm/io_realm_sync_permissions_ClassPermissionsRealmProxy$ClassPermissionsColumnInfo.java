package io.realm;

import io.realm.internal.ColumnInfo;

public final class io_realm_sync_permissions_ClassPermissionsRealmProxy$ClassPermissionsColumnInfo extends ColumnInfo {
    public long nameColKey;
    public long permissionsColKey;

    @Override // io.realm.internal.ColumnInfo
    public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
        io_realm_sync_permissions_ClassPermissionsRealmProxy$ClassPermissionsColumnInfo io_realm_sync_permissions_classpermissionsrealmproxy_classpermissionscolumninfo = (io_realm_sync_permissions_ClassPermissionsRealmProxy$ClassPermissionsColumnInfo) columnInfo;
        io_realm_sync_permissions_ClassPermissionsRealmProxy$ClassPermissionsColumnInfo io_realm_sync_permissions_classpermissionsrealmproxy_classpermissionscolumninfo2 = (io_realm_sync_permissions_ClassPermissionsRealmProxy$ClassPermissionsColumnInfo) columnInfo2;
        io_realm_sync_permissions_classpermissionsrealmproxy_classpermissionscolumninfo2.nameColKey = io_realm_sync_permissions_classpermissionsrealmproxy_classpermissionscolumninfo.nameColKey;
        io_realm_sync_permissions_classpermissionsrealmproxy_classpermissionscolumninfo2.permissionsColKey = io_realm_sync_permissions_classpermissionsrealmproxy_classpermissionscolumninfo.permissionsColKey;
    }
}
