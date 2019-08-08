package com.popular.backingapp.ui.detail;

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

/**
 * The adapter allows the loading and display the recipe steps.
 */
public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.MyViewHolder> {

    private List<Step> stepList;
    private OnStepListener onStepListener;

    /**
     * Constructor
     *
     * @param onStepListener for selecting the step
     */
    StepsAdapter(OnStepListener onStepListener) {
        this.onStepListener = onStepListener;
        stepList = new ArrayList<>();
    }

    void setStepList(List<Step> stepList) {
        this.stepList = stepList;
    }

    /**
     * The method creates a View Holder object.
     *
     * @param viewGroup contains the application context
     * @param viewType  - not used
     * @return new View Holder object
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_step_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    /**
     * The View Holder binds the step data object.
     *
     * @param holder   current view holder
     * @param position in the adapter
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(stepList.get(position));

    }

    /**
     * Count of all step objects.
     *
     * @return count
     */
    @Override
    public int getItemCount() {
        return stepList.size();
    }

    /**
     * Listener for selecting the step from the step overview list page.
     */
    public interface OnStepListener {
        void onStepClick(Step step);
    }

    /**
     * The ViewHolder contains the step description and the video sho button.
     * The step short description is in the button text.
     */
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final String SHOW = "Show \"";
        private static final String VIDEO = "\" Video";
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
                final String buttonText = SHOW + step.getShortDescription() + VIDEO;
                showVideoButton.setText(buttonText);
            }
        }


        @Override
        public void onClick(View v) {
            Step step = stepList.get(getAdapterPosition());
            onStepListener.onStepClick(step);
        }

    }
}
