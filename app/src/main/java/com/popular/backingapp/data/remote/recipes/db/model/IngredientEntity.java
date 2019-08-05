package com.popular.backingapp.data.remote.recipes.db.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * The class is used by retrofit to store the JSON structure of quantity, measure and
 * ingredient.
 */
public class IngredientEntity implements Parcelable {

    /**
     * Factory class to create one or more ingredient objects.
     */
    public static final Creator<IngredientEntity> CREATOR = new Creator<IngredientEntity>() {
        @Override
        public IngredientEntity createFromParcel(Parcel parcel) {
            return new IngredientEntity(parcel);
        }

        @Override
        public IngredientEntity[] newArray(int size) {
            return new IngredientEntity[size];
        }
    };


    @SerializedName("quantity")
    private String quantity;

    @SerializedName("measure")
    private String measure;

    @SerializedName("ingredient")
    private String ingredient;

    /**
     * deserialization of IngredientEntity
     *
     * @param parcel serialized object
     */
    private IngredientEntity(Parcel parcel) {
        this.quantity = parcel.readString();
        this.measure = parcel.readString();
        this.ingredient = parcel.readString();
    }

    /**
     * Serialization of IngredientEntity.
     *
     * @param parcel Serialization object
     * @param flags  control flags - not used
     */
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(quantity);
        parcel.writeString(measure);
        parcel.writeString(ingredient);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public String getIngredient() {
        return ingredient;
    }
}
