package com.fitstagram;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.content.Intent;
import android.provider.MediaStore;

public class MainActivity extends ActionBarActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView pictureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pictureView = (ImageView) findViewById(R.id.picture_view);
    }

    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Take a picture and pass results along to onActivityResult
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
    }

    //if you want to return the image taken
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // checks that there arent errors or anything
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            //get the photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            pictureView.setImageBitmap(photo);
        }
    }
}
