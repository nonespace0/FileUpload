package com.fileupload.localPath;

import com.fileupload.localPath.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
