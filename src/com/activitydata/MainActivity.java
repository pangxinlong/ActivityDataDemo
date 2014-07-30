package com.activitydata;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	private Button intButton;
	private Button stringButton;
	private Button booleanButton;
	
	private Button objectButton;

	private EditText intText;
	private EditText stringText;
	private EditText booleanText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		listen();
	}

	private void listen() {
		// TODO Auto-generated method stub
		intButton.setOnClickListener(this);
		stringButton.setOnClickListener(this);
		booleanButton.setOnClickListener(this);
		objectButton.setOnClickListener(this);

		intText.setOnClickListener(this);
		stringText.setOnClickListener(this);
		booleanText.setOnClickListener(this);
	}

	private void init() {
		intButton = (Button) findViewById(R.id.intInputB);
		stringButton = (Button) findViewById(R.id.strngInputB);
		booleanButton = (Button) findViewById(R.id.booleanInputB);
		
		objectButton = (Button) findViewById(R.id.objectInputB);

		intText = (EditText) findViewById(R.id.intDataE);
		stringText = (EditText) findViewById(R.id.stringDataE);
		booleanText = (EditText) findViewById(R.id.booleanDataE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.intInputB:
			if ("".equals(intText.getText().toString())) {
				Log.e("int is not null","eorror!!!!!!!!!!!");
			}
			else
			intInput(Integer.valueOf(intText.getText().toString()));

			break;
		case R.id.strngInputB:
			if ("".equals(stringText.getText().toString())) {
				Log.e("String is not null","eorror!!!!!!!!!!!");
			}
			else
				stringInput(stringText.getText().toString());
			break;
		case R.id.booleanInputB:
			if ("".equals(booleanText.getText().toString())) {
				Log.e("boolean is not null","eorror!!!!!!!!!!!");
			}
			else
			booleanInput(Boolean.valueOf(booleanText.getText().toString()));
			break;
		//传递对象按钮
		case R.id.objectInputB:
			ReceiveDataActivity.SerializeMethod(this);
			break;
		default:
			break;
		}

	}

	private void intInput(int dataI) {
		ReceiveDataActivity.Jump(this, dataI);
	}

	private void stringInput(String dataS) {
		ReceiveDataActivity.Jump(this, dataS);
	}

	private void booleanInput(boolean dataB) {
		ReceiveDataActivity.Jump(this, dataB);
	}

	

}
