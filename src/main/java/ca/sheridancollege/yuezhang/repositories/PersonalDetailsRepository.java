package ca.sheridancollege.yuezhang.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.yuezhang.beans.PersonalDetails;


@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long>{

}
