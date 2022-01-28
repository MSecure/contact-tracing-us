package com.facebook.react.uimanager;

import android.util.SparseBooleanArray;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;

public class NativeViewHierarchyOptimizer {
    public final ShadowNodeRegistry mShadowNodeRegistry;
    public final SparseBooleanArray mTagsWithLayoutVisited = new SparseBooleanArray();
    public final UIViewOperationQueue mUIViewOperationQueue;

    public static class NodeIndexPair {
        public final int index;
        public final ReactShadowNode node;

        public NodeIndexPair(ReactShadowNode reactShadowNode, int i) {
            this.node = reactShadowNode;
            this.index = i;
        }
    }

    public NativeViewHierarchyOptimizer(UIViewOperationQueue uIViewOperationQueue, ShadowNodeRegistry shadowNodeRegistry) {
        this.mUIViewOperationQueue = uIViewOperationQueue;
        this.mShadowNodeRegistry = shadowNodeRegistry;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0184, code lost:
        if (r3.getInt("borderLeftColor") == 0) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0193, code lost:
        if (r3.getInt("backgroundColor") != 0) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01a8, code lost:
        if (r3.getDouble("borderWidth") != 0.0d) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01b9, code lost:
        if (r3.getDouble("opacity") != 1.0d) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00ff, code lost:
        if ("visible".equals(r3.getString("overflow")) == false) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x010f, code lost:
        if (r3.getDouble("borderBottomWidth") != 0.0d) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x011f, code lost:
        if (r3.getDouble("borderRightWidth") != 0.0d) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x012f, code lost:
        if (r3.getDouble("borderTopWidth") != 0.0d) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x013f, code lost:
        if (r3.getDouble("borderLeftWidth") != 0.0d) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x014f, code lost:
        if (r3.getDouble("borderWidth") != 0.0d) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x015d, code lost:
        if (r3.getInt("borderBottomColor") == 0) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x016a, code lost:
        if (r3.getInt("borderTopColor") == 0) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0177, code lost:
        if (r3.getInt("borderRightColor") == 0) goto L_0x01bb;
     */
    public static boolean isLayoutOnlyAndCollapsable(ReactStylesDiffMap reactStylesDiffMap) {
        char c;
        boolean z = true;
        if (reactStylesDiffMap == null) {
            return true;
        }
        boolean z2 = false;
        if (reactStylesDiffMap.mBackingMap.hasKey("collapsable")) {
            if (!(reactStylesDiffMap.mBackingMap.isNull("collapsable") ? true : reactStylesDiffMap.mBackingMap.getBoolean("collapsable"))) {
                return false;
            }
        }
        ReadableMapKeySetIterator keySetIterator = reactStylesDiffMap.mBackingMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            ReadableMap readableMap = reactStylesDiffMap.mBackingMap;
            String nextKey = keySetIterator.nextKey();
            if (!ViewProps.LAYOUT_ONLY_PROPS.contains(nextKey)) {
                if (!"pointerEvents".equals(nextKey)) {
                    switch (nextKey.hashCode()) {
                        case -1989576717:
                            if (nextKey.equals("borderRightColor")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1971292586:
                            if (nextKey.equals("borderRightWidth")) {
                                c = '\t';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1470826662:
                            if (nextKey.equals("borderTopColor")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1452542531:
                            if (nextKey.equals("borderTopWidth")) {
                                c = '\b';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1308858324:
                            if (nextKey.equals("borderBottomColor")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1290574193:
                            if (nextKey.equals("borderBottomWidth")) {
                                c = '\n';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1267206133:
                            if (nextKey.equals("opacity")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -242276144:
                            if (nextKey.equals("borderLeftColor")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -223992013:
                            if (nextKey.equals("borderLeftWidth")) {
                                c = 7;
                                break;
                            }
                            c = 65535;
                            break;
                        case 529642498:
                            if (nextKey.equals("overflow")) {
                                c = 11;
                                break;
                            }
                            c = 65535;
                            break;
                        case 741115130:
                            if (nextKey.equals("borderWidth")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1349188574:
                            if (nextKey.equals("borderRadius")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            if (!readableMap.isNull("opacity")) {
                                break;
                            }
                            z = true;
                            break;
                        case 1:
                            if (readableMap.hasKey("backgroundColor")) {
                                break;
                            }
                            if (readableMap.hasKey("borderWidth")) {
                                if (!readableMap.isNull("borderWidth")) {
                                    break;
                                }
                            }
                            z = true;
                            break;
                        case 2:
                            if (!readableMap.isNull("borderLeftColor")) {
                                break;
                            }
                            z = false;
                            break;
                        case 3:
                            if (!readableMap.isNull("borderRightColor")) {
                                break;
                            }
                            z = false;
                            break;
                        case 4:
                            if (!readableMap.isNull("borderTopColor")) {
                                break;
                            }
                            z = false;
                            break;
                        case 5:
                            if (!readableMap.isNull("borderBottomColor")) {
                                break;
                            }
                            z = false;
                            break;
                        case 6:
                            if (!readableMap.isNull("borderWidth")) {
                                break;
                            }
                            z = true;
                            break;
                        case 7:
                            if (!readableMap.isNull("borderLeftWidth")) {
                                break;
                            }
                            z = true;
                            break;
                        case '\b':
                            if (!readableMap.isNull("borderTopWidth")) {
                                break;
                            }
                            z = true;
                            break;
                        case '\t':
                            if (!readableMap.isNull("borderRightWidth")) {
                                break;
                            }
                            z = true;
                            break;
                        case '\n':
                            if (!readableMap.isNull("borderBottomWidth")) {
                                break;
                            }
                            z = true;
                            break;
                        case 11:
                            if (!readableMap.isNull("overflow")) {
                                break;
                            }
                            z = true;
                            break;
                        default:
                            z = false;
                            break;
                    }
                } else {
                    String string = readableMap.getString(nextKey);
                    if (!"auto".equals(string) && !"box-none".equals(string)) {
                        z = z2;
                    }
                }
            }
            if (!z) {
                return false;
            }
            z = true;
            z2 = false;
        }
        return z;
    }

    public final void addGrandchildren(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i) {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(reactShadowNode2.getNativeKind() != NativeKind.PARENT);
        for (int i2 = 0; i2 < reactShadowNode2.getChildCount(); i2++) {
            ReactShadowNode childAt = reactShadowNode2.getChildAt(i2);
            AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(childAt.getNativeParent() == null);
            int nativeChildCount = reactShadowNode.getNativeChildCount();
            if (childAt.getNativeKind() == NativeKind.NONE) {
                addGrandchildren(reactShadowNode, childAt, i);
            } else {
                addNativeChild(reactShadowNode, childAt, i);
            }
            i += reactShadowNode.getNativeChildCount() - nativeChildCount;
        }
    }

    public final void addNativeChild(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i) {
        reactShadowNode.addNativeChildAt(reactShadowNode2, i);
        this.mUIViewOperationQueue.enqueueManageChildren(reactShadowNode.getReactTag(), null, new ViewAtIndex[]{new ViewAtIndex(reactShadowNode2.getReactTag(), i)}, null);
        if (reactShadowNode2.getNativeKind() != NativeKind.PARENT) {
            addGrandchildren(reactShadowNode, reactShadowNode2, i + 1);
        }
    }

    public final void addNodeToNode(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i) {
        NodeIndexPair nodeIndexPair;
        NativeKind nativeKind = NativeKind.PARENT;
        int nativeOffsetForChild = reactShadowNode.getNativeOffsetForChild(reactShadowNode.getChildAt(i));
        if (reactShadowNode.getNativeKind() != nativeKind) {
            while (true) {
                if (reactShadowNode.getNativeKind() == nativeKind) {
                    nodeIndexPair = new NodeIndexPair(reactShadowNode, nativeOffsetForChild);
                    break;
                }
                ReactShadowNode parent = reactShadowNode.getParent();
                if (parent == null) {
                    nodeIndexPair = null;
                    break;
                } else {
                    nativeOffsetForChild = nativeOffsetForChild + (reactShadowNode.getNativeKind() == NativeKind.LEAF ? 1 : 0) + parent.getNativeOffsetForChild(reactShadowNode);
                    reactShadowNode = parent;
                }
            }
            if (nodeIndexPair != null) {
                ReactShadowNode reactShadowNode3 = nodeIndexPair.node;
                nativeOffsetForChild = nodeIndexPair.index;
                reactShadowNode = reactShadowNode3;
            } else {
                return;
            }
        }
        if (reactShadowNode2.getNativeKind() != NativeKind.NONE) {
            addNativeChild(reactShadowNode, reactShadowNode2, nativeOffsetForChild);
        } else {
            addGrandchildren(reactShadowNode, reactShadowNode2, nativeOffsetForChild);
        }
    }

    public final void applyLayoutBase(ReactShadowNode reactShadowNode) {
        int reactTag = reactShadowNode.getReactTag();
        if (!this.mTagsWithLayoutVisited.get(reactTag)) {
            this.mTagsWithLayoutVisited.put(reactTag, true);
            ReactShadowNode parent = reactShadowNode.getParent();
            int screenX = reactShadowNode.getScreenX();
            int screenY = reactShadowNode.getScreenY();
            while (parent != null && parent.getNativeKind() != NativeKind.PARENT) {
                if (!parent.isVirtual()) {
                    int round = Math.round(parent.getLayoutX()) + screenX;
                    screenY = Math.round(parent.getLayoutY()) + screenY;
                    screenX = round;
                }
                parent = parent.getParent();
            }
            applyLayoutRecursive(reactShadowNode, screenX, screenY);
        }
    }

    public final void applyLayoutRecursive(ReactShadowNode reactShadowNode, int i, int i2) {
        if (reactShadowNode.getNativeKind() == NativeKind.NONE || reactShadowNode.getNativeParent() == null) {
            for (int i3 = 0; i3 < reactShadowNode.getChildCount(); i3++) {
                ReactShadowNode childAt = reactShadowNode.getChildAt(i3);
                int reactTag = childAt.getReactTag();
                if (!this.mTagsWithLayoutVisited.get(reactTag)) {
                    this.mTagsWithLayoutVisited.put(reactTag, true);
                    applyLayoutRecursive(childAt, childAt.getScreenX() + i, childAt.getScreenY() + i2);
                }
            }
            return;
        }
        this.mUIViewOperationQueue.enqueueUpdateLayout(reactShadowNode.getLayoutParent().getReactTag(), reactShadowNode.getReactTag(), i, i2, reactShadowNode.getScreenWidth(), reactShadowNode.getScreenHeight());
    }

    public void handleManageChildren(ReactShadowNode reactShadowNode, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
        boolean z;
        for (int i : iArr) {
            int i2 = 0;
            while (true) {
                if (i2 >= iArr2.length) {
                    z = false;
                    break;
                } else if (iArr2[i2] == i) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            removeNodeFromParent(this.mShadowNodeRegistry.getNode(i), z);
        }
        for (ViewAtIndex viewAtIndex : viewAtIndexArr) {
            addNodeToNode(reactShadowNode, this.mShadowNodeRegistry.getNode(viewAtIndex.mTag), viewAtIndex.mIndex);
        }
    }

    public final void removeNodeFromParent(ReactShadowNode reactShadowNode, boolean z) {
        if (reactShadowNode.getNativeKind() != NativeKind.PARENT) {
            for (int childCount = reactShadowNode.getChildCount() - 1; childCount >= 0; childCount--) {
                removeNodeFromParent(reactShadowNode.getChildAt(childCount), z);
            }
        }
        ReactShadowNode nativeParent = reactShadowNode.getNativeParent();
        if (nativeParent != null) {
            int indexOfNativeChild = nativeParent.indexOfNativeChild(reactShadowNode);
            nativeParent.removeNativeChildAt(indexOfNativeChild);
            this.mUIViewOperationQueue.enqueueManageChildren(nativeParent.getReactTag(), new int[]{indexOfNativeChild}, null, z ? new int[]{reactShadowNode.getReactTag()} : null);
        }
    }

    public final void transitionLayoutOnlyViewToNativeView(ReactShadowNode reactShadowNode, ReactStylesDiffMap reactStylesDiffMap) {
        ReactShadowNode parent = reactShadowNode.getParent();
        if (parent == null) {
            reactShadowNode.setIsLayoutOnly(false);
            return;
        }
        int indexOf = parent.indexOf(reactShadowNode);
        parent.removeChildAt(indexOf);
        removeNodeFromParent(reactShadowNode, false);
        reactShadowNode.setIsLayoutOnly(false);
        this.mUIViewOperationQueue.enqueueCreateView(reactShadowNode.getThemedContext(), reactShadowNode.getReactTag(), reactShadowNode.getViewClass(), reactStylesDiffMap);
        parent.addChildAt(reactShadowNode, indexOf);
        addNodeToNode(parent, reactShadowNode, indexOf);
        for (int i = 0; i < reactShadowNode.getChildCount(); i++) {
            addNodeToNode(reactShadowNode, reactShadowNode.getChildAt(i), i);
        }
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(this.mTagsWithLayoutVisited.size() == 0);
        applyLayoutBase(reactShadowNode);
        for (int i2 = 0; i2 < reactShadowNode.getChildCount(); i2++) {
            applyLayoutBase(reactShadowNode.getChildAt(i2));
        }
        this.mTagsWithLayoutVisited.clear();
    }
}
