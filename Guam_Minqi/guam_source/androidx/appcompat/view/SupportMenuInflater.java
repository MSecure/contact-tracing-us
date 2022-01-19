package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import okhttp3.internal.http2.Settings;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SupportMenuInflater extends MenuInflater {
    public static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
    public static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    public final Object[] mActionProviderConstructorArguments;
    public final Object[] mActionViewConstructorArguments;
    public Context mContext;
    public Object mRealOwner;

    public static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        public static final Class<?>[] PARAM_TYPES = {MenuItem.class};
        public Method mMethod;
        public Object mRealOwner;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.mRealOwner = obj;
            Class<?> cls = obj.getClass();
            try {
                this.mMethod = cls.getMethod(str, PARAM_TYPES);
            } catch (Exception e) {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Couldn't resolve menu item onClick handler ", str, " in class ");
                outline17.append(cls.getName());
                InflateException inflateException = new InflateException(outline17.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.mMethod.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.mMethod.invoke(this.mRealOwner, menuItem)).booleanValue();
                }
                this.mMethod.invoke(this.mRealOwner, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public class MenuState {
        public int groupCategory;
        public int groupCheckable;
        public boolean groupEnabled;
        public int groupId;
        public int groupOrder;
        public boolean groupVisible;
        public ActionProvider itemActionProvider;
        public String itemActionProviderClassName;
        public String itemActionViewClassName;
        public int itemActionViewLayout;
        public boolean itemAdded;
        public int itemAlphabeticModifiers;
        public char itemAlphabeticShortcut;
        public int itemCategoryOrder;
        public int itemCheckable;
        public boolean itemChecked;
        public CharSequence itemContentDescription;
        public boolean itemEnabled;
        public int itemIconResId;
        public ColorStateList itemIconTintList = null;
        public PorterDuff.Mode itemIconTintMode = null;
        public int itemId;
        public String itemListenerMethodName;
        public int itemNumericModifiers;
        public char itemNumericShortcut;
        public int itemShowAsAction;
        public CharSequence itemTitle;
        public CharSequence itemTitleCondensed;
        public CharSequence itemTooltipText;
        public boolean itemVisible;
        public Menu menu;

        public MenuState(Menu menu2) {
            this.menu = menu2;
            this.groupId = 0;
            this.groupCategory = 0;
            this.groupOrder = 0;
            this.groupCheckable = 0;
            this.groupVisible = true;
            this.groupEnabled = true;
        }

        public SubMenu addSubMenuItem() {
            this.itemAdded = true;
            SubMenu addSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            setItem(addSubMenu.getItem());
            return addSubMenu;
        }

        public final <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.mContext.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        public final void setItem(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled).setCheckable(this.itemCheckable >= 1).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
            int i = this.itemShowAsAction;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.itemListenerMethodName != null) {
                if (!SupportMenuInflater.this.mContext.isRestricted()) {
                    SupportMenuInflater supportMenuInflater = SupportMenuInflater.this;
                    if (supportMenuInflater.mRealOwner == null) {
                        supportMenuInflater.mRealOwner = supportMenuInflater.findRealOwner(supportMenuInflater.mContext);
                    }
                    menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(supportMenuInflater.mRealOwner, this.itemListenerMethodName));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.itemCheckable >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
                    menuItemImpl.mFlags = (menuItemImpl.mFlags & -5) | 4;
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    MenuItemWrapperICS menuItemWrapperICS = (MenuItemWrapperICS) menuItem;
                    try {
                        if (menuItemWrapperICS.mSetExclusiveCheckableMethod == null) {
                            menuItemWrapperICS.mSetExclusiveCheckableMethod = menuItemWrapperICS.mWrappedObject.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        menuItemWrapperICS.mSetExclusiveCheckableMethod.invoke(menuItemWrapperICS.mWrappedObject, Boolean.TRUE);
                    } catch (Exception e) {
                        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
                    }
                }
            }
            String str = this.itemActionViewClassName;
            if (str != null) {
                menuItem.setActionView((View) newInstance(str, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionViewConstructorArguments));
                z = true;
            }
            int i2 = this.itemActionViewLayout;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            ActionProvider actionProvider = this.itemActionProvider;
            if (actionProvider != null) {
                if (menuItem instanceof SupportMenuItem) {
                    ((SupportMenuItem) menuItem).setSupportActionProvider(actionProvider);
                } else {
                    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
            CharSequence charSequence = this.itemContentDescription;
            boolean z2 = menuItem instanceof SupportMenuItem;
            if (z2) {
                ((SupportMenuItem) menuItem).setContentDescription(charSequence);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.itemTooltipText;
            if (z2) {
                ((SupportMenuItem) menuItem).setTooltipText(charSequence2);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setTooltipText(charSequence2);
            }
            char c = this.itemAlphabeticShortcut;
            int i3 = this.itemAlphabeticModifiers;
            if (z2) {
                ((SupportMenuItem) menuItem).setAlphabeticShortcut(c, i3);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setAlphabeticShortcut(c, i3);
            }
            char c2 = this.itemNumericShortcut;
            int i4 = this.itemNumericModifiers;
            if (z2) {
                ((SupportMenuItem) menuItem).setNumericShortcut(c2, i4);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setNumericShortcut(c2, i4);
            }
            PorterDuff.Mode mode = this.itemIconTintMode;
            if (mode != null) {
                if (z2) {
                    ((SupportMenuItem) menuItem).setIconTintMode(mode);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    menuItem.setIconTintMode(mode);
                }
            }
            ColorStateList colorStateList = this.itemIconTintList;
            if (colorStateList == null) {
                return;
            }
            if (z2) {
                ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setIconTintList(colorStateList);
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = clsArr;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.mContext = context;
        Object[] objArr = {context};
        this.mActionViewConstructorArguments = objArr;
        this.mActionProviderConstructorArguments = objArr;
    }

    public final Object findRealOwner(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? findRealOwner(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public void inflate(int i, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.mContext.getResources().getLayout(i);
            parseMenu(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            xmlResourceParser.close();
        } catch (XmlPullParserException e) {
            throw new InflateException("Error inflating menu XML", e);
        } catch (IOException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:95:0x0255 */
    public final void parseMenu(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        char c;
        char c2;
        MenuState menuState = new MenuState(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException(GeneratedOutlineSupport.outline8("Expecting menu, got ", name));
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                            eventType = xmlPullParser.next();
                            z = z;
                            z2 = z2;
                        } else if (name2.equals("group")) {
                            menuState.groupId = 0;
                            menuState.groupCategory = 0;
                            menuState.groupOrder = 0;
                            menuState.groupCheckable = 0;
                            menuState.groupVisible = true;
                            menuState.groupEnabled = true;
                        } else if (name2.equals("item")) {
                            if (!menuState.itemAdded) {
                                ActionProvider actionProvider = menuState.itemActionProvider;
                                if (actionProvider == null || !((MenuItemWrapperICS.ActionProviderWrapper) actionProvider).mInner.hasSubMenu()) {
                                    menuState.itemAdded = true;
                                    menuState.setItem(menuState.menu.add(menuState.groupId, menuState.itemId, menuState.itemCategoryOrder, menuState.itemTitle));
                                } else {
                                    menuState.addSubMenuItem();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                            eventType = xmlPullParser.next();
                            z = z;
                            z2 = z2;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        TypedArray obtainStyledAttributes = SupportMenuInflater.this.mContext.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
                        menuState.groupId = obtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
                        menuState.groupCategory = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
                        menuState.groupOrder = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
                        menuState.groupCheckable = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
                        menuState.groupVisible = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
                        menuState.groupEnabled = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
                        obtainStyledAttributes.recycle();
                    } else if (name3.equals("item")) {
                        TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(SupportMenuInflater.this.mContext, attributeSet, R$styleable.MenuItem);
                        menuState.itemId = obtainStyledAttributes2.getResourceId(R$styleable.MenuItem_android_id, 0);
                        menuState.itemCategoryOrder = (obtainStyledAttributes2.getInt(R$styleable.MenuItem_android_menuCategory, menuState.groupCategory) & -65536) | (obtainStyledAttributes2.getInt(R$styleable.MenuItem_android_orderInCategory, menuState.groupOrder) & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                        menuState.itemTitle = obtainStyledAttributes2.getText(R$styleable.MenuItem_android_title);
                        menuState.itemTitleCondensed = obtainStyledAttributes2.getText(R$styleable.MenuItem_android_titleCondensed);
                        menuState.itemIconResId = obtainStyledAttributes2.getResourceId(R$styleable.MenuItem_android_icon, 0);
                        String string = obtainStyledAttributes2.getString(R$styleable.MenuItem_android_alphabeticShortcut);
                        if (string == null) {
                            c = 0;
                        } else {
                            c = string.charAt(0);
                        }
                        menuState.itemAlphabeticShortcut = c;
                        menuState.itemAlphabeticModifiers = obtainStyledAttributes2.getInt(R$styleable.MenuItem_alphabeticModifiers, 4096);
                        String string2 = obtainStyledAttributes2.getString(R$styleable.MenuItem_android_numericShortcut);
                        if (string2 == null) {
                            c2 = 0;
                        } else {
                            c2 = string2.charAt(0);
                        }
                        menuState.itemNumericShortcut = c2;
                        menuState.itemNumericModifiers = obtainStyledAttributes2.getInt(R$styleable.MenuItem_numericModifiers, 4096);
                        if (obtainStyledAttributes2.hasValue(R$styleable.MenuItem_android_checkable)) {
                            menuState.itemCheckable = obtainStyledAttributes2.getBoolean(R$styleable.MenuItem_android_checkable, false) ? 1 : 0;
                        } else {
                            menuState.itemCheckable = menuState.groupCheckable;
                        }
                        menuState.itemChecked = obtainStyledAttributes2.getBoolean(R$styleable.MenuItem_android_checked, false);
                        menuState.itemVisible = obtainStyledAttributes2.getBoolean(R$styleable.MenuItem_android_visible, menuState.groupVisible);
                        menuState.itemEnabled = obtainStyledAttributes2.getBoolean(R$styleable.MenuItem_android_enabled, menuState.groupEnabled);
                        menuState.itemShowAsAction = obtainStyledAttributes2.getInt(R$styleable.MenuItem_showAsAction, -1);
                        menuState.itemListenerMethodName = obtainStyledAttributes2.getString(R$styleable.MenuItem_android_onClick);
                        menuState.itemActionViewLayout = obtainStyledAttributes2.getResourceId(R$styleable.MenuItem_actionLayout, 0);
                        menuState.itemActionViewClassName = obtainStyledAttributes2.getString(R$styleable.MenuItem_actionViewClass);
                        String string3 = obtainStyledAttributes2.getString(R$styleable.MenuItem_actionProviderClass);
                        menuState.itemActionProviderClassName = string3;
                        boolean z3 = string3 != null;
                        if (z3 && menuState.itemActionViewLayout == 0 && menuState.itemActionViewClassName == null) {
                            menuState.itemActionProvider = (ActionProvider) menuState.newInstance(menuState.itemActionProviderClassName, ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionProviderConstructorArguments);
                        } else {
                            if (z3) {
                                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                            }
                            menuState.itemActionProvider = null;
                        }
                        menuState.itemContentDescription = obtainStyledAttributes2.getText(R$styleable.MenuItem_contentDescription);
                        menuState.itemTooltipText = obtainStyledAttributes2.getText(R$styleable.MenuItem_tooltipText);
                        if (obtainStyledAttributes2.hasValue(R$styleable.MenuItem_iconTintMode)) {
                            menuState.itemIconTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes2.getInt(R$styleable.MenuItem_iconTintMode, -1), menuState.itemIconTintMode);
                        } else {
                            menuState.itemIconTintMode = null;
                        }
                        if (obtainStyledAttributes2.hasValue(R$styleable.MenuItem_iconTint)) {
                            menuState.itemIconTintList = obtainStyledAttributes2.getColorStateList(R$styleable.MenuItem_iconTint);
                        } else {
                            menuState.itemIconTintList = null;
                        }
                        obtainStyledAttributes2.mWrapped.recycle();
                        menuState.itemAdded = false;
                    } else {
                        if (name3.equals("menu")) {
                            parseMenu(xmlPullParser, attributeSet, menuState.addSubMenuItem());
                        } else {
                            str = name3;
                            z2 = true;
                        }
                        eventType = xmlPullParser.next();
                        z = z;
                        z2 = z2;
                    }
                }
                eventType = xmlPullParser.next();
                z = z;
                z2 = z2;
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }
}
