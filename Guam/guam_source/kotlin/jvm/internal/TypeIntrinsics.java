package kotlin.jvm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;

public class TypeIntrinsics {
    public static Map asMutableMap(Object obj) {
        String str;
        if (obj instanceof KMappedMarker) {
            if (obj == null) {
                str = "null";
            } else {
                str = obj.getClass().getName();
            }
            ClassCastException classCastException = new ClassCastException(GeneratedOutlineSupport.outline9(str, " cannot be cast to ", "kotlin.collections.MutableMap"));
            Intrinsics.sanitizeStackTrace(classCastException, TypeIntrinsics.class.getName());
            throw classCastException;
        }
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            Intrinsics.sanitizeStackTrace(e, TypeIntrinsics.class.getName());
            throw e;
        }
    }

    public static boolean isMutableMap(Object obj) {
        return (obj instanceof Map) && !(obj instanceof KMappedMarker);
    }
}
