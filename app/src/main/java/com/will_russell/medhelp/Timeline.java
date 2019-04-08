package com.will_russell.medhelp;

import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.button.MaterialButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.google.android.material.card.MaterialCardView;
import android.widget.TextView;
import android.util.TypedValue;

public class Timeline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        BottomAppBar bar = findViewById(R.id.bar);
        setSupportActionBar(bar);

        MaterialButton button = findViewById(R.id.med_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMedOverview();
            }
        });

        NestedScrollView scroller = findViewById(R.id.scroll_view);
        if (scroller != null) {
            scroller.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                @Override
                public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    MaterialButton bt = findViewById(R.id.med_button);
                    boolean visible = true;
                    if (scrollY > oldScrollY || scrollY == ( v.getMeasuredHeight() - v.getChildAt(0).getMeasuredHeight())) {
                        Animation fadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_fade_out);
                        bt.startAnimation(fadeOut);
                        bt.setVisibility(View.GONE);
                        visible = false;
                    }
                    if (scrollY < oldScrollY || scrollY == 0) {
                        Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_fade_in);
                        if (visible == false) {
                            bt.startAnimation(fadeIn);
                            visible = true;
                        }
                        bt.setVisibility(View.VISIBLE);

                    }
                }
            });
        }





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

        buildView();
    }

    private void buildView() {
        LinearLayout parent = findViewById(R.id.parent);
        for (int i = 0; i < Medication.medicationList.size(); i++) { // Size depends on number of doses to be taken in a time frame
            parent.addView(buildCard(i));
        }
    }

    private MaterialCardView buildCard(int index) {
        MaterialCardView card = new MaterialCardView(this);
        MaterialCardView.LayoutParams params = new MaterialCardView.LayoutParams(MaterialCardView.LayoutParams.MATCH_PARENT, MaterialCardView.LayoutParams.WRAP_CONTENT);
        int dimens = (int) (getResources().getDimension(R.dimen.card_margin) / getResources().getDisplayMetrics().density);
        params.setMargins(dimens,dimens,dimens,dimens);
        card.setLayoutParams(params);
        card.setCardElevation(4);
        card.setRadius(8);

        card.setCardBackgroundColor(getResources().getColor(R.color.textboxBackground));
        card.setMinimumHeight(100);
        card.addView(buildEntry(index));
        return card;
    }

    private LinearLayout buildEntry(int index) {
        LinearLayout layout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(params);
        layout.setOrientation(LinearLayout.VERTICAL);
        int dimens = (int) (getResources().getDimension(R.dimen.card_internal_padding) / getResources().getDisplayMetrics().density);
        layout.setPadding(dimens,dimens,dimens,dimens);
        layout.addView(buildName(index));
        layout.addView(buildTimes(index));
        layout.addView(buildQuantity(index));
        layout.addView(buildRequirements(index));
        return layout;
    }

    private TextView initialSetup(int index) {
        TextView tv = new TextView(this);
        tv.setId(index);
        tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f);
        return tv;
    }

    private TextView buildName(int index) {
        TextView tv = initialSetup(index);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f);
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        String text = Medication.medicationList.get(index).getName();
        tv.setText(text);
        return tv;
    }

    private TextView buildTimes(int index) {
        TextView tv = initialSetup(index);
        String text = "Time: " + new String(Medication.medicationList.get(index).getSpecificTime(0));
        tv.setText(text);
        return tv;
    }

    private TextView buildQuantity(int index) {
        TextView tv = initialSetup(index);
        String text = "";
        if (Medication.medicationList.get(index).validtabletTotal() == true) {
            text = "Quantity: " + new Integer(Medication.medicationList.get(index).gettabletTotal()).toString();

        } else {
            text = "Dose: " + new Double(Medication.medicationList.get(index).getDoseSize()).toString() + " mg";
        }
        tv.setText(text);
        return tv;
    }

    private TextView buildRequirements(int index) {
        TextView tv = initialSetup(index);
        String text = "Requirements: ";
        for (int i = 0; i < Medication.medicationList.get(index).getRequirements().length; i++) {
            text += Medication.medicationList.get(index).getRequirements()[i];
        }
        tv.setText(text);
        return tv;
    }


    private void openMedOverview() {
        Intent intent = new Intent(this, MedicationOverview.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_timeline, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
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
