package com.me.kotlinbase.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.me.kotlinbase.R

/**
 * Create by lzf on 2021/12/14
 */
class MainFragment : Fragment() {

    private val TAG = javaClass.name

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d(TAG, ">>onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, ">>onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, ">>onCreateView")
        val textView = TextView(context)
        return textView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, ">>onViewCreated")
        val int = arguments?.getInt("int_extra")
        val string = arguments?.getString("string_extra")
        Log.d(TAG, "int_extra:$int  string_extra:$string")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, ">>onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, ">>onStart")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        //当且仅当Activity存在多个Fragment，并且调用了show-hide方法时调用
        //hidden:当前Fragment可见的时候为false
        //hidden:当前Fragment不可见的时候为true
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, ">>onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, ">>onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, ">>onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //onCreateView返回的View对象被销毁的时候会执行这个回调
        Log.e(TAG, ">>onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        //Fragment对象被销毁的时候会调用
        Log.e(TAG, ">>onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e(TAG, ">>onDetach")
    }
}