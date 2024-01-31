package com.notation.campusnote.signUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.notation.campusnote.R
import com.notation.campusnote.databinding.FragmentSignUp3Binding

class SignUp3Fragment : Fragment() {
    private var _binding: FragmentSignUp3Binding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUp3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as? SignUpActivity)?.onFragmentInteraction(isFinalFragment = false)
        (activity as? OnFragmentInteractionListener)?.onFirstFragmentShown(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}