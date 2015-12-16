package ua.org.oa.podkopayv.zmarket3.service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.oa.podkopayv.zmarket3.model.User;

@Service
@Repository
//@Transactional
public class UserService implements UserDetailsService {

//    private static final Logger log = Logger.getLogger(UserService.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User U WHERE U.username=:username");
        query.setParameter("username", username);
        User result = (User) query.uniqueResult();
//        log.info("Load user: " + result);
        return result;
    }
}
