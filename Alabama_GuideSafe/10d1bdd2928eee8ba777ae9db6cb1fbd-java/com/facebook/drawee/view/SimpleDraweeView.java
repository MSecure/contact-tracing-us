package com.facebook.drawee.view;

import android.net.Uri;
import com.facebook.common.internal.Supplier;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequest;

public class SimpleDraweeView extends GenericDraweeView {
    public static void initialize(Supplier<? extends AbstractDraweeControllerBuilder> supplier) {
    }

    public AbstractDraweeControllerBuilder getControllerBuilder() {
        return null;
    }

    public void setActualImageResource(int i) {
        UriUtil.getUriForResourceId(i);
        throw null;
    }

    public void setImageRequest(ImageRequest imageRequest) {
        throw null;
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void setImageResource(int i) {
        super.setImageResource(i);
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void setImageURI(Uri uri) {
        throw null;
    }

    public void setImageURI(String str) {
        if (str != null) {
            Uri.parse(str);
        }
        throw null;
    }
}
