package org.rhok;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.ViewFlipper;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class RhokMad extends Activity 
	implements OnClickListener, DatePickerDialog.OnDateSetListener {
	
	private static final int MENU_SUBMIT = 1;
	private static final int MENU_CLEAR = 2;
	private static final int ID_DATEPICKER = 1;
	private static final String BASE_URL = "http://192.168.1.130:3000/residences";
	
	private Button next;
	private Button prev;
	private TextView dateField;
	private ViewFlipper flipper;
	private int pageCount;
	private int currPage;
	
	private static final String[] titles = {
		"MadPub: Eneter Contact Info",
		"MadPub: Damage Report"
	};
	
    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        super.setTitle("MadPub: Enter Contact Info");
        
        next = (Button)findViewById(R.id.nextButton);
        prev = (Button)findViewById(R.id.prevButton);
        dateField = (TextView)findViewById(R.id.date);
        next.setOnClickListener(this);
        prev.setOnClickListener(this);
        dateField.setOnClickListener(this);
        flipper = (ViewFlipper)findViewById(R.id.flipper);
        pageCount = flipper.getChildCount();
    }
    
    
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, MENU_SUBMIT, 0, "Submit Form");
		menu.add(Menu.NONE, MENU_CLEAR, 0, "Clear Form");
		return true;
	}
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == MENU_SUBMIT) {
			submit();
		} else { // if(item.getItemId() == MENU_CLEAR)
			// TODO
		}

		return true;
	}
    
    private void submit() {
    	//validate and populate shit
    	validate();
		HttpClient httpclient = new DefaultHttpClient();  
		HttpPost httppost = new HttpPost(BASE_URL);
		
		boolean success = true;
		
	     try {  
	         // Add your data  
	         List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(22);
	         
//	         nameValuePairs.add(new BasicNameValuePair("residence[first_name]", getEditText(R.id.firstName)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[last_name]", getEditText(R.id.lastName)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[street_address_1]", getEditText(R.id.address)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[street_address_2]", getEditText(R.id.address2)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[city]", getEditText(R.id.city)));
////    	         nameValuePairs.add(new BasicNameValuePair("residence[county]", getEditText(R.id.)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[zip_code]", getEditText(R.id.zip)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[occupant_owner]", getEditText(R.id.occupant)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[estimated_predisaster_FMV_of_structure]", getEditText(R.id.estpredistfmv)));
////    	         nameValuePairs.add(new BasicNameValuePair("residence[estimated_structure_loss_in_dollars]", getEditText(R.id.)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[estimated_personal_property_loss_in_dollars]", getEditText(R.id.estperproploss)));
////    	         nameValuePairs.add(new BasicNameValuePair("residence[primary_cause_of_damage]", getEditText(R.id.)));
////    	         nameValuePairs.add(new BasicNameValuePair("residence[type_of_insurance]", getEditText(R.id.)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[deductible]", getEditText(R.id.deductible)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[is_habitable]", getEditText(R.id.habitable)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[is_accessible]", getEditText(R.id.accessible)));
////    	         nameValuePairs.add(new BasicNameValuePair("residence[category_of_damage]", getEditText(R.id.)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[description_of_damages]", getEditText(R.id.description)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[contact_name]", getEditText(R.id.contact)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[contact_phone]", getEditText(R.id.phone)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[contact_email]", getEditText(R.id.email)));
//	         nameValuePairs.add(new BasicNameValuePair("residence[total_uninsured_loss]", getEditText(R.id.uninsured_loss)));
  
	         httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	   
	         // Execute HTTP Post Request  
	         HttpResponse response = httpclient.execute(httppost);  
	         int status = response.getStatusLine().getStatusCode(); 
	         
	         if(status < 200 || status >= 300) {
	        	 success = false;
	        	 Log.e("rhok", "Opps");
	         }
	           
	     } catch (ClientProtocolException e) {
	    	 success = false;
	         Log.e("rhok", e.getMessage());  
	     } catch (IOException e) {
	    	 success = false;
	    	 Log.e("rhok", e.getMessage());
	     }
	     
	     if(!success) {
	    	 //OH NOES!!!!
	     }
    }
    
	private String getEditText(int id) {
		return ((TextView)super.findViewById(id)).getText().toString();
	}
    
    private boolean validate() {
    	return true;
    }

	@Override
	public void onClick(View view) {
		if(view == next) {
			flipper.showNext();
			currPage = (currPage + 1) % pageCount;
			super.setTitle(titles[currPage]);
		} else if(view == prev) {
			flipper.showPrevious();
			currPage = (currPage - 1) % pageCount;
			super.setTitle(titles[currPage]);
		} else if (view == dateField) {
			showDialog(ID_DATEPICKER);
		}
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		Calendar c = Calendar.getInstance();
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		return new DatePickerDialog(this, this, year, month, day);
	}

	@Override
	public void onDateSet(DatePicker dp, int year, int month, int day) {
		this.dateField.setText(month + "/" + day + "/" + year);
	}
}