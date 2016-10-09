package id.sch.smktelkom_mlg.tugas01.xiirpl4030.ordertrains;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nama;
    EditText tahun;
    Button Bot;
    TextView hasil, jumker;
    RadioGroup RG;
    Spinner spKt;
    CheckBox CBA, CBB, CBC;
    int jum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (EditText) findViewById(R.id.Tnama);
        tahun = (EditText) findViewById(R.id.Ttahun);
        RG = (RadioGroup) findViewById(R.id.RadioGroupStat);
        spKt = (Spinner) findViewById(R.id.Skt);
        CBA = (CheckBox) findViewById(R.id.checkBox1);
        CBB = (CheckBox) findViewById(R.id.checkBox2);
        CBC = (CheckBox) findViewById(R.id.checkBox3);
        Bot = (Button) findViewById(R.id.Bo);
        hasil = (TextView) findViewById(R.id.Thasil);

        Bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();

            }
        });
    }

    private void doProcess() {
        String tamnama = nama.getText().toString();
        int lah = Integer.parseInt(tahun.getText().toString());
        int usia = 2016 - lah;
        String Ka = null;
        if (RG.getCheckedRadioButtonId() != -1) {
            RadioButton Rb = (RadioButton) findViewById(RG.getCheckedRadioButtonId());
            Ka = Rb.getText().toString();
        }
        String kt = spKt.getSelectedItem().toString();
        String h = "/nJumlah Tiket:";
        int starlen = hasil.length();
        if (CBA.isChecked()) h += CBA.getText();
        if (CBB.isChecked()) h += CBB.getText();
        if (CBC.isChecked()) h += CBC.getText();

        if (h.length() == starlen) h += "Anda Harus Memilih";
        hasil.setText("List Pembelian\n" + "Nama : " + tamnama + "\nUmur : " + usia + "\nKota Asal : " + Ka + "\nKota Tujuan : " + kt + h + "\nTransaksi Berhasil Diproses");
    }

}
