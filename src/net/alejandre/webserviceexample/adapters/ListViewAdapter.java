package net.alejandre.webserviceexample.adapters;

import java.util.ArrayList;

import net.alejandre.webserviceexample.R;
import net.alejandre.webserviceexample.entities.Account;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ListViewAdapter extends ArrayAdapter<Account> {

	private int				rowLayout;
	private LayoutInflater	inflater;

	public ListViewAdapter(Context ctx, int resourceId, ArrayList<Account> objects) {
		
		super(ctx, resourceId, objects);
		rowLayout = resourceId;
		inflater = LayoutInflater.from(ctx);
	}
	public View getView(int position, View row, ViewGroup parent) {
		// row layout
		row = (RelativeLayout) inflater.inflate(rowLayout, null);
		// getting the object:
		Account a = getItem(position);
		
		TextView tv = (TextView) row.findViewById(R.id.lvrSocialNetwork);
		tv.setText(a.getWebsite());
		
		// returning the row formed:
		return(row);
	}
	
}

