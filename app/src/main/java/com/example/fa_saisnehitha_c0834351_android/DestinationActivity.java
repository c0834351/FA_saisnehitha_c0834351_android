package com.example.fa_saisnehitha_c0834351_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class DestinationActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    FavDestination des;
    List<FavDestination> destinationList;
    SwipeMenuListView listView;
    DestinationAdapter destinationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        listView = findViewById(R.id.swipe_lv);
        destinationList = new ArrayList<>();
        //instantiate dbHelper
        databaseHelper = new DatabaseHelper(this);
        displayListOfDestinatios();
        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem editItem = new SwipeMenuItem(
                        getApplicationContext());
                editItem.setBackground(new ColorDrawable(Color.rgb(0x00, 0x66,
                        0xff)));
                editItem.setWidth((200));
                editItem.setTitleSize(20);
                editItem.setTitleColor(Color.BLACK);
                editItem.setTitle("update");
                menu.addMenuItem(editItem);
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                deleteItem.setTitleColor(Color.BLACK);
                deleteItem.setWidth((200));
                deleteItem.setTitleSize(20);
                deleteItem.setTitle("delete");
                menu.addMenuItem(deleteItem);

            }
        };
        listView.setMenuCreator(creator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // update
                        FavDestination place = destinationList.get(position);
                        double latitude = place.getLatitude();
                        double longitude = place.getLongitude();
                        Intent intent = new Intent(DestinationActivity.this,MapsActivity.class);
//                        intent.putExtra("latitude",latitude);
//                        intent.putExtra("longitude",longitude);
//                        LatLng latLng = new LatLng(latitude,longitude);
                        setResult(MapsActivity.RESULT_OK, intent);
                        finish();
                        break;
                    case 1:
                        // delete
                        Toast.makeText(DestinationActivity.this, "delete clicked", Toast.LENGTH_SHORT).show();
                        FavDestination favDestina = destinationList.get(position);
                        System.out.println(position+"))))))))))))))))))))))*************");
                        int id = favDestina.getId();
                        System.out.println(id + "))))))))))))))))))))))************");
                        if(databaseHelper.deleteDestinations(id))
                            destinationList.remove(position);
                            destinationAdapter.notifyDataSetChanged();
                        break;
                }
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FavDestination place = destinationList.get(position);
                double latitude = place.getLatitude();
                double longitude = place.getLongitude();
                Intent intent = new Intent(DestinationActivity.this,MapsActivity.class);
                intent.putExtra("latitude",latitude);
                intent.putExtra("longitude",longitude);
                LatLng latLng = new LatLng(latitude,longitude);
                setResult(MapsActivity.RESULT_OK, intent);
                finish();
                Toast.makeText(DestinationActivity.this, "cell clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteProduct(){

    }

    private void displayListOfDestinatios() {
        Cursor cursor = databaseHelper.getAllDestinations();
        if(cursor.moveToFirst()){
            do {
                destinationList.add(new FavDestination(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getDouble(2),
                        cursor.getDouble(3),
                        cursor.getString(4)
                ));
            }while (cursor.moveToNext());
            cursor.close();
            destinationAdapter= new DestinationAdapter(this, R.layout.destination_list_layout, destinationList, databaseHelper);
            listView.setAdapter(destinationAdapter);

        }
    }
}