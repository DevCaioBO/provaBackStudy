package com.lioncar.jarcar.repositorys;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lioncar.jarcar.DTOS.userDTO;
import com.lioncar.jarcar.models.userModel;

public interface userRepository extends JpaRepository<userModel,Long> {

	

}
