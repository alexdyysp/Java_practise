public class Net extends Maintainer{
    public Net(String name,String id){
        super(name,id);
    }
    public void work(){
        System.out.println(super.getName()+"..."+super.getId()+"...check network");
    }
}
