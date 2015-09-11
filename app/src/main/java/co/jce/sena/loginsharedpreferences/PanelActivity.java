package co.jce.sena.loginsharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jce on 11/09/15.
 */
public class PanelActivity extends AppCompatActivity {

    //-> Atributos (Componentes)
    private TextView tvBienvenida;

    //-> Atributos (Especiales)
    private SharedPreferences spSesion;

    //-> Atributos (Comunes)
    private String vNumeroCedula,
                   vContrasena,
                   vBienvenida;
    private boolean estaGuardo = false;

    //-> Atributos (Constantes)
    private final static String ID_USUARIO = "id_usuario",
                                CLAVE_USUARIO = "clave_usuario",
                                GUARDADO = "guardado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);
        init();

        //-> Valida si al iniciar el "Activity" hay valores guardados
        //   como datos de preferencia compartida o "SharedPreferences"
        if( spSesion .getBoolean( GUARDADO, false ) ) {
            Toast.makeText( PanelActivity .this, "Existen valores guardados \ncomo preferencias compartidas", Toast .LENGTH_SHORT) .show();
        }
        else {
            Toast .makeText( PanelActivity .this, "No existen valores guardados", Toast .LENGTH_SHORT) .show();
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
        //-> Accedemos a los componentes del "Activity"
        tvBienvenida = ( TextView ) findViewById( R .id .tvBienvenida );
        //-> Asignamos el nombre al archivo XML que aloja las preferencias y el nivel de seguridad del mismo
        spSesion = getSharedPreferences( "Sesion", MODE_PRIVATE );

        //#> Mensajes de log en consola
        Log .e( "spSesion", spSesion + "");
        Log .e( "spSesion", spSesion .getString( ID_USUARIO, "" ) + "" );
        Log .e( "spSesion", spSesion .getString( CLAVE_USUARIO, "" ) + "" );
        Log .e( "spSesion", spSesion .getBoolean( GUARDADO, false ) + "" );

        //-> Se obtiene la cadena del objeto de preferencias compartidas "spSesion"
        vNumeroCedula = spSesion .getString( ID_USUARIO, "" );
        vContrasena = spSesion .getString( CLAVE_USUARIO, "" );

        //-> Valida las cadenas de datos vienen vacias
        if( vNumeroCedula .equals( "" ) && vContrasena .equals( "" ) ) {
            tvBienvenida .setText( "Ups! No recordé los datos" );
        }
        else {
            tvBienvenida .setText( "Te recuerdo, tus datos son:\n - " + vNumeroCedula + "\n - " + vContrasena );
        }

    }


}
