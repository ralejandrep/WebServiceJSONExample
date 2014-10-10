package net.alejandre.webserviceexample;

import net.alejandre.webserviceexample.entities.Account;
import net.alejandre.webserviceexample.entities.User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class InfoActivity extends Activity {
	
	private Account account;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		
		getIntentData();
		
		setTitle(account.getWebsite());
		
		User user = account.getUser();
		
		((TextView) findViewById(R.id.tvUsername)).setText(user.getUsername());
		((TextView) findViewById(R.id.tvPassword)).setText(user.getPassword());
		((TextView) findViewById(R.id.tvMail)).setText(user.getEmail());
		
		
		ListView lv = (ListView) findViewById(R.id.lvInfo);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        android.R.layout.simple_list_item_1, account.getInfo());
		
		lv.setAdapter(adapter);
				
		
		
	}

	private void getIntentData() {
		 Intent i = getIntent();
		 account = (Account) i.getExtras().get("account");
	}

}
