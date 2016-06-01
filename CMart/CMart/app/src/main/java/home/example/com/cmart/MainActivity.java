package home.example.com.cmart;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from listview_main.xml
		setContentView(R.layout.main_activity);
		// Execute DownloadJSON AsyncTask

	}

	// DownloadJSON AsyncTask

}