package org.buildcode.facebookclone.repository;

import org.buildcode.facebookclone.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostEntityRepository extends JpaRepository<PostEntity,String> {
	
}
