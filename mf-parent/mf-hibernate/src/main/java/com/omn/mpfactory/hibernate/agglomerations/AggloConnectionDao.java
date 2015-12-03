package com.omn.mpfactory.hibernate.agglomerations;

import java.util.List;

import com.omn.mpfactory.model.AggloConnection;

public interface AggloConnectionDao {
	
    List<AggloConnection> findCitiesByAgglomerationId(Long agglomId);
    void create(AggloConnection aggloConnection);

}
