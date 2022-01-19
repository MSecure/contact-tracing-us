package com.facebook.react.views.text.frescosupport;

import android.net.Uri;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.ReactTextInlineImageShadowNode;
import java.util.Locale;

public class FrescoBasedReactTextInlineImageShadowNode extends ReactTextInlineImageShadowNode {
    public final Object mCallerContext;
    public final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    public ReadableMap mHeaders;
    public float mHeight = Float.NaN;
    public String mResizeMode;
    public int mTintColor = 0;
    public Uri mUri;
    public float mWidth = Float.NaN;

    public FrescoBasedReactTextInlineImageShadowNode(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Object obj) {
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mCallerContext = obj;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public boolean isVirtual() {
        return true;
    }

    @ReactProp(name = "headers")
    public void setHeaders(ReadableMap readableMap) {
        this.mHeaders = readableMap;
    }

    @Override // com.facebook.react.uimanager.LayoutShadowNode
    public void setHeight(Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Number) {
            this.mHeight = (float) dynamic.asDouble();
            return;
        }
        throw new JSApplicationIllegalArgumentException("Inline images must not have percentage based height");
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(String str) {
        this.mResizeMode = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r1.getScheme() == null) goto L_0x0023;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
    @ReactProp(name = "src")
    public void setSource(ReadableArray readableArray) {
        Uri uri;
        Uri uri2 = null;
        String string = (readableArray == null || readableArray.size() == 0) ? null : readableArray.getMap(0).getString(NetworkingModule.REQUEST_BODY_KEY_URI);
        if (string != null) {
            try {
                uri = Uri.parse(string);
            } catch (Exception unused) {
            }
        }
        if (uri2 != this.mUri) {
            markUpdated();
        }
        this.mUri = uri2;
        uri = null;
        if (uri != null) {
            ThemedReactContext themedContext = getThemedContext();
            if (!string.isEmpty()) {
                uri2 = new Uri.Builder().scheme("res").path(String.valueOf(themedContext.getResources().getIdentifier(string.toLowerCase(Locale.getDefault()).replace("-", "_"), "drawable", themedContext.getPackageName()))).build();
            }
        } else {
            uri2 = uri;
        }
        if (uri2 != this.mUri) {
        }
        this.mUri = uri2;
        if (uri != null) {
        }
        if (uri2 != this.mUri) {
        }
        this.mUri = uri2;
    }

    @ReactProp(name = "tintColor")
    public void setTintColor(int i) {
        this.mTintColor = i;
    }

    @Override // com.facebook.react.uimanager.LayoutShadowNode
    public void setWidth(Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Number) {
            this.mWidth = (float) dynamic.asDouble();
            return;
        }
        throw new JSApplicationIllegalArgumentException("Inline images must not have percentage based width");
    }
}
