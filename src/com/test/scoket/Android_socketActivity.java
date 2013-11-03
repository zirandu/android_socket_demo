package com.test.scoket;



import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Android_socketActivity extends Activity {
    /** Called when the activity is first created. */
	private Button rev=null;
	private TextView revtext=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        rev=(Button)findViewById(R.id.rev);    
        revtext=(TextView)findViewById(R.id.receiver);
        rev.setOnClickListener(new receiverlistenr());
    }
    class receiverlistenr implements OnClickListener{
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		try {
    			//实例化Socket
				Socket socket=new Socket("172.18.107.219",8500);
				//获得输入流
				InputStream in=socket.getInputStream();
				//缓冲区
				byte[] buffer=new byte[in.available()];
				//读取缓冲区
				in.read(buffer);
				//转换字符串
				String msg=new String(buffer);
				//设置文本框的字符串
				revtext.setText(msg);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    }
}