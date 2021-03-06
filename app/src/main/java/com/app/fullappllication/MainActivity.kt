package com.app.fullappllication

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.fullappllication.Adapter.MovieAdapter
import com.app.fullappllication.Common.Common
import com.app.fullappllication.DaggerClasses.Car
import com.app.fullappllication.Model.Movie
import com.app.fullappllication.Retrofit.RetrofitServices
import dmax.dialog.SpotsDialog
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var mService :RetrofitServices
    lateinit var layoutManager:LinearLayoutManager
    lateinit var adapter:MovieAdapter
    lateinit var dialog:AlertDialog
    lateinit var movieList:MutableList<Movie>

    private var TAG="MainActivity"
    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService=Common.retrofitService
        recyclerMovieList.setHasFixedSize(true)
        layoutManager= LinearLayoutManager(this)
        recyclerMovieList.layoutManager=layoutManager
        dialog=SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        movieList= mutableListOf<Movie>()
        adapter= MovieAdapter(baseContext, movieList)
        recyclerMovieList.adapter=adapter

       // getAllMovieList()

      //  DaggerDaggerComponent.create().inject(this)
      //  car.start()

        button.setOnClickListener(View.OnClickListener { startRStream() })
    }
    private fun getAllMovieList(){
        dialog.show()
        mService.getMovieList().enqueue( object : Callback<MutableList<Movie>>{
            override fun onResponse(
                call: Call<MutableList<Movie>>,
                response: Response<MutableList<Movie>>
            ) {
                movieList.addAll(response.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }

            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {

            }

        })
    }

    private fun startRStream(){
        val list=listOf(1,2,3,4,5)
        list.toObservable().subscribeBy(
                onNext = {println(it)},
                onComplete = {println("onComplete")},
                onError = {it.printStackTrace()}
        )
    }

  /*  private fun getObserver(): Observer<Int>{
        return object : Observer<Int>{
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: Int) {
                Log.d(TAG,"onNext: $t")
            }

            override fun onError(e: Throwable) {
                Log.e(TAG,"onError: $e")
            }

            override fun onComplete() {
                Log.d(TAG,"onComplete")
            }
        }
    }
    private fun getObservable() : Observable<Int> {
        return Observable.just(1,2,3)
    }*/
}