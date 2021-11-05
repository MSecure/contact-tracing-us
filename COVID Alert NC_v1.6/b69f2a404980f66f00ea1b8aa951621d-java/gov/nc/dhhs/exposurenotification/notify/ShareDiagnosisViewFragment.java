package gov.nc.dhhs.exposurenotification.notify;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.fragment.app.Fragment;
import b.l.d.a;
import b.l.d.q;
import b.n.y;
import c.b.a.b.y.b;
import d.a.a.a.h.f0;
import d.a.a.a.h.g0;
import d.a.a.a.h.h0;
import d.a.a.a.h.i0;
import d.a.a.a.h.j0;
import d.a.a.a.h.k0;
import d.a.a.a.h.l0;
import d.a.a.a.h.m0;
import d.a.a.a.h.n0;
import e.c.a.u.c;
import e.c.a.u.k;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisEntity;

public class ShareDiagnosisViewFragment extends Fragment {
    public static final String KEY_POSITIVE_DIAGNOSIS_ID = "PositiveDiagnosisViewFragment.KEY_POSITIVE_DIAGNOSIS_ID";
    public static final String STATE_DELETE_OPEN = "DebugFragment.STATE_DELETE_OPEN";
    public static final String TAG = "ShareDiagnosisViewFrag";
    public final c dateTimeFormatter = c.b(k.MEDIUM);
    public boolean deleteOpen = false;
    public ShareDiagnosisViewModel shareDiagnosisViewModel;

    private void deleteAction(PositiveDiagnosisEntity positiveDiagnosisEntity) {
        this.deleteOpen = true;
        b bVar = new b(requireContext());
        AlertController.b bVar2 = bVar.f365a;
        bVar2.f = bVar2.f27a.getText(R.string.dialog_delete_positive_test_title);
        AlertController.b bVar3 = bVar.f365a;
        bVar3.h = bVar3.f27a.getText(R.string.dialog_delete_positive_test_description);
        f0 f0Var = new f0(this, positiveDiagnosisEntity);
        AlertController.b bVar4 = bVar.f365a;
        bVar4.i = bVar4.f27a.getText(R.string.dialog_delete_positive_test_action);
        bVar.f365a.j = f0Var;
        n0 n0Var = new n0(this);
        AlertController.b bVar5 = bVar.f365a;
        bVar5.k = bVar5.f27a.getText(17039360);
        bVar.f365a.l = n0Var;
        bVar.f365a.o = new m0(this);
        bVar.f365a.n = new k0(this);
        bVar.a().show();
    }

    private void navigateUp() {
        requireActivity().finish();
    }

    public static ShareDiagnosisViewFragment newInstance(long j) {
        ShareDiagnosisViewFragment shareDiagnosisViewFragment = new ShareDiagnosisViewFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(KEY_POSITIVE_DIAGNOSIS_ID, j);
        shareDiagnosisViewFragment.setArguments(bundle);
        return shareDiagnosisViewFragment;
    }

    private void shareAction() {
        q parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager != null) {
            a aVar = new a(parentFragmentManager);
            aVar.i(R.id.share_exposure_fragment, new ShareDiagnosisReviewFragment(), ShareDiagnosisActivity.SHARE_EXPOSURE_FRAGMENT_TAG);
            aVar.c(null);
            aVar.f = 4097;
            aVar.d();
            return;
        }
        throw null;
    }

    public /* synthetic */ void d(PositiveDiagnosisEntity positiveDiagnosisEntity, DialogInterface dialogInterface, int i) {
        this.deleteOpen = false;
        this.shareDiagnosisViewModel.deleteEntity(positiveDiagnosisEntity);
    }

    public /* synthetic */ void e(DialogInterface dialogInterface, int i) {
        this.deleteOpen = false;
    }

    public /* synthetic */ void f(DialogInterface dialogInterface) {
        this.deleteOpen = false;
    }

    public /* synthetic */ void g(DialogInterface dialogInterface) {
        this.deleteOpen = false;
    }

    public /* synthetic */ void h(PositiveDiagnosisEntity positiveDiagnosisEntity, View view) {
        deleteAction(positiveDiagnosisEntity);
    }

    public /* synthetic */ void i(View view) {
        shareAction();
    }

    public /* synthetic */ void j(Button button, TextView textView, Button button2, TextView textView2, PositiveDiagnosisEntity positiveDiagnosisEntity) {
        if (positiveDiagnosisEntity != null) {
            if (positiveDiagnosisEntity.isShared()) {
                button.setEnabled(false);
                button.setText(R.string.btn_share_already_shared);
                textView.setText(R.string.positive_test_shared_title);
                button2.setVisibility(8);
            } else {
                button.setEnabled(true);
                button2.setVisibility(0);
                button.setText(R.string.btn_share_positive);
                textView.setText(R.string.positive_test_not_shared_title);
            }
            textView2.setText(this.dateTimeFormatter.a(positiveDiagnosisEntity.getTestTimestamp()));
            button2.setOnClickListener(new i0(this, positiveDiagnosisEntity));
            if (this.deleteOpen) {
                deleteAction(positiveDiagnosisEntity);
            }
        }
    }

    public /* synthetic */ void k(Void r1) {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public /* synthetic */ void l(View view) {
        navigateUp();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_view, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(STATE_DELETE_OPEN, this.deleteOpen);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (bundle != null) {
            this.deleteOpen = bundle.getBoolean(STATE_DELETE_OPEN, false);
        }
        ShareDiagnosisViewModel shareDiagnosisViewModel2 = (ShareDiagnosisViewModel) new y(getActivity()).a(ShareDiagnosisViewModel.class);
        this.shareDiagnosisViewModel = shareDiagnosisViewModel2;
        shareDiagnosisViewModel2.setExistingId(getArguments().getLong(KEY_POSITIVE_DIAGNOSIS_ID, -1));
        TextView textView = (TextView) view.findViewById(R.id.test_date);
        TextView textView2 = (TextView) view.findViewById(R.id.share_exposure_view_title);
        Button button = (Button) view.findViewById(R.id.positive_diagnosis_share_button);
        button.setOnClickListener(new g0(this));
        Button button2 = (Button) view.findViewById(R.id.positive_diagnosis_delete_button);
        ShareDiagnosisViewModel shareDiagnosisViewModel3 = this.shareDiagnosisViewModel;
        shareDiagnosisViewModel3.getByIdLiveData(shareDiagnosisViewModel3.getExistingIdLiveData().getValue().longValue()).observe(getViewLifecycleOwner(), new j0(this, button, textView2, button2, textView));
        this.shareDiagnosisViewModel.getDeletedSingleLiveEvent().observe(getViewLifecycleOwner(), new h0(this));
        View findViewById = view.findViewById(16908332);
        findViewById.setContentDescription(getString(R.string.back_btn_content_description));
        findViewById.setOnClickListener(new l0(this));
    }
}
