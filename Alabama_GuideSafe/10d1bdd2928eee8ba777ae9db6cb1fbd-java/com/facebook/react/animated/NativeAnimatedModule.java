package com.facebook.react.animated;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeAnimatedModuleSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModuleListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NativeAnimatedModule extends NativeAnimatedModuleSpec implements LifecycleEventListener, UIManagerModuleListener {
    public static final String NAME;
    public final GuardedFrameCallback mAnimatedFrameCallback;
    public NativeAnimatedNodesManager mNodesManager;
    public ArrayList<UIThreadOperation> mOperations = new ArrayList<>();
    public ArrayList<UIThreadOperation> mPreOperations = new ArrayList<>();
    public final ReactChoreographer mReactChoreographer = ReactChoreographer.getInstance();

    public interface UIThreadOperation {
        void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager);
    }

    public NativeAnimatedModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mAnimatedFrameCallback = new GuardedFrameCallback(reactApplicationContext) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:9:0x001c A[Catch:{ Exception -> 0x0036 }] */
            @Override // com.facebook.react.uimanager.GuardedFrameCallback
            public void doFrameGuarded(long j) {
                boolean z;
                try {
                    NativeAnimatedNodesManager nodesManager = NativeAnimatedModule.this.getNodesManager();
                    if (nodesManager.mActiveAnimations.size() <= 0) {
                        if (nodesManager.mUpdatedNodes.size() <= 0) {
                            z = false;
                            if (z) {
                                nodesManager.runUpdates(j);
                            }
                            ReactChoreographer reactChoreographer = NativeAnimatedModule.this.mReactChoreographer;
                            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactChoreographer);
                            reactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, NativeAnimatedModule.this.mAnimatedFrameCallback);
                        }
                    }
                    z = true;
                    if (z) {
                    }
                    ReactChoreographer reactChoreographer2 = NativeAnimatedModule.this.mReactChoreographer;
                    AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactChoreographer2);
                    reactChoreographer2.postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, NativeAnimatedModule.this.mAnimatedFrameCallback);
                } catch (Exception e) {
                    FLog.e("ReactNative", "Exception while executing animated frame callback.", e);
                    throw new RuntimeException(e);
                }
            }
        };
    }

    private void clearFrameCallback() {
        ReactChoreographer reactChoreographer = this.mReactChoreographer;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactChoreographer);
        reactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
    }

    private void enqueueFrameCallback() {
        ReactChoreographer reactChoreographer = this.mReactChoreographer;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactChoreographer);
        reactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
    }

    private NativeAnimatedNodesManager getNodesManager() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn;
        if (this.mNodesManager == null && (reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn()) != null) {
            this.mNodesManager = new NativeAnimatedNodesManager((UIManagerModule) reactApplicationContextIfActiveOrWarn.getNativeModule(UIManagerModule.class));
        }
        return this.mNodesManager;
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void addAnimatedEventToView(double d, final String str, final ReadableMap readableMap) {
        final int i = (int) d;
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass20 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                String str = str;
                ReadableMap readableMap = readableMap;
                if (nativeAnimatedNodesManager != null) {
                    int i2 = readableMap.getInt("animatedValueTag");
                    AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i2);
                    if (animatedNode == null) {
                        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline6("Animated node with tag ", i2, " does not exists"));
                    } else if (animatedNode instanceof ValueAnimatedNode) {
                        ReadableArray array = readableMap.getArray("nativeEventPath");
                        ArrayList arrayList = new ArrayList(array.size());
                        for (int i3 = 0; i3 < array.size(); i3++) {
                            arrayList.add(array.getString(i3));
                        }
                        EventAnimationDriver eventAnimationDriver = new EventAnimationDriver(arrayList, (ValueAnimatedNode) animatedNode);
                        String str2 = i + str;
                        if (nativeAnimatedNodesManager.mEventDrivers.containsKey(str2)) {
                            nativeAnimatedNodesManager.mEventDrivers.get(str2).add(eventAnimationDriver);
                            return;
                        }
                        ArrayList arrayList2 = new ArrayList(1);
                        arrayList2.add(eventAnimationDriver);
                        nativeAnimatedNodesManager.mEventDrivers.put(str2, arrayList2);
                    } else {
                        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Animated node connected to event should beof type ");
                        outline17.append(ValueAnimatedNode.class.getName());
                        throw new JSApplicationIllegalArgumentException(outline17.toString());
                    }
                } else {
                    throw null;
                }
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void addListener(String str) {
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void connectAnimatedNodeToView(double d, double d2) {
        final int i = (int) d;
        final int i2 = (int) d2;
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass17 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                int i2 = i2;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline6("Animated node with tag ", i, " does not exists"));
                } else if (animatedNode instanceof PropsAnimatedNode) {
                    PropsAnimatedNode propsAnimatedNode = (PropsAnimatedNode) animatedNode;
                    if (propsAnimatedNode.mConnectedViewTag == -1) {
                        propsAnimatedNode.mConnectedViewTag = i2;
                        nativeAnimatedNodesManager.mUpdatedNodes.put(i, animatedNode);
                        return;
                    }
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline13(GeneratedOutlineSupport.outline17("Animated node "), propsAnimatedNode.mTag, " is already attached to a view"));
                } else {
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("Animated node connected to view should beof type ");
                    outline17.append(PropsAnimatedNode.class.getName());
                    throw new JSApplicationIllegalArgumentException(outline17.toString());
                }
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void connectAnimatedNodes(double d, double d2) {
        final int i = (int) d;
        final int i2 = (int) d2;
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass15 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                int i2 = i2;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode != null) {
                    AnimatedNode animatedNode2 = nativeAnimatedNodesManager.mAnimatedNodes.get(i2);
                    if (animatedNode2 != null) {
                        if (animatedNode.mChildren == null) {
                            animatedNode.mChildren = new ArrayList(1);
                        }
                        List<AnimatedNode> list = animatedNode.mChildren;
                        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(list);
                        list.add(animatedNode2);
                        animatedNode2.onAttachedToNode(animatedNode);
                        nativeAnimatedNodesManager.mUpdatedNodes.put(i2, animatedNode2);
                        return;
                    }
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline6("Animated node with tag ", i2, " does not exists"));
                }
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline6("Animated node with tag ", i, " does not exists"));
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void createAnimatedNode(double d, final ReadableMap readableMap) {
        final int i = (int) d;
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass4 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                AnimatedNode animatedNode;
                int i = i;
                ReadableMap readableMap = readableMap;
                if (nativeAnimatedNodesManager.mAnimatedNodes.get(i) == null) {
                    String string = readableMap.getString("type");
                    if ("style".equals(string)) {
                        animatedNode = new StyleAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if ("value".equals(string)) {
                        animatedNode = new ValueAnimatedNode(readableMap);
                    } else if ("props".equals(string)) {
                        animatedNode = new PropsAnimatedNode(readableMap, nativeAnimatedNodesManager, nativeAnimatedNodesManager.mUIManagerModule);
                    } else if ("interpolation".equals(string)) {
                        animatedNode = new InterpolationAnimatedNode(readableMap);
                    } else if ("addition".equals(string)) {
                        animatedNode = new AdditionAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if ("subtraction".equals(string)) {
                        animatedNode = new SubtractionAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if ("division".equals(string)) {
                        animatedNode = new DivisionAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if ("multiplication".equals(string)) {
                        animatedNode = new MultiplicationAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if ("modulus".equals(string)) {
                        animatedNode = new ModulusAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if ("diffclamp".equals(string)) {
                        animatedNode = new DiffClampAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if ("transform".equals(string)) {
                        animatedNode = new TransformAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else if ("tracking".equals(string)) {
                        animatedNode = new TrackingAnimatedNode(readableMap, nativeAnimatedNodesManager);
                    } else {
                        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline10("Unsupported node type: ", string));
                    }
                    animatedNode.mTag = i;
                    nativeAnimatedNodesManager.mAnimatedNodes.put(i, animatedNode);
                    nativeAnimatedNodesManager.mUpdatedNodes.put(i, animatedNode);
                    return;
                }
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline6("Animated node with tag ", i, " already exists"));
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void disconnectAnimatedNodeFromView(double d, double d2) {
        final int i = (int) d;
        final int i2 = (int) d2;
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass18 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                int i2 = i2;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline6("Animated node with tag ", i, " does not exists"));
                } else if (animatedNode instanceof PropsAnimatedNode) {
                    PropsAnimatedNode propsAnimatedNode = (PropsAnimatedNode) animatedNode;
                    if (propsAnimatedNode.mConnectedViewTag == i2) {
                        propsAnimatedNode.mConnectedViewTag = -1;
                        return;
                    }
                    throw new JSApplicationIllegalArgumentException("Attempting to disconnect view that has not been connected with the given animated node");
                } else {
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("Animated node connected to view should beof type ");
                    outline17.append(PropsAnimatedNode.class.getName());
                    throw new JSApplicationIllegalArgumentException(outline17.toString());
                }
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void disconnectAnimatedNodes(double d, double d2) {
        final int i = (int) d;
        final int i2 = (int) d2;
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass16 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                int i2 = i2;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode != null) {
                    AnimatedNode animatedNode2 = nativeAnimatedNodesManager.mAnimatedNodes.get(i2);
                    if (animatedNode2 != null) {
                        if (animatedNode.mChildren != null) {
                            animatedNode2.onDetachedFromNode(animatedNode);
                            animatedNode.mChildren.remove(animatedNode2);
                        }
                        nativeAnimatedNodesManager.mUpdatedNodes.put(i2, animatedNode2);
                        return;
                    }
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline6("Animated node with tag ", i2, " does not exists"));
                }
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline6("Animated node with tag ", i, " does not exists"));
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void dropAnimatedNode(double d) {
        final int i = (int) d;
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass8 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                nativeAnimatedNodesManager.mAnimatedNodes.remove(i);
                nativeAnimatedNodesManager.mUpdatedNodes.remove(i);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void extractAnimatedNodeOffset(double d) {
        final int i = (int) d;
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass12 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline6("Animated node with tag ", i, " does not exists or is not a 'value' node"));
                }
                ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) animatedNode;
                valueAnimatedNode.mOffset += valueAnimatedNode.mValue;
                valueAnimatedNode.mValue = 0.0d;
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void flattenAnimatedNodeOffset(double d) {
        final int i = (int) d;
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass11 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline6("Animated node with tag ", i, " does not exists or is not a 'value' node"));
                }
                ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) animatedNode;
                valueAnimatedNode.mValue += valueAnimatedNode.mOffset;
                valueAnimatedNode.mOffset = 0.0d;
            }
        });
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null && !reactApplicationContextIfActiveOrWarn.isBridgeless()) {
            reactApplicationContextIfActiveOrWarn.addLifecycleEventListener(this);
            ((UIManagerModule) reactApplicationContextIfActiveOrWarn.getNativeModule(UIManagerModule.class)).addUIManagerListener(this);
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        clearFrameCallback();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        enqueueFrameCallback();
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void removeAnimatedEventFromView(double d, final String str, double d2) {
        final int i = (int) d;
        final int i2 = (int) d2;
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass21 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                String str = str;
                int i2 = i2;
                if (nativeAnimatedNodesManager != null) {
                    String str2 = i + str;
                    if (nativeAnimatedNodesManager.mEventDrivers.containsKey(str2)) {
                        List<EventAnimationDriver> list = nativeAnimatedNodesManager.mEventDrivers.get(str2);
                        if (list.size() == 1) {
                            nativeAnimatedNodesManager.mEventDrivers.remove(i + str);
                            return;
                        }
                        ListIterator<EventAnimationDriver> listIterator = list.listIterator();
                        while (listIterator.hasNext()) {
                            if (listIterator.next().mValueNode.mTag == i2) {
                                listIterator.remove();
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                throw null;
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void removeListeners(double d) {
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void restoreDefaultValues(double d) {
        final int i = (int) d;
        this.mPreOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass19 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode != null) {
                    if (animatedNode instanceof PropsAnimatedNode) {
                        PropsAnimatedNode propsAnimatedNode = (PropsAnimatedNode) animatedNode;
                        ReadableMapKeySetIterator keySetIterator = propsAnimatedNode.mPropMap.keySetIterator();
                        while (keySetIterator.hasNextKey()) {
                            propsAnimatedNode.mPropMap.putNull(keySetIterator.nextKey());
                        }
                        propsAnimatedNode.mUIManager.synchronouslyUpdateViewOnUIThread(propsAnimatedNode.mConnectedViewTag, propsAnimatedNode.mPropMap);
                        return;
                    }
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("Animated node connected to view should beof type ");
                    outline17.append(PropsAnimatedNode.class.getName());
                    throw new JSApplicationIllegalArgumentException(outline17.toString());
                }
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void setAnimatedNodeOffset(double d, final double d2) {
        final int i = (int) d;
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass10 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                double d = d2;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline6("Animated node with tag ", i, " does not exists or is not a 'value' node"));
                }
                ((ValueAnimatedNode) animatedNode).mOffset = d;
                nativeAnimatedNodesManager.mUpdatedNodes.put(i, animatedNode);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void setAnimatedNodeValue(double d, final double d2) {
        final int i = (int) d;
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass9 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                double d = d2;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline6("Animated node with tag ", i, " does not exists or is not a 'value' node"));
                }
                nativeAnimatedNodesManager.stopAnimationsForNode(animatedNode);
                ((ValueAnimatedNode) animatedNode).mValue = d;
                nativeAnimatedNodesManager.mUpdatedNodes.put(i, animatedNode);
            }
        });
    }

    public void setNodesManager(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        this.mNodesManager = nativeAnimatedNodesManager;
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void startAnimatingNode(double d, double d2, final ReadableMap readableMap, final Callback callback) {
        final int i = (int) d;
        final int i2 = (int) d2;
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass13 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.startAnimatingNode(i, i2, readableMap, callback);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void startListeningToAnimatedNodeValue(double d) {
        final int i = (int) d;
        final AnonymousClass5 r4 = new AnimatedNodeValueListener() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass5 */
        };
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass6 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                AnimatedNodeValueListener animatedNodeValueListener = r4;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline6("Animated node with tag ", i, " does not exists or is not a 'value' node"));
                }
                ((ValueAnimatedNode) animatedNode).mValueListener = animatedNodeValueListener;
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void stopAnimation(double d) {
        final int i = (int) d;
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass14 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                for (int i2 = 0; i2 < nativeAnimatedNodesManager.mActiveAnimations.size(); i2++) {
                    AnimationDriver valueAt = nativeAnimatedNodesManager.mActiveAnimations.valueAt(i2);
                    if (valueAt.mId == i) {
                        if (valueAt.mEndCallback != null) {
                            WritableMap createMap = Arguments.createMap();
                            createMap.putBoolean("finished", false);
                            valueAt.mEndCallback.invoke(createMap);
                        }
                        nativeAnimatedNodesManager.mActiveAnimations.removeAt(i2);
                        return;
                    }
                }
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void stopListeningToAnimatedNodeValue(double d) {
        final int i = (int) d;
        this.mOperations.add(new UIThreadOperation(this) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass7 */

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                int i = i;
                AnimatedNode animatedNode = nativeAnimatedNodesManager.mAnimatedNodes.get(i);
                if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline6("Animated node with tag ", i, " does not exists or is not a 'value' node"));
                }
                ((ValueAnimatedNode) animatedNode).mValueListener = null;
            }
        });
    }

    @Override // com.facebook.react.uimanager.UIManagerModuleListener
    public void willDispatchViewUpdates(UIManagerModule uIManagerModule) {
        if (!this.mOperations.isEmpty() || !this.mPreOperations.isEmpty()) {
            final ArrayList<UIThreadOperation> arrayList = this.mPreOperations;
            final ArrayList<UIThreadOperation> arrayList2 = this.mOperations;
            this.mPreOperations = new ArrayList<>();
            this.mOperations = new ArrayList<>();
            uIManagerModule.prependUIBlock(new UIBlock() {
                /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass2 */

                @Override // com.facebook.react.uimanager.UIBlock
                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    NativeAnimatedNodesManager nodesManager = NativeAnimatedModule.this.getNodesManager();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((UIThreadOperation) it.next()).execute(nodesManager);
                    }
                }
            });
            uIManagerModule.addUIBlock(new UIBlock() {
                /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass3 */

                @Override // com.facebook.react.uimanager.UIBlock
                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    NativeAnimatedNodesManager nodesManager = NativeAnimatedModule.this.getNodesManager();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((UIThreadOperation) it.next()).execute(nodesManager);
                    }
                }
            });
        }
    }
}
