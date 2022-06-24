package com.example.recyclerview2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var onigiriAdapter: OnigiriAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var onigiriList: ArrayList<Onigiri>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        // RecyclerViewのサイズを維持し続ける設定する
        // RecyclerViewのサイズが固定で決まっているならtrueにするが良い
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        onigiriList = ArrayList()

        /** おにぎりリストを100個表示する
         *
         */
        for (i in 0..9) {
            onigiriList.add(Onigiri(R.drawable.onigiri_tenmusu, "天むす", "人気No.1おにぎり"))
            onigiriList.add(Onigiri(R.drawable.onigiri_tarako, "たらこ", "人気No.3おにぎり"))
            onigiriList.add(Onigiri(R.drawable.onigiri_ume, "うめ", "さっぱりしたい時にオススメ"))
            onigiriList.add(Onigiri(R.drawable.onigiri_wakame, "わかめ", "わかめの香ばしさがオススメ"))
            onigiriList.add(Onigiri(R.drawable.onigiri_yakionigiri, "焼きおにぎり", "人気No.2おにぎり"))
            onigiriList.add(Onigiri(R.drawable.onigiri_sake, "鮭", "懐かしの味"))
            onigiriList.add(Onigiri(R.drawable.onigiri_ikura, "イクラ", "当店オススメ"))
            onigiriList.add(Onigiri(R.drawable.onigiri_seachicken, "ツナ", "お子さんに大人気"))
            onigiriList.add(Onigiri(R.drawable.onigiri_konbu, "こんぶ ", "定番の味"))
            onigiriList.add(Onigiri(R.drawable.onigiri_gomoku, "五目おにぎり", "五目ご飯を握り飯にしました"))
        }

        onigiriAdapter = OnigiriAdapter(onigiriList)
        recyclerView.adapter = onigiriAdapter

        // 下線を引く
        val dividerItemDecoration =
            DividerItemDecoration(this, LinearLayoutManager(this).orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)

        onigiriAdapter.onItemClick = {

            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("onigiri", it)
            startActivity(intent)

        }
    }
}




