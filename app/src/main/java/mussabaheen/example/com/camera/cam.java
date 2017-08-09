package mussabaheen.example.com.camera;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class cam extends AppCompatActivity {
    EditText txt;
    EditText txt2;
    EditText txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);
        txt=(EditText) findViewById(R.id.e1);
        txt2=(EditText)findViewById(R.id.e2);
        txt3=(EditText)findViewById(R.id.e3);
    }

    public void web(View view) {
        String a=txt.getText().toString();
        Uri web=Uri.parse(a);
        Intent i1= new Intent(Intent.ACTION_VIEW,web);
        startActivity(i1);
    }


    public void loc(View view) {
        String b=txt2.getText().toString();
        Uri c=Uri.parse("geo:0,0?q="+b);
        Intent i3=new Intent(Intent.ACTION_VIEW,c);
        startActivity(i3);
    }

    public void sharee(View view) {
        String c=txt3.getText().toString();
        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setChooserTitle("Share this text with: ")
                .setText(c)
                .startChooser();


    }

    public void came(View view) {
        Intent i2= new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        startActivity(i2);
    }
}
