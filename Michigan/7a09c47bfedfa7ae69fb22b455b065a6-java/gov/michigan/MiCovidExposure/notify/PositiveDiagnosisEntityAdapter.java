package gov.michigan.MiCovidExposure.notify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.recyclerview.widget.RecyclerView;
import g.b.a.u.c;
import g.b.a.u.k;
import gov.michigan.MiCovidExposure.R;
import gov.michigan.MiCovidExposure.storage.PositiveDiagnosisEntity;
import java.util.Collections;
import java.util.List;

public class PositiveDiagnosisEntityAdapter extends RecyclerView.e<PositiveDiagnosisViewHolder> {
    public final c dateTimeFormatter = c.b(k.MEDIUM);
    public final OnPositiveDiagnosisClickListener onPositiveDiagnosisClickListener;
    public List<PositiveDiagnosisEntity> positiveDiagnosisEntities = Collections.emptyList();

    public interface OnPositiveDiagnosisClickListener {
        void onClick(PositiveDiagnosisEntity positiveDiagnosisEntity);
    }

    public class PositiveDiagnosisViewHolder extends RecyclerView.a0 {
        public final TextView date;
        public final View itemDivider;
        public final View rootView;
        public final ViewSwitcher shared;

        public PositiveDiagnosisViewHolder(View view) {
            super(view);
            this.rootView = view;
            this.date = (TextView) view.findViewById(R.id.positive_diagnosis_date);
            this.shared = (ViewSwitcher) view.findViewById(R.id.positive_diagnosis_status);
            this.itemDivider = view.findViewById(R.id.horizontal_divider_view);
        }

        public void bind(PositiveDiagnosisEntity positiveDiagnosisEntity, boolean z) {
            View view;
            int i;
            this.date.setText(PositiveDiagnosisEntityAdapter.this.dateTimeFormatter.a(positiveDiagnosisEntity.getTestTimestamp()));
            if (z) {
                view = this.itemDivider;
                i = 8;
            } else {
                view = this.itemDivider;
                i = 0;
            }
            view.setVisibility(i);
            this.shared.setDisplayedChild(!positiveDiagnosisEntity.isShared());
        }
    }

    public PositiveDiagnosisEntityAdapter(OnPositiveDiagnosisClickListener onPositiveDiagnosisClickListener2) {
        this.onPositiveDiagnosisClickListener = onPositiveDiagnosisClickListener2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return this.positiveDiagnosisEntities.size();
    }

    public void onBindViewHolder(PositiveDiagnosisViewHolder positiveDiagnosisViewHolder, int i) {
        PositiveDiagnosisEntity positiveDiagnosisEntity = this.positiveDiagnosisEntities.get(i);
        boolean z = true;
        if (i != getItemCount() - 1) {
            z = false;
        }
        positiveDiagnosisViewHolder.bind(positiveDiagnosisEntity, z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public PositiveDiagnosisViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new PositiveDiagnosisViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_positive_diagnosis_entity, viewGroup, false));
    }

    public void setPositiveDiagnosisEntities(List<PositiveDiagnosisEntity> list) {
        this.positiveDiagnosisEntities = list;
        notifyDataSetChanged();
    }
}
