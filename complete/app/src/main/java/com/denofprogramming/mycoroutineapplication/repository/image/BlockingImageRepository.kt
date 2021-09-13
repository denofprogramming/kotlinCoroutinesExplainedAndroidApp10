package com.denofprogramming.mycoroutineapplication.repository.image

import android.graphics.Bitmap
import com.denofprogramming.mycoroutineapplication.network.allImages
import com.denofprogramming.mycoroutineapplication.shared.Resource
import com.denofprogramming.mycoroutineapplication.shared.uilt.logMessage

class BlockingImageRepository(
) {

    private var _count: Int = -1

    fun fetchImage(imageId: String): Resource<Bitmap> {

        logMessage("Start fetchImage() downloading...")
        Thread.sleep(10000)
        logMessage("Start fetchImage() download Success.")
        return Resource.success(allImages[imageId.toInt()])

    }

    fun nextImageId(): String {
        _count++
        if (_count > allImages.size - 1) {
            _count = 0
        }
        return _count.toString()
    }

    companion object {

        fun build(): BlockingImageRepository {
            return BlockingImageRepository()
        }
    }


}