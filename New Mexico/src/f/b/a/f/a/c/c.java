package f.b.a.f.a.c;

import android.os.Process;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public static final Map<String, Map<String, Integer>> a = new HashMap();

    static {
        new HashSet(Arrays.asList("app_update", "review"));
        new HashSet(Arrays.asList("native", "unity"));
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder(39);
        sb.append("UID: [");
        sb.append(myUid);
        sb.append("]  PID: [");
        sb.append(myPid);
        sb.append("] ");
        String valueOf = String.valueOf(sb.toString());
        if ("PlayCoreVersion".length() != 0) {
            valueOf.concat("PlayCoreVersion");
        } else {
            new String(valueOf);
        }
    }
}
