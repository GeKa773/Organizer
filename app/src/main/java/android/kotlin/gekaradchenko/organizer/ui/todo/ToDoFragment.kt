package android.kotlin.gekaradchenko.organizer.ui.todo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.kotlin.gekaradchenko.organizer.R
import android.kotlin.gekaradchenko.organizer.appComponent
import android.kotlin.gekaradchenko.organizer.databinding.FragmentToDoBinding
import android.kotlin.gekaradchenko.organizer.ui.todo.viewmodel.ToDoFragmentViewModel
import android.kotlin.gekaradchenko.organizer.ui.todo.viewmodel.ToDoFragmentViewModelFactory
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class ToDoFragment : Fragment() {

    private lateinit var viewModel: ToDoFragmentViewModel

    @Inject
    lateinit var factory: ToDoFragmentViewModelFactory

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding: FragmentToDoBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_to_do, container, false
        )
        viewModel = ViewModelProvider(this, factory).get(ToDoFragmentViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel






        return binding.root
    }


}