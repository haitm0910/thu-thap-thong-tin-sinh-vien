package com.example.thbuoi1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView thongtinView;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Ánh xạ TextView
        thongtinView = findViewById(R.id.thongtin);
        back = findViewById(R.id.back);
        // Nhận dữ liệu từ Intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String hoten = bundle.getString("hoten", "Không có dữ liệu");
            String mssv = bundle.getString("mssv", "Không có dữ liệu");
            String lop = bundle.getString("lop", "Không có dữ liệu");
            String sdt = bundle.getString("sdt", "Không có dữ liệu");
            String khpt = bundle.getString("khpt", "Không có dữ liệu");
            String major = bundle.getString("major", "Không có sở thích");
            String namHoc = bundle.getString("namHoc", "Không chọn năm học");

            // Gộp tất cả thông tin thành một chuỗi
            String fullInfo =
                    "Họ và tên: " + hoten + "\n" +
                            "MSSV: " + mssv + "\n" +
                            "Lớp: " + lop + "\n" +
                            "SĐT: " + sdt + "\n" +
                            "Khả năng phát triển: " + khpt + "\n" +
                            "Chuyên ngành: " + major + "\n" +
                            "Năm học: " + namHoc;

            // Hiển thị thông tin lên TextView
            thongtinView.setText(fullInfo);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}
