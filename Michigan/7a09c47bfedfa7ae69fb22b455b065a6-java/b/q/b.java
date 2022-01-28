package b.q;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import c.a.a.a.a;
import java.io.File;

public class b extends Application {
    public void attachBaseContext(Context context) {
        ApplicationInfo applicationInfo;
        super.attachBaseContext(context);
        if (!a.f2271b) {
            try {
                applicationInfo = getApplicationInfo();
            } catch (RuntimeException unused) {
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                try {
                    a.d(this, new File(applicationInfo.sourceDir), new File(applicationInfo.dataDir), "secondary-dexes", "", true);
                } catch (Exception e2) {
                    StringBuilder h = a.h("MultiDex installation failed (");
                    h.append(e2.getMessage());
                    h.append(").");
                    throw new RuntimeException(h.toString());
                }
            }
        }
    }
}
