package com.example.ch_e00587.diabetes2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class Profile extends ActionBarActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    MyDbHandler myDbHandler;
    Button btn;
    Button btn5;
    String diabetes_check_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        editText1=(EditText) findViewById(R.id.editText1);
        editText2=(EditText) findViewById(R.id.editText2);
        editText3=(EditText) findViewById(R.id.editText3);
        editText4=(EditText) findViewById(R.id.editText4);
        editText5=(EditText) findViewById(R.id.editText5);
        editText6=(EditText) findViewById(R.id.editText6);

        btn=(Button) findViewById(R.id.button);
//        btn5=(Button) findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("DIABETES1","In listener of btn");
                int check=checkvalues();
                if(check ==0) {
                    deletebutton(view);
                    adddbutton(view);
                    Log.i("DIABETES1", "After Add button Finish");
                    checkdiabetes2();
                }
                else{
                    Log.i("DIABETES1", "Nothing to do");
                }
            }

        });
  /*      btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //deletebutton(view);
                //printDatabase();
                clearData(view);
            }
        });*/

        myDbHandler=new MyDbHandler(this,null,null,1);
        printDatabase();
    }

    public int checkvalues(){
        if(editText1.getText().equals(null) || editText2.getText().equals(null) || editText3.getText().equals(null) || editText4.getText().equals(null) || editText5.getText().equals(null) || editText6.getText().equals(null)){
            return 1;
        }
        else{
            return 0;
        }
    }
    public void printDatabase(){
        //String[] dbName=myDbHandler.dbToString();
        Log.i("DIABETES1", "In printDatabase");
        List<Object> dbName=new ArrayList(5);
        dbName=myDbHandler.dbToString();
        Products pd1=new Products();
        Log.i("DIABETES1", "In print DB getting from product class " + pd1.get_name());
        Log.i("DIABETES1", "In print DB getting from product class " + pd1.get_dob());
        Log.i("DIABETES1", "In print DB getting from product class " + pd1.get_bp());
        Log.i("DIABETES1", "In print DB getting from product class " + pd1.get_cholestrol());
        Log.i("DIABETES1", "In print DB getting from product class " + pd1.get_glucose());
        Log.i("DIABETES1", "In print DB getting from product class " + pd1.get_hypo());

        if(pd1.get_name() != null) {
            editText1.setText(pd1.get_name().toString());
        }

        if(pd1.get_dob() != null) {
            editText2.setText(pd1.get_dob().toString());
        }
        if(pd1.get_bp() != 0) {
            editText3.setText(""+pd1.get_bp());
        }
        if(pd1.get_cholestrol() != 0) {
            editText4.setText(""+pd1.get_cholestrol());
        }
        if(pd1.get_hypo() != 0) {
            editText5.setText(""+pd1.get_hypo());
        }
        if(pd1.get_glucose() != 0) {
            editText6.setText(""+pd1.get_glucose());
        }

        //editText.setText(dbName[0]);
        //Log.i("DIABETES1", "print DB");
    }
    public void checkdiabetes2(){
        //bp
        Log.i("DIABETES1", "After Add button Finish in checkdiabetes2" + Integer.parseInt(editText3.getText().toString()));
        int bp_pass = Integer.parseInt(editText3.getText().toString());
        Log.i("DIABETES1", "After Add button Finish after get bp");
        int cholestrol_pass = Integer.parseInt(editText4.getText().toString());
        Log.i("DIABETES1", "After Add button Finish after get choles");
        int hypop_pass = Integer.parseInt(editText5.getText().toString());
        Log.i("DIABETES1", "After Add button Finish after get hypo");
        int glucose_pass = Integer.parseInt(editText6.getText().toString());
        Log.i("DIABETES1", "Before BP Compare in checkdiabetes2");
        if(bp_pass >130){
            diabetes_check_result="bp";
            //return 1;
        }
        Log.i("DIABETES1", "Before Cholestrol Compare in checkdiabetes2");
        if (cholestrol_pass<1 || cholestrol_pass>4){
            diabetes_check_result="cholestrol";
            //return 2;
        }
        if (hypop_pass <47 || hypop_pass >53){
            diabetes_check_result="hypo";
            //return 3;
        }
        if (glucose_pass<6 || glucose_pass>8){
            diabetes_check_result="glocose";
            //return 4;
        }
        else{
            diabetes_check_result="ok";
            //return 0;
        }
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
        editText5.setText("");
        editText6.setText("");
        Log.i("DIABETES1", "Value of diabetes_check_result "+diabetes_check_result);
        if (diabetes_check_result.equalsIgnoreCase("bp")){
            Log.i("DIABETES1", "Value of diabetes_check_result in if"+diabetes_check_result);
            Intent intent=new Intent(this,Diabetes2Found.class);
            startActivity(intent);
        }
        else {
            Log.i("DIABETES1", "Value of diabetes_check_result in else"+diabetes_check_result);
            Intent intent=new Intent(this,Diabetes2Found.class);
            startActivity(intent);
        }
    }
    public void deletebutton(View view){
        Log.i("DIABETES1", "delete button clicked");
        //Products product=new Products(editText1.getText().toString(),"abcd",1,2,3,4);
        myDbHandler.deleteProduct("abc");
        Log.i("DIABETES1", "delete button clicked lower");
        //printDatabase();
    }
    public void clearData(View view){
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
        editText5.setText("");
        editText6.setText("");
    }

    public void adddbutton(View view){
        //Log.i("DIABETES1", "button clicked with value"+editText1.getText().toString());
        Log.i("DIABETES1", "button clicked in add btn");
        if(editText3.getText().toString() != null) {


            Log.i("DIABETES1", "button clicked with value in if 1 "+editText1.getText().toString());
            Log.i("DIABETES1", "button clicked with value in if 2 "+editText2.getText().toString());
            Log.i("DIABETES1", "button clicked with value in if 3 "+editText3.getText());
            Log.i("DIABETES1", "button clicked with value in if 3 "+editText3.getText());
            Log.i("DIABETES1", "button clicked with value in if 4 "+editText4.getText());
            Log.i("DIABETES1", "button clicked with value in if 5 "+editText5.getText());
            Log.i("DIABETES1", "button clicked with value in if 6 "+editText6.getText());

            int bp_pass = Integer.parseInt(editText3.getText().toString());
            int cholestrol_pass = Integer.parseInt(editText4.getText().toString());
            int hypop_pass = Integer.parseInt(editText5.getText().toString());
            int glucose_pass = Integer.parseInt(editText6.getText().toString());
            Products product=new Products(editText1.getText().toString(),editText2.getText().toString(),bp_pass,cholestrol_pass,hypop_pass,glucose_pass);
            myDbHandler.addProduct(product);
            Log.i("DIABETES1", "button clicked lower");


            //printDatabase();
        }
        else
        {
            Log.i("DIABETES1", "button clicked with value in else");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
