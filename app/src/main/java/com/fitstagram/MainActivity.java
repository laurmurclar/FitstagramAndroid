package com.fitstagram;

import android.location.GpsStatus;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity{

    OnClickListener l1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1 = (Button) findViewById(R.id.button);
    //    tv1 = (TextView) findViewById(R.id.textView1);

        b1.setOnClickListener(l1);

    }

    public void onClick(View v)
    {
        // TODO Auto-generated method stub
        Intent i = new Intent(getApplicationContext(),TakePicture.class);
        startActivity(i);
        setContentView(R.layout.activity_take_picture);
    }


}
