package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.TextView;

public class DispayContact extends AppCompatActivity {


    private EditText conname;
    private EditText connumber;
    private EditText conmail;
    private Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispay_contact);
        conname=(EditText) findViewById(R.id.contactname);
        connumber=(EditText) findViewById(R.id.contactnumber);
        conmail=(EditText) findViewById(R.id.contactnumber);
        add=(Button)findViewById(R.id.addbtn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String coname=conname.getText().toString();
                String conum=connumber.getText().toString();
                String coema=conmail.getText().toString();
                Intent read=new Intent(getApplicationContext(),MainActivity.class);
                read.putExtra("Name",coname);
                read.putExtra("Number",conum);
                read.putExtra("Mail",coema);
                startActivity(read);
            }
        });
    }
}
