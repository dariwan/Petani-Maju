package com.dariwan.petanimaju.view.education

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dariwan.petanimaju.R
import com.dariwan.petanimaju.adapter.EducationAdapter
import com.dariwan.petanimaju.databinding.FragmentEducationBinding
import com.dariwan.petanimaju.model.EducationModel

class EducationFragment : Fragment() {

    private var _binding: FragmentEducationBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEducationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_education, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAction()
    }

    private fun setupAction() {
        binding.rvEducation.layoutManager = LinearLayoutManager(requireContext())
        val dataList: MutableList<EducationModel> = mutableListOf()
        val educationTitle: Array<String> = resources.getStringArray(R.array.title_education)
        val educationDesc: Array<String> = resources.getStringArray(R.array.desc_education)
        val educationImage: List<Int> = listOf(
            R.drawable.img_education_1,
            R.drawable.img_education_2,
            R.drawable.img_education_3,
            R.drawable.img_education_4,
            R.drawable.img_education_5,
            R.drawable.img_education_6,
        )

        educationTitle.forEachIndexed { index, name ->
            dataList.add(EducationModel(educationImage.get(index), name, educationDesc[index]))
        }

        val adapter = EducationAdapter(dataList)
        binding.rvEducation.adapter = adapter

        adapter.setOnItemClickCallback(object : EducationAdapter.OnItemClickCallback{
            override fun onItemClicked(data: EducationModel) {
                val intent = Intent(requireContext(), DetailEducationActivity::class.java)
                intent.putExtra("DATA", data)
                startActivity(intent)
            }

        })

    }

}