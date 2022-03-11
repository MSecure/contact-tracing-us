package f.b.a.b.i.p;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class k implements e {
    public final a a;
    public final i b;
    public final Map<String, m> c = new HashMap();

    /* loaded from: classes.dex */
    public static class a {
        public final Context a;
        public Map<String, String> b = null;

        public a(Context context) {
            this.a = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public d a(String str) {
            Bundle bundle;
            Map<String, String> map;
            PackageManager packageManager;
            ServiceInfo serviceInfo;
            if (this.b == null) {
                Context context = this.a;
                try {
                    packageManager = context.getPackageManager();
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (!(packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), 128)) == null)) {
                    bundle = serviceInfo.metaData;
                    if (bundle != null) {
                        map = Collections.emptyMap();
                    } else {
                        HashMap hashMap = new HashMap();
                        for (String str2 : bundle.keySet()) {
                            Object obj = bundle.get(str2);
                            if ((obj instanceof String) && str2.startsWith("backend:")) {
                                for (String str3 : ((String) obj).split(",", -1)) {
                                    String trim = str3.trim();
                                    if (!trim.isEmpty()) {
                                        hashMap.put(trim, str2.substring(8));
                                    }
                                }
                            }
                        }
                        map = hashMap;
                    }
                    this.b = map;
                }
                bundle = null;
                if (bundle != null) {
                }
                this.b = map;
            }
            String str4 = this.b.get(str);
            if (str4 == null) {
                return null;
            }
            try {
                return (d) Class.forName(str4).asSubclass(d.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException unused2) {
                String.format("Class %s is not found.", str4);
                return null;
            } catch (IllegalAccessException unused3) {
                String.format("Could not instantiate %s.", str4);
                return null;
            } catch (InstantiationException unused4) {
                String.format("Could not instantiate %s.", str4);
                return null;
            } catch (NoSuchMethodException unused5) {
                String.format("Could not instantiate %s", str4);
                return null;
            } catch (InvocationTargetException unused6) {
                String.format("Could not instantiate %s", str4);
                return null;
            }
        }
    }

    public k(Context context, i iVar) {
        a aVar = new a(context);
        this.a = aVar;
        this.b = iVar;
    }

    @Override // f.b.a.b.i.p.e
    public synchronized m a(String str) {
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        d a2 = this.a.a(str);
        if (a2 == null) {
            return null;
        }
        i iVar = this.b;
        m create = a2.create(new c(iVar.a, iVar.b, iVar.c, str));
        this.c.put(str, create);
        return create;
    }
}
