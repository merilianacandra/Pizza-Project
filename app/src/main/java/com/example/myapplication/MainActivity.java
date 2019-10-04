package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void pizza1(View v){
        Intent a = new Intent(MainActivity.this, Main2Activity.class);
        a.putExtra("resId", R.drawable.piza1);
        startActivity(a);
    }

    public void pizza2(View v){
        Intent a = new Intent(MainActivity.this, Main2Activity.class);
        a.putExtra("resId", R.drawable.piza2);
        startActivity(a);
    }

    public void pizza3(View v){
        Intent a = new Intent(MainActivity.this, Main2Activity.class);
        a.putExtra("resId", R.drawable.piza3);
        startActivity(a);
    }


    public void getSelected(View view){

        int size_price, topping_price, total_price;
        int pizza_price = 0;

        RadioButton smallChecked = (RadioButton) findViewById(R.id.small);
        RadioButton mediumChecked = (RadioButton) findViewById(R.id.medium);
        RadioButton largeChecked = (RadioButton) findViewById(R.id.large);
        RadioButton pizz1_button = (RadioButton) findViewById(R.id.id_pizza_1);
        RadioButton pizza2_button = (RadioButton) findViewById(R.id.id_pizza_2);
        RadioButton pizza3_button = (RadioButton) findViewById(R.id.id_pizza_3);

        CheckBox avocadoCheckBox = (CheckBox) findViewById(R.id.avocado);
        CheckBox brocolliCheckBox = (CheckBox) findViewById(R.id.brocolli);
        CheckBox onionsCheckBox = (CheckBox) findViewById(R.id.onions);
        CheckBox zuchinniCheckBox = (CheckBox) findViewById(R.id.zuchinni);
        CheckBox lobsterCheckBox = (CheckBox) findViewById(R.id.lobster);
        CheckBox oysterCheckBox = (CheckBox) findViewById(R.id.oyster);
        CheckBox salmonCheckBox = (CheckBox) findViewById(R.id.salmon);
        CheckBox tunaCheckBox = (CheckBox) findViewById(R.id.tuna);
        CheckBox baconCheckBox = (CheckBox) findViewById(R.id.bacon);
        CheckBox duckCheckBox = (CheckBox) findViewById(R.id.duck);
        CheckBox hamCheckBox = (CheckBox) findViewById(R.id.ham);
        CheckBox sausageCheckBox = (CheckBox) findViewById(R.id.sausage);

        avocadoCheckBox.setEnabled(false);
        brocolliCheckBox.setEnabled(false);
        onionsCheckBox.setEnabled(false);
        zuchinniCheckBox.setEnabled(false);
        lobsterCheckBox.setEnabled(false);
        oysterCheckBox.setEnabled(false);
        salmonCheckBox.setEnabled(false);
        tunaCheckBox.setEnabled(false);
        baconCheckBox.setEnabled(false);
        duckCheckBox.setEnabled(false);
        hamCheckBox.setEnabled(false);
        sausageCheckBox.setEnabled(false);

        mediumChecked.setEnabled(false);
        smallChecked.setEnabled(false);
        largeChecked.setEnabled(false);

        boolean pickavocado = avocadoCheckBox.isChecked();
        boolean pickbrocolli = brocolliCheckBox.isChecked();
        boolean pickonions = onionsCheckBox.isChecked();
        boolean pickzuchinni = zuchinniCheckBox.isChecked();
        boolean picklobster = lobsterCheckBox.isChecked();
        boolean pickoyster = oysterCheckBox.isChecked();
        boolean picksalmon = salmonCheckBox.isChecked();
        boolean picktuna = tunaCheckBox.isChecked();
        boolean pickbacon = baconCheckBox.isChecked();
        boolean pickduck = duckCheckBox.isChecked();
        boolean pickham = hamCheckBox.isChecked();
        boolean picksausage = sausageCheckBox.isChecked();

        boolean picksmall = smallChecked.isChecked();
        boolean pickmedium = mediumChecked.isChecked();
        boolean picklarge = largeChecked.isChecked();

        if(pizz1_button.isChecked()){
            mediumChecked.setEnabled(true);
            smallChecked.setEnabled(true);
            largeChecked.setEnabled(true);

            avocadoCheckBox.setEnabled(true);
            brocolliCheckBox.setEnabled(true);
            onionsCheckBox.setEnabled(true);
            zuchinniCheckBox.setEnabled(true);
            lobsterCheckBox.setEnabled(false);
            oysterCheckBox.setEnabled(false);
            salmonCheckBox.setEnabled(false);
            tunaCheckBox.setEnabled(true);
            baconCheckBox.setEnabled(false);
            duckCheckBox.setEnabled(false);
            hamCheckBox.setEnabled(true);
            sausageCheckBox.setEnabled(false);

            pizza_price = 8;

        }

        else if(pizza2_button.isChecked()){

            mediumChecked.setEnabled(true);
            smallChecked.setEnabled(true);
            largeChecked.setEnabled(true);

            avocadoCheckBox.setEnabled(false);
            brocolliCheckBox.setEnabled(true);
            onionsCheckBox.setEnabled(true);
            zuchinniCheckBox.setEnabled(true);
            lobsterCheckBox.setEnabled(true);
            oysterCheckBox.setEnabled(true);
            salmonCheckBox.setEnabled(true);
            tunaCheckBox.setEnabled(false);
            baconCheckBox.setEnabled(true);
            duckCheckBox.setEnabled(false);
            hamCheckBox.setEnabled(true);
            sausageCheckBox.setEnabled(false);

            pizza_price = 10;

        }

        else if(pizza3_button.isChecked()){

            mediumChecked.setEnabled(true);
            smallChecked.setEnabled(true);
            largeChecked.setEnabled(true);

            avocadoCheckBox.setEnabled(false);
            brocolliCheckBox.setEnabled(true);
            onionsCheckBox.setEnabled(true);
            zuchinniCheckBox.setEnabled(true);
            lobsterCheckBox.setEnabled(false);
            oysterCheckBox.setEnabled(false);
            salmonCheckBox.setEnabled(false);
            tunaCheckBox.setEnabled(true);
            baconCheckBox.setEnabled(true);
            duckCheckBox.setEnabled(true);
            hamCheckBox.setEnabled(true);
            sausageCheckBox.setEnabled(true);

            pizza_price = 12;
        }


        size_price = totalSizePrice(picksmall, pickmedium, picklarge);
        topping_price = totalToppingPrice(pickavocado, pickbrocolli, pickonions, pickzuchinni, picklobster,
                pickoyster, picksalmon, picktuna, pickbacon, pickduck, pickham, picksausage);


        total_price = size_price + topping_price + pizza_price;

        TextView displayPrice = (TextView) findViewById(R.id.totalhrg);
        displayPrice.setText(String.format(Locale.US, "$ %d", total_price));

    }

    private int totalSizePrice(boolean addsmall, boolean addmedium, boolean addlarge){
        int hargaSize = 0;

        if(addsmall){
            hargaSize = hargaSize - 1;
        }

        else if (addmedium){
            hargaSize = hargaSize + 0;
        }

        else if (addlarge){
            hargaSize = hargaSize + 2;
        }

        return hargaSize;
    }


    private int totalToppingPrice(boolean addavocado, boolean addbrocolli, boolean addonions, boolean addzuchinni,
                                  boolean addlobster, boolean addoyster, boolean addsalmon, boolean addtuna,
                                  boolean addbacon, boolean addduck, boolean addham, boolean addsausage ){
        int hargaTopping = 0;

        if(addavocado){
            hargaTopping = hargaTopping + 1;
        }

        if(addbrocolli){
            hargaTopping = hargaTopping + 1;
        }

        if(addonions){
            hargaTopping = hargaTopping + 1;
        }

        if(addzuchinni){
            hargaTopping = hargaTopping + 1;
        }

        if(addlobster){
            hargaTopping = hargaTopping + 2;
        }

        if(addoyster){
            hargaTopping = hargaTopping + 2;
        }

        if(addsalmon){
            hargaTopping = hargaTopping + 2;
        }

        if(addtuna){
            hargaTopping = hargaTopping + 2;
        }

        if(addbacon){
            hargaTopping = hargaTopping + 3;
        }

        if(addduck){
            hargaTopping = hargaTopping + 3;
        }

        if(addham){
            hargaTopping = hargaTopping + 3;
        }

        if(addsausage){
            hargaTopping = hargaTopping + 3;
        }

        return hargaTopping;
    }
}
