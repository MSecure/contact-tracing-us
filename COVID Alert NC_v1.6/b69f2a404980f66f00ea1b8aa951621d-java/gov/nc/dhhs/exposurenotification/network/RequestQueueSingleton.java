package gov.nc.dhhs.exposurenotification.network;

import android.content.Context;
import c.a.b.p;
import c.a.b.x.a;
import c.a.b.x.b;
import c.a.b.x.d;
import c.a.b.x.f;
import c.a.b.x.i;
import gov.nc.dhhs.exposurenotification.utils.CustomUtility;
import java.io.File;

public class RequestQueueSingleton {
    public static p queue;

    public static p get(Context context) {
        if (queue == null) {
            try {
                queue = new p(new i(), new b(new f()));
            } catch (Exception e2) {
                e2.printStackTrace();
                CustomUtility.customLogger("Error in RequestQueueSingleton > get() : " + e2.getMessage());
            }
            queue.b();
        }
        return queue;
    }

    public static void setHttpStackForTests(Context context, a aVar) {
        p pVar = new p(new d(new File(context.getApplicationContext().getCacheDir(), "volley")), aVar == null ? new b(new f()) : new b(aVar));
        pVar.b();
        queue = pVar;
    }
}
