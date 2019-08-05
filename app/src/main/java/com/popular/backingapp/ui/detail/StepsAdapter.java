package com.popular.backingapp.ui.detail;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.popular.backingapp.R;
import com.popular.backingapp.ui.model.Step;

import java.util.ArrayList;
import java.util.List;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.MyViewHolder> {

    private List<Step> stepList;
    private OnStepListener onStepListener;

    StepsAdapter(OnStepListener onStepListener) {
        this.onStepListener = onStepListener;
        stepList = new ArrayList<>();
    }

    void setStepList(List<Step> stepList) {
        this.stepList = stepList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_step_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(stepList.get(position));

    }

    @Override
    public int getItemCount() {
        return stepList.size();
    }


    public interface OnStepListener {
        void onStepClick(Step step);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView descriptionTextView;
        private Button showVideoButton;

        private MyViewHolder(@NonNull View itemView) {
            super(itemView);
            descriptionTextView = itemView.findViewById(R.id.description_tv);
            showVideoButton = itemView.findViewById(R.id.show_video_bt);
            showVideoButton.setOnClickListener(this);
        }

        void bind(Step step) {
            descriptionTextView.setText(step.getDescription());

            if (step.getThumbnailURL().trim().isEmpty() && step.getVideoURL().trim().isEmpty()) {
                showVideoButton.setVisibility(View.GONE);
            } else {
                showVideoButton.setText("Show \"" + step.getShortDescription() + "\" Video");
            }
        }


        @Override
        public void onClick(View v) {
            Step step = stepList.get(getAdapterPosition());
            onStepListener.onStepClick(step);
        }

    }
}
