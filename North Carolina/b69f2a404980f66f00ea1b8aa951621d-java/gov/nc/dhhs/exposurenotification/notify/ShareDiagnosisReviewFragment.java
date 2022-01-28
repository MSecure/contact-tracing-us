package gov.nc.dhhs.exposurenotification.notify;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.fragment.app.Fragment;
import b.b.k.e;
import b.l.d.a;
import b.l.d.d;
import b.l.d.q;
import b.n.y;
import c.b.a.a.c.k.b;
import com.google.android.material.snackbar.Snackbar;
import d.a.a.a.h.a0;
import d.a.a.a.h.b0;
import d.a.a.a.h.c0;
import d.a.a.a.h.d0;
import d.a.a.a.h.v;
import d.a.a.a.h.w;
import d.a.a.a.h.x;
import d.a.a.a.h.z;
import e.c.a.u.c;
import e.c.a.u.k;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisEntity;
import gov.nc.dhhs.exposurenotification.utils.RequestCodes;

public class ShareDiagnosisReviewFragment extends Fragment {
    public static final String TAG = "ShareExposureReviewFrag";
    public static final c dateTimeFormatter = c.b(k.MEDIUM);
    public ProgressDialog prog;
    public ShareDiagnosisViewModel shareDiagnosisViewModel;

    private void cancelAction() {
        requireActivity().finish();
    }

    public static /* synthetic */ void d(String str) {
    }

    public static /* synthetic */ void g(Button button, Boolean bool) {
        button.setEnabled(!bool.booleanValue());
    }

    private e getAlertDialog(final d dVar, String str, String str2) {
        final e a2 = new e.a(dVar).a();
        a2.setTitle(str);
        AlertController alertController = a2.f364d;
        alertController.f = str2;
        TextView textView = alertController.F;
        if (textView != null) {
            textView.setText(str2);
        }
        a2.setCancelable(false);
        a2.e(-2, "OK", new DialogInterface.OnClickListener() {
            /* class gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisReviewFragment.AnonymousClass1 */

            public void onClick(DialogInterface dialogInterface, int i) {
                a2.dismiss();
                dVar.finish();
            }
        });
        return a2;
    }

    /* access modifiers changed from: private */
    /* renamed from: maybeShowSnackbar */
    public void h(String str) {
        View view = getView();
        if (view != null) {
            Snackbar.i(view, str, 0).j();
        }
    }

    private void navigateUp() {
        getParentFragmentManager().Z();
    }

    private void shareAction() {
        this.shareDiagnosisViewModel.share(this.prog);
    }

    private void transitionToFragment(Fragment fragment) {
        getParentFragmentManager().a0(null, 1);
        q parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager != null) {
            a aVar = new a(parentFragmentManager);
            aVar.i(R.id.share_exposure_fragment, fragment, ShareDiagnosisActivity.SHARE_EXPOSURE_FRAGMENT_TAG);
            aVar.f = 4097;
            aVar.d();
            return;
        }
        throw null;
    }

    public /* synthetic */ void e(PositiveDiagnosisEntity positiveDiagnosisEntity) {
        if (positiveDiagnosisEntity != null) {
            this.shareDiagnosisViewModel.onTestTimestampChanged(positiveDiagnosisEntity.getTestTimestamp());
        }
    }

    public /* synthetic */ void f(View view) {
        shareAction();
    }

    public void i(b bVar) {
        try {
            this.shareDiagnosisViewModel.setInflightResolution(true);
            bVar.f2304b.q(requireActivity(), RequestCodes.REQUEST_CODE_GET_TEMP_EXPOSURE_KEY_HISTORY);
        } catch (IntentSender.SendIntentException unused) {
            h(getString(R.string.generic_error_message));
        }
    }

    public /* synthetic */ void j(Boolean bool) {
        String string;
        int i;
        if (!bool.booleanValue()) {
            d requireActivity = requireActivity();
            if ("revision_token".equalsIgnoreCase(ShareDiagnosisViewModel.error_token_flag)) {
                string = getString(R.string.revision_token_alert_title);
                i = R.string.revision_token_alert_message;
            } else if ("generic".equalsIgnoreCase(ShareDiagnosisViewModel.error_token_flag)) {
                string = getString(R.string.generic_key_upload_error_title_text);
                i = R.string.generic_key_upload_error_message_text;
            } else {
                ShareDiagnosisViewModel.error_token_flag = "OK";
            }
            getAlertDialog(requireActivity, string, getString(i)).show();
        }
        this.shareDiagnosisViewModel.save(bool.booleanValue(), this.prog);
    }

    public /* synthetic */ void k(Boolean bool) {
        if (bool.booleanValue()) {
            transitionToFragment(new ShareDiagnosisSharedFragment());
        } else if ("revision_token".equalsIgnoreCase(ShareDiagnosisViewModel.error_token_flag) || "generic".equalsIgnoreCase(ShareDiagnosisViewModel.error_token_flag)) {
            ShareDiagnosisViewModel.error_token_flag = "OK";
        } else {
            cancelAction();
        }
    }

    public /* synthetic */ void l(View view) {
        navigateUp();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 2222) {
            this.shareDiagnosisViewModel.setInflightResolution(false);
            if (i2 == -1) {
                this.shareDiagnosisViewModel.share(this.prog);
            } else {
                this.shareDiagnosisViewModel.save(false, this.prog);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_review, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.shareDiagnosisViewModel = (ShareDiagnosisViewModel) new y(getActivity()).a(ShareDiagnosisViewModel.class);
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        this.prog = progressDialog;
        progressDialog.setMessage(getActivity().getString(R.string.uploading));
        this.prog.setCancelable(false);
        this.prog.setIndeterminate(true);
        this.prog.setProgressStyle(0);
        this.shareDiagnosisViewModel.getTestIdentifierLiveData().observe(getViewLifecycleOwner(), x.f4757a);
        ShareDiagnosisViewModel shareDiagnosisViewModel2 = this.shareDiagnosisViewModel;
        shareDiagnosisViewModel2.getByIdLiveData(shareDiagnosisViewModel2.getExistingIdLiveData().getValue().longValue()).observe(getViewLifecycleOwner(), new a0(this));
        Button button = (Button) view.findViewById(R.id.share_share_button);
        button.setOnClickListener(new d.a.a.a.h.y(this));
        this.shareDiagnosisViewModel.getInFlightResolutionLiveData().observe(getViewLifecycleOwner(), new z(button));
        this.shareDiagnosisViewModel.getSnackbarSingleLiveEvent().observe(getViewLifecycleOwner(), new d0(this));
        this.shareDiagnosisViewModel.getResolutionRequiredLiveEvent().observe(getViewLifecycleOwner(), new b0(this));
        this.shareDiagnosisViewModel.getSharedLiveEvent().observe(getViewLifecycleOwner(), new c0(this));
        this.shareDiagnosisViewModel.getSavedLiveEvent().observe(getViewLifecycleOwner(), new v(this));
        View findViewById = view.findViewById(16908332);
        findViewById.setContentDescription(getString(R.string.back_btn_content_description));
        findViewById.setOnClickListener(new w(this));
    }
}
