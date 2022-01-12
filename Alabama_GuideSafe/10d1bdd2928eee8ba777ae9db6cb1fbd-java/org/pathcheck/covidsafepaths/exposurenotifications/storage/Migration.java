package org.pathcheck.covidsafepaths.exposurenotifications.storage;

import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Migration.kt */
public final class Migration implements RealmMigration {
    @Override // io.realm.RealmMigration
    public void migrate(DynamicRealm dynamicRealm, long j, long j2) {
        long j3;
        RealmObjectSchema renameField;
        RealmObjectSchema removePrimaryKey;
        RealmObjectSchema transform;
        FieldAttribute fieldAttribute = FieldAttribute.PRIMARY_KEY;
        Intrinsics.checkNotNullParameter(dynamicRealm, "realm");
        RealmSchema realmSchema = dynamicRealm.schema;
        if (j == 1) {
            realmSchema.create("ExposureEntity").addField("id", Long.TYPE, fieldAttribute).addField("dateMillisSinceEpoch", Long.TYPE, new FieldAttribute[0]).addField("receivedTimestampMs", Long.TYPE, new FieldAttribute[0]);
            j3 = j + 1;
        } else {
            j3 = j;
        }
        if (j3 == 2) {
            RealmObjectSchema realmObjectSchema = realmSchema.get("KeyValues");
            if (!(realmObjectSchema == null || (renameField = realmObjectSchema.renameField("lastDownloadedKeyZipFileName", "value")) == null || (removePrimaryKey = renameField.removePrimaryKey()) == null || (transform = removePrimaryKey.transform(Migration$migrate$1.INSTANCE)) == null)) {
                transform.addPrimaryKey("id");
            }
            j3++;
        }
        if (j3 == 3) {
            realmSchema.remove("PositiveDiagnosis");
            j3++;
        }
        if (j3 == 4) {
            realmSchema.create("CheckInStatus").addField("id", String.class, fieldAttribute).addField("posixDate", Long.TYPE, new FieldAttribute[0]).addField("feelingGood", Integer.TYPE, new FieldAttribute[0]).addRealmListField("symptoms", String.class);
            j3++;
        }
        if (j3 == 5) {
            realmSchema.rename("CheckInStatus", "CheckIn").removeField("symptoms").renameField("posixDate", DatePickerDialogModule.ARG_DATE).renameField("feelingGood", "status").removePrimaryKey().removeField("id").addPrimaryKey(DatePickerDialogModule.ARG_DATE);
            realmSchema.create("SymptomLogEntry").addField("id", String.class, fieldAttribute, FieldAttribute.REQUIRED).addField(DatePickerDialogModule.ARG_DATE, Long.TYPE, new FieldAttribute[0]).addRealmListField("symptoms", String.class);
            j3++;
        }
        if (j3 == 6) {
            realmSchema.remove("CheckIn");
        }
    }
}
