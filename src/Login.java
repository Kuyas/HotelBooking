import java.util.*;
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
class Login
{
	public static void main(String args[])
	{
		String fullName;
		int date,month,year; // yyyy-mm-dd
		String dob;
		String address;
		String email;
		String username;
		String password;
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
		Scanner s = new Scanner (System.in);
		System.out.println("Enter full name:");
		fullName = s.nextLine();
		System.out.println("Enter dd:");
		date = s.nextInt();
		System.out.println("Enter mm:");
		month = s.nextInt();
		System.out.println("Enter yyyy:");
		year = s.nextInt();
		Scanner s1 = new Scanner (System.in);
		System.out.println("Enter residential address:");
		address = s1.nextLine();
		System.out.println("Enter email id:");
		email = s1.nextLine();
		System.out.println("Enter username:");
		username = s1.nextLine();
		System.out.println("Enter password:");
		password = s1.nextLine();
		Pattern pat = Pattern.compile(emailRegex);
		if(email == null){
			System.out.println("False");
		}
		else if(pat.matcher(email).matches())//Pattern.matches("^[A-Z0-9._%+-]@[A-Z0-9.-].[A-Z]{2,6}$",email))
		{
			System.out.println("True");
			dob = (Integer.toString(year)+'-'+Integer.toString(month/10)+Integer.toString(month%10)+'-'+Integer.toString(date/10)+Integer.toString(date%10));
			System.out.println(fullName);
			System.out.println(dob);
			System.out.println(address);
			System.out.println(email);
			System.out.println(username);
			System.out.println(password);
		}
		else
		{
			System.out.println("False");
		}
	}
}
