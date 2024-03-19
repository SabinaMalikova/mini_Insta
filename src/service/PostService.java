package service;

import models.Post;

import java.util.List;

public interface PostService {
    String addPostToUser(Long userId,Post post);
    String deletePostById(Long postId);
    List<Post>getPostByUserId(Long userId);


}
