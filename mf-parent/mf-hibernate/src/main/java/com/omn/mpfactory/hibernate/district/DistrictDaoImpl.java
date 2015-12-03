package com.omn.mpfactory.hibernate.district;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.omn.mpfactory.hibernate.generic.GenericDaoImpl;
import com.omn.mpfactory.model.District;

@Repository
public class DistrictDaoImpl extends GenericDaoImpl<District> implements DistrictDao {

    public DistrictDaoImpl() {
        super(District.class);
    }

    @Override
    @Transactional
    public List<District> findDistrictListByCityId(Long cityId) {
        List<District> districtList = getDistrictList(cityId);
        if (CollectionUtils.isEmpty(districtList)) {
            return null;
        }
        return districtList;
    }

    @Override
    @Transactional
    public Boolean isDistrictInCity(Long cityId) {
        List<District> districtList = getDistrictList(cityId);
        if (CollectionUtils.isEmpty(districtList)) {
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    private List<District> getDistrictList(Long cityId){
        return (List<District>) getSessionFactory()
                .getCurrentSession().createCriteria(District.class)
                .add(Restrictions.eq("city.id", cityId)).list();
    }
}
