package com.pernix.einvoicing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
 
@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

}
