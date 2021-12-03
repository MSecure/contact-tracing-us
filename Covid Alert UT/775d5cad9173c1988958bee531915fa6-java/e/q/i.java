package e.q;

import android.app.Activity;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class i {
    public static AtomicBoolean a = new AtomicBoolean(false);

    public static class a extends d {
        @Override // e.q.d
        public void onActivityCreated(Activity activity, Bundle bundle) {
            x.c(activity);
        }

        @Override // e.q.d
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // e.q.d
        public void onActivityStopped(Activity activity) {
        }
    }
}
