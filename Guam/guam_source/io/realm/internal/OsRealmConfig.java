package io.realm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.CompactOnLaunchCallback;
import io.realm.RealmConfiguration;
import io.realm.internal.OsSharedRealm;
import io.realm.log.RealmLog;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class OsRealmConfig implements NativeObject {
    public static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    public final CompactOnLaunchCallback compactOnLaunchCallback;
    public final NativeContext context = new NativeContext();
    public final long nativePtr;
    public final RealmConfiguration realmConfiguration;
    public final URI resolvedRealmURI;

    /* renamed from: io.realm.internal.OsRealmConfig$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$java$net$Proxy$Type;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            $SwitchMap$java$net$Proxy$Type = iArr;
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class Builder {
        public boolean autoUpdateNotification = false;
        public RealmConfiguration configuration;
        public String fifoFallbackDir = "";
        public OsSharedRealm.InitializationCallback initializationCallback = null;
        public OsSharedRealm.MigrationCallback migrationCallback = null;
        public OsSchemaInfo schemaInfo = null;

        public Builder(RealmConfiguration realmConfiguration) {
            this.configuration = realmConfiguration;
        }

        public OsRealmConfig build() {
            return new OsRealmConfig(this.configuration, this.fifoFallbackDir, this.autoUpdateNotification, this.schemaInfo, this.migrationCallback, this.initializationCallback, null);
        }
    }

    public enum Durability {
        FULL(0),
        MEM_ONLY(1);

        /* access modifiers changed from: public */
        Durability(int i) {
        }
    }

    public enum SchemaMode {
        SCHEMA_MODE_AUTOMATIC((byte) 0),
        SCHEMA_MODE_IMMUTABLE((byte) 1),
        SCHEMA_MODE_READONLY((byte) 2),
        SCHEMA_MODE_RESET_FILE((byte) 3),
        SCHEMA_MODE_ADDITIVE((byte) 4),
        SCHEMA_MODE_MANUAL((byte) 5);
        
        public final byte value;

        /* access modifiers changed from: public */
        SchemaMode(byte b) {
            this.value = b;
        }
    }

    public OsRealmConfig(RealmConfiguration realmConfiguration2, String str, boolean z, OsSchemaInfo osSchemaInfo, OsSharedRealm.MigrationCallback migrationCallback, OsSharedRealm.InitializationCallback initializationCallback, AnonymousClass1 r33) {
        long j;
        URI uri;
        int i;
        URI uri2;
        URI uri3;
        this.realmConfiguration = realmConfiguration2;
        boolean z2 = true;
        this.nativePtr = nativeCreate(realmConfiguration2.canonicalPath, str, true, realmConfiguration2.maxNumberOfActiveVersions);
        NativeContext.dummyContext.addReference(this);
        if (ObjectServerFacade.getSyncFacadeIfPossible() != null) {
            Object[] objArr = new Object[12];
            String str2 = (String) objArr[0];
            String str3 = (String) objArr[1];
            String str4 = (String) objArr[2];
            String str5 = (String) objArr[3];
            boolean equals = Boolean.TRUE.equals(objArr[4]);
            String str6 = (String) objArr[5];
            Byte b = (Byte) objArr[6];
            boolean equals2 = Boolean.TRUE.equals(objArr[7]);
            String str7 = (String) objArr[8];
            String str8 = (String) objArr[9];
            Byte b2 = (Byte) objArr[11];
            Map map = (Map) objArr[10];
            String[] strArr = new String[(map != null ? map.size() * 2 : 0)];
            if (map != null) {
                int i2 = 0;
                for (Map.Entry entry : map.entrySet()) {
                    strArr[i2] = (String) entry.getKey();
                    strArr[i2 + 1] = (String) entry.getValue();
                    i2 += 2;
                }
            }
            byte[] encryptionKey = realmConfiguration2.getEncryptionKey();
            if (encryptionKey != null) {
                nativeSetEncryptionKey(this.nativePtr, encryptionKey);
            }
            nativeSetInMemory(this.nativePtr, realmConfiguration2.durability != Durability.MEM_ONLY ? false : z2);
            nativeEnableChangeNotification(this.nativePtr, z);
            SchemaMode schemaMode = SchemaMode.SCHEMA_MODE_MANUAL;
            if (realmConfiguration2.isRecoveryConfiguration) {
                schemaMode = SchemaMode.SCHEMA_MODE_IMMUTABLE;
            } else if (realmConfiguration2.readOnly) {
                schemaMode = SchemaMode.SCHEMA_MODE_READONLY;
            } else if (str3 != null) {
                schemaMode = SchemaMode.SCHEMA_MODE_ADDITIVE;
            } else if (realmConfiguration2.deleteRealmIfMigrationNeeded) {
                schemaMode = SchemaMode.SCHEMA_MODE_RESET_FILE;
            }
            long j2 = realmConfiguration2.schemaVersion;
            if (osSchemaInfo == null) {
                j = 0;
            } else {
                j = osSchemaInfo.nativePtr;
            }
            nativeSetSchemaConfig(this.nativePtr, schemaMode.value, j2, j, migrationCallback);
            CompactOnLaunchCallback compactOnLaunchCallback2 = realmConfiguration2.compactOnLaunch;
            this.compactOnLaunchCallback = compactOnLaunchCallback2;
            if (compactOnLaunchCallback2 != null) {
                nativeSetCompactOnLaunchCallback(this.nativePtr, compactOnLaunchCallback2);
            }
            if (initializationCallback != null) {
                nativeSetInitializationCallback(this.nativePtr, initializationCallback);
            }
            if (str3 != null) {
                String nativeCreateAndSetSyncConfig = nativeCreateAndSetSyncConfig(this.nativePtr, str3, str4, str2, str5, equals2, b.byteValue(), str7, str8, strArr, b2.byteValue());
                try {
                    uri2 = new URI(nativeCreateAndSetSyncConfig);
                    i = 6;
                } catch (URISyntaxException e) {
                    i = 6;
                    RealmLog.log(6, e, "Cannot create a URI from the Realm URL address", new Object[0]);
                    uri2 = null;
                }
                uri = uri2;
                nativeSetSyncConfigSslSettings(this.nativePtr, equals, str6);
                ProxySelector proxySelector = ProxySelector.getDefault();
                if (!(uri == null || proxySelector == null)) {
                    try {
                        uri3 = new URI(nativeCreateAndSetSyncConfig.replaceFirst("realm", "http"));
                    } catch (URISyntaxException e2) {
                        RealmLog.log(i, e2, "Cannot create a URI from the Realm URL address", new Object[0]);
                        uri3 = null;
                    }
                    List<Proxy> select = proxySelector.select(uri3);
                    if (select != null && !select.isEmpty()) {
                        Proxy proxy = select.get(0);
                        if (proxy.type() != Proxy.Type.DIRECT) {
                            byte b3 = AnonymousClass1.$SwitchMap$java$net$Proxy$Type[proxy.type().ordinal()] == 1 ? (byte) 0 : -1;
                            if (proxy.type() == Proxy.Type.HTTP) {
                                SocketAddress address = proxy.address();
                                if (address instanceof InetSocketAddress) {
                                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                                    nativeSetSyncConfigProxySettings(this.nativePtr, b3, inetSocketAddress.getHostString(), inetSocketAddress.getPort());
                                } else {
                                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("Unsupported proxy socket address type: ");
                                    outline15.append(address.getClass().getName());
                                    RealmLog.error(outline15.toString(), new Object[0]);
                                }
                            } else {
                                RealmLog.error("SOCKS proxies are not supported.", new Object[0]);
                            }
                        }
                    }
                }
            } else {
                uri = null;
            }
            this.resolvedRealmURI = uri;
            return;
        }
        throw null;
    }

    public static native long nativeCreate(String str, String str2, boolean z, long j);

    public static native String nativeCreateAndSetSyncConfig(long j, String str, String str2, String str3, String str4, boolean z, byte b, String str5, String str6, String[] strArr, byte b2);

    public static native void nativeEnableChangeNotification(long j, boolean z);

    public static native long nativeGetFinalizerPtr();

    public static native void nativeSetCompactOnLaunchCallback(long j, CompactOnLaunchCallback compactOnLaunchCallback2);

    public static native void nativeSetEncryptionKey(long j, byte[] bArr);

    public static native void nativeSetInMemory(long j, boolean z);

    private native void nativeSetInitializationCallback(long j, OsSharedRealm.InitializationCallback initializationCallback);

    private native void nativeSetSchemaConfig(long j, byte b, long j2, long j3, OsSharedRealm.MigrationCallback migrationCallback);

    public static native void nativeSetSyncConfigProxySettings(long j, byte b, String str, int i);

    public static native void nativeSetSyncConfigSslSettings(long j, boolean z, String str);

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }
}
