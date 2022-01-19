package com.facebook.react.animated;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.animated.TransformAnimatedNode;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.UIManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PropsAnimatedNode extends AnimatedNode {
    public int mConnectedViewTag = -1;
    public final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
    public final JavaOnlyMap mPropMap;
    public final Map<String, Integer> mPropNodeMapping;
    public final UIManager mUIManager;

    public PropsAnimatedNode(ReadableMap readableMap, NativeAnimatedNodesManager nativeAnimatedNodesManager, UIManager uIManager) {
        ReadableMap map = readableMap.getMap("props");
        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
        this.mPropNodeMapping = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            this.mPropNodeMapping.put(nextKey, Integer.valueOf(map.getInt(nextKey)));
        }
        this.mPropMap = new JavaOnlyMap();
        this.mNativeAnimatedNodesManager = nativeAnimatedNodesManager;
        this.mUIManager = uIManager;
    }

    public final void updateView() {
        double d;
        if (this.mConnectedViewTag != -1) {
            for (Map.Entry<String, Integer> entry : this.mPropNodeMapping.entrySet()) {
                AnimatedNode nodeById = this.mNativeAnimatedNodesManager.getNodeById(entry.getValue().intValue());
                if (nodeById == null) {
                    throw new IllegalArgumentException("Mapped property node does not exists");
                } else if (nodeById instanceof StyleAnimatedNode) {
                    StyleAnimatedNode styleAnimatedNode = (StyleAnimatedNode) nodeById;
                    JavaOnlyMap javaOnlyMap = this.mPropMap;
                    for (Map.Entry<String, Integer> entry2 : styleAnimatedNode.mPropMapping.entrySet()) {
                        AnimatedNode nodeById2 = styleAnimatedNode.mNativeAnimatedNodesManager.getNodeById(entry2.getValue().intValue());
                        if (nodeById2 == null) {
                            throw new IllegalArgumentException("Mapped style node does not exists");
                        } else if (nodeById2 instanceof TransformAnimatedNode) {
                            TransformAnimatedNode transformAnimatedNode = (TransformAnimatedNode) nodeById2;
                            ArrayList arrayList = new ArrayList(transformAnimatedNode.mTransformConfigs.size());
                            for (TransformAnimatedNode.TransformConfig transformConfig : transformAnimatedNode.mTransformConfigs) {
                                if (transformConfig instanceof TransformAnimatedNode.AnimatedTransformConfig) {
                                    AnimatedNode nodeById3 = transformAnimatedNode.mNativeAnimatedNodesManager.getNodeById(((TransformAnimatedNode.AnimatedTransformConfig) transformConfig).mNodeTag);
                                    if (nodeById3 == null) {
                                        throw new IllegalArgumentException("Mapped style node does not exists");
                                    } else if (nodeById3 instanceof ValueAnimatedNode) {
                                        d = ((ValueAnimatedNode) nodeById3).getValue();
                                    } else {
                                        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Unsupported type of node used as a transform child node ");
                                        outline15.append(nodeById3.getClass());
                                        throw new IllegalArgumentException(outline15.toString());
                                    }
                                } else {
                                    d = ((TransformAnimatedNode.StaticTransformConfig) transformConfig).mValue;
                                }
                                arrayList.add(JavaOnlyMap.of(transformConfig.mProperty, Double.valueOf(d)));
                            }
                            javaOnlyMap.putArray("transform", JavaOnlyArray.from(arrayList));
                        } else if (nodeById2 instanceof ValueAnimatedNode) {
                            javaOnlyMap.putDouble(entry2.getKey(), ((ValueAnimatedNode) nodeById2).getValue());
                        } else {
                            StringBuilder outline152 = GeneratedOutlineSupport.outline15("Unsupported type of node used in property node ");
                            outline152.append(nodeById2.getClass());
                            throw new IllegalArgumentException(outline152.toString());
                        }
                    }
                    continue;
                } else if (nodeById instanceof ValueAnimatedNode) {
                    ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) nodeById;
                    Object obj = valueAnimatedNode.mAnimatedObject;
                    if (obj instanceof String) {
                        this.mPropMap.putString(entry.getKey(), (String) obj);
                    } else {
                        this.mPropMap.putDouble(entry.getKey(), valueAnimatedNode.getValue());
                    }
                } else {
                    StringBuilder outline153 = GeneratedOutlineSupport.outline15("Unsupported type of node used in property node ");
                    outline153.append(nodeById.getClass());
                    throw new IllegalArgumentException(outline153.toString());
                }
            }
            this.mUIManager.synchronouslyUpdateViewOnUIThread(this.mConnectedViewTag, this.mPropMap);
        }
    }
}
