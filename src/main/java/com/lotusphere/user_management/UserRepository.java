package com.lotusphere.user_management;

import jakarta.transaction.Transactional;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Create a persistence layer interface, defining an interface that abstracts the data access operations (CRUD operations) for your entities.
    // This helps in separating the data access logic from the business logic, promoting a clean architecture and easier testing.

    @Query("SELECT u FROM user u WHERE u.birthday = ?1")
    List<User> findByBirthday(LocalDate birthday);

    @Query(value = "SELECT * FROM user WHERE birthday =:birthday", nativeQuery = true)
    List<User> findByBirthdayNative(@Param("birthday") String birthday);
}
