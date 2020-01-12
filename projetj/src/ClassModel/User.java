package ClassModel;

public class User {
	
		private String name;
		private String mdp;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMdp() {
			return mdp;
		}
		public void setMdp(String mdp) {
			this.mdp = mdp;
		}
		public User(String name, String mdp) {
			super();
			this.name = name;
			this.mdp = mdp;
		}
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		}



