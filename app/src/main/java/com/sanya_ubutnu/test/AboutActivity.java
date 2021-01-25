package com.sanya_ubutnu.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class AboutActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private TextView aboutTv,textTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtity_about);

        //init
        init();

        //setToolbar
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //setListener
        navView.setNavigationItemSelectedListener(this);

        if (getIntent() != null){
            aboutTv.setText(getIntent().getIntExtra(BaseActivity.PARTNER_NAME_EXTRA,R.string.app_name));
            textTv.setText(getIntent().getIntExtra(BaseActivity.TEXT_EXTRA,R.string.app_name));
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.item_yandex_taxi:
                startProductActivity(R.string.partner_yandex,R.string.sale_yandex,R.string.text_yandex_taxi);
                break;
            case R.id.item_get_taxi:
                startProductActivity(R.string.partner_get_taxi,R.string.sale_get_taxi,R.string.text_get__taxi);
                break;
            case R.id.item_sitymobil_taxi:
                startProductActivity(R.string.partner_sity_mobil,R.string.sale_sity_mobil,R.string.text_sity_mobil);
                break;
            case R.id.item_taximow_taxi:
                startProductActivity(R.string.partner_taxi_mow,R.string.sale_taxi_mow,R.string.text_taxi_mow);
                break;
            case R.id.item_about_partners:
                startAboutActivity(R.string.about_partner,R.string.text_about_partner);
                break;
            case R.id.item_about_app:
                startAboutActivity(R.string.text_about_app,R.string.about_app);

                break;
        }
        return true;
    }

    private void startProductActivity(int partnerName,int sale,int text){
        Intent productActivity = new Intent(getApplicationContext(),ProductActivity.class);
        productActivity.putExtra(BaseActivity.PARTNER_NAME_EXTRA,partnerName);
        productActivity.putExtra(BaseActivity.SALE_EXTRA,sale);
        productActivity.putExtra(BaseActivity.TEXT_EXTRA,text);

        startActivity(productActivity);
    }

    private void startAboutActivity(int partnerName,int text){
        Intent aboutActivity = new Intent(getApplicationContext(),AboutActivity.class);
        aboutActivity.putExtra(BaseActivity.PARTNER_NAME_EXTRA,partnerName);
        aboutActivity.putExtra(BaseActivity.TEXT_EXTRA,text);

        startActivity(aboutActivity);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
        }
        return true;
    }

    private void init(){
        drawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.nav_view);
        aboutTv = findViewById(R.id.about_tv);
        textTv = findViewById(R.id.text_tv);
    }

}
