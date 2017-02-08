package com.example.ruiz.pruebasolarizr;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class detalleCliente extends AppCompatActivity{
    BottomNavigationView bottomNavigationView;
    private int mSelectedItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cliente);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });

        MenuItem selectedItem;
        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt("y", 0);
            selectedItem = bottomNavigationView.getMenu().findItem(mSelectedItem);
        } else {
            selectedItem = bottomNavigationView.getMenu().getItem(0);
        }
        selectFragment(selectedItem);
    }

    public void selectFragment(MenuItem item){
        Fragment mifragment = null;
        switch (item.getItemId()) {
            case R.id.action_favorites:
                mifragment = new detalleFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.container,mifragment).commit();
                //mifragment = detalleFragment.newInstance("detalle"," ");
                break;
            case R.id.action_schedules:
                mifragment = new fotosFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.container,mifragment).commit();
                //mifragment = fotosFragment.newInstance("fotos"," ");
                break;

            case R.id.action_music:
                mifragment = new anotacionesFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.container,mifragment).commit();
                //mifragment = anotacionesFragment.newInstance("anotaciones", " ");
                break;
        }
        // update selected item
        mSelectedItem = item.getItemId();

        // uncheck the other items.
        for (int i = 0; i< bottomNavigationView.getMenu().size(); i++) {
            MenuItem menuItem = bottomNavigationView.getMenu().getItem(i);
            menuItem.setChecked(menuItem.getItemId() == item.getItemId());
        }

        updateToolbarText(item.getTitle());

        if (mifragment!= null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container,mifragment,"e");
            //ft.add(R.id.container, frag, frag.getTag());
            ft.commit();
        }
    }


    private void updateToolbarText(CharSequence text) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(text);
        }
    }
}
