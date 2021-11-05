package b.l.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import b.l.d.i0;
import b.l.d.z;
import b.o.i;
import b.o.q;

public class l extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static final String SAVED_BACK_STACK_ID = "android:backStackId";
    public static final String SAVED_CANCELABLE = "android:cancelable";
    public static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    public static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    public static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    public static final String SAVED_STYLE = "android:style";
    public static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    public int mBackStackId = -1;
    public boolean mCancelable = true;
    public boolean mCreatingDialog;
    public Dialog mDialog;
    public boolean mDialogCreated = false;
    public Runnable mDismissRunnable = new a();
    public boolean mDismissed;
    public Handler mHandler;
    public q<i> mObserver = new d();
    public DialogInterface.OnCancelListener mOnCancelListener = new b();
    public DialogInterface.OnDismissListener mOnDismissListener = new c();
    public boolean mShownByMe;
    public boolean mShowsDialog = true;
    public int mStyle = 0;
    public int mTheme = 0;
    public boolean mViewDestroyed;

    public class a implements Runnable {
        public a() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            l.this.mOnDismissListener.onDismiss(l.this.mDialog);
        }
    }

    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(DialogInterface dialogInterface) {
            if (l.this.mDialog != null) {
                l lVar = l.this;
                lVar.onCancel(lVar.mDialog);
            }
        }
    }

    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(DialogInterface dialogInterface) {
            if (l.this.mDialog != null) {
                l lVar = l.this;
                lVar.onDismiss(lVar.mDialog);
            }
        }
    }

    public class d implements q<i> {
        public d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.o.q
        @SuppressLint({"SyntheticAccessor"})
        public void a(i iVar) {
            if (iVar != null && l.this.mShowsDialog) {
                View requireView = l.this.requireView();
                if (requireView.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                } else if (l.this.mDialog != null) {
                    if (z.P(3)) {
                        String str = "DialogFragment " + this + " setting the content view on " + l.this.mDialog;
                    }
                    l.this.mDialog.setContentView(requireView);
                }
            }
        }
    }

    public class e extends s {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f2059a;

        public e(s sVar) {
            this.f2059a = sVar;
        }

        @Override // b.l.d.s
        public View b(int i) {
            View onFindViewById = l.this.onFindViewById(i);
            if (onFindViewById != null) {
                return onFindViewById;
            }
            if (this.f2059a.c()) {
                return this.f2059a.b(i);
            }
            return null;
        }

        @Override // b.l.d.s
        public boolean c() {
            return l.this.onHasView() || this.f2059a.c();
        }
    }

    public l() {
    }

    public l(int i) {
        super(i);
    }

    private void dismissInternal(boolean z, boolean z2) {
        if (!this.mDismissed) {
            this.mDismissed = true;
            this.mShownByMe = false;
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                dialog.setOnDismissListener(null);
                this.mDialog.dismiss();
                if (!z2) {
                    if (Looper.myLooper() == this.mHandler.getLooper()) {
                        onDismiss(this.mDialog);
                    } else {
                        this.mHandler.post(this.mDismissRunnable);
                    }
                }
            }
            this.mViewDestroyed = true;
            if (this.mBackStackId >= 0) {
                z parentFragmentManager = getParentFragmentManager();
                int i = this.mBackStackId;
                if (parentFragmentManager == null) {
                    throw null;
                } else if (i >= 0) {
                    parentFragmentManager.B(new z.m(null, i, 1), false);
                    this.mBackStackId = -1;
                } else {
                    throw new IllegalArgumentException(c.a.a.a.a.n("Bad id: ", i));
                }
            } else {
                z parentFragmentManager2 = getParentFragmentManager();
                if (parentFragmentManager2 != null) {
                    a aVar = new a(parentFragmentManager2);
                    z zVar = this.mFragmentManager;
                    if (zVar == null || zVar == aVar.r) {
                        aVar.b(new i0.a(3, this));
                        if (z) {
                            aVar.l(true);
                        } else {
                            aVar.d();
                        }
                    } else {
                        StringBuilder h = c.a.a.a.a.h("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
                        h.append(toString());
                        h.append(" is already attached to a FragmentManager.");
                        throw new IllegalStateException(h.toString());
                    }
                } else {
                    throw null;
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private void prepareDialog(Bundle bundle) {
        if (this.mShowsDialog && !this.mDialogCreated) {
            try {
                this.mCreatingDialog = true;
                Dialog onCreateDialog = onCreateDialog(bundle);
                this.mDialog = onCreateDialog;
                if (this.mShowsDialog) {
                    setupDialog(onCreateDialog, this.mStyle);
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.mDialog.setOwnerActivity((Activity) context);
                    }
                    this.mDialog.setCancelable(this.mCancelable);
                    this.mDialog.setOnCancelListener(this.mOnCancelListener);
                    this.mDialog.setOnDismissListener(this.mOnDismissListener);
                    this.mDialogCreated = true;
                } else {
                    this.mDialog = null;
                }
                this.mCreatingDialog = false;
            } catch (Throwable th) {
                this.mCreatingDialog = false;
                throw th;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public s createFragmentContainer() {
        return new e(super.createFragmentContainer());
    }

    public void dismiss() {
        dismissInternal(false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false);
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().observeForever(this.mObserver);
        if (!this.mShownByMe) {
            this.mDismissed = false;
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new Handler();
        this.mShowsDialog = this.mContainerId == 0;
        if (bundle != null) {
            this.mStyle = bundle.getInt(SAVED_STYLE, 0);
            this.mTheme = bundle.getInt(SAVED_THEME, 0);
            this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
            this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
            this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (z.P(3)) {
            String str = "onCreateDialog called for DialogFragment " + this;
        }
        return new Dialog(requireContext(), getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = null;
            this.mDialogCreated = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
        getViewLifecycleOwnerLiveData().removeObserver(this.mObserver);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.mViewDestroyed) {
            if (z.P(3)) {
                String str = "onDismiss called for DialogFragment " + this;
            }
            dismissInternal(true, true);
        }
    }

    public View onFindViewById(int i) {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (!this.mShowsDialog || this.mCreatingDialog) {
            if (z.P(2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                boolean z = this.mShowsDialog;
            }
            return onGetLayoutInflater;
        }
        prepareDialog(bundle);
        if (z.P(2)) {
            String str2 = "get layout inflater for DialogFragment " + this + " from dialog context";
        }
        Dialog dialog = this.mDialog;
        return dialog != null ? onGetLayoutInflater.cloneInContext(dialog.getContext()) : onGetLayoutInflater;
    }

    public boolean onHasView() {
        return this.mDialogCreated;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
            bundle.putBundle(SAVED_DIALOG_STATE_TAG, onSaveInstanceState);
        }
        int i = this.mStyle;
        if (i != 0) {
            bundle.putInt(SAVED_STYLE, i);
        }
        int i2 = this.mTheme;
        if (i2 != 0) {
            bundle.putInt(SAVED_THEME, i2);
        }
        boolean z = this.mCancelable;
        if (!z) {
            bundle.putBoolean(SAVED_CANCELABLE, z);
        }
        boolean z2 = this.mShowsDialog;
        if (!z2) {
            bundle.putBoolean(SAVED_SHOWS_DIALOG, z2);
        }
        int i3 = this.mBackStackId;
        if (i3 != -1) {
            bundle.putInt(SAVED_BACK_STACK_ID, i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
            View decorView = this.mDialog.getWindow().getDecorView();
            decorView.setTag(b.o.b0.a.view_tree_lifecycle_owner, this);
            decorView.setTag(b.o.c0.a.view_tree_view_model_store_owner, this);
            decorView.setTag(b.t.a.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.mDialog != null && bundle != null && (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) != null) {
            this.mDialog.onRestoreInstanceState(bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView == null && this.mDialog != null && bundle != null && (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) != null) {
            this.mDialog.onRestoreInstanceState(bundle2);
        }
    }

    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean z) {
        this.mCancelable = z;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void setShowsDialog(boolean z) {
        this.mShowsDialog = z;
    }

    public void setStyle(int i, int i2) {
        if (z.P(2)) {
            String str = "Setting style and theme for DialogFragment " + this + " to " + i + ", " + i2;
        }
        this.mStyle = i;
        if (i == 2 || i == 3) {
            this.mTheme = 16973913;
        }
        if (i2 != 0) {
            this.mTheme = i2;
        }
    }

    public void setupDialog(Dialog dialog, int i) {
        if (!(i == 1 || i == 2)) {
            if (i == 3) {
                Window window = dialog.getWindow();
                if (window != null) {
                    window.addFlags(24);
                }
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }

    public int show(i0 i0Var, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        i0Var.g(0, this, str, 1);
        this.mViewDestroyed = false;
        int d2 = i0Var.d();
        this.mBackStackId = d2;
        return d2;
    }

    public void showNow(z zVar, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        if (zVar != null) {
            a aVar = new a(zVar);
            aVar.g(0, this, str, 1);
            aVar.e();
            return;
        }
        throw null;
    }

    public void show(z zVar, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        if (zVar != null) {
            a aVar = new a(zVar);
            aVar.g(0, this, str, 1);
            aVar.d();
            return;
        }
        throw null;
    }
}
