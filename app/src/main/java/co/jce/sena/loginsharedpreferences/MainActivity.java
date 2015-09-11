package co.jce.sena.loginsharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View .OnClickListener {

    //-> Atributos (Componentes)
    private EditText etNumeroCedula;
    private EditText etContrasena;
    private CheckBox cbRecordar;
    private Button btnIngresar;


    //-> Atributos (Especiales)
    private Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
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
        etNumeroCedula = (EditText) findViewById( R .id .etNumeroCedula );
        etContrasena = ( EditText ) findViewById( R .id .etContrasena );
        cbRecordar = (CheckBox) findViewById( R .id .cbRecordar );
        btnIngresar = (Button) findViewById( R .id .btnIngresar );

        //-> Asignamos un manejador de Eventos al botón (Ingresar)
        btnIngresar .setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {

        if( v .getId() == R .id .btnIngresar ) {
            in = new Intent( this , PanelActivity.class );
            startActivity( in );
        }

    }

}
