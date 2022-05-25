package com.example.lamarianno.ui.camera

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lamarianno.MainActivity
import com.example.lamarianno.R
import com.example.lamarianno.databinding.FragmentCameraBinding
import java.io.File

private const val REQUEST_CODE = 42                                 //nu conteaza valoarea

class CameraFragment : Fragment() {

    private var _binding: FragmentCameraBinding? = null                 //referinta catre layout-ul home, care poate fi null
    private val binding get() = _binding!!                              //asteapta sa fie creat view-ul si sa returneze ceva (sa nu fie o referinta catre null)
    private val acc get() = requireActivity()                           //imi trebuia pentru ca sa obtin o referinta la contextul curent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCameraBinding.inflate(inflater, container, false)    //inflam view-ul fragmentului
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {                   //dupa ce a fost creat view-ul fragmentului
        super.onViewCreated(view, savedInstanceState)                                       //punem event de click pe buton ca atunci cand este apasat sa "faca o poza"
        var btnTakePicture = binding.buttonScan.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)                 //declararea intentiei de captura imagine
            if (takePictureIntent.resolveActivity(acc.packageManager) != null) {            //exista dispozitive care nu au camera si acelea returneaza null, deci verificam daca dispozitivul curent are camera
                startActivityForResult(takePictureIntent, REQUEST_CODE)                     //incepem activitatea cu intentia de a captura o imagine
            } else {
                Toast.makeText(acc.applicationContext, "Unable to open camera", Toast.LENGTH_SHORT).show()      //in cazul in care nu are camera telefonul
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {       //aici asteptam sa primim informatii de la actiunea lansata la apasarea butonului
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {              //daca request codul primit e identic cu cel trimis si a fost evectuata cu succes captura

            val takenImage = data?.extras?.get("data") as Bitmap                            //obtinem poza sub forma de data
            val imageView = binding.imageView                                               //referinta catre image view-ul din layout-ul fragmentului cu camera

            imageView.setImageBitmap(takenImage)                                            //modificam, folosind data binding, imageView-ul din layout-ul fragmentului
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}