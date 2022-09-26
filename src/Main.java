public class Main {
    public static void main(String[] args) {
        String login = "hello647";
        String password = "password2546";
        String confirmPassword = "password2546";
        System.out.println(acceptTheParamets(login, password, confirmPassword));
    }

    public static boolean acceptTheParamets(String login, String password, String confirmPassword) {
        
        boolean loginVerifiation;
        boolean passwordVerification;
        boolean passwordLengthVerification;

        try {
            loginVerifiation = wordInLoginVerification(login);
            passwordVerification = wordInLoginVerification(password);
            verificatLengthLogin(login);
            passwordLengthVerification = verificatLengthPassword(password);
            passwordEqualityVerification(password, confirmPassword);
        } catch (WrongLoginException exception) {
            System.out.println(exception.getMessage());
            return false;
        } catch (WrongPasswordException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return loginVerifiation && passwordVerification && passwordLengthVerification;
    }

    public static boolean wordInLoginVerification(String verificatWord) {
        if (verificatWord ==null) {
            System.out.println("Не введено слово");
            return false;
        }
        if (verificatWord.matches("\\w+")) {
            return true;
        }
        System.out.printf("Недоступные символы в слове - %s\n", verificatWord);
        return false;
    }

    public static boolean verificatLengthLogin(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Логин доллжен быть меньше или равен 20 символам");
        }
        return true;
    }

    public static boolean verificatLengthPassword(String password) {
        if (password.length() > 19) {
            System.out.println("Пароль должен быть мнеьше 20 символов");
            return false;
        }
        return true;
    }

    public static boolean passwordEqualityVerification(String password,String confirmPassword) throws WrongPasswordException {
        if (password.equals(confirmPassword)) {
            return true;
        }
        throw new WrongPasswordException("Пароли не совпадают");
    }

}