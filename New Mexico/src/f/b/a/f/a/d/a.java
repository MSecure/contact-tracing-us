package f.b.a.f.a.d;

import f.b.a.f.a.h.o;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends o {
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public a(int i2) {
        super(String.format("Install Error(%d): %s", r0));
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        Map<Integer, String> map = f.b.a.f.a.d.b.a.a;
        Integer valueOf = Integer.valueOf(i2);
        if (map.containsKey(valueOf)) {
            Map<Integer, String> map2 = f.b.a.f.a.d.b.a.b;
            if (map2.containsKey(valueOf)) {
                String str2 = map.get(valueOf);
                String str3 = map2.get(valueOf);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 103 + String.valueOf(str3).length());
                sb.append(str2);
                sb.append(" (https://developer.android.com/reference/com/google/android/play/core/install/model/InstallErrorCode#");
                sb.append(str3);
                sb.append(")");
                str = sb.toString();
                objArr[1] = str;
                if (i2 != 0) {
                    throw new IllegalArgumentException("errorCode should not be 0.");
                }
                return;
            }
        }
        str = "";
        objArr[1] = str;
        if (i2 != 0) {
        }
    }
}
