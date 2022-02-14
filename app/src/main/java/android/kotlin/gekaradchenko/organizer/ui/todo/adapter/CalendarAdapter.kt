package android.kotlin.gekaradchenko.organizer.ui.todo.adapter

import android.kotlin.gekaradchenko.organizer.R
import android.kotlin.gekaradchenko.organizer.data.pojo.CalendarData
import android.kotlin.gekaradchenko.organizer.databinding.ItemCalendarBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CalendarAdapter(
    private val lifecycleOwner: LifecycleOwner,
    private val click: (item: CalendarData) -> Unit,
) :
    ListAdapter<CalendarData, CalendarAdapter.ViewHolder>(DiffCallback) {


    inner class ViewHolder(private val binding: ItemCalendarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                click.invoke(getItem(adapterPosition))
            }
        }

        fun bind(item: CalendarData) {
            binding.data = item
            item.isFocusLiveData.observe(lifecycleOwner, {
                if (it) {
                    binding.textView.background =
                        itemView.context.getDrawable(R.drawable.calendar_text_view_background)
                } else {
                    binding.textView.background =
                        itemView.context.getDrawable(R.drawable.transparent_background)
                }
            })

        }
    }

    private companion object DiffCallback : DiffUtil.ItemCallback<CalendarData>() {
        override fun areItemsTheSame(oldItem: CalendarData, newItem: CalendarData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: CalendarData, newItem: CalendarData): Boolean {
            return oldItem.isFocus == newItem.isFocus
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCalendarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}