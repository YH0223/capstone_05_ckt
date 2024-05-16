package com.capstone5.newapp

import androidx.recyclerview.widget.RecyclerView

object SearchWordManager {
    private const val MAX_WORDS = 10
    private val wordList = mutableListOf<SearchWord>()
    private lateinit var recyclerView: RecyclerView // RecyclerView 변수 추가

    // RecyclerView를 설정하는 메서드
    fun setRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = recyclerView
    }

    fun addWord(word: String) {
        if (wordList.size >= MAX_WORDS) {
            wordList.removeAt(0) // Remove the oldest word if the list exceeds the maximum size
        }
        wordList.add(SearchWord(word))
    }

    fun getWordList(): MutableList<SearchWord> {
        return wordList
    }

    fun updateRecyclerView() {
        val adapter = MyAdapter(wordList) // 최신 단어 목록으로 어댑터 생성
        recyclerView.adapter = adapter // RecyclerView에 어댑터 설정
        adapter.notifyDataSetChanged() // 어댑터에 데이터 변경 알림
    }
}

