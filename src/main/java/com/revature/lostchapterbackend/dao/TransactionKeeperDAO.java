package com.revature.lostchapterbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.lostchapterbackend.model.TransactionKeeper;
@Repository
public interface TransactionKeeperDAO extends JpaRepository<TransactionKeeper, Integer>{

}
