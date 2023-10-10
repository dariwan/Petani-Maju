package com.dariwan.petanimaju.view.education

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dariwan.petanimaju.R
import com.dariwan.petanimaju.databinding.ActivityDetailEducationBinding
import com.dariwan.petanimaju.model.EducationModel

class DetailEducationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailEducationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailEducationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {
        val data = intent.getParcelableExtra<EducationModel>("DATA")
        binding.imgDetailEducation.setImageResource(data?.image!!)
        binding.tvTitle.text = data?.title

        val titleEducation = listOf(
            "Ini Beberapa Cara Memberikan Pupuk pada Tanaman",
            "MENGUKUR PH TANAH",
            "Teknik Pemupukan Tanaman Padi Yang Tidak Semua Orang Tahu",
            "Cara membuat pupuk organik cair",
            "PEMUPUKAN PADA TANAMAN JAGUNG",
            "Pemupukan Berimbang,, Hasil Maksimal",
        )

        val educationList = resources.getStringArray(R.array.desc_education)
        binding.tvContent.text = when(data?.title){
            titleEducation[0] -> educationList[0]
            titleEducation[1] -> educationList[1]
            titleEducation[2] -> educationList[2]
            titleEducation[3] -> educationList[3]
            titleEducation[4] -> educationList[4]
            titleEducation[5] -> educationList[5]
            else -> "Content not founf"
        }
    }
}