package com.popular.backingapp.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.popular.backingapp.R;
import com.popular.backingapp.ui.model.RecipeModel;
import com.popular.backingapp.ui.model.Step;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class StepsFragment extends Fragment implements StepsAdapter.OnStepListener {
    @BindView(R.id.steps_rv)
    RecyclerView stepsRecyclerView;
    //for ButterKnife framework
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // Inflate
        View rootView = inflater.inflate(R.layout.detail_steps_fragment, container, false);

        //bind
        unbinder = ButterKnife.bind(this, rootView);

        StepsAdapter stepsAdapter = new StepsAdapter(this);
        stepsRecyclerView.setAdapter(stepsAdapter);

        stepsAdapter.setStepList(RecipeModel.getInstance().getCurrentSelectedRecipe().getSteps());
        stepsAdapter.notifyDataSetChanged();

        return rootView;

    }

    /**
     * When the view is destroyed, the binder is reset.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onStepClick(Step step) {
        RecipeModel.getInstance().setCurrentSelectedStep(step);
        Intent intent = new Intent(getActivity(), StepActivity.class);
        startActivity(intent);
    }
}
