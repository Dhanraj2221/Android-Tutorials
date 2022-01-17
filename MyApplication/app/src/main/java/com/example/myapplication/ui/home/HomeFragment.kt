package com.example.myapplication.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ExpandableParentItemBinding
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val list=ArrayList<MyModel>()

        list.add(MyModel("qqq","asdffbghnbfdssqwefrgbdswefg"))

        list.add(MyModel("qqq","asdffbghnbfdssqwefrgbdswefg"))

        list.add(MyModel("qqq","asdffbghnbfdssqwefrgbdswefg"))

        list.add(MyModel("qqq","asdffbghnbfdssqwefrgbdswefg"))

        list.add(MyModel("qqq","asdffbghnbfdssqwefrgbdswefg"))

        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager= LinearLayoutManager(requireContext())
        val adapter=MyAdapter(list)
        binding.rv.adapter=adapter
        adapter.notifyDataSetChanged()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class ExpandableCountryModel {
    companion object {
        const val PARENT = 1
        const val CHILD = 2

    }

    lateinit var countryParent: StateCapital.Country
    var type: Int
    lateinit var countryChild: StateCapital.Country.State
    var isExpanded: Boolean
    private var isCloseShown: Boolean


    constructor(
        type: Int,
        countryParent: StateCapital.Country,
        isExpanded: Boolean = false,
        isCloseShown: Boolean = false
    ) {
        this.type = type
        this.countryParent = countryParent
        this.isExpanded = isExpanded
        this.isCloseShown = isCloseShown

    }

    constructor(
        type: Int,
        countryChild: StateCapital.Country.State,
        isExpanded: Boolean = false,
        isCloseShown: Boolean = false
    ) {
        this.type = type
        this.countryChild = countryChild
        this.isExpanded = isExpanded
        this.isCloseShown = isCloseShown


    }
}

data class StateCapital(
    val countries: List<Country>
) {
    data class Country(
        val country: String, // India
        val states: List<State>
    ) {
        data class State(
            val capital: String, // Hyderabad
            val name: String // Telangana
        )
    }
}

data class MyModel(
    var title: String,
    var desc: String,
    var expnd: Boolean = false
)

class MyAdapter(var list: ArrayList<MyModel>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

//     private  var binding:ExpandableParentItemBinding ?= null
    inner class MyViewHolder(val binding: ExpandableParentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myModel: MyModel, i:Int){
            with(binding){
               textView2.text=myModel.title

                var isExpand=list[i].expnd
                parentRelative.visibility= if (isExpand) View.VISIBLE else View.GONE

                layout.setOnClickListener{
                    val v=list[i]
                    v.expnd = !v.expnd
                    notifyItemChanged(i)

                    for (i in list){
                       parentRelative.visibility= View.GONE
                    }
                }
            }
        }

    private fun expandRow(position: Int){
        val row = list[position]
        var nextPosition = position
                for(i in list){

                }
                notifyDataSetChanged()
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        var v= ExpandableParentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.bind(list[position],position)
    }

    override fun getItemCount(): Int = list.size

}


//class RecyclerAda(var countryStateModelList: ArrayList<StateCapital.Country>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return when(viewType) {
//            ExpandableCountryModel.PARENT -> {CountryStateParentViewHolder(LayoutInflater.from(parent.context).inflate(
//                R.layout.expandable_parent_item, parent, false))}
//
//            ExpandableCountryModel.CHILD -> { CountryStateChildViewHolder(LayoutInflater.from(parent.context).inflate(
//                R.layout.expandable_child_item, parent, false))  }
//
//            else -> {CountryStateParentViewHolder(LayoutInflater.from(parent.context).inflate(
//                R.layout.expandable_parent_item, parent, false))}
//        }
//    }
//
//    class CountryStateChildViewHolder(inflate: View?) : RecyclerView.ViewHolder(inflate!!) {
//        var txt=
//    }
//
//    class CountryStateParentViewHolder(inflate: View?) : RecyclerView.ViewHolder(inflate!!) {
//        var textView2=inflate!!.findViewById<TextView>(R.id.textView2)
//        var layout=inflate!!.findViewById<ConstraintLayout>(R.id.layout)
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val row = countryStateModelList[position]
//        when(row.type){
//            ExpandableCountryModel.PARENT -> {
//                (holder as CountryStateParentViewHolder).textView2.text = row.countryParent.country
//                holder.textView2.setOnClickListener {
//                    if (row.isExpanded) {
//                        row.isExpanded = false
//                        collapseRow(position)
//                        holder.layout.setBackgroundColor(Color.WHITE)
//
//
//                    }else{
//                        holder.layout.setBackgroundColor(Color.GRAY)
//                        row.isExpanded = true
//                        holder.upArrowImg.visibility = View.VISIBLE
//                        holder.closeImage.visibility = View.GONE
//                        expandRow(position)
//                    }
//                }
//                holder.upArrowImg.setOnClickListener{
//                    if(row.isExpanded){
//                        row.isExpanded = false
//                        collapseRow(position)
//                        holder.layout.setBackgroundColor(Color.WHITE)
//                        holder.upArrowImg.visibility = View.GONE
//                        holder.closeImage.visibility = View.VISIBLE
//
//                    }
//                }
//            }
//
//
//            ExpandableCountryModel.CHILD -> {
//                (holder as CountryStateChildViewHolder).stateName.text = row.countryChild.name
//                holder.capitalImage.text = row.countryChild.capital
//            }
//        }
//
//    }
//
//    override fun getItemCount(): Int = countryStateModelList.size
//}