package com.example.dmiike.project1daniellemiike

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val checkedItem = 1
var levels = arrayOf("Level 1", "Level 2", "Level 3", "Level 4")

/**
 * A simple [Fragment] subclass.
 * Use the [ListLevelsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListLevelsFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var sendMessages: SendMessages? = null
    private var test: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListLevelsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(title: Int): ListLevelsFragment? {
            val fragment = ListLevelsFragment()
            val args = Bundle()
            args.putInt("title", title)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = requireArguments()!!.getInt("title")
        return AlertDialog.Builder(activity)
            .setTitle(title)
            .setSingleChoiceItems(levels, checkedItem,
                DialogInterface.OnClickListener { dialog, which ->
                    test = levels[which]
                })
            .setPositiveButton(R.string.alert_dialog_ok,
                DialogInterface.OnClickListener { dialog, whichButton ->
                    (activity as MainActivity?)
                        ?.doPositiveClick()
                    sendMessages!!.choiceMade(test)
                })
            .setNegativeButton(R.string.alert_dialog_cancel,
                DialogInterface.OnClickListener { dialog, whichButton ->
                    (activity as MainActivity?)
                        ?.doNegativeClick()
                }).create()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        sendMessages = context as SendMessages
    }

    //Interface - send message from this fragment to main activity
    internal interface SendMessages {
        fun choiceMade(msg: String?)
    }
}