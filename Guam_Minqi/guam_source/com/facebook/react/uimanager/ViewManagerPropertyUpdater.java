package com.facebook.react.uimanager;

import android.view.View;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.ViewManagersPropertyCache;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ViewManagerPropertyUpdater {
    public static final Map<Class<?>, ShadowNodeSetter<?>> SHADOW_NODE_SETTER_MAP = new HashMap();
    public static final Map<Class<?>, ViewManagerSetter<?, ?>> VIEW_MANAGER_SETTER_MAP = new HashMap();

    public static class FallbackShadowNodeSetter<T extends ReactShadowNode> implements ShadowNodeSetter<T> {
        public final Map<String, ViewManagersPropertyCache.PropSetter> mPropSetters;

        public FallbackShadowNodeSetter(Class cls, AnonymousClass1 r2) {
            this.mPropSetters = ViewManagersPropertyCache.getNativePropSettersForShadowNodeClass(cls);
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.Settable
        public void getProperties(Map<String, String> map) {
            for (ViewManagersPropertyCache.PropSetter propSetter : this.mPropSetters.values()) {
                map.put(propSetter.mPropName, propSetter.mPropType);
            }
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.ShadowNodeSetter
        public void setProperty(ReactShadowNode reactShadowNode, String str, Object obj) {
            ViewManagersPropertyCache.PropSetter propSetter = this.mPropSetters.get(str);
            if (propSetter != null) {
                try {
                    if (propSetter.mIndex == null) {
                        ViewManagersPropertyCache.PropSetter.SHADOW_ARGS[0] = propSetter.getValueOrDefault(obj, reactShadowNode.getThemedContext());
                        propSetter.mSetter.invoke(reactShadowNode, ViewManagersPropertyCache.PropSetter.SHADOW_ARGS);
                        Arrays.fill(ViewManagersPropertyCache.PropSetter.SHADOW_ARGS, (Object) null);
                        return;
                    }
                    ViewManagersPropertyCache.PropSetter.SHADOW_GROUP_ARGS[0] = propSetter.mIndex;
                    ViewManagersPropertyCache.PropSetter.SHADOW_GROUP_ARGS[1] = propSetter.getValueOrDefault(obj, reactShadowNode.getThemedContext());
                    propSetter.mSetter.invoke(reactShadowNode, ViewManagersPropertyCache.PropSetter.SHADOW_GROUP_ARGS);
                    Arrays.fill(ViewManagersPropertyCache.PropSetter.SHADOW_GROUP_ARGS, (Object) null);
                } catch (Throwable th) {
                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("Error while updating prop ");
                    outline15.append(propSetter.mPropName);
                    FLog.e(ViewManager.class, outline15.toString(), th);
                    StringBuilder outline152 = GeneratedOutlineSupport.outline15("Error while updating property '");
                    outline152.append(propSetter.mPropName);
                    outline152.append("' in shadow node of type: ");
                    outline152.append(reactShadowNode.getViewClass());
                    throw new JSApplicationIllegalArgumentException(outline152.toString(), th);
                }
            }
        }
    }

    public static class FallbackViewManagerSetter<T extends ViewManager, V extends View> implements ViewManagerSetter<T, V> {
        public final Map<String, ViewManagersPropertyCache.PropSetter> mPropSetters;

        public FallbackViewManagerSetter(Class cls, AnonymousClass1 r2) {
            this.mPropSetters = ViewManagersPropertyCache.getNativePropSettersForViewManagerClass(cls);
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.Settable
        public void getProperties(Map<String, String> map) {
            for (ViewManagersPropertyCache.PropSetter propSetter : this.mPropSetters.values()) {
                map.put(propSetter.mPropName, propSetter.mPropType);
            }
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter
        public void setProperty(T t, V v, String str, Object obj) {
            ViewManagersPropertyCache.PropSetter propSetter = this.mPropSetters.get(str);
            if (propSetter != null) {
                try {
                    if (propSetter.mIndex == null) {
                        ViewManagersPropertyCache.PropSetter.VIEW_MGR_ARGS[0] = v;
                        ViewManagersPropertyCache.PropSetter.VIEW_MGR_ARGS[1] = propSetter.getValueOrDefault(obj, v.getContext());
                        propSetter.mSetter.invoke(t, ViewManagersPropertyCache.PropSetter.VIEW_MGR_ARGS);
                        Arrays.fill(ViewManagersPropertyCache.PropSetter.VIEW_MGR_ARGS, (Object) null);
                        return;
                    }
                    ViewManagersPropertyCache.PropSetter.VIEW_MGR_GROUP_ARGS[0] = v;
                    ViewManagersPropertyCache.PropSetter.VIEW_MGR_GROUP_ARGS[1] = propSetter.mIndex;
                    ViewManagersPropertyCache.PropSetter.VIEW_MGR_GROUP_ARGS[2] = propSetter.getValueOrDefault(obj, v.getContext());
                    propSetter.mSetter.invoke(t, ViewManagersPropertyCache.PropSetter.VIEW_MGR_GROUP_ARGS);
                    Arrays.fill(ViewManagersPropertyCache.PropSetter.VIEW_MGR_GROUP_ARGS, (Object) null);
                } catch (Throwable th) {
                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("Error while updating prop ");
                    outline15.append(propSetter.mPropName);
                    FLog.e(ViewManager.class, outline15.toString(), th);
                    StringBuilder outline152 = GeneratedOutlineSupport.outline15("Error while updating property '");
                    outline152.append(propSetter.mPropName);
                    outline152.append("' of a view managed by: ");
                    outline152.append(t.getName());
                    throw new JSApplicationIllegalArgumentException(outline152.toString(), th);
                }
            }
        }
    }

    public interface Settable {
        void getProperties(Map<String, String> map);
    }

    public interface ShadowNodeSetter<T extends ReactShadowNode> extends Settable {
        void setProperty(T t, String str, Object obj);
    }

    public interface ViewManagerSetter<T extends ViewManager, V extends View> extends Settable {
        void setProperty(T t, V v, String str, Object obj);
    }

    public static void clear() {
        ViewManagersPropertyCache.CLASS_PROPS_CACHE.clear();
        ViewManagersPropertyCache.EMPTY_PROPS_MAP.clear();
        VIEW_MANAGER_SETTER_MAP.clear();
        SHADOW_NODE_SETTER_MAP.clear();
    }

    public static <T> T findGeneratedSetter(Class<?> cls) {
        String name = cls.getName();
        try {
            return (T) Class.forName(name + "$$PropsSetter").newInstance();
        } catch (ClassNotFoundException unused) {
            FLog.w("ViewManagerPropertyUpdater", "Could not find generated setter for " + cls);
            return null;
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(GeneratedOutlineSupport.outline8("Unable to instantiate methods getter for ", name), e);
        }
    }

    public static <T extends ViewManager, V extends View> ViewManagerSetter<T, V> findManagerSetter(Class<? extends ViewManager> cls) {
        FallbackViewManagerSetter fallbackViewManagerSetter = (ViewManagerSetter<T, V>) VIEW_MANAGER_SETTER_MAP.get(cls);
        if (fallbackViewManagerSetter == null) {
            fallbackViewManagerSetter = (ViewManagerSetter) findGeneratedSetter(cls);
            if (fallbackViewManagerSetter == null) {
                fallbackViewManagerSetter = new FallbackViewManagerSetter(cls, null);
            }
            VIEW_MANAGER_SETTER_MAP.put(cls, fallbackViewManagerSetter);
        }
        return fallbackViewManagerSetter;
    }

    public static <T extends ReactShadowNode> ShadowNodeSetter<T> findNodeSetter(Class<? extends ReactShadowNode> cls) {
        FallbackShadowNodeSetter fallbackShadowNodeSetter = (ShadowNodeSetter<T>) SHADOW_NODE_SETTER_MAP.get(cls);
        if (fallbackShadowNodeSetter == null) {
            fallbackShadowNodeSetter = (ShadowNodeSetter) findGeneratedSetter(cls);
            if (fallbackShadowNodeSetter == null) {
                fallbackShadowNodeSetter = new FallbackShadowNodeSetter(cls, null);
            }
            SHADOW_NODE_SETTER_MAP.put(cls, fallbackShadowNodeSetter);
        }
        return fallbackShadowNodeSetter;
    }

    public static Map<String, String> getNativeProps(Class<? extends ViewManager> cls, Class<? extends ReactShadowNode> cls2) {
        HashMap hashMap = new HashMap();
        findManagerSetter(cls).getProperties(hashMap);
        findNodeSetter(cls2).getProperties(hashMap);
        return hashMap;
    }

    public static <T extends ViewManager, V extends View> void updateProps(T t, V v, ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerSetter findManagerSetter = findManagerSetter(t.getClass());
        Iterator<Map.Entry<String, Object>> entryIterator = reactStylesDiffMap.mBackingMap.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> next = entryIterator.next();
            findManagerSetter.setProperty(t, v, next.getKey(), next.getValue());
        }
    }

    public static <T extends ReactShadowNode> void updateProps(T t, ReactStylesDiffMap reactStylesDiffMap) {
        ShadowNodeSetter findNodeSetter = findNodeSetter(t.getClass());
        Iterator<Map.Entry<String, Object>> entryIterator = reactStylesDiffMap.mBackingMap.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> next = entryIterator.next();
            findNodeSetter.setProperty(t, next.getKey(), next.getValue());
        }
    }
}
