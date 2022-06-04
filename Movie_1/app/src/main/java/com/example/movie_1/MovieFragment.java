package com.example.movie_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movie_1.adapter.MovieAdapter;
import com.example.movie_1.databinding.FragmentMovieBinding;
import com.example.movie_1.interfaces.OnChangeToolbarType;
import com.example.movie_1.interfaces.OnMovieItemClicked;
import com.example.movie_1.models.Movie;
import com.example.movie_1.models.YtsData;
import com.example.movie_1.repository.MovieService;
import com.example.movie_1.utils.Define;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieFragment extends Fragment implements OnMovieItemClicked {

    // 안드로이드에서 만들어 준 클래스
    private FragmentMovieBinding binding;
    private static final String TAG = MovieFragment.class.getName();
    // 여기서 통신 요청을 할 예정
    private MovieService movieService;

    private MovieAdapter movieAdapter;
    private List<Movie> list = new ArrayList<>();

    private int currentPageNumber = 1;
    //스크롤시 중복 이벤트 발생 해결방안
    private boolean preventDuplicateScrollEvent = true;

    private OnChangeToolbarType onChangeToolbarType;

    private static MovieFragment movieFragment;
    private boolean isFirstLoading = true;


    private MovieFragment(OnChangeToolbarType onChangeToolbarType) {
        this.onChangeToolbarType = onChangeToolbarType;

    }


    public static MovieFragment getInstance(OnChangeToolbarType onChangeToolbarType) {
        // 위에는 메소드이다. (static 통해서 new MovieFragment())
        if (movieFragment == null){
            movieFragment = new MovieFragment(onChangeToolbarType);
        }

        return movieFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieService  = MovieService.retrofit.create(MovieService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // findViewById 대체 (뷰 바인딩 활용)
        // inflater.inflate(R.layout.fragment_movie, container, false);
        binding = FragmentMovieBinding.inflate(inflater, container, false);
        // RecyclerView 만들어주기

        // 아직 없음 (안드로이드 입체적으로 생각)
        setupRecyclerView(list);

        if (isFirstLoading) {
            requestMoviesData(currentPageNumber);
        } else {
            setVisibilityProgressBar(View.GONE);
        }
        // 화면 띄울 때 네트워크 요청
        //requestMoviesData(currentPageNumber);
        onChangeToolbarType.onSetupType(Define.PAGE_TITLE_MOVIE);
        // null pointer exception 이기 때문에 주소를 연결해준다 (누가 내 메소드를 콜백 받을지 연결)
        // 연결방법은 2가지 (1 생성자, 2 메소드)
        return binding.getRoot();
    }

    private void requestMoviesData(int requestPage) {

        int ITEM_LIMIT = 10;
        Log.d(TAG, "통신 요청!");
        movieService.repoContributors("rating", ITEM_LIMIT,  requestPage)
                .enqueue(new Callback<YtsData>() {
                    @Override
                    public void onResponse(Call<YtsData> call, Response<YtsData> response) {
                        if(response.isSuccessful()) {
                            // 통신을 통해서 데이터를 넘겨받았으면 adapter에 데이터를 전달해서 화면을 갱신처리
                            List<Movie> list = response.body().getData().getMovies();
                            // 어댑터에 메소드 호출
                            movieAdapter.addItem(list);
                            currentPageNumber++;
                            preventDuplicateScrollEvent = true; // 통신 끝나면 다시 되돌려줌
                            isFirstLoading = false;
                            setVisibilityProgressBar(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<YtsData> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                        setVisibilityProgressBar(View.GONE);
                        // xml --> TEXT_VIEW = 네트워크가 불안정합니다 show
                    }
                });
    }
    // 통신해서 JSON 받은 다음에 매개변수로 데이터를 넘길 예정
    private void setupRecyclerView(List<Movie> movieList) {
        // 1. 어댑터
        movieAdapter = new MovieAdapter();
        movieAdapter.setOnMovieItemClicked(this);
        movieAdapter.initItemList(movieList);
        // 2. 매니저 필요
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        // 3. xml 파일에 선언한 recyclerView에 세팅
        RecyclerView recyclerView = binding.movieRecyclerView;
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.hasFixedSize();
        // 이벤트 리스너
        binding.movieRecyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                if (preventDuplicateScrollEvent) {
                    LinearLayoutManager layoutManager = (LinearLayoutManager)(binding.movieRecyclerView.getLayoutManager());
                    int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                    Log.d(TAG, "lastVisibleItemPosition " + lastVisibleItemPosition);
                    // adapter (데이터) list.size
                    // 한번 더 통신했을 때 (10)
                    //
                    int itemTotalCount = binding.movieRecyclerView.getAdapter().getItemCount() - 1; // 인덱스값과 맞춰주기위해 1을 뺀다
                    if (lastVisibleItemPosition == itemTotalCount) {
                        if (currentPageNumber != 1) {
                            Log.d(TAG, "check event!");
                            // 네트워크 요청
                            preventDuplicateScrollEvent = false;
                            requestMoviesData(currentPageNumber); // 2 (3) (4) (5)
                        }
                    }
                }
            }
        });
    }

    private void setVisibilityProgressBar(int visible) {
        binding.progressIndicator.setVisibility(visible);
    }

    @Override
    public void selectedItem(Movie movie) {
        Intent intent = new Intent(getContext(), MovieDetailActivity.class);
        // 직렬화란 object를 byte단위로 변환해서 던진다
        intent.putExtra(MovieDetailActivity.PARAM_NAME_1, movie);
        startActivity(intent);
    }
}