package b.b.p;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import b.b.p.i.i;
import b.b.p.i.j;
import b.b.q.e0;
import b.b.q.y0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class f extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    public static final Class<?>[] f483e;
    public static final Class<?>[] f;

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f484a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f485b;

    /* renamed from: c  reason: collision with root package name */
    public Context f486c;

    /* renamed from: d  reason: collision with root package name */
    public Object f487d;

    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c  reason: collision with root package name */
        public static final Class<?>[] f488c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        public Object f489a;

        /* renamed from: b  reason: collision with root package name */
        public Method f490b;

        public a(Object obj, String str) {
            this.f489a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f490b = cls.getMethod(str, f488c);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f490b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f490b.invoke(this.f489a, menuItem)).booleanValue();
                }
                this.f490b.invoke(this.f489a, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public class b {
        public b.i.l.b A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        public Menu f491a;

        /* renamed from: b  reason: collision with root package name */
        public int f492b;

        /* renamed from: c  reason: collision with root package name */
        public int f493c;

        /* renamed from: d  reason: collision with root package name */
        public int f494d;

        /* renamed from: e  reason: collision with root package name */
        public int f495e;
        public boolean f;
        public boolean g;
        public boolean h;
        public int i;
        public int j;
        public CharSequence k;
        public CharSequence l;
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
            this.f491a = menu;
            this.f492b = 0;
            this.f493c = 0;
            this.f494d = 0;
            this.f495e = 0;
            this.f = true;
            this.g = true;
        }

        public SubMenu a() {
            this.h = true;
            SubMenu addSubMenu = this.f491a.addSubMenu(this.f492b, this.i, this.j, this.k);
            c(addSubMenu.getItem());
            return addSubMenu;
        }

        public final <T> T b(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, f.this.f486c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception unused) {
                return null;
            }
        }

        public final void c(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (!f.this.f486c.isRestricted()) {
                    f fVar = f.this;
                    if (fVar.f487d == null) {
                        fVar.f487d = fVar.a(fVar.f486c);
                    }
                    menuItem.setOnMenuItemClickListener(new a(fVar.f487d, this.z));
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
                        if (jVar.f555e == null) {
                            jVar.f555e = jVar.f554d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        jVar.f555e.invoke(jVar.f554d, Boolean.TRUE);
                    } catch (Exception unused) {
                    }
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) b(str, f.f483e, f.this.f484a));
                z2 = true;
            }
            int i3 = this.w;
            if (i3 > 0 && !z2) {
                menuItem.setActionView(i3);
            }
            b.i.l.b bVar = this.A;
            if (bVar != null && (menuItem instanceof b.i.g.a.b)) {
                ((b.i.g.a.b) menuItem).a(bVar);
            }
            CharSequence charSequence = this.B;
            boolean z3 = menuItem instanceof b.i.g.a.b;
            if (z3) {
                ((b.i.g.a.b) menuItem).setContentDescription(charSequence);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.C;
            if (z3) {
                ((b.i.g.a.b) menuItem).setTooltipText(charSequence2);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setTooltipText(charSequence2);
            }
            char c2 = this.n;
            int i4 = this.o;
            if (z3) {
                ((b.i.g.a.b) menuItem).setAlphabeticShortcut(c2, i4);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setAlphabeticShortcut(c2, i4);
            }
            char c3 = this.p;
            int i5 = this.q;
            if (z3) {
                ((b.i.g.a.b) menuItem).setNumericShortcut(c3, i5);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setNumericShortcut(c3, i5);
            }
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                if (z3) {
                    ((b.i.g.a.b) menuItem).setIconTintMode(mode);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    menuItem.setIconTintMode(mode);
                }
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList == null) {
                return;
            }
            if (z3) {
                ((b.i.g.a.b) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setIconTintList(colorStateList);
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f483e = clsArr;
        f = clsArr;
    }

    public f(Context context) {
        super(context);
        this.f486c = context;
        Object[] objArr = {context};
        this.f484a = objArr;
        this.f485b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:93:0x024a */
    /* JADX DEBUG: Multi-variable search result rejected for r12v69, resolved type: int */
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
                    throw new RuntimeException(c.a.a.a.a.o("Expecting menu, got ", name));
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
                            bVar.f492b = 0;
                            bVar.f493c = 0;
                            bVar.f494d = 0;
                            bVar.f495e = 0;
                            bVar.f = true;
                            bVar.g = true;
                        } else if (name2.equals("item")) {
                            if (!bVar.h) {
                                b.i.l.b bVar2 = bVar.A;
                                if (bVar2 == null || !((j.a) bVar2).f556b.hasSubMenu()) {
                                    bVar.h = true;
                                    bVar.c(bVar.f491a.add(bVar.f492b, bVar.i, bVar.j, bVar.k));
                                } else {
                                    bVar.a();
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
                        TypedArray obtainStyledAttributes = f.this.f486c.obtainStyledAttributes(attributeSet, b.b.j.MenuGroup);
                        bVar.f492b = obtainStyledAttributes.getResourceId(b.b.j.MenuGroup_android_id, 0);
                        bVar.f493c = obtainStyledAttributes.getInt(b.b.j.MenuGroup_android_menuCategory, 0);
                        bVar.f494d = obtainStyledAttributes.getInt(b.b.j.MenuGroup_android_orderInCategory, 0);
                        bVar.f495e = obtainStyledAttributes.getInt(b.b.j.MenuGroup_android_checkableBehavior, 0);
                        bVar.f = obtainStyledAttributes.getBoolean(b.b.j.MenuGroup_android_visible, true);
                        bVar.g = obtainStyledAttributes.getBoolean(b.b.j.MenuGroup_android_enabled, true);
                        obtainStyledAttributes.recycle();
                    } else if (name3.equals("item")) {
                        y0 p = y0.p(f.this.f486c, attributeSet, b.b.j.MenuItem);
                        bVar.i = p.l(b.b.j.MenuItem_android_id, 0);
                        bVar.j = (p.j(b.b.j.MenuItem_android_menuCategory, bVar.f493c) & -65536) | (p.j(b.b.j.MenuItem_android_orderInCategory, bVar.f494d) & 65535);
                        bVar.k = p.n(b.b.j.MenuItem_android_title);
                        bVar.l = p.n(b.b.j.MenuItem_android_titleCondensed);
                        bVar.m = p.l(b.b.j.MenuItem_android_icon, 0);
                        String m = p.m(b.b.j.MenuItem_android_alphabeticShortcut);
                        if (m == null) {
                            c2 = 0;
                        } else {
                            c2 = m.charAt(0);
                        }
                        bVar.n = c2;
                        bVar.o = p.j(b.b.j.MenuItem_alphabeticModifiers, 4096);
                        String m2 = p.m(b.b.j.MenuItem_android_numericShortcut);
                        if (m2 == null) {
                            c3 = 0;
                        } else {
                            c3 = m2.charAt(0);
                        }
                        bVar.p = c3;
                        bVar.q = p.j(b.b.j.MenuItem_numericModifiers, 4096);
                        bVar.r = p.o(b.b.j.MenuItem_android_checkable) ? p.a(b.b.j.MenuItem_android_checkable, false) : bVar.f495e ? 1 : 0;
                        bVar.s = p.a(b.b.j.MenuItem_android_checked, false);
                        bVar.t = p.a(b.b.j.MenuItem_android_visible, bVar.f);
                        bVar.u = p.a(b.b.j.MenuItem_android_enabled, bVar.g);
                        bVar.v = p.j(b.b.j.MenuItem_showAsAction, -1);
                        bVar.z = p.m(b.b.j.MenuItem_android_onClick);
                        bVar.w = p.l(b.b.j.MenuItem_actionLayout, 0);
                        bVar.x = p.m(b.b.j.MenuItem_actionViewClass);
                        String m3 = p.m(b.b.j.MenuItem_actionProviderClass);
                        bVar.y = m3;
                        if ((m3 != null) && bVar.w == 0 && bVar.x == null) {
                            bVar.A = (b.i.l.b) bVar.b(bVar.y, f, f.this.f485b);
                        } else {
                            bVar.A = null;
                        }
                        bVar.B = p.n(b.b.j.MenuItem_contentDescription);
                        bVar.C = p.n(b.b.j.MenuItem_tooltipText);
                        if (p.o(b.b.j.MenuItem_iconTintMode)) {
                            bVar.E = e0.d(p.j(b.b.j.MenuItem_iconTintMode, -1), bVar.E);
                        } else {
                            bVar.E = null;
                        }
                        if (p.o(b.b.j.MenuItem_iconTint)) {
                            bVar.D = p.c(b.b.j.MenuItem_iconTint);
                        } else {
                            bVar.D = null;
                        }
                        p.f759b.recycle();
                        bVar.h = false;
                    } else {
                        if (name3.equals("menu")) {
                            b(xmlPullParser, attributeSet, bVar.a());
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

    public void inflate(int i, Menu menu) {
        if (!(menu instanceof b.i.g.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f486c.getResources().getLayout(i);
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
