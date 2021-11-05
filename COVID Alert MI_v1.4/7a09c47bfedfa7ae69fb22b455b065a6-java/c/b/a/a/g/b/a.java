package c.b.a.a.g.b;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile UserManager f3212a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f3213b = (!(Build.VERSION.SDK_INT >= 24));

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            boolean z = f3213b;
            if (!z) {
                UserManager userManager = f3212a;
                if (userManager == null) {
                    synchronized (a.class) {
                        userManager = f3212a;
                        if (userManager == null) {
                            UserManager userManager2 = (UserManager) context.getSystemService(UserManager.class);
                            f3212a = userManager2;
                            if (userManager2 == null) {
                                f3213b = true;
                                z = true;
                            } else {
                                userManager = userManager2;
                            }
                        }
                    }
                }
                z = userManager.isUserUnlocked();
                f3213b = z;
                if (z) {
                    f3212a = null;
                }
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }
}
