package com.facebook.react.animated;

import android.util.SparseArray;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NativeAnimatedNodesManager implements EventDispatcherListener {
    public final SparseArray<AnimationDriver> mActiveAnimations = new SparseArray<>();
    public int mAnimatedGraphBFSColor = 0;
    public final SparseArray<AnimatedNode> mAnimatedNodes = new SparseArray<>();
    public final UIManagerModule.CustomEventNamesResolver mCustomEventNamesResolver;
    public final Map<String, List<EventAnimationDriver>> mEventDrivers = new HashMap();
    public final List<AnimatedNode> mRunUpdateNodeList = new LinkedList();
    public final UIManagerModule mUIManagerModule;
    public final SparseArray<AnimatedNode> mUpdatedNodes = new SparseArray<>();

    public NativeAnimatedNodesManager(UIManagerModule uIManagerModule) {
        this.mUIManagerModule = uIManagerModule;
        uIManagerModule.getEventDispatcher().mListeners.add(this);
        this.mCustomEventNamesResolver = uIManagerModule.getDirectEventNamesResolver();
    }

    public AnimatedNode getNodeById(int i) {
        return this.mAnimatedNodes.get(i);
    }

    public final void handleEvent(Event event) {
        if (!this.mEventDrivers.isEmpty()) {
            UIManagerModule.CustomEventNamesResolver customEventNamesResolver = this.mCustomEventNamesResolver;
            String eventName = event.getEventName();
            Map map = (Map) UIManagerModule.this.mCustomDirectEvents.get(eventName);
            if (map != null) {
                eventName = (String) map.get("registrationName");
            }
            Map<String, List<EventAnimationDriver>> map2 = this.mEventDrivers;
            List<EventAnimationDriver> list = map2.get(event.mViewTag + eventName);
            if (list != null) {
                for (EventAnimationDriver eventAnimationDriver : list) {
                    stopAnimationsForNode(eventAnimationDriver.mValueNode);
                    event.dispatch(eventAnimationDriver);
                    this.mRunUpdateNodeList.add(eventAnimationDriver.mValueNode);
                }
                updateNodes(this.mRunUpdateNodeList);
                this.mRunUpdateNodeList.clear();
            }
        }
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcherListener
    public void onEventDispatch(final Event event) {
        if (UiThreadUtil.isOnUiThread()) {
            handleEvent(event);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.animated.NativeAnimatedNodesManager.AnonymousClass1 */

                public void run() {
                    NativeAnimatedNodesManager.this.handleEvent(event);
                }
            });
        }
    }

    public void runUpdates(long j) {
        UiThreadUtil.assertOnUiThread();
        for (int i = 0; i < this.mUpdatedNodes.size(); i++) {
            this.mRunUpdateNodeList.add(this.mUpdatedNodes.valueAt(i));
        }
        this.mUpdatedNodes.clear();
        boolean z = false;
        for (int i2 = 0; i2 < this.mActiveAnimations.size(); i2++) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i2);
            valueAt.runAnimationStep(j);
            this.mRunUpdateNodeList.add(valueAt.mAnimatedValue);
            if (valueAt.mHasFinished) {
                z = true;
            }
        }
        updateNodes(this.mRunUpdateNodeList);
        this.mRunUpdateNodeList.clear();
        if (z) {
            for (int size = this.mActiveAnimations.size() - 1; size >= 0; size--) {
                AnimationDriver valueAt2 = this.mActiveAnimations.valueAt(size);
                if (valueAt2.mHasFinished) {
                    if (valueAt2.mEndCallback != null) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putBoolean("finished", true);
                        valueAt2.mEndCallback.invoke(createMap);
                    }
                    this.mActiveAnimations.removeAt(size);
                }
            }
        }
    }

    public void startAnimatingNode(int i, int i2, ReadableMap readableMap, Callback callback) {
        AnimationDriver animationDriver;
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline5("Animated node with tag ", i2, " does not exists"));
        } else if (animatedNode instanceof ValueAnimatedNode) {
            AnimationDriver animationDriver2 = this.mActiveAnimations.get(i);
            if (animationDriver2 != null) {
                animationDriver2.resetConfig(readableMap);
                return;
            }
            String string = readableMap.getString("type");
            if ("frames".equals(string)) {
                animationDriver = new FrameBasedAnimationDriver(readableMap);
            } else if ("spring".equals(string)) {
                animationDriver = new SpringAnimation(readableMap);
            } else if ("decay".equals(string)) {
                animationDriver = new DecayAnimation(readableMap);
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("Unsupported animation type: ", string));
            }
            animationDriver.mId = i;
            animationDriver.mEndCallback = callback;
            animationDriver.mAnimatedValue = (ValueAnimatedNode) animatedNode;
            this.mActiveAnimations.put(i, animationDriver);
        } else {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Animated node should be of type ");
            outline15.append(ValueAnimatedNode.class.getName());
            throw new JSApplicationIllegalArgumentException(outline15.toString());
        }
    }

    public final void stopAnimationsForNode(AnimatedNode animatedNode) {
        int i = 0;
        while (i < this.mActiveAnimations.size()) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i);
            if (animatedNode.equals(valueAt.mAnimatedValue)) {
                if (valueAt.mEndCallback != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    valueAt.mEndCallback.invoke(createMap);
                }
                this.mActiveAnimations.removeAt(i);
                i--;
            }
            i++;
        }
    }

    public final void updateNodes(List<AnimatedNode> list) {
        ValueAnimatedNode valueAnimatedNode;
        AnimatedNodeValueListener animatedNodeValueListener;
        int i;
        int i2 = this.mAnimatedGraphBFSColor + 1;
        this.mAnimatedGraphBFSColor = i2;
        if (i2 == 0) {
            this.mAnimatedGraphBFSColor = i2 + 1;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i3 = 0;
        for (AnimatedNode animatedNode : list) {
            int i4 = animatedNode.mBFSColor;
            int i5 = this.mAnimatedGraphBFSColor;
            if (i4 != i5) {
                animatedNode.mBFSColor = i5;
                i3++;
                arrayDeque.add(animatedNode);
            }
        }
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode2 = (AnimatedNode) arrayDeque.poll();
            if (animatedNode2.mChildren != null) {
                for (int i6 = 0; i6 < animatedNode2.mChildren.size(); i6++) {
                    AnimatedNode animatedNode3 = animatedNode2.mChildren.get(i6);
                    animatedNode3.mActiveIncomingNodes++;
                    int i7 = animatedNode3.mBFSColor;
                    int i8 = this.mAnimatedGraphBFSColor;
                    if (i7 != i8) {
                        animatedNode3.mBFSColor = i8;
                        i3++;
                        arrayDeque.add(animatedNode3);
                    }
                }
            }
        }
        int i9 = this.mAnimatedGraphBFSColor + 1;
        this.mAnimatedGraphBFSColor = i9;
        if (i9 == 0) {
            this.mAnimatedGraphBFSColor = i9 + 1;
        }
        int i10 = 0;
        for (AnimatedNode animatedNode4 : list) {
            if (animatedNode4.mActiveIncomingNodes == 0 && animatedNode4.mBFSColor != (i = this.mAnimatedGraphBFSColor)) {
                animatedNode4.mBFSColor = i;
                i10++;
                arrayDeque.add(animatedNode4);
            }
        }
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode5 = (AnimatedNode) arrayDeque.poll();
            animatedNode5.update();
            if (animatedNode5 instanceof PropsAnimatedNode) {
                try {
                    ((PropsAnimatedNode) animatedNode5).updateView();
                } catch (IllegalViewOperationException e) {
                    FLog.e("ReactNative", "Native animation workaround, frame lost as result of race condition", e);
                }
            }
            if ((animatedNode5 instanceof ValueAnimatedNode) && (animatedNodeValueListener = (valueAnimatedNode = (ValueAnimatedNode) animatedNode5).mValueListener) != null) {
                double value = valueAnimatedNode.getValue();
                NativeAnimatedModule.AnonymousClass5 r5 = (NativeAnimatedModule.AnonymousClass5) animatedNodeValueListener;
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("tag", r3);
                createMap.putDouble("value", value);
                ReactApplicationContext access$300 = NativeAnimatedModule.access$300(NativeAnimatedModule.this);
                if (access$300 != null) {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) access$300.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onAnimatedValueUpdate", createMap);
                }
            }
            if (animatedNode5.mChildren != null) {
                for (int i11 = 0; i11 < animatedNode5.mChildren.size(); i11++) {
                    AnimatedNode animatedNode6 = animatedNode5.mChildren.get(i11);
                    int i12 = animatedNode6.mActiveIncomingNodes - 1;
                    animatedNode6.mActiveIncomingNodes = i12;
                    int i13 = animatedNode6.mBFSColor;
                    int i14 = this.mAnimatedGraphBFSColor;
                    if (i13 != i14 && i12 == 0) {
                        animatedNode6.mBFSColor = i14;
                        i10++;
                        arrayDeque.add(animatedNode6);
                    }
                }
            }
        }
        if (i3 != i10) {
            throw new IllegalStateException("Looks like animated nodes graph has cycles, there are " + i3 + " but toposort visited only " + i10);
        }
    }
}
