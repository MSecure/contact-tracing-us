package com.google.android.material.elevation;

import android.content.Context;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.R$attr;

public class ElevationOverlayProvider {
    public final int colorSurface;
    public final float displayDensity;
    public final int elevationOverlayColor;
    public final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(Context context) {
        this.elevationOverlayEnabled = ReactYogaConfigProvider.resolveBoolean(context, R$attr.elevationOverlayEnabled, false);
        this.elevationOverlayColor = ReactYogaConfigProvider.getColor(context, R$attr.elevationOverlayColor, 0);
        this.colorSurface = ReactYogaConfigProvider.getColor(context, R$attr.colorSurface, 0);
        this.displayDensity = context.getResources().getDisplayMetrics().density;
    }
}
