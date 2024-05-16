import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.capstone5.newapp.MyAdapter
import com.capstone5.newapp.R
import com.capstone5.newapp.SearchWordManager

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search) // search.xml 레이아웃을 화면에 표시

        val searchEditText: EditText = findViewById(R.id.search_insert_text)

        searchEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                // 사용자가 키보드의 완료 버튼을 누르면 실행할 작업을 여기에 추가합니다.
                val word = searchEditText.text.toString()
                SearchWordManager.addWord(word)
                updateRecyclerView() // RecyclerView 업데이트 메서드 호출
                true
            } else {
                false
            }
        }


    }

    private fun updateRecyclerView() {
        // RecyclerView 어댑터와 데이터 연결
        val recyclerView = findViewById<RecyclerView>(R.id.search_recycler)
        val wordList = SearchWordManager.getWordList()
        val adapter = MyAdapter(wordList)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}
