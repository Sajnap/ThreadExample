package com.example.threadexampleandroid;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class sajna extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }
    public void asyncTaskStartClicked(View v)
    {
        sample s=new sample();
        s.execute("ok");
    }
class sample extends AsyncTask<String, Integer, String>
{
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(getApplicationContext(),"preexecute", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(String... params) {
        publishProgress(1);
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int val=values[0];
        Toast.makeText(getApplicationContext(),"from background"+val, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(String s) {
                super.onPostExecute(s);
        Toast.makeText(getApplicationContext(),"postexecute", Toast.LENGTH_SHORT).show();
    }
}
}
