package ua.org.oa.podkopayv.zmarket3.service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.org.oa.podkopayv.zmarket3.model.User;

import javax.transaction.Transactional;

public class UserService implements UserDetailsService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.username=:username");
        query.setParameter("username", username);
        User result = (User) query.uniqueResult();
        return result;
    }
}
