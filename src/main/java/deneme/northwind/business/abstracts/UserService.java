package deneme.northwind.business.abstracts;

import deneme.northwind.core.entities.User;
import deneme.northwind.core.utilities.results.DataResult;
import deneme.northwind.core.utilities.results.Result;

public interface UserService {
    Result add(User user);

    DataResult<User> findByEmail(String email);
}
