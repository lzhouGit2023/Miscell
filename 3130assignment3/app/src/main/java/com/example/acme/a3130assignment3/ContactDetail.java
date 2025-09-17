package com.example.acme.a3130assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.acme.a3130assignment3.model.Contact;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ContactDetail extends AppCompatActivity {
    //Created more textviews for other fields and integrated them into the delete and update methods
    private TextView name;
    private TextView email;
    private TextView business;
    private TextView address;
    private TextView businessNumber;
    private TextView provinceOrTerritory;

    private Button delete;
    private Button update;

    private FirebaseFirestore database;
    private Intent intent;
    private Contact contact;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_detail);

        name = findViewById(R.id.nameEdit);
        email = findViewById(R.id.emailEdit);
        business = findViewById(R.id.businessEdit);
        address = findViewById(R.id.addressEdit);
        businessNumber = findViewById(R.id.businessNumberEdit);
        provinceOrTerritory = findViewById(R.id.provinceEdit);

        delete = findViewById(R.id.deleteButton);
        update = findViewById(R.id.updateButton);

        database = FirebaseFirestore.getInstance();

        intent = getIntent();

        contact = (Contact)intent.getSerializableExtra("contact");
        name.setText(contact.name);
        email.setText(contact.email);
        business.setText(contact.business);
        address.setText(contact.address);
        businessNumber.setText(contact.businessNumber);
        provinceOrTerritory.setText(contact.provinceOrTerritory);
        id = contact.id;

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContact();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });



    }

    //TODO: add the logic for updating an entry
    private void updateContact()
    {
        database.collection("contacts").document(id).update("email", email.getText().toString());
        database.collection("contacts").document(id).update("name", name.getText().toString());
        database.collection("contacts").document(id).update("business", business.getText().toString());
        database.collection("contacts").document(id).update("address", address.getText().toString());
        database.collection("contacts").document(id).update("businessNumber", businessNumber.getText().toString());
        database.collection("contacts").document(id).update("provinceOrTerritory", provinceOrTerritory.getText().toString());
        finish();
    }

    //TODO: add the logic for deleting an entry
    private void deleteContact()
    {
        database.collection("contacts").document(id).delete();
        //finishes the activity
        finish();

    }
}
