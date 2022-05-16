package sg.edu.np.mad.hanisah.listactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating the alert
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                int min = 0;
                int max = 100;

                //Generate random int value from 0 to 100
                int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

                //transferring data to next activity
                Intent activityName = new Intent(MainActivity.this, PracWeek2.class);
                activityName.putExtra("RandomInt", random_int);
                startActivity(activityName);
                //setContentView(R.layout.pracweek2);
            }
        });
        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
            }
        });

        //making the img interactable
        ImageView img = findViewById(R.id.imageView4);
        img.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View V)
            {
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}