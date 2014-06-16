public class TestMain{
	public static void main(String[] args){
		ThreeStooges thr = new ThreeStooges();
		thr.getStooges().add("Doris");
		thr.getStooges().remove("Moe");
		for(String str : thr.getStooges()){
			System.out.println(str);
		}
	}
}
