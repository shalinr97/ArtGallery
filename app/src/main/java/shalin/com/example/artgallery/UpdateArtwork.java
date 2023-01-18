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

public class UpdateArtwork extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_artwork);
        Button update=(Button)findViewById(R.id.Update);

        final EditText name=(EditText)findViewById(R.id.name);
        final EditText amt=(EditText)findViewById(R.id.amount);
        final EditText year=(EditText)findViewById(R.id.year);
        final EditText email=(EditText)findViewById(R.id.eid);
        final EditText id=(EditText)findViewById(R.id.gid);

        final String DB_NAME = "Art.db";
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
                final String TABLE_NAME = "Artwork";
                db.execSQL("CREATE TABLE IF NOT EXISTS "
                        + TABLE_NAME
                        + "(email TEXT primary key,gallery_id integer,name TEXT,amount TEXT,year TEXT,foreign key(gallery_id)references ArtGal(gallery_id),foreign key(email)references Artist(Email));");
                db.execSQL("INSERT INTO " + TABLE_NAME + "(email,gallery_id,name, amount, year)VALUES('" + email.getText().toString() + "','" + id.getText().toString() + "','" + name.getText().toString() + "', '" + amt.getText().toString() + "', '" + year.getText() + "')");
                db.close();
                Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();
            }
        });
        Button back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Registration.class);
                startActivity(i);
            }
        });

    }
}
