package com.saini.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.saini.dao.AbstractDao;
import com.saini.dao.UserDao;
import com.saini.model.Users;
 

 
 
 
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, Users> implements UserDao {
 
    static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
     
    public Users findById(int id) {
        Users user = getByKey(id);
        if(user!=null){
            Hibernate.initialize(user.getUserProfiles());
        }
        return user;
    }
 
    public Users findBySSO(String sso) {
        logger.info("SSO : {}", sso);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        Users user = (Users)crit.uniqueResult();
        if(user!=null){
            Hibernate.initialize(user.getUserProfiles());
        }
        return user;
    }
 
    @SuppressWarnings("unchecked")
    public List<Users> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Users> users = (List<Users>) criteria.list();
         
        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
        /*
        for(User user : users){
            Hibernate.initialize(user.getUserProfiles());
        }*/
        return users;
    }
 
    public void save(Users user) {
        persist(user);
    }
 
    public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        Users user = (Users)crit.uniqueResult();
        delete(user);
    }
 
}