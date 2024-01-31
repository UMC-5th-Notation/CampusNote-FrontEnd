package com.notation.campusnote.signUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.notation.campusnote.R
import com.notation.campusnote.databinding.FragmentSignUp2Binding

class SignUp2Fragment : Fragment() {
    private var _binding: FragmentSignUp2Binding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUp2Binding.inflate(inflater, container, false)

        // 다음 버튼 클릭 리스너 안에서
        binding.signUp2NextBtn.setOnClickListener {
            // signUp3Fragment 인스턴스 생성
            val signUp3Fragment = SignUp3Fragment()

            // Activity에서 FragmentManager를 가져와서 트랜잭션 시작
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                // FrameLayout에 SignUp2Fragment 교체
                replace(R.id.sign_up_frame, signUp3Fragment)
                // 트랜잭션을 백 스택에 추가
                addToBackStack(null)
                // 트랜잭션 커밋
                commit()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}