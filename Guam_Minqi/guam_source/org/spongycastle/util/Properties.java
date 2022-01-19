package org.spongycastle.util;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Map;
import org.pathcheck.covidsafepaths.BuildConfig;

public class Properties {
    public static final ThreadLocal threadProperties = new ThreadLocal();

    public static boolean isOverrideSet(final String str) {
        try {
            String str2 = (String) AccessController.doPrivileged(new PrivilegedAction() {
                /* class org.spongycastle.util.Properties.AnonymousClass1 */

                @Override // java.security.PrivilegedAction
                public Object run() {
                    Map map = (Map) Properties.threadProperties.get();
                    if (map != null) {
                        return map.get(str);
                    }
                    return System.getProperty(str);
                }
            });
            if (str2 != null) {
                return BuildConfig.DISPLAY_CALL_EMERGENCY_SERVICES.equals(Strings.toLowerCase(str2));
            }
            return false;
        } catch (AccessControlException unused) {
            return false;
        }
    }
}
