package com.lotusphere.user_management;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Create a persistence layer interface, defining an interface that abstracts the data access operations (CRUD operations) for your entities.
    // This helps in separating the data access logic from the business logic, promoting a clean architecture and easier testing.
}
