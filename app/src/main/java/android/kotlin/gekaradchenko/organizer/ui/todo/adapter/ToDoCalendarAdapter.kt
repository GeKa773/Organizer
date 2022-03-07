package android.kotlin.gekaradchenko.organizer.ui.todo.adapter

import android.kotlin.gekaradchenko.organizer.data.pojo.CalendarData
import android.kotlin.gekaradchenko.organizer.data.pojo.ToDoCalendarData
import android.kotlin.gekaradchenko.organizer.databinding.ItemTodoCalendarBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ToDoCalendarAdapter :
    ListAdapter<ToDoCalendarData, ToDoCalendarAdapter.ViewHolder>(DiffCallback) {

    inner class ViewHolder(private val binding: ItemTodoCalendarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ToDoCalendarData) {
            binding.data = item
        }

    }

    private companion object DiffCallback : DiffUtil.ItemCallback<ToDoCalendarData>() {
        override fun areItemsTheSame(
            oldItem: ToDoCalendarData,
            newItem: ToDoCalendarData,
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: ToDoCalendarData,
            newItem: ToDoCalendarData,
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemTodoCalendarBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}