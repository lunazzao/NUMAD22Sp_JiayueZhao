package edu.neu.madcourse.numad22sp_jiayuezhao;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;

public class ItemCard implements ItemClickListener {

    private final String itemName;
    private final String itemDesc;
    //Constructor
    public ItemCard(String itemName, String itemDesc) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
    }

    //Getters for the imageSource, itemName and itemDesc

    public String getItemDesc() {
        return itemDesc;
    }

    public String getItemName() {
        return itemName ;
    }




    @Override
    public void onItemClick(int position) {


    }




}
