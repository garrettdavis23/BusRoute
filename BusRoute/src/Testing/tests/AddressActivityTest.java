package Testing.tests;

import com.example.busroute.AddressActivity;
import com.example.busroute.R;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

public class AddressActivityTest extends ActivityInstrumentationTestCase2<AddressActivity>{

		private AddressActivity mAddressActivityTest;
	    private Button mFirstTestText;
	    
	    private int addressEntry;

	    public AddressActivityTest() {
	        super(AddressActivity.class);
	    }

	    @Override
	    protected void setUp() throws Exception {
	        super.setUp();
	        mAddressActivityTest = getActivity();
	        mFirstTestText = (Button) mAddressActivityTest.findViewById(R.id.saveAddressButton);	        
	    }
	    
	    public void testInstructions() {

	    	addressEntry = com.example.busroute.R.id.addressField;
	    	EditText address = (EditText) mAddressActivityTest.findViewById(addressEntry);
	    	assertTrue("Address Entry wasn't blank", address.toString() != "");
	      }

}
