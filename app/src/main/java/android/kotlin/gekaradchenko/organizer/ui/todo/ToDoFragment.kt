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
import android.kotlin.gekaradchenko.organizer.ui.todo.adapter.CalendarAdapter
import android.kotlin.gekaradchenko.organizer.ui.todo.adapter.ToDoCalendarAdapter
import android.kotlin.gekaradchenko.organizer.ui.todo.viewmodel.ToDoFragmentViewModel
import android.kotlin.gekaradchenko.organizer.ui.todo.viewmodel.ToDoFragmentViewModelFactory
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
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
        viewModel.create()


        /*-----------------------------calendar recycler view-------------------------------*/
        val calendarAdapter = CalendarAdapter(viewLifecycleOwner) {
            viewModel.focusOnDate(it)
        }
        val flexboxLayoutManager = FlexboxLayoutManager(requireContext())
        flexboxLayoutManager.flexDirection = FlexDirection.ROW
        flexboxLayoutManager.justifyContent = JustifyContent.FLEX_START

        binding.calendarRecyclerView.apply {
            layoutManager = flexboxLayoutManager
            adapter = calendarAdapter
        }

        viewModel.calendarList.observe(viewLifecycleOwner, {
            calendarAdapter.submitList(it)
        })

        /*-----------------------------to do calendar recycler view-------------------------------*/

        val toDoCalendarAdapter = ToDoCalendarAdapter()

        binding.toDoRecyclerView.apply {
            adapter = toDoCalendarAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.toDoCalendarList.observe(viewLifecycleOwner, {
            toDoCalendarAdapter.submitList(it)
        })


        return binding.root
    }


}