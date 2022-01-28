package b.i.l;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import b.i.l.w.b;
import b.i.l.w.c;
import b.i.l.w.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final View.AccessibilityDelegate f1138c = new View.AccessibilityDelegate();

    /* renamed from: a  reason: collision with root package name */
    public final View.AccessibilityDelegate f1139a;

    /* renamed from: b  reason: collision with root package name */
    public final View.AccessibilityDelegate f1140b;

    /* renamed from: b.i.l.a$a  reason: collision with other inner class name */
    public static final class C0025a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        public final a f1141a;

        public C0025a(a aVar) {
            this.f1141a = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f1141a.a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            c b2 = this.f1141a.b(view);
            if (b2 != null) {
                return (AccessibilityNodeProvider) b2.f1205a;
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1141a.c(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            int i;
            b bVar = new b(accessibilityNodeInfo);
            boolean E = m.E(view);
            if (Build.VERSION.SDK_INT >= 28) {
                bVar.f1195a.setScreenReaderFocusable(E);
            } else {
                bVar.h(1, E);
            }
            Boolean bool = (Boolean) new p(b.i.b.tag_accessibility_heading, Boolean.class, 28).d(view);
            boolean booleanValue = bool == null ? false : bool.booleanValue();
            if (Build.VERSION.SDK_INT >= 28) {
                bVar.f1195a.setHeading(booleanValue);
            } else {
                bVar.h(2, booleanValue);
            }
            CharSequence charSequence = (CharSequence) new o(b.i.b.tag_accessibility_pane_title, CharSequence.class, 8, 28).d(view);
            if (Build.VERSION.SDK_INT >= 28) {
                bVar.f1195a.setPaneTitle(charSequence);
            } else {
                bVar.f1195a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
            }
            this.f1141a.d(view, bVar);
            CharSequence text = accessibilityNodeInfo.getText();
            if (Build.VERSION.SDK_INT < 26) {
                bVar.f1195a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
                bVar.f1195a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
                bVar.f1195a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
                bVar.f1195a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
                SparseArray sparseArray = (SparseArray) view.getTag(b.i.b.tag_accessibility_clickable_spans);
                if (sparseArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        if (((WeakReference) sparseArray.valueAt(i2)).get() == null) {
                            arrayList.add(Integer.valueOf(i2));
                        }
                    }
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        sparseArray.remove(((Integer) arrayList.get(i3)).intValue());
                    }
                }
                ClickableSpan[] d2 = b.d(text);
                if (d2 != null && d2.length > 0) {
                    bVar.f().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", b.i.b.accessibility_action_clickable_span);
                    SparseArray sparseArray2 = (SparseArray) view.getTag(b.i.b.tag_accessibility_clickable_spans);
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        view.setTag(b.i.b.tag_accessibility_clickable_spans, sparseArray2);
                    }
                    for (int i4 = 0; i4 < d2.length; i4++) {
                        ClickableSpan clickableSpan = d2[i4];
                        int i5 = 0;
                        while (true) {
                            if (i5 >= sparseArray2.size()) {
                                i = b.f1194d;
                                b.f1194d = i + 1;
                                break;
                            } else if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(i5)).get())) {
                                i = sparseArray2.keyAt(i5);
                                break;
                            } else {
                                i5++;
                            }
                        }
                        sparseArray2.put(i, new WeakReference(d2[i4]));
                        ClickableSpan clickableSpan2 = d2[i4];
                        Spanned spanned = (Spanned) text;
                        bVar.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan2)));
                        bVar.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan2)));
                        bVar.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan2)));
                        bVar.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
                    }
                }
            }
            List list = (List) view.getTag(b.i.b.tag_accessibility_actions);
            if (list == null) {
                list = Collections.emptyList();
            }
            for (int i6 = 0; i6 < list.size(); i6++) {
                bVar.a((b.a) list.get(i6));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1141a.e(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f1141a.f(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f1141a.g(view, i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.f1141a.h(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f1141a.i(view, accessibilityEvent);
        }
    }

    public a() {
        this.f1139a = f1138c;
        this.f1140b = new C0025a(this);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f1139a = accessibilityDelegate;
        this.f1140b = new C0025a(this);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f1139a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public c b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f1139a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new c(accessibilityNodeProvider);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f1139a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, b bVar) {
        this.f1139a.onInitializeAccessibilityNodeInfo(view, bVar.f1195a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.f1139a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f1139a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean g(View view, int i, Bundle bundle) {
        boolean z;
        WeakReference weakReference;
        boolean z2;
        List list = (List) view.getTag(b.i.b.tag_accessibility_actions);
        if (list == null) {
            list = Collections.emptyList();
        }
        boolean z3 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= list.size()) {
                break;
            }
            b.a aVar = (b.a) list.get(i2);
            if (aVar.a() != i) {
                i2++;
            } else if (aVar.f1202d != null) {
                Class<? extends d.a> cls = aVar.f1201c;
                d.a aVar2 = null;
                if (cls != null) {
                    try {
                        d.a aVar3 = (d.a) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        if (aVar3 == null) {
                            try {
                                throw null;
                            } catch (Exception unused) {
                            }
                        }
                        aVar2 = aVar3;
                    } catch (Exception unused2) {
                    }
                }
                z = aVar.f1202d.a(view, aVar2);
            }
        }
        z = false;
        if (!z) {
            z = this.f1139a.performAccessibilityAction(view, i, bundle);
        }
        if (z || i != b.i.b.accessibility_action_clickable_span) {
            return z;
        }
        int i3 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(b.i.b.tag_accessibility_clickable_spans);
        if (!(sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i3)) == null)) {
            ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
            if (clickableSpan != null) {
                ClickableSpan[] d2 = b.d(view.createAccessibilityNodeInfo().getText());
                int i4 = 0;
                while (true) {
                    if (d2 == null || i4 >= d2.length) {
                        break;
                    } else if (clickableSpan.equals(d2[i4])) {
                        z2 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            z2 = false;
            if (z2) {
                clickableSpan.onClick(view);
                z3 = true;
            }
        }
        return z3;
    }

    public void h(View view, int i) {
        this.f1139a.sendAccessibilityEvent(view, i);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.f1139a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
