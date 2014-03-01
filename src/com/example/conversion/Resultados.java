package com.example.conversion;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class Resultados extends Activity implements android.widget.CompoundButton.OnCheckedChangeListener {

	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
              
        CheckBox check=(CheckBox)findViewById(R.id.checkBox1);
        check.setChecked(false);
        check.setOnCheckedChangeListener(this);
        
        Bundle bundle;
        TextView resultado_caballo_vapor=(TextView)findViewById(R.id.resultado_caballo_vapor);
        TextView resultado_vatio=(TextView)findViewById(R.id.resultado_vatio);
        TextView resultado_dbw=(TextView)findViewById(R.id.resultado_dbw);
        TextView resultado_dbm=(TextView)findViewById(R.id.resultado_dbm);
        TextView resultado_mw=(TextView)findViewById(R.id.resultado_mw);
        TextView resultado_hp=(TextView)findViewById(R.id.resultado_caballo_potencia);
        TextView resultado_kcalhoras=(TextView)findViewById(R.id.resultado_kcalhora);
        TextView resultado_kjulioshora=(TextView)findViewById(R.id.resultado_kjulioshora);
        
        
        
        bundle=getIntent().getExtras();
        resultado_caballo_vapor.setText(bundle.getString("caballo_vapor"));
        resultado_vatio.setText(bundle.getString("vatio"));
        resultado_dbw.setText(bundle.getString("dbw"));
        resultado_dbm.setText(bundle.getString("dbm"));
        resultado_mw.setText(bundle.getString("mw"));
        resultado_hp.setText(bundle.getString("hp"));
        resultado_kcalhoras.setText(bundle.getString("kcalhora"));
        resultado_kjulioshora.setText(bundle.getString("kjulioshora"));

    }    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_resultados, menu);
        return true;
    }

    
    
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) 
	{
		if(isChecked)
    	{
    		TextView caballo_vapor=(TextView)findViewById(R.id.caballo_vapor);
    		caballo_vapor.setText(R.string.caballo_vapor);
    		
    		TextView vatio=(TextView)findViewById(R.id.vatio);
    		vatio.setText(R.string.vatio);
    		
    		TextView decvatio=(TextView)findViewById(R.id.dbw);
    		decvatio.setText(R.string.decibelio_vatio);
    		
    		TextView decmvatio=(TextView)findViewById(R.id.dbm);
    		decmvatio.setText(R.string.decibelio_mw);
    		
    		TextView mvatio=(TextView)findViewById(R.id.mw);
    		mvatio.setText(R.string.milivatio);
    		
    		TextView hp=(TextView)findViewById(R.id.hp);
    		hp.setText(R.string.caballo_potencia);
    		
    		TextView kcalhora=(TextView)findViewById(R.id.kcalhora);
    		kcalhora.setText(R.string.kcalhora);
    		
    		TextView kjulioshora=(TextView)findViewById(R.id.kjulioshora);
    		kjulioshora.setText(R.string.kjulioshora);
    	}
		else
		{
			TextView caballo_vapor=(TextView)findViewById(R.id.caballo_vapor);
    		caballo_vapor.setText(R.string.comp_caballo_vapor);
    		
    		TextView vatio=(TextView)findViewById(R.id.vatio);
    		vatio.setText(R.string.comp_vatio);
    		
    		TextView decvatio=(TextView)findViewById(R.id.dbw);
    		decvatio.setText(R.string.comp_decibelio_vatio);
    		
    		TextView decmvatio=(TextView)findViewById(R.id.dbm);
    		decmvatio.setText(R.string.comp_decibelio_mw);
    		
    		TextView mvatio=(TextView)findViewById(R.id.mw);
    		mvatio.setText(R.string.comp_milivatio);
    		
    		TextView hp=(TextView)findViewById(R.id.hp);
    		hp.setText(R.string.comp_caballo_potencia);
    		
    		TextView kcalhora=(TextView)findViewById(R.id.kcalhora);
    		kcalhora.setText(R.string.comp_kcalhora);
    		
    		TextView kjulioshora=(TextView)findViewById(R.id.kjulioshora);
    		kjulioshora.setText(R.string.comp_kjulioshora);
		}
		
	}
    
}
