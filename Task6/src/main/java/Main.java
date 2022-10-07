public class Main {
    static public void main(String[] args){
        Company company=new Company(5);
        Founder founder=new Founder(company);
        founder.start();
    }
}
