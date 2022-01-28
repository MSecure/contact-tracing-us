package io.realm.internal;

import io.realm.RealmModel;
import io.realm.RealmObject;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Util {
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: java.lang.Class<? super ? extends io.realm.RealmModel>, java.lang.Object, java.lang.Class<? extends io.realm.RealmModel> */
    public static Class<? extends RealmModel> getOriginalModelClass(Class<? extends RealmModel> cls) {
        if (cls.equals(RealmModel.class) || cls.equals(RealmObject.class)) {
            throw new IllegalArgumentException("RealmModel or RealmObject was passed as an argument. Only subclasses of these can be used as arguments to methods that accept a Realm model class.");
        }
        Class superclass = cls.getSuperclass();
        return (superclass.equals(Object.class) || superclass.equals(RealmObject.class)) ? cls : superclass;
    }

    public static boolean isEmptyString(String str) {
        return str == null || str.length() == 0;
    }

    public static native String nativeGetTablePrefix();

    public static <T> Set<T> toSet(T... tArr) {
        if (tArr == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (T t : tArr) {
            if (t != null) {
                linkedHashSet.add(t);
            }
        }
        return linkedHashSet;
    }
}
