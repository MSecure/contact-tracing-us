package com.mikepenz.aboutlibraries.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import com.mikepenz.aboutlibraries.R$attr;
import com.mikepenz.aboutlibraries.R$color;
import com.mikepenz.aboutlibraries.R$id;
import com.mikepenz.aboutlibraries.R$layout;
import com.mikepenz.aboutlibraries.R$style;
import e.b.a.j;
import f.b.a.c.b.o.b;
import f.d.a.e.a;
import j.k.b.e;

public class LibsActivity extends j {
    @Override // androidx.activity.ComponentActivity, e.n.a.r, e.i.a.g
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        e.b(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null && extras.getBoolean("ABOUT_LIBRARIES_EDGE_TO_EDGE")) {
            Resources resources = getResources();
            e.b(resources, "resources");
            if ((resources.getConfiguration().uiMode & 48) != 32) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 23) {
                    Window window = getWindow();
                    e.b(window, "window");
                    View decorView = window.getDecorView();
                    e.b(decorView, "window.decorView");
                    Window window2 = getWindow();
                    e.b(window2, "window");
                    View decorView2 = window2.getDecorView();
                    e.b(decorView2, "window.decorView");
                    decorView2.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1792);
                    ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this, R$style.Theme_MaterialComponents_Light);
                    Window window3 = getWindow();
                    e.b(window3, "this.window");
                    window3.setStatusBarColor(b.L0(contextThemeWrapper, R$attr.colorSurface));
                    Window window4 = getWindow();
                    e.b(window4, "this.window");
                    window4.setNavigationBarColor(b.L0(contextThemeWrapper, 16842801));
                    if (i2 >= 28) {
                        Window window5 = getWindow();
                        e.b(window5, "this.window");
                        window5.setNavigationBarDividerColor(b.L0(contextThemeWrapper, 16843820));
                    }
                }
                Window window6 = getWindow();
                e.b(window6, "this.window");
                window6.setStatusBarColor(b.J0(this, R$color.immersive_bars));
                Window window7 = getWindow();
                e.b(window7, "this.window");
                int i3 = R$color.nav_bar;
                window7.setNavigationBarColor(b.J0(this, i3));
                if (i2 >= 28) {
                    Window window8 = getWindow();
                    e.b(window8, "this.window");
                    window8.setNavigationBarDividerColor(b.J0(this, i3));
                }
            } else {
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 23) {
                    Window window9 = getWindow();
                    e.b(window9, "window");
                    View decorView3 = window9.getDecorView();
                    e.b(decorView3, "window.decorView");
                    Window window10 = getWindow();
                    e.b(window10, "window");
                    View decorView4 = window10.getDecorView();
                    e.b(decorView4, "window.decorView");
                    decorView4.setSystemUiVisibility(decorView3.getSystemUiVisibility() | 1792);
                    ContextThemeWrapper contextThemeWrapper2 = new ContextThemeWrapper(this, R$style.Theme_MaterialComponents);
                    Window window11 = getWindow();
                    e.b(window11, "this.window");
                    window11.setStatusBarColor(b.L0(contextThemeWrapper2, R$attr.colorSurface));
                    Window window12 = getWindow();
                    e.b(window12, "this.window");
                    window12.setNavigationBarColor(b.L0(contextThemeWrapper2, 16842801));
                    if (i4 >= 28) {
                        Window window13 = getWindow();
                        e.b(window13, "this.window");
                        window13.setNavigationBarDividerColor(b.L0(contextThemeWrapper2, 16843820));
                    }
                }
                Window window14 = getWindow();
                e.b(window14, "this.window");
                window14.setStatusBarColor(b.J0(this, R$color.dark_immersive_bars));
                Window window15 = getWindow();
                e.b(window15, "this.window");
                int i5 = R$color.dark_nav_bar;
                window15.setNavigationBarColor(b.J0(this, i5));
                if (i4 >= 28) {
                    Window window16 = getWindow();
                    e.b(window16, "this.window");
                    window16.setNavigationBarDividerColor(b.J0(this, i5));
                }
            }
        }
        super.onCreate(bundle);
        setContentView(R$layout.activity_opensource);
        String str = "";
        if (extras != null) {
            str = extras.getString("ABOUT_LIBRARIES_TITLE", str);
            e.b(str, "bundle.getString(Libs.BUNDLE_TITLE, \"\")");
        }
        a aVar = new a();
        aVar.y0(extras);
        Toolbar toolbar = (Toolbar) findViewById(R$id.toolbar);
        u().x(toolbar);
        e.b.a.a v = v();
        if (v != null) {
            boolean z = true;
            v.m(true);
            if (str.length() <= 0) {
                z = false;
            }
            v.n(z);
            v.p(str);
        }
        e.b(toolbar, "toolbar");
        b.k0(toolbar, 48, 8388611, 8388613);
        e.n.a.a aVar2 = new e.n.a.a(q());
        aVar2.f(R$id.frame_container, aVar, null);
        aVar2.d();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        e.c(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        finish();
        return true;
    }
}
