package com.example.thbuoi1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText hoten, mssv, lop, sdt, khpt;
    RadioButton nam1, nam2, nam3, nam4;
    CheckBox htn, dt, vt;
    Button send;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần
        hoten = findViewById(R.id.hoten);
        mssv = findViewById(R.id.mssv);
        lop = findViewById(R.id.lop);
        sdt = findViewById(R.id.sdt);
        khpt = findViewById(R.id.khptbt);
        send = findViewById(R.id.send);
        htn = findViewById(R.id.htn);
        dt = findViewById(R.id.dt);
        vt = findViewById(R.id.vt);
        nam1 = findViewById(R.id.nam1);
        nam2 = findViewById(R.id.nam2);
        nam3 = findViewById(R.id.nam3);
        nam4 = findViewById(R.id.nam4);

        // Xử lý sự kiện khi nhấn nút "send"
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy dữ liệu từ các trường nhập liệu
                String hoten1 = hoten.getText().toString();
                String mssv1 = mssv.getText().toString();
                String lop1 = lop.getText().toString();
                String sdt1 = sdt.getText().toString();
                String khpt1 = khpt.getText().toString();

                // Kiểm tra CheckBox (htn, dt, vt)
                StringBuilder major  = new StringBuilder();
                if (htn.isChecked()) {
                    major.append("Hệ thống nhúng ");
                }
                if (dt.isChecked()) {
                    major.append("Điện tử ");
                }
                if (vt.isChecked()) {
                    major.append("Viễn thông ");
                }

                // Kiểm tra RadioButton (nam1, nam2, nam3, nam4)
                String namHoc = "";
                if (nam1.isChecked()) {
                    namHoc = "Năm 1";
                } else if (nam2.isChecked()) {
                    namHoc = "Năm 2";
                } else if (nam3.isChecked()) {
                    namHoc = "Năm 3";
                } else if (nam4.isChecked()) {
                    namHoc = "Năm 4";
                }

                // Hiển thị dữ liệu (hoặc gửi sang Activity khác)
                Toast.makeText(MainActivity.this,
                        "Họ tên: " + hoten1 + "\n" +
                                "MSSV: " + mssv1 + "\n" +
                                "Lớp: " + lop1 + "\n" +
                                "SĐT: " + sdt1 + "\n" +
                                "Khả năng phát triển: " + khpt1 + "\n" +
                                "Chuyên ngành: " + major.toString() + "\n" +
                                "Năm học: " + namHoc,
                        Toast.LENGTH_LONG).show();

                // Chuyển dữ liệu sang Activity khác (nếu cần)
                Intent myintent = new Intent(MainActivity.this, SecondActivity.class);
                myintent.putExtra("hoten", hoten1);
                myintent.putExtra("mssv", mssv1);
                myintent.putExtra("lop", lop1);
                myintent.putExtra("sdt", sdt1);
                myintent.putExtra("khpt", khpt1);
                myintent.putExtra("hobbies", major.toString());
                myintent.putExtra("namHoc", namHoc);
                startActivity(myintent);
            }
        });

        // Xử lý hiển thị padding cho toàn bộ màn hình
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
