package co.jce.sena.loginsharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View .OnClickListener {

    //-> Atributos (Componentes)
    private EditText etNumeroCedula;
    private EditText etContrasena;
    private CheckBox cbRecordar;
    private Button btnIngresar;

    //-> Atributos (Comunes)
    private String vNumeroCedula,
                   vContrasena;

    //-> Atributos (Constantes)
    private final static String GUARDADO = "guardado";

    //-> Atributos (Especiales)
    private SharedPreferences spSesion;
    private SharedPreferences.Editor spEditorSession;
    private Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //-> Valida si al iniciar el "Activity" hay valores guardados
        //   como datos de preferencia compartida o "SharedPreferences"
        if( spSesion .getBoolean( GUARDADO, false ) ) {
            Toast .makeText( MainActivity .this, "LLenar los campos", Toast .LENGTH_SHORT) .show();
        }
        else {
            Toast .makeText( MainActivity .this, "Limpiar los campos", Toast .LENGTH_SHORT) .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void init() {

        //-> Asignamos el nombre al archivo XML que alojará las preferencias y el nivel de seguridad del mismo
        spSesion = getSharedPreferences( "Sesion", MODE_PRIVATE );
        spEditorSession = spSesion .edit();     //: Se cambia la preferencia para que sea editable y se le asigna el editor.

        //-> Accedemos a los componentes del "Activity"
        etNumeroCedula = (EditText) findViewById( R .id .etNumeroCedula );
        etContrasena = ( EditText ) findViewById( R .id .etContrasena );
        cbRecordar = ( CheckBox ) findViewById( R .id .cbRecordar );
        btnIngresar = ( Button ) findViewById( R .id .btnIngresar );

        //-> Asignamos un manejador de Eventos al botón (Ingresar)
        btnIngresar .setOnClickListener( this );
    }

    private void extraerValores() {
        //-> Extraer los valores de los componentes del "Activity"
        vNumeroCedula = etNumeroCedula .getText() .toString();
        vContrasena = etContrasena .getText() .toString();
        Toast .makeText( this, "Valores extraidos son:\n" + vNumeroCedula + " / " + vContrasena, Toast .LENGTH_SHORT ) .show();
    }

    @Override
    public void onClick(View v) {

        if( v .getId() == R .id .btnIngresar ) {
            extraerValores();
            in = new Intent( this , PanelActivity.class );
            startActivity( in );
        }

    }

}
