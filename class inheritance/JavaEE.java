public class JavaEE extends Developer{
    public JavaEE(String name,String id) {
        super(name, id);
    }
    public void work(){
        System.out.println(super.getName()+"..."+super.getId()+"...develop Taobao");
    }
}
