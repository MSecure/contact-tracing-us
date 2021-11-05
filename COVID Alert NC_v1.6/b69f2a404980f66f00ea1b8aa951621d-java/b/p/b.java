package b.p;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import c.a.a.a.a;
import java.io.File;

public class b extends Application {
    public void attachBaseContext(Context context) {
        ApplicationInfo applicationInfo;
        super.attachBaseContext(context);
        if (!a.f1435b) {
            try {
                applicationInfo = getApplicationInfo();
            } catch (RuntimeException unused) {
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                try {
                    a.d(this, new File(applicationInfo.sourceDir), new File(applicationInfo.dataDir), "secondary-dexes", "", true);
                } catch (Exception e2) {
                    StringBuilder g = a.g("MultiDex installation failed (");
                    g.append(e2.getMessage());
                    g.append(").");
                    throw new RuntimeException(g.toString());
                }
            }
        }
    }
}
