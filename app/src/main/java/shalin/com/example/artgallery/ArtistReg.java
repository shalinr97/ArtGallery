package desai.com.example.artgallery;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ArtistReg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_reg);
        final EditText name=(EditText)findViewById(R.id.name);
        final EditText email=(EditText)findViewById(R.id.eid);
        final EditText pass=(EditText)findViewById(R.id.pass);
        final EditText age=(EditText)findViewById(R.id.age);
        final EditText style=(EditText)findViewById(R.id.style);
        final EditText city=(EditText)findViewById(R.id.city);
        Button reg=(Button)findViewById(R.id.Register);
        final String DB_NAME = "Art.db";
        final String TABLE_NAME = "Artist";
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
                db.execSQL("CREATE TABLE IF NOT EXISTS "
                        + TABLE_NAME
                        + "(Email TEXT primary key,name TEXT,Pass TEXT,age TEXT,city TEXT,style TEXT);");
                db.execSQL("INSERT INTO " + TABLE_NAME + "(Email,name, pass, age,city,style)VALUES('" + email.getText().toString() + "', '" + name.getText().toString() + "', '" + pass.getText() + "', '" + age.getText().toString() + "', '" + city.getText().toString() + "', '" + style.getText().toString()+"')");
                db.close();

                Toast.makeText(getApplicationContext(),"Registration Completed",Toast.LENGTH_LONG).show();;
                Intent i=new Intent(view.getContext(),ArtistPage.class);
                startActivity(i);

            }
        });
    }
}
