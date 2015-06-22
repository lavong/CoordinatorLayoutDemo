package com.ingloriousmind.android.coordinatorlayoutdemo;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * coordinator layout demo activity
 *
 * @author lavong.soysavanh
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
        }

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getString(R.string.app_name));

        Button buttonSnack = (Button) findViewById(R.id.button_snack);
        buttonSnack.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_snack:
                Snackbar.make(coordinatorLayout, getString(R.string.snacked), Snackbar.LENGTH_SHORT)
                        .setAction(getString(R.string.more), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HomeActivity.this, getString(R.string.snack_more), Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                break;
            default:
                break;
        }
    }
}
