package com.example.myapplication.hw18.todoList

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class NumberAdapter(fragment: ListFragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        val fragmentInProgress = InProgressFragment.newInstance("Screen = $position")
        val fragmentDone = DoneFragment.newInstance("Screen = $position")
        val fragmentDeleted = DeletedFragment.newInstance("Screen = $position")

        return when(position){
            0-> fragmentInProgress
            1-> fragmentDone
            2-> fragmentDeleted
            else -> {fragmentInProgress}
        }
    }
}