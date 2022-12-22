package com.example.digitallibrary.Repository;

import com.example.digitallibrary.Model.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<LibraryUser,Integer> {
      LibraryUser findLibraryUserById(Integer id);
      LibraryUser findByUsernameAndPassword(String un,String pass);
}

