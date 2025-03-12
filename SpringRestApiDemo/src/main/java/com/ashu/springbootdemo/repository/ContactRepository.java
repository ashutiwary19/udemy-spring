package com.ashu.springbootdemo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ashu.springbootdemo.model.Contact;

import jakarta.transaction.Transactional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
	public List<Contact> findByStatus(String status);

//	@Query(value = "SELECT * FROM contact_msg where status=:status", nativeQuery = true)
	@Query("FROM Contact WHERE status=:status")
	public Page<Contact> findByStatus(@Param("status") String status, Pageable pageable);

	@Transactional
	@Modifying
	@Query("UPDATE Contact c set c.status=:status WHERE c.contactId=:contactId")
	public int updateStatusById(String status, Integer contactId);

	Page<Contact> findOpenMsgs(@Param("status") String status, Pageable pageable);

	@Transactional
	@Modifying
	int updateMsgStatus(String status, int id);

	@Query(nativeQuery = true)
	Page<Contact> findOpenMsgsNative(@Param("status") String status, Pageable pageable);

	@Transactional
	@Modifying
	@Query(nativeQuery = true)
	int updateMsgStatusNative(String status, int id);
}
