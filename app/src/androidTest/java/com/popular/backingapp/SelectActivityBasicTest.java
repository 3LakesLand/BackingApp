package com.popular.backingapp;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.popular.backingapp.ui.main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class SelectActivityBasicTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);


    @Test
    public void checkRecipesAreDisplayed() {
        // Check that the recyclerview containing the recipes is displayed
        onView(withId(R.id.recipes_rv))
                .check(matches(isDisplayed()));
    }

    @Test
    public void checkTheFirstRecipeIsNutellaPie() {
        onData(is("Nutella Pie"))
                .inAdapterView(withId(R.id.recipes_rv))
                .atPosition(0);
    }

    @Test
    public void checkStepsFromFirstRecipeAreDisplayed() {

        onView(withId(R.id.recipes_rv)).perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.steps_rv)).check(matches(isDisplayed()));
    }

}
