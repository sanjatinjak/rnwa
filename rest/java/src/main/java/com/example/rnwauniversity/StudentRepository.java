package com.example.rnwauniversity;


import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findById(int id);

    public Student deleteById(int id);

   
    
}
