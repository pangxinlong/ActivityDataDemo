package com.activitydata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceiveDataActivity extends Activity{

	TextView textviewi,textviews,textviewb;
	TextView textObject;
	Button back;
	
	int dataI;
	String dataS;
	boolean dataB;
		
	Person myperson;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_receive_data);
		initConfig();
		initData();
		textviewi.setText("int : "+dataI+"");
		textviews.setText("stirng : "+dataS);
		textviewb.setText("boolean : "+dataB+"");
		//显示对象内容
		showObject();
	}
	
	
	
	private void showObject() {
		if(myperson!=null){
			textObject.setText("对象myperson"+"\n"+"Person name:"+myperson.getName()+"\n"+
					"Person id     :"+myperson.getId());
		}
	}



	private void initConfig() {
		// TODO Auto-generated method stub
		textviewi=(TextView) findViewById(R.id.showDataI);
		textviews=(TextView) findViewById(R.id.showDataS);
		textviewb=(TextView) findViewById(R.id.showDataB);
		textObject=(TextView) findViewById(R.id.showObject);
		
		back=(Button) findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				parcelableMethod();
			}
		});
	}



	private void initData(){
		dataI=this.getIntent().getIntExtra("data", dataI);
		dataS=this.getIntent().getStringExtra("data");
		dataB=this.getIntent().getBooleanExtra("data",dataB);
		
		 myperson=(Person) getIntent().getSerializableExtra("serialize");

	}
	
	public static void Jump(Activity context,int dataI){
		Intent intent=new Intent();
		intent.setClass(context, ReceiveDataActivity.class);
		intent.putExtra("data", dataI);
		context.startActivity(intent);
	}
	
	public static void Jump(Activity context,String dataS){
		Intent intent=new Intent();
		intent.setClass(context, ReceiveDataActivity.class);
		intent.putExtra("data", dataS);
		context.startActivity(intent);
	}
	
	public static void Jump(Activity context,boolean dataB){
		Intent intent=new Intent();
		intent.setClass(context, ReceiveDataActivity.class);
		intent.putExtra("data", dataB);
		context.startActivity(intent);
	}

	static void serializeMethod(Activity context) {
		Person person = new Person("test", "123456");
		Bundle myBundle = new Bundle();
		myBundle.putSerializable("serialize", person);
		Intent myIntent = new Intent(context, ReceiveDataActivity.class);
		myIntent.putExtras(myBundle);
		context.startActivity(myIntent);
	}
	
	 void parcelableMethod() {
		Person person2 = new Person("test2", "111111");
		Intent myIntent = new Intent();
		Bundle myBundle=new Bundle();
		myBundle.putParcelable("parcelable", person2);
		myIntent.setClass(this,MainActivity.class);
		myIntent.putExtras(myBundle);
		startActivity(myIntent);
	}
}
