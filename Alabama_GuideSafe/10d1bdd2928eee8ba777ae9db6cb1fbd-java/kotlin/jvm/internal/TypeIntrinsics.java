package kotlin.jvm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

public class TypeIntrinsics {
    public static Map asMutableMap(Object obj) {
        if (obj instanceof KMappedMarker) {
            throwCce(obj, "kotlin.collections.MutableMap");
            throw null;
        }
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            Intrinsics.sanitizeStackTrace(e, TypeIntrinsics.class.getName());
            throw e;
        }
    }

    public static Object beforeCheckcastToFunctionOfArity(Object obj, int i) {
        int i2;
        boolean z = true;
        if (obj instanceof FunctionBase) {
            i2 = ((FunctionBase) obj).getArity();
        } else if (obj instanceof Function0) {
            i2 = 0;
        } else {
            i2 = obj instanceof Function1 ? 1 : 2;
        }
        if (i2 != i) {
            z = false;
        }
        if (z) {
            return obj;
        }
        throwCce(obj, "kotlin.jvm.functions.Function" + i);
        throw null;
    }

    public static boolean isMutableMap(Object obj) {
        return (obj instanceof Map) && !(obj instanceof KMappedMarker);
    }

    public static void throwCce(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(GeneratedOutlineSupport.outline11(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        Intrinsics.sanitizeStackTrace(classCastException, TypeIntrinsics.class.getName());
        throw classCastException;
    }
}
