/**
 * 
 */
package com.example.demo;

//import com.example.demo.Expense;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
  List<Expense> findAll();
  
  List<Expense> findByid(Long paramLong);
  
  List<Expense> findByItem(String paramString);
  
  @Query("SELECT e FROM Expense e WHERE e.amount >= :amount")
  List<Expense> listItemsWithPriceOver(@Param("amount") float paramFloat);
  
  /*@Override
  @RestResource(exported = false)
  void delete(Long id);
  */

}

