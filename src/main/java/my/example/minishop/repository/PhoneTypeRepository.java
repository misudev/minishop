package my.example.minishop.repository;

import my.example.minishop.domain.PhoneType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneTypeRepository extends JpaRepository<PhoneType, Long> {

}
