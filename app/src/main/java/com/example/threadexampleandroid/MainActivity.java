package com.example.threadexampleandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	int count =0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void oneClick(View v) {
		startActivity(new Intent(getApplicationContext(),NewActivity.class));
	}

	public void twoClick(View v) {

		Thread th= new Thread(new Runnable() {
			@Override
			public void run() {
				for(;;){
					System.out.println("Thread"+count++);
					if(count>100000){
						break;
					}
				}

				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						Toast.makeText(getApplicationContext(), "Finished Loop", Toast.LENGTH_LONG).show();

					}
				});
			}
		});
		th.start();
	}
}