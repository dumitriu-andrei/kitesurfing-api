package com.andreiDumitriu.Kitesurfing.repositories;

import com.andreiDumitriu.Kitesurfing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsername(String username);

    @Modifying
    @Query(value = "INSERT INTO favorites(location_id,user_id) VALUES(:locationID,:userID)",nativeQuery = true)
    @Transactional
    void insertFavorite(@Param("locationID") Long locID,@Param("userID") Long userID);

    @Query(value = "SELECT id FROM User WHERE username=:name")
    Long getUserIdByName(@Param("name") String userName);



}




