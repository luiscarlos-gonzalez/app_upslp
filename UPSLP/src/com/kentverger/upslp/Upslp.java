package com.kentverger.upslp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Upslp extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upslp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_upslp, menu);
        return true;
    }
}
