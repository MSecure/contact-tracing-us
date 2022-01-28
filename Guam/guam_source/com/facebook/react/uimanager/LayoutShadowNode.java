package com.facebook.react.uimanager;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaNative;
import com.facebook.yoga.YogaNodeJNIBase;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaWrap;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

public class LayoutShadowNode extends ReactShadowNodeImpl {
    public final MutableYogaValue mTempYogaValue = new MutableYogaValue(null);

    public static class MutableYogaValue {
        public YogaUnit unit;
        public float value;

        public MutableYogaValue(AnonymousClass1 r1) {
        }

        public void setFromDynamic(Dynamic dynamic) {
            if (dynamic.isNull()) {
                this.unit = YogaUnit.UNDEFINED;
                this.value = Float.NaN;
            } else if (dynamic.getType() == ReadableType.String) {
                String asString = dynamic.asString();
                if (asString.equals("auto")) {
                    this.unit = YogaUnit.AUTO;
                    this.value = Float.NaN;
                } else if (asString.endsWith("%")) {
                    this.unit = YogaUnit.PERCENT;
                    this.value = Float.parseFloat(asString.substring(0, asString.length() - 1));
                } else {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline8("Unknown value: ", asString));
                }
            } else {
                this.unit = YogaUnit.POINT;
                this.value = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(dynamic.asDouble());
            }
        }
    }

    public final int maybeTransformLeftRightToStartEnd(int i) {
        if (!I18nUtil.getInstance().doLeftAndRightSwapInRTL(getThemedContext())) {
            return i;
        }
        if (i == 0) {
            return 4;
        }
        if (i != 2) {
            return i;
        }
        return 5;
    }

    @ReactProp(name = "alignContent")
    public void setAlignContent(String str) {
        YogaAlign yogaAlign = YogaAlign.FLEX_START;
        if (!isVirtual()) {
            if (str == null) {
                YogaNative.jni_YGNodeStyleSetAlignContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaAlign.mIntValue);
                return;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c = 0;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    YogaNative.jni_YGNodeStyleSetAlignContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.AUTO.mIntValue);
                    return;
                case 1:
                    YogaNative.jni_YGNodeStyleSetAlignContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaAlign.mIntValue);
                    return;
                case 2:
                    YogaNative.jni_YGNodeStyleSetAlignContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.CENTER.mIntValue);
                    return;
                case 3:
                    YogaNative.jni_YGNodeStyleSetAlignContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.FLEX_END.mIntValue);
                    return;
                case 4:
                    YogaNative.jni_YGNodeStyleSetAlignContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.STRETCH.mIntValue);
                    return;
                case 5:
                    YogaNative.jni_YGNodeStyleSetAlignContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.BASELINE.mIntValue);
                    return;
                case 6:
                    YogaNative.jni_YGNodeStyleSetAlignContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.SPACE_BETWEEN.mIntValue);
                    return;
                case 7:
                    YogaNative.jni_YGNodeStyleSetAlignContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.SPACE_AROUND.mIntValue);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("invalid value for alignContent: ", str));
            }
        }
    }

    @ReactProp(name = "alignItems")
    public void setAlignItems(String str) {
        YogaAlign yogaAlign = YogaAlign.STRETCH;
        if (!isVirtual()) {
            if (str == null) {
                YogaNative.jni_YGNodeStyleSetAlignItemsJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaAlign.mIntValue);
                return;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c = 0;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    YogaNative.jni_YGNodeStyleSetAlignItemsJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.AUTO.mIntValue);
                    return;
                case 1:
                    YogaNative.jni_YGNodeStyleSetAlignItemsJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.FLEX_START.mIntValue);
                    return;
                case 2:
                    YogaNative.jni_YGNodeStyleSetAlignItemsJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.CENTER.mIntValue);
                    return;
                case 3:
                    YogaNative.jni_YGNodeStyleSetAlignItemsJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.FLEX_END.mIntValue);
                    return;
                case 4:
                    YogaNative.jni_YGNodeStyleSetAlignItemsJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaAlign.mIntValue);
                    return;
                case 5:
                    YogaNative.jni_YGNodeStyleSetAlignItemsJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.BASELINE.mIntValue);
                    return;
                case 6:
                    YogaNative.jni_YGNodeStyleSetAlignItemsJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.SPACE_BETWEEN.mIntValue);
                    return;
                case 7:
                    YogaNative.jni_YGNodeStyleSetAlignItemsJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.SPACE_AROUND.mIntValue);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("invalid value for alignItems: ", str));
            }
        }
    }

    @ReactProp(name = "alignSelf")
    public void setAlignSelf(String str) {
        YogaAlign yogaAlign = YogaAlign.AUTO;
        if (!isVirtual()) {
            if (str == null) {
                YogaNative.jni_YGNodeStyleSetAlignSelfJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaAlign.mIntValue);
                return;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c = 0;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    YogaNative.jni_YGNodeStyleSetAlignSelfJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaAlign.mIntValue);
                    return;
                case 1:
                    YogaNative.jni_YGNodeStyleSetAlignSelfJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.FLEX_START.mIntValue);
                    return;
                case 2:
                    YogaNative.jni_YGNodeStyleSetAlignSelfJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.CENTER.mIntValue);
                    return;
                case 3:
                    YogaNative.jni_YGNodeStyleSetAlignSelfJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.FLEX_END.mIntValue);
                    return;
                case 4:
                    YogaNative.jni_YGNodeStyleSetAlignSelfJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.STRETCH.mIntValue);
                    return;
                case 5:
                    YogaNative.jni_YGNodeStyleSetAlignSelfJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.BASELINE.mIntValue);
                    return;
                case 6:
                    YogaNative.jni_YGNodeStyleSetAlignSelfJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.SPACE_BETWEEN.mIntValue);
                    return;
                case 7:
                    YogaNative.jni_YGNodeStyleSetAlignSelfJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaAlign.SPACE_AROUND.mIntValue);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("invalid value for alignSelf: ", str));
            }
        }
    }

    @ReactProp(defaultFloat = Float.NaN, name = "aspectRatio")
    public void setAspectRatio(float f) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, f);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
    public void setBorderWidths(int i, float f) {
        if (!isVirtual()) {
            int maybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.BORDER_SPACING_TYPES[i]);
            YogaNative.jni_YGNodeStyleSetBorderJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaEdge.fromInt(maybeTransformLeftRightToStartEnd).mIntValue, AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f));
        }
    }

    @ReactProp(name = "collapsable")
    public void setCollapsable(boolean z) {
    }

    @ReactProp(name = "display")
    public void setDisplay(String str) {
        YogaDisplay yogaDisplay = YogaDisplay.FLEX;
        if (!isVirtual()) {
            if (str == null) {
                YogaNative.jni_YGNodeStyleSetDisplayJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaDisplay.mIntValue);
                return;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 3145721) {
                if (hashCode == 3387192 && str.equals("none")) {
                    c = 1;
                }
            } else if (str.equals("flex")) {
                c = 0;
            }
            if (c == 0) {
                YogaNative.jni_YGNodeStyleSetDisplayJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaDisplay.mIntValue);
            } else if (c == 1) {
                YogaNative.jni_YGNodeStyleSetDisplayJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaDisplay.NONE.mIntValue);
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("invalid value for display: ", str));
            }
        }
    }

    @ReactProp(defaultFloat = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, name = "flex")
    public void setFlex(float f) {
        if (!isVirtual()) {
            YogaNative.jni_YGNodeStyleSetFlexJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, f);
        }
    }

    @ReactProp(name = "flexBasis")
    public void setFlexBasis(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                YogaNative.jni_YGNodeStyleSetFlexBasisJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetFlexBasisPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 3) {
                YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "flexDirection")
    public void setFlexDirection(String str) {
        YogaFlexDirection yogaFlexDirection = YogaFlexDirection.COLUMN;
        if (!isVirtual()) {
            if (str == null) {
                YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaFlexDirection.mIntValue);
                return;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1448970769:
                    if (str.equals("row-reverse")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1354837162:
                    if (str.equals(StackTraceHelper.COLUMN_KEY)) {
                        c = 0;
                        break;
                    }
                    break;
                case 113114:
                    if (str.equals("row")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1272730475:
                    if (str.equals("column-reverse")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaFlexDirection.mIntValue);
            } else if (c == 1) {
                YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaFlexDirection.COLUMN_REVERSE.mIntValue);
            } else if (c == 2) {
                YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaFlexDirection.ROW.mIntValue);
            } else if (c == 3) {
                YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaFlexDirection.ROW_REVERSE.mIntValue);
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("invalid value for flexDirection: ", str));
            }
        }
    }

    @ReactProp(defaultFloat = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, name = "flexGrow")
    public void setFlexGrow(float f) {
        if (!isVirtual()) {
            YogaNative.jni_YGNodeStyleSetFlexGrowJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, f);
        }
    }

    @ReactProp(defaultFloat = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, name = "flexShrink")
    public void setFlexShrink(float f) {
        if (!isVirtual()) {
            YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, f);
        }
    }

    @ReactProp(name = "flexWrap")
    public void setFlexWrap(String str) {
        YogaWrap yogaWrap = YogaWrap.NO_WRAP;
        if (!isVirtual()) {
            if (str == null) {
                YogaNative.jni_YGNodeStyleSetFlexWrapJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaWrap.mIntValue);
                return;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1039592053) {
                if (hashCode != -749527969) {
                    if (hashCode == 3657802 && str.equals("wrap")) {
                        c = 1;
                    }
                } else if (str.equals("wrap-reverse")) {
                    c = 2;
                }
            } else if (str.equals("nowrap")) {
                c = 0;
            }
            if (c == 0) {
                YogaNative.jni_YGNodeStyleSetFlexWrapJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaWrap.mIntValue);
            } else if (c == 1) {
                YogaNative.jni_YGNodeStyleSetFlexWrapJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaWrap.WRAP.mIntValue);
            } else if (c == 2) {
                YogaNative.jni_YGNodeStyleSetFlexWrapJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaWrap.WRAP_REVERSE.mIntValue);
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("invalid value for flexWrap: ", str));
            }
        }
    }

    @ReactProp(name = RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT)
    public void setHeight(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                setStyleHeight(this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetHeightPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 3) {
                YogaNative.jni_YGNodeStyleSetHeightAutoJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "justifyContent")
    public void setJustifyContent(String str) {
        YogaJustify yogaJustify = YogaJustify.FLEX_START;
        if (!isVirtual()) {
            if (str == null) {
                YogaNative.jni_YGNodeStyleSetJustifyContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaJustify.mIntValue);
                return;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c = 1;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c = 0;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2055030478:
                    if (str.equals("space-evenly")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                YogaNative.jni_YGNodeStyleSetJustifyContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaJustify.mIntValue);
            } else if (c == 1) {
                YogaNative.jni_YGNodeStyleSetJustifyContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaJustify.CENTER.mIntValue);
            } else if (c == 2) {
                YogaNative.jni_YGNodeStyleSetJustifyContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaJustify.FLEX_END.mIntValue);
            } else if (c == 3) {
                YogaNative.jni_YGNodeStyleSetJustifyContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaJustify.SPACE_BETWEEN.mIntValue);
            } else if (c == 4) {
                YogaNative.jni_YGNodeStyleSetJustifyContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaJustify.SPACE_AROUND.mIntValue);
            } else if (c == 5) {
                YogaNative.jni_YGNodeStyleSetJustifyContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaJustify.SPACE_EVENLY.mIntValue);
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("invalid value for justifyContent: ", str));
            }
        }
    }

    @ReactPropGroup(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i, Dynamic dynamic) {
        if (!isVirtual()) {
            int maybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                setMargin(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetMarginPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaEdge.fromInt(maybeTransformLeftRightToStartEnd).mIntValue, this.mTempYogaValue.value);
            } else if (ordinal == 3) {
                YogaNative.jni_YGNodeStyleSetMarginAutoJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaEdge.fromInt(maybeTransformLeftRightToStartEnd).mIntValue);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "maxHeight")
    public void setMaxHeight(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                YogaNative.jni_YGNodeStyleSetMaxHeightJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetMaxHeightPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "maxWidth")
    public void setMaxWidth(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                YogaNative.jni_YGNodeStyleSetMaxWidthJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetMaxWidthPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "minHeight")
    public void setMinHeight(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                YogaNative.jni_YGNodeStyleSetMinHeightJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetMinHeightPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "minWidth")
    public void setMinWidth(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                YogaNative.jni_YGNodeStyleSetMinWidthJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetMinWidthPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "overflow")
    public void setOverflow(String str) {
        YogaOverflow yogaOverflow = YogaOverflow.VISIBLE;
        if (!isVirtual()) {
            if (str == null) {
                YogaNative.jni_YGNodeStyleSetOverflowJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaOverflow.mIntValue);
                return;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1217487446) {
                if (hashCode != -907680051) {
                    if (hashCode == 466743410 && str.equals("visible")) {
                        c = 0;
                    }
                } else if (str.equals("scroll")) {
                    c = 2;
                }
            } else if (str.equals("hidden")) {
                c = 1;
            }
            if (c == 0) {
                YogaNative.jni_YGNodeStyleSetOverflowJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaOverflow.mIntValue);
            } else if (c == 1) {
                YogaNative.jni_YGNodeStyleSetOverflowJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaOverflow.HIDDEN.mIntValue);
            } else if (c == 2) {
                YogaNative.jni_YGNodeStyleSetOverflowJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaOverflow.SCROLL.mIntValue);
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("invalid value for overflow: ", str));
            }
        }
    }

    @ReactPropGroup(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i, Dynamic dynamic) {
        if (!isVirtual()) {
            int maybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                setPadding(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                float f = this.mTempYogaValue.value;
                this.mPadding[maybeTransformLeftRightToStartEnd] = f;
                this.mPaddingIsPercent[maybeTransformLeftRightToStartEnd] = !ReactYogaConfigProvider.isUndefined(f);
                updatePadding();
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "position")
    public void setPosition(String str) {
        YogaPositionType yogaPositionType = YogaPositionType.RELATIVE;
        if (!isVirtual()) {
            if (str == null) {
                YogaNative.jni_YGNodeStyleSetPositionTypeJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaPositionType.mIntValue);
                return;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -554435892) {
                if (hashCode == 1728122231 && str.equals("absolute")) {
                    c = 1;
                }
            } else if (str.equals("relative")) {
                c = 0;
            }
            if (c == 0) {
                YogaNative.jni_YGNodeStyleSetPositionTypeJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaPositionType.mIntValue);
            } else if (c == 1) {
                YogaNative.jni_YGNodeStyleSetPositionTypeJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaPositionType.ABSOLUTE.mIntValue);
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("invalid value for position: ", str));
            }
        }
    }

    @ReactPropGroup(names = {"start", "end", RNGestureHandlerModule.KEY_HIT_SLOP_LEFT, RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT, RNGestureHandlerModule.KEY_HIT_SLOP_TOP, RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM})
    public void setPositionValues(int i, Dynamic dynamic) {
        if (!isVirtual()) {
            int maybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(new int[]{4, 5, 0, 2, 1, 3}[i]);
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                YogaNative.jni_YGNodeStyleSetPositionJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaEdge.fromInt(maybeTransformLeftRightToStartEnd).mIntValue, this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetPositionPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaEdge.fromInt(maybeTransformLeftRightToStartEnd).mIntValue, this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "onLayout")
    public void setShouldNotifyOnLayout(boolean z) {
        this.mShouldNotifyOnLayout = z;
    }

    @ReactProp(name = RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH)
    public void setWidth(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int ordinal = this.mTempYogaValue.unit.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                setStyleWidth(this.mTempYogaValue.value);
            } else if (ordinal == 2) {
                YogaNative.jni_YGNodeStyleSetWidthPercentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, this.mTempYogaValue.value);
            } else if (ordinal == 3) {
                YogaNative.jni_YGNodeStyleSetWidthAutoJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer);
            }
            dynamic.recycle();
        }
    }
}
