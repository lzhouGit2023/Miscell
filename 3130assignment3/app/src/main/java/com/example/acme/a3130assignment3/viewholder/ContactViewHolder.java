package com.example.acme.a3130assignment3.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.acme.a3130assignment3.R;

//We added more fields which are the other strings listed here besides name, email and id
public class ContactViewHolder extends RecyclerView.ViewHolder  {

    public TextView name;
    public TextView email;
    public TextView businessNumber;
    public TextView business;
    public TextView address;
    public TextView provinceOrTerritory;
    public Button detailsButton;

    public ContactViewHolder(View view)
    {
        super(view);
        name = view.findViewById(R.id.contactName);
        email = view.findViewById(R.id.contactEmail);
        businessNumber = view.findViewById(R.id.contactBusinessNumber);
        business = view.findViewById(R.id.contactBusiness);
        address = view.findViewById(R.id.contactAddress);
        provinceOrTerritory = view.findViewById(R.id.contactProvinceOrTerritory);

        detailsButton = view.findViewById(R.id.goDetails);

    }




}