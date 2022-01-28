package com.bugfender.sdk.a.b.c;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import java.lang.reflect.Field;

public class a {
    public static CompoundButton.OnCheckedChangeListener a(View view) {
        try {
            Field declaredField = Class.forName("android.widget.CompoundButton").getDeclaredField("mOnCheckedChangeListener");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return (CompoundButton.OnCheckedChangeListener) declaredField.get(view);
            }
        } catch (NoSuchFieldException unused) {
            Log.e("Reflection", "No Such Field.");
        } catch (ClassNotFoundException unused2) {
            Log.e("Reflection", "Class Not Found.");
        } catch (IllegalAccessException unused3) {
            Log.e("Reflection", "Illegal Access.");
        }
        return null;
    }

    public static View.OnClickListener b(View view) {
        Object obj;
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                obj = declaredField.get(view);
            } else {
                obj = null;
            }
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            if (declaredField2 == null || obj == null) {
                return null;
            }
            return (View.OnClickListener) declaredField2.get(obj);
        } catch (NoSuchFieldException unused) {
            Log.e("Reflection", "No Such Field.");
            return null;
        } catch (IllegalAccessException unused2) {
            Log.e("Reflection", "Illegal Access.");
            return null;
        } catch (ClassNotFoundException unused3) {
            Log.e("Reflection", "Class Not Found.");
            return null;
        }
    }

    public static AdapterView.OnItemSelectedListener c(View view) {
        try {
            Field declaredField = Class.forName("android.widget.AdapterView").getDeclaredField("mOnItemSelectedListener");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return (AdapterView.OnItemSelectedListener) declaredField.get(view);
            }
        } catch (NoSuchFieldException unused) {
            Log.e("Reflection", "No Such Field.");
        } catch (ClassNotFoundException unused2) {
            Log.e("Reflection", "Class Not Found.");
        } catch (IllegalAccessException unused3) {
            Log.e("Reflection", "Illegal Access.");
        }
        return null;
    }

    public static SeekBar.OnSeekBarChangeListener d(View view) {
        try {
            Field declaredField = Class.forName("android.widget.SeekBar").getDeclaredField("mOnSeekBarChangeListener");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return (SeekBar.OnSeekBarChangeListener) declaredField.get(view);
            }
        } catch (NoSuchFieldException unused) {
            Log.e("Reflection", "No Such Field.");
        } catch (ClassNotFoundException unused2) {
            Log.e("Reflection", "Class Not Found.");
        } catch (IllegalAccessException unused3) {
            Log.e("Reflection", "Illegal Access.");
        }
        return null;
    }
}
