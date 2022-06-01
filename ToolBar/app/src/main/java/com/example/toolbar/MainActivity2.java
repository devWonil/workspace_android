package com.example.toolbar;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

   TextView textView;

   // 값을 돌려 받을 때 사용하는 코드
    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
           result -> {
                Log.d("TAG", "comeback 돌아왔다");
                if(result.getResultCode() == Activity.RESULT_OK){
                    // 정상 동작
                    Intent data = result.getData();
                    int returnValue = data.getIntExtra("result", 0);
                    textView.setText(returnValue + "");
                }else{
                    // 실패
                }
           }
   );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.toolBar);
        //toolbar.setTitle("");
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.tempTextView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuItem1:
                Intent intent = new Intent(this, SubActivity.class);
                intent.putExtra("value1", 10);
                // 값을 돌려 받지 않을 때
                //startActivity(intent);

                // 값을 돌려 받아야 할 때
                startActivityResult.launch(intent);
                break;
            case R.id.menuItem2:
                Log.d("TAG", "2번클릭");
                break;
            case R.id.menuItem3:
                Log.d("TAG", "3번클릭");
                break;
        }
        return true;
    }
}