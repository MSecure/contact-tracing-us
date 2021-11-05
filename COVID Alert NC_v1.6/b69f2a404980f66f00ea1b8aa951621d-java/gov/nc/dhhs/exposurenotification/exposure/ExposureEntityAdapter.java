package gov.nc.dhhs.exposurenotification.exposure;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.q.d.p;
import b.q.d.v;
import d.a.a.a.d.c;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.common.StringUtils;
import gov.nc.dhhs.exposurenotification.storage.ExposureEntity;

public class ExposureEntityAdapter extends v<ExposureEntity, ViewHolder> {
    public final OnExposureClickListener onExposureClickListener;

    public static class ExposureItemCallback extends p.d<ExposureEntity> {
        public ExposureItemCallback() {
        }

        public boolean areContentsTheSame(ExposureEntity exposureEntity, ExposureEntity exposureEntity2) {
            return exposureEntity.getDateMillisSinceEpoch() == exposureEntity2.getDateMillisSinceEpoch();
        }

        public boolean areItemsTheSame(ExposureEntity exposureEntity, ExposureEntity exposureEntity2) {
            return exposureEntity.getId() == exposureEntity2.getId();
        }
    }

    public interface OnExposureClickListener {
        void onClick(ExposureEntity exposureEntity);
    }

    public static class ViewHolder extends RecyclerView.d0 {
        public ExposureEntity currentItem;
        public final TextView exposureItemTimestamp;

        public ViewHolder(View view, OnExposureClickListener onExposureClickListener) {
            super(view);
            this.exposureItemTimestamp = (TextView) view.findViewById(R.id.exposure_item_timestamp);
            view.setOnClickListener(new c(this, onExposureClickListener));
        }

        public /* synthetic */ void a(OnExposureClickListener onExposureClickListener, View view) {
            ExposureEntity exposureEntity = this.currentItem;
            if (exposureEntity != null) {
                onExposureClickListener.onClick(exposureEntity);
            }
        }

        public void bind(ExposureEntity exposureEntity) {
            this.currentItem = exposureEntity;
            this.exposureItemTimestamp.setText(StringUtils.epochTimestampToMediumUTCDateString(exposureEntity.getDateMillisSinceEpoch(), this.itemView.getContext().getResources().getConfiguration().locale));
        }
    }

    public ExposureEntityAdapter(OnExposureClickListener onExposureClickListener2) {
        super(new ExposureItemCallback());
        this.onExposureClickListener = onExposureClickListener2;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bind((ExposureEntity) getItem(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_exposure_entity, viewGroup, false), this.onExposureClickListener);
    }
}
