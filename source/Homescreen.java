package com.example.bussinessanalsis;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class Homescreen  extends Activity{
	Button additem,viewitem,graph,settings;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_screen);
		additem= (Button)findViewById(R.id.add_item);
		viewitem=(Button)findViewById(R.id.viewitem);
		additem.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Homescreen.this,Additems.class);
				startActivity(i);
			}
		});
		viewitem.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Homescreen.this,ViewItemsList.class);
				startActivity(i);
			}
		});
	
			    }
			}

