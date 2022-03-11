package e.a.e.f;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import e.a.e.f.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
    java.lang.UnsupportedOperationException
    	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
    	at java.util.AbstractList.equals(AbstractList.java:519)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
    */
/* loaded from: classes.dex */
public final class b extends a<String[], Map<String, Boolean>> {
    @Override // e.a.e.f.a
    public Intent a(Context context, Object obj) {
        return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", (String[]) obj);
    }

    public a.C0011a b(Context context, Object obj) {
        String[] strArr = (String[]) obj;
        if (strArr == null || strArr.length == 0) {
            return new a.C0011a(Collections.emptyMap());
        }
        e.f.a aVar = new e.f.a();
        boolean z = true;
        for (String str : strArr) {
            Object obj2 = e.j.b.a.a;
            Objects.requireNonNull(str, "permission must be non-null");
            boolean z2 = context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
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

    public Object c(int i2, Intent intent) {
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
