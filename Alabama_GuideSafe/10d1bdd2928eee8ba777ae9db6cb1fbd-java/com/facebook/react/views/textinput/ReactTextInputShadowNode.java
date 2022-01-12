package com.facebook.react.views.textinput;

import android.annotation.TargetApi;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.ReactTextViewManagerCallback;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaNode;

@TargetApi(23)
public class ReactTextInputShadowNode extends ReactBaseTextShadowNode implements YogaMeasureFunction {
    public EditText mInternalEditText;
    public ReactTextInputLocalData mLocalData;
    public int mMostRecentEventCount;
    public String mPlaceholder;
    public int mSelectionEnd;
    public int mSelectionStart;
    public String mText;

    public ReactTextInputShadowNode(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        super(reactTextViewManagerCallback);
        this.mMostRecentEventCount = -1;
        this.mText = null;
        this.mPlaceholder = null;
        this.mSelectionStart = -1;
        this.mSelectionEnd = -1;
        this.mTextBreakStrategy = 1;
        setMeasureFunction(this);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    public boolean isVirtualAnchor() {
        return true;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    public boolean isYogaLeafNode() {
        return true;
    }

    @Override // com.facebook.yoga.YogaMeasureFunction
    public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
        EditText editText = this.mInternalEditText;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(editText);
        ReactTextInputLocalData reactTextInputLocalData = this.mLocalData;
        if (reactTextInputLocalData != null) {
            editText.setText(reactTextInputLocalData.mText);
            editText.setTextSize(0, reactTextInputLocalData.mTextSize);
            editText.setMinLines(reactTextInputLocalData.mMinLines);
            editText.setMaxLines(reactTextInputLocalData.mMaxLines);
            editText.setInputType(reactTextInputLocalData.mInputType);
            editText.setHint(reactTextInputLocalData.mPlaceholder);
            editText.setBreakStrategy(reactTextInputLocalData.mBreakStrategy);
        } else {
            editText.setTextSize(0, (float) this.mTextAttributes.getEffectiveFontSize());
            int i = this.mNumberOfLines;
            if (i != -1) {
                editText.setLines(i);
            }
            int breakStrategy = editText.getBreakStrategy();
            int i2 = this.mTextBreakStrategy;
            if (breakStrategy != i2) {
                editText.setBreakStrategy(i2);
            }
        }
        editText.setHint(this.mPlaceholder);
        editText.measure(ReactYogaConfigProvider.getMeasureSpec(f, yogaMeasureMode), ReactYogaConfigProvider.getMeasureSpec(f2, yogaMeasureMode2));
        return ReactYogaConfigProvider.make(editText.getMeasuredWidth(), editText.getMeasuredHeight());
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
        if (this.mMostRecentEventCount != -1) {
            uIViewOperationQueue.enqueueUpdateExtraData(this.mReactTag, new ReactTextUpdate(spannedFromShadowNode(this, this.mText, false, null), this.mMostRecentEventCount, this.mContainsImages, getPadding(0), getPadding(1), getPadding(2), getPadding(3), this.mTextAlign, this.mTextBreakStrategy, this.mJustificationMode, this.mSelectionStart, this.mSelectionEnd));
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void setLocalData(Object obj) {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(obj instanceof ReactTextInputLocalData);
        this.mLocalData = (ReactTextInputLocalData) obj;
        dirty();
    }

    @ReactProp(name = "mostRecentEventCount")
    public void setMostRecentEventCount(int i) {
        this.mMostRecentEventCount = i;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    public void setPadding(int i, float f) {
        this.mPadding[i] = f;
        this.mPaddingIsPercent[i] = false;
        updatePadding();
        markUpdated();
    }

    @ReactProp(name = "placeholder")
    public void setPlaceholder(String str) {
        this.mPlaceholder = str;
        markUpdated();
    }

    @ReactProp(name = "selection")
    public void setSelection(ReadableMap readableMap) {
        this.mSelectionEnd = -1;
        this.mSelectionStart = -1;
        if (readableMap != null && readableMap.hasKey("start") && readableMap.hasKey("end")) {
            this.mSelectionStart = readableMap.getInt("start");
            this.mSelectionEnd = readableMap.getInt("end");
            markUpdated();
        }
    }

    @ReactProp(name = "text")
    public void setText(String str) {
        this.mText = str;
        if (str != null) {
            if (this.mSelectionStart > str.length()) {
                this.mSelectionStart = str.length();
            }
            if (this.mSelectionEnd > str.length()) {
                this.mSelectionEnd = str.length();
            }
        } else {
            this.mSelectionStart = -1;
            this.mSelectionEnd = -1;
        }
        markUpdated();
    }

    @Override // com.facebook.react.views.text.ReactBaseTextShadowNode
    public void setTextBreakStrategy(String str) {
        if (str == null || "simple".equals(str)) {
            this.mTextBreakStrategy = 0;
        } else if ("highQuality".equals(str)) {
            this.mTextBreakStrategy = 1;
        } else if ("balanced".equals(str)) {
            this.mTextBreakStrategy = 2;
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline10("Invalid textBreakStrategy: ", str));
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void setThemedContext(ThemedReactContext themedReactContext) {
        this.mThemedContext = themedReactContext;
        EditText editText = new EditText(getThemedContext());
        setDefaultPadding(4, (float) ViewCompat.getPaddingStart(editText));
        setDefaultPadding(1, (float) editText.getPaddingTop());
        setDefaultPadding(5, (float) editText.getPaddingEnd());
        setDefaultPadding(3, (float) editText.getPaddingBottom());
        this.mInternalEditText = editText;
        editText.setPadding(0, 0, 0, 0);
        this.mInternalEditText.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    }

    public ReactTextInputShadowNode() {
        this(null);
    }
}
