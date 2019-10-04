package com.example.androidliststudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewStudent;
    ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewStudent = findViewById(R.id.recyclerview_id);
        recyclerViewStudent.setLayoutManager(new LinearLayoutManager((this)));

        final StudentAdapter studentAdapter = new StudentAdapter();
        recyclerViewStudent.setAdapter(studentAdapter);

        final Student student_1 = new Student("Tuan", 20, "Da Nang");
        final Student student_2 = new Student("Tai", 21, "Quang Binh");
        final Student student_3 = new Student("Vi", 22, "Quang Nam");
        final Student student_4 = new Student("Nga", 22, "Binh Dinh");
        final Student student_5 = new Student("Quan", 21, "Khanh Hoa");

        students = new ArrayList<Student>();
        students.add(student_1);
        students.add(student_2);
        students.add(student_3);
        students.add(student_4);
        students.add(student_5);

        studentAdapter.students = students;

        final Button btn_Add = (Button) findViewById(R.id.btn_Add);
        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.add(new Student("Anonymous", 20, "Mars"));
                studentAdapter.notifyDataSetChanged();
            }
        });

        final Button btn_Delete = (Button) findViewById(R.id.btn_Delete);
        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.remove(students.size() - 1);
                studentAdapter.notifyDataSetChanged();
            }
        });
    }

    public void onClickStudentDetail(int position) {
        Intent studentDetail = new Intent(this, StudentDetail.class);
        studentDetail.putExtra("Name", students.get(position).getName());
        studentDetail.putExtra("Age", students.get(position).getAge());
        studentDetail.putExtra("Hometown", students.get(position).getHometown());
        startActivityForResult(studentDetail, 0);
    }
}
