package edi194.fblite;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView view;
    SwipeRefreshLayout mySwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySwipeRefreshLayout = (SwipeRefreshLayout) this.findViewById(R.id.swipeContainer);
        String url = "http://m.facebook.com/";
        view = (WebView) this.findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setBuiltInZoomControls(true);
        view.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36 OPR/52.0.2871.97");
        view.getSettings().setDisplayZoomControls(false);
        view.setWebViewClient(new WebViewClient());
        view.loadUrl(url);

        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        view.reload();
                        mySwipeRefreshLayout.setRefreshing(false);
                    }
                }
        );
    }

        @Override
        public void onBackPressed() {
            if (view.canGoBack()) {
                view.goBack();
            } else {
                super.onBackPressed();
            }
        }

}