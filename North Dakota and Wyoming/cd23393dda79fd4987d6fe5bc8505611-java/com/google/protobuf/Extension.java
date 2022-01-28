package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.MessageLite;

public abstract class Extension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

    /* access modifiers changed from: protected */
    public enum ExtensionType {
        IMMUTABLE,
        MUTABLE,
        PROTO1
    }

    public enum MessageType {
        PROTO1,
        PROTO2
    }

    /* access modifiers changed from: protected */
    public abstract Object fromReflectionType(Object obj);

    public abstract Descriptors.FieldDescriptor getDescriptor();

    /* access modifiers changed from: protected */
    public abstract ExtensionType getExtensionType();

    @Override // com.google.protobuf.ExtensionLite
    public abstract Message getMessageDefaultInstance();

    /* access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionLite
    public final boolean isLite() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract Object singularFromReflectionType(Object obj);

    /* access modifiers changed from: protected */
    public abstract Object singularToReflectionType(Object obj);

    /* access modifiers changed from: protected */
    public abstract Object toReflectionType(Object obj);

    public MessageType getMessageType() {
        return MessageType.PROTO2;
    }
}
