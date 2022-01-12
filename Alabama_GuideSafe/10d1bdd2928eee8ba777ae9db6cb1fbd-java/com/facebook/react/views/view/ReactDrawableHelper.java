package com.facebook.react.views.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.TypedValue;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;

public class ReactDrawableHelper {
    public static final TypedValue sResolveOutValue = new TypedValue();

    @TargetApi(21)
    public static Drawable createDrawableFromJSDescription(Context context, ReadableMap readableMap) {
        int i;
        ColorDrawable colorDrawable;
        String string = readableMap.getString("type");
        if ("ThemeAttrAndroid".equals(string)) {
            String string2 = readableMap.getString("attribute");
            SoftAssertions.assertNotNull(string2);
            int identifier = context.getResources().getIdentifier(string2, ColorPropConverter.ATTR, "android");
            if (identifier == 0) {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline11("Attribute ", string2, " couldn't be found in the resource list"));
            } else if (context.getTheme().resolveAttribute(identifier, sResolveOutValue, true)) {
                Drawable drawable = context.getResources().getDrawable(sResolveOutValue.resourceId, context.getTheme());
                setRadius(readableMap, drawable);
                return drawable;
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline11("Attribute ", string2, " couldn't be resolved into a drawable"));
            }
        } else if ("RippleAndroid".equals(string)) {
            if (readableMap.hasKey("color") && !readableMap.isNull("color")) {
                i = readableMap.getInt("color");
            } else if (context.getTheme().resolveAttribute(16843820, sResolveOutValue, true)) {
                i = context.getResources().getColor(sResolveOutValue.resourceId);
            } else {
                throw new JSApplicationIllegalArgumentException("Attribute colorControlHighlight couldn't be resolved into a drawable");
            }
            if (!readableMap.hasKey("borderless") || readableMap.isNull("borderless") || !readableMap.getBoolean("borderless")) {
                colorDrawable = new ColorDrawable(-1);
            } else {
                colorDrawable = null;
            }
            RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{i}), null, colorDrawable);
            setRadius(readableMap, rippleDrawable);
            return rippleDrawable;
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline10("Invalid type for android drawable: ", string));
        }
    }

    public static Drawable setRadius(ReadableMap readableMap, Drawable drawable) {
        if (readableMap.hasKey("rippleRadius") && (drawable instanceof RippleDrawable)) {
            ((RippleDrawable) drawable).setRadius((int) AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableMap.getDouble("rippleRadius")));
        }
        return drawable;
    }
}
