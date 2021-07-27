package com.training.captureimage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView image;
    ImageButton cameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.imageView);
        cameraButton = findViewById(R.id.imageButton);
        //if the device has no camera than button will now work
        if (!cameraAvailable())
            cameraButton.setEnabled(false);
    }

    public boolean cameraAvailable() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public void getPhoto(View view) {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //we are expecting result , that is the image captured by the camera
        startActivityForResult(i, REQUEST_IMAGE_CAPTURE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        //if condition makes sure that the image is taken, and result is ok
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle imageExtras = data.getExtras();
            Bitmap photo = (Bitmap) imageExtras.get("data");
            image.setImageBitmap(photo);
        }
    }
}