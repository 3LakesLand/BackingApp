package com.popular.backingapp.data.remote.recipes.db.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * The class is used by retrofit to store the JSON structure of id, shortDescription,
 * description, videoURL and thumbnailURL.
 */
public class StepEntity implements Parcelable {

    /**
     * Factory class to create one or more step objects.
     */
    public static final Creator<StepEntity> CREATOR = new Creator<StepEntity>() {
        @Override
        public StepEntity createFromParcel(Parcel parcel) {
            return new StepEntity(parcel);
        }

        @Override
        public StepEntity[] newArray(int size) {
            return new StepEntity[size];
        }
    };


    @SerializedName("id")
    private String id;

    @SerializedName("shortDescription")
    private String shortDescription;

    @SerializedName("description")
    private String description;

    @SerializedName("videoURL")
    private String videoURL;

    @SerializedName("thumbnailURL")
    private String thumbnailURL;

    /**
     * deserialization of StepEntity
     *
     * @param parcel serialized object
     */
    private StepEntity(Parcel parcel) {
        this.id = parcel.readString();
        this.shortDescription = parcel.readString();
        this.description = parcel.readString();
        this.videoURL = parcel.readString();
        this.thumbnailURL = parcel.readString();
    }

    /**
     * Serialization of StepEntity.
     *
     * @param parcel Serialization object
     * @param flags  control flags - not used
     */
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(id);
        parcel.writeString(shortDescription);
        parcel.writeString(description);
        parcel.writeString(videoURL);
        parcel.writeString(thumbnailURL);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }
}
