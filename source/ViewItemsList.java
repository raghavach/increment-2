package com.example.bussinessanalsis;

import java.util.ArrayList;
import java.util.List;

import com.example.bussinessanalsis.database.DataBaseConector;


import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class ViewItemsList  extends Activity{
	 DataBaseConector dbconnector;
	 ListView list;
	 ItemsDetails itemdetails;
	 private ArrayAdapter<String> listAdapter ; 
	 String result;
	  ArrayList<String> lists = new ArrayList<String>();;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_item_list);
        list=(ListView)findViewById(R.id.listView1);
        dbconnector=new DataBaseConector(this);
      
       
    	SharedPreferences prefs = getSharedPreferences("", MODE_PRIVATE); 
		String userid = prefs.getString("userid", "");
		List<ItemsDetails>	itemlist=dbconnector.getAllItems(userid);
		itemdetails=new ItemsDetails();
		
		for( ItemsDetails itemdetails:itemlist)
		{  String tag= itemdetails.getPrice();
		String Date=	itemdetails.getDate();
		String Discription=	itemdetails.getDiscrption();
		String sppinerval	=itemdetails.getSppinervalue();
		String notes=itemdetails.getNote();
		String Price=itemdetails.getTag();
		result=Date+""+" "+sppinerval +" "+" Price:"+Price+"\n"+"Description:"+Discription+" "+"tag:"+tag;
	// result=Date+" "+price+";"+Discription+";"+sppinerval+";"+notes+";"+sppinerval;
		Log.i("the result values",result);
		lists.add(result);
		}
		
		
		
		//String result =discrption+";"+price+";"+tag+";"+note+";"+date+";"+sppinervalue;*/
		ArrayAdapter adapter1=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,lists);
		list.setAdapter(adapter1);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				final String  selecteditem=list.getItemAtPosition(arg2).toString();
				AlertDialog.Builder adb=new AlertDialog.Builder(ViewItemsList.this);
				adb.setTitle("Task Details");
				adb.setMessage("Selected ITEMS "+"\n"+list.getItemAtPosition(arg2));
				Log.i("Selected item",list.getItemAtPosition(arg2).toString());
			//	final String  selecteditem=list.getItemAtPosition(arg2).toString();
				adb.setNegativeButton("Edit", new DialogInterface.OnClickListener() {
				
	                public void onClick(DialogInterface dialog,int id) {

	                    // go to a new activity of the app

	                    Intent positveActivity = new Intent(getApplicationContext(),

	                            EditActivity.class);
	                    
	                    positveActivity.putExtra("result",selecteditem) ;
	                    startActivity(positveActivity);
	                   

	                }

	              });
				adb.setPositiveButton("Delete", new DialogInterface.OnClickListener() {

	                public void onClick(DialogInterface dialog,int id) {

	                    // go to a new activity of the app

	                    Intent positveActivity = new Intent(getApplicationContext(),

	                            EditActivity.class);

	                    startActivity(positveActivity);

	                }

	              });
				adb.show();
				
				
			}
		});
		Log.i("the result values+",itemdetails.toString());
		
		
	}

}
