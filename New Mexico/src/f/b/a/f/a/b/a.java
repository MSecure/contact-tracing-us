package f.b.a.f.a.b;

import f.b.a.f.a.h.o;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends o {
    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public a(int i2) {
        super(String.format("Asset Pack Download Error(%d): %s", r0));
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        Map<Integer, String> map = f.b.a.f.a.b.c.a.a;
        Integer valueOf = Integer.valueOf(i2);
        if (!map.containsKey(valueOf)) {
            str = "";
        } else {
            String str2 = map.get(valueOf);
            String str3 = f.b.a.f.a.b.c.a.b.get(valueOf);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 113 + String.valueOf(str3).length());
            sb.append(str2);
            sb.append(" (https://developer.android.com/reference/com/google/android/play/core/assetpacks/model/AssetPackErrorCode.html#");
            sb.append(str3);
            sb.append(")");
            str = sb.toString();
        }
        objArr[1] = str;
        if (i2 == 0) {
            throw new IllegalArgumentException("errorCode should not be 0.");
        }
    }
}
