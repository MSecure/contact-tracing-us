package com.proudcrowd.exposure.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.datamodel.InstructionDetail;
import java.util.List;

public class PartyInstructionsFragmentAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<InstructionDetail> mInstructions;

    public PartyInstructionsFragmentAdapter(List<InstructionDetail> list) {
        this.mInstructions = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_party_instructions_cell, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        InstructionDetail instructionDetail = this.mInstructions.get(i);
        myViewHolder.titleControl.setText(instructionDetail.title);
        myViewHolder.detailControl.setText(instructionDetail.detail);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mInstructions.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView detailControl;
        public TextView titleControl;

        public MyViewHolder(View view) {
            super(view);
            this.titleControl = (TextView) view.findViewById(R.id.standard_title);
            this.detailControl = (TextView) view.findViewById(R.id.standard_detail);
        }
    }
}
