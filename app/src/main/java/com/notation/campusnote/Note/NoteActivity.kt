package com.notation.campusnote.Note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notation.campusnote.R
import com.notation.campusnote.databinding.ActivityNoteBinding

class NoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteBinding
    private lateinit var adapter: NoteRVAdapter
    private lateinit var layoutManager: LinearLayoutManager

    private var currentPage = 1
    private var totalSize = 0 // 이미지 리스트의 크기를 저장하는 변수

    private val images = listOf(

        R.drawable.btn_color_select
        // 이미지 추가
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        totalSize = images.size // 이미지 리스트의 크기를 초기화

        adapter = NoteRVAdapter(images)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.notePaintRv.apply {
            setHasFixedSize(true)
            layoutManager = this@NoteActivity.layoutManager
            adapter = this@NoteActivity.adapter

            setOnTouchListener { _, _ ->
                true
            }
        }

        // Slider의 범위 및 변경 이벤트 처리
        binding.noteMenuPageBarSl.apply {
            valueFrom = 1f // 최소 값 설정
            valueTo = totalSize.toFloat() // 최대 값 설정
            stepSize = 1f // 슬라이더의 단계 크기 설정

            addOnChangeListener { slider, value, fromUser ->
                if (fromUser) { // 사용자에 의한 변경인지 확인
                    val targetPage = value.toInt()
                    if (targetPage != currentPage) {
                        currentPage = targetPage
                        updatePageInfo()
                        binding.notePaintRv.smoothScrollToPosition(currentPage - 1)
                    }
                }
            }
        }


        // 초기 페이지 설정
        currentPage = savedInstanceState?.getInt("currentPage") ?: 1
        updatePageInfo()
        binding.noteMenuTotalPageInfoTv.text = totalSize.toString()

//        // RecyclerView 스크롤 이벤트 처리 // 클라이언트가 슬라이드 넘길 때 부분, 오류가 너무 많아서 일단 슬라이드 말고 버튼으로만 넘길 수 있게 해놨습니다..
//        val scrollListener = object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    val position = layoutManager.findFirstVisibleItemPosition()
//                    val currentPageTemp = position + 1
//                    if (currentPageTemp != currentPage) {
//                        currentPage = currentPageTemp
//                        updateSliderProgress()
//                        updatePageInfo()
//                    }
//                }
//            }
//
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                // 스크롤 이벤트 발생 시 슬라이더 프로그레스 업데이트
//                updateSliderProgress()
//            }
//        }


        // RecyclerView에 스와이프 리스너 연결
        //binding.notePaintRv.addOnScrollListener(scrollListener)

        // 이전 페이지로 이동하는 버튼 클릭 이벤트 처리
        binding.noteMenuPrePageIv.setOnClickListener {
            previousPage()
        }

        // 다음 페이지로 이동하는 버튼 클릭 이벤트 처리
        binding.noteMenuNextPageIv.setOnClickListener {
            nextPage()
        }

        binding.noteMenuRecodeIv.setOnClickListener {
            //녹음
        }

        binding.noteMenuCameraIv.setOnClickListener {
            //카메라
        }

        binding.noteMenuSidePageIv.setOnClickListener {
            //사이드 페이지
        }

        binding.noteMenuUndoIv.setOnClickListener {
            //되돌리기
        }

        binding.noteMenuRedoIv.setOnClickListener {
            //되돌리기 취소
        }

        binding.noteMenuGalleryIv.setOnClickListener {
            //갤러리
        }

        binding.noteMenuPaintBrushIv.setOnClickListener {
            //페인트 붓
        }

        binding.noteMenuTextBoxIv.setOnClickListener {
            //텍스트 박스
        }

        binding.noteMenuEraserIv.setOnClickListener {
            //지우개
        }

        binding.noteMenuLayersIv.setOnClickListener {
            //메뉴 레이어
        }

        binding.noteMenuColorSelectIv.setOnClickListener {
            //색 선택
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("currentPage", currentPage)
    }

    // 이전 페이지로 이동하는 메서드
    private fun previousPage() {
        if (currentPage == 1) {
            Toast.makeText(this, "첫 번째 페이지입니다", Toast.LENGTH_LONG).show()
        } else {
            currentPage--
            updatePageInfo()
            binding.notePaintRv.smoothScrollToPosition(currentPage - 1)
        }
    }

    // 다음 페이지로 이동하는 메서드
    private fun nextPage() {
        if (currentPage < totalSize) {
            currentPage++
            updatePageInfo()
            binding.notePaintRv.smoothScrollToPosition(currentPage - 1)
        } else {
            Toast.makeText(this, "마지막 페이지입니다", Toast.LENGTH_LONG).show()
        }
    }

    // 페이지 정보를 업데이트하는 메서드
    private fun updatePageInfo() {
        binding.noteMenuCurPageInfoTv.text = currentPage.toString()
    }

    // 슬라이더의 프로그레스를 업데이트하는 메서드
    private fun updateSliderProgress() {
        binding.noteMenuPageBarSl.value = currentPage.toFloat()
    }
}