package com.popular.backingapp.data.remote.recipes.db.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * The class is used by retrofit to store the JSON structure of id, name,
 * ingredients, steps and servings.
 */
public class RecipeEntity implements Parcelable {

    /**
     * Factory class to create one or more recipe objects.
     */
    public static final Creator<RecipeEntity> CREATOR = new Creator<RecipeEntity>() {
        @Override
        public RecipeEntity createFromParcel(Parcel parcel) {
            return new RecipeEntity(parcel);
        }

        @Override
        public RecipeEntity[] newArray(int size) {
            return new RecipeEntity[size];
        }
    };

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SuppressWarnings("unused")
    @SerializedName("ingredients")
    private List<IngredientEntity> ingredients;

    @SuppressWarnings("unused")
    @SerializedName("steps")
    private List<StepEntity> steps;

    @SerializedName("servings")
    private String servings;



    /**
     * deserialization of RecipeEntity
     *
     * @param parcel serialized object
     */
    private RecipeEntity(Parcel parcel) {
        this.id = parcel.readString();
        this.name = parcel.readString();
        parcel.readTypedList(this.ingredients, IngredientEntity.CREATOR);
        parcel.readTypedList(this.steps, StepEntity.CREATOR);
        this.servings = parcel.readString();
    }

    /**
     * Serialization of RecipeEntity.
     *
     * @param parcel Serialization object
     * @param flags  control flags - not used
     */
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeTypedList(ingredients);
        parcel.writeTypedList(steps);
        parcel.writeString(servings);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public List<StepEntity> getSteps() {
        return steps;
    }

    public String getServings() {
        return servings;
    }
}
