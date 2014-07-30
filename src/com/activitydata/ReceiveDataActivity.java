package com.activitydata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ReceiveDataActivity extends Activity{

	TextView textviewi,textviews,textviewb;
	TextView textObject;
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
		try{
		if(""==(myperson.getName().toString())&&""==(myperson.getId().toString())){
			Log.e("getName or getid is null","error!!!!");
		}
		else
		{
			textObject.setText("对象"+"\n"+"Person name:"+myperson.getName()+"\n"+
					"Person id:"+myperson.getId());
		}
		}catch(Exception e){
			Log.i("getName is null","getid is null");
		}
	}



	private void initConfig() {
		// TODO Auto-generated method stub
		textviewi=(TextView) findViewById(R.id.showDataI);
		textviews=(TextView) findViewById(R.id.showDataS);
		textviewb=(TextView) findViewById(R.id.showDataB);
		textObject=(TextView) findViewById(R.id.showObject);
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

	static void SerializeMethod(Activity context) {
		Person person = new Person("test", "123456");
		Bundle myBundle = new Bundle();
		myBundle.putSerializable("serialize", person);
		Intent myIntent = new Intent(context, ReceiveDataActivity.class);
		myIntent.putExtras(myBundle);
		context.startActivity(myIntent);
	}
}
