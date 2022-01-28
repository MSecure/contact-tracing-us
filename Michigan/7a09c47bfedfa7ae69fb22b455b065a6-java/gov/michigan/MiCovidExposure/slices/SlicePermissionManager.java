package gov.michigan.MiCovidExposure.slices;

public interface SlicePermissionManager {
    boolean callingUidHasAccess();

    void grantSlicePermission();
}
