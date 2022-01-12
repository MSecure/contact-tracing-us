package io.realm;

public interface org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface {
    long realmGet$date();

    String realmGet$id();

    RealmList<String> realmGet$symptoms();

    void realmSet$date(long j);

    void realmSet$id(String str);

    void realmSet$symptoms(RealmList<String> realmList);
}
