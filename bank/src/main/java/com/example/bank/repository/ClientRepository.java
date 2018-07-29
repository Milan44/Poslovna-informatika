package com.example.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bank.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	Client findOneById(Long id);
	
	@Query(value="SELECT * FROM client cli where (:address is null or cli.address = :address) and "
			+ "(:addressForStatements is null or cli.addressForStatements = :addressForStatements) and "
			+ "(:email is null or cli.email = :email) and "
			+ "(:fax is null or cli.fax = :fax) and "
			+ "(:jmbg is null or cli.jmbg = :jmbg) and "
			+ "(:name is null or cli.name = :name) and "
			+ "(:phone is null or cli.phone = :phone) and "
			+ "(:pib is null or cli.pib = :pib) and "
			+ "(:typeOfClient is null or cli.typeOfClient = :typeOfClient) and "
			+ "(:residence_id is null or cli.residence_id = :residence_id)", nativeQuery = true)
	public List<Client> searchClients(@Param("address")String address, @Param("addressForStatements")String addressForStatements, @Param("email")String email,
			@Param("fax")String fax, @Param("jmbg")String jmbg, @Param("name")String name, @Param("phone")String phone, @Param("pib")String pib, 
			@Param("typeOfClient")String typeOfClient, @Param("residence_id")Long residence_id);

}
