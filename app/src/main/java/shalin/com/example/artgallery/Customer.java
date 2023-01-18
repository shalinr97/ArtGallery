package desai.com.example.artgallery;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog.Builder;
import android.widget.Toast;

public class Customer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        final EditText name=(EditText)findViewById(R.id.name);
        final EditText email=(EditText)findViewById(R.id.eid);
        final EditText pass=(EditText)findViewById(R.id.pass);
        final EditText age=(EditText)findViewById(R.id.age);
        final EditText phone=(EditText)findViewById(R.id.phone);
        Button reg=(Button)findViewById(R.id.Register);
        final String DB_NAME = "Art.db";
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
                final String TABLE_NAME = "Customer";
                db.execSQL("CREATE TABLE IF NOT EXISTS "
                                + TABLE_NAME
                                + "(Email TEXT primary key,name TEXT,Pass TEXT,age TEXT,phone TEXT);");
                db.execSQL("INSERT INTO " + TABLE_NAME + "(Email,name, pass, age, phone)VALUES('" + name.getText().toString() + "', '" + email.getText().toString() + "', '" + pass.getText() + "', '" + age.getText().toString() + "', '" + phone.getText().toString() + "')");
                 Toast.makeText(getApplicationContext(),"Registration Completed", Toast.LENGTH_LONG).show();;
                Intent i=new Intent(view.getContext(),CustPage.class);
                startActivity(i);
                db.close();
            }
        });
    }
}
