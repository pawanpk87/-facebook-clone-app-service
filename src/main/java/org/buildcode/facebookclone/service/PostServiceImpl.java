package org.buildcode.facebookclone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.buildcode.facebookclone.entity.PostEntity;
import org.buildcode.facebookclone.model.Post;
import org.buildcode.facebookclone.repository.PostEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
	private PostEntityRepository postEntityRepository;
	
	public PostServiceImpl(PostEntityRepository postEntityRepositor) {
		this.postEntityRepository = postEntityRepositor;
	}
	
	@Override
	public Post addPost(Post post) throws Exception {
		System.out.println("Got the request for adding post");
		System.out.println(post);
		
		try {
			PostEntity postEnity = new PostEntity();
			BeanUtils.copyProperties(post, postEnity);
			
			if(post.getFile() != null && !post.getFile().equalsIgnoreCase("null")) {
				postEnity.setImage(post.getFile());
			}
			else {
				postEnity.setImage(null);
			}
			
			postEnity = postEntityRepository.save(postEnity);
			
			post.setId(postEnity.getId());
			post.setFile(null);
			post.setImage(postEnity.getImage());			
		}catch(Exception ex) {
			throw new Exception("Could not save Post: "+ex);
		}
		
		return post;
	}
	
	@Override
    public List<Post> getPost() {
        List<PostEntity> postEntities
                = postEntityRepository.findAll();

        List<Post> posts = new ArrayList<>();
        
        for(PostEntity entity : postEntities) {
        	Post postObj = Post.builder()
				                  .id(entity.getId())
				                  .timeStamp(entity.getTimesStamp())
				                  .email(entity.getEmail())
				                  .name(entity.getName())
				                  .post(entity.getPost())
				                  .image(entity.getImage())
				                  .profilePic(entity.getProfilePic())
				                  .build();
        	posts.add(postObj);        	
        }
        
        System.out.println("Final list is:-");
        System.out.println(posts);
        
        return posts;
    }
}
