package com.springweb.app.Rest.Reinforcement.Repos;

import com.springweb.app.Rest.Reinforcement.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User, Long> {

}
