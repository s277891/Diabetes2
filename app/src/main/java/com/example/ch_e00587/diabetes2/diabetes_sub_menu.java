package com.example.ch_e00587.diabetes2;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;


public class diabetes_sub_menu extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.i("DIABETES1", "On Create Sub main activity");
        TabHost tabHost=(TabHost) findViewById(android.R.id.tabhost);
        //      Log.i("DIABETES1", "On Create Sub main activity tabhost");
        TabHost.TabSpec tab4=tabHost.newTabSpec("Fourth Tab");
        //    Log.i("DIABETES1", "On Create Sub main activity first tab");
        TabHost.TabSpec tab5=tabHost.newTabSpec("Fifth Tab");
        //  Log.i("DIABETES1", "On Create Sub main activity second");
        TabHost.TabSpec tab6=tabHost.newTabSpec("Sixth Tab");
        //Log.i("DIABETES1", "On Create Sub main activity third");
        tab4.setIndicator("Eat Healthy");
        tab4.setContent(new Intent(this,EatHealthy.class));
//        Log.i("DIABETES1", "On Create Sub main activity set content");
        tab5.setIndicator("Activity");
        tab5.setContent(new Intent(this,Physicalactivity.class));

        tab6.setIndicator("Stories");
        tab6.setContent(new Intent(this,stories.class));
        //      Log.i("DIABETES1", "On Create Sub main activity before add");
        tabHost.addTab(tab4);
        tabHost.addTab(tab5);
        tabHost.addTab(tab6);
        //    Log.i("DIABETES1", "On Create Sub main activity after add");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_diabetes_sub_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
