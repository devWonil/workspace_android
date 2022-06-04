package com.example.movie_1_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.example.movie_1_ex.databinding.ActivityMainBinding;
import com.example.movie_1_ex.interfaces.OnChangeToolbarType;
import com.example.movie_1_ex.interfaces.OnPassWebView;
import com.example.movie_1_ex.utils.Define;
import com.example.movie_1_ex.utils.FragmentType;

public class MainActivity extends AppCompatActivity implements OnChangeToolbarType, OnPassWebView {
    // 뷰 바인딩 생성 방법
    // 1. 안드로이드가 만들어준 객체 선언
    ActivityMainBinding binding;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 2. 객체 초기화
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // 3. 연결
        setContentView(binding.getRoot());

        replaceFragment(FragmentType.MOVIE);
        addBottomNavigationListener();
    }

    private void replaceFragment(FragmentType type){
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (type == FragmentType.MOVIE) {
            // 프래그먼트 생성
            fragment = MovieFragment.getInstance(this); // MOVIE TAG
        } else {
            // 프래그먼트 생성
            fragment = InfoFragment.getInstance(this); // INFO TAG
            if (fragment != null){
                InfoFragment infoFragment = (InfoFragment) fragment;
                infoFragment.setOnPassWebView(this); // 주소 연결
            }
        }
        // 문자열로 이름 지어서 구분 해 놓는 녀석 --> Tag
        transaction.replace(binding.mainContainer.getId(), fragment, type.toString());
        transaction.commit();
    }

    private void addBottomNavigationListener() {
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.page1:
                    replaceFragment(FragmentType.MOVIE);
                    break;
                case R.id.page2:
                    replaceFragment(FragmentType.INFO);
                    break;
            }
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        // infofragment 라면 한 번은 movieFragment 갔다가 --> 동작
        // movie -- 종료
        // mainContainer --> 올라와 있는 녀석이 현재 moviefragment 인지 infofragment 인지 구분
        String fragmentTag = getSupportFragmentManager().findFragmentByTag(FragmentType.INFO.toString()).getTag();
        if (fragmentTag.equals(FragmentType.INFO.toString())){
            if (webView.canGoBack()){
                webView.goBack();
            }else {
                View view = binding.bottomNavigation.findViewById(R.id.page1);
                view.callOnClick();
            }
        }else{
            super.onBackPressed();
        }

    }

    @Override
    public void onSetupType(String title) {
        if (title.equals(Define.PAGE_TITLE_MOVIE)){
            binding.topAppBar.setTitle(title);
            binding.topAppBar.setVisibility(View.VISIBLE);
        }else if (title.equals(Define.PAGE_TITLE_INFO)){
            binding.topAppBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPassWebViewObj(WebView webView) {
        this.webView = webView;
    }
}