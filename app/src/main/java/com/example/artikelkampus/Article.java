package com.example.artikelkampus;

import android.os.Parcel;
import android.os.Parcelable;

public class Article implements Parcelable {
    private int imageResource;
    private String title;
    private String overview;
    private String description;
    private int foundingYear;

    public Article(int imageResource, String title, String overview, String description, int foundingYear) {
        this.imageResource = imageResource;
        this.title = title;
        this.overview = overview;
        this.description = description;
        this.foundingYear = foundingYear;
    }

    protected Article(Parcel in) {
        imageResource = in.readInt();
        title = in.readString();
        overview = in.readString();
        description = in.readString();
        foundingYear = in.readInt();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getDescription() {
        return description;
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageResource);
        dest.writeString(title);
        dest.writeString(overview);
        dest.writeString(description);
        dest.writeInt(foundingYear);
    }
}
