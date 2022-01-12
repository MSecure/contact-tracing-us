package com.google.gson.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Modifier;

public abstract class UnsafeAllocator {
    public static void assertInstantiable(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Interface can't be instantiated! Interface name: ");
            outline17.append(cls.getName());
            throw new UnsupportedOperationException(outline17.toString());
        } else if (Modifier.isAbstract(modifiers)) {
            StringBuilder outline172 = GeneratedOutlineSupport.outline17("Abstract class can't be instantiated! Class name: ");
            outline172.append(cls.getName());
            throw new UnsupportedOperationException(outline172.toString());
        }
    }

    public abstract <T> T newInstance(Class<T> cls) throws Exception;
}
