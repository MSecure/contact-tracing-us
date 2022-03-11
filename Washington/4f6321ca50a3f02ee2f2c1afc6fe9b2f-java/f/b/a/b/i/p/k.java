package f.b.a.b.i.p;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class k implements e {
    public final a a;
    public final i b;
    public final Map<String, m> c = new HashMap();

    public static class a {
        public final Context a;
        public Map<String, String> b = null;

        public a(Context context) {
            this.a = context;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
        public d a(String str) {
            String str2;
            Throwable e2;
            String str3;
            Throwable e3;
            Bundle bundle;
            Map<String, String> map;
            String str4;
            if (this.b == null) {
                Context context = this.a;
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager == null) {
                        str4 = "Context has no PackageManager.";
                    } else {
                        ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), 128);
                        if (serviceInfo == null) {
                            str4 = "TransportBackendDiscovery has no service info.";
                        } else {
                            bundle = serviceInfo.metaData;
                            if (bundle != null) {
                                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                                map = Collections.emptyMap();
                            } else {
                                HashMap hashMap = new HashMap();
                                for (String str5 : bundle.keySet()) {
                                    Object obj = bundle.get(str5);
                                    if ((obj instanceof String) && str5.startsWith("backend:")) {
                                        for (String str6 : ((String) obj).split(",", -1)) {
                                            String trim = str6.trim();
                                            if (!trim.isEmpty()) {
                                                hashMap.put(trim, str5.substring(8));
                                            }
                                        }
                                    }
                                }
                                map = hashMap;
                            }
                            this.b = map;
                        }
                    }
                    Log.w("BackendRegistry", str4);
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.w("BackendRegistry", "Application info not found.");
                }
                bundle = null;
                if (bundle != null) {
                }
                this.b = map;
            }
            String str7 = this.b.get(str);
            if (str7 == null) {
                return null;
            }
            try {
                return (d) Class.forName(str7).asSubclass(d.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e4) {
                e2 = e4;
                str2 = String.format("Class %s is not found.", str7);
                Log.w("BackendRegistry", str2, e2);
                return null;
            } catch (IllegalAccessException e5) {
                e2 = e5;
                str2 = String.format("Could not instantiate %s.", str7);
                Log.w("BackendRegistry", str2, e2);
                return null;
            } catch (InstantiationException e6) {
                e2 = e6;
                str2 = String.format("Could not instantiate %s.", str7);
                Log.w("BackendRegistry", str2, e2);
                return null;
            } catch (NoSuchMethodException e7) {
                e3 = e7;
                str3 = String.format("Could not instantiate %s", str7);
                Log.w("BackendRegistry", str3, e3);
                return null;
            } catch (InvocationTargetException e8) {
                e3 = e8;
                str3 = String.format("Could not instantiate %s", str7);
                Log.w("BackendRegistry", str3, e3);
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
