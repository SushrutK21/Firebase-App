package com.example.cgi.my_home_circle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class GetReferralActivity extends Activity implements View.OnClickListener {

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;
    Button Network;


    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getreferral);

        Network = (Button) findViewById(R.id.network);
        Network.setOnClickListener(this);


        // Listview Data
        String products[] = {"Addition & Remodels",
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
                "Windows & Doors"};

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, products);
        lv.setAdapter(adapter);

        /**
         * Enabling Search Filter
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                GetReferralActivity.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

              //  final TextView mTextView = (TextView)view;
                switch (i) {
                    case 0:
                        Intent newActivity0 = new Intent(view.getContext(),ReferralActivity.class);
                        startActivity(newActivity0);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(view.getContext(),ReferralActivity.class);
                        startActivity(newActivity1);
                        break;

                    default:
                        // Nothing do!
                }

            }


        });

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.network:
                // reference a function that would house your current onClick behavior, such as:
                Intent i = new Intent(GetReferralActivity.this, NetworkActivity.class);
                startActivity(i);
                break;
        }
    }


}