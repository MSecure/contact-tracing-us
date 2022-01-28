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

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f6095g = {16842912};

    /* renamed from: d  reason: collision with root package name */
    public boolean f6096d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6097e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6098f = true;

    public static class a extends b.k.a.a {
        public static final Parcelable.Creator<a> CREATOR = new C0121a();

        /* renamed from: d  reason: collision with root package name */
        public boolean f6099d;

        /* renamed from: com.google.android.material.internal.CheckableImageButton$a$a  reason: collision with other inner class name */
        public static class C0121a implements Parcelable.ClassLoaderCreator<a> {
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
            this.f6099d = parcel.readInt() != 1 ? false : true;
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.k.a.a
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1952b, i);
            parcel.writeInt(this.f6099d ? 1 : 0);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, b.b.a.imageButtonStyle);
        m.U(this, new c.b.a.b.c0.a(this));
    }

    public boolean isChecked() {
        return this.f6096d;
    }

    public int[] onCreateDrawableState(int i) {
        return this.f6096d ? ImageButton.mergeDrawableStates(super.onCreateDrawableState(i + f6095g.length), f6095g) : super.onCreateDrawableState(i);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.f1952b);
        setChecked(aVar.f6099d);
    }

    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f6099d = this.f6096d;
        return aVar;
    }

    public void setCheckable(boolean z) {
        if (this.f6097e != z) {
            this.f6097e = z;
            sendAccessibilityEvent(0);
        }
    }

    public void setChecked(boolean z) {
        if (this.f6097e && this.f6096d != z) {
            this.f6096d = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void setPressable(boolean z) {
        this.f6098f = z;
    }

    public void setPressed(boolean z) {
        if (this.f6098f) {
            super.setPressed(z);
        }
    }

    public void toggle() {
        setChecked(!this.f6096d);
    }
}
