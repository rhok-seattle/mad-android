package org.rhok;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class RhokMad extends Activity {
	
	private static final int MENU_SUBMIT = 1;
	private static final int MENU_CLEAR = 2;
	
	private static final String BASE_URL = "http://10.0.1.41:3000/residences";
	
    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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
		}

		return true;
	}
    
    private void submit() {
    	//validate and populate shit
    	if(validate()) {
    		HttpClient httpclient = new DefaultHttpClient();  
    		HttpPost httppost = new HttpPost(BASE_URL);
    		
    	     try {  
    	         // Add your data  
    	         List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(22);
//    	         nameValuePairs.add(new BasicNameValuePair("residences_first_name", "test"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_last_name", "test"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_street_address_1", "test"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_street_address_2", "test"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_city", "Seattle"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_county", "King"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_zip_code", "98001"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_occupant_owner", "owner"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_estimated_predisaster_FMV_of_structure", "9001"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_estimated_structure_loss_in_dollars", "9001"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_estimated_personal_property_loss_in_dollars", "9001"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_primary_cause_of_damage", "Basement cat"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_type_of_insurance", "Dice"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_deductible", "5"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_is_habitable", "true"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_is_accessible", "true"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_category_of_damage", "Basement cat"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_description_of_damages", "Cheezburger"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_contact_name", "Prof HappyCat"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_contact_phone", "1111111111"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_contact_email", "test@chzb.gr"));
//    	         nameValuePairs.add(new BasicNameValuePair("residences_total_uninsured_loss", "9001"));
    	         
    	         nameValuePairs.add(new BasicNameValuePair("residence[first_name]", getEditText(R.id.firstName)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[last_name]", getEditText(R.id.lastName)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[street_address_1]", getEditText(R.id.address)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[street_address_2]", getEditText(R.id.address2)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[city]", getEditText(R.id.city)));
//    	         nameValuePairs.add(new BasicNameValuePair("residence[county]", getEditText(R.id.)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[zip_code]", getEditText(R.id.zip)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[occupant_owner]", getEditText(R.id.occupant)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[estimated_predisaster_FMV_of_structure]", getEditText(R.id.estpredistfmv)));
//    	         nameValuePairs.add(new BasicNameValuePair("residence[estimated_structure_loss_in_dollars]", getEditText(R.id.)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[estimated_personal_property_loss_in_dollars]", getEditText(R.id.estperproploss)));
//    	         nameValuePairs.add(new BasicNameValuePair("residence[primary_cause_of_damage]", getEditText(R.id.)));
//    	         nameValuePairs.add(new BasicNameValuePair("residence[type_of_insurance]", getEditText(R.id.)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[deductible]", getEditText(R.id.deductible)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[is_habitable]", getEditText(R.id.habitable)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[is_accessible]", getEditText(R.id.accessible)));
//    	         nameValuePairs.add(new BasicNameValuePair("residence[category_of_damage]", getEditText(R.id.)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[description_of_damages]", getEditText(R.id.description)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[contact_name]", getEditText(R.id.contact)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[contact_phone]", getEditText(R.id.phone)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[contact_email]", getEditText(R.id.email)));
    	         nameValuePairs.add(new BasicNameValuePair("residence[total_uninsured_loss]", getEditText(R.id.uninsured_loss)));


      
    	         httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    	   
    	         // Execute HTTP Post Request  
    	         HttpResponse response = httpclient.execute(httppost);  
    	         int status = response.getStatusLine().getStatusCode(); 
    	         
    	         if(status < 200 || status >= 300) {
    	        	 Log.e("rhok", "Opps");
    	         }
    	           
    	     } catch (ClientProtocolException e) {  
    	         // TODO Auto-generated catch block  
    	     } catch (IOException e) {  
    	         // TODO Auto-generated catch block  
    	     }  
    	}
    }
    
	private String getEditText(int id) {
		return ((EditText)super.findViewById(id)).getText().toString();
	}
    
    private boolean validate() {
    	return true;
    }
}