package com.example.myapplication.hw20

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding? = null
    private val binding: FragmentStartBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonClick()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun setImages() {
        val url1 =
            "https://e7.pngegg.com/pngimages/23/659/png-clipart-snowflake-freezing-ice-crystals-ice-axe-blue-cloud.png"
        val url2 = "https://photoshop-kopona.com/uploads/posts/2019-02/1549560943_1.jpg"
        val url3 =
            "https://e7.pngegg.com/pngimages/23/659/png-clipart-snowflake-freezing-ice-crystals-ice-axe-blue-cloud.png"
        val url4 =
            "https://w7.pngwing.com/pngs/890/1022/png-transparent-snowflake-red-building-blocks-toy-store-snowflakes-leaf-snowflakes-symmetry.png"
        val image1: ImageView = binding.ivFirstPhoto
        val image2: ImageView = binding.ivSecondPhoto
        val image3: ImageView = binding.ivThirdPhoto
        val image4: ImageView = binding.ivFourthPhoto

        val images = listOf(image1, image2, image3, image4)
        val urlImages = listOf(url1, url2, url3, url4)

        for (it in urlImages.indices) {
            Glide.with(this)
                .load(urlImages[it])
                .into(images[it])
        }
    }

    private fun buttonClick() {
        binding.button.setOnClickListener {
            val connectivityManager =
                context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val network = connectivityManager.activeNetwork
                val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
                val isConnectedToWifi =
                    networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true

                if (isConnectedToWifi) {
                    setImages()
                    binding.ivFirstPhoto.visibility = View.VISIBLE
                    binding.ivSecondPhoto.visibility = View.VISIBLE
                    binding.ivThirdPhoto.visibility = View.VISIBLE
                    binding.ivFourthPhoto.visibility = View.VISIBLE
                } else {
                    Toast.makeText(context, "Wi-fi isn't available", Toast.LENGTH_SHORT).show()
                }
            } else {

                val network = connectivityManager.activeNetwork
                val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
                val isConnectedToWifi =
                    networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true

                if (isConnectedToWifi) {
                    setImages()
                    binding.ivFirstPhoto.visibility = View.VISIBLE
                    binding.ivSecondPhoto.visibility = View.VISIBLE
                    binding.ivThirdPhoto.visibility = View.VISIBLE
                    binding.ivFourthPhoto.visibility = View.VISIBLE
                } else {
                    Toast.makeText(context, "Wi-fi isn't available", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}