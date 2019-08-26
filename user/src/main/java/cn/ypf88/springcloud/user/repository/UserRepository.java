package cn.ypf88.springcloud.user.repository;

import cn.ypf88.springcloud.user.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
