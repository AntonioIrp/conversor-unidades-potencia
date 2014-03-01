package com.example.conversion;

import java.text.NumberFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConversorUnidades extends Activity {

	int seleccion;
	int decimales;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          	
        Spinner spinner=(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.unidades, android.R.layout.simple_spinner_item);
        
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() 
        {
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) 
            {
             Toast.makeText(parentView.getContext(), "Has seleccionado: " +
             parentView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
             
             long item_id=parentView.getItemIdAtPosition(position);
             seleccion=(int)item_id;
            }                  
            public void onNothingSelected(AdapterView<?> parentView) 
            {
            
            }    
        }); 
        
        //seleccion por defecto
        RadioGroup grupo=(RadioGroup)findViewById(R.id.radio_grupo);
        grupo.check(R.id.opcion1);
        decimales=2;
       
    }
    

    public void mostrar(View arg0)
    {
		EditText nombre = (EditText)findViewById(R.id.valor);
		RadioGroup grupo=(RadioGroup)findViewById(R.id.radio_grupo);
    	Double valor;
    	double vatio = 0, caballo_vapor = 0, dbw=0, dbm=0;
    	double mili_vatio=0,hp=0,kcalhora=0,kjulioshora=0;
        
        if(grupo.getCheckedRadioButtonId()==R.id.opcion1);
		{
			decimales=2;
		}
		if(grupo.getCheckedRadioButtonId()==R.id.opcion2)
        {
			decimales=3;
        }
		if(grupo.getCheckedRadioButtonId()==R.id.opcion3)
        {
			decimales=4;
        }
		if(grupo.getCheckedRadioButtonId()==R.id.opcion4)
        {
			decimales=5;
        }
    	int txt=nombre.getText().length();
    	
		if(txt==0)
		{
			
			Toast.makeText(this, "INSERTE UN VALOR PARA CONVERTIR", Toast.LENGTH_LONG).show();
			onCreate(null);
		}
		else
		{
			switch (seleccion)
	    	{
	    	case 0: //cv
	    		valor=Double.valueOf(nombre.getText().toString());    		
	    		vatio=valor*735.49875;
	       		break;
	    		
	    	case 1: //w
	    		valor=Double.valueOf(nombre.getText().toString());
	    		vatio=valor;
	    		break;
	    		
	    	case 2: //dbw
	    		valor=Double.valueOf(nombre.getText().toString());
	    		vatio=Math.pow(10, valor/10);
	    		break;
	    	
	    	case 3: //dbm
	    		valor=Double.valueOf(nombre.getText().toString());
	    		dbw=valor-30;
	    		vatio=Math.pow(10, dbw/10);
	    		break;
	    		
	    	case 4: //mw
	    		valor=Double.valueOf(nombre.getText().toString());
	    		vatio=valor/1000;
	    		break;
	    		
	    	case 5: //hp
	    		valor=Double.valueOf(nombre.getText().toString());
	    		vatio=valor*745.7;
	    		break;
	    		
	    
	    	}
	    	   
	    	dbw=10*java.lang.Math.log10(vatio);
			dbm=10*java.lang.Math.log10(vatio/0.001);
			caballo_vapor=vatio*0.0013596211551613;
			mili_vatio=vatio*1000;
			hp=vatio*0.0013410218586563;
			kcalhora=vatio*0.85980415572009;
			kjulioshora=vatio*3.6;
	    	
			
	    	//truncar decimales
	    	NumberFormat nf = NumberFormat.getInstance();
	    	nf.setMaximumFractionDigits(decimales);
	    	
	    	
	    	//preparacion de la activity: resultados
	    	Intent i = new Intent(this, Resultados.class);
	        i.putExtra("caballo_vapor", String.valueOf(nf.format(caballo_vapor)));
	        i.putExtra("vatio", String.valueOf(nf.format(vatio)));
	        i.putExtra("dbw", String.valueOf(nf.format(dbw)));
	        i.putExtra("dbm", String.valueOf(nf.format(dbm)));
	        i.putExtra("mw", String.valueOf(nf.format(mili_vatio)));
	        i.putExtra("hp", String.valueOf(nf.format(hp)));
	        i.putExtra("kcalhora", String.valueOf(nf.format(kcalhora)));
	        i.putExtra("kjulioshora", String.valueOf(nf.format(kjulioshora)));
	       
	        startActivity(i);  
		}
    	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
