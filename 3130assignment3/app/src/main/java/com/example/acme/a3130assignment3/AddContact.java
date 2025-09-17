package com.example.acme.a3130assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.acme.a3130assignment3.model.Contact;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddContact extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private TextView business;
    private TextView address;
    private TextView businessNumber;
    private TextView provinceOrTerritory;

    //Created more fields and textviews for these fields and integrated them into method of adding a contact
    //We will also use the editTexts for these fields
    private Button addContact;

    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        name = findViewById(R.id.nameEdit);//make sure all of these are right!
        email = findViewById(R.id.emailEdit);
        business = findViewById(R.id.businessEdit);//make sure all of these are right!
        address = findViewById(R.id.addressEdit);
        businessNumber = findViewById(R.id.businessNumberEdit);//make sure all of these are right!
        provinceOrTerritory = findViewById(R.id.provinceEdit);

        database = FirebaseFirestore.getInstance();

        addContact = findViewById(R.id.addNew);
        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Contact c = new Contact(name.getText().toString(),email.getText().toString(),business.getText().toString()
                        ,address.getText().toString(),businessNumber.getText().toString(),provinceOrTerritory.getText().toString());

                //Here instead of adding directly we are first getting a reference so we save the ID;
                // this is not necessary but it will make life easier latter when editing/deleting.
                DocumentReference ref = database.collection("contacts").document();
                c.id = ref.getId();
                ref.set(c);

                //Finishes the acitivy and return to the parent one.
                finish();
            }
        });

    }
}