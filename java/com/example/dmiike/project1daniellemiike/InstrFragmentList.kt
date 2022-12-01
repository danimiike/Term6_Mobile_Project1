package com.example.dmiike.project1daniellemiike

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.ListFragment
import java.lang.reflect.Array

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstrFragmentList : ListFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var levelsArray= arrayOf("Level 1", "Level 2", "Level 3", "Level 4")
    var levelsExplanation = arrayOf("Immediate Gratification: Pleasure and minimize pain.","Comparative/Personal Achievement: Ego Centeredness, better than, gain advantage.",
        "Contributive: Do good beyond self; Make an optimal positive difference for others.","Ultimate Good: Participate in giving and receiving ultimate meaning, goodness, ideals and love.")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_instr_list, container, false)
        val adapter = ArrayAdapter(
            requireActivity(),
            android.R.layout.simple_list_item_1, levelsArray
        )
        listAdapter = adapter
        return view
    }
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long){
        super.onListItemClick(l, v, position, id)
        val txt = getParentFragmentManager().findFragmentById(R.id.fragment2) as InstrFragmentDescription?
        txt?.change(levelsExplanation[position], levelsArray[position] )
        listView.setSelector(android.R.color.holo_blue_dark)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DialogFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}