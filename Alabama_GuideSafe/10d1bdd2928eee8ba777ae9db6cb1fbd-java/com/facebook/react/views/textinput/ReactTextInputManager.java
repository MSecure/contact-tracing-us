package com.facebook.react.views.textinput;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.react.views.scroll.ScrollEventType;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.ReactTextViewManagerCallback;
import com.facebook.react.views.text.TextAttributeProps;
import com.facebook.react.views.text.TextInlineImageSpan;
import com.facebook.react.views.text.TextLayoutManager;
import com.facebook.react.views.text.TextTransform;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;

@ReactModule(name = ReactTextInputManager.REACT_CLASS)
public class ReactTextInputManager extends BaseViewManager<ReactEditText, LayoutShadowNode> {
    public static final int AUTOCAPITALIZE_FLAGS = 28672;
    public static final int BLUR_TEXT_INPUT = 2;
    public static final InputFilter[] EMPTY_FILTERS = new InputFilter[0];
    public static final int FOCUS_TEXT_INPUT = 1;
    public static final int IME_ACTION_ID = 1648;
    public static final int INPUT_TYPE_KEYBOARD_DECIMAL_PAD = 8194;
    public static final int INPUT_TYPE_KEYBOARD_NUMBERED = 12290;
    public static final int INPUT_TYPE_KEYBOARD_NUMBER_PAD = 2;
    public static final String KEYBOARD_TYPE_DECIMAL_PAD = "decimal-pad";
    public static final String KEYBOARD_TYPE_EMAIL_ADDRESS = "email-address";
    public static final String KEYBOARD_TYPE_NUMBER_PAD = "number-pad";
    public static final String KEYBOARD_TYPE_NUMERIC = "numeric";
    public static final String KEYBOARD_TYPE_PHONE_PAD = "phone-pad";
    public static final String KEYBOARD_TYPE_VISIBLE_PASSWORD = "visible-password";
    public static final int PASSWORD_VISIBILITY_FLAG = 16;
    public static final String REACT_CLASS = "AndroidTextInput";
    public static final int SET_MOST_RECENT_EVENT_COUNT = 3;
    public static final int SET_TEXT_AND_SELECTION = 4;
    public static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    public static final String TAG = "ReactTextInputManager";
    public static final int UNSET = -1;
    public ReactTextViewManagerCallback mReactTextViewManagerCallback;

    public class ReactContentSizeWatcher implements ContentSizeWatcher {
        public ReactEditText mEditText;
        public EventDispatcher mEventDispatcher;
        public int mPreviousContentHeight = 0;
        public int mPreviousContentWidth = 0;

        public ReactContentSizeWatcher(ReactTextInputManager reactTextInputManager, ReactEditText reactEditText) {
            this.mEditText = reactEditText;
            this.mEventDispatcher = ((UIManagerModule) ReactYogaConfigProvider.getReactContext(reactEditText).getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }
    }

    public class ReactScrollWatcher implements ScrollWatcher {
        public EventDispatcher mEventDispatcher;
        public int mPreviousHoriz;
        public int mPreviousVert;
        public ReactEditText mReactEditText;

        public ReactScrollWatcher(ReactTextInputManager reactTextInputManager, ReactEditText reactEditText) {
            this.mReactEditText = reactEditText;
            this.mEventDispatcher = ReactTextInputManager.getEventDispatcher(ReactYogaConfigProvider.getReactContext(reactEditText), reactEditText);
        }
    }

    public class ReactSelectionWatcher implements SelectionWatcher {
        public EventDispatcher mEventDispatcher;
        public int mPreviousSelectionEnd;
        public int mPreviousSelectionStart;
        public ReactEditText mReactEditText;

        public ReactSelectionWatcher(ReactTextInputManager reactTextInputManager, ReactEditText reactEditText) {
            this.mReactEditText = reactEditText;
            this.mEventDispatcher = ReactTextInputManager.getEventDispatcher(ReactYogaConfigProvider.getReactContext(reactEditText), reactEditText);
        }

        public void onSelectionChanged(int i, int i2) {
            int min = Math.min(i, i2);
            int max = Math.max(i, i2);
            if (this.mPreviousSelectionStart != min || this.mPreviousSelectionEnd != max) {
                this.mEventDispatcher.dispatchEvent(new ReactTextInputSelectionEvent(this.mReactEditText.getId(), min, max));
                this.mPreviousSelectionStart = min;
                this.mPreviousSelectionEnd = max;
            }
        }
    }

    public class ReactTextInputTextWatcher implements TextWatcher {
        public ReactEditText mEditText;
        public EventDispatcher mEventDispatcher;
        public String mPreviousText = null;

