package com.example.worldskills.turistapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Sitios extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerView;
    Adaptador adaptador;
    AdaptadorGrid adaptadorGrid;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Info>llenar;
    Context context;
    int cambiar=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView=findViewById(R.id.recyclerview);

        llenar=new ArrayList<Info>();
        llenar.add(new Info("Cerro de Monserrate","El Cerro de Monserrate los espera durante los 365 días del año bogota","Carrera 2 E No. 21-48 | Paseo Bolívar, Bogota, Colombia",""));
        llenar.add(new Info("hotel","cama","bogota","ah"));



        construir();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Sitios.this,MapsActivity.class);
                intent.putExtra("ubicacion","2");
                startActivity(intent);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void construir(){
        recyclerView.setHasFixedSize(true);
        adaptador= new Adaptador(this, llenar);
        linearLayoutManager=new GridLayoutManager(context,cambiar);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adaptador);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sitios, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.grid) {
            camVista();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.inicio) {
            Intent intent=new Intent(Sitios.this,Inicio.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.sitios) {



        } else if (id == R.id.hoteles) {
            Intent intent=new Intent(Sitios.this,Hoteles.class);
            startActivity(intent);
            finish();


        } else if (id == R.id.restaurantes) {
            Intent intent=new Intent(Sitios.this,Restaurantes.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void camVista(){
        if (cambiar==1){
            cambiar=2;
            linearLayoutManager=new GridLayoutManager(context,cambiar);
            adaptadorGrid= new AdaptadorGrid(this, llenar);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adaptadorGrid);
        }
        else {
            cambiar=1;
            linearLayoutManager=new GridLayoutManager(context,cambiar);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adaptador);
    }
    }

}
