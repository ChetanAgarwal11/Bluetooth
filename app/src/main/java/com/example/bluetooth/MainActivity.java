package com.example.bluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    Button bton,btoff,btdis;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bton = findViewById(R.id.bton);
        btoff = findViewById(R.id.btoff);
        btdis = findViewById(R.id.btdis);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        bton.setOnClickListener(this);
        btoff.setOnClickListener(this);
        btdis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bton:{
                if(bluetoothAdapter!=null){
                    bluetoothAdapter.enable();
                }else {
                    Toast.makeText(this,"No Bluetooth found",Toast.LENGTH_SHORT).show();
                }
                break ;
            }
            case R.id.btoff:{
                if(bluetoothAdapter.isEnabled()) {
                    bluetoothAdapter.disable();
                }
                break ;
            }
            case R.id.btdis:{
                bluetoothAdapter.startDiscovery();
                break ;
            }
        }
    }
}
