package gov.michigan.MiCovidExposure.notify;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import b.b.k.e;
import b.l.d.a;
import b.l.d.m;
import b.l.d.z;
import b.o.y;
import c.b.a.a.d.k.b;
import com.google.android.material.snackbar.Snackbar;
import e.a.a.f.a0;
import e.a.a.f.b0;
import e.a.a.f.c0;
import e.a.a.f.d0;
import e.a.a.f.v;
import e.a.a.f.w;
import e.a.a.f.x;
import g.b.a.u.c;
import g.b.a.u.k;
import gov.michigan.MiCovidExposure.R;
import gov.michigan.MiCovidExposure.storage.PositiveDiagnosisEntity;
import gov.michigan.MiCovidExposure.utils.RequestCodes;

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

    private e getAlertDialog(final m mVar, String str, String str2) {
        final e a2 = new e.a(mVar).a();
        a2.setTitle(getString(R.string.revision_key_error_title_text));
        a2.f(getString(R.string.revision_key_error_message_text));
        a2.setCancelable(false);
        a2.e(-2, "OK", new DialogInterface.OnClickListener() {
            /* class gov.michigan.MiCovidExposure.notify.ShareDiagnosisReviewFragment.AnonymousClass1 */

            public void onClick(DialogInterface dialogInterface, int i) {
                a2.dismiss();
                mVar.finish();
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
        getParentFragmentManager().Y();
    }

    private void shareAction() {
        this.shareDiagnosisViewModel.share(this.prog);
    }

    private void transitionToFragment(Fragment fragment) {
        getParentFragmentManager().Z(null, 1);
        z parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager != null) {
            a aVar = new a(parentFragmentManager);
            aVar.h(R.id.share_exposure_fragment, fragment, ShareDiagnosisActivity.SHARE_EXPOSURE_FRAGMENT_TAG);
            aVar.f2040f = 4097;
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
            bVar.f2941b.x(requireActivity(), RequestCodes.REQUEST_CODE_GET_TEMP_EXPOSURE_KEY_HISTORY);
        } catch (IntentSender.SendIntentException unused) {
            h(getString(R.string.generic_error_message));
        }
    }

    public /* synthetic */ void j(Boolean bool) {
        String string;
        int i;
        if (!bool.booleanValue()) {
            m requireActivity = requireActivity();
            if ("revision_token".equalsIgnoreCase(ShareDiagnosisViewModel.error_token_flag)) {
                ShareDiagnosisViewModel.error_token_flag = "OK";
                string = getString(R.string.revision_key_error_title_text);
                i = R.string.revision_key_error_message_text;
            } else {
                boolean equalsIgnoreCase = "generic".equalsIgnoreCase(ShareDiagnosisViewModel.error_token_flag);
                ShareDiagnosisViewModel.error_token_flag = "OK";
                if (equalsIgnoreCase) {
                    string = getString(R.string.generic_key_upload_error_title_text);
                    i = R.string.generic_key_upload_error_message_text;
                }
            }
            getAlertDialog(requireActivity, string, getString(i)).show();
        }
        this.shareDiagnosisViewModel.save(bool.booleanValue(), this.prog);
    }

    public /* synthetic */ void k(Boolean bool) {
        transitionToFragment(bool.booleanValue() ? new ShareDiagnosisSharedFragment() : new NotifyHomeFragment());
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
        this.shareDiagnosisViewModel.getTestIdentifierLiveData().observe(getViewLifecycleOwner(), w.f6369a);
        ShareDiagnosisViewModel shareDiagnosisViewModel2 = this.shareDiagnosisViewModel;
        shareDiagnosisViewModel2.getByIdLiveData(shareDiagnosisViewModel2.getExistingIdLiveData().getValue().longValue()).observe(getViewLifecycleOwner(), new v(this));
        Button button = (Button) view.findViewById(R.id.share_share_button);
        button.setOnClickListener(new d0(this));
        this.shareDiagnosisViewModel.getInFlightResolutionLiveData().observe(getViewLifecycleOwner(), new e.a.a.f.y(button));
        this.shareDiagnosisViewModel.getSnackbarSingleLiveEvent().observe(getViewLifecycleOwner(), new e.a.a.f.z(this));
        this.shareDiagnosisViewModel.getResolutionRequiredLiveEvent().observe(getViewLifecycleOwner(), new a0(this));
        this.shareDiagnosisViewModel.getSharedLiveEvent().observe(getViewLifecycleOwner(), new x(this));
        this.shareDiagnosisViewModel.getSavedLiveEvent().observe(getViewLifecycleOwner(), new c0(this));
        View findViewById = view.findViewById(16908332);
        findViewById.setContentDescription(getString(R.string.navigate_up));
        findViewById.setOnClickListener(new b0(this));
    }
}
