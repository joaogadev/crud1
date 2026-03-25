package com.api.crup1.Repository;

import com.api.crup1.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserModel, Long> {

}
