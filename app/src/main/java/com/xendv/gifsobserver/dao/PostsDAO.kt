package com.xendv.gifsobserver.dao

import com.xendv.gifsobserver.dataClasses.Post
import com.xendv.gifsobserver.dataClasses.PostNode

class PostsDAO {
    var tempPost: PostNode? = null

    fun getNextSavedPost(): Post? {
        tempPost = tempPost?.next
        return tempPost?.post
    }

    fun getPrevSavedPost(): Post? {
        tempPost = tempPost?.prev
        return tempPost?.post
    }

    fun savePost(newPost: Post) {
        if (tempPost != null) {
            tempPost?.next = PostNode(newPost, tempPost)
            tempPost = tempPost?.next
        }
        else tempPost = PostNode(newPost)
    }
}