        public ReactTextInputTextWatcher(ReactTextInputManager reactTextInputManager, ReactContext reactContext, ReactEditText reactEditText) {
            this.mEventDispatcher = ReactTextInputManager.getEventDispatcher(reactContext, reactEditText);
            this.mEditText = reactEditText;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mPreviousText = charSequence.toString();
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String str;
            String str2;
            int i4;
            String str3;
            int i5 = i;
            int i6 = i2;
            if (!this.mEditText.mDisableTextDiffing) {
                if (i3 != 0 || i6 != 0) {
                    AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mPreviousText);
                    int i7 = i5 + i3;
                    String substring = charSequence.toString().substring(i5, i7);
                    int i8 = i5 + i6;
                    String substring2 = this.mPreviousText.substring(i5, i8);
                    if (i3 != i6 || !substring.equals(substring2)) {
                        JavaOnlyMap javaOnlyMap = this.mEditText.mAttributedString;
                        int i9 = 0;
                        if (javaOnlyMap != null && javaOnlyMap.hasKey("fragments")) {
                            String charSequence2 = charSequence.subSequence(i5, i7).toString();
                            String string = javaOnlyMap.getString(NetworkingModule.REQUEST_BODY_KEY_STRING);
                            StringBuilder sb = new StringBuilder();
                            sb.append(string.substring(0, i5));
                            sb.append(charSequence2);
                            String str4 = "";
                            sb.append(string.length() > i8 ? string.substring(i8) : str4);
                            javaOnlyMap.putString(NetworkingModule.REQUEST_BODY_KEY_STRING, sb.toString());
                            JavaOnlyArray javaOnlyArray = (JavaOnlyArray) javaOnlyMap.getArray("fragments");
                            boolean z = false;
                            int i10 = 0;
                            int i11 = 0;
                            while (i9 < javaOnlyArray.size() && !z) {
                                JavaOnlyMap javaOnlyMap2 = (JavaOnlyMap) javaOnlyArray.getMap(i9);
                                String string2 = javaOnlyMap2.getString(NetworkingModule.REQUEST_BODY_KEY_STRING);
                                int length = string2.length() + i11;
                                if (length < i5) {
                                    i4 = length;
                                    i10 = 0;
                                    str3 = str4;
                                } else {
                                    int i12 = i5 - i11;
                                    int length2 = string2.length() - i12;
                                    i4 = length;
                                    StringBuilder sb2 = new StringBuilder();
                                    str3 = str4;
                                    GeneratedOutlineSupport.outline23(string2, 0, i12, sb2, charSequence2);
                                    sb2.append(string2.substring(Math.min(i6, length2) + i12));
                                    javaOnlyMap2.putString(NetworkingModule.REQUEST_BODY_KEY_STRING, sb2.toString());
                                    if (length2 < i6) {
                                        i5 += length2;
                                        i6 -= length2;
                                        z = false;
                                        i10 = 0;
                                        charSequence2 = str3;
                                    } else {
                                        z = true;
                                        i10 = 0;
                                    }
                                }
                                i9++;
                                i11 = i4;
                                javaOnlyArray = javaOnlyArray;
                                str4 = str3;
                            }
                            i9 = i10;
                        }
                        if (this.mEditText.mStateWrapper == null || javaOnlyMap == null) {
                            str2 = substring;
                            str = substring2;
                        } else {
                            WritableNativeMap writableNativeMap = new WritableNativeMap();
                            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                            WritableNativeArray writableNativeArray = new WritableNativeArray();
                            while (i9 < javaOnlyMap.getArray("fragments").size()) {
                                ReadableMap map = javaOnlyMap.getArray("fragments").getMap(i9);
                                WritableNativeMap writableNativeMap3 = new WritableNativeMap();
                                writableNativeMap3.putDouble("reactTag", (double) map.getInt("reactTag"));
                                writableNativeMap3.putString(NetworkingModule.REQUEST_BODY_KEY_STRING, map.getString(NetworkingModule.REQUEST_BODY_KEY_STRING));
                                writableNativeArray.pushMap(writableNativeMap3);
                                i9++;
                                substring = substring;
                                substring2 = substring2;
                            }
                            str2 = substring;
                            str = substring2;
                            writableNativeMap2.putString(NetworkingModule.REQUEST_BODY_KEY_STRING, javaOnlyMap.getString(NetworkingModule.REQUEST_BODY_KEY_STRING));
                            writableNativeMap2.putArray("fragments", writableNativeArray);
                            ReactEditText reactEditText = this.mEditText;
                            int i13 = reactEditText.mNativeEventCount + 1;
                            reactEditText.mNativeEventCount = i13;
                            writableNativeMap.putInt("mostRecentEventCount", i13);
                            writableNativeMap.putMap("textChanged", writableNativeMap2);
                            this.mEditText.mStateWrapper.updateState(writableNativeMap);
                        }
                        EventDispatcher eventDispatcher = this.mEventDispatcher;
                        int id = this.mEditText.getId();
                        String charSequence3 = charSequence.toString();
                        ReactEditText reactEditText2 = this.mEditText;
                        int i14 = reactEditText2.mNativeEventCount + 1;
                        reactEditText2.mNativeEventCount = i14;
                        eventDispatcher.dispatchEvent(new ReactTextChangedEvent(id, charSequence3, i14));
                        this.mEventDispatcher.dispatchEvent(new ReactTextInputEvent(this.mEditText.getId(), str2, str, i5, i5 + i6));
                    }
                }
            }
        }
    }

