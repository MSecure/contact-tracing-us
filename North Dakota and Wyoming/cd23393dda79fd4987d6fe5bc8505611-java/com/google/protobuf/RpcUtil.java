package com.google.protobuf;

public final class RpcUtil {
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.protobuf.RpcCallback<com.google.protobuf.Message> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <Type extends Message> RpcCallback<Type> specializeCallback(RpcCallback<Message> rpcCallback) {
        return rpcCallback;
    }

    private RpcUtil() {
    }

    public static <Type extends Message> RpcCallback<Message> generalizeCallback(final RpcCallback<Type> rpcCallback, final Class<Type> cls, final Type type) {
        return new RpcCallback<Message>() {
            /* class com.google.protobuf.RpcUtil.AnonymousClass1 */

            public void run(Message message) {
                Message message2;
                try {
                    message2 = (Message) cls.cast(message);
                } catch (ClassCastException unused) {
                    message2 = RpcUtil.copyAsType(type, message);
                }
                rpcCallback.run(message2);
            }
        };
    }

    /* access modifiers changed from: private */
    public static <Type extends Message> Type copyAsType(Type type, Message message) {
        return (Type) type.newBuilderForType().mergeFrom(message).build();
    }

    public static <ParameterType> RpcCallback<ParameterType> newOneTimeCallback(final RpcCallback<ParameterType> rpcCallback) {
        return new RpcCallback<ParameterType>() {
            /* class com.google.protobuf.RpcUtil.AnonymousClass2 */
            private boolean alreadyCalled = false;

            @Override // com.google.protobuf.RpcCallback
            public void run(ParameterType parametertype) {
                synchronized (this) {
                    if (!this.alreadyCalled) {
                        this.alreadyCalled = true;
                    } else {
                        throw new AlreadyCalledException();
                    }
                }
                rpcCallback.run(parametertype);
            }
        };
    }

    public static final class AlreadyCalledException extends RuntimeException {
        private static final long serialVersionUID = 5469741279507848266L;

        public AlreadyCalledException() {
            super("This RpcCallback was already called and cannot be called multiple times.");
        }
    }
}
