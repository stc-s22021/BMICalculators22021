package jo.suntech.s22021.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタン・オブジェクトの用意
        Button btClick=findViewById(R.id.btClick);
        //リスナオブジェクトの用意
        HellowListener listener=new HellowListener();
        btClick.setOnClickListener(listener);

        //クリアボタンであるButtonobjectを取得
        Button btClear=findViewById(R.id.btClear);
        //クリアボタンにリスナを追加
        btClear.setOnClickListener(listener);



    }
    private class HellowListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            EditText input =findViewById(R.id.etNumber);
            EditText  input2 =findViewById(R.id.etNumber2);
            EditText  input3 =findViewById(R.id.etNumber3);

            TextView output=findViewById(R.id.tvOutput);
            TextView output2=findViewById(R.id.tvOutput2);
            TextView output3=findViewById(R.id.tvOutput3);
            TextView output4=findViewById(R.id.tvOutput4);
            TextView output5=findViewById(R.id.tvOutput5);

            int id= v.getId();//何を入力したか


            if (id==R.id.btClick){

                String inputStr=input.getText().toString();

                String inputStr2=input2.getText().toString();
                String inputStr3=input3.getText().toString();


                float f=Float.parseFloat(inputStr);//数値型に変える処理
                float f2=Float.parseFloat(inputStr2);
                float f3=Float.parseFloat(inputStr3);
                int i=6;




                if(i>f){

                    ConfigDialog dialogFragment = new ConfigDialog();
                    dialogFragment.show(getSupportFragmentManager(),"ConfigDialog");

                }
                    double BMI=0;
                    BMI = f3/((f2/100)*(f2/100));
                    if(BMI>=40){
                        output2.setText("肥満（4）");
                    }
                    else if(BMI>=35){
                        output2.setText("肥満（3）");
                    }
                    else if(BMI>=30){
                        output2.setText("肥満（2）");
                    }
                    else if(BMI>=25){
                        output2.setText("肥満（1）");
                    }
                    else if(BMI>=18.5){
                        output2.setText("普通体重");
                    }
                    else {
                        output2.setText("低体重");
                    }





                double g=((f2/100)*(f2/100))*22;
               // String.format("%.3f", g);
                //String h=String.valueOf(g);

                output.setText("あなたの肥満度は");
                output3.setText("あなたの適正体重は");
                output4.setText( String.format("%.3f", g));
                output5.setText("kg");

            }

            else if(id==R.id.btClear){
                input.setText("");
                input2.setText("");
                input3.setText("");
                output.setText("");
                output2.setText("");
                output3.setText("");
                output4.setText("");
                output5.setText("");

            }


        }
    }
}