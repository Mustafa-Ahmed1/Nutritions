package com.example.nutritionapp.ui.base

import com.example.nutritionapp.`interface`.CustomActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.nutritionapp.R
import com.example.nutritionapp.ui.activity.HomeActivity
import com.example.nutritionapp.util.enum.StateNavigation

abstract class BaseFragment<VB : ViewBinding> : Fragment(), CustomActionBar {

    private lateinit var _binding: VB
    abstract fun bindingInflater(): VB
    protected val binding get() = _binding

    abstract fun setUp()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater()
        setUp()

        (activity as HomeActivity).setUpCustomActionBar(visibilityCustomActionBar, getTitle(), back())

        return requireNotNull(_binding).root
    }

    private fun changeNavigation(state: StateNavigation, to: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()

        when (state) {
            StateNavigation.Add -> transaction.add(R.id.root_fragment, to)
            StateNavigation.Remove -> transaction.remove(to)
            StateNavigation.Replace -> transaction.replace(R.id.root_fragment, to)
        }
        transaction.addToBackStack(null).commit()
    }

    protected fun navigationTo(to: Fragment) {
        changeNavigation(StateNavigation.Replace, to)
    }

    protected fun backNavigation(to: Fragment) {
        changeNavigation(StateNavigation.Replace, to)
    }

}