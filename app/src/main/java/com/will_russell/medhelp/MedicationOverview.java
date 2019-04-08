package com.will_russell.medhelp;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.content.Intent;
import android.widget.TextView;

public class MedicationOverview extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_overview);

        BottomAppBar bar = findViewById(R.id.bar);
        setSupportActionBar(bar);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createMedication();
            }
        });

        LinearLayout layout = (LinearLayout) findViewById(R.id.med_element);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //editMedication();
                // Plus add stuff to it
            }

        });
        buildView(); // Builds the LinearLayout with all the medication views in it
    }

    private void createMedication() {
        Intent intent = new Intent(this, ChangeMedication.class);
        this.startActivityForResult(intent, 1);
    }

    private void editMedication() {
        Intent intent = new Intent(this, ChangeMedication.class);
        //String name =

        //intent.putExtra();
        this.startActivity(intent);
    }

    private void buildView() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.med_element);
        layout.removeAllViews(); // DOESN'T WORK
        for (int i = 0; i < Medication.medicationList.size(); i++) {
            layout.addView(buildTitle(i));
            layout.addView(buildSub(i));
        }

    }

    private TextView buildTitle(int index) {
        TextView title = new TextView(this);
        title.setId(index);
        title.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        title.setText(Medication.medicationList.get(index).getName());
        title.setGravity(Gravity.CENTER_VERTICAL);
        title.setPadding(48, 20,2,0);
        title.setTextColor(Color.parseColor("#000000"));
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        return title;
    }

    private TextView buildSub(int index) {
        TextView sub = new TextView(this);
        sub.setId(index);
        sub.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        String subText = "";
        if (Medication.medicationList.get(index).validtabletTotal() == true) {
            subText = "Quantity: " + new Integer(Medication.medicationList.get(index).gettabletTotal()).toString();

        } else {
            subText = "Dose: " + new Double(Medication.medicationList.get(index).getDoseSize()).toString() + " mg";
        }
        sub.setText(subText);
        sub.setGravity(Gravity.CENTER_VERTICAL);
        sub.setPadding(48, 0, 2, 20);
        sub.setTextColor(Color.parseColor("#999999"));
        sub.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f);
        return sub;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            buildView();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // close this activity as oppose to navigating up
        return false;
    }
}
