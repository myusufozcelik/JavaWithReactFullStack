package deneme.northwind.business.concretes;

import deneme.northwind.business.abstracts.UserService;
import deneme.northwind.core.dataAccess.UserDao;
import deneme.northwind.core.entities.User;
import deneme.northwind.core.utilities.results.DataResult;
import deneme.northwind.core.utilities.results.Result;
import deneme.northwind.core.utilities.results.SuccessDataResult;
import deneme.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        userDao.save(user);
        return new SuccessResult("Kullanıcı eklendi");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(userDao.findByEmail(email), "Kullanıcı Bulundu");
    }
}
