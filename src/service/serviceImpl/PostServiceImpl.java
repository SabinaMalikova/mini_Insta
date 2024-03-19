package service.serviceImpl;

import models.DataBase;
import models.Post;
import models.User;
import service.PostService;

import java.util.ArrayList;
import java.util.List;

public class PostServiceImpl implements PostService {
    @Override
    public String addPostToUser(Long userId, Post post) {
        for (User user : DataBase.users) {
            if (user.getId().equals(userId)) {
                user.getPosts().add(post);
                return "Successfully added!";
            }
        }
        return "not found";
    }


    @Override
    public String deletePostById(Long postId) {
        for (User user : DataBase.users) {
            for (Post post : user.getPosts()) {
                try {
                    if (post.getId().equals(postId)) {
                        user.getPosts().remove(post);
                        return "Successfully deleted";
                    }
                } catch (NullPointerException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        return "Not found";
    }

    @Override
    public List<Post> getPostByUserId(Long userId) {
        for (User user : DataBase.users) {
            if (user.getId().equals(userId)) {
                return user.getPosts();
            }
        }
        return new ArrayList<>();
    }
}
