package androidx.fragment.app;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import com.android.tools.r8.GeneratedOutlineSupport;

public class FragmentFactory {
    public static final SimpleArrayMap<String, Class<?>> sClassMap = new SimpleArrayMap<>();

    public static boolean isFragmentClass(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(loadClass(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class<?> loadClass(ClassLoader classLoader, String str) throws ClassNotFoundException {
        Class<?> orDefault = sClassMap.getOrDefault(str, null);
        if (orDefault != null) {
            return orDefault;
        }
        Class<?> cls = Class.forName(str, false, classLoader);
        sClassMap.put(str, cls);
        return cls;
    }

    /* JADX DEBUG: Type inference failed for r3v3. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends androidx.fragment.app.Fragment> */
    public static Class<? extends Fragment> loadFragmentClass(ClassLoader classLoader, String str) {
        try {
            return loadClass(classLoader, str);
        } catch (ClassNotFoundException e) {
            throw new Fragment.InstantiationException(GeneratedOutlineSupport.outline9("Unable to instantiate fragment ", str, ": make sure class name exists"), e);
        } catch (ClassCastException e2) {
            throw new Fragment.InstantiationException(GeneratedOutlineSupport.outline9("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e2);
        }
    }

    public abstract Fragment instantiate(ClassLoader classLoader, String str);
}
