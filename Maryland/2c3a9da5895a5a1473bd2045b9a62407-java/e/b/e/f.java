package e.b.e;

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
import e.b.e.i.i;
import e.b.e.i.j;
import e.b.f.e0;
import e.b.f.y0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class f extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    public static final Class<?>[] f740e;

    /* renamed from: f  reason: collision with root package name */
    public static final Class<?>[] f741f;
    public final Object[] a;
    public final Object[] b;
    public Context c;

    /* renamed from: d  reason: collision with root package name */
    public Object f742d;

    public static class a implements MenuItem.OnMenuItemClickListener {
        public static final Class<?>[] c = {MenuItem.class};
        public Object a;
        public Method b;

        public a(Object obj, String str) {
            this.a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.b = cls.getMethod(str, c);
            } catch (Exception e2) {
                StringBuilder j2 = f.a.a.a.a.j("Couldn't resolve menu item onClick handler ", str, " in class ");
                j2.append(cls.getName());
                InflateException inflateException = new InflateException(j2.toString());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.b.invoke(this.a, menuItem)).booleanValue();
                }
                this.b.invoke(this.a, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public class b {
        public e.i.i.b A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;
        public Menu a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f743d;

        /* renamed from: e  reason: collision with root package name */
        public int f744e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f745f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f746g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f747h;

        /* renamed from: i  reason: collision with root package name */
        public int f748i;

        /* renamed from: j  reason: collision with root package name */
        public int f749j;

        /* renamed from: k  reason: collision with root package name */
        public CharSequence f750k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f751l;
        public int m;
        public char n;
        public int o;
        public char p;
        public int q;
        public int r;
        public boolean s;
        public boolean t;
        public boolean u;
        public int v;
        public int w;
        public String x;
        public String y;
        public String z;

        public b(Menu menu) {
            this.a = menu;
            this.b = 0;
            this.c = 0;
            this.f743d = 0;
            this.f744e = 0;
            this.f745f = true;
            this.f746g = true;
        }

        public SubMenu a() {
            this.f747h = true;
            SubMenu addSubMenu = this.a.addSubMenu(this.b, this.f748i, this.f749j, this.f750k);
            c(addSubMenu.getItem());
            return addSubMenu;
        }

        public final <T> T b(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, f.this.c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        public final void c(MenuItem menuItem) {
            int i2 = Build.VERSION.SDK_INT;
            boolean z2 = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.f751l).setIcon(this.m);
            int i3 = this.v;
            if (i3 >= 0) {
                menuItem.setShowAsAction(i3);
            }
            if (this.z != null) {
                if (!f.this.c.isRestricted()) {
                    f fVar = f.this;
                    if (fVar.f742d == null) {
                        fVar.f742d = fVar.a(fVar.c);
                    }
                    menuItem.setOnMenuItemClickListener(new a(fVar.f742d, this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof i) {
                    i iVar = (i) menuItem;
                    iVar.x = (iVar.x & -5) | 4;
                } else if (menuItem instanceof j) {
                    j jVar = (j) menuItem;
                    try {
                        if (jVar.f810e == null) {
                            jVar.f810e = jVar.f809d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        jVar.f810e.invoke(jVar.f809d, Boolean.TRUE);
                    } catch (Exception e2) {
                        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
                    }
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) b(str, f.f740e, f.this.a));
                z2 = true;
            }
            int i4 = this.w;
            if (i4 > 0) {
                if (!z2) {
                    menuItem.setActionView(i4);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            e.i.i.b bVar = this.A;
            if (bVar != null) {
                if (menuItem instanceof e.i.d.a.b) {
                    ((e.i.d.a.b) menuItem).a(bVar);
                } else {
                    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
            CharSequence charSequence = this.B;
            boolean z3 = menuItem instanceof e.i.d.a.b;
            if (z3) {
                ((e.i.d.a.b) menuItem).setContentDescription(charSequence);
            } else if (i2 >= 26) {
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.C;
            if (z3) {
                ((e.i.d.a.b) menuItem).setTooltipText(charSequence2);
            } else if (i2 >= 26) {
                menuItem.setTooltipText(charSequence2);
            }
            char c2 = this.n;
            int i5 = this.o;
            if (z3) {
                ((e.i.d.a.b) menuItem).setAlphabeticShortcut(c2, i5);
            } else if (i2 >= 26) {
                menuItem.setAlphabeticShortcut(c2, i5);
            }
            char c3 = this.p;
            int i6 = this.q;
            if (z3) {
                ((e.i.d.a.b) menuItem).setNumericShortcut(c3, i6);
            } else if (i2 >= 26) {
                menuItem.setNumericShortcut(c3, i6);
            }
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                if (z3) {
                    ((e.i.d.a.b) menuItem).setIconTintMode(mode);
                } else if (i2 >= 26) {
                    menuItem.setIconTintMode(mode);
                }
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList == null) {
                return;
            }
            if (z3) {
                ((e.i.d.a.b) menuItem).setIconTintList(colorStateList);
            } else if (i2 >= 26) {
                menuItem.setIconTintList(colorStateList);
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f740e = clsArr;
        f741f = clsArr;
    }

    public f(Context context) {
        super(context);
        this.c = context;
        Object[] objArr = {context};
        this.a = objArr;
        this.b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v59, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public final void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        char c2;
        char c3;
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException(f.a.a.a.a.t("Expecting menu, got ", name));
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                            eventType = xmlPullParser.next();
                        } else if (name2.equals("group")) {
                            bVar.b = 0;
                            bVar.c = 0;
                            bVar.f743d = 0;
                            bVar.f744e = 0;
                            bVar.f745f = true;
                            bVar.f746g = true;
                        } else if (name2.equals("item")) {
                            if (!bVar.f747h) {
                                e.i.i.b bVar2 = bVar.A;
                                if (bVar2 == null || !bVar2.a()) {
                                    bVar.f747h = true;
                                    bVar.c(bVar.a.add(bVar.b, bVar.f748i, bVar.f749j, bVar.f750k));
                                } else {
                                    bVar.a();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                            eventType = xmlPullParser.next();
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        TypedArray obtainStyledAttributes = f.this.c.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
                        bVar.b = obtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
                        bVar.c = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
                        bVar.f743d = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
                        bVar.f744e = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
                        bVar.f745f = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
                        bVar.f746g = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
                        obtainStyledAttributes.recycle();
                    } else if (name3.equals("item")) {
                        y0 p = y0.p(f.this.c, attributeSet, R$styleable.MenuItem);
                        bVar.f748i = p.l(R$styleable.MenuItem_android_id, 0);
                        bVar.f749j = (p.j(R$styleable.MenuItem_android_menuCategory, bVar.c) & -65536) | (p.j(R$styleable.MenuItem_android_orderInCategory, bVar.f743d) & 65535);
                        bVar.f750k = p.n(R$styleable.MenuItem_android_title);
                        bVar.f751l = p.n(R$styleable.MenuItem_android_titleCondensed);
                        bVar.m = p.l(R$styleable.MenuItem_android_icon, 0);
                        String m = p.m(R$styleable.MenuItem_android_alphabeticShortcut);
                        if (m == null) {
                            c2 = 0;
                        } else {
                            c2 = m.charAt(0);
                        }
                        bVar.n = c2;
                        bVar.o = p.j(R$styleable.MenuItem_alphabeticModifiers, 4096);
                        String m2 = p.m(R$styleable.MenuItem_android_numericShortcut);
                        if (m2 == null) {
                            c3 = 0;
                        } else {
                            c3 = m2.charAt(0);
                        }
                        bVar.p = c3;
                        bVar.q = p.j(R$styleable.MenuItem_numericModifiers, 4096);
                        int i2 = R$styleable.MenuItem_android_checkable;
                        bVar.r = p.o(i2) ? p.a(i2, false) : bVar.f744e ? 1 : 0;
                        bVar.s = p.a(R$styleable.MenuItem_android_checked, false);
                        bVar.t = p.a(R$styleable.MenuItem_android_visible, bVar.f745f);
                        bVar.u = p.a(R$styleable.MenuItem_android_enabled, bVar.f746g);
                        bVar.v = p.j(R$styleable.MenuItem_showAsAction, -1);
                        bVar.z = p.m(R$styleable.MenuItem_android_onClick);
                        bVar.w = p.l(R$styleable.MenuItem_actionLayout, 0);
                        bVar.x = p.m(R$styleable.MenuItem_actionViewClass);
                        String m3 = p.m(R$styleable.MenuItem_actionProviderClass);
                        bVar.y = m3;
                        boolean z3 = m3 != null;
                        if (z3 && bVar.w == 0 && bVar.x == null) {
                            bVar.A = (e.i.i.b) bVar.b(m3, f741f, f.this.b);
                        } else {
                            if (z3) {
                                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                            }
                            bVar.A = null;
                        }
                        bVar.B = p.n(R$styleable.MenuItem_contentDescription);
                        bVar.C = p.n(R$styleable.MenuItem_tooltipText);
                        int i3 = R$styleable.MenuItem_iconTintMode;
                        if (p.o(i3)) {
                            bVar.E = e0.d(p.j(i3, -1), bVar.E);
                        } else {
                            bVar.E = null;
                        }
                        int i4 = R$styleable.MenuItem_iconTint;
                        if (p.o(i4)) {
                            bVar.D = p.c(i4);
                        } else {
                            bVar.D = null;
                        }
                        p.b.recycle();
                        bVar.f747h = false;
                    } else {
                        if (name3.equals("menu")) {
                            b(xmlPullParser, attributeSet, bVar.a());
                        } else {
                            z2 = true;
                            str = name3;
                        }
                        eventType = xmlPullParser.next();
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    public void inflate(int i2, Menu menu) {
        if (!(menu instanceof e.i.d.a.a)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.c.getResources().getLayout(i2);
            b(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            xmlResourceParser.close();
        } catch (XmlPullParserException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (IOException e3) {
            throw new InflateException("Error inflating menu XML", e3);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
