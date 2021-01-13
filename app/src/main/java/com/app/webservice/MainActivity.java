package com.app.webservice;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;

import com.app.webservice.fragments.BienvenidaFragment;
import com.app.webservice.fragments.ConsultaListaUsuarioImagenUrlFragment;
import com.app.webservice.fragments.ConsultaUsuarioUrlFragment;
import com.app.webservice.fragments.ConsultarListaUsuariosFragment;
import com.app.webservice.fragments.ConsultarUsuarioFragment;
import com.app.webservice.fragments.ConsutarListausuarioImagenFragment;
import com.app.webservice.fragments.DesarrolladorFragment;
import com.app.webservice.fragments.RegistrarUsuarioFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        Fragment miFragment=new BienvenidaFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main,miFragment).commit();

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


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment miFragment=null;
        boolean fragmentSeleccionado=false;

        if (id == R.id.nav_inicio) {
            miFragment=new BienvenidaFragment();
            fragmentSeleccionado=true;
        }else if (id == R.id.nav_registro) {
            miFragment=new RegistrarUsuarioFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_consulta_individual) {
            miFragment=new ConsultarUsuarioFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_consulta_Url) {
            miFragment=new ConsultaUsuarioUrlFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_consulta_gral) {
            miFragment=new ConsultarListaUsuariosFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_consulta_gral_img) {
            miFragment=new ConsutarListausuarioImagenFragment();
            fragmentSeleccionado=true;
        }else if (id == R.id.nav_consulta_gral_img_url) {
            miFragment=new ConsultaListaUsuarioImagenUrlFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_desarrollador) {
            miFragment=new DesarrolladorFragment();
            fragmentSeleccionado=true;
        }

        if (fragmentSeleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,miFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}