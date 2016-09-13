package id.sch.smktelkom_mlg.tugas01.xirpl5032.formulirpendaftaran;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText etNama;
    EditText etEmail;
    EditText etNomer;
    //RadioButton rb10,rb11;
    RadioGroup rgStatus;
    CheckBox cbR, cbT;
    TextView tvHasil, tvKls;
    Button bOk;
    int nJurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        etNomer = (EditText) findViewById(R.id.editTextNomer);
        /*rb10 = (RadioButton) findViewById (R.id.rb10);
        rb11 = (RadioButton) findViewById(R.id.rb11); */
        rgStatus = (RadioGroup) findViewById(R.id.radioGroupStatus);
        cbR = (CheckBox) findViewById(R.id.checkBoxR);
        cbT = (CheckBox) findViewById(R.id.checkBoxT);
        bOk = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil;
        tvKls = (TextView) findViewById(R.id.textViewKls);

        cbR.setOnCheckedChangeListener(this);
        cbT.setOnCheckedChangeListener(this);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String email = etEmail.getText().toString();
            String nomer = etNomer.getText().toString();


        }
    }

           /*if(rb10.isChecked())
        {
            hasil = rb10.getText().toString();
        }
        else if(rb10.isChecked())
        {
            hasil = rb10.getText().toString();
        }
        else if(rb11.isChecked())
        {
            hasil = rb11.getText().toString();
        }*/


    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String email = etEmail.getText().toString();
        String Nomer = etNomer.getText().toString();

        String jurusan = "\nJurusan anda : \n";
        int startlen = jurusan.length();
        if (cbR.isChecked()) jurusan += cbR.getText() + "\n";
        if (cbT.isChecked()) jurusan += cbT.getText() + "\n";

        if (jurusan.length() == startlen) jurusan += "Tidak Terisi";
        String hasil = null;

        if (rgStatus.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgStatus.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (email.isEmpty()) {
            etEmail.setError("Isi Email anda");
            valid = false;
        } else {
            etEmail.setError(null);
        }

        if (Nomer.isEmpty()) {
            etNomer.setError("Isi Nomor Telepon anda");
            valid = false;
        } else {
            etNomer.setError(null);
        }
        return valid;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nJurusan += 1;
        else nJurusan -= 1;

        tvKls.setText("Jurusan (" + nJurusan + " terpilih");

    }
}



