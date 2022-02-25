package e.a.e.f;

import android.content.Intent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class b extends a<String[], Map<String, Boolean>> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // e.a.e.f.a
    public Map<String, Boolean> a(int i2, Intent intent) {
        if (i2 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (!(intArrayExtra == null || stringArrayExtra == null)) {
                HashMap hashMap = new HashMap();
                int length = stringArrayExtra.length;
                for (int i3 = 0; i3 < length; i3++) {
                    hashMap.put(stringArrayExtra[i3], Boolean.valueOf(intArrayExtra[i3] == 0));
                }
                return hashMap;
            }
        }
        return Collections.emptyMap();
    }
}
