package io.realm.internal;

import io.realm.exceptions.RealmException;
import java.lang.reflect.InvocationTargetException;

public class ObjectServerFacade {
    public static final ObjectServerFacade nonSyncFacade = new ObjectServerFacade();
    public static ObjectServerFacade syncFacade;

    static {
        try {
            syncFacade = (ObjectServerFacade) Class.forName("io.realm.internal.SyncObjectServerFacade").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
        } catch (InstantiationException e) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e);
        } catch (IllegalAccessException e2) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e2);
        } catch (NoSuchMethodException e3) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e3);
        } catch (InvocationTargetException e4) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e4.getTargetException());
        }
    }

    public static ObjectServerFacade getFacade(boolean z) {
        if (z) {
            return syncFacade;
        }
        return nonSyncFacade;
    }

    public static ObjectServerFacade getSyncFacadeIfPossible() {
        ObjectServerFacade objectServerFacade = syncFacade;
        if (objectServerFacade != null) {
            return objectServerFacade;
        }
        return nonSyncFacade;
    }
}
