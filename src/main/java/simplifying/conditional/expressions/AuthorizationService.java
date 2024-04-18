package simplifying.conditional.expressions;

public class AuthorizationService {
  public boolean isAuthorized(User user, String action) {
    if ((action == null )|| (action.equals("")) || (user.getAge() < 18) ||  (user.isDisabled()) || (!user.isLoyal())) {
      return false;
    }
    return true;
  }
}
