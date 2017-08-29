package kodluyoruz.com.spinnera;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //1-Öğeleri tanımlama
    Spinner spinner;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1-init metodu icinde öğeler bağlanir
        init();

        //2-Array adapter olusturulur parametreleri (context,dizi,spinner görünümü)
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.dersler, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);//spinner'ı adaptore baglama

        spinner.setOnItemSelectedListener(this);//spinner'dan oge secildiginde (alt + enter ile imlement et)

        /**Farklı ArrayAdaptor Olusturma Yontemi
         *ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dizi);
         *Java tarafında String bir dizi tanımlaması yapılması gerekiyor.
         */
    }

    private void init() {

        spinner = (Spinner) findViewById(R.id.activity_main_spinner);
        tv = (TextView) findViewById(R.id.activity_main_tv);
    }


    //Spinner'a tıklanıldıgında
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int id, long l) {

        //Seçilen Ogenin Id Degerini Göstermek
//        Toast.makeText(this, "Seçilen Öğe Id: " + id, Toast.LENGTH_SHORT).show();

        //diziyi kopyaladık isimleri göstermek icin
        String[] dersDizisi = getResources().getStringArray(R.array.dersler);

        tv.setText(dersDizisi[id] + " dersine hoşgeldin (:");
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
