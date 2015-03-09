package com.example.threadexampleandroid;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class NewActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
	}

	public void asyncTaskStartClicked(View v) {
		MyAsyncTask myObj=new MyAsyncTask();
		myObj.execute("Ok Start");
	}

	class MyAsyncTask extends AsyncTask<String, Integer, String>{

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			Toast.makeText(getApplicationContext(), "AsyncTask Started", Toast.LENGTH_SHORT).show();

		}

		@Override
		protected String doInBackground(String... params) {
			int count=0;
			for(;;){
				System.out.println("Thread"+count++);
				if(count>100000){

					break;
				}else if(count==2424){
					publishProgress(2424);
				}

			}
			return "Completed doInBackground()";
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			Toast.makeText(getApplicationContext(), "Updating Progress Update", Toast.LENGTH_SHORT).show();
			if(values[0]==2424){
				Toast.makeText(getApplicationContext(), "My Fav No", Toast.LENGTH_SHORT).show();
			}
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			Toast.makeText(getApplicationContext(), "AsyncTask Finished", Toast.LENGTH_SHORT).show();

		}
	}
}
