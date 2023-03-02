package org.buildcode.facebookclone.service;

import java.util.List;

import org.buildcode.facebookclone.model.Post;

public interface PostService {
    Post addPost(Post post) throws Exception;

    List<Post> getPost();
}