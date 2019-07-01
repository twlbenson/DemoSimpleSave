package c346.rp.edu.demosimplesave;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("greetings", "Hello!");

        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //String msg = "No Greeting";

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String msg = prefs.getString("greeting", "no greeting");


        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
}
