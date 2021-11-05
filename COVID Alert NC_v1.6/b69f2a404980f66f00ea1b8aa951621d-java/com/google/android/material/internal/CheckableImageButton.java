package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import b.b.q.l;
import b.i.l.m;

public class CheckableImageButton extends l implements Checkable {
    public static final int[] g = {16842912};

    /* renamed from: d  reason: collision with root package name */
    public boolean f4510d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4511e = true;
    public boolean f = true;

    public static class a extends b.k.a.a {
        public static final Parcelable.Creator<a> CREATOR = new C0112a();

        /* renamed from: d  reason: collision with root package name */
        public boolean f4512d;

        /* renamed from: com.google.android.material.internal.CheckableImageButton$a$a  reason: collision with other inner class name */
        public static class C0112a implements Parcelable.ClassLoaderCreator<a> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new a(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new a[i];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4512d = parcel.readInt() != 1 ? false : true;
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.k.a.a
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1231b, i);
            parcel.writeInt(this.f4512d ? 1 : 0);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, b.b.a.imageButtonStyle);
        m.T(this, new c.b.a.b.c0.a(this));
    }

    public boolean isChecked() {
        return this.f4510d;
    }

    public int[] onCreateDrawableState(int i) {
        return this.f4510d ? ImageButton.mergeDrawableStates(super.onCreateDrawableState(i + g.length), g) : super.onCreateDrawableState(i);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.f1231b);
        setChecked(aVar.f4512d);
    }

    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f4512d = this.f4510d;
        return aVar;
    }

    public void setCheckable(boolean z) {
        if (this.f4511e != z) {
            this.f4511e = z;
            sendAccessibilityEvent(0);
        }
    }

    public void setChecked(boolean z) {
        if (this.f4511e && this.f4510d != z) {
            this.f4510d = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void setPressable(boolean z) {
        this.f = z;
    }

    public void setPressed(boolean z) {
        if (this.f) {
            super.setPressed(z);
        }
    }

    public void toggle() {
        setChecked(!this.f4510d);
    }
}
