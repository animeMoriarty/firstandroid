package com.sanya_ubutnu.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    public static final String PARTNER_NAME_EXTRA = "PartnerName.EXTRA";
    public static final String SALE_EXTRA = "Sale.EXTRA";
    public static final String TEXT_EXTRA = "Text.EXTRA";


    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private Button yandexBtn,sitymobilBtn,getTaxiBtn,taxiMowBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        //setToolbar
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();


        //setListener
        navView.setNavigationItemSelectedListener(this);
        yandexBtn.setOnClickListener(this);
        sitymobilBtn.setOnClickListener(this);
        getTaxiBtn.setOnClickListener(this);
        taxiMowBtn.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            super.onBackPressed();
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

    private void init(){
        drawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.nav_view);

        yandexBtn = findViewById(R.id.yandex_btn);
        sitymobilBtn = findViewById(R.id.sitymobil_btn);
        getTaxiBtn = findViewById(R.id.get_btn);
        taxiMowBtn = findViewById(R.id.taximow_btn);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.yandex_btn:
                startProductActivity(R.string.partner_yandex,R.string.sale_yandex,R.string.text_yandex_taxi);
                break;
            case R.id.get_btn:
                startProductActivity(R.string.partner_get_taxi,R.string.sale_get_taxi,R.string.text_get__taxi);
                break;
            case R.id.sitymobil_btn:
                startProductActivity(R.string.partner_sity_mobil,R.string.sale_sity_mobil,R.string.text_sity_mobil);
                break;
            case R.id.taximow_btn:
                startProductActivity(R.string.partner_taxi_mow,R.string.sale_taxi_mow,R.string.text_taxi_mow);
                break;
        }

    }

    private void startProductActivity(int partnerName,int sale,int text){
        Intent productActivity = new Intent(getApplicationContext(),ProductActivity.class);
        productActivity.putExtra(PARTNER_NAME_EXTRA,partnerName);
        productActivity.putExtra(SALE_EXTRA,sale);
        productActivity.putExtra(TEXT_EXTRA,text);

        startActivity(productActivity);
    }

    private void startAboutActivity(int partnerName,int text){
        Intent aboutActivity = new Intent(getApplicationContext(),AboutActivity.class);
        aboutActivity.putExtra(PARTNER_NAME_EXTRA,partnerName);
        aboutActivity.putExtra(TEXT_EXTRA,text);

        startActivity(aboutActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
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
}

