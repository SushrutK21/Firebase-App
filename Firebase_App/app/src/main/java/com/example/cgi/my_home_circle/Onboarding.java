package com.example.cgi.my_home_circle;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

public class Onboarding extends ListActivity implements View.OnClickListener {

    private Button back , next;

    String[] Products= {
            "Addition & Remodels",
            "Cabinets",
            "Closing Attorney",
            "Countertops",
            "Decks , Porches & patios",
            "Design & Build",
            "Driveways & Walkways",
            "Electrical",
            "Equipment Rental",
            "Exterior walls & sliding",
            "Fences & Gates",
            "Flooring",
            "Furniture Repair",
            "Garage & Outbuildings",
            "Gutters",
            "Handyman Services",
            "Heating & AC ",
            "Home Appraiser",
            "Home Insurance Agency",
            "Home Inspection",
            "Home Office & Theater",
            "Home Security",
            "Home Staging",
            "Home Warranty",
            "Interior Walls & Ceiling",
            "Landscape, Lawn & Garden",
            "Locksmith",
            "Mortgage Lender",
            "Moving Services",
            "Painting",
            "Pest & Toxin Control",
            "Plumbing",
            "Pool & Spa",
            "Propane & Heating fuels",
            "Real Estate Agent",
            "Roofing",
            "Storage Rental",
            "Title Insurance",
            "Trash Service",
            "Window Treatments",
            "Windows & Doors"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboardingscreen);

        Button back  = (Button) findViewById(R.id.back);
        Button next  = (Button) findViewById(R.id.next);
        back.setOnClickListener(this);
        next.setOnClickListener(this);

        // -- Display mode of the ListView

        ListView listview= getListView();
        //	listview.setChoiceMode(listview.CHOICE_MODE_NONE);
        //	listview.setChoiceMode(listview.CHOICE_MODE_SINGLE);
        listview.setChoiceMode(listview.CHOICE_MODE_MULTIPLE);

        //--	text filtering
        listview.setTextFilterEnabled(true);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked,Products));
    }

    public void onListItemClick(ListView parent, View v,int position,long id){
        CheckedTextView item = (CheckedTextView) v;
        Toast.makeText(this, Products[position] + " checked : " +
                item.isChecked(), Toast.LENGTH_SHORT).show();
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                // reference a function that would house your current onClick behavior, such as:
                Intent i = new Intent(Onboarding.this, SignUpActivity.class);
                startActivity(i);
                break;
            case R.id.next:
                i = new Intent(Onboarding.this, GetReferralActivity.class);
                startActivity(i);
        }
    } }