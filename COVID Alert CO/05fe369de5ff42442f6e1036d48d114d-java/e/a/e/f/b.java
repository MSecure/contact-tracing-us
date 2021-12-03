package e.a.e.f;

import android.content.Context;
import android.content.Intent;
import e.a.e.f.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class b extends a<String[], Map<String, Boolean>> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.Object] */
    @Override // e.a.e.f.a
    public Intent a(Context context, String[] strArr) {
        return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
    }

    /* Return type fixed from 'e.a.e.f.a$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.Object] */
    @Override // e.a.e.f.a
    public a.C0011a<Map<String, Boolean>> b(Context context, String[] strArr) {
        String[] strArr2 = strArr;
        if (strArr2 == null || strArr2.length == 0) {
            return new a.C0011a(Collections.emptyMap());
        }
        e.e.a aVar = new e.e.a();
        boolean z = true;
        for (String str : strArr2) {
            boolean z2 = e.i.b.a.a(context, str) == 0;
            aVar.put(str, Boolean.valueOf(z2));
            if (!z2) {
                z = false;
            }
        }
        if (z) {
            return new a.C0011a(aVar);
        }
        return null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // e.a.e.f.a
    public Map<String, Boolean> c(int i2, Intent intent) {
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
