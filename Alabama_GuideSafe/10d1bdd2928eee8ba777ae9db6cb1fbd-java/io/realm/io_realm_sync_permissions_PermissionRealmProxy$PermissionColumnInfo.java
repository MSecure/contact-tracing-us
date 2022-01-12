package io.realm;

import io.realm.internal.ColumnInfo;

public final class io_realm_sync_permissions_PermissionRealmProxy$PermissionColumnInfo extends ColumnInfo {
    public long canCreateColKey;
    public long canDeleteColKey;
    public long canModifySchemaColKey;
    public long canQueryColKey;
    public long canReadColKey;
    public long canSetPermissionsColKey;
    public long canUpdateColKey;
    public long roleColKey;

    @Override // io.realm.internal.ColumnInfo
    public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
        io_realm_sync_permissions_PermissionRealmProxy$PermissionColumnInfo io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo = (io_realm_sync_permissions_PermissionRealmProxy$PermissionColumnInfo) columnInfo;
        io_realm_sync_permissions_PermissionRealmProxy$PermissionColumnInfo io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2 = (io_realm_sync_permissions_PermissionRealmProxy$PermissionColumnInfo) columnInfo2;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.roleColKey = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.roleColKey;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.canReadColKey = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.canReadColKey;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.canUpdateColKey = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.canUpdateColKey;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.canDeleteColKey = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.canDeleteColKey;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.canSetPermissionsColKey = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.canSetPermissionsColKey;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.canQueryColKey = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.canQueryColKey;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.canCreateColKey = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.canCreateColKey;
        io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo2.canModifySchemaColKey = io_realm_sync_permissions_permissionrealmproxy_permissioncolumninfo.canModifySchemaColKey;
    }
}
