package com.facebook.drawee.view;

import android.content.Context;
import com.facebook.drawee.generic.GenericDraweeHierarchy;

public class GenericDraweeView extends DraweeView<GenericDraweeHierarchy> {
    public GenericDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context);
        setHierarchy(genericDraweeHierarchy);
    }
}
