package com.example.cgi.my_home_circle;

/**
 * Created by CGI on 1/29/2017.
 */
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ReferralActivity extends ListActivity  implements View.OnClickListener {

    Button Network , newbiz;
    private ListView lv;


    String[] itemname ={
            "Architectural Custom Woodwork",
            "Ashland Woodwork",
            "Byrd Mill Co",
            "Commercial Custom Cabinet Inc",
            "E H Lail Millwork",
            "Freeburger Custom Cabinetry",
            "Hackney Millwork Inc",
            "Integrated Millwork Inc"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.referrals);


        Network = (Button) findViewById(R.id.network);
        Network.setOnClickListener(this);

        newbiz = (Button) findViewById(R.id.NewBiz);
        newbiz.setOnClickListener(this);

        this.setListAdapter(new ArrayAdapter<String>(
                this, R.layout.mylist,
                R.id.Itemname,itemname));

        lv = (ListView) findViewById(android.R.id.list);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //  final TextView mTextView = (TextView)view;
                switch (i) {
                    case 0:
                        Intent newActivity0 = new Intent(view.getContext(),ProductDetail.class);
                        startActivity(newActivity0);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(view.getContext(),ProductDetail.class);
                        startActivity(newActivity1);
                        break;

                    default:
                        // Nothing do!
                }

            }


        });


    }



    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.network:
                // reference a function that would house your current onClick behavior, such as:
                Intent i = new Intent(ReferralActivity.this, NetworkActivity.class);
                startActivity(i);
                break;

            case R.id.NewBiz:
                 i = new Intent(ReferralActivity.this, AddBiz.class);
                startActivity(i);
                break;
        }
    }

}

