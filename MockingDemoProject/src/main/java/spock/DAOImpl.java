package spock;

public class DAOImpl implements DAO{

	@Override
	public int saveUser(String name) {
		int uid=90;
		System.out.println("saving user with name:"+name);
		return uid;
	}

}
