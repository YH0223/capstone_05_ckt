package com.capstone5.newapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent

import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // 네비게이션바 아이템 선택 이벤트 처리
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_item_1 -> {
                    // "홈" 메뉴 아이템 클릭 시 처리할 내용
                    // 예를 들어, 메인 콘텐츠 프레임에 홈 화면을 표시하는 프래그먼트를 로드합니다.
                    // supportFragmentManager.beginTransaction().replace(R.id.main_content, HomeFragment()).commit()
                    true
                }
                R.id.menu_item_2 -> {
                    // "즐겨찾기" 메뉴 아이템 클릭 시 처리할 내용
                    // 예를 들어, 메인 콘텐츠 프레임에 즐겨찾기 화면을 표시하는 프래그먼트를 로드합니다.
                    true
                }
                R.id.menu_item_3 -> {
                    // "추천레시피" 메뉴 아이템 클릭 시 처리할 내용
                    // 예를 들어, 메인 콘텐츠 프레임에 추천 레시피 화면을 표시하는 프래그먼트를 로드합니다.
                    true
                }
                R.id.menu_item_4 -> {
                    // "설정" 메뉴 아이템 클릭 시 처리할 내용
                    // 예를 들어, 메인 콘텐츠 프레임에 설정 화면을 표시하는 프래그먼트를 로드합니다.
                    true
                }
                else -> false
            }
        }

    }
    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
        }

        fun openPostActivity(view: View) {
            val intent = Intent(this, PostActivity::class.java)
            when (view.id) {
                R.id.image1 -> intent.putExtra("postId", "post1")
                R.id.image2 -> intent.putExtra("postId", "post2")
                R.id.image3 -> intent.putExtra("postId", "post3")
                R.id.image4 -> intent.putExtra("postId", "post4")
            }
            startActivity(intent)
        }
    }

}