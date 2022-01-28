package com.proudcrowd.exposure.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.storage.KeyScanEntity;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CheckScansFragmentCell extends BaseCellAdapterLocal<KeyScanEntity> {
    private FragmentActivity mControllingActivity;
    private SimpleDateFormat mDateFormat = new SimpleDateFormat("EEEE, MMM d, h:mm aa");
    private LayoutInflater mLayoutInflater;

    public CheckScansFragmentCell(BaseListFragmentLocal baseListFragmentLocal) {
        this.mControllingActivity = baseListFragmentLocal.getActivity();
        this.mLayoutInflater = (LayoutInflater) baseListFragmentLocal.getActivity().getSystemService("layout_inflater");
    }

    public String getDate(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return this.mDateFormat.format(instance.getTime());
    }

    @Override // com.proudcrowd.exposure.fragment.BaseCellAdapterLocal
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout;
        if (view == null) {
            linearLayout = (LinearLayout) this.mLayoutInflater.inflate(R.layout.fragment_check_scans_cell, viewGroup, false);
        } else {
            linearLayout = (LinearLayout) view;
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.scan_icon);
        TextView textView = (TextView) linearLayout.findViewById(R.id.scan_date);
        if (this.mLocalData != null) {
            textView.setText(getDate(((KeyScanEntity) this.mLocalData.get(i)).getCreatedTimestampMs()));
        }
        return linearLayout;
    }
}