    public static void checkPasswordType(ReactEditText reactEditText) {
        if ((reactEditText.getStagedInputType() & INPUT_TYPE_KEYBOARD_NUMBERED) != 0 && (reactEditText.getStagedInputType() & 128) != 0) {
            updateStagedInputTypeFlag(reactEditText, 128, 16);
        }
    }

    public static EventDispatcher getEventDispatcher(ReactContext reactContext, ReactEditText reactEditText) {
        return ReactYogaConfigProvider.getEventDispatcherForReactTag(reactContext, reactEditText.getId());
    }

    private ReactTextUpdate getReactTextUpdate(String str, int i, int i2, int i3) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) TextTransform.apply(str, TextTransform.UNSET));
        return new ReactTextUpdate(spannableStringBuilder, i, false, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 0, 0, 0, i2, i3);
    }

    private void setAutofillHints(ReactEditText reactEditText, String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setAutofillHints(strArr);
        }
    }

    public static void updateStagedInputTypeFlag(ReactEditText reactEditText, int i, int i2) {
        reactEditText.setStagedInputType(((~i) & reactEditText.getStagedInputType()) | i2);
    }

    public EditText createInternalEditText(ThemedReactContext themedReactContext) {
        return new EditText(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return AppCompatDelegateImpl.ConfigurationImplApi17.of("focusTextInput", 1, "blurTextInput", 2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        MapBuilder$Builder builder = AppCompatDelegateImpl.ConfigurationImplApi17.builder();
        builder.put("topSubmitEditing", AppCompatDelegateImpl.ConfigurationImplApi17.of("phasedRegistrationNames", AppCompatDelegateImpl.ConfigurationImplApi17.of("bubbled", "onSubmitEditing", "captured", "onSubmitEditingCapture")));
        builder.put("topEndEditing", AppCompatDelegateImpl.ConfigurationImplApi17.of("phasedRegistrationNames", AppCompatDelegateImpl.ConfigurationImplApi17.of("bubbled", "onEndEditing", "captured", "onEndEditingCapture")));
        builder.put("topTextInput", AppCompatDelegateImpl.ConfigurationImplApi17.of("phasedRegistrationNames", AppCompatDelegateImpl.ConfigurationImplApi17.of("bubbled", "onTextInput", "captured", "onTextInputCapture")));
        builder.put("topFocus", AppCompatDelegateImpl.ConfigurationImplApi17.of("phasedRegistrationNames", AppCompatDelegateImpl.ConfigurationImplApi17.of("bubbled", "onFocus", "captured", "onFocusCapture")));
        builder.put("topBlur", AppCompatDelegateImpl.ConfigurationImplApi17.of("phasedRegistrationNames", AppCompatDelegateImpl.ConfigurationImplApi17.of("bubbled", "onBlur", "captured", "onBlurCapture")));
        builder.put("topKeyPress", AppCompatDelegateImpl.ConfigurationImplApi17.of("phasedRegistrationNames", AppCompatDelegateImpl.ConfigurationImplApi17.of("bubbled", "onKeyPress", "captured", "onKeyPressCapture")));
        return builder.build();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder$Builder builder = AppCompatDelegateImpl.ConfigurationImplApi17.builder();
        builder.put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onScroll"));
        return builder.build();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map getExportedViewConstants() {
        return AppCompatDelegateImpl.ConfigurationImplApi17.of("AutoCapitalizationType", AppCompatDelegateImpl.ConfigurationImplApi17.of("none", 0, "characters", 4096, "words", 8192, "sentences", 16384));
    }

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return ReactTextInputShadowNode.class;
    }

    @ReactProp(defaultBoolean = true, name = "allowFontScaling")
    public void setAllowFontScaling(ReactEditText reactEditText, boolean z) {
        reactEditText.setAllowFontScaling(z);
    }

    @ReactProp(name = "autoCapitalize")
    public void setAutoCapitalize(ReactEditText reactEditText, Dynamic dynamic) {
        int i = 16384;
        if (dynamic.getType() == ReadableType.Number) {
            i = dynamic.asInt();
        } else if (dynamic.getType() == ReadableType.String) {
            String asString = dynamic.asString();
            if (asString.equals("none")) {
                i = 0;
            } else if (asString.equals("characters")) {
                i = 4096;
            } else if (asString.equals("words")) {
                i = 8192;
            } else {
                asString.equals("sentences");
            }
        }
        updateStagedInputTypeFlag(reactEditText, AUTOCAPITALIZE_FLAGS, i);
    }

    @ReactProp(name = "autoCorrect")
    public void setAutoCorrect(ReactEditText reactEditText, Boolean bool) {
        updateStagedInputTypeFlag(reactEditText, 557056, bool != null ? bool.booleanValue() ? 32768 : 524288 : 0);
    }

    @ReactProp(defaultBoolean = false, name = "autoFocus")
    public void setAutoFocus(ReactEditText reactEditText, boolean z) {
        reactEditText.setAutoFocus(z);
    }

    @ReactProp(name = "blurOnSubmit")
    public void setBlurOnSubmit(ReactEditText reactEditText, Boolean bool) {
        reactEditText.setBlurOnSubmit(bool);
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactEditText reactEditText, int i, Integer num) {
        float f = Float.NaN;
        float intValue = num == null ? Float.NaN : (float) (num.intValue() & 16777215);
        if (num != null) {
            f = (float) (num.intValue() >>> 24);
        }
        reactEditText.mReactBackgroundManager.getOrCreateReactViewBackground().setBorderColor(SPACING_TYPES[i], intValue, f);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactEditText reactEditText, int i, float f) {
        if (!ReactYogaConfigProvider.isUndefined(f)) {
            f = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f);
        }
        if (i == 0) {
            reactEditText.setBorderRadius(f);
            return;
        }
        reactEditText.mReactBackgroundManager.getOrCreateReactViewBackground().setRadius(f, i - 1);
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactEditText reactEditText, String str) {
        reactEditText.setBorderStyle(str);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactEditText reactEditText, int i, float f) {
        if (!ReactYogaConfigProvider.isUndefined(f)) {
            f = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f);
        }
        reactEditText.mReactBackgroundManager.getOrCreateReactViewBackground().setBorderWidth(SPACING_TYPES[i], f);
    }

    @ReactProp(defaultBoolean = false, name = "caretHidden")
    public void setCaretHidden(ReactEditText reactEditText, boolean z) {
        reactEditText.setCursorVisible(!z);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ReactEditText reactEditText, Integer num) {
        if (num == null) {
            ColorStateList defaultTextAttribute = ReactYogaConfigProvider.getDefaultTextAttribute(reactEditText.getContext(), 16842904);
            if (defaultTextAttribute != null) {
                reactEditText.setTextColor(defaultTextAttribute);
                return;
            }
            Context context = reactEditText.getContext();
            String str = TAG;
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Could not get default text color from View Context: ");
            outline17.append(context != null ? context.getClass().getCanonicalName() : "null");
            ReactSoftException.logSoftException(str, new IllegalStateException(outline17.toString()));
            return;
        }
        reactEditText.setTextColor(num.intValue());
    }

    @ReactProp(defaultBoolean = false, name = "contextMenuHidden")
    public void setContextMenuHidden(ReactEditText reactEditText, final boolean z) {
        reactEditText.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.facebook.react.views.textinput.ReactTextInputManager.AnonymousClass1 */

            public boolean onLongClick(View view) {
                return z;
            }
        });
    }

    @ReactProp(customType = "Color", name = "cursorColor")
    public void setCursorColor(ReactEditText reactEditText, Integer num) {
        if (num != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                Drawable textCursorDrawable = reactEditText.getTextCursorDrawable();
                if (textCursorDrawable != null) {
                    textCursorDrawable.setColorFilter(new BlendModeColorFilter(num.intValue(), BlendMode.SRC_IN));
                    reactEditText.setTextCursorDrawable(textCursorDrawable);
                }
            } else if (i != 28) {
                try {
                    Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                    declaredField.setAccessible(true);
                    int i2 = declaredField.getInt(reactEditText);
                    if (i2 != 0) {
                        Drawable drawable = ContextCompat.getDrawable(reactEditText.getContext(), i2);
                        drawable.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
                        Drawable[] drawableArr = {drawable, drawable};
                        Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                        declaredField2.setAccessible(true);
                        Object obj = declaredField2.get(reactEditText);
                        Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
                        declaredField3.setAccessible(true);
                        declaredField3.set(obj, drawableArr);
                    }
                } catch (IllegalAccessException | NoSuchFieldException unused) {
                }
            }
        }
    }

    @ReactProp(defaultBoolean = false, name = "disableFullscreenUI")
    public void setDisableFullscreenUI(ReactEditText reactEditText, boolean z) {
        reactEditText.setDisableFullscreenUI(z);
    }

    @ReactProp(defaultBoolean = true, name = "editable")
    public void setEditable(ReactEditText reactEditText, boolean z) {
        reactEditText.setEnabled(z);
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(ReactEditText reactEditText, String str) {
        reactEditText.setFontFamily(str);
    }

    @ReactProp(defaultFloat = 14.0f, name = "fontSize")
    public void setFontSize(ReactEditText reactEditText, float f) {
        reactEditText.setFontSize(f);
    }

    @ReactProp(name = "fontStyle")
    public void setFontStyle(ReactEditText reactEditText, String str) {
        reactEditText.setFontStyle(str);
    }

    @ReactProp(name = "fontWeight")
    public void setFontWeight(ReactEditText reactEditText, String str) {
        reactEditText.setFontWeight(str);
    }

    @ReactProp(name = "importantForAutofill")
    public void setImportantForAutofill(ReactEditText reactEditText, String str) {
        int i;
        if ("no".equals(str)) {
            i = 2;
        } else if ("noExcludeDescendants".equals(str)) {
            i = 8;
        } else if ("yes".equals(str)) {
            i = 1;
        } else {
            i = "yesExcludeDescendants".equals(str) ? 4 : 0;
        }
        setImportantForAutofill(reactEditText, i);
    }

    @ReactProp(defaultBoolean = true, name = "includeFontPadding")
    public void setIncludeFontPadding(ReactEditText reactEditText, boolean z) {
        reactEditText.setIncludeFontPadding(z);
    }

    @ReactProp(name = "inlineImageLeft")
    public void setInlineImageLeft(ReactEditText reactEditText, String str) {
        reactEditText.setCompoundDrawablesWithIntrinsicBounds(ResourceDrawableIdHelper.getInstance().getResourceDrawableId(reactEditText.getContext(), str), 0, 0, 0);
    }

    @ReactProp(name = "inlineImagePadding")
    public void setInlineImagePadding(ReactEditText reactEditText, int i) {
        reactEditText.setCompoundDrawablePadding(i);
    }

    @ReactProp(name = "keyboardType")
    public void setKeyboardType(ReactEditText reactEditText, String str) {
        int i;
        if (KEYBOARD_TYPE_NUMERIC.equalsIgnoreCase(str)) {
            i = INPUT_TYPE_KEYBOARD_NUMBERED;
        } else if (KEYBOARD_TYPE_NUMBER_PAD.equalsIgnoreCase(str)) {
            i = 2;
        } else if (KEYBOARD_TYPE_DECIMAL_PAD.equalsIgnoreCase(str)) {
            i = INPUT_TYPE_KEYBOARD_DECIMAL_PAD;
        } else if (KEYBOARD_TYPE_EMAIL_ADDRESS.equalsIgnoreCase(str)) {
            i = 33;
        } else if (KEYBOARD_TYPE_PHONE_PAD.equalsIgnoreCase(str)) {
            i = 3;
        } else {
            i = KEYBOARD_TYPE_VISIBLE_PASSWORD.equalsIgnoreCase(str) ? 144 : 1;
        }
        updateStagedInputTypeFlag(reactEditText, 15, i);
        checkPasswordType(reactEditText);
    }

    @ReactProp(defaultFloat = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, name = "letterSpacing")
    public void setLetterSpacing(ReactEditText reactEditText, float f) {
        reactEditText.setLetterSpacingPt(f);
    }

    @ReactProp(defaultFloat = Float.NaN, name = "maxFontSizeMultiplier")
    public void setMaxFontSizeMultiplier(ReactEditText reactEditText, float f) {
        reactEditText.setMaxFontSizeMultiplier(f);
    }

    @ReactProp(name = "maxLength")
    public void setMaxLength(ReactEditText reactEditText, Integer num) {
        InputFilter[] filters = reactEditText.getFilters();
        InputFilter[] inputFilterArr = EMPTY_FILTERS;
        if (num == null) {
            if (filters.length > 0) {
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < filters.length; i++) {
                    if (!(filters[i] instanceof InputFilter.LengthFilter)) {
                        linkedList.add(filters[i]);
                    }
                }
                if (!linkedList.isEmpty()) {
                    inputFilterArr = (InputFilter[]) linkedList.toArray(new InputFilter[linkedList.size()]);
                }
            }
        } else if (filters.length > 0) {
            boolean z = false;
            for (int i2 = 0; i2 < filters.length; i2++) {
                if (filters[i2] instanceof InputFilter.LengthFilter) {
                    filters[i2] = new InputFilter.LengthFilter(num.intValue());
                    z = true;
                }
            }
            if (!z) {
                InputFilter[] inputFilterArr2 = new InputFilter[(filters.length + 1)];
                System.arraycopy(filters, 0, inputFilterArr2, 0, filters.length);
                filters[filters.length] = new InputFilter.LengthFilter(num.intValue());
                filters = inputFilterArr2;
            }
            inputFilterArr = filters;
        } else {
            inputFilterArr = new InputFilter[]{new InputFilter.LengthFilter(num.intValue())};
        }
        reactEditText.setFilters(inputFilterArr);
    }

    @ReactProp(defaultBoolean = false, name = "multiline")
    public void setMultiline(ReactEditText reactEditText, boolean z) {
        int i = 0;
        int i2 = z ? 0 : 131072;
        if (z) {
            i = 131072;
        }
        updateStagedInputTypeFlag(reactEditText, i2, i);
    }

    @ReactProp(defaultInt = 1, name = "numberOfLines")
    public void setNumLines(ReactEditText reactEditText, int i) {
        reactEditText.setLines(i);
    }

    @ReactProp(defaultBoolean = false, name = "onContentSizeChange")
    public void setOnContentSizeChange(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setContentSizeWatcher(new ReactContentSizeWatcher(this, reactEditText));
        } else {
            reactEditText.setContentSizeWatcher(null);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onKeyPress")
    public void setOnKeyPress(ReactEditText reactEditText, boolean z) {
        reactEditText.setOnKeyPress(z);
    }

    @ReactProp(defaultBoolean = false, name = "onScroll")
    public void setOnScroll(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setScrollWatcher(new ReactScrollWatcher(this, reactEditText));
        } else {
            reactEditText.setScrollWatcher(null);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onSelectionChange")
    public void setOnSelectionChange(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setSelectionWatcher(new ReactSelectionWatcher(this, reactEditText));
        } else {
            reactEditText.setSelectionWatcher(null);
        }
    }

    @ReactProp(name = "placeholder")
    public void setPlaceholder(ReactEditText reactEditText, String str) {
        reactEditText.setHint(str);
    }

    @ReactProp(customType = "Color", name = "placeholderTextColor")
    public void setPlaceholderTextColor(ReactEditText reactEditText, Integer num) {
        if (num == null) {
            reactEditText.setHintTextColor(ReactYogaConfigProvider.getDefaultTextAttribute(reactEditText.getContext(), 16842906));
        } else {
            reactEditText.setHintTextColor(num.intValue());
        }
    }

    @ReactProp(name = "returnKeyLabel")
    public void setReturnKeyLabel(ReactEditText reactEditText, String str) {
        reactEditText.setImeActionLabel(str, IME_ACTION_ID);
    }

    @ReactProp(name = "returnKeyType")
    public void setReturnKeyType(ReactEditText reactEditText, String str) {
        reactEditText.setReturnKeyType(str);
    }

    @ReactProp(defaultBoolean = false, name = "secureTextEntry")
    public void setSecureTextEntry(ReactEditText reactEditText, boolean z) {
        int i = 0;
        int i2 = z ? 0 : 144;
        if (z) {
            i = 128;
        }
        updateStagedInputTypeFlag(reactEditText, i2, i);
        checkPasswordType(reactEditText);
    }

    @ReactProp(defaultBoolean = false, name = "selectTextOnFocus")
    public void setSelectTextOnFocus(ReactEditText reactEditText, boolean z) {
        reactEditText.setSelectAllOnFocus(z);
    }

    @ReactProp(customType = "Color", name = "selectionColor")
    public void setSelectionColor(ReactEditText reactEditText, Integer num) {
        if (num == null) {
            reactEditText.setHighlightColor(ReactYogaConfigProvider.getDefaultTextAttribute(reactEditText.getContext(), 16842905).getDefaultColor());
        } else {
            reactEditText.setHighlightColor(num.intValue());
        }
        setCursorColor(reactEditText, num);
    }

    @ReactProp(name = "textAlign")
    public void setTextAlign(ReactEditText reactEditText, String str) {
        if ("justify".equals(str)) {
            if (Build.VERSION.SDK_INT >= 26) {
                reactEditText.setJustificationMode(1);
            }
            reactEditText.setGravityHorizontal(3);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setJustificationMode(0);
        }
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityHorizontal(0);
        } else if (RNGestureHandlerModule.KEY_HIT_SLOP_LEFT.equals(str)) {
            reactEditText.setGravityHorizontal(3);
        } else if (RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT.equals(str)) {
            reactEditText.setGravityHorizontal(5);
        } else if ("center".equals(str)) {
            reactEditText.setGravityHorizontal(1);
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline10("Invalid textAlign: ", str));
        }
    }

    @ReactProp(name = "textAlignVertical")
    public void setTextAlignVertical(ReactEditText reactEditText, String str) {
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityVertical(0);
        } else if (RNGestureHandlerModule.KEY_HIT_SLOP_TOP.equals(str)) {
            reactEditText.setGravityVertical(48);
        } else if (RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM.equals(str)) {
            reactEditText.setGravityVertical(80);
        } else if ("center".equals(str)) {
            reactEditText.setGravityVertical(16);
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline10("Invalid textAlignVertical: ", str));
        }
    }

    @ReactProp(name = "autoCompleteType")
    public void setTextContentType(ReactEditText reactEditText, String str) {
        if (str == null) {
            setImportantForAutofill(reactEditText, 2);
        } else if ("username".equals(str)) {
            setAutofillHints(reactEditText, "username");
        } else if ("password".equals(str)) {
            setAutofillHints(reactEditText, "password");
        } else if ("email".equals(str)) {
            setAutofillHints(reactEditText, "emailAddress");
        } else if ("name".equals(str)) {
            setAutofillHints(reactEditText, "name");
        } else if ("tel".equals(str)) {
            setAutofillHints(reactEditText, "phone");
        } else if ("street-address".equals(str)) {
            setAutofillHints(reactEditText, "postalAddress");
        } else if ("postal-code".equals(str)) {
            setAutofillHints(reactEditText, "postalCode");
        } else if ("cc-number".equals(str)) {
            setAutofillHints(reactEditText, "creditCardNumber");
        } else if ("cc-csc".equals(str)) {
            setAutofillHints(reactEditText, "creditCardSecurityCode");
        } else if ("cc-exp".equals(str)) {
            setAutofillHints(reactEditText, "creditCardExpirationDate");
        } else if ("cc-exp-month".equals(str)) {
            setAutofillHints(reactEditText, "creditCardExpirationMonth");
        } else if ("cc-exp-year".equals(str)) {
            setAutofillHints(reactEditText, "creditCardExpirationYear");
        } else if ("off".equals(str)) {
            setImportantForAutofill(reactEditText, 2);
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline10("Invalid autoCompleteType: ", str));
        }
    }

    @ReactProp(customType = "Color", name = "underlineColorAndroid")
    public void setUnderlineColor(ReactEditText reactEditText, Integer num) {
        Drawable background = reactEditText.getBackground();
        if (background.getConstantState() != null) {
            try {
                background = background.mutate();
            } catch (NullPointerException e) {
                FLog.e(TAG, "NullPointerException when setting underlineColorAndroid for TextInput", e);
            }
        }
        if (num == null) {
            background.clearColorFilter();
        } else {
            background.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @ReactProp(defaultBoolean = true, name = "showSoftInputOnFocus")
    public void showKeyboardOnFocus(ReactEditText reactEditText, boolean z) {
        reactEditText.setShowSoftInputOnFocus(z);
    }

    public void addEventEmitters(final ThemedReactContext themedReactContext, final ReactEditText reactEditText) {
        reactEditText.addTextChangedListener(new ReactTextInputTextWatcher(this, themedReactContext, reactEditText));
        reactEditText.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
            /* class com.facebook.react.views.textinput.ReactTextInputManager.AnonymousClass2 */

            public void onFocusChange(View view, boolean z) {
                EventDispatcher eventDispatcher = ReactTextInputManager.getEventDispatcher(themedReactContext, reactEditText);
                if (z) {
                    eventDispatcher.dispatchEvent(new ReactTextInputFocusEvent(reactEditText.getId()));
                    return;
                }
                eventDispatcher.dispatchEvent(new ReactTextInputBlurEvent(reactEditText.getId()));
                eventDispatcher.dispatchEvent(new ReactTextInputEndEditingEvent(reactEditText.getId(), reactEditText.getText().toString()));
            }
        });
        reactEditText.setOnEditorActionListener(new TextView.OnEditorActionListener(this) {
            /* class com.facebook.react.views.textinput.ReactTextInputManager.AnonymousClass3 */

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i & 255) == 0 && i != 0) {
                    return true;
                }
                boolean blurOnSubmit = reactEditText.getBlurOnSubmit();
                boolean isMultiline = reactEditText.isMultiline();
                ReactTextInputManager.getEventDispatcher(themedReactContext, reactEditText).dispatchEvent(new ReactTextInputSubmitEditingEvent(reactEditText.getId(), reactEditText.getText().toString()));
                if (blurOnSubmit) {
                    reactEditText.clearFocus();
                }
                if (blurOnSubmit || !isMultiline || i == 5 || i == 7) {
                    return true;
                }
                return false;
            }
        });
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactBaseTextShadowNode createShadowNodeInstance() {
        return new ReactTextInputShadowNode(null);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactEditText createViewInstance(ThemedReactContext themedReactContext) {
        ReactEditText reactEditText = new ReactEditText(themedReactContext);
        reactEditText.setInputType(reactEditText.getInputType() & -131073);
        reactEditText.setReturnKeyType("done");
        return reactEditText;
    }

    public void onAfterUpdateTransaction(ReactEditText reactEditText) {
        super.onAfterUpdateTransaction((View) reactEditText);
        if (reactEditText.mTypefaceDirty) {
            reactEditText.mTypefaceDirty = false;
            reactEditText.setTypeface(ReactYogaConfigProvider.applyStyles(reactEditText.getTypeface(), reactEditText.mFontStyle, reactEditText.mFontWeight, reactEditText.mFontFamily, reactEditText.getContext().getAssets()));
        }
        if (reactEditText.getInputType() != reactEditText.mStagedInputType) {
            int selectionStart = reactEditText.getSelectionStart();
            int selectionEnd = reactEditText.getSelectionEnd();
            reactEditText.setInputType(reactEditText.mStagedInputType);
            reactEditText.setSelection(selectionStart, selectionEnd);
        }
    }

    public void setPadding(ReactEditText reactEditText, int i, int i2, int i3, int i4) {
        reactEditText.setPadding(i, i2, i3, i4);
    }

    public void updateExtraData(ReactEditText reactEditText, Object obj) {
        if (obj instanceof ReactTextUpdate) {
            ReactTextUpdate reactTextUpdate = (ReactTextUpdate) obj;
            int i = (int) reactTextUpdate.mPaddingLeft;
            int i2 = (int) reactTextUpdate.mPaddingTop;
            int i3 = (int) reactTextUpdate.mPaddingRight;
            int i4 = (int) reactTextUpdate.mPaddingBottom;
            if (!(i == -1 && i2 == -1 && i3 == -1 && i4 == -1)) {
                if (i == -1) {
                    i = reactEditText.getPaddingLeft();
                }
                if (i2 == -1) {
                    i2 = reactEditText.getPaddingTop();
                }
                if (i3 == -1) {
                    i3 = reactEditText.getPaddingRight();
                }
                if (i4 == -1) {
                    i4 = reactEditText.getPaddingBottom();
                }
                reactEditText.setPadding(i, i2, i3, i4);
            }
            if (reactTextUpdate.mContainsImages) {
                TextInlineImageSpan.possiblyUpdateInlineImageSpans(reactTextUpdate.mText, reactEditText);
            }
            reactEditText.maybeSetText(reactTextUpdate);
            reactEditText.maybeSetSelection(reactTextUpdate.mJsEventCounter, reactTextUpdate.mSelectionStart, reactTextUpdate.mSelectionEnd);
        }
    }

    public Object updateState(ReactEditText reactEditText, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        ReadableNativeMap state = stateWrapper.getState();
        if (!state.getBoolean("hasThemeData")) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            ReactContext reactContext = ReactYogaConfigProvider.getReactContext(reactEditText);
            if (reactContext instanceof ThemedReactContext) {
                EditText createInternalEditText = createInternalEditText((ThemedReactContext) reactContext);
                writableNativeMap.putNull("textChanged");
                writableNativeMap.putDouble("themePaddingStart", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) ViewCompat.getPaddingStart(createInternalEditText)));
                writableNativeMap.putDouble("themePaddingEnd", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) createInternalEditText.getPaddingEnd()));
                writableNativeMap.putDouble("themePaddingTop", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) createInternalEditText.getPaddingTop()));
                writableNativeMap.putDouble("themePaddingBottom", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) createInternalEditText.getPaddingBottom()));
                stateWrapper.updateState(writableNativeMap);
            } else {
                String str = TAG;
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("ReactContext is not a ThemedReactContent: ");
                outline17.append(reactContext != null ? reactContext.getClass().getName() : "null");
                ReactSoftException.logSoftException(str, new IllegalStateException(outline17.toString()));
            }
        }
        ReadableNativeMap map = state.getMap("attributedString");
        ReadableNativeMap map2 = state.getMap("paragraphAttributes");
        Spannable orCreateSpannableForText = TextLayoutManager.getOrCreateSpannableForText(reactEditText.getContext(), map, this.mReactTextViewManagerCallback);
        int textBreakStrategy = TextAttributeProps.getTextBreakStrategy(map2.getString("textBreakStrategy"));
        reactEditText.mStateWrapper = stateWrapper;
        ReactTextUpdate reactTextUpdate = new ReactTextUpdate(orCreateSpannableForText, state.getInt("mostRecentEventCount"), false, TextAttributeProps.getTextAlignment(reactStylesDiffMap), textBreakStrategy, TextAttributeProps.getJustificationMode(reactStylesDiffMap));
        reactTextUpdate.mAttributedString = map;
        return reactTextUpdate;
    }

    public void receiveCommand(ReactEditText reactEditText, int i, ReadableArray readableArray) {
        if (i == 1) {
            receiveCommand(reactEditText, "focus", readableArray);
        } else if (i == 2) {
            receiveCommand(reactEditText, "blur", readableArray);
        } else if (i == 4) {
            receiveCommand(reactEditText, "setTextAndSelection", readableArray);
        }
    }

    public ReactBaseTextShadowNode createShadowNodeInstance(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        return new ReactTextInputShadowNode(reactTextViewManagerCallback);
    }

    private void setImportantForAutofill(ReactEditText reactEditText, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setImportantForAutofill(i);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void receiveCommand(ReactEditText reactEditText, String str, ReadableArray readableArray) {
        boolean z;
        int i;
        switch (str.hashCode()) {
            case -1699362314:
                if (str.equals("blurTextInput")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 3027047:
                if (str.equals("blur")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 97604824:
                if (str.equals("focus")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 1427010500:
                if (str.equals("setTextAndSelection")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1690703013:
                if (str.equals("focusTextInput")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (!z || z) {
            reactEditText.requestFocusInternal();
        } else if (z || z) {
            reactEditText.clearFocus();
        } else if (z && (i = readableArray.getInt(0)) != -1) {
            String string = readableArray.getString(1);
            int i2 = readableArray.getInt(2);
            int i3 = readableArray.getInt(3);
            if (i3 == -1) {
                i3 = i2;
            }
            ReactTextUpdate reactTextUpdate = getReactTextUpdate(string, i, i2, i3);
            reactEditText.mIsSettingTextFromJS = true;
            reactEditText.maybeSetText(reactTextUpdate);
            reactEditText.mIsSettingTextFromJS = false;
            reactEditText.maybeSetSelection(i, i2, i3);
        }
    }
}
