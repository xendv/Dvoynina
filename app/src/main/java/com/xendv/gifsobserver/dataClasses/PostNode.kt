package com.xendv.gifsobserver.dataClasses

data class PostNode(var post: Post, var prev: PostNode? = null, var next: PostNode? = null) {}