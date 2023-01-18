package desai.com.example.artgallery;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CustPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_page);
        Button view=(Button)findViewById(R.id.View);
        Button artg=(Button)findViewById(R.id.Artgal);
        Button loc=(Button)findViewById(R.id.Location);
        final String DB_NAME = "Art.db";
        final SQLiteDatabase db=openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        final String TABLE_NAME = "Artwork";
        final String TABLE_NAME1 = "Artist";
        Button back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Registration.class);
                startActivity(i);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor result=db.rawQuery("Select * from " + TABLE_NAME ,null);
                StringBuffer buffer=new StringBuffer();
                while(result.moveToNext())
                {
                    buffer.append("Name: "+result.getString(2)+"\n");
                    buffer.append("Amount: "+result.getString(3)+"\n");
                    buffer.append("Year: "+result.getString(4)+"\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(CustPage.this);
                builder.setCancelable(true);
                builder.setTitle("All Artworks");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        artg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result=db.rawQuery("Select * from Artwork a,Artist b where a.email=b.Email and b.style='Contemporary'",null);
                StringBuffer buffer=new StringBuffer();
                while(result.moveToNext())
                {
                    buffer.append("Name: "+result.getString(2)+"\n");
                    buffer.append("Amount: "+result.getString(3)+"\n");
                    buffer.append("Year: "+result.getString(4)+"\n");
                    buffer.append("Artist Name: "+result.getString(6)+"\n");
                    buffer.append("Style: "+result.getString(10)+"\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(CustPage.this);
                builder.setCancelable(true);
                builder.setTitle("Style:Contemprorary");
                builder.setMessage(buffer.toString());
                builder.show();


            }
        });
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result=db.rawQuery("Select * from ArtGal where location='Mumbai'" ,null);
                StringBuffer buffer=new StringBuffer();
                while(result.moveToNext())
                {
                    buffer.append("Name: "+result.getString(0)+"\n");
                    buffer.append("Location: "+result.getString(3)+"\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(CustPage.this);
                builder.setCancelable(true);
                builder.setTitle("Art Gallery:Mumbai");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
    }
}