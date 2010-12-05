package org.rhok;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class RhokMad extends Activity {
	
	private static final int MENU_SUBMIT = 1;
	private static final int MENU_CLEAR = 2;
	
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
		// if(item.getItemId() == MENU_SUBMIT)
		// submit stuff
		return true;
	}
    
    private void submit() {
    	//validate and populate shit
    	LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    	lm.getLastKnownLocation();
    }
}