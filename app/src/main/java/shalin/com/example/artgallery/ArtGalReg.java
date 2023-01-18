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

public class ArtGalReg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_gal_reg);
        final EditText name=(EditText)findViewById(R.id.name);
        final EditText id=(EditText)findViewById(R.id.eid);
        final EditText pass=(EditText)findViewById(R.id.pass);
        final EditText location=(EditText)findViewById(R.id.location);
        Button reg=(Button)findViewById(R.id.Register);
        final String DB_NAME = "Art.db";
        final String TABLE_NAME = "ArtGal";
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
                db.execSQL("CREATE TABLE IF NOT EXISTS "
                        + TABLE_NAME
                        + "(name TEXT,gallery_id integer primary key,Pass TEXT,location TEXT);");
                db.execSQL("INSERT INTO " + TABLE_NAME + "(name,gallery_id,pass,location)VALUES('" + name.getText().toString() + "', '" + id.getText().toString() + "', '" + pass.getText() + "', '" + location.getText().toString() + "')");
                db.close();
                Toast.makeText(getApplicationContext(),"Registration Completed",Toast.LENGTH_LONG).show();
                Intent i=new Intent(view.getContext(),ArtGalPage.class);
                startActivity(i);


            }
        });

    }
}
