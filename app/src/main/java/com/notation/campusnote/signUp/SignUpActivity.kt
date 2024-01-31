package com.notation.campusnote.signUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.notation.campusnote.R
import com.notation.campusnote.databinding.ActivitySignUpBinding

interface OnFragmentInteractionListener {
    fun onFragmentInteraction(isFinalFragment: Boolean)
    fun onFirstFragmentShown(isFirstFragment: Boolean)
}

class SignUpActivity : AppCompatActivity(), OnFragmentInteractionListener {
    private lateinit var binding: ActivitySignUpBinding
    private var currentFragmentIndex = 1 // 현재 프래그먼트 인덱스

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        // 초기 프래그먼트 로드
        loadFragment(SignUp1Fragment())

        // 버튼 클릭 리스너 설정
        binding.signUpNextBtn.setOnClickListener {
            when (currentFragmentIndex) {
                1 -> {
                    loadFragment(SignUp2Fragment())
                    currentFragmentIndex++
                }
                2 -> {
                    loadFragment(SignUp3Fragment())
                    currentFragmentIndex++
                }
                3 -> {
                    loadFragment(SignUp4Fragment())
                    currentFragmentIndex++
                    // 마지막 프래그먼트에 도달했을 때 인터페이스 호출
                    onFragmentInteraction(isFinalFragment = true)
                }
                4 -> {
                    // 여기에 완료 버튼이 눌렸을 때의 로직을 구현합니다.
                    // 예: 데이터 저장, 결과 화면으로 전환 등
                }
            }
        }
    }

    override fun onBackPressed() {
        when {
            currentFragmentIndex == 1 -> {
                // 첫 번째 프래그먼트 (SignUp1Fragment)에서 뒤로 가기를 누르면 앱 종료
                finish()
            }
            supportFragmentManager.backStackEntryCount == 1 -> {
                // 마지막 프래그먼트에서 뒤로 가기를 누를 경우
                binding.signUpNextBtn.background = ContextCompat.getDrawable(this, R.drawable.sign_up_next_btn_background)
                currentFragmentIndex--
                super.onBackPressed()
            }
            supportFragmentManager.backStackEntryCount > 1 -> {
                // 백 스택에 두 개 이상의 프래그먼트가 있는 경우 이전 프래그먼트로 돌아감
                supportFragmentManager.popBackStack()
                currentFragmentIndex--
            }
            else -> {
                // 백 스택이 비어있으면 기본 동작을 수행
                super.onBackPressed()
            }
        }
    }

    // 프래그먼트 로드 함수
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.signUpFrame.id, fragment)
            addToBackStack(null) // 프래그먼트 교체를 백 스택에 추가
            commit()
        }
    }

    override fun onFragmentInteraction(isFinalFragment: Boolean) {
        if (isFinalFragment) {
            binding.signUpNextBtn.apply {
                text = "완료"
                //setBackgroundColor(ContextCompat.getColor(context, R.color.black))
                // 또는 배경을 drawable 리소스로 설정하는 경우
                 background = ContextCompat.getDrawable(context, R.drawable.sign_up_done_btn_background)
            }
        } else {
            binding.signUpNextBtn.apply {
                text = "다음"
                //setBackgroundColor(ContextCompat.getColor(context, R.color.your_original_color))
                // 또는 배경을 drawable 리소스로 설정하는 경우
                 background = ContextCompat.getDrawable(context, R.drawable.sign_up_next_btn_background)
            }
        }
    }

    override fun onFirstFragmentShown(isFirstFragment: Boolean) {
        binding.btnBack.visibility = if (isFirstFragment) View.GONE else View.VISIBLE
    }
}