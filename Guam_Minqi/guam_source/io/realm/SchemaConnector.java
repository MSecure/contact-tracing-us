package io.realm;

import io.realm.internal.fields.FieldDescriptor;

public class SchemaConnector implements FieldDescriptor.SchemaProxy {
    public final RealmSchema schema;

    public SchemaConnector(RealmSchema realmSchema) {
        this.schema = realmSchema;
    }
}
