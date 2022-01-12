package io.realm;

import io.realm.internal.ColumnInfo;

public final class io_realm_sync_permissions_RealmPermissionsRealmProxy$RealmPermissionsColumnInfo extends ColumnInfo {
    public long idColKey;
    public long permissionsColKey;

    @Override // io.realm.internal.ColumnInfo
    public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
        io_realm_sync_permissions_RealmPermissionsRealmProxy$RealmPermissionsColumnInfo io_realm_sync_permissions_realmpermissionsrealmproxy_realmpermissionscolumninfo = (io_realm_sync_permissions_RealmPermissionsRealmProxy$RealmPermissionsColumnInfo) columnInfo;
        io_realm_sync_permissions_RealmPermissionsRealmProxy$RealmPermissionsColumnInfo io_realm_sync_permissions_realmpermissionsrealmproxy_realmpermissionscolumninfo2 = (io_realm_sync_permissions_RealmPermissionsRealmProxy$RealmPermissionsColumnInfo) columnInfo2;
        io_realm_sync_permissions_realmpermissionsrealmproxy_realmpermissionscolumninfo2.idColKey = io_realm_sync_permissions_realmpermissionsrealmproxy_realmpermissionscolumninfo.idColKey;
        io_realm_sync_permissions_realmpermissionsrealmproxy_realmpermissionscolumninfo2.permissionsColKey = io_realm_sync_permissions_realmpermissionsrealmproxy_realmpermissionscolumninfo.permissionsColKey;
    }
}
