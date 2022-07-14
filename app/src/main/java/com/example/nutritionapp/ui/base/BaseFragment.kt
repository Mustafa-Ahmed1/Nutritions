package com.example.nutritionapp.ui.base

import CustomActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.nutritionapp.R
import com.example.nutritionapp.ui.HomeActivity
import com.example.nutritionapp.util.enum.StateNavigation

abstract class BaseFragment<VB : ViewBinding> : Fragment(), CustomActionBar{

    private var _binding: ViewBinding? = null
    abstract fun bindingInflater(): VB
    protected val binding get() = _binding as VB

    var  rootFragmentApp =  R.id.root_fragment
        get() = field
        set(value) {
            field = value
        }

    abstract fun setUp()

     override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater()
        setUp()

        (activity as HomeActivity).setUpCustomActionBar(visibilityCustomActionBar,title(),back())

        return requireNotNull(_binding).root
    }
    private fun changeNavigation(state: StateNavigation, from: Int?, to: Fragment){
        val transaction =requireActivity().supportFragmentManager.beginTransaction()

        when(state){
            StateNavigation.add -> transaction.add(from!!,to)
            StateNavigation.remove ->transaction.remove(to)
            StateNavigation.replace ->transaction.replace(from!!, to)
        }

        transaction.commit()
    }

    protected fun navigationTo(to: Fragment){
        changeNavigation(StateNavigation.add, rootFragmentApp, to)
    }

    protected fun backNavigation(to: Fragment){
        changeNavigation(StateNavigation.replace,rootFragmentApp, to)
    }

}