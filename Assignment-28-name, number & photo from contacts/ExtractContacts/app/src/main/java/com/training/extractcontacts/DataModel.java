package com.training.extractcontacts;

import android.net.Uri;

public class DataModel {
    String name;
    String number;
    Uri imageUri;

    public DataModel(String name, String number, Uri imageUri) {
        this.name = name;
        this.number = number;
        this.imageUri = imageUri;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public Uri getImageUri() {
        return imageUri;
    }
}
