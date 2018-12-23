package com.will_russell.medhelp;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.LinearLayout;
import com.google.android.material.card.MaterialCardView;
import android.widget.TextView;


public class Timeline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("Timeline");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMedOverview();
            }
        });


        String[] times1 = new String[2];
        times1[0] = "10:00";
        times1[1] = "20:00";
        String[] times2 = new String[3];
        times2[0] = "08:00";
        times2[1] = "12:00";
        times2[2] = "18:00";
        String[] times3 = new String[4];
        times3[0] = "08:00";
        times3[1] = "12:00";
        times3[2] = "16:00";
        times3[3] = "20:00";
        String[] times4 = new String[1];
        times4[0] = "23:00";
        String[] r1 = new String[1];
        r1[0] = "With Food";
        String[] none = new String[1];
        none[0] = "N/A";

        Medication.medicationList.add(new Medication(
                "Azathioprine",
                times1,
                times1.length,
                150.0,
                r1
        ));

        Medication.medicationList.add(new Medication(
                "Adcal D3",
                times2,
                times2.length,
                1,
                r1
        ));
        Medication.medicationList.add(new Medication(
                "EpiPen",
                times3,
                times3.length,
                10.0,
                r1
        ));
        Medication.medicationList.add(new Medication(
                "Certirizine",
                times4,
                times4.length,
                10.0,
                none
        ));
    }

    private void buildView() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.cards_timeline);
        layout.removeAllViews();

        for (int i = 0; i < 4; i++) {
            MaterialCardView materialCardView = new MaterialCardView(this);
            layout.addView(buildName(i));
            layout.addView(buildTimes(i));
            layout.addView(buildQuantity(i));
        }
    }

    private TextView buildName(int index) {
        TextView tv = new TextView(this);
        tv.setId(index);
        return tv;
    }
    
    private TextView buildTimes(int index) {
        TextView tv = new TextView(this);
        tv.setId(index);
        return tv;
    }

    private TextView buildQuantity(int index) {
        TextView tv = new TextView(this);
        tv.setId(index);
        return tv;
    }

    private TextView buildRequirements(int index) {
        TextView tv = new TextView(this);
        tv.setId(index);
        return tv;
    }


    private void openMedOverview() {
        Intent intent = new Intent(this, MedicationOverview.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timeline, menu);
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
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_about) {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


}
