package com.fitstagram;

/**
 * Created by Sean on 06/04/2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.fitstagram.imageutils.ImageLoader;

public class SingleItemView extends Activity {
    // Declare Variables
    String rank;
    String country;
    String time;
    String image;
    String position;
    ImageLoader imageLoader = new ImageLoader(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.singleitemview);

        Intent i = getIntent();
        // Get the result of rank
        time = i.getStringExtra("time");
        // Get the result of country
//        country = i.getStringExtra("country");
        // Get the result of population
//        population = i.getStringExtra("population");
        // Get the result of flag
        image = i.getStringExtra("image");

        // Locate the TextViews in singleitemview.xml
        TextView txtTime = (TextView) findViewById(R.id.time);
   //     TextView txtcountry = (TextView) findViewById(R.id.country);
  //      TextView txtpopulation = (TextView) findViewById(R.id.population);

        // Locate the ImageView in singleitemview.xml
        ImageView imgflag = (ImageView) findViewById(R.id.image);

        // Set results to the TextViews
//        txtrank.setText(rank);
//        txtcountry.setText(country);
//        txttime.setText(time);

        // Capture position and set results to the ImageView
        // Passes flag images URL into ImageLoader.class
        imageLoader.DisplayImage(image, imgflag);
    }
}
