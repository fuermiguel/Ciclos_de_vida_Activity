package ciclodevidaactivity.android.miguel.net.ciclos_de_vida_activity;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        SuperActivityToast.create(this, new Style(), Style.TYPE_BUTTON)
                .setButtonText("UNDO")
                .setOnButtonClickListener("good_tag_name", null, null)
                .setProgressBarColor(Color.WHITE)
                .setText("Email deleted")
                .setDuration(Style.DURATION_LONG)
                .setFrame(Style.FRAME_LOLLIPOP)
                .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_PURPLE))
                .setAnimations(Style.ANIMATIONS_POP).show();



        /**manejando un intent de manera implicita**/
        // Create the text message with a string
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        //sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Mensaje enviado con el intent");
        sendIntent.setType("text/plain");

        //Usar siempre recursos para poner texto en la interface gráfica
        //De esta forma utilizando un chooser, siempre saldrá una ventana de selección
        //  de aplicación con la que llevar acabo el intent
        String title = getResources().getString(R.string.app_name);
        // Create intent to show the chooser dialog
        Intent chooser = Intent.createChooser(sendIntent, title);


        // Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }

        /**manejando un intent de manera implicita**/
        // Crear una alarma
        Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM);
                alarma.putExtra(AlarmClock.EXTRA_MESSAGE, "cocooco");
                alarma.putExtra(AlarmClock.EXTRA_HOUR, 12);
                alarma.putExtra(AlarmClock.EXTRA_MINUTES, 0);
        if (alarma.resolveActivity(getPackageManager()) != null) {
            startActivity(alarma);
        }

        }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(this, "onSaveInstanceState", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Toast.makeText(this, "onRestoreInstanceState", Toast.LENGTH_SHORT).show();
    }
}
