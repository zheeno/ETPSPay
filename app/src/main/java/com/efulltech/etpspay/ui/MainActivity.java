package com.efulltech.etpspay.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.efulltech.epay_tps_library_module.CardPaymentActivity;
import com.efulltech.epay_tps_library_module.UsbPrinter;
import com.efulltech.etpspay.R;
import com.efulltech.etpspay.SplashActivity;
import com.google.android.material.snackbar.Snackbar;
import com.efulltech.etpspay.utils.Constants;
import com.efulltech.etpspay.utils.DataProccessor;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView timeText;
    private TextView dateText;

    @BindView(R.id.cardPaymentBtn)
    Button cardPayment;
//    @BindView(R.id.transactionHistoryBtn)
//    Button transactionHistory;
//    @BindView(R.id.printEODBtn)
//    Button printReceipt;
//    @BindView(R.id.userPreferencesBtn)
//    Button userPreferences;
//
//    DataProccessor dataProccessor;
//
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeText = findViewById(R.id.timeText);
//        dateText = findViewById

        //get current device seconds (Time)
        @SuppressLint("SimpleDateFormat") SimpleDateFormat curSec = new SimpleDateFormat("ss");
        // convert seconds to int
        Integer timer = Integer.parseInt(curSec.format(new Date()));
        // start the recursive function to display time
        showDateTime(timer);

        ButterKnife.bind(this);
//
//        dataProccessor = new DataProccessor(this);
//
//        checkOsVersion();

    }

    private void showDateTime(int _secTimer) {
        final Integer secTimer = _secTimer;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat curTime = new SimpleDateFormat("HH:mm:ss z");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G");
        String currentTime = curTime.format(new Date());
        timeText.setText(currentTime);

        Thread background = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 'secTimer' seconds
                    sleep(secTimer * 1000);

                    // After 5 seconds call showDateTime
                    showDateTime(secTimer);
                }
                catch (Exception e) {
                    Log.d("Main", e.toString());
                }
            }
        };
        // start thread
        background.start();
    }

    //
    @OnClick(R.id.cardPaymentBtn)
    public void cardPayment(View view) {
//        Toast.makeText(MainActivity.this, "I am clickable", Toast.LENGTH_LONG).show();
        Intent cardPayment = new Intent(MainActivity.this, CardPaymentActivity.class);
        startActivity(cardPayment);
    }

//
//    @OnClick(R.id.transactionHistoryBtn)
//    public void transactionHistory(View view) {
//        Intent transactionHistory = new Intent(MainActivity.this, TransactionHistoryActivity.class);
//        startActivity(transactionHistory);
//
//    }
//
//    @OnClick(R.id.printEODBtn)
//    public void printReceipt(View view) {
////        Intent receipt = new Intent(MainActivity.this, PrintReceiptActivity.class);
////        startActivity(receipt);
//        UsbPrinter usbPrinter = new UsbPrinter(MainActivity.this);
//        usbPrinter.PrintDemoText();
//    }
//
//    @OnClick(R.id.userPreferencesBtn)
//    protected void userPreferences(View view) {
//        confirmPinThenSettings();
//
//    }
//
//    private void confirmPinThenSettings() {
//
//        // get prompts.xml view
//        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
//        View promptView = layoutInflater.inflate(R.layout.admin_pin_dialog, null);
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
//        alertDialogBuilder.setView(promptView);
//
//        final EditText uPin = promptView.findViewById(R.id.pinTextField);
//        dataProccessor.setStr(Constants.OPERATOR_PIN, "1234");
//        dataProccessor.setStr(Constants.SUPERVISOR_PIN, "1111");
//        dataProccessor.setStr(Constants.ADMIN_PIN, "260089");
//
//        // setup a dialog window
//        alertDialogBuilder.setCancelable(false)
//                .setPositiveButton("Confirm", (dialog, id) -> {
//
//                    String pin = uPin.getText().toString();
//                    String permission = "";
//                    if(dataProccessor.getStr(Constants.OPERATOR_PIN).equals(pin) ||
//                            dataProccessor.getStr(Constants.SUPERVISOR_PIN).equals(pin) ||
//                            dataProccessor.getStr(Constants.ADMIN_PIN).equals(pin)){
//                        if(Constants.ADMIN_PIN.equals(pin)){
//                            dataProccessor.setStr(Constants.ADMIN, "admin");
////                            Log.d("MainActivity", "Admin:" + pin);
////                            permission = "admin";
//                        }else if(Constants.SUPERVISOR_PIN.equals(pin)){
//                            dataProccessor.setStr(Constants.SUPERVISOR, "supervisor");
////                            Log.d("MainActivity", "Supervisor:" + pin);
////                            permission = "supervisor";
//                        }else{
//                            dataProccessor.setStr(Constants.OPERATOR, "operator");
////                            Log.d("MainActivity", "Operator:" + pin);
////                            permission = "operator";
//                        }
////                            display SettingsActivity page
//                        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
////
//                        startActivity(intent);
//                    }else{
////                            alert invalid PIN
//                        Snackbar.make(findViewById(android.R.id.content), "Invalid PIN! Please try again", Snackbar.LENGTH_LONG).show();
//                    }
//                })
//                .setNegativeButton("Cancel",
//                        (dialog, id) ->
//                                dialog.cancel());
//
//        // create an alert dialog
//        AlertDialog alert = alertDialogBuilder.create();
//        alert.show();
//
//    }
//
//    public void checkOsVersion() {
//
////        String _uri = sharedPref.getString("cloudDBUri", "http://192.168.8.101/api/");
////        String packageName =  BuildConfig.APPLICATION_ID;
////        String versionName = BuildConfig.VERSION_NAME;
////        String tid = this.sharedPref.getString("terminalid", "");
////        String url = _uri + "/checkOsVersion?terminalId="+tid+"&package="+packageName+"&version="+versionName;
////
////        Log.d("Checking OS Version ", url);
////        Toast.makeText(MainActivity.this, "Checking for updates", Toast.LENGTH_SHORT).show();
//
////        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
////        StringRequest stringRequest = new StringRequest(
////                Request.Method.GET,
////                url,
////                new Response.Listener<String>() {
////                    @Override
////                    public void onResponse(String response) {
////                        Log.d("Update Response", response);
////                        if(response.equals("true")){
////                            Toast.makeText(MainActivity.this, "Your app is up to date", Toast.LENGTH_SHORT).show();
////                        }else{
//////                            navigate to update page
////                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(response)));
////                        }
////
////                    }
////                },
////                new Response.ErrorListener() {
////                    @Override
////                    public void onErrorResponse(VolleyError error) {
////                        Log.e("Cloud DB Error", error.toString());
////                        Toast.makeText(MainActivity.this, "Timeout, Please check your internet connection", Toast.LENGTH_LONG).show();
////                    }
////                }
////        );
//////      set retry policy to determine how long volley should wait before resending a failed request
////        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
////                30000,
////                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
////                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//////        add jsonObjectRequest to the queue
////        requestQueue.add(stringRequest);
//    }
}
