package net.alejandre.webserviceexample;

import java.util.ArrayList;

import net.alejandre.downloaders.Downloader;
import net.alejandre.json.JsonToObject;
import net.alejandre.webserviceexample.adapters.ListViewAdapter;
import net.alejandre.webserviceexample.entities.Account;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class MainActivity extends ListActivity {

	public String Stringresult;
	private ProgressDialog pd;
	public ArrayList<Account> lista;
	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("init","init");
		lv = this.getListView();

		pd=ProgressDialog.show(this, null, "Downloading ...", true, false);
		new MyThread().execute();

		// putting the listview click listener:
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Intent i = new Intent();
				i.setClass(MainActivity.this, InfoActivity.class);
				i.putExtra("account", lista.get(position));
				startActivity(i);
				
			}
		});
		
	}

	private class MyThread extends AsyncTask<String, Integer, Long> {

		@SuppressWarnings("unchecked")
		@Override
		protected Long doInBackground(String... arg0) {
			// object to download the data from internet.
			Downloader down = new Downloader();
			// downloading in this case text. TODO pon la ip de tu equipo aqui.
			Stringresult = down.methodGet("http://192.168.1.134/pruebas-java/stored_users.html");
			//Log.e("JSON", Stringresult);
			
			// this method will be called if the json does not have tag for the array of objects.
			//			lista = (List<Categoria>) new JsonToObject(null)
			//															.jsonToObj(Stringresult, Categoria.class);
			// this method will be called if the json has the tag to identify the array of objects.
			lista = (ArrayList<Account>) new JsonToObject(MainActivity.this,"accounts")
			.jsonToList(Stringresult, Account.class);
			return null;
		}

		@Override
		protected void onPostExecute(Long result) {
			
			// adding the adapter to the list view:
			ListViewAdapter adapter = new ListViewAdapter(MainActivity.this, R.layout.lvrow, lista);
			lv.setAdapter(adapter);
			// closing the dialog:
			pd.dismiss();
			super.onPostExecute(result);
		}
	}

}
