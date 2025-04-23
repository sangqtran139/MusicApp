package com.sangtq.musicapp

import android.media.MediaPlayer
import androidx.fragment.app.viewModels
import com.sangtq.ui.BaseFragment
import com.sangtq.musicapp.databinding.FragmentABinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentA : BaseFragment<FragmentABinding, AViewMOdel>() {

    override val viewModel: AViewMOdel by viewModels()
    override val layoutResId: Int = R.layout.fragment_a

    private var mediaPlayer: MediaPlayer? = null

    override fun initView() {
        super.initView()
        binding.btnClick.setOnClickListener {
            (requireActivity() as MainActivity).addFragment(FragmentB())
        }

        val audioUrl = "https://spotify-api.mybackend.in/download/Jack%20-%20J97/Thi%C3%AAn%20L%C3%BD%20%C6%A0i/Thi%C3%AAn%20L%C3%BD%20%C6%A0i-3ztP5O7dJSha2PG429eUCb.mp3?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=fb1f22f7dff2534061496f49%2F20250423%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250423T134251Z&X-Amz-Expires=900&X-Amz-SignedHeaders=host&X-Amz-Signature=03c1746c402aa2f52560bfc422dfaf369401b66a483b249d2533908a39caef2c"

        mediaPlayer = MediaPlayer().apply {
            setDataSource(audioUrl) // Set the audio URL
            setOnPreparedListener { start() } // Start playback when ready
            setOnCompletionListener {
                // Handle completion
                release()
            }
            prepareAsync() // Prepare the player asynchronously
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release() // Release resources when the activity is destroyed
        mediaPlayer = null
    }


    fun observerView() {
    }
}

