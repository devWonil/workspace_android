package com.example.movie_1_ex;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.movie_1_ex.databinding.FragmentInfoBinding;
import com.example.movie_1_ex.interfaces.OnChangeToolbarType;
import com.example.movie_1_ex.interfaces.OnPassWebView;
import com.example.movie_1_ex.utils.Define;


public class InfoFragment extends Fragment {

    private FragmentInfoBinding binding;
    private OnChangeToolbarType onChangeToolbarType;
    private static InfoFragment infoFragment;
    private WebView webView;
    private OnPassWebView onPassWebView;

    public void setOnPassWebView(OnPassWebView onPassWebView){
        this.onPassWebView = onPassWebView;
    }

    public void setOnChangeToolbarType(OnChangeToolbarType onChangeToolbarType){
        this.onChangeToolbarType = onChangeToolbarType;
    }

    public InfoFragment(OnChangeToolbarType onChangeToolbarType) {
       this.onChangeToolbarType = onChangeToolbarType;
    }

    public static InfoFragment getInstance(OnChangeToolbarType onChangeToolbarType) {
        if (infoFragment == null) {
            infoFragment = new InfoFragment(onChangeToolbarType);
        }

        return infoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 뷰 결합 하기위해 메모리 초기화
        binding = FragmentInfoBinding.inflate(inflater, container, false);
        onChangeToolbarType.onSetupType(Define.PAGE_TITLE_INFO); // 여기까지만 하면 nullPointer
        setupWebView();

        return binding.getRoot();
    }

    private void setupWebView() {
        webView = binding.mWebView;
        webView.loadUrl("https://yts.mx/");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                // 콜백
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // 콜백
                binding.progressIndicator.setVisibility(View.GONE);
            }
        });
        // 자바스크립트 허용하는 코드
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        onPassWebView.onPassWebViewObj(webView);
    }
}