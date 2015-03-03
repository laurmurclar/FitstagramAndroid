package com.fitstagram;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.content.Intent;
import android.provider.MediaStore;

public class MainActivity extends ActionBarActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView takenPictureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   ActionBar actionBar = getSupportActionBar();
     //   actionBar.show();
        setContentView(R.layout.activity_main);
    //    Button takePictureButton = (Button) findViewById(R.id.takePictureButton);
    //    takenPictureView = (ImageView) findViewById(R.id.takenPictureView);
    }

    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Take a picture and pass results along to onActivityResult
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                return true;
            case R.id.action_home:
                setContentView(R.layout.activity_main);
                return true;
            case R.id.takePictureButton:
                setContentView(R.layout.activity_take_picture);
                Button takePictureButton = (Button) findViewById(R.id.takePictureButton);
                takenPictureView = ((ImageView) findViewById(R.id.takenPictureView));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




    //if you want to return the image taken
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // checks that there arent errors or anything
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            //get the photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            Intent intent = new Intent(this, UploadConfirmActivity.class);
            intent.putExtra("BitmapImg",photo);
            startActivity(intent);
        }
    }
}
