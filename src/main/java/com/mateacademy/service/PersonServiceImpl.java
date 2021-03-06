package com.mateacademy.service;

import com.mateacademy.entity.Person;
import com.mateacademy.entity.PersonDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** This class marked as "personService"
 *  using @Service annotation. Use @Autowired
 *  annotation to autowire PersonDao bean.
 *  It contains methods which realize PersonDao
 *  methods.
 */

@Service("personService")
public class PersonServiceImpl implements PersonService {
    private static final Logger LOGGER = Logger.getLogger(PersonServiceImpl.class);

    @Autowired
    private PersonDao personDao;

    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    public void editPerson(Person person) {
        personDao.editPerson(person);
    }

    public int getId(Person person) {
        return personDao.getId(person);
    }

    public void deletePerson(int personId) {
        personDao.deletePerson(personId);
    }

    public Person find(int personId) throws MyException{
        return personDao.find(personId).orElseThrow(MyException::new);
    }

    public List<Person> findAll() {
        return personDao.findAll();
    }
}

