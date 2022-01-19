package com.google.gson.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Modifier;

public abstract class UnsafeAllocator {
    public static void assertInstantiable(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Interface can't be instantiated! Interface name: ");
            outline15.append(cls.getName());
            throw new UnsupportedOperationException(outline15.toString());
        } else if (Modifier.isAbstract(modifiers)) {
            StringBuilder outline152 = GeneratedOutlineSupport.outline15("Abstract class can't be instantiated! Class name: ");
            outline152.append(cls.getName());
            throw new UnsupportedOperationException(outline152.toString());
        }
    }

    public abstract <T> T newInstance(Class<T> cls) throws Exception;
}
