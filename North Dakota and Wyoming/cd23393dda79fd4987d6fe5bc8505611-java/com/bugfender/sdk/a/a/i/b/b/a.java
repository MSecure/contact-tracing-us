package com.bugfender.sdk.a.a.i.b.b;

import com.bugfender.sdk.a.a.h.f;
import com.bugfender.sdk.a.a.h.g;
import com.bugfender.sdk.a.a.h.h;
import com.bugfender.sdk.a.a.i.c.b.a;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.messaging.Constants;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    public static class b {

        /* renamed from: com.bugfender.sdk.a.a.i.b.b.a$b$a  reason: collision with other inner class name */
        public static class C0008a {
            public static String a(com.bugfender.sdk.a.a.h.e eVar) {
                try {
                    com.bugfender.sdk.a.a.e.c.a(eVar, "Issue == null");
                    com.bugfender.sdk.a.a.e.c.a(eVar.a(), "Application == null");
                    com.bugfender.sdk.a.a.e.c.a(eVar.c(), "sessionId == null");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("uid", eVar.g() != null ? eVar.g().toString() : null);
                    jSONObject.put("title", eVar.e());
                    jSONObject.put("text", eVar.d());
                    jSONObject.put("session_id", eVar.c());
                    jSONObject.put("app", a.a(eVar.a()));
                    jSONObject.putOpt("type", eVar.f());
                    jSONObject.putOpt("raw", eVar.b());
                    return jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    public static class d {

        /* renamed from: com.bugfender.sdk.a.a.i.b.b.a$d$a  reason: collision with other inner class name */
        public static class C0010a {
            public static String a(String str, String str2, f<?> fVar) {
                try {
                    com.bugfender.sdk.a.a.e.c.a(str, "applicationKey == null");
                    com.bugfender.sdk.a.a.e.c.a(str2, "deviceId == null");
                    com.bugfender.sdk.a.a.e.c.a(fVar, "key == null");
                    com.bugfender.sdk.a.a.e.c.a(fVar.a(), "key == null");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_key", str);
                    jSONObject.put("device_id", str2);
                    jSONObject.put("key", fVar.a());
                    jSONObject.put("value", fVar.b());
                    return jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    public static class e {

        /* renamed from: com.bugfender.sdk.a.a.i.b.b.a$e$a  reason: collision with other inner class name */
        public static class C0011a {
            public static String a(long j, List<g> list) {
                try {
                    com.bugfender.sdk.a.a.e.c.a(list, "logs == null");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("session_id", j);
                    JSONArray jSONArray = new JSONArray();
                    for (g gVar : list) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("l", gVar.e());
                        jSONObject2.put("ll", gVar.d());
                        jSONObject2.put("at", gVar.a());
                        jSONObject2.put("x", com.bugfender.sdk.a.a.i.b.a.b.a().format(gVar.b()));
                        jSONObject2.put("tg", gVar.g());
                        jSONObject2.put("m", gVar.f());
                        jSONObject2.put("f", gVar.c());
                        jSONObject2.put("t", gVar.h());
                        jSONObject2.put("thn", gVar.j());
                        jSONObject2.put("th", gVar.i());
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("logs", jSONArray);
                    return jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    static JSONObject a(com.bugfender.sdk.a.a.h.a aVar) {
        try {
            com.bugfender.sdk.a.a.e.c.a(aVar, "application == null");
            com.bugfender.sdk.a.a.e.c.a(aVar.a(), "application.getKey()");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", aVar.a());
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: com.bugfender.sdk.a.a.i.b.b.a$a  reason: collision with other inner class name */
    public static class C0006a {

        /* renamed from: com.bugfender.sdk.a.a.i.b.b.a$a$b */
        public static class b {
            public static com.bugfender.sdk.a.a.i.c.b.a a(String str) {
                try {
                    com.bugfender.sdk.a.a.i.c.b.a aVar = new com.bugfender.sdk.a.a.i.c.b.a();
                    JSONObject jSONObject = new JSONObject(str);
                    aVar.b(jSONObject.getBoolean("logger_enabled"));
                    aVar.a(jSONObject.getBoolean("crashes_enabled"));
                    JSONObject jSONObject2 = jSONObject.getJSONObject("latest_sdk_version");
                    if (jSONObject2 != null) {
                        aVar.a(new a.b(jSONObject2.getInt(AbstractSpiCall.ANDROID_CLIENT_TYPE), jSONObject2.getInt("ios")));
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                    if (optJSONObject != null) {
                        aVar.a(new a.C0012a(optJSONObject.getString("message"), optJSONObject.getInt("code")));
                    }
                    return aVar;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

        /* renamed from: com.bugfender.sdk.a.a.i.b.b.a$a$a  reason: collision with other inner class name */
        public static class C0007a {
            public static String a(String str, com.bugfender.sdk.a.a.h.c cVar, Map<String, ?> map) {
                try {
                    com.bugfender.sdk.a.a.e.c.a(str, "applicationToken == null");
                    com.bugfender.sdk.a.a.e.c.a(cVar, "device == null");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_token", str);
                    jSONObject.put("device", a(cVar, map));
                    return jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            private static JSONObject a(com.bugfender.sdk.a.a.h.c cVar, Map<String, ?> map) {
                try {
                    com.bugfender.sdk.a.a.e.c.a(cVar, "device == null");
                    com.bugfender.sdk.a.a.e.c.a(cVar.l(), "udid == null");
                    com.bugfender.sdk.a.a.e.c.a(cVar.e(), "name == null");
                    com.bugfender.sdk.a.a.e.c.a(cVar.f(), "osVersion == null");
                    com.bugfender.sdk.a.a.e.c.a(cVar.m(), "version == null");
                    com.bugfender.sdk.a.a.e.c.a(cVar.b(), "build == null");
                    com.bugfender.sdk.a.a.e.c.a(cVar.d(), "language == null");
                    com.bugfender.sdk.a.a.e.c.a(cVar.g(), "sdkType == null");
                    com.bugfender.sdk.a.a.e.c.a(cVar.i(), "timezone == null");
                    com.bugfender.sdk.a.a.e.c.a(cVar.c(), "device_type == null");
                    com.bugfender.sdk.a.a.e.c.a(cVar.h(), "sdk_version == null");
                    com.bugfender.sdk.a.a.e.c.a(Long.valueOf(cVar.k()), "total_storage_size == null");
                    com.bugfender.sdk.a.a.e.c.a(Long.valueOf(cVar.j()), "total_storage_available == null");
                    com.bugfender.sdk.a.a.e.c.a(Boolean.valueOf(cVar.n()), "firebase_test_lab == null");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("udid", cVar.l());
                    jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.NAME, cVar.e());
                    jSONObject.put("os_version", cVar.f());
                    jSONObject.put("version", cVar.m());
                    jSONObject.put("build", cVar.b());
                    jSONObject.put("language", cVar.d());
                    jSONObject.put("sdk_type", cVar.g());
                    jSONObject.put("timezone", cVar.i());
                    jSONObject.put("device_type", cVar.c());
                    jSONObject.put("sdk_version", cVar.h());
                    jSONObject.put("total_storage_size", cVar.k());
                    jSONObject.put("total_storage_available", cVar.j());
                    jSONObject.put("firebase_test_lab", cVar.n());
                    if (!map.isEmpty()) {
                        if (map.containsKey(com.bugfender.sdk.a.a.b.D)) {
                            jSONObject.put(com.bugfender.sdk.a.a.b.D, map.remove(com.bugfender.sdk.a.a.b.D));
                        }
                        if (map.containsKey(com.bugfender.sdk.a.a.b.C)) {
                            jSONObject.put(com.bugfender.sdk.a.a.b.C, map.remove(com.bugfender.sdk.a.a.b.C));
                        }
                        if (!map.isEmpty()) {
                            JSONObject jSONObject2 = new JSONObject();
                            for (Map.Entry<String, ?> entry : map.entrySet()) {
                                jSONObject2.put(entry.getKey(), entry.getValue());
                            }
                            jSONObject.put("key_values", jSONObject2);
                        }
                    }
                    return jSONObject;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    public static class c {

        public static class b {
            public static com.bugfender.sdk.a.a.i.c.b.e a(String str) {
                try {
                    return new com.bugfender.sdk.a.a.i.c.b.e(new JSONObject(str).getInt("id"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

        /* renamed from: com.bugfender.sdk.a.a.i.b.b.a$c$a  reason: collision with other inner class name */
        public static class C0009a {
            public static String a(h hVar) {
                String format = com.bugfender.sdk.a.a.i.b.a.b.a().format(hVar.m());
                try {
                    com.bugfender.sdk.a.a.e.c.a(hVar, "session == null");
                    com.bugfender.sdk.a.a.e.c.a(hVar.c(), "session.getDevice() == null");
                    com.bugfender.sdk.a.a.e.c.a(hVar.a(), "session.getApplicationVersion() == null");
                    com.bugfender.sdk.a.a.e.c.a(Float.valueOf(hVar.b()), "session.getBatteryLevel() == null");
                    com.bugfender.sdk.a.a.e.c.a(Long.valueOf(hVar.d()), "session.getFreeRam() == null");
                    com.bugfender.sdk.a.a.e.c.a(hVar.m(), "session.getTime() == null");
                    com.bugfender.sdk.a.a.e.c.a(hVar.h(), "session.getOsVersion() == null");
                    com.bugfender.sdk.a.a.e.c.a(hVar.e(), "session.getLanguage() == null");
                    com.bugfender.sdk.a.a.e.c.a(hVar.n(), "session.getTimezone() == null");
                    com.bugfender.sdk.a.a.e.c.a(Long.valueOf(hVar.o()), "session.getTotalRam() == null");
                    com.bugfender.sdk.a.a.e.c.a(Long.valueOf(hVar.i()), "session.getRamUsed() == null");
                    com.bugfender.sdk.a.a.e.c.a(Integer.valueOf(hVar.g()), "session.getOrientation() == null");
                    com.bugfender.sdk.a.a.e.c.a(hVar.j(), "session.getSdkType() == null");
                    com.bugfender.sdk.a.a.e.c.a(hVar.l(), "session.getSessionIdentifier() == null");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("device", a(hVar.c()));
                    jSONObject.put("app_version", a(hVar.a()));
                    jSONObject.put("battery_level", (double) hVar.b());
                    jSONObject.put("ram_free", hVar.d());
                    jSONObject.put("time", format);
                    jSONObject.put("os_version", hVar.h());
                    jSONObject.put("language", hVar.e());
                    jSONObject.put("timezone", hVar.n());
                    jSONObject.put("ram_total", hVar.o());
                    jSONObject.put("ram_used", hVar.i());
                    jSONObject.put("orientation", hVar.g());
                    jSONObject.put("sdk_type", hVar.j());
                    jSONObject.put("session_uid", hVar.l());
                    return jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            private static JSONObject a(com.bugfender.sdk.a.a.h.c cVar) {
                try {
                    com.bugfender.sdk.a.a.e.c.a(cVar, "device == null");
                    com.bugfender.sdk.a.a.e.c.a(cVar.l(), "device.getUdid() == null");
                    com.bugfender.sdk.a.a.e.c.a(cVar.e(), "device.getName() == null");
                    com.bugfender.sdk.a.a.e.c.a(cVar.c(), "device.getDeviceType() == null");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("udid", cVar.l());
                    jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.NAME, cVar.e());
                    jSONObject.put("device_type", cVar.c());
                    return jSONObject;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            private static JSONObject a(com.bugfender.sdk.a.a.h.b bVar) {
                try {
                    com.bugfender.sdk.a.a.e.c.a(bVar, "applicationVersion == null");
                    com.bugfender.sdk.a.a.e.c.a(bVar.a(), "applicationVersion.getApplication() == null");
                    com.bugfender.sdk.a.a.e.c.a(bVar.c(), "applicationVersion.getVersionName() == null");
                    com.bugfender.sdk.a.a.e.c.a(bVar.b(), "applicationVersion.getVersionCode() == null");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app", a(bVar.a()));
                    jSONObject.put("version", bVar.c());
                    jSONObject.put("build", bVar.b());
                    return jSONObject;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            private static JSONObject a(com.bugfender.sdk.a.a.h.a aVar) {
                try {
                    com.bugfender.sdk.a.a.e.c.a(aVar, "application == null");
                    com.bugfender.sdk.a.a.e.c.a(aVar.a(), "application.getKey() == null");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", aVar.a());
                    return jSONObject;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}
