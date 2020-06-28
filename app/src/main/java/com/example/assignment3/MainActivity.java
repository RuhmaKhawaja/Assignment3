package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText pname;
    EditText pemail;

    Button b1;
    Button signin;
    private RecyclerView myRecyclerview;
    private TextView conn;
    private TextView connum;
    private TextView conm;
    private ArrayList<Contact> mContact=new ArrayList<>();


    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pname = (EditText) findViewById(R.id.ava);
        pemail = (EditText) findViewById(R.id.email);
        signin=(Button)findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MainActivity.this, signin.class);
                startActivity(i2);
            }
        });

        b1 = (Button) findViewById(R.id.reg2);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        View editText;
        awesomeValidation.addValidation(this, R.id.ava, RegexTemplate.NOT_EMPTY, R.string.invalid_name);

        awesomeValidation.addValidation(this, R.id.email, Patterns.EMAIL_ADDRESS, R.string.invalid_email);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()) {
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }


        });
        conn=(TextView)findViewById(R.id.contactname);
        connum=(TextView)findViewById(R.id.contactnumber);
        conm=(TextView)findViewById(R.id.contactemail);
        Intent i=getIntent();
        String conna=i.getStringExtra("Name");
        String connu=i.getStringExtra("Number");
        String conma=i.getStringExtra("E-mail");
        conn.setText(conna);
        connum.setText(connu);
        conm.setText(conma);


        myRecyclerview =(RecyclerView)findViewById(R.id.contactlist);
        LinearLayoutManager mLayoutmanager =new LinearLayoutManager(this);
        mLayoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerview.setLayoutManager(mLayoutmanager);
        //Create List

        mContact.add(new Contact("Alex sin",R.drawable.ic_add));
        mContact.add(new Contact("Anna",R.drawable.ic_add));
        mContact.add(new Contact("Omaima Ali",R.drawable.omaima));
        mContact.add(new Contact("John",R.drawable.ic_add));
        mContact.add(new Contact("Ruhma Khawaja",R.drawable.ruhma));
        mContact.add(new Contact("Saira Sabir",R.drawable.saira));
        mContact.add(new Contact("Wajeeha Iqbal",R.drawable.wajeeha));
        mContact.add(new Contact("Menu Item",R.drawable.ic_add));
        mContact.add(new Contact("Menu Item",R.drawable.ic_add));
        mContact.add(new Contact("Menu Item",R.drawable.ic_add));
        mContact.add(new Contact("Menu Item",R.drawable.ic_add));
        mContact.add(new Contact("Menu Item",R.drawable.ic_add));
        mContact.add(new Contact("Menu Item",R.drawable.ic_add));
        mContact.add(new Contact("Menu Item",R.drawable.ic_add));
        mContact.add(new Contact("Menu Item",R.drawable.ic_add));
        mContact.add(new Contact("Menu Item",R.drawable.ic_add));
        mContact.add(new Contact("Menu Item",R.drawable.ic_add));
        mContact.add(new Contact("Menu Item",R.drawable.ic_add));
        mContact.add(new Contact("Menu Item",R.drawable.ic_add));
        mContact.add(new Contact("Menu Item",R.drawable.ic_add));
        mContact.add(new Contact("Menu Item",R.drawable.ic_add));
        mContact.add(new Contact("Menu Item",R.drawable.ic_add));
        //Set Adapter
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(mContact);
        myRecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

}



