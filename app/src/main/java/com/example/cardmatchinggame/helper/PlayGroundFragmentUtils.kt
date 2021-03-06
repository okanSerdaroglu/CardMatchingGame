package com.example.cardmatchinggame.helper

import com.example.cardmatchinggame.R
import com.example.cardmatchinggame.adapter.ImageListAdapter
import com.example.cardmatchinggame.helper.interfaces.IBoxSelected
import com.example.cardmatchinggame.model.Box
import com.example.cardmatchinggame.model.Level
import com.example.cardmatchinggame.model.SelectedBox
import com.example.cardmatchinggame.viewmodel.ItemImageViewModel
import com.example.cardmatchinggame.viewmodel.PlaygroundViewModel


class PlayGroundFragmentUtils {

    companion object {
        private val selectedBoxList = ArrayList<SelectedBox>()
        var listSize = 0

        fun getPlayGroundViewModel(viewModel: PlaygroundViewModel, levelID: Int) {
            viewModel.imageListAdapter = getImageListAdapter(levelID)
            if (levelID != 0) {
                viewModel.imageListAdapter.notifyDataSetChanged()
            }
            viewModel.stepCount.value = viewModel.imageListAdapter.itemCount / 2
            viewModel.imageListAdapter.iBoxSelected = object : IBoxSelected {
                override fun onBoxSelected(itemImageViewModel: ItemImageViewModel) {
                    checkSelectedBox(viewModel.imageListAdapter, viewModel, itemImageViewModel)
                }
            }
        }


        private fun checkSelectedBox(
            adapter: ImageListAdapter,
            viewModel: PlaygroundViewModel,
            selectedBox: ItemImageViewModel
        ) {

            val currentSelectedBox = SelectedBox(selectedBox.box, selectedBox.position, selectedBox)

            selectedBoxList.add(currentSelectedBox)
            if (selectedBoxList.size == 2) {
                if (selectedBoxList[0].box.id
                    != selectedBoxList[1].box.id
                ) {
                    selectedBoxList[0].itemImageViewModel.isBoxTurned.value = false
                    selectedBoxList[1].itemImageViewModel.isBoxTurned.value = false
                } else {
                    listSize += 2
                    if (listSize == adapter.itemImageViewModelList.size) {
                        viewModel.isLevelSuccess.value = true
                    }
                }
                adapter.notifyItemChanged(selectedBoxList[0].position)
                adapter.notifyItemChanged(selectedBoxList[1].position)
                selectedBoxList.clear()
            } else {
                adapter.notifyItemChanged(selectedBox.position)
            }
        }

        private fun getImageListAdapter(levelID: Int): ImageListAdapter {
            return ImageListAdapter(getItemViewModelList(levelID))
        }

        private fun getItemViewModelList(levelID: Int): ArrayList<ItemImageViewModel> {

            val imageList = prepareImageList()
            val itemImageViewModelList = ArrayList<ItemImageViewModel>()
            val level = prepareLevelList(imageList)[levelID]
            for ((position, box) in level.boxList.withIndex()) {
                itemImageViewModelList.add(ItemImageViewModel(box, position))
            }

            return itemImageViewModelList

        }


        enum class LevelNumbers(val value: Int) {
            LEVEL_1(3),
            LEVEL_2(4),
            LEVEL_3(6),
            LEVEL_4(8),
            LEVEL_DEF(3)
        }

        private fun prepareLevelList(imageList: ArrayList<Int>): ArrayList<Level> {

            val levelList = ArrayList<Level>()
            for (j in 1..4) {
                val boxList = ArrayList<Box>()
                for (i in 0 until getBoxNumberOfLevel(j)) {
                    val box = Box(i, imageList[i])
                    boxList.add(box)
                }
                boxList.addAll(boxList)
                val level = Level(j, boxList.shuffled() as ArrayList<Box>)
                levelList.add(level)
            }

            return levelList
        }

        private fun prepareImageList(): ArrayList<Int> {
            val imageList = arrayListOf<Int>()
            imageList.add(R.drawable.ic_bullseye_arrow)
            imageList.add(R.drawable.ic_duck)
            imageList.add(R.drawable.ic_emoticon_cool_outline)
            imageList.add(R.drawable.ic_gift)
            imageList.add(R.drawable.ic_mushroom)
            imageList.add(R.drawable.ic_music)
            imageList.add(R.drawable.ic_person)
            imageList.add(R.drawable.ic_pine_tree)
            imageList.add(R.drawable.ic_sail_boat)
            imageList.add(R.drawable.ic_trophy_variant)
            imageList.add(R.drawable.ic_volleyball)
            imageList.add(R.drawable.ic_white_balance_sunny)
            return imageList.shuffled() as ArrayList<Int>
        }

        private fun getBoxNumberOfLevel(levelID: Int): Int {

            return when (levelID) {
                1 -> {
                    LevelNumbers.LEVEL_1.value
                }
                2 -> {
                    LevelNumbers.LEVEL_2.value
                }
                3 -> {
                    LevelNumbers.LEVEL_3.value
                }
                4 -> {
                    LevelNumbers.LEVEL_4.value
                }
                else -> return LevelNumbers.LEVEL_DEF.value
            }

        }

    }
}