package bsl.co.ke.covidapp.ui;




import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import bsl.co.ke.covidapp.R;


public class HospitalsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private HospitalAdapter adapter;
    ArrayList<HospitalItems> hospitalItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);

        mRecyclerView = findViewById(R.id.recycler_view_hospital);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Available Isolation Facilities");

        setArrayList();

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.sk_line_divider));
        mRecyclerView.addItemDecoration(itemDecoration);

        adapter = new HospitalAdapter(getApplicationContext(), (ArrayList<HospitalItems>) hospitalItems);
        mRecyclerView.setAdapter(adapter);

    }


    @Override
    public boolean onSupportNavigateUp()
    {

        onBackPressed();

        finish();
        return true;
    }

    private void setArrayList() {

        hospitalItems = new ArrayList<>();
        hospitalItems.add(new HospitalItems("MBAGATHI HOSPITAL", "24 hours \nmonday - sunday", "0720000000"));
        hospitalItems.add(new HospitalItems("KNH Hospital", "24 hrs      \nmonday - sunday", "0721000000"));
        hospitalItems.add(new HospitalItems("KAREN HOSPITAL", "24 hrs\nmonday - sunday", "0725000000"));
        hospitalItems.add(new HospitalItems("MAMA LUCY HOSPITAL", "24 hrs\nmonday - sunday", "071562222"));

    }

}