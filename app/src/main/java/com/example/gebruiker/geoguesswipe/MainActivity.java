package com.example.gebruiker.geoguesswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GeoObjectAdapter mAdapter;
    private List<GeoObject> mGeoObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setGeoObjectAdapter();

        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder
                            target) {
                        return false;
                    }
                    //Called when a user swipes left or right on a ViewHolder
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        //Get the index corresponding to the selected position
                        int position = (viewHolder.getAdapterPosition());
                        if (swipeDir == ItemTouchHelper.LEFT) {
                            getAnswer(true, position);
                            removeItem(position);
                        } else if (swipeDir == ItemTouchHelper.RIGHT) {//swipe right
                            getAnswer(false, position);
                            removeItem(position);
                        }
                    }
                };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);


    }

     void getAnswer(boolean userSwipe, int position) {
        boolean correctAnswer = mGeoObjects.get(position).getmGeoAnwser();
        if (userSwipe == correctAnswer) {
            Toast.makeText(getApplicationContext(), "You are right!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Haha wrong!", Toast.LENGTH_SHORT).show();
        }
    }
    void removeItem(int position) {
        mGeoObjects.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    void setGeoObjectAdapter() {
        mGeoObjects = new ArrayList<>();
        for (int i = 0; i < GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS.length; i++){
            mGeoObjects.add(new GeoObject(i));
        }
        mAdapter = new GeoObjectAdapter(mGeoObjects);

    }

}
