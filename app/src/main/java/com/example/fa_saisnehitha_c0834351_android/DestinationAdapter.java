package com.example.fa_saisnehitha_c0834351_android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DestinationAdapter extends ArrayAdapter {

    Context mContext;
    int layoutRes;
    List<FavDestination> destination;
    DatabaseHelper dbhelper;
    TextView tvAddress, tvLat, tvLng,tvDate;

    public DestinationAdapter( Context mContext, int layoutRes, List<FavDestination> places, DatabaseHelper db) {
        super(mContext, layoutRes,places);
        this.mContext = mContext;
        this.layoutRes = layoutRes;
        this.destination = places;
        this.dbhelper = db;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(layoutRes, null);
        tvAddress = v.findViewById(R.id.address);
        tvLat = v.findViewById(R.id.latitude);
        tvLng = v.findViewById(R.id.longitude);
        tvDate = v.findViewById(R.id.date);

        FavDestination favDestination = destination.get(position);
        tvAddress.setText(favDestination.getAddress());
        tvLat.setText(String.valueOf(favDestination.getLatitude()));
        tvLng.setText(String.valueOf(favDestination.getLongitude()));
        tvDate.setText(favDestination.getDate());
        return v;
    }

//    public void deleteplace(final FavDestination place) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//        builder.setTitle("Are you sure?");
//        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                if(dbhelper.deleteDestinations(place.getId()))
//                    displayDestinations();
//            }
//        });
//        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//            }
//        });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }

//    private void displayDestinations() {
//        Cursor cursor = dbhelper.getAllDestinations();
//
//        if(cursor.moveToFirst()){
//            destination.clear();
//            do{
//                destination.add(new FavDestination(
//                        cursor.getString(1),
//                        cursor.getDouble(2),
//                        cursor.getDouble(3),
//                        cursor.getString(4)
//                ));
//            }while (cursor.moveToNext());
//            cursor.close();
//        }
//        notifyDataSetChanged();
//    }


}
