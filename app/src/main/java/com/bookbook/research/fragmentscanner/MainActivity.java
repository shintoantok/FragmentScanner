package com.bookbook.research.fragmentscanner;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements Scanner.OnFragmentInteractionListener, ScanBookdetail.OnFragmentInteractionListener {

    private Scanner scanner = new Scanner();
    private ScanBookdetail scanBookdetail = new ScanBookdetail();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.your_placeholder, scanner);
                ft.commitNow();
                //getSupportFragmentManager().beginTransaction().add(R.id.your_placeholder, new Scanner()).commitNowAllowingStateLoss();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void navigateToScanDetailFragment(String isbn){

//        getSupportFragmentManager().beginTransaction().
//                remove(getSupportFragmentManager().findFragmentById(R.id.scannercam)).commit();
        //you can leave it empty
        Bundle bundle = new Bundle();
        bundle.putString("BarcodeValue", isbn);
        scanBookdetail.setArguments(bundle);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.your_placeholder, scanBookdetail);
        ft.remove(getSupportFragmentManager().findFragmentById(R.id.your_placeholder)).commit();
        //ft.commitNow();


        //getSupportFragmentManager().beginTransaction().replace(R.id.your_placeholder, new ScanBookdetail()).commitNowAllowingStateLoss();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
