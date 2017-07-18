package com.example.ll.mvp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.example.ll.mvp.api.DoubanManager;
import com.example.ll.mvp.books.BooksFragment;
import com.example.ll.mvp.movies.MovieFragment;
import com.example.ll.mvp.movies.MoviePresenter;
import com.example.ll.mvp.movies.MoviesContract;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.sliding_tab)
    TabLayout mSlidingTab;
    @BindView(R.id.main_vp)
    ViewPager mMainVp;
    MainViewPagerAdapter mViewPageradapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        setupViewPager(mMainVp);
        if (mSlidingTab!=null){
            mSlidingTab.addTab(mSlidingTab.newTab());
            mSlidingTab.addTab(mSlidingTab.newTab());
            mSlidingTab.setupWithViewPager(mMainVp);
        }

    }
    private void setupViewPager(ViewPager viewPager){
        mViewPageradapter = new MainViewPagerAdapter(getSupportFragmentManager());
        MovieFragment movieFragment = MovieFragment.newInstance();
        mViewPageradapter.addFragment(movieFragment,getApplicationContext().getResources().getString(R.string.tab_movies_title));
        mViewPageradapter.addFragment(new BooksFragment(),getApplicationContext().getResources().getString(R.string.tab_books_title));
        mMainVp.setAdapter(mViewPageradapter);
        creatPresenter(movieFragment);
    }

    private void creatPresenter(MoviesContract.View fragment){
        new MoviePresenter(DoubanManager.creatDoubanService(),fragment);
    }

    private class MainViewPagerAdapter extends FragmentPagerAdapter{
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mTitles = new ArrayList<>();
        public MainViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        public void addFragment(Fragment fragment,String title){
            mFragments.add(fragment);
            mTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
    }
}
