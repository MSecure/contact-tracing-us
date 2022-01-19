package com.bugsnag.android;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.bugsnag.android.StateEvent;
import com.facebook.react.bridge.PromiseImpl;
import com.horcrux.svg.PathParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: BugsnagReactNativePlugin.kt */
public final class BugsnagReactNativePlugin implements Plugin {
    public final AppSerializer appSerializer = new AppSerializer();
    public final BreadcrumbSerializer breadcrumbSerializer = new BreadcrumbSerializer();
    public Client client;
    public final ConfigSerializer configSerializer = new ConfigSerializer();
    public final DeviceSerializer deviceSerializer = new DeviceSerializer();
    public boolean ignoreJsExceptionCallbackAdded;
    public InternalHooks internalHooks;
    public Function1<? super MessageEvent, Unit> jsCallback;
    public BugsnagReactNativeBridge observerBridge;
    public final ThreadSerializer threadSerializer = new ThreadSerializer();

    public final void addMetadata(String str, Map<String, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(str, "section");
        if (map == null) {
            Client client2 = this.client;
            if (client2 != null) {
                client2.clearMetadata(str);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("client");
                throw null;
            }
        } else {
            Client client3 = this.client;
            if (client3 != null) {
                MetadataState metadataState = client3.metadataState;
                if (metadataState != null) {
                    Intrinsics.checkParameterIsNotNull(str, "section");
                    Intrinsics.checkParameterIsNotNull(map, "value");
                    metadataState.metadata.addMetadata(str, map);
                    for (T t : map.entrySet()) {
                        String str2 = (String) t.getKey();
                        Metadata metadata = metadataState.metadata;
                        String str3 = (String) t.getKey();
                        if (metadata != null) {
                            Intrinsics.checkParameterIsNotNull(str3, "section");
                            metadataState.notifyObservers(new StateEvent.AddMetadata(str, str2, (Map) metadata.store.get(str3)));
                        } else {
                            throw null;
                        }
                    }
                    return;
                }
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("client");
            throw null;
        }
    }

    public final Map<String, Object> configure(Map<String, ? extends Object> map) {
        if (map != null) {
            String str = (String) map.get("reactNativeVersion");
            if (str != null) {
                Client client2 = this.client;
                if (client2 != null) {
                    DeviceDataCollector deviceDataCollector = client2.deviceDataCollector;
                    if (deviceDataCollector != null) {
                        Intrinsics.checkParameterIsNotNull("reactNative", "key");
                        Intrinsics.checkParameterIsNotNull(str, "value");
                        deviceDataCollector.runtimeVersions.put("reactNative", str);
                    } else {
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                    throw null;
                }
            }
            String str2 = (String) map.get("engine");
            if (str2 != null) {
                Client client3 = this.client;
                if (client3 != null) {
                    DeviceDataCollector deviceDataCollector2 = client3.deviceDataCollector;
                    if (deviceDataCollector2 != null) {
                        Intrinsics.checkParameterIsNotNull("reactNativeJsEngine", "key");
                        Intrinsics.checkParameterIsNotNull(str2, "value");
                        deviceDataCollector2.runtimeVersions.put("reactNativeJsEngine", str2);
                    } else {
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                    throw null;
                }
            }
            Object obj = map.get("notifierVersion");
            if (obj != null) {
                String str3 = (String) obj;
                Client client4 = this.client;
                if (client4 != null) {
                    Notifier notifier = client4.notifier;
                    if (notifier != null) {
                        Intrinsics.checkParameterIsNotNull("Bugsnag React Native", "<set-?>");
                        notifier.name = "Bugsnag React Native";
                        Intrinsics.checkParameterIsNotNull("https://github.com/bugsnag/bugsnag-js", "<set-?>");
                        notifier.url = "https://github.com/bugsnag/bugsnag-js";
                        Intrinsics.checkParameterIsNotNull(str3, "<set-?>");
                        notifier.version = str3;
                        List<Notifier> listOf = PathParser.listOf(new Notifier(null, null, null, 7));
                        Intrinsics.checkParameterIsNotNull(listOf, "<set-?>");
                        notifier.dependencies = listOf;
                        if (!this.ignoreJsExceptionCallbackAdded) {
                            this.ignoreJsExceptionCallbackAdded = true;
                            Client client5 = this.client;
                            if (client5 != null) {
                                BugsnagReactNativePlugin$ignoreJavaScriptExceptions$1 bugsnagReactNativePlugin$ignoreJavaScriptExceptions$1 = BugsnagReactNativePlugin$ignoreJavaScriptExceptions$1.INSTANCE;
                                CallbackState callbackState = client5.callbackState;
                                if (callbackState != null) {
                                    Intrinsics.checkParameterIsNotNull(bugsnagReactNativePlugin$ignoreJavaScriptExceptions$1, "onError");
                                    callbackState.onErrorTasks.add(bugsnagReactNativePlugin$ignoreJavaScriptExceptions$1);
                                } else {
                                    throw null;
                                }
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("client");
                                throw null;
                            }
                        }
                        HashMap hashMap = new HashMap();
                        ConfigSerializer configSerializer2 = this.configSerializer;
                        InternalHooks internalHooks2 = this.internalHooks;
                        if (internalHooks2 != null) {
                            ImmutableConfig immutableConfig = internalHooks2.client.immutableConfig;
                            if (configSerializer2 != null) {
                                hashMap.put("apiKey", immutableConfig.apiKey);
                                hashMap.put("autoDetectErrors", Boolean.valueOf(immutableConfig.autoDetectErrors));
                                hashMap.put("autoTrackSessions", Boolean.valueOf(immutableConfig.autoTrackSessions));
                                hashMap.put("sendThreads", immutableConfig.sendThreads.toString());
                                hashMap.put("discardClasses", immutableConfig.discardClasses);
                                hashMap.put("projectPackages", immutableConfig.projectPackages);
                                hashMap.put("enabledReleaseStages", immutableConfig.enabledReleaseStages);
                                hashMap.put("releaseStage", immutableConfig.releaseStage);
                                hashMap.put("buildUuid", immutableConfig.buildUuid);
                                String str4 = immutableConfig.appVersion;
                                if (str4 != null) {
                                    hashMap.put("appVersion", str4);
                                }
                                hashMap.put("versionCode", immutableConfig.versionCode);
                                hashMap.put("type", immutableConfig.appType);
                                hashMap.put("persistUser", Boolean.valueOf(immutableConfig.persistUser));
                                hashMap.put("launchCrashThresholdMs", Integer.valueOf((int) immutableConfig.launchCrashThresholdMs));
                                hashMap.put("maxBreadcrumbs", Integer.valueOf(immutableConfig.maxBreadcrumbs));
                                HashSet hashSet = new HashSet();
                                Set<BreadcrumbType> set = immutableConfig.enabledBreadcrumbTypes;
                                if (set != null) {
                                    for (BreadcrumbType breadcrumbType : set) {
                                        hashSet.add(breadcrumbType.toString());
                                    }
                                }
                                hashMap.put("enabledBreadcrumbTypes", hashSet);
                                HashMap hashMap2 = new HashMap();
                                ErrorTypes errorTypes = immutableConfig.enabledErrorTypes;
                                hashMap2.put("anrs", Boolean.valueOf(errorTypes.anrs));
                                hashMap2.put("ndkCrashes", Boolean.valueOf(errorTypes.ndkCrashes));
                                hashMap2.put("unhandledExceptions", Boolean.valueOf(errorTypes.unhandledExceptions));
                                hashMap2.put("unhandledRejections", Boolean.valueOf(errorTypes.unhandledRejections));
                                hashMap.put("enabledErrorTypes", hashMap2);
                                HashMap hashMap3 = new HashMap();
                                EndpointConfiguration endpointConfiguration = immutableConfig.endpoints;
                                hashMap3.put("notify", endpointConfiguration.notify);
                                hashMap3.put("sessions", endpointConfiguration.sessions);
                                hashMap.put("endpoints", hashMap3);
                                return hashMap;
                            }
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("internalHooks");
                        throw null;
                    }
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("client");
                throw null;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void dispatch(Map<String, Object> map) {
        String str;
        boolean z;
        if (map != null) {
            Client client2 = this.client;
            String str2 = "client";
            if (client2 != null) {
                Intrinsics.checkParameterIsNotNull(client2, str2);
                StackframeDeserializer stackframeDeserializer = new StackframeDeserializer();
                Logger logger = client2.logger;
                Logger logger2 = client2.logger;
                Logger logger3 = client2.logger;
                Intrinsics.checkParameterIsNotNull(map, "map");
                Object obj = map.get("severityReason");
                if (obj != null) {
                    String str3 = "type";
                    Object obj2 = ((Map) obj).get(str3);
                    if (obj2 != null) {
                        String str4 = (String) obj2;
                        Object obj3 = map.get("severity");
                        if (obj3 != null) {
                            String str5 = (String) obj3;
                            Object obj4 = map.get("unhandled");
                            if (obj4 != null) {
                                boolean booleanValue = ((Boolean) obj4).booleanValue();
                                Locale locale = Locale.US;
                                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
                                String upperCase = str5.toUpperCase(locale);
                                Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                                Event createEvent = NativeInterface.createEvent(null, client2, new HandledState(str4, Severity.valueOf(upperCase), booleanValue, null));
                                Intrinsics.checkExpressionValueIsNotNull(createEvent, "NativeInterface.createEv…ll, client, handledState)");
                                createEvent.impl.context = (String) map.get("context");
                                createEvent.impl.groupingHash = (String) map.get("groupingHash");
                                Object obj5 = map.get("app");
                                if (obj5 != null) {
                                    Map asMutableMap = TypeIntrinsics.asMutableMap(obj5);
                                    Object obj6 = asMutableMap.get("binaryArch");
                                    if (obj6 == null) {
                                        obj6 = null;
                                    }
                                    String str6 = (String) obj6;
                                    String str7 = "id";
                                    Object obj7 = asMutableMap.get(str7);
                                    if (obj7 == null) {
                                        obj7 = null;
                                    }
                                    String str8 = (String) obj7;
                                    Object obj8 = asMutableMap.get("releaseStage");
                                    if (obj8 == null) {
                                        obj8 = null;
                                    }
                                    String str9 = (String) obj8;
                                    Object obj9 = asMutableMap.get("version");
                                    if (obj9 == null) {
                                        obj9 = null;
                                    }
                                    String str10 = (String) obj9;
                                    Object obj10 = asMutableMap.get("codeBundleId");
                                    if (obj10 == null) {
                                        obj10 = null;
                                    }
                                    String str11 = (String) obj10;
                                    Object obj11 = asMutableMap.get("buildUuid");
                                    if (obj11 == null) {
                                        obj11 = null;
                                    }
                                    String str12 = (String) obj11;
                                    Object obj12 = asMutableMap.get(str3);
                                    if (obj12 == null) {
                                        obj12 = null;
                                    }
                                    String str13 = (String) obj12;
                                    Object obj13 = asMutableMap.get("versionCode");
                                    if (obj13 == null) {
                                        obj13 = null;
                                    }
                                    Number number = (Number) obj13;
                                    Object obj14 = asMutableMap.get("duration");
                                    if (obj14 == null) {
                                        obj14 = null;
                                    }
                                    Number number2 = (Number) obj14;
                                    Object obj15 = asMutableMap.get("durationInForeground");
                                    if (obj15 == null) {
                                        obj15 = null;
                                    }
                                    Number number3 = (Number) obj15;
                                    Object obj16 = asMutableMap.get("inForeground");
                                    if (obj16 == null) {
                                        obj16 = null;
                                    }
                                    createEvent.setApp(new AppWithState(str6, str8, str9, str10, str11, str12, str13, number, number2, number3, (Boolean) obj16));
                                    Object obj17 = map.get("device");
                                    if (obj17 != null) {
                                        Map asMutableMap2 = TypeIntrinsics.asMutableMap(obj17);
                                        Object obj18 = asMutableMap2.get("manufacturer");
                                        if (obj18 == null) {
                                            obj18 = null;
                                        }
                                        String str14 = (String) obj18;
                                        Object obj19 = asMutableMap2.get("model");
                                        if (obj19 == null) {
                                            obj19 = null;
                                        }
                                        String str15 = (String) obj19;
                                        Object obj20 = asMutableMap2.get("osVersion");
                                        if (obj20 == null) {
                                            obj20 = null;
                                        }
                                        String str16 = (String) obj20;
                                        Object obj21 = asMutableMap2.get("apiLevel");
                                        if (obj21 == null) {
                                            obj21 = null;
                                        }
                                        Number number4 = (Number) obj21;
                                        Integer valueOf = number4 != null ? Integer.valueOf(number4.intValue()) : null;
                                        Object obj22 = asMutableMap2.get("osBuild");
                                        if (obj22 == null) {
                                            obj22 = null;
                                        }
                                        String str17 = (String) obj22;
                                        Object obj23 = asMutableMap2.get("fingerprint");
                                        if (obj23 == null) {
                                            obj23 = null;
                                        }
                                        String str18 = (String) obj23;
                                        Object obj24 = asMutableMap2.get("tags");
                                        if (obj24 == null) {
                                            obj24 = null;
                                        }
                                        String str19 = (String) obj24;
                                        Object obj25 = asMutableMap2.get("brand");
                                        if (obj25 == null) {
                                            obj25 = null;
                                        }
                                        String str20 = (String) obj25;
                                        Object obj26 = asMutableMap2.get("cpuAbis");
                                        if (obj26 == null) {
                                            obj26 = null;
                                        }
                                        DeviceBuildInfo deviceBuildInfo = new DeviceBuildInfo(str14, str15, str16, valueOf, str17, str18, str19, str20, (String[]) obj26);
                                        Object obj27 = asMutableMap2.get("time");
                                        if (obj27 == null) {
                                            obj27 = null;
                                        }
                                        String str21 = (String) obj27;
                                        Date fromIso8601 = str21 != null ? DateUtils.fromIso8601(str21) : null;
                                        Object obj28 = asMutableMap2.get("jailbroken");
                                        if (obj28 == null) {
                                            obj28 = null;
                                        }
                                        Boolean bool = (Boolean) obj28;
                                        Object obj29 = asMutableMap2.get(str7);
                                        if (obj29 == null) {
                                            obj29 = null;
                                        }
                                        String str22 = (String) obj29;
                                        Object obj30 = asMutableMap2.get("locale");
                                        if (obj30 == null) {
                                            obj30 = null;
                                        }
                                        String str23 = (String) obj30;
                                        Long l = AppCompatDelegateImpl.ConfigurationImplApi17.getLong(asMutableMap2, "totalMemory");
                                        Object obj31 = asMutableMap2.get("runtimeVersions");
                                        if (obj31 == null) {
                                            obj31 = null;
                                        }
                                        Map map2 = (Map) obj31;
                                        Long l2 = AppCompatDelegateImpl.ConfigurationImplApi17.getLong(asMutableMap2, "freeDisk");
                                        Long l3 = AppCompatDelegateImpl.ConfigurationImplApi17.getLong(asMutableMap2, "freeMemory");
                                        Object obj32 = asMutableMap2.get("orientation");
                                        if (obj32 == null) {
                                            obj32 = null;
                                        }
                                        createEvent.setDevice(new DeviceWithState(deviceBuildInfo, bool, str22, str23, l, map2, l2, l3, (String) obj32, fromIso8601));
                                        Object obj33 = map.get("user");
                                        if (obj33 != null) {
                                            Map asMutableMap3 = TypeIntrinsics.asMutableMap(obj33);
                                            Object obj34 = asMutableMap3.get(str7);
                                            if (obj34 == null) {
                                                obj34 = null;
                                            }
                                            String str24 = (String) obj34;
                                            Object obj35 = asMutableMap3.get("email");
                                            if (obj35 == null) {
                                                obj35 = null;
                                            }
                                            String str25 = (String) obj35;
                                            String str26 = "name";
                                            Object obj36 = asMutableMap3.get(str26);
                                            if (obj36 == null) {
                                                obj36 = null;
                                            }
                                            createEvent.impl._user = new User(str24, str25, (String) obj36);
                                            Object obj37 = map.get("errors");
                                            if (obj37 != null) {
                                                List list = (List) obj37;
                                                createEvent.impl.errors.clear();
                                                List<Error> list2 = createEvent.impl.errors;
                                                String str27 = "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.Any?>>";
                                                ArrayList arrayList = new ArrayList(PathParser.collectionSizeOrDefault(list, 10));
                                                Iterator it = list.iterator();
                                                while (true) {
                                                    str = "stacktrace";
                                                    if (!it.hasNext()) {
                                                        break;
                                                    }
                                                    Map map3 = (Map) it.next();
                                                    String str28 = (String) AppCompatDelegateImpl.ConfigurationImplApi17.getOrThrow(map3, str3);
                                                    ArrayList arrayList2 = new ArrayList();
                                                    for (Iterator it2 = ((List) AppCompatDelegateImpl.ConfigurationImplApi17.getOrThrow(map3, str)).iterator(); it2.hasNext(); it2 = it2) {
                                                        arrayList2.add(stackframeDeserializer.deserialize((Map) it2.next()));
                                                    }
                                                    String str29 = (String) AppCompatDelegateImpl.ConfigurationImplApi17.getOrThrow(map3, "errorClass");
                                                    Object obj38 = map3.get("errorMessage");
                                                    if (obj38 == null) {
                                                        obj38 = null;
                                                    }
                                                    arrayList.add(new Error(new ErrorInternal(str29, (String) obj38, new Stacktrace(arrayList2, logger), ErrorType.valueOf(str28.toUpperCase(Locale.US))), logger));
                                                    logger3 = logger3;
                                                    it = it;
                                                    str2 = str2;
                                                }
                                                list2.addAll(arrayList);
                                                Object obj39 = map.get("threads");
                                                if (obj39 != null) {
                                                    List list3 = (List) obj39;
                                                    createEvent.impl.threads.clear();
                                                    List<Thread> list4 = createEvent.impl.threads;
                                                    ArrayList arrayList3 = new ArrayList(PathParser.collectionSizeOrDefault(list3, 10));
                                                    Iterator it3 = list3.iterator();
                                                    while (it3.hasNext()) {
                                                        Map map4 = (Map) it3.next();
                                                        String str30 = (String) AppCompatDelegateImpl.ConfigurationImplApi17.getOrThrow(map4, str3);
                                                        ArrayList arrayList4 = new ArrayList();
                                                        for (Map<String, Object> map5 : (List) AppCompatDelegateImpl.ConfigurationImplApi17.getOrThrow(map4, str)) {
                                                            arrayList4.add(stackframeDeserializer.deserialize(map5));
                                                        }
                                                        Object obj40 = map4.get("errorReportingThread");
                                                        if (obj40 == null) {
                                                            obj40 = null;
                                                        }
                                                        Boolean bool2 = (Boolean) obj40;
                                                        if (bool2 == null) {
                                                            z = false;
                                                        } else {
                                                            z = bool2.booleanValue();
                                                        }
                                                        arrayList3.add(new Thread(((Number) AppCompatDelegateImpl.ConfigurationImplApi17.getOrThrow(map4, str7)).longValue(), (String) AppCompatDelegateImpl.ConfigurationImplApi17.getOrThrow(map4, str26), ThreadType.valueOf(str30.toUpperCase(Locale.US)), Boolean.valueOf(z).booleanValue(), new Stacktrace(arrayList4, logger2), logger2));
                                                        str7 = str7;
                                                        str = str;
                                                        str26 = str26;
                                                        it3 = it3;
                                                        str3 = str3;
                                                        str27 = str27;
                                                    }
                                                    String str31 = str3;
                                                    list4.addAll(arrayList3);
                                                    Object obj41 = map.get("breadcrumbs");
                                                    if (obj41 != null) {
                                                        List<Map> list5 = (List) obj41;
                                                        createEvent.impl.breadcrumbs.clear();
                                                        List<Breadcrumb> list6 = createEvent.impl.breadcrumbs;
                                                        ArrayList arrayList5 = new ArrayList(PathParser.collectionSizeOrDefault(list5, 10));
                                                        for (Map map6 : list5) {
                                                            String str32 = (String) AppCompatDelegateImpl.ConfigurationImplApi17.getOrThrow(map6, "timestamp");
                                                            String str33 = (String) AppCompatDelegateImpl.ConfigurationImplApi17.getOrThrow(map6, "message");
                                                            BreadcrumbType valueOf2 = BreadcrumbType.valueOf(((String) AppCompatDelegateImpl.ConfigurationImplApi17.getOrThrow(map6, str31)).toUpperCase(Locale.US));
                                                            Object obj42 = map6.get("metadata");
                                                            if (obj42 == null) {
                                                                obj42 = null;
                                                            }
                                                            arrayList5.add(new Breadcrumb(str33, valueOf2, (Map) obj42, DateUtils.fromIso8601(str32), logger3));
                                                            str31 = str31;
                                                        }
                                                        list6.addAll(arrayList5);
                                                        Object obj43 = map.get("metadata");
                                                        if (obj43 != null) {
                                                            for (Map.Entry entry : ((Map) obj43).entrySet()) {
                                                                String str34 = (String) entry.getKey();
                                                                Object value = entry.getValue();
                                                                if (value != null) {
                                                                    createEvent.addMetadata(str34, (Map) value);
                                                                } else {
                                                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                                                                }
                                                            }
                                                            Client client3 = this.client;
                                                            if (client3 != null) {
                                                                client3.notifyInternal(createEvent, null);
                                                            } else {
                                                                Intrinsics.throwUninitializedPropertyAccessException(str2);
                                                                throw null;
                                                            }
                                                        } else {
                                                            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                                                        }
                                                    } else {
                                                        throw new TypeCastException(str27);
                                                    }
                                                } else {
                                                    throw new TypeCastException(str27);
                                                }
                                            } else {
                                                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.Any?>>");
                                            }
                                        } else {
                                            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
                                        }
                                    } else {
                                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
                                    }
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                throw null;
            }
        } else {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public final Map<String, Object> getPayloadInfo(boolean z) {
        Object obj;
        String str;
        LinkedHashMap linkedHashMap;
        Iterable<Thread> iterable;
        List<Thread> list;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        AppSerializer appSerializer2 = this.appSerializer;
        InternalHooks internalHooks2 = this.internalHooks;
        if (internalHooks2 != null) {
            AppWithState generateAppWithState = internalHooks2.client.appDataCollector.generateAppWithState();
            Intrinsics.checkExpressionValueIsNotNull(generateAppWithState, "internalHooks.appWithState");
            if (appSerializer2 != null) {
                Intrinsics.checkParameterIsNotNull(linkedHashMap3, "map");
                Intrinsics.checkParameterIsNotNull(generateAppWithState, "app");
                linkedHashMap3.put("type", generateAppWithState.type);
                linkedHashMap3.put("binaryArch", generateAppWithState.binaryArch);
                linkedHashMap3.put("buildUuid", generateAppWithState.buildUuid);
                linkedHashMap3.put("codeBundleId", generateAppWithState.codeBundleId);
                linkedHashMap3.put("duration", generateAppWithState.duration);
                linkedHashMap3.put("durationInForeground", generateAppWithState.durationInForeground);
                linkedHashMap3.put("id", generateAppWithState.id);
                linkedHashMap3.put("inForeground", generateAppWithState.inForeground);
                linkedHashMap3.put("releaseStage", generateAppWithState.releaseStage);
                linkedHashMap3.put("version", generateAppWithState.version);
                linkedHashMap3.put("versionCode", generateAppWithState.versionCode);
                linkedHashMap2.put("app", linkedHashMap3);
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                DeviceSerializer deviceSerializer2 = this.deviceSerializer;
                InternalHooks internalHooks3 = this.internalHooks;
                if (internalHooks3 != null) {
                    DeviceWithState generateDeviceWithState = internalHooks3.client.deviceDataCollector.generateDeviceWithState(new Date().getTime());
                    Intrinsics.checkExpressionValueIsNotNull(generateDeviceWithState, "internalHooks.deviceWithState");
                    if (deviceSerializer2 != null) {
                        Intrinsics.checkParameterIsNotNull(linkedHashMap4, "map");
                        Intrinsics.checkParameterIsNotNull(generateDeviceWithState, "device");
                        String[] strArr = generateDeviceWithState.cpuAbi;
                        linkedHashMap4.put("cpuAbi", strArr != null ? PathParser.toList(strArr) : null);
                        linkedHashMap4.put("jailbroken", generateDeviceWithState.jailbroken);
                        linkedHashMap4.put("id", generateDeviceWithState.id);
                        linkedHashMap4.put("locale", generateDeviceWithState.locale);
                        linkedHashMap4.put("manufacturer", generateDeviceWithState.manufacturer);
                        linkedHashMap4.put("model", generateDeviceWithState.model);
                        linkedHashMap4.put("osName", generateDeviceWithState.osName);
                        linkedHashMap4.put("osVersion", generateDeviceWithState.osVersion);
                        linkedHashMap4.put("totalMemory", generateDeviceWithState.totalMemory);
                        linkedHashMap4.put("freeDisk", generateDeviceWithState.freeDisk);
                        linkedHashMap4.put("freeMemory", generateDeviceWithState.freeMemory);
                        linkedHashMap4.put("orientation", generateDeviceWithState.orientation);
                        Date date = generateDeviceWithState.time;
                        if (date != null) {
                            linkedHashMap4.put("time", DateUtils.toIso8601(date));
                        }
                        linkedHashMap4.put("runtimeVersions", generateDeviceWithState.runtimeVersions);
                        linkedHashMap2.put("device", linkedHashMap4);
                        Client client2 = this.client;
                        if (client2 != null) {
                            ArrayList arrayList = new ArrayList(client2.breadcrumbState.getStore());
                            Intrinsics.checkExpressionValueIsNotNull(arrayList, "client.breadcrumbs");
                            ArrayList arrayList2 = new ArrayList(PathParser.collectionSizeOrDefault(arrayList, 10));
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                Breadcrumb breadcrumb = (Breadcrumb) it.next();
                                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                                BreadcrumbSerializer breadcrumbSerializer2 = this.breadcrumbSerializer;
                                Intrinsics.checkExpressionValueIsNotNull(breadcrumb, "it");
                                if (breadcrumbSerializer2 != null) {
                                    Intrinsics.checkParameterIsNotNull(linkedHashMap5, "map");
                                    Intrinsics.checkParameterIsNotNull(breadcrumb, "crumb");
                                    linkedHashMap5.put("timestamp", DateUtils.toIso8601(breadcrumb.getTimestamp()));
                                    linkedHashMap5.put("message", breadcrumb.getMessage());
                                    String breadcrumbType = breadcrumb.getType().toString();
                                    Locale locale = Locale.US;
                                    Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
                                    if (breadcrumbType != null) {
                                        String lowerCase = breadcrumbType.toLowerCase(locale);
                                        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                                        linkedHashMap5.put("type", lowerCase);
                                        linkedHashMap5.put("metadata", breadcrumb.getMetadata());
                                        arrayList2.add(linkedHashMap5);
                                    } else {
                                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                    }
                                } else {
                                    throw null;
                                }
                            }
                            linkedHashMap2.put("breadcrumbs", arrayList2);
                            InternalHooks internalHooks4 = this.internalHooks;
                            if (internalHooks4 != null) {
                                ImmutableConfig immutableConfig = internalHooks4.client.immutableConfig;
                                Intrinsics.checkParameterIsNotNull(immutableConfig, "config");
                                ThreadSendPolicy threadSendPolicy = immutableConfig.sendThreads;
                                Collection<String> collection = immutableConfig.projectPackages;
                                Logger logger = immutableConfig.logger;
                                Thread currentThread = Thread.currentThread();
                                Intrinsics.checkExpressionValueIsNotNull(currentThread, "java.lang.Thread.currentThread()");
                                Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
                                Intrinsics.checkExpressionValueIsNotNull(allStackTraces, "java.lang.Thread.getAllStackTraces()");
                                Intrinsics.checkParameterIsNotNull(threadSendPolicy, "sendThreads");
                                Intrinsics.checkParameterIsNotNull(collection, "projectPackages");
                                Intrinsics.checkParameterIsNotNull(logger, "logger");
                                Intrinsics.checkParameterIsNotNull(currentThread, "currentThread");
                                Intrinsics.checkParameterIsNotNull(allStackTraces, "stackTraces");
                                if (threadSendPolicy == ThreadSendPolicy.ALWAYS || (threadSendPolicy == ThreadSendPolicy.UNHANDLED_ONLY && z)) {
                                    if (!allStackTraces.containsKey(currentThread)) {
                                        StackTraceElement[] stackTrace = currentThread.getStackTrace();
                                        Intrinsics.checkExpressionValueIsNotNull(stackTrace, "currentThread.stackTrace");
                                        allStackTraces.put(currentThread, stackTrace);
                                    }
                                    long id = currentThread.getId();
                                    Set<Thread> keySet = allStackTraces.keySet();
                                    ThreadState$captureThreadTrace$$inlined$sortedBy$1 threadState$captureThreadTrace$$inlined$sortedBy$1 = new ThreadState$captureThreadTrace$$inlined$sortedBy$1();
                                    linkedHashMap = linkedHashMap2;
                                    Intrinsics.checkNotNullParameter(keySet, "$this$sortedWith");
                                    Intrinsics.checkNotNullParameter(threadState$captureThreadTrace$$inlined$sortedBy$1, "comparator");
                                    str = "null cannot be cast to non-null type java.lang.String";
                                    obj = "type";
                                    if (keySet.size() <= 1) {
                                        Intrinsics.checkNotNullParameter(keySet, "$this$toList");
                                        int size = keySet.size();
                                        if (size == 0) {
                                            list = EmptyList.INSTANCE;
                                        } else if (size != 1) {
                                            list = CollectionsKt__CollectionsKt.toMutableList(keySet);
                                        } else {
                                            list = PathParser.listOf(keySet instanceof List ? ((List) keySet).get(0) : keySet.iterator().next());
                                        }
                                    } else {
                                        Object[] array = keySet.toArray(new Object[0]);
                                        if (array != null) {
                                            Intrinsics.checkNotNullParameter(array, "$this$sortWith");
                                            Intrinsics.checkNotNullParameter(threadState$captureThreadTrace$$inlined$sortedBy$1, "comparator");
                                            if (array.length > 1) {
                                                Arrays.sort(array, threadState$captureThreadTrace$$inlined$sortedBy$1);
                                            }
                                            list = PathParser.asList(array);
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                        }
                                    }
                                    ArrayList arrayList3 = new ArrayList(PathParser.collectionSizeOrDefault(list, 10));
                                    for (Thread thread : list) {
                                        StackTraceElement[] stackTraceElementArr = allStackTraces.get(thread);
                                        if (stackTraceElementArr != null) {
                                            arrayList3.add(new Thread(thread.getId(), thread.getName(), ThreadType.ANDROID, thread.getId() == id, new Stacktrace(stackTraceElementArr, collection, logger), logger));
                                        } else {
                                            Intrinsics.throwNpe();
                                            throw null;
                                        }
                                    }
                                    iterable = CollectionsKt__CollectionsKt.toMutableList(arrayList3);
                                } else {
                                    linkedHashMap = linkedHashMap2;
                                    obj = "type";
                                    str = "null cannot be cast to non-null type java.lang.String";
                                    iterable = new ArrayList();
                                }
                                Intrinsics.checkExpressionValueIsNotNull(iterable, "internalHooks.getThreads(unhandled)");
                                ArrayList arrayList4 = new ArrayList(PathParser.collectionSizeOrDefault(iterable, 10));
                                for (Thread thread2 : iterable) {
                                    LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                                    ThreadSerializer threadSerializer2 = this.threadSerializer;
                                    Intrinsics.checkExpressionValueIsNotNull(thread2, "it");
                                    if (threadSerializer2 != null) {
                                        Intrinsics.checkParameterIsNotNull(linkedHashMap6, "map");
                                        Intrinsics.checkParameterIsNotNull(thread2, "thread");
                                        linkedHashMap6.put("id", Long.valueOf(thread2.impl.id));
                                        linkedHashMap6.put("name", thread2.impl.name);
                                        String str2 = thread2.impl.type.toString();
                                        Locale locale2 = Locale.US;
                                        Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.US");
                                        if (str2 != null) {
                                            String lowerCase2 = str2.toLowerCase(locale2);
                                            Intrinsics.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                                            linkedHashMap6.put(obj, lowerCase2);
                                            linkedHashMap6.put("errorReportingThread", Boolean.valueOf(thread2.impl.isErrorReportingThread));
                                            List<Stackframe> list2 = thread2.impl.stacktrace;
                                            Intrinsics.checkExpressionValueIsNotNull(list2, "thread.stacktrace");
                                            ArrayList arrayList5 = new ArrayList(PathParser.collectionSizeOrDefault(list2, 10));
                                            for (T t : list2) {
                                                LinkedHashMap linkedHashMap7 = new LinkedHashMap();
                                                linkedHashMap7.put("method", t.method);
                                                linkedHashMap7.put("lineNumber", t.lineNumber);
                                                linkedHashMap7.put(PromiseImpl.STACK_FRAME_KEY_FILE, t.file);
                                                linkedHashMap7.put("inProject", t.inProject);
                                                arrayList5.add(linkedHashMap7);
                                            }
                                            linkedHashMap6.put("stacktrace", arrayList5);
                                            arrayList4.add(linkedHashMap6);
                                            obj = obj;
                                        } else {
                                            throw new TypeCastException(str);
                                        }
                                    } else {
                                        throw null;
                                    }
                                }
                                linkedHashMap.put("threads", arrayList4);
                                InternalHooks internalHooks5 = this.internalHooks;
                                if (internalHooks5 != null) {
                                    linkedHashMap.put("appMetadata", internalHooks5.client.appDataCollector.getAppDataMetadata());
                                    InternalHooks internalHooks6 = this.internalHooks;
                                    if (internalHooks6 != null) {
                                        linkedHashMap.put("deviceMetadata", internalHooks6.client.deviceDataCollector.getDeviceMetadata());
                                        return linkedHashMap;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException("internalHooks");
                                    throw null;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("internalHooks");
                                throw null;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("internalHooks");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("client");
                        throw null;
                    }
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("internalHooks");
                throw null;
            }
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("internalHooks");
        throw null;
    }

    public final void leaveBreadcrumb(Map<String, ? extends Object> map) {
        if (map != null) {
            Object obj = map.get("message");
            if (obj != null) {
                String str = (String) obj;
                Object obj2 = map.get("type");
                if (obj2 != null) {
                    Locale locale = Locale.US;
                    Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
                    String upperCase = ((String) obj2).toUpperCase(locale);
                    Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    BreadcrumbType valueOf = BreadcrumbType.valueOf(upperCase);
                    Object obj3 = map.get("metadata");
                    if (obj3 == null) {
                        obj3 = EmptyMap.INSTANCE;
                    }
                    Client client2 = this.client;
                    if (client2 != null) {
                        client2.leaveBreadcrumb(str, (Map) obj3, valueOf);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("client");
                        throw null;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
        } else {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    @Override // com.bugsnag.android.Plugin
    public void load(Client client2) {
        Intrinsics.checkParameterIsNotNull(client2, "client");
        this.client = client2;
        Intrinsics.checkExpressionValueIsNotNull(client2.logger, "client.logger");
        this.internalHooks = new InternalHooks(client2);
        BugsnagReactNativeBridge bugsnagReactNativeBridge = new BugsnagReactNativeBridge(client2, new BugsnagReactNativePlugin$load$1(this));
        this.observerBridge = bugsnagReactNativeBridge;
        client2.registerObserver(bugsnagReactNativeBridge);
        client2.logger.i("Initialized React Native Plugin");
    }

    public final void resumeSession() {
        Client client2 = this.client;
        if (client2 != null) {
            SessionTracker sessionTracker = client2.sessionTracker;
            Session session = sessionTracker.currentSession.get();
            if (session == null) {
                session = sessionTracker.startNewSession(new Date(), sessionTracker.client.userState.user, false);
            } else {
                session.isPaused.compareAndSet(true, false);
            }
            sessionTracker.notifySessionStartObserver(session);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("client");
        throw null;
    }
}